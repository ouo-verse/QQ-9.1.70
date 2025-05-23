package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QShadowLoadInfo implements Parcelable {
    public static final Parcelable.Creator<QShadowLoadInfo> CREATOR = new Parcelable.Creator<QShadowLoadInfo>() { // from class: com.tencent.shadow.dynamic.host.QShadowLoadInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QShadowLoadInfo createFromParcel(Parcel parcel) {
            return new QShadowLoadInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QShadowLoadInfo[] newArray(int i3) {
            return new QShadowLoadInfo[i3];
        }
    };
    public final long appCreateTime;
    public final long bindServiceTime;
    public final boolean isHotLaunch;
    public final long loadLoaderTime;
    public final long loadPluginTime;
    public final long loadRuntimeTime;

    public QShadowLoadInfo(long j3, long j16, long j17, long j18, long j19, boolean z16) {
        this.loadRuntimeTime = j3;
        this.loadLoaderTime = j16;
        this.loadPluginTime = j17;
        this.bindServiceTime = j18;
        this.appCreateTime = j19;
        this.isHotLaunch = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "QShadowLoadInfo{loadRuntimeTime=" + this.loadRuntimeTime + ", loadLoaderTime=" + this.loadLoaderTime + ", loadPluginTime=" + this.loadPluginTime + ", bindServiceTime=" + this.bindServiceTime + ", appCreateTime=" + this.appCreateTime + ", isHotLaunch=" + this.isHotLaunch + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.loadRuntimeTime);
        parcel.writeLong(this.loadLoaderTime);
        parcel.writeLong(this.loadPluginTime);
        parcel.writeLong(this.bindServiceTime);
        parcel.writeLong(this.appCreateTime);
        parcel.writeByte(this.isHotLaunch ? (byte) 1 : (byte) 0);
    }

    protected QShadowLoadInfo(Parcel parcel) {
        this.loadRuntimeTime = parcel.readLong();
        this.loadLoaderTime = parcel.readLong();
        this.loadPluginTime = parcel.readLong();
        this.bindServiceTime = parcel.readLong();
        this.appCreateTime = parcel.readLong();
        this.isHotLaunch = parcel.readByte() != 0;
    }
}
