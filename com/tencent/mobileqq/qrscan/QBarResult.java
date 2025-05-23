package com.tencent.mobileqq.qrscan;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QBarResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<QBarResult> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public float f276506d;

    /* renamed from: e, reason: collision with root package name */
    public String f276507e;

    /* renamed from: f, reason: collision with root package name */
    public String f276508f;

    /* renamed from: h, reason: collision with root package name */
    public RectF f276509h;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<QBarResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QBarResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QBarResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new QBarResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QBarResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QBarResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new QBarResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public QBarResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QbarScanResult{prob=" + this.f276506d + ", typeName='" + this.f276507e + "', data='" + this.f276508f + "', location=" + this.f276509h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeFloat(this.f276506d);
        parcel.writeString(this.f276507e);
        parcel.writeString(this.f276508f);
        parcel.writeParcelable(this.f276509h, i3);
    }

    protected QBarResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f276506d = parcel.readFloat();
        this.f276507e = parcel.readString();
        this.f276508f = parcel.readString();
        this.f276509h = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
