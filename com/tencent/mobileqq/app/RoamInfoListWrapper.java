package com.tencent.mobileqq.app;

import MessageSvcPack.RoamInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RoamInfoListWrapper implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RoamInfoListWrapper> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<RoamInfo> f195005d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<RoamInfoListWrapper> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoamInfoListWrapper createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RoamInfoListWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            RoamInfoListWrapper roamInfoListWrapper = new RoamInfoListWrapper();
            roamInfoListWrapper.f195005d = parcel.readArrayList(ArrayList.class.getClassLoader());
            return roamInfoListWrapper;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RoamInfoListWrapper[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RoamInfoListWrapper[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RoamInfoListWrapper[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69927);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public RoamInfoListWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
        } else {
            parcel.writeList(this.f195005d);
        }
    }
}
