package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.IMiniCmdService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniCmdServiceImpl implements IMiniCmdService {
    @Override // com.tencent.mobileqq.mini.api.IMiniCmdService
    public void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().createUpdatableMsg(str, str2, i3, i16, i17, str3, i18, bArr, miniAppCmdInterface);
    }
}
