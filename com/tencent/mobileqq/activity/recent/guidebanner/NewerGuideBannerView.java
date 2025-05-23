package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewerGuideBannerView extends FrameLayout implements View.OnClickListener, SkinnableView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f185571d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f185572e;

    /* renamed from: f, reason: collision with root package name */
    private NewerGuideBannerViewModel f185573f;

    /* renamed from: h, reason: collision with root package name */
    private QQProgressDialog f185574h;

    /* renamed from: i, reason: collision with root package name */
    private QQCustomDialog f185575i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Observer<com.tencent.mobileqq.activity.recent.guidebanner.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerView.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.tencent.mobileqq.activity.recent.guidebanner.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NewerGuideBannerView.this.h(aVar);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f185578d;

        b(QBaseActivity qBaseActivity) {
            this.f185578d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerView.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NewerGuideBannerView.this.f185573f.f2(this.f185578d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f185580d;

        c(QBaseActivity qBaseActivity) {
            this.f185580d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerView.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NewerGuideBannerView.this.f185573f.e2(this.f185580d);
            }
        }
    }

    public NewerGuideBannerView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            g(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            QQCustomDialog qQCustomDialog = this.f185575i;
            if (qQCustomDialog != null) {
                if (qQCustomDialog.isShowing()) {
                    this.f185575i.dismiss();
                }
                this.f185575i = null;
            }
        } catch (Exception e16) {
            QLog.e("NewerGuideBannerView", 1, "[destroyPermissionDialog] err ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            QQProgressDialog qQProgressDialog = this.f185574h;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                this.f185574h = null;
            }
        } catch (Exception e16) {
            QLog.d("NewerGuideBannerView", 1, "hideProgressDialog exception", e16);
        }
    }

    private void g(Context context) {
        j(context);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.tencent.mobileqq.activity.recent.guidebanner.a aVar) {
        QLog.d("NewerGuideBannerView", 1, "initData  data = " + aVar);
        if (aVar == null) {
            return;
        }
        int i3 = aVar.f185591a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    n();
                    return;
                }
                return;
            }
            m(aVar.f185594d);
            return;
        }
        k(aVar.f185592b, aVar.f185593c);
    }

    private void i(LifecycleOwner lifecycleOwner) {
        this.f185573f.T1().observe(lifecycleOwner, new a());
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewerGuideBannerView.this);
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy(LifecycleOwner lifecycleOwner2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NewerGuideBannerView.this.f();
                    NewerGuideBannerView.this.e();
                    lifecycleOwner2.getLifecycle().removeObserver(this);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lifecycleOwner2);
            }
        });
    }

    private void j(Context context) {
        this.f185571d = new ImageView(context);
        this.f185571d.setLayoutParams(new FrameLayout.LayoutParams(-1, Utils.n(140.0f, getResources())));
        this.f185571d.setContentDescription(context.getString(R.string.f170812m2));
        ImageView imageView = new ImageView(getContext());
        this.f185572e = imageView;
        imageView.setBackgroundDrawable(null);
        this.f185572e.setImageResource(R.drawable.recent_newer_guide_banner_close);
        this.f185572e.setScaleType(ImageView.ScaleType.CENTER);
        int n3 = Utils.n(24.0f, getResources());
        int n16 = Utils.n(8.0f, getResources());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n3, n3);
        layoutParams.gravity = 8388661;
        layoutParams.rightMargin = n16;
        layoutParams.topMargin = n16;
        this.f185572e.setLayoutParams(layoutParams);
        this.f185572e.setOnClickListener(this);
        this.f185572e.setContentDescription(context.getString(R.string.vyu));
        setOnClickListener(this);
    }

    private void k(Drawable drawable, boolean z16) {
        if (drawable != null) {
            Utils.T(this.f185571d, null);
            Utils.T(this.f185571d, drawable);
            if (z16) {
                if (this.f185571d.getParent() == null) {
                    addView(this.f185571d);
                }
                if (this.f185572e.getParent() == null) {
                    addView(this.f185572e);
                }
            }
        }
    }

    private void l() {
        com.tencent.mobileqq.mvvm.d ph5 = QLifeCycleFragment.ph((QBaseActivity) getContext());
        this.f185573f = (NewerGuideBannerViewModel) h.b(ph5, NewerGuideBannerViewModel.E).get(NewerGuideBannerViewModel.class);
        i(ph5);
    }

    private void m(boolean z16) {
        if (z16) {
            o();
        } else {
            f();
        }
    }

    private void n() {
        try {
            QBaseActivity qBaseActivity = (QBaseActivity) getContext();
            if (this.f185575i == null) {
                this.f185575i = DialogUtil.createCustomDialog(qBaseActivity, 230, HardCodeUtil.qqStr(R.string.f170842m5), HardCodeUtil.qqStr(R.string.f170832m4), HardCodeUtil.qqStr(R.string.f170852m6), HardCodeUtil.qqStr(R.string.f170862m7), new b(qBaseActivity), new c(qBaseActivity));
            }
            if (!qBaseActivity.isFinishing()) {
                this.f185575i.show();
                ReportController.o(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 0, 0, "", "", "", "");
            }
        } catch (Exception e16) {
            QLog.e("NewerGuideBannerView", 1, "[showPermissionDeniedDialog] err ", e16);
        }
    }

    private void o() {
        try {
            if (this.f185574h == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext(), 0, R.layout.gza, 17);
                this.f185574h = qQProgressDialog;
                qQProgressDialog.setContentView(R.layout.bwu);
                this.f185574h.setMessage(getContext().getString(R.string.f170822m3));
                this.f185574h.setBackAndSearchFilter(false);
                this.f185574h.setCancelable(false);
            }
            this.f185574h.show();
        } catch (Exception e16) {
            QLog.d("NewerGuideBannerView", 1, "showProgressDialog exception", e16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            QBaseActivity qBaseActivity = (QBaseActivity) getContext();
            if (view == this.f185572e) {
                this.f185573f.c2(qBaseActivity.getAppRuntime());
            } else {
                this.f185573f.a2(qBaseActivity);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f185573f.h2((QBaseActivity) getContext());
        }
    }

    public void p(oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) oidb_0x59f_guidelines_8410);
        } else {
            this.f185573f.o2((QBaseActivity) getContext(), oidb_0x59f_guidelines_8410);
        }
    }

    public NewerGuideBannerView(@NonNull Context context, @androidx.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            g(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public NewerGuideBannerView(@NonNull Context context, @androidx.annotation.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            g(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
