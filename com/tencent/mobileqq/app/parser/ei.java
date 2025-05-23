package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ei extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private QQAppInterface Q;

    public ei(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = qQAppInterface;
        }
    }

    private boolean F() {
        String str = this.f307441f.get("guin");
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str);
        int i3 = 0;
        if (troopInfoFromCache != null && troopInfoFromCache.isMember()) {
            String str2 = this.f307441f.get("type");
            if (TextUtils.isEmpty(str2)) {
                QLog.e("TroopProfileAction", 1, "illegal goToTroopProfileApp jumpAction. action type is null");
            } else {
                QLog.e("TroopProfileAction", 1, "goToTroopProfileApp jumpAction. type[" + str2 + "]");
            }
            if (AbstractImageDownloader.TAG_GROUP.equals(str2)) {
                TroopUtils.T(this.Q, (Activity) this.f307437b, str);
            } else if ("group_album".equals(str2)) {
                String str3 = this.f307441f.get("gname");
                try {
                    i3 = Integer.parseInt(this.f307441f.get("unreadnum"));
                } catch (NumberFormatException unused) {
                }
                TroopUtils.l(this.Q, (Activity) this.f307437b, str, str3, i3);
            } else if (!"group_story".equals(str2)) {
                if (!"bulk_send_message".equals(str2)) {
                    return false;
                }
                String str4 = this.f307441f.get("gc");
                Bundle bundle = new Bundle();
                bundle.putString("extra.GROUP_UIN", str4);
                bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.j6l));
                BulkSendMessageFragment.th((Activity) this.f307437b, bundle);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopProfileAction", 2, "illegal goToTroopProfileApp jumpAction. troopUin=", str);
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
            return F();
        } catch (Exception e16) {
            QLog.e("TroopProfileAction", 1, "doAction error: " + e16.getMessage());
            i("TroopProfileAction");
            return false;
        }
    }
}
