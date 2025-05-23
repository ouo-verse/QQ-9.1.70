package ms1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0002\u0019\u000fB!\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\b\b\u0002\u0010'\u001a\u00020#\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u0017\u0010\u001d\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lms1/b;", "Lls1/a;", "Lms1/b$a;", "jumpInfo", "", "e", h.F, "f", "g", "i", "j", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "l", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAppChnnPreInfo;", "preInfo", "b", "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "k", "", "source", "Landroid/content/Context;", "c", "context", "", "jump", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "extras", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "contextRef", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Landroid/os/Bundle;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements ls1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extras;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<Context> contextRef;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lms1/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "I", "()I", "jumpType", "<init>", "(Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ms1.b$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class AppChannelJumpInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int jumpType;

        public AppChannelJumpInfo(@NotNull String jumpUrl, int i3) {
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.jumpUrl = jumpUrl;
            this.jumpType = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getJumpType() {
            return this.jumpType;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppChannelJumpInfo)) {
                return false;
            }
            AppChannelJumpInfo appChannelJumpInfo = (AppChannelJumpInfo) other;
            if (Intrinsics.areEqual(this.jumpUrl, appChannelJumpInfo.jumpUrl) && this.jumpType == appChannelJumpInfo.jumpType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.jumpUrl.hashCode() * 31) + this.jumpType;
        }

        @NotNull
        public String toString() {
            return "AppChannelJumpInfo(jumpUrl=" + this.jumpUrl + ", jumpType=" + this.jumpType + ")";
        }
    }

    public b(@NotNull String guildId, @NotNull IGProChannelInfo channelInfo, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.guildId = guildId;
        this.channelInfo = channelInfo;
        this.extras = extras;
        this.contextRef = new WeakReference<>(null);
    }

    private final AppChannelJumpInfo b(IGProAppChnnPreInfo preInfo) {
        Object m476constructorimpl;
        Integer valueOf;
        Object m476constructorimpl2;
        int appChannelJumpType;
        String str;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (preInfo != null) {
                str = preInfo.getJumpUrl();
            } else {
                str = null;
            }
            m476constructorimpl = Result.m476constructorimpl(str);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        String str2 = (String) m476constructorimpl;
        if (str2 == null) {
            str2 = this.channelInfo.getAppChannelJumpUrl();
        }
        if (str2 == null) {
            str2 = "";
        }
        if (preInfo != null) {
            try {
                valueOf = Integer.valueOf(preInfo.getJumpType());
            } catch (Throwable th6) {
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
            }
        } else {
            valueOf = null;
        }
        m476constructorimpl2 = Result.m476constructorimpl(valueOf);
        if (!Result.m482isFailureimpl(m476constructorimpl2)) {
            obj = m476constructorimpl2;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            appChannelJumpType = num.intValue();
        } else {
            appChannelJumpType = this.channelInfo.getAppChannelJumpType();
        }
        return new AppChannelJumpInfo(str2, appChannelJumpType);
    }

    private final Context c(String source) {
        Context context = this.contextRef.get();
        if (context == null) {
            Logger.f235387a.d().w("Guild.jump.AppChannelStrategy", 1, "getContext(" + source + ") contextRef.get() is null");
            return null;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, String str, Context context, int i3, String str2) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProAppChnnPreInfo appChnnPreInfo = ((IGPSService) S0).getAppChnnPreInfo(this$0.guildId, str);
        if (appChnnPreInfo != null) {
            String jumpUrl = appChnnPreInfo.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "preInfo.jumpUrl");
            isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
            if (!isBlank) {
                String jumpUrl2 = appChnnPreInfo.getJumpUrl();
                Intrinsics.checkNotNullExpressionValue(jumpUrl2, "preInfo.jumpUrl");
                this$0.e(new AppChannelJumpInfo(jumpUrl2, appChnnPreInfo.getJumpType()));
                return;
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str3 = "AppChannelStrategy::jump() jumpUrl is blank, " + i3 + ", " + str2;
        if (str3 instanceof String) {
            bVar.a().add(str3);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.AppChannelStrategy", 1, (String) it.next(), null);
        }
    }

    private final void e(AppChannelJumpInfo jumpInfo) {
        int jumpType = jumpInfo.getJumpType();
        if (jumpType != 1) {
            if (jumpType != 2) {
                if (jumpType != 3) {
                    if (jumpType != 5) {
                        j();
                        return;
                    } else {
                        h(jumpInfo);
                        return;
                    }
                }
                f(jumpInfo);
                return;
            }
            g(jumpInfo);
            return;
        }
        i(jumpInfo);
    }

    private final void f(AppChannelJumpInfo jumpInfo) {
        Context c16 = c("jumpApplets");
        if (c16 == null) {
            return;
        }
        GuildClientParams k3 = k(jumpInfo);
        EntryModel entryModel = new EntryModel();
        entryModel.type = -1;
        entryModel.titlebarIconUrl = k3.E();
        Bundle bundle = new Bundle();
        bundle.putString("extra_guild_id", k3.G());
        bundle.putString("extra_channel_id", k3.u());
        bundle.putBoolean("extra_key_is_guest", k3.M());
        bundle.putLong("extra_app_id", k3.q());
        entryModel.mArguments = bundle;
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(c16, k3.V(), 5002, entryModel, null)) {
            r rVar = r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(this.guildId);
            if (guildInfo == null) {
                return;
            }
            k02.d.a(guildInfo, this.channelInfo, !guildInfo.isMember());
        }
    }

    private final void g(AppChannelJumpInfo jumpInfo) {
        boolean z16;
        Context c16 = c("jumpH5");
        if (c16 == null) {
            return;
        }
        GuildClientParams k3 = k(jumpInfo);
        if (((int) this.channelInfo.getApplicationId()) == 9999999) {
            kg1.a.c(c16, k3);
            return;
        }
        if (k3.q() == 1000101) {
            z16 = true;
        } else {
            z16 = false;
        }
        ch.n1((Activity) c16, k3.V(), k3.v(), k3.E(), true, z16);
    }

    private final void h(AppChannelJumpInfo jumpInfo) {
        Context c16 = c("jumpHippy");
        if (c16 == null) {
            return;
        }
        ch.N0(c16, jumpInfo.getJumpUrl());
    }

    private final void i(AppChannelJumpInfo jumpInfo) {
        Context c16 = c("jumpNative");
        if (c16 == null) {
            return;
        }
        JumpGuildParam l3 = l(jumpInfo);
        Logger.f235387a.d().i("Guild.jump.AppChannelStrategy", 1, "AppChannelStrategy::jumpNative() jumpParam = " + l3);
        GuildBlankActivity.b.a(c16, l3);
    }

    private final void j() {
        String channelUin = this.channelInfo.getChannelUin();
        Context c16 = c("jumpWithDefaultAction");
        if (c16 == null) {
            return;
        }
        GuildJumpUtil.z(c16, this.guildId, channelUin, null, null, 16, null);
    }

    private final GuildClientParams k(AppChannelJumpInfo jumpInfo) {
        String str;
        int applicationId = (int) this.channelInfo.getApplicationId();
        String channelUin = this.channelInfo.getChannelUin();
        String channelName = this.channelInfo.getChannelName();
        r rVar = r.f214743a;
        String str2 = "";
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(this.guildId);
        if (guildInfo != null) {
            str = guildInfo.getAvatarUrl(100);
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        GuildClientParams e16 = new GuildClientParams().a(applicationId).d0(BundleKt.bundleOf(TuplesKt.to("guild_id", this.guildId))).e0(this.guildId).i0(jumpInfo.getJumpType()).f(channelUin).g(channelName).c0(str2).j0(jumpInfo.getJumpUrl()).g0(false).e();
        GuildJumpDebugUtils.a("Guild.jump.AppChannelStrategy", "AppChannelStrategy::newGuildClientParams() ret = ", e16);
        Intrinsics.checkNotNullExpressionValue(e16, "GuildClientParams()\n    \u2026et = \", it)\n            }");
        return e16;
    }

    private final JumpGuildParam l(AppChannelJumpInfo jumpInfo) {
        String channelUin = this.channelInfo.getChannelUin();
        JumpGuildParam jumpGuildParam = new JumpGuildParam(this.guildId, channelUin);
        jumpGuildParam.extras.putAll(this.extras);
        if (!jumpGuildParam.extras.containsKey(AppConstants.Key.COLUMN_MSG_SENDER_UIN)) {
            jumpGuildParam.extras.putString(AppConstants.Key.COLUMN_MSG_SENDER_UIN, "");
        }
        if (!jumpGuildParam.extras.containsKey(JumpGuildParam.EXTRA_KEY_OPEN_FROM)) {
            jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 1);
        }
        JumpGuildParam.JoinInfoParam loadFrom = JumpGuildParam.JoinInfoParam.loadFrom(jumpGuildParam.extras);
        if (loadFrom != null) {
            jumpGuildParam.setJoinInfoParam(loadFrom);
        } else {
            jumpGuildParam.getJoinInfoParam().setAfterJoinJumpChannelId(channelUin);
        }
        GuildJumpDebugUtils.a("Guild.jump.AppChannelStrategy", "AppChannelStrategy::newJumpGuildParam() ret = ", jumpGuildParam);
        return jumpGuildParam;
    }

    @Override // ls1.a
    public boolean jump(@NotNull final Context context) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new WeakReference<>(context);
        final String channelUin = this.channelInfo.getChannelUin();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProAppChnnPreInfo appChannelPreInfo = ((IGPSService) S0).getAppChannelPreInfo(this.guildId, channelUin);
        GuildJumpDebugUtils.a("Guild.jump.AppChannelStrategy", "AppChannelStrategy::jump(), channelInfo = ", this.channelInfo);
        AppChannelJumpInfo b16 = b(appChannelPreInfo);
        isBlank = StringsKt__StringsJVMKt.isBlank(b16.getJumpUrl());
        if (isBlank) {
            Logger.f235387a.d().i("Guild.jump.AppChannelStrategy", 1, "AppChannelStrategy::jump() jumpUrl is blank refresh...");
            IRuntimeService S02 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(T::class.java, process)");
            ((IGPSService) S02).refreshAppChannelPreInfos(this.guildId, true, new em() { // from class: ms1.a
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    b.d(b.this, channelUin, context, i3, str);
                }
            });
            return true;
        }
        e(b16);
        return true;
    }
}
