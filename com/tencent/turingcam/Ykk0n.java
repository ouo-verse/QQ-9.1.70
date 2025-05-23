package com.tencent.turingcam;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Ykk0n implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382110a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f382111b;

    /* renamed from: c, reason: collision with root package name */
    public int f382112c;

    public Ykk0n(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            return;
        }
        this.f382110a = parcel.readInt();
        this.f382111b = parcel.createByteArray();
        this.f382112c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f382110a);
        parcel.writeByteArray(this.f382111b);
        parcel.writeInt(this.f382112c);
    }
}
