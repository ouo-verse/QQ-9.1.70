package dl3;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import t74.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Ldl3/b;", "Ldl3/c;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin;", "plugin", "<init>", "(Lcom/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin;)V", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends c {
    public b(VasWebviewJsPlugin vasWebviewJsPlugin) {
        super(vasWebviewJsPlugin);
        QLog.i("[zplan]AvatarRecordJsModule", 1, "process == " + MobileQQ.processName);
        if (h.a("com.tencent.mobileqq:tool")) {
            try {
                QIPCClientHelper.getInstance().register(((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).getIPCModule());
            } catch (Exception e16) {
                QLog.i("[zplan]AvatarRecordJsModule", 1, "AvatarRecordJsModule error :: ", e16);
            }
        }
    }
}
