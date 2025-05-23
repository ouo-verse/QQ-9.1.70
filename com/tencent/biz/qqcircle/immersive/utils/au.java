package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.IReplyMsgWithSourceMsgInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SourceMsgInfoForReplyMsg;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import feedcloud.DstUinType;
import feedcloud.FeedCloudMeta$MessageInfo;
import feedcloud.FeedCloudMeta$RightInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.MessageInfo;
import feedcloud.ShareMessageInfo;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class au {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements RecentContactListener {
        a() {
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> list) {
            int i3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getRecentChatGroupList] size:");
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            QLog.d("QFSShareInfoUtils", 1, sb5.toString());
        }
    }

    public static ShareMessageInfo a(String str, MsgRecord msgRecord) {
        if (msgRecord != null && !TextUtils.isEmpty(str)) {
            ShareMessageInfo.a aVar = new ShareMessageInfo.a();
            aVar.d(str).f(String.valueOf(msgRecord.getSenderUin())).b(String.valueOf(msgRecord.getPeerUin())).c(DstUinType.fromValue(msgRecord.getChatType()));
            MessageInfo.a aVar2 = new MessageInfo.a();
            aVar2.f(msgRecord.getMsgTime()).d(msgRecord.getMsgRandom()).e(msgRecord.getMsgSeq()).c(msgRecord.getClientSeq()).b(msgRecord.getChatType()).g(msgRecord.getPeerUid()).h(msgRecord.getSenderUid());
            aVar.e(aVar2.build());
            return aVar.build();
        }
        return null;
    }

    public static SourceMsgInfoForReplyMsg b(FeedCloudMeta$MessageInfo feedCloudMeta$MessageInfo) {
        if (feedCloudMeta$MessageInfo == null) {
            return null;
        }
        SourceMsgInfoForReplyMsg sourceMsgInfoForReplyMsg = new SourceMsgInfoForReplyMsg();
        sourceMsgInfoForReplyMsg.chatType = feedCloudMeta$MessageInfo.chatType.get();
        sourceMsgInfoForReplyMsg.peerUid = feedCloudMeta$MessageInfo.peerUID.get();
        sourceMsgInfoForReplyMsg.senderUid = feedCloudMeta$MessageInfo.senderUID.get();
        sourceMsgInfoForReplyMsg.msgTime = feedCloudMeta$MessageInfo.msgTime.get();
        sourceMsgInfoForReplyMsg.msgRandom = feedCloudMeta$MessageInfo.msgRandom.get();
        sourceMsgInfoForReplyMsg.msgSeq = feedCloudMeta$MessageInfo.msgSeq.get();
        sourceMsgInfoForReplyMsg.clientSeq = feedCloudMeta$MessageInfo.clientSeq.get();
        return sourceMsgInfoForReplyMsg;
    }

    public static QCircleShareInfo c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.extraTypeInfo = new QCircleExtraTypeInfo();
        if (feedCloudMeta$StFeed == null) {
            return qCircleShareInfo;
        }
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.type = 0;
        qCircleShareInfo.isShowBarrageSwitch = false;
        qCircleShareInfo.isShareBottomBarrageSwitch = o.e(feedCloudMeta$StFeed);
        if (QCirclePluginUtil.isFeedOwner(qCircleShareInfo.feed)) {
            qCircleShareInfo.isShowDelete = true;
            if (r.Z(feedCloudMeta$StFeed)) {
                qCircleShareInfo.isShowFeedBindQQGroup = true;
            }
            m(qCircleShareInfo, feedCloudMeta$StFeed);
        } else {
            qCircleShareInfo.isShowReport = true;
            l(qCircleShareInfo, feedCloudMeta$StFeed);
        }
        if (feedCloudMeta$StFeed.opMask2.get().contains(25)) {
            qCircleShareInfo.isShowUnCollect = true;
        } else {
            qCircleShareInfo.isShowCollect = true;
        }
        qCircleShareInfo.isShowDisLike = false;
        qCircleShareInfo.isShowHideThisWork = false;
        t(feedCloudMeta$StFeed, qCircleShareInfo);
        q(feedCloudMeta$StFeed, qCircleShareInfo);
        r(feedCloudMeta$StFeed, qCircleShareInfo);
        o(feedCloudMeta$StFeed, qCircleShareInfo);
        n(feedCloudMeta$StFeed, qCircleShareInfo);
        p(feedCloudMeta$StFeed, qCircleShareInfo);
        u(feedCloudMeta$StFeed, qCircleShareInfo);
        s(qCircleShareInfo);
        e(qCircleShareInfo);
        return qCircleShareInfo;
    }

    public static void d(String str, SourceMsgInfoForReplyMsg sourceMsgInfoForReplyMsg, IReplyMsgWithSourceMsgInfoCallback iReplyMsgWithSourceMsgInfoCallback) {
        com.tencent.qqnt.kernel.api.w e16;
        if (TextUtils.isEmpty(str) || sourceMsgInfoForReplyMsg == null || (e16 = com.tencent.qqnt.msg.f.e()) == null) {
            return;
        }
        e16.replyMsgWithSourceMsgInfo(sourceMsgInfoForReplyMsg, ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getForwardCommentElement(str), new HashMap<>(), iReplyMsgWithSourceMsgInfoCallback);
    }

    private static void e(QCircleShareInfo qCircleShareInfo) {
        qCircleShareInfo.isShowStick = false;
        qCircleShareInfo.isShowUnStick = false;
        qCircleShareInfo.isShowReport = false;
        qCircleShareInfo.isShowDeletePush = false;
        qCircleShareInfo.isShowDeletePushDisable = false;
        qCircleShareInfo.isShowPersonalQrcode = false;
        qCircleShareInfo.isShowPersonalQrcodeDown = false;
        qCircleShareInfo.isShowSetToPublicPermission = false;
        qCircleShareInfo.isShowSetToPrivatePermission = false;
        qCircleShareInfo.isShowDeleteAndEditAlbum = false;
        qCircleShareInfo.isShowCollect = false;
        qCircleShareInfo.isShowUnCollect = false;
        qCircleShareInfo.isShowFeedback = false;
        qCircleShareInfo.isNotAllowDownload = false;
        qCircleShareInfo.isShowCopySchemaLink = false;
        qCircleShareInfo.isShowFeedBindQQGroup = false;
        qCircleShareInfo.isShowBackgroundMusic = false;
        qCircleShareInfo.isShowCopyContent = false;
        qCircleShareInfo.isShowDisLike = false;
        qCircleShareInfo.isShowHideThisWork = false;
        qCircleShareInfo.isShowQCircleEnterFloatingWindow = false;
        qCircleShareInfo.isShowBarrageSwitch = false;
        qCircleShareInfo.isShowWatchLater = false;
        qCircleShareInfo.isShowSetQQProfileCover = false;
        qCircleShareInfo.isShowCopyShortLink = false;
    }

    public static String f() {
        List<RecentUser> recentListFromCache = ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentListFromCache();
        if (RFSafeListUtils.isEmpty(recentListFromCache)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (int i16 = 0; i16 < recentListFromCache.size(); i16++) {
            RecentUser recentUser = recentListFromCache.get(i16);
            if (recentUser != null && recentUser.type == 1) {
                sb5.append(recentUser.troopUin);
                sb5.append(",");
                i3++;
                if (i3 >= 5) {
                    break;
                }
            }
        }
        if (sb5.length() > 0 && sb5.charAt(sb5.length() - 1) == ',') {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        QLog.d("QFSShareInfoUtils", 1, "[getRecentChatGroupList] recentGroupList:" + sb5.toString());
        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(QCircleServiceImpl.getAppRunTime(), new a(), false);
        return sb5.toString();
    }

    public static void g() {
        long f16 = uq3.k.a().f("sp_key_share_fast_reply_last_show_timestamp", 0L);
        if (f16 != 0 && uq3.n.c(System.currentTimeMillis(), f16)) {
            int e16 = uq3.k.a().e("sp_key_share_fast_reply_showed_count", 0);
            uq3.k.a().n("sp_key_share_fast_reply_last_show_timestamp", System.currentTimeMillis());
            uq3.k.a().m("sp_key_share_fast_reply_showed_count", e16 + 1);
        } else {
            uq3.k.a().n("sp_key_share_fast_reply_last_show_timestamp", System.currentTimeMillis());
            uq3.k.a().m("sp_key_share_fast_reply_showed_count", 1);
        }
    }

    public static boolean h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    public static Pair<Boolean, Integer> i() {
        int i3;
        long f16 = uq3.k.a().f("sp_key_share_fast_reply_last_show_timestamp", 0L);
        boolean z16 = false;
        if (f16 == 0) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        if (!uq3.n.c(System.currentTimeMillis(), f16)) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        int e16 = uq3.k.a().e("sp_key_share_fast_reply_showed_count", 0);
        try {
            i3 = Integer.parseInt(uq3.o.z0("102954", "show_count_one_day", "3"));
        } catch (Exception e17) {
            QLog.e("QFSShareInfoUtils", 1, "[isShareFastReplyArriveMaxTime] e:" + e17);
            i3 = 3;
        }
        if (e16 >= i3) {
            z16 = true;
        }
        return new Pair<>(Boolean.valueOf(z16), Integer.valueOf(e16));
    }

    public static boolean j(QCircleShareInfo qCircleShareInfo) {
        if (qCircleShareInfo == null) {
            return false;
        }
        if (com.tencent.biz.qqcircle.helpers.d.a(1, false)) {
            QLog.d("QFSShareInfoUtils", 1, "[needShowSetQQProfileCoverActionSheet] scene beat.");
            return false;
        }
        int i3 = qCircleShareInfo.source;
        if ((i3 != 1 && i3 != 2) || h(qCircleShareInfo.feed) || y.f(qCircleShareInfo.feed)) {
            return false;
        }
        return !cq.f92752a.s(qCircleShareInfo.feed);
    }

    public static boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && feedCloudMeta$StLiteBanner.business_type.get() == 17) {
            return true;
        }
        return false;
    }

    public static void l(QCircleShareInfo qCircleShareInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StRight feedCloudMeta$StRight;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StRight = feedCloudMeta$StFeed.right) != null) {
            qCircleShareInfo.isNotAllowDownload = feedCloudMeta$StRight.notAllowDownLoad.get();
        }
    }

    public static void m(QCircleShareInfo qCircleShareInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StRight feedCloudMeta$StRight;
        FeedCloudMeta$RightInfo feedCloudMeta$RightInfo;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StRight = feedCloudMeta$StFeed.right) != null && (feedCloudMeta$RightInfo = feedCloudMeta$StRight.ugcRight) != null) {
            long j3 = feedCloudMeta$RightInfo.rightFlag.get();
            if (j3 != 1 && j3 != 0) {
                if (j3 == 2) {
                    qCircleShareInfo.isShowSetToPublicPermission = true;
                    return;
                }
                return;
            }
            qCircleShareInfo.isShowSetToPrivatePermission = true;
        }
    }

    private static void n(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleShareInfo qCircleShareInfo) {
        if (qCircleShareInfo == null || !p40.n.e().m(feedCloudMeta$StFeed)) {
            return;
        }
        uq3.c.M6();
    }

    private static void o(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QCircleShareInfo qCircleShareInfo) {
        List<Integer> list = feedCloudMeta$StFeed.opMask2.get();
        if (list != null) {
            if ((list.contains(13) || list.contains(28)) && QCircleApplication.isRDMVersion()) {
                qCircleShareInfo.isShowFeedback = true;
            }
        }
    }

    private static void p(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QCircleShareInfo qCircleShareInfo) {
        boolean z16;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.musicInfo.get().show_mask.get().contains(2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        qCircleShareInfo.isShowBackgroundMusic = z16;
    }

    private static void q(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QCircleShareInfo qCircleShareInfo) {
        boolean z16;
        List<Integer> list = feedCloudMeta$StFeed.opMask2.get();
        if (list != null) {
            boolean z17 = false;
            if (!QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get()) && list.contains(1)) {
                z16 = true;
            } else {
                z16 = false;
            }
            qCircleShareInfo.isShowHideThisWork = z16;
            if (QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get()) && list.contains(10)) {
                z17 = true;
            }
            qCircleShareInfo.isShowDownLoad = z17;
        }
    }

    private static void r(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleShareInfo qCircleShareInfo) {
        float t16 = QCirclePluginGlobalInfo.t(feedCloudMeta$StFeed.f398449id.get());
        int e16 = com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed);
        if ((e16 == 1003 || e16 == 4003) && uq3.c.S()) {
            qCircleShareInfo.isShowPlayRate = true;
            qCircleShareInfo.mPlayRate = t16;
        }
    }

    private static void s(@NonNull QCircleShareInfo qCircleShareInfo) {
        if (!com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSShareInfoUtils", 1, "[updateSencebeat] is not sencebeat");
            return;
        }
        qCircleShareInfo.isShowStick = false;
        qCircleShareInfo.isShowUnStick = false;
        qCircleShareInfo.isShowDelete = false;
        qCircleShareInfo.isShowReport = false;
        qCircleShareInfo.isShowDeletePush = false;
        qCircleShareInfo.isShowDeletePushDisable = false;
        qCircleShareInfo.isShowPersonalQrcode = false;
        qCircleShareInfo.isShowPersonalQrcodeDown = false;
        qCircleShareInfo.isShowSetToPublicPermission = false;
        qCircleShareInfo.isShowSetToPrivatePermission = false;
        qCircleShareInfo.isShowDeleteAndEditAlbum = false;
        qCircleShareInfo.isShowCollect = false;
        qCircleShareInfo.isShowUnCollect = false;
        qCircleShareInfo.isShowFeedback = false;
        qCircleShareInfo.isNotAllowDownload = false;
        qCircleShareInfo.isShowCopySchemaLink = false;
        qCircleShareInfo.isShowFeedBindQQGroup = false;
        qCircleShareInfo.isShowBackgroundMusic = false;
        qCircleShareInfo.isShowCopyContent = false;
        qCircleShareInfo.isShowDisLike = true;
        qCircleShareInfo.isShowHideThisWork = false;
        qCircleShareInfo.isShowDownLoad = true;
        qCircleShareInfo.isShowQCircleEnterFloatingWindow = true;
    }

    private static void t(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QCircleShareInfo qCircleShareInfo) {
        boolean z16;
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            List<Integer> list = qQCircleFeedBase$StFeedBusiReqData.uninterest_buttons.get();
            if (list != null && list.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            qCircleShareInfo.isShowDisLike = z16;
            FeedCloudMeta$StPushList feedCloudMeta$StPushList = qQCircleFeedBase$StFeedBusiReqData.pushList;
            if (feedCloudMeta$StPushList != null && feedCloudMeta$StPushList.hasClickCount.get() > 0) {
                qCircleShareInfo.isShowDeletePush = true;
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSShareInfoUtils", 1, "[createShareInfo] error: ", e16);
        }
    }

    private static void u(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull QCircleShareInfo qCircleShareInfo) {
        if (QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed)) {
            return;
        }
        if (feedCloudMeta$StFeed.type.get() != 3) {
            QLog.d("QFSShareInfoUtils", 1, "[updateWatchLaterValue] not video type, return.");
        } else if (feedCloudMeta$StFeed.opMask2.get().contains(60)) {
            qCircleShareInfo.isShowCancelWatchLater = true;
        } else {
            qCircleShareInfo.isShowWatchLater = true;
        }
    }
}
