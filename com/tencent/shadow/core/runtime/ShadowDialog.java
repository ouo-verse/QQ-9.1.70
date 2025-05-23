package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.shadow.core.runtime.qcircle.container.PluginContainerActivity;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowDialog extends ReportDialog {
    public ShadowDialog(Context context) {
        super(context);
    }

    public final ShadowActivity getOwnerPluginActivity() {
        PluginContainerActivity pluginContainerActivity = (PluginContainerActivity) getOwnerActivity();
        if (pluginContainerActivity != null) {
            return (ShadowActivity) pluginContainerActivity.getPluginActivity();
        }
        return null;
    }

    public final void setOwnerPluginActivity(ShadowActivity shadowActivity) {
        setOwnerActivity((Activity) shadowActivity.mHostActivityDelegator.getHostActivity());
    }

    public ShadowDialog(Context context, int i3) {
        super(context, i3);
    }

    protected ShadowDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
    }
}
