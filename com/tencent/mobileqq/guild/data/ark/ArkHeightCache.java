package com.tencent.mobileqq.guild.data.ark;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ArkHeightCache implements Parcelable {
    public static final Parcelable.Creator<ArkHeightCache> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private Map<Long, Integer> f216411d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<Long, Long> f216412e = new HashMap();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<ArkHeightCache> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArkHeightCache createFromParcel(Parcel parcel) {
            ArkHeightCache arkHeightCache = new ArkHeightCache();
            arkHeightCache.c(parcel.readHashMap(HashMap.class.getClassLoader()));
            arkHeightCache.e(parcel.readHashMap(HashMap.class.getClassLoader()));
            return arkHeightCache;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArkHeightCache[] newArray(int i3) {
            return new ArkHeightCache[i3];
        }
    }

    public Map<Long, Integer> a() {
        return this.f216411d;
    }

    public Map<Long, Long> b() {
        return this.f216412e;
    }

    public void c(Map<Long, Integer> map) {
        this.f216411d = new HashMap(map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(Map<Long, Long> map) {
        this.f216412e = map;
    }

    public String toString() {
        return "ArkHeightCache{heightCache = " + this.f216411d + ", msgIdCache = " + this.f216412e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.f216411d);
        parcel.writeMap(this.f216412e);
    }
}
