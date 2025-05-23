package com.tencent.mobileqq.ecshop.temp.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.statistics.a;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EcshopOtherApiImpl implements IEcshopOtherApi {
    static IPatchRedirector $redirector_;

    public EcshopOtherApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi
    public void gdtC2SReport(qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) adInfo, i3);
        } else if (i3 == 0) {
            a.b(0, 2, adInfo);
        } else if (i3 == 1) {
            a.b(1, 2, adInfo);
        }
    }

    @Override // com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi
    public void updateRecentList(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        MqqHandler handler = appInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }
}
