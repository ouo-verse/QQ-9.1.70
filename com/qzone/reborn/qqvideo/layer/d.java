package com.qzone.reborn.qqvideo.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
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
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.event.QZoneVideoRetryPlayEvent;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import xg.g;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {
    private static void e(Context context, final g.a aVar, QCircleLayerBean qCircleLayerBean, BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        QFSTransitionAnimBean transitionAnimBean = qCircleLayerBean.getTransitionAnimBean();
        if (transitionAnimBean != null) {
            final Drawable coverDrawable = transitionAnimBean.getCoverDrawable();
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.qqvideo.layer.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.l(g.a.this, coverDrawable, true);
                }
            });
        }
        String str = businessFeedData.getOperationInfo().qzoneFeedid;
        if (str != null) {
            qCircleLayerBean.setQQVideoBusinessFeedID(str);
        }
        g(qCircleLayerBean, str, videoInfo, businessFeedData);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = 90;
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        qCircleLayerBean.setLayerBizAssemblerType("biz_qzone_qq_video_layer");
        qCircleLayerBean.putBusinessData("enableQQVideoCommentPublicTips", Boolean.valueOf(QZoneConfigHelper.z()));
        qCircleLayerBean.putBusinessData("enableQQVideoCommentPublicTipsContent", QZoneConfigHelper.q0());
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101688", false);
        qCircleLayerBean.setSupportDragExit(!isSwitchOn);
        QCircleContentDetailSchemeParser.F(qCircleLayerBean);
        qCircleLayerBean.setNeedReleaseOtherSceneIdPlayer(false);
        com.tencent.biz.qqcircle.launcher.c.u(context, qCircleLayerBean);
        QCircleDTLoginReporter.doQQVideoDaTongLoginReport(qCircleLayerBean.getSchemeAttrs());
        RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[openQQVideoPlayer] start play feed id is :" + str + ", isLayerDragExitClose :" + isSwitchOn);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qqvideo.layer.c
            @Override // java.lang.Runnable
            public final void run() {
                d.l(g.a.this, null, false);
            }
        }, 300L);
    }

    private static void f(QCircleLayerBean qCircleLayerBean, g.a aVar, long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xsj_main_entrance", "qzone");
        hashMap.put("xsj_sub_entrance", QCircleDaTongConstant.ElementParamValue.FEED_MOMENT_LAYER);
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_QZONE_QQ_VIDEO_PAGE);
        hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, j3 + "");
        if (aVar != null && aVar.f447951a != null) {
            hashMap.put(QZoneVideoRetryPlayEvent.CLICK_VIEW_HASH_CODE, aVar.f447951a.hashCode() + "");
        }
        qCircleLayerBean.setSchemeAttrs(hashMap);
    }

    private static void g(QCircleLayerBean qCircleLayerBean, String str, VideoInfo videoInfo, BusinessFeedData businessFeedData) {
        String str2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.video.width.set(videoInfo.width);
        feedCloudMeta$StFeed.video.height.set(videoInfo.height);
        feedCloudMeta$StFeed.video.fileId.set(videoInfo.videoId);
        feedCloudMeta$StFeed.video.duration.set((int) videoInfo.videoTime);
        feedCloudMeta$StFeed.video.setHasFlag(true);
        feedCloudMeta$StFeed.video.videoRate.set(videoInfo.currentVideoRate);
        PictureUrl pictureUrl = videoInfo.coverUrl;
        if (pictureUrl != null) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.width.set(pictureUrl.width);
            feedCloudMeta$StImage.height.set(pictureUrl.height);
            feedCloudMeta$StImage.picUrl.set(pictureUrl.url);
            feedCloudMeta$StImage.layerPicUrl.set(pictureUrl.url);
            feedCloudMeta$StFeed.cover.set(feedCloudMeta$StImage);
        }
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl != null && (str2 = videoUrl.url) != null) {
            boolean b16 = ah.b1(str2);
            if (!b16 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qq_video_enable_append_url_scene", true)) {
                if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str2 = str2 + "&play_scene=qzone_qq_video";
                } else {
                    str2 = str2 + "?play_scene=qzone_qq_video";
                }
            }
            feedCloudMeta$StFeed.video.playUrl.set(str2);
            RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[initStFeed] play url:" + videoUrl.url + ",isLocalFileUrl:" + b16);
        }
        feedCloudMeta$StFeed.feedType.set(1);
        feedCloudMeta$StFeed.type.set(3);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qqvideo_enable_simple_feed", true)) {
            feedCloudMeta$StFeed.opMask2.add(44);
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(businessFeedData.getCellUserInfo().getUser().uin + "");
        feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        feedCloudCommon$BytesEntry.key.set("xsj_sync_content_src");
        feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFromUtf8("100"));
        feedCloudMeta$StFeed.busiTranparent.add(feedCloudCommon$BytesEntry);
        if (str != null) {
            feedCloudMeta$StFeed.f398449id.set(str);
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry2 = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry2.key.set("qzone_feed_id");
            feedCloudCommon$BytesEntry2.value.set(ByteStringMicro.copyFromUtf8(str));
            feedCloudMeta$StFeed.busiTranparent.add(feedCloudCommon$BytesEntry2);
        }
        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
        qCircleLayerBean.setGetFeedList(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(g.a aVar, Drawable drawable, boolean z16) {
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView;
        if (aVar != null && (qZoneVideoItemWidgetView = aVar.f447952b) != null) {
            RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[trySetFeedViewVisible] isVisible:" + z16 + ",videoItemWidgetView:" + qZoneVideoItemWidgetView);
            if (!z16) {
                ImageView O0 = qZoneVideoItemWidgetView.O0();
                if (O0 != null) {
                    O0.setVisibility(8);
                    O0.setImageDrawable(null);
                    return;
                }
                return;
            }
            ImageView O02 = qZoneVideoItemWidgetView.O0();
            if (O02 == null) {
                O02 = new ImageView(qZoneVideoItemWidgetView.getContext());
                O02.setScaleType(ImageView.ScaleType.CENTER_CROP);
                qZoneVideoItemWidgetView.addView(O02, new FrameLayout.LayoutParams(-2, -2));
                qZoneVideoItemWidgetView.setAnimCoverView(O02);
            }
            ImageView p06 = qZoneVideoItemWidgetView.p0();
            if (p06 != null) {
                ViewGroup.LayoutParams layoutParams = O02.getLayoutParams();
                layoutParams.width = p06.getWidth();
                layoutParams.height = p06.getHeight();
                O02.setLayoutParams(layoutParams);
            }
            if (drawable != null) {
                O02.setImageDrawable(drawable);
            } else {
                ImageView imageView = aVar.f447951a;
                if (imageView != null) {
                    try {
                        O02.setImageDrawable(imageView.getDrawable());
                    } catch (Exception e16) {
                        RFWLog.e("QZoneQQVideoJumpUtils", RFWLog.USR, "[trySetFeedViewVisible] error:" + e16);
                    }
                }
            }
            O02.setVisibility(0);
            return;
        }
        RFWLog.e("QZoneQQVideoJumpUtils", RFWLog.USR, "[tryHideFeedView] coverView is null");
    }

    public static boolean d(BusinessFeedData businessFeedData) {
        return businessFeedData != null && businessFeedData.isQQVideoFeeds() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_qqvideo_qzone_enable_exchange_video_url", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(QCircleLayerBean qCircleLayerBean, g.a aVar, long j3, Context context, BusinessFeedData businessFeedData, VideoInfo videoInfo, Pair pair) {
        if (pair != null) {
            RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[openQQVideoPlayer] create coverSucceed,cover:" + pair.second);
            f(qCircleLayerBean, aVar, j3);
            qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(new BitmapDrawable((Bitmap) pair.second));
        } else {
            RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[openQQVideoPlayer] error bitmapInfo is null");
        }
        e(context, aVar, qCircleLayerBean, businessFeedData, videoInfo);
    }

    public static void k(final BusinessFeedData businessFeedData, final Context context, final g.a aVar, final long j3) {
        QZoneVideoItemWidgetView qZoneVideoItemWidgetView;
        String str;
        ImageUrl imageUrl;
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo == null && businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getVideoInfo() != null) {
            videoInfo = businessFeedData.getOriginalInfo().getVideoInfo();
        }
        final VideoInfo videoInfo2 = videoInfo;
        if (videoInfo2 == null) {
            RFWLog.e("QZoneQQVideoJumpUtils", RFWLog.USR, "[openQQVideoPlayer] videoInfo == null");
            return;
        }
        final QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        if (aVar != null && (qZoneVideoItemWidgetView = aVar.f447952b) != null && qZoneVideoItemWidgetView.V0() != null) {
            PictureUrl pictureUrl = videoInfo2.coverUrl;
            if (pictureUrl != null && (imageUrl = pictureUrl.imageUrl) != null) {
                str = imageUrl.url;
            } else {
                str = "";
            }
            QZoneVideoView V0 = aVar.f447952b.V0();
            int[] iArr = new int[2];
            V0.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i3 = iArr[0];
            qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], V0.getMeasuredWidth() + i3, iArr[1] + V0.getMeasuredHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(str).setTransitionDelayTimeMs(0).setEnterAnimFadeCoverTimeMs(200).setExitAnimFadeCoverTimeMs(50).setTransitionDurationMs(200).setBackTransitionUseVideoFrame(true));
            boolean z06 = V0.z0();
            if (V0.y0() && z06) {
                bi.r(V0.getSuperPlayer(), businessFeedData.getOperationInfo().qzoneFeedid, new bi.a() { // from class: com.qzone.reborn.qqvideo.layer.a
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        d.j(QCircleLayerBean.this, aVar, j3, context, businessFeedData, videoInfo2, pair);
                    }
                });
                return;
            }
            QLog.d("QZoneQQVideoJumpUtils", 1, "[openQQVideoPlayer] current first render not callback, save frame fail; playIng:" + z06);
            f(qCircleLayerBean, aVar, 0L);
            e(context, aVar, qCircleLayerBean, businessFeedData, videoInfo2);
            return;
        }
        RFWLog.d("QZoneQQVideoJumpUtils", RFWLog.USR, "[openQQVideoPlayer] videoView is null");
        f(qCircleLayerBean, aVar, j3);
        e(context, aVar, qCircleLayerBean, businessFeedData, videoInfo2);
    }
}
