package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.WebSsoBody$WebSsoRequestBody;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.s;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j extends PublicCommentWindow {
    static IPatchRedirector $redirector_;
    Context W;
    protected boolean X;
    String Y;
    String Z;

    /* renamed from: a0, reason: collision with root package name */
    String f293748a0;

    /* renamed from: b0, reason: collision with root package name */
    String f293749b0;

    /* renamed from: c0, reason: collision with root package name */
    String f293750c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f293751d0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            j.this.E.setEnabled(true);
            j.this.U.getString(R.string.dun);
            try {
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody = new WebSsoBody$WebSsoResponseBody();
                        webSsoBody$WebSsoResponseBody.mergeFrom(byteArray);
                        int i16 = webSsoBody$WebSsoResponseBody.ret.get();
                        JSONObject jSONObject = new JSONObject(webSsoBody$WebSsoResponseBody.data.get());
                        if (i16 != 0) {
                            string = jSONObject.optString("msg");
                            if (TextUtils.isEmpty(string)) {
                                string = j.this.U.getString(R.string.duo, Integer.valueOf(i16));
                            }
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                            j jVar = j.this;
                            s.b("two_comment", "suc", jVar.Y, jVar.f293750c0, "", "");
                            j jVar2 = j.this;
                            jVar2.N = true;
                            jVar2.Q(jVar2.V, jSONObject2.toString(), true);
                            j.this.dismiss();
                            return;
                        }
                    } else {
                        string = j.this.U.getString(R.string.duo, 9991);
                    }
                } else {
                    string = j.this.U.getString(R.string.duo, 9992);
                }
            } catch (Exception unused) {
                string = j.this.U.getString(R.string.duo, 9992);
            }
            QQToast.makeText(j.this.U, 1, string, 0).show(j.this.U.getTitleBarHeight());
            s.b("two_comment", "fail", j.this.Y, "4", "", "");
            j.this.X = false;
        }
    }

    public j(QBaseActivity qBaseActivity, Bundle bundle) {
        super(qBaseActivity, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        this.X = false;
        this.f293750c0 = "0";
        this.W = qBaseActivity.getApplicationContext();
    }

    @Override // com.tencent.mobileqq.troop.activity.PublicCommentWindow
    protected void N(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (this.X) {
            return;
        }
        this.X = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pid", this.Z);
            jSONObject.put("cid", this.f293748a0);
            jSONObject.put("bid", Long.parseLong(this.Y));
            jSONObject.put("target_rid", this.f293749b0);
            jSONObject.put("comment", TroopBarPublishUtils.c(str, null, null));
            jSONObject.put("version", AppSetting.f99554n);
            jSONObject.put("extparam", this.f293751d0);
            NewIntent newIntent = new NewIntent(this.W, com.tencent.biz.m.class);
            newIntent.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
            WebSsoBody$WebSsoRequestBody webSsoBody$WebSsoRequestBody = new WebSsoBody$WebSsoRequestBody();
            webSsoBody$WebSsoRequestBody.type.set(0);
            webSsoBody$WebSsoRequestBody.data.set(jSONObject.toString());
            newIntent.putExtra("data", webSsoBody$WebSsoRequestBody.toByteArray());
            this.E.setEnabled(false);
            newIntent.setObserver(new a());
            this.U.getAppRuntime().startServlet(newIntent);
        } catch (Exception unused) {
            QQToast.makeText(this.U, 1, R.string.dun, 0).show(this.U.getTitleBarHeight());
            this.X = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.activity.PublicCommentWindow
    public void O(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.O(bundle);
        this.Y = this.I.optString("bid");
        this.Z = this.I.optString("pid");
        this.f293748a0 = this.I.optString("cid");
        this.f293749b0 = this.I.optString("rid");
        if ("detail".equals(this.I.optString("from"))) {
            str = "0";
        } else {
            str = "1";
        }
        this.f293750c0 = str;
        this.f293751d0 = this.I.optString("extparam");
        this.J = this.U.getAppRuntime().getAccount() + "-" + this.Y + "-" + this.Z + "-" + this.f293748a0 + "-" + this.f293749b0;
        s.b("two_comment", "exp", this.Y, this.f293750c0, "", "");
    }

    @Override // com.tencent.mobileqq.troop.activity.PublicCommentWindow, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.dismiss();
        EditText editText = this.D;
        if (editText != null && editText.length() > 0) {
            str = "0";
        } else {
            str = "1";
        }
        s.b("two_comment", "un", this.Y, str, "", "");
        if (!this.N) {
            Q(this.V, null, false);
        }
    }
}
