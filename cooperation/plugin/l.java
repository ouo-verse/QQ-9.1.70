package cooperation.plugin;

import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l extends AbstractPluginCommunicationChannel {
    private QQAppInterface v() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public String getNickName() throws RemoteException {
        QQAppInterface v3 = v();
        if (v3 != null) {
            return v3.getCurrentNickname();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public String getSKey() throws RemoteException {
        if (v() != null) {
            return "getSKey";
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public String getSid() throws RemoteException {
        throw new RuntimeException("NotSupported!");
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel
    public long getUin() throws RemoteException {
        QQAppInterface v3 = v();
        if (v3 != null) {
            return v3.getLongAccountUin();
        }
        return 0L;
    }
}
