package com.tencent.util;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.inject.u;
import com.tencent.mobileqq.inject.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/util/l;", "", "", "a", "", "name", "", AdMetricTag.FALLBACK, "b", "Lcom/tencent/mobileqq/inject/u;", "Lcom/tencent/mobileqq/inject/u;", "getSUniteConfig", "()Lcom/tencent/mobileqq/inject/u;", "setSUniteConfig", "(Lcom/tencent/mobileqq/inject/u;)V", "sUniteConfig", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f383986a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_UniteConfig.yml", version = 1)
    @Nullable
    private static u sUniteConfig;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f383988c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f383988c = arrayList;
        arrayList.add(w.class);
        l lVar = new l();
        f383986a = lVar;
        lVar.a();
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private final void a() {
        sUniteConfig = (u) com.tencent.mobileqq.qroute.utils.b.a(f383988c);
    }

    public final boolean b(@NotNull String name, boolean fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, name, Boolean.valueOf(fallback))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(name, "name");
        u uVar = sUniteConfig;
        if (uVar != null) {
            return uVar.isSwitchOn(name, fallback);
        }
        return fallback;
    }
}
