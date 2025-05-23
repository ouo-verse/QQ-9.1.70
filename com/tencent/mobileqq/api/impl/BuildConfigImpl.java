package com.tencent.mobileqq.api.impl;

import com.tencent.mobileqq.BuildConfig;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/api/impl/BuildConfigImpl;", "Lcom/tencent/mobileqq/api/IBuildConfig;", "()V", "getAlphaBuildNo", "", "getDCLType", "", "getDynamicFeaturePlugins", "", "getRouteModules", "", "isQRun", "", "isQRunCompact", "isUITest", "AQQLiteApp_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class BuildConfigImpl implements IBuildConfig {
    static IPatchRedirector $redirector_;

    public BuildConfigImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    @NotNull
    public String getAlphaBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    public int getDCLType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    @NotNull
    public Set<String> getDynamicFeaturePlugins() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Set<String> DYNAMIC_FEATURE_PLUGINS = BuildConfig.f154060a;
        Intrinsics.checkNotNullExpressionValue(DYNAMIC_FEATURE_PLUGINS, "DYNAMIC_FEATURE_PLUGINS");
        return DYNAMIC_FEATURE_PLUGINS;
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    @NotNull
    public List<String> getRouteModules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<String> ROUTE_MODULES = BuildConfig.f154061b;
        Intrinsics.checkNotNullExpressionValue(ROUTE_MODULES, "ROUTE_MODULES");
        return ROUTE_MODULES;
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    public boolean isQRun() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    public boolean isQRunCompact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.api.IBuildConfig
    public boolean isUITest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
