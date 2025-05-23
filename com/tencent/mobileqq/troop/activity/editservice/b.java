package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements com.tencent.mobileqq.troop.activity.editinfo.b {
    static IPatchRedirector $redirector_;
    private static String C;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.troop.activity.editinfo.a f293723d;

    /* renamed from: e, reason: collision with root package name */
    private Context f293724e;

    /* renamed from: f, reason: collision with root package name */
    private String f293725f;

    /* renamed from: h, reason: collision with root package name */
    private String f293726h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f293727i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f293728m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(b.C, 2, "onItemSelect: item + ", Integer.valueOf(i3));
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    QQText qQText = new QQText(b.this.f293723d.getText(), 3);
                    String qQText2 = qQText.toString();
                    String trim = qQText.trim();
                    if (trim.equals(b.this.f293725f)) {
                        if (trim.trim().isEmpty()) {
                            QQToast.makeText(b.this.f293723d.getContext(), 1, b.this.f293724e.getString(R.string.f235057am), 0).show();
                        }
                        b.this.f293723d.onFinish();
                        return;
                    } else {
                        if (!TextUtils.isEmpty(qQText2) && TextUtils.isEmpty(trim)) {
                            QQToast.makeText(b.this.f293723d.getContext(), b.this.f293724e.getString(R.string.f160781vy), 0).show();
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("result", trim);
                        b.this.f293723d.onFinishForResult(-1, intent);
                        return;
                    }
                }
                return;
            }
            b.this.f293723d.onFinish();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.activity.editservice.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class ViewOnClickListenerC8664b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC8664b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            C = "EditTroopNameService";
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293723d = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public View.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ViewOnClickListenerC8664b();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else if (i3 == 0) {
            this.f293728m = true;
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, viewGroup, editText, viewGroup2);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public EmoticonCallback e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EmoticonCallback) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public Intent f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        this.f293725f = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        this.f293727i = intent.getBooleanExtra("edit_mode", false);
        this.f293726h = intent.getStringExtra("troopUin");
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void g(com.tencent.mobileqq.troop.activity.editinfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f293723d = aVar;
            this.f293724e = aVar.getContext();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public TextView.OnEditorActionListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView.OnEditorActionListener) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public com.tencent.mobileqq.widget.navbar.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.widget.navbar.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onTextChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
