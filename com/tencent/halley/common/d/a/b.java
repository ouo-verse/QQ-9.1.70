package com.tencent.halley.common.d.a;

import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.d.f;
import com.tencent.halley.common.d.i;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    h.a f113415a;

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f113416b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113415a = new h.a();
        this.f113416b = new ArrayList();
        com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.d.a.b.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String b16 = i.b("settings_in_client", "", true);
                d.c("SettingsClient", "loadLocal jsonData:".concat(String.valueOf(b16)));
                if (!TextUtils.isEmpty(b16)) {
                    try {
                        b.this.f113415a.a(b16);
                        b.this.a();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        i.a("settings_in_client", "", true);
                    }
                }
            }
        });
    }

    @Override // com.tencent.halley.common.d.f
    public final String a(String str, int i3, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f113415a.a(str, i3, str2, str3, str4, str5) : (String) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3, str4, str5);
    }

    @Override // com.tencent.halley.common.d.a.a
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QCircleDaTongConstant.ElementParamValue.SETTINGS;
    }

    @Override // com.tencent.halley.common.d.a.a, com.tencent.halley.common.d.c
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.halley.common.d.h.d().b();
        }
    }

    final synchronized void a() {
        Iterator<Object> it = this.f113416b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.tencent.halley.common.d.a.a, com.tencent.halley.common.d.b
    public final void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str2) && !com.tencent.halley.common.d.b.a.b.a().b().equals(str2)) {
            com.tencent.halley.common.d.b.a.b.a().a(str2, true);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f113415a) {
            this.f113415a.b();
            this.f113415a.a(str);
        }
        i.a("settings_in_client", this.f113415a.a(), true);
        a();
    }
}
