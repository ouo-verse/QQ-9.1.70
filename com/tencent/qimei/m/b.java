package com.tencent.qimei.m;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.qimei.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public a f343346a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343347b;

    public b() {
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
            this.f343346a = new a(context);
            this.f343347b = aVar;
        }
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qimei.a.a aVar = this.f343347b;
        if (aVar != null) {
            try {
                str = (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, "persist.sys.identifierid.supported", "unknown");
            } catch (Exception e16) {
                e16.printStackTrace();
                str = "";
            }
            boolean equals = "1".equals(str);
            a aVar2 = this.f343346a;
            aVar2.getClass();
            Cursor query = ContactsMonitor.query(aVar2.f343345a.getContentResolver(), Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query == null) {
                com.tencent.qimei.ad.b.a("return cursor is null,return");
                str2 = null;
            } else {
                if (query.moveToNext()) {
                    str2 = query.getString(query.getColumnIndex("value"));
                } else {
                    str2 = null;
                }
                query.close();
            }
            aVar.callbackOaid(equals, null, str2, false);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
