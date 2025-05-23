package com.tencent.qimei.am;

import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.sdk.S.DataFormatter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.qimei.v.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataFormatter[] f343063a;

        public a(DataFormatter[] dataFormatterArr) {
            this.f343063a = dataFormatterArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dataFormatterArr);
            }
        }

        @Override // com.tencent.qimei.v.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f343063a[0] = b.this.a(com.tencent.qimei.ab.c.a(com.tencent.qimei.u.a.b(), "spread_data"), "qAucMjh7lsNepLGw");
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public DataFormatter a(String str, String str2) {
        String str3;
        DataFormatter dataFormatter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DataFormatter) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
        DataFormatter dataFormatter2 = new DataFormatter();
        if (TextUtils.isEmpty(str)) {
            return dataFormatter2;
        }
        try {
            str3 = com.tencent.qimei.f.a.a(str, str2);
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return dataFormatter2;
        }
        try {
            dataFormatter = (DataFormatter) new Gson().fromJson(str3, DataFormatter.class);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
            dataFormatter = null;
        }
        return dataFormatter == null ? new DataFormatter() : dataFormatter;
    }

    public String a(DataFormatter dataFormatter, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataFormatter, (Object) str);
        }
        try {
            String json = new Gson().toJson(dataFormatter);
            return TextUtils.isEmpty(json) ? "" : Base64.encodeToString(com.tencent.qimei.f.a.a(json.getBytes("UTF-8"), str.getBytes("UTF-8"), 1), 2);
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
            return "";
        }
    }

    public DataFormatter a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DataFormatter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        DataFormatter dataFormatter = new DataFormatter();
        synchronized (DataFormatter.class) {
            DataFormatter[] dataFormatterArr = new DataFormatter[1];
            com.tencent.qimei.ad.c.b("SpreadQM", "readFromCache blockRead result %b", Boolean.valueOf(new com.tencent.qimei.v.b().a("spread_data", new a(dataFormatterArr), 2)));
            DataFormatter dataFormatter2 = dataFormatterArr[0];
            if (dataFormatter2 != null) {
                dataFormatter = dataFormatter2;
            }
        }
        return dataFormatter;
    }
}
