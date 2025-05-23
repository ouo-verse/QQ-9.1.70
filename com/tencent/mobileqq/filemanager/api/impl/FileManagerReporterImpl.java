package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerReporterImpl implements IFileManagerReporter {
    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerReporter
    public void addData(String str) {
        FileManagerReporter.addData(str);
    }
}
