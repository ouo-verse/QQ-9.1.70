package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class InitHwEngineValue {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "AutoInjectYml/Foundation/Transfile/Inject_InitHwEngineConfig.yml", version = 1)
    public static ArrayList<Class<? extends IHwEngineValue>> getEngineValue;
    public int localId;
    public boolean switchIpv6;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IHwEngineValue>> arrayList = new ArrayList<>();
        getEngineValue = arrayList;
        arrayList.add(InitHwEngineImp.class);
    }

    public InitHwEngineValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            IHwEngineValue newInstance = getEngineValue.get(0).newInstance();
            this.localId = newInstance.getLocaleId();
            this.switchIpv6 = newInstance.getIpv6Switch();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IndexOutOfBoundsException e17) {
            e17.printStackTrace();
        } catch (InstantiationException e18) {
            e18.printStackTrace();
        }
    }
}
