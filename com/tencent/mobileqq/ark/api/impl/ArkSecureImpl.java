package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.ark.secure.ArkSecureUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkSecureImpl implements IArkSecure {
    @Override // com.tencent.mobileqq.ark.api.IArkSecure
    public void checkShareUrl(String str, String str2, String str3, String str4, com.tencent.mobileqq.ark.secure.b bVar) {
        ArkSecureUtil.a(str, str2, str3, str4, bVar);
    }
}
