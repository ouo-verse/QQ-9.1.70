package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fBA\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020)\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0002R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/w;", "", "", tl.h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "addGuildOption", "j", "", "g", "k", "", "f", "()Ljava/lang/Long;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "b", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "e", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "c", "Ljava/lang/String;", "pageFlag", "Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "d", "Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "getJumpParam", "()Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "jumpParam", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "joinGuildSetting", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "guildJoinReportTask", "Lvh2/bv;", "Lvh2/bv;", "getCallback", "()Lvh2/bv;", "callback", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Ljava/lang/String;Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lvh2/bv;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JoinGuildLogic.JumpParam jumpParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProJoinGuildSetting joinGuildSetting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask guildJoinReportTask;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bv callback;

    public w(@NotNull Context context, @NotNull JumpGuildParam param, @NotNull String pageFlag, @NotNull JoinGuildLogic.JumpParam jumpParam, @Nullable IGProJoinGuildSetting iGProJoinGuildSetting, @NotNull IPerformanceReportTask guildJoinReportTask, @NotNull bv callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(pageFlag, "pageFlag");
        Intrinsics.checkNotNullParameter(jumpParam, "jumpParam");
        Intrinsics.checkNotNullParameter(guildJoinReportTask, "guildJoinReportTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.param = param;
        this.pageFlag = pageFlag;
        this.jumpParam = jumpParam;
        this.joinGuildSetting = iGProJoinGuildSetting;
        this.guildJoinReportTask = guildJoinReportTask;
        this.callback = callback;
    }

    private final Long f() {
        String string;
        Long longOrNull;
        Bundle bundle = this.param.extras;
        if (bundle != null && (string = bundle.getString("appid")) != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
            return longOrNull;
        }
        return null;
    }

    private final boolean g(IGProJoinGuildSetting addGuildOption) {
        if (addGuildOption != null) {
            return t.INSTANCE.a(addGuildOption);
        }
        return false;
    }

    private final void h() {
        String mainSource = this.param.getJoinInfoParam().getMainSource();
        Intrinsics.checkNotNullExpressionValue(mainSource, "param.joinInfoParam.mainSource");
        String subSource = this.param.getJoinInfoParam().getSubSource();
        Intrinsics.checkNotNullExpressionValue(subSource, "param.joinInfoParam.subSource");
        int pageEntranceId = this.param.getJoinInfoParam().getPageEntranceId();
        String str = "";
        String string = this.param.extras.getString("sgrp_channel_extension_info", "");
        Intrinsics.checkNotNullExpressionValue(string, "param.extras.getString(\"\u2026nnel_extension_info\", \"\")");
        GuildSourceId b16 = g.b(mainSource, subSource, pageEntranceId, 0, string);
        Long f16 = f();
        if (f16 != null) {
            b16.x(f16.longValue());
        }
        String arkInviteCode = this.param.getJoinInfoParam().getArkInviteCode();
        if (arkInviteCode == null) {
            arkInviteCode = "";
        }
        b16.t(arkInviteCode);
        String arkContentId = this.param.getJoinInfoParam().getArkContentId();
        if (arkContentId != null) {
            str = arkContentId;
        }
        b16.s(str);
        b16.u(com.tencent.mobileqq.guild.report.b.b());
        Logger.f235387a.d().i("Guild.join.HandleJoinGuildOptionStep", 1, "sendJoinGuildCmd traceId=" + this.guildJoinReportTask.getTraceId() + " page:" + this.pageFlag + ", guildId=" + getParam().guildId + " guildSourceId=" + b16 + ", sourceApp=" + b16.n() + " inviteUuid:" + b16.f() + ", id:" + System.identityHashCode(getParam().getJoinInfoParam()));
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        JumpGuildParam jumpGuildParam = this.param;
        iGPSService.addGuild(jumpGuildParam.guildId, b16, jumpGuildParam.getJoinSignature(), new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.u
            @Override // vh2.bv
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                w.i(w.this, i3, str2, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(w this$0, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.join.HandleJoinGuildOptionStep", 1, "addGuild page:" + this$0.pageFlag + " result=" + i3 + " errMsg=" + errMsg + " security=" + iGProSecurityResult);
        this$0.guildJoinReportTask.setResultCode((long) i3);
        IPerformanceReportTask iPerformanceReportTask = this$0.guildJoinReportTask;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        iPerformanceReportTask.setResultMsg(errMsg);
        IPerformanceReportTask iPerformanceReportTask2 = this$0.guildJoinReportTask;
        IGProJoinGuildSetting iGProJoinGuildSetting = this$0.joinGuildSetting;
        if (iGProJoinGuildSetting != null) {
            num = Integer.valueOf(iGProJoinGuildSetting.getOptionType());
        } else {
            num = null;
        }
        iPerformanceReportTask2.setParam("join_option", String.valueOf(num));
        this$0.guildJoinReportTask.report();
        this$0.callback.a(i3, errMsg, iGProSecurityResult, iGProJoinGuildResult);
    }

    private final void j(IGProJoinGuildSetting addGuildOption) {
        Logger.f235387a.d().i("Guild.join.HandleJoinGuildOptionStep", 1, "showAnswerQuestionDialog page:" + this.pageFlag + " addGuildOption=" + addGuildOption);
        Intrinsics.checkNotNull(addGuildOption);
        k(addGuildOption);
    }

    private final void k(IGProJoinGuildSetting addGuildOption) {
        Logger.f235387a.d().i("Guild.join.HandleJoinGuildOptionStep", 1, "[showJoinGuildDialogWithNewActivity] page:" + this.pageFlag + " addGuildOption=" + addGuildOption);
        JoinGuildVerifyFragment.INSTANCE.a(this.context, this.param, addGuildOption, this.guildJoinReportTask, new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.v
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                w.l(w.this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(w this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.a(i3, str, iGProSecurityResult, iGProJoinGuildResult);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final JumpGuildParam getParam() {
        return this.param;
    }

    public final void m() {
        if (g(this.joinGuildSetting)) {
            this.guildJoinReportTask.setStageCode("stage_answer_question_dialog");
            j(this.joinGuildSetting);
        } else {
            this.guildJoinReportTask.setStageCode("stage_send_join_guild_cmd");
            h();
        }
    }
}
