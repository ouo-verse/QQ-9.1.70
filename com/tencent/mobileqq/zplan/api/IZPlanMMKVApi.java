package com.tencent.mobileqq.zplan.api;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\nH&J\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u0007H&J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH&J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000eH&J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H&J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanMMKVApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "edit", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getBoolean", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getBytes", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "remove", "", "setBoolean", "value", "setBytes", "byteArray", "setBytesWithClean", "cleanPrefix", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT, "setInt", "setLong", "setString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanMMKVApi extends QRouteApi {
    @NotNull
    MMKVOptionEntity edit();

    boolean getBoolean(@NotNull String key, boolean defaultValue);

    @NotNull
    byte[] getBytes(@NotNull String key, @NotNull byte[] defaultValue);

    float getFloat(@NotNull String key, float defaultValue);

    int getInt(@NotNull String key, int defaultValue);

    long getLong(@NotNull String key, long defaultValue);

    @NotNull
    String getString(@NotNull String key, @NotNull String defaultValue);

    void remove(@NotNull String key);

    void setBoolean(@NotNull String key, boolean value);

    void setBytes(@NotNull String key, @NotNull byte[] byteArray);

    void setBytesWithClean(@NotNull String key, @NotNull byte[] byteArray, @NotNull String cleanPrefix);

    void setFloat(@NotNull String key, float value);

    void setInt(@NotNull String key, int value);

    void setLong(@NotNull String key, long value);

    void setString(@NotNull String key, @NotNull String value);
}
