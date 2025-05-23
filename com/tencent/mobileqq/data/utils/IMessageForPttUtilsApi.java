package com.tencent.mobileqq.data.utils;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IMessageForPttUtilsApi extends QRouteApi {
    byte[] c2cConstructPTTExtraInfo(MessageForPtt messageForPtt);

    byte[] c2cConstructPttReserveInfo(MessageForPtt messageForPtt);

    byte[] changeWaveformToPb(int[] iArr);

    byte[] groupConstructPTTExtraInfo(MessageForPtt messageForPtt);
}
