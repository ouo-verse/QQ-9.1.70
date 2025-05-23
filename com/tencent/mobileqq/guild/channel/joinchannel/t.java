package com.tencent.mobileqq.guild.channel.joinchannel;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.mobileqq.qqguildsdk.data.genc.au;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ar;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0002\u0012\u0018B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u0004R\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/t;", "", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "", "g", "i", "f", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "joinGuildSetting", "d", "k", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "b", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "getParam", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "Lcom/tencent/mobileqq/guild/channel/joinchannel/t$b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/t$b;", "getCallback", "()Lcom/tencent/mobileqq/guild/channel/joinchannel/t$b;", "callback", "", "Z", "mHasFinish", "e", "I", "mQueryAddGuildResult", "mQueryAddGuildErrMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "mJoinGuildSetting", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Lcom/tencent/mobileqq/guild/channel/joinchannel/t$b;)V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class t {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam param;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mHasFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mQueryAddGuildResult;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mQueryAddGuildErrMsg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProJoinGuildSetting mJoinGuildSetting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/t$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "", "a", "", "INIT_RESULT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.t$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull IGProJoinGuildSetting iGProJoinGuildSetting) {
            Intrinsics.checkNotNullParameter(iGProJoinGuildSetting, "<this>");
            int optionType = iGProJoinGuildSetting.getOptionType();
            if (optionType != 2 && optionType != 5 && optionType != 6 && optionType != 7) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/t$b;", "", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "addGuildOption", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(int result, @NotNull String errMsg, @Nullable IGProSecurityResult security, @Nullable IGProJoinGuildSetting addGuildOption);
    }

    public t(@NotNull String guildId, @NotNull JumpGuildParam param, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.guildId = guildId;
        this.param = param;
        this.callback = callback;
        this.mQueryAddGuildResult = -1;
        this.mQueryAddGuildErrMsg = "";
    }

    private final void d(int result, String errMsg, IGProSecurityResult security, IGProJoinGuildSetting joinGuildSetting) {
        if (!this.mHasFinish) {
            this.mHasFinish = true;
            this.callback.a(result, errMsg, security, joinGuildSetting);
            Logger.f235387a.d().i("Guild.join.StepGetJoinGuildOption", 1, "handleCallback code=" + result + " errMsg=" + errMsg + " joinGuildSetting=" + joinGuildSetting);
        }
    }

    static /* synthetic */ void e(t tVar, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildSetting iGProJoinGuildSetting, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            iGProJoinGuildSetting = null;
        }
        tVar.d(i3, str, iGProSecurityResult, iGProJoinGuildSetting);
    }

    private final void f() {
        IGProJoinGuildSetting iGProJoinGuildSetting;
        if (this.mQueryAddGuildResult != -1 && (iGProJoinGuildSetting = this.mJoinGuildSetting) != null) {
            if (this.mHasFinish) {
                QLog.w("Guild.join.StepGetJoinGuildOption", 1, "handleNextStep mHasFinish");
                return;
            }
            Intrinsics.checkNotNull(iGProJoinGuildSetting);
            int optionType = iGProJoinGuildSetting.getOptionType();
            if (optionType != 2) {
                if (optionType != 3) {
                    if (optionType != 5) {
                        d(0, "", null, this.mJoinGuildSetting);
                        return;
                    }
                } else {
                    String string = BaseApplication.getContext().getString(R.string.f147070vw);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026uild_join_nobody_allowed)");
                    e(this, 3, string, null, null, 8, null);
                    return;
                }
            }
            int i3 = this.mQueryAddGuildResult;
            if (i3 == 22008) {
                d(i3, this.mQueryAddGuildErrMsg, null, this.mJoinGuildSetting);
            } else {
                d(0, "", null, this.mJoinGuildSetting);
            }
        }
    }

    private final void g(IGPSService service) {
        au auVar = new au();
        auVar.e(Long.parseLong(this.guildId));
        String arkInviteCode = this.param.getJoinInfoParam().getArkInviteCode();
        String str = "";
        if (arkInviteCode == null) {
            arkInviteCode = "";
        }
        auVar.f(arkInviteCode);
        String arkContentId = this.param.getJoinInfoParam().getArkContentId();
        if (arkContentId != null) {
            str = arkContentId;
        }
        auVar.d(str);
        Logger.f235387a.d().d("Guild.join.StepGetJoinGuildOption", 1, "[newFetchJoinGuildOption] guildId " + getGuildId() + ", inviteCode " + auVar.c() + ", contentId " + auVar.a());
        service.fetchJoinGuildOption(auVar, new ar() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.s
            @Override // wh2.ar
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProFetchJoinGuildOptionRsp iGProFetchJoinGuildOptionRsp) {
                t.h(t.this, i3, str2, iGProSecurityResult, iGProFetchJoinGuildOptionRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(t this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProFetchJoinGuildOptionRsp iGProFetchJoinGuildOptionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && iGProFetchJoinGuildOptionRsp != null && iGProFetchJoinGuildOptionRsp.getSettingInfo() != null && (iGProSecurityResult == null || iGProSecurityResult.get$actionCode() == 0)) {
            Logger.f235387a.d().i("Guild.join.StepGetJoinGuildOption", 1, "FetchJoinGuildOption result=" + iGProFetchJoinGuildOptionRsp);
            this$0.mJoinGuildSetting = iGProFetchJoinGuildOptionRsp.getSettingInfo();
            this$0.f();
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "FetchJoinGuildOption getAddGuildOption=" + this$0.getGuildId() + " result=" + i3 + " errMsg=" + str + " rsp=" + iGProFetchJoinGuildOptionRsp;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.join.StepGetJoinGuildOption", 1, (String) it.next(), null);
        }
        String string = BaseApplication.getContext().getString(R.string.f138610_1);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R.string.guild_add_error)");
        e(this$0, i3, string, iGProSecurityResult, null, 8, null);
    }

    private final void i(IGPSService service) {
        service.queryApplyAddGuildStatus(this.guildId, new dv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.r
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                t.j(t.this, i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(t this$0, int i3, String errMsg, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("Guild.join.StepGetJoinGuildOption", 1, "queryApplyAddGuildStatus result=" + i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        com.tencent.mobileqq.guild.performance.report.h.c("queryApplyAddGuildStatus", i3, errMsg, null, 8, null);
        this$0.mQueryAddGuildResult = i3;
        this$0.mQueryAddGuildErrMsg = errMsg;
        if (i3 != 0) {
            if (i3 != 22008) {
                e(this$0, i3, errMsg, iGProSecurityResult, null, 8, null);
                return;
            } else {
                this$0.f();
                return;
            }
        }
        this$0.f();
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public final void k() {
        IGPSService service = (IGPSService) ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(service, "service");
        i(service);
        g(service);
    }
}
