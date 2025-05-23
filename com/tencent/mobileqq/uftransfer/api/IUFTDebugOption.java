package com.tencent.mobileqq.uftransfer.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IUFTDebugOption extends QRouteApi {
    void enableForceBigFileUpload(boolean z16);

    void enableSimulateForwardForbiddenFiles(boolean z16);

    boolean isForceBigFileUploadEnabled();

    boolean isSimulateForwardForbiddenFilesEnabled();
}
