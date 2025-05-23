package com.tencent.mobileqq.webview.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IAddContactSecCheckWebApi extends QRouteApi {
    void openSecCheckWeb(AppInterface appInterface, Context context, int i3, String str);

    void openSecCheckWebForFragment(AppInterface appInterface, Context context, QBaseFragment qBaseFragment, int i3, String str);
}
