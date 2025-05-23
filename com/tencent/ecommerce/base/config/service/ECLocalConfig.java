package com.tencent.ecommerce.base.config.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.api.IECLocalConfigKeyRegistry;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J)\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b!\u0010\"J)\u0010#\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b%\u0010&J)\u0010'\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00028\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b)\u0010*J!\u0010+\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u000bH\u0017R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u00109\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000206j\u0002`78\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010;R\u001b\u0010@\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\b3\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/ecommerce/base/config/service/ECLocalConfig;", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "", "d", "key", "", "accountScoped", "Landroid/content/SharedPreferences;", "c", "(Ljava/lang/String;Ljava/lang/Boolean;)Landroid/content/SharedPreferences;", "e", "", "a", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)Z", "getString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "", "getInt", "(Ljava/lang/String;ILjava/lang/Boolean;)I", "", "getLong", "(Ljava/lang/String;JLjava/lang/Boolean;)J", "", "getFloat", "(Ljava/lang/String;FLjava/lang/Boolean;)F", "T", "get", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/Object;", "value", "setBoolean", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "setString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "setInt", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "setLong", "(Ljava/lang/String;JLjava/lang/Boolean;)V", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "(Ljava/lang/String;FLjava/lang/Boolean;)V", "set", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)V", "remove", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "contains", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", HippyQQPagView.FunctionName.FLUSH, "Landroid/content/Context;", "Landroid/content/Context;", "context", "b", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfig;", "localMMKVConfig", "Lkotlin/Function0;", "Lcom/tencent/ecommerce/base/config/service/ECUinFetcher;", "Lkotlin/jvm/functions/Function0;", "uinFetcher", "", "Ljava/util/Set;", "spNameList", "Lcom/tencent/ecommerce/base/config/api/IECLocalConfigKeyRegistry;", "Lkotlin/Lazy;", "()Lcom/tencent/ecommerce/base/config/api/IECLocalConfigKeyRegistry;", "localConfigKeyRegistry", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECLocalConfig implements IECLocalConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy localConfigKeyRegistry;

    /* renamed from: f, reason: collision with root package name */
    public static final ECLocalConfig f100650f = new ECLocalConfig();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Context context = wg0.a.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static IECLocalConfig localMMKVConfig = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocalMMKVConfig();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Function0<String> uinFetcher = new Function0<String>() { // from class: com.tencent.ecommerce.base.config.service.ECLocalConfig$uinFetcher$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> spNameList = new LinkedHashSet();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.ecommerce.base.config.service.ECLocalConfig$localConfigKeyRegistry$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return a.f100653c;
            }
        });
        localConfigKeyRegistry = lazy;
    }

    ECLocalConfig() {
    }

    private final void a() {
        String str = "sp.ecommerce.sdk_" + d();
        Context context2 = context;
        context2.getSharedPreferences(str, 0).edit().apply();
        context2.getSharedPreferences("sp.ecommerce.sdk", 0).edit().apply();
    }

    private final IECLocalConfigKeyRegistry b() {
        return (IECLocalConfigKeyRegistry) localConfigKeyRegistry.getValue();
    }

    private final SharedPreferences c(String key, Boolean accountScoped) {
        if (Intrinsics.areEqual(accountScoped, Boolean.TRUE)) {
            cg0.a.b("LocalConfig", "getConfig for accountScoped --> key:" + key);
            String str = "sp.ecommerce.sdk_" + d();
            spNameList.add(str);
            return context.getSharedPreferences(str, 0);
        }
        String str2 = "sp.ecommerce.sdk";
        if (Intrinsics.areEqual(accountScoped, Boolean.FALSE)) {
            cg0.a.b("LocalConfig", "getConfig for globalScoped --> key:" + key);
            spNameList.add("sp.ecommerce.sdk");
            return context.getSharedPreferences("sp.ecommerce.sdk", 0);
        }
        if (e(key)) {
            cg0.a.b("LocalConfig", "getConfig for globalScoped --> key:" + key);
        } else {
            cg0.a.b("LocalConfig", "getConfig for accountScoped --> key:" + key);
            str2 = "sp.ecommerce.sdk_" + d();
        }
        spNameList.add(str2);
        return context.getSharedPreferences(str2, 0);
    }

    private final String d() {
        String invoke = uinFetcher.invoke();
        return invoke != null ? invoke : "UNKNOWN_UIN";
    }

    private final boolean e(String key) {
        return b().isGlobalScopedConfigKey(key);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public boolean contains(String key, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            return iECLocalConfig.contains(key, accountScoped);
        }
        return c(key, accountScoped).contains(key);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void flush() {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.flush();
        } else {
            a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public <T> T get(String key, T defaultValue, Boolean accountScoped) {
        T t16;
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null && (t16 = (T) iECLocalConfig.get(key, defaultValue, accountScoped)) != null) {
            return t16;
        }
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(getLong(key, ((Number) defaultValue).longValue(), accountScoped));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(getFloat(key, ((Number) defaultValue).floatValue(), accountScoped));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(getInt(key, ((Number) defaultValue).intValue(), accountScoped));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(getBoolean(key, ((Boolean) defaultValue).booleanValue(), accountScoped));
        }
        if (defaultValue instanceof String) {
            return (T) getString(key, (String) defaultValue, accountScoped);
        }
        throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b");
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public boolean getBoolean(String key, boolean defaultValue, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            return iECLocalConfig.getBoolean(key, defaultValue, accountScoped);
        }
        return c(key, accountScoped).getBoolean(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public float getFloat(String key, float defaultValue, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            return iECLocalConfig.getFloat(key, defaultValue, accountScoped);
        }
        return c(key, accountScoped).getFloat(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public int getInt(String key, int defaultValue, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            return iECLocalConfig.getInt(key, defaultValue, accountScoped);
        }
        return c(key, accountScoped).getInt(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public long getLong(String key, long defaultValue, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            return iECLocalConfig.getLong(key, defaultValue, accountScoped);
        }
        return c(key, accountScoped).getLong(key, defaultValue);
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public String getString(String key, String defaultValue, Boolean accountScoped) {
        String string;
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig == null || (string = iECLocalConfig.getString(key, defaultValue, accountScoped)) == null) {
            string = c(key, accountScoped).getString(key, defaultValue);
        }
        return string != null ? string : defaultValue;
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void remove(String key, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.remove(key, accountScoped);
        } else {
            c(key, accountScoped).edit().remove(key).apply();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public <T> void set(String key, T value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.set(key, value, accountScoped);
            return;
        }
        if (value instanceof Long) {
            setLong(key, ((Number) value).longValue(), accountScoped);
            return;
        }
        if (value instanceof Float) {
            setFloat(key, ((Number) value).floatValue(), accountScoped);
            return;
        }
        if (value instanceof Integer) {
            setInt(key, ((Number) value).intValue(), accountScoped);
            return;
        }
        if (value instanceof Boolean) {
            setBoolean(key, ((Boolean) value).booleanValue(), accountScoped);
        } else {
            if (value instanceof String) {
                setString(key, (String) value, accountScoped);
                return;
            }
            throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b, value:" + value);
        }
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setBoolean(String key, boolean value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.setBoolean(key, value, accountScoped);
            return;
        }
        SharedPreferences.Editor edit = c(key, accountScoped).edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setFloat(String key, float value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.setFloat(key, value, accountScoped);
            return;
        }
        SharedPreferences.Editor edit = c(key, accountScoped).edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setInt(String key, int value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.setInt(key, value, accountScoped);
            return;
        }
        SharedPreferences.Editor edit = c(key, accountScoped).edit();
        edit.putInt(key, value);
        edit.apply();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setLong(String key, long value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.setLong(key, value, accountScoped);
            return;
        }
        SharedPreferences.Editor edit = c(key, accountScoped).edit();
        edit.putLong(key, value);
        edit.apply();
    }

    @Override // com.tencent.ecommerce.base.config.api.IECLocalConfig
    public void setString(String key, String value, Boolean accountScoped) {
        IECLocalConfig iECLocalConfig = localMMKVConfig;
        if (iECLocalConfig != null) {
            iECLocalConfig.setString(key, value, accountScoped);
            return;
        }
        SharedPreferences.Editor edit = c(key, accountScoped).edit();
        edit.putString(key, value);
        edit.apply();
    }
}
