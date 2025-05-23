package com.tencent.mobileqq.troop.shortcut.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/util/a;", "", "Lcom/tencent/mobileqq/troop/shortcut/util/a$a;", "jumpParam", "", "d", "a", "c", "b", "", "e", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f298561a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0007\u0012\u0006\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u0010\u0010!R\u0017\u0010)\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b#\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010*\u001a\u0004\b\u001e\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/util/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "d", "()Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "b", "Lmqq/app/AppRuntime;", "c", "()Lmqq/app/AppRuntime;", "appRuntime", "Landroid/app/Activity;", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "f", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "e", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "troopUin", h.F, "url", "appId", "Z", "i", "()Z", "isGuildApp", "I", "()I", "launchScene", "<init>", "(Landroid/content/Context;Lmqq/app/AppRuntime;Landroid/app/Activity;Lcom/tencent/mobileqq/data/troop/TroopInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final /* data */ class C8774a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AppRuntime appRuntime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Activity activity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TroopInfo troopInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String troopUin;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String appId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean isGuildApp;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final int launchScene;

        public C8774a(@NotNull Context context, @NotNull AppRuntime appRuntime, @Nullable Activity activity, @NotNull TroopInfo troopInfo, @NotNull String troopUin, @NotNull String url, @NotNull String appId, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(appId, "appId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, appRuntime, activity, troopInfo, troopUin, url, appId, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            this.context = context;
            this.appRuntime = appRuntime;
            this.activity = activity;
            this.troopInfo = troopInfo;
            this.troopUin = troopUin;
            this.url = url;
            this.appId = appId;
            this.isGuildApp = z16;
            this.launchScene = i3;
        }

        @Nullable
        public final Activity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.activity;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.appId;
        }

        @NotNull
        public final AppRuntime c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AppRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.appRuntime;
        }

        @NotNull
        public final Context d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.context;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.launchScene;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C8774a)) {
                return false;
            }
            C8774a c8774a = (C8774a) other;
            if (Intrinsics.areEqual(this.context, c8774a.context) && Intrinsics.areEqual(this.appRuntime, c8774a.appRuntime) && Intrinsics.areEqual(this.activity, c8774a.activity) && Intrinsics.areEqual(this.troopInfo, c8774a.troopInfo) && Intrinsics.areEqual(this.troopUin, c8774a.troopUin) && Intrinsics.areEqual(this.url, c8774a.url) && Intrinsics.areEqual(this.appId, c8774a.appId) && this.isGuildApp == c8774a.isGuildApp && this.launchScene == c8774a.launchScene) {
                return true;
            }
            return false;
        }

        @NotNull
        public final TroopInfo f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (TroopInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.troopInfo;
        }

        @NotNull
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.troopUin;
        }

        @NotNull
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
            }
            int hashCode2 = ((this.context.hashCode() * 31) + this.appRuntime.hashCode()) * 31;
            Activity activity = this.activity;
            if (activity == null) {
                hashCode = 0;
            } else {
                hashCode = activity.hashCode();
            }
            int hashCode3 = (((((((((hashCode2 + hashCode) * 31) + this.troopInfo.hashCode()) * 31) + this.troopUin.hashCode()) * 31) + this.url.hashCode()) * 31) + this.appId.hashCode()) * 31;
            boolean z16 = this.isGuildApp;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode3 + i3) * 31) + this.launchScene;
        }

        public final boolean i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.isGuildApp;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (String) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return "JumpParam(context=" + this.context + ", appRuntime=" + this.appRuntime + ", activity=" + this.activity + ", troopInfo=" + this.troopInfo + ", troopUin=" + this.troopUin + ", url=" + this.url + ", appId=" + this.appId + ", isGuildApp=" + this.isGuildApp + ", launchScene=" + this.launchScene + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f298561a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    private static final void a(C8774a jumpParam) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(jumpParam.d(), e(jumpParam), jumpParam.e(), ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).createEntryModel(jumpParam.f(), jumpParam.g()), null);
    }

    @JvmStatic
    private static final void b(C8774a jumpParam) {
        Unit unit;
        String e16 = e(jumpParam);
        Context a16 = jumpParam.a();
        if (a16 == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SchemaActionUtil", "activity is null, use context, jump may failed by this");
            a16 = jumpParam.d();
        }
        AppRuntime c16 = jumpParam.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        ax c17 = bi.c((BaseQQAppInterface) c16, a16, e16);
        if (c17 != null) {
            c17.b();
            return;
        }
        Intent intent = new Intent(jumpParam.d(), (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(e16));
        Activity a17 = jumpParam.a();
        if (a17 != null) {
            a17.startActivity(intent);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            jumpParam.d().startActivity(intent.addFlags(268435456));
        }
    }

    @JvmStatic
    private static final void c(C8774a jumpParam) {
        Unit unit;
        Intent intent = new Intent(jumpParam.d(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", e(jumpParam));
        intent.putExtra("webStyle", "noBottomBar");
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (Intrinsics.areEqual(jumpParam.b(), "101914115")) {
            intent.putExtra("big_brother_source_key", "biz_src_zf_games");
        }
        Activity a16 = jumpParam.a();
        if (a16 != null) {
            a16.startActivity(intent);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            jumpParam.d().startActivity(intent.addFlags(268435456));
        }
    }

    @JvmStatic
    public static final void d(@NotNull C8774a jumpParam) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(jumpParam, "jumpParam");
        if (Intrinsics.areEqual(jumpParam.b(), MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN) && jumpParam.i()) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuild(jumpParam.d(), new GuildShareUrlParam(jumpParam.h()));
            return;
        }
        if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(jumpParam.h())) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpParam.h(), "http", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpParam.h(), SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(jumpParam.h(), "mqzone", false, 2, null);
                    if (!startsWith$default3) {
                        startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(jumpParam.h(), "local", false, 2, null);
                        if (startsWith$default4) {
                            ((ITroopAppsApi) QRoute.api(ITroopAppsApi.class)).openNewPage(jumpParam.d(), jumpParam.g(), 1);
                            return;
                        }
                        return;
                    }
                    ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(jumpParam.a(), jumpParam.h());
                    return;
                }
                b(jumpParam);
                return;
            }
            c(jumpParam);
            return;
        }
        a(jumpParam);
    }

    @JvmStatic
    private static final String e(C8774a jumpParam) {
        String str;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        String replace$default7;
        String replace$default8;
        String replace$default9;
        boolean z16;
        if (jumpParam.f().isOwner()) {
            str = "0";
        } else if (jumpParam.f().isAdmin()) {
            str = "1";
        } else {
            str = "2";
        }
        String str2 = str;
        replace$default = StringsKt__StringsJVMKt.replace$default(jumpParam.h(), "$GCODE$", jumpParam.g(), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$CLIENTVER$", "android" + AppSetting.f99551k, false, 4, (Object) null);
        String currentAccountUin = jumpParam.c().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$UIN$", currentAccountUin, false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "$LANG$", "zh_CN", false, 4, (Object) null);
        replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "$GROUPAPPID$", jumpParam.b(), false, 4, (Object) null);
        replace$default6 = StringsKt__StringsJVMKt.replace$default(replace$default5, "$ROLE$", str2, false, 4, (Object) null);
        replace$default7 = StringsKt__StringsJVMKt.replace$default(replace$default6, "$ENTERSOURCE$", "1", false, 4, (Object) null);
        replace$default8 = StringsKt__StringsJVMKt.replace$default(replace$default7, "$GUIN$", jumpParam.g(), false, 4, (Object) null);
        replace$default9 = StringsKt__StringsJVMKt.replace$default(replace$default8, "$UNREADNUM$", "0", false, 4, (Object) null);
        String troopNameFromNT = jumpParam.f().troopNameFromNT;
        if (troopNameFromNT != null) {
            Intrinsics.checkNotNullExpressionValue(troopNameFromNT, "troopNameFromNT");
            if (troopNameFromNT.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                troopNameFromNT = null;
            }
            String str3 = troopNameFromNT;
            if (str3 != null) {
                StringsKt__StringsJVMKt.replace$default(replace$default9, "$GNAME$", str3, false, 4, (Object) null);
            }
        }
        return replace$default9;
    }
}
