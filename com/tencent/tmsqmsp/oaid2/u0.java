package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class u0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f380890a;

    public u0(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f380890a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i3, String str) {
        Uri parse;
        Uri uri;
        Cursor query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
        String str2 = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    uri = null;
                    query = ContactsMonitor.query(this.f380890a.getContentResolver(), uri, null, null, null, null);
                    if (query != null) {
                        t0.a("return cursor is null,return");
                    } else {
                        if (query.moveToNext()) {
                            str2 = query.getString(query.getColumnIndex("value"));
                        }
                        query.close();
                    }
                    return str2;
                }
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(str)));
            } else {
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(str)));
            }
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        }
        uri = parse;
        query = ContactsMonitor.query(this.f380890a.getContentResolver(), uri, null, null, null, null);
        if (query != null) {
        }
        return str2;
    }
}
