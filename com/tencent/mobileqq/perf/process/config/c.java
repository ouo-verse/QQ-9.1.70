package com.tencent.mobileqq.perf.process.config;

import com.tencent.cache.core.manager.api.CacheConfig;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/c;", "Lcom/tencent/freesia/IConfigData;", "", "jsonStr", "", "d", "Lcom/tencent/cache/core/manager/api/CacheConfig;", "Lcom/tencent/cache/core/manager/api/CacheConfig;", "c", "()Lcom/tencent/cache/core/manager/api/CacheConfig;", "setMemoryCacheConfig", "(Lcom/tencent/cache/core/manager/api/CacheConfig;)V", "memoryCacheConfig", "<init>", "()V", "e", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static c f257903f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CacheConfig memoryCacheConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/c$a;", "", "Lcom/tencent/mobileqq/perf/process/config/c;", "c", "", "e", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/perf/process/config/c;", "b", "()Lcom/tencent/mobileqq/perf/process/config/c;", "d", "(Lcom/tencent/mobileqq/perf/process/config/c;)V", "getInstance$annotations", "()V", "", "GROUP", "Ljava/lang/String;", "TAG", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.config.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c c() {
            c cVar;
            try {
                f fVar = f.f257911a;
                if (fVar.e()) {
                    QLog.i("CacheConfigWrapper", 1, "loadConfig, use local config");
                    cVar = new c();
                    cVar.d(fVar.b());
                } else {
                    QLog.i("CacheConfigWrapper", 1, "loadConfig, parse publish config");
                    cVar = (c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100973");
                    if (cVar == null) {
                        cVar = new c();
                    }
                }
                return cVar;
            } catch (Throwable th5) {
                QLog.e("CacheConfigWrapper", 1, "loadConfig, error. use default config", th5);
                return new c();
            }
        }

        @NotNull
        public final c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return c.f257903f;
            }
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void d(@NotNull c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            } else {
                Intrinsics.checkNotNullParameter(cVar, "<set-?>");
                c.f257903f = cVar;
            }
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                d(c());
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f257903f = companion.c();
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        CacheConfig cacheConfig = new CacheConfig();
        cacheConfig.M(false);
        cacheConfig.L(false);
        cacheConfig.I(false);
        this.memoryCacheConfig = cacheConfig;
    }

    @NotNull
    public final CacheConfig c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CacheConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.memoryCacheConfig;
    }

    public final void d(@NotNull String jsonStr) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jsonStr);
            return;
        }
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        this.memoryCacheConfig = CacheConfig.INSTANCE.b(jsonStr);
        if (!AppSetting.isPublicVersion()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) jsonStr, (CharSequence) "usePublish", false, 2, (Object) null);
            if (!contains$default && !Utils.K()) {
                this.memoryCacheConfig.K(true);
                this.memoryCacheConfig.N(true);
            }
        }
        com.tencent.cache.core.manager.api.c.f98725d.i(this.memoryCacheConfig);
        QLog.i("CacheConfigWrapper", 1, "parse, " + this.memoryCacheConfig);
    }
}
