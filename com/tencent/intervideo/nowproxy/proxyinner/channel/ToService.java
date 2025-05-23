package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ToService implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ToService> CREATOR;
    public Bundle C;

    /* renamed from: d, reason: collision with root package name */
    public int f116910d;

    /* renamed from: e, reason: collision with root package name */
    public int f116911e;

    /* renamed from: f, reason: collision with root package name */
    public int f116912f;

    /* renamed from: h, reason: collision with root package name */
    public int f116913h;

    /* renamed from: i, reason: collision with root package name */
    public long f116914i;

    /* renamed from: m, reason: collision with root package name */
    public String f116915m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<ToService> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToService createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToService) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ToService toService = new ToService();
            toService.f116910d = parcel.readInt();
            toService.f116911e = parcel.readInt();
            toService.f116912f = parcel.readInt();
            toService.f116913h = parcel.readInt();
            toService.f116914i = parcel.readLong();
            toService.f116915m = parcel.readString();
            toService.C = parcel.readBundle();
            return toService;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToService[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ToService[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ToService[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new a();
        }
    }

    public ToService() {
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
        parcel.writeInt(this.f116910d);
        parcel.writeInt(this.f116911e);
        parcel.writeInt(this.f116912f);
        parcel.writeInt(this.f116913h);
        parcel.writeLong(this.f116914i);
        parcel.writeString(this.f116915m);
        parcel.writeBundle(this.C);
    }
}
