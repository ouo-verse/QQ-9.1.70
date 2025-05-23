package com.tencent.imcore.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u000b\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0003\u0010\u0013R\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/imcore/message/k;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "configId", "", "Z", "e", "()Z", "setOpen", "(Z)V", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "", "c", "Ljava/util/Set;", "d", "()Ljava/util/Set;", "whiteTables", "blackTables", "f", "interceptMRTroop", "<init>", "(Ljava/lang/String;)V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isOpen;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> whiteTables;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> blackTables;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean interceptMRTroop;

    public k(@NotNull String configId) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) configId);
            return;
        }
        this.configId = configId;
        this.isOpen = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(configId, false);
        this.whiteTables = new LinkedHashSet();
        this.blackTables = new LinkedHashSet();
    }

    @NotNull
    public final Set<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.blackTables;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.configId;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.interceptMRTroop;
    }

    @NotNull
    public final Set<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.whiteTables;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isOpen;
    }

    public final void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.interceptMRTroop = z16;
        }
    }
}
