package com.qzone.misc.network.report;

import NS_MOBILE_EXTRA.s_visit_record;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.configx.g;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFeedVisitorReportService implements IQZoneServiceListener {
    private static QzoneFeedVisitorReportService F;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<s_visit_record> f48491f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<s_visit_record> f48492h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<String> f48493i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Long> f48494m = new HashMap<>();
    private Handler C = new Handler();
    private int D = -1;
    private HashMap<String, FeedVistorReportRunnable> E = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private long f48489d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f48490e = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FeedVistorReportRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private BusinessFeedData f48495d;

        public FeedVistorReportRunnable(BusinessFeedData businessFeedData) {
            this.f48495d = businessFeedData;
        }

        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("QzoneFeedVisitorReportService", "FeedVistorReportRunnable addRecord: " + ef.b.a(this.f48495d));
            QzoneFeedVisitorReportService.this.e(this.f48495d, 0);
            QzoneFeedVisitorReportService.this.E.remove(ef.b.a(this.f48495d));
        }
    }

    QzoneFeedVisitorReportService() {
    }

    public static final QzoneFeedVisitorReportService f() {
        if (F == null) {
            F = new QzoneFeedVisitorReportService();
        }
        return F;
    }

    private boolean h() {
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        return System.currentTimeMillis() - this.f48489d > ((long) (qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_INTEVAL, 600) * 1000)) && this.f48491f.size() >= qzoneConfig.getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_COUNT, 50);
    }

    public synchronized void c(s_visit_record s_visit_recordVar) {
        RFWLog.i("QzoneFeedVisitorReportService", RFWLog.USR, "add record,record :" + s_visit_recordVar);
        if (g(s_visit_recordVar)) {
            s_visit_recordVar.vtime = System.currentTimeMillis() / 1000;
            this.f48491f.add(s_visit_recordVar);
            RFWLog.i("QzoneFeedVisitorReportService", RFWLog.USR, "add record,record size : " + this.f48491f.size());
        } else {
            RFWLog.i("QzoneFeedVisitorReportService", RFWLog.USR, "duplicate record, do not record");
        }
        if (h()) {
            l();
        }
    }

    public synchronized void d(s_visit_record s_visit_recordVar, int i3) {
        if (s_visit_recordVar != null) {
            s_visit_recordVar.visit_type = i3;
            c(s_visit_recordVar);
        }
    }

    public void i(BusinessFeedData businessFeedData) {
        if (g.f53821a.b().F()) {
            FeedVistorReportRunnable feedVistorReportRunnable = new FeedVistorReportRunnable(businessFeedData);
            if (this.D < 0) {
                this.D = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_VISITORREPORT_STOPTIME, 2000);
            }
            Handler handler = this.C;
            if (handler != null) {
                handler.postDelayed(feedVistorReportRunnable, this.D);
            }
            this.E.put(ef.b.a(businessFeedData), feedVistorReportRunnable);
        }
    }

    public void k(String str) {
        FeedVistorReportRunnable feedVistorReportRunnable;
        if (!g.f53821a.b().F() || str == null || (feedVistorReportRunnable = this.E.get(str)) == null) {
            return;
        }
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacks(feedVistorReportRunnable);
        }
        this.E.remove(str);
    }

    public synchronized void l() {
        if (g.f53821a.b().F()) {
            if (LoginData.getInstance().getUin() != 0) {
                m(this.f48491f);
                if (this.f48492h.size() > 0) {
                    this.f48492h.clear();
                }
                this.f48492h.addAll(this.f48491f);
                this.f48491f.clear();
                this.f48493i.clear();
            }
        }
    }

    public void m(ArrayList<s_visit_record> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            RFWLog.i("QzoneFeedVisitorReportService", RFWLog.USR, "do report: " + arrayList.size());
            this.f48489d = System.currentTimeMillis();
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneFeedVisitorRptRequest(new ArrayList(arrayList)), null, this, 0));
            return;
        }
        RFWLog.i("QzoneFeedVisitorReportService", RFWLog.USR, "There is no record to report!");
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (!qZoneTask.succeeded()) {
            synchronized (this) {
                ArrayList<s_visit_record> arrayList = this.f48492h;
                if (arrayList != null && arrayList.size() > 0) {
                    m(this.f48492h);
                }
            }
        }
        ArrayList<s_visit_record> arrayList2 = this.f48492h;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void e(BusinessFeedData businessFeedData, int i3) {
        HashMap hashMap;
        String str;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getUser() == null || businessFeedData.getIdInfo() == null) {
            return;
        }
        s_visit_record s_visit_recordVar = new s_visit_record();
        s_visit_recordVar.appid = businessFeedData.getFeedCommInfo().appid;
        s_visit_recordVar.subid = businessFeedData.getFeedCommInfo().subid;
        s_visit_recordVar.fuin = businessFeedData.getUser().uin;
        s_visit_recordVar.visit_type = i3;
        try {
            s_visit_recordVar.gameId = Long.valueOf(businessFeedData.getIdInfo().subId).longValue();
        } catch (NumberFormatException unused) {
            s_visit_recordVar.gameId = 0L;
        }
        if (businessFeedData.getOperationInfo().busiParam != null) {
            hashMap = new HashMap(businessFeedData.getOperationInfo().busiParam);
        } else {
            hashMap = new HashMap();
        }
        if (s_visit_recordVar.appid != 4) {
            str = businessFeedData.getOriginalInfoSafe().getIdInfo().cellId;
            if (TextUtils.isEmpty(str)) {
                str = businessFeedData.getIdInfo().cellId;
            }
        } else if (businessFeedData.getPictureInfo() != null) {
            str = businessFeedData.getPictureInfo().albumid;
        } else {
            QZLog.e("QzoneFeedVisitorReportService", "appid photo cant get srcId");
            str = "";
        }
        s_visit_recordVar.srcId = str != null ? str : "";
        s_visit_recordVar.busi_param = hashMap;
        if (i3 == 6 || i3 == 7) {
            return;
        }
        c(s_visit_recordVar);
    }

    private boolean g(s_visit_record s_visit_recordVar) {
        if (s_visit_recordVar != null && s_visit_recordVar.fuin != LoginData.getInstance().getUin()) {
            String str = (s_visit_recordVar.appid + s_visit_recordVar.fuin) + s_visit_recordVar.srcId + s_visit_recordVar.gameId + s_visit_recordVar.subid + s_visit_recordVar.visit_type;
            ArrayList<String> arrayList = this.f48493i;
            if (arrayList != null && !arrayList.contains(str)) {
                this.f48493i.add(str);
                return true;
            }
        }
        return false;
    }

    public void b(PhotoParam photoParam, ArrayList<PhotoInfo> arrayList, int i3) {
        PhotoInfo photoInfo;
        HashMap hashMap;
        if (photoParam == null) {
            return;
        }
        int i16 = photoParam.appid;
        if (arrayList == null || i3 >= arrayList.size() || (photoInfo = arrayList.get(i3)) == null) {
            return;
        }
        s_visit_record s_visit_recordVar = new s_visit_record();
        s_visit_recordVar.fuin = photoParam.ownerUin;
        s_visit_recordVar.subid = photoParam.subid;
        s_visit_recordVar.appid = i16;
        s_visit_recordVar.srcId = photoParam.cell_id;
        if (i16 == 4) {
            s_visit_recordVar.srcId = photoParam.albumid;
        }
        if (s_visit_recordVar.srcId == null) {
            QZLog.e("QzoneFeedVistorReportService", "srcId is null");
            s_visit_recordVar.srcId = "";
        }
        if (photoParam.busi_param != null) {
            hashMap = new HashMap(photoParam.busi_param);
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(2, photoInfo.lloc);
        hashMap.put(1, photoInfo.sloc);
        s_visit_recordVar.busi_param = hashMap;
        d(s_visit_recordVar, 1);
    }

    public void j(View view) {
        Object tag;
        if (view == null || (tag = view.getTag()) == null || !(tag instanceof FeedVistorReportRunnable) || this.C == null) {
            return;
        }
        QZLog.i("QzoneFeedVisitorReportService", "remove record: " + view);
        this.C.removeCallbacks((FeedVistorReportRunnable) tag);
    }
}
