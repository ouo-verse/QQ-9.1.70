package com.tencent.mobileqq.profilecard.base.config;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.c;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* loaded from: classes16.dex */
public class ProfileConfig implements IProfileConfig, c.b {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ProfileConfigHelper";
    private QQAppInterface app;
    private final Boolean[] mSwitchValueArray;

    public ProfileConfig(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.mSwitchValueArray = new Boolean[21];
            this.app = (QQAppInterface) appInterface;
        }
    }

    private void initProfileSwitchConfig(String str) {
        boolean z16;
        System.arraycopy(IProfileConfigConst.SWITCH_DEFAULT_VALUES, 0, r0, 0, 21);
        ProfileEntranceConfigData config = ProfileEntranceConfigLoader.INSTANCE.getConfig();
        int[] iArr = {config.getNow(), config.getCmshow(), config.getPhotoWall(), config.getPersonalLabel(), config.getRecentListen(), config.getTribe(), config.getGift(), isMiniAppProfileOpen(), config.getStickyNote(), config.getQcircle(), config.getAchievement(), config.getWeishi(), config.getBaseInfoAB(), config.getStickyNote(), config.getWzGame(), config.getWzSkin(), config.getYuanMeng()};
        iArr[14] = config.getGameInfo();
        iArr[16] = config.getDressup();
        iArr[17] = config.getQqcard();
        iArr[18] = config.getQcub();
        iArr[19] = config.getMusicData();
        for (int i3 = 0; i3 < 21; i3++) {
            Boolean[] boolArr = this.mSwitchValueArray;
            if (iArr[i3] == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolArr[i3] = Boolean.valueOf(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("initProfileSwitchConfig switch_values:%s]", Arrays.toString(this.mSwitchValueArray)));
        }
    }

    private int isMiniAppProfileOpen() {
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppOpenOnProfile() ? 1 : 0;
    }

    @Override // com.tencent.mobileqq.profilecard.base.config.IProfileConfig
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.getConfigProcess().h(this);
        }
        this.app = null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.config.IProfileConfig
    public String getVoiceBtnWording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.app == null) {
            return HardCodeUtil.qqStr(R.string.pd7);
        }
        if (PadUtil.a(BaseApplicationImpl.getApplication()) == DeviceType.FOLD) {
            return HardCodeUtil.qqStr(R.string.f175352yb);
        }
        return HardCodeUtil.qqStr(R.string.f175342ya);
    }

    @Override // com.tencent.mobileqq.profilecard.base.config.IProfileConfig
    public boolean isSwitchEnable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (this.app == null || i3 < 0 || i3 >= 21) {
            return false;
        }
        if (this.mSwitchValueArray[i3] == null) {
            initProfileSwitchConfig(null);
        }
        return this.mSwitchValueArray[i3].booleanValue();
    }

    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, Integer.valueOf(i3), str, aVar);
        }
    }
}
