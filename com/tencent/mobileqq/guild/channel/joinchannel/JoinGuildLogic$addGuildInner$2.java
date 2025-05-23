package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.channel.joinchannel.t;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vh2.bv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class JoinGuildLogic$addGuildInner$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ bv $callback;
    final /* synthetic */ JoinGuildLogic.JumpParam $jumpParam;
    final /* synthetic */ JumpGuildParam $param;
    final /* synthetic */ JoinGuildLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildLogic$addGuildInner$2(JumpGuildParam jumpGuildParam, JoinGuildLogic joinGuildLogic, bv bvVar, JoinGuildLogic.JumpParam jumpParam) {
        super(0);
        this.$param = jumpGuildParam;
        this.this$0 = joinGuildLogic;
        this.$callback = bvVar;
        this.$jumpParam = jumpParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final JoinGuildLogic this$0, final bv callback, JumpGuildParam param, final JoinGuildLogic.JumpParam jumpParam, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, IGProJoinGuildSetting iGProJoinGuildSetting) {
        IPerformanceReportTask iPerformanceReportTask;
        IPerformanceReportTask iPerformanceReportTask2;
        IPerformanceReportTask iPerformanceReportTask3;
        IPerformanceReportTask iPerformanceReportTask4;
        IPerformanceReportTask iPerformanceReportTask5;
        IPerformanceReportTask iPerformanceReportTask6;
        IPerformanceReportTask iPerformanceReportTask7;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(jumpParam, "$jumpParam");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Integer num = null;
        if (i3 != 0) {
            iPerformanceReportTask5 = this$0.step2GetJoinGuildOptionReport;
            if (iPerformanceReportTask5 != null) {
                iPerformanceReportTask5.setResultCode(i3);
            }
            iPerformanceReportTask6 = this$0.step2GetJoinGuildOptionReport;
            if (iPerformanceReportTask6 != null) {
                iPerformanceReportTask6.setResultMsg(errMsg);
            }
            iPerformanceReportTask7 = this$0.step2GetJoinGuildOptionReport;
            if (iPerformanceReportTask7 != null) {
                iPerformanceReportTask7.report();
            }
            com.tencent.mobileqq.guild.performance.report.h.d(i3, errMsg);
            callback.a(i3, errMsg, iGProSecurityResult, null);
            return;
        }
        iPerformanceReportTask = this$0.step2GetJoinGuildOptionReport;
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(0L);
        }
        iPerformanceReportTask2 = this$0.step2GetJoinGuildOptionReport;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask2.report();
        }
        iPerformanceReportTask3 = this$0.step2GetJoinGuildOptionReport;
        if (iPerformanceReportTask3 == null || (iPerformanceReportTask4 = iPerformanceReportTask3.duplicate("guild_id")) == null) {
            iPerformanceReportTask4 = DummyPerformanceReportTask.INSTANCE;
        }
        IPerformanceReportTask iPerformanceReportTask8 = iPerformanceReportTask4;
        if (iGProJoinGuildSetting != null) {
            num = Integer.valueOf(iGProJoinGuildSetting.getOptionType());
        }
        iPerformanceReportTask8.setParam("join_option", String.valueOf(num));
        new w(this$0.getContext(), param, this$0.getPageFlag(), jumpParam, iGProJoinGuildSetting, iPerformanceReportTask8, new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.f
            @Override // vh2.bv
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult2, IGProJoinGuildResult iGProJoinGuildResult) {
                JoinGuildLogic$addGuildInner$2.d(JoinGuildLogic.JumpParam.this, this$0, callback, i16, str, iGProSecurityResult2, iGProJoinGuildResult);
            }
        }).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(JoinGuildLogic.JumpParam jumpParam, JoinGuildLogic this$0, final bv callback, final int i3, final String str, final IGProSecurityResult iGProSecurityResult, final IGProJoinGuildResult iGProJoinGuildResult) {
        String str2;
        JumpGuildParam jumpGuildParam;
        JumpGuildParam jumpGuildParam2;
        JumpGuildParam jumpGuildParam3;
        Intrinsics.checkNotNullParameter(jumpParam, "$jumpParam");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JumpGuildParam jumpGuildParam4 = null;
        if (h.d(i3, iGProSecurityResult)) {
            jumpParam.b(iGProJoinGuildResult);
            Context context = this$0.getContext();
            jumpGuildParam3 = this$0.jumpGuildParam;
            if (jumpGuildParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                jumpGuildParam3 = null;
            }
            new x(context, jumpGuildParam3).d();
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.tencent.mobileqq.guild.performance.report.h.d(i3, str2);
        jumpGuildParam = this$0.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String str3 = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str3, "jumpGuildParam.guildId");
        jumpGuildParam2 = this$0.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam4 = jumpGuildParam2;
        }
        new a(str3, jumpGuildParam4.getChannelId(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic$addGuildInner$2$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void invoke(boolean z16) {
                bv.this.a(i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }).l(true);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str = this.$param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        final JumpGuildParam jumpGuildParam = this.$param;
        final JoinGuildLogic joinGuildLogic = this.this$0;
        final bv bvVar = this.$callback;
        final JoinGuildLogic.JumpParam jumpParam = this.$jumpParam;
        new t(str, jumpGuildParam, new t.b() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.e
            @Override // com.tencent.mobileqq.guild.channel.joinchannel.t.b
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildSetting iGProJoinGuildSetting) {
                JoinGuildLogic$addGuildInner$2.c(JoinGuildLogic.this, bvVar, jumpGuildParam, jumpParam, i3, str2, iGProSecurityResult, iGProJoinGuildSetting);
            }
        }).k();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
