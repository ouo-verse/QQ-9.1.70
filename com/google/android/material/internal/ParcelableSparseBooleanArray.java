package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray createFromParcel(@NonNull Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(readInt);
            int[] iArr = new int[readInt];
            boolean[] zArr = new boolean[readInt];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i3 = 0; i3 < readInt; i3++) {
                parcelableSparseBooleanArray.put(iArr[i3], zArr[i3]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray[] newArray(int i3) {
            return new ParcelableSparseBooleanArray[i3];
        }
    }

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i16 = 0; i16 < size(); i16++) {
            iArr[i16] = keyAt(i16);
            zArr[i16] = valueAt(i16);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }

    public ParcelableSparseBooleanArray(int i3) {
        super(i3);
    }
}
