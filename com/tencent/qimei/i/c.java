package com.tencent.qimei.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static volatile c f343305g;

    /* renamed from: a, reason: collision with root package name */
    public b f343306a;

    /* renamed from: b, reason: collision with root package name */
    public b f343307b;

    /* renamed from: c, reason: collision with root package name */
    public b f343308c;

    /* renamed from: d, reason: collision with root package name */
    public b f343309d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f343310e;

    /* renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f343311f;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343306a = new b("udid");
        this.f343307b = new b("oaid");
        this.f343309d = new b("vaid");
        this.f343308c = new b("aaid");
    }

    public static void b(String str) {
        com.tencent.qimei.ad.b.c("MzOpenIdManager " + str);
    }

    public b a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if ("oaid".equals(str)) {
            return this.f343307b;
        }
        if ("vaid".equals(str)) {
            return this.f343309d;
        }
        if ("aaid".equals(str)) {
            return this.f343308c;
        }
        if ("udid".equals(str)) {
            return this.f343306a;
        }
        return null;
    }

    public static final c a() {
        if (f343305g == null) {
            synchronized (c.class) {
                f343305g = new c();
            }
        }
        return f343305g;
    }

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (cursor.isClosed()) {
            str = "parseValue fail, cursor is closed.";
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.f343314c = cursor.getString(columnIndex);
            } else {
                b("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.f343312a = cursor.getInt(columnIndex2);
            } else {
                b("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.f343313b = cursor.getLong(columnIndex3);
                return dVar;
            }
            str = "parseExpired fail, index < 0.";
        }
        b(str);
        return dVar;
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        synchronized (this) {
            if (this.f343311f == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                a aVar = new a();
                this.f343311f = aVar;
                if (Build.VERSION.SDK_INT < 33) {
                    context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
                } else {
                    context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null, 2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0043, code lost:
    
        if (r11.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16))).booleanValue();
        }
        Boolean bool = this.f343310e;
        if (bool != null && !z16) {
            return bool.booleanValue();
        }
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            z17 = packageManager != null;
        }
        z17 = false;
        if (!z17) {
            b("is not Supported, for isLegalProvider : false");
            this.f343310e = Boolean.FALSE;
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f343310e = Boolean.FALSE;
                }
                try {
                    String str = a(cursor).f343314c;
                    b("querySupport, result : " + str);
                    Boolean valueOf = Boolean.valueOf("0".equals(str));
                    this.f343310e = valueOf;
                    boolean booleanValue = valueOf.booleanValue();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return booleanValue;
                } catch (Exception unused) {
                    if (cursor == null) {
                        return false;
                    }
                    return false;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception unused2) {
            if (cursor == null) {
                return false;
            }
        }
    }

    public final String a(Context context, b bVar) {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) bVar);
        }
        Cursor cursor2 = null;
        if (bVar == null) {
            return null;
        }
        if (bVar.f343302b > System.currentTimeMillis()) {
            return bVar.f343304d;
        }
        b("queryId : " + bVar.f343303c);
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{bVar.f343303c}, null);
        } catch (Exception unused) {
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (cursor == null) {
                try {
                    a(context, false);
                    b("forceQuery isSupported : " + a(context, true));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Exception unused2) {
                    if (cursor == null) {
                        return null;
                    }
                    cursor.close();
                    return null;
                }
            }
            try {
                d a16 = a(cursor);
                String str = a16.f343314c;
                try {
                    bVar.f343304d = str;
                    bVar.f343302b = a16.f343313b;
                    bVar.f343301a = a16.f343312a;
                    b(bVar.f343303c + " errorCode : " + bVar.f343301a);
                    if (a16.f343312a == 1000) {
                        cursor.close();
                        return str;
                    }
                    a(context);
                    if (a(context, false)) {
                        cursor.close();
                        return str;
                    }
                    b("not support, forceQuery isSupported: " + a(context, true));
                    cursor.close();
                    return str;
                } catch (Exception unused3) {
                    cursor.close();
                    return null;
                }
            } catch (Exception unused4) {
                cursor.close();
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
