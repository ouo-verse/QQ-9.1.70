package com.tencent.luggage.wxa.x3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f144562a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i3 = 0; i3 != readInt; i3++) {
                arrayList.add(c.CREATOR.createFromParcel(parcel));
            }
            return new d(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(ArrayList list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f144562a = list;
    }

    public final ArrayList a() {
        return this.f144562a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof d) && Intrinsics.areEqual(this.f144562a, ((d) obj).f144562a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f144562a.hashCode();
    }

    public String toString() {
        return "ReportLogDataList(list=" + this.f144562a + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        ArrayList arrayList = this.f144562a;
        out.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).writeToParcel(out, i3);
        }
    }
}
