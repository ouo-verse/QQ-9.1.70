package com.tencent.mobileqq.copyprompt;

import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.o;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.helper.u;
import com.tencent.mobileqq.activity.i;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.copyprompt.CopyPromptManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* loaded from: classes10.dex */
public class CopyPromptHelper implements u, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private CopyPromptManager C;
    private TextWatcher D;
    private Runnable E;

    /* renamed from: d, reason: collision with root package name */
    private a61.c f203004d;

    /* renamed from: e, reason: collision with root package name */
    private View f203005e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f203006f;

    /* renamed from: h, reason: collision with root package name */
    private o f203007h;

    /* renamed from: i, reason: collision with root package name */
    private long f203008i;

    /* renamed from: m, reason: collision with root package name */
    private int f203009m;

    /* renamed from: com.tencent.mobileqq.copyprompt.CopyPromptHelper$6, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CopyPromptHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.this$0.f203005e != null && this.this$0.f203005e.getParent() != null) {
                ((RelativeLayout) this.this$0.f203004d.f25594s.findViewById(R.id.aua)).removeView(this.this$0.f203005e);
                this.this$0.f203005e = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements CopyPromptManager.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CopyPromptHelper.this);
            }
        }

        @Override // com.tencent.mobileqq.copyprompt.CopyPromptManager.a
        public void onResult(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CopyPromptHelper.this.o(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements o.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CopyPromptHelper.this);
            }
        }

        @Override // com.tencent.biz.o.a
        public void N1(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!z16) {
                CopyPromptHelper.this.f203006f.removeCallbacks(CopyPromptHelper.this.E);
                CopyPromptHelper.this.E.run();
                if (CopyPromptHelper.this.f203007h != null) {
                    CopyPromptHelper.this.f203007h.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203013d;

        c(String str) {
            this.f203013d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CopyPromptHelper.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CopyPromptHelper.this.f203006f.removeCallbacks(CopyPromptHelper.this.E);
                CopyPromptHelper.this.E.run();
                int selectionStart = CopyPromptHelper.this.f203004d.f25587l.getSelectionStart();
                Editable editableText = CopyPromptHelper.this.f203004d.f25587l.getEditableText();
                if (selectionStart >= 0 && selectionStart < editableText.length()) {
                    editableText.insert(selectionStart, this.f203013d);
                } else {
                    editableText.append((CharSequence) this.f203013d);
                }
                ReportController.o(CopyPromptHelper.this.f203004d.f(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private View j(String str) {
        View inflate = LayoutInflater.from(this.f203004d.f25578c).inflate(R.layout.f168396ut, this.f203004d.f25594s, false);
        ((TextView) inflate.findViewById(R.id.g2m)).setText(new QQText(str, 3, 16));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(2, R.id.inputBar);
        layoutParams.leftMargin = BaseAIOUtils.f(14.0f, this.f203004d.f25578c.getResources());
        ((RelativeLayout) this.f203004d.f25594s.findViewById(R.id.aua)).addView(inflate, layoutParams);
        ReportController.o(this.f203004d.f(), "dc00898", "", "", "0X800B22B", "0X800B22B", 0, 0, "", "", "", "");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("CopyPromptHelper", 2, "handlePrompt content : " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            l();
            this.f203005e = j(str);
            this.f203006f.postDelayed(this.E, 5000L);
            p();
            q(str);
        }
    }

    private boolean m(int i3) {
        if (i3 != 0 && i3 != 1 && !i.a(i3)) {
            return true;
        }
        return false;
    }

    private void n() {
        Manager manager = this.f203004d.f25577b.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
        if (manager instanceof CopyPromptManager) {
            CopyPromptManager copyPromptManager = (CopyPromptManager) manager;
            if (Build.VERSION.SDK_INT > 27) {
                this.C = copyPromptManager;
                copyPromptManager.f(new a());
            } else {
                k(copyPromptManager.e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        ThreadManager.getUIHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.copyprompt.CopyPromptHelper.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f203010d;

            {
                this.f203010d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CopyPromptHelper.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (CopyPromptHelper.this.f203009m != 15) {
                    CopyPromptHelper.this.k(this.f203010d);
                }
            }
        });
    }

    private void p() {
        if (this.f203007h == null) {
            this.f203007h = new o(this.f203004d.f25594s, new b());
        }
    }

    private void q(String str) {
        View view = this.f203005e;
        if (view != null) {
            view.setOnClickListener(new c(str));
        }
    }

    private boolean r() {
        if (this.f203004d.f25594s.findViewById(R.id.awh).getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f203006f.removeCallbacks(this.E);
            this.E.run();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f203008i + 2000 <= System.currentTimeMillis()) {
                this.f203008i = currentTimeMillis;
                if (!r()) {
                    n();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (i3 != 4) {
            if (i3 == 15) {
                this.f203009m = 15;
                this.f203006f.removeCallbacks(this.E);
                this.E.run();
                o oVar = this.f203007h;
                if (oVar != null) {
                    oVar.a();
                    this.f203007h = null;
                }
                XEditTextEx xEditTextEx = this.f203004d.f25587l;
                if (xEditTextEx != null) {
                    xEditTextEx.removeTextChangedListener(this.D);
                }
                CopyPromptManager copyPromptManager = this.C;
                if (copyPromptManager != null) {
                    copyPromptManager.h(null);
                    return;
                }
                return;
            }
            return;
        }
        this.f203009m = 4;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_aio_paste_bubble_view") || m(this.f203004d.f25589n.f179555d)) {
            this.f203004d.f25587l.b(this);
        }
        this.f203004d.f25587l.addTextChangedListener(this.D);
    }
}
