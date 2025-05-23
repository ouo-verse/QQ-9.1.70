package com.qq.e.comm.plugin.base.ad.d;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.b;
import com.qq.e.comm.plugin.base.ad.c.f;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.k.c;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f38753a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Boolean> f38754b = new ConcurrentHashMap<>();

    a() {
    }

    public static a a() {
        if (f38753a == null) {
            synchronized (a.class) {
                if (f38753a == null) {
                    f38753a = new a();
                }
            }
        }
        return f38753a;
    }

    public void a(JSONArray jSONArray, String str) {
        String aPPName = GDTADManager.getInstance().getAppStatus().getAPPName();
        String aPPRealName = GDTADManager.getInstance().getAppStatus().getAPPRealName();
        String processName = GDTADManager.getInstance().getProcessName();
        if (!TextUtils.equals(aPPName, processName) && !TextUtils.equals(aPPRealName, processName)) {
            GDTLogger.e("AdInstallStatusReporter processAdJson not in main process :" + aPPName + " processName :" + processName);
            return;
        }
        if (y.a(jSONArray)) {
            GDTLogger.e("AdInstallStatusReporter posList null");
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject a16 = y.a(jSONArray, i3);
            if (y.a(a16)) {
                JSONArray f16 = y.f(a16, "report_pkg_name");
                a(f16);
                a(a16, f16, str);
            }
        }
    }

    private void a(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String c16 = y.c(jSONArray, i3);
            if (!TextUtils.isEmpty(c16) && !this.f38754b.containsKey(c16)) {
                boolean a16 = c.a(GDTADManager.getInstance().getAppContext(), c16);
                GDTLogger.d("AdInstallStatusReporter processRpnList pkgName :" + c16 + " isApkInstalled :" + a16);
                a(c16, a16);
            }
        }
    }

    private void a(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f38754b.put(str, Boolean.valueOf(z16));
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray, String str) {
        if (!y.a(jSONObject) || y.a(jSONArray) || TextUtils.isEmpty(str)) {
            return;
        }
        l lVar = new l(str, b.UNKNOWN, (com.qq.e.comm.plugin.base.ad.definition.a) null);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String c16 = y.c(jSONArray, i3);
            if (!TextUtils.isEmpty(c16)) {
                Boolean bool = this.f38754b.get(c16);
                try {
                    f.a(c16, y.e(jSONObject, "traceid"), lVar, null, (bool == null || !bool.booleanValue()) ? "0" : "1", "3");
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }
}
