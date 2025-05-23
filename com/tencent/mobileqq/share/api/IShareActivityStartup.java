package com.tencent.mobileqq.share.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShareActivityStartup extends QRouteApi {
    void gotoShareActivity(Context context, String str);
}
