package com.tencent.mobileqq.gamecenter.preload;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import pd1.a;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IPreloadRequestManager extends QRouteApi {
    String getPreloadRequest(int i3, String str, String str2, String str3);

    void getPreloadRequestAsync(int i3, String str, String str2, String str3, a aVar);

    void onBundleDownloaded(String str);

    void onHippyDestroy(int i3, String str);

    void onOpenHippyStart(int i3, String str, String str2);
}
