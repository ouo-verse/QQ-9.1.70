package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedAutoVideoCanvasControllerView extends VideoControllerView {

    /* renamed from: m, reason: collision with root package name */
    public static int f279621m = 3000;

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f279622d;

    /* renamed from: e, reason: collision with root package name */
    private int f279623e;

    /* renamed from: f, reason: collision with root package name */
    private int f279624f;

    /* renamed from: h, reason: collision with root package name */
    private BaseVideo f279625h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f279626i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoCanvasControllerView.this.doToggleFullscreen();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoCanvasControllerView.this.doToggleLandscape();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FeedAutoVideoCanvasControllerView.this.f279625h instanceof FeedAutoVideoFullCanvas) {
                ((FeedAutoVideoFullCanvas) FeedAutoVideoCanvasControllerView.this.f279625h).w();
            }
            if (((VideoControllerView) FeedAutoVideoCanvasControllerView.this).mPlayer != null && ((VideoControllerView) FeedAutoVideoCanvasControllerView.this).mPlayer.isPlaying()) {
                FeedAutoVideoCanvasControllerView.this.f279622d.setImageResource(((VideoControllerView) FeedAutoVideoCanvasControllerView.this).playerResources.getDrawableId(1104));
            } else {
                FeedAutoVideoCanvasControllerView.this.f279622d.setImageResource(((VideoControllerView) FeedAutoVideoCanvasControllerView.this).playerResources.getDrawableId(1105));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface d {
    }

    public FeedAutoVideoCanvasControllerView(Context context, PlayerResources playerResources) {
        super(context, playerResources);
        this.f279622d = null;
        initData();
    }

    public void cancelFadeout() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void hide() {
        if (this.mAnchor == null) {
            return;
        }
        this.mShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void initControllerView(View view) {
        ProgressBar progressBar = (ProgressBar) view.findViewById(this.playerResources.getViewId(PlayerResources.ViewId.CONTROLLER_PROGRESS));
        this.mProgress = progressBar;
        if (progressBar != null && (progressBar instanceof SeekBar)) {
            ((SeekBar) progressBar).setOnSeekBarChangeListener(this.mSeekListener);
            this.mProgress.setMax(1000);
        }
        ImageButton imageButton = (ImageButton) view.findViewById(this.playerResources.getViewId(28));
        this.f279622d = imageButton;
        imageButton.setImageResource(this.playerResources.getDrawableId(1104));
        this.f279622d.setOnClickListener(new c());
    }

    public void initData() {
        this.mFullscreenListener = new a();
        this.mSwitchLandscapeListener = new b();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    protected View makeControllerView() {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.playerResources.getLayoutId(7), (ViewGroup) null);
        this.mRoot = inflate;
        initControllerView(inflate);
        return this.mRoot;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setSeekbarRotationChangeListener(RotationSeekBar.OnRotationChangeListener onRotationChangeListener) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null || !(progressBar instanceof RotationSeekBar)) {
            return;
        }
        ((RotationSeekBar) progressBar).setOnRotationChangeListener(onRotationChangeListener);
    }

    public void setVideoDimension(int i3, int i16) {
        this.f279623e = i3;
        this.f279624f = i16;
    }

    public void setVideoView(BaseVideo baseVideo) {
        this.f279625h = baseVideo;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void show() {
        show(f279621m);
    }

    public void startFadeout() {
        startFadeout(f279621m);
    }

    public void updateLayout() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        BaseVideo baseVideo = this.f279625h;
        if (baseVideo != null) {
            int i3 = baseVideo.getLayoutParams().height;
            if (i3 == -2) {
                layoutParams.topMargin = this.f279624f - FeedVideoEnv.dp40;
            } else if (i3 == -1) {
                layoutParams.addRule(12);
            }
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void updatePausePlay() {
        VideoControllerView.MediaPlayerControl mediaPlayerControl;
        super.updatePausePlay();
        if (this.mRoot == null || (mediaPlayerControl = this.mPlayer) == null || this.f279622d == null) {
            return;
        }
        if (mediaPlayerControl != null && mediaPlayerControl.isPlaying()) {
            this.f279622d.setImageResource(this.playerResources.getDrawableId(1105));
        } else {
            this.f279622d.setImageResource(this.playerResources.getDrawableId(1104));
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
    public void show(int i3) {
        if (!this.mShowing && this.mAnchor != null) {
            postSetProgress();
            disableUnsupportedButtons();
            updateLayout();
            if (!this.f279626i) {
                this.mAnchor.addView(this);
                this.f279626i = true;
            }
            this.mShowing = true;
        }
        updatePausePlay();
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        this.mHandler.removeMessages(1);
        if (i3 != 0) {
            this.mHandler.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public void startFadeout(int i3) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i3 == 0) {
            this.mHandler.sendEmptyMessage(1);
        } else {
            this.mHandler.sendMessageDelayed(obtainMessage, i3);
        }
    }

    public void setControllerVisibilityListener(d dVar) {
    }
}
