package com.tencent.ams.dsdk.core.wormhole;

import android.view.View;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKWormholeHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKWormholeHelper";
    public static final String WORMHOLE_ID = "wormholeId";

    public DKWormholeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkWormholeEnvironment() {
        try {
            WormholeManager.getInstance();
            return true;
        } catch (Throwable unused) {
            DLog.w(TAG, "checkWormholeEnvironment failed");
            return false;
        }
    }

    public static WormholeManager getWormholeManager() {
        return WormholeManager.getInstance();
    }

    public static void onNativeBindItemView(String str, View view, HippyMap hippyMap, int i3, HippyWormholeView.OnWormholeViewListener onWormholeViewListener) {
        WormholeManager.getInstance().onNativeBindItemView(str, view, hippyMap, i3, onWormholeViewListener);
    }

    public static void registerClientEngine(Object obj) {
        WormholeManager.getInstance().registerClientEngine(obj);
    }

    public static void sendMessageToAllClient(HippyMap hippyMap) {
        WormholeManager.getInstance().sendMessageToAllClient(hippyMap);
    }
}
