package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends com.tencent.tbs.one.impl.a.b<e<File>> {

    /* renamed from: b, reason: collision with root package name */
    final Context f374900b;

    /* renamed from: c, reason: collision with root package name */
    final String f374901c;

    /* renamed from: d, reason: collision with root package name */
    final String f374902d;

    /* renamed from: e, reason: collision with root package name */
    final String f374903e;

    /* renamed from: f, reason: collision with root package name */
    final int f374904f;

    /* renamed from: g, reason: collision with root package name */
    final File f374905g;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.tbs.one.impl.d.a f374906h;

    /* renamed from: i, reason: collision with root package name */
    int f374907i;

    /* renamed from: j, reason: collision with root package name */
    JSONObject f374908j;

    /* renamed from: k, reason: collision with root package name */
    int f374909k;

    /* renamed from: l, reason: collision with root package name */
    String f374910l;

    /* renamed from: m, reason: collision with root package name */
    long f374911m = -1;

    /* renamed from: n, reason: collision with root package name */
    private final Bundle f374912n;

    /* renamed from: o, reason: collision with root package name */
    private final d.a f374913o;

    public a(Context context, String str, String str2, d.a aVar, File file, Bundle bundle) {
        this.f374900b = context;
        this.f374901c = str;
        String str3 = aVar.f374829d;
        this.f374902d = TextUtils.isEmpty(str3) ? str2 : str3;
        this.f374903e = aVar.f374826a;
        this.f374904f = aVar.f374828c;
        this.f374905g = file;
        this.f374912n = bundle;
        this.f374913o = aVar;
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        TBSOneRuntimeExtension a16;
        super.b();
        com.tencent.tbs.one.impl.d.a aVar = this.f374906h;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f374907i != 0 && (a16 = com.tencent.tbs.one.impl.common.a.a(this.f374900b, this.f374901c)) != null) {
            a16.cancel(this.f374907i);
        }
    }

    final boolean c() {
        Bundle bundle = this.f374912n;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, false);
    }

    final boolean d() {
        Bundle bundle = this.f374912n;
        if (bundle == null || bundle.getInt("info_from", -1) != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        int shouldOverrideInstallationJob;
        final Context context = this.f374900b;
        final String str = this.f374901c;
        final String str2 = this.f374903e;
        final int i3 = this.f374904f;
        final File file = this.f374905g;
        g.a("[%s] [AutoComponentInstallationJob].install start on path=%s", str, file);
        TBSOneRuntimeExtension a16 = com.tencent.tbs.one.impl.common.a.a(context, str);
        if (a16 != null && (shouldOverrideInstallationJob = a16.shouldOverrideInstallationJob(str, str2, i3, null, file, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.a.a.1
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r46) {
                g.a("[%s] {%s} Finished intercepting component installation job by runtime extension", str, str2);
                a aVar = a.this;
                aVar.f374907i = 0;
                aVar.a((a) e.a(e.a.EXTENSION, file));
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i16, String str3) {
                a aVar = a.this;
                aVar.f374907i = 0;
                aVar.a(i16, str3, null);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i16, int i17) {
                a.this.a(i17);
            }
        })) != 0) {
            g.a("[%s] {%s} Intercepted component installation job by runtime extension", str, str2);
            this.f374907i = shouldOverrideInstallationJob;
        } else {
            if (file.exists()) {
                com.tencent.tbs.one.impl.a.d.a(file, false);
            }
            o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.e.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (!a.this.c() && !com.tencent.tbs.one.impl.a.e.g(context)) {
                        a.super.a(201, "current network is unavialable,no need sendrequest to server", null);
                        return;
                    }
                    if (a.this.d()) {
                        h.a d16 = h.b("TBSOneAction", 1013).c(a.this.f374903e).d(a.this.f374904f);
                        a aVar = a.this;
                        h.a b16 = d16.b(f.a(aVar.f374900b, aVar.f374901c, aVar.f374903e));
                        a aVar2 = a.this;
                        b16.g(f.a(aVar2.f374900b, aVar2.f374901c)).a();
                    } else {
                        h.a d17 = h.b("TBSOneAction", 1003).c(a.this.f374903e).d(a.this.f374904f);
                        a aVar3 = a.this;
                        h.a b17 = d17.b(f.a(aVar3.f374900b, aVar3.f374901c, aVar3.f374903e));
                        a aVar4 = a.this;
                        b17.g(f.a(aVar4.f374900b, aVar4.f374901c)).a();
                    }
                    int c16 = com.tencent.tbs.one.impl.e.f.c(f.b(f.a(context.getDir("tbs", 0), str), str2));
                    a aVar5 = a.this;
                    a.a(aVar5, context, str, str2, i3, aVar5.f374902d, c16);
                }
            });
        }
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void a(int i3, String str, Throwable th5) {
        d.a aVar = this.f374913o;
        String str2 = aVar == null ? "" : aVar.f374826a;
        int i16 = aVar == null ? -1 : aVar.f374828c;
        boolean z16 = i3 == 219;
        h.b("TBSOneAction", d() ? z16 ? 1017 : 1014 : z16 ? 1007 : 1004).c(str2).d(i16).b(f.a(this.f374900b, this.f374901c, this.f374903e)).g(f.a(this.f374900b, this.f374901c)).a();
        com.tencent.tbs.one.impl.e.f.a(this.f374905g, System.currentTimeMillis());
        super.a(i3, str, th5);
    }

    static /* synthetic */ void a(a aVar, Context context, String str, String str2, final int i3, String str3, final int i16) {
        PackageInfo packageInfo;
        boolean z16;
        boolean z17;
        com.tencent.tbs.one.b.c(aVar.f374901c).d(aVar.f374903e).c("requestInfo");
        JSONObject jSONObject = new JSONObject();
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "PROTV", 1);
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "FUNC", 1);
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "ABI", com.tencent.tbs.one.impl.a.e.d());
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "NAME", str2);
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "REQV", Integer.valueOf(i3));
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "LOCV", Integer.valueOf(i16));
        String packageName = context.getPackageName();
        com.tencent.tbs.one.impl.a.f.a(jSONObject, "PN", packageName);
        String b16 = com.tencent.tbs.one.impl.a.e.b();
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            g.c("Failed to get package info for %s", packageName, e16);
            packageInfo = null;
        }
        if (!TextUtils.isEmpty(b16)) {
            com.tencent.tbs.one.impl.a.f.a(jSONObject, "PPVN", b16);
        } else if (packageInfo != null) {
            com.tencent.tbs.one.impl.a.f.a(jSONObject, "PPVN", packageInfo.versionName);
        }
        Bundle bundle = aVar.f374912n;
        if (bundle != null) {
            z16 = bundle.getBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL, false);
            z17 = aVar.f374912n.getBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL_SUGGESTION, false);
        } else {
            z16 = false;
            z17 = false;
        }
        if (z16) {
            com.tencent.tbs.one.impl.a.f.a(jSONObject, "FORCE", 2);
        } else if (z17) {
            com.tencent.tbs.one.impl.a.f.a(jSONObject, "FORCE", 1);
        }
        g.a("AutoComponentInstallationJob requestInformation  " + str + " " + str2 + " " + str3 + " " + jSONObject, new Object[0]);
        g.a("[%s] {%s} Requesting component info from %s, post data: %s", str, str2, str3, jSONObject);
        com.tencent.tbs.one.impl.d.a aVar2 = new com.tencent.tbs.one.impl.d.a(context, str3, "POST", null, jSONObject.toString().getBytes(com.tencent.tbs.one.impl.common.b.f374813b));
        aVar.f374906h = aVar2;
        aVar2.f374889f = new a.InterfaceC9892a() { // from class: com.tencent.tbs.one.impl.e.a.a.3
            @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
            public final void a(int i17, Map<String, List<String>> map, InputStream inputStream) {
                final a aVar3 = a.this;
                final int i18 = i16;
                Context context2 = aVar3.f374900b;
                String str4 = aVar3.f374901c;
                String str5 = aVar3.f374902d;
                String str6 = aVar3.f374903e;
                g.a("[%s] {%s} Receiving component information response: [%d] %s", str4, str6, Integer.valueOf(i17), map);
                if (i17 == 200 && inputStream != null) {
                    try {
                        String a16 = com.tencent.tbs.one.impl.a.d.a(inputStream, "utf-8");
                        try {
                            JSONObject jSONObject2 = new JSONObject(a16);
                            g.a("[%s] {%s} Receiving component information data %s", str4, str6, jSONObject2);
                            int optInt = jSONObject2.optInt("CODE", -1);
                            if (optInt != 0) {
                                aVar3.a(219, "Failed to request component " + str6 + " information, url: " + str5 + ", response code: " + optInt + ", message: " + jSONObject2.optString("MSG"), null);
                                return;
                            }
                            int optInt2 = jSONObject2.optInt("TYPE");
                            if (optInt2 == 1) {
                                String str7 = aVar3.f374901c;
                                if (!aVar3.d()) {
                                    TBSOneManager.getInstance(context2, str7).loadComponentAsync(MimeTypeParser.ATTR_EXTENSION, null);
                                } else {
                                    File c16 = f.c(f.a(context2.getDir("tbs", 0), str7));
                                    Bundle bundle2 = new Bundle();
                                    try {
                                        bundle2.putSerializable("deps", d.a(c16));
                                        TBSOneManager.getInstance(context2, str7).loadComponentAsync(MimeTypeParser.ATTR_EXTENSION, bundle2, null);
                                    } catch (TBSOneException unused) {
                                    }
                                }
                            }
                            aVar3.f374909k = optInt2;
                            aVar3.f374910l = jSONObject2.optString(KeyPropertiesCompact.DIGEST_MD5);
                            aVar3.f374911m = jSONObject2.optLong("BYTE");
                            aVar3.f374908j = jSONObject2;
                            final String optString = jSONObject2.optString(Global.TRACKING_URL);
                            com.tencent.tbs.one.b.c(aVar3.f374901c).d(aVar3.f374903e).b("requestInfo");
                            com.tencent.tbs.one.b.c(aVar3.f374901c).d(aVar3.f374903e).c("downloadAndUnzip");
                            g.a("[%s] {%s} [AutoComponentInstallationJob].downloadInstallationPackage Downloading component from %s", aVar3.f374901c, aVar3.f374903e, optString);
                            if (aVar3.d()) {
                                h.b("TBSOneAction", 1015).c(aVar3.f374903e).d(aVar3.f374904f).b(f.a(aVar3.f374900b, aVar3.f374901c, aVar3.f374903e)).g(f.a(aVar3.f374900b, aVar3.f374901c)).a();
                            } else {
                                h.b("TBSOneAction", 1005).c(aVar3.f374903e).d(aVar3.f374904f).b(f.a(aVar3.f374900b, aVar3.f374901c, aVar3.f374903e)).g(f.a(aVar3.f374900b, aVar3.f374901c)).a();
                            }
                            aVar3.f374906h = new com.tencent.tbs.one.impl.d.a(aVar3.f374900b, optString);
                            if (!aVar3.c()) {
                                aVar3.f374906h.f374890g = true;
                            }
                            aVar3.f374906h.f374889f = new a.InterfaceC9892a() { // from class: com.tencent.tbs.one.impl.e.a.a.5
                                @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
                                public final void a(int i19, Map<String, List<String>> map2, InputStream inputStream2) {
                                    String str8;
                                    int i26;
                                    int i27;
                                    File file;
                                    int i28;
                                    final a aVar4 = a.this;
                                    String str9 = optString;
                                    int i29 = i18;
                                    final Context context3 = aVar4.f374900b;
                                    final String str10 = aVar4.f374901c;
                                    final String str11 = aVar4.f374903e;
                                    final int i36 = aVar4.f374904f;
                                    final File file2 = aVar4.f374905g;
                                    g.a("[%s] {%s} Receiving component download response: [%d] %s", str10, str11, Integer.valueOf(i19), map2);
                                    if (i19 == 200 && inputStream2 != null) {
                                        g.a("AutoComponentInstallationJob onDownloadResponseReceived mType  " + aVar4.f374909k, new Object[0]);
                                        if (aVar4.f374909k != 1) {
                                            str8 = "tbs";
                                            i26 = 1;
                                            i27 = 0;
                                            file = file2;
                                            i28 = i36;
                                        } else {
                                            g.a("[%s] {%s} Asking runtime extension to intercept download stream", str10, str11);
                                            try {
                                                TBSOneRuntimeExtension a17 = com.tencent.tbs.one.impl.common.a.a(context3, str10, aVar4.d());
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("localVersion", Integer.valueOf(i29));
                                                hashMap.put("localVersionDirectory", new File(f.b(f.a(context3.getDir("tbs", 0), str10), str11), String.valueOf(i29)).getAbsolutePath());
                                                hashMap.put("controlMessage", aVar4.f374908j);
                                                str8 = "tbs";
                                                i27 = 0;
                                                file = file2;
                                                i28 = i36;
                                                int shouldInterceptComponentResponse = a17.shouldInterceptComponentResponse(str10, str11, i28, hashMap, inputStream2, file, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.a.a.7
                                                    @Override // com.tencent.tbs.one.TBSOneCallback
                                                    public final /* synthetic */ void onCompleted(Void r46) {
                                                        g.a("[%s] {%s} Finished intercepting component download stream by runtime extension", str10, str11);
                                                        a.this.f374907i = 0;
                                                        com.tencent.tbs.one.b.c(str10).b("patch");
                                                        h.a d16 = h.b("TBSOneAction", 1019).c(a.this.f374903e).d(a.this.f374904f);
                                                        a aVar5 = a.this;
                                                        h.a b17 = d16.b(f.a(aVar5.f374900b, aVar5.f374901c, aVar5.f374903e));
                                                        a aVar6 = a.this;
                                                        b17.g(f.a(aVar6.f374900b, aVar6.f374901c)).a();
                                                        a.this.a((a) e.a(e.a.EXTENSION, file2));
                                                    }

                                                    @Override // com.tencent.tbs.one.TBSOneCallback
                                                    public final void onError(int i37, String str12) {
                                                        g.a("[%s] {%s} Failed to intercept component download stream by runtime extension: [%d] %s", str10, str11, Integer.valueOf(i37), str12);
                                                        a aVar5 = a.this;
                                                        aVar5.f374907i = 0;
                                                        a.a(aVar5, context3, str10, str11, i36, aVar5.f374902d, -1);
                                                    }

                                                    @Override // com.tencent.tbs.one.TBSOneCallback
                                                    public final void onProgressChanged(int i37, int i38) {
                                                        a.this.a(com.tencent.tbs.one.impl.e.f.a(i38, 70, 100));
                                                    }
                                                });
                                                if (shouldInterceptComponentResponse != 0) {
                                                    g.a("[%s] {%s} Intercepted component download stream by runtime extension", str10, str11);
                                                    aVar4.f374907i = shouldInterceptComponentResponse;
                                                    com.tencent.tbs.one.b.c(str10).c("patch");
                                                    return;
                                                }
                                                i26 = 1;
                                            } catch (TBSOneException e17) {
                                                aVar4.a(e17.getErrorCode(), e17.getMessage(), e17.getCause());
                                                return;
                                            }
                                        }
                                        try {
                                            com.tencent.tbs.one.impl.e.f.a(inputStream2, aVar4.f374910l, aVar4.f374911m, file, null, new l.a() { // from class: com.tencent.tbs.one.impl.e.a.a.8
                                                @Override // com.tencent.tbs.one.impl.a.l.a
                                                public final boolean a() {
                                                    return !a.this.f374550a;
                                                }

                                                @Override // com.tencent.tbs.one.impl.a.l.a
                                                public final void a(int i37) {
                                                    a.this.a(i37);
                                                }
                                            });
                                            com.tencent.tbs.one.b.c(aVar4.f374901c).d(aVar4.f374903e).b("downloadAndUnzip");
                                            com.tencent.tbs.one.b.c(aVar4.f374901c).d(aVar4.f374903e).c(VRReportDefine$ReportKey.INSTALL);
                                            com.tencent.tbs.one.impl.e.f.a(file, file);
                                            com.tencent.tbs.one.impl.e.f.a(file, i28, aVar4.d());
                                            com.tencent.tbs.one.impl.e.f.a(aVar4.f374900b.getDir(str8, i27));
                                            com.tencent.tbs.one.impl.e.f.b(file);
                                            com.tencent.tbs.one.b.c(aVar4.f374901c).d(aVar4.f374903e).b(VRReportDefine$ReportKey.INSTALL);
                                            h.b("TBSOneAction", 1018).c(aVar4.f374903e).d(aVar4.f374904f).b(f.a(aVar4.f374900b, aVar4.f374901c, aVar4.f374903e)).g(f.a(aVar4.f374900b, aVar4.f374901c)).a();
                                        } catch (TBSOneException e18) {
                                            aVar4.a(e18.getErrorCode(), e18.getMessage(), e18.getCause());
                                            return;
                                        } catch (Exception e19) {
                                            Object[] objArr = new Object[i26];
                                            objArr[i27] = Log.getStackTraceString(e19);
                                            g.c("null pointer occured,e=%s", objArr);
                                        }
                                        e a18 = e.a(e.a.ONLINE, file);
                                        a18.f375022c = aVar4.f374908j;
                                        aVar4.a((a) a18);
                                        return;
                                    }
                                    aVar4.a(220, "Invalid component download stream, url: " + str9 + ", statusCode: " + i19, null);
                                }
                            };
                            aVar3.f374906h.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.a.a.6
                                @Override // com.tencent.tbs.one.impl.a.m
                                public final void a(int i19, int i26) {
                                    g.a("AutoComponentInstallationJob download onProgressChanged  " + i26, new Object[0]);
                                    a.this.a(com.tencent.tbs.one.impl.e.f.a(i26, 40, 100));
                                }

                                @Override // com.tencent.tbs.one.impl.a.m
                                public final void a(int i19, String str8, Throwable th5) {
                                    a.this.a(i19, str8, th5);
                                    h.a d16 = h.b("TBSOneAction", 1006).c(a.this.f374903e).d(a.this.f374904f);
                                    a aVar4 = a.this;
                                    h.a b17 = d16.b(f.a(aVar4.f374900b, aVar4.f374901c, aVar4.f374903e));
                                    a aVar5 = a.this;
                                    b17.g(f.a(aVar5.f374900b, aVar5.f374901c)).a();
                                }
                            });
                            return;
                        } catch (JSONException e17) {
                            aVar3.a(218, "Failed to parse component " + str6 + " information " + a16 + ", url: " + str5, e17);
                            return;
                        }
                    } catch (IOException e18) {
                        aVar3.a(217, "Failed to read component " + str6 + " information, url: " + str5, e18);
                        return;
                    }
                }
                aVar3.a(216, "Invalid component information stream, url: " + str5 + ", statusCode: " + i17, null);
            }
        };
        aVar.f374906h.a((m) new m<Integer>() { // from class: com.tencent.tbs.one.impl.e.a.a.4
            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i17, int i18) {
                a.this.a(com.tencent.tbs.one.impl.e.f.a(i18, 0, 40));
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final void a(int i17, String str4, Throwable th5) {
                a.this.a(i17, str4, th5);
                if (a.this.d()) {
                    h.a b17 = h.b("TBSOneAction", 1016).c(a.this.f374903e).d(i3).b(i16);
                    a aVar3 = a.this;
                    b17.g(f.a(aVar3.f374900b, aVar3.f374901c)).a();
                } else {
                    h.a d16 = h.b("TBSOneAction", 1006).c(a.this.f374903e).b(i16).d(i3);
                    a aVar4 = a.this;
                    d16.g(f.a(aVar4.f374900b, aVar4.f374901c)).a();
                }
            }
        });
        if (z16) {
            h.b("TBSOneError", 223).c(str2).d(i3).a();
        } else if (z17) {
            h.b("TBSOneError", 222).c(str2).d(i3).a();
        }
    }
}
