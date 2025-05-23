package com.tencent.zplan.luabridge;

import androidx.annotation.Keep;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001R\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/zplan/luabridge/LuaArgument;", "Lp0/a;", "", "external", "Lorg/json/JSONObject;", "genResultObject", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "message", "messageObj", "fail", "result", "", "callback", "", "isASync", "arg", "Lp0/a;", "", "getCallbackId", "()I", "callbackId", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "getParams", "params", "<init>", "(Lp0/a;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class LuaArgument implements p0.a {
    private final p0.a arg;

    public LuaArgument(@NotNull p0.a arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        this.arg = arg;
    }

    private final JSONObject genResultObject(String external) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.arg.getEventName() + ':' + external);
        return jSONObject;
    }

    @Override // p0.a
    public void callback(@Nullable String result) {
        ux4.b bVar = ux4.b.f440566e;
        if (bVar.l(getEventName())) {
            String eventName = getEventName();
            String params = getParams();
            int callbackId = getCallbackId();
            if (result == null) {
                result = "";
            }
            bVar.c(eventName, params, callbackId, result);
            return;
        }
        this.arg.callback(result);
    }

    @NotNull
    public final String fail() {
        String jSONObject = genResultObject("fail").toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "genResultObject(\"fail\").toString()");
        return jSONObject;
    }

    @Override // p0.a
    public int getCallbackId() {
        return this.arg.getCallbackId();
    }

    @Override // p0.a
    @NotNull
    public String getEventName() {
        return this.arg.getEventName();
    }

    @Override // p0.a
    @NotNull
    public String getParams() {
        return this.arg.getParams();
    }

    @Override // p0.a
    public boolean isASync() {
        return this.arg.isASync();
    }

    @NotNull
    public final String ok() {
        String jSONObject = genResultObject(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "genResultObject(\"ok\").toString()");
        return jSONObject;
    }

    @NotNull
    public final String fail(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String jSONObject = genResultObject("fail, " + message).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "genResultObject(\"fail, $message\").toString()");
        return jSONObject;
    }

    @NotNull
    public final String ok(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String jSONObject = genResultObject("ok, " + message).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "genResultObject(\"ok, $message\").toString()");
        return jSONObject;
    }

    @NotNull
    public final String fail(@NotNull JSONObject messageObj) {
        Intrinsics.checkNotNullParameter(messageObj, "messageObj");
        if (!messageObj.has("result")) {
            messageObj.put("result:", this.arg.getEventName() + ":fail");
        }
        String jSONObject = messageObj.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "messageObj.toString()");
        return jSONObject;
    }

    @NotNull
    public final String ok(@NotNull JSONObject messageObj) {
        Intrinsics.checkNotNullParameter(messageObj, "messageObj");
        if (!messageObj.has("result")) {
            messageObj.put("result:", this.arg.getEventName() + ":ok");
        }
        String jSONObject = messageObj.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "messageObj.toString()");
        return jSONObject;
    }
}
