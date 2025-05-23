package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J7\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\bH&\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&J$\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0017H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IToggleData;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "i", "", "tag", "", "isEnable", "onGetBean", "T", "name", "clazz", "Ljava/lang/Class;", "defVal", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "onGetInt", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "onGetJsonString", "Lorg/json/JSONObject;", "onGetStringData", "onGetStringDataSet", "key", "onIsEnable", "", "isLogResult", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IToggleData extends QRouteApi {
    void i(@NotNull String tag, @NotNull String isEnable);

    @Nullable
    <T> T onGetBean(@NotNull String name, @Nullable Class<T> clazz, @Nullable T defVal);

    int onGetInt(@NotNull String name, int defaultValue);

    @Nullable
    JSONObject onGetJsonString(@NotNull String name);

    @NotNull
    String onGetStringData(@NotNull String name, @NotNull String defaultValue);

    @Nullable
    String onGetStringDataSet(@NotNull String name, @NotNull String key, @Nullable String defaultValue);

    boolean onIsEnable(boolean isLogResult, @NotNull String name, boolean defaultValue);
}
