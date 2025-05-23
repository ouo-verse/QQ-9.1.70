package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterDeviceResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SoterDeviceResult> CREATOR;
    public byte[] exportData;
    public int exportDataLength;
    public int resultCode;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<SoterDeviceResult>() { // from class: com.tencent.soter.soterserver.SoterDeviceResult.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SoterDeviceResult createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SoterDeviceResult(parcel) : (SoterDeviceResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SoterDeviceResult[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SoterDeviceResult[i3] : (SoterDeviceResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SoterDeviceResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
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
        parcel.writeInt(this.resultCode);
        parcel.writeByteArray(this.exportData);
        parcel.writeInt(this.exportDataLength);
    }

    protected SoterDeviceResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.resultCode = parcel.readInt();
        this.exportData = parcel.createByteArray();
        this.exportDataLength = parcel.readInt();
    }
}
