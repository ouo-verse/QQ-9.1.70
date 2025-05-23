package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.module.covercomponent.manage.QZoneCoverContainerManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.widget.AsyncImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.CoverAutoVideo;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoElement;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.g;
import com.tencent.mobileqq.qzoneplayer.video.h;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverVideoCoverView extends CoverBaseView implements g, View.OnClickListener, h {
    public static final int COVER_WIDTH = CoverEnv.getScreenWidth();
    private Context J;
    private Activity K;
    private FrameLayout L;
    private String M;
    private CoverAutoVideo N;
    private View P;
    private RelativeLayout Q;
    private long R;
    private VideoInfo S;
    private BaseHandler T;
    private Runnable U;

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        G("uin=" + this.R + ",login uin=" + CoverEnv.getLoginUin() + ",click playing video cover,openVideoLayer");
        VideoInfo videoInfo = this.S;
        videoInfo.actionType = 19;
        CoverEnv.playWith(this.K, videoInfo);
    }

    private void B() {
        if (!y()) {
            E("", this.S.coverUrl.url);
            return;
        }
        F("", this.S.coverUrl.url, true);
        View view = this.P;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.covercomponent.ui.CoverVideoCoverView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (!CoverVideoCoverView.this.y()) {
                    CoverVideoCoverView.this.G("not in feeds page ,do nothing");
                } else {
                    CoverVideoCoverView.this.A();
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.P.setOnLongClickListener(this);
    }

    private void C() {
        CoverAutoVideo coverAutoVideo = this.N;
        if (coverAutoVideo == null) {
            return;
        }
        coverAutoVideo.doPlayVideo();
    }

    private void D(boolean z16) {
        y();
    }

    private void F(String str, String str2, boolean z16) {
        q();
        View inflate = LayoutInflater.from(this.J).inflate(CoverHelper.getResId(4), (ViewGroup) null);
        this.P = inflate;
        if (inflate == null) {
            return;
        }
        AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(CoverHelper.getResId(3));
        asyncImageView.setAsyncImage(str2);
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.P.findViewById(CoverHelper.getResId(2)).setVisibility(z16 ? 0 : 8);
        this.L.addView(this.P, 0, new FrameLayout.LayoutParams(-1, -1));
        this.P.setOnLongClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        if (CoverLog.isColorLevel()) {
            CoverLog.i("CoverVideoCoverView" + hashCode(), CoverLog.CLR, str);
        }
    }

    private void n() {
        if (FeedVideoEnv.isWifiConnected()) {
            if (this.N != null) {
                try {
                    if (BaseVideoManager.getFeedVideoManager().r()) {
                        G("is playing, stop video");
                        BaseVideoManager.getFeedVideoManager().stopVideo(this.N);
                    } else {
                        G("is not playing");
                    }
                    G("start playing");
                    BaseVideoManager.getFeedVideoManager().startVideo(this.N);
                } catch (IllegalStateException unused) {
                    G("auto play video error");
                }
                G("auto play video");
                return;
            }
            return;
        }
        G("condition is NOT allow start play video");
    }

    private static boolean o() {
        return (!CoverEnv.isBestPerformanceDevice() || BaseVideoManager.belowICE_CREAM || FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED || x()) ? false : true;
    }

    private boolean p(String str, String str2) {
        if ("1000".equals(this.M)) {
            G("mVideoCoverStatus \u5408\u6210\u4e2d");
            if (str == null || str.length() == 0) {
                E("\u89c6\u9891\u4e0a\u4f20\u4e2d", str2);
                return false;
            }
        } else if ("1001".equals(this.M)) {
            G("mVideoCoverStatus \u4e0a\u4f20\u4e2d");
            if (str == null || str.length() == 0) {
                E("\u89c6\u9891\u4e0a\u4f20\u4e2d", str2);
                return false;
            }
        } else if ("1".equals(this.M)) {
            G("mVideoCoverStatus \u8f6c\u7801\u4e2d");
            if (str == null || str.length() == 0) {
                E("\u89c6\u9891\u8f6c\u7801\u4e2d", str2);
                return false;
            }
        } else {
            if ("3".equals(this.M)) {
                G("mVideoCoverStatus \u89c6\u9891\u88ab\u7981");
                E("\u89c6\u9891\u7981\u6b62\u64ad\u653e", CoverHelper.getDefaultCover());
                return false;
            }
            if ("0".equals(this.M)) {
                G("mVideoCoverStatus \u89c6\u9891cover\u672a\u8bbe\u7f6e");
                E("", str2);
                return false;
            }
            if ("1002".equals(this.M)) {
                G("mVideoCoverStatus album\u89c6\u9891cover\u5047\u663e");
                if (TextUtils.isEmpty(str)) {
                    E("", str2);
                    return false;
                }
            }
        }
        if (str != null && str.length() != 0) {
            return true;
        }
        G("video url is empty.");
        E("", CoverHelper.getDefaultCover());
        return false;
    }

    private void q() {
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.removeAllViewsInLayout();
        }
    }

    private void r(VideoInfo videoInfo) {
        q();
        BusinessFeedData businessFeedData = new BusinessFeedData();
        businessFeedData.setUser(new User(this.R, ""));
        businessFeedData.setVideoInfo(videoInfo);
        this.N = new CoverAutoVideo(this.J);
        this.Q = new RelativeLayout(this.J);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.L.addView(this.Q, 0, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        this.Q.addView(this.N, layoutParams2);
        this.N.setVideoPlayInfo(CoverEnv.convertToVideoPlayInfo(businessFeedData, videoInfo));
        this.N.setOnFeedVideoElementClickListener(this);
        this.N.setOnClickListener(this);
        this.N.setOnFeedVideoElementLongClickListener(this);
        this.N.startLayout();
        if (ar.b("kenaiyu", "2024-12-2", "vas_bug_134861019").isEnable(true)) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String config;
        int i3 = this.E != 1 ? 2 : 1;
        if (getCoverType() == 15) {
            config = CoverEnv.getConfig("H5Url", "CoverStore", CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
        } else {
            config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_VIDEO_USER_DEFINE_TAB_URL, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
        }
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(CoverEnv.getLoginUin());
        if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
            config = coverJumpUrlFromJce;
        }
        CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithQua(config), "{hostUin}", String.valueOf(this.R)), CoverEnv.getLoginUin()), "{page}", String.valueOf(i3)), "{from}", CoverHelper.getFromPageName(this.E)), this.J, null);
    }

    private void t() {
        CoverAutoVideo coverAutoVideo = this.N;
        if (coverAutoVideo != null) {
            coverAutoVideo.onPause();
        }
    }

    private void u() {
        if (z()) {
            if (this.N != null) {
                n();
            }
            G("condition is NOT allow start play video mVideoContainer.invalidate");
            if (this.T == null) {
                this.T = new BaseHandler();
            }
            this.T.postDelayed(this.U, 100L);
            this.T.postDelayed(this.U, 500L);
            this.T.postDelayed(this.U, 1000L);
            this.T.postDelayed(this.U, 2000L);
            return;
        }
        if (CoverEnv.isInQQ()) {
            return;
        }
        CoverEnv.notifyCanPlayVideo();
    }

    private void v(Context context, Activity activity, FrameLayout frameLayout, long j3, HashMap<String, String> hashMap, int i3) {
        this.J = context;
        this.K = activity;
        this.L = frameLayout;
        this.E = i3;
        w(j3, hashMap);
    }

    private static boolean x() {
        String[] split;
        String[] split2;
        String str;
        String config = CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECONDARY_COVER_VIDEO_AUTOPLAY_BLACKLIST, "HTC D816w,21;");
        if (config == null || config.length() == 0 || (split = config.split(";")) == null) {
            return false;
        }
        for (String str2 : split) {
            if (str2 != null && str2.length() != 0 && (split2 = str2.split(",")) != null && split2.length >= 1) {
                String str3 = split2[0];
                if (split2.length >= 2) {
                    str = split2[1];
                } else {
                    str = "";
                }
                if (str3 != null && str3.length() != 0) {
                    if (str != null && str.length() != 0) {
                        if (str3.equals(DeviceInfoMonitor.getModel()) && str.equals(String.valueOf(Build.VERSION.SDK_INT))) {
                            return true;
                        }
                    } else if (str3.equals(DeviceInfoMonitor.getModel())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        int i3 = this.E;
        return 1 == i3 || 2 == i3;
    }

    private boolean z() {
        int i3 = this.E;
        return 4 == i3 || 3 == i3;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.g
    public void onClick(View view, FeedVideoElement feedVideoElement, int i3, Object obj) {
        if (FeedVideoElement.AUTO_VIDEO == feedVideoElement) {
            G("onclick FeedVideoElement : " + feedVideoElement + ",feedPos: " + i3);
            onClick(view);
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        G(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        BaseHandler baseHandler = this.T;
        if (baseHandler != null) {
            baseHandler.removeCallbacks(this.U);
        }
        CoverAutoVideo coverAutoVideo = this.N;
        if (coverAutoVideo != null) {
            coverAutoVideo.onRecycled();
            this.N = null;
        }
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.removeAllViewsInLayout();
        }
        super.onDestroy();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onInvisible() {
        super.onInvisible();
        t();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        if (isPaused()) {
            return;
        }
        super.onPause();
        t();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        if (isPaused()) {
            super.onResume();
            u();
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.h
    public void onVideoLongClick(View view) {
        onLongClick(view);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onVisible() {
        if (isCoverVisible()) {
            return;
        }
        super.onVisible();
        u();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void setRefer(int i3) {
        super.setRefer(i3);
    }

    private void E(String str, String str2) {
        F(str, str2, false);
    }

    public CoverVideoCoverView(Context context, Activity activity, FrameLayout frameLayout, long j3, HashMap<String, String> hashMap, int i3, int i16) {
        super(i3);
        this.U = new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverVideoCoverView.2
            @Override // java.lang.Runnable
            public void run() {
                if (CoverVideoCoverView.this.Q != null) {
                    CoverVideoCoverView.this.Q.invalidate();
                    CoverVideoCoverView.this.G("mVideoContainer invalidate");
                }
            }
        };
        v(context, activity, frameLayout, j3, hashMap, i16);
    }

    private void w(long j3, HashMap<String, String> hashMap) {
        String defaultCover;
        if (hashMap == null) {
            E(null, CoverHelper.getDefaultCover());
            return;
        }
        this.M = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS);
        this.R = j3;
        VideoInfo videoData = CoverHelper.toVideoData(hashMap);
        if (videoData == null) {
            return;
        }
        this.S = videoData;
        PictureUrl pictureUrl = videoData.coverUrl;
        if (pictureUrl != null) {
            defaultCover = pictureUrl.url;
        } else {
            defaultCover = CoverHelper.getDefaultCover();
        }
        VideoUrl videoUrl = videoData.videoUrl;
        if (!p(videoUrl != null ? videoUrl.url : null, defaultCover)) {
            View view = this.P;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.covercomponent.ui.CoverVideoCoverView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        CoverVideoCoverView.this.s();
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
                return;
            }
            return;
        }
        if (!o()) {
            G("process as BadDevices");
            B();
            D(true);
        } else {
            r(videoData);
            D(false);
            G("init method call resume.");
            onResume();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        G("video cover view onclicked");
        CoverAutoVideo coverAutoVideo = this.N;
        if (view == coverAutoVideo) {
            if (y()) {
                if (coverAutoVideo == null) {
                    s();
                } else if (coverAutoVideo.getState() != 3 && coverAutoVideo.getState() != 2) {
                    C();
                } else {
                    s();
                }
            } else if (z()) {
                if (coverAutoVideo != null && coverAutoVideo.getState() == 3) {
                    G("in preview activity,playing ,do nothing");
                } else {
                    C();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public boolean isChanged(long j3, HashMap<String, String> hashMap) {
        return (hashMap != null && j3 == this.R && CoverHelper.isTheSameVideo(CoverHelper.toVideoData(hashMap), this.S)) ? false : true;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
    }
}
