package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g extends a implements Callable<d> {

    /* renamed from: i, reason: collision with root package name */
    private static final String f37014i = "g";

    public g(String str, int i3, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        super(str, i3, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x013a: MOVE (r6 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:79:0x013a */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d call() {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        long j3;
        long currentTimeMillis;
        long elapsedRealtime;
        String str = f37014i;
        Logger.i(str, "Post call execute");
        long j16 = 0;
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            try {
                try {
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        j16 = System.currentTimeMillis();
                        httpsURLConnection = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                        try {
                        } catch (IOException e16) {
                            e = e16;
                            long j17 = j16;
                            j16 = elapsedRealtime;
                            j3 = j17;
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            currentTimeMillis = System.currentTimeMillis();
                            Logger.w(f37014i, "RequestCallableV2 run task catch IOException", e);
                            this.f36962a = new d(e, elapsedRealtime2 - j16);
                            if (httpsURLConnection != null) {
                                try {
                                    httpsURLConnection.disconnect();
                                } catch (RuntimeException unused) {
                                    j16 = j3;
                                    Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                                    this.f36962a.b(c());
                                    this.f36962a.a(d());
                                    this.f36962a.b(j16);
                                    this.f36962a.a(currentTimeMillis);
                                    if (b() != null) {
                                    }
                                    return this.f36962a;
                                } catch (Throwable unused2) {
                                    j16 = j3;
                                    Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                                    this.f36962a.b(c());
                                    this.f36962a.a(d());
                                    this.f36962a.b(j16);
                                    this.f36962a.a(currentTimeMillis);
                                    if (b() != null) {
                                    }
                                    return this.f36962a;
                                }
                            }
                            j16 = j3;
                            this.f36962a.b(c());
                            this.f36962a.a(d());
                            this.f36962a.b(j16);
                            this.f36962a.a(currentTimeMillis);
                            if (b() != null) {
                            }
                            return this.f36962a;
                        }
                    } catch (IOException e17) {
                        e = e17;
                        httpsURLConnection = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (RuntimeException unused3) {
                            Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused4) {
                            Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
                httpsURLConnection = null;
                j3 = 0;
            }
            if (httpsURLConnection == null) {
                Logger.w(str, "create HttpsURLConnection instance by url return null.");
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (RuntimeException unused5) {
                        Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused6) {
                        Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                return null;
            }
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            String a16 = b() != null ? b().a() : "";
            if (TextUtils.isEmpty(a16)) {
                a16 = ContainerUtils.FIELD_DELIMITER;
            }
            httpsURLConnection.setRequestProperty("If-None-Match", a16);
            httpsURLConnection.connect();
            com.huawei.hms.framework.network.grs.h.f.a.a(httpsURLConnection, f().a("services", ""));
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                try {
                    inputStream = httpsURLConnection.getInputStream();
                    byte[] byteArray = IoUtils.toByteArray(inputStream);
                    IoUtils.closeSecure(inputStream);
                    bArr = byteArray;
                } catch (Throwable th6) {
                    IoUtils.closeSecure(inputStream);
                    throw th6;
                }
            }
            Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
            httpsURLConnection.disconnect();
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            currentTimeMillis = System.currentTimeMillis();
            this.f36962a = new d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
            try {
                httpsURLConnection.disconnect();
            } catch (RuntimeException unused7) {
                Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                this.f36962a.b(c());
                this.f36962a.a(d());
                this.f36962a.b(j16);
                this.f36962a.a(currentTimeMillis);
                if (b() != null) {
                }
                return this.f36962a;
            } catch (Throwable unused8) {
                Logger.w(f37014i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                this.f36962a.b(c());
                this.f36962a.a(d());
                this.f36962a.b(j16);
                this.f36962a.a(currentTimeMillis);
                if (b() != null) {
                }
                return this.f36962a;
            }
            this.f36962a.b(c());
            this.f36962a.a(d());
            this.f36962a.b(j16);
            this.f36962a.a(currentTimeMillis);
            if (b() != null) {
                b().a(this.f36962a);
            }
            return this.f36962a;
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection2 = httpURLConnection;
        }
    }
}
