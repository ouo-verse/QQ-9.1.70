package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aacu;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new aab();
    private String appId;
    private final String detailsUrl;
    private final String domainName;
    private final String packageName;
    private final String version;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<AppInfo> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AppInfo[] newArray(int i3) {
            return new AppInfo[i3];
        }
    }

    protected AppInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.domainName = parcel.readString();
        this.version = parcel.readString();
        this.detailsUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        if (Objects.equals(this.packageName, appInfo.packageName) && Objects.equals(this.domainName, appInfo.domainName) && Objects.equals(this.version, appInfo.version) && Objects.equals(this.detailsUrl, appInfo.detailsUrl)) {
            return true;
        }
        return false;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDetailsUrl() {
        return this.detailsUrl;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Objects.hash(this.packageName, this.domainName, this.version, this.detailsUrl);
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("AppInfo{");
        if (this.packageName != null) {
            sb5.append(":");
            sb5.append(this.packageName);
        }
        if (this.domainName != null) {
            sb5.append(":");
            sb5.append(this.domainName);
        }
        if (this.version != null) {
            sb5.append(":");
            sb5.append(this.version);
        }
        if (this.detailsUrl != null) {
            sb5.append(":");
            sb5.append(this.detailsUrl);
        }
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(getPackageName());
        parcel.writeString(getDomainName());
        parcel.writeString(getVersion());
        parcel.writeString(getDetailsUrl());
    }

    public AppInfo(String str, String str2, String str3, String str4) {
        Preconditions.checkArgument(str == null || aacu.aabc(str), "PackageName Length Is Illegal!");
        this.packageName = str;
        this.domainName = str2;
        this.version = str3;
        this.detailsUrl = str4;
    }
}
