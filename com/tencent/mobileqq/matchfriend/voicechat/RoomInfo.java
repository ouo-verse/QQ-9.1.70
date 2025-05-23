package com.tencent.mobileqq.matchfriend.voicechat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RoomInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RoomInfo> CREATOR;
    public byte[] C;
    public long D;
    public long E;

    /* renamed from: d, reason: collision with root package name */
    public int f245597d;

    /* renamed from: e, reason: collision with root package name */
    public long f245598e;

    /* renamed from: f, reason: collision with root package name */
    public long f245599f;

    /* renamed from: h, reason: collision with root package name */
    public String f245600h;

    /* renamed from: i, reason: collision with root package name */
    public String f245601i;

    /* renamed from: m, reason: collision with root package name */
    public String f245602m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<RoomInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RoomInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RoomInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new RoomInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RoomInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RoomInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RoomInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public RoomInfo(int i3, long j3, long j16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), bArr);
            return;
        }
        this.f245597d = i3;
        this.f245598e = j3;
        this.f245599f = j16;
        this.C = bArr;
    }

    public boolean a() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f245597d > 0 && this.f245598e > 0 && this.f245599f > 0 && (bArr = this.C) != null && bArr.length > 0) {
            return true;
        }
        return false;
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
        parcel.writeInt(this.f245597d);
        parcel.writeLong(this.f245598e);
        parcel.writeLong(this.f245599f);
        parcel.writeString(this.f245600h);
        parcel.writeString(this.f245601i);
        parcel.writeString(this.f245602m);
        parcel.writeByteArray(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
    }

    protected RoomInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f245597d = parcel.readInt();
        this.f245598e = parcel.readLong();
        this.f245599f = parcel.readLong();
        this.f245600h = parcel.readString();
        this.f245601i = parcel.readString();
        this.f245602m = parcel.readString();
        this.C = parcel.createByteArray();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
    }
}
