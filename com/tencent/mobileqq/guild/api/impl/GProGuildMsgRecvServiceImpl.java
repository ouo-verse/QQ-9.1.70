package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import com.google.gson.JsonObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.guild.report.model.PushReportData;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiTransInfo;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedMsg;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#H\u0016J\u0012\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\nH\u0016\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GProGuildMsgRecvServiceImpl;", "Lcom/tencent/mobileqq/guild/api/IGProGuildMsgRecvService;", "", "atType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "createMsgElements", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildTopFeedMsg;", "topFeedMsg", "", "notifyGuildMsg", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "fetchGuildInfoAnyWay", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "fmsg", "onFeed2Msg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAvChannelStateMsg;", "avChannelStateMsg", "onAVChannel2Msg", "onFeedTop2Msg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleNotifyInfo;", "scheduleNotifyInfo", "onGuildScheduleNotify", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCheckInNotifyInfo;", "checkInNotifyInfo", "onGuildCheckInNotify", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProManagerNotice;", "manageNotice", "onManageNotice2Msg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "onGuildNewPostEvent", "Ljava/util/HashMap;", "switchValue", "onGuildHelperNotifySwitchUpdate", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GProGuildMsgRecvServiceImpl implements IGProGuildMsgRecvService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "GuildOnFeed2MsgServiceImpl";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GProGuildMsgRecvServiceImpl$a;", "", "", "", "feedAtTypes", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.api.impl.GProGuildMsgRecvServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull List<Integer> feedAtTypes) {
            Intrinsics.checkNotNullParameter(feedAtTypes, "feedAtTypes");
            if (feedAtTypes.isEmpty()) {
                return 0;
            }
            int i3 = 2;
            if (feedAtTypes.indexOf(2) == -1) {
                i3 = 8;
                if (feedAtTypes.indexOf(8) == -1) {
                    i3 = 64;
                    if (feedAtTypes.indexOf(64) == -1) {
                        i3 = 1;
                        if (feedAtTypes.indexOf(1) == -1) {
                            return 0;
                        }
                    }
                }
            }
            return i3;
        }

        Companion() {
        }
    }

    private final ArrayList<MsgElement> createMsgElements(int atType) {
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        TextElement textElement = new TextElement();
        textElement.atType = atType;
        arrayList.add(((IMsgUtilApi) api).createTextElement(textElement));
        return arrayList;
    }

    private final IGProGuildInfo fetchGuildInfoAnyWay(String guildId) {
        return (IGProGuildInfo) BuildersKt.runBlocking(Dispatchers.getIO(), new GProGuildMsgRecvServiceImpl$fetchGuildInfoAnyWay$1(guildId, null));
    }

    private final void notifyGuildMsg(GProGuildTopFeedMsg topFeedMsg) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGuildNotify.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        GProTopFeedMsg gProTopFeedMsg = topFeedMsg.topFeedMsg;
        String str = "[" + gProTopFeedMsg.labelText + "]" + gProTopFeedMsg.summaryText;
        PushReportData pushReportData = new PushReportData();
        pushReportData.setSenderTinyId(String.valueOf(topFeedMsg.topFeedMsg.operatorTinyid));
        pushReportData.setTime(topFeedMsg.topFeedMsg.createTime);
        pushReportData.setGuildId(String.valueOf(topFeedMsg.guildId));
        pushReportData.setChannelId(String.valueOf(topFeedMsg.channelId));
        pushReportData.setChannelType(7);
        pushReportData.setUin(ch.g());
        pushReportData.setFeedId(topFeedMsg.topFeedMsg.feedId);
        pushReportData.setPushType(PushReportData.PushType.PUSH_TYPE_OPERATOR_ANNOUNCEMENT.ordinal());
        Message message = new Message();
        message.frienduin = String.valueOf(topFeedMsg.channelId);
        message.istroop = 10014;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, String.valueOf(topFeedMsg.guildId));
        jsonObject.addProperty(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, (Number) 1);
        message.extStr = jsonObject.toString();
        message.f203106msg = str;
        message.extLong = 1;
        message.counter = 1;
        message.nickName = "";
        message.extObj = pushReportData;
        ((IGuildNotify) runtimeService).handleNotifyGuildMessage(message);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onAVChannel2Msg(@NotNull GProAvChannelStateMsg avChannelStateMsg) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(avChannelStateMsg, "avChannelStateMsg");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(avChannelStateMsg.guildId));
        IGProChannelInfo channelInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(String.valueOf(avChannelStateMsg.channelId));
        if (guildInfo == null) {
            QLog.e(TAG, 1, "[onAVChannel2Msg] guildInfo == null, guildId = " + avChannelStateMsg.guildId);
            return;
        }
        boolean areEqual = Intrinsics.areEqual(String.valueOf(avChannelStateMsg.fromTinyId), ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId());
        if (avChannelStateMsg.needNotify && !areEqual && guildInfo.getGuildAudioChannelNotify() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(TAG, 1, "[onAVChannel2Msg] needNotify = " + z16 + ", isFromSelf: " + areEqual + "\uff0c avChannelStateMsg.needNotify = " + avChannelStateMsg.needNotify + ", guildUnNotifyFlag = " + guildInfo.getGuildUnNotifyFlag() + ", guildAudioChannelNotify = " + guildInfo.getGuildAudioChannelNotify() + ",msgSummary: " + avChannelStateMsg.summary + ", msgContent: " + avChannelStateMsg.f359281msg);
        if (!z16) {
            return;
        }
        PushReportData pushReportData = new PushReportData();
        pushReportData.setSenderTinyId(String.valueOf(avChannelStateMsg.fromTinyId));
        pushReportData.setTime(avChannelStateMsg.timestamp);
        pushReportData.setGuildId(String.valueOf(avChannelStateMsg.guildId));
        pushReportData.setChannelId(String.valueOf(avChannelStateMsg.channelId));
        if (channelInfo != null) {
            i3 = channelInfo.getType();
        } else if (avChannelStateMsg.appid == 999) {
            i3 = 5;
        } else {
            i3 = 2;
        }
        pushReportData.setChannelType(i3);
        pushReportData.setUin(ch.g());
        if (avChannelStateMsg.atType == 1) {
            i16 = 1;
        } else {
            i16 = 10;
        }
        pushReportData.setPushType(i16);
        Message message = new Message();
        message.frienduin = String.valueOf(avChannelStateMsg.channelId);
        message.istroop = 10014;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, String.valueOf(avChannelStateMsg.guildId));
        jsonObject.addProperty(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, (Number) 2);
        message.extStr = jsonObject.toString();
        message.f203106msg = avChannelStateMsg.summary + avChannelStateMsg.f359281msg;
        message.extLong = 1;
        message.counter = 1;
        message.nickName = "";
        message.extObj = pushReportData;
        ((IGuildNotify) peekAppRuntime.getRuntimeService(IGuildNotify.class, "")).handleNotifyGuildMessage(message);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onFeed2Msg(@NotNull FirstViewDirectMsgNotifyInfo fmsg) {
        boolean z16;
        IGProGuildInfo fetchGuildInfoAnyWay;
        String str;
        Message message;
        String decodeToString;
        Object obj;
        Intrinsics.checkNotNullParameter(fmsg, "fmsg");
        Companion companion = INSTANCE;
        ArrayList<Integer> feedAtTypes = fmsg.getFeedAtTypes();
        Intrinsics.checkNotNullExpressionValue(feedAtTypes, "fmsg.feedAtTypes");
        int a16 = companion.a(feedAtTypes);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (fmsg.getFeedType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            fetchGuildInfoAnyWay = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(fmsg.getFeedsGuildId()));
        } else {
            fetchGuildInfoAnyWay = fetchGuildInfoAnyWay(String.valueOf(fmsg.getFeedsGuildId()));
        }
        if (fetchGuildInfoAnyWay == null) {
            QLog.e(TAG, 1, "onFeed2Msg guildinfo == null, guildId = " + fmsg.getFeedsGuildId());
            return;
        }
        boolean z17 = fmsg.needPushNotify;
        QLog.d(TAG, 1, "onFeed2Msg atType = " + a16 + ", feedsNeedNofity= " + fmsg.getFeedsNeedNofity() + ", needPushNotify: " + fmsg.needPushNotify + ", movePostSection=" + fetchGuildInfoAnyWay.isMovePostSection());
        if (fetchGuildInfoAnyWay.isMovePostSection() && !z17) {
            return;
        }
        if (!fetchGuildInfoAnyWay.isMovePostSection()) {
            if (fmsg.getFeedsNeedNofity()) {
                if (a16 != 64 && !z17) {
                    return;
                }
            } else {
                return;
            }
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGuildNotify.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGuildNotify iGuildNotify = (IGuildNotify) runtimeService;
        if (a16 != 1) {
            if (a16 != 8) {
                str = "";
            } else {
                str = "[\u6709\u4eba@\u6211]";
            }
        } else {
            str = "[@\u5168\u4f53\u6210\u5458]";
        }
        iu1.b bVar = iu1.b.f408754a;
        MsgAbstract msgAbstract = fmsg.msgAbstract;
        Intrinsics.checkNotNullExpressionValue(msgAbstract, "fmsg.msgAbstract");
        String str2 = str + ((Object) bVar.b(msgAbstract, ""));
        QLog.d(TAG, 1, "decodeMsg content= " + str2 + " element.size= " + fmsg.msgAbstract.elements.size());
        Message message2 = new Message();
        message2.frienduin = String.valueOf(fmsg.getFeedsChannelId());
        message2.istroop = 10014;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, String.valueOf(fmsg.getFeedsGuildId()));
        jsonObject.addProperty(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, (Number) 3);
        message2.extStr = jsonObject.toString();
        message2.f203106msg = str2;
        message2.extLong = 1;
        message2.counter = 1;
        message2.nickName = "";
        if (a16 == 64) {
            obj = new MsgRecord(message2.uniseq, 0L, message2.msgseq, 0L, 0, message2.msgtype, 0, 0, "", "", String.valueOf(fmsg.getFeedsChannelId()), String.valueOf(fmsg.getFeedsGuildId()), 0L, 0L, 0L, 0L, new byte[0], 0, "", "", "", "", "", createMsgElements(a16), new ArrayList(), new ArrayList(), 0L, 0, new ArrayList(), "", new FreqLimitInfo(), false, "", "", fmsg.getFeedId() + "," + fmsg.getCmtId() + "," + fmsg.getReplyId() + "," + fmsg.getJumpSchema(), 0L, message2.time, new GuildClientIdentity(), false, a16, 0, new FromRoleInfo(), new FromRoleInfo(), new FromRoleInfo(), 0L, true, new byte[0], 0L, 0, new FoldingInfo(), new MultiTransInfo(), 0L, 0L, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], new GuildMedal(), 0, new byte[0]);
            message = message2;
        } else {
            message = message2;
            PushReportData pushReportData = new PushReportData();
            pushReportData.setSenderTinyId("");
            pushReportData.setTime(fmsg.getFeedsEventLastTime());
            pushReportData.setGuildId(String.valueOf(fmsg.getFeedsGuildId()));
            pushReportData.setChannelId(String.valueOf(fmsg.getFeedsChannelId()));
            pushReportData.setChannelType(7);
            pushReportData.setUin(ch.g());
            pushReportData.setFeedId(fmsg.getFeedId());
            pushReportData.setPushType(PushReportData.PushType.PUSH_TYPE_FEED.ordinal());
            Bundle bundle = new Bundle();
            byte[] feedsEventLastId = fmsg.getFeedsEventLastId();
            Intrinsics.checkNotNullExpressionValue(feedsEventLastId, "fmsg.feedsEventLastId");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(feedsEventLastId);
            bundle.putString("detailId", decodeToString);
            bundle.putBoolean("is_guest_notice", z16);
            bundle.putInt(AppConstants.Key.GUILD_PUSH_AT_TYPE, a16);
            bundle.putParcelable(PushReportData.GUILD_NOTIFY_REPORT, pushReportData);
            obj = bundle;
        }
        message.extObj = obj;
        iGuildNotify.handleNotifyGuildMessage(message);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onFeedTop2Msg(@NotNull GProGuildTopFeedMsg topFeedMsg) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(topFeedMsg, "topFeedMsg");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(topFeedMsg.guildId)) == null) {
            QLog.e(TAG, 1, "onFeedTop2Msg guildinfo == null, guildId = " + topFeedMsg.guildId);
            return;
        }
        GProTopFeedMsg gProTopFeedMsg = topFeedMsg.topFeedMsg;
        if (!gProTopFeedMsg.needNotify) {
            QLog.d(TAG, 1, "onFeedTop2Msg topFeedMsg.needNotify = false");
            return;
        }
        long j3 = gProTopFeedMsg.operatorTinyid;
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(f16);
        if (longOrNull != null && j3 == longOrNull.longValue()) {
            QLog.d(TAG, 1, "onFeedTop2Msg operatorTinyid = " + topFeedMsg.topFeedMsg.operatorTinyid + " isSelf = true");
            return;
        }
        long j16 = topFeedMsg.channelId;
        GProTopFeedMsg gProTopFeedMsg2 = topFeedMsg.topFeedMsg;
        QLog.d(TAG, 1, "onFeedTop2Msg channelId= " + j16 + " labelText=" + gProTopFeedMsg2.labelText + ", summaryText=" + gProTopFeedMsg2.summaryText + " ");
        notifyGuildMsg(topFeedMsg);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onGuildCheckInNotify(@NotNull GProCheckInNotifyInfo checkInNotifyInfo) {
        Intrinsics.checkNotNullParameter(checkInNotifyInfo, "checkInNotifyInfo");
        uo1.b.f439371a.d(checkInNotifyInfo);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onGuildHelperNotifySwitchUpdate(@NotNull HashMap<Integer, Integer> switchValue) {
        Intrinsics.checkNotNullParameter(switchValue, "switchValue");
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onGuildNewPostEvent(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onGuildScheduleNotify(@NotNull GProScheduleNotifyInfo scheduleNotifyInfo) {
        Intrinsics.checkNotNullParameter(scheduleNotifyInfo, "scheduleNotifyInfo");
        ry1.b.f432950a.f(scheduleNotifyInfo);
    }

    @Override // com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService
    public void onManageNotice2Msg(@NotNull GProManagerNotice manageNotice) {
        Intrinsics.checkNotNullParameter(manageNotice, "manageNotice");
        QLog.i(TAG, 1, "onManageNotice2Msg manageNotice:" + manageNotice);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(manageNotice.guildId)) == null) {
            QLog.i(TAG, 1, "onManageNotice2Msg guildinfo == null, guildId = " + manageNotice.guildId);
            return;
        }
        if (!manageNotice.needNotify) {
            QLog.i(TAG, 1, "onManageNotice2Msg disallow notify");
            return;
        }
        Message message = new Message();
        message.frienduin = "";
        message.istroop = 10014;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, String.valueOf(manageNotice.guildId));
        jsonObject.addProperty(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, (Number) 4);
        message.extStr = jsonObject.toString();
        message.f203106msg = manageNotice.noticeContent;
        message.extLong = 1;
        message.counter = 1;
        message.nickName = "";
        Bundle bundle = new Bundle();
        bundle.putParcelable("GUILD_MANAGE_NOTICE_PUSH", new GuildManageNoticePushMsg("\u7cfb\u7edf\u6d88\u606f"));
        message.extObj = bundle;
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGuildNotify.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IGuildNotify) runtimeService).handleNotifyGuildMessage(message);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
