package i12;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J4\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0007J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0007J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\u0019"}, d2 = {"Li12/a;", "", "", "guildId", "", "e", "Landroid/content/Context;", "ctx", "Lcom/tencent/imcore/message/Message;", "message", "channelId", "feedId", "Landroid/content/Intent;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "isNeedJumpToMsg", "friendUin", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "c", "", "d", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f407028a = new a();

    a() {
    }

    @JvmStatic
    public static final Intent a(Context ctx, MsgRecord msgRecord, boolean isNeedJumpToMsg, String friendUin) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Logger.f235387a.d().i("GuildConversationTabUtil", 1, "getConversationTabMsgRecordIntent");
        JumpGuildParam c16 = f407028a.c(msgRecord, isNeedJumpToMsg, friendUin);
        c16.extras.putInt("openGuildAioFrom", 10);
        c16.extras.putString("PGIN_SOURCE_REPORT_KEY", "qq_push");
        Intent createGotoConversationGuildIntent = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createGotoConversationGuildIntent(ctx, c16);
        Intrinsics.checkNotNullExpressionValue(createGotoConversationGuildIntent, "api(IGuildMainFrameApi::\u2026tent(ctx, jumpGuildParam)");
        return createGotoConversationGuildIntent;
    }

    private final JumpGuildParam c(MsgRecord msgRecord, boolean isNeedJumpToMsg, String friendUin) {
        boolean z16;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(msgRecord.guildId, friendUin);
        jumpGuildParam.extras.putInt("openGuildAioFrom", 10);
        boolean z17 = true;
        if (isNeedJumpToMsg && !MsgExtKt.V(msgRecord)) {
            jumpGuildParam.extras.putBoolean(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_IS_NEED_JUMP, true);
            jumpGuildParam.extras.putLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, msgRecord.msgSeq);
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && textElement.atType == 64) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(MobileQQ.sMobileQQ.peekAppRuntime(), msgRecord.guildId, friendUin) == 7) {
            jumpGuildParam.extras.putString("detailId", msgRecord.getFeedId());
        }
        if (msgRecord.directMsgFlag == 1) {
            jumpGuildParam.extras.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        }
        if (msgRecord.msgType == -4051) {
            ArrayList<MsgElement> arrayList2 = msgRecord.elements;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z17 = false;
            }
            if (!z17) {
                CalendarElement calendarElement = msgRecord.elements.get(0).getCalendarElement();
                Intrinsics.checkNotNullExpressionValue(calendarElement, "msgRecord.elements[0].getCalendarElement()");
                if (calendarElement.expireTimeMs > NetConnInfoCenter.getServerTimeMillis()) {
                    jumpGuildParam.extras.putString(WadlProxyConsts.KEY_JUMP_URL, calendarElement.schema);
                    jumpGuildParam.extras.putInt("schemaType", calendarElement.schemaType);
                }
            }
        }
        return jumpGuildParam;
    }

    private final int d(Message message) {
        int intFromExtStr = message.getIntFromExtStr(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL);
        Logger.f235387a.d().i("GuildConversationTabUtil", 1, "messageFromPushChannel pushFrom: " + intFromExtStr);
        return intFromExtStr;
    }

    @JvmStatic
    public static final boolean e(String guildId) {
        AppRuntime peekAppRuntime;
        IGPSService iGPSService;
        Long longOrNull;
        if (guildId == null || ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")) == null) {
            return false;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        return iGPSService.isQQMsgListGuild(longOrNull != null ? longOrNull.longValue() : 0L);
    }

    @JvmStatic
    public static final Intent b(Context ctx, Message message, String guildId, String channelId, String feedId) {
        JumpGuildParam jumpGuildParam;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Logger.f235387a.d().i("GuildConversationTabUtil", 1, "getConversationTabNotMsgRecordIntent");
        GuildManageNoticePushMsg guildManageNoticePushMsgFromMr = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildManageNoticePushMsgFromMr(message);
        if (TextUtils.isEmpty(feedId) && guildManageNoticePushMsgFromMr == null) {
            jumpGuildParam = new JumpGuildParam(guildId, channelId);
            jumpGuildParam.extras.putInt("openGuildAioFrom", 10);
        } else {
            JumpGuildParam jumpGuildParam2 = new JumpGuildParam(guildId, "");
            jumpGuildParam2.extras.putInt("openGuildAioFrom", 10);
            jumpGuildParam2.extras.putParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG, new JumpGuildNoticeMsg(guildManageNoticePushMsgFromMr != null ? 2 : 1, guildId, channelId, feedId == null ? "" : feedId, false, 0, 48, null));
            jumpGuildParam = jumpGuildParam2;
        }
        jumpGuildParam.extras.putString("PGIN_SOURCE_REPORT_KEY", "qq_push");
        int d16 = f407028a.d(message);
        if (d16 != -1) {
            if (d16 == 1) {
                jumpGuildParam.setChannelId("");
            }
            jumpGuildParam.extras.putInt(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL, d16);
        }
        return ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).createGotoConversationGuildIntent(ctx, jumpGuildParam);
    }
}
