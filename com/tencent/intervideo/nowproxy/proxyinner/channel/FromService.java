package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FromService implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<FromService> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f116906d;

    /* renamed from: e, reason: collision with root package name */
    public int f116907e;

    /* renamed from: f, reason: collision with root package name */
    public int f116908f;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f116909h;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<FromService> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FromService createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FromService) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            FromService fromService = new FromService();
            fromService.f116906d = parcel.readInt();
            fromService.f116907e = parcel.readInt();
            fromService.f116908f = parcel.readInt();
            fromService.f116909h = parcel.readBundle();
            return fromService;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FromService[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FromService[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new FromService[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new a();
        }
    }

    public FromService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f116906d);
        parcel.writeInt(this.f116907e);
        parcel.writeInt(this.f116908f);
        parcel.writeBundle(this.f116909h);
    }
}
