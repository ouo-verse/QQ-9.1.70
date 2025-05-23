package fc3;

import com.tencent.halley.common.utils.log.IDownloadLogProxy;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lfc3/a;", "Lcom/tencent/halley/common/utils/log/IDownloadLogProxy;", "", "initLogger", "", "tag", "msg", "", ReportConstant.COSTREPORT_TRANS, "i", "e", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IDownloadLogProxy {
    @Override // com.tencent.halley.common.utils.log.IDownloadLogProxy
    public void e(String tag, String msg2, Throwable tr5) {
        QLog.e("ZPlan_HalleyDownloader_ProxyLogger_" + tag, 1, msg2, tr5);
    }

    @Override // com.tencent.halley.common.utils.log.IDownloadLogProxy
    public void i(String tag, String msg2, Throwable tr5) {
        QLog.i("ZPlan_HalleyDownloader_ProxyLogger_" + tag, 2, msg2, tr5);
    }

    @Override // com.tencent.halley.common.utils.log.IDownloadLogProxy
    public void initLogger() {
        QLog.i("ZPlan_HalleyDownloader_ProxyLogger", 1, "initLogger -- " + this);
    }
}
