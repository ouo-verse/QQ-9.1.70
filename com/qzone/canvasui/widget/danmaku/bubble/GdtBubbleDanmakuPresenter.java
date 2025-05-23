package com.qzone.canvasui.widget.danmaku.bubble;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes39.dex */
public class GdtBubbleDanmakuPresenter extends RelativeLayout {
    private static final int BASE_HEIGHT = 90;
    private static final int BUBBLE_MOTION_TIME = 300;
    private static final int BUBBLE_STOP_TIME = 800;
    private static final int BUBBLE_UPDATE = 2;
    private static final float END_ALPHA = 0.4f;
    private static final int MOTION_LEN = 30;
    private static final float START_ALPHA = 1.0f;
    private static final String TAG = "GdtBubbleDanmakuPresenter";
    private List<GdtBubbleDanmakuItemView> itemViews;
    private boolean mIsRunning;
    private final Handler mMainHandler;
    private String[] mStrContents;
    private Queue<String> queueText;

    public GdtBubbleDanmakuPresenter(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShowBubble() {
        Iterator<GdtBubbleDanmakuItemView> it = this.itemViews.iterator();
        while (it.hasNext()) {
            update(it.next());
        }
    }

    private void reset() {
        int i3 = 0;
        for (GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView : this.itemViews) {
            gdtBubbleDanmakuItemView.setVisibility(8);
            gdtBubbleDanmakuItemView.mStatus = i3;
            i3--;
        }
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.queueText.clear();
    }

    private String truncateString(String str) {
        if (TextUtils.isEmpty(str)) {
            b.c(TAG, "string is empty");
            return "";
        }
        if (str.length() <= 10) {
            return str;
        }
        return str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public void initDanmakuItemViews(String[] strArr) {
        this.mStrContents = strArr;
        if (this.itemViews.isEmpty()) {
            for (int i3 = -3; i3 <= 0; i3++) {
                GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView = new GdtBubbleDanmakuItemView(getContext());
                gdtBubbleDanmakuItemView.setClickable(false);
                gdtBubbleDanmakuItemView.mStatus = i3;
                this.itemViews.add(gdtBubbleDanmakuItemView);
                addView(gdtBubbleDanmakuItemView);
            }
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void recycle() {
        reset();
        this.mIsRunning = false;
        removeAllViews();
        clearDisappearingChildren();
        this.itemViews.clear();
        b.e(TAG, "bubble danmaku is recycled");
    }

    public void start() {
        reset();
        this.mIsRunning = false;
        String[] strArr = this.mStrContents;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.queueText.add(str);
                }
            }
            if (this.queueText.isEmpty()) {
                b.e(TAG, "bubble danmaku cannot start because of the empty text queue ");
                return;
            }
            this.mMainHandler.sendEmptyMessage(2);
            b.e(TAG, "bubble danmaku start");
            this.mIsRunning = true;
            return;
        }
        b.e(TAG, "string content array is empty");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 != 3) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(GdtBubbleDanmakuItemView gdtBubbleDanmakuItemView) {
        int i3;
        int i16 = gdtBubbleDanmakuItemView.mStatus;
        if (i16 == 0) {
            gdtBubbleDanmakuItemView.setY(g.a(90.0f));
            String poll = this.queueText.poll();
            this.queueText.offer(poll);
            gdtBubbleDanmakuItemView.setText(truncateString(poll));
            gdtBubbleDanmakuItemView.setVisibility(0);
            gdtBubbleDanmakuItemView.setAlpha(1.0f);
            b.e(TAG, "bubble danmaku is running");
        } else if (i16 != 1) {
            if (i16 == 2) {
                ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, "translationY", gdtBubbleDanmakuItemView.getY(), gdtBubbleDanmakuItemView.getY() - g.a(30.0f)).setDuration(300L).start();
                ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, c.f123400v, 1.0f, 0.4f).setDuration(300L).start();
            }
            i3 = gdtBubbleDanmakuItemView.mStatus + 1;
            gdtBubbleDanmakuItemView.mStatus = i3;
            if (i3 != 4) {
                gdtBubbleDanmakuItemView.mStatus = 0;
                return;
            }
            return;
        }
        ObjectAnimator.ofFloat(gdtBubbleDanmakuItemView, "translationY", gdtBubbleDanmakuItemView.getY(), gdtBubbleDanmakuItemView.getY() - g.a(30.0f)).setDuration(300L).start();
        i3 = gdtBubbleDanmakuItemView.mStatus + 1;
        gdtBubbleDanmakuItemView.mStatus = i3;
        if (i3 != 4) {
        }
    }

    public GdtBubbleDanmakuPresenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsRunning = false;
        this.itemViews = new ArrayList();
        this.queueText = new LinkedList();
        this.mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.qzone.canvasui.widget.danmaku.bubble.GdtBubbleDanmakuPresenter.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 2) {
                    try {
                        GdtBubbleDanmakuPresenter.this.handleShowBubble();
                        sendEmptyMessageDelayed(2, 1100L);
                        return;
                    } catch (Exception unused) {
                        b.a(GdtBubbleDanmakuPresenter.TAG, "bubble container is empty");
                        return;
                    }
                }
                b.c(GdtBubbleDanmakuPresenter.TAG, "illegal msg.what " + message.what);
            }
        };
    }
}
