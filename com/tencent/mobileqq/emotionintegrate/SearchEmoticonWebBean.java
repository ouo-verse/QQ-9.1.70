package com.tencent.mobileqq.emotionintegrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SearchEmoticonWebBean implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SearchEmoticonWebBean> CREATOR;
    public int C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;

    /* renamed from: d, reason: collision with root package name */
    public String f205169d;

    /* renamed from: e, reason: collision with root package name */
    public String f205170e;

    /* renamed from: f, reason: collision with root package name */
    public String f205171f;

    /* renamed from: h, reason: collision with root package name */
    public int f205172h;

    /* renamed from: i, reason: collision with root package name */
    public int f205173i;

    /* renamed from: m, reason: collision with root package name */
    public int f205174m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<SearchEmoticonWebBean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SearchEmoticonWebBean createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SearchEmoticonWebBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SearchEmoticonWebBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SearchEmoticonWebBean[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SearchEmoticonWebBean[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SearchEmoticonWebBean[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71746);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public SearchEmoticonWebBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205169d = "";
        this.f205170e = "";
        this.f205171f = "";
        this.f205172h = 0;
        this.f205173i = 0;
        this.f205174m = 0;
        this.C = 0;
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
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
        parcel.writeString(this.f205169d);
        parcel.writeString(this.f205170e);
        parcel.writeString(this.f205171f);
        parcel.writeInt(this.f205172h);
        parcel.writeInt(this.f205173i);
        parcel.writeInt(this.f205174m);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.J);
    }

    protected SearchEmoticonWebBean(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f205169d = "";
        this.f205170e = "";
        this.f205171f = "";
        this.f205172h = 0;
        this.f205173i = 0;
        this.f205174m = 0;
        this.C = 0;
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.f205169d = parcel.readString();
        this.f205170e = parcel.readString();
        this.f205171f = parcel.readString();
        this.f205172h = parcel.readInt();
        this.f205173i = parcel.readInt();
        this.f205174m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.J = parcel.readString();
    }
}
