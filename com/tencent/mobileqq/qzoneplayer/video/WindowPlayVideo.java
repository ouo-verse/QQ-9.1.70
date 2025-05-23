package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes35.dex */
public class WindowPlayVideo extends BaseVideo {

    /* renamed from: d, reason: collision with root package name */
    protected static String f279947d = "WindowPlayVideo";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PlayerUtils.log(4, WindowPlayVideo.f279947d, "mVideoClickListener onClick: state=" + WindowPlayVideo.this.getState());
            if (WindowPlayVideo.this.getVideoPlayInfo() == null) {
                PlayerUtils.log(6, WindowPlayVideo.f279947d, "mVideoClickListener onClick: getVideoPlayInfo() is null");
            } else if (!BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                WindowPlayVideo.a(WindowPlayVideo.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WindowPlayVideo.b(WindowPlayVideo.this);
            return false;
        }
    }

    /* loaded from: classes35.dex */
    class c implements SurfaceHolder.Callback {
        c() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            PlayerUtils.log(4, WindowPlayVideo.f279947d, "surfaceChanged: format=" + i3 + " width=" + i16 + " height=" + i17);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            PlayerUtils.log(4, WindowPlayVideo.f279947d, "surfaceCreated");
            WindowPlayVideo.this.surfaceCreated = true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            PlayerUtils.log(4, WindowPlayVideo.f279947d, "onSurfaceTextureDestroyed");
            WindowPlayVideo.this.surfaceCreated = false;
            WindowPlayVideo windowPlayVideo = WindowPlayVideo.this;
            windowPlayVideo.mHandler.obtainMessage(19, windowPlayVideo).sendToTarget();
        }
    }

    /* loaded from: classes35.dex */
    public interface d {
    }

    /* loaded from: classes35.dex */
    public interface e {
    }

    /* loaded from: classes35.dex */
    public interface f {
    }

    public WindowPlayVideo(Context context) {
        super(context);
        d();
        initData();
    }

    static /* synthetic */ f a(WindowPlayVideo windowPlayVideo) {
        windowPlayVideo.getClass();
        return null;
    }

    static /* synthetic */ e b(WindowPlayVideo windowPlayVideo) {
        windowPlayVideo.getClass();
        return null;
    }

    private static Pair<Integer, Integer> c(int i3, int i16) {
        int i17;
        int screenWidth = FeedVideoEnv.getScreenWidth();
        if (i3 > 0 && i16 > 0) {
            if (i3 > i16) {
                i17 = screenWidth / 2;
            } else if (i3 < i16) {
                i17 = screenWidth / 3;
            } else {
                i17 = (screenWidth * 2) / 5;
            }
            return new Pair<>(Integer.valueOf(i17), Integer.valueOf((int) (((i17 * 1.0d) / i3) * i16)));
        }
        int i18 = screenWidth / 2;
        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i18));
    }

    private void initData() {
        a aVar = new a();
        this.mVideoClickListener = aVar;
        setOnClickListener(aVar);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new WindowPlayVideoCover(context, this);
        addView(this.mVideoCover, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void createSurface() {
        VideoSurfaceView videoSurfaceView = new VideoSurfaceView(getContext());
        this.mVideoView = videoSurfaceView;
        videoSurfaceView.setCornerTriangleNumber(10);
        ((VideoSurfaceView) this.mVideoView).setCornerRadius(FeedVideoEnv.dp5);
        ((VideoSurfaceView) this.mVideoView).getHolder().addCallback(new c());
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected int getBackgroundColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected int getDelayHideCoverTime() {
        return 500;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public Surface getSurface() {
        if (BaseVideoManager.belowICE_CREAM) {
            return null;
        }
        try {
            return ((VideoSurfaceView) this.mVideoView).b();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public int getVideoCoverHeight() {
        int i3;
        int i16;
        int maxWidth = this.mVideoCover.getMaxWidth();
        BaseVideo.VideoSize videoSize = this.mVideoSize;
        if (videoSize != null) {
            i3 = videoSize.videoNatureWidth;
            i16 = videoSize.videoNatureHeight;
        } else {
            BaseVideoCover baseVideoCover = this.mVideoCover;
            i3 = baseVideoCover.picWidth;
            i16 = baseVideoCover.picHeight;
        }
        return (int) (((i16 * 1.0d) / i3) * maxWidth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public int getVideoCoverWidth() {
        return this.mVideoCover.getMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        setOnTouchListener(new b());
        setOnLongClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initVideoView() {
        super.initVideoView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public boolean isAllOnScreen() {
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public boolean isSurfaceAvailable() {
        View view;
        return (BaseVideoManager.belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || (view = this.mVideoView) == null || !((VideoSurfaceView) view).d()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 != 1) {
            if ((i3 == 17 || i3 == 20) && !getBaseVideoManager().isCurSoundOpened()) {
                getBaseVideoManager().enableAutoVideoSound();
                return;
            }
            return;
        }
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(Message.obtain(handler, 17, message.obj), getDelayHideCoverTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.onSetVideoPlayInfo(videoPlayInfo);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        setMaxWidth(((Integer) c(i3, i16).first).intValue());
        super.onVideoSizeChanged(i3, i16);
    }

    private void d() {
        this.hasTimeview = false;
        this.hasPlayCountView = false;
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    public WindowPlayVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        initData();
    }

    public WindowPlayVideo(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d();
        initData();
    }

    public void setOnVideoSizeChangeListener(d dVar) {
    }

    public void setOnVideoTouchedListener(e eVar) {
    }

    public void setVideoClickedListener(f fVar) {
    }
}
