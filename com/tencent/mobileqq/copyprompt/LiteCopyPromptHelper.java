package com.tencent.mobileqq.copyprompt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.o;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import mqq.manager.Manager;

/* loaded from: classes10.dex */
public class LiteCopyPromptHelper implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private XEditTextEx C;
    private o D;
    private TextWatcher E;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private View f203020d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f203021e;

    /* renamed from: f, reason: collision with root package name */
    private long f203022f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f203023h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f203024i;

    /* renamed from: m, reason: collision with root package name */
    private Context f203025m;

    /* loaded from: classes10.dex */
    class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteCopyPromptHelper.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else if (!TextUtils.isEmpty(charSequence)) {
                LiteCopyPromptHelper.this.j();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteCopyPromptHelper.this);
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
                LiteCopyPromptHelper.this.f203021e.removeCallbacks(LiteCopyPromptHelper.this.F);
                LiteCopyPromptHelper.this.F.run();
                if (LiteCopyPromptHelper.this.D != null) {
                    LiteCopyPromptHelper.this.D.a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203028d;

        c(String str) {
            this.f203028d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiteCopyPromptHelper.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LiteCopyPromptHelper.this.f203021e.removeCallbacks(LiteCopyPromptHelper.this.F);
                LiteCopyPromptHelper.this.F.run();
                int selectionStart = LiteCopyPromptHelper.this.C.getSelectionStart();
                Editable editableText = LiteCopyPromptHelper.this.C.getEditableText();
                if (selectionStart >= 0 && selectionStart < editableText.length()) {
                    editableText.insert(selectionStart, this.f203028d);
                } else {
                    editableText.append((CharSequence) this.f203028d);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public LiteCopyPromptHelper(Context context, ViewGroup viewGroup, QQAppInterface qQAppInterface, XEditTextEx xEditTextEx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, viewGroup, qQAppInterface, xEditTextEx);
            return;
        }
        this.f203021e = new Handler(Looper.getMainLooper());
        this.E = new a();
        this.F = new Runnable() { // from class: com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiteCopyPromptHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (LiteCopyPromptHelper.this.f203020d != null && LiteCopyPromptHelper.this.f203020d.getParent() != null) {
                    ((RelativeLayout) LiteCopyPromptHelper.this.f203024i.findViewById(R.id.aua)).removeView(LiteCopyPromptHelper.this.f203020d);
                    LiteCopyPromptHelper.this.f203020d = null;
                }
            }
        };
        this.f203023h = qQAppInterface;
        this.f203024i = viewGroup;
        this.f203025m = context;
        this.C = xEditTextEx;
    }

    private View i(String str) {
        View inflate = LayoutInflater.from(this.f203025m).inflate(R.layout.f168396ut, this.f203024i, false);
        ((TextView) inflate.findViewById(R.id.g2m)).setText(new QQText(str, 3, 16));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(2, R.id.inputBar);
        layoutParams.leftMargin = BaseAIOUtils.f(14.0f, this.f203025m.getResources());
        ((RelativeLayout) this.f203024i.findViewById(R.id.aua)).addView(inflate, layoutParams);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f203021e.removeCallbacks(this.F);
        this.F.run();
    }

    private void k() {
        if (this.D == null) {
            this.D = new o(this.f203024i, new b());
        }
    }

    private void l(String str) {
        View view = this.f203020d;
        if (view != null) {
            view.setOnClickListener(new c(str));
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        XEditTextEx xEditTextEx = this.C;
        if (xEditTextEx != null) {
            xEditTextEx.b(this);
            this.C.addTextChangedListener(this.E);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f203021e.removeCallbacks(this.F);
        this.F.run();
        XEditTextEx xEditTextEx = this.C;
        if (xEditTextEx != null) {
            xEditTextEx.removeTextChangedListener(this.E);
        }
        o oVar = this.D;
        if (oVar != null) {
            oVar.a();
            this.D = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f203022f + 2000 <= System.currentTimeMillis()) {
                this.f203022f = currentTimeMillis;
                Manager manager = this.f203023h.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
                if (manager instanceof CopyPromptManager) {
                    String e16 = ((CopyPromptManager) manager).e();
                    if (!TextUtils.isEmpty(e16)) {
                        j();
                        this.f203020d = i(e16);
                        this.f203021e.postDelayed(this.F, 5000L);
                        k();
                        l(e16);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
