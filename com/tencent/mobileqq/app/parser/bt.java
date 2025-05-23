package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.sdk.data.AuthoritySdkJumpInfo;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bt extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bt(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    protected Bundle F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.f307441f.entrySet()) {
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                if (!entry.getKey().equals(ISchemeApi.KEY_IOS_SRC_TYPE)) {
                    value = com.tencent.mobileqq.utils.ax.E(value);
                }
                bundle.putString(entry.getKey(), value);
            }
        }
        bundle.putString("pkg_name", this.f307444i);
        bundle.putString("pkg_sig", this.f307445j);
        return bundle;
    }

    protected BasicSdkJumpInfo G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BasicSdkJumpInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = this.f307441f.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String str2 = this.f307441f.get("app_id");
        String E = com.tencent.mobileqq.utils.ax.E(this.f307441f.get("open_id"));
        String E2 = com.tencent.mobileqq.utils.ax.E(this.f307441f.get("app_name"));
        String E3 = com.tencent.mobileqq.utils.ax.E(this.f307441f.get("sdk_version"));
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(E) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f307444i)) {
            try {
                return new BasicSdkJumpInfo(Long.parseLong(str2), E, str, this.f307444i, this.f307445j, E2, E3);
            } catch (NumberFormatException e16) {
                QLog.e("OpenSdkJumpAction", 1, "getBasicInfo: parse long error.", e16);
                return null;
            }
        }
        QLog.e("OpenSdkJumpAction", 1, "getBasicInfo: appId/openId/src/pkgName is empty!" + this.f307444i + " appId: " + str2 + " src=" + str);
        return null;
    }

    protected void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BasicSdkJumpInfo G = G();
        if (G == null) {
            return;
        }
        AuthorityControlAppDetailsFragment.Wh(this.f307437b, new AuthoritySdkJumpInfo(G));
    }

    protected void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Intent intent = new Intent();
        Bundle F = F();
        F.putInt("action", 1);
        intent.putExtra("key_params", F);
        PublicFragmentActivity.b.a(this.f307437b, intent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    }

    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Intent intent = new Intent();
        Bundle F = F();
        F.putInt("action", 3);
        intent.putExtra("key_params", F);
        PublicFragmentActivity.b.a(this.f307437b, intent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("OpenSdkJumpAction", 1, "doAction: action=" + this.f307440e);
        if ("join_group".equals(this.f307440e)) {
            J();
        } else if ("bind_group".equals(this.f307440e)) {
            I();
        } else if ("open_auth_manage".equals(this.f307440e)) {
            H();
        }
        return true;
    }
}
