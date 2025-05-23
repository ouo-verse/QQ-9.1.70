package com.tencent.open.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import tencent.im.oidb.qqconnect$Appinfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f341669d;

    /* renamed from: e, reason: collision with root package name */
    private int f341670e;

    /* renamed from: f, reason: collision with root package name */
    private String f341671f;

    /* renamed from: h, reason: collision with root package name */
    private String f341672h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f341673i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f341674m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<AppInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppInfo[] newArray(int i3) {
            return new AppInfo[i3];
        }
    }

    public AppInfo(int i3, String str, String str2) {
        this.f341670e = -1;
        this.f341673i = false;
        this.f341674m = false;
        this.f341669d = i3;
        this.f341671f = str;
        this.f341672h = str2;
    }

    public boolean a() {
        return this.f341673i;
    }

    public String b() {
        return this.f341672h;
    }

    public int c() {
        return this.f341669d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f341671f;
    }

    public String f() {
        int i3 = this.f341670e;
        if (i3 == 100) {
            return "";
        }
        switch (i3) {
            case 0:
                return HardCodeUtil.qqStr(R.string.jnr);
            case 1:
                return HardCodeUtil.qqStr(R.string.jnt);
            case 2:
                return HardCodeUtil.qqStr(R.string.f211665lf);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "";
            default:
                return HardCodeUtil.qqStr(R.string.jns);
        }
    }

    public boolean g() {
        return this.f341674m;
    }

    public void j(boolean z16) {
        this.f341673i = z16;
    }

    public String toString() {
        return "AppInfo{mId=" + this.f341669d + ", mName='" + this.f341671f + "', type='" + f() + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f341669d);
        parcel.writeInt(this.f341670e);
        parcel.writeString(this.f341671f);
        parcel.writeString(this.f341672h);
        parcel.writeByte(this.f341673i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f341674m ? (byte) 1 : (byte) 0);
    }

    public AppInfo(qqconnect$Appinfo qqconnect_appinfo) {
        this.f341669d = -1;
        this.f341670e = -1;
        this.f341671f = "";
        this.f341672h = "";
        this.f341673i = false;
        this.f341674m = false;
        if (qqconnect_appinfo.appid.has()) {
            this.f341669d = qqconnect_appinfo.appid.get();
        }
        if (qqconnect_appinfo.app_name.has()) {
            this.f341671f = qqconnect_appinfo.app_name.get();
        }
        if (qqconnect_appinfo.app_type.has()) {
            this.f341670e = qqconnect_appinfo.app_type.get();
        }
        if (qqconnect_appinfo.icon_url.has()) {
            this.f341672h = qqconnect_appinfo.icon_url.get();
        }
        if (qqconnect_appinfo.mobile_app_info.has() && qqconnect_appinfo.mobile_app_info.is_high_quality_game.has()) {
            this.f341674m = qqconnect_appinfo.mobile_app_info.is_high_quality_game.get();
        }
    }

    protected AppInfo(Parcel parcel) {
        this.f341669d = -1;
        this.f341670e = -1;
        this.f341671f = "";
        this.f341672h = "";
        this.f341673i = false;
        this.f341674m = false;
        this.f341669d = parcel.readInt();
        this.f341670e = parcel.readInt();
        this.f341671f = parcel.readString();
        this.f341672h = parcel.readString();
        this.f341673i = parcel.readByte() != 0;
        this.f341674m = parcel.readByte() != 0;
    }
}
