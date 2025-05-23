package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VoiceTextEditViewHelper extends com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.a implements View.OnClickListener, VoiceTextShowAnimator.a {
    private VoiceTextShowAnimator C;
    private int D;
    private TextWatcher E;
    TextView.OnEditorActionListener F;

    /* renamed from: i, reason: collision with root package name */
    private Handler f180213i;

    /* renamed from: m, reason: collision with root package name */
    private EditText f180214m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (i3 == 4) {
                c71.c cVar = VoiceTextEditViewHelper.this.f180227h;
                if (cVar != null) {
                    cVar.a();
                }
                e71.a.a("0X800A89F", 0, 0);
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    public VoiceTextEditViewHelper(d71.c cVar, AppRuntime appRuntime, Handler handler) {
        super(appRuntime, cVar);
        this.D = 0;
        this.E = new a();
        this.F = new b();
        this.f180213i = handler;
        this.C = new VoiceTextShowAnimator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        int i3 = this.D + 1;
        this.D = i3;
        if (i3 % 10 == 0 && !NetworkUtil.isNetworkAvailable()) {
            QLog.i("VoiceTextEditViewHelper", 1, "handleLoadingTxt  network unavailable");
            c().g(5);
            this.f180214m.setFocusableInTouchMode(true);
            this.C.m();
            return;
        }
        if (c().d()) {
            this.f180214m.setText(this.C.f());
        } else if (c().a()) {
            this.f180214m.setText(this.C.g(b().b(), false));
            this.f180214m.setSelection(this.C.h(), this.C.h());
        } else if (c().b()) {
            l();
        }
    }

    private void l() {
        String b16 = b().b();
        if (StringUtil.isEmpty(b16)) {
            this.f180214m.setText("");
            c().g(5);
            this.f180214m.setFocusableInTouchMode(true);
            this.C.m();
            QQToast.makeText(this.f180225e, HardCodeUtil.qqStr(R.string.f214705tm), 0).show(this.f180225e.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (this.C.l(b16)) {
            m();
            this.f180214m.setText(b16);
            this.C.m();
            this.f180214m.setFocusableInTouchMode(true);
            c().g(5);
            this.f180214m.setSelection(b16.length(), b16.length());
            return;
        }
        this.f180214m.setText(this.C.g(b16, false));
        this.f180214m.setSelection(this.C.h(), this.C.h());
    }

    private void m() {
        this.f180214m.setTextColor(this.f180225e.getResources().getColorStateList(R.color.qui_common_text_primary).getDefaultColor());
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.a
    public void a() {
        this.f180213i.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper.3
            @Override // java.lang.Runnable
            public void run() {
                VoiceTextEditViewHelper.this.k();
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.a
    public void e(c71.c cVar) {
        super.e(cVar);
        this.C.j(this.f180225e.getResources().getColorStateList(R.color.skin_gray2_theme_version2).getDefaultColor(), this);
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.a
    public void f(VoiceTextPanel voiceTextPanel) {
        super.f(voiceTextPanel);
        EditText editText = (EditText) voiceTextPanel.findViewById(R.id.bri);
        this.f180214m = editText;
        editText.setHorizontallyScrolling(false);
        this.f180214m.setLines(100);
        this.f180214m.setOnClickListener(this);
        this.f180214m.setOnEditorActionListener(this.F);
        this.f180214m.addTextChangedListener(this.E);
    }

    public void i() {
        this.f180214m.setText("");
    }

    public EditText j() {
        return this.f180214m;
    }

    public void n() {
        this.C.k();
    }

    public void o() {
        this.f180214m.setFocusable(true);
        this.f180214m.setFocusableInTouchMode(true);
        this.f180214m.requestFocus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (c().d() || c().a()) {
            QQToast.makeText(this.f180225e, HardCodeUtil.qqStr(R.string.f172918vj2), 0).show(this.f180225e.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        this.f180214m.setEnabled(true);
        this.f180214m.setFocusableInTouchMode(false);
    }

    public void q(String str) {
        this.f180214m.setText(str);
    }

    public void r() {
        this.C.m();
    }

    public void s() {
        this.f180214m.setText("");
        this.f180214m.setFocusableInTouchMode(true);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (VoiceTextEditViewHelper.this.f180226f.c().e()) {
                String obj = editable.toString();
                VoiceTextEditViewHelper.this.f180226f.b().c(obj);
                c71.c cVar = VoiceTextEditViewHelper.this.f180227h;
                if (cVar != null) {
                    cVar.b(obj);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
