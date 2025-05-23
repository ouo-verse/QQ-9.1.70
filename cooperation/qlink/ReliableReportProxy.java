package cooperation.qlink;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
/* loaded from: classes28.dex */
public class ReliableReportProxy extends BaseProxy {
    public ReliableReportProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        QlinkReliableReport.i().e();
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        QlinkReliableReport.i().j();
    }
}
