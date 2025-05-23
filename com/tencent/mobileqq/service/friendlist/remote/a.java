package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f286131a;

    /* renamed from: b, reason: collision with root package name */
    public String f286132b;

    /* renamed from: c, reason: collision with root package name */
    public int f286133c;

    /* renamed from: d, reason: collision with root package name */
    public int f286134d;

    /* renamed from: e, reason: collision with root package name */
    public int f286135e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f286131a = parcel.readString();
        this.f286132b = parcel.readString();
        this.f286133c = parcel.readInt();
        this.f286134d = parcel.readInt();
        this.f286135e = parcel.readInt();
    }

    public void b(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        parcel.writeString(this.f286131a);
        parcel.writeString(this.f286132b);
        parcel.writeInt(this.f286133c);
        parcel.writeInt(this.f286134d);
        parcel.writeInt(this.f286135e);
    }
}
