package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface ISSRBundleRequester extends QRouteApi {
    public static final String FROM_PREREQUEST = "preReq";
    public static final String FROM_SSR = "ssr";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnGetSSRBundleListener {
        void onGetSSRBundle(int i3, String str, String str2);
    }

    void getSSRBundle(OnGetSSRBundleListener onGetSSRBundleListener);

    void requestSSRBundle(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo);

    ISSRBundleRequester setRequestFrom(String str);

    ISSRBundleRequester setSSRBundleListener(OnGetSSRBundleListener onGetSSRBundleListener);
}
