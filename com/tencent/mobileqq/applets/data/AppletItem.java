package com.tencent.mobileqq.applets.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AppletItem implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<AppletItem> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    private long f196755d;

    /* renamed from: e, reason: collision with root package name */
    private String f196756e;

    /* renamed from: f, reason: collision with root package name */
    private String f196757f;

    /* renamed from: h, reason: collision with root package name */
    private int f196758h;

    /* renamed from: i, reason: collision with root package name */
    private int f196759i;

    /* renamed from: m, reason: collision with root package name */
    private String f196760m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<AppletItem> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppletItem createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AppletItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new AppletItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppletItem[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AppletItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new AppletItem[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f196761a;

        /* renamed from: b, reason: collision with root package name */
        private String f196762b;

        /* renamed from: c, reason: collision with root package name */
        private String f196763c;

        /* renamed from: d, reason: collision with root package name */
        private int f196764d;

        /* renamed from: e, reason: collision with root package name */
        private int f196765e;

        /* renamed from: f, reason: collision with root package name */
        private String f196766f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public AppletItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (AppletItem) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new AppletItem(this.f196761a, this.f196762b, this.f196763c, this.f196764d, this.f196765e, this.f196766f);
        }

        public b b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f196763c = str;
            return this;
        }

        public b c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, j3);
            }
            this.f196761a = j3;
            return this;
        }

        public b d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f196762b = str;
            return this;
        }

        public b e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f196764d = i3;
            return this;
        }

        public b f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f196765e = i3;
            return this;
        }

        public void g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.f196766f = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            CREATOR = new a();
        }
    }

    protected AppletItem(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            return;
        }
        this.f196755d = parcel.readLong();
        this.f196756e = parcel.readString();
        this.f196757f = parcel.readString();
        this.f196758h = parcel.readInt();
        this.f196759i = parcel.readInt();
        this.f196760m = parcel.readString();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f196757f;
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f196755d;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f196756e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f196759i;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f196760m;
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f196759i = i3;
        }
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f196758h;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "AppletItem:[id = " + this.f196755d + ", name = " + this.f196756e + " icon = " + this.f196757f + ", type = " + this.f196758h + "(1:\u5f00, 0:\u5173) , value = " + this.f196759i + "] ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeLong(this.f196755d);
        parcel.writeString(this.f196756e);
        parcel.writeString(this.f196757f);
        parcel.writeInt(this.f196758h);
        parcel.writeInt(this.f196759i);
        parcel.writeString(this.f196760m);
    }

    AppletItem(long j3, String str, String str2, int i3, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        this.f196755d = j3;
        this.f196756e = str;
        this.f196757f = str2;
        this.f196758h = i3;
        this.f196759i = i16;
        this.f196760m = str3;
    }
}
