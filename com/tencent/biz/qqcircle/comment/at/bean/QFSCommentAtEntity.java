package com.tencent.biz.qqcircle.comment.at.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAtEntity extends HostSelectMemberUtils.QCircleResultData implements Parcelable {
    public static final Parcelable.Creator<QFSCommentAtEntity> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f83501d;

    /* renamed from: e, reason: collision with root package name */
    private int f83502e;

    /* renamed from: f, reason: collision with root package name */
    private long f83503f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<QFSCommentAtEntity> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QFSCommentAtEntity createFromParcel(Parcel parcel) {
            return new QFSCommentAtEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QFSCommentAtEntity[] newArray(int i3) {
            return new QFSCommentAtEntity[i3];
        }
    }

    public QFSCommentAtEntity(String str, String str2, String str3, int i3) {
        this(str, str2, str3, i3, 0);
    }

    public int a() {
        return this.f83502e;
    }

    public String b() {
        return this.name;
    }

    public long c() {
        return this.f83503f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.uin;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return TextUtils.equals(this.uin, ((QFSCommentAtEntity) obj).uin);
        }
        return false;
    }

    public int f() {
        return this.uinType;
    }

    public String g() {
        return this.f83501d;
    }

    public int hashCode() {
        int i3;
        String str = this.uin;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i3 * 31;
    }

    public void j(long j3) {
        this.f83503f = j3;
    }

    public String toString() {
        return "QFSCommentAtEntity{mUrl='" + this.f83501d + "', mAuthType=" + this.f83502e + ", mTimestamp=" + this.f83503f + "} " + super.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uin);
        parcel.writeString(this.name);
        parcel.writeInt(this.uinType);
        parcel.writeString(this.f83501d);
        parcel.writeInt(this.f83502e);
        parcel.writeLong(this.f83503f);
    }

    public QFSCommentAtEntity(String str, String str2, String str3, int i3, int i16) {
        this.f83503f = System.currentTimeMillis();
        this.uin = str;
        this.name = str3;
        this.f83501d = str2;
        this.f83502e = i3;
        this.uinType = i16;
    }

    protected QFSCommentAtEntity(Parcel parcel) {
        this.f83503f = System.currentTimeMillis();
        this.uin = parcel.readString();
        this.name = parcel.readString();
        this.uinType = parcel.readInt();
        this.f83501d = parcel.readString();
        this.f83502e = parcel.readInt();
        this.f83503f = parcel.readLong();
    }
}
