package com.tencent.tmsqmsp.oaid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f0 {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static volatile f0 f380806g;

    /* renamed from: a, reason: collision with root package name */
    public e0 f380807a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f380808b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f380809c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f380810d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f380811e;

    /* renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f380812f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380807a = new e0("udid");
        this.f380808b = new e0("oaid");
        this.f380810d = new e0("vaid");
        this.f380809c = new e0("aaid");
    }

    public static h0 a(Cursor cursor) {
        h0 h0Var = new h0(null, 0);
        if (cursor == null) {
            b("parseValue fail, cursor is null.");
        } else if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                h0Var.f380818c = cursor.getString(columnIndex);
            } else {
                b("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                h0Var.f380816a = cursor.getInt(columnIndex2);
            } else {
                b("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                h0Var.f380817b = cursor.getLong(columnIndex3);
            } else {
                b("parseExpired fail, index < 0.");
            }
        } else {
            b("parseValue fail, cursor is closed.");
        }
        return h0Var;
    }

    public static void b(String str) {
        t0.c("MzOpenIdManager ".concat(String.valueOf(str)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
    
        if (r2 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, e0 e0Var) {
        Cursor cursor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) e0Var);
        }
        Cursor cursor2 = null;
        if (e0Var != null) {
            if (!e0Var.a()) {
                b("queryId : " + e0Var.f380797c);
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{e0Var.f380797c}, null);
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
                        }
                    } else {
                        try {
                            h0 a16 = a(cursor);
                            String str = a16.f380818c;
                            try {
                                e0Var.a(str);
                                e0Var.a(a16.f380817b);
                                e0Var.a(a16.f380816a);
                                b(e0Var.f380797c + " errorCode : " + e0Var.f380795a);
                                if (a16.f380816a == 1000) {
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
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else {
                return e0Var.f380798d;
            }
        }
        return null;
    }

    public e0 a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (e0) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if ("oaid".equals(str)) {
            return this.f380808b;
        }
        if ("vaid".equals(str)) {
            return this.f380810d;
        }
        if ("aaid".equals(str)) {
            return this.f380809c;
        }
        if ("udid".equals(str)) {
            return this.f380807a;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0044, code lost:
    
        if (r11.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16))).booleanValue();
        }
        Boolean bool = this.f380811e;
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
            this.f380811e = Boolean.FALSE;
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f380811e = Boolean.FALSE;
                }
            } catch (Exception unused) {
                if (cursor == null) {
                    return false;
                }
            }
            try {
                String str = a(cursor).f380818c;
                b("querySupport, result : ".concat(String.valueOf(str)));
                Boolean valueOf = Boolean.valueOf("0".equals(str));
                this.f380811e = valueOf;
                boolean booleanValue = valueOf.booleanValue();
                if (cursor != null) {
                    cursor.close();
                }
                return booleanValue;
            } catch (Exception unused2) {
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
    }

    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        synchronized (this) {
            if (this.f380812f == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                d0 d0Var = new d0();
                this.f380812f = d0Var;
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(d0Var, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null, 2);
                } else {
                    context.registerReceiver(d0Var, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
                }
            }
        }
    }

    public static final f0 a() {
        if (f380806g == null) {
            synchronized (f0.class) {
                f380806g = new f0();
            }
        }
        return f380806g;
    }
}
