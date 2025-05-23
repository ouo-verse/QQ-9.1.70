package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LabelInfo implements Parcelable {
    public static final Parcelable.Creator<LabelInfo> CREATOR = new Parcelable.Creator<LabelInfo>() { // from class: com.huawei.hms.support.api.entity.hwid.LabelInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelInfo createFromParcel(Parcel parcel) {
            return new LabelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelInfo[] newArray(int i3) {
            return new LabelInfo[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private int f37546a;

    /* renamed from: b, reason: collision with root package name */
    private String f37547b;

    public LabelInfo() {
        this.f37546a = -1;
        this.f37547b = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLabelName() {
        return this.f37547b;
    }

    public int getLabelType() {
        return this.f37546a;
    }

    public boolean isEquals(LabelInfo labelInfo) {
        if (labelInfo != null && getLabelType() == labelInfo.getLabelType() && getLabelName().equals(labelInfo.getLabelName())) {
            return true;
        }
        return false;
    }

    public void setLabelName(String str) {
        this.f37547b = str;
    }

    public void setLabelType(int i3) {
        this.f37546a = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f37546a);
        parcel.writeString(this.f37547b);
    }

    protected LabelInfo(Parcel parcel) {
        this.f37546a = parcel.readInt();
        this.f37547b = parcel.readString();
    }
}
