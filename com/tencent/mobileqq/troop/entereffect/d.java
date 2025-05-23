package com.tencent.mobileqq.troop.enterEffect;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f295222d;

    public d(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f295222d = qQAppInterface;
        }
    }

    public void a(e.d dVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffectManager", 2, "addGrayTips uin = " + str + " wording = " + dVar.f295244d);
        }
        g gVar = new g(str, this.f295222d.getCurrentAccountUin(), dVar.f295244d, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, FileMsg.TRANSFILE_TYPE_MULTIMSG, com.tencent.mobileqq.service.message.e.K0());
        for (int i3 = 0; i3 < dVar.f295245e.size(); i3++) {
            e.d.a aVar = dVar.f295245e.get(i3);
            Bundle bundle = new Bundle();
            int i16 = dVar.f295247g;
            if (i16 == 1) {
                bundle.putInt("key_action", 1);
                bundle.putString("key_action_DATA", aVar.f295257c);
            } else if (i16 == 2) {
                bundle.putInt("key_action", 30);
                bundle.putString("key_action_DATA", VasH5PayUtil.getOpenClubPayParamForGrayTips(dVar.f295248h, dVar.f295249i, dVar.f295250j, dVar.f295251k, dVar.f295252l));
            }
            gVar.b(aVar.f295255a, aVar.f295256b, bundle);
        }
        if (dVar.f295246f) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_action", 29);
            bundle2.putString("key_action_DATA", dVar.f295241a + "");
            gVar.b(dVar.f295244d.length() + (-4), dVar.f295244d.length(), bundle2);
        }
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(this.f295222d, gVar);
        f.a(this.f295222d, messageForUniteGrayTip);
        ((ITroopEnterEffectService) this.f295222d.getRuntimeService(ITroopEnterEffectService.class, "")).getSharedPreferences().edit().putLong(ITroopEnterEffectService.SP_KEY_SHOW_GRAY_TIPS_TIME, System.currentTimeMillis()).commit();
        VasWebviewUtil.reportCommercialDrainage(this.f295222d.getCurrentUin(), "style", "0X8009132", "", 1, 0, 0, "", "", "");
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
