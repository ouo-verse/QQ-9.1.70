package com.tencent.richframework.delegate;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.IConfigDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nH\u0016J\u0018\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000bH\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/delegate/RFWConfigImpl;", "Lcom/tencent/biz/richframework/delegate/IConfigDelegate;", "()V", "TAG", "", "getConfigValue", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "", "", "", "subKey", "getRawConfigJsonObject", "Lorg/json/JSONObject;", "groupId", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RFWConfigImpl implements IConfigDelegate {

    @NotNull
    private final String TAG = "RFWConfigImpl";

    private final JSONObject getRawConfigJsonObject(String groupId) {
        boolean z16;
        try {
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(groupId, new byte[0]);
            if (loadRawConfig.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                RFWLog.i(this.TAG, RFWLog.USR, "[getConfigValue] configBytes is empty");
                return null;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return new JSONObject(new String(loadRawConfig, UTF_8));
        } catch (Exception e16) {
            RFWLog.e(this.TAG, RFWLog.USR, "[getRawConfigJsonObject] exception: " + e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    public int getConfigValue(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject rawConfigJsonObject = getRawConfigJsonObject(key);
        return rawConfigJsonObject != null ? rawConfigJsonObject.optInt(key) : defaultValue;
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    @Nullable
    public String getConfigValue(@NotNull String key, @Nullable String defaultValue) {
        String optString;
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject rawConfigJsonObject = getRawConfigJsonObject(key);
        return (rawConfigJsonObject == null || (optString = rawConfigJsonObject.optString(key)) == null) ? defaultValue : optString;
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    public boolean getConfigValue(@NotNull String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(key, defaultValue);
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    public boolean getConfigValue(@NotNull String key, @NotNull String subKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(subKey, "subKey");
        if (TextUtils.isEmpty(subKey)) {
            subKey = "tabKey";
        }
        JSONObject rawConfigJsonObject = getRawConfigJsonObject(key);
        return rawConfigJsonObject != null ? rawConfigJsonObject.optBoolean(subKey) : getConfigValue(key, defaultValue);
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    public float getConfigValue(@NotNull String key, float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject rawConfigJsonObject = getRawConfigJsonObject(key);
        return (rawConfigJsonObject != null ? Double.valueOf(rawConfigJsonObject.optDouble(key)) : Float.valueOf(defaultValue)).floatValue();
    }

    @Override // com.tencent.biz.richframework.delegate.IConfigDelegate
    public long getConfigValue(@NotNull String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject rawConfigJsonObject = getRawConfigJsonObject(key);
        return rawConfigJsonObject != null ? rawConfigJsonObject.optLong(key) : defaultValue;
    }
}
