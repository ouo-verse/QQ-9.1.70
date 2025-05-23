package com.tencent.luggage.wxa.ii;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f130502a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f130503b = Uri.parse("content://" + com.tencent.luggage.wxa.o7.a.f136193a + "/DevPkgLaunchExtInfo");

    public static h a() {
        return f130502a;
    }

    public boolean a(String str, int i3, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_VERSION_TYPE", Integer.valueOf(i3));
            contentValues.put("CONTENT_KEY_EXT_INFO", str2);
            com.tencent.luggage.wxa.tn.z.c().getContentResolver().insert(f130503b, contentValues);
            return true;
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.DevPkgLaunchExtInfoContentResolver", "setExtInfo fail");
            return false;
        }
    }

    public String a(String str, int i3) {
        Cursor query;
        g gVar = null;
        if (TextUtils.isEmpty(str) || (query = ContactsMonitor.query(com.tencent.luggage.wxa.tn.z.c().getContentResolver(), f130503b, null, String.format(Locale.US, "%s=? And %s=?", "appId", "versionType"), new String[]{str, String.valueOf(i3)}, null, null)) == null) {
            return null;
        }
        if (!query.isClosed() && query.moveToFirst()) {
            gVar = new g();
            gVar.a(query);
        }
        query.close();
        return gVar != null ? gVar.f138343f : "";
    }
}
