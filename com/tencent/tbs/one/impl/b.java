package com.tencent.tbs.one.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.tbs.logger.e;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.d.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    private static int f374597g = 10001;

    /* renamed from: h, reason: collision with root package name */
    private static String f374598h = "https://tbsone.imtt.qq.com";

    /* renamed from: i, reason: collision with root package name */
    private static WeakReference<Context> f374599i;

    /* renamed from: a, reason: collision with root package name */
    String f374600a = "";

    /* renamed from: b, reason: collision with root package name */
    int f374601b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f374602c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f374603d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f374604e = 0;

    /* renamed from: f, reason: collision with root package name */
    String f374605f = "";

    /* renamed from: j, reason: collision with root package name */
    private String f374606j;

    /* renamed from: k, reason: collision with root package name */
    private int f374607k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.b$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f374608d;

        /* compiled from: P */
        /* renamed from: com.tencent.tbs.one.impl.b$1$a */
        /* loaded from: classes26.dex */
        final class a extends m<byte[]> {

            /* compiled from: P */
            /* renamed from: com.tencent.tbs.one.impl.b$1$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            final class C9885a extends m<Integer> {
                C9885a() {
                }

                @Override // com.tencent.tbs.one.impl.a.m
                public final /* synthetic */ void a(Integer num) {
                    b.b(AnonymousClass1.this.f374608d);
                }
            }

            a() {
            }

            @Override // com.tencent.tbs.one.impl.a.m
            public final /* synthetic */ void a(byte[] bArr) {
                byte[] bArr2 = bArr;
                if (bArr2.length > 1048576 && com.tencent.tbs.one.impl.common.a.c.a(AnonymousClass1.this.f374608d) != 3) {
                    g.b("Log size greater than 1MB, and current network is not WI-FI, log report halt!", new Object[0]);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put(HttpHeader.RSP.CHARSET, "UTF-8");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(bArr2.length);
                hashMap.put(FileUploadBase.CONTENT_LENGTH, sb5.toString());
                hashMap.put("q-proxy-log", "tbsonelog");
                hashMap.put("q-guid", com.tencent.tbs.one.impl.common.a.c.b());
                hashMap.put("q-params", "");
                hashMap.put("openrandom", "tbsonelog");
                hashMap.put("openmode", com.tencent.tbs.one.impl.common.a.c.e(AnonymousClass1.this.f374608d));
                new com.tencent.tbs.one.impl.d.a(AnonymousClass1.this.f374608d, "https://qprostat.imtt.qq.com", "POST", hashMap, bArr2).a((m) new C9885a());
            }
        }

        AnonymousClass1(Context context) {
            this.f374608d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.h();
            new com.tencent.tbs.one.impl.common.a.a(e.h()).a((m) new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a implements a.InterfaceC9892a {
        a() {
        }

        @Override // com.tencent.tbs.one.impl.d.a.InterfaceC9892a
        public final void a(int i3, Map<String, List<String>> map, InputStream inputStream) {
            if (inputStream == null) {
                return;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byteArrayOutputStream.close();
                inputStream.close();
                String str = new String(byteArrayOutputStream.toByteArray());
                g.a(str, new Object[0]);
                int i16 = new JSONObject(str).getInt("CODE");
                if (i16 == 0) {
                    g.a("Statistic report successfully!", new Object[0]);
                    return;
                }
                g.c("Statistic report error! Code: " + i16, new Object[0]);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    b(String str, int i3) {
        this.f374606j = str;
        this.f374607k = i3;
    }

    public static void a(Context context) {
        f374599i = new WeakReference<>(context);
        c(context);
    }

    private static int c() {
        File file = new File(e.h(), "log.lock");
        if (file.exists()) {
            try {
                String a16 = com.tencent.tbs.one.impl.a.d.a(new FileInputStream(file), "utf-8");
                if (TextUtils.isEmpty(a16)) {
                    return -1;
                }
                return Integer.parseInt(a16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return -1;
    }

    private static synchronized void d(Context context) {
        synchronized (b.class) {
            ArrayList<String> a16 = com.tencent.tbs.one.impl.common.a.d.a(context);
            if (a16.isEmpty()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("PROTV", 1);
            hashMap.put("FUNC", 2);
            hashMap.put("CPUABI", Build.CPU_ABI);
            hashMap.put("APPVERNAME", com.tencent.tbs.one.impl.common.a.c.c(context));
            hashMap.put("APPPKG", context.getPackageName());
            hashMap.put("ONECODE", "5");
            hashMap.put("MODEL", com.tencent.tbs.one.impl.common.a.c.e(context));
            hashMap.put("ADV", Build.VERSION.RELEASE);
            hashMap.put(Global.TRACKING_IMEI, n.b(context));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(f374597g);
            hashMap.put("CODE", sb5.toString());
            HashMap hashMap2 = new HashMap(hashMap);
            hashMap2.put("DESCRIPTION", com.tencent.tbs.one.impl.a.e.a(",", a16));
            String jSONObject = new JSONObject(hashMap2).toString();
            g.a(jSONObject, new Object[0]);
            com.tencent.tbs.one.impl.d.a aVar = new com.tencent.tbs.one.impl.d.a(context, f374598h, "POST", null, jSONObject.getBytes());
            aVar.f374889f = new a();
            aVar.a((m) new C9887b(context));
        }
    }

    public final void b() {
        try {
            Context context = f374599i.get();
            int i3 = 1;
            if (context == null) {
                g.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Throwable("Null context!"));
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f374600a);
            sb5.append("_");
            sb5.append(this.f374601b);
            sb5.append(".");
            sb5.append(this.f374602c);
            sb5.append("_");
            sb5.append(this.f374603d);
            sb5.append(".");
            sb5.append(this.f374604e);
            if (TextUtils.equals("TBSOneAction", this.f374606j)) {
                i3 = 0;
            } else if (!TextUtils.equals("TBSOneError", this.f374606j)) {
                i3 = -1;
            }
            StringBuilder sb6 = new StringBuilder();
            if (!TextUtils.isEmpty(sb5)) {
                sb6.append(":D=");
                sb6.append((CharSequence) sb5);
            }
            sb6.append(":C=");
            sb6.append(i3);
            sb6.append(".");
            sb6.append(this.f374607k);
            sb6.append(":A=");
            sb6.append(com.tencent.tbs.one.impl.common.a.c.a(context));
            if (!TextUtils.isEmpty(this.f374605f)) {
                sb6.append(":V=");
                sb6.append(this.f374605f);
            }
            sb6.append(":T=");
            sb6.append(System.currentTimeMillis());
            String sb7 = sb6.toString();
            ArrayList<String> a16 = com.tencent.tbs.one.impl.common.a.d.a(context);
            if (a16.size() >= 20) {
                a16.remove(0);
            }
            a16.add(sb7);
            SharedPreferences.Editor edit = context.getSharedPreferences("com.tencent.tbs.one.report", 4).edit();
            edit.putString("stat_not_yet_sent", com.tencent.tbs.one.impl.a.e.a(",", a16));
            edit.apply();
            c(context);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9887b extends m<Integer> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f374621f;

        C9887b(Context context) {
            this.f374621f = context;
        }

        @Override // com.tencent.tbs.one.impl.a.m
        public final /* synthetic */ void a(Integer num) {
            com.tencent.tbs.one.impl.common.a.d.b(this.f374621f);
            g.a("Statistic upload complete with http response code: %d", num);
        }

        @Override // com.tencent.tbs.one.impl.a.m
        public final void a(int i3, String str, Throwable th5) {
            g.c(str, th5);
        }
    }

    public static void a(boolean z16) {
        f374598h = z16 ? "https://tbsone.sparta.html5.qq.com" : "https://tbsone.imtt.qq.com";
    }

    public static b a(String str, int i3) {
        return new b(str, i3);
    }

    public static synchronized void a() {
        synchronized (b.class) {
            Context context = f374599i.get();
            if (context == null) {
                g.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Throwable("Null context!"));
                return;
            }
            int c16 = c();
            if (c16 > 0 && c16 == com.tencent.tbs.one.impl.common.a.c.d(context)) {
                g.a("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
            } else {
                com.tencent.tbs.one.impl.common.a.b.a();
                com.tencent.tbs.one.impl.common.a.b.b(new AnonymousClass1(context));
            }
        }
    }

    private static void c(Context context) {
        if (context != null && com.tencent.tbs.one.impl.common.a.d.c(context)) {
            try {
                d(context);
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void b(Context context) {
        try {
            File file = new File(e.h(), "log.lock");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    file.getAbsolutePath();
                } else {
                    g.c("Create log upload lock failed!", new Object[0]);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.tbs.one.impl.common.a.c.d(context));
            com.tencent.tbs.one.impl.a.d.a(sb5.toString(), "utf-8", file);
        } catch (IOException e16) {
            g.c("Exception when write log upload lock:" + e16.getMessage(), new Object[0]);
            e16.printStackTrace();
        }
    }
}
