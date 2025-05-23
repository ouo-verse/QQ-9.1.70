package com.tencent.mobileqq.relationx.addFrd.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.processor.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

@KeepClassConstructor
/* loaded from: classes17.dex */
public class KplAddFriendProcessor extends a {
    static IPatchRedirector $redirector_;

    public KplAddFriendProcessor(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.processor.a
    public void a(Intent intent, Activity activity, String str, int i3) {
        String buildNickName;
        KplRoleInfo.WZRYUIinfo createInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, activity, str, Integer.valueOf(i3));
            return;
        }
        if (activity == null) {
            return;
        }
        AppInterface appInterface = this.f187364a.get();
        if (!intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (KplHelper.isKplSession(qQAppInterface, activity, str, i3) && (createInfo = KplRoleInfo.WZRYUIinfo.createInfo(str, (buildNickName = KplRoleInfo.WZRYUIinfo.buildNickName(activity.getIntent().getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME), KplHelper.getGameNickByUin(qQAppInterface, str))), KplHelper.getKplVerifyMsg(qQAppInterface), 0, 0)) != null) {
                intent.putExtra(IProfileCardConst.KEY_WZRY_DATA, createInfo);
                intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, buildNickName);
            }
        }
    }
}
