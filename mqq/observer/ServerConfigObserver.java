package mqq.observer;

import android.os.Bundle;
import mqq.app.Constants;
import protocol.KQQConfig.GetResourceRespV2;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ServerConfigObserver implements BusinessObserver, Constants.Action {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 1018) {
            onGetPluginConfig(z16, bundle.getInt("iPluginType"), (GetResourceRespV2) bundle.getSerializable("jce"));
        }
    }

    public void onGetServerTime(boolean z16, int i3) {
    }

    public void onGetPluginConfig(boolean z16, int i3, GetResourceRespV2 getResourceRespV2) {
    }
}
