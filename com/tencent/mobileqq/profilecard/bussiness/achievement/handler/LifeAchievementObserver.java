package com.tencent.mobileqq.profilecard.bussiness.achievement.handler;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LifeAchievementObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public LifeAchievementObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_onPraiseLifeAchievement(int i3, boolean z16, Object obj) {
        int i16;
        if (i3 != 10) {
            return;
        }
        int i17 = -1;
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            i17 = bundle.getInt(LifeAchievementHandler.LIFE_ACHIEVEMENT_PRAISE_ACTION_TYPE_KEY, -1);
            i16 = bundle.getInt(LifeAchievementHandler.LIFE_ACHIEVEMENT_PRAISE_ID_KEY, -1);
        } else {
            i16 = -1;
        }
        onPraiseLifeAchievement(z16, i17, i16);
    }

    protected void onPraiseLifeAchievement(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            onUpdate_onPraiseLifeAchievement(i3, z16, obj);
        }
    }
}
