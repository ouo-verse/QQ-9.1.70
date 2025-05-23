package com.tencent.ad.tangram.widget.bubble;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GdtBubbleDanmakuLayout extends RelativeLayout {
    private static final int BASE_HEIGHT = 136;
    private static final float BUBBLE_ALPHA = 1.0f;
    private static final int BUBBLE_MOTION_TIME = 300;
    private static final int BUBBLE_RESUME = 3;
    private static final int BUBBLE_STOP_TIME = 800;
    private static final int BUBBLE_UPDATE = 2;
    private static final float END_ALPHA = 0.0f;
    private static final int MAX_TEXT_LEN = 10;
    private static final float START_ALPHA = 0.0f;
    private static final String TAG = "GdtBubbleDanmakuLayout";
    private GdtBubbleDanmakuParams mDanmakuParams;
    private volatile boolean mIsRunning;
    private final List<GdtBubbleDanmakuItemView> mItemViews;
    private Handler mMainHandler;
    private final Queue<String> mQueueText;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class GdtBubbleHandler extends Handler {
        private final WeakReference<GdtBubbleDanmakuLayout> mWeakLayout;

        public GdtBubbleHandler(Looper looper, WeakReference<GdtBubbleDanmakuLayout> weakReference) {
            super(looper);
            this.mWeakLayout = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout;
            super.handleMessage(message);
            WeakReference<GdtBubbleDanmakuLayout> weakReference = this.mWeakLayout;
            if (weakReference != null) {
                gdtBubbleDanmakuLayout = weakReference.get();
            } else {
                gdtBubbleDanmakuLayout = null;
            }
            if (gdtBubbleDanmakuLayout == null) {
                GdtLogger.e(GdtBubbleDanmakuLayout.TAG, "layout is null");
                return;
            }
            int i3 = message.what;
            if (i3 == 2 || (i3 == 3 && !gdtBubbleDanmakuLayout.mIsRunning)) {
                try {
                    gdtBubbleDanmakuLayout.mIsRunning = true;
                    gdtBubbleDanmakuLayout.handleShowBubble();
                    sendEmptyMessageDelayed(2, 1100L);
                    return;
                } catch (Exception unused) {
                    GdtLogger.d(GdtBubbleDanmakuLayout.TAG, "bubble container is empty");
                    return;
                }
            }
            GdtLogger.e(GdtBubbleDanmakuLayout.TAG, "illegal msg.what " + message.what);
        }
    }

    public GdtBubbleDanmakuLayout(Context context) {
        this(context, null);
        this.mMainHandler = new GdtBubbleHandler(Looper.getMainLooper(), new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShowBubble() {
        if (this.mItemViews.size() == 0) {
            GdtLogger.d(TAG, "handleShowBubble mItemViews is empty");
            return;
        }
        Iterator<GdtBubbleDanmakuItemView> it = this.mItemViews.iterator();
        while (it.hasNext()) {
            update(it.next());
        }
    }

    private void reset() {
        this.mQueueText.clear();
        this.mMainHandler.removeCallbacksAndMessages(null);
        if (this.mItemViews.size() == 0) {
            GdtLogger.d(TAG, "handleShowBubble mItemViews is empty");
            return;
        }
        int i3 = 0;
        for (GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView : this.mItemViews) {
            gdtBubbleDanmakuItemView.setVisibility(8);
            gdtBubbleDanmakuItemView.status = i3;
            i3--;
        }
    }

    private String truncateString(String str) {
        if (TextUtils.isEmpty(str)) {
            GdtLogger.d(TAG, "string is empty");
            return "";
        }
        if (str.length() > 10) {
            return str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    private void update(GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView) {
        GdtBubbleDanmakuParams gdtBubbleDanmakuParams = this.mDanmakuParams;
        if (gdtBubbleDanmakuParams != null && !gdtBubbleDanmakuParams.isValid()) {
            GdtLogger.e(TAG, "please input valid value");
            return;
        }
        if (gdtBubbleDanmakuItemView == null) {
            GdtLogger.d(TAG, "update null itemView");
            return;
        }
        int i3 = gdtBubbleDanmakuItemView.status;
        if (i3 == 0) {
            gdtBubbleDanmakuItemView.setY(GdtDisplayUtil.dpToPx(getContext(), 136));
            String poll = this.mQueueText.poll();
            this.mQueueText.offer(poll);
            gdtBubbleDanmakuItemView.setText(truncateString(poll));
            gdtBubbleDanmakuItemView.setVisibility(0);
            gdtBubbleDanmakuItemView.setAlpha(0.0f);
            ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
            ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, "translationY", gdtBubbleDanmakuItemView.getY(), gdtBubbleDanmakuItemView.getY() - GdtDisplayUtil.dpToPx(getContext(), this.mDanmakuParams.getMotionLengthDp() >> 1)).setDuration(300L).start();
            GdtLogger.d(TAG, "bubble danmaku is running");
        } else if (i3 > 0 && i3 < this.mDanmakuParams.getBubbleItemCount()) {
            ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, "translationY", gdtBubbleDanmakuItemView.getY(), gdtBubbleDanmakuItemView.getY() - GdtDisplayUtil.dpToPx(getContext(), this.mDanmakuParams.getMotionLengthDp())).setDuration(300L).start();
        } else if (gdtBubbleDanmakuItemView.status >= this.mDanmakuParams.getBubbleItemCount()) {
            ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, "translationY", gdtBubbleDanmakuItemView.getY(), gdtBubbleDanmakuItemView.getY() - GdtDisplayUtil.dpToPx(getContext(), this.mDanmakuParams.getMotionLengthDp())).setDuration(300L).start();
            ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, c.f123400v, 1.0f, 0.0f).setDuration(300L).start();
        }
        int i16 = gdtBubbleDanmakuItemView.status + 1;
        gdtBubbleDanmakuItemView.status = i16;
        if (i16 > this.mDanmakuParams.getBubbleItemCount()) {
            gdtBubbleDanmakuItemView.status = 0;
        }
    }

    public void init(GdtBubbleDanmakuParams gdtBubbleDanmakuParams) {
        if (gdtBubbleDanmakuParams != null && !gdtBubbleDanmakuParams.isValid()) {
            GdtLogger.e(TAG, "please input valid value");
            return;
        }
        this.mDanmakuParams = gdtBubbleDanmakuParams;
        if (this.mItemViews.isEmpty()) {
            for (int i3 = -gdtBubbleDanmakuParams.getBubbleItemCount(); i3 <= 0; i3++) {
                GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView = new GdtBubbleDanmakuItemView(getContext());
                gdtBubbleDanmakuItemView.status = i3;
                this.mItemViews.add(gdtBubbleDanmakuItemView);
                addView(gdtBubbleDanmakuItemView);
            }
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void pauseAnimator() {
        this.mIsRunning = false;
        this.mMainHandler.removeCallbacksAndMessages(null);
    }

    public void recycle() {
        reset();
        this.mIsRunning = false;
        removeAllViews();
        clearDisappearingChildren();
        this.mItemViews.clear();
        GdtLogger.d(TAG, "bubble danmaku is recycled");
    }

    public void resumeAnimator() {
        this.mMainHandler.sendEmptyMessage(3);
        GdtLogger.d(TAG, "bubble danmaku resumeAnimator");
    }

    public void setLogger(WeakReference<GdtLogProxy> weakReference) {
        GdtLogger.sWeakLogger = weakReference;
    }

    public void start() {
        reset();
        this.mIsRunning = false;
        GdtBubbleDanmakuParams gdtBubbleDanmakuParams = this.mDanmakuParams;
        if (gdtBubbleDanmakuParams != null && gdtBubbleDanmakuParams.isValid()) {
            for (String str : this.mDanmakuParams.getContents()) {
                if (!TextUtils.isEmpty(str)) {
                    this.mQueueText.add(str);
                }
            }
            if (this.mQueueText.isEmpty()) {
                GdtLogger.d(TAG, "bubble danmaku cannot start because of the empty text queue ");
                return;
            } else {
                this.mMainHandler.sendEmptyMessage(3);
                GdtLogger.d(TAG, "bubble danmaku start");
                return;
            }
        }
        GdtLogger.e(TAG, "please input valid value");
    }

    public void stopAnimator() {
        reset();
        this.mIsRunning = false;
        GdtLogger.d(TAG, "bubble danmaku is recycled");
    }

    public GdtBubbleDanmakuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsRunning = false;
        this.mItemViews = new ArrayList();
        this.mQueueText = new LinkedList();
        this.mMainHandler = new GdtBubbleHandler(Looper.getMainLooper(), new WeakReference(this));
    }
}
