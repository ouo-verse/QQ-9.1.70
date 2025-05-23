package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;

/* loaded from: classes34.dex */
public class QzonePluginProxyActivityImpl implements IQzonePluginProxyActivity {
    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public ClassLoader getPhotoPlusClassLoader(Context context) throws Exception {
        return QzonePluginProxyActivity.getPhotoPlusClassLoader(context);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public ClassLoader getQzoneLiveClassLoader(Context context) throws Exception {
        return QzonePluginProxyActivity.getQzoneLiveClassLoader(context);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public ClassLoader getQzoneVerticalVideoClassLoader(Context context) throws Exception {
        return QzonePluginProxyActivity.getQzoneVerticalVideoClassLoader(context);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public ClassLoader getQzoneWeishiFeedsClassLoader(Context context) throws Exception {
        return QzonePluginProxyActivity.getQzoneWeishiFeedsClassLoader(context);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void launchPluingActivityForResult(Context context, String str, Intent intent, int i3) {
        QzonePluginProxyActivity.launchPluingActivityForResult(context, str, intent, i3);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void setActivityNameToIntent(Intent intent, String str) {
        QzonePluginProxyActivity.setActivityNameToIntent(intent, str);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, com.tencent.mobileqq.hitrate.b bVar) {
        QzonePluginProxyActivity.launchPluingActivityForResult(context, str, intent, i3, bVar);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void launchPluingActivityForResult(Activity activity, String str, Intent intent, int i3, boolean z16) {
        QzonePluginProxyActivity.launchPluingActivityForResult(activity, str, intent, i3, z16);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16, com.tencent.mobileqq.hitrate.b bVar, boolean z17) {
        QzonePluginProxyActivity.launchPluingActivityForResult(context, str, intent, i3, onDismissListener, z16, bVar, z17);
    }

    @Override // com.tencent.qzonehub.api.IQzonePluginProxyActivity
    public void launchPluingActivityForResult(Context context, String str, Intent intent, int i3, DialogInterface.OnDismissListener onDismissListener, boolean z16) {
        QzonePluginProxyActivity.launchPluingActivityForResult(context, str, intent, i3, onDismissListener, z16);
    }
}
