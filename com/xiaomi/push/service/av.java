package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.ge;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.io;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    private static au f389671a;

    /* renamed from: b, reason: collision with root package name */
    private static a f389672b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static synchronized au b(Context context) {
        synchronized (av.class) {
            au auVar = f389671a;
            if (auVar != null) {
                return auVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i3 = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && ge.m(string7)) {
                string7 = ge.z(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String z16 = ge.z(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(z16) && !TextUtils.isEmpty(string7) && !string7.equals(z16)) {
                jz4.c.m("read_phone_state permission changes.");
            }
            au auVar2 = new au(string, string2, string3, string4, string5, string6, i3);
            f389671a = auVar2;
            return auVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:118)|14|(1:16)(1:117)|17|(1:19)(1:116)|20|21|22|23|(1:25)(1:112)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|106|(2:91|93)|94|95|96))|111|61|(0)(0)))|119|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|111|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x008c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x008d, code lost:
    
        jz4.c.q(r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[Catch: all -> 0x035a, TryCatch #5 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0023, B:10:0x003b, B:11:0x0047, B:14:0x005b, B:17:0x0068, B:20:0x0075, B:22:0x0081, B:25:0x0096, B:26:0x00a0, B:28:0x00ce, B:30:0x00db, B:31:0x00ee, B:33:0x00f8, B:35:0x00fe, B:36:0x0113, B:38:0x0119, B:39:0x011f, B:41:0x0144, B:42:0x014e, B:43:0x0189, B:45:0x018f, B:47:0x0196, B:52:0x01a5, B:55:0x01d9, B:57:0x01fc, B:60:0x0203, B:61:0x021b, B:69:0x022a, B:110:0x0231, B:71:0x0249, B:73:0x024f, B:101:0x0311, B:91:0x0344, B:93:0x034a, B:94:0x0352, B:99:0x032a, B:115:0x008d), top: B:3:0x0005, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce A[Catch: all -> 0x035a, TryCatch #5 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0023, B:10:0x003b, B:11:0x0047, B:14:0x005b, B:17:0x0068, B:20:0x0075, B:22:0x0081, B:25:0x0096, B:26:0x00a0, B:28:0x00ce, B:30:0x00db, B:31:0x00ee, B:33:0x00f8, B:35:0x00fe, B:36:0x0113, B:38:0x0119, B:39:0x011f, B:41:0x0144, B:42:0x014e, B:43:0x0189, B:45:0x018f, B:47:0x0196, B:52:0x01a5, B:55:0x01d9, B:57:0x01fc, B:60:0x0203, B:61:0x021b, B:69:0x022a, B:110:0x0231, B:71:0x0249, B:73:0x024f, B:101:0x0311, B:91:0x0344, B:93:0x034a, B:94:0x0352, B:99:0x032a, B:115:0x008d), top: B:3:0x0005, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144 A[Catch: all -> 0x035a, TryCatch #5 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0023, B:10:0x003b, B:11:0x0047, B:14:0x005b, B:17:0x0068, B:20:0x0075, B:22:0x0081, B:25:0x0096, B:26:0x00a0, B:28:0x00ce, B:30:0x00db, B:31:0x00ee, B:33:0x00f8, B:35:0x00fe, B:36:0x0113, B:38:0x0119, B:39:0x011f, B:41:0x0144, B:42:0x014e, B:43:0x0189, B:45:0x018f, B:47:0x0196, B:52:0x01a5, B:55:0x01d9, B:57:0x01fc, B:60:0x0203, B:61:0x021b, B:69:0x022a, B:110:0x0231, B:71:0x0249, B:73:0x024f, B:101:0x0311, B:91:0x0344, B:93:0x034a, B:94:0x0352, B:99:0x032a, B:115:0x008d), top: B:3:0x0005, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018f A[Catch: all -> 0x035a, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0023, B:10:0x003b, B:11:0x0047, B:14:0x005b, B:17:0x0068, B:20:0x0075, B:22:0x0081, B:25:0x0096, B:26:0x00a0, B:28:0x00ce, B:30:0x00db, B:31:0x00ee, B:33:0x00f8, B:35:0x00fe, B:36:0x0113, B:38:0x0119, B:39:0x011f, B:41:0x0144, B:42:0x014e, B:43:0x0189, B:45:0x018f, B:47:0x0196, B:52:0x01a5, B:55:0x01d9, B:57:0x01fc, B:60:0x0203, B:61:0x021b, B:69:0x022a, B:110:0x0231, B:71:0x0249, B:73:0x024f, B:101:0x0311, B:91:0x0344, B:93:0x034a, B:94:0x0352, B:99:0x032a, B:115:0x008d), top: B:3:0x0005, inners: #0, #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0225 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0344 A[Catch: all -> 0x035a, TryCatch #5 {, blocks: (B:4:0x0005, B:6:0x001b, B:8:0x0023, B:10:0x003b, B:11:0x0047, B:14:0x005b, B:17:0x0068, B:20:0x0075, B:22:0x0081, B:25:0x0096, B:26:0x00a0, B:28:0x00ce, B:30:0x00db, B:31:0x00ee, B:33:0x00f8, B:35:0x00fe, B:36:0x0113, B:38:0x0119, B:39:0x011f, B:41:0x0144, B:42:0x014e, B:43:0x0189, B:45:0x018f, B:47:0x0196, B:52:0x01a5, B:55:0x01d9, B:57:0x01fc, B:60:0x0203, B:61:0x021b, B:69:0x022a, B:110:0x0231, B:71:0x0249, B:73:0x024f, B:101:0x0311, B:91:0x0344, B:93:0x034a, B:94:0x0352, B:99:0x032a, B:115:0x008d), top: B:3:0x0005, inners: #0, #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized au c(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        PackageInfo packageInfo;
        String str8;
        int c16;
        String a16;
        boolean z16;
        String e16;
        com.xiaomi.push.v vVar;
        boolean z17;
        JSONObject jSONObject;
        synchronized (av.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", ge.h(context, false));
            au auVar = f389671a;
            if (auVar != null && !TextUtils.isEmpty(auVar.f389664a)) {
                treeMap.put("uuid", f389671a.f389664a);
                int lastIndexOf = f389671a.f389664a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = f389671a.f389664a.substring(lastIndexOf + 1);
                    com.xiaomi.push.q.a(context).d(treeMap);
                    if (!k(context)) {
                        str5 = "1000271";
                    } else {
                        str5 = str2;
                    }
                    if (!k(context)) {
                        str6 = "420100086271";
                    } else {
                        str6 = str3;
                    }
                    if (!k(context)) {
                        str7 = "com.xiaomi.xmsf";
                    } else {
                        str7 = str;
                    }
                    treeMap.put("appid", str5);
                    treeMap.put("apptoken", str6);
                    packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str7, 16384);
                    if (packageInfo == null) {
                        str8 = String.valueOf(packageInfo.versionCode);
                    } else {
                        str8 = "0";
                    }
                    treeMap.put("appversion", str8);
                    treeMap.put(AdParam.SDKVERSION, Integer.toString(50909));
                    treeMap.put("packagename", str7);
                    treeMap.put("model", ia.a());
                    treeMap.put("board", Build.BOARD);
                    if (!hz.t()) {
                        String str9 = "";
                        String t16 = ge.t(context);
                        if (!TextUtils.isEmpty(t16)) {
                            str9 = "" + com.xiaomi.push.ag.b(t16);
                        }
                        String x16 = ge.x(context);
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(x16)) {
                            str9 = str9 + "," + x16;
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            treeMap.put("imei_md5", str9);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    c16 = ge.c();
                    if (c16 >= 0) {
                        treeMap.put("space_id", Integer.toString(c16));
                    }
                    treeMap.put("brand", Build.BRAND + "");
                    treeMap.put("ram", ge.e());
                    treeMap.put("rom", ge.o());
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e17) {
                            jz4.c.B("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e17);
                        }
                    }
                    a16 = ad.a(jSONObject2.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put(WebViewPlugin.KEY_REQUEST, a16);
                    treeMap2.put("keyPairVer", "1");
                    if (a(context) < 2 && !TextUtils.isEmpty(a16)) {
                        jz4.c.m("r.data = " + a16);
                        z16 = true;
                        e16 = e(context, z16);
                        if (!TextUtils.isEmpty(e16)) {
                            return null;
                        }
                        if (z16) {
                            treeMap = treeMap2;
                        }
                        try {
                            vVar = com.xiaomi.push.au.c(context, e16, treeMap);
                        } catch (IOException e18) {
                            jz4.c.B("device registration request failed. " + e18);
                            vVar = null;
                        }
                        if (vVar != null && vVar.f389862a == 200) {
                            String a17 = vVar.a();
                            if (!TextUtils.isEmpty(a17)) {
                                try {
                                    jSONObject = new JSONObject(a17);
                                    try {
                                    } catch (JSONException e19) {
                                        e = e19;
                                        jz4.c.B("failed to parse respone json data. " + e);
                                        if (z17) {
                                        }
                                        jz4.c.m("fail to register push account. meet error.");
                                        return null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        jz4.c.B("unknow throwable. " + th);
                                        if (z17) {
                                        }
                                        jz4.c.m("fail to register push account. meet error.");
                                        return null;
                                    }
                                } catch (JSONException e26) {
                                    e = e26;
                                    z17 = z16;
                                } catch (Throwable th6) {
                                    th = th6;
                                    z17 = z16;
                                }
                                if (jSONObject.getInt("code") == 0) {
                                    JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                                    String string = jSONObject3.getString("ssecurity");
                                    String string2 = jSONObject3.getString("token");
                                    String string3 = jSONObject3.getString("userId");
                                    if (TextUtils.isEmpty(str4)) {
                                        str4 = com.tencent.av.ui.an.f75362j + com.xiaomi.push.ag.a(6);
                                    }
                                    au auVar2 = new au(string3 + "@xiaomi.com/" + str4, string2, string, str5, str6, str7, io.a());
                                    i(context, auVar2);
                                    f389671a = auVar2;
                                    h(context, 0);
                                    jz4.c.m("device registration is successful. " + string3);
                                    return auVar2;
                                }
                                z17 = z16;
                                az.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                                jz4.c.m("device registration resp: " + a17);
                                if (z17 && com.xiaomi.push.au.v(context)) {
                                    h(context, a(context) + 1);
                                }
                                jz4.c.m("fail to register push account. meet error.");
                                return null;
                            }
                        }
                        z17 = z16;
                        if (z17) {
                            h(context, a(context) + 1);
                        }
                        jz4.c.m("fail to register push account. meet error.");
                        return null;
                    }
                    z16 = false;
                    e16 = e(context, z16);
                    if (!TextUtils.isEmpty(e16)) {
                    }
                }
            }
            str4 = null;
            com.xiaomi.push.q.a(context).d(treeMap);
            if (!k(context)) {
            }
            if (!k(context)) {
            }
            if (!k(context)) {
            }
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str7, 16384);
            if (packageInfo == null) {
            }
            treeMap.put("appversion", str8);
            treeMap.put(AdParam.SDKVERSION, Integer.toString(50909));
            treeMap.put("packagename", str7);
            treeMap.put("model", ia.a());
            treeMap.put("board", Build.BOARD);
            if (!hz.t()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            c16 = ge.c();
            if (c16 >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", ge.e());
            treeMap.put("rom", ge.o());
            JSONObject jSONObject22 = new JSONObject();
            while (r9.hasNext()) {
            }
            a16 = ad.a(jSONObject22.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put(WebViewPlugin.KEY_REQUEST, a16);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2) {
                jz4.c.m("r.data = " + a16);
                z16 = true;
                e16 = e(context, z16);
                if (!TextUtils.isEmpty(e16)) {
                }
            }
            z16 = false;
            e16 = e(context, z16);
            if (!TextUtils.isEmpty(e16)) {
            }
        }
    }

    public static String d(Context context) {
        au b16 = b(context);
        if (b16 != null && !TextUtils.isEmpty(b16.f389664a)) {
            String[] split = b16.f389664a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    private static String e(Context context, boolean z16) {
        String str;
        String b16 = ag.a(context).b();
        if (z16) {
            str = "/pass/v2/register/encrypt";
        } else {
            str = "/pass/v2/register";
        }
        if (io.d()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (com.xiaomi.push.n.China.name().equals(b16)) {
            return "https://cn.register.xmpush.xiaomi.com" + str;
        }
        return null;
    }

    public static void f() {
        a aVar = f389672b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void g(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f389671a = null;
        f();
    }

    private static void h(Context context, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i3);
        edit.commit();
    }

    public static void i(Context context, au auVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", auVar.f389664a);
        edit.putString("security", auVar.f389666c);
        edit.putString("token", auVar.f389665b);
        edit.putString("app_id", auVar.f389667d);
        edit.putString("package_name", auVar.f389669f);
        edit.putString("app_token", auVar.f389668e);
        edit.putString("device_id", ge.z(context));
        edit.putInt("env_type", auVar.f389670g);
        edit.commit();
        f();
    }

    public static void j(a aVar) {
        f389672b = aVar;
    }

    private static boolean k(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
