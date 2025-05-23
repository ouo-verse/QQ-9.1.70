package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WatchTogetherSession extends tr2.f implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<WatchTogetherSession> CREATOR;
    public int L;
    public String M;
    public long N;
    public String P;
    public String Q;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<WatchTogetherSession> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WatchTogetherSession createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WatchTogetherSession) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new WatchTogetherSession(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WatchTogetherSession[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (WatchTogetherSession[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new WatchTogetherSession[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            CREATOR = new a();
        }
    }

    public WatchTogetherSession(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.L = 0;
        this.M = "";
        this.Q = "";
        this.f437187d = 2;
        this.f437188e = 1;
        this.f437189f = str;
    }

    protected Object clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WatchTogetherSession watchTogetherSession = (WatchTogetherSession) super.clone();
        watchTogetherSession.f437187d = this.f437187d;
        watchTogetherSession.f437188e = this.f437188e;
        watchTogetherSession.f437189f = this.f437189f;
        watchTogetherSession.f437190h = this.f437190h;
        watchTogetherSession.f437191i = this.f437191i;
        watchTogetherSession.f437192m = this.f437192m;
        watchTogetherSession.C = this.C;
        watchTogetherSession.E = this.E;
        watchTogetherSession.F = this.F;
        watchTogetherSession.G = this.G;
        watchTogetherSession.H = this.H;
        watchTogetherSession.L = this.L;
        watchTogetherSession.M = this.M;
        watchTogetherSession.N = this.N;
        watchTogetherSession.P = this.P;
        watchTogetherSession.Q = this.Q;
        watchTogetherSession.I = this.I;
        return watchTogetherSession;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "WatchTogetherSession{roomType=" + this.L + ", jumpurl='" + this.M + "', roomId=" + this.N + ", roomName='" + this.P + "', roomCover='" + this.Q + "', serviceType=" + this.f437187d + ", type=" + this.f437188e + ", uin='" + this.f437189f + "', joinNum=" + this.f437190h + ", status=" + this.f437191i + ", userState=" + this.f437192m + ", creator='" + this.C + "', timeStamp=" + this.E + ", videoType=" + this.F + ", videoJumpType=" + this.G + ", videoJumpURL='" + this.H + "', identifyId=" + this.I + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f437187d);
        parcel.writeInt(this.f437188e);
        parcel.writeString(this.f437189f);
        parcel.writeInt(this.f437190h);
        parcel.writeInt(this.f437191i);
        parcel.writeInt(this.f437192m);
        parcel.writeString(this.C);
        parcel.writeLong(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeLong(this.I);
    }

    protected WatchTogetherSession(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.L = 0;
        this.M = "";
        this.Q = "";
        this.f437187d = parcel.readInt();
        this.f437188e = parcel.readInt();
        this.f437189f = parcel.readString();
        this.f437190h = parcel.readInt();
        this.f437191i = parcel.readInt();
        this.f437192m = parcel.readInt();
        this.C = parcel.readString();
        this.E = parcel.readLong();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readString();
        this.L = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readInt();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.I = parcel.readLong();
    }
}
