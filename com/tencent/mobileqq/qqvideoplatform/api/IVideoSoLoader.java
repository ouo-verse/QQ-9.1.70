package com.tencent.mobileqq.qqvideoplatform.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IVideoSoLoader extends QRouteApi {
    boolean isAllSoExist(boolean z16);

    boolean isDownloadSoExist(boolean z16);

    boolean isTpCoreSoExist(boolean z16);

    void loadDownProxyAsync(boolean z16, LoadSoCallback loadSoCallback);

    boolean loadDownProxySync(boolean z16);

    void loadMonetSo(LoadSoCallback loadSoCallback);

    void loadSo(boolean z16, LoadSoCallback loadSoCallback);

    boolean loadTPCoreSync(boolean z16);

    void preloadSo(boolean z16);
}
