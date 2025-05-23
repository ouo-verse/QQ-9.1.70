package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.a.a;
import com.qq.e.comm.plugin.base.ad.model.n;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.az;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static int a(int i3) {
        if (i3 == 2) {
            return 2;
        }
        return i3 == 3 ? 1 : 0;
    }

    public static String a(int i3, int i16, String str) {
        com.qq.e.comm.plugin.base.ad.c cVar = new com.qq.e.comm.plugin.base.ad.c();
        cVar.a().b(i3);
        cVar.a().a(i16);
        cVar.a().b(str);
        try {
            GDTLogger.d("anti info:" + cVar.b());
            return URLEncoder.encode(cVar.b(), "UTF-8");
        } catch (Exception e16) {
            GDTLogger.w("Get anti failed:" + e16);
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, boolean z16, int i3) {
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONArray = new JSONArray();
            y.a(jSONObject2, "errorMessage", jSONArray);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
            GDTLogger.report("ExceptionIn DownClickRunnable.startInstalledAPP", th5);
        }
        if (y.a(jSONObject) && context != null) {
            com.qq.e.comm.plugin.base.ad.model.f fVar = new com.qq.e.comm.plugin.base.ad.model.f();
            fVar.e(jSONObject);
            n U = fVar.U();
            if (U == null) {
                a(jSONArray, 206);
                return jSONObject2;
            }
            List<String> b16 = U.b();
            String b17 = com.qq.e.comm.plugin.k.d.c(jSONObject).b();
            if (!com.qq.e.comm.plugin.k.g.b(b16) && !TextUtils.isEmpty(b17)) {
                Pair<Integer, JSONArray> a16 = a(context, U, z16);
                if (a16 == null) {
                    return jSONObject2;
                }
                int intValue = ((Integer) a16.first).intValue();
                w.b(jSONArray, (JSONArray) a16.second);
                if (intValue == 0) {
                    return jSONObject2;
                }
                y.a(jSONObject2, VirtualAppProxy.KEY_AUTO_DOWNLOAD, a(intValue));
                int i16 = 0;
                boolean z17 = false;
                while (true) {
                    if (i16 >= b16.size()) {
                        break;
                    }
                    String str = b16.get(i16);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("packageName", str);
                    if (TextUtils.isEmpty(str)) {
                        jSONObject3.putOpt("errorCode", 206);
                        jSONArray.mo162put(jSONObject3);
                    } else {
                        Pair<Boolean, JSONArray> a17 = a(context, str, U, intValue);
                        boolean booleanValue = ((Boolean) a17.first).booleanValue();
                        w.b(jSONArray, (JSONArray) a17.second);
                        if (booleanValue) {
                            a(fVar, b17, intValue, i3);
                            z17 = booleanValue;
                            break;
                        }
                        z17 = booleanValue;
                    }
                    i16++;
                }
                y.a(jSONObject2, "result", z17);
                return jSONObject2;
            }
            a(jSONArray, 206);
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Integer, JSONArray> a(Context context, n nVar, boolean z16) {
        int i3 = 0;
        if (nVar == null) {
            return new Pair<>(0, new JSONArray());
        }
        long f16 = nVar.f();
        String e16 = nVar.e();
        String d16 = nVar.d();
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(e16) || !TextUtils.isEmpty(d16)) {
            if (f16 < System.currentTimeMillis()) {
                a(jSONArray, 318);
            } else if (!az.b(context)) {
                a(jSONArray, 319);
            } else if (!a()) {
                a(jSONArray, 321);
            }
            if (i3 == 0) {
                if (ay.b(nVar.a())) {
                    i3 = 1;
                } else {
                    a(jSONArray, 304);
                }
            }
            return new Pair<>(Integer.valueOf(i3), jSONArray);
        }
        if (!TextUtils.isEmpty(e16)) {
            if (z16 && ay.b(e16)) {
                i3 = 3;
                if (i3 == 0) {
                }
                return new Pair<>(Integer.valueOf(i3), jSONArray);
            }
            if (!z16) {
                a(jSONArray, 320, e16);
            } else if (!ay.b(e16)) {
                a(jSONArray, 304, e16);
            }
        }
        if (!TextUtils.isEmpty(d16)) {
            if (ay.b(d16)) {
                i3 = 2;
            } else {
                a(jSONArray, 304);
            }
        }
        if (i3 == 0) {
        }
        return new Pair<>(Integer.valueOf(i3), jSONArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Boolean, JSONArray> a(Context context, String str, n nVar, int i3) {
        Intent a16;
        if (context != null && str != null && i3 != 0) {
            String a17 = a(nVar, i3);
            if (!ay.b(a17)) {
                return new Pair<>(Boolean.FALSE, new JSONArray());
            }
            JSONArray jSONArray = new JSONArray();
            try {
                if (!com.qq.e.comm.plugin.base.ad.e.a.a.a(context, str, (String) null, a17)) {
                    a(jSONArray, 314);
                    return new Pair<>(Boolean.FALSE, jSONArray);
                }
                boolean z16 = false;
                if (az.b(context) && (i3 == 2 || i3 == 3)) {
                    Intent a18 = com.qq.e.comm.plugin.base.ad.e.a.a.a(str, a17, false);
                    Activity activity = (Activity) context;
                    if (a18 != null) {
                        activity.startActivityForResult(a18, 1);
                        z16 = true;
                    }
                    if (!z16) {
                    }
                    return new Pair<>(Boolean.valueOf(z16), jSONArray);
                }
                if (i3 == 1 && (a16 = com.qq.e.comm.plugin.base.ad.e.a.a.a(context, str, (String) null, Uri.parse(a17))) != null) {
                    context.startActivity(a16);
                    z16 = true;
                }
                if (!z16) {
                    a(jSONArray, 315);
                }
                return new Pair<>(Boolean.valueOf(z16), jSONArray);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
                return new Pair<>(Boolean.FALSE, jSONArray);
            }
        }
        return new Pair<>(Boolean.FALSE, new JSONArray());
    }

    private static void a(com.qq.e.comm.plugin.base.ad.model.f fVar, final String str, int i3, int i16) {
        int i17;
        if (TextUtils.isEmpty(str) || i3 == 0) {
            return;
        }
        try {
            com.qq.e.comm.plugin.base.ad.model.d dVar = new com.qq.e.comm.plugin.base.ad.model.d(fVar.f(), fVar.V(), fVar.y(), null, null, null, str, null, 0, fVar.b());
            dVar.a("startTimeMills", System.currentTimeMillis());
            dVar.a(VirtualAppProxy.KEY_DOWNLOAD_SCENE, i16);
            int i18 = 2;
            if (i3 != 2) {
                if (i3 == 3) {
                    i17 = 1;
                    dVar.a(VirtualAppProxy.KEY_AUTO_DOWNLOAD, i17);
                    ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).startInstallChecker(dVar);
                    if (i3 == 1 && a()) {
                        com.qq.e.comm.plugin.f.a.a(new com.qq.e.comm.plugin.f.b(str, fVar.s(), fVar.f(), fVar.y(), i17, i16));
                        GdtSDKThreadManager.getInstance().runOnThread(1, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.qq.e.comm.plugin.f.a.a(str);
                            }
                        }, com.qq.e.comm.plugin.j.c.a("mktReceiverDelay", 300000));
                    }
                    return;
                }
                i18 = 0;
            }
            i17 = i18;
            dVar.a(VirtualAppProxy.KEY_AUTO_DOWNLOAD, i17);
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).startInstallChecker(dVar);
            if (i3 == 1) {
                return;
            }
            com.qq.e.comm.plugin.f.a.a(new com.qq.e.comm.plugin.f.b(str, fVar.s(), fVar.f(), fVar.y(), i17, i16));
            GdtSDKThreadManager.getInstance().runOnThread(1, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.qq.e.comm.plugin.f.a.a(str);
                }
            }, com.qq.e.comm.plugin.j.c.a("mktReceiverDelay", 300000));
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private static String a(n nVar, int i3) {
        if (nVar == null) {
            return null;
        }
        if (i3 == 1) {
            return nVar.a();
        }
        if (i3 == 2) {
            return nVar.d();
        }
        if (i3 != 3) {
            return null;
        }
        return nVar.e();
    }

    private static boolean a() {
        Context appContext;
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT < 29 || (appContext = GDTADManager.getInstance().getAppContext()) == null || (call = appContext.getContentResolver().call(Uri.parse("content://mk_ex"), "querySupportPostback", (String) null, (Bundle) null)) == null) {
                return false;
            }
            return call.getBoolean("isSupport", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(JSONArray jSONArray, int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i3 > 0) {
                y.a(jSONObject, "errorCode", i3);
            }
            if (!TextUtils.isEmpty(str)) {
                y.a(jSONObject, ZPlanPublishSource.FROM_SCHEME, str);
            }
            jSONArray.mo162put(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private static void a(JSONArray jSONArray, int i3) {
        a(jSONArray, i3, (String) null);
    }

    public static void a(String str, final String str2, final com.qq.e.comm.plugin.stat.b bVar, final long j3) {
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, 0, z.a(bVar, null, j3));
        if (TextUtils.isEmpty(str)) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, 0, z.a(bVar, null, j3));
        }
        com.qq.e.comm.plugin.base.ad.clickcomponent.a.a aVar = new com.qq.e.comm.plugin.base.ad.clickcomponent.a.a(str);
        aVar.a(new a.InterfaceC0279a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.2
            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(int i3, JSONObject jSONObject) {
                if (i3 != 200 && i3 != 302) {
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, 0, z.a(com.qq.e.comm.plugin.stat.b.this, null, j3));
                } else {
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS, 0, z.a(com.qq.e.comm.plugin.stat.b.this, null, j3));
                }
                StatTracer.instantReport(str2);
            }

            @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
            public void a(Exception exc) {
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, 0, z.a(com.qq.e.comm.plugin.stat.b.this, null, j3));
                StatTracer.instantReport(str2);
            }
        });
        aVar.a();
    }
}
