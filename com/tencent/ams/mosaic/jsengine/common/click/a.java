package com.tencent.ams.mosaic.jsengine.common.click;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.QuickJSEngine;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.mosaic.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a implements IWXManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70824a;

    /* renamed from: b, reason: collision with root package name */
    private final QuickJSEngine f70825b;

    public a(Context context, QuickJSEngine quickJSEngine) {
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) quickJSEngine);
            return;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f70824a = context2;
        this.f70825b = quickJSEngine;
    }

    private void a(JSFunction jSFunction, int i3) {
        QuickJSEngine quickJSEngine = this.f70825b;
        if (quickJSEngine == null) {
            f.b("WXManager", "callBackResult: mQuickJSEngine is null");
            return;
        }
        if (jSFunction == null) {
            f.b("WXManager", "callBackResult: callback is null");
            return;
        }
        try {
            quickJSEngine.u(jSFunction, new Object[]{null, Integer.valueOf(i3)}, null);
        } catch (Throwable th5) {
            f.c("WXManager", "callBackResult", th5);
        }
    }

    private static String b(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pathType", 2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_trace_data", str2);
            jSONObject2.put("token", str);
            jSONObject2.put("muid", str3);
            jSONObject.put("invokeData", jSONObject2);
            return jSONObject.toString();
        } catch (Throwable th5) {
            f.c("WXManager", "[getExtData]", th5);
            return null;
        }
    }

    public static int c() {
        Class a16 = j.a("com.tencent.mm.opensdk.constants.Build");
        if (a16 != null) {
            try {
                return a16.getField("SDK_INT").getInt(a16);
            } catch (Exception e16) {
                f.c("WXManager", "Exception ", e16);
                return 0;
            }
        }
        return 0;
    }

    private int e(String str, int i3, String str2, String str3, String str4) {
        Field e16;
        f.e("WXManager", String.format("%s start launch %s, path = %s", str, str2, str3));
        Class a16 = j.a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        if (a16 == null) {
            f.b("WXManager", "can't get class WXAPIFactory");
            return -2;
        }
        Method f16 = j.f(a16, "createWXAPI", Context.class, String.class);
        if (f16 == null) {
            f.b("WXManager", "get method createWXAPI() failed");
            return -2;
        }
        Object h16 = j.h(a16, f16, this.f70824a, str);
        if (h16 == null) {
            f.b("WXManager", "invoke method createWXAPI() failed");
            return -2;
        }
        if (i(h16, str) != 1) {
            f.b("WXManager", "register to wx failed");
        }
        if ((Build.VERSION.SDK_INT < 28 || i3 < 621019904) && h(h16) != 1) {
            f.b("WXManager", "open wx app failed");
        }
        Class a17 = j.a("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
        if (a17 == null) {
            f.b("WXManager", "can't get class com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            return -2;
        }
        Object d16 = j.d(a17);
        if (d16 == null) {
            f.b("WXManager", "can't new com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            return -2;
        }
        Field e17 = j.e(a17, "userName");
        if (e17 != null && j.j(e17, d16, str2)) {
            if (!TextUtils.isEmpty(str3) && ((e16 = j.e(a17, "path")) == null || !j.j(e16, d16, str3))) {
                f.b("WXManager", "set field path failed");
                return -2;
            }
            Field e18 = j.e(a17, "extData");
            if (e18 != null && j.j(e18, d16, str4)) {
                Method f17 = j.f(h16.getClass(), "sendReq", a17.getSuperclass());
                if (f17 == null) {
                    f.b("WXManager", "get method sendReq() failed");
                    return -2;
                }
                Object h17 = j.h(h16, f17, d16);
                f.e("WXManager", String.format("%s end launch %s, path = %s, result = %s", str, str2, str3, h17));
                if ((h17 instanceof Boolean) && ((Boolean) h17).booleanValue()) {
                    return 0;
                }
                return -3;
            }
            f.b("WXManager", "set field extData failed");
            return -2;
        }
        f.b("WXManager", "set field userName failed");
        return -2;
    }

    private int g(String str, String str2) {
        Class a16 = j.a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        if (a16 == null) {
            f.b("WXManager", "can't get class WXAPIFactory");
            return -2;
        }
        Method f16 = j.f(a16, "createWXAPI", Context.class, String.class);
        if (f16 == null) {
            f.b("WXManager", "get method createWXAPI() failed");
            return -2;
        }
        Object h16 = j.h(a16, f16, this.f70824a, str);
        if (h16 == null) {
            f.b("WXManager", "invoke method createWXAPI() failed");
            return -2;
        }
        Class a17 = j.a("com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView$Req");
        if (a17 == null) {
            f.b("WXManager", "can't get class WXOpenBusinessView$Req");
            return -2;
        }
        Object d16 = j.d(a17);
        if (d16 == null) {
            f.b("WXManager", "can't new WXOpenBusinessView$Req");
            return -2;
        }
        Field e16 = j.e(a17, "businessType");
        if (e16 != null && j.j(e16, d16, "nativeOpenAdCanvas")) {
            Field e17 = j.e(a17, "extInfo");
            if (e17 != null && j.j(e17, d16, str2)) {
                Method f17 = j.f(h16.getClass(), "sendReq", a17.getSuperclass());
                if (f17 == null) {
                    f.b("WXManager", "get method extInfo() failed");
                    return -2;
                }
                Object h17 = j.h(h16, f17, d16);
                if (h17 instanceof Boolean) {
                    if (((Boolean) h17).booleanValue()) {
                        return 0;
                    }
                    return -3;
                }
                return -2;
            }
            f.b("WXManager", "set field extData failed");
            return -2;
        }
        f.b("WXManager", "set field businessType failed");
        return -2;
    }

    private static int h(Object obj) {
        f.e("WXManager", String.format("start openWXApp", new Object[0]));
        Method f16 = j.f(obj.getClass(), "openWXApp", new Class[0]);
        if (f16 == null) {
            f.b("WXManager", "openWXApp failed, can't get openWXApp method");
            return 2;
        }
        Object h16 = j.h(obj, f16, new Object[0]);
        f.e("WXManager", String.format("end openWXApp, result = %b", h16));
        if (h16 instanceof Boolean) {
            if (((Boolean) h16).booleanValue()) {
                return 1;
            }
            return 3;
        }
        return 4;
    }

    private static int i(Object obj, String str) {
        f.e("WXManager", String.format("%s start reg", str));
        Method f16 = j.f(obj.getClass(), "registerApp", String.class);
        if (f16 == null) {
            f.b("WXManager", "reg failed, can't get registerApp method");
            return 2;
        }
        Object h16 = j.h(obj, f16, str);
        f.e("WXManager", String.format("%s end reg, result = %b", str, h16));
        if (h16 instanceof Boolean) {
            if (((Boolean) h16).booleanValue()) {
                return 1;
            }
            return 3;
        }
        return 4;
    }

    public int d() {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        Context context = this.f70824a;
        if (context != null) {
            try {
            } catch (Throwable th5) {
                f.c("WXManager", "getWXAppSupportAPI", th5);
            }
            if (context.getPackageManager() != null) {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                }
                return 0;
            }
        }
        f.b("WXManager", "getWXAppSupportAPI: getPackageManager is null");
        return 0;
    }

    public boolean f() {
        Signature[] signatureArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Context context = this.f70824a;
        if (context == null) {
            f.b("WXManager", "isWXAppInstalled: context is null");
            return false;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.mm", 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null) {
                if (signatureArr.length != 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            f.c("WXManager", "isWXAppInstalled:", th5);
            return false;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.click.IWXManager
    public String getOpenSDKVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String valueOf = String.valueOf(c());
        f.e("WXManager", "getOpenSDKVersion:" + valueOf);
        return valueOf;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.click.IWXManager
    public boolean isWXAppSupportApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int d16 = d();
        f.e("WXManager", "getWXAppSupportAPI:" + d16);
        if (d16 >= 620953856) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.click.IWXManager
    public boolean isWxInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean f16 = f();
        f.e("WXManager", "isWXAppInstalled:" + f16);
        return f16;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.click.IWXManager
    public void launchWxBusinessView(JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSObject, (Object) jSFunction);
            return;
        }
        QuickJSEngine quickJSEngine = this.f70825b;
        if (quickJSEngine == null) {
            f.b("WXManager", "launchWxBusinessView engine is null");
            return;
        }
        if (jSFunction == null) {
            f.b("WXManager", "launchWxBusinessView callback is null");
            return;
        }
        Map<String, Object> f16 = e.f(quickJSEngine.l(), jSObject);
        if (f16 == null) {
            f.b("WXManager", "launchWxBusinessView map is null");
            a(jSFunction, -4);
            return;
        }
        try {
            int c16 = c();
            if (c16 < 620889344) {
                f.b("WXManager", "launchWxBusinessView openSDK not support, ver = " + c16);
                a(jSFunction, -5);
                return;
            }
            int d16 = d();
            if (d16 < 671089408) {
                f.b("WXManager", "launchWxBusinessView wx not support, ver = " + d16);
                a(jSFunction, -6);
                return;
            }
            String str = (String) f16.get("wxAppId");
            String str2 = (String) f16.get("extInfo");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int g16 = g(str, str2);
                f.e("WXManager", "launchWxBusinessView");
                a(jSFunction, g16);
                return;
            }
            f.b("WXManager", "launchWxBusinessView params error:" + f16);
            a(jSFunction, -4);
        } catch (Throwable th5) {
            f.c("WXManager", "launchWxBusinessView error", th5);
            a(jSFunction, -7);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.click.IWXManager
    public void launchWxMiniProgram(JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSObject, (Object) jSFunction);
            return;
        }
        QuickJSEngine quickJSEngine = this.f70825b;
        if (quickJSEngine == null) {
            f.b("WXManager", "launchWxMiniProgram engine is null");
            return;
        }
        if (jSFunction == null) {
            f.b("WXManager", "launchWxMiniProgram callback is null");
            return;
        }
        Map<String, Object> f16 = e.f(quickJSEngine.l(), jSObject);
        if (f16 == null) {
            f.b("WXManager", "launchWxMiniProgram map is null");
            a(jSFunction, -6);
            return;
        }
        try {
            int c16 = c();
            if (c16 < 620953856) {
                f.b("WXManager", "launchWxMiniProgram openSDK not support, ver = " + c16);
                a(jSFunction, -5);
                return;
            }
            int d16 = d();
            if (d16 < 620953856) {
                f.b("WXManager", "launchWxMiniProgram wx not support, ver = " + d16);
                a(jSFunction, -6);
                return;
            }
            String str = (String) f16.get("token");
            String str2 = (String) f16.get("adTraceData");
            String str3 = (String) f16.get("path");
            String str4 = (String) f16.get("userName");
            String str5 = (String) f16.get("muid");
            String str6 = (String) f16.get("wxAppId");
            String b16 = b(str, str2, str5);
            if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(b16)) {
                int e16 = e(str6, c16, str4, str3, b16);
                f.e("WXManager", "launchWxMiniProgram");
                a(jSFunction, e16);
                return;
            }
            f.b("WXManager", "launchWxMiniProgram params error:" + f16);
            a(jSFunction, -4);
        } catch (Throwable th5) {
            f.c("WXManager", "launchWxMiniProgram error", th5);
            a(jSFunction, -7);
        }
    }
}
