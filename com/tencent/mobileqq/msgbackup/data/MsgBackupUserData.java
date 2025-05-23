package com.tencent.mobileqq.msgbackup.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupUserData implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<MsgBackupUserData> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    private String f251097d;

    /* renamed from: e, reason: collision with root package name */
    private List<Integer> f251098e;

    /* renamed from: f, reason: collision with root package name */
    private String f251099f;

    /* renamed from: h, reason: collision with root package name */
    private String f251100h;

    /* renamed from: i, reason: collision with root package name */
    private int f251101i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f251102m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<MsgBackupUserData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MsgBackupUserData createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MsgBackupUserData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new MsgBackupUserData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MsgBackupUserData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MsgBackupUserData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new MsgBackupUserData[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f251103a;

        /* renamed from: b, reason: collision with root package name */
        private List<Integer> f251104b;

        /* renamed from: c, reason: collision with root package name */
        private String f251105c;

        /* renamed from: d, reason: collision with root package name */
        private String f251106d;

        /* renamed from: e, reason: collision with root package name */
        private int f251107e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f251108f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public MsgBackupUserData a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (MsgBackupUserData) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new MsgBackupUserData(this.f251103a, this.f251104b, this.f251105c, this.f251106d, this.f251107e, this.f251108f, null);
        }

        public b b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f251106d = str;
            return this;
        }

        public b c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f251103a = str;
            return this;
        }

        public b d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f251108f = z16;
            return this;
        }

        public b e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.f251107e = i3;
            return this;
        }

        public b f(List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            }
            this.f251104b = list;
            return this;
        }

        public b g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f251105c = str;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ MsgBackupUserData(String str, List list, String str2, String str3, int i3, boolean z16, a aVar) {
        this(str, list, str2, str3, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, this, str, list, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16), aVar);
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f251100h;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f251097d;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f251102m;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f251101i;
    }

    public List<Integer> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f251098e;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f251099f;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "--UserData--, ip: " + this.f251097d + ",ports: " + this.f251098e + ",bssid: " + this.f251100h + ", ssid: " + this.f251099f + ", platfrom: " + this.f251101i + ", isNt: " + this.f251102m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f251097d);
        parcel.writeList(this.f251098e);
        parcel.writeString(this.f251099f);
        parcel.writeString(this.f251100h);
        parcel.writeInt(this.f251101i);
        parcel.writeByte(this.f251102m ? (byte) 1 : (byte) 0);
    }

    MsgBackupUserData(String str, List<Integer> list, String str2, String str3, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f251097d = str;
        this.f251098e = list;
        this.f251099f = str2;
        this.f251100h = str3;
        this.f251101i = i3;
        this.f251102m = z16;
    }

    protected MsgBackupUserData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f251097d = parcel.readString();
        parcel.readList(this.f251098e, getClass().getClassLoader());
        this.f251099f = parcel.readString();
        this.f251100h = parcel.readString();
        this.f251101i = parcel.readInt();
        this.f251102m = parcel.readByte() != 0;
    }
}
