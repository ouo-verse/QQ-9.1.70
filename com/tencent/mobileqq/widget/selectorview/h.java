package com.tencent.mobileqq.widget.selectorview;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected Context f317411a;

    /* renamed from: b, reason: collision with root package name */
    protected QActionSheet f317412b;

    /* renamed from: c, reason: collision with root package name */
    protected QPickerView f317413c;

    /* renamed from: d, reason: collision with root package name */
    private b f317414d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f317415e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f317416f = true;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends ReportDialog {
        public b(@NonNull Context context) {
            super(context, R.style.MenuDialogStyle);
            initWindow();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(Integer.MIN_VALUE);
            super.setContentView(frameLayout);
        }

        private void initWindow() {
            Window window = getWindow();
            if (window == null) {
                return;
            }
            window.requestFeature(1);
            try {
                ImmersiveUtils.clearCoverForStatus(window, true);
            } catch (Exception e16) {
                QLog.e("CoverDialog", 1, e16, new Object[0]);
            }
        }
    }

    public h(Context context) {
        this.f317411a = context;
        QActionSheet Z = QActionSheet.Z(context);
        this.f317412b = Z;
        this.f317413c = (QPickerView) Z.findViewById(R.id.f61852z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.selectorview.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.g();
            }
        }, 200L);
    }

    private void f() {
        this.f317412b.i0(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        b bVar = this.f317414d;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    private void n() {
        if (this.f317414d == null) {
            this.f317414d = new b(this.f317411a);
        }
        this.f317414d.show();
    }

    public void c() {
        try {
            Context context = this.f317411a;
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing() && this.f317412b.isShowing()) {
                    this.f317412b.dismiss();
                }
            } else {
                this.f317412b.dismiss();
            }
        } catch (Exception e16) {
            QLog.e("BaseSelectorView", 1, "BaseSelectorView dismiss error", e16);
        }
    }

    public QActionSheet.f e() {
        return this.f317412b.c0();
    }

    public void h(int i3) {
        this.f317412b.g0(i3);
    }

    public void i(QActionSheet.f fVar) {
        this.f317412b.j0(fVar);
    }

    public void j(boolean z16) {
        this.f317412b.k0(z16);
    }

    public void k(String str) {
        this.f317412b.setTitle(str);
    }

    public void l(String str) {
        this.f317412b.l0(str);
    }

    public void m() {
        try {
            f();
            Context context = this.f317411a;
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing() && !this.f317412b.isShowing()) {
                    n();
                    this.f317412b.show();
                }
            } else {
                n();
                this.f317412b.show();
            }
        } catch (Exception e16) {
            QLog.e("BaseSelectorView", 1, "BaseSelectorView show error", e16);
        }
    }

    public h(Context context, boolean z16) {
        this.f317411a = context;
        this.f317415e = z16;
        QActionSheet a06 = QActionSheet.a0(context, z16);
        this.f317412b = a06;
        this.f317413c = (QPickerView) a06.findViewById(R.id.f61852z9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements QActionSheet.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            h.this.d();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            h.this.d();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
