package com.tencent.mobileqq.troop.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.config.QTroopUnitedConfigParser;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/config/b;", "", "", "configId", "Lcom/tencent/mobileqq/troop/config/QTroopUnitedConfigParser$b;", "g", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", "", "c", "", "d", "", "b", "f", "", "a", h.F, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f294691a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f294691a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final QTroopUnitedConfigParser.b g(String configId) {
        QTroopUnitedConfigParser.b bVar = (QTroopUnitedConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(configId);
        if (bVar == null) {
            return new QTroopUnitedConfigParser.b();
        }
        return bVar;
    }

    @NotNull
    public final Map<String, String> a(@NotNull String configId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this, (Object) configId);
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        return g(configId).a();
    }

    public final boolean b(@NotNull String configId, @NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, configId, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        QTroopUnitedConfigParser.b g16 = g(configId);
        try {
            String str = g16.a().get(key);
            if (str != null) {
                return Boolean.parseBoolean(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e("QTroopUnitedConfig", 1, "[getBoolean] key = " + key + " config = " + ((Object) g16.a().get(key)));
            return defaultValue;
        }
    }

    public final double c(@NotNull String configId, @NotNull String key, double defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, this, configId, key, Double.valueOf(defaultValue))).doubleValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        QTroopUnitedConfigParser.b g16 = g(configId);
        try {
            String str = g16.a().get(key);
            if (str != null) {
                return Double.parseDouble(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e("QTroopUnitedConfig", 1, "[getDouble] key = " + key + " config = " + ((Object) g16.a().get(key)));
            return defaultValue;
        }
    }

    public final int d(@NotNull String configId, @NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, configId, key, Integer.valueOf(defaultValue))).intValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        QTroopUnitedConfigParser.b g16 = g(configId);
        try {
            String str = g16.a().get(key);
            if (str != null) {
                return Integer.parseInt(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e("QTroopUnitedConfig", 1, "[getInt] key = " + key + " config = " + ((Object) g16.a().get(key)));
            return defaultValue;
        }
    }

    public final long e(@NotNull String configId, @NotNull String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, configId, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        QTroopUnitedConfigParser.b g16 = g(configId);
        try {
            String str = g16.a().get(key);
            if (str != null) {
                return Long.parseLong(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e("QTroopUnitedConfig", 1, "[getLong] key = " + key + " config = " + ((Object) g16.a().get(key)));
            return defaultValue;
        }
    }

    @NotNull
    public final String f(@NotNull String configId, @NotNull String key, @NotNull String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, configId, key, defaultValue);
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        QTroopUnitedConfigParser.b g16 = g(configId);
        try {
            String str = g16.a().get(key);
            if (str != null) {
                return str;
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e("QTroopUnitedConfig", 1, "[getString] key = " + key + " config = " + ((Object) g16.a().get(key)));
            return defaultValue;
        }
    }

    public final boolean h(@NotNull String configId, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, configId, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(configId, defaultValue);
    }
}
