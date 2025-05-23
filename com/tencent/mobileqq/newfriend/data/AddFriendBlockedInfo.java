package com.tencent.mobileqq.newfriend.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AddFriendBlockedInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<AddFriendBlockedInfo> CREATOR;
    public boolean C;
    public int D;

    /* renamed from: d, reason: collision with root package name */
    public String f254008d;

    /* renamed from: e, reason: collision with root package name */
    public String f254009e;

    /* renamed from: f, reason: collision with root package name */
    public int f254010f;

    /* renamed from: h, reason: collision with root package name */
    public int f254011h;

    /* renamed from: i, reason: collision with root package name */
    public String f254012i;

    /* renamed from: m, reason: collision with root package name */
    public long f254013m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<AddFriendBlockedInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AddFriendBlockedInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AddFriendBlockedInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new AddFriendBlockedInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AddFriendBlockedInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AddFriendBlockedInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new AddFriendBlockedInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public AddFriendBlockedInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "AddFriendBlockedInfo {, friendUin='" + this.f254008d + "', friendNick='" + this.f254009e + "', age='" + this.f254010f + "', sex='" + this.f254011h + "', sourceDsp='" + this.f254012i + "', blockTime='" + this.f254013m + "', isRead='" + this.C + "', commFriends='" + this.D + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f254008d);
        parcel.writeString(this.f254009e);
        parcel.writeInt(this.f254010f);
        parcel.writeInt(this.f254011h);
        parcel.writeString(this.f254012i);
        parcel.writeLong(this.f254013m);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.D);
    }

    protected AddFriendBlockedInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f254008d = parcel.readString();
        this.f254009e = parcel.readString();
        this.f254010f = parcel.readInt();
        this.f254011h = parcel.readInt();
        this.f254012i = parcel.readString();
        this.f254013m = parcel.readLong();
        this.C = parcel.readByte() != 0;
        this.D = parcel.readInt();
    }
}
