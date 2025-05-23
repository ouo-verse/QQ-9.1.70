package com.tencent.biz.qqcircle.immersive.manager;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QFSBusinessWeakBean;
import com.tencent.biz.qqcircle.beans.QFSWeakNetworkCommendInfo;
import com.tencent.biz.qqcircle.beans.QFSWeakNetworkFirstPlayInfo;
import com.tencent.biz.qqcircle.events.QFSWeakNetworkChangeEvent;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleReport$SingleDcData;
import qqcircle.QQCircleReport$StDataReportRsp;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j implements SimpleEventReceiver {
    private static volatile j G;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f87235d = new AtomicInteger(-1);

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f87236e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f87237f = new AtomicInteger(-1);

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f87238h = new AtomicInteger(-1);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f87239i = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private AtomicReference<String> f87240m = new AtomicReference<>();
    private final Map<Integer, QFSWeakNetworkCommendInfo> C = new ConcurrentHashMap();
    private final Type D = new a().getType();
    private final p50.a E = new p50.a();
    private final s50.d F = new s50.d();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends TypeToken<ArrayList<QFSWeakNetworkCommendInfo>> {
        a() {
        }
    }

    j() {
        n();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private List<QQCircleReport$SingleDcData> b(List<QFSWeakNetworkCommendInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (QFSWeakNetworkCommendInfo qFSWeakNetworkCommendInfo : list) {
            QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
            qQCircleReport$SingleDcData.dcid.set(10011);
            qQCircleReport$SingleDcData.report_data.set(c(qFSWeakNetworkCommendInfo));
            arrayList.add(qQCircleReport$SingleDcData);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:3:0x0006, B:5:0x002e, B:8:0x0035, B:9:0x003b, B:11:0x0040, B:14:0x0047, B:15:0x004d, B:17:0x0052, B:20:0x0059, B:21:0x005e), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0132 A[LOOP:0: B:23:0x012c->B:25:0x0132, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<FeedCloudCommon$Entry> c(QFSWeakNetworkCommendInfo qFSWeakNetworkCommendInfo) {
        String str;
        List asList;
        QFSBusinessWeakBean qFSBusinessWeakBean;
        String str2;
        String str3;
        String str4;
        double d16;
        double d17;
        double d18;
        try {
            qFSBusinessWeakBean = new QFSBusinessWeakBean();
            Map<String, String> f16 = QCircleNetWorkTestHelper.f();
            str2 = f16.get("cmd_avg_cost");
            str3 = f16.get("pic_avg_speed");
            str4 = f16.get("qfs_avg_video_speed");
            d16 = 0.0d;
        } catch (Throwable th5) {
            QLog.e("QFSWeakNetworkReportManager", 1, "[createWeakNetEntryList] ex: ", th5.getMessage());
            str = "";
        }
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            d17 = Double.parseDouble(str2);
            qFSBusinessWeakBean.setCmdCost(d17);
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                d18 = Double.parseDouble(str3);
                qFSBusinessWeakBean.setPicSpeed(d18);
                if (str4 != null && !TextUtils.isEmpty(str4)) {
                    d16 = Long.parseLong(str4);
                }
                qFSBusinessWeakBean.setPicSpeed(d16);
                str = new Gson().toJson(qFSBusinessWeakBean);
                ArrayList arrayList = new ArrayList();
                asList = Arrays.asList("uin", QCircleWeakNetReporter.KEY_COST, QCircleWeakNetReporter.KEY_RSP_TIME, QCircleWeakNetReporter.KEY_START_NET_TYPE, QCircleWeakNetReporter.KEY_END_NET_TYPE, QCircleWeakNetReporter.KEY_WEAK_NET_TYPE, "version", QCircleWeakNetReporter.KEY_TRACE_ID, "method", "extData");
                List asList2 = Arrays.asList(String.valueOf(qFSWeakNetworkCommendInfo.getUin()), String.valueOf(qFSWeakNetworkCommendInfo.getCost()), String.valueOf(qFSWeakNetworkCommendInfo.getRspTime()), String.valueOf(qFSWeakNetworkCommendInfo.getStartNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getEndNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getWeakNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getVersion()), String.valueOf(qFSWeakNetworkCommendInfo.getTraceId()), String.valueOf(qFSWeakNetworkCommendInfo.getMethod()), str);
                QLog.d("QFSWeakNetworkReportManager", 4, "[createWeakNetEntryList] extDataVal: " + str);
                for (int i3 = 0; i3 < asList.size(); i3++) {
                    FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                    feedCloudCommon$Entry.key.set((String) asList.get(i3));
                    feedCloudCommon$Entry.value.set((String) asList2.get(i3));
                    arrayList.add(feedCloudCommon$Entry);
                }
                return arrayList;
            }
            d18 = 0.0d;
            qFSBusinessWeakBean.setPicSpeed(d18);
            if (str4 != null) {
                d16 = Long.parseLong(str4);
            }
            qFSBusinessWeakBean.setPicSpeed(d16);
            str = new Gson().toJson(qFSBusinessWeakBean);
            ArrayList arrayList2 = new ArrayList();
            asList = Arrays.asList("uin", QCircleWeakNetReporter.KEY_COST, QCircleWeakNetReporter.KEY_RSP_TIME, QCircleWeakNetReporter.KEY_START_NET_TYPE, QCircleWeakNetReporter.KEY_END_NET_TYPE, QCircleWeakNetReporter.KEY_WEAK_NET_TYPE, "version", QCircleWeakNetReporter.KEY_TRACE_ID, "method", "extData");
            List asList22 = Arrays.asList(String.valueOf(qFSWeakNetworkCommendInfo.getUin()), String.valueOf(qFSWeakNetworkCommendInfo.getCost()), String.valueOf(qFSWeakNetworkCommendInfo.getRspTime()), String.valueOf(qFSWeakNetworkCommendInfo.getStartNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getEndNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getWeakNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getVersion()), String.valueOf(qFSWeakNetworkCommendInfo.getTraceId()), String.valueOf(qFSWeakNetworkCommendInfo.getMethod()), str);
            QLog.d("QFSWeakNetworkReportManager", 4, "[createWeakNetEntryList] extDataVal: " + str);
            while (i3 < asList.size()) {
            }
            return arrayList2;
        }
        d17 = 0.0d;
        qFSBusinessWeakBean.setCmdCost(d17);
        if (str3 != null) {
            d18 = Double.parseDouble(str3);
            qFSBusinessWeakBean.setPicSpeed(d18);
            if (str4 != null) {
            }
            qFSBusinessWeakBean.setPicSpeed(d16);
            str = new Gson().toJson(qFSBusinessWeakBean);
            ArrayList arrayList22 = new ArrayList();
            asList = Arrays.asList("uin", QCircleWeakNetReporter.KEY_COST, QCircleWeakNetReporter.KEY_RSP_TIME, QCircleWeakNetReporter.KEY_START_NET_TYPE, QCircleWeakNetReporter.KEY_END_NET_TYPE, QCircleWeakNetReporter.KEY_WEAK_NET_TYPE, "version", QCircleWeakNetReporter.KEY_TRACE_ID, "method", "extData");
            List asList222 = Arrays.asList(String.valueOf(qFSWeakNetworkCommendInfo.getUin()), String.valueOf(qFSWeakNetworkCommendInfo.getCost()), String.valueOf(qFSWeakNetworkCommendInfo.getRspTime()), String.valueOf(qFSWeakNetworkCommendInfo.getStartNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getEndNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getWeakNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getVersion()), String.valueOf(qFSWeakNetworkCommendInfo.getTraceId()), String.valueOf(qFSWeakNetworkCommendInfo.getMethod()), str);
            QLog.d("QFSWeakNetworkReportManager", 4, "[createWeakNetEntryList] extDataVal: " + str);
            while (i3 < asList.size()) {
            }
            return arrayList22;
        }
        d18 = 0.0d;
        qFSBusinessWeakBean.setPicSpeed(d18);
        if (str4 != null) {
        }
        qFSBusinessWeakBean.setPicSpeed(d16);
        str = new Gson().toJson(qFSBusinessWeakBean);
        ArrayList arrayList222 = new ArrayList();
        asList = Arrays.asList("uin", QCircleWeakNetReporter.KEY_COST, QCircleWeakNetReporter.KEY_RSP_TIME, QCircleWeakNetReporter.KEY_START_NET_TYPE, QCircleWeakNetReporter.KEY_END_NET_TYPE, QCircleWeakNetReporter.KEY_WEAK_NET_TYPE, "version", QCircleWeakNetReporter.KEY_TRACE_ID, "method", "extData");
        List asList2222 = Arrays.asList(String.valueOf(qFSWeakNetworkCommendInfo.getUin()), String.valueOf(qFSWeakNetworkCommendInfo.getCost()), String.valueOf(qFSWeakNetworkCommendInfo.getRspTime()), String.valueOf(qFSWeakNetworkCommendInfo.getStartNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getEndNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getWeakNetType()), String.valueOf(qFSWeakNetworkCommendInfo.getVersion()), String.valueOf(qFSWeakNetworkCommendInfo.getTraceId()), String.valueOf(qFSWeakNetworkCommendInfo.getMethod()), str);
        QLog.d("QFSWeakNetworkReportManager", 4, "[createWeakNetEntryList] extDataVal: " + str);
        while (i3 < asList.size()) {
        }
        return arrayList222;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "null";
        }
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return "null";
        }
        return split[split.length - 1];
    }

    private void e(List<QFSWeakNetworkCommendInfo> list) {
        this.E.c("weak_net_commend_report", this.D, list);
        this.f87239i.set(false);
    }

    private void f() {
        this.E.a("weak_net_commend_report");
        this.f87239i.set(false);
    }

    private void g(@NotNull QFSWeakNetworkChangeEvent qFSWeakNetworkChangeEvent) {
        this.f87235d.set(qFSWeakNetworkChangeEvent.getWeakType());
        this.f87236e.set(qFSWeakNetworkChangeEvent.isWeakNetwork());
        if (!this.f87236e.get()) {
            n();
        }
    }

    public static j h() {
        if (G == null) {
            synchronized (j.class) {
                if (G == null) {
                    G = new j();
                }
            }
        }
        return G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
        String traceId;
        if (z16 && j3 == 0) {
            f();
        } else {
            e(list);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[reportWeakNetwork] result isSuccess: ");
        sb5.append(z16);
        sb5.append(" | retCode: ");
        sb5.append(j3);
        sb5.append(" | traceId: ");
        if (baseRequest == null) {
            traceId = "null";
        } else {
            traceId = baseRequest.getTraceId();
        }
        sb5.append(traceId);
        QLog.d("QFSWeakNetworkReportManager", 1, sb5.toString());
        this.f87239i.set(true);
    }

    private void m(final List<QFSWeakNetworkCommendInfo> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        QCircleReporter.getInstance().sendListReport(b(list), new QCircleReporter.QCircleReportRspCallback() { // from class: com.tencent.biz.qqcircle.immersive.manager.i
            @Override // cooperation.qqcircle.report.QCircleReporter.QCircleReportRspCallback
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleReport$StDataReportRsp qQCircleReport$StDataReportRsp) {
                j.this.i(list, baseRequest, z16, j3, str, qQCircleReport$StDataReportRsp);
            }
        });
        QLog.d("QFSWeakNetworkReportManager", 1, "[reportWeakNetwork] list: " + list.size());
    }

    private void n() {
        if (this.f87239i.get()) {
            return;
        }
        m(this.E.b("weak_net_commend_report", this.D));
        s50.d dVar = this.F;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSWeakNetworkChangeEvent.class);
        return arrayList;
    }

    public void j(int i3, int i16, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSWeakNetworkCommendInfo qFSWeakNetworkCommendInfo;
        if (!this.f87236e.get() || i3 != 503 || !TextUtils.equals(this.f87240m.get(), ba.d(feedCloudMeta$StFeed)) || (qFSWeakNetworkCommendInfo = this.C.get(Integer.valueOf(this.f87238h.get()))) == null) {
            return;
        }
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() - qFSWeakNetworkCommendInfo.getReqTimeVal());
            if (currentTimeMillis < o.T(2000)) {
                return;
            }
            String g16 = bj.g(feedCloudMeta$StFeed);
            QFSWeakNetworkFirstPlayInfo qFSWeakNetworkFirstPlayInfo = new QFSWeakNetworkFirstPlayInfo();
            qFSWeakNetworkFirstPlayInfo.setFeedId(g16);
            qFSWeakNetworkFirstPlayInfo.setFiledId(str);
            qFSWeakNetworkFirstPlayInfo.setStartNetType(qFSWeakNetworkCommendInfo.getStartNetType());
            qFSWeakNetworkFirstPlayInfo.setEndNetType(Integer.parseInt(QCircleReportHelper.getNetworkType()));
            qFSWeakNetworkFirstPlayInfo.setWeakNetType(this.f87235d.get());
            qFSWeakNetworkFirstPlayInfo.setCost(currentTimeMillis);
            String json = new Gson().toJson(qFSWeakNetworkFirstPlayInfo);
            QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_QFS_WEAK_NETWORK_REFRESH_FIRST_PLAY_EVENT, Collections.singletonList(QCircleReportHelper.newEntry("attach_info", json)), false);
            QLog.d("QFSWeakNetworkReportManager", 1, "[recordFirstPlayCallback] pageId: " + i3 + " | position: " + i16 + " | json: " + json);
            this.f87238h.set(-1);
        } catch (Throwable th5) {
            QLog.d("QFSWeakNetworkReportManager", 1, "[recordFirstPlayCallback] ex: ", th5.getMessage());
        }
    }

    public void k(Object obj) {
        if (!(obj instanceof QCircleTabGetFeedListRequest)) {
            return;
        }
        QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
        if (qCircleTabGetFeedListRequest.mRequest == null) {
            return;
        }
        if (this.f87237f.get() != -1) {
            this.C.remove(Integer.valueOf(this.f87237f.get()));
        }
        int requestSource = qCircleTabGetFeedListRequest.getRequestSource();
        if (requestSource != 10) {
            return;
        }
        try {
            this.f87237f.set(qCircleTabGetFeedListRequest.hashCode());
            QFSWeakNetworkCommendInfo qFSWeakNetworkCommendInfo = new QFSWeakNetworkCommendInfo();
            qFSWeakNetworkCommendInfo.setUin(HostDataTransUtils.getAccount());
            qFSWeakNetworkCommendInfo.setStartNetType(Integer.parseInt(QCircleReportHelper.getNetworkType()));
            qFSWeakNetworkCommendInfo.setReqTimeVal(System.currentTimeMillis());
            qFSWeakNetworkCommendInfo.setMethod(d(qCircleTabGetFeedListRequest.getCmd()) + "_" + requestSource);
            qFSWeakNetworkCommendInfo.setVersion(QUA.getQUA3());
            this.C.put(Integer.valueOf(this.f87237f.get()), qFSWeakNetworkCommendInfo);
        } catch (Throwable th5) {
            QLog.d("QFSWeakNetworkReportManager", 1, "[recordReq] ex: ", th5);
        }
    }

    public void l(boolean z16, long j3, Object obj, Object obj2) {
        QFSWeakNetworkCommendInfo qFSWeakNetworkCommendInfo;
        if (!this.f87236e.get() || !(obj instanceof QCircleTabGetFeedListRequest) || !(obj2 instanceof FeedCloudRead$StGetFeedListRsp)) {
            return;
        }
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj2;
        QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
        String traceId = qCircleTabGetFeedListRequest.getTraceId();
        int hashCode = qCircleTabGetFeedListRequest.hashCode();
        if (TextUtils.isEmpty(traceId) || hashCode != this.f87237f.get() || (qFSWeakNetworkCommendInfo = this.C.get(Integer.valueOf(hashCode))) == null) {
            return;
        }
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() - qFSWeakNetworkCommendInfo.getReqTimeVal());
            if (currentTimeMillis < o.G0(2000)) {
                return;
            }
            qFSWeakNetworkCommendInfo.setCost(currentTimeMillis);
            qFSWeakNetworkCommendInfo.setEndNetType(Integer.parseInt(QCircleReportHelper.getNetworkType()));
            qFSWeakNetworkCommendInfo.setTraceId(qCircleTabGetFeedListRequest.getTraceId());
            qFSWeakNetworkCommendInfo.setWeakNetType(this.f87235d.get());
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            qFSWeakNetworkCommendInfo.setRspTime(qQCircleFeedBase$StFeedListBusiRspData.rspTimestamp.get());
            QLog.d("QFSWeakNetworkReportManager", 1, "[recordRsp] isSuccess: " + z16 + " | retCode: " + j3 + " | commendInfo: " + qFSWeakNetworkCommendInfo);
            m(Collections.singletonList(qFSWeakNetworkCommendInfo));
            this.f87238h.set(this.f87237f.get());
            this.f87237f.set(-1);
            this.f87240m.set(traceId);
        } catch (Throwable th5) {
            QLog.e("QFSWeakNetworkReportManager", 1, "[recordRsp] ex: ", th5.getMessage());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSWeakNetworkChangeEvent) {
            g((QFSWeakNetworkChangeEvent) simpleBaseEvent);
        }
    }
}
