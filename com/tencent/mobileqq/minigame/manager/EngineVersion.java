package com.tencent.mobileqq.minigame.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EngineVersion implements Comparable<EngineVersion>, Parcelable {
    public static final Parcelable.Creator<EngineVersion> CREATOR = new Parcelable.Creator<EngineVersion>() { // from class: com.tencent.mobileqq.minigame.manager.EngineVersion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EngineVersion createFromParcel(Parcel parcel) {
            EngineVersion engineVersion = new EngineVersion();
            engineVersion.mMajor = parcel.readString();
            engineVersion.mMinor = parcel.readString();
            return engineVersion;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EngineVersion[] newArray(int i3) {
            return new EngineVersion[i3];
        }
    };
    public static final String LOG_TAG = "EngineVersion";
    public static final String SEP = "_";
    public String mMajor;
    public String mMinor;

    public EngineVersion() {
    }

    public static int compareVersion(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i3 = 0;
        for (int i16 = 0; i16 < min; i16++) {
            i3 = split[i16].length() - split2[i16].length();
            if (i3 != 0 || (i3 = split[i16].compareTo(split2[i16])) != 0) {
                break;
            }
        }
        return i3 != 0 ? i3 : split.length - split2.length;
    }

    public static EngineVersion fromFolderName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("_");
        if (split.length > 1) {
            return new EngineVersion(split[0], split[1]);
        }
        return null;
    }

    public static String toFolderName(EngineVersion engineVersion) {
        return engineVersion.mMajor + "_" + engineVersion.mMinor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (this.mMajor.hashCode() * 31) + this.mMinor.hashCode();
    }

    public String toString() {
        return "EngineVersion{mMajor=" + this.mMajor + ",mMinor=" + this.mMinor + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mMajor);
        parcel.writeString(this.mMinor);
    }

    public EngineVersion(String str, String str2) {
        this.mMajor = str;
        this.mMinor = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(EngineVersion engineVersion) {
        try {
            int compareVersion = compareVersion(this.mMajor, engineVersion.mMajor);
            return compareVersion == 0 ? compareVersion(this.mMinor, engineVersion.mMinor) : compareVersion;
        } catch (Exception e16) {
            QLog.e("EngineVersion", 1, "[MiniEng] compare error " + DebugUtil.getPrintableStackTrace(e16));
            return 0;
        }
    }

    public String toFolderName() {
        return toFolderName(this);
    }

    public EngineVersion(String str) {
        this.mMajor = AppSetting.f99551k + "." + AppSetting.f99542b;
        this.mMinor = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EngineVersion engineVersion = (EngineVersion) obj;
        if (this.mMajor.equals(engineVersion.mMajor)) {
            return this.mMinor.equals(engineVersion.mMinor);
        }
        return false;
    }
}
