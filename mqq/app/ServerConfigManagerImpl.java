package mqq.app;

import com.qq.jce.wup.UniPacket;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceReqV2;
import protocol.KQQConfig.ReqUserInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ServerConfigManagerImpl implements ServerConfigManager {
    private AppRuntime app;

    /* compiled from: P */
    /* renamed from: mqq.app.ServerConfigManagerImpl$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mqq$manager$ServerConfigManager$ConfigType;

        static {
            int[] iArr = new int[ServerConfigManager.ConfigType.values().length];
            $SwitchMap$mqq$manager$ServerConfigManager$ConfigType = iArr;
            try {
                iArr[ServerConfigManager.ConfigType.app.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$mqq$manager$ServerConfigManager$ConfigType[ServerConfigManager.ConfigType.common.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$mqq$manager$ServerConfigManager$ConfigType[ServerConfigManager.ConfigType.user.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ServerConfigManagerImpl(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // mqq.manager.ServerConfigManager
    public void getPluginConfig(int i3, ReqUserInfo reqUserInfo, ArrayList<GetResourceReqInfoV2> arrayList, ServerConfigObserver serverConfigObserver, int i16) {
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.setRequestId(0);
        uniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
        uniPacket.setFuncName("ClientReq");
        uniPacket.put("iCmdType", 64);
        uniPacket.put("ReqUserInfo", reqUserInfo);
        GetResourceReqV2 getResourceReqV2 = new GetResourceReqV2();
        getResourceReqV2.iPluginType = i3;
        getResourceReqV2.vecResReqInfo = arrayList;
        getResourceReqV2.iAppid = i16;
        getResourceReqV2.cReqVer = (byte) 1;
        uniPacket.put("GetResourceReqV2", getResourceReqV2);
        byte[] encode = uniPacket.encode();
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1018);
        newIntent.putExtra("buffer", encode);
        newIntent.putExtra("iPluginType", i3);
        newIntent.setObserver(serverConfigObserver);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.ServerConfigManager
    public void getRichMediaServerList(int i3) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1011);
        newIntent.putExtra("timestamp", i3);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.ServerConfigManager
    public String getServerConfig(String str, ServerConfigManager.ConfigType configType) {
        int i3 = AnonymousClass1.$SwitchMap$mqq$manager$ServerConfigManager$ConfigType[configType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return this.app.getService().msfSub.syncGetServerUserConfig(str);
            }
            return this.app.getService().msfSub.syncGetServerCommonConfig();
        }
        return this.app.getService().msfSub.syncGetServerAppConfig();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
