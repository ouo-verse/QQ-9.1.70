package com.huawei.hms.support.account.result;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AccountIcon implements Parcelable {
    public static final Parcelable.Creator<AccountIcon> CREATOR = new Parcelable.Creator<AccountIcon>() { // from class: com.huawei.hms.support.account.result.AccountIcon.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon createFromParcel(Parcel parcel) {
            return new AccountIcon(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountIcon[] newArray(int i3) {
            return new AccountIcon[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f37508a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f37509b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.f37508a;
    }

    public Bitmap getIcon() {
        return this.f37509b;
    }

    public void setDescription(String str) {
        this.f37508a = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.f37509b = bitmap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f37508a);
        parcel.writeParcelable(this.f37509b, i3);
    }

    public AccountIcon() {
    }

    AccountIcon(Parcel parcel) {
        this.f37508a = parcel.readString();
        this.f37509b = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    public AccountIcon(String str, Bitmap bitmap) {
        this.f37508a = str;
        this.f37509b = bitmap;
    }
}
