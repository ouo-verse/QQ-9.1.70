package com.tencent.mobileqq.troop.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.IOException;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopStringUtilsApi extends QRouteApi {
    String cutByteByUtf8(byte[] bArr, int i3) throws IOException;
}
