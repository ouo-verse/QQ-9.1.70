package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class ChatHistoryBaseFragment extends BaseFragment {
    static IPatchRedirector $redirector_;
    public QQAppInterface C;
    public boolean D;
    public boolean E;
    private int F;
    protected BaseActivity G;
    protected String H;
    protected View I;
    protected Handler J;
    protected Dialog K;
    protected ProgressView L;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnCancelListener f182513d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CharSequence f182514e;
        final /* synthetic */ ChatHistoryBaseFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.getBaseActivity() != null && !this.this$0.getBaseActivity().isFinishing()) {
                ChatHistoryBaseFragment chatHistoryBaseFragment = this.this$0;
                Dialog dialog = chatHistoryBaseFragment.K;
                if (dialog == null) {
                    chatHistoryBaseFragment.L = new ProgressView(this.this$0.getBaseActivity());
                    ChatHistoryBaseFragment chatHistoryBaseFragment2 = this.this$0;
                    chatHistoryBaseFragment2.K = new ReportDialog(chatHistoryBaseFragment2.getBaseActivity());
                    this.this$0.K.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    this.this$0.K.setCanceledOnTouchOutside(false);
                    this.this$0.K.requestWindowFeature(1);
                    ChatHistoryBaseFragment chatHistoryBaseFragment3 = this.this$0;
                    chatHistoryBaseFragment3.K.setContentView(chatHistoryBaseFragment3.L);
                    this.this$0.K.setOnCancelListener(this.f182513d);
                } else {
                    dialog.dismiss();
                }
                this.this$0.L.b(this.f182514e);
                this.this$0.K.show();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ChatHistoryBaseFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                Dialog dialog = this.this$0.K;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public ChatHistoryBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.J = new Handler(Looper.getMainLooper());
        }
    }

    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            sh();
        }
    }

    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        this.I = view;
        if (view != null && this.E) {
            qh();
            this.D = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryBaseFragment", 2, "onViewCreated " + rh());
        }
    }

    public void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public int rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.F;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            super.setUserVisibleHint(z16);
            this.E = z16;
        }
    }

    protected abstract void sh();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class ProgressView extends FrameLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ProgressBar f182515d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f182516e;

        public ProgressView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a(context);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        private void a(Context context) {
            LayoutInflater.from(context).inflate(R.layout.baj, this);
            this.f182515d = (ProgressBar) findViewById(R.id.g1f);
            this.f182516e = (TextView) findViewById(R.id.jfb);
        }

        public void b(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
            } else if (charSequence != null && charSequence.length() > 0) {
                this.f182516e.setVisibility(0);
                this.f182516e.setText(charSequence);
            } else {
                this.f182516e.setVisibility(8);
            }
        }

        public ProgressView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a(context);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            }
        }
    }
}
