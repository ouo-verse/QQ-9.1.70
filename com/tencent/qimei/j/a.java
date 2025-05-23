package com.tencent.qimei.j;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.luggage.wxa.q2.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.a.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements com.tencent.qimei.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f343317a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343318b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343317a = context;
            this.f343318b = aVar;
        }
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:23:0x0087, B:25:0x009c, B:26:0x00a3, B:28:0x00a9, B:29:0x00c3, B:33:0x00b6, B:34:0x00a0), top: B:22:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:23:0x0087, B:25:0x009c, B:26:0x00a3, B:28:0x00a9, B:29:0x00c3, B:33:0x00b6, B:34:0x00a0), top: B:22:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:23:0x0087, B:25:0x009c, B:26:0x00a3, B:28:0x00a9, B:29:0x00c3, B:33:0x00b6, B:34:0x00a0), top: B:22:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:23:0x0087, B:25:0x009c, B:26:0x00a3, B:28:0x00a9, B:29:0x00c3, B:33:0x00b6, B:34:0x00a0), top: B:22:0x0087 }] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    @Override // com.tencent.qimei.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        String str;
        String str2;
        int i3;
        Bundle call;
        StringBuilder sb5;
        ?? r85;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.qimei.a.a aVar = this.f343318b;
        if (aVar != null) {
            boolean a16 = a();
            Context context = this.f343317a;
            String a17 = c.a(context);
            Uri uri = b.f343319a;
            String str3 = null;
            try {
                int i16 = Build.VERSION.SDK_INT;
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(b.f343319a);
                Bundle call2 = acquireUnstableContentProviderClient.call("getAAID", a17, null);
                if (i16 >= 24) {
                    acquireUnstableContentProviderClient.close();
                } else {
                    acquireUnstableContentProviderClient.release();
                }
                ?? r75 = call2.getInt("code", -1);
                try {
                    if (r75 == 0) {
                        String string = call2.getString("id");
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("NubiaLog succeed:");
                        r75 = string;
                        r85 = sb6;
                    } else {
                        String string2 = call2.getString("message");
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("NubiaLog failed:");
                        r75 = string2;
                        r85 = sb7;
                    }
                    r85.append(r75);
                    com.tencent.qimei.ad.b.b(r85.toString());
                    str2 = r75;
                } catch (Exception e16) {
                    str = r75;
                    e = e16;
                    e.printStackTrace();
                    str2 = str;
                    Context context2 = this.f343317a;
                    Uri uri2 = b.f343319a;
                    i3 = Build.VERSION.SDK_INT;
                    ContentProviderClient acquireUnstableContentProviderClient2 = context2.getContentResolver().acquireUnstableContentProviderClient(b.f343319a);
                    call = acquireUnstableContentProviderClient2.call(e.NAME, null, null);
                    if (i3 < 24) {
                    }
                    if (call.getInt("code", -1) != 0) {
                    }
                    sb5.append(str3);
                    com.tencent.qimei.ad.b.b(sb5.toString());
                    aVar.callbackOaid(a16, str2, str3, false);
                }
            } catch (Exception e17) {
                e = e17;
                str = null;
            }
            Context context22 = this.f343317a;
            Uri uri22 = b.f343319a;
            try {
                i3 = Build.VERSION.SDK_INT;
                ContentProviderClient acquireUnstableContentProviderClient22 = context22.getContentResolver().acquireUnstableContentProviderClient(b.f343319a);
                call = acquireUnstableContentProviderClient22.call(e.NAME, null, null);
                if (i3 < 24) {
                    acquireUnstableContentProviderClient22.close();
                } else {
                    acquireUnstableContentProviderClient22.release();
                }
                if (call.getInt("code", -1) != 0) {
                    str3 = call.getString("id");
                    sb5 = new StringBuilder();
                    sb5.append("NubiaLog succeed:");
                } else {
                    str3 = call.getString("message");
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("NubiaLog failed:");
                    sb5 = sb8;
                }
                sb5.append(str3);
                com.tencent.qimei.ad.b.b(sb5.toString());
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            aVar.callbackOaid(a16, str2, str3, false);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Context context = this.f343317a;
        Uri uri = b.f343319a;
        try {
            int i3 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(b.f343319a);
            Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
            if (i3 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                com.tencent.qimei.ad.b.b("NubiaLog succeed");
                return call.getBoolean("issupport", true);
            }
            com.tencent.qimei.ad.b.b("NubiaLog failed:" + call.getString("message"));
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
