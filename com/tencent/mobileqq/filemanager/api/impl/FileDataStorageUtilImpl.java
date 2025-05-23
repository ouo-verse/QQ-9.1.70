package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil;
import com.tencent.mobileqq.filemanager.util.h;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileDataStorageUtilImpl implements IFileDataStorageUtil {
    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public boolean getBool(AppRuntime appRuntime, String str, boolean z16) {
        return h.a(appRuntime, str, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public int getInt(AppRuntime appRuntime, String str, int i3) {
        return h.b(appRuntime, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public String getString(AppRuntime appRuntime, String str, String str2) {
        return h.c(appRuntime, str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public void putBool(AppRuntime appRuntime, String str, boolean z16) {
        h.f(appRuntime, str, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public void putInt(AppRuntime appRuntime, String str, int i3) {
        h.g(appRuntime, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileDataStorageUtil
    public void putString(AppRuntime appRuntime, String str, String str2) {
        h.h(appRuntime, str, str2);
    }
}
