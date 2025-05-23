package com.tencent.mobileqq.loginregister.sms;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseSmsVerifyResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BaseSmsVerifyResult> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public boolean f242901d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<BaseSmsVerifyResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseSmsVerifyResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BaseSmsVerifyResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BaseSmsVerifyResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseSmsVerifyResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BaseSmsVerifyResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BaseSmsVerifyResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseSmsVerifyResult(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f242901d = z16;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeByte(this.f242901d ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseSmsVerifyResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f242901d = parcel.readByte() != 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }
    }
}
