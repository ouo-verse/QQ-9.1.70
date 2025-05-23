package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FriendSingleInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<FriendSingleInfo> CREATOR;
    public byte C;
    public int D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public String f286125d;

    /* renamed from: e, reason: collision with root package name */
    public String f286126e;

    /* renamed from: f, reason: collision with root package name */
    public String f286127f;

    /* renamed from: h, reason: collision with root package name */
    public String f286128h;

    /* renamed from: i, reason: collision with root package name */
    public int f286129i;

    /* renamed from: m, reason: collision with root package name */
    public int f286130m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<FriendSingleInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FriendSingleInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FriendSingleInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new FriendSingleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FriendSingleInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FriendSingleInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new FriendSingleInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74930);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public FriendSingleInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286125d = "";
        this.f286126e = "";
        this.f286127f = "";
        this.f286128h = "";
        this.E = "";
    }

    public void a(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.f286126e = parcel.readString();
        this.f286127f = parcel.readString();
        this.f286128h = parcel.readString();
        this.f286129i = parcel.readInt();
        this.f286130m = parcel.readInt();
        this.C = parcel.readByte();
        this.D = parcel.readInt();
        this.E = parcel.readString();
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
            return;
        }
        parcel.writeString(this.f286126e);
        parcel.writeString(this.f286127f);
        parcel.writeString(this.f286128h);
        parcel.writeInt(this.f286129i);
        parcel.writeInt(this.f286130m);
        parcel.writeByte(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
    }

    public FriendSingleInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f286125d = "";
        this.f286126e = "";
        this.f286127f = "";
        this.f286128h = "";
        this.E = "";
        a(parcel);
    }
}
