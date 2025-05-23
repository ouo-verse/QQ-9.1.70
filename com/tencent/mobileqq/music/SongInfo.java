package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SongInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SongInfo> CREATOR;
    public String C;
    public String D;
    public String E;
    public String F;
    public long G;
    public int H;
    public int I;
    public boolean J;
    public BroadcastMusicInfo K;
    public long L;

    /* renamed from: d, reason: collision with root package name */
    public long f251867d;

    /* renamed from: e, reason: collision with root package name */
    public String f251868e;

    /* renamed from: f, reason: collision with root package name */
    public long f251869f;

    /* renamed from: h, reason: collision with root package name */
    public String f251870h;

    /* renamed from: i, reason: collision with root package name */
    public String f251871i;

    /* renamed from: m, reason: collision with root package name */
    public String f251872m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<SongInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SongInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SongInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SongInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SongInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SongInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SongInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new a();
        }
    }

    /* synthetic */ SongInfo(Parcel parcel, a aVar) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f251870h);
        parcel.writeString(this.f251871i);
        parcel.writeString(this.f251872m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeLong(this.f251867d);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeInt(this.I);
        parcel.writeLong(this.G);
        parcel.writeParcelable(this.K, i3);
        parcel.writeInt(this.H);
        if (this.J) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        parcel.writeFloat(f16);
        parcel.writeLong(this.L);
        parcel.writeLong(this.f251869f);
        parcel.writeString(this.f251868e);
    }

    public SongInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public SongInfo(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2);
            return;
        }
        this.f251867d = j3;
        this.E = str;
        this.f251870h = str2;
        this.K = null;
    }

    SongInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f251870h = parcel.readString();
        this.f251871i = parcel.readString();
        this.f251872m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.f251867d = parcel.readLong();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.I = parcel.readInt();
        this.G = parcel.readLong();
        this.K = (BroadcastMusicInfo) parcel.readParcelable(BroadcastMusicInfo.class.getClassLoader());
        this.H = parcel.readInt();
        this.J = parcel.readFloat() != 0.0f;
        this.L = parcel.readLong();
        this.f251869f = parcel.readLong();
        this.f251868e = parcel.readString();
    }
}
