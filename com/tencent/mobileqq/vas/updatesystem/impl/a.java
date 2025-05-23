package com.tencent.mobileqq.vas.updatesystem.impl;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasSafeUnzip;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements sw4.b {
    @Override // sw4.b
    public long a() {
        return NetConnInfoCenter.getServerTime();
    }

    @Override // sw4.b
    public String b() {
        return VasTempConstant.ENGINE_CONFIG_PATH;
    }

    @Override // sw4.b
    public boolean c(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return FileUtils.copyFile(file, FileUtils.createFile(str2));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return false;
    }

    @Override // sw4.b
    public long d() {
        return 500L;
    }

    @Override // sw4.b
    public String e() {
        return com.tencent.mobileqq.vas.api.g.f308459b.getReportVersionName();
    }

    @Override // sw4.b
    public String f(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip: type = " + i3 + " srcFile = " + str);
        }
        if (i3 != 1) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip file un exist");
            return null;
        }
        String safeUnZipFile = VasSafeUnzip.safeUnZipFile(file, qw4.a.f430261e);
        if (safeUnZipFile != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip result = " + safeUnZipFile);
            }
            return safeUnZipFile;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VasUpdate_CommonManagerImpl", 2, "uncompressZip fail");
        }
        return null;
    }

    @Override // sw4.b
    public boolean g(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_CommonManagerImpl", 2, "bsPatch: srcFile = " + str + " patchFile = " + str2);
        }
        return ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).patch(str, str2, str);
    }

    @Override // sw4.b
    public String getAppVersion() {
        return com.tencent.mobileqq.vas.api.g.f308459b.getSubVersion();
    }

    @Override // sw4.b
    public Context getApplicationContext() {
        return BaseApplication.getContext();
    }

    @Override // sw4.b
    public String getFileMd5(String str) {
        return MD5Utils.encodeFileHexStr(str);
    }

    @Override // sw4.b
    public int getNetType() {
        VasCommonUtils vasCommonUtils = VasCommonUtils.INSTANCE;
        int netWorkType = vasCommonUtils.getNetWorkType();
        int i3 = 1;
        if (netWorkType != 0) {
            if (netWorkType != 1) {
                i3 = 5;
                if (netWorkType != 2) {
                    if (netWorkType != 3) {
                        if (netWorkType != 4) {
                            if (netWorkType != 5) {
                                i3 = 0;
                            }
                        } else {
                            i3 = 3;
                        }
                    } else {
                        i3 = 4;
                    }
                }
            }
            i3 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_CommonManagerImpl", 2, "getNetType netType = " + i3 + " local = " + vasCommonUtils.getNetWorkType());
        }
        return i3;
    }
}
