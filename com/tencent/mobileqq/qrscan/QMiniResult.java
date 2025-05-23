package com.tencent.mobileqq.qrscan;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QMiniResult implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<QMiniResult> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public float f276510d;

    /* renamed from: e, reason: collision with root package name */
    public String f276511e;

    /* renamed from: f, reason: collision with root package name */
    public RectF f276512f;

    /* renamed from: h, reason: collision with root package name */
    public String f276513h;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<QMiniResult> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QMiniResult createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QMiniResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new QMiniResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QMiniResult[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QMiniResult[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new QMiniResult[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public QMiniResult() {
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
        return "QMiniResult{type" + this.f276513h + "prob=" + this.f276510d + ", data='" + this.f276511e + "', location=" + this.f276512f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeFloat(this.f276510d);
        parcel.writeString(this.f276511e);
        parcel.writeParcelable(this.f276512f, i3);
    }

    protected QMiniResult(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f276510d = parcel.readFloat();
        this.f276511e = parcel.readString();
        this.f276512f = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }
}
