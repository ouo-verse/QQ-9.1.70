package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataQueryRequest implements Parcelable {
    public static final Parcelable.Creator<HealthDataQueryRequest> CREATOR = new a();
    public Integer C;
    public Integer D;
    public Integer E;

    /* renamed from: d, reason: collision with root package name */
    public Integer f36064d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f36065e;

    /* renamed from: f, reason: collision with root package name */
    public Long f36066f;

    /* renamed from: h, reason: collision with root package name */
    public Long f36067h;

    /* renamed from: i, reason: collision with root package name */
    public String f36068i;

    /* renamed from: m, reason: collision with root package name */
    public List<String> f36069m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthDataQueryRequest> {
        @Override // android.os.Parcelable.Creator
        public HealthDataQueryRequest createFromParcel(Parcel parcel) {
            return new HealthDataQueryRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDataQueryRequest[] newArray(int i3) {
            return new HealthDataQueryRequest[i3];
        }
    }

    public HealthDataQueryRequest() {
        this.f36064d = 0;
        this.f36065e = null;
        this.f36066f = 0L;
        this.f36067h = 0L;
        this.f36068i = null;
        this.f36069m = null;
        this.C = 0;
        this.D = -1;
        this.E = -1;
    }

    public final void a(Parcel parcel) {
        int[] createIntArray = parcel.createIntArray();
        if (createIntArray != null) {
            this.f36065e = new ArrayList();
            for (int i3 : createIntArray) {
                this.f36065e.add(Integer.valueOf(i3));
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36064d.intValue());
        List<Integer> list = this.f36065e;
        if (list != null && !list.isEmpty()) {
            int size = this.f36065e.size();
            int[] iArr = new int[size];
            for (int i16 = 0; i16 < size; i16++) {
                iArr[i16] = this.f36065e.get(i16).intValue();
            }
            parcel.writeIntArray(iArr);
        } else {
            parcel.writeIntArray(null);
        }
        parcel.writeLong(this.f36066f.longValue());
        parcel.writeLong(this.f36067h.longValue());
        parcel.writeString(this.f36068i);
        parcel.writeStringList(this.f36069m);
        parcel.writeInt(this.C.intValue());
        parcel.writeInt(this.D.intValue());
        parcel.writeInt(this.E.intValue());
    }

    public HealthDataQueryRequest(Parcel parcel) {
        this.f36064d = 0;
        this.f36065e = null;
        this.f36066f = 0L;
        this.f36067h = 0L;
        this.f36068i = null;
        this.f36069m = null;
        this.C = 0;
        this.D = -1;
        this.E = -1;
        this.f36064d = Integer.valueOf(parcel.readInt());
        a(parcel);
        this.f36066f = Long.valueOf(parcel.readLong());
        this.f36067h = Long.valueOf(parcel.readLong());
        this.f36068i = parcel.readString();
        this.f36069m = parcel.createStringArrayList();
        this.C = Integer.valueOf(parcel.readInt());
        this.D = Integer.valueOf(parcel.readInt());
        this.E = Integer.valueOf(parcel.readInt());
    }
}
