package com.tencent.mobileqq.profilecard.bussiness.achievement.bean;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileLifeAchievementInfo implements IProfileBusinessInfo {
    static IPatchRedirector $redirector_;
    public ArrayList<LifeAchivementData> lifeAchievementList;
    public String lifeAchievementOpenId;
    public int lifeAchievementTotalCount;

    public ProfileLifeAchievementInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
