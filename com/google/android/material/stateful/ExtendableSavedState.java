package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final SimpleArrayMap<String, Bundle> f34223d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel) {
            return new ExtendableSavedState(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState[] newArray(int i3) {
            return new ExtendableSavedState[i3];
        }
    }

    /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f34223d + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        int size = this.f34223d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = this.f34223d.keyAt(i16);
            bundleArr[i16] = this.f34223d.valueAt(i16);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f34223d = new SimpleArrayMap<>();
    }

    ExtendableSavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f34223d = new SimpleArrayMap<>(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.f34223d.put(strArr[i3], bundleArr[i3]);
        }
    }
}
