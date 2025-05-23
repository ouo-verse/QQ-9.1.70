package dr2;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f394682a;

    public static a b() {
        if (f394682a == null) {
            synchronized (a.class) {
                if (f394682a == null) {
                    f394682a = new a();
                }
            }
        }
        return f394682a;
    }

    public Bundle a(String str, Bundle bundle) {
        EIPCResult callServer;
        if ("CMD_GET_CURRENT_NICK_NAME".equals(str)) {
            EIPCResult callServer2 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "Module_VideoPlayIPCServer", "CMD_GET_CURRENT_NICK_NAME", bundle);
            if (callServer2 == null || !callServer2.isSuccess()) {
                return null;
            }
            return callServer2.data;
        }
        if ("CMD_GET_CURRENT_USER_HEAD".equals(str)) {
            EIPCResult callServer3 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "Module_VideoPlayIPCServer", "CMD_GET_CURRENT_USER_HEAD", bundle);
            if (callServer3 == null || !callServer3.isSuccess()) {
                return null;
            }
            return callServer3.data;
        }
        if ("CMD_DOWNLOAD_PTU_BASE_RES".equals(str)) {
            EIPCResult callServer4 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "Module_VideoPlayIPCServer", "CMD_DOWNLOAD_PTU_BASE_RES", bundle);
            if (callServer4 == null || !callServer4.isSuccess()) {
                return null;
            }
            return callServer4.data;
        }
        if (!"CMD_QUERY_STATUS_PTU_RES".equals(str) || (callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "Module_VideoPlayIPCServer", "CMD_QUERY_STATUS_PTU_RES", bundle)) == null || !callServer.isSuccess()) {
            return null;
        }
        return callServer.data;
    }
}
