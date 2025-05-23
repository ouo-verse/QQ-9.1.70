package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class CheckBoxPreference extends Preference {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f384464a;

    /* renamed from: b, reason: collision with root package name */
    public MMSwitchBtn f384465b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f384466c;

    /* renamed from: d, reason: collision with root package name */
    public int f384467d;

    /* renamed from: e, reason: collision with root package name */
    public String f384468e;

    /* renamed from: f, reason: collision with root package name */
    public int f384469f;

    /* renamed from: g, reason: collision with root package name */
    public View f384470g;

    /* loaded from: classes27.dex */
    public class a implements MMSwitchBtn.ISwitch {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CheckBoxPreference.this);
            }
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
        public void onStatusChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z16));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public boolean isChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        MMSwitchBtn mMSwitchBtn = this.f384465b;
        if (mMSwitchBtn != null) {
            return mMSwitchBtn.isCheck();
        }
        return this.f384464a;
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        super.onBindView(view);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) view.findViewById(R.id.axa);
        this.f384465b = mMSwitchBtn;
        mMSwitchBtn.setSwitchListener(new a());
        this.f384465b.setCheck(this.f384464a);
        if (!isEnabled()) {
            this.f384465b.setEnabled(false);
            ((TextView) view.findViewById(android.R.id.title)).setTextColor(view.getResources().getColor(R.color.b9e));
        }
        this.f384466c = (TextView) view.findViewById(R.id.f97765l_);
        setTipIcon(this.f384468e, this.f384467d);
        setTipIconVisible(this.f384469f);
    }

    @Override // android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
        }
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.content);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.fkq, viewGroup2);
        this.f384470g = onCreateView;
        return onCreateView;
    }

    public void setChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f384464a = z16;
        }
    }

    public void setTipIcon(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        this.f384467d = i3;
        this.f384468e = str;
        TextView textView = this.f384466c;
        if (textView != null) {
            if (i3 > 0) {
                textView.setBackgroundResource(i3);
            }
            if (!TextUtils.isEmpty(this.f384468e)) {
                this.f384466c.setText(this.f384468e);
            }
        }
    }

    public void setTipIconVisible(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.f384469f = i3;
        TextView textView = this.f384466c;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void updateCheckStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        MMSwitchBtn mMSwitchBtn = this.f384465b;
        if (mMSwitchBtn != null) {
            this.f384464a = z16;
            mMSwitchBtn.setCheck(z16);
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384464a = false;
        this.f384467d = -1;
        this.f384468e = "";
        this.f384469f = 8;
        setLayoutResource(R.layout.fkb);
    }
}
