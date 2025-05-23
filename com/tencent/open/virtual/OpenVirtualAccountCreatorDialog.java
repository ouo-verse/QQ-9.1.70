package com.tencent.open.virtual;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.OpenVirtualAccountCreatorFragment;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenVirtualAccountCreatorDialog extends BottomSheetDialogFragment {
    protected b D;
    private OpenVirtualAccountCreatorFragment C = null;
    protected boolean E = true;
    private Handler F = new Handler();
    private int G = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements OpenVirtualAccountCreatorFragment.h {
        a() {
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void a(long j3) {
            t.b("OpenVirtualAccountCreatorDialog", "onCreateSuccess");
            OpenVirtualAccountCreatorDialog.this.dismissDialog();
            b bVar = OpenVirtualAccountCreatorDialog.this.D;
            if (bVar != null) {
                bVar.a(j3);
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void b(int i3) {
            t.b("OpenVirtualAccountCreatorDialog", "onCreateFailed");
            OpenVirtualAccountCreatorDialog.this.dismissDialog();
            b bVar = OpenVirtualAccountCreatorDialog.this.D;
            if (bVar != null) {
                bVar.b(i3);
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void c(boolean z16) {
            t.b("OpenVirtualAccountCreatorDialog", "onEditComplete");
            OpenVirtualAccountCreatorDialog openVirtualAccountCreatorDialog = OpenVirtualAccountCreatorDialog.this;
            openVirtualAccountCreatorDialog.E = z16;
            if (z16) {
                openVirtualAccountCreatorDialog.th();
            }
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void d() {
            t.b("OpenVirtualAccountCreatorDialog", "onEdit");
            OpenVirtualAccountCreatorDialog.this.ph();
        }

        @Override // com.tencent.open.agent.OpenVirtualAccountCreatorFragment.h
        public void onCancel() {
            t.b("OpenVirtualAccountCreatorDialog", "onCancel");
            OpenVirtualAccountCreatorDialog.this.dismissDialog();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(long j3);

        void b(int i3);

        void onCancel();
    }

    private void qh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(-1);
    }

    private void uh(Dialog dialog) {
        Object valueOf;
        Window window = dialog.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showFromSpecialDevice, decorView ");
            if (decorView == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(decorView.getVisibility());
            }
            sb5.append(valueOf);
            objArr[0] = sb5.toString();
            t.b("OpenVirtualAccountCreatorDialog", objArr);
            if (decorView != null && decorView.getVisibility() != 0) {
                decorView.setVisibility(0);
                this.G = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissDialog() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        OpenVirtualAccountCreatorFragment openVirtualAccountCreatorFragment = this.C;
        if (openVirtualAccountCreatorFragment != null) {
            openVirtualAccountCreatorFragment.onActivityResult(i3, i16, intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.a0_);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fqy, viewGroup, false);
        if (this.C == null) {
            this.C = new OpenVirtualAccountCreatorFragment();
        }
        this.C.Nh(new a());
        vh();
        getChildFragmentManager().beginTransaction().replace(R.id.ckj, this.C).commitAllowingStateLoss();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        t.b("OpenVirtualAccountCreatorDialog", "onDismiss");
        this.G = 3;
        b bVar = this.D;
        if (bVar != null) {
            bVar.onCancel();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        t.b("OpenVirtualAccountCreatorDialog", "onResume, shownState = " + this.G + " isFromEditNick = " + this.E);
        if (this.G == 1) {
            this.F.postDelayed(new Runnable() { // from class: com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    OpenVirtualAccountCreatorDialog.this.vh();
                }
            }, 500L);
        }
        if (!this.E) {
            t.b("OpenVirtualAccountCreatorDialog", "onResume, from edit avatar!");
            th();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.G == 2 && getDialog() != null) {
            t.b("OpenVirtualAccountCreatorDialog", "hide dialog after onStart");
            getDialog().hide();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.G == 1) {
            qh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.G = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ph() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
            this.G = 2;
        }
    }

    public void rh(b bVar) {
        this.D = bVar;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setShowsDialog(boolean z16) {
        super.setShowsDialog(z16);
    }

    public void sh(@NonNull QBaseActivity qBaseActivity) {
        if (qBaseActivity.isFinishing()) {
            return;
        }
        if (getDialog() != null && getDialog().isShowing()) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("OpenVirtualAccountCreatorDialog");
            if (findFragmentByTag != null) {
                supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            show(qBaseActivity.getSupportFragmentManager(), "OpenVirtualAccountCreatorDialog");
        } catch (Exception e16) {
            t.d("OpenVirtualAccountCreatorDialog", "showDialog error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void th() {
        String str;
        Dialog dialog = getDialog();
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("showDialogFromHidden, dialog ");
        if (dialog == null) {
            str = "null";
        } else {
            str = "is showing = " + dialog.isShowing();
        }
        sb5.append(str);
        objArr[0] = sb5.toString();
        t.b("OpenVirtualAccountCreatorDialog", objArr);
        if (dialog != null) {
            if (!dialog.isShowing()) {
                dialog.show();
                this.G = 1;
            } else {
                uh(dialog);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.a0c);
        window.setBackgroundDrawableResource(17170445);
        window.setDimAmount(0.5f);
    }
}
