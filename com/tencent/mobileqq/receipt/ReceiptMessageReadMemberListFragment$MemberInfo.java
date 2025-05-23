package com.tencent.mobileqq.receipt;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes16.dex */
public class ReceiptMessageReadMemberListFragment$MemberInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ReceiptMessageReadMemberListFragment$MemberInfo> CREATOR;

    /* renamed from: d, reason: collision with root package name */
    public String f280198d;

    /* renamed from: e, reason: collision with root package name */
    public String f280199e;

    /* renamed from: f, reason: collision with root package name */
    public long f280200f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<ReceiptMessageReadMemberListFragment$MemberInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReceiptMessageReadMemberListFragment$MemberInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ReceiptMessageReadMemberListFragment$MemberInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ReceiptMessageReadMemberListFragment$MemberInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReceiptMessageReadMemberListFragment$MemberInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ReceiptMessageReadMemberListFragment$MemberInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ReceiptMessageReadMemberListFragment$MemberInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    protected ReceiptMessageReadMemberListFragment$MemberInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.f280198d = parcel.readString();
        this.f280199e = parcel.readString();
        this.f280200f = parcel.readLong();
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
        parcel.writeString(this.f280198d);
        parcel.writeString(this.f280199e);
        parcel.writeLong(this.f280200f);
    }
}
