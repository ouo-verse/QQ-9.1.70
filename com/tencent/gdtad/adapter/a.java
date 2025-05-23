package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.util.AdAppReceiverWrapper;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements AdAppReceiverWrapper.Adapter {
    @Override // com.tencent.ad.tangram.util.AdAppReceiverWrapper.Adapter
    public void observe(AdClickUtil.Params params, AdClickUtil.Result result) {
        Activity activity;
        WeakReference<Activity> weakReference;
        Context context = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            context = activity.getApplicationContext();
        }
        try {
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).registerAppInstallerReceiver(context);
            ((IGdtAPI) QRoute.api(IGdtAPI.class)).observeAppInstallerReceiver(params, result);
        } catch (Throwable th5) {
            QLog.e("GdtAppReceiverWrapperAdapter", 1, "[observe]", th5);
        }
    }
}
