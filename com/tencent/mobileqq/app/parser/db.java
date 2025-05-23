package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.util.AppSetting;
import com.tencent.util.URLUtil;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.QzoneAuthorizeConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class db extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private static final boolean Q;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70580);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Q = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("parse_qzone_schema_param_no_url_decode", true);
        }
    }

    public db(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private String F(String str) {
        try {
            return Uri.parse(str).getQueryParameter("request_from");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private boolean G() {
        String str;
        String str2;
        if (this.f307438c == null) {
            return false;
        }
        if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.f307444i, this.f307438c)) {
            QLog.e("QzoneAction", 1, "has no right to handle this schema");
            return false;
        }
        if (this.f307438c.startsWith("mqzone")) {
            str = this.f307438c;
        } else if (this.f307438c.startsWith("mqqzone")) {
            str = "mqzone" + this.f307438c.substring(7);
        } else {
            if (this.f307438c.contains("schema=")) {
                if (this.f307438c.contains("%")) {
                    str2 = URLUtil.getArgumentsFromURL(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                } else if (Q) {
                    str2 = URLUtil.getArgusFromURLWithoutDecode(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                } else {
                    str2 = URLUtil.getArgumentsFromURL(this.f307438c).get(QZoneDTLoginReporter.SCHEMA);
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        str = new String(Base64.decode(str2, 0), "utf-8");
                    } catch (Exception e16) {
                        QLog.e("QzoneAction", 1, e16, new Object[0]);
                    }
                }
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!AppSetting.isPublicVersion()) {
                QLog.d("QzoneAction", 1, "gotoQzoneHandleSchema,schema:" + str);
            }
            Intent intent = new Intent();
            intent.putExtra("cmd", "Schema");
            intent.putExtra(QZoneDTLoginReporter.SCHEMA, str);
            if (H(str)) {
                ((IWSManager) QRoute.api(IWSManager.class)).enterTrendsTabWs(this.f307437b, "from_trends_tab", this.f307450o, this.A, intent);
            } else {
                ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(this.f307437b, str);
            }
        } else {
            QLog.e("QzoneAction", 1, "gotoQzoneHandleSchema,schema=null");
        }
        return true;
    }

    private boolean H(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/normalvideolayer") && TextUtils.equals(F(str), "6")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return G();
        } catch (Exception e16) {
            QLog.e("QzoneAction", 1, "doAction error: " + e16.getMessage());
            i("QzoneAction");
            return false;
        }
    }
}
