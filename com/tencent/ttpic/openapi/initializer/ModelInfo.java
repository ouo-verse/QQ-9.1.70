package com.tencent.ttpic.openapi.initializer;

import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ModelInfo extends AEResourceInfo {
    public String assetsDir;
    private boolean isEncrypted;
    private boolean mustUseSDCardPath;

    public ModelInfo(String str, String str2) {
        this(false, false, str, str2, 0);
    }

    public String getAssetsDir() {
        return this.assetsDir;
    }

    public String getFullAssetsPathNoPrefix() {
        return (getAssetsDir() + this.fileName).replace("assets://", "");
    }

    public String getFullAssetsPathWithPrefix() {
        return "assets://" + getAssetsDir() + this.fileName;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isMustUseSDCardPath() {
        return this.mustUseSDCardPath;
    }

    public ModelInfo(String str, String str2, int i3) {
        this(false, false, str, str2, i3);
    }

    public ModelInfo(boolean z16, String str, String str2) {
        this(z16, false, str, str2, 0);
    }

    public ModelInfo(boolean z16, String str, String str2, int i3) {
        this(z16, false, str, str2, i3);
    }

    public ModelInfo(boolean z16, boolean z17, String str, String str2, int i3) {
        this.mustUseSDCardPath = false;
        this.isEncrypted = false;
        if (!str.endsWith(File.separator) && !str.equals("")) {
            this.assetsDir = FileUtils.genSeperateFileDir(str);
        } else {
            this.assetsDir = str;
        }
        this.fileName = str2;
        this.mustUseSDCardPath = z16;
        this.fileSizeBytes = i3;
        this.isEncrypted = z17;
    }
}
