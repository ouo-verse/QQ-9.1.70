package com.tencent.mobileqq.profilecard.multyple;

import com.tencent.mobileqq.profilecard.collector.ElegantProfileComponentCollector;
import com.tencent.mobileqq.profilecard.collector.FeatureElegantComponentCollector;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.profilecard.a;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileCardElegantConfig implements IProfileCardMultiConfig {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Business/profilecard-impl/src/main/resources/Inject_ProfileComponentCollector_elegant.yml", version = 1)
    private static ArrayList<Class<? extends IProfileComponentCollector>> sInjectCollectorClasses;
    private boolean showGiftBtn;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList<Class<? extends IProfileComponentCollector>> arrayList = new ArrayList<>();
        sInjectCollectorClasses = arrayList;
        arrayList.add(ElegantProfileComponentCollector.class);
        sInjectCollectorClasses.add(FeatureElegantComponentCollector.class);
        sInjectCollectorClasses.add(a.class);
    }

    public ProfileCardElegantConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.showGiftBtn = false;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiConfig
    public boolean enableVasComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiConfig
    public ArrayList<Class<? extends IProfileComponentCollector>> getInjectCollectorClasses() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sInjectCollectorClasses;
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiConfig
    public IProfileCardVersion getProfileCardVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IProfileCardVersion) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ProfileCardVersion.V_ELEGANT;
    }

    public boolean isShowGiftBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.showGiftBtn;
    }

    public void setShowGiftBtn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.showGiftBtn = z16;
        }
    }
}
