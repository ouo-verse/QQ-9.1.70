package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewTogetherRoomMessageData implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<NewTogetherRoomMessageData> CREATOR;
    public int C;
    public long D;
    public String E;
    public String F;
    public String G;
    public String H;

    /* renamed from: d, reason: collision with root package name */
    public String f238444d;

    /* renamed from: e, reason: collision with root package name */
    public String f238445e;

    /* renamed from: f, reason: collision with root package name */
    public int f238446f;

    /* renamed from: h, reason: collision with root package name */
    public long f238447h;

    /* renamed from: i, reason: collision with root package name */
    public int f238448i;

    /* renamed from: m, reason: collision with root package name */
    public String f238449m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<NewTogetherRoomMessageData> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NewTogetherRoomMessageData createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NewTogetherRoomMessageData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new NewTogetherRoomMessageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NewTogetherRoomMessageData[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (NewTogetherRoomMessageData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new NewTogetherRoomMessageData[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ISlideShowController.CODE_FROM_SLIDE_SHOW_CLIP);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public NewTogetherRoomMessageData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f238446f = 0;
        this.f238447h = 0L;
        this.f238448i = 0;
        this.f238449m = "";
        this.C = 0;
        this.D = 0L;
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
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" groupUin = " + this.f238444d);
        sb5.append(" groupOwnerUin = " + this.f238445e);
        sb5.append(" roomid = " + this.f238447h);
        sb5.append(" oldRoomid = " + this.D);
        sb5.append(" roomName = " + this.E);
        sb5.append(" jumpScheme = " + this.F);
        sb5.append(" roomCover = " + this.G);
        sb5.append(" roomtype = " + this.f238446f);
        sb5.append(" fromid = " + this.H);
        sb5.append(" oldRoomtype = " + this.C);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.f238444d);
        parcel.writeString(this.f238445e);
        parcel.writeInt(this.f238446f);
        parcel.writeLong(this.f238447h);
        parcel.writeInt(this.C);
        parcel.writeLong(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
    }

    protected NewTogetherRoomMessageData(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f238446f = 0;
        this.f238447h = 0L;
        this.f238448i = 0;
        this.f238449m = "";
        this.C = 0;
        this.D = 0L;
        this.f238444d = parcel.readString();
        this.f238445e = parcel.readString();
        this.f238446f = parcel.readInt();
        this.f238447h = parcel.readLong();
        this.C = parcel.readInt();
        this.D = parcel.readLong();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
    }
}
