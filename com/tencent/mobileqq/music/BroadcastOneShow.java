package com.tencent.mobileqq.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BroadcastOneShow implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BroadcastOneShow> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f251828d;

    /* renamed from: e, reason: collision with root package name */
    public String f251829e;

    /* renamed from: f, reason: collision with root package name */
    public long f251830f;

    /* renamed from: h, reason: collision with root package name */
    public long f251831h;

    /* renamed from: i, reason: collision with root package name */
    public int f251832i;

    /* renamed from: m, reason: collision with root package name */
    public String f251833m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<BroadcastOneShow> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BroadcastOneShow createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BroadcastOneShow) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new BroadcastOneShow(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BroadcastOneShow[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BroadcastOneShow[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BroadcastOneShow[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    BroadcastOneShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251828d = "";
        this.f251829e = "";
        this.f251830f = 0L;
        this.f251831h = 0L;
        this.f251832i = 0;
        this.f251833m = "";
    }

    public static BroadcastOneShow a(NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow broadcastOneShow) {
        BroadcastOneShow broadcastOneShow2 = new BroadcastOneShow();
        broadcastOneShow2.f251828d = broadcastOneShow.bcShowId;
        broadcastOneShow2.f251829e = broadcastOneShow.bcShowName;
        broadcastOneShow2.f251830f = broadcastOneShow.startTime;
        broadcastOneShow2.f251831h = broadcastOneShow.endTime;
        broadcastOneShow2.f251832i = broadcastOneShow.singerId;
        broadcastOneShow2.f251833m = broadcastOneShow.singerName;
        return broadcastOneShow2;
    }

    public static BroadcastOneShow b(String str) {
        BroadcastOneShow broadcastOneShow = new BroadcastOneShow();
        try {
            JSONObject jSONObject = new JSONObject(str);
            broadcastOneShow.f251828d = jSONObject.optString("bcShowId");
            broadcastOneShow.f251829e = jSONObject.optString("bcShowName");
            broadcastOneShow.f251830f = jSONObject.optLong("startTime");
            broadcastOneShow.f251831h = jSONObject.optLong("endTime");
            broadcastOneShow.f251832i = jSONObject.optInt("singerId");
            broadcastOneShow.f251833m = jSONObject.optString("singerName");
        } catch (Exception unused) {
        }
        return broadcastOneShow;
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
        parcel.writeString(this.f251828d);
        parcel.writeString(this.f251829e);
        parcel.writeLong(this.f251830f);
        parcel.writeLong(this.f251831h);
        parcel.writeInt(this.f251832i);
        parcel.writeString(this.f251833m);
    }

    public BroadcastOneShow(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f251828d = "";
        this.f251829e = "";
        this.f251830f = 0L;
        this.f251831h = 0L;
        this.f251832i = 0;
        this.f251833m = "";
        this.f251828d = parcel.readString();
        this.f251829e = parcel.readString();
        this.f251830f = parcel.readLong();
        this.f251831h = parcel.readLong();
        this.f251832i = parcel.readInt();
        this.f251833m = parcel.readString();
    }
}
