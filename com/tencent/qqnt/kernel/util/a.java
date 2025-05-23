package com.tencent.qqnt.kernel.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.AdelieMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.AttaReportData;
import com.tencent.qqnt.kernel.nativeinterface.ExtendBusinessAttr;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupHonor;
import com.tencent.qqnt.kernel.nativeinterface.KingHonor;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionAttr;
import com.tencent.qqnt.kernel.nativeinterface.LongMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.MemoryStateMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountAttrs;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import com.tencent.qqnt.kernel.nativeinterface.RobotMsgExt;
import com.tencent.qqnt.kernel.nativeinterface.SendMsgRspTransSvrInfoAttr;
import com.tencent.qqnt.kernel.nativeinterface.SharedMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.UinInfoAttr;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.ZPlanMsgElement;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J'\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u00f0\u0001\u0010/\u001a\u00020.2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$\u0018\u00010#2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,J\u009d\u0002\u00104\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020.2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$\u0018\u00010#2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,2\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/kernel/util/a;", "", "T", "data", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "e", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "attrType", "", "attrId", "Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgElement;", "vasMsgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/VASAIOPersonalElement;", "vasPersonalInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupHonor;", "groupHonor", "Lcom/tencent/qqnt/kernel/nativeinterface/KingHonor;", "kingHonor", "Lcom/tencent/qqnt/kernel/nativeinterface/PublicAccountAttrs;", "publicAccountAttrs", "Lcom/tencent/qqnt/kernel/nativeinterface/SharedMsgInfo;", "sharedMsgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "gameChatSession", "Lcom/tencent/qqnt/kernel/nativeinterface/UinInfoAttr;", "uinInfoAttr", "Lcom/tencent/qqnt/kernel/nativeinterface/LongMsgAttr;", "longMsgAttr", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMsgExt;", "robotExt", "Lcom/tencent/qqnt/kernel/nativeinterface/ZPlanMsgElement;", "zPlanMsgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/QQConnectAttr;", "qqConnectAttr", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/ExtendBusinessAttr;", "extendBusiness", "Lcom/tencent/qqnt/kernel/nativeinterface/SendMsgRspTransSvrInfoAttr;", "sendMsgRspTransSvrInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieMsgAttr;", "adelieMsgAttr", "Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackStateInfo;", "feedBackStateInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MemoryStateMsgInfo;", "memoryStateMsgInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;", "attaReportData", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteActionAttr;", "liteAction", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;Ljava/lang/Integer;Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgElement;Lcom/tencent/qqnt/kernel/nativeinterface/VASAIOPersonalElement;Lcom/tencent/qqnt/kernel/nativeinterface/GroupHonor;Lcom/tencent/qqnt/kernel/nativeinterface/KingHonor;Lcom/tencent/qqnt/kernel/nativeinterface/PublicAccountAttrs;Lcom/tencent/qqnt/kernel/nativeinterface/SharedMsgInfo;Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;Lcom/tencent/qqnt/kernel/nativeinterface/UinInfoAttr;Lcom/tencent/qqnt/kernel/nativeinterface/LongMsgAttr;Lcom/tencent/qqnt/kernel/nativeinterface/RobotMsgExt;Lcom/tencent/qqnt/kernel/nativeinterface/ZPlanMsgElement;Lcom/tencent/qqnt/kernel/nativeinterface/QQConnectAttr;Ljava/util/HashMap;Lcom/tencent/qqnt/kernel/nativeinterface/SendMsgRspTransSvrInfoAttr;Lcom/tencent/qqnt/kernel/nativeinterface/AdelieMsgAttr;Lcom/tencent/qqnt/kernel/nativeinterface/FeedBackStateInfo;Lcom/tencent/qqnt/kernel/nativeinterface/MemoryStateMsgInfo;Lcom/tencent/qqnt/kernel/nativeinterface/AttaReportData;Lcom/tencent/qqnt/kernel/nativeinterface/LiteActionAttr;)Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359256a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359256a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ MsgAttributeInfo c(a aVar, int i3, long j3, VASMsgElement vASMsgElement, VASAIOPersonalElement vASAIOPersonalElement, GroupHonor groupHonor, KingHonor kingHonor, PublicAccountAttrs publicAccountAttrs, SharedMsgInfo sharedMsgInfo, TempChatGameSession tempChatGameSession, UinInfoAttr uinInfoAttr, LongMsgAttr longMsgAttr, RobotMsgExt robotMsgExt, ZPlanMsgElement zPlanMsgElement, QQConnectAttr qQConnectAttr, HashMap hashMap, SendMsgRspTransSvrInfoAttr sendMsgRspTransSvrInfoAttr, AdelieMsgAttr adelieMsgAttr, FeedBackStateInfo feedBackStateInfo, MemoryStateMsgInfo memoryStateMsgInfo, int i16, Object obj) {
        return aVar.a(i3, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? null : vASMsgElement, (i16 & 8) != 0 ? null : vASAIOPersonalElement, (i16 & 16) != 0 ? null : groupHonor, (i16 & 32) != 0 ? null : kingHonor, (i16 & 64) != 0 ? null : publicAccountAttrs, (i16 & 128) != 0 ? null : sharedMsgInfo, (i16 & 256) != 0 ? null : tempChatGameSession, (i16 & 512) != 0 ? null : uinInfoAttr, (i16 & 1024) != 0 ? null : longMsgAttr, (i16 & 2048) != 0 ? null : robotMsgExt, (i16 & 4096) != 0 ? null : zPlanMsgElement, (i16 & 8192) != 0 ? null : qQConnectAttr, (i16 & 16384) != 0 ? null : hashMap, (i16 & 32768) != 0 ? null : sendMsgRspTransSvrInfoAttr, (i16 & 65536) != 0 ? null : adelieMsgAttr, (i16 & 131072) != 0 ? null : feedBackStateInfo, (i16 & 262144) != 0 ? null : memoryStateMsgInfo);
    }

    public static /* synthetic */ MsgAttributeInfo d(a aVar, MsgAttributeInfo msgAttributeInfo, Integer num, Long l3, VASMsgElement vASMsgElement, VASAIOPersonalElement vASAIOPersonalElement, GroupHonor groupHonor, KingHonor kingHonor, PublicAccountAttrs publicAccountAttrs, SharedMsgInfo sharedMsgInfo, TempChatGameSession tempChatGameSession, UinInfoAttr uinInfoAttr, LongMsgAttr longMsgAttr, RobotMsgExt robotMsgExt, ZPlanMsgElement zPlanMsgElement, QQConnectAttr qQConnectAttr, HashMap hashMap, SendMsgRspTransSvrInfoAttr sendMsgRspTransSvrInfoAttr, AdelieMsgAttr adelieMsgAttr, FeedBackStateInfo feedBackStateInfo, MemoryStateMsgInfo memoryStateMsgInfo, AttaReportData attaReportData, LiteActionAttr liteActionAttr, int i3, Object obj) {
        return aVar.b(msgAttributeInfo, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? null : vASMsgElement, (i3 & 16) != 0 ? null : vASAIOPersonalElement, (i3 & 32) != 0 ? null : groupHonor, (i3 & 64) != 0 ? null : kingHonor, (i3 & 128) != 0 ? null : publicAccountAttrs, (i3 & 256) != 0 ? null : sharedMsgInfo, (i3 & 512) != 0 ? null : tempChatGameSession, (i3 & 1024) != 0 ? null : uinInfoAttr, (i3 & 2048) != 0 ? null : longMsgAttr, (i3 & 4096) != 0 ? null : robotMsgExt, (i3 & 8192) != 0 ? null : zPlanMsgElement, (i3 & 16384) != 0 ? null : qQConnectAttr, (i3 & 32768) != 0 ? null : hashMap, (i3 & 65536) != 0 ? null : sendMsgRspTransSvrInfoAttr, (i3 & 131072) != 0 ? null : adelieMsgAttr, (i3 & 262144) != 0 ? null : feedBackStateInfo, (i3 & 524288) != 0 ? null : memoryStateMsgInfo, (i3 & 1048576) != 0 ? null : attaReportData, (i3 & 2097152) == 0 ? liteActionAttr : null);
    }

    private final <T> T e(T data, T old) {
        if (data == null) {
            return old;
        }
        return data;
    }

    @NotNull
    public final MsgAttributeInfo a(int attrType, long attrId, @Nullable VASMsgElement vasMsgInfo, @Nullable VASAIOPersonalElement vasPersonalInfo, @Nullable GroupHonor groupHonor, @Nullable KingHonor kingHonor, @Nullable PublicAccountAttrs publicAccountAttrs, @Nullable SharedMsgInfo sharedMsgInfo, @Nullable TempChatGameSession gameChatSession, @Nullable UinInfoAttr uinInfoAttr, @Nullable LongMsgAttr longMsgAttr, @Nullable RobotMsgExt robotExt, @Nullable ZPlanMsgElement zPlanMsgInfo, @Nullable QQConnectAttr qqConnectAttr, @Nullable HashMap<Integer, ExtendBusinessAttr> extendBusiness, @Nullable SendMsgRspTransSvrInfoAttr sendMsgRspTransSvrInfo, @Nullable AdelieMsgAttr adelieMsgAttr, @Nullable FeedBackStateInfo feedBackStateInfo, @Nullable MemoryStateMsgInfo memoryStateMsgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new MsgAttributeInfo(attrType, attrId, vasMsgInfo, vasPersonalInfo, groupHonor, kingHonor, publicAccountAttrs, sharedMsgInfo, gameChatSession, uinInfoAttr, longMsgAttr, robotExt, zPlanMsgInfo, qqConnectAttr, extendBusiness, sendMsgRspTransSvrInfo, adelieMsgAttr, feedBackStateInfo, memoryStateMsgInfo) : (MsgAttributeInfo) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(attrType), Long.valueOf(attrId), vasMsgInfo, vasPersonalInfo, groupHonor, kingHonor, publicAccountAttrs, sharedMsgInfo, gameChatSession, uinInfoAttr, longMsgAttr, robotExt, zPlanMsgInfo, qqConnectAttr, extendBusiness, sendMsgRspTransSvrInfo, adelieMsgAttr, feedBackStateInfo, memoryStateMsgInfo);
    }

    @NotNull
    public final MsgAttributeInfo b(@NotNull MsgAttributeInfo old, @Nullable Integer attrType, @Nullable Long attrId, @Nullable VASMsgElement vasMsgInfo, @Nullable VASAIOPersonalElement vasPersonalInfo, @Nullable GroupHonor groupHonor, @Nullable KingHonor kingHonor, @Nullable PublicAccountAttrs publicAccountAttrs, @Nullable SharedMsgInfo sharedMsgInfo, @Nullable TempChatGameSession gameChatSession, @Nullable UinInfoAttr uinInfoAttr, @Nullable LongMsgAttr longMsgAttr, @Nullable RobotMsgExt robotExt, @Nullable ZPlanMsgElement zPlanMsgInfo, @Nullable QQConnectAttr qqConnectAttr, @Nullable HashMap<Integer, ExtendBusinessAttr> extendBusiness, @Nullable SendMsgRspTransSvrInfoAttr sendMsgRspTransSvrInfo, @Nullable AdelieMsgAttr adelieMsgAttr, @Nullable FeedBackStateInfo feedBackStateInfo, @Nullable MemoryStateMsgInfo memoryStateMsgInfo, @Nullable AttaReportData attaReportData, @Nullable LiteActionAttr liteAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgAttributeInfo) iPatchRedirector.redirect((short) 3, this, old, attrType, attrId, vasMsgInfo, vasPersonalInfo, groupHonor, kingHonor, publicAccountAttrs, sharedMsgInfo, gameChatSession, uinInfoAttr, longMsgAttr, robotExt, zPlanMsgInfo, qqConnectAttr, extendBusiness, sendMsgRspTransSvrInfo, adelieMsgAttr, feedBackStateInfo, memoryStateMsgInfo, attaReportData, liteAction);
        }
        Intrinsics.checkNotNullParameter(old, "old");
        MsgAttributeInfo msgAttributeInfo = new MsgAttributeInfo(((Number) e(attrType, Integer.valueOf(old.attrType))).intValue(), ((Number) e(attrId, Long.valueOf(old.attrId))).longValue(), (VASMsgElement) e(vasMsgInfo, old.vasMsgInfo), (VASAIOPersonalElement) e(vasPersonalInfo, old.vasPersonalInfo), (GroupHonor) e(groupHonor, old.groupHonor), (KingHonor) e(kingHonor, old.kingHonor), (PublicAccountAttrs) e(publicAccountAttrs, old.publicAccountAttrs), (SharedMsgInfo) e(sharedMsgInfo, old.sharedMsgInfo), (TempChatGameSession) e(gameChatSession, old.gameChatSession), (UinInfoAttr) e(uinInfoAttr, old.uinInfoAttr), (LongMsgAttr) e(longMsgAttr, old.longMsgAttr), (RobotMsgExt) e(robotExt, old.robotExt), (ZPlanMsgElement) e(zPlanMsgInfo, old.zPlanMsgInfo), (QQConnectAttr) e(qqConnectAttr, old.qqConnectAttr), (HashMap) e(extendBusiness, old.extendBusiness), (SendMsgRspTransSvrInfoAttr) e(sendMsgRspTransSvrInfo, old.sendMsgRspTransSvrInfo), (AdelieMsgAttr) e(adelieMsgAttr, old.adelieMsgAttr), (FeedBackStateInfo) e(feedBackStateInfo, old.feedBackStateInfo), (MemoryStateMsgInfo) e(memoryStateMsgInfo, old.memoryStateMsgInfo));
        a aVar = f359256a;
        msgAttributeInfo.attaReportData = (AttaReportData) aVar.e(attaReportData, old.attaReportData);
        msgAttributeInfo.liteAction = (LiteActionAttr) aVar.e(liteAction, old.liteAction);
        return msgAttributeInfo;
    }
}
