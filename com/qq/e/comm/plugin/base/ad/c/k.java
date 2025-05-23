package com.qq.e.comm.plugin.base.ad.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.s;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static volatile k f38482a;

    /* renamed from: b, reason: collision with root package name */
    private volatile JSONObject f38483b = null;

    k() {
    }

    public static k a() {
        if (f38482a == null) {
            synchronized (k.class) {
                if (f38482a == null) {
                    f38482a = new k();
                }
            }
        }
        return f38482a;
    }

    private void c() {
        File a16 = at.a();
        if (a16 != null && a16.exists()) {
            File file = new File(a16, "preload");
            if (file.exists()) {
                try {
                    if (!TextUtils.isEmpty(at.c(file))) {
                        this.f38483b = new JSONObject(at.c(file));
                    }
                } catch (Throwable th5) {
                    GDTLogger.e(th5.getMessage());
                }
            }
        }
    }

    public synchronized void b() {
        File a16 = at.a();
        if (a16 != null && a16.exists()) {
            File file = new File(a16, "preload");
            if (this.f38483b != null) {
                GDTLogger.d("update wx preload res file");
                at.a(file, this.f38483b.toString());
            }
            this.f38483b = null;
        }
    }

    public boolean a(JSONObject jSONObject, String str) {
        if (y.a(jSONObject) && com.qq.e.comm.plugin.j.e.a().a(str, "wxPreloadFetchPkgInfo", 0) == 1) {
            return com.qq.e.comm.plugin.k.b.d(jSONObject) || (com.qq.e.comm.plugin.k.b.c(jSONObject) && com.qq.e.comm.plugin.j.e.a().a(str, "wxPreloadSupportGame", 1) == 1);
        }
        return false;
    }

    public String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        } else {
            int indexOf = str2.indexOf("&gdt_vid");
            if (indexOf >= 0) {
                str2 = str2.substring(0, indexOf);
                GDTLogger.d("raw path = " + str2);
            }
        }
        return Md5Util.encode(str + str2);
    }

    public synchronized JSONObject a(String str, String str2) {
        c();
        if (this.f38483b == null || TextUtils.isEmpty(b(str, str2))) {
            return null;
        }
        return this.f38483b.optJSONObject(b(str, str2));
    }

    public synchronized void a(String str) {
        File a16 = at.a();
        if (a16 != null && a16.exists()) {
            GDTLogger.d(a16.getAbsolutePath());
            c();
            List<File> c16 = ai.c(a16.getAbsolutePath());
            if (c16 != null && c16.size() != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
                bVar.a("cur_download_package_count", c16.size() - 1);
                bVar.a("total_package_size", Math.round((at.a(a16) * 1000.0d) / 1048576.0d) / 1000.0d);
                bVar.a("remain_time", (currentTimeMillis - c16.get(c16.size() - 1).lastModified()) / 3600000);
                int a17 = com.qq.e.comm.plugin.j.e.a().a(str, "wxMiniProgramExpireTime", 12);
                boolean z16 = false;
                for (File file : c16) {
                    if (file != null) {
                        if (currentTimeMillis - file.lastModified() >= a17 * 3600000) {
                            file.delete();
                            if (this.f38483b != null) {
                                this.f38483b.remove(file.getName());
                            }
                            z16 = true;
                        }
                    }
                }
                if (z16) {
                    bVar.a("act_code", 1);
                    StatTracer.trackEvent(5000022, 0, bVar);
                }
                if (at.a(a16) >= com.qq.e.comm.plugin.j.e.a().a(str, "wxPreloadMaxDirSize", 50) * 1024 * 1024) {
                    bVar.a("act_code", 2);
                    StatTracer.trackEvent(5000022, 0, bVar);
                    int size = (((c16.size() - 1) * (100 - com.qq.e.comm.plugin.j.e.a().a(str, "wxPreloadDirCleanFactor", 50))) / 100) + 1;
                    while (c16.size() > size) {
                        File remove = c16.remove(c16.size() - 1);
                        remove.delete();
                        if (this.f38483b != null) {
                            this.f38483b.remove(remove.getName());
                        }
                    }
                }
            }
        }
    }

    public Pair<JSONArray, Boolean> a(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return new Pair<>(jSONArray, Boolean.FALSE);
        }
        HashMap hashMap = new HashMap();
        boolean z16 = false;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (com.qq.e.comm.plugin.k.b.e(jSONObject)) {
                    String optString = jSONObject.optString("wechat_app_path");
                    String optString2 = jSONObject.optString("wechat_app_username");
                    if (!TextUtils.isEmpty(b(optString2, optString))) {
                        hashMap.put(b(optString2, optString), jSONObject);
                    }
                }
                if (com.qq.e.comm.plugin.k.b.g(jSONObject) && !z16) {
                    z16 = true;
                }
            } catch (JSONException e16) {
                GDTLogger.e(e16.getMessage());
            }
        }
        return new Pair<>(new JSONArray(hashMap.values()), Boolean.valueOf(z16));
    }

    public synchronized void a(String str, String str2, String str3, long j3, String str4, long j16) {
        Uri a16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File a17 = at.a();
        if (a17 != null && a17.exists()) {
            c();
            if (this.f38483b == null) {
                this.f38483b = new JSONObject();
            }
            try {
                a16 = s.a(GDTADManager.getInstance().getAppContext(), new File(a17 + File.separator + str), null, "com.tencent.mm");
            } catch (JSONException e16) {
                GDTLogger.e(e16.getMessage());
            }
            if (a16 == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadUrl", str2);
            jSONObject.put("fileMd5", str3);
            jSONObject.put("expireTime", j3);
            jSONObject.put("extraBytes", str4);
            jSONObject.put("filePath", a16.toString());
            jSONObject.put(VirtualAppProxy.KEY_PKG_SIZE, j16);
            this.f38483b.put(str, jSONObject);
            GDTLogger.d("fetchPkgInfo, save wx package info success");
        }
    }
}
