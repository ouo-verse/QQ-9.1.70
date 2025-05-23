package com.tencent.mobileqq.qqdataline.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQDataLineApi extends QRouteApi {
    String changeUid2Uin(String str);

    String getDeviceNameFromUid(Context context, String str);
}
