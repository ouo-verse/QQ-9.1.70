package com.tencent.mobileqq.weiyun.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IWeiyunGrayTipHelper extends QRouteApi {
    void insertAIOGrayTips(AppInterface appInterface, String str, String str2, int i3, int i16, String str3);
}
