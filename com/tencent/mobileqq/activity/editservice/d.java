package com.tencent.mobileqq.activity.editservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemarkParams;
import com.tencent.qqnt.kernel.nativeinterface.RemarkSceneId;
import com.tencent.qqnt.kernel.nativeinterface.RemarkSignExtInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.UiThreadUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements com.tencent.mobileqq.troop.activity.editinfo.b {
    static IPatchRedirector $redirector_;
    private Intent C;
    private String D;
    private EditText E;
    private int F;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f181990d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.troop.activity.editinfo.a f181991e;

    /* renamed from: f, reason: collision with root package name */
    private Context f181992f;

    /* renamed from: h, reason: collision with root package name */
    private String f181993h;

    /* renamed from: i, reason: collision with root package name */
    private String f181994i;

    /* renamed from: m, reason: collision with root package name */
    private String f181995m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
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
                    QQText qQText = new QQText(d.this.f181991e.getText(), 3);
                    String qQText2 = qQText.toString();
                    String trim = qQText.trim();
                    if (!TextUtils.isEmpty(qQText2) && TextUtils.isEmpty(qQText2.trim())) {
                        QQToast.makeText(d.this.f181992f, d.this.f181992f.getString(R.string.buc), 0).show();
                    }
                    if (TextUtils.isEmpty(trim)) {
                        if (d.this.f181994i != null) {
                            trim = d.this.f181994i;
                        } else {
                            trim = "";
                        }
                    }
                    if (trim.equals(d.this.f181993h)) {
                        d.this.f181991e.onFinish();
                        return;
                    }
                    if (!NetworkUtil.isNetSupport(d.this.f181990d.getApplication().getApplicationContext())) {
                        QQToast.makeText(d.this.f181991e.getContext(), 1, R.string.f171139ci4, 0).show();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EditFriendRemarkService", 2, String.format("edit friend remark, uin: %s, result: %s", d.this.f181995m, trim));
                    }
                    d.this.f181991e.loadingProgress(true);
                    d.this.y(trim);
                    return;
                }
                return;
            }
            d.this.f181991e.onFinish();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f181991e = null;
        this.F = 3;
        this.G = "";
    }

    private RemarkParams t(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("EditFriendRemarkService", 1, "getRemarkSignExtInfo source: " + this.F + " mTroopUin: " + this.G);
        }
        RemarkParams remarkParams = new RemarkParams(str, str2, null);
        int i3 = this.F;
        if (i3 == 0 || i3 == 1) {
            if (!TextUtils.isEmpty(this.G) && TextUtils.isDigitsOnly(this.G)) {
                remarkParams.signInfo = new RemarkSignExtInfo(RemarkSceneId.GROUP, null, Long.valueOf(Long.parseLong(this.G)), new byte[0]);
            } else {
                remarkParams.signInfo = new RemarkSignExtInfo(RemarkSceneId.GROUP, null, null, new byte[0]);
            }
        }
        return remarkParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean v(CharSequence charSequence, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.E.setText(charSequence);
            Selection.setSelection(this.E.getEditableText(), this.E.getText().length());
            this.E.setOnTouchListener(null);
            this.E.setHint((CharSequence) null);
            this.f181994i = "";
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(int i3, String str) {
        this.f181991e.loadingProgress(false);
        if (i3 == 0) {
            this.C.putExtra("result", str);
            this.f181991e.onFinishForResult(-1, this.C);
        } else {
            QQToast.makeText(this.f181992f, 0, R.string.cab, 0).show();
            this.f181991e.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final String str, final int i3, String str2) {
        QLog.i("EditFriendRemarkService", 2, "setRemarkName onResult: " + i3 + " ,errMsg: " + str2);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.w(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final String str) {
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null) {
            QLog.e("EditFriendRemarkService", 1, "setRemarkName service is null");
        } else {
            QLog.i("EditFriendRemarkService", 2, "setRemarkName");
            b16.setBuddyRemark(t(this.D, str), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.editservice.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    d.this.x(str, i3, str2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public View.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (i3 == 1) {
            u();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, viewGroup, editText, viewGroup2);
            return;
        }
        this.E = editText;
        if (TextUtils.isEmpty(this.f181993h) && !TextUtils.isEmpty(this.f181994i)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            final SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.f181994i, 16);
            this.E.setHint(spannableStringFromColorNickText);
            this.E.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.activity.editservice.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean v3;
                    v3 = d.this.v(spannableStringFromColorNickText, view, motionEvent);
                    return v3;
                }
            });
        } else {
            this.E.setHint((CharSequence) null);
            this.f181994i = "";
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public EmoticonCallback e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (EmoticonCallback) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public Intent f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        }
        this.f181993h = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        this.f181994i = intent.getStringExtra("default_hint");
        this.f181995m = intent.getStringExtra("uin");
        this.C = intent;
        String stringExtra = intent.getStringExtra("uid");
        this.D = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.D = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f181995m);
        }
        this.F = intent.getIntExtra("from", 3);
        this.G = intent.getStringExtra("troopUin");
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void g(com.tencent.mobileqq.troop.activity.editinfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f181990d = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f181991e = aVar;
        this.f181992f = aVar.getContext();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public TextView.OnEditorActionListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextView.OnEditorActionListener) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public com.tencent.mobileqq.widget.navbar.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.widget.navbar.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onTextChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        EditText editText = this.E;
        if (editText == null) {
            return;
        }
        editText.clearFocus();
        Context context = this.E.getContext();
        if (context == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.E.getWindowToken(), 0);
    }
}
