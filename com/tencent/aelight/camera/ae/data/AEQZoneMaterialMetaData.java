package com.tencent.aelight.camera.ae.data;

import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEQZoneMaterialMetaData extends AEMaterialMetaData {
    public static final String TAG = "AEQZoneMaterialMetaData";
    public String unzipDir;
    public String zipSaveDir;

    public static AEQZoneMaterialMetaData createAEQZoneMaterialMetaData(String str) {
        AEQZoneMaterialMetaData aEQZoneMaterialMetaData = new AEQZoneMaterialMetaData();
        if (!str.isEmpty() && str.endsWith(".zip")) {
            String substring = str.substring(str.lastIndexOf(47) + 1, str.indexOf(".zip"));
            aEQZoneMaterialMetaData.f69050id = substring;
            aEQZoneMaterialMetaData.name = substring;
            aEQZoneMaterialMetaData.resurl = str;
            aEQZoneMaterialMetaData.md5 = String.valueOf(substring.length());
            aEQZoneMaterialMetaData.unzipDir = ((IAEPath) QRoute.api(IAEPath.class)).getQZoneCameraPathMaterialFinalUsable();
            aEQZoneMaterialMetaData.zipSaveDir = ((IAEPath) QRoute.api(IAEPath.class)).getQZoneCameraZipPathMaterialFinalUsable();
            return aEQZoneMaterialMetaData;
        }
        ms.a.c(TAG, "createAEQZoneMaterialMetaData failed, url is: " + str);
        return null;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getLocalPath() {
        File file = new File(this.unzipDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return this.unzipDir + File.separator + this.name;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getLocalUnzipFolder() {
        File file = new File(this.unzipDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file.getPath(), this.name);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2 + File.separator;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getLocalZipPath() {
        File file = new File(this.zipSaveDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return this.zipSaveDir + File.separator + this.name;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getZipDownloadPath() {
        File file = new File(this.zipSaveDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file.getPath(), this.name);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2 + File.separator;
    }

    public boolean isUsable() {
        String[] list;
        File file = new File(getLocalPath());
        return file.exists() && (list = file.list()) != null && list.length > 0;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public boolean unZipFile() {
        String str = "AEMaterialMetaData getMaterialZipDeleteSwitch = ";
        File file = new File(getLocalZipPath());
        boolean z16 = false;
        try {
            if (!file.exists()) {
                ms.a.c(TAG, "AEMaterialMetaData getLocalZipPath = " + getLocalZipPath() + "zip\u4e0d\u5b58\u5728");
                return false;
            }
            try {
                ZipUtils.unZipFile(file, getLocalUnzipFolder());
                boolean materialZipDeleteSwitch = QzoneConfig.getMaterialZipDeleteSwitch();
                str = "AEMaterialMetaData getMaterialZipDeleteSwitch = " + materialZipDeleteSwitch;
                ms.a.a(TAG, str);
                if (materialZipDeleteSwitch) {
                    deleteOldZipFile();
                }
                z16 = true;
            } catch (IOException e16) {
                ms.a.a(TAG, "AEMaterialMetaData unZipFile exp = " + e16.getMessage());
                FileUtils.deleteDirectory(getLocalUnzipFolder());
                boolean materialZipDeleteSwitch2 = QzoneConfig.getMaterialZipDeleteSwitch();
                str = "AEMaterialMetaData getMaterialZipDeleteSwitch = " + materialZipDeleteSwitch2;
                ms.a.a(TAG, str);
                if (materialZipDeleteSwitch2) {
                    deleteOldZipFile();
                }
            }
            return z16;
        } catch (Throwable th5) {
            FileUtils.deleteDirectory(getLocalUnzipFolder());
            boolean materialZipDeleteSwitch3 = QzoneConfig.getMaterialZipDeleteSwitch();
            ms.a.a(TAG, str + materialZipDeleteSwitch3);
            if (materialZipDeleteSwitch3) {
                deleteOldZipFile();
            }
            throw th5;
        }
    }
}
