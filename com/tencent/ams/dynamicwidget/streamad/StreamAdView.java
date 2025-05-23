package com.tencent.ams.dynamicwidget.streamad;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dynamicwidget.BaseDynamicView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J5\u0010\r\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J*\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ams/dynamicwidget/streamad/StreamAdView;", "Lcom/tencent/ams/dynamicwidget/BaseDynamicView;", "", "", "getModuleId", "Lcom/tencent/ams/dsdk/core/DKEngine;", "dkEngine", "methodName", "Lorg/json/JSONObject;", "params", "Lcom/tencent/ams/dsdk/event/DKMethodHandler$Callback;", "callback", "", "invoke", "", "downX", "downY", "", "clickArea", "", "G", "step", "H", UserInfo.SEX_FEMALE, "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class StreamAdView extends BaseDynamicView {
    static IPatchRedirector $redirector_;

    @NotNull
    public String F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "";
    }

    public void G(float downX, float downY, int clickArea, @Nullable JSONObject params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(downX), Float.valueOf(downY), Integer.valueOf(clickArea), params);
        }
    }

    public void H(int step) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, step);
        }
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dsdk.event.DKMethodHandler
    @NotNull
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "StreamAd";
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(@Nullable DKEngine<?> dkEngine, @Nullable String methodName, @Nullable JSONObject params, @Nullable DKMethodHandler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, dkEngine, methodName, params, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(methodName)) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (Intrinsics.areEqual(methodName, "clickAd")) {
            if (params != null) {
                float optDouble = (float) params.optDouble("downX", 0.0d);
                float optDouble2 = (float) params.optDouble("downY", 0.0d);
                float optDouble3 = (float) params.optDouble("locationX", 0.0d);
                float optDouble4 = (float) params.optDouble("locationY", 0.0d);
                float optDouble5 = (float) params.optDouble("width", 0.0d);
                float optDouble6 = (float) params.optDouble("height", 0.0d);
                int optInt = params.optInt("clickArea", 0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("locationX", Float.valueOf(optDouble3));
                jSONObject.put("locationY", Float.valueOf(optDouble4));
                jSONObject.put("width", Float.valueOf(optDouble5));
                jSONObject.put("height", Float.valueOf(optDouble6));
                G(optDouble, optDouble2, optInt, jSONObject);
                C(callback, linkedHashMap);
                return true;
            }
            B(callback, -1, "invalid params");
        } else if (Intrinsics.areEqual(methodName, "onUIStepUpdated")) {
            if (params != null) {
                H(params.optInt("step", 1));
                C(callback, linkedHashMap);
                return true;
            }
            B(callback, -1, "invalid params");
        } else if (Intrinsics.areEqual(methodName, "getActionButtonText")) {
            linkedHashMap.put("text", F());
            C(callback, linkedHashMap);
            return true;
        }
        return super.invoke(dkEngine, methodName, params, callback);
    }
}
