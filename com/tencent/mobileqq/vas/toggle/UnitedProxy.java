package com.tencent.mobileqq.vas.toggle;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.BaseConfigProxy;
import com.tencent.mobileqq.vas.api.IUnitedData;
import com.tencent.mobileqq.vas.api.g;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "Lcom/tencent/mobileqq/vas/BaseConfigProxy;", "key", "", "(Ljava/lang/String;)V", "backupToMMKV", "", "(Ljava/lang/String;Z)V", "getData", "onGetInt", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "onGetJson", "Lorg/json/JSONObject;", "onGetStringData", "onGetStringDataSet", "onIsEnable", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class UnitedProxy extends BaseConfigProxy {

    @NotNull
    private static final byte[] DEFAULT_VALUE = new byte[0];

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnitedProxy(@NotNull String key, boolean z16) {
        super(key, z16);
        Intrinsics.checkNotNullParameter(key, "key");
    }

    private final String getData() {
        boolean z16;
        byte[] loadRawConfig = ((IUnitedData) QRoute.api(IUnitedData.class)).loadRawConfig(getName(), DEFAULT_VALUE);
        if (loadRawConfig.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(loadRawConfig, UTF_8);
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public int onGetInt(int defaultValue) {
        boolean z16;
        String data = getData();
        if (data.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(data);
        } catch (Exception unused) {
            if (!g.f308459b.isDebugVersion()) {
                return defaultValue;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    @NotNull
    public JSONObject onGetJson() {
        boolean z16;
        try {
            String data = getData();
            if (data.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                data = "{}";
            }
            return new JSONObject(data);
        } catch (Exception unused) {
            if (!g.f308459b.isDebugVersion()) {
                return new JSONObject();
            }
            throw new RuntimeException("toggle(" + getName() + ") \u62c9\u53d6\u5230\u65e0\u6cd5\u89e3\u6790\u7684\u6570\u636e[" + getData() + "]");
        }
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    @Nullable
    public String onGetStringData(@Nullable String defaultValue) {
        boolean z16;
        String data = getData();
        if (data.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return defaultValue;
        }
        return data;
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    @Nullable
    public String onGetStringDataSet(@Nullable String key, @Nullable String defaultValue) {
        JSONObject onGetJson = onGetJson();
        if (key == null) {
            return defaultValue;
        }
        try {
            return onGetJson.optString(key, defaultValue);
        } catch (Exception unused) {
            if (!g.f308459b.isDebugVersion()) {
                return defaultValue;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.tencent.mobileqq.vas.BaseConfigProxy
    public boolean onIsEnable(boolean defaultValue) {
        return ((IUnitedData) QRoute.api(IUnitedData.class)).isSwitchOn(getName(), defaultValue);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnitedProxy(@NotNull String key) {
        this(key, false);
        Intrinsics.checkNotNullParameter(key, "key");
    }
}
