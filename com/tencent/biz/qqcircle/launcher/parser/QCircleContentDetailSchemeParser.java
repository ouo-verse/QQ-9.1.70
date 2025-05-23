package com.tencent.biz.qqcircle.launcher.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.part.ea;
import com.tencent.biz.qqcircle.immersive.utils.v;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import e40.QFSSchemaTransitionInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import uq3.o;

/* loaded from: classes4.dex */
public class QCircleContentDetailSchemeParser extends com.tencent.biz.qqcircle.launcher.parser.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Function1<Boolean, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QCircleLayerBean f91406d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f91407e;

        a(QCircleLayerBean qCircleLayerBean, Context context) {
            this.f91406d = qCircleLayerBean;
            this.f91407e = context;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool) {
            QLog.i("QCircleBaseSchemeParser", 1, "addForceRefreshKeyToInitBeanAttrs ,hasUnReadMessage=" + bool);
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.i(this.f91406d, bool.booleanValue() ^ true);
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.j(this.f91406d, bool.booleanValue());
            QCircleContentDetailSchemeParser.this.H(this.f91407e, this.f91406d, QCircleContentDetailSchemeParser.this.q(this.f91407e, this.f91406d));
            ea.x9();
            QCircleLauncherUtil.c();
            return null;
        }
    }

    public static void A(QCircleInitBean qCircleInitBean, HashMap<String, String> hashMap) {
        if (qCircleInitBean != null && hashMap != null && hashMap.containsKey("autoshowpannel")) {
            qCircleInitBean.setAutoShowPanel(TextUtils.equals("1", hashMap.get("autoshowpannel")));
        }
    }

    @NonNull
    private QFSSchemaTransitionInfo B(@NonNull Map<String, String> map) {
        String str = map.get(QCircleSchemeAttr.Detail.NATIVE_POSITION);
        return new QFSSchemaTransitionInfo(QFSSchemaTransitionInfo.FeedInfo.m(map.get("feedinfo")), J(map.get(QCircleSchemeAttr.Detail.COVER_CACHE_PATH)), QFSSchemaTransitionInfo.PositionInfo.e(str));
    }

    private void C(QCircleLayerBean qCircleLayerBean, HashMap<String, String> hashMap) {
        if (qCircleLayerBean == null) {
            return;
        }
        QCircleInitBean.QCircleActionBean actionBean = qCircleLayerBean.getActionBean();
        if (actionBean == null) {
            actionBean = new QCircleInitBean.QCircleActionBean();
        }
        if (TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.SHOW_TOP_SHARE_PANEL), "true")) {
            actionBean.mShowTopSharePanel = true;
        }
        if (TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.SHOW_SHARE_PANEL), "true")) {
            actionBean.mShowSharePanel = true;
        } else if (TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.SHOW_DETAIL_SHARE_PANEL), "1")) {
            actionBean.mShowSharePanel = true;
            actionBean.mIsShowDetailSharePanel = true;
        }
        qCircleLayerBean.setActionBean(actionBean);
    }

    public static void D(QCircleLayerBean qCircleLayerBean) {
        com.tencent.biz.qqcircle.immersive.layer.base.c c16;
        if (qCircleLayerBean == null || qCircleLayerBean.getSchemeAttrs() == null || (c16 = n50.a.c(qCircleLayerBean)) == null) {
            return;
        }
        PreLoader.remove(c16.b());
        PreLoader.preLoad(c16.b(), c16);
        QLog.d("QCircleBaseSchemeParser", 1, "preload task:" + c16.b());
    }

    private static void E(QCircleLayerBean qCircleLayerBean) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (qCircleLayerBean != null && qCircleLayerBean.getFeed() != null) {
            QLog.d("QCircleBaseSchemeParser", 1, "preload player:" + qCircleLayerBean.getFeed().video.playUrl.get());
            RFWPlayerOptions obtain = RFWPlayerOptions.obtain(cq.f92752a.p(qCircleLayerBean.getFeed()));
            HashMap<String, String> schemeAttrs = qCircleLayerBean.getSchemeAttrs();
            if (schemeAttrs != null) {
                if (!TextUtils.isEmpty(schemeAttrs.get(QCircleSchemeAttr.Detail.CURRENT_TIME))) {
                    try {
                        obtain.setStartOffset(Integer.parseInt(r3));
                    } catch (Exception e16) {
                        QLog.d("QCircleBaseSchemeParser", 1, "[preloadPlayer] error:" + e16);
                    }
                }
            }
            RFWPlayerPreRenderBean activity = new RFWPlayerPreRenderBean(cq.f92752a.p(qCircleLayerBean.getFeed()), 10006).setActivity(((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getTopActivity());
            if (qCircleLayerBean.getFeed() != null) {
                feedCloudMeta$StVideo = qCircleLayerBean.getFeed().video;
            } else {
                feedCloudMeta$StVideo = null;
            }
            RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(activity.setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setPreloadOriginData(gb0.b.m(new e30.b(qCircleLayerBean.getFeed()))).setSourceType(com.tencent.biz.qqcircle.immersive.manager.g.e().h(qCircleLayerBean)).setMultiLevel(false).setIsJumpTrigger(o.U0()).setPlayerOptions(obtain)));
        }
    }

    public static void F(QCircleLayerBean qCircleLayerBean) {
        if (!uq3.c.j5()) {
            return;
        }
        if (qCircleLayerBean != null && qCircleLayerBean.getFeed() != null) {
            gb0.a.a(qCircleLayerBean.getFeed());
        }
        E(qCircleLayerBean);
        D(qCircleLayerBean);
    }

    private void G(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QFSSchemaTransitionInfo.FeedInfo feedInfo) {
        feedCloudMeta$StFeed.cover.width.set(feedInfo.getWidth());
        feedCloudMeta$StFeed.cover.height.set(feedInfo.getHeight());
        feedCloudMeta$StFeed.type.set(feedInfo.getFeedType());
        if (feedCloudMeta$StFeed.type.get() == 2) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.picUrl.set(feedCloudMeta$StFeed.cover.picUrl.get());
            feedCloudMeta$StImage.width.set(feedInfo.getWidth());
            feedCloudMeta$StImage.height.set(feedInfo.getHeight());
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StImage);
            feedCloudMeta$StFeed.images.set(arrayList);
            return;
        }
        if (feedCloudMeta$StFeed.type.get() == 3) {
            feedCloudMeta$StFeed.video.setHasFlag(true);
            feedCloudMeta$StFeed.video.width.set(feedInfo.getWidth());
            feedCloudMeta$StFeed.video.height.set(feedInfo.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Context context, QCircleLayerBean qCircleLayerBean, Intent intent, QFSSchemaTransitionInfo qFSSchemaTransitionInfo) {
        boolean z16;
        QFSSchemaTransitionInfo.PositionInfo positionInfo = qFSSchemaTransitionInfo.getPositionInfo();
        if (positionInfo != null) {
            QFSTransitionAnimBean layoutRect = new QFSTransitionAnimBean().setLayoutRect(new QFSTransitionAnimBean.SourceRect(positionInfo.getVisibleRectLeft(), positionInfo.getVisibleRectTop(), positionInfo.getVisibleRectRight(), positionInfo.getVisibleRectBottom()));
            QFSSchemaTransitionInfo.FeedInfo feedInfo = qFSSchemaTransitionInfo.getFeedInfo();
            if (feedInfo != null) {
                layoutRect.setScaleType(v.a(feedInfo.getWidth(), feedInfo.getHeight()));
            }
            qCircleLayerBean.setTransitionAnimBean(layoutRect);
        }
        if (positionInfo == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QCircleLauncherUtil.q(context, intent, z16);
    }

    @Nullable
    private String J(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String decode = Uri.decode(str);
        if (!com.tencent.biz.qqcircle.utils.f.a(decode) && !uq3.h.d(decode)) {
            String arkPathToSysPath = ((IArkHelper) QRoute.api(IArkHelper.class)).arkPathToSysPath("com.tencent.wezone.share", decode);
            if (!TextUtils.isEmpty(arkPathToSysPath)) {
                return arkPathToSysPath;
            }
            return decode;
        }
        return decode;
    }

    public static FeedCloudMeta$StFeed p(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        if (!r(hashMap)) {
            FeedCloudMeta$StFeed k3 = bb0.b.i().k(true);
            if (bb0.b.n(k3, hashMap)) {
                QLog.d("QCircleBaseSchemeParser", 1, "[buildFeedByAttrs] hasCompleteSimpleFeedInfo return push preload feed");
                return k3;
            }
            QLog.d("QCircleBaseSchemeParser", 1, "[buildFeedByAttrs] hasCompleteSimpleFeedInfo return false");
            return null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        if (hashMap.containsKey("feedid")) {
            feedCloudMeta$StFeed.f398449id.set(hashMap.get("feedid"));
        }
        if (hashMap.containsKey("type")) {
            try {
                feedCloudMeta$StFeed.type.set(Integer.parseInt(hashMap.get("type")));
            } catch (Exception e16) {
                QLog.d("QCircleBaseSchemeParser", 1, "[scheme] create time parse error. " + e16);
            }
            feedCloudMeta$StFeed.feedType.set(1);
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.COVER_PIC_URL)) {
            feedCloudMeta$StFeed.cover.setHasFlag(true);
            String decode = Uri.decode(hashMap.get(QCircleSchemeAttr.Detail.COVER_PIC_URL));
            feedCloudMeta$StFeed.cover.picUrl.set(decode);
            QCircleFeedPicLoader.g().download(Option.obtain().setUrl(decode), null);
        }
        if (hashMap.containsKey("createtime") && !TextUtils.isEmpty(hashMap.get("createtime"))) {
            try {
                feedCloudMeta$StFeed.createTime.set(Long.parseLong(hashMap.get("createtime")));
            } catch (Exception e17) {
                QLog.d("QCircleBaseSchemeParser", 1, "[scheme] create time parse error. " + e17);
            }
        }
        if (hashMap.containsKey("uin")) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(hashMap.get("uin"));
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        }
        if (hashMap.containsKey("play_url")) {
            feedCloudMeta$StFeed.video.setHasFlag(true);
            feedCloudMeta$StFeed.video.playUrl.set(Uri.decode(hashMap.get("play_url")));
            feedCloudMeta$StFeed.opMask2.add(44);
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.V_WIDTH) && hashMap.containsKey(QCircleSchemeAttr.Detail.V_HEIGHT)) {
            try {
                feedCloudMeta$StFeed.video.width.set(Integer.parseInt(hashMap.get(QCircleSchemeAttr.Detail.V_WIDTH)));
                feedCloudMeta$StFeed.video.height.set(Integer.parseInt(hashMap.get(QCircleSchemeAttr.Detail.V_HEIGHT)));
            } catch (Exception e18) {
                QLog.d("QCircleBaseSchemeParser", 1, "[scheme] source parse error. " + e18);
            }
        }
        return feedCloudMeta$StFeed;
    }

    public static boolean r(HashMap<String, String> hashMap) {
        if (hashMap == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_parse_simple_feed_info", true) || !hashMap.containsKey("feedid") || !hashMap.containsKey("uin") || !hashMap.containsKey("createtime") || !hashMap.containsKey("type") || !hashMap.containsKey("play_url") || !hashMap.containsKey(QCircleSchemeAttr.Detail.V_WIDTH) || !hashMap.containsKey(QCircleSchemeAttr.Detail.V_HEIGHT)) {
            return false;
        }
        return true;
    }

    private void s(Context context, QCircleSchemeBean qCircleSchemeBean) {
        if (context != null && qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            QCircleLayerBean K = K(qCircleSchemeBean);
            QLog.i("QCircleBaseSchemeParser", 1, "launchContentDetailPageByScheme  | isNewLayerMode = " + uq3.c.g6() + " | isMiddlePage = " + K.isMiddlePage());
            if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.e(K)) {
                com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.m(K);
            }
            if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.g(K)) {
                u(context, K);
            } else {
                t(context, K);
            }
        }
    }

    private void u(Context context, QCircleLayerBean qCircleLayerBean) {
        if (fb0.a.b("QCircleBaseSchemeParserlaunchPublicAccountContentDetailPage", 500L)) {
            return;
        }
        ((IQCirclePublicAccountMessageService) QCircleServiceImpl.getAppInterface().getRuntimeService(IQCirclePublicAccountMessageService.class, "")).hasUnReadMessage(new a(qCircleLayerBean, context));
    }

    private void v(QCircleLayerBean qCircleLayerBean, QFSSchemaTransitionInfo qFSSchemaTransitionInfo) {
        FeedCloudMeta$StFeed feed = qCircleLayerBean.getFeed();
        QLog.i("TM-QCircleBaseSchemeParser", 1, "makeUpFeedInfo, schemaTransitionInfo=" + qFSSchemaTransitionInfo.toString());
        if (feed == null) {
            QLog.e("QCircleBaseSchemeParser", 1, "makeUpFeedInfo, feed == null");
            return;
        }
        feed.feedType.set(1);
        String coverPath = qFSSchemaTransitionInfo.getCoverPath();
        if (coverPath != null) {
            feed.cover.setHasFlag(true);
            feed.cover.picUrl.set(coverPath);
        }
        QFSSchemaTransitionInfo.FeedInfo feedInfo = qFSSchemaTransitionInfo.getFeedInfo();
        if (feedInfo != null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_layer_simple_feed_opmask", true)) {
                feed.type.set(feedInfo.getFeedType());
                feed.opMask2.add(44);
            }
            G(feed, feedInfo);
            feed.poster.setHasFlag(true);
            feed.poster.nick.set(feedInfo.getNickName());
            feed.poster.f398463id.set(feedInfo.getUin());
            feed.poster.icon.setHasFlag(true);
            feed.poster.icon.iconUrl.set(feedInfo.getAvatar());
            feed.content.set(feedInfo.getContent());
            feed.likeInfo.setHasFlag(true);
            feed.likeInfo.count.set(feedInfo.getLikeNum());
            feed.commentCount.set(feedInfo.getCommentNum());
            FeedCloudMeta$StPushList feedCloudMeta$StPushList = new FeedCloudMeta$StPushList();
            feedCloudMeta$StPushList.totalClickCount.set(feedInfo.getFuelNum());
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            qQCircleFeedBase$StFeedBusiReqData.pushList.set(feedCloudMeta$StPushList);
            feed.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
            feed.share.setHasFlag(true);
            feed.share.sharedCount.set(feedInfo.getShareNum());
            QFSSchemaTransitionInfo.VideoInfo videoInfo = feedInfo.getVideoInfo();
            if (videoInfo != null) {
                feed.video.setHasFlag(true);
                feed.video.fileId.set(videoInfo.getId());
                feed.video.playUrl.set(videoInfo.getPlayUrl());
                feed.video.duration.set((int) videoInfo.getDuration());
                feed.video.isQuic.set(videoInfo.getIsQUICVideo() ? 1 : 0);
            }
        }
        qCircleLayerBean.setFeed(feed);
    }

    private void w(@NonNull QCircleLayerBean qCircleLayerBean, @NonNull HashMap<String, String> hashMap) {
        if (TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.OPEN_ONLY_COMMENT_KEYBOARD), "1")) {
            QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
            qCircleActionBean.mOnlyShowCommentKeyboard = true;
            qCircleLayerBean.setActionBean(qCircleActionBean);
            QLog.d("QCircleBaseSchemeParser", 1, "[parseCommentAndReplyData] open only comment Keyboard.");
            return;
        }
        String str = hashMap.get(QCircleSchemeAttr.Detail.COMMENT_ID);
        boolean equals = TextUtils.equals(hashMap.get(QCircleSchemeAttr.Detail.OPEN_COMMENT_LIST), "1");
        if (TextUtils.isEmpty(str) && !equals) {
            return;
        }
        QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
        QCircleInitBean.QCircleActionBean qCircleActionBean2 = new QCircleInitBean.QCircleActionBean();
        qCircleActionBean2.mShowCommentPanel = true;
        if (!TextUtils.isEmpty(str)) {
            qCircleActionBean2.mItemTopAnimationCommentId = str;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = qQCircleFeedBase$StBusiInfoCommentListData.comment;
        feedCloudMeta$StComment.setHasFlag(true);
        if (!TextUtils.isEmpty(str)) {
            feedCloudMeta$StComment.f398447id.set(str);
        }
        String str2 = hashMap.get(QCircleSchemeAttr.Detail.COMMENT_USER_ID);
        if (!TextUtils.isEmpty(str2)) {
            feedCloudMeta$StComment.postUser.setHasFlag(true);
            feedCloudMeta$StComment.postUser.f398463id.set(str2);
            qCircleActionBean2.mShowInputKeyboard = uq3.c.W();
        }
        String str3 = hashMap.get(QCircleSchemeAttr.Detail.REPLY_ID);
        if (!TextUtils.isEmpty(str3)) {
            qCircleActionBean2.mItemTopAnimationReplyId = str3;
            FeedCloudMeta$StReply feedCloudMeta$StReply = qQCircleFeedBase$StBusiInfoCommentListData.reply;
            feedCloudMeta$StReply.setHasFlag(true);
            feedCloudMeta$StReply.f398460id.set(str3);
            String str4 = hashMap.get(QCircleSchemeAttr.Detail.REPLY_USER_ID);
            if (!TextUtils.isEmpty(str4)) {
                feedCloudMeta$StReply.postUser.setHasFlag(true);
                feedCloudMeta$StReply.postUser.f398463id.set(str4);
            } else {
                qCircleActionBean2.mShowInputKeyboard = false;
            }
        }
        qCircleLayerBean.setBusiInfoData(qQCircleFeedBase$StBusiInfoCommentListData.toByteArray());
        qCircleLayerBean.setActionBean(qCircleActionBean2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(HashMap<String, String> hashMap, QCircleLayerBean qCircleLayerBean) {
        int parseInt;
        boolean z16;
        boolean z17;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        if (hashMap.containsKey("feedid")) {
            feedCloudMeta$StFeed.f398449id.set(hashMap.get("feedid"));
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.COVER_PIC_URL)) {
            feedCloudMeta$StFeed.cover.picUrl.set(hashMap.get(QCircleSchemeAttr.Detail.COVER_PIC_URL));
        }
        if (hashMap.containsKey("createtime") && !TextUtils.isEmpty(hashMap.get("createtime"))) {
            try {
                feedCloudMeta$StFeed.createTime.set(Long.parseLong(hashMap.get("createtime")));
            } catch (Exception e16) {
                QLog.d("QCircleBaseSchemeParser", 1, "[scheme] create time parse error. " + e16.toString());
            }
        }
        if (hashMap.containsKey("uin")) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(hashMap.get("uin"));
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        }
        boolean z18 = false;
        if (hashMap.containsKey("sourcetype")) {
            try {
                parseInt = Integer.parseInt(hashMap.get("sourcetype"));
            } catch (Exception e17) {
                QLog.d("QCircleBaseSchemeParser", 1, "[scheme] source parse error. " + e17.toString());
            }
            if (!hashMap.containsKey(QCircleSchemeAttr.Detail.IS_SINGLE_FEED)) {
                z16 = "1".equals(hashMap.get(QCircleSchemeAttr.Detail.IS_SINGLE_FEED));
            } else {
                z16 = false;
            }
            if (!hashMap.containsKey(QCircleSchemeAttr.Detail.IS_TAG)) {
                z17 = "1".equals(hashMap.get(QCircleSchemeAttr.Detail.IS_TAG));
            } else {
                z17 = false;
            }
            if (!hashMap.containsKey("tagname")) {
                str = hashMap.get("tagname");
            } else {
                str = "";
            }
            if (hashMap.containsKey("getfeedlist")) {
                z18 = "1".equals(hashMap.get("getfeedlist"));
            }
            if (hashMap.containsKey(QCircleSchemeAttr.Detail.DISABLE_FOOT)) {
                qCircleLayerBean.setDisableFoot("1".equals(hashMap.get(QCircleSchemeAttr.Detail.DISABLE_FOOT)));
            }
            QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
            qCircleExtraTypeInfo.sourceType = parseInt;
            qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
            if (z17 && !TextUtils.isEmpty(str)) {
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
                feedCloudMeta$StTagInfo.tagName.set(str);
                qCircleLayerBean.setTagInfo(feedCloudMeta$StTagInfo);
            }
            qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
            qCircleLayerBean.setSingleFeed(z16);
            qCircleLayerBean.setGetFeedList(z18);
            if (hashMap.containsKey(QCircleSchemeAttr.Detail.FROM_ELEMENT)) {
                QCircleReportBean qCircleReportBean = new QCircleReportBean();
                qCircleReportBean.setFromElement(hashMap.get(QCircleSchemeAttr.Detail.FROM_ELEMENT));
                qCircleLayerBean.setFromReportBean(qCircleReportBean);
            }
            if (hashMap.containsKey(QCircleSchemeAttr.Detail.VIEW_MODEL_KEY)) {
                qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
                qCircleLayerBean.setGlobalViewModelKey(hashMap.get(QCircleSchemeAttr.Detail.VIEW_MODEL_KEY));
            }
            z(qCircleLayerBean, parseInt);
        }
        parseInt = 0;
        if (!hashMap.containsKey(QCircleSchemeAttr.Detail.IS_SINGLE_FEED)) {
        }
        if (!hashMap.containsKey(QCircleSchemeAttr.Detail.IS_TAG)) {
        }
        if (!hashMap.containsKey("tagname")) {
        }
        if (hashMap.containsKey("getfeedlist")) {
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.DISABLE_FOOT)) {
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo2.sourceType = parseInt;
        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
        if (z17) {
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo2 = new FeedCloudMeta$StTagInfo();
            feedCloudMeta$StTagInfo2.tagName.set(str);
            qCircleLayerBean.setTagInfo(feedCloudMeta$StTagInfo2);
        }
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo2);
        qCircleLayerBean.setSingleFeed(z16);
        qCircleLayerBean.setGetFeedList(z18);
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.FROM_ELEMENT)) {
        }
        if (hashMap.containsKey(QCircleSchemeAttr.Detail.VIEW_MODEL_KEY)) {
        }
        z(qCircleLayerBean, parseInt);
    }

    private void y(HashMap<String, String> hashMap, QCircleLayerBean qCircleLayerBean) {
        qCircleLayerBean.setFeed(p(hashMap));
    }

    private static void z(@NonNull QCircleLayerBean qCircleLayerBean, int i3) {
        if (i3 == 8) {
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setTransInitBean(new QCircleInitBean());
            qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
            qCircleLayerBean.setGlobalViewModelKey("key_personal_detail_source");
            qCircleLayerBean.setFromPage(1);
        }
    }

    protected void H(final Context context, final QCircleLayerBean qCircleLayerBean, final Intent intent) {
        HashMap<String, String> schemeAttrs = qCircleLayerBean.getSchemeAttrs();
        if (schemeAttrs != null && o50.e.P9()) {
            final QFSSchemaTransitionInfo B = B(schemeAttrs);
            String coverPath = B.getCoverPath();
            v(qCircleLayerBean, B);
            F(qCircleLayerBean);
            if (TextUtils.isEmpty(coverPath)) {
                QCircleLauncherUtil.q(context, intent, true);
                return;
            } else if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.g(qCircleLayerBean)) {
                I(context, qCircleLayerBean, intent, B);
                return;
            } else {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(coverPath), new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser.2
                    @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                    public void onStateChange(final LoadState loadState, final Option option) {
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QLog.d("TM-QCircleBaseSchemeParser", 1, "startSchemaTransitionAnimActivity  onStateChang state = " + loadState);
                                LoadState loadState2 = loadState;
                                if (loadState2 == LoadState.STATE_SUCCESS) {
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                                    TransitionAnimUtil.saveCoverDrawable(bitmapDrawable);
                                    QLog.i("QCircleBaseSchemeParser", 1, "startSchemaTransitionAnimActivity resultDrawable=" + bitmapDrawable);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    QCircleContentDetailSchemeParser.this.I(context, qCircleLayerBean, intent, B);
                                    return;
                                }
                                if (loadState2 == LoadState.STATE_DECODE_FAILED || loadState2 == LoadState.STATE_DOWNLOAD_FAILED || loadState2 == LoadState.STATE_CANCEL || loadState2 == LoadState.STATE_URL_ILLEGAL) {
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    QCircleLauncherUtil.q(context, intent, true);
                                }
                            }
                        });
                    }
                });
                return;
            }
        }
        QCircleLauncherUtil.q(context, intent, true);
    }

    public QCircleLayerBean K(QCircleSchemeBean qCircleSchemeBean) {
        HashMap<String, String> attrs = qCircleSchemeBean.getAttrs();
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        b(qCircleSchemeBean, qCircleLayerBean);
        i(qCircleLayerBean, attrs);
        j(qCircleLayerBean, attrs);
        x(attrs, qCircleLayerBean);
        w(qCircleLayerBean, attrs);
        C(qCircleLayerBean, attrs);
        A(qCircleLayerBean, attrs);
        y(attrs, qCircleLayerBean);
        return qCircleLayerBean;
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(Context context, QCircleSchemeBean qCircleSchemeBean) {
        Activity topActivity;
        if (!(context instanceof Activity) && (topActivity = ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getTopActivity()) != null && !topActivity.isFinishing()) {
            context = topActivity;
        }
        if (qCircleSchemeBean.getEnterTime() <= 0) {
            qCircleSchemeBean.setEnterTime(System.currentTimeMillis());
        }
        s(context, qCircleSchemeBean);
    }

    public Intent q(Context context, QCircleLayerBean qCircleLayerBean) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.d(qCircleLayerBean)) {
            intent.addFlags(603979776);
        }
        intent.setClass(context, QCircleTransFragmentActivity.class);
        intent.putExtra("public_fragment_class", QCircleLauncherUtil.d());
        intent.putExtra("key_bundle_common_init_bean", qCircleLayerBean);
        return intent;
    }

    public void t(Context context, QCircleLayerBean qCircleLayerBean) {
        if (fb0.a.b("QCircleBaseSchemeParser_launchContentDetailPage", 500L)) {
            return;
        }
        QLog.d("QCircleBaseSchemeParser", 1, "[launchContentLayerPageByScheme]");
        H(context, qCircleLayerBean, q(context, qCircleLayerBean));
    }
}
