package com.tencent.richmediabrowser.view.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.utils.VersionUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleVideoView;
import e04.g;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class VideoView extends BrowserBaseView implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static final float MAX_PROGRESS = 10000.0f;
    private static final String TAG = "VideoView";
    public RelativeLayout bufferPanel;
    public GalleryUrlImageView coverView;
    public boolean isPlayPanelDecorator;
    private boolean isSeeking;
    public ImageView mCenterPlayBtn;
    public LinearLayout mErrLayout;
    private boolean mIsHandledByPlayPanel;
    private boolean mVideoGestureScaleEnable;
    public BaseVideoView mVideoView;
    public SeekBar playBar;
    public ImageView playButton;
    public View playPanel;
    public TextView progressTime;
    public TextView rateText;
    public TextView totalTime;
    public RelativeLayout videoControlContainer;
    private VideoPlayerCallback videoPlayerCallback;
    public VideoPresenter videoPresenter;
    private g videoViewClickEvent;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class GalleryVideoViewHolder {
        public BaseVideoView videoView;

        public GalleryVideoViewHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            float f16;
            Rect rect = new Rect();
            VideoView.this.playBar.getHitRect(rect);
            if (motionEvent.getY() >= rect.top + LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT && motionEvent.getY() <= rect.bottom + 600) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                VideoView.this.mIsHandledByPlayPanel = false;
                return false;
            }
            VideoView.this.mIsHandledByPlayPanel = true;
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                VideoView.this.mIsHandledByPlayPanel = false;
            }
            float height = rect.top + (rect.height() >> 1);
            float x16 = motionEvent.getX() - rect.left;
            if (x16 < 0.0f) {
                f16 = 0.0f;
            } else if (x16 > rect.width()) {
                f16 = rect.width();
            } else {
                f16 = x16;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), f16, height, motionEvent.getMetaState());
            boolean onTouchEvent = VideoView.this.playBar.onTouchEvent(obtain);
            obtain.recycle();
            return onTouchEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b implements e04.c {
        b() {
        }

        @Override // e04.c
        public void onClickEvent() {
            if (VideoView.this.videoViewClickEvent != null) {
                VideoView.this.videoViewClickEvent.d();
            }
        }

        @Override // e04.c
        public void onLongClickEvent() {
            e04.c cVar = VideoView.this.itemClickEventListener;
            if (cVar != null) {
                cVar.onLongClickEvent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c implements VideoPlayerCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoPlayParam f365150d;

        c(VideoPlayParam videoPlayParam) {
            this.f365150d = videoPlayParam;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onCapFrame, id:" + j3 + ", isSuccess:" + z16 + ", w:" + i3 + ", h:" + i16);
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onCapFrame(j3, z16, i3, i16, bitmap);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onDownloadComplete");
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onDownloadComplete(j3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onDownloadProgress(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onFirstFrameRendered, id:" + j3);
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onFirstFrameRendered(j3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onLoopBack(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            BrowserLogHelper.getInstance().getGalleryLog().e("VideoView", 1, "onPlayError, id = " + j3 + " ,module = " + i3 + " , errorType = " + i16 + ", errCode = " + i17 + " , exInfo = " + str);
            if (VideoView.this.videoPlayerCallback == null) {
                VideoView.this.handlePlayError(i3, i17, this.f365150d);
            } else {
                VideoView.this.videoPlayerCallback.onPlayError(j3, i3, i16, i17, str);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            if (VideoView.this.mVideoView != null) {
                int videoDurationMs = (int) ((j16 / r0.getVideoDurationMs()) * 10000.0d);
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onPlayProgress, id = " + j3 + " , position = " + j16 + " , progress = " + videoDurationMs);
                VideoView.this.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(j16));
                VideoView.this.playBar.setProgress(videoDurationMs);
            }
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onPlayProgress(j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStateChange , state = " + i3 + ", id = " + j3);
            if (i3 == 4) {
                VideoView.this.updateStatus(3);
                VideoView.this.updateUI();
                if (!this.f365150d.mIsMute) {
                    VideoView.this.requestAudioFocus();
                }
                VideoData currentVideoData = VideoView.this.videoPresenter.getCurrentVideoData();
                if (currentVideoData != null) {
                    VideoView.this.videoPresenter.dealVideoMutePlay(currentVideoData.f365136id, false);
                    VideoView.this.videoPresenter.dealVideoAutoPlay(currentVideoData.f365136id, false);
                }
                VideoView.this.addScreenOnFlag();
            } else if (i3 == 5) {
                VideoView.this.updateStatus(2);
                VideoView.this.updateUI();
            } else if (i3 != 6) {
                if (i3 != 8) {
                    if (i3 == 9) {
                        VideoView.this.abandonAudioFocus();
                        VideoView.this.clearScreenOnFlag();
                    }
                } else {
                    VideoView videoView = VideoView.this;
                    BaseVideoView baseVideoView = videoView.mVideoView;
                    if (baseVideoView != null) {
                        videoView.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(baseVideoView.getVideoDurationMs()));
                    }
                    VideoView.this.playBar.setProgress(100);
                    VideoView.this.updateStatus(0);
                    VideoView.this.updateUI();
                    VideoView.this.clearScreenOnFlag();
                }
            } else if (!VideoView.this.isSeeking) {
                VideoView.this.updateStatus(4);
                VideoView.this.clearScreenOnFlag();
                VideoView.this.updateUI();
            } else {
                return;
            }
            if (VideoView.this.videoPlayerCallback != null) {
                VideoView.this.videoPlayerCallback.onStateChange(j3, i3);
            }
        }
    }

    public VideoView(Context context, VideoPresenter videoPresenter) {
        super(context, videoPresenter);
        this.isPlayPanelDecorator = false;
        this.videoPresenter = videoPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addScreenOnFlag() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().addFlags(128);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScreenOnFlag() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).getWindow().clearFlags(128);
            } catch (NullPointerException e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "clearScreenOnFlag  exception:" + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlayError(int i3, int i16, VideoPlayParam videoPlayParam) {
        String str;
        if (i16 == 14011001) {
            str = this.mContext.getString(R.string.f238137iy);
        } else {
            str = null;
        }
        VideoData currentVideoData = this.videoPresenter.getCurrentVideoData();
        if (currentVideoData != null) {
            if (str == null) {
                str = this.mContext.getString(R.string.f238267ja);
            }
            currentVideoData.errorDescription = str;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.richmediabrowser.view.video.VideoView.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoView.this.updateStatus(6);
                    VideoView.this.updateUI();
                }
            });
        }
    }

    private void realPlayVideo(VideoData videoData) {
        if (videoData != null && videoData.videoPlayParam != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "realPlayVideo id = " + videoData.f365136id);
            this.videoPresenter.updateItemStatus(videoData.f365136id, 3);
            updateUI();
            setVideoPlayCallback(videoData.videoPlayParam);
            BaseVideoView baseVideoView = this.mVideoView;
            if (baseVideoView != null) {
                baseVideoView.setVideoParam(videoData.videoPlayParam);
                this.mVideoView.play();
                return;
            }
            return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "videoPlayParam is null");
    }

    private void tryPlayVideo(int i3, boolean z16) {
        RichMediaBaseData richMediaBaseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "tryPlayVideo, position = " + i3);
        RichMediaBrowserInfo item = this.videoPresenter.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 2) {
            VideoData videoData = (VideoData) item.baseData;
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "tryPlayVideo, position = " + i3 + " , id = " + videoData.f365136id);
            videoData.isAutoPlay = z16;
            if (this.videoPresenter.videoModel != null && videoData.videoPlayParam != null) {
                realPlayVideo(videoData);
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateItemStatus downloadVideo");
            this.videoPresenter.downloadVideo(videoData);
            this.videoPresenter.updateItemStatus(videoData.f365136id, 1);
            updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatus(int i3) {
        VideoData currentVideoData;
        VideoPresenter videoPresenter = this.videoPresenter;
        if (videoPresenter != null && (currentVideoData = videoPresenter.getCurrentVideoData()) != null) {
            this.videoPresenter.updateItemStatus(currentVideoData.f365136id, i3);
        }
    }

    public void abandonAudioFocus() {
        Context context;
        if (VersionUtils.isrFroyo() && (context = this.mContext) != null) {
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void bindView(int i3) {
        RichMediaBaseData richMediaBaseData;
        BaseVideoView baseVideoView;
        this.coverView.setOnClickListener(this);
        this.coverView.setOnLongClickListener(this);
        this.mVideoView.setID(R.id.kvb);
        this.mVideoView.setId(R.id.kvb);
        this.mVideoView.setOnClickListener(this);
        this.mVideoView.setOnLongClickListener(this);
        this.mBrowserItemView.setContentDescription(this.mContext.getString(R.string.ic7));
        RichMediaBrowserInfo item = this.videoPresenter.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            if (richMediaBaseData.getType() == 2) {
                Drawable drawable = this.videoPresenter.mActiveThumbDrawable.get(Integer.valueOf(i3));
                if (drawable != null && (baseVideoView = this.mVideoView) != null) {
                    baseVideoView.showCover(drawable);
                } else {
                    this.videoPresenter.loadVideoCover(this.mScreenWidthPx, this.mScreenHeightPx, this.coverView, i3);
                }
                GalleryVideoViewHolder galleryVideoViewHolder = new GalleryVideoViewHolder();
                galleryVideoViewHolder.videoView = this.mVideoView;
                this.mBrowserItemView.setTag(galleryVideoViewHolder);
            } else if (item.baseData.getType() == 101) {
                BaseVideoView baseVideoView2 = this.mVideoView;
                if (baseVideoView2 instanceof BrowserScaleVideoView) {
                    BrowserScaleVideoView browserScaleVideoView = (BrowserScaleVideoView) baseVideoView2;
                    if (this.mVideoGestureScaleEnable) {
                        browserScaleVideoView.setVideoGestureScaleEnable(true);
                        browserScaleVideoView.setMainBrowserPresenter(this.basePresenter.mainBrowserPresenter);
                        browserScaleVideoView.setOnItemEventListener(new b());
                        this.coverView.setClickable(false);
                        this.coverView.setLongClickable(false);
                    } else {
                        browserScaleVideoView.setVideoGestureScaleEnable(false);
                        browserScaleVideoView.setMainBrowserPresenter(null);
                        browserScaleVideoView.setOnItemEventListener(null);
                        this.coverView.setClickable(true);
                        this.coverView.setLongClickable(true);
                    }
                }
            }
            super.bindView(i3);
            return;
        }
        super.bindView(i3);
    }

    public void clearTheOuchCache() {
        this.videoPresenter.mActiveThumbDrawable.clear();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public View getView(View view, ViewGroup viewGroup) {
        if ((view instanceof RelativeLayout) && (view.getTag() instanceof GalleryVideoViewHolder)) {
            this.mBrowserItemView = (RelativeLayout) view;
            this.mVideoView = ((GalleryVideoViewHolder) view.getTag()).videoView;
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.i3e, viewGroup, false);
            this.mBrowserItemView = relativeLayout;
            this.coverView = (GalleryUrlImageView) relativeLayout.findViewById(R.id.fyr);
            this.mVideoView = (BaseVideoView) this.mBrowserItemView.findViewById(R.id.kvb);
            if (!this.isPlayPanelDecorator) {
                ((ViewStub) this.mBrowserItemView.findViewById(R.id.f1178172g)).inflate();
                initContentView(this.mBrowserItemView);
            }
        }
        super.getView(view, viewGroup);
        return this.mBrowserItemView;
    }

    public void initContentView(View view) {
        RelativeLayout relativeLayout = this.mBrowserItemView;
        if (relativeLayout != null) {
            this.videoControlContainer = (RelativeLayout) relativeLayout.findViewById(R.id.f11727710);
            View findViewById = view.findViewById(R.id.fac);
            this.playPanel = findViewById;
            this.playBar = (SeekBar) findViewById.findViewById(R.id.ilh);
            this.playButton = (ImageView) this.playPanel.findViewById(R.id.fff);
            this.progressTime = (TextView) this.playPanel.findViewById(R.id.g1m);
            this.totalTime = (TextView) this.playPanel.findViewById(R.id.jut);
            this.playButton.setOnClickListener(this);
            this.playBar.setMax(10000);
            this.playBar.setOnSeekBarChangeListener(this);
            this.playPanel.setOnTouchListener(new a());
            this.bufferPanel = (RelativeLayout) this.mBrowserItemView.findViewById(R.id.alq);
            this.rateText = (TextView) this.mBrowserItemView.findViewById(R.id.hvh);
            ImageView imageView = (ImageView) this.mBrowserItemView.findViewById(R.id.fyq);
            this.mCenterPlayBtn = imageView;
            imageView.bringToFront();
            this.mCenterPlayBtn.setOnClickListener(this);
            this.mErrLayout = (LinearLayout) this.mBrowserItemView.findViewById(R.id.fys);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public boolean isNeedDisallowInterceptEvent(MotionEvent motionEvent) {
        if (this.playBar.getVisibility() == 0) {
            if (this.mIsHandledByPlayPanel) {
                return true;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar is visible");
            int[] iArr = new int[2];
            this.playBar.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i16 = iArr[1];
            if (new Rect(i3, i16, this.playBar.getWidth() + i3, this.playBar.getHeight() + i16).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar deal event");
                return true;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "recyclerView deal event");
        }
        return super.isNeedDisallowInterceptEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fff) {
            g gVar = this.videoViewClickEvent;
            if (gVar != null) {
                gVar.e();
            } else {
                BaseVideoView baseVideoView = this.mVideoView;
                if (baseVideoView != null && baseVideoView.isPlaying()) {
                    pauseVideo();
                } else {
                    tryPlayVideo(this.videoPresenter.getCurrentPosition(), false);
                }
            }
        } else if (id5 != R.id.fyr && id5 != R.id.kvb) {
            if (id5 == R.id.fyq) {
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 2, "onItemClick, play button click.");
                g gVar2 = this.videoViewClickEvent;
                if (gVar2 != null) {
                    gVar2.f();
                } else if (this.videoPresenter.getCurrentVideoData() != null) {
                    tryPlayVideo(this.videoPresenter.getCurrentPosition(), false);
                }
            }
        } else {
            g gVar3 = this.videoViewClickEvent;
            if (gVar3 != null) {
                gVar3.d();
            } else if (this.itemClickEventListener != null) {
                onClickEvent();
            } else {
                this.videoPresenter.back();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroy() {
        clearScreenOnFlag();
        super.onDestroy();
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroyView(int i3, View view) {
        this.videoPresenter.mActiveThumbDrawable.remove(Integer.valueOf(i3));
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
        super.onDestroyView(i3, view);
        clearScreenOnFlag();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onItemSelected(int i3) {
        bindView(i3);
        RichMediaBrowserInfo item = this.videoPresenter.getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof VideoData) {
                VideoData videoData = (VideoData) richMediaBaseData;
                this.videoPresenter.updateItemStatus(videoData.f365136id, 0);
                if (this.videoPresenter.isAutoPlay(i3) && videoData.videoPlayParam != null) {
                    tryPlayVideo(i3, true);
                } else {
                    updateUI();
                }
            }
        }
        super.onItemSelected(i3);
    }

    public void onPause() {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        pauseVideo();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        BaseVideoView baseVideoView;
        if (z16 && (baseVideoView = this.mVideoView) != null) {
            long videoDurationMs = baseVideoView.getVideoDurationMs();
            int i16 = (int) ((i3 / 10000.0f) * ((float) videoDurationMs));
            if (Math.abs(videoDurationMs - i16) < 100) {
                i16 = Math.max(0, (int) (videoDurationMs - 100));
            }
            this.mVideoView.seekTo(i16, 3);
            this.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(i16));
        }
        g gVar = this.videoViewClickEvent;
        if (gVar != null) {
            gVar.onProgressChanged(seekBar, i3, z16);
        }
    }

    public void onResume() {
        VideoData currentVideoData;
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onResume");
        VideoPresenter videoPresenter = this.videoPresenter;
        if (videoPresenter.isAutoPlay(videoPresenter.getCurrentPosition()) && this.mVideoView != null && (currentVideoData = this.videoPresenter.getCurrentVideoData()) != null && currentVideoData.status == 4) {
            this.mVideoView.resume();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, e04.d
    public void onScrollHalfScreenWidth() {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onScrollHalfScreenWidth");
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null && baseVideoView.mIsPlayVideo) {
            baseVideoView.pause();
        }
        super.onScrollHalfScreenWidth();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.isSeeking = true;
        this.mVideoView.pause();
    }

    public void onStop() {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, DKHippyEvent.EVENT_STOP);
        clearTheOuchCache();
        clearScreenOnFlag();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStopTrackingTouch");
        this.isSeeking = false;
        this.mVideoView.play();
        g gVar = this.videoViewClickEvent;
        if (gVar != null) {
            gVar.onStopTrackingTouch(seekBar);
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    public void pauseVideo() {
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
        abandonAudioFocus();
        clearScreenOnFlag();
    }

    public void requestAudioFocus() {
        Context context;
        if (VersionUtils.isrFroyo() && (context = this.mContext) != null) {
            ((AudioManager) context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
        }
    }

    public void setPlayPanelDecorator(boolean z16) {
        this.isPlayPanelDecorator = z16;
    }

    public void setVideoGestureScaleEnable(boolean z16) {
        this.mVideoGestureScaleEnable = z16;
    }

    public void setVideoPlayCallback(VideoPlayerCallback videoPlayerCallback) {
        this.videoPlayerCallback = videoPlayerCallback;
    }

    public void setVideoViewClickEvent(g gVar) {
        this.videoViewClickEvent = gVar;
    }

    public void showPlayPanel(boolean z16) {
        int i3;
        View view = this.playPanel;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void updateUI() {
        String string;
        super.updateUI();
        VideoData currentVideoData = this.videoPresenter.getCurrentVideoData();
        if (currentVideoData != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateUI id = " + currentVideoData.f365136id + ", status = " + currentVideoData.status);
            int i3 = currentVideoData.status;
            int i16 = 8;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 6) {
                                    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateUI status is error, status = " + currentVideoData.status);
                                    return;
                                }
                                VideoPresenter videoPresenter = this.videoPresenter;
                                videoPresenter.onLoadFinish(videoPresenter.getSelectedIndex(), true);
                                showPlayPanel(false);
                                this.bufferPanel.setVisibility(8);
                                this.mErrLayout.setVisibility(0);
                                this.mCenterPlayBtn.setVisibility(8);
                                this.playButton.setImageResource(R.drawable.f9n);
                                TextView textView = (TextView) this.mErrLayout.findViewById(R.id.byl);
                                if (textView != null) {
                                    if (!TextUtils.isEmpty(currentVideoData.errorDescription)) {
                                        string = currentVideoData.errorDescription;
                                    } else {
                                        string = this.mContext.getString(R.string.f238267ja);
                                    }
                                    textView.setText(string);
                                    return;
                                }
                                return;
                            }
                            VideoPresenter videoPresenter2 = this.videoPresenter;
                            videoPresenter2.onLoadFinish(videoPresenter2.getSelectedIndex(), true);
                            showPlayPanel(true);
                            this.bufferPanel.setVisibility(8);
                            this.mErrLayout.setVisibility(8);
                            this.mCenterPlayBtn.setVisibility(0);
                            this.playButton.setImageResource(R.drawable.f9n);
                            return;
                        }
                        VideoPresenter videoPresenter3 = this.videoPresenter;
                        videoPresenter3.onLoadFinish(videoPresenter3.getSelectedIndex(), true);
                        showPlayPanel(true);
                        this.bufferPanel.setVisibility(8);
                        this.mErrLayout.setVisibility(8);
                        this.mCenterPlayBtn.setVisibility(8);
                        this.playButton.setImageResource(R.drawable.f9o);
                        BaseVideoView baseVideoView = this.mVideoView;
                        if (baseVideoView != null) {
                            long videoDurationMs = baseVideoView.getVideoDurationMs();
                            BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "videoDuration = " + videoDurationMs);
                            this.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(videoDurationMs));
                            return;
                        }
                        return;
                    }
                    BaseVideoView baseVideoView2 = this.mVideoView;
                    if (baseVideoView2 != null) {
                        if (baseVideoView2.isPlaying()) {
                            this.bufferPanel.setVisibility(0);
                        } else {
                            this.bufferPanel.setVisibility(8);
                        }
                    }
                    VideoPresenter videoPresenter4 = this.videoPresenter;
                    videoPresenter4.onLoadFinish(videoPresenter4.getSelectedIndex(), true);
                    showPlayPanel(true);
                    this.mCenterPlayBtn.setVisibility(8);
                    this.mErrLayout.setVisibility(8);
                    return;
                }
                VideoPresenter videoPresenter5 = this.videoPresenter;
                videoPresenter5.onLoadStart(videoPresenter5.getSelectedIndex(), currentVideoData.progress);
                showPlayPanel(false);
                this.bufferPanel.setVisibility(8);
                this.mErrLayout.setVisibility(8);
                this.mCenterPlayBtn.setVisibility(8);
                return;
            }
            VideoPresenter videoPresenter6 = this.videoPresenter;
            videoPresenter6.onLoadFinish(videoPresenter6.getSelectedIndex(), true);
            showPlayPanel(false);
            this.bufferPanel.setVisibility(8);
            this.mErrLayout.setVisibility(8);
            ImageView imageView = this.mCenterPlayBtn;
            if (!currentVideoData.isAutoPlay) {
                i16 = 0;
            }
            imageView.setVisibility(i16);
            this.playButton.setImageResource(R.drawable.f9n);
            BaseVideoView baseVideoView3 = this.mVideoView;
            if (baseVideoView3 != null) {
                long videoDurationMs2 = baseVideoView3.getVideoDurationMs();
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "videoDuration = " + videoDurationMs2);
                this.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(videoDurationMs2));
                this.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(0L));
            }
            this.playBar.setProgress(0);
        }
    }

    public void updateView(int i3, View view) {
        RichMediaBrowserInfo item = this.videoPresenter.getItem(i3);
        if (item != null && item.baseData != null && view != null && (view.getTag() instanceof GalleryVideoViewHolder)) {
            BaseVideoView baseVideoView = ((GalleryVideoViewHolder) view.getTag()).videoView;
            if (item.baseData.getType() == 2) {
                VideoData videoData = (VideoData) item.baseData;
                BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateView loadShortVideoCover");
                this.videoPresenter.loadVideoCover(this.mScreenWidthPx, this.mScreenHeightPx, baseVideoView.getCoverImage(), i3);
                if (this.videoPresenter.isAutoPlay(i3)) {
                    realPlayVideo(videoData);
                }
            }
        }
    }

    public void setVideoPlayCallback(VideoPlayParam videoPlayParam) {
        videoPlayParam.mCallback = new c(videoPlayParam);
    }
}
