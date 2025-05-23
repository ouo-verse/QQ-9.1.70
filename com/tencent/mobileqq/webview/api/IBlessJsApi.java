package com.tencent.mobileqq.webview.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IBlessJsApi extends QRouteApi {
    Intent getBlessIntent(Intent intent, String str, int i3, int i16);

    Intent getPtvIntent(Intent intent, String str, String str2, String str3, String str4, String str5, String str6);
}
