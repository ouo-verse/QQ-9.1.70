package com.tencent.mobileqq.utils.api.impl;

import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.api.ISecurityUtile;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SecurityUtileImpl implements ISecurityUtile {
    @Override // com.tencent.mobileqq.utils.api.ISecurityUtile
    public String encode(String str) {
        return SecurityUtile.encode(str);
    }

    @Override // com.tencent.mobileqq.utils.api.ISecurityUtile
    public byte[] encode(byte[] bArr) {
        return SecurityUtile.encode(bArr);
    }
}
