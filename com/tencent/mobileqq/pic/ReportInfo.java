package com.tencent.mobileqq.pic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReportInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ReportInfo> CREATOR;
    public int C;
    public long D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    public int f258582d;

    /* renamed from: e, reason: collision with root package name */
    public long f258583e;

    /* renamed from: f, reason: collision with root package name */
    public int f258584f;

    /* renamed from: h, reason: collision with root package name */
    public int f258585h;

    /* renamed from: i, reason: collision with root package name */
    public int f258586i;

    /* renamed from: m, reason: collision with root package name */
    public long f258587m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<ReportInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReportInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ReportInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ReportInfo reportInfo = new ReportInfo();
            reportInfo.f258582d = parcel.readInt();
            reportInfo.f258584f = parcel.readInt();
            reportInfo.f258585h = parcel.readInt();
            reportInfo.E = parcel.readInt();
            reportInfo.f258586i = parcel.readInt();
            reportInfo.C = parcel.readInt();
            reportInfo.f258583e = parcel.readLong();
            reportInfo.f258587m = parcel.readLong();
            reportInfo.D = parcel.readLong();
            return reportInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReportInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ReportInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ReportInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public ReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258582d = -1;
        this.f258583e = -1L;
        this.f258584f = -1;
        this.f258585h = -1;
        this.f258586i = -1;
        this.f258587m = -1L;
        this.C = -1;
        this.D = -1L;
        this.E = -1;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "\nReportInfo\n |-rpStep:" + this.f258582d + "\n |-rpMsgRecvTime:" + this.f258583e + "\n |-rpMsgNetwork:" + this.f258584f + "\n |-rpThumbNetwork:" + this.f258585h + "\n |-rpThumbDownMode:" + this.f258586i + "\n |-rpThumbTimeDiff:" + this.f258587m + "\n |-rpBigDownMode:" + this.C + "\n |-rpBigTimeDiff:" + this.D + "\n |-rpBigNetwork:" + this.E;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f258582d);
        parcel.writeInt(this.f258584f);
        parcel.writeInt(this.f258585h);
        parcel.writeInt(this.E);
        parcel.writeInt(this.f258586i);
        parcel.writeInt(this.C);
        parcel.writeLong(this.f258583e);
        parcel.writeLong(this.f258587m);
        parcel.writeLong(this.D);
    }
}
