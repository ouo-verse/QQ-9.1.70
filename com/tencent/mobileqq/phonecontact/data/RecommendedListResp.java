package com.tencent.mobileqq.phonecontact.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class RecommendedListResp implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<RecommendedListResp> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f258452d;

    /* renamed from: e, reason: collision with root package name */
    public int f258453e;

    /* renamed from: f, reason: collision with root package name */
    public long f258454f;

    /* renamed from: h, reason: collision with root package name */
    public List<PhoneInfo> f258455h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<RecommendedListResp> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendedListResp createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecommendedListResp) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new RecommendedListResp(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecommendedListResp[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RecommendedListResp[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new RecommendedListResp[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public RecommendedListResp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f258455h = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
        parcel.writeInt(this.f258452d);
        parcel.writeInt(this.f258453e);
        parcel.writeLong(this.f258454f);
        parcel.writeTypedList(this.f258455h);
    }

    protected RecommendedListResp(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f258455h = new ArrayList();
        this.f258452d = parcel.readInt();
        this.f258453e = parcel.readInt();
        this.f258454f = parcel.readLong();
        this.f258455h = parcel.createTypedArrayList(PhoneInfo.CREATOR);
    }
}
