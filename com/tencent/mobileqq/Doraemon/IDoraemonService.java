package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IDoraemonService extends QRouteApi {
    DoraemonAPIManager createAPIManager(@NonNull Activity activity, int i3, String str);

    DoraemonAPIManager createAPIManager(@NonNull Activity activity, int i3, String str, Bundle bundle);

    DoraemonAPIManager getDoraemonAPIModuleByUrl(com.tencent.mobileqq.webview.nativeapi.b bVar, String str);

    void prepare();
}
