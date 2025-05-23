package com.qzone.util;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ai {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f59783d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f59784e;

        a(b bVar, int i3) {
            this.f59783d = bVar;
            this.f59784e = i3;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            ai.e(qZoneTask, this.f59783d, this.f59784e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
        void a(boolean z16, String str, String str2);
    }

    public static void d(int i3, b bVar, long j3, boolean z16) {
        String j06 = u5.b.j0("QbossUtilDataKey" + i3, null, LoginData.getInstance().getUin());
        long K = u5.b.K("QbossUtilTimeKey" + i3, 0L, LoginData.getInstance().getUin());
        if ((TextUtils.isEmpty(j06) || System.currentTimeMillis() - K > j3 || j3 <= 0) && !z16) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), i3, true), null, new a(bVar, i3), 1));
        }
        if (bVar != null) {
            bVar.a(true, j06, null);
        }
    }

    public static void c(int i3, b bVar, long j3) {
        d(i3, bVar, j3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(QZoneTask qZoneTask, b bVar, int i3) {
        QZoneResult result = qZoneTask.getResult(1);
        if (result != null && result.getReturnCode() == 0 && result.getSucceed()) {
            MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) ((QzoneQBossAdvRequest) qZoneTask.mRequest).rsp;
            if (mobileQbossAdvRsp != null && mobileQbossAdvRsp.iRet == 0) {
                Map<Integer, ArrayList<tAdvDesc>> map = mobileQbossAdvRsp.mapAdv;
                if (map != null && !map.isEmpty()) {
                    ArrayList<tAdvDesc> value = mobileQbossAdvRsp.mapAdv.entrySet().iterator().next().getValue();
                    if (value != null && !value.isEmpty()) {
                        tAdvDesc tadvdesc = value.get(0);
                        if (bVar != null) {
                            if (QZLog.isColorLevel()) {
                                QZLog.d("QbossUtil", 2, "handleGetQBossAdvInfo \u83b7\u53d6qboss\u6210\u529f\uff0cres_data: " + tadvdesc.res_data);
                            }
                            bVar.a(false, tadvdesc.res_data, tadvdesc.res_traceinfo);
                        }
                        u5.b.x0("QbossUtilDataKey" + i3, tadvdesc.res_data, LoginData.getInstance().getUin());
                        u5.b.u0("QbossUtilTimeKey" + i3, System.currentTimeMillis(), LoginData.getInstance().getUin());
                        return tadvdesc.res_data;
                    }
                    QZLog.w("QBossAdv", "mood list resp.mapAdv map is null");
                    result.setSucceed(false);
                } else {
                    QZLog.e("QbossUtil", 2, "handleGetQBossAdvInfo \u83b7\u53d6qboss\u6210\u529f \u4f46\u662f\u8fd4\u56de\u503c\u4e3a\u7a7a  \u6e05\u7a7a\u672c\u5730\u7f13\u5b58");
                    u5.b.x0("QbossUtilDataKey" + i3, "", LoginData.getInstance().getUin());
                }
                if (bVar != null) {
                    bVar.a(false, null, null);
                }
                return null;
            }
            QZLog.w("QbossUtil", "MobileQbossAdvRsp is null or ret!=0");
            if (bVar != null) {
                bVar.a(false, null, null);
            }
            return null;
        }
        if (result == null) {
            QZLog.e("QbossUtil", "handleGetQBossAdvInfo failed: result==null");
        } else if (result.getReturnCode() != 0) {
            QZLog.e("QbossUtil", String.format("handleGetQBossAdvInfo failed: code=%d, msg=%s", Integer.valueOf(result.getReturnCode()), result.getMessage()));
        } else if (!result.getSucceed()) {
            QZLog.e("QbossUtil", String.format("handleGetQBossAdvInfo failed: result.result=%d, msg=%s", Boolean.valueOf(result.getSucceed()), result.getMessage()));
        }
        QZLog.w("QbossUtil", "handleGetQBossAdvInfo failed");
        if (bVar != null) {
            bVar.a(false, null, null);
        }
        return null;
    }

    public static void b(int i3, b bVar) {
        c(i3, bVar, 0L);
    }
}
