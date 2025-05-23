package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniCmdService extends QRouteApi {
    void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr, MiniAppCmdInterface miniAppCmdInterface);
}
