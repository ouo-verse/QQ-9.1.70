package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IFileHttpUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileHttpUtilsImpl implements IFileHttpUtils {
    @Override // com.tencent.mobileqq.filemanager.api.IFileHttpUtils
    public int getBlockSize(com.tencent.wstt.SSCM.a aVar, long j3, long j16, long j17) {
        return vb1.c.a(aVar, j3, j16, j17);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileHttpUtils
    public String hexToString(byte[] bArr) {
        return vb1.c.b(bArr);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileHttpUtils
    public boolean isNeedRetryOtherUrl(int i3) {
        return vb1.c.c(i3);
    }
}
