package com.tencent.mobileqq.minigame.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InstalledEngine implements Comparable<InstalledEngine>, Parcelable {
    public static final Parcelable.Creator<InstalledEngine> CREATOR = new Parcelable.Creator<InstalledEngine>() { // from class: com.tencent.mobileqq.minigame.manager.InstalledEngine.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledEngine createFromParcel(Parcel parcel) {
            InstalledEngine installedEngine = new InstalledEngine();
            installedEngine.engineName = parcel.readString();
            installedEngine.engineDir = parcel.readString();
            installedEngine.engineVersion = (EngineVersion) parcel.readParcelable(EngineVersion.class.getClassLoader());
            installedEngine.engineType = parcel.readInt();
            installedEngine.isVerify = parcel.readByte() != 0;
            installedEngine.isPersist = parcel.readByte() != 0;
            installedEngine.loadStatus = parcel.readInt();
            return installedEngine;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InstalledEngine[] newArray(int i3) {
            return new InstalledEngine[i3];
        }
    };
    public static final String LOG_TAG = "InstalledEngine";
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_LOAD_FAILED = 2;
    public static final int STATUS_LOAD_SUCC = 3;
    public String engineDir;
    public String engineName;
    public int engineType;
    public EngineVersion engineVersion;
    public boolean isPersist;
    public boolean isVerify;
    public volatile int loadStatus = 1;

    @Deprecated
    public void deleteFiles() {
        if (!TextUtils.isEmpty(this.engineDir)) {
            FileUtils.delete(this.engineDir, false);
            EngineInstaller.getSp().edit().remove(this.engineDir).apply();
        }
        QLog.i("InstalledEngine", 1, "[MiniEng] delete engine " + this + ", pName=" + BaseApplicationImpl.getApplication().getQQProcessName());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isLoadSuccess() {
        return this.loadStatus == 3;
    }

    public String toString() {
        return "InstalledEngine{engineDir=" + this.engineDir + ", engineName=" + this.engineName + ", engineVersion=" + this.engineVersion + ", engineType=" + this.engineType + ", isVerify=" + this.isVerify + ", isPersist=" + this.isPersist + ", loadStatus=" + this.loadStatus + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.engineName);
        parcel.writeString(this.engineDir);
        parcel.writeParcelable(this.engineVersion, 0);
        parcel.writeInt(this.engineType);
        parcel.writeByte(this.isVerify ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isPersist ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.loadStatus);
    }

    @Override // java.lang.Comparable
    public int compareTo(InstalledEngine installedEngine) {
        return this.engineVersion.compareTo(installedEngine.engineVersion);
    }
}
