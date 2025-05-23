package com.tencent.mobileqq.intervideo.now.api.impl;

import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.intervideo.now.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowUtilImpl implements INowUtil {
    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean checkNowApkExist(String str, String str2) {
        return c.a(str, str2);
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean copyNowApkToCommonDir(String str, String str2, String str3) {
        return c.b(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean delete(String str) {
        return c.d(str);
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public String getCommonNowPath() {
        return c.f();
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean isExists(String str) {
        return c.h(str);
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean isH5Test() {
        return c.i();
    }

    @Override // com.tencent.mobileqq.intervideo.now.api.INowUtil
    public boolean renameTo(String str, String str2) {
        return c.j(str, str2);
    }
}
