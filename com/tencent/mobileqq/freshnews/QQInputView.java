package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQInputView extends RelativeLayout implements View.OnClickListener, EmoticonCallback, TextWatcher {
    static IPatchRedirector $redirector_;
    private Handler C;
    private BaseActivity D;
    private SystemAndEmojiEmoticonPanel E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    private InputBar f211509d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f211510e;

    /* renamed from: f, reason: collision with root package name */
    private XEditTextEx f211511f;

    /* renamed from: h, reason: collision with root package name */
    private Button f211512h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f211513i;

    /* renamed from: m, reason: collision with root package name */
    private long f211514m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
    }

    public QQInputView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f211514m = 0L;
        this.C = new Handler();
        this.F = 0;
        this.G = false;
        this.H = 50;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = Integer.MAX_VALUE;
        j(context);
    }

    static /* bridge */ /* synthetic */ a a(QQInputView qQInputView) {
        qQInputView.getClass();
        return null;
    }

    private void g() {
        f(Pattern.compile(" +$").matcher(Pattern.compile("^ +").matcher(Pattern.compile("\n").matcher(this.f211511f.getText().toString()).replaceAll("")).replaceAll("")).replaceAll("").length());
    }

    private void j(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168809av2, (ViewGroup) this, true);
        this.D = (BaseActivity) context;
        this.f211510e = (ImageView) super.findViewById(R.id.emo_btn);
        this.f211511f = (XEditTextEx) super.findViewById(R.id.input);
        this.f211512h = (Button) super.findViewById(R.id.send_btn);
        this.f211513i = (FrameLayout) super.findViewById(R.id.e3e);
        this.f211509d = (InputBar) super.findViewById(R.id.inputBar);
        this.E = TroopBarPublishUtils.a(getContext(), this.f211513i, this.f211511f, this);
        this.f211510e.setOnClickListener(this);
        this.f211512h.setOnClickListener(this);
        this.f211511f.addTextChangedListener(this);
        this.f211511f.setOnClickListener(this);
        if (AppSetting.f99565y) {
            this.f211511f.setContentDescription(HardCodeUtil.qqStr(R.string.qtg));
            this.f211512h.setContentDescription(HardCodeUtil.qqStr(R.string.qtc));
        }
        com.tencent.devicelib.a.a(getContext(), this.f211511f);
    }

    private void k() {
        this.F = 0;
        this.f211510e.setImageResource(R.drawable.asw);
        if (AppSetting.f99565y) {
            this.f211510e.setContentDescription(HardCodeUtil.qqStr(R.string.qtd));
        }
        this.E.setVisibility(8);
    }

    private void l(int i3) {
        this.F = i3;
        this.f211511f.requestFocus();
        if (this.F == 0) {
            this.C.post(new Runnable() { // from class: com.tencent.mobileqq.freshnews.QQInputView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQInputView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQInputView.this.E.setVisibility(8);
                    QQInputView.this.f211510e.setImageResource(R.drawable.asw);
                    if (AppSetting.f99565y) {
                        QQInputView.this.f211510e.setContentDescription(HardCodeUtil.qqStr(R.string.qte));
                    }
                    InputMethodUtil.show(QQInputView.this.f211511f);
                }
            });
            return;
        }
        InputMethodUtil.hide(this.f211511f);
        if (this.I == this.J) {
            this.C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.freshnews.QQInputView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQInputView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQInputView.this.E.setVisibility(0);
                    QQInputView.this.f211510e.setImageResource(R.drawable.buz);
                    if (AppSetting.f99565y) {
                        QQInputView.this.f211510e.setContentDescription(HardCodeUtil.qqStr(R.string.qtb));
                    }
                }
            }, 50L);
        } else {
            this.G = true;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) editable);
            return;
        }
        if (Pattern.compile(" +$").matcher(Pattern.compile("^ +").matcher(Pattern.compile("\n").matcher(this.f211511f.getText().toString()).replaceAll("")).replaceAll("")).replaceAll("").length() > 0) {
            this.f211512h.setEnabled(true);
            this.f211512h.setSelected(true);
        } else {
            this.f211512h.setEnabled(false);
            this.f211512h.setSelected(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            TextUtils.backspace(this.f211511f);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public boolean f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, i3)).booleanValue();
        }
        return true;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            l(this.F);
        }
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (view != null) {
            if (view == this.f211510e) {
                if (System.currentTimeMillis() - this.f211514m >= 500) {
                    this.f211514m = System.currentTimeMillis();
                    if (this.E.getVisibility() == 8) {
                        this.F = 1;
                    } else {
                        this.F = 0;
                    }
                    h();
                }
            } else if (view == this.f211512h) {
                g();
            } else if (view == this.f211511f) {
                l(0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int bottom = this.f211509d.getBottom();
        int top = this.f211509d.getTop();
        if (top <= 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("input", 2, "onLayout.bottom=" + bottom + ",top=" + top + ",mFistBottom" + this.J + " mLastBottom=" + this.I + ",mFirstTop=" + this.K + ",mLastTop=" + this.L);
        }
        if (this.J == 0) {
            this.J = bottom;
        }
        if (this.K == 0) {
            this.K = top;
        }
        if (z16 && i18 == this.J && this.I < i18) {
            if (this.G) {
                this.G = false;
                post(new Runnable() { // from class: com.tencent.mobileqq.freshnews.QQInputView.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQInputView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QQInputView.this.E.setVisibility(0);
                        QQInputView.this.f211510e.setImageResource(R.drawable.buz);
                        if (AppSetting.f99565y) {
                            QQInputView.this.f211510e.setContentDescription(HardCodeUtil.qqStr(R.string.qtf));
                        }
                    }
                });
            }
        } else {
            int i19 = this.K;
            if (top == i19 && top > this.L) {
                if (QLog.isColorLevel()) {
                    QLog.d("input", 2, "inputview hide");
                }
                this.f211511f.setHint(i());
                k();
            } else {
                int i26 = this.L;
                if (i26 == i19 && top != i26) {
                    if (QLog.isColorLevel()) {
                        QLog.d("input", 2, "inputview show");
                    }
                    if (android.text.TextUtils.isEmpty(this.f211511f.getText().toString()) && !android.text.TextUtils.isEmpty(null)) {
                        this.f211511f.setHint((CharSequence) null);
                        this.f211512h.setEnabled(false);
                        this.f211512h.setSelected(false);
                    }
                }
            }
        }
        this.I = bottom;
        this.L = top;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonInfo)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    public void setCallback(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.C.post(new Runnable() { // from class: com.tencent.mobileqq.freshnews.QQInputView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQInputView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQInputView.a(QQInputView.this);
                    if (android.text.TextUtils.isEmpty(null)) {
                        if (!android.text.TextUtils.isEmpty(null)) {
                            QQInputView.this.f211511f.setHint((CharSequence) null);
                            QQInputView.this.f211512h.setEnabled(false);
                            QQInputView.this.f211512h.setSelected(false);
                            return;
                        }
                        return;
                    }
                    QQInputView.this.f211511f.setText((CharSequence) null);
                    XEditTextEx unused = QQInputView.this.f211511f;
                    throw null;
                }
            });
        }
    }

    public void setContentMaxLength(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.H = i3;
            this.f211511f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
    }

    public void setHintTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        XEditTextEx xEditTextEx = this.f211511f;
        if (xEditTextEx != null) {
            xEditTextEx.setHintTextColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonInfo);
            return;
        }
        String obj = this.f211511f.getText() == null ? null : this.f211511f.getText().toString();
        if (android.text.TextUtils.isEmpty(obj) || (!android.text.TextUtils.isEmpty(obj) && obj.length() < 49)) {
            BaseActivity baseActivity = this.D;
            emoticonInfo.send(baseActivity.app, baseActivity, this.f211511f, null);
        }
    }

    public QQInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f211514m = 0L;
        this.C = new Handler();
        this.F = 0;
        this.G = false;
        this.H = 50;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = Integer.MAX_VALUE;
        j(context);
    }
}
