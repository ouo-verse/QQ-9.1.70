package com.tencent.tfd.sdk.wxa;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Arbutus implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final Parcelable.Creator<Arbutus> f375405d;

    /* renamed from: a, reason: collision with root package name */
    public int f375406a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f375407b;

    /* renamed from: c, reason: collision with root package name */
    public int f375408c;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Arbutus$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements Parcelable.Creator<Arbutus> {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.tfd.sdk.wxa.Arbutus, java.lang.Object] */
        @Override // android.os.Parcelable.Creator
        public final Arbutus createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            return new Arbutus(parcel);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.tfd.sdk.wxa.Arbutus[], java.lang.Object[]] */
        @Override // android.os.Parcelable.Creator
        public final Arbutus[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Object[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new Arbutus[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62375);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375405d = new Cdo();
        }
    }

    public Arbutus(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            return;
        }
        this.f375406a = parcel.readInt();
        this.f375407b = parcel.createByteArray();
        this.f375408c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f375406a);
        parcel.writeByteArray(this.f375407b);
        parcel.writeInt(this.f375408c);
    }
}
