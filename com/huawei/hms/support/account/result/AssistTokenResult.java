package com.huawei.hms.support.account.result;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AssistTokenResult implements Parcelable {
    public static final Parcelable.Creator<AssistTokenResult> CREATOR = new Parcelable.Creator<AssistTokenResult>() { // from class: com.huawei.hms.support.account.result.AssistTokenResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AssistTokenResult createFromParcel(Parcel parcel) {
            return new AssistTokenResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AssistTokenResult[] newArray(int i3) {
            return new AssistTokenResult[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f37510a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAssistToken() {
        return this.f37510a;
    }

    public void setAssistToken(String str) {
        this.f37510a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f37510a);
    }

    public AssistTokenResult() {
    }

    AssistTokenResult(Parcel parcel) {
        this.f37510a = parcel.readString();
    }
}
