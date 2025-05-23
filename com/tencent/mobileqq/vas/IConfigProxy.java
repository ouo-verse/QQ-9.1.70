package com.tencent.mobileqq.vas;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH&J\u001c\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/IConfigProxy;", "", "getInt", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getJson", "Lorg/json/JSONObject;", "getStringData", "", "getStringDataSet", "key", "isEnable", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IConfigProxy {
    int getInt(int defaultValue);

    @NotNull
    JSONObject getJson();

    @NotNull
    String getStringData(@NotNull String defaultValue);

    @Nullable
    String getStringDataSet(@NotNull String key, @Nullable String defaultValue);

    boolean isEnable(boolean defaultValue);
}
