package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.tool.v.QarHelperV1;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QarFile {
    private QarHelper helper = new QarHelperV1();
    private File requiredFile;
    private File targetFile;

    private boolean initRequiredParam(String str, String str2) {
        File file = new File(str);
        this.requiredFile = file;
        if (!file.exists()) {
            System.out.println("required file not found: " + str);
            return false;
        }
        File file2 = new File(str2);
        this.targetFile = file2;
        if (file2.exists()) {
            if (!this.targetFile.delete()) {
                System.out.println("Qar can't create: " + str2);
                return false;
            }
            return true;
        }
        if (this.targetFile.getParentFile() != null && !this.targetFile.getParentFile().exists()) {
            this.targetFile.mkdirs();
            return true;
        }
        return true;
    }

    public boolean createQar(String str, String str2) {
        if (initRequiredParam(str, str2)) {
            return this.helper.write(this.requiredFile, this.targetFile);
        }
        return false;
    }

    public String getMd5(String str) {
        return this.helper.getQarMd5(new File(str));
    }

    public boolean restoreQar(String str, String str2) {
        if (initRequiredParam(str, str2)) {
            return this.helper.read(str, str2);
        }
        return false;
    }

    public void setExceptFiles(List<String> list) {
        this.helper.setExceptFiles(list);
    }

    public void setUncompressList(List<String> list) {
        this.helper.setUncompressList(list);
    }
}
