package com.tencent.filament.zplan.util;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J*\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/util/a;", "", "", AdMetricTag.EVENT_NAME, "", "callbackId", "Lorg/json/JSONObject;", "resultObject", "b", "errMsg", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f106239a = new a();

    a() {
    }

    @NotNull
    public final JSONObject a(@NotNull String eventName, int callbackId, @Nullable JSONObject resultObject, @Nullable String errMsg) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        JSONObject jSONObject = new JSONObject();
        if (resultObject == null) {
            try {
                resultObject = new JSONObject();
            } catch (Exception e16) {
                FLog.INSTANCE.e("ApiUtil", "wrapCallbackFail fail.", e16);
            }
        }
        if (errMsg == null) {
            errMsg = "";
        }
        resultObject.put("errorMessage", eventName + ":fail " + errMsg);
        resultObject.put("isSuccess", false);
        jSONObject.put("data", resultObject);
        jSONObject.put("callbackId", callbackId);
        return jSONObject;
    }

    @NotNull
    public final JSONObject b(@NotNull String eventName, int callbackId, @Nullable JSONObject resultObject) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        JSONObject jSONObject = new JSONObject();
        if (resultObject == null) {
            try {
                resultObject = new JSONObject();
            } catch (Exception e16) {
                FLog.INSTANCE.e("ApiUtil", "wrapCallbackOk fail.", e16);
            }
        }
        resultObject.put("isSuccess", true);
        jSONObject.put("data", resultObject);
        jSONObject.put("callbackId", callbackId);
        return jSONObject;
    }
}
