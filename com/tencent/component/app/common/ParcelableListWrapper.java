package com.tencent.component.app.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ParcelableListWrapper implements Parcelable {
    public static final int POOL_SIZE = 5;
    private ArrayList parcelableList;
    private static ParcelableListWrapper[] sOwnedPool = new ParcelableListWrapper[5];
    public static final Parcelable.Creator<ParcelableListWrapper> CREATOR = new Parcelable.Creator<ParcelableListWrapper>() { // from class: com.tencent.component.app.common.ParcelableListWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableListWrapper[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableListWrapper createFromParcel(Parcel parcel) {
            ArrayList<? extends SmartParcelable> readArrayList = ParcelableListWrapper.readArrayList(parcel, getClass().getClassLoader());
            if (readArrayList != null) {
                return new ParcelableListWrapper(readArrayList);
            }
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableListWrapper(ArrayList<? extends SmartParcelable> arrayList) {
        this.parcelableList = arrayList;
    }

    public static ParcelableListWrapper obtain(ArrayList<? extends SmartParcelable> arrayList) {
        ParcelableListWrapper[] parcelableListWrapperArr = sOwnedPool;
        synchronized (parcelableListWrapperArr) {
            for (int i3 = 0; i3 < 5; i3++) {
                ParcelableListWrapper parcelableListWrapper = parcelableListWrapperArr[i3];
                if (parcelableListWrapper != null) {
                    parcelableListWrapperArr[i3] = null;
                    parcelableListWrapper.parcelableList = arrayList;
                    return parcelableListWrapper;
                }
            }
            return new ParcelableListWrapper(arrayList);
        }
    }

    public static ArrayList<? extends SmartParcelable> readArrayList(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList<? extends SmartParcelable> arrayList = new ArrayList<>(readInt);
        readListInternal(parcel, arrayList, readInt, classLoader);
        return arrayList;
    }

    private static void readListInternal(Parcel parcel, List list, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            list.add(((ParcelableWrapper) parcel.readValue(classLoader)).getData());
            i3--;
        }
    }

    public static void recycle(ParcelableListWrapper parcelableListWrapper) {
        ParcelableListWrapper[] parcelableListWrapperArr = sOwnedPool;
        synchronized (parcelableListWrapperArr) {
            for (int i3 = 0; i3 < 5; i3++) {
                if (parcelableListWrapperArr[i3] == null) {
                    parcelableListWrapperArr[i3] = parcelableListWrapper;
                    return;
                }
            }
        }
    }

    public static void writeList(Parcel parcel, List<? extends SmartParcelable> list) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            ParcelableWrapper obtain = ParcelableWrapper.obtain(list.get(i3));
            parcel.writeValue(obtain);
            ParcelableWrapper.recycle(obtain);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends SmartParcelable> ArrayList<T> getParcelableList() {
        return this.parcelableList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        writeList(parcel, this.parcelableList);
    }
}
