package com.tencent.mobileqq.profilesetting.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.CardSettingHandler;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.profilesetting.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileSettingApiImpl implements IProfileSettingApi {
    static IPatchRedirector $redirector_;

    public ProfileSettingApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
    public int getProfileDisplaySettingStateFromCard(int i3, Card card, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), card, appInterface)).intValue();
        }
        return w.INSTANCE.j(i3, card, (QQAppInterface) appInterface);
    }

    @Override // com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
    public int getProfileSettingStateFromCard(int i3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) card)).intValue();
        }
        return w.INSTANCE.j(i3, card, null);
    }

    @Override // com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
    public boolean reqGetCardDisplaySetting(AppInterface appInterface, ArrayList<Integer> arrayList) {
        CardSettingHandler cardSettingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface, (Object) arrayList)).booleanValue();
        }
        if (appInterface == null || (cardSettingHandler = (CardSettingHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER)) == null) {
            return false;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(42425);
        cardSettingHandler.H2(arrayList2);
        return true;
    }

    @Override // com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
    public void requestProfileSettingState(AppInterface appInterface, ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) arrayList);
            return;
        }
        CardSettingHandler cardSettingHandler = (CardSettingHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
        if (cardSettingHandler != null) {
            cardSettingHandler.H2(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
    public void requestSetCardDisplaySetting(AppInterface appInterface, ArrayList<ReqSetSettingItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) arrayList);
            return;
        }
        CardSettingHandler cardSettingHandler = (CardSettingHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
        if (cardSettingHandler != null) {
            cardSettingHandler.I2(arrayList);
        }
    }
}
