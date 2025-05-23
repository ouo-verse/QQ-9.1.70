package cooperation.qzone.statistic.access;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.access.HttpDeliverer;
import cooperation.qzone.statistic.access.concept.Global;

/* loaded from: classes28.dex */
public class WapProxyHttpDeliverer extends HttpDeliverer {
    public static final int PROXY_IS_NEED = 1;
    public static final int PROXY_NEVER_TRY = -1;
    public static final int PROXY_USELESS = 0;
    public static final String TAG = "cooperation.qzone.statistic.access.WapProxyHttpDeliverer";
    public int needProxy;

    public WapProxyHttpDeliverer(String str) {
        super(str);
        this.needProxy = -1;
    }

    public static boolean isNetworkViaWAP() {
        if (Global.getContext() == null) {
            return false;
        }
        return ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).isWap();
    }

    @Override // cooperation.qzone.statistic.access.HttpDeliverer, cooperation.qzone.statistic.access.concept.Deliverer
    public int deliver(String str, int i3) {
        if (this.needProxy == -1) {
            int deliver = super.deliver(str, i3);
            if (isNetworkViaWAP()) {
                if (deliver != 0) {
                    this.needProxy = 1;
                    return super.deliver(str, i3);
                }
                this.needProxy = 0;
            }
            return deliver;
        }
        return super.deliver(str, i3);
    }

    @Override // cooperation.qzone.statistic.access.HttpDeliverer
    public HttpDeliverer.IProxy getProxy() {
        if (isNetworkViaWAP() && this.needProxy == 1) {
            return HttpDeliverer.IProxy.Default;
        }
        return null;
    }
}
