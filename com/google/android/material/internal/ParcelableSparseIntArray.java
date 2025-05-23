package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ParcelableSparseIntArray> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseIntArray createFromParcel(@NonNull Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i3 = 0; i3 < readInt; i3++) {
                parcelableSparseIntArray.put(iArr[i3], iArr2[i3]);
            }
            return parcelableSparseIntArray;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseIntArray[] newArray(int i3) {
            return new ParcelableSparseIntArray[i3];
        }
    }

    public ParcelableSparseIntArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i16 = 0; i16 < size(); i16++) {
            iArr[i16] = keyAt(i16);
            iArr2[i16] = valueAt(i16);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }

    public ParcelableSparseIntArray(int i3) {
        super(i3);
    }
}
