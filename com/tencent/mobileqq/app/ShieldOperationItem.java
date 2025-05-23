package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ShieldOperationItem implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ShieldOperationItem> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public int f195067d;

    /* renamed from: e, reason: collision with root package name */
    public int f195068e;

    /* renamed from: f, reason: collision with root package name */
    public int f195069f;

    /* renamed from: h, reason: collision with root package name */
    public long[] f195070h;

    /* renamed from: i, reason: collision with root package name */
    public int f195071i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ShieldOperationItem> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShieldOperationItem createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ShieldOperationItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ShieldOperationItem shieldOperationItem = new ShieldOperationItem();
            shieldOperationItem.f195067d = parcel.readInt();
            shieldOperationItem.f195068e = parcel.readInt();
            shieldOperationItem.f195069f = parcel.readInt();
            shieldOperationItem.f195070h = parcel.createLongArray();
            shieldOperationItem.f195071i = parcel.readInt();
            return shieldOperationItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShieldOperationItem[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ShieldOperationItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69959);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public ShieldOperationItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195069f = 0;
            this.f195071i = 0;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("");
        sb5.append("--->>DUMP_ShieldOperationItem<<---");
        sb5.append(",");
        sb5.append("opType:");
        sb5.append(this.f195067d);
        sb5.append(",source_id:");
        sb5.append(this.f195068e);
        sb5.append(",source_sub_id:");
        sb5.append(this.f195069f);
        sb5.append(this.f195071i);
        sb5.append(",uinList:");
        long[] jArr = this.f195070h;
        if (jArr != null) {
            sb5.append(jArr.toString());
        } else {
            sb5.append("null.");
        }
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.f195067d);
        parcel.writeInt(this.f195068e);
        parcel.writeInt(this.f195069f);
        parcel.writeLongArray(this.f195070h);
        parcel.writeInt(this.f195071i);
    }
}
