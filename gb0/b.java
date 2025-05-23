package gb0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.manager.f;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.j;
import com.tencent.biz.qqcircle.immersive.utils.bb;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.QFSPlayerClarityReportInterceptor;
import com.tencent.biz.qqcircle.richframework.video.player.process.QFSPlayerOptionsExchangeUrlProcess;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.spr.RFWSprManger;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudMeta$StVideoUrl;
import java.util.ArrayList;
import java.util.LinkedList;
import jb0.e;
import jy2.g;
import org.jetbrains.annotations.NotNull;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static boolean A(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed.video.fileId.get();
        if (!PreLoader.exists(str) || !RFWPlayerPreRenderHelper.getInstance().isPreRender(str)) {
            return false;
        }
        return true;
    }

    static void B(View view, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int height;
        if (i16 != 0 && i3 != 0 && view != null) {
            Context context = view.getContext();
            if (h(context)) {
                QLog.d("QCircleVideoUtils", 1, "adjust video size, screen size error. ");
                DisplayUtil.init(context);
            }
            int i17 = -1;
            if (i3 == -1 && i16 == -1) {
                height = -1;
            } else if (!bz.s(context) && !bz.k()) {
                if (bz.k() && (TransitionHelper.shouldFullScreen(i3, i16) || !z(feedCloudMeta$StFeed))) {
                    int screenHeight = DisplayUtil.getScreenHeight() - DisplayUtil.dip2px(view.getContext(), 56.0f);
                    i17 = (int) (screenHeight * (i3 / i16));
                    height = screenHeight;
                } else {
                    i17 = DisplayUtil.getScreenWidth();
                    height = (int) ((i17 / i3) * i16);
                }
            } else {
                Size a16 = bz.a(i3, i16);
                i17 = a16.getWidth();
                height = a16.getHeight();
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i17, height);
            }
            layoutParams.width = i17;
            layoutParams.height = height;
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            RFWLog.d("QCircleVideoUtils", RFWLog.USR, "fs_lifecycle setSize origin:", Integer.valueOf(i3), "|", Integer.valueOf(i16), " , target:", Integer.valueOf(i17), "|", Integer.valueOf(height), " , view.hashCode", Integer.valueOf(view.hashCode()));
            return;
        }
        RFWLog.d("QCircleVideoUtils", RFWLog.USR, "setSize origin size zero");
    }

    private static void C(QFSVideoView qFSVideoView, int i3, int i16, int i17) {
        if (qFSVideoView != null && qFSVideoView.getQCirclePlayer() != null && qFSVideoView.getQCirclePlayer().getVideoView() != null) {
            KeyEvent.Callback videoView = qFSVideoView.getQCirclePlayer().getVideoView();
            if (videoView instanceof ISPlayerVideoView) {
                ISPlayerVideoView iSPlayerVideoView = (ISPlayerVideoView) videoView;
                iSPlayerVideoView.setFixedSize(i16, i17);
                iSPlayerVideoView.setXYaxis(i3);
            } else if (videoView instanceof TVKPlayerVideoView) {
                TVKPlayerVideoView tVKPlayerVideoView = (TVKPlayerVideoView) videoView;
                tVKPlayerVideoView.setFixedSize(i16, i17);
                tVKPlayerVideoView.setXYaxis(i3);
            }
            qFSVideoView.requestLayout();
        }
    }

    private static void D(QFSVideoView qFSVideoView, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (qFSVideoView != null && qFSVideoView.getQCirclePlayer() != null && qFSVideoView.getQCirclePlayer().getVideoView() != null && (feedCloudMeta$StFeed instanceof FeedCloudMeta$StFeed)) {
            KeyEvent.Callback videoView = qFSVideoView.getQCirclePlayer().getVideoView();
            if (videoView instanceof ISPlayerVideoView) {
                ISPlayerVideoView iSPlayerVideoView = (ISPlayerVideoView) videoView;
                iSPlayerVideoView.setFixedSize(feedCloudMeta$StFeed.video.width.get(), feedCloudMeta$StFeed.video.height.get());
                iSPlayerVideoView.setXYaxis(i3);
            } else if (videoView instanceof TVKPlayerVideoView) {
                TVKPlayerVideoView tVKPlayerVideoView = (TVKPlayerVideoView) videoView;
                tVKPlayerVideoView.setFixedSize(feedCloudMeta$StFeed.video.width.get(), feedCloudMeta$StFeed.video.height.get());
                tVKPlayerVideoView.setXYaxis(i3);
            }
            qFSVideoView.requestLayout();
        }
    }

    private static void E(QFSVideoView qFSVideoView, int i3, int i16, int i17, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_re_size_player_view", true)) {
            C(qFSVideoView, i3, i16, i17);
        } else {
            D(qFSVideoView, i3, feedCloudMeta$StFeed);
        }
    }

    public static boolean F(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.startsWith("share_fake_") && TextUtils.isEmpty(str2)) {
            return true;
        }
        return false;
    }

    public static boolean G(Activity activity) {
        if (!RFWSprManger.g().enableSpr()) {
            return false;
        }
        return bb.b(activity);
    }

    private static void a(ImageView imageView, QFSVideoView qFSVideoView, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (qFSVideoView != null && imageView != null) {
            QLog.d("QCircleVideoUtils", 1, "isShowInPadFunctionZone = true");
            B(imageView, i3, i16, feedCloudMeta$StFeed);
            B(qFSVideoView, i3, i16, feedCloudMeta$StFeed);
            D(qFSVideoView, 0, feedCloudMeta$StFeed);
        }
    }

    private static void b(ImageView imageView, QFSVideoView qFSVideoView, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (qFSVideoView != null && imageView != null) {
            if (!TransitionHelper.shouldVideoYFullScreen(i3, i16) && (!TransitionHelper.isFolderScreenOpenMode(imageView.getContext()) || z(feedCloudMeta$StFeed))) {
                if (TransitionHelper.shouldFullScreen(i3, i16)) {
                    QLog.d("QCircleVideoUtils", 1, "adjustViewInPhone shouldFullScreen" + i3 + "|" + i16);
                    B(imageView, -1, -1, feedCloudMeta$StFeed);
                    B(qFSVideoView, -1, -1, feedCloudMeta$StFeed);
                    E(qFSVideoView, 2, i3, i16, feedCloudMeta$StFeed);
                    return;
                }
                QLog.d("QCircleVideoUtils", 1, "adjustViewInPhone other" + i3 + "|" + i16);
                B(imageView, i3, i16, feedCloudMeta$StFeed);
                B(qFSVideoView, i3, i16, feedCloudMeta$StFeed);
                E(qFSVideoView, 2, i3, i16, feedCloudMeta$StFeed);
                return;
            }
            QLog.d("QCircleVideoUtils", 1, "adjustViewInPhone shouldVideoYFullScreen:" + i3 + "|" + i16);
            TransitionHelper.setSizeWhenYFullScreen(o(imageView.getContext()), imageView, i3, i16);
            B(qFSVideoView, -1, -1, feedCloudMeta$StFeed);
            E(qFSVideoView, 0, i3, i16, feedCloudMeta$StFeed);
        }
    }

    protected static void c(QFSVideoView qFSVideoView, ImageView imageView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        ISuperPlayer superPlayer;
        MediaInfo mediaInfo;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QLog.d("QCircleVideoUtils", 1, "adjustViewSize begin");
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = feedCloudMeta$StFeed.video.height.get();
        if (qFSVideoView != null && (superPlayer = qFSVideoView.getSuperPlayer()) != null && (mediaInfo = superPlayer.getMediaInfo()) != null) {
            QLog.d("QCircleVideoUtils", 1, "adjustViewSize use playView");
            i3 = mediaInfo.getVideoWidth();
            i16 = mediaInfo.getVideoHeight();
        }
        if (bz.k() && !bz.m()) {
            a(imageView, qFSVideoView, i3, i16, feedCloudMeta$StFeed);
        } else {
            b(imageView, qFSVideoView, i3, i16, feedCloudMeta$StFeed);
        }
    }

    public static void d(QFSVideoView qFSVideoView, ImageView imageView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        c(qFSVideoView, imageView, feedCloudMeta$StFeed);
    }

    private static void e(RFWPlayerPreRenderBean rFWPlayerPreRenderBean, RFWPlayerOptions rFWPlayerOptions) {
        boolean z16;
        if (rFWPlayerOptions == null) {
            rFWPlayerOptions = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        }
        boolean b16 = hb0.a.b(rFWPlayerPreRenderBean.getSourceType());
        rFWPlayerPreRenderBean.setPlayerOptions(rFWPlayerOptions);
        RFWPlayerOptions playUrl = rFWPlayerOptions.setStVideo(rFWPlayerPreRenderBean.getPreloadVideo()).setFromType(rFWPlayerPreRenderBean.getFromType()).setPreloadSourceType(rFWPlayerPreRenderBean.getSourceType()).setFileId(rFWPlayerPreRenderBean.getPreloadVideo().getFileId()).setPlayUrl(rFWPlayerPreRenderBean.getPreloadVideo().getPlayUrl());
        if (rFWPlayerPreRenderBean.isJumpTrigger() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_player_slid_back_render", true)) {
            z16 = true;
        } else {
            z16 = false;
        }
        playUrl.setForceActive(z16).setInitBackThread(b16);
        if (rFWPlayerOptions.getStartOffset() <= 0) {
            rFWPlayerOptions.setStartOffset(p(rFWPlayerPreRenderBean.getPreloadVideo()));
        }
        if (rFWPlayerOptions.getStartOffset() <= 0 && rFWPlayerPreRenderBean.getFromType() == 10014 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_get_history_position_for_watch_later", true)) {
            rFWPlayerOptions.setStartOffset(q(rFWPlayerPreRenderBean.getPreloadVideo()));
        }
        boolean a16 = hb0.a.a(rFWPlayerPreRenderBean.getSourceType());
        if ((a16 || b16) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true)) {
            rFWPlayerOptions.setOffSetBySeek(true);
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        linkedList.add(QFSPlayerOptionsExchangeUrlProcess.f92033a);
        if (rFWPlayerPreRenderBean.isMultiLevel()) {
            linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        }
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        if (!b16 && !a16) {
            linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        }
        linkedList.add(com.tencent.biz.qqcircle.richframework.video.player.process.a.f92042a);
        rFWPlayerPreRenderBean.setProcessOrder(linkedList);
    }

    public static RFWPlayerPreRenderBean f(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        if (rFWPlayerPreRenderBean != null && rFWPlayerPreRenderBean.getPreloadVideo() != null) {
            RFWPlayerOptions playerOptions = rFWPlayerPreRenderBean.getPlayerOptions();
            if (x(rFWPlayerPreRenderBean)) {
                g(rFWPlayerPreRenderBean, playerOptions);
            } else {
                e(rFWPlayerPreRenderBean, playerOptions);
            }
            return rFWPlayerPreRenderBean;
        }
        QLog.d("QCircleVideoUtils", 1, "bindRenderOptions error");
        return rFWPlayerPreRenderBean;
    }

    private static void g(RFWPlayerPreRenderBean rFWPlayerPreRenderBean, RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            rFWPlayerOptions = RFWPlayerOptions.obtain(rFWPlayerPreRenderBean.getSceneId());
        }
        rFWPlayerPreRenderBean.setPlayerOptions(rFWPlayerOptions);
        Video q16 = g.q(((e30.b) rFWPlayerPreRenderBean.getPreloadOriginData().getOriginBusinessData()).g());
        if (q16 != null && q16.video_base_info != null) {
            rFWPlayerOptions.setFileId(rFWPlayerPreRenderBean.getPreloadVideo().getFileId()).setFromType(10008).setPreloadSourceType(rFWPlayerPreRenderBean.getSourceType()).setTVKPlayerOption(g.o(((e30.b) rFWPlayerPreRenderBean.getPreloadOriginData().getOriginBusinessData()).g(), q16, jy2.c.f411160a.b(q16)));
        }
    }

    private static boolean h(Context context) {
        boolean z16;
        if (context == null) {
            return false;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(context);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(context);
        if (screenWidth <= 0 || screenHeight <= 0 || instantScreenHeight <= 0 || instantScreenWidth <= 0) {
            return true;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (screenHeight >= screenWidth && instantScreenHeight >= instantScreenWidth) {
                return false;
            }
            return true;
        }
        if (screenHeight <= screenWidth && instantScreenHeight <= instantScreenWidth) {
            return false;
        }
        return true;
    }

    public static RFWStVideo i(e30.b bVar) {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig() == null) {
            QLog.d("QCircleVideoUtils", 1, "convertFeedToStVideo error,no init");
            return null;
        }
        return RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig().getFeedConvert().convertFeedToStVideo(bVar);
    }

    public static boolean j(Activity activity) {
        if (!RFWSprManger.g().enableSpr()) {
            return false;
        }
        return bb.a(activity);
    }

    public static RFWStVideo k(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig() == null) {
            QLog.d("QCircleVideoUtils", 1, "convertToRRFStVideo error,no init");
            return null;
        }
        return RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig().getVideoConvert().convertToRFWStVideo(feedCloudMeta$StVideo);
    }

    public static FeedCloudMeta$StVideo l(RFWStVideo rFWStVideo) {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig() == null) {
            QLog.d("QCircleVideoUtils", 1, "convertToRRFStVideo error,no init");
            return null;
        }
        return (FeedCloudMeta$StVideo) RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig().getVideoConvert().convertToBusinessVideo(rFWStVideo);
    }

    public static RFWPlayerReportInfo<e30.b> m(e30.b bVar) {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig() == null) {
            QLog.d("QCircleVideoUtils", 1, "coverToReportInfo error,no init");
            return null;
        }
        return RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).getConfig().getFeedConvert().convertToReportInfo(bVar);
    }

    public static RFWVideoPreloadBean n(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        return RFWVideoPreloadBean.obtainBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsQUIC(QCirclePluginUtil.isQUIC(feedCloudMeta$StFeed)).setIsMultiLevel(z16).setIsSimpleFeed(j.g(feedCloudMeta$StFeed)).setPreloadVideo(k(feedCloudMeta$StFeed.video.get()));
    }

    private static int o(Context context) {
        View findViewById;
        if (!(context instanceof Activity) || (findViewById = ((Activity) context).findViewById(R.id.f73923uv)) == null) {
            return 0;
        }
        return findViewById.getHeight() - ImmersiveUtils.dpToPx(56.0f);
    }

    public static long p(RFWStVideo rFWStVideo) {
        long j3 = 0;
        if (rFWStVideo == null) {
            return 0L;
        }
        String N = r.N(rFWStVideo.getPlayUrl());
        if (TextUtils.isEmpty(N)) {
            return 0L;
        }
        long t16 = t(rFWStVideo);
        boolean g16 = f.f().g(t16);
        Long l3 = 0L;
        if (g16) {
            l3 = Long.valueOf(f.f().d(false, t(rFWStVideo), N));
        }
        if (l3 != null) {
            j3 = l3.longValue();
        }
        QLog.d("QCircleVideoUtils", 1, "[QPH][getCurrentHistoryPosition] result: " + j3 + " | duration: " + t16 + " | isEnabled: " + g16 + " | playUrlKey: " + N);
        return j3;
    }

    private static long q(RFWStVideo rFWStVideo) {
        long j3 = 0;
        if (rFWStVideo == null) {
            return 0L;
        }
        Long e16 = f.f().e(r.N(rFWStVideo.getPlayUrl()));
        if (e16 != null) {
            j3 = e16.longValue();
        }
        QLog.d("QCircleVideoUtils", 1, "[getCurrentHistoryPositionForWatchLater] result: " + j3);
        return j3;
    }

    public static String r(float f16) {
        if (f16 == 0.5f) {
            return h.a(R.string.f193484_b);
        }
        if (f16 == 1.0f) {
            return h.a(R.string.f193624_p);
        }
        if (f16 == 1.5f) {
            return h.a(R.string.f193564_j);
        }
        if (f16 == 2.0f) {
            return h.a(R.string.f193394_3);
        }
        return "";
    }

    public static String s(float f16) {
        if (f16 == 0.5f) {
            return h.a(R.string.f193494_c);
        }
        if (f16 == 1.0f) {
            return h.a(R.string.f193534_g);
        }
        if (f16 == 1.5f) {
            return h.a(R.string.f193574_k);
        }
        if (f16 == 2.0f) {
            return h.a(R.string.f193404_4);
        }
        return "";
    }

    private static long t(RFWStVideo rFWStVideo) {
        if (rFWStVideo == null) {
            return 0L;
        }
        return rFWStVideo.getDuration();
    }

    public static float u(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 1.0f;
        }
        float t16 = QCirclePluginGlobalInfo.t(feedCloudMeta$StFeed.f398449id.get());
        if (t16 == 0.5f) {
            return 1.0f;
        }
        if (t16 == 1.0f) {
            return 1.5f;
        }
        if (t16 == 1.5f) {
            return 2.0f;
        }
        if (t16 != 2.0f) {
            return 1.0f;
        }
        return 0.5f;
    }

    public static boolean v(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed.video.fileId.get();
        if (RFWVideoUtils.checkCacheExist(126, feedCloudMeta$StFeed.video.playUrl.get(), str)) {
            return true;
        }
        for (FeedCloudMeta$StVideoUrl feedCloudMeta$StVideoUrl : feedCloudMeta$StFeed.video.vecVideoUrl.get()) {
            if (RFWVideoUtils.checkCacheExist(126, feedCloudMeta$StVideoUrl.playUrl.get(), str) && feedCloudMeta$StVideoUrl.levelType.get() != 9 && feedCloudMeta$StVideoUrl.levelType.get() != 20) {
                return true;
            }
        }
        return false;
    }

    public static void w() {
        if (RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).hasInit()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.b.class);
        arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.d.class);
        arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.a.class);
        arrayList.add(QFSPlayerClarityReportInterceptor.class);
        arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.h.class);
        arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.c.class);
        if (com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.e() > 0) {
            arrayList.add(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.class);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(com.tencent.biz.qqcircle.richframework.video.player.process.a.class);
        arrayList2.add(QFSPlayerOptionsExchangeUrlProcess.class);
        RFWPlayerManger.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).init(new RFWPlayerConfig.RFWPlayerInitBuilder().setInterceptor(arrayList).setBusinessUrlProcess(arrayList2).setIDataConvert(new e()).setIFeedConvert(new jb0.a()).setProcessOrder(new kb0.a()).setVideoHistoryPoiFetch(new jb0.f()).setPlayerRenderCallBack(new jb0.c()).setPlayerOptionsProcessCallback(new jb0.b()).setPlayerReportCallback(new jb0.d()).setSPBandwidthPredictor(QCircleBaseFragment.BAND_WIDTH_PREDICTOR).setFieldToLocalPathConfig(new ib0.a()).build());
    }

    public static boolean x(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        try {
            Video q16 = g.q(((e30.b) rFWPlayerPreRenderBean.getPreloadOriginData().getOriginBusinessData()).g());
            if (q16 != null) {
                if (q16.video_base_info != null) {
                    return true;
                }
            }
        } catch (Exception e16) {
            RFWLog.e("QCircleVideoUtils", RFWLog.DEV, e16);
        }
        return false;
    }

    public static boolean y(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16 = false;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed.video.fileId.get();
        if (PreLoader.exists(str) && RFWPlayerPreRenderHelper.getInstance().isPreRender(str)) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return v(feedCloudMeta$StFeed);
    }

    public static boolean z(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.video.orientation.get() != 2) {
            return false;
        }
        return true;
    }
}
