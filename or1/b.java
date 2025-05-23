package or1;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IQQGuildVisitorApi;
import com.tencent.mobileqq.guild.config.subconfig.parser.h;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001e\u00a8\u0006("}, d2 = {"Lor1/b;", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "", "j", "l", "", "k", "", "callFrom", DomainData.DOMAIN_NAME, "b", "a", "Landroid/app/Activity;", "Landroid/app/Activity;", "context", "Ljava/lang/String;", "pageTag", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "d", "J", "timeLimit", "e", "timeCost", "f", "startTime", "g", "Z", "hasShowJoinGuild", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "runnable", "i", "taskRunning", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements IQQGuildVisitorApi.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Activity context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam jumpGuildParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long timeLimit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long timeCost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowJoinGuild;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable runnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean taskRunning;

    public b(@Nullable Activity activity, @NotNull String pageTag, @NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(pageTag, "pageTag");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        this.context = activity;
        this.pageTag = pageTag;
        this.jumpGuildParam = jumpGuildParam;
        this.timeLimit = 30000L;
        j();
        l();
        tg1.a a16 = ch.E().a(102);
        if (a16 instanceof h.GuildVisitorConfigBean) {
            h.GuildVisitorConfigBean guildVisitorConfigBean = (h.GuildVisitorConfigBean) a16;
            if (guildVisitorConfigBean.getChannelShowJoinDialogDelayTime() > 0) {
                this.timeLimit = guildVisitorConfigBean.getChannelShowJoinDialogDelayTime();
            }
        }
        n("init");
    }

    private final void j() {
        boolean z16;
        String channelId = this.jumpGuildParam.getChannelId();
        if (channelId != null && channelId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            AppRuntime m3 = ch.m();
            JumpGuildParam jumpGuildParam = this.jumpGuildParam;
            IGProChannelInfo C = ch.C(m3, jumpGuildParam.guildId, jumpGuildParam.getChannelId());
            if (C != null) {
                this.jumpGuildParam.getJoinInfoParam().setPageEntranceId(QQGuildJumpSource.a(C.getType(), C.getApplicationId()));
                return;
            }
        }
        this.jumpGuildParam.getJoinInfoParam().setPageEntranceId(4);
    }

    private final boolean k() {
        return false;
    }

    private final void l() {
        this.runnable = new Runnable() { // from class: or1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.m(b.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.taskRunning = false;
        if (this$0.hasShowJoinGuild) {
            Logger.f235387a.d().i("Guild.MF.Vst.VisitorJoinGuildTimerTask", 1, "already show join guild pageTag=" + this$0.pageTag + " guildId=" + this$0.jumpGuildParam.guildId);
            return;
        }
        if (!this$0.k()) {
            Logger.f235387a.d().i("Guild.MF.Vst.VisitorJoinGuildTimerTask", 1, "not guest pageTag=" + this$0.pageTag + " guildId=" + this$0.jumpGuildParam.guildId);
            return;
        }
        this$0.hasShowJoinGuild = true;
        this$0.jumpGuildParam.getExtras().putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 2);
        if (this$0.context == null) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(BaseApplication.getContext(), this$0.jumpGuildParam, HardCodeUtil.qqStr(R.string.f147280wg));
        } else {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(this$0.context, this$0.jumpGuildParam, HardCodeUtil.qqStr(R.string.f147280wg));
        }
    }

    private final void n(String callFrom) {
        if (!k()) {
            return;
        }
        this.startTime = System.currentTimeMillis();
        Runnable runnable = this.runnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, this.timeLimit - this.timeCost);
        }
        this.taskRunning = true;
        Logger.f235387a.d().i("Guild.MF.Vst.VisitorJoinGuildTimerTask", 1, "run task after" + (this.timeLimit - this.timeCost) + "ms pageTag=" + this.pageTag + " guildId=" + this.jumpGuildParam.guildId + " timeLimit=" + this.timeLimit + " hasShowJoinGuild=" + this.hasShowJoinGuild + " callFrom=" + callFrom);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildVisitorApi.a
    public void a() {
        Logger.f235387a.d().i("Guild.MF.Vst.VisitorJoinGuildTimerTask", 1, "pauseTimer pageTag=" + this.pageTag + " guildId=" + this.jumpGuildParam.guildId);
        Runnable runnable = this.runnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        if (this.startTime > 0) {
            this.timeCost += System.currentTimeMillis() - this.startTime;
        }
        this.startTime = 0L;
        this.taskRunning = false;
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildVisitorApi.a
    public void b() {
        if (!this.hasShowJoinGuild && !this.taskRunning) {
            n("resumeTimer");
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Vst.VisitorJoinGuildTimerTask", 2, "resumeTimer pageTag=" + this.pageTag + " guildId=" + this.jumpGuildParam.guildId + " hasShowJoinGuild=" + this.hasShowJoinGuild + " taskRunning=" + this.taskRunning);
        }
    }
}
