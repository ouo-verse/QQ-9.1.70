package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b extends com.tencent.tbs.one.impl.a.b<e<d>> implements a.InterfaceC9892a {

    /* renamed from: b, reason: collision with root package name */
    int f374939b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f374940c;

    /* renamed from: d, reason: collision with root package name */
    private final String f374941d;

    /* renamed from: e, reason: collision with root package name */
    private final String f374942e;

    /* renamed from: f, reason: collision with root package name */
    private final String[] f374943f;

    /* renamed from: g, reason: collision with root package name */
    private final int f374944g;

    /* renamed from: h, reason: collision with root package name */
    private final File f374945h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.tbs.one.impl.d.a f374946i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f374947j;

    public b(Context context, String str, String str2, String[] strArr, int i3, File file, Bundle bundle) {
        this.f374940c = context;
        this.f374941d = str;
        this.f374942e = str2;
        this.f374943f = strArr;
        this.f374944g = i3;
        this.f374945h = file;
        this.f374947j = bundle;
    }

    private JSONObject c() {
        try {
            return f.a(BuildConfig.COMPONENT_SDK_VERSIONS);
        } catch (Throwable th5) {
            g.c("[%s] Failed to get component sdk versions", this.f374941d, th5);
            return new JSONObject();
        }
    }

    private JSONObject d() {
        File[] listFiles = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.f374940c.getDir("tbs", 0), this.f374941d)).listFiles();
        JSONObject jSONObject = new JSONObject();
        if (listFiles != null) {
            for (File file : listFiles) {
                f.a(jSONObject, file.getName(), Integer.valueOf(com.tencent.tbs.one.impl.e.f.c(file)));
            }
        }
        return jSONObject;
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        Context context = this.f374940c;
        String str = this.f374941d;
        String[] strArr = this.f374943f;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!str2.equals(context.getPackageName())) {
                    try {
                        int a16 = a(context.createPackageContext(str2, 2), str);
                        if (a16 != -1) {
                            jSONArray.put(a16);
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
    @Override // com.tencent.tbs.one.impl.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        PackageInfo packageInfo;
        String b16;
        Object obj;
        int shouldOverrideInstallationJob;
        Context context = this.f374940c;
        final String str = this.f374941d;
        final File file = this.f374945h;
        g.a("[%s] [AutoDEPSInstallationJob].run start on file=%s", str, file);
        com.tencent.tbs.one.b.c(this.f374941d).c("depsRequest");
        TBSOneRuntimeExtension a16 = com.tencent.tbs.one.impl.common.a.a(context, str);
        if (a16 != null && (shouldOverrideInstallationJob = a16.shouldOverrideInstallationJob(str, "DEPS", -1, null, file, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.a.b.1
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r46) {
                g.a("[%s] Finished intercepting DEPS installation job by runtime extension", str);
                b.this.f374939b = 0;
                try {
                    b.this.a((b) e.a(e.a.EXTENSION, d.a(file)));
                } catch (TBSOneException e16) {
                    b.this.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i3, String str2) {
                b bVar = b.this;
                bVar.f374939b = 0;
                bVar.a(i3, str2, (Throwable) null);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i3, int i16) {
                b.this.a(i16);
            }
        })) != 0) {
            g.a("[%s] Intercepted DEPS installation job by runtime extension", str);
            this.f374939b = shouldOverrideInstallationJob;
            return;
        }
        JSONObject jSONObject = new JSONObject();
        final int a17 = a(context, str);
        f.a(jSONObject, "ONEV", 5);
        f.a(jSONObject, "DEPSV", Integer.valueOf(a17));
        f.a(jSONObject, "HSTV", e());
        f.a(jSONObject, "SDKV", c());
        f.a(jSONObject, "LOCV", d());
        int i3 = this.f374944g;
        if (i3 != -1) {
            f.a(jSONObject, "REQV", Integer.valueOf(i3));
        }
        f.a(jSONObject, "PROTV", 1);
        f.a(jSONObject, "FUNC", 0);
        String packageName = context.getPackageName();
        f.a(jSONObject, "PN", packageName);
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, packageName, 0);
            try {
                f.a(jSONObject, "PPVC", Integer.valueOf(packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException e16) {
                e = e16;
                g.c("Failed to get package info for %s", packageName, e);
                b16 = com.tencent.tbs.one.impl.a.e.b();
                if (TextUtils.isEmpty(b16)) {
                }
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
                if (applicationInfo != null) {
                }
                f.a(jSONObject, "BVR", Build.VERSION.RELEASE);
                f.a(jSONObject, "ABI", com.tencent.tbs.one.impl.a.e.d());
                f.a(jSONObject, Global.TRACKING_IMEI, com.tencent.tbs.one.impl.a.e.c());
                f.a(jSONObject, "GUID", com.tencent.tbs.one.impl.a.e.a());
                f.a(jSONObject, "ADRID", com.tencent.tbs.one.impl.a.e.a(context));
                f.a(jSONObject, "UA", com.tencent.tbs.one.impl.a.e.e(context));
                f.a(jSONObject, "UNIQUEID", n.b(context));
                g.a("[%s] Requesting DEPS from %s, post data: %s", str, this.f374942e, jSONObject);
                h.b("TBSOneAction", 1000).f(a17).e(com.tencent.tbs.one.impl.common.f.b(context, this.f374941d)).a();
                com.tencent.tbs.one.impl.d.a aVar = new com.tencent.tbs.one.impl.d.a(context, this.f374942e, "POST", null, jSONObject.toString().getBytes(com.tencent.tbs.one.impl.common.b.f374813b));
                this.f374946i = aVar;
                aVar.f374889f = this;
                aVar.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.a.b.2
                    @Override // com.tencent.tbs.one.impl.a.m
                    public final void a(int i16, int i17) {
                        b.this.a(i17);
                    }

                    @Override // com.tencent.tbs.one.impl.a.m
                    public final void a(int i16, String str2, Throwable th5) {
                        b.this.a(i16, str2, th5);
                        h.b("TBSOneAction", 1002).g(a17).a();
                    }
                });
            }
        } catch (PackageManager.NameNotFoundException e17) {
            e = e17;
            packageInfo = null;
        }
        b16 = com.tencent.tbs.one.impl.a.e.b();
        if (TextUtils.isEmpty(b16)) {
            f.a(jSONObject, "PPVN", b16);
        } else if (packageInfo != null) {
            f.a(jSONObject, "PPVN", packageInfo.versionName);
        }
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 128);
        } catch (Exception e18) {
            g.c("Failed to get application info for %s", packageName, e18);
        }
        if (applicationInfo != null) {
            f.a(jSONObject, "TAPI", Integer.valueOf(applicationInfo.targetSdkVersion));
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && (obj = bundle.get(TbsDownloader.TBS_METADATA)) != null) {
                try {
                    f.a(jSONObject, "META", Integer.toHexString(Integer.parseInt(String.valueOf(obj))));
                } catch (Exception e19) {
                    g.c("Failed to parse meta data %s", obj, e19);
                }
            }
        }
        f.a(jSONObject, "BVR", Build.VERSION.RELEASE);
        f.a(jSONObject, "ABI", com.tencent.tbs.one.impl.a.e.d());
        f.a(jSONObject, Global.TRACKING_IMEI, com.tencent.tbs.one.impl.a.e.c());
        f.a(jSONObject, "GUID", com.tencent.tbs.one.impl.a.e.a());
        f.a(jSONObject, "ADRID", com.tencent.tbs.one.impl.a.e.a(context));
        f.a(jSONObject, "UA", com.tencent.tbs.one.impl.a.e.e(context));
        f.a(jSONObject, "UNIQUEID", n.b(context));
        g.a("[%s] Requesting DEPS from %s, post data: %s", str, this.f374942e, jSONObject);
        h.b("TBSOneAction", 1000).f(a17).e(com.tencent.tbs.one.impl.common.f.b(context, this.f374941d)).a();
        com.tencent.tbs.one.impl.d.a aVar2 = new com.tencent.tbs.one.impl.d.a(context, this.f374942e, "POST", null, jSONObject.toString().getBytes(com.tencent.tbs.one.impl.common.b.f374813b));
        this.f374946i = aVar2;
        aVar2.f374889f = this;
        aVar2.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.a.b.2
            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i16, int i17) {
                b.this.a(i17);
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i16, String str2, Throwable th5) {
                b.this.a(i16, str2, th5);
                h.b("TBSOneAction", 1002).g(a17).a();
            }
        });
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        TBSOneRuntimeExtension a16;
        super.b();
        com.tencent.tbs.one.impl.d.a aVar = this.f374946i;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f374939b != 0 && (a16 = com.tencent.tbs.one.impl.common.a.a(this.f374940c, this.f374941d)) != null) {
            a16.cancel(this.f374939b);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void a(int i3, String str, Throwable th5) {
        com.tencent.tbs.one.impl.e.f.a(this.f374945h, System.currentTimeMillis());
        super.a(i3, str, th5);
    }

    @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
    public final void a(int i3, Map<String, List<String>> map, InputStream inputStream) {
        int shouldInterceptDEPSResponse;
        Context context = this.f374940c;
        final String str = this.f374941d;
        String str2 = this.f374942e;
        final File file = this.f374945h;
        g.a("[%s] Receiving DEPS response: [%d] %s", str, Integer.valueOf(i3), map);
        if (i3 == 200 && inputStream != null) {
            TBSOneRuntimeExtension a16 = com.tencent.tbs.one.impl.common.a.a(context, str);
            if (a16 != null && (shouldInterceptDEPSResponse = a16.shouldInterceptDEPSResponse(str, null, inputStream, file, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.a.b.3
                @Override // com.tencent.tbs.one.TBSOneCallback
                public final /* synthetic */ void onCompleted(Void r46) {
                    g.a("[%s] Finished intercepting DEPS response stream by runtime extension", str);
                    b.this.f374939b = 0;
                    try {
                        b.this.a((b) e.a(e.a.EXTENSION, d.a(file)));
                    } catch (TBSOneException e16) {
                        b.this.a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                    }
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onError(int i16, String str3) {
                    b bVar = b.this;
                    bVar.f374939b = 0;
                    bVar.a(i16, str3, (Throwable) null);
                }

                @Override // com.tencent.tbs.one.TBSOneCallback
                public final void onProgressChanged(int i16, int i17) {
                    b.this.a(com.tencent.tbs.one.impl.e.f.a(i17, 50, 100));
                }
            })) != 0) {
                g.a("[%s] Intercepted DEPS response stream by runtime extension", str);
                this.f374939b = shouldInterceptDEPSResponse;
                return;
            }
            try {
                String a17 = com.tencent.tbs.one.impl.a.d.a(inputStream, "utf-8");
                try {
                    JSONObject jSONObject = new JSONObject(a17);
                    g.a("AutoDEPSInstallationJob onResponseReceived Receiving DEPS data is " + jSONObject, new Object[0]);
                    g.a("[%s] Receiving DEPS data %s", str, jSONObject);
                    int optInt = jSONObject.optInt("CODE", -1);
                    if (optInt != 0) {
                        a(213, "Failed to request DEPS, url: " + str2 + ", response code: " + optInt + ", message: " + jSONObject.optString("MSG"), (Throwable) null);
                        return;
                    }
                    String optString = jSONObject.optString("DEPS");
                    try {
                        d a18 = d.a(optString);
                        com.tencent.tbs.one.impl.a.d.a(optString, "utf-8", file);
                        h.b("TBSOneAction", 1001).g(a18.f374824b).a();
                        e a19 = e.a(e.a.ONLINE, a18);
                        a19.f375022c = jSONObject;
                        com.tencent.tbs.one.b.c(this.f374941d).b("depsRequest");
                        a((b) a19);
                        return;
                    } catch (TBSOneException e16) {
                        a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                        return;
                    } catch (IOException e17) {
                        a(305, "Failed to save online DEPS to " + file.getAbsolutePath(), e17);
                        return;
                    }
                } catch (JSONException e18) {
                    a(212, "Failed to parse DEPS response " + a17 + ", url: " + str2, e18);
                    return;
                }
            } catch (IOException e19) {
                a(211, "Failed to read DEPS response, url:" + str2, e19);
                return;
            }
        }
        a(210, "Invalid DEPS response stream, url: " + str2 + ", statusCode: " + i3, (Throwable) null);
    }

    private static int a(Context context, String str) {
        return context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", str), 4).getInt("in_use_deps_version", -1);
    }
}
