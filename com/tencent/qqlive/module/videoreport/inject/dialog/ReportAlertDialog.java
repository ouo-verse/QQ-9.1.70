package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportAlertDialog extends AlertDialog {
    public ReportAlertDialog(@NonNull Context context) {
        super(context);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        EventCollector.getInstance().onDialogDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onDialogDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        EventCollector.getInstance().onDialogStop(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        EventCollector.getInstance().onDialogFocusChanged(this, z16);
    }

    public ReportAlertDialog(@NonNull Context context, int i3) {
        super(context, i3);
    }

    protected ReportAlertDialog(@NonNull Context context, boolean z16, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
    }
}
