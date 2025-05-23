package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.mc.j;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes9.dex */
public class WxaPluginPkgInfo implements Parcelable, j {
    public static final Parcelable.Creator<WxaPluginPkgInfo> CREATOR = new a();
    public static final String PREFIX_EXTENDED = "__extended__/";
    public static final String PREFIX_NORMAL = "__plugin__/";
    public List<Integer> contexts;
    public String md5;
    public volatile String pkgPath;
    public String prefixPath;
    public String provider;
    public String stringVersion;
    public int version;

    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxaPluginPkgInfo createFromParcel(Parcel parcel) {
            return new WxaPluginPkgInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxaPluginPkgInfo[] newArray(int i3) {
            return new WxaPluginPkgInfo[i3];
        }
    }

    public /* synthetic */ WxaPluginPkgInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public void assignFrom(WxaPluginPkgInfo wxaPluginPkgInfo) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPluginPkgInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
    }

    public String checksumMd5() {
        return this.md5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isAssignable(WxaPluginPkgInfo wxaPluginPkgInfo) {
        return this.provider.equals(wxaPluginPkgInfo.provider);
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public long lastModified() {
        if (x.d(this.pkgPath)) {
            return x.f(this.pkgPath);
        }
        return 0L;
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public String pkgPath() {
        return this.pkgPath;
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public int pkgVersion() {
        return this.version;
    }

    public void readFromParcel(Parcel parcel) {
        this.pkgPath = parcel.readString();
        this.provider = parcel.readString();
        this.version = parcel.readInt();
        this.md5 = parcel.readString();
        this.prefixPath = parcel.readString();
        this.stringVersion = parcel.readString();
        if (this.contexts == null) {
            this.contexts = new LinkedList();
        }
        parcel.readList(this.contexts, Integer.class.getClassLoader());
    }

    public String toString() {
        return "WxaPluginPkgInfo{pkgPath='" + this.pkgPath + "', provider='" + this.provider + "', version=" + this.version + ", md5='" + this.md5 + "', prefixPath='" + this.prefixPath + "', stringVersion='" + this.stringVersion + "', contexts=" + this.contexts + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.pkgPath);
        parcel.writeString(this.provider);
        parcel.writeInt(this.version);
        parcel.writeString(this.md5);
        parcel.writeString(this.prefixPath);
        parcel.writeString(this.stringVersion);
        parcel.writeList(this.contexts);
    }

    public WxaPluginPkgInfo() {
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WxaPluginPkgInfo m164clone() {
        WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
        wxaPluginPkgInfo.assignFrom(this);
        return wxaPluginPkgInfo;
    }

    WxaPluginPkgInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
