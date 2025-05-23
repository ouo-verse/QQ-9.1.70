package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchMore;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class aa extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public aa(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity topActivity = Foreground.getTopActivity();
        QLog.i("GameCenterAction", 1, "gotoKuiklyFloatDialog topActivity:" + topActivity + ",process:" + MobileQQ.sMobileQQ.getQQProcessName());
        if (topActivity != null) {
            ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).openKuiklyFloatDialog(topActivity, str);
            return true;
        }
        QLog.e("GameCenterAction", 1, "[gotoKuiklyFloatDialog] failed , topActivity is null");
        return false;
    }

    private boolean G(Context context) {
        HashMap<String, String> hashMap = this.f307441f;
        if (hashMap != null && hashMap.get("key") != null) {
            ((ISearchMore) QRoute.api(ISearchMore.class)).openSearchMoreGamePage(context, this.f307441f.get("key"));
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", "982", "9075", "907501", "907220", "", "", "20", "");
            return true;
        }
        QLog.e("GameCenterAction", 1, "gotoSearchGamePage SearchWords is null");
        return false;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if ("searchgame".equals(this.f307440e)) {
                return G(this.f307437b);
            }
            if ("kuikly_float".equals(this.f307440e)) {
                return F(this.f307438c);
            }
            return false;
        } catch (Exception e16) {
            QLog.e("GameCenterAction", 1, "doAction error:", e16);
            i("GameCenterAction");
            return false;
        }
    }
}
