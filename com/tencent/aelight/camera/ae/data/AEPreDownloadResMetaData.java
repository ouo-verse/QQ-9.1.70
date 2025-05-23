package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import java.io.File;

/* loaded from: classes32.dex */
public class AEPreDownloadResMetaData extends AEMaterialMetaData {
    public String unzipDir;
    public String zipSaveDir;

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getLocalPath() {
        File file = new File(this.unzipDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.unzipDir);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(this.name);
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        sb5.append(this.name);
        return sb5.toString();
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
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
        }
        File file3 = new File(file.getPath(), str);
        if (!file3.exists()) {
            file3.mkdir();
        }
        return file3 + File.separator;
    }

    @Override // com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData
    public String getLocalZipPath() {
        File file = new File(this.zipSaveDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.md5;
        if (TextUtils.isEmpty(str)) {
            str = this.name;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.zipSaveDir);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(this.name);
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
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
}
