package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rp {

    /* renamed from: c, reason: collision with root package name */
    private static final String f150113c = "https://confinfo.map.qq.com/confinfo?";

    /* renamed from: a, reason: collision with root package name */
    Context f150114a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<a> f150115b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void c();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends AsyncTask<Context, Void, Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009a, code lost:
        
            if (r9 != null) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        
            r9.c();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
        
            com.tencent.mapsdk.internal.ku.a((java.io.Closeable) r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00fb, code lost:
        
            if (r9 != null) goto L29;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Context... contextArr) {
            InputStream inputStream;
            Context context;
            Context context2;
            a aVar;
            byte[] b16;
            Context context3;
            Context context4;
            JSONObject optJSONObject;
            int a16 = rm.a();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(rp.f150113c);
            sb5.append("apiKey=");
            boolean z16 = false;
            if (contextArr != null && contextArr.length > 0) {
                sb5.append(rp.a(contextArr[0].getApplicationContext()));
            }
            NetResponse doStream = NetManager.getInstance().builder().url(sb5.toString()).timeOut(3000).doStream();
            try {
                inputStream = doStream.dataStream;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
            try {
                b16 = ku.b(inputStream);
            } catch (Throwable th6) {
                th = th6;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        ku.a((Closeable) inputStream);
                    }
                    if (doStream != null) {
                        ku.a((Closeable) doStream.dataStream);
                    }
                    if (a16 != rm.a()) {
                        z16 = true;
                    }
                    if (z16 && (context2 = rp.this.f150114a) != null) {
                        rm.a(context2, a16);
                        aVar = rp.this.f150115b.get();
                    }
                    return null;
                } catch (Throwable th7) {
                    if (inputStream != null) {
                        ku.a((Closeable) inputStream);
                    }
                    if (doStream != null) {
                        ku.a((Closeable) doStream.dataStream);
                    }
                    if (a16 != rm.a()) {
                        z16 = true;
                    }
                    if (z16 && (context = rp.this.f150114a) != null) {
                        rm.a(context, a16);
                        a aVar2 = rp.this.f150115b.get();
                        if (aVar2 != null) {
                            aVar2.c();
                        }
                    }
                    throw th7;
                }
            }
            if (b16 != null && b16.length != 0) {
                JSONObject jSONObject = new JSONObject(new String(b16));
                if (jSONObject.optInt("error", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("info")) != null) {
                    a16 = optJSONObject.optInt("scenic", a16);
                }
                if (inputStream != null) {
                    ku.a((Closeable) inputStream);
                }
                ku.a((Closeable) doStream.dataStream);
                if (a16 != rm.a()) {
                    z16 = true;
                }
                if (z16 && (context4 = rp.this.f150114a) != null) {
                    rm.a(context4, a16);
                    aVar = rp.this.f150115b.get();
                }
                return null;
            }
            ku.a((Closeable) doStream.dataStream);
            if (a16 != rm.a()) {
                z16 = true;
            }
            if (z16 && (context3 = rp.this.f150114a) != null) {
                rm.a(context3, a16);
                a aVar3 = rp.this.f150115b.get();
                if (aVar3 != null) {
                    aVar3.c();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(rp rpVar, byte b16) {
            this();
        }
    }

    public rp(Context context, a aVar) {
        this.f150114a = context;
        this.f150115b = new WeakReference<>(aVar);
    }

    private void a() {
        new b(this, (byte) 0).execute(this.f150114a);
    }

    private static int a(String str, int i3) throws JSONException {
        JSONObject optJSONObject;
        JSONObject jSONObject = new JSONObject(str);
        return (jSONObject.optInt("error", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("info")) == null) ? i3 : optJSONObject.optInt("scenic", i3);
    }

    private static /* synthetic */ int b(String str, int i3) throws JSONException {
        JSONObject optJSONObject;
        JSONObject jSONObject = new JSONObject(str);
        return (jSONObject.optInt("error", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("info")) == null) ? i3 : optJSONObject.optInt("scenic", i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString("TencentMapSDK");
    }
}
