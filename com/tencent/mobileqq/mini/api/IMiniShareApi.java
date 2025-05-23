package com.tencent.mobileqq.mini.api;

import android.content.Context;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniShareApi extends QRouteApi {
    void addMyMiniApp(String str, int i3, MiniAppCmdInterface miniAppCmdInterface);

    void jumpReportPage(Context context, String str);

    void jumpUrl(Context context, String str);

    void removeMyMiniApp(String str, int i3, MiniAppCmdInterface miniAppCmdInterface);
}
