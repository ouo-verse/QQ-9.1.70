package com.tencent.mobileqq.qqlive.room.livelabel;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.room.livelabel.f;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SelectLabelDialog extends ReportAndroidXDialogFragment {
    static IPatchRedirector $redirector_;
    private TabLayout C;
    private ViewPager2 D;
    private f E;
    private IQQLiveSDK F;
    private j G;
    private LabelModel H;
    private int I;
    private LabelModel J;
    private b K;
    private int L;
    private long M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectLabelDialog.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (SelectLabelDialog.this.I != i3 && SelectLabelDialog.this.H != null) {
                SelectLabelDialog.this.E.notifyItemChanged(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(LabelModel labelModel);
    }

    public SelectLabelDialog(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.M = j3;
        this.L = 390;
        this.F = com.tencent.mobileqq.qqlive.base.sdk.a.c(null);
        AegisLogger.i(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[constructor] labelType=" + j3 + ", sdk=" + this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(QQLiveResponse qQLiveResponse) {
        wh((j) qQLiveResponse.getRsp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(j jVar) {
        final f55.e[] eVarArr;
        this.G = jVar;
        if (jVar != null && (eVarArr = jVar.f271629a) != null) {
            new com.google.android.material.tabs.d(this.C, this.D, new d.b() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.m
                @Override // com.google.android.material.tabs.d.b
                public final void a(TabLayout.g gVar, int i3) {
                    SelectLabelDialog.yh(eVarArr, gVar, i3);
                }
            }).a();
            this.E.v0(eVarArr, this.J, this.G.f271630b);
            this.E.w0(new f.a() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.n
                @Override // com.tencent.mobileqq.qqlive.room.livelabel.f.a
                public final void a(int i3, int i16, LabelModel labelModel) {
                    SelectLabelDialog.this.zh(i3, i16, labelModel);
                }
            });
            this.D.registerOnPageChangeCallback(new a());
            return;
        }
        AegisLogger.e(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[handleSecondLabelsData] invalid data");
    }

    private void xh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            AegisLogger.e(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[initTabData] no activity");
            return;
        }
        long j3 = this.M;
        if (j3 == 2) {
            ((QQLiveLabelViewModel) new ViewModelProvider(activity).get(QQLiveLabelViewModel.class)).R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectLabelDialog.this.Ah((QQLiveResponse) obj);
                }
            });
            return;
        }
        if (j3 == 1) {
            ((QQLiveLabelViewModel) new ViewModelProvider(activity).get(QQLiveLabelViewModel.class)).S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectLabelDialog.this.wh((j) obj);
                }
            });
            return;
        }
        if (j3 == 10) {
            ((QQLiveLabelViewModel) new ViewModelProvider(activity).get(QQLiveLabelViewModel.class)).Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectLabelDialog.this.wh((j) obj);
                }
            });
            return;
        }
        AegisLogger.e(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[initTabData] invalid labelType: " + this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void yh(f55.e[] eVarArr, TabLayout.g gVar, int i3) {
        gVar.t(eVarArr[i3].f397870b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(int i3, int i16, LabelModel labelModel) {
        this.H = labelModel;
        this.I = i3;
        AegisLogger.i(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[onItemSelect] model=" + labelModel + ", selectPos=" + i3 + ", labelPos=" + i16);
        dismiss();
    }

    public void Bh(LabelModel labelModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) labelModel);
        } else {
            this.J = labelModel;
        }
    }

    public void Ch(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.K = bVar;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (getDialog() != null) {
                getDialog().requestWindowFeature(1);
            }
            if (this.M == 2) {
                inflate = layoutInflater.inflate(R.layout.hbf, viewGroup, false);
            } else {
                inflate = layoutInflater.inflate(R.layout.hbg, viewGroup, false);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialogInterface);
            return;
        }
        super.onDismiss(dialogInterface);
        b bVar = this.K;
        if (bVar != null) {
            bVar.a(this.H);
        }
        AegisLogger.i(AegisLogger.OPEN_LIVE, "SelectLabelDialog", "[onDismiss] mSelectModel=" + this.H);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onStart();
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            window.setDimAmount(0.0f);
            getDialog().setCanceledOnTouchOutside(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(window.getWindowManager().getDefaultDisplay().getWidth(), lk4.e.b(getContext(), this.L));
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setGravity(80);
            window.setWindowAnimations(R.style.ayq);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        this.C = (TabLayout) view.findViewById(R.id.f916055m);
        this.D = (ViewPager2) view.findViewById(R.id.f81984fn);
        f fVar = new f(this.M);
        this.E = fVar;
        this.D.setAdapter(fVar);
        xh();
    }
}
