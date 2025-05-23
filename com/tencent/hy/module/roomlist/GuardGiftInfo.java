package com.tencent.hy.module.roomlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GuardGiftInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<GuardGiftInfo> CREATOR;
    public String C;
    public String D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public String f114731d;

    /* renamed from: e, reason: collision with root package name */
    public long f114732e;

    /* renamed from: f, reason: collision with root package name */
    public long f114733f;

    /* renamed from: h, reason: collision with root package name */
    public String f114734h;

    /* renamed from: i, reason: collision with root package name */
    public String f114735i;

    /* renamed from: m, reason: collision with root package name */
    public String f114736m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<GuardGiftInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuardGiftInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GuardGiftInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new GuardGiftInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuardGiftInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (GuardGiftInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new GuardGiftInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20139);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public GuardGiftInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            return;
        }
        this.f114731d = parcel.readString();
        this.f114732e = parcel.readLong();
        this.f114733f = parcel.readLong();
        this.f114734h = parcel.readString();
        this.f114735i = parcel.readString();
        this.f114736m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
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

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "GiftInfo{mSendUid=" + this.f114732e + ", mReceiveUid='" + this.f114733f + "', mSendHead=" + this.f114734h + ", mReceiveHead=" + this.f114735i + ", mResUrl=" + this.f114736m + ", mSendName=" + this.C + ", mReceiveName=" + this.D + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f114731d);
        parcel.writeLong(this.f114732e);
        parcel.writeLong(this.f114733f);
        parcel.writeString(this.f114734h);
        parcel.writeString(this.f114735i);
        parcel.writeString(this.f114736m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
    }

    public GuardGiftInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
