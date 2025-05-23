package com.qzone.detail.ui.component;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.component.PokeLikeWizard;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.util.ar;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.aa;
import com.qzone.widget.util.ZipLoadBitmapGenerator;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class PokeMsgAnimDirector extends aa implements StickerBubbleAnimationView.StickerBubbleAnimationCallback, Runnable, ZipLoadBitmapGenerator.a, View.OnClickListener {
    private static final int INTERVAL_CHECK_TOUCH_IN_MILLISECONDS = 80;
    private static final String TAG = "PokeMsgAnimDirector";
    private boolean isStop;
    private Point mAnimStartPoint;
    private final StickerBubbleAnimationView mAnimView;
    private final View mMsgLayout;
    private final TextView mNickView;
    private d mOnJumpListener;
    private OnStopListener mOnStopListener;
    private int mPlayCnt;
    private int mPokeCnt;
    private ZipLoadBitmapGenerator mPokeImgGenerator;
    private String mPokeZipUrl;
    private final AvatarImageView mPortraitAiv;
    private final PokeLikeWizard mWizard;

    /* loaded from: classes39.dex */
    public interface OnStopListener {
        void onStop();
    }

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PokeMsgAnimDirector.this.stop();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PokeMsgAnimDirector.this.mOnJumpListener != null) {
                PokeMsgAnimDirector.this.mOnJumpListener.a();
                PokeMsgAnimDirector.this.stop();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PokeMsgAnimDirector.this.mOnJumpListener != null) {
                PokeMsgAnimDirector.this.mOnJumpListener.a();
                PokeMsgAnimDirector.this.stop();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public interface d {
        void a();
    }

    public PokeMsgAnimDirector(View view) {
        super(view);
        this.mWizard = PokeLikeWizard.INSTANCE;
        this.mMsgLayout = findViewById(R.id.lfi);
        AvatarImageView avatarImageView = (AvatarImageView) findViewById(R.id.lfk);
        this.mPortraitAiv = avatarImageView;
        TextView textView = (TextView) findViewById(R.id.lfj);
        this.mNickView = textView;
        this.mAnimView = (StickerBubbleAnimationView) findViewById(R.id.m3e);
        findViewById(R.id.aga).setOnClickListener(this);
        view.setOnClickListener(new a());
        avatarImageView.setOnClickListener(new b());
        textView.setOnClickListener(new c());
    }

    public void addItem() {
        Point point = this.mAnimStartPoint;
        String str = this.mPokeZipUrl;
        int i3 = this.mPlayCnt;
        this.mPlayCnt = i3 + 1;
        this.mAnimView.c(com.qzone.component.f.a(point, str, i3), true);
        if (this.mAnimView.getVisibility() == 8) {
            this.mAnimView.setVisibility(0);
        }
    }

    @Override // com.qzone.component.StickerBubbleAnimationView.StickerBubbleAnimationCallback
    public void onAnimationEnd() {
        this.mAnimView.setVisibility(8);
        this.mMsgLayout.setVisibility(8);
        this.isStop = true;
        this.mPokeImgGenerator.recycle();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.aga) {
            stop();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // java.lang.Runnable
    public void run() {
        QZLog.i(TAG, "run: " + this.isStop);
        if (this.isStop) {
            return;
        }
        if (this.mPlayCnt == 0) {
            int[] iArr = new int[2];
            this.mNickView.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                QzoneHandlerThreadFactory.getMainHandler().postDelayed(this, 80L);
                return;
            }
            this.mAnimStartPoint = new Point(iArr[0], iArr[1]);
            this.mAnimView.getLocationInWindow(iArr);
            Point point = this.mAnimStartPoint;
            int i3 = point.y - iArr[1];
            point.y = i3;
            this.mAnimView.p(i3 - ar.e(15.0f));
        }
        addItem();
        if (this.mPlayCnt <= this.mPokeCnt) {
            QzoneHandlerThreadFactory.getMainHandler().postDelayed(this, 80L);
        } else {
            this.mAnimView.m();
        }
    }

    public void setOnJumpMainPageListener(d dVar) {
        this.mOnJumpListener = dVar;
    }

    public void setOnStopListener(OnStopListener onStopListener) {
        this.mOnStopListener = onStopListener;
    }

    public void stop() {
        QZLog.i(TAG, "stop: ");
        this.isStop = true;
        this.mAnimView.o();
        this.mAnimView.q();
        this.mMsgLayout.setVisibility(8);
        OnStopListener onStopListener = this.mOnStopListener;
        if (onStopListener != null) {
            onStopListener.onStop();
        }
    }

    @Override // com.qzone.widget.util.ZipLoadBitmapGenerator.a
    public void onLoad(boolean z16) {
        if (!z16) {
            stop();
        } else {
            this.mPokeImgGenerator.preLoadImg();
            QzoneHandlerThreadFactory.getMainHandler().postDelayed(this, 80L);
        }
    }

    public void showAnim(long j3, String str, String str2, int i3) {
        if (i3 < 1 || TextUtils.isEmpty(str2)) {
            return;
        }
        this.isStop = false;
        this.mMsgLayout.setVisibility(0);
        this.mPortraitAiv.j(j3);
        this.mNickView.setText(str);
        this.mAnimStartPoint = null;
        this.mPokeZipUrl = str2;
        this.mPokeCnt = i3;
        this.mPlayCnt = 0;
        this.mAnimView.setAnimationCallback(this);
        ZipLoadBitmapGenerator pokeLikeAnimItem = this.mWizard.getPokeLikeAnimItem(this.mPokeZipUrl);
        this.mPokeImgGenerator = pokeLikeAnimItem;
        pokeLikeAnimItem.setLoadListener(this);
    }

    @Override // com.qzone.component.StickerBubbleAnimationView.StickerBubbleAnimationCallback
    public void onSurfaceDestroyed() {
    }
}
