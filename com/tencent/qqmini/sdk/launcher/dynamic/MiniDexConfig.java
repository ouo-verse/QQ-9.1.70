package com.tencent.qqmini.sdk.launcher.dynamic;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.SharedPreferencesUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniDexConfig implements Parcelable {
    public static final Parcelable.Creator<MiniDexConfig> CREATOR = new Parcelable.Creator<MiniDexConfig>() { // from class: com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniDexConfig createFromParcel(Parcel parcel) {
            return new MiniDexConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniDexConfig[] newArray(int i3) {
            return new MiniDexConfig[i3];
        }
    };
    private static String DEX_FOLDER = null;
    private static final String TAG = "minisdk-MiniAppDexLoader_DexConfig";
    public String currPlatformVersion;
    public String dexUrl;
    public String md5;
    public String minBaselibVersion;
    public String platformVersion;

    public MiniDexConfig() {
    }

    public static MiniDexConfig convertFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app_version");
            String optString2 = jSONObject.optString("ver");
            String optString3 = jSONObject.optString("minjs");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("md5");
            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4)) {
                MiniDexConfig miniDexConfig = new MiniDexConfig();
                miniDexConfig.currPlatformVersion = optString;
                miniDexConfig.platformVersion = optString2;
                miniDexConfig.minBaselibVersion = optString3;
                miniDexConfig.dexUrl = optString4;
                miniDexConfig.md5 = optString5;
                return miniDexConfig;
            }
            QMLog.e(TAG, "dex config is invalid because of platformVersion or url is empty.");
            return null;
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            return null;
        }
    }

    public static String getDexFolder() {
        if (TextUtils.isEmpty(DEX_FOLDER)) {
            DEX_FOLDER = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/dex/";
        }
        return DEX_FOLDER;
    }

    public static MiniDexConfig getValidDexConfig(String str) {
        QMLog.i(TAG, "dex config: " + str);
        MiniDexConfig convertFrom = convertFrom(str);
        if (convertFrom != null && convertFrom.verifyDex()) {
            return convertFrom;
        }
        return null;
    }

    public void addCrashInfo() {
        try {
            if (TextUtils.isEmpty(this.dexUrl)) {
                return;
            }
            String string = SharedPreferencesUtil.getPreference().getString("dexcrash", "");
            QMLog.i(TAG, "add crash info. dexUrl:" + this.dexUrl + " dexCrashInfo:" + string);
            String[] split = string.split(";");
            if (split.length == 3 && this.dexUrl.equals(split[0])) {
                int parseInt = Integer.parseInt(split[1]);
                if (System.currentTimeMillis() - Long.parseLong(split[2]) <= 7200000) {
                    int i3 = parseInt + 1;
                    QMLog.i(TAG, "add crash count " + i3);
                    SharedPreferencesUtil.getPreference().edit().putString("dexcrash", this.dexUrl + ";" + i3 + ";" + System.currentTimeMillis()).commit();
                }
            } else {
                SharedPreferencesUtil.getPreference().edit().putString("dexcrash", this.dexUrl + ";1;" + System.currentTimeMillis()).commit();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDexCrashCount() {
        int i3;
        try {
            if (TextUtils.isEmpty(this.dexUrl)) {
                return 0;
            }
            String[] split = SharedPreferencesUtil.getPreference().getString("dexcrash", "").split(";");
            if (split.length == 3 && this.dexUrl.equals(split[0])) {
                i3 = Integer.parseInt(split[1]);
            } else {
                i3 = 0;
            }
            QMLog.i(TAG, "get crash count=" + i3 + " dexUrl:" + this.dexUrl);
            return i3;
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            return 0;
        }
    }

    public String getDexPath() {
        if (TextUtils.isEmpty(this.dexUrl)) {
            QMLog.e(TAG, "dex url is null.");
            return null;
        }
        return getDexFolder() + this.dexUrl.hashCode() + QZonePatchService.PATCH_SUFFIX;
    }

    public boolean isDexDownloaded() {
        String dexPath = getDexPath();
        if (!TextUtils.isEmpty(dexPath) && new File(dexPath).exists()) {
            if (!TextUtils.isEmpty(this.md5)) {
                String encodeFileHexStr = MD5Utils.encodeFileHexStr(dexPath);
                if (TextUtils.isEmpty(encodeFileHexStr) || !this.md5.toLowerCase().equals(encodeFileHexStr.toLowerCase())) {
                    QMLog.e(TAG, "md5 is wrong! configMD5=" + this.md5 + " fileMD5=" + encodeFileHexStr);
                    return false;
                }
                return true;
            }
            return true;
        }
        QMLog.e(TAG, "dex file is not exist.");
        return false;
    }

    public boolean verifyDex() {
        if (TextUtils.isEmpty(this.currPlatformVersion)) {
            QMLog.e(TAG, "dex is invalid because of currPlatformVersion is empty.");
            return false;
        }
        if (TextUtils.isEmpty(this.platformVersion)) {
            QMLog.e(TAG, "dex is invalid because of platformVersion is empty.");
            return false;
        }
        try {
            String str = this.currPlatformVersion;
            if (!this.platformVersion.equals(str)) {
                QMLog.e(TAG, "platformVersion is not match. platformVersion=" + this.platformVersion + " currQUA=" + str);
                return false;
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
        if (TextUtils.isEmpty(this.minBaselibVersion)) {
            String string = StorageUtil.getPreference().getString("version", "1.74.3.00001");
            if (BaseLibInfo.needUpdateVersion(this.minBaselibVersion, string)) {
                QMLog.e(TAG, "baselib version is not match. minBaselibVersion=" + this.platformVersion + " currBaselibVersion=" + string);
                return false;
            }
        }
        if (TextUtils.isEmpty(this.dexUrl)) {
            QMLog.e(TAG, "dex url is empty.");
            return true;
        }
        if (!isDexDownloaded()) {
            return false;
        }
        if (getDexCrashCount() < 3) {
            return true;
        }
        QMLog.e(TAG, "dex is invalid because of too many crashes!");
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.platformVersion);
        parcel.writeString(this.minBaselibVersion);
        parcel.writeString(this.dexUrl);
        parcel.writeString(this.md5);
    }

    protected MiniDexConfig(Parcel parcel) {
        this.platformVersion = parcel.readString();
        this.minBaselibVersion = parcel.readString();
        this.dexUrl = parcel.readString();
        this.md5 = parcel.readString();
    }
}
