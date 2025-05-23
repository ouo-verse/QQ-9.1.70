package com.tencent.now.linkpkanchorplay.invite.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BottomDialog extends ReportAndroidXDialogFragment {
    static Set<BottomDialog> G = new HashSet(2);
    private Dialog C;
    private boolean D = false;
    private b E;
    protected a F;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void onDismiss(DialogInterface dialogInterface);
    }

    private void ph() {
        for (BottomDialog bottomDialog : G) {
            LogUtil.d("LinkPKBottomDialog", "onCancel:for", new Object[0]);
            bottomDialog.dismissAllowingStateLoss();
        }
        G.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    @CallSuper
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        LogUtil.d("LinkPKBottomDialog", "onCancel:", new Object[0]);
        if (this.D && qh() != null) {
            qh().t1(new UIEvent.c());
        }
        G.remove(this);
        if (G.size() == 0) {
            return;
        }
        ph();
        G.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.d("LinkPKBottomDialog", "onCreate: add", new Object[0]);
        setStyle(0, R.style.auw);
        ph();
        G.add(this);
        setCancelable(true);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        G.remove(this);
        this.F = null;
        this.C = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.F;
        if (aVar != null) {
            aVar.onDismiss(dialogInterface);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        this.C = dialog;
        Window window = dialog.getWindow();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        this.C.setCanceledOnTouchOutside(true);
    }

    public b qh() {
        return this.E;
    }

    public void rh(boolean z16) {
        this.D = z16;
    }

    public void sh(b bVar) {
        this.E = bVar;
    }

    public void th(a aVar) {
        this.F = aVar;
    }
}
