package com.tencent.guild.aio.msglist.holder.component.tail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.aio.util.ex.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u001b\u0010\u0012\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/tail/RobotPushSettingTail;", "Lcom/tencent/guild/aio/msglist/holder/component/tail/a;", "", "d", "Lcom/tencent/aio/data/msglist/a;", "msg", "", "b", "Landroid/view/View;", "a", "", "c", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lkotlin/Lazy;", h.F, "()Landroid/view/View;", "mPushLayout", "Landroid/widget/TextView;", "i", "()Landroid/widget/TextView;", "mSetting", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RobotPushSettingTail implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPushLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSetting;

    public RobotPushSettingTail(@NotNull Context mContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.RobotPushSettingTail$mPushLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                Context context;
                context = RobotPushSettingTail.this.mContext;
                View inflate = LayoutInflater.from(context).inflate(R.layout.ef5, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.View");
                return inflate;
            }
        });
        this.mPushLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.RobotPushSettingTail$mSetting$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                View h16;
                h16 = RobotPushSettingTail.this.h();
                View findViewById = h16.findViewById(R.id.f29390li);
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                return (TextView) findViewById;
            }
        });
        this.mSetting = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View h() {
        return (View) this.mPushLayout.getValue();
    }

    private final TextView i() {
        return (TextView) this.mSetting.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildMsgItem it, RobotPushSettingTail this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026nt.MAIN\n                )");
        IGPSService iGPSService = (IGPSService) runtimeService;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(iGPSService.getGuildIdOf(it.getMsgRecord().channelId));
        if (guildInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e("RobotPushSettingTail", 2, "guildInfo == null");
            }
        } else {
            ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).jumpRobotPushSettingPage(this$0.mContext, iGPSService.getGuildIdOf(it.getMsgRecord().channelId), it.getMsgRecord().senderUid, guildInfo.getUserType(), 3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    @NotNull
    public View a() {
        return h();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public boolean b(@NotNull com.tencent.aio.data.msglist.a msg2) {
        GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msg2;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem == null || !com.tencent.guild.api.data.msglist.a.c(guildMsgItem)) {
            return false;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026AIN\n                    )");
        IGPSService iGPSService = (IGPSService) runtimeService;
        GuildMsgItem guildMsgItem2 = (GuildMsgItem) msg2;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(iGPSService.getGuildIdOf(guildMsgItem2.getMsgRecord().channelId));
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem2, IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING, null, 2, null);
        if (QLog.isColorLevel()) {
            QLog.d("RobotPushSettingTail", 2, " showMsgSetting = " + extInfoFromExtStr$default + " guildInfo = " + guildInfo + " msg.frienduin = " + msg2.getMsgId() + " msg.shmsgseq = " + msg2.getMsgSeq() + " extStr = " + ((GuildMsgItem) msg2).getExtJsonObject());
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr$default) && guildInfo != null) {
            int userType = guildInfo.getUserType();
            if (QLog.isColorLevel()) {
                QLog.d("RobotPushSettingTail", 2, "userType = " + userType);
            }
            if ((userType == 2 || userType == 1) && Boolean.parseBoolean(extInfoFromExtStr$default)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public void c(@NotNull com.tencent.aio.data.msglist.a msg2) {
        final GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msg2;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem != null) {
            i().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotPushSettingTail.j(GuildMsgItem.this, this, view);
                }
            });
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) msg2;
            String guildUserDisplayName = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "all")).getGuildUserDisplayName(f.a(guildMsgItem2), guildMsgItem2.getMsgRecord().senderUid);
            Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "app.getRuntimeService(IG\u2026 msg.msgRecord.senderUid)");
            VideoReport.setElementId(i(), "em_aio_graytext");
            VideoReport.setElementClickPolicy(i(), ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(i(), ExposurePolicy.REPORT_FIRST);
            VideoReport.setElementEndExposePolicy(i(), EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParam(i(), "aio_graytext_type", 4);
            VideoReport.setElementParam(i(), "sgrp_robot_id", guildMsgItem2.getMsgRecord().senderUid);
            VideoReport.setElementParam(i(), "sgrp_robot_name", guildUserDisplayName);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public int d() {
        return 3;
    }
}
