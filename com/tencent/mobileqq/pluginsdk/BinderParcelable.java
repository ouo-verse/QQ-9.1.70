package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class BinderParcelable implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BinderParcelable> CREATOR;
    public IBinder mBinder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12145);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<BinderParcelable>() { // from class: com.tencent.mobileqq.pluginsdk.BinderParcelable.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BinderParcelable createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new BinderParcelable(parcel) : (BinderParcelable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BinderParcelable[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new BinderParcelable[i3] : (BinderParcelable[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderParcelable(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mBinder = iBinder;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
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
            parcel.writeStrongBinder(this.mBinder);
        }
    }

    BinderParcelable(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mBinder = parcel.readStrongBinder();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }
    }
}
