package com.tencent.mobileqq.data;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IMessageForPttInnerApi extends QRouteApi {
    String getLocalFilePath(int i3, String str);

    String getMsgFilePath(int i3, String str);

    String getSummaryMsg(String str, int i3);

    boolean hasSttTxt(String str, int i3);
}
