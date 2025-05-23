package com.tencent.mobileqq.troop.memberlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@Deprecated
/* loaded from: classes19.dex */
public class TroopMemberList$TroopAdmin implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TroopMemberList$TroopAdmin> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f297801d;

    /* renamed from: e, reason: collision with root package name */
    public String f297802e;

    /* renamed from: f, reason: collision with root package name */
    public String f297803f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Parcelable.Creator<TroopMemberList$TroopAdmin> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopMemberList$TroopAdmin createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopMemberList$TroopAdmin) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new TroopMemberList$TroopAdmin(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopMemberList$TroopAdmin[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopMemberList$TroopAdmin[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new TroopMemberList$TroopAdmin[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ TroopMemberList$TroopAdmin(Parcel parcel, com.tencent.mobileqq.troop.memberlist.a aVar) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, (Object) aVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof TroopMemberList$TroopAdmin) {
            TroopMemberList$TroopAdmin troopMemberList$TroopAdmin = (TroopMemberList$TroopAdmin) obj;
            String str = this.f297801d;
            if (str != null) {
                return str.equals(troopMemberList$TroopAdmin.f297801d);
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f297801d);
        parcel.writeString(this.f297802e);
        parcel.writeString(this.f297803f);
    }

    TroopMemberList$TroopAdmin(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f297801d = parcel.readString();
        this.f297802e = parcel.readString();
        this.f297803f = parcel.readString();
    }

    public TroopMemberList$TroopAdmin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
