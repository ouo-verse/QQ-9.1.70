package com.tencent.mobileqq.qcircle.api.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountDetailPageLaunchInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0004H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\tH\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0004H\u0002\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\t\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0001H\u0002\u00a8\u0006\f"}, d2 = {"consumed", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "getRedDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "hasUnreadMsg", "", "toBriefString", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "toQCirclePublicAccountMessageInfo", "tryExchangedUrl", "qcircle-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountMessageServiceImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final QCirclePublicAccountMessageInfo consumed(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        QCirclePublicAccountMessageInfo copy;
        QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo = new QCirclePublicAccountDetailPageLaunchInfo(null, null, null, null, null, null, null, null, null, 0, 1023, null);
        String launchInfoStr = qCirclePublicAccountMessageInfo.getLaunchInfoStr();
        if (launchInfoStr == null) {
            launchInfoStr = "";
        }
        QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr = qCirclePublicAccountDetailPageLaunchInfo.parseFromJSONStr(launchInfoStr);
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        QRouteApi api = QRoute.api(IQCirclePublicAccountLauncher.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQCirclePublicAccountLauncher::class.java)");
        copy = qCirclePublicAccountMessageInfo.copy((r24 & 1) != 0 ? qCirclePublicAccountMessageInfo.feedId : null, (r24 & 2) != 0 ? qCirclePublicAccountMessageInfo.isLocal : bool, (r24 & 4) != 0 ? qCirclePublicAccountMessageInfo.receiveTimeSec : null, (r24 & 8) != 0 ? qCirclePublicAccountMessageInfo.redDotType : 1, (r24 & 16) != 0 ? qCirclePublicAccountMessageInfo.hasOrangeWord : bool2, (r24 & 32) != 0 ? qCirclePublicAccountMessageInfo.jumpUrl : IQCirclePublicAccountLauncher.a.a((IQCirclePublicAccountLauncher) api, parseFromJSONStr, false, 2, null), (r24 & 64) != 0 ? qCirclePublicAccountMessageInfo.reportData : null, (r24 & 128) != 0 ? qCirclePublicAccountMessageInfo.videoPlayUrl : "", (r24 & 256) != 0 ? qCirclePublicAccountMessageInfo.coverUrl : "", (r24 & 512) != 0 ? qCirclePublicAccountMessageInfo.launchInfoStr : null, (r24 & 1024) != 0 ? qCirclePublicAccountMessageInfo.id : null);
        return copy;
    }

    @NotNull
    public static final QCirclePublicAccountRedDotType getRedDotType(@Nullable RecentContactInfo recentContactInfo) {
        if (recentContactInfo == null) {
            return new QCirclePublicAccountRedDotType.NoneRedDot(0L);
        }
        boolean z16 = true;
        if (((int) recentContactInfo.unreadFlag) != 1) {
            z16 = false;
        }
        long j3 = recentContactInfo.unreadCnt;
        if (j3 > 0) {
            return new QCirclePublicAccountRedDotType.NumRedDot(j3);
        }
        if (z16) {
            return new QCirclePublicAccountRedDotType.NormalRedDot(-1L);
        }
        return new QCirclePublicAccountRedDotType.NoneRedDot(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasUnreadMsg(RecentContactInfo recentContactInfo) {
        boolean z16;
        if (recentContactInfo == null) {
            return false;
        }
        if (((int) recentContactInfo.unreadFlag) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && recentContactInfo.unreadCnt <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toBriefString(RecentContactInfo recentContactInfo) {
        if (recentContactInfo == null) {
            return "RecentContactInfo=null";
        }
        return "RecentContactInfo(id=" + recentContactInfo.f359204id + " msgId=" + recentContactInfo.msgId + " msgTime=" + recentContactInfo.msgTime + "chatType=" + recentContactInfo.chatType + " peerUin=" + recentContactInfo.peerUin + " peerName=" + recentContactInfo.peerName + " unReadCont=" + recentContactInfo.unreadCnt + " unreadFlag=" + recentContactInfo.unreadFlag + " )";
    }

    @Nullable
    public static final QCirclePublicAccountMessageInfo toQCirclePublicAccountMessageInfo(@NotNull MsgRecord msgRecord) {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String jSONStr;
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo;
        String coverUrl;
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo2;
        QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo;
        String playUrl;
        String reportData;
        String feedId;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        QRouteApi api = QRoute.api(IPublicAccountMsgExtMrg.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountMsgExtMrg::class.java)");
        IPublicAccountMsgExtMrg iPublicAccountMsgExtMrg = (IPublicAccountMsgExtMrg) api;
        String originalParam = iPublicAccountMsgExtMrg.getOriginalParam(iPublicAccountMsgExtMrg.getBusiIdExtra(msgRecord));
        boolean z17 = false;
        if (originalParam.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i(QCirclePublicAccountMessageServiceImpl.TAG, 1, "toQCirclePublicAccountMessageInfo: get message without extra info");
            return null;
        }
        int i3 = 2;
        if (QLog.isDebugVersion()) {
            QLog.d(QCirclePublicAccountMessageServiceImpl.TAG, 2, "toQCirclePublicAccountMessageInfo actionData=" + originalParam);
        }
        JsonObject jsonObject = (JsonObject) new Gson().fromJson(originalParam, JsonObject.class);
        if (!jsonObject.has("ow")) {
            str = "";
        } else {
            str = jsonObject.get("ow").getAsString();
        }
        if (!jsonObject.has("rdt")) {
            str2 = "0";
        } else {
            str2 = jsonObject.get("rdt").getAsString();
        }
        boolean areEqual = Intrinsics.areEqual(str2, "0");
        long j3 = msgRecord.msgTime;
        if (areEqual) {
            i3 = 3;
        }
        int i16 = i3;
        QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr = new QCirclePublicAccountDetailPageLaunchInfo(null, null, null, null, null, null, null, null, null, 0, 1023, null).parseFromJSONStr(originalParam);
        if (parseFromJSONStr == null || (feedId = parseFromJSONStr.getFeedId()) == null) {
            str3 = "";
        } else {
            str3 = feedId;
        }
        Boolean bool = Boolean.FALSE;
        Long valueOf = Long.valueOf(j3);
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        Boolean valueOf2 = Boolean.valueOf(!z17);
        String jumpUrl = ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).getJumpUrl(parseFromJSONStr, true);
        if (parseFromJSONStr == null || (reportData = parseFromJSONStr.getReportData()) == null) {
            str4 = "";
        } else {
            str4 = reportData;
        }
        if (parseFromJSONStr == null || (feedInfo2 = parseFromJSONStr.getFeedInfo()) == null || (videoInfo = feedInfo2.getVideoInfo()) == null || (playUrl = videoInfo.getPlayUrl()) == null) {
            str5 = "";
        } else {
            str5 = playUrl;
        }
        if (parseFromJSONStr == null || (feedInfo = parseFromJSONStr.getFeedInfo()) == null || (coverUrl = feedInfo.getCoverUrl()) == null) {
            str6 = "";
        } else {
            str6 = coverUrl;
        }
        if (parseFromJSONStr == null || (jSONStr = parseFromJSONStr.toJSONStr()) == null) {
            str7 = "";
        } else {
            str7 = jSONStr;
        }
        QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = new QCirclePublicAccountMessageInfo(str3, bool, valueOf, i16, valueOf2, jumpUrl, str4, str5, str6, str7, null, 1024, null);
        QLog.i(QCirclePublicAccountMessageServiceImpl.TAG, 1, "toQCirclePublicAccountMessageInfo=" + toBriefString(qCirclePublicAccountMessageInfo));
        return qCirclePublicAccountMessageInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QCirclePublicAccountMessageInfo tryExchangedUrl(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        String str;
        String str2;
        QCirclePublicAccountMessageInfo copy;
        QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo;
        if (!Intrinsics.areEqual(k.a().h(QCirclePublicAccountMessageServiceImpl.KEY_LAST_EXCHANGED_URL_MESSAGE_INFO_ID, ""), qCirclePublicAccountMessageInfo.getId())) {
            return qCirclePublicAccountMessageInfo;
        }
        String launchInfoStr = k.a().h(QCirclePublicAccountMessageServiceImpl.KEY_LAST_EXCHANGED_URL_LAUNCH_INFO, "");
        QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo = new QCirclePublicAccountDetailPageLaunchInfo(null, null, null, null, null, null, null, null, null, 0, 1023, null);
        Intrinsics.checkNotNullExpressionValue(launchInfoStr, "launchInfoStr");
        QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr = qCirclePublicAccountDetailPageLaunchInfo.parseFromJSONStr(launchInfoStr);
        if (parseFromJSONStr == null) {
            return qCirclePublicAccountMessageInfo;
        }
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo = parseFromJSONStr.getFeedInfo();
        if (feedInfo == null || (videoInfo = feedInfo.getVideoInfo()) == null || (str = videoInfo.getPlayUrl()) == null) {
            str = "";
        }
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo2 = parseFromJSONStr.getFeedInfo();
        if (feedInfo2 == null || (str2 = feedInfo2.getCoverUrl()) == null) {
            str2 = "";
        }
        copy = qCirclePublicAccountMessageInfo.copy((r24 & 1) != 0 ? qCirclePublicAccountMessageInfo.feedId : null, (r24 & 2) != 0 ? qCirclePublicAccountMessageInfo.isLocal : null, (r24 & 4) != 0 ? qCirclePublicAccountMessageInfo.receiveTimeSec : null, (r24 & 8) != 0 ? qCirclePublicAccountMessageInfo.redDotType : 0, (r24 & 16) != 0 ? qCirclePublicAccountMessageInfo.hasOrangeWord : null, (r24 & 32) != 0 ? qCirclePublicAccountMessageInfo.jumpUrl : null, (r24 & 64) != 0 ? qCirclePublicAccountMessageInfo.reportData : null, (r24 & 128) != 0 ? qCirclePublicAccountMessageInfo.videoPlayUrl : str, (r24 & 256) != 0 ? qCirclePublicAccountMessageInfo.coverUrl : str2, (r24 & 512) != 0 ? qCirclePublicAccountMessageInfo.launchInfoStr : parseFromJSONStr.toJSONStr(), (r24 & 1024) != 0 ? qCirclePublicAccountMessageInfo.id : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toBriefString(MsgRecord msgRecord) {
        if (msgRecord == null) {
            return "MsgRecord=null";
        }
        return "MsgRecord(id=" + msgRecord.msgId + " msgTime=" + msgRecord.msgTime + " chatType=" + msgRecord.chatType + " peerUin=" + msgRecord.peerUin + " peerName=" + msgRecord.peerName + " )";
    }

    private static final String toBriefString(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        if (qCirclePublicAccountMessageInfo == null) {
            return "MsgRecord=null";
        }
        return "QCirclePublicAccountMessageInfo(id=" + qCirclePublicAccountMessageInfo.getId() + " feedId=" + qCirclePublicAccountMessageInfo.getFeedId() + " isLocal=" + qCirclePublicAccountMessageInfo.isLocal() + " receiveTime=" + qCirclePublicAccountMessageInfo.getReceiveTimeSec() + " hasOw=" + qCirclePublicAccountMessageInfo.getHasOrangeWord() + " )";
    }
}
