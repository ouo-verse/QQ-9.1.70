package com.tencent.mobileqq.qqsec.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RiskInfoItem implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RiskInfoItem> CREATOR;
    public String C;

    /* renamed from: d, reason: collision with root package name */
    public String f274383d;

    /* renamed from: e, reason: collision with root package name */
    public String f274384e;

    /* renamed from: f, reason: collision with root package name */
    public String f274385f;

    /* renamed from: h, reason: collision with root package name */
    public String f274386h;

    /* renamed from: i, reason: collision with root package name */
    public int f274387i;

    /* renamed from: m, reason: collision with root package name */
    public int f274388m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<RiskInfoItem> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RiskInfoItem createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RiskInfoItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new RiskInfoItem(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RiskInfoItem[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RiskInfoItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RiskInfoItem[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ RiskInfoItem(Parcel parcel, a aVar) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, (Object) aVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f274383d);
        parcel.writeString(this.f274384e);
        parcel.writeString(this.f274385f);
        parcel.writeString(this.f274386h);
        parcel.writeInt(this.f274387i);
        parcel.writeInt(this.f274388m);
        parcel.writeString(this.C);
    }

    RiskInfoItem(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f274383d = parcel.readString();
        this.f274384e = parcel.readString();
        this.f274385f = parcel.readString();
        this.f274386h = parcel.readString();
        this.f274387i = parcel.readInt();
        this.f274388m = parcel.readInt();
        this.C = parcel.readString();
    }

    public RiskInfoItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
