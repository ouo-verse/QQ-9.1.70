package com.tencent.mobileqq.app.parser;

import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cv extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private c Q;
    private com.tencent.mobileqq.app.cl R;
    private Dialog S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cv.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (cv.this.S != null && cv.this.S.isShowing()) {
                    cv.this.S.dismiss();
                }
                cv.this.L();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cv.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (cv.this.S != null && cv.this.S.isShowing()) {
                    cv.this.S.dismiss();
                }
                ((QBaseActivity) cv.this.f307437b).finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cv.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what != 1) {
                return;
            }
            if (cv.this.R != null) {
                cv.this.R.a();
                cv cvVar = cv.this;
                cvVar.f307436a.removeObserver(cvVar.R);
            }
            if (message.arg1 != 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("QwalletModifyPassAction", 2, "msf return error ");
                }
                cv.this.N(1);
                return;
            }
            Object obj = message.obj;
            if (obj instanceof RespCheckChangePwdAuth) {
                RespCheckChangePwdAuth respCheckChangePwdAuth = (RespCheckChangePwdAuth) obj;
                if (respCheckChangePwdAuth.retCode == 0) {
                    cv.this.M();
                    return;
                } else if (QLog.isColorLevel()) {
                    QLog.i("QwalletModifyPassAction", 2, "server return error, errorCode: " + respCheckChangePwdAuth.retCode + " errorMsg: " + respCheckChangePwdAuth.retMsg);
                }
            }
            cv.this.N(1);
        }
    }

    public cv(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean K() {
        String str;
        if (!(this.f307437b instanceof QBaseActivity)) {
            return false;
        }
        if (this.f307441f.containsKey("uin")) {
            str = this.f307441f.get("uin");
        } else {
            str = "";
        }
        if (!str.equals(this.f307436a.getCurrentAccountUin())) {
            O();
        } else {
            L();
        }
        QLog.i("QwalletModifyPassAction", 1, "gotoQwalletModifyPass");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (!this.f307441f.containsKey("packageName")) {
            str = "";
        } else {
            str = this.f307441f.get("packageName");
        }
        if (!this.f307441f.containsKey("signareMode")) {
            str2 = "";
        } else {
            str2 = this.f307441f.get("signareMode");
        }
        if (!this.f307441f.containsKey("appid")) {
            str3 = "";
        } else {
            str3 = this.f307441f.get("appid");
        }
        if (!this.f307441f.containsKey(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)) {
            str4 = "";
        } else {
            str4 = this.f307441f.get(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
        }
        if (!this.f307441f.containsKey("resetWordMode")) {
            str5 = "";
        } else {
            str5 = this.f307441f.get("resetWordMode");
        }
        if (this.f307441f.containsKey("offerid")) {
            str6 = this.f307441f.get("offerid");
        }
        String str7 = str6;
        if (QLog.isColorLevel()) {
            QLog.d("QwalletModifyPassAction", 2, "packageName : " + str + " signatureMode :" + str2 + " appid : " + str3 + " timestamp : " + str4 + " resetWordMode : " + str5 + " offerId : " + str7);
        }
        ((QWalletAuthHandler) this.f307436a.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).D2(new ReqCheckChangePwdAuth(str, str2, str3, str4, str5, str7));
        c cVar = new c();
        this.Q = cVar;
        com.tencent.mobileqq.app.cl clVar = new com.tencent.mobileqq.app.cl(cVar);
        this.R = clVar;
        this.f307436a.addObserver(clVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        int i3;
        com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f307436a.getCurrentAccountUin());
            jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "pswManage");
            if (!PayBridgeActivity.tenpay((Activity) this.f307437b, jSONObject.toString(), 5, "")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            N(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            N(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("midas://open_modify_status?status=" + i3));
        if (InstalledAppListMonitor.queryIntentActivities(this.f307437b.getPackageManager(), intent, 0).size() > 0) {
            this.f307437b.startActivity(intent);
        }
        ((QBaseActivity) this.f307437b).finish();
    }

    private void O() {
        Context context = this.f307437b;
        Dialog createTipDialog = DialogUtil.createTipDialog(context, R.string.bgk, context.getString(R.string.bgf), R.string.bgh, R.string.bgg, new a(), new b());
        this.S = createTipDialog;
        createTipDialog.show();
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return K();
        } catch (Exception e16) {
            QLog.e("QwalletModifyPassAction", 1, "doAction error: " + e16.getMessage());
            i("QwalletModifyPassAction");
            return false;
        }
    }
}
