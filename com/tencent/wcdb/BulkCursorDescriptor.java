package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class BulkCursorDescriptor implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<BulkCursorDescriptor> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public i f384290d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f384291e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f384292f;

    /* renamed from: h, reason: collision with root package name */
    public int f384293h;

    /* renamed from: i, reason: collision with root package name */
    public CursorWindow f384294i;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class a implements Parcelable.Creator<BulkCursorDescriptor> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BulkCursorDescriptor createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BulkCursorDescriptor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            BulkCursorDescriptor bulkCursorDescriptor = new BulkCursorDescriptor();
            bulkCursorDescriptor.a(parcel);
            return bulkCursorDescriptor;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BulkCursorDescriptor[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BulkCursorDescriptor[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new BulkCursorDescriptor[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14165);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public BulkCursorDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(Parcel parcel) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.f384290d = c.j(parcel.readStrongBinder());
        this.f384291e = b(parcel);
        if (parcel.readInt() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f384292f = z16;
        this.f384293h = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.f384294i = CursorWindow.CREATOR.createFromParcel(parcel);
        }
    }

    public final String[] b(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
        }
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            String[] strArr = new String[readInt];
            for (int i3 = 0; i3 < readInt; i3++) {
                strArr[i3] = parcel.readString();
            }
            return strArr;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeStrongBinder(this.f384290d.asBinder());
        parcel.writeStringArray(this.f384291e);
        parcel.writeInt(this.f384292f ? 1 : 0);
        parcel.writeInt(this.f384293h);
        if (this.f384294i != null) {
            parcel.writeInt(1);
            this.f384294i.writeToParcel(parcel, i3);
        } else {
            parcel.writeInt(0);
        }
    }
}
