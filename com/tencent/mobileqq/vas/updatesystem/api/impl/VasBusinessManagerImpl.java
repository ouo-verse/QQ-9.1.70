package com.tencent.mobileqq.vas.updatesystem.api.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.UpdateSystemFileCheck;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasBusinessManagerImpl implements IVasBusinessManager {
    private static final String TAG = "IVasBusinessManager";
    private b updateService = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        File f311151a;

        /* renamed from: b, reason: collision with root package name */
        long f311152b;

        a() {
        }

        @NonNull
        public String toString() {
            return "path[" + this.f311151a + "] size[" + (((float) (this.f311152b / 10000)) / 100.0f) + "MB]";
        }
    }

    private void cleanDir(File file, ArrayList<String> arrayList, a aVar, boolean z16) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (arrayList.contains(file2.getAbsolutePath())) {
                    if (z16) {
                        QLog.i(TAG, 1, "hold file : " + file2);
                    }
                } else {
                    try {
                        aVar.f311152b += file2.length();
                        if (z16 && !file2.delete()) {
                            QLog.i(TAG, 1, "delete error : " + file2);
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                }
            } else if (arrayList.contains(file2.getAbsolutePath()) && VasNtToggle.VAS_AIO_FONT_BUG_116794049.isEnable(true)) {
                if (z16) {
                    QLog.i(TAG, 1, "hold dir : " + file2);
                }
            } else {
                cleanDir(file2, arrayList, aVar, z16);
            }
        }
    }

    private long doCleanBusiness(QQVasUpdateBusiness qQVasUpdateBusiness, boolean z16) {
        File file = new File(qQVasUpdateBusiness.getSavePath(""));
        if (!file.exists()) {
            return 0L;
        }
        ArrayList<String> readHistory = qQVasUpdateBusiness.getReadHistory();
        a aVar = new a();
        aVar.f311151a = file;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BID[" + qQVasUpdateBusiness.getBid() + "] Read History:");
        sb5.append("\n");
        for (int i3 = 0; i3 < readHistory.size(); i3++) {
            sb5.append("- ");
            sb5.append(readHistory.get(i3));
            sb5.append("\n");
        }
        QLog.i(TAG, 1, sb5.toString());
        cleanDir(file, readHistory, aVar, z16);
        if (z16) {
            QLog.i(TAG, 1, aVar.toString());
        }
        return aVar.f311152b;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager
    public List<IBusinessCallback> getAllBusiness() {
        return this.updateService.d();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager
    public <T extends QQVasUpdateBusiness> T getBusinessInstance(Class<T> cls) {
        return (T) this.updateService.e(cls);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager
    public List<String> getCustomCleanFiles() {
        ArrayList arrayList = new ArrayList();
        List<IBusinessCallback> allBusiness = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getAllBusiness();
        for (int i3 = 0; i3 < allBusiness.size(); i3++) {
            IBusinessCallback iBusinessCallback = allBusiness.get(i3);
            if (iBusinessCallback instanceof QQVasUpdateBusiness) {
                QQVasUpdateBusiness qQVasUpdateBusiness = (QQVasUpdateBusiness) iBusinessCallback;
                if (qQVasUpdateBusiness.isEnableFileClean()) {
                    arrayList.add(qQVasUpdateBusiness.getSavePath(""));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager
    public long refreshCustomCleanFiles(boolean z16) {
        long j3 = 0;
        if (!VasNtToggle.UPDATE_SYSTEM_CUSTOM_CLEAN.isEnable(true)) {
            return 0L;
        }
        List<IBusinessCallback> allBusiness = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getAllBusiness();
        for (int i3 = 0; i3 < allBusiness.size(); i3++) {
            IBusinessCallback iBusinessCallback = allBusiness.get(i3);
            if (iBusinessCallback instanceof QQVasUpdateBusiness) {
                QQVasUpdateBusiness qQVasUpdateBusiness = (QQVasUpdateBusiness) iBusinessCallback;
                if (qQVasUpdateBusiness.isEnableFileClean()) {
                    j3 += doCleanBusiness(qQVasUpdateBusiness, z16);
                }
            }
        }
        if (!z16) {
            a aVar = new a();
            aVar.f311152b = j3;
            QLog.i(TAG, 1, aVar.toString());
        }
        if (z16) {
            UpdateSystemFileCheck updateSystemFileCheck = new UpdateSystemFileCheck();
            updateSystemFileCheck.checkLocalResMd5();
            updateSystemFileCheck.checkBusinessList(allBusiness);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager
    public <T extends QQVasUpdateBusiness> T getBusinessInstance(Long l3) {
        return (T) this.updateService.f(l3);
    }
}
