package com.tencent.gdtad.wechat.mini;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtWXMINIProgramAPI extends QRouteApi {
    boolean handleOpenUrl(WeakReference<Activity> weakReference, Bundle bundle, String str);

    void updateTuringAIDTicketAsync(WeakReference<Context> weakReference);
}
