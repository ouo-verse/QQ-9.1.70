package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes35.dex */
public class IndividualAutoVideo extends BaseVideo {
    protected boolean C;
    protected VideoControllerView.OnControllerEventListener D;
    protected boolean E;
    private TextView F;
    private ImageView G;
    private boolean H;
    protected boolean I;
    private MediaControllerListener J;
    protected ImageView K;
    private boolean L;
    protected int M;
    protected int N;
    protected boolean P;
    private Runnable Q;
    private Runnable R;
    private int S;
    protected b T;
    private int U;

    /* renamed from: d, reason: collision with root package name */
    private final int f279803d;

    /* renamed from: e, reason: collision with root package name */
    private final int f279804e;

    /* renamed from: f, reason: collision with root package name */
    protected IndividualAutoVideoControlView f279805f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f279806h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f279807i;

    /* renamed from: m, reason: collision with root package name */
    int f279808m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PlayerUtils.isNetworkAvailable()) {
                IndividualAutoVideo.this.j();
                IndividualAutoVideo.this.k();
                VideoPlayInfo videoPlayInfo = IndividualAutoVideo.this.mVideoPlayInfo;
                if (videoPlayInfo != null && videoPlayInfo.videoId != null) {
                    BaseVideoManagerUtils.getOriginalVideoMap().put(IndividualAutoVideo.this.mVideoPlayInfo.videoId, Boolean.TRUE);
                }
                IndividualAutoVideo.this.i();
            } else {
                new n().a("\u67e5\u770b\u539f\u753b\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements IndividualAutoVideoControlView.e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f279810a;

        /* renamed from: b, reason: collision with root package name */
        private StringBuilder f279811b = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private Formatter f279812c = new Formatter(this.f279811b, Locale.getDefault());

        /* renamed from: d, reason: collision with root package name */
        private int f279813d;

        public b() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean canPausePlay() {
            return IndividualAutoVideo.this.getState() == 3 || IndividualAutoVideo.this.getState() == 5 || IndividualAutoVideo.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean canSeekBackward() {
            return IndividualAutoVideo.this.L;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean canSeekForward() {
            return IndividualAutoVideo.this.L;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean enableToggleFullScreen() {
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean enableToggleLandscape() {
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public int getBufferPercentage() {
            return IndividualAutoVideo.this.S;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public int getCurrentPosition() {
            Object h16 = IndividualAutoVideo.this.getBaseVideoManager().h();
            if (h16 == null) {
                return this.f279813d;
            }
            this.f279813d = ((Integer) h16).intValue();
            PlayerUtils.log(3, "AlbumAutoVideo", "MangerHandler getCurrentPosition: positon=" + this.f279813d);
            return this.f279813d;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public int getDuration() {
            Object duration = IndividualAutoVideo.this.getBaseVideoManager().getDuration();
            if (duration == null) {
                return 0;
            }
            return ((Integer) duration).intValue();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public String getVideoUriWithUuid() {
            return IndividualAutoVideo.this.getBaseVideoManager().i();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean isFullScreen() {
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean isLandscape() {
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean isLoading() {
            return IndividualAutoVideo.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean isPlayComplete() {
            return IndividualAutoVideo.this.getState() == 4 || IndividualAutoVideo.this.getState() == 1;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public boolean isPlaying() {
            return IndividualAutoVideo.this.getState() == 3 && !this.f279810a;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void pause() {
            IndividualAutoVideo.this.setState(5);
            this.f279810a = true;
            IndividualAutoVideo.this.getBaseVideoManager().pauseVideo();
            VideoControllerView.OnControllerEventListener onControllerEventListener = IndividualAutoVideo.this.D;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void seekTo(int i3) {
            boolean z16;
            if (IndividualAutoVideo.this.getState() != 5) {
                IndividualAutoVideo.this.setState(2);
                z16 = false;
            } else {
                z16 = true;
            }
            IndividualAutoVideo.this.getBaseVideoManager().seekVideoRealManual(i3);
            IndividualAutoVideo.this.f279805f.r();
            if (IndividualAutoVideo.this.getState() == 3 && this.f279810a) {
                this.f279810a = false;
            }
            if (z16) {
                pause();
            }
            IndividualAutoVideo.this.f279805f.x();
            IndividualAutoVideo.this.f279805f.t();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void updatePlayPauseButton() {
            if (IndividualAutoVideo.this.J != null) {
                IndividualAutoVideo.this.J.onUpdatePlayPauseButton();
            }
            IndividualAutoVideo individualAutoVideo = IndividualAutoVideo.this;
            if (individualAutoVideo.K == null) {
                return;
            }
            if (individualAutoVideo.getState() != 2 && IndividualAutoVideo.this.getState() != 0 && IndividualAutoVideo.this.getState() != 1) {
                IndividualAutoVideo individualAutoVideo2 = IndividualAutoVideo.this;
                individualAutoVideo2.K.setVisibility(individualAutoVideo2.I ? 0 : 8);
            } else {
                IndividualAutoVideo.this.K.setVisibility(8);
            }
            if (isPlaying()) {
                IndividualAutoVideo.this.K.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1093));
            } else {
                IndividualAutoVideo.this.K.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1094));
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void start() {
            this.f279810a = false;
            IndividualAutoVideo.this.setState(3);
            IndividualAutoVideo.this.getBaseVideoManager().startVideoReal();
            IndividualAutoVideo.this.mVideoCover.requestLayout();
            if (!IndividualAutoVideo.this.getBaseVideoManager().isCurSoundOpened()) {
                IndividualAutoVideo.this.getBaseVideoManager().enableAutoVideoSound();
            }
            VideoControllerView.OnControllerEventListener onControllerEventListener = IndividualAutoVideo.this.D;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPlayVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public String time2str(int i3) {
            int round = (int) Math.round((i3 * 1.0d) / 1000.0d);
            int i16 = round % 60;
            int i17 = (round / 60) % 60;
            int i18 = round / 3600;
            this.f279811b.setLength(0);
            if (i18 > 0) {
                return this.f279812c.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
            }
            return this.f279812c.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void hideTopBar() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void toggleFullScreen() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView.e
        public void toggleLandscape() {
        }
    }

    public IndividualAutoVideo(Context context) {
        super(context);
        this.f279803d = 3000;
        this.f279804e = 950;
        this.f279806h = true;
        this.f279807i = false;
        this.f279808m = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.E = false;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.2
            @Override // java.lang.Runnable
            public void run() {
                if (IndividualAutoVideo.this.F == null || !IndividualAutoVideo.this.F.getText().equals("\u6b63\u5728\u52a0\u8f7d...")) {
                    return;
                }
                IndividualAutoVideo.this.F.setText("\u5df2\u5b8c\u6210");
            }
        };
        this.R = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.3
            @Override // java.lang.Runnable
            public void run() {
                if (IndividualAutoVideo.this.F != null) {
                    if (IndividualAutoVideo.this.F.getText().equals("\u6b63\u5728\u52a0\u8f7d...") || IndividualAutoVideo.this.F.getText().equals("\u5df2\u5b8c\u6210")) {
                        IndividualAutoVideo.this.F.setVisibility(8);
                    }
                }
            }
        };
        this.T = new b();
        this.U = 4000;
        h();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.F == null || getHandler() == null) {
            return;
        }
        getHandler().postDelayed(this.Q, 2000L);
        getHandler().postDelayed(this.R, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        TextView textView = this.F;
        if (textView != null) {
            textView.setText("\u6b63\u5728\u52a0\u8f7d...");
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new AutoVideoCoverFull(context, this);
        addView(this.mVideoCover, new ViewGroup.LayoutParams(-2, -2));
    }

    protected void g() {
        PlayerUtils.runOnUiThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.6
            @Override // java.lang.Runnable
            public void run() {
                IndividualAutoVideo.this.f279805f.t();
                IndividualAutoVideo.this.I = false;
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        IndividualAutoVideoControlView individualAutoVideoControlView = new IndividualAutoVideoControlView(getContext(), FeedVideoEnv.playerResources);
        this.f279805f = individualAutoVideoControlView;
        individualAutoVideoControlView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int defaultSize;
        int defaultSize2;
        BaseVideoCover baseVideoCover = this.mVideoCover;
        int i17 = baseVideoCover.picWidth;
        int i18 = baseVideoCover.picHeight;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
            return;
        }
        if (this.P) {
            defaultSize = this.M;
            defaultSize2 = this.N;
        } else {
            defaultSize = View.getDefaultSize(0, i3);
            defaultSize2 = View.getDefaultSize(0, i16);
        }
        if (i17 > 0 && i18 > 0) {
            int i19 = i17 * defaultSize2;
            int i26 = defaultSize * i18;
            if (i19 > i26) {
                defaultSize2 = i26 / i17;
            } else if (i19 < i26) {
                defaultSize = i19 / i18;
            }
        }
        View view = this.mVideoView;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams();
            this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2 - (marginLayoutParams.topMargin * 2), 1073741824));
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824);
        ViewGroup.LayoutParams layoutParams2 = this.mVideoCover.getLayoutParams();
        layoutParams2.height = -1;
        layoutParams2.width = -1;
        this.mVideoCover.setLayoutParams(layoutParams2);
        this.mVideoCover.measure(makeMeasureSpec, makeMeasureSpec2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            IndividualAutoVideoControlView individualAutoVideoControlView = this.f279805f;
            if (individualAutoVideoControlView != null && individualAutoVideoControlView.p()) {
                this.f279805f.x();
            }
            this.T.f279810a = false;
            getBaseVideoManager().enableAutoVideoSound();
            return;
        }
        if (i3 == 17) {
            getBaseVideoManager().enableAutoVideoSound();
            this.L = true;
        } else {
            if (i3 != 20) {
                return;
            }
            getBaseVideoManager().enableAutoVideoSound();
            this.L = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        getBaseVideoManager().schedulePreload(this.mVideoPlayInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoBufferingUpdate(int i3) {
        this.S = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        super.onVideoSizeChanged(i3, i16);
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.M = i3;
        this.N = i16;
        this.P = z16;
    }

    public void setMediaControllerListener(MediaControllerListener mediaControllerListener) {
        this.J = mediaControllerListener;
    }

    public void setOnControllerEventListener(VideoControllerView.OnControllerEventListener onControllerEventListener) {
        this.D = onControllerEventListener;
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IndividualAutoVideoControlView individualAutoVideoControlView = this.f279805f;
        if (individualAutoVideoControlView != null) {
            individualAutoVideoControlView.setSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.setVideoPlayInfo(videoPlayInfo);
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.Q);
            getHandler().removeCallbacks(this.R);
        }
        IndividualAutoVideoControlView individualAutoVideoControlView = this.f279805f;
        if (individualAutoVideoControlView != null) {
            individualAutoVideoControlView.m();
            this.f279805f.setContentDescription("individualVideoController");
            this.f279805f.setMediaPlayer(this.T);
            this.f279805f.setEnabled(true);
        }
        if (videoPlayInfo.segmentVideoInfo.getDefaultUrl().startsWith("/")) {
            this.S = 100;
        }
        this.F = null;
        b bVar = this.T;
        if (bVar != null) {
            bVar.f279810a = false;
            this.T.f279813d = 0;
        }
        this.L = false;
        this.H = false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        super.stop();
        setShowCoverImage(true);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void update() {
        b bVar;
        super.update();
        if (this.isAutoPlay && this.C && (bVar = this.T) != null && bVar.f279810a) {
            this.T.pause();
        }
        this.C = false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void updateWithoutDelay(boolean z16) {
        super.updateWithoutDelay(z16);
        g();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void videoUIStop() {
        super.videoUIStop();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.5
            @Override // java.lang.Runnable
            public void run() {
                IndividualAutoVideo.this.f279805f.k();
            }
        });
    }

    private void h() {
        this.hasTimeview = false;
        this.hasPlayCountView = false;
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    public void k() {
        this.H = true;
        getBaseVideoManager().switchVideoStream(this, 3);
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        VideoControllerView.OnControllerEventListener onControllerEventListener = this.D;
        if (onControllerEventListener != null) {
            onControllerEventListener.onRequestOriginalVideo();
        }
    }

    public void setOriginalVideoBtn(TextView textView) {
        if (textView == null) {
            return;
        }
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null && videoPlayInfo.segmentVideoInfo.getStreamInfo(3) != null) {
            this.F = textView;
            textView.setOnClickListener(new a());
            if (VideoManager.getInstance().isCached(this.mVideoPlayInfo.segmentVideoInfo.getStreamInfo(3))) {
                PlayerUtils.log(4, "AlbumAutoVideo", "Original video is Cached!");
                this.F.setVisibility(4);
                this.H = true;
                return;
            } else {
                PlayerUtils.log(4, "AlbumAutoVideo", "Original video is not Cached!");
                this.F.setTextColor(Color.parseColor("#CCCCCC"));
                this.F.setVisibility(0);
                return;
            }
        }
        textView.setVisibility(4);
    }

    public void setVideoPlayBtn(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        this.G = imageView;
    }

    public IndividualAutoVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279803d = 3000;
        this.f279804e = 950;
        this.f279806h = true;
        this.f279807i = false;
        this.f279808m = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.E = false;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.2
            @Override // java.lang.Runnable
            public void run() {
                if (IndividualAutoVideo.this.F == null || !IndividualAutoVideo.this.F.getText().equals("\u6b63\u5728\u52a0\u8f7d...")) {
                    return;
                }
                IndividualAutoVideo.this.F.setText("\u5df2\u5b8c\u6210");
            }
        };
        this.R = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo.3
            @Override // java.lang.Runnable
            public void run() {
                if (IndividualAutoVideo.this.F != null) {
                    if (IndividualAutoVideo.this.F.getText().equals("\u6b63\u5728\u52a0\u8f7d...") || IndividualAutoVideo.this.F.getText().equals("\u5df2\u5b8c\u6210")) {
                        IndividualAutoVideo.this.F.setVisibility(8);
                    }
                }
            }
        };
        this.T = new b();
        this.U = 4000;
        h();
        initData();
    }

    private void initData() {
    }
}
