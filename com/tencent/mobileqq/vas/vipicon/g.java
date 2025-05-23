package com.tencent.mobileqq.vas.vipicon;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g extends QQVasUpdateBusiness {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f311336a = ar.a("lianfang", "2025-03-27", "vas_new_standard_scid").isEnable(true);

    private String e(long j3, String str, String str2) {
        boolean z16;
        if (j3 == 0) {
            j3 = 20712;
        }
        if (j3 > 20712 && f311336a) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            str = str2;
        }
        return String.format(str, Long.valueOf(j3));
    }

    private String f(long j3) {
        return e(j3, "namePlate.%d.zip", "newStandard202503.namePlate.%d.zip");
    }

    private String g(long j3) {
        return e(j3, "namePlate.%d.avif.zip", "newStandard202503.namePlate.%d.avif.zip");
    }

    public static boolean i() {
        ToggleProxy toggleProxy = VasNtToggle.FEATURE_AVIF;
        if (toggleProxy.isEnable(true) && Build.VERSION.SDK_INT >= Integer.parseInt(toggleProxy.getStringData("0"))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 34L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "namePlate_dir";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "NamePlateBusiness";
    }

    @NotNull
    public String h(long j3, int i3, int i16, boolean z16) {
        String str;
        String str2 = "_grey";
        if (i()) {
            String savePath = getSavePath(g(j3));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("/");
            sb5.append(i16);
            if (z16) {
                str = "_grey";
            } else {
                str = "";
            }
            sb5.append(str);
            sb5.append(BasePicDownloadProcessor.AVIF_FILE_SUFFIX);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(i3);
            sb7.append("/");
            sb7.append(i16);
            if (!z16) {
                str2 = "";
            }
            sb7.append(str2);
            sb7.append(".png");
            String sb8 = sb7.toString();
            File file = new File(savePath, sb6);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            File file2 = new File(savePath, sb8);
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            return new File(getSavePath(f(j3)), sb8).getAbsolutePath();
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(getSavePath(f(j3)));
        sb9.append("/");
        sb9.append(i3);
        sb9.append("/");
        sb9.append(i16);
        if (!z16) {
            str2 = "";
        }
        sb9.append(str2);
        sb9.append(".png");
        return sb9.toString();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int i3) {
        if (i()) {
            long j3 = i3;
            if (isFileExist(g(j3)) && !isDownloadingOrUnpacking(g(j3))) {
                return true;
            }
            if (isFileExist(f(j3)) && !isDownloadingOrUnpacking(f(j3))) {
                return true;
            }
            return false;
        }
        long j16 = i3;
        if (isFileExist(f(j16)) && !isDownloadingOrUnpacking(f(j16))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        int i3;
        QLog.e("VasUpdate_VipIconDownloadBusiness", 1, "onLoadFail errorCode=" + updateListenerParams.mErrorCode + " httpCode=" + updateListenerParams.mHttpCode + " errorMessage=" + updateListenerParams.mErrorMessage + " scid=" + updateListenerParams.mBusinessUpdateParams.mScid);
        if (updateListenerParams.mBusinessUpdateParams.mScid.endsWith("avif.zip") && ((i3 = updateListenerParams.mErrorCode) == 24 || i3 == 4)) {
            String replace = updateListenerParams.mBusinessUpdateParams.mScid.replace(BasePicDownloadProcessor.AVIF_FILE_SUFFIX, "");
            QLog.i("VasUpdate_VipIconDownloadBusiness", 2, "\u8bf7\u6c42avif=" + updateListenerParams.mBusinessUpdateParams.mScid + "\u5931\u8d25\uff0c\u5c1d\u8bd5\u8bf7\u6c42png=" + replace);
            startDownload(replace);
            return;
        }
        super.onLoadFail(updateListenerParams);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        try {
            if (QQVasUpdateBusiness.fixBugs122584537) {
                if (!this.downloadedStatus.contains(updateListenerParams.mBusinessUpdateParams.mScid)) {
                    this.downloadedStatus.add(updateListenerParams.mBusinessUpdateParams.mScid);
                }
            } else {
                this.downloadedStatus.add(updateListenerParams.mBusinessUpdateParams.mScid);
            }
            BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
            businessUpdateParams.mScid = businessUpdateParams.mScid.split("\\.")[1];
        } catch (Exception unused) {
        }
        super.onLoadSuccess(updateListenerParams);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int i3) {
        if (i()) {
            startDownload(g(i3));
        } else {
            startDownload(f(i3));
        }
    }
}
