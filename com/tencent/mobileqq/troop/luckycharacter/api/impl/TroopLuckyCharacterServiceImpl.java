package com.tencent.mobileqq.troop.luckycharacter.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLuckyCharacterServiceImpl implements ITroopLuckyCharacterService {
    static IPatchRedirector $redirector_;
    private AppRuntime mApp;

    public TroopLuckyCharacterServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService
    public String getLuckyCharacterPicUrl(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfo);
        }
        if (troopInfo == null || troopInfo.groupExt == null || TextUtils.isEmpty(troopInfo.troopuin) || !isSupportLuckyCharacter(troopInfo)) {
            return "";
        }
        GroupExt groupExt = troopInfo.groupExt;
        long j3 = groupExt.luckyWordId;
        if (j3 == 0) {
            return "";
        }
        return "https://tianquan.gtimg.cn/groupluckyword/item/" + j3 + "/tinypic-" + groupExt.lightCharNum + ".png";
    }

    @Override // com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService
    public boolean isShowInTroopGuild() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService
    public boolean isSupportLuckyCharacter(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo)).booleanValue();
        }
        if (troopInfo == null || TextUtils.isEmpty(troopInfo.troopuin) || QQTheme.isNowSimpleUI() || (troopInfo.groupFlagExt4 & 32768) != 0) {
            return false;
        }
        String currentAccountUin = this.mApp.getCurrentAccountUin();
        return BaseApplication.getContext().getSharedPreferences(currentAccountUin, 0).getBoolean(currentAccountUin + "self_troop_lucky_character_switch", true);
    }

    @Override // com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService
    public boolean isTroopLuckyCharacterSwitchChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if ((i16 & 32768) != (i3 & 32768)) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
