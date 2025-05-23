package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class ParcelableBinder implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ParcelableBinder> CREATOR;
    private IBinder mBinder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<ParcelableBinder>() { // from class: com.tencent.mobileqq.pluginsdk.ipc.ParcelableBinder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ParcelableBinder createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ParcelableBinder(parcel, null) : (ParcelableBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ParcelableBinder[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ParcelableBinder[i3] : (ParcelableBinder[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    /* synthetic */ ParcelableBinder(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, (Object) anonymousClass1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public IBinder getBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mBinder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeStrongBinder(this.mBinder);
        }
    }

    public ParcelableBinder(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mBinder = iBinder;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
        }
    }

    ParcelableBinder(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mBinder = parcel.readStrongBinder();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }
    }
}
