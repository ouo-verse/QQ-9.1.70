package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QFSBaseBottomSheetDialog extends com.google.android.material.bottomsheet.a implements LifecycleEventObserver {

    @NonNull
    protected final Context C;

    @Nullable
    protected Lifecycle D;

    public QFSBaseBottomSheetDialog(@NonNull Context context) {
        super(context, R.style.a66);
        this.C = context;
        setCanceledOnTouchOutside(N());
        O(context);
    }

    private void O(@NonNull Context context) {
        if (context instanceof ComponentActivity) {
            this.D = ((ComponentActivity) context).getLifecycle();
        }
    }

    protected boolean N() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        super.dismiss();
        QUIImmersiveHelper.u(getWindow(), false, true);
        Lifecycle lifecycle = this.D;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dismiss();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    @CallSuper
    public void show() {
        super.show();
        QUIImmersiveHelper.u(getWindow(), false, true);
        Lifecycle lifecycle = this.D;
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }
}
