package com.tencent.mobileqq.guild.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class IpcArguments implements Parcelable {
    public static final Parcelable.Creator<IpcArguments> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<Object> f226301d;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<IpcArguments> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IpcArguments createFromParcel(Parcel parcel) {
            return new IpcArguments(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IpcArguments[] newArray(int i3) {
            return new IpcArguments[i3];
        }
    }

    public IpcArguments() {
        this.f226301d = new ArrayList<>();
    }

    public Object[] a() {
        return this.f226301d.toArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.f226301d);
    }

    public IpcArguments(Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        this.f226301d = arrayList;
        Collections.addAll(arrayList, objArr);
    }

    protected IpcArguments(Parcel parcel) {
        ArrayList<Object> arrayList = new ArrayList<>();
        this.f226301d = arrayList;
        parcel.readList(arrayList, MobileQQ.sMobileQQ.getClassLoader());
    }
}
