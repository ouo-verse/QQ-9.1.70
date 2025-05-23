package com.tencent.biz.qqcircle.immersive.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchInfo implements Parcelable {
    public static final Parcelable.Creator<QFSSearchInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f84909d;

    /* renamed from: e, reason: collision with root package name */
    private int f84910e;

    /* renamed from: f, reason: collision with root package name */
    private String f84911f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f84912h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f84913i = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final List<FeedCloudCommon$Entry> f84914m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<QFSSearchInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QFSSearchInfo createFromParcel(Parcel parcel) {
            return new QFSSearchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QFSSearchInfo[] newArray(int i3) {
            return new QFSSearchInfo[i3];
        }
    }

    public QFSSearchInfo() {
    }

    private void l() {
        this.f84911f = HostDataTransUtils.getAccount() + "_" + System.currentTimeMillis();
    }

    public void a(List<FeedCloudCommon$Entry> list) {
        this.f84914m.addAll(list);
    }

    public ConcurrentHashMap b() {
        return this.f84913i;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f84911f)) {
            return "";
        }
        return this.f84911f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f84910e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QFSSearchInfo qFSSearchInfo = (QFSSearchInfo) obj;
        if (this.f84910e == qFSSearchInfo.f84910e && this.f84912h == qFSSearchInfo.f84912h && Objects.equals(this.f84909d, qFSSearchInfo.f84909d)) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f84909d;
    }

    public List<FeedCloudCommon$Entry> g() {
        return this.f84914m;
    }

    public int hashCode() {
        return Objects.hash(this.f84909d, Integer.valueOf(this.f84910e));
    }

    public void j(int i3) {
        this.f84910e = i3;
    }

    public void k(String str) {
        this.f84909d = str;
        l();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f84909d);
        parcel.writeInt(this.f84910e);
        parcel.writeByte(this.f84912h ? (byte) 1 : (byte) 0);
    }

    protected QFSSearchInfo(Parcel parcel) {
        this.f84909d = parcel.readString();
        this.f84910e = parcel.readInt();
        this.f84912h = parcel.readByte() != 0;
    }
}
