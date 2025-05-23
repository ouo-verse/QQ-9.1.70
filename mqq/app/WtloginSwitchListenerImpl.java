package mqq.app;

import mqq.inject.MqqInjectorManager;
import oicq.wlogin_sdk.listener.SwitchListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginSwitchListenerImpl implements SwitchListener {
    private static volatile WtloginSwitchListenerImpl singleton;

    public static WtloginSwitchListenerImpl getSingleton() {
        if (singleton == null) {
            synchronized (WtloginSwitchListenerImpl.class) {
                if (singleton == null) {
                    singleton = new WtloginSwitchListenerImpl();
                }
            }
        }
        return singleton;
    }

    @Override // oicq.wlogin_sdk.listener.SwitchListener
    public boolean isSwitchOn(String str, boolean z16) {
        return MqqInjectorManager.instance().getSwitch(str, z16);
    }
}
