package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.config.ODUnitedConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u000eH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/RemoteConfigService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IRemoteConfigService;", "", "configId", "Lcom/tencent/mobileqq/groupvideo/config/ODUnitedConfigParser$b;", "getUnitedConfig", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getLong", "", "getFloat", "", "getInt", "", "getBoolean", "getString", "isSwitchOn", "<init>", "()V", "Companion", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RemoteConfigService implements IRemoteConfigService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "RemoteConfigService";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/RemoteConfigService$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.bridgeengine.RemoteConfigService$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RemoteConfigService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ODUnitedConfigParser.b getUnitedConfig(String configId) {
        ODUnitedConfigParser.b bVar = (ODUnitedConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(configId);
        if (bVar == null) {
            return new ODUnitedConfigParser.b();
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    public boolean getBoolean(@NotNull String configId, @Nullable String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, configId, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        ODUnitedConfigParser.b unitedConfig = getUnitedConfig(configId);
        try {
            String str = unitedConfig.a().get(key);
            if (str != null) {
                return Boolean.parseBoolean(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getBoolean] key = " + key + " config = " + ((Object) unitedConfig.a().get(key)));
            return defaultValue;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    public float getFloat(@NotNull String configId, @Nullable String key, float defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, this, configId, key, Float.valueOf(defaultValue))).floatValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        ODUnitedConfigParser.b unitedConfig = getUnitedConfig(configId);
        try {
            String str = unitedConfig.a().get(key);
            if (str != null) {
                return Float.parseFloat(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getFloat] key = " + key + " config = " + ((Object) unitedConfig.a().get(key)));
            return defaultValue;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    public int getInt(@NotNull String configId, @Nullable String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, configId, key, Integer.valueOf(defaultValue))).intValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        ODUnitedConfigParser.b unitedConfig = getUnitedConfig(configId);
        try {
            String str = unitedConfig.a().get(key);
            QLog.d(TAG, 1, "[getInt] key = " + key + " config = " + str);
            if (str != null) {
                return Integer.parseInt(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getInt] key = " + key + " config = " + ((Object) unitedConfig.a().get(key)));
            return defaultValue;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    public long getLong(@NotNull String configId, @Nullable String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, configId, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        ODUnitedConfigParser.b unitedConfig = getUnitedConfig(configId);
        try {
            String str = unitedConfig.a().get(key);
            if (str != null) {
                return Long.parseLong(str);
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getLong] key = " + key + " config = " + ((Object) unitedConfig.a().get(key)));
            return defaultValue;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    @Nullable
    public String getString(@NotNull String configId, @Nullable String key, @Nullable String defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, configId, key, defaultValue);
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        ODUnitedConfigParser.b unitedConfig = getUnitedConfig(configId);
        try {
            String str = unitedConfig.a().get(key);
            if (str != null) {
                return str;
            }
            return defaultValue;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "[getString] key = " + key + " config = " + ((Object) unitedConfig.a().get(key)));
            return defaultValue;
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IRemoteConfigService
    public boolean isSwitchOn(@NotNull String configId, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, configId, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(configId, "configId");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(configId, defaultValue);
    }
}
