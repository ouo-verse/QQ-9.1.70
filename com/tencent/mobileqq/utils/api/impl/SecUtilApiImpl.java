package com.tencent.mobileqq.utils.api.impl;

import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.api.ISecUtilApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SecUtilApiImpl implements ISecUtilApi {
    @Override // com.tencent.mobileqq.utils.api.ISecUtilApi
    public String getFileMd5(String str) {
        return SecUtil.getFileMd5(str);
    }
}
