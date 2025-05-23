package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.hitrate.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzonePluginProxyActivity extends QRouteApi {
    ClassLoader getPhotoPlusClassLoader(Context context) throws Exception;

    ClassLoader getQzoneLiveClassLoader(Context context) throws Exception;

    ClassLoader getQzoneVerticalVideoClassLoader(Context context) throws Exception;

    ClassLoader getQzoneWeishiFeedsClassLoader(Context context) throws Exception;

    void launchPluingActivityForResult(Activity activity, String str, Intent intent, int i3, boolean z16);

    void launchPluingActivityForResult(Context context, String str, Intent intent, int i3);

    void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16);

    void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, b bVar, boolean z17);

    void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, b bVar);

    void setActivityNameToIntent(Intent intent, String str);
}
