package com.tencent.mobileqq.profilecard.multyple;

import com.tencent.mobileqq.profilecard.collector.FeatureComponentCollector;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;
import com.tencent.mobileqq.profilecard.collector.ProfileComponentCollector;
import com.tencent.mobileqq.profilecard.collector.TempProfileComponentCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.profilecard.a;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileCardOldConfig implements IProfileCardMultiConfig {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Business/profilecard-impl/src/main/resources/Inject_ProfileComponentCollector.yml", version = 1)
    private static ArrayList<Class<? extends IProfileComponentCollector>> sInjectCollectorClasses;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        ArrayList<Class<? extends IProfileComponentCollector>> arrayList = new ArrayList<>();
        sInjectCollectorClasses = arrayList;
        arrayList.add(ProfileComponentCollector.class);
        sInjectCollectorClasses.add(TempProfileComponentCollector.class);
        sInjectCollectorClasses.add(a.class);
        sInjectCollectorClasses.add(FeatureComponentCollector.class);
    }

    public ProfileCardOldConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiConfig
    public boolean enableVasComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
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
        return ProfileCardVersion.V_OLD;
    }
}
