package oy2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.txc.log.api.ITxcActiveReportLogApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.ILogPushApi;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f424519d;

    a(String str) {
        super(str);
    }

    public static a b() {
        if (f424519d == null) {
            synchronized (a.class) {
                if (f424519d == null) {
                    f424519d = new a(ITxcActiveReportLogApi.NAME);
                }
            }
        }
        return f424519d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        try {
            if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) && TextUtils.equals(ITxcActiveReportLogApi.TXC_ACTION_ACTIVE_REPORT_LOG, str)) {
                String string = bundle.getString(ITxcActiveReportLogApi.TXC_PARAM_UIN, "");
                long j3 = bundle.getLong(ITxcActiveReportLogApi.TXC_PARAM_START_TIME);
                long j16 = bundle.getLong(ITxcActiveReportLogApi.TXC_PARAM_END_TIME);
                ((ILogPushApi) QRoute.api(ILogPushApi.class)).handleTxcActiveReportLog(string, j3 % SafeBitmapFactory.PX_THRESHOID_DEFAULTS, j3, j16);
            }
        } catch (Exception e16) {
            QLog.e(ITxcActiveReportLogApi.NAME, 1, "handleTxcActiveReportLog error", e16);
        }
        return null;
    }
}
