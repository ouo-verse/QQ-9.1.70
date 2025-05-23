package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.tencent.biz.qqcircle.events.QFSWeakNetworkChangeEvent;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedTest;
import com.tencent.biz.richframework.video.RFWNetworkHelper;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.qcircle.api.requests.QCircleEeveeUndealMsgRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleNetWorkTestHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f92532a = new AtomicInteger(-1);

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f92533b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static long f92534c;

    /* renamed from: d, reason: collision with root package name */
    public static long f92535d;

    /* renamed from: e, reason: collision with root package name */
    private static final VSNetworkSpeedTest.NetworkEventListener f92536e;

    /* renamed from: f, reason: collision with root package name */
    private static final Runnable f92537f;

    /* renamed from: g, reason: collision with root package name */
    private static final IWeakNetStatusHandler f92538g;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements VSNetworkSpeedTest.NetworkEventListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.util.VSNetworkSpeedTest.NetworkEventListener
        public void onNewEvent(VSNetworkSpeedTest.NetworkEvent networkEvent) {
            if (TextUtils.equals(networkEvent.type, QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST)) {
                if (networkEvent.isSuccess) {
                    QCircleNetWorkTestHelper.f92535d = networkEvent.requestCost;
                } else {
                    QCircleNetWorkTestHelper.f92535d = -2L;
                }
                QLog.d("QCircleNetWorkTestHelper", 1, "sLastGetFeedListRequestCost change to:" + QCircleNetWorkTestHelper.f92535d);
                return;
            }
            if (TextUtils.equals(networkEvent.type, QCircleEeveeUndealMsgRequest.CMD_EEVEE)) {
                if (networkEvent.isSuccess) {
                    QCircleNetWorkTestHelper.f92534c = networkEvent.requestCost;
                } else {
                    QCircleNetWorkTestHelper.f92534c = -2L;
                }
                QLog.d("QCircleNetWorkTestHelper", 1, "sLastEeveeRequestCost change to:" + QCircleNetWorkTestHelper.f92534c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements IWeakNetStatusHandler {
        b() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onNormalToWeakNet(int i3) {
            QCircleNetWorkTestHelper.j(true, i3);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onWeakNetToNormal(int i3) {
            QCircleNetWorkTestHelper.j(false, -1);
        }
    }

    static {
        a aVar = new a();
        f92536e = aVar;
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper.2
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                for (Map.Entry<String, String> entry : QCircleNetWorkTestHelper.g().entrySet()) {
                    sb5.append(entry.getKey());
                    sb5.append(",");
                    sb5.append(entry.getValue());
                    sb5.append(";");
                }
                QLog.d("QCircleNetWorkTestHelper", 1, "current network info:" + ((Object) sb5));
                RFWThreadManager.getInstance().execOnSubThread(QCircleNetWorkTestHelper.f92537f, QCircleNetWorkTestHelper.b());
                x.b();
            }
        };
        f92537f = runnable;
        b bVar = new b();
        f92538g = bVar;
        QLog.d("QCircleNetWorkTestHelper", 1, "startLogPrint 1");
        VSNetworkSpeedHelper.getNetworkSpeedTest().registerNetWorkEventListener(aVar);
        RFWThreadManager.getInstance().execOnSubThread(runnable, e());
        AppNetConnInfo.registerWeakNetStatusHandler(null, bVar);
    }

    static /* bridge */ /* synthetic */ long b() {
        return e();
    }

    public static void d(Map<String, String> map) {
        map.put("last_eevee_request_cost", f92534c + "");
        map.put("last_get_feed_list_cost", f92535d + "");
    }

    private static long e() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_newwork_speed_log_interval", "5000"));
        } catch (Exception e16) {
            QLog.d("QCircleNetWorkTestHelper", 1, "getLogInterval error:" + e16);
            return 5000L;
        }
    }

    public static Map<String, String> f() {
        ArrayMap arrayMap = new ArrayMap();
        Pair<Double, Double> speedAndSucceedRate = VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate();
        arrayMap.put("cmd_avg_cost", speedAndSucceedRate.first + "");
        arrayMap.put("cmd_succeed_rate", speedAndSucceedRate.second + "");
        Pair<Double, Double> speedAndSucceedRate2 = com.tencent.mobileqq.qcircle.picload.listener.a.c().getSpeedAndSucceedRate();
        arrayMap.put("pic_avg_speed", speedAndSucceedRate2.first + "");
        arrayMap.put("pic_succeed_rate", speedAndSucceedRate2.second + "");
        arrayMap.put("qfs_avg_video_speed", RFWVideoUtils.getPredictSpeedWithOutDownGrade(126) + "");
        arrayMap.put("network_type", QCircleReportHelper.getNetworkType());
        return arrayMap;
    }

    public static Map<String, String> g() {
        ArrayMap arrayMap = new ArrayMap();
        try {
            arrayMap.putAll(f());
            arrayMap.putAll(h());
        } catch (Exception e16) {
            RFWLog.e("QCircleNetWorkTestHelper", RFWLog.USR, "getNetworkLogMap" + e16);
        }
        return arrayMap;
    }

    private static Map<String, String> h() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("msf_cur_weak_net_type", String.valueOf(f92532a.get()));
        arrayMap.put("is_cur_msf_weak_net", String.valueOf(f92533b.get()));
        arrayMap.put("msf_net_change_range", x.a());
        return arrayMap;
    }

    public static void i() {
        QLog.d("QCircleNetWorkTestHelper", 1, "startLogPrint");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QCircleNetWorkTestHelper", 2, "[updateNormalToWeakNet] isWeakNet: " + z16 + " | weakReason: " + i3);
        }
        f92532a.set(i3);
        f92533b.set(z16);
        x.c(z16, i3);
        RFWNetworkHelper.updateMsfWeakNet(z16, i3);
        SimpleEventBus.getInstance().dispatchEvent(new QFSWeakNetworkChangeEvent(z16, i3));
    }
}
