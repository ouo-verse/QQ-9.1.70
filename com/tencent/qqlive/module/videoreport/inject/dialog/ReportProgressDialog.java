package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes22.dex */
public class ReportProgressDialog extends ProgressDialog {
    public ReportProgressDialog(@NonNull Context context) {
        super(context);
    }

    @Override // android.app.ProgressDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        EventCollector.getInstance().onDialogStop(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        EventCollector.getInstance().onDialogFocusChanged(this, z16);
    }

    public ReportProgressDialog(@NonNull Context context, int i3) {
        super(context, i3);
    }
}
