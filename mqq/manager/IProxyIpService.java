package mqq.manager;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
/* loaded from: classes28.dex */
public interface IProxyIpService extends IRuntimeService {
    public static final int PROXY_HTTP_COMMON = 2;
    public static final int PROXY_HTTP_FILE = 5;
    public static final int PROXY_HTTP_PIC = 3;
    public static final int PROXY_HTTP_PTT = 4;
    public static final int PROXY_SSO = 0;
    public static final int PROXY_TCP_COMMON = 1;

    /* loaded from: classes28.dex */
    public static class ProxyIp {

        /* renamed from: ip, reason: collision with root package name */
        public String f417211ip;
        public int port;
        public int type;

        public String toString() {
            return this.f417211ip + ":" + this.port + ":" + this.type;
        }
    }

    List<ProxyIp> getProxyIp(int i3);

    void reloadCache(String str, boolean z16);
}
