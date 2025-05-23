package mqq.manager;

import java.util.ArrayList;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.ReqUserInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ServerConfigManager extends Manager {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum ConfigType {
        user,
        app,
        common
    }

    void getPluginConfig(int i3, ReqUserInfo reqUserInfo, ArrayList<GetResourceReqInfoV2> arrayList, ServerConfigObserver serverConfigObserver, int i16);

    void getRichMediaServerList(int i3);

    String getServerConfig(String str, ConfigType configType);
}
