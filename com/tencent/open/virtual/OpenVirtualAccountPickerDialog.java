package com.tencent.open.virtual;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.open.agent.OpenVirtualAccountPickerFragment;
import com.tencent.open.agent.auth.model.k;
import com.tencent.open.agent.util.p;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.virtual.OpenVirtualAccountCreatorDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class OpenVirtualAccountPickerDialog extends BottomSheetDialogFragment {
    private OpenVirtualAccountPickerFragment C;
    private OpenVirtualAccountCreatorDialog D;
    private int E;
    private Handler F = new Handler();

    /* loaded from: classes22.dex */
    class a extends com.tencent.open.agent.auth.presenter.c {

        /* renamed from: com.tencent.open.virtual.OpenVirtualAccountPickerDialog$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C9286a implements OpenVirtualAccountCreatorDialog.b {
            C9286a() {
            }

            @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
            public void a(long j3) {
                t.b("OpenVirtualAccountPickerDialog", "create virtual account success!");
                OpenVirtualAccountPickerDialog.this.showDialog();
                OpenVirtualAccountPickerDialog.this.Fh(j3);
            }

            @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
            public void b(int i3) {
                t.b("OpenVirtualAccountPickerDialog", "create virtual account failed!");
                if (i3 == 2) {
                    Intent intent = new Intent();
                    intent.putExtra("createVirtualAccount", 2);
                    OpenVirtualAccountPickerDialog.this.C.Hh(intent);
                }
                OpenVirtualAccountPickerDialog.this.dismissDialog();
            }

            @Override // com.tencent.open.virtual.OpenVirtualAccountCreatorDialog.b
            public void onCancel() {
                t.b("OpenVirtualAccountPickerDialog", "create virtual account cancel!");
                OpenVirtualAccountPickerDialog.this.showDialog();
            }
        }

        a() {
        }

        @Override // ep3.i
        public void a() {
            OpenVirtualAccountPickerDialog.this.Ah();
            OpenVirtualAccountPickerDialog openVirtualAccountPickerDialog = OpenVirtualAccountPickerDialog.this;
            openVirtualAccountPickerDialog.D = g.c(openVirtualAccountPickerDialog.C.getQBaseActivity(), new C9286a());
        }

        @Override // ep3.i
        public void b(hp3.g gVar) {
            OpenVirtualAccountPickerDialog.th(OpenVirtualAccountPickerDialog.this);
            OpenVirtualAccountPickerDialog.this.dismissDialog();
        }

        @Override // ep3.i
        public void cancel() {
            OpenVirtualAccountPickerDialog.th(OpenVirtualAccountPickerDialog.this);
            OpenVirtualAccountPickerDialog.this.dismissDialog();
        }

        @Override // ep3.i
        public Bundle e() {
            OpenVirtualAccountPickerDialog.sh(OpenVirtualAccountPickerDialog.this);
            return k.a(null);
        }
    }

    /* loaded from: classes22.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
            this.E = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(List list, long j3, String str) {
        this.C.H7(true);
        com.tencent.open.model.e eVar = new com.tencent.open.model.e();
        eVar.f341695c = new ArrayList<>(list);
        eVar.f341694b = j3;
        hp3.b.e().p("0", eVar);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VirtualInfo virtualInfo = (VirtualInfo) it.next();
            hp3.h hVar = new hp3.h(virtualInfo);
            if (virtualInfo.f341675d == j3) {
                hVar.f405844d = true;
            }
            arrayList.add(hVar);
        }
        this.C.gf(arrayList, str);
        this.C.Lh(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(final long j3, final String str, boolean z16, final List list, int i3) {
        if (z16 && list != null) {
            this.C.getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.open.virtual.j
                @Override // java.lang.Runnable
                public final void run() {
                    OpenVirtualAccountPickerDialog.this.Bh(list, j3, str);
                }
            });
        }
    }

    private void Dh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.a0c);
        window.setBackgroundDrawableResource(17170445);
        window.setDimAmount(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(final long j3) {
        final String account = this.C.getQBaseActivity().getAppRuntime().getAccount();
        com.tencent.open.agent.auth.model.k.b(account, p.m(), new k.b() { // from class: com.tencent.open.virtual.i
            @Override // com.tencent.open.agent.auth.model.k.b
            public final void a(boolean z16, List list, int i3) {
                OpenVirtualAccountPickerDialog.this.Ch(j3, account, z16, list, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    static /* bridge */ /* synthetic */ k sh(OpenVirtualAccountPickerDialog openVirtualAccountPickerDialog) {
        openVirtualAccountPickerDialog.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.show();
            this.E = 1;
        }
    }

    static /* bridge */ /* synthetic */ b th(OpenVirtualAccountPickerDialog openVirtualAccountPickerDialog) {
        openVirtualAccountPickerDialog.getClass();
        return null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        OpenVirtualAccountCreatorDialog openVirtualAccountCreatorDialog;
        if (i3 == 257 && (openVirtualAccountCreatorDialog = this.D) != null) {
            openVirtualAccountCreatorDialog.onActivityResult(i3, i16, intent);
            return;
        }
        OpenVirtualAccountPickerFragment openVirtualAccountPickerFragment = this.C;
        if (openVirtualAccountPickerFragment != null) {
            openVirtualAccountPickerFragment.onActivityResult(i3, i16, intent);
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
        OpenVirtualAccountPickerFragment openVirtualAccountPickerFragment = new OpenVirtualAccountPickerFragment();
        this.C = openVirtualAccountPickerFragment;
        openVirtualAccountPickerFragment.Kh(new a());
        Eh();
        getChildFragmentManager().beginTransaction().replace(R.id.ckj, this.C).commitAllowingStateLoss();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.E == 1) {
            this.F.postDelayed(new Runnable() { // from class: com.tencent.open.virtual.OpenVirtualAccountPickerDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    OpenVirtualAccountPickerDialog.this.Eh();
                }
            }, 500L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() != null && this.E == 2) {
            getDialog().hide();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.E == 1) {
            Dh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.E = 0;
    }
}
