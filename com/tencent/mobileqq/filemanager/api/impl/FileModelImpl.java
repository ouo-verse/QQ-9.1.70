package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFileModel;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileModelImpl implements IFileModel {
    @Override // com.tencent.mobileqq.filemanager.api.IFileModel
    public kc1.b newFileModel(FileManagerEntity fileManagerEntity) {
        return kc1.c.m(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileModel
    public kc1.b newFileModel(MessageForFile messageForFile) {
        return kc1.c.l(messageForFile);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileModel
    public kc1.b newFileModel(String str) {
        return kc1.c.n(str);
    }
}
