package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: P */
    /* renamed from: com.sina.weibo.sdk.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0511a {

        /* renamed from: an, reason: collision with root package name */
        public int f61248an;
        public String packageName = "com.sina.weibo";

        /* renamed from: am, reason: collision with root package name */
        public String f61247am = "com.sina.weibo.SSOActivity";
    }

    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager;
        ResolveInfo resolveActivity;
        if (context == null || (packageManager = context.getPackageManager()) == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(packageManager, resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature signature : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(d.a(signature.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static C0511a c(Context context) {
        List<ResolveInfo> queryIntentServices;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        C0511a c0511a = null;
        if (context != null && (queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, 0)) != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && serviceInfo.applicationInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                    String str = resolveInfo.serviceInfo.packageName;
                    C0511a d16 = d(context, str);
                    if (d16 != null) {
                        c0511a = d16;
                    }
                    if ("com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str)) {
                        break;
                    }
                }
            }
        }
        return c0511a;
    }

    private static C0511a d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream open = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            StringBuilder sb5 = new StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr, 0, 4096);
                if (read != -1) {
                    sb5.append(new String(bArr, 0, read));
                } else {
                    JSONObject jSONObject = new JSONObject(sb5.toString());
                    C0511a c0511a = new C0511a();
                    c0511a.f61248an = jSONObject.optInt("support_api", -1);
                    c0511a.f61247am = jSONObject.optString("authActivityName", null);
                    c0511a.packageName = str;
                    return c0511a;
                }
            }
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (IOException e17) {
            e17.printStackTrace();
            return null;
        } catch (JSONException e18) {
            e18.printStackTrace();
            return null;
        }
    }
}
