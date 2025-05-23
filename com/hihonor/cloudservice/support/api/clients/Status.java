package com.hihonor.cloudservice.support.api.clients;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Status implements Parcelable {

    /* renamed from: d, reason: collision with root package name */
    private final int f36221d;

    /* renamed from: e, reason: collision with root package name */
    private final String f36222e;

    /* renamed from: f, reason: collision with root package name */
    private final PendingIntent f36223f;

    /* renamed from: h, reason: collision with root package name */
    public static final Status f36219h = new Status(0);

    /* renamed from: i, reason: collision with root package name */
    public static final Status f36220i = new Status(1);
    public static final Parcelable.Creator<Status> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<Status> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Status[] newArray(int i3) {
            return new Status[i3];
        }
    }

    public Status(int i3) {
        this(i3, null);
    }

    private static boolean b(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public int a() {
        return this.f36221d;
    }

    public String c() {
        return this.f36222e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f36221d == status.f36221d && b(this.f36222e, status.f36222e) && b(this.f36223f, status.f36223f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36221d), this.f36222e, this.f36223f});
    }

    public String toString() {
        return "{statusCode: " + this.f36221d + ", statusMessage: " + this.f36222e + ", pendingIntent: " + this.f36223f + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36221d);
        parcel.writeString(this.f36222e);
        PendingIntent.writePendingIntentOrNullToParcel(this.f36223f, parcel);
    }

    public Status() {
        this(0);
    }

    public Status(int i3, String str) {
        this(i3, str, null);
    }

    public Status(int i3, String str, PendingIntent pendingIntent) {
        this.f36221d = i3;
        this.f36222e = str;
        this.f36223f = pendingIntent;
    }
}
