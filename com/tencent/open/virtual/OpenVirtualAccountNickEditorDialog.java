package com.tencent.open.virtual;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import h53.QUIInputCountCalculateStrategy;
import h53.q;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenVirtualAccountNickEditorDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private TextView D;
    private TextView E;
    private QUISingleLineInputView G;
    private c H;
    private ViewTreeObserver.OnGlobalLayoutListener I;
    private String F = null;
    private long J = 0;
    private Handler K = new Handler();
    private boolean L = true;
    private long M = 100;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f341760d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f341761e;

        a(View view, View view2) {
            this.f341760d = view;
            this.f341761e = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f341760d.getWindowVisibleDisplayFrame(rect);
            int i3 = this.f341760d.getContext().getResources().getDisplayMetrics().heightPixels - rect.bottom;
            if (i3 != 0) {
                if (this.f341761e.getPaddingBottom() != i3) {
                    View view = this.f341761e;
                    if (i3 <= 0) {
                        i3 = 80;
                    }
                    view.setPadding(0, 0, 0, i3);
                    return;
                }
                return;
            }
            if (this.f341761e.getPaddingBottom() != 0) {
                this.f341761e.setPadding(0, 0, 0, 80);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        void a(String str);

        void onCancel();
    }

    private void dismissDialog() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        QUISingleLineInputView qUISingleLineInputView = this.G;
        if (qUISingleLineInputView != null) {
            qUISingleLineInputView.q();
            this.G.z();
        }
    }

    private void th() {
        this.G.setCalculateStrategy(new QUIInputCountCalculateStrategy(2.0d, 2.0d, 1.0d, 1.0d));
        if (!TextUtils.isEmpty(this.F)) {
            this.G.setContentText(this.F);
        }
        this.G.setInputViewWatcher(new b());
    }

    private void uh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(-1);
    }

    private void vh() {
        if (getActivity() != null && this.I != null) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.I);
            this.I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(R.style.a0c);
        window.setBackgroundDrawableResource(17170445);
        window.setDimAmount(0.5f);
    }

    public void hideSoftInput() {
        QUISingleLineInputView qUISingleLineInputView = this.G;
        if (qUISingleLineInputView != null) {
            qUISingleLineInputView.p();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            t.b("OpenVirtualAccountNickEditorDialog", "onCancelBtnClick");
            dismissDialog();
            vh();
            c cVar = this.H;
            if (cVar != null) {
                cVar.onCancel();
            }
        } else if (view == this.C) {
            hideSoftInput();
        } else if (view == this.E) {
            CharSequence d16 = this.G.d();
            t.b("OpenVirtualAccountNickEditorDialog", "onCompleteBtnClick name=", d16);
            if (System.currentTimeMillis() - this.J <= 1000) {
                t.b("OpenVirtualAccountNickEditorDialog", "onCompleteBtnClick repeat click");
            } else {
                this.J = System.currentTimeMillis();
                if (TextUtils.isEmpty(d16)) {
                    AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l56), false);
                } else {
                    hideSoftInput();
                    String charSequence = d16.toString();
                    dismissDialog();
                    vh();
                    c cVar2 = this.H;
                    if (cVar2 != null) {
                        cVar2.a(charSequence);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.a0_);
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        boolean isSwitchOn = iUnitedConfigManager.isSwitchOn("qq_open_auth_create_virtual_edit_nick_auto_input_switch", true);
        this.L = isSwitchOn;
        if (isSwitchOn) {
            try {
                long parseLong = Long.parseLong(iUnitedConfigManager.loadAsString("qq_open_auth_create_virtual_edit_nick_auto_input_switch", ""));
                if (parseLong > 0) {
                    this.M = parseLong;
                }
            } catch (NumberFormatException e16) {
                QLog.e("OpenVirtualAccountNickEditorDialog", 1, "parse delay exception: ", e16);
            }
        }
        QLog.i("OpenVirtualAccountNickEditorDialog", 1, "onCreate autoShowInputSwitch: " + this.L + ", delay: " + this.M);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fqv, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.aou);
        this.D = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) inflate.findViewById(R.id.u2t);
        this.E = textView2;
        textView2.setOnClickListener(this);
        this.G = (QUISingleLineInputView) inflate.findViewById(R.id.f165824xp0);
        th();
        if (getActivity() != null) {
            View decorView = getActivity().getWindow().getDecorView();
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            a aVar = new a(decorView, inflate);
            this.I = aVar;
            viewTreeObserver.addOnGlobalLayoutListener(aVar);
        }
        zh();
        this.C = inflate;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        c cVar = this.H;
        if (cVar != null) {
            cVar.onCancel();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        int i3;
        super.onResume();
        QUISingleLineInputView qUISingleLineInputView = this.G;
        if (qUISingleLineInputView != null) {
            CharSequence d16 = qUISingleLineInputView.d();
            if (d16 != null) {
                i3 = d16.length();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                this.G.setTextSelection(i3);
            }
        }
        if (!this.L || this.M >= 500) {
            this.K.postDelayed(new Runnable() { // from class: com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("OpenVirtualAccountNickEditorDialog", 1, "post updateDialogAnimation");
                    OpenVirtualAccountNickEditorDialog.this.zh();
                }
            }, 500L);
        }
        if (this.L && this.M > 0) {
            this.K.postDelayed(new Runnable() { // from class: com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("OpenVirtualAccountNickEditorDialog", 1, "post doShowSoftInput");
                    OpenVirtualAccountNickEditorDialog.this.sh();
                }
            }, this.M);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        uh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void wh(String str) {
        this.F = str;
    }

    public void xh(c cVar) {
        this.H = cVar;
    }

    public void yh(@NonNull QBaseActivity qBaseActivity) {
        if (qBaseActivity.isFinishing()) {
            return;
        }
        if (getDialog() != null && getDialog().isShowing()) {
            return;
        }
        show(qBaseActivity.getSupportFragmentManager(), "OpenVirtualAccountNickEditor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements q {
        b() {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int l3 = OpenVirtualAccountNickEditorDialog.this.G.l();
            if (OpenVirtualAccountNickEditorDialog.this.G.e() > l3) {
                AuthUIUtil.l(OpenVirtualAccountNickEditorDialog.this.getActivity(), "\u6635\u79f0\u6700\u591a\u53ef\u8f93\u5165" + l3 + "\u4e2a\u5b57", false);
            }
        }

        @Override // h53.q
        public void A4(String str) {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
        }

        @Override // h53.k
        public void f8(boolean z16) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
