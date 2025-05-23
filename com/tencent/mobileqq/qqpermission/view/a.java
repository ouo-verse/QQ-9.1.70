package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends ReportDialog {
    static IPatchRedirector $redirector_;
    private static int I;
    private TextView C;
    private TextView D;
    private View.OnClickListener E;
    private View.OnClickListener F;
    private QUIButton G;
    private QUIButton H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqpermission.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class ViewOnClickListenerC8424a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC8424a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (a.this.E != null) {
                    a.this.E.onClick(view);
                }
                a.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (a.this.F != null) {
                    a.this.F.onClick(view);
                }
                a.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            QLog.d("MultiSceneAuthDialog", 1, "onClick how auth");
            String qqStr = HardCodeUtil.qqStr(R.string.f202904yr);
            String qqStr2 = HardCodeUtil.qqStr(R.string.f202894yq);
            a aVar = a.this;
            aVar.showHintDialog(aVar.getContext(), qqStr, qqStr2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setUnderlineText(false);
                textPaint.setColor(a.this.getContext().getResources().getColor(R.color.qui_common_text_link));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements DialogInterface.OnShowListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f274351d;

        d(a aVar) {
            this.f274351d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) aVar);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QLog.d("MultiSceneAuthDialog", 1, "MultiSceneAuthDialog height: " + this.f274351d.setAndGetDialogHeight());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33002);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            I = 0;
        }
    }

    public a(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            setContentView(R.layout.gzg);
            initViews();
        }
    }

    private void initViews() {
        this.C = (TextView) findViewById(R.id.f79804_r);
        this.D = (TextView) findViewById(R.id.f79754_m);
        this.G = (QUIButton) findViewById(R.id.f79794_q);
        this.H = (QUIButton) findViewById(R.id.f79744_l);
        this.G.setOnClickListener(new ViewOnClickListenerC8424a());
        this.H.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHintDialog(Context context, String str, String str2) {
        com.tencent.mobileqq.qqpermission.view.b N = com.tencent.mobileqq.qqpermission.view.b.N(context, str, str2);
        N.setDialogHeight(I);
        try {
            N.show();
        } catch (WindowManager.BadTokenException e16) {
            QLog.e("MultiSceneAuthDialog", 1, "toShowHintDialog " + e16.getMessage());
        }
    }

    public void Q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        if (str.length() <= 6) {
            QLog.e("MultiSceneAuthDialog", 1, "setContent error!");
            this.D.setText(str);
        }
        this.D.setMovementMethod(LinkMovementMethod.getInstance());
        this.D.setHighlightColor(0);
        spannableString.setSpan(new c(), str.length() - 6, str.length(), 33);
        setOnShowListener(new d(this));
        this.D.setText(spannableString);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public void setAllowClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onClickListener);
        } else {
            this.F = onClickListener;
        }
    }

    public int setAndGetDialogHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            I = decorView.getHeight();
        }
        return I;
    }

    public void setRefuseClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onClickListener);
        } else {
            this.E = onClickListener;
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.C.setText(str);
        }
    }
}
