package com.tencent.mobileqq.loginregister.sms;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import oicq.wlogin_sdk.request.WUserSigInfo;

/* loaded from: classes15.dex */
public class PhoneLoginSmsVerifyResult extends BaseSmsVerifyResult {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<PhoneLoginSmsVerifyResult> CREATOR;

    /* renamed from: e, reason: collision with root package name */
    public WUserSigInfo f242902e;

    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<PhoneLoginSmsVerifyResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhoneLoginSmsVerifyResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PhoneLoginSmsVerifyResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PhoneLoginSmsVerifyResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PhoneLoginSmsVerifyResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PhoneLoginSmsVerifyResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PhoneLoginSmsVerifyResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public PhoneLoginSmsVerifyResult(boolean z16) {
        super(z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, z16);
    }

    @Override // com.tencent.mobileqq.loginregister.sms.BaseSmsVerifyResult, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.loginregister.sms.BaseSmsVerifyResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
        } else {
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.f242902e, i3);
        }
    }

    protected PhoneLoginSmsVerifyResult(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f242902e = (WUserSigInfo) parcel.readParcelable(WUserSigInfo.class.getClassLoader());
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }
    }
}
