package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import bq1.JoinInfoParamData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\u000f%\u0015B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010$J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "jumpParam", "Lvh2/bv;", "callback", "", tl.h.F, "jumpGuildParam", "joinAfterAction", "g", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "i", "()Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "pageFlag", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "Lvh2/bv;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "f", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "step2GetJoinGuildOptionReport", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "JoinGuildResultEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class JoinGuildLogic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageFlag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private JumpGuildParam jumpGuildParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private JumpParam jumpParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private bv callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask step2GetJoinGuildOptionReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$JoinGuildResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "result", "", "errMsg", "security", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "joinResult", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;)V", "getErrMsg", "()Ljava/lang/String;", "getGuildId", "getJoinResult", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "getResult", "()I", "getSecurity", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class JoinGuildResultEvent extends SimpleBaseEvent {

        @Nullable
        private final String errMsg;

        @NotNull
        private final String guildId;

        @Nullable
        private final IGProJoinGuildResult joinResult;
        private final int result;

        @Nullable
        private final IGProSecurityResult security;

        public JoinGuildResultEvent(@NotNull String guildId, int i3, @Nullable String str, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildId = guildId;
            this.result = i3;
            this.errMsg = str;
            this.security = iGProSecurityResult;
            this.joinResult = iGProJoinGuildResult;
        }

        @Nullable
        public final String getErrMsg() {
            return this.errMsg;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        @Nullable
        public final IGProJoinGuildResult getJoinResult() {
            return this.joinResult;
        }

        public final int getResult() {
            return this.result;
        }

        @Nullable
        public final IGProSecurityResult getSecurity() {
            return this.security;
        }

        @NotNull
        public String toString() {
            return "JoinGuildResultEvent(guildId=" + this.guildId + ", result=" + this.result + ", errMsg=" + this.errMsg + ", security=" + this.security + ", joinResult=" + this.joinResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0005\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\r\u0010\u0017R(\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u0019\u0010\n\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$b;", "", "", "toString", "", "a", "Z", "getJump2AIO", "()Z", "c", "(Z)V", "jump2AIO", "", "b", "I", "getJoinPageSource", "()I", "(I)V", "joinPageSource", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "getJoinResult", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;)V", "joinResult", "d", "getNeedJumpToSuccessDialog", "getNeedJumpToSuccessDialog$annotations", "()V", "needJumpToSuccessDialog", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final class JumpParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean jump2AIO;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int joinPageSource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private IGProJoinGuildResult joinResult;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean needJumpToSuccessDialog;

        public final void a(int i3) {
            this.joinPageSource = i3;
        }

        public final void b(@Nullable IGProJoinGuildResult iGProJoinGuildResult) {
            this.joinResult = iGProJoinGuildResult;
        }

        public final void c(boolean z16) {
            this.jump2AIO = z16;
        }

        public final void d(boolean z16) {
            this.needJumpToSuccessDialog = z16;
        }

        @NotNull
        public String toString() {
            return "JumpParam(jump2AIO=" + this.jump2AIO + ", joinPageSource=" + this.joinPageSource + ", joinResult=" + this.joinResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/JoinGuildLogic$c", "Lvh2/bv;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "joinResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements bv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JumpGuildParam f214965a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JoinGuildLogic f214966b;

        c(JumpGuildParam jumpGuildParam, JoinGuildLogic joinGuildLogic) {
            this.f214965a = jumpGuildParam;
            this.f214966b = joinGuildLogic;
        }

        @Override // vh2.bv
        public void a(int result, @Nullable String errMsg, @Nullable IGProSecurityResult security, @Nullable IGProJoinGuildResult joinResult) {
            Logger logger = Logger.f235387a;
            JoinGuildLogic joinGuildLogic = this.f214966b;
            JumpGuildParam jumpGuildParam = this.f214965a;
            logger.d().i("Guild.join.JoinGuildLogic", 1, "addGuildAndJump2AIO onResult page:" + joinGuildLogic.getPageFlag() + " result:" + result + " errMsg:" + errMsg + " security:" + security + " guildId:" + jumpGuildParam.guildId);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = this.f214965a.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            simpleEventBus.dispatchEvent(new JoinGuildResultEvent(str, result, errMsg, security, joinResult), true);
            if (h.d(result, security)) {
                return;
            }
            h.c(this.f214966b.getContext(), result, errMsg, security);
        }
    }

    public JoinGuildLogic(@NotNull Context context, @NotNull String pageFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageFlag, "pageFlag");
        this.context = context;
        this.pageFlag = pageFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function4 tmp0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, iGProSecurityResult, iGProJoinGuildResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(JumpGuildParam param, JumpParam jumpParam, bv callback) {
        this.jumpGuildParam = param;
        this.jumpParam = jumpParam;
        this.callback = callback;
        String str = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        com.tencent.mobileqq.guild.performance.report.h.e(str, this.pageFlag);
        Logger.f235387a.d().i("Guild.join.JoinGuildLogic", 1, "startJoin pageFlag:" + getPageFlag() + " jumpParam=" + jumpParam + " param:" + param);
        String str2 = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "param.guildId");
        new RiskGuildTipsIntercept(str2, this.context, new JoinGuildLogic$addGuildInner$2(param, this, callback, jumpParam)).q();
    }

    public final void e(@NotNull JumpGuildParam param, @NotNull JumpParam joinAfterAction, @Nullable final bv callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(joinAfterAction, "joinAfterAction");
        IPerformanceReportTask stageCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_join").setStageCode("stage_start");
        String str = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        IPerformanceReportTask param2 = stageCode.setParam("guild_id", str);
        String mainSource = param.getMainSource();
        Intrinsics.checkNotNullExpressionValue(mainSource, "param.mainSource");
        IPerformanceReportTask enterFrom = param2.setEnterFrom(mainSource);
        String subSource = param.getSubSource();
        Intrinsics.checkNotNullExpressionValue(subSource, "param.subSource");
        IPerformanceReportTask report = enterFrom.setAppChannel(subSource).report();
        Logger.f235387a.d().i("Guild.join.JoinGuildLogic", 1, "addGuild traceId=" + report.getTraceId() + " pageFlag:" + getPageFlag() + " jumpGuildParam:" + param + " joinAfterAction:" + joinAfterAction);
        this.step2GetJoinGuildOptionReport = report.duplicate("guild_id").setStageCode("stage_get_join_guild_option");
        final Function4<Integer, String, IGProSecurityResult, IGProJoinGuildResult, Unit> function4 = new Function4<Integer, String, IGProSecurityResult, IGProJoinGuildResult, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic$addGuild$callbackWrapper$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                invoke(num.intValue(), str2, iGProSecurityResult, iGProJoinGuildResult);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable String str2, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable IGProJoinGuildResult iGProJoinGuildResult) {
                JumpGuildParam jumpGuildParam;
                JumpGuildParam jumpGuildParam2;
                Logger logger = Logger.f235387a;
                JoinGuildLogic joinGuildLogic = JoinGuildLogic.this;
                bv bvVar = callback;
                Logger.a d16 = logger.d();
                String pageFlag = joinGuildLogic.getPageFlag();
                jumpGuildParam = joinGuildLogic.jumpGuildParam;
                Unit unit = null;
                if (jumpGuildParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                    jumpGuildParam = null;
                }
                d16.i("Guild.join.JoinGuildLogic", 1, "addGuild onResult page:" + pageFlag + " result:" + i3 + " errMsg:" + str2 + " security:" + iGProSecurityResult + " guildId:" + jumpGuildParam.guildId + " " + (bvVar == null ? "inner" : "external callback"));
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                jumpGuildParam2 = JoinGuildLogic.this.jumpGuildParam;
                if (jumpGuildParam2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                    jumpGuildParam2 = null;
                }
                String str3 = jumpGuildParam2.guildId;
                Intrinsics.checkNotNullExpressionValue(str3, "jumpGuildParam.guildId");
                simpleEventBus.dispatchEvent(new JoinGuildLogic.JoinGuildResultEvent(str3, i3, str2, iGProSecurityResult, iGProJoinGuildResult), true);
                bv bvVar2 = callback;
                if (bvVar2 != null) {
                    bvVar2.a(i3, str2, iGProSecurityResult, iGProJoinGuildResult);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    JoinGuildLogic joinGuildLogic2 = JoinGuildLogic.this;
                    if (h.d(i3, iGProSecurityResult)) {
                        return;
                    }
                    h.c(joinGuildLogic2.getContext(), i3, str2, iGProSecurityResult);
                }
            }
        };
        if (bq1.b.c(param)) {
            JoinInfoParamData b16 = bq1.b.b(param);
            String guildId = b16.getGuildId();
            String channelId = b16.getChannelId();
            int businessType = b16.getBusinessType();
            String inviteCode = b16.getInviteCode();
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "Guild.join.JoinGuildLogic fetchGuildAndChannelInfo", null, null, null, new JoinGuildLogic$addGuild$2(guildId, channelId, businessType, inviteCode, param, this, joinAfterAction, function4, null), 14, null);
                return;
            }
            return;
        }
        h(param, joinAfterAction, new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.c
            @Override // vh2.bv
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                JoinGuildLogic.f(Function4.this, i3, str2, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    public final void g(@NotNull JumpGuildParam jumpGuildParam, @NotNull JumpParam joinAfterAction) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Intrinsics.checkNotNullParameter(joinAfterAction, "joinAfterAction");
        joinAfterAction.c(true);
        IPerformanceReportTask stageCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_join").setStageCode("stage_start");
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        IPerformanceReportTask param = stageCode.setParam("guild_id", str);
        String mainSource = jumpGuildParam.getMainSource();
        Intrinsics.checkNotNullExpressionValue(mainSource, "jumpGuildParam.mainSource");
        IPerformanceReportTask enterFrom = param.setEnterFrom(mainSource);
        String subSource = jumpGuildParam.getSubSource();
        Intrinsics.checkNotNullExpressionValue(subSource, "jumpGuildParam.subSource");
        IPerformanceReportTask report = enterFrom.setAppChannel(subSource).report();
        Logger.f235387a.d().i("Guild.join.JoinGuildLogic", 1, "addGuildAndJump2AIO traceId=" + report.getTraceId() + " pageFlag:" + getPageFlag() + " jumpGuildParam:" + jumpGuildParam + " joinAfterAction:" + joinAfterAction);
        this.step2GetJoinGuildOptionReport = report.duplicate("guild_id").setStageCode("stage_get_join_guild_option");
        h(jumpGuildParam, joinAfterAction, new c(jumpGuildParam, this));
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getPageFlag() {
        return this.pageFlag;
    }
}
