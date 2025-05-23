package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements com.tencent.mobileqq.troop.activity.editinfo.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.troop.activity.editinfo.a f293716d;

    /* renamed from: e, reason: collision with root package name */
    private EditText f293717e;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f293718f;

    /* renamed from: h, reason: collision with root package name */
    private Context f293719h;

    /* renamed from: i, reason: collision with root package name */
    private String f293720i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.activity.editservice.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8663a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        C8663a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    String trim = new QQText(a.this.f293716d.getText(), 3).trim();
                    Intent intent = new Intent();
                    intent.putExtra("result", trim);
                    a.this.f293716d.onFinishForResult(-1, intent);
                    return;
                }
                return;
            }
            a.this.f293716d.onFinish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TextUtils.backspace(a.this.f293717e);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonInfo)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, emoticonInfo, emoticonInfo2, drawable);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                emoticonInfo.send(a.this.f293718f, a.this.f293719h, a.this.f293717e, null);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public View.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, viewGroup, editText, viewGroup2);
        } else {
            this.f293717e = editText;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonCallback) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public Intent f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        this.f293720i = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void g(com.tencent.mobileqq.troop.activity.editinfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f293718f = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f293719h = aVar.getContext();
        this.f293716d = aVar;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public TextView.OnEditorActionListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView.OnEditorActionListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public com.tencent.mobileqq.widget.navbar.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.widget.navbar.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new C8663a();
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
