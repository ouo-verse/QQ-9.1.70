package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UpdateTotal extends UpdateBase {
    public UpdateTotal(String str, String str2, String str3, String str4, int i3, PackageUpdateListener packageUpdateListener) {
        super(str, str2, str3, str4, i3, packageUpdateListener);
    }

    @Override // com.tencent.hippy.qq.update.UpdateBase
    boolean isPatchEnable() {
        return false;
    }

    @Override // com.tencent.hippy.qq.update.UpdateBase
    boolean patch(File file) {
        return true;
    }

    @Override // com.tencent.hippy.qq.update.UpdateBase
    boolean unzipFile(File file) {
        File moduleFile = HippyQQFileUtil.getModuleFile(this.mModule, this.mVersion);
        if (moduleFile == null) {
            return false;
        }
        this.mModuleFilePath = moduleFile.getAbsolutePath();
        try {
            FileUtils.uncompressZip(file.getAbsolutePath(), this.mModuleFilePath, false);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
