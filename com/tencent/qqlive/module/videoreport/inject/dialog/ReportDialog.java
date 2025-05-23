package com.tencent.qqlive.module.videoreport.inject.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.mobileqq.qui.dialog.QUICompatDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportDialog extends QUICompatDialog {
    public ReportDialog(@NonNull Context context) {
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

    public ReportDialog(@NonNull Context context, int i3) {
        super(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReportDialog(@NonNull Context context, boolean z16, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
    }
}
