package eg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qzone.event.QZoneVideoRetryPlayEvent;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.HashMap;
import xg.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {
    private static int e(VideoInfo videoInfo, g.a aVar) {
        long durationMs;
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView;
        long j3 = videoInfo.videoTime;
        if (j3 > 0) {
            return (int) j3;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_sync_qzone_video_use_player_duration", true)) {
            durationMs = videoInfo.videoTime;
        } else {
            ISuperPlayer superPlayer = (aVar == null || (qZoneVideoItemWidgetView = aVar.f447952b) == null || qZoneVideoItemWidgetView.V0() == null) ? null : aVar.f447952b.V0().getSuperPlayer();
            if (superPlayer == null) {
                QLog.e("QZoneQCircleShareJumpUtils", 1, "[getVideoDuration] superPlayer == null, use video info duration");
                durationMs = videoInfo.videoTime;
            } else {
                durationMs = superPlayer.getDurationMs();
            }
        }
        return (int) durationMs;
    }

    private static void f(QCircleLayerBean qCircleLayerBean, VideoInfo videoInfo, g.a aVar, long j3) {
        HashMap<String, String> hashMap;
        String str;
        String g16;
        if (qCircleLayerBean.getSchemeAttrs() != null) {
            hashMap = qCircleLayerBean.getSchemeAttrs();
        } else {
            hashMap = new HashMap<>();
        }
        if (!hashMap.containsKey(QCircleSchemeAttr.Detail.CURRENT_TIME)) {
            hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, j3 + "");
        }
        if (!hashMap.containsKey(QCircleSchemeAttr.Detail.DISABLE_FAKE_RE_PLAY)) {
            hashMap.put(QCircleSchemeAttr.Detail.DISABLE_FAKE_RE_PLAY, "1");
        }
        if (!hashMap.containsKey(QCircleSchemeAttr.Detail.USE_REAL_FEED_ID_CHECK_DATA)) {
            hashMap.put(QCircleSchemeAttr.Detail.USE_REAL_FEED_ID_CHECK_DATA, "1");
        }
        if (!hashMap.containsKey("is_force_login_report")) {
            hashMap.put("is_force_login_report", "1");
        }
        if (!TextUtils.isEmpty(videoInfo.videoId)) {
            g16 = videoInfo.videoId;
        } else {
            VideoUrl videoUrl = videoInfo.videoUrl;
            if (videoUrl == null) {
                str = "";
            } else {
                str = videoUrl.url;
            }
            g16 = nh.c.g(str);
        }
        qCircleLayerBean.setProgressCallbackId(g16);
        qCircleLayerBean.setEnableUsePlayerSize(true);
        if (aVar == null || aVar.f447951a == null) {
            return;
        }
        hashMap.put(QZoneVideoRetryPlayEvent.CLICK_VIEW_HASH_CODE, aVar.f447951a.hashCode() + "");
    }

    private static void g(VideoInfo videoInfo, View view, QCircleLayerBean qCircleLayerBean) {
        String str;
        ImageUrl imageUrl;
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null && (imageUrl = pictureUrl.imageUrl) != null) {
            str = imageUrl.url;
        } else {
            str = "";
        }
        if (view == null || qCircleLayerBean == null || TextUtils.isEmpty(str)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i3 = iArr[0];
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], view.getMeasuredWidth() + i3, iArr[1] + view.getMeasuredHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(str).setEnterAnimFadeCoverTimeMs(300).setTransitionDurationMs(200).setBackTransitionUseVideoFrame(true));
    }

    private static void h(QCircleLayerBean qCircleLayerBean, VideoInfo videoInfo, BusinessFeedData businessFeedData, g.a aVar) {
        String str;
        String str2;
        FeedCloudMeta$StFeed feed = qCircleLayerBean.getFeed();
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl != null && (str2 = videoUrl.url) != null) {
            str = kh.b.d(businessFeedData, str2);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            feed.video.playUrl.set(str);
        }
        feed.video.fileId.set(videoInfo.videoId);
        feed.video.width.set(videoInfo.width);
        feed.video.height.set(videoInfo.height);
        feed.video.duration.set(e(videoInfo, aVar));
        feed.video.setHasFlag(true);
        feed.video.videoRate.set(videoInfo.currentVideoRate);
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.width.set(pictureUrl.width);
            feedCloudMeta$StImage.height.set(pictureUrl.height);
            feedCloudMeta$StImage.picUrl.set(pictureUrl.url);
            feedCloudMeta$StImage.layerPicUrl.set(pictureUrl.url);
            feed.cover.set(feedCloudMeta$StImage);
        }
        feed.feedType.set(1);
        feed.type.set(3);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qqvideo_enable_simple_feed", true)) {
            feed.opMask2.add(44);
        }
        qCircleLayerBean.setFeed(feed);
    }

    public static void l(BusinessFeedData businessFeedData, final Context context, final g.a aVar, long j3) {
        final QCircleLayerBean qCircleLayerBean;
        String feedId;
        ImageView imageView;
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView;
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null) {
            QLog.e("QZoneQCircleShareJumpUtils", 1, "[openQCircleLayerPage] videoInfo == null");
            return;
        }
        QCircleInitBean a16 = QCircleSchemeLauncher.a(context, videoInfo.actionUrl);
        if (a16 instanceof QCircleLayerBean) {
            qCircleLayerBean = (QCircleLayerBean) a16;
        } else {
            qCircleLayerBean = new QCircleLayerBean();
        }
        f(qCircleLayerBean, videoInfo, aVar, j3);
        h(qCircleLayerBean, videoInfo, businessFeedData, aVar);
        ImageView imageView2 = null;
        QZoneVideoView V0 = (aVar == null || (qZoneVideoItemWidgetView = aVar.f447952b) == null) ? null : qZoneVideoItemWidgetView.V0();
        if (aVar != null && (imageView = aVar.f447951a) != null) {
            imageView2 = imageView;
        }
        if (V0 != null) {
            g(videoInfo, V0, qCircleLayerBean);
            boolean z06 = V0.z0();
            if (V0.y0() && z06) {
                if (qCircleLayerBean.getFeedId() != null && !qCircleLayerBean.getFeedId().startsWith("share_fake_")) {
                    feedId = "share_fake_" + qCircleLayerBean.getFeedId();
                } else {
                    feedId = qCircleLayerBean.getFeedId();
                }
                bi.r(V0.getSuperPlayer(), feedId, new bi.a() { // from class: eg.c
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        f.k(QCircleLayerBean.this, context, aVar, pair);
                    }
                });
                return;
            }
            QLog.d("QZoneQCircleShareJumpUtils", 1, "[openQCircleLayerPage] current first render not callback, save frame fail; playIng:" + z06);
            d(context, qCircleLayerBean, aVar);
            return;
        }
        QLog.d("QZoneQCircleShareJumpUtils", 1, "[openQCircleLayerPage] videoView == null");
        g(videoInfo, imageView2, qCircleLayerBean);
        d(context, qCircleLayerBean, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(QCircleLayerBean qCircleLayerBean, Context context, g.a aVar, Pair pair) {
        if (pair != null) {
            QLog.d("QZoneQCircleShareJumpUtils", 1, "[openQCircleLayerPage] create coverSucceed,cover:" + pair.second);
            qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(new BitmapDrawable((Bitmap) pair.second));
        } else {
            QLog.d("QZoneQCircleShareJumpUtils", 1, "[openQCircleLayerPage] error bitmapInfo is null");
        }
        d(context, qCircleLayerBean, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(g.a aVar, Drawable drawable, boolean z16) {
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView;
        if (aVar != null && (qZoneVideoItemWidgetView = aVar.f447952b) != null) {
            QLog.d("QZoneQCircleShareJumpUtils", 1, "[trySetFeedViewVisible] isVisible:" + z16 + ",videoItemWidgetView:" + qZoneVideoItemWidgetView);
            ImageView O0 = qZoneVideoItemWidgetView.O0();
            if (!z16) {
                if (O0 != null) {
                    O0.setVisibility(8);
                    O0.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (O0 == null) {
                O0 = new ImageView(qZoneVideoItemWidgetView.getContext());
                O0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                qZoneVideoItemWidgetView.addView(O0, new FrameLayout.LayoutParams(-2, -2));
                qZoneVideoItemWidgetView.setAnimCoverView(O0);
            }
            ImageView p06 = qZoneVideoItemWidgetView.p0();
            if (p06 != null) {
                ViewGroup.LayoutParams layoutParams = O0.getLayoutParams();
                layoutParams.width = p06.getWidth();
                layoutParams.height = p06.getHeight();
                O0.setLayoutParams(layoutParams);
            }
            if (drawable != null) {
                O0.setImageDrawable(drawable);
            } else {
                ImageView imageView = aVar.f447951a;
                if (imageView != null) {
                    try {
                        O0.setImageDrawable(imageView.getDrawable());
                    } catch (Exception e16) {
                        QLog.e("QZoneQCircleShareJumpUtils", 1, "[trySetFeedViewVisible] error:" + e16);
                    }
                }
            }
            O0.setVisibility(0);
            return;
        }
        QLog.e("QZoneQCircleShareJumpUtils", 1, "[tryHideFeedView] coverView is null");
    }

    private static void d(Context context, QCircleLayerBean qCircleLayerBean, final g.a aVar) {
        if (context == null) {
            QLog.e("QZoneQCircleShareJumpUtils", 1, "[doRealJumpQCircleLayer] context == null");
            return;
        }
        QFSTransitionAnimBean transitionAnimBean = qCircleLayerBean.getTransitionAnimBean();
        if (transitionAnimBean != null) {
            final Drawable coverDrawable = transitionAnimBean.getCoverDrawable();
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: eg.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.m(g.a.this, coverDrawable, true);
                }
            });
        }
        QCircleContentDetailSchemeParser.F(qCircleLayerBean);
        com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: eg.e
            @Override // java.lang.Runnable
            public final void run() {
                f.m(g.a.this, null, false);
            }
        }, 800L);
    }
}
