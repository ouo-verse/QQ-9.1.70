package com.tencent.mobileqq.activity.verifysms;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableTextView;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements com.tencent.mobileqq.activity.verifysms.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View f186624a;

    /* renamed from: b, reason: collision with root package name */
    private AlphaClickableTextView f186625b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f186626c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f186627d;

    /* renamed from: e, reason: collision with root package name */
    private View f186628e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f186629f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f186630g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f186631h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f186632i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
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
            boolean z16 = true;
            int i18 = 0;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TextView textView = d.this.f186631h;
                if (charSequence == null || charSequence.length() < 6) {
                    z16 = false;
                }
                textView.setEnabled(z16);
                ImageView imageView = d.this.f186630g;
                if (charSequence == null || charSequence.length() <= 0) {
                    i18 = 8;
                }
                imageView.setVisibility(i18);
                return;
            }
            iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public d(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, layoutInflater, viewGroup, onClickListener);
            return;
        }
        View inflate = layoutInflater.inflate(R.layout.f168820gy2, viewGroup, false);
        viewGroup.addView(inflate);
        j(inflate, onClickListener);
    }

    private void j(View view, View.OnClickListener onClickListener) {
        this.f186624a = view;
        view.findViewById(R.id.f166990jp4).setBackground(null);
        this.f186626c = (TextView) view.findViewById(R.id.f109946h7);
        this.f186627d = (TextView) view.findViewById(R.id.f107076_f);
        this.f186628e = view.findViewById(R.id.u_7);
        int m3 = xy2.b.m(view.getResources().getColor(R.color.qui_common_text_primary), 127);
        this.f186626c.setTextColor(m3);
        this.f186627d.setTextColor(m3);
        this.f186628e.setAlpha(0.5f);
        this.f186629f = (EditText) view.findViewById(R.id.f165048uq0);
        this.f186630g = (ImageView) view.findViewById(R.id.y1g);
        this.f186631h = (TextView) view.findViewById(R.id.b7p);
        this.f186632i = (TextView) view.findViewById(R.id.aji);
        this.f186629f.addTextChangedListener(new a());
        this.f186630g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.verifysms.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.k(view2);
            }
        });
        AlphaClickableTextView alphaClickableTextView = (AlphaClickableTextView) view.findViewById(R.id.tfu);
        this.f186625b = alphaClickableTextView;
        alphaClickableTextView.setOnClickListener(onClickListener);
        this.f186631h.setOnClickListener(onClickListener);
        this.f186632i.setOnClickListener(onClickListener);
        if (FontSettingManager.getFontLevel() >= 20.0f) {
            this.f186626c.setPadding(ViewUtils.dpToPx(68.0f), 0, ViewUtils.dpToPx(16.0f), 0);
            this.f186626c.setTextSize(17.0f);
            this.f186627d.setTextSize(17.0f);
            this.f186629f.setTextSize(17.0f);
        } else if (FontSettingManager.getFontLevel() >= 17.0f) {
            this.f186626c.setPadding(ViewUtils.dpToPx(48.0f), 0, ViewUtils.dpToPx(16.0f), 0);
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f186629f.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        EditText editText = this.f186629f;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void c(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            this.f186632i.setEnabled(true);
            this.f186632i.setClickable(true);
            TextView textView = this.f186632i;
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_link_selector));
            if (z17) {
                this.f186632i.setText(R.string.f172945g10);
                return;
            } else {
                this.f186632i.setText(R.string.f216635yu);
                return;
            }
        }
        this.f186632i.setEnabled(false);
        this.f186632i.setClickable(false);
        TextView textView2 = this.f186632i;
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qui_common_text_secondary));
        this.f186632i.setText(this.f186632i.getContext().getString(R.string.f172945g10) + "(" + i3 + "s)");
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void clearWrongCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        EditText editText = this.f186629f;
        if (editText != null) {
            editText.setText("");
        }
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public boolean d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (!TextUtils.isEmpty(str)) {
            if (!str.trim().startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = Marker.ANY_NON_NULL_MARKER + str.trim();
            }
            this.f186627d.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f186626c.setText(str2);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (z.b(this.f186624a.getContext())) {
            z.w(this.f186624a.findViewById(R.id.jpx));
            z.w(this.f186624a.findViewById(R.id.f113286q8));
            z.w(this.f186624a.findViewById(R.id.bz6));
            z.w(this.f186624a.findViewById(R.id.f107886bm));
            return;
        }
        z.A(this.f186624a.findViewById(R.id.jpx));
        z.A(this.f186624a.findViewById(R.id.f113286q8));
        z.A(this.f186624a.findViewById(R.id.bz6));
        z.A(this.f186624a.findViewById(R.id.f107886bm));
    }

    @Override // com.tencent.mobileqq.activity.verifysms.a
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
