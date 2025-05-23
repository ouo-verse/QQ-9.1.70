package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SosoCell implements Comparable<SosoCell>, Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SosoCell> CREATOR;
    public int mCellId;
    public boolean mIsMainCell;
    public int mLac;
    public int mMcc;
    public int mMnc;
    public int mRss;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<SosoCell> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SosoCell createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SosoCell) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new SosoCell(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SosoCell[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SosoCell[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new SosoCell[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public SosoCell(int i3, int i16, int i17, int i18, int i19, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16));
            return;
        }
        this.mMcc = i3;
        this.mMnc = i16;
        this.mLac = i17;
        this.mCellId = i18;
        this.mRss = i19;
        this.mIsMainCell = z16;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeInt(this.mLac);
        parcel.writeInt(this.mCellId);
        parcel.writeInt(this.mRss);
        parcel.writeByte(this.mIsMainCell ? (byte) 1 : (byte) 0);
    }

    @Override // java.lang.Comparable
    public int compareTo(SosoCell sosoCell) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.mCellId - sosoCell.mCellId : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sosoCell)).intValue();
    }

    protected SosoCell(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mMcc = parcel.readInt();
        this.mMnc = parcel.readInt();
        this.mLac = parcel.readInt();
        this.mCellId = parcel.readInt();
        this.mRss = parcel.readInt();
        this.mIsMainCell = parcel.readByte() != 0;
    }
}
