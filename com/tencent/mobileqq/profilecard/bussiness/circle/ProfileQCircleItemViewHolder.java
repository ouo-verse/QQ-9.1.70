package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.dataline.util.j;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StSingleVideoUrlAttachOption;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class ProfileQCircleItemViewHolder implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileQCircleItemViewHolder";
    private static final int VIDEO_MAX_PLAY_TIME = 5000;
    private static final int VIDEO_TYPE = 3;
    public FeedCloudMeta$StFeed data;

    @NonNull
    public final View itemView;
    private final int mCardRadius;
    private final int mContainerHeight;
    private final int mContainerWidth;
    private final Context mContext;
    private Bitmap mCoverBitMap;
    private ImageView mCoverImgView;
    private RoundRelativeLayout mItemContainer;
    private IProfileQCircleItemPlayListener mItemPlayListener;
    private View mPlayIconView;
    private final ColorDrawable mQQCircleDefaultPic;
    private final int mRightMargin;
    private RFWVideoView mVideoView;
    public int pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder$3, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass3 implements IRFWPlayerPrepareListener {
        static IPatchRedirector $redirector_;

        AnonymousClass3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFirstFrameRendered$0() {
            ProfileQCircleItemViewHolder.this.setCoverAndPlayIconVisibility(8);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) rFWPlayer);
                return;
            }
            QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onFirstFrameRendered] player=" + rFWPlayer);
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.b
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileQCircleItemViewHolder.AnonymousClass3.this.lambda$onFirstFrameRendered$0();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFWPlayer);
                return;
            }
            if (ProfileQCircleItemViewHolder.this.mVideoView != null && ProfileQCircleItemViewHolder.this.mVideoView.getQCirclePlayer() != null && (ProfileQCircleItemViewHolder.this.mVideoView.getQCirclePlayer().getVideoView() instanceof ISPlayerVideoView)) {
                ISPlayerVideoView iSPlayerVideoView = (ISPlayerVideoView) ProfileQCircleItemViewHolder.this.mVideoView.getQCirclePlayer().getVideoView();
                iSPlayerVideoView.setXYaxis(2);
                QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onVideoPrepared] player=" + rFWPlayer + ", playerVideoView:" + iSPlayerVideoView);
            } else {
                QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onVideoPrepared] player=" + rFWPlayer);
            }
            rFWPlayer.setOutputMute(true);
            if (ProfileQCircleItemViewHolder.this.mVideoView != null) {
                ProfileQCircleItemViewHolder.this.mVideoView.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder$6, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass6 implements IRFWPlayerCompletionListener {
        static IPatchRedirector $redirector_;

        AnonymousClass6() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCompletion$0() {
            ProfileQCircleItemViewHolder.this.notifyNextVideoPlay();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iSuperPlayer);
            } else {
                QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onCompletion]");
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileQCircleItemViewHolder.AnonymousClass6.this.lambda$onCompletion$0();
                    }
                });
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface IProfileQCircleItemPlayListener {
        void onItemClick(View view, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BitmapDrawable bitmapDrawable);

        void onPlayEnd(int i3);
    }

    public ProfileQCircleItemViewHolder(Context context, View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.mContext = context;
        this.itemView = view;
        this.mRightMargin = i3;
        this.mContainerWidth = i16;
        this.mContainerHeight = i17;
        this.mCardRadius = i18;
        initView();
        this.mQQCircleDefaultPic = new ColorDrawable(view.getResources().getColor(R.color.f157194kw));
    }

    private void addCallback(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            QLog.e(TAG, 1, "[addCallback] options is null");
            return;
        }
        rFWPlayerOptions.setPlayIOC(new RFWPlayerIOC() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
                }
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
            /* renamed from: getPlayerUpperData */
            public RFWPlayerUpperData getUpperData() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (RFWPlayerUpperData) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                RFWPlayerUpperData rFWPlayerUpperData = new RFWPlayerUpperData();
                rFWPlayerUpperData.addValue("QFS_PLAYER_MUTE_KEY", Boolean.FALSE);
                return rFWPlayerUpperData;
            }
        });
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new AnonymousClass3());
        rFWPlayerOptions.getListenerSet().addSeekListeners(new IRFWPlayerSeekListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
                }
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public void onProgress(String str, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (ProfileQCircleItemViewHolder.this.mVideoView != null && i16 >= 5000) {
                    QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onProgress] play end, pause and release, notify next play, curPos:" + ProfileQCircleItemViewHolder.this.pos);
                    ProfileQCircleItemViewHolder.this.notifyNextVideoPlay();
                }
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public /* bridge */ /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                re0.b.b(this, seekBar, i3, z16);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public /* bridge */ /* synthetic */ void onStartTrackingTouch(SeekBar seekBar) {
                re0.b.c(this, seekBar);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public /* bridge */ /* synthetic */ void onStopTrackingTouch(SeekBar seekBar) {
                re0.b.d(this, seekBar);
            }
        });
        rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new IRFWPlayerLifeCycle() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
                }
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* bridge */ /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
                re0.a.a(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* bridge */ /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
                re0.a.b(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public void onRelease(RFWPlayer rFWPlayer) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFWPlayer);
                    return;
                }
                QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[onRelease] player=" + rFWPlayer);
                ProfileQCircleItemViewHolder.this.setCoverAndPlayIconVisibility(0);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* bridge */ /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
                re0.a.d(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* bridge */ /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
                re0.a.e(this, rFWPlayer);
            }
        });
        rFWPlayerOptions.getListenerSet().addCompletionListener(new AnonymousClass6());
    }

    private void adjustContainerViewSize(View view) {
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = this.mRightMargin;
            layoutParams.width = this.mContainerWidth;
            layoutParams.height = this.mContainerHeight;
            view.setLayoutParams(layoutParams);
        }
    }

    private void bindPicData() {
        String str;
        int i3;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        if (this.mCoverImgView != null && this.mPlayIconView != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
            String str2 = "";
            if (feedCloudMeta$StFeed == null || (feedCloudMeta$StImage = feedCloudMeta$StFeed.cover) == null) {
                str = "";
            } else {
                str = feedCloudMeta$StImage.picUrl.get();
            }
            boolean isVideo = isVideo();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[bindPicData] pos:");
            sb5.append(this.pos);
            sb5.append(", feedId:");
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.data;
            if (feedCloudMeta$StFeed2 != null) {
                str2 = feedCloudMeta$StFeed2.f398449id.get();
            }
            sb5.append(str2);
            sb5.append(", picUrl:");
            sb5.append(str);
            QLog.d(TAG, 1, sb5.toString());
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(this.mContainerWidth).setRequestHeight(this.mContainerHeight).setLoadingDrawable(this.mQQCircleDefaultPic).setFailDrawable(this.mQQCircleDefaultPic).setTargetView(this.mCoverImgView), new QCirclePicStateListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
                    }
                }

                @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                public void onStateChange(LoadState loadState, Option option) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadState, (Object) option);
                        return;
                    }
                    super.onStateChange(loadState, option);
                    if (loadState == LoadState.STATE_SUCCESS && option != null) {
                        ProfileQCircleItemViewHolder.this.mCoverBitMap = option.getResultBitMap();
                    }
                }
            });
            View view = this.mPlayIconView;
            if (isVideo) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            return;
        }
        QLog.e(TAG, 1, "[bindPicData] view is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap createVideoFrameBitmap(TextureView textureView) {
        if (textureView == null) {
            QLog.e(TAG, 1, "[createVideoFrameBitmap] texture view should not be null");
            return null;
        }
        if (!textureView.isAvailable()) {
            QLog.e(TAG, 1, "[createVideoFrameBitmap] current surface not is available, end flow");
            return null;
        }
        DisplayMetrics displayMetrics = textureView.getResources().getDisplayMetrics();
        int width = textureView.getWidth();
        int height = textureView.getHeight();
        if (width > 0 && height > 0) {
            try {
                return textureView.getBitmap(Bitmap.createBitmap(displayMetrics, width, height, Bitmap.Config.RGB_565));
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[createVideoFrameBitmap] error: ", th5);
                return null;
            }
        }
        QLog.e(TAG, 1, "[createVideoFrameBitmap] previewWidth <= 0 || previewHeight <= 0");
        return null;
    }

    private void doDtReport(String str) {
        RoundRelativeLayout roundRelativeLayout = this.mItemContainer;
        if (roundRelativeLayout == null) {
            return;
        }
        VideoReport.setElementId(roundRelativeLayout, ProfileCardDtReportUtil.DT_EM_PROFILE_SMALLWORLD_CARD);
        VideoReport.setElementClickPolicy(this.mItemContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.mItemContainer, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        String feedId = getFeedId();
        if (!TextUtils.isEmpty(feedId)) {
            hashMap.put("xsj_feed_id", feedId);
        }
        VideoReport.reportEvent(str, this.mItemContainer, hashMap);
    }

    private void initView() {
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.itemView.findViewById(R.id.ifh);
        this.mItemContainer = roundRelativeLayout;
        roundRelativeLayout.f316195e = this.mCardRadius;
        this.mCoverImgView = (ImageView) this.itemView.findViewById(R.id.xmw);
        this.mPlayIconView = this.itemView.findViewById(R.id.xmx);
        this.mItemContainer.setOnClickListener(this);
        this.mItemContainer.setContentDescription(j.d(Constants.Business.QQCIRCLE));
        adjustContainerViewSize(this.mItemContainer);
        this.mItemContainer.setVisibility(0);
    }

    private void makeSureAddVideoView() {
        if (this.mItemContainer == null) {
            QLog.e(TAG, 1, "[makeSureAddVideoView] mItemContainer is null");
            return;
        }
        if (this.mVideoView != null) {
            return;
        }
        QLog.e(TAG, 1, "[makeSureAddVideoView] add video view");
        RFWVideoView rFWVideoView = new RFWVideoView(this.mContext);
        this.mVideoView = rFWVideoView;
        rFWVideoView.setAlpha(0.99f);
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mItemContainer.addView(this.mVideoView, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNextVideoPlay() {
        if (this.mVideoView != null) {
            pause(false);
            this.mVideoView.release();
            bindPicData();
        }
        IProfileQCircleItemPlayListener iProfileQCircleItemPlayListener = this.mItemPlayListener;
        if (iProfileQCircleItemPlayListener != null) {
            iProfileQCircleItemPlayListener.onPlayEnd(this.pos);
        }
    }

    private void saveVideoFrameToBitmap() {
        if (this.mVideoView != null && this.mCoverImgView != null) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQCircleItemViewHolder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ISPlayerVideoView videoView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        RFWVideoView rFWVideoView = ProfileQCircleItemViewHolder.this.mVideoView;
                        if (rFWVideoView == null) {
                            QLog.e(ProfileQCircleItemViewHolder.TAG, 1, 1, "[saveVideoFrameToBitmap] videoView is null");
                            return;
                        }
                        RFWPlayer qCirclePlayer = rFWVideoView.getQCirclePlayer();
                        if (qCirclePlayer == null) {
                            QLog.e(ProfileQCircleItemViewHolder.TAG, 1, 1, "[saveVideoFrameToBitmap] rfwPlayer is null");
                            return;
                        }
                        if (!qCirclePlayer.isFirstRenderCallback()) {
                            QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[saveVideoFrameToBitmap] first render not callback");
                            return;
                        }
                        ISuperPlayer superPlayer = rFWVideoView.getSuperPlayer();
                        View view = null;
                        if (superPlayer == null) {
                            videoView = null;
                        } else {
                            videoView = superPlayer.getVideoView();
                        }
                        if (videoView != null) {
                            view = videoView.getRenderView();
                        }
                        if (view instanceof TextureView) {
                            Bitmap createVideoFrameBitmap = ProfileQCircleItemViewHolder.createVideoFrameBitmap((TextureView) view);
                            QLog.d(ProfileQCircleItemViewHolder.TAG, 1, "[saveVideoFrameToBitmap] set cur frame success, bitmap:" + createVideoFrameBitmap);
                            if (createVideoFrameBitmap == null) {
                                return;
                            }
                            RFWThreadManager.getUIHandler().post(new Runnable(createVideoFrameBitmap) { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolder.7.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Bitmap val$bitmap;

                                {
                                    this.val$bitmap = createVideoFrameBitmap;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) createVideoFrameBitmap);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else if (ProfileQCircleItemViewHolder.this.mCoverImgView != null) {
                                        ProfileQCircleItemViewHolder.this.mCoverImgView.setImageBitmap(this.val$bitmap);
                                    }
                                }
                            });
                            return;
                        }
                        QLog.e(ProfileQCircleItemViewHolder.TAG, 1, "[saveVideoFrameToBitmap] view not is texture view, view: " + view);
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            });
        } else {
            QLog.e(TAG, 1, "[saveVideoFrameToBitmap] playView or mCoverImgView is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCoverAndPlayIconVisibility(int i3) {
        View view;
        if (this.mCoverImgView != null && (view = this.mPlayIconView) != null) {
            view.setVisibility(i3);
        } else {
            QLog.e(TAG, 1, "[setCoverAndPlayIconVisibility] view is null");
        }
    }

    private void startANewPlayer() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2;
        if (this.mVideoView == null) {
            QLog.e(TAG, 1, "[startANewPlayer] playView is null");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo2 = feedCloudMeta$StFeed.video) != null) {
            feedCloudMeta$StVideo = feedCloudMeta$StVideo2.get();
        } else {
            feedCloudMeta$StVideo = null;
        }
        if (feedCloudMeta$StVideo == null) {
            QLog.e(TAG, 1, "[startANewPlayer] stVideo is null");
            return;
        }
        this.mVideoView.setData(this.data, this.pos);
        RFWPlayerOptions fromType = RFWPlayerOptions.obtain(126).setPlayUrl(feedCloudMeta$StVideo.playUrl.get()).setFileId(feedCloudMeta$StVideo.fileId.get()).setStVideo(gb0.b.k(feedCloudMeta$StVideo)).setIsMutualExclusion(false).setFromType(17);
        QLog.d("ProfileQCircleItemViewHolder_" + fromType.tag(), 1, "[startANewPlayer], feedId:" + this.data.f398449id.get() + ", playUrl:" + feedCloudMeta$StVideo.playUrl.get() + ", fileId:" + feedCloudMeta$StVideo.fileId.get());
        addCallback(fromType);
        this.mVideoView.loadPlayOptions(fromType);
    }

    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) feedCloudMeta$StFeed, i3);
            return;
        }
        this.pos = i3;
        this.data = feedCloudMeta$StFeed;
        bindPicData();
        doDtReport("dt_imp");
    }

    public boolean disableAutoPlay() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) == null) {
            return true;
        }
        FeedCloudMeta$StSingleVideoUrlAttachOption feedCloudMeta$StSingleVideoUrlAttachOption = feedCloudMeta$StVideo.attachOption;
        if (feedCloudMeta$StSingleVideoUrlAttachOption != null && feedCloudMeta$StSingleVideoUrlAttachOption.isHdrVideo.get()) {
            return true;
        }
        return false;
    }

    public String getFeedId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
        if (feedCloudMeta$StFeed != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return null;
    }

    public int getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.pos;
    }

    public boolean isPlaying() {
        RFWPlayer rFWPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        RFWVideoView rFWVideoView = this.mVideoView;
        if (rFWVideoView != null) {
            rFWPlayer = rFWVideoView.getQCirclePlayer();
        } else {
            rFWPlayer = null;
        }
        QLog.d(TAG, 1, "[isPlaying]  player:" + rFWPlayer);
        if (rFWPlayer != null && rFWPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean isVideo() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.feedType.get() != 3 && ((feedCloudMeta$StVideo = this.data.video) == null || TextUtils.isEmpty(feedCloudMeta$StVideo.playUrl.get()))) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else if (view != null && view.getId() == R.id.ifh && this.mItemPlayListener != null) {
            QLog.d(TAG, 1, "[onItemClick] pos:" + this.pos);
            this.mItemPlayListener.onItemClick(view, this.pos, this.data, new BitmapDrawable(this.mCoverBitMap));
            doDtReport("dt_clck");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void pause(boolean z16) {
        RFWPlayer rFWPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        RFWVideoView rFWVideoView = this.mVideoView;
        if (rFWVideoView != null) {
            rFWPlayer = rFWVideoView.getQCirclePlayer();
        } else {
            rFWPlayer = null;
        }
        if (rFWPlayer != null && !rFWPlayer.isPausing()) {
            if (z16) {
                saveVideoFrameToBitmap();
            }
            if (this.mVideoView != null) {
                QLog.d(TAG, 1, "[pause] player:" + rFWPlayer + ", needSaveFrame:" + z16);
                this.mVideoView.pause();
            }
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mVideoView != null) {
            QLog.d(TAG, 1, "[release] player:" + this.mVideoView.getQCirclePlayer());
            this.mVideoView.release();
            this.mCoverBitMap = null;
        }
    }

    public void setItemPlayListener(IProfileQCircleItemPlayListener iProfileQCircleItemPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProfileQCircleItemPlayListener);
        } else {
            this.mItemPlayListener = iProfileQCircleItemPlayListener;
        }
    }

    public void startPlay() {
        RFWPlayer rFWPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        makeSureAddVideoView();
        RFWVideoView rFWVideoView = this.mVideoView;
        if (rFWVideoView != null) {
            rFWPlayer = rFWVideoView.getQCirclePlayer();
        } else {
            rFWPlayer = null;
        }
        if (rFWPlayer == null) {
            QLog.d(TAG, 1, "[startPlay] player is null, start a new player");
            startANewPlayer();
            return;
        }
        if (rFWPlayer.isPlaying()) {
            QLog.d(TAG, 1, "[startPlay] isPlaying, player:" + rFWPlayer);
            return;
        }
        if (rFWPlayer.isPausing()) {
            QLog.d(TAG, 1, "[startPlay] start from pause, player:" + rFWPlayer);
            this.mVideoView.start();
            return;
        }
        startANewPlayer();
    }
}
