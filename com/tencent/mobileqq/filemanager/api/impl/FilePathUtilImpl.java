package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.filemanager.util.ak;

/* loaded from: classes12.dex */
public class FilePathUtilImpl implements IFilePathUtil {
    @Override // com.tencent.mobileqq.filemanager.api.IFilePathUtil
    public String copyImageFileToMediaStorage(String str) {
        return ak.a(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFilePathUtil
    public boolean fileExistsAndNotEmpty(String str) {
        return ak.c(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFilePathUtil
    public String getRealPath(String str) {
        return ak.e(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFilePathUtil
    public String renameImageFileToMediaStorage(String str) {
        return ak.g(str);
    }
}
