package com.tencent.mobileqq.troop.api.impl;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopAioKeywordService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x971.oidb_0x971$ReqBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioKeywordServiceImpl implements ITroopAioKeywordService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopAioKeywordServiceImpl";
    private AppInterface app;

    public TroopAioKeywordServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopAioKeywordService
    public void getTroopAioKeywordTipInfo(List<Integer> list, com.tencent.mobileqq.troop.observer.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) bVar);
            return;
        }
        if (list != null && list.size() != 0) {
            oidb_0x971$ReqBody oidb_0x971_reqbody = new oidb_0x971$ReqBody();
            oidb_0x971_reqbody.rule_id.set(list);
            ProtoUtils.a(this.app, bVar, oidb_0x971_reqbody.toByteArray(), "OidbSvc.0x971_0", 2417, 0);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next());
                    sb5.append(";");
                }
                QLog.i(TAG, 2, "getTroopAioKeywordTipInfo,ruleIds.size=" + list.size() + ",content=" + sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getTroopAioKeywordTipInfo, ruleIds == null || ruleIds.size() == 0");
        }
        bVar.b(false, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (appRuntime instanceof AppInterface) {
            this.app = (AppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
