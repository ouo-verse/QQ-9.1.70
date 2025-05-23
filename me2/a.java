package me2;

import com.tencent.ecommerce.base.config.api.IECRemoteConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import re2.b;
import vf0.ECTabExpEntityInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\tJ%\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J-\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lme2/a;", "Lcom/tencent/ecommerce/base/config/api/IECRemoteConfig;", "T", "", "configId", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getConfig", "toggleName", "getFeatureToggleConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lvf0/a;", "getTabConfig", "getUnitedConfig", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECRemoteConfig {
    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T a(int configId, String key, T defaultValue) {
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(ne2.a.f420060a.d(configId, key, ((Number) defaultValue).longValue()));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(ne2.a.f420060a.b(configId, key, ((Number) defaultValue).floatValue()));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(ne2.a.f420060a.c(configId, key, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(ne2.a.f420060a.a(configId, key, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (T) ne2.a.f420060a.e(configId, key, (String) defaultValue);
        }
        throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b");
    }

    @Override // com.tencent.ecommerce.base.config.api.IECRemoteConfig
    public <T> T getConfig(int configId, String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        re2.a aVar = re2.a.f431161a;
        boolean d16 = aVar.d();
        List<Integer> c16 = aVar.c();
        QLog.i("ECRemoteConfigManger", 1, "[getAladdinConfig] isUnitedConfigSwitchOn = " + d16 + ",configId = " + configId + ", remoteRollbackIdList =" + c16);
        if (d16 && !c16.contains(Integer.valueOf(configId))) {
            JSONObject b16 = aVar.b();
            JSONObject a16 = aVar.a();
            int optInt = b16.optInt(String.valueOf(configId), 0);
            int optInt2 = a16.optInt(String.valueOf(configId), 0);
            int i3 = optInt > 0 ? optInt : optInt2 > 0 ? optInt2 : configId;
            QLog.i("ECRemoteConfigManger", 1, "[getAladdinConfig] configId = " + configId + " remoteConfigId = " + optInt + " localConfigId = " + optInt2 + " unitedConfigId = " + i3);
            return i3 < 1000 ? defaultValue : (T) getUnitedConfig(i3, key, defaultValue);
        }
        return (T) a(configId, key, defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECRemoteConfig
    public <T> T getFeatureToggleConfig(String toggleName, T defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(qe2.a.f428882a.d(toggleName, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(qe2.a.f428882a.b(toggleName, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (T) qe2.a.f428882a.f(toggleName, (String) defaultValue);
        }
        if (defaultValue instanceof JSONObject) {
            return (T) qe2.a.f428882a.e(toggleName, (JSONObject) defaultValue);
        }
        if (defaultValue instanceof Map) {
            return (T) qe2.a.f428882a.c(toggleName, (Map) defaultValue);
        }
        throw new IllegalArgumentException("\u53ea\u652f\u6301String\u3001Int\u3001Boolean\u3001JSONObject\u3001Map<String, String>\u7c7b\u578b");
    }

    @Override // com.tencent.ecommerce.base.config.api.IECRemoteConfig
    public ECTabExpEntityInfo getTabConfig(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        return pe2.a.f426057a.a(expName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ecommerce.base.config.api.IECRemoteConfig
    public <T> T getUnitedConfig(int configId, String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(b.f431163a.d(String.valueOf(configId), key, ((Number) defaultValue).longValue()));
        }
        if (defaultValue instanceof Float) {
            return (T) Float.valueOf(b.f431163a.b(String.valueOf(configId), key, ((Number) defaultValue).floatValue()));
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(b.f431163a.c(String.valueOf(configId), key, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(b.f431163a.a(String.valueOf(configId), key, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (T) b.f431163a.e(String.valueOf(configId), key, (String) defaultValue);
        }
        throw new IllegalArgumentException("\u53ea\u652f\u6301\u57fa\u7840\u7c7b\u578b");
    }
}
