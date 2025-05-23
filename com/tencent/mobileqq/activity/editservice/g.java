package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g implements com.tencent.mobileqq.troop.activity.editinfo.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f182002d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.troop.activity.editinfo.a f182003e;

    /* renamed from: f, reason: collision with root package name */
    private Context f182004f;

    /* renamed from: h, reason: collision with root package name */
    private String f182005h;

    /* renamed from: i, reason: collision with root package name */
    private String f182006i;

    /* renamed from: m, reason: collision with root package name */
    private Intent f182007m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
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
                    QQText qQText = new QQText(g.this.f182003e.getText(), 3);
                    String qQText2 = qQText.toString();
                    String trim = qQText.trim();
                    if (!g.this.s(qQText2, trim)) {
                        return;
                    }
                    if (trim.equals(g.this.f182005h)) {
                        g.this.f182003e.onFinish();
                        return;
                    }
                    if (!NetworkUtil.isNetSupport(g.this.f182002d.getApplication().getApplicationContext())) {
                        QQToast.makeText(g.this.f182004f, 1, R.string.f171139ci4, 0).show();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EditMyNickService", 2, String.format("edit self nick, uin: %s, result: %s", g.this.f182006i, trim));
                    }
                    if (g.this.f182006i != null && !g.this.f182006i.equals(g.this.f182002d.getCurrentAccountUin())) {
                        return;
                    }
                    g.this.f182003e.loadingProgress(true);
                    g.this.w(trim);
                    return;
                }
                return;
            }
            g.this.f182003e.onFinish();
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182003e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Context context = this.f182004f;
            QQToast.makeText(context, context.getString(R.string.bu_), 0).show();
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            Context context2 = this.f182004f;
            QQToast.makeText(context2, context2.getString(R.string.bua), 0).show();
            return false;
        }
        return true;
    }

    public static void t(int i3) {
        if (i3 != 0) {
            if (i3 != 36) {
                if (i3 != 54) {
                    if (i3 != 39 && i3 != 40) {
                        QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.zto));
                        return;
                    } else {
                        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f225576m0));
                        return;
                    }
                }
                QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.ztn));
                return;
            }
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.ztp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(int i3, String str) {
        this.f182003e.loadingProgress(false);
        if (i3 == 0) {
            this.f182007m.putExtra("result", str);
            this.f182003e.onFinishForResult(-1, this.f182007m);
        } else {
            t(i3);
            this.f182003e.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(final String str, final int i3, String str2) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.u(i3, str);
            }
        });
        QLog.d("EditMyNickService", 1, String.format("setSelfNick callback, result: %s, errMsg:%s", Integer.valueOf(i3), str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final String str) {
        y profileService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e("EditMyNickService", 1, "setSelfNick service is null");
        } else {
            profileService.l0(str, new IOperateCallback() { // from class: com.tencent.mobileqq.activity.editservice.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    g.this.v(str, i3, str2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public View.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, viewGroup, editText, viewGroup2);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public EmoticonCallback e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EmoticonCallback) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public Intent f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        this.f182005h = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        this.f182006i = intent.getStringExtra("uin");
        this.f182007m = intent;
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void g(com.tencent.mobileqq.troop.activity.editinfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f182002d = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f182003e = aVar;
        this.f182004f = aVar.getContext();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public TextView.OnEditorActionListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView.OnEditorActionListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public com.tencent.mobileqq.widget.navbar.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.widget.navbar.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onTextChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
