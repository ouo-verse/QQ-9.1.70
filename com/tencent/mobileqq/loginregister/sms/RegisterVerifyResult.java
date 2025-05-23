package com.tencent.mobileqq.loginregister.sms;

import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RegisterVerifyResult extends BaseSmsVerifyResult {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public String f242903e;

    /* renamed from: f, reason: collision with root package name */
    public String f242904f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f242905h;

    /* renamed from: i, reason: collision with root package name */
    public int f242906i;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f242907m;

    public RegisterVerifyResult(boolean z16) {
        super(z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.sms.BaseSmsVerifyResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f242903e);
        parcel.writeString(this.f242904f);
        parcel.writeByte(this.f242905h ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f242906i);
        parcel.writeInt(this.f242907m.length);
        parcel.writeByteArray(this.f242907m);
    }
}
