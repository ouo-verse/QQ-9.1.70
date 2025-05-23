package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ak;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.guild.forward.ForwardTroopRobotOption;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.ISendCommonRobotCallBack;
import com.tencent.qqnt.kernel.nativeinterface.RobotShareTarget;
import com.tencent.qqnt.kernel.nativeinterface.SendCommonRobotReq;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0014J$\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/ForwardTroopRobotOption;", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "Lcom/tencent/mobileqq/forward/al;", "Landroid/os/Bundle;", "params", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "target", "o", "p", "", "isSupportMultipleForward", "realForwardTo", "", "toUin", "troopUin", "", "uinType", "sendMessage2TargetOnConfirm", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "c", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", "d", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ForwardTroopRobotOption extends ForwardBaseOption implements al {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardTroopRobotOption(Intent intent) {
        super(intent);
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    private final void m(final Bundle params) {
        RobotShareTarget robotShareTarget;
        Long longOrNull;
        Long longOrNull2;
        Long longOrNull3;
        IKernelService iKernelService;
        final String string = params.getString("guild_id");
        if (string == null) {
            string = "";
        }
        final String string2 = params.getString("uin");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = params.getString("robot_appid");
        if (string3 == null) {
            string3 = "";
        }
        if (params.getBoolean("robot_list_share")) {
            robotShareTarget = RobotShareTarget.KROBOTLIST;
        } else {
            robotShareTarget = RobotShareTarget.KROBOT;
        }
        SendCommonRobotReq sendCommonRobotReq = new SendCommonRobotReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string3);
        sendCommonRobotReq.robotAppId = longOrNull != null ? longOrNull.longValue() : 0L;
        sendCommonRobotReq.shareScene = 1;
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
        sendCommonRobotReq.guildId = longOrNull2 != null ? longOrNull2.longValue() : 0L;
        longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(string2);
        sendCommonRobotReq.channelId = longOrNull3 != null ? longOrNull3.longValue() : 0L;
        sendCommonRobotReq.shareTarget = robotShareTarget;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null) {
            return;
        }
        QLog.d("ForwardTroopRobotOption", 1, "forwardRobot guildId " + string + " channelId " + string2 + ", robotAppId " + string3);
        ac robotService = iKernelService.getRobotService();
        if (robotService != null) {
            robotService.sendCommonRobotToGuild(sendCommonRobotReq, new ISendCommonRobotCallBack() { // from class: jo1.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISendCommonRobotCallBack
                public final void onResult(int i3, String str) {
                    ForwardTroopRobotOption.n(string, string2, this, params, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String guildId, String channelId, ForwardTroopRobotOption this$0, Bundle params, int i3, String str) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.d("ForwardTroopRobotOption", 1, "forwardRobot guildId " + guildId + " channelId " + channelId + ", result " + i3 + " errMsg " + str);
        this$0.p(params);
    }

    private final Bundle o(ResultRecord target) {
        Bundle bundle = new Bundle();
        bundle.putAll(this.mExtraData);
        bundle.putInt("uintype", target.getUinType());
        bundle.putString("guild_id", target.guildId);
        bundle.putString("uin", target.uin);
        return bundle;
    }

    private final void p(Bundle params) {
        String b16 = jo1.b.b(this.mExtraData, this.mConfirmDialog);
        String string = params.getString("guild_id");
        QLog.d("ForwardTroopRobotOption", 1, "sendLeaveMsg guildId " + string + ", leaveMessage " + b16);
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        params.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, b16);
        SessionInfo sessionInfo = ForwardUtils.n0(new Intent().putExtras(params));
        if (sessionInfo.f179555d == 10014 && !TextUtils.isEmpty(string)) {
            sessionInfo.f179559f = string;
        } else {
            QLog.i("ForwardTroopRobotOption", 1, "[sendCommentMsgToGuild] Fail to get guildId");
        }
        Intrinsics.checkNotNullExpressionValue(sessionInfo, "sessionInfo");
        jo1.b.d(sessionInfo, b16);
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    @Override // com.tencent.mobileqq.forward.al
    public SharePublishGuildFeedParam c() {
        Bundle mExtraData = this.mExtraData;
        Intrinsics.checkNotNullExpressionValue(mExtraData, "mExtraData");
        return GuildForwardUtilKt.g(mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            if (multiTargetWithoutDataLine == null) {
                return false;
            }
            for (ResultRecord target : multiTargetWithoutDataLine) {
                Intrinsics.checkNotNullExpressionValue(target, "target");
                m(o(target));
            }
        } else {
            Bundle mExtraData = this.mExtraData;
            Intrinsics.checkNotNullExpressionValue(mExtraData, "mExtraData");
            m(mExtraData);
        }
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String toUin, String troopUin, int uinType) {
        return true;
    }
}
