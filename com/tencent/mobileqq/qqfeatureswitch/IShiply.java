package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&J\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0011H&J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0013H&J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0017H&J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/IShiply;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearAll", "", "clearData", "key", "", "getBool", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getBytes", "", "getDouble", "", "getFloat", "", "getInt", "", "getJSONArray", "Lorg/json/JSONArray;", "getJSONObject", "Lorg/json/JSONObject;", "getLong", "", "getString", "isSwitchOn", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IShiply extends QRouteApi {
    void clearAll();

    void clearData(@NotNull String key);

    boolean getBool(@NotNull String key, boolean defaultValue);

    @Nullable
    byte[] getBytes(@NotNull String key, @Nullable byte[] defaultValue);

    double getDouble(@NotNull String key, double defaultValue);

    float getFloat(@NotNull String key, float defaultValue);

    int getInt(@NotNull String key, int defaultValue);

    @Nullable
    JSONArray getJSONArray(@NotNull String key, @Nullable JSONArray defaultValue);

    @Nullable
    JSONObject getJSONObject(@NotNull String key, @Nullable JSONObject defaultValue);

    long getLong(@NotNull String key, long defaultValue);

    @Nullable
    String getString(@NotNull String key, @Nullable String defaultValue);

    boolean isSwitchOn(@NotNull String key, boolean defaultValue);
}
