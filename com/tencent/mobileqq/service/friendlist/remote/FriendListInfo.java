package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FriendListInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<FriendListInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f286123d;

    /* renamed from: e, reason: collision with root package name */
    public List<FriendSingleInfo> f286124e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<FriendListInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FriendListInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FriendListInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new FriendListInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FriendListInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FriendListInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new FriendListInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    public FriendListInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286123d = 0;
            this.f286124e = new ArrayList();
        }
    }

    public void a(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel);
            return;
        }
        this.f286123d = parcel.readInt();
        int readInt = parcel.readInt();
        this.f286124e = new ArrayList();
        for (int i3 = 0; i3 < readInt; i3++) {
            FriendSingleInfo friendSingleInfo = new FriendSingleInfo();
            friendSingleInfo.a(parcel);
            this.f286124e.add(friendSingleInfo);
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
            return;
        }
        if (this.f286124e == null) {
            this.f286124e = new ArrayList();
        }
        parcel.writeInt(this.f286123d);
        parcel.writeInt(this.f286124e.size());
        for (int i16 = 0; i16 < this.f286124e.size(); i16++) {
            this.f286124e.get(i16).writeToParcel(parcel, i3);
        }
    }

    public FriendListInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a(parcel);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
        }
    }
}
