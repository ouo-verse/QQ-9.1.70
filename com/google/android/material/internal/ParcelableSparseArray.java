package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray createFromParcel(@NonNull Parcel parcel) {
            return new ParcelableSparseArray(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray[] newArray(int i3) {
            return new ParcelableSparseArray[i3];
        }
    }

    public ParcelableSparseArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i16 = 0; i16 < size; i16++) {
            iArr[i16] = keyAt(i16);
            parcelableArr[i16] = valueAt(i16);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i3);
    }

    public ParcelableSparseArray(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i3 = 0; i3 < readInt; i3++) {
            put(iArr[i3], readParcelableArray[i3]);
        }
    }
}
