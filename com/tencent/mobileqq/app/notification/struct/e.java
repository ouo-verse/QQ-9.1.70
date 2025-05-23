package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Intent f196406a;

    /* renamed from: b, reason: collision with root package name */
    private String f196407b;

    /* renamed from: c, reason: collision with root package name */
    private String f196408c;

    /* renamed from: d, reason: collision with root package name */
    private String f196409d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f196410e;

    /* renamed from: f, reason: collision with root package name */
    private String f196411f;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f196407b = "";
        this.f196408c = "";
        this.f196409d = "";
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f196411f;
    }

    public Intent b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f196406a;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f196408c;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f196409d;
    }

    public Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bitmap) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f196410e;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f196407b;
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f196411f = str;
        }
    }

    public void h(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            this.f196406a = intent;
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f196408c = str;
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f196409d = str;
        }
    }

    public void k(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bitmap);
        } else {
            this.f196410e = bitmap;
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f196407b = str;
        }
    }

    @NonNull
    public String toString() {
        Bundle bundle;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (b() != null) {
            bundle = b().getExtras();
        } else {
            bundle = null;
        }
        if (e() != null) {
            str = String.valueOf(e().getHeight());
        } else {
            str = "using default bitmap";
        }
        return "NotificationElement{contentIntentExtras=" + bundle + ", ticker='" + this.f196407b + "', contentTitle='" + this.f196408c + "', notificationContentText='" + this.f196409d + "', notificationIconBitmap=" + str + ", briefOfMessage='" + this.f196411f + "'}";
    }

    public e(Intent intent, String str, String str2, String str3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, intent, str, str2, str3, bitmap);
            return;
        }
        this.f196406a = intent;
        this.f196407b = str;
        this.f196408c = str2;
        this.f196409d = str3;
        this.f196410e = bitmap;
    }
}
