package com.tencent.hippy.qq.api;

import android.os.Handler;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyThread extends QRouteApi {
    bc createQQHandler();

    bc createQQHandler(Handler.Callback callback);
}
