package com.tencent.luggage.wxa.ii;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.i6;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f130588a = new t();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f130589b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f130590c;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("content://");
        String str = com.tencent.luggage.wxa.o7.a.f136193a;
        sb5.append(str);
        sb5.append("/");
        sb5.append("LaunchWxaAppPBTableNew");
        f130589b = Uri.parse(sb5.toString());
        f130590c = Uri.parse("content://" + str + "/LaunchWxaAppPBTableNew");
    }

    public static t a() {
        return f130588a;
    }

    public final i6 b(String str) {
        Cursor query;
        n nVar;
        if (TextUtils.isEmpty(str) || (query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f130590c, null, String.format(Locale.US, "%s=?", "appId"), new String[]{str}, null, null)) == null) {
            return null;
        }
        if (!query.isClosed() && query.moveToFirst()) {
            nVar = new n();
            nVar.a(query);
        } else {
            nVar = null;
        }
        query.close();
        if (nVar == null) {
            return null;
        }
        return nVar.f138357d;
    }

    public boolean a(String str, i6 i6Var) {
        if (i6Var != null && !TextUtils.isEmpty(str)) {
            try {
                byte[] b16 = i6Var.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("CONTENT_KEY_SYNC_PROTO", b16);
                contentValues.put("CONTENT_KEY_APPID", str);
                com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f130589b, contentValues);
                return true;
            } catch (Exception unused) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.LaunchWxaPBContentResolver", "setLaunchPB insert failed");
            }
        }
        return false;
    }

    public i6 a(String str) {
        o oVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f130589b, null, String.format(Locale.US, "%s=?", "appId"), new String[]{str}, null, null);
        if (query == null) {
            return b(str);
        }
        if (!query.isClosed() && query.moveToFirst()) {
            oVar = new o();
            oVar.a(query);
        }
        query.close();
        if (oVar == null) {
            return b(str);
        }
        return oVar.f138371d;
    }
}
