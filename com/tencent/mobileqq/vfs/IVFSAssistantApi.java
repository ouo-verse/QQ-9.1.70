package com.tencent.mobileqq.vfs;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.IOException;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVFSAssistantApi extends QRouteApi {
    String getCanonicalPath(String str) throws IOException;

    String getSDKPrivatePath(String str);
}
