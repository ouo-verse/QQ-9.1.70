package mp0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.util.k;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mp0.e;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016\u00a8\u0006\u001e"}, d2 = {"Lmp0/i;", "Lpn0/a;", "Lmp0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "r", "Landroid/content/Context;", "context", "", "t", "", "errorCode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityInfo", ReportConstant.COSTREPORT_PREFIX, "security", "p", "Lcom/tencent/aio/api/runtime/a;", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i extends pn0.a<e, GuildAioDefaultInputUIState> {
    private final boolean p(IGProSecurityResult security) {
        if (security != null && security.get$actionCode() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r() {
        return ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isInLiveChannel(((com.tencent.aio.api.runtime.a) getMContext()).g().n());
    }

    private final boolean s(int errorCode, IGProSecurityResult securityInfo) {
        if (p(securityInfo) && (errorCode == 0 || errorCode == 22004)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(final Context context) {
        boolean z16;
        AppInterface appInterface;
        k kVar = k.f112410a;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        final JumpGuildParam a16 = kVar.a(g16);
        String joinSignature = a16.getJoinInfoParam().getJoinSignature();
        if (joinSignature != null && joinSignature.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !TextUtils.isEmpty(a16.guildId)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IQQGuildService.class, "");
            }
            IQQGuildService iQQGuildService = (IQQGuildService) iRuntimeService;
            if (iQQGuildService != null) {
                iQQGuildService.addGuild(context, a16, "GuildAioInput.GuestVM", new bv() { // from class: mp0.h
                    @Override // vh2.bv
                    public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                        i.u(JumpGuildParam.this, this, context, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("GuildAioInput.GuestVM", 1, "join Guild arg error! guildId = ", a16.guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(JumpGuildParam jumpGuildParam, i this$0, Context context, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "$jumpGuildParam");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.d("GuildAioInput.GuestVM", 1, "join guild. guildId = ", jumpGuildParam.guildId, " code=", Integer.valueOf(i3), " msg=", str);
        if (!this$0.s(i3, iGProSecurityResult)) {
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).handleJoinGuildError(context, i3, str, iGProSecurityResult);
            return;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, channelId));
        QLog.i("GuildAioInput.GuestVM", 1, "[handleIntent] permissions = " + guildPermissionsChange.getPermissions());
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(guildPermissionsChange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            updateUI(new GuildAioDefaultInputUIState.GuildHandlerPermissionsChange(((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions(), null, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()), 2, null));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName());
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.a) {
            t(((e.a) intent).getContext());
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        updateUI(new GuildAioDefaultInputUIState.StyleUpdateEvent(r()));
    }
}
