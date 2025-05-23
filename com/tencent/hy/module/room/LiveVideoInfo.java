package com.tencent.hy.module.room;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LiveVideoInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<LiveVideoInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f114721d;

    /* renamed from: e, reason: collision with root package name */
    public int f114722e;

    /* renamed from: f, reason: collision with root package name */
    public int f114723f;

    /* renamed from: h, reason: collision with root package name */
    public int f114724h;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Parcelable.Creator<LiveVideoInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LiveVideoInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LiveVideoInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new LiveVideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LiveVideoInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LiveVideoInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new LiveVideoInfo[0];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public LiveVideoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "[videoId=" + this.f114721d + ", width=" + this.f114722e + ", height=" + this.f114723f + ", bitrate=" + this.f114724h + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f114721d);
        parcel.writeInt(this.f114722e);
        parcel.writeInt(this.f114723f);
        parcel.writeInt(this.f114724h);
    }

    @VisibleForTesting
    LiveVideoInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.f114721d = parcel.readInt();
        this.f114722e = parcel.readInt();
        this.f114723f = parcel.readInt();
        this.f114724h = parcel.readInt();
    }
}
