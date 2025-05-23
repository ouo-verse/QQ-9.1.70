package com.tencent.ams.dynamicwidget.landingpage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dynamicwidget.BaseDynamicView;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.ams.dynamicwidget.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0016J5\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002J&\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010 \u001a\u00020\u0005H\u0014R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006-"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/LandingPageView;", "Lcom/tencent/ams/dynamicwidget/BaseDynamicView;", "Lcom/tencent/ams/dynamicwidget/landingpage/c;", "", "reason", "", "H", "getModuleId", "Lcom/tencent/ams/dsdk/core/DKEngine;", "dkEngine", "methodName", "Lorg/json/JSONObject;", "params", "Lcom/tencent/ams/dsdk/event/DKMethodHandler$Callback;", "callback", "", "invoke", "moduleId", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "errorMsg", "b", "", "downX", "downY", "d", "", "clickArea", "c", "g", "templateId", ReportConstant.COSTREPORT_PREFIX, NodeProps.ON_ATTACHED_TO_WINDOW, "", "M", "J", "viewRenderStartTime", "N", "Z", "hasDowngrade", "P", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "I", "()Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "adInfo", "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class LandingPageView extends BaseDynamicView implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    private long viewRenderStartTime;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasDowngrade;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final AdInfo adInfo;

    private final void H(String reason) {
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(z(), "downgrade: " + reason);
        if (!this.hasDowngrade) {
            this.hasDowngrade = true;
            d.f70220a.g(new LandingPageView$downgrade$1(this));
        }
    }

    @NotNull
    public final AdInfo I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (AdInfo) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.adInfo;
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dynamicwidget.e
    public void b(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, moduleId, ad5, errorMsg);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.d(z(), "onJsRuntimeError, errorMsg:" + errorMsg);
        super.b(moduleId, ad5, errorMsg);
        if (!A()) {
            H("js runtime error");
        }
    }

    public void c(float downX, float downY, int clickArea) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(downX), Float.valueOf(downY), Integer.valueOf(clickArea));
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(z(), "onAdClose, downX: " + downX + ", downY: " + downY + ", clickArea: " + clickArea);
        u(4001071);
    }

    public void d(float downX, float downY, @Nullable JSONObject params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(downX), Float.valueOf(downY), params);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(z(), "onAdClick, downX: " + downX + ", downY: " + downY);
        u(4001081);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dsdk.event.DKMethodHandler
    @NotNull
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        if (com.tencent.ams.dynamicwidget.c.f70185s.k()) {
            return "DynamicCanvas";
        }
        return "LandingPage";
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(@Nullable DKEngine<?> dkEngine, @Nullable String methodName, @Nullable JSONObject params, @Nullable DKMethodHandler.Callback callback) {
        String str;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, dkEngine, methodName, params, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(methodName)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (Intrinsics.areEqual(methodName, "clickAd")) {
            if (params != null) {
                d((float) params.optDouble("downX", 0.0d), (float) params.optDouble("downY", 0.0d), params);
                C(callback, hashMap);
            } else {
                B(callback, -1, "invalid params");
            }
            return true;
        }
        if (!Intrinsics.areEqual(methodName, "onAdClose") && !Intrinsics.areEqual(methodName, "closePage")) {
            if (Intrinsics.areEqual(methodName, "onLandingPageWillShow")) {
                g();
                C(callback, hashMap);
                return true;
            }
            if (Intrinsics.areEqual(methodName, "adDowngrade")) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("msg:");
                if (params == null || (str = params.optString("reasonMsg")) == null) {
                    str = "js call adDowngrade";
                }
                sb5.append(str);
                sb5.append(',');
                sb5.append(" code:");
                if (params != null) {
                    num = Integer.valueOf(params.optInt("reasonCode"));
                } else {
                    num = null;
                }
                sb5.append(num);
                H(sb5.toString());
                return true;
            }
            return super.invoke(dkEngine, methodName, params, callback);
        }
        if (params != null) {
            c((float) params.optDouble("downX", 0.0d), (float) params.optDouble("downY", 0.0d), params.optInt("clickArea", 0));
            C(callback, hashMap);
        } else {
            B(callback, -1, "invalid params");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (com.tencent.ams.dynamicwidget.c.f70185s.j()) {
            u(4001065);
            H("config downgrade native");
        }
    }

    @Override // com.tencent.ams.dynamicwidget.BaseDynamicView
    public boolean s(@Nullable String templateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) templateId)).booleanValue();
        }
        return b.f70204c.a(templateId);
    }
}
