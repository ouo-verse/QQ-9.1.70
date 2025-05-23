package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.update.sign.MD5;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class UpdateBase implements HippyQQFileUtil.DownLoadCallBack {
    private static final String TAG = "UpdateBase";
    protected String mMd5;
    protected String mModule;
    protected String mModuleFilePath;
    protected String mPatchMd5;
    protected PackageUpdateListener mUpdateListener;
    protected String mUrl;
    protected int mVersion;

    public UpdateBase(String str, String str2, String str3, String str4, int i3, PackageUpdateListener packageUpdateListener) {
        this.mUrl = str;
        this.mMd5 = str2;
        this.mPatchMd5 = str3;
        this.mModule = str4;
        this.mVersion = i3;
        this.mUpdateListener = packageUpdateListener;
    }

    public static void checkAndResetLocalVersion(String str, int i3) {
        int moduleVersion = UpdateSetting.getInstance().getModuleVersion(str);
        if (moduleVersion > 0 && moduleVersion < i3) {
            HippyQQFileUtil.cleanHistoryVersion(str, moduleVersion);
        }
        UpdateSetting.getInstance().setModuleVersion(str, i3);
    }

    void doAfterDownLoadBusiness(File file) {
        int i3;
        if (TextUtils.equals(MD5.getFileMd5(file.getAbsolutePath()), this.mMd5)) {
            if (patch(file)) {
                if (unzipFile(file)) {
                    checkAndResetLocalVersion(this.mModule, this.mVersion);
                    i3 = 0;
                } else {
                    i3 = -1;
                }
            } else {
                i3 = -2;
            }
        } else {
            i3 = -3;
        }
        PackageUpdateListener packageUpdateListener = this.mUpdateListener;
        if (packageUpdateListener != null) {
            packageUpdateListener.onUpdateComplete(i3, "", this.mModuleFilePath);
        }
    }

    abstract boolean isPatchEnable();

    @Override // com.tencent.hippy.qq.update.HippyQQFileUtil.DownLoadCallBack
    public void onDownloadResult(int i3, File file) {
        if (i3 == 0) {
            doAfterDownLoadBusiness(file);
            return;
        }
        if (this.mUpdateListener != null) {
            this.mUpdateListener.onUpdateComplete(-4, "download result: " + i3, this.mModuleFilePath);
        }
    }

    abstract boolean patch(File file);

    public void startDownload() {
        File zipFile;
        try {
            if (isPatchEnable()) {
                zipFile = HippyQQFileUtil.getDiffFile(this.mModule, this.mVersion);
            } else {
                zipFile = HippyQQFileUtil.getZipFile(this.mModule, this.mVersion);
            }
            HippyQQFileUtil.downLoad(this.mUrl, zipFile, this);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    abstract boolean unzipFile(File file);
}
