package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cx extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private QQAppInterface Q;

    public cx(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = qQAppInterface;
        }
    }

    private boolean F() {
        String str;
        if (this.f307441f.containsKey("entry")) {
            str = this.f307441f.get("entry");
        } else {
            str = null;
        }
        String str2 = this.f307441f.get("view");
        if (!"2".equals(str2) && !"3".equals(str2) && !"4".equals(str2) && !"5".equals(str2) && !"6".equals(str2) && !"7".equals(str2) && !"9".equals(str2) && !"10".equals(str2) && !"11".equals(str2) && !"15".equals(str2)) {
            if ("8".equals(str2)) {
                return G(str2, str);
            }
            if ("13".equals(str2)) {
                ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).parseJumpQWalletPetAction(this.f307437b, this.f307441f);
                return false;
            }
            if ("14".equals(str2)) {
                ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).parseJumpIdVerifyEntryAction(this.f307437b, this.f307441f);
                return false;
            }
            if ("16".equals(str2)) {
                return ((IQWalletApi) QRoute.api(IQWalletApi.class)).jumpToHbDetail(this.f307437b, this.f307441f);
            }
            return false;
        }
        Bundle bundle = new Bundle();
        if (this.f307441f.containsKey("tokenid")) {
            bundle.putString("tokenid", this.f307441f.get("tokenid"));
        }
        if (this.f307441f.containsKey("data")) {
            bundle.putString("data", this.f307441f.get("data"));
        }
        return H(str2, str, bundle);
    }

    private boolean G(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 13);
        bundle.putString("viewParam", str);
        if (str2 != null) {
            bundle.putString("entry", str2);
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) JumpActivity.class);
        intent.putExtra("srvBundle", bundle);
        intent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + str2));
        this.f307437b.startActivity(intent);
        return true;
    }

    private boolean H(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 13);
        bundle2.putString("viewParam", str);
        if (str2 != null) {
            bundle2.putString("entry", str2);
        }
        if (bundle != null) {
            bundle2.putBundle("extra_pay_data", bundle);
        }
        QWalletPayBridge.launchForeground((Activity) this.f307437b, bundle2);
        return true;
    }

    private boolean I(int i3) {
        if (!(this.f307437b instanceof QBaseActivity)) {
            return false;
        }
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchQWalletAct((QBaseActivity) this.f307437b, this.Q, true, i3);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if ("0".equals(this.f307441f.get("viewtype")) && !TextUtils.isEmpty(this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE))) {
                if (this.f307441f.get("view") != null && !"0".equals(this.f307441f.get("view")) && !"1".equals(this.f307441f.get("view"))) {
                    return F();
                }
                if (this.f307441f.containsKey(WadlProxyConsts.CHANNEL)) {
                    i3 = Integer.valueOf(this.f307441f.get(WadlProxyConsts.CHANNEL)).intValue();
                } else {
                    i3 = 0;
                }
                return I(i3);
            }
            return F();
        } catch (Exception e16) {
            QLog.e("QwalletToHomeAction", 1, "doAction error: " + e16.getMessage());
            i("QwalletToHomeAction");
            return false;
        }
    }
}
