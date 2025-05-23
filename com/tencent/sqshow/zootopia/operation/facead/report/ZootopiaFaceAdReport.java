package com.tencent.sqshow.zootopia.operation.facead.report;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mb4.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00021\u001cB\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ2\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0007J \u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J*\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001aj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u001b2\u0006\u0010\u0019\u001a\u00020\u0018J:\u0010!\u001a\u00020\u00042\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001aj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u001b2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fR\"\u0010(\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R>\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u001aj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport;", "", "Landroid/os/Bundle;", "bundle", "", "i", "c", "", "needShow", "d", "g", "", QzoneIPCModule.RESULT_CODE, "sslErrorCode", h.F, "adloadCostTime", "picLoadResult", "", "completeData", "isNativeFaceAd", "e", "showAgainStatus", "b", "j", "Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$a;", "stepRecord", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "params", "paramKey", "", "costTime", "k", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getFaceAdReportNum", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setFaceAdReportNum", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "faceAdReportNum", "Ljava/util/HashMap;", "getRecordCache", "()Ljava/util/HashMap;", "setRecordCache", "(Ljava/util/HashMap;)V", "recordCache", "<init>", "()V", "STEP", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaFaceAdReport {

    /* renamed from: a */
    public static final ZootopiaFaceAdReport f372190a = new ZootopiaFaceAdReport();

    /* renamed from: b, reason: from kotlin metadata */
    private static AtomicInteger faceAdReportNum = new AtomicInteger(0);

    /* renamed from: c, reason: from kotlin metadata */
    private static HashMap<Integer, StepRecord> recordCache = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;", "", "(Ljava/lang/String;I)V", "ON_PORTAL_CREATE", "ON_AD_REQ", "ON_AD_RSP", "ON_AD_WEB_CREATE", "ON_AD_WEB_LOAD_COMPLETE", "ON_AD_SHOW", "ON_AD_CLOSE", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum STEP {
        ON_PORTAL_CREATE,
        ON_AD_REQ,
        ON_AD_RSP,
        ON_AD_WEB_CREATE,
        ON_AD_WEB_LOAD_COMPLETE,
        ON_AD_SHOW,
        ON_AD_CLOSE
    }

    ZootopiaFaceAdReport() {
    }

    public final HashMap<String, String> a(StepRecord stepRecord) {
        String str;
        Intrinsics.checkNotNullParameter(stepRecord, "stepRecord");
        HashMap<String, String> hashMap = new HashMap<>();
        k(hashMap, "k_facead_req_cost_time", stepRecord.getReqCostTime());
        k(hashMap, "k_facead_rsp_cost_time", stepRecord.getRspCostTime());
        k(hashMap, "k_facead_web_create_cost_time", stepRecord.getWebCreateCostTime());
        k(hashMap, "k_facead_web_load_cost_time", stepRecord.getWebLoadCostTime());
        k(hashMap, "k_facead_show_cost_time", stepRecord.getAdShowCostTime());
        k(hashMap, "k_facead_close_cost_time", stepRecord.getAdCloseCostTime());
        if (((IZPlanWebUtil) QRoute.api(IZPlanWebUtil.class)).isZPlanWebOfflineResLoaded()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("k_offline_res_is_download", str);
        return hashMap;
    }

    public final void b(Bundle bundle, int showAgainStatus, String completeData) {
        Intrinsics.checkNotNullParameter(completeData, "completeData");
        if (bundle != null) {
            int i3 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i3));
            if (record == null || record.getLastStep() != STEP.ON_AD_SHOW) {
                return;
            }
            record.m(STEP.ON_AD_CLOSE);
            record.j(System.currentTimeMillis() - record.getAdShownTime());
            ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
            Intrinsics.checkNotNullExpressionValue(record, "record");
            HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
            a16.put("k_show_again_status", String.valueOf(showAgainStatus));
            a16.put("k_facead_h5_callback_complete_data", completeData);
            a16.put("k_facead_total_cost_time", String.valueOf(System.currentTimeMillis() - record.getPortalCreateTime()));
            c.c(c.f416532a, "e_zplan_facead_on_close", a16, false, 4, null);
            QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdClose enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void e(Bundle bundle, int adloadCostTime, int picLoadResult, String completeData, boolean isNativeFaceAd) {
        Intrinsics.checkNotNullParameter(completeData, "completeData");
        if (bundle != null) {
            int i3 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i3));
            if (record != null) {
                if (record.getLastStep() == STEP.ON_AD_WEB_CREATE || isNativeFaceAd) {
                    record.m(STEP.ON_AD_SHOW);
                    record.l(System.currentTimeMillis());
                    record.k(isNativeFaceAd ? adloadCostTime : (((System.currentTimeMillis() - record.getPortalCreateTime()) - record.getRspCostTime()) - record.getReqCostTime()) - record.getWebCreateCostTime());
                    ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
                    Intrinsics.checkNotNullExpressionValue(record, "record");
                    HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
                    a16.put("k_pic_load_result", String.valueOf(picLoadResult));
                    if (!isNativeFaceAd) {
                        a16.put("k_facead_h5_cost_time", String.valueOf(adloadCostTime));
                        a16.put("k_facead_h5_callback_complete_data", completeData);
                        a16.put("k_facead_total_cost_time", String.valueOf(System.currentTimeMillis() - record.getPortalCreateTime()));
                    } else {
                        a16.put("k_facead_total_cost_time", String.valueOf(record.getRspCostTime() + record.getReqCostTime() + adloadCostTime));
                    }
                    c.c(c.f416532a, "e_zplan_facead_on_show", a16, false, 4, null);
                    QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdShow enterNum=" + i3 + " params=" + a16);
                }
            }
        }
    }

    public final void k(HashMap<String, String> params, String paramKey, long costTime) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        if (costTime > 0) {
            params.put(paramKey, String.valueOf(costTime));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\"\u0010\"\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\"\u0010%\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\"\u0010'\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b&\u0010\u0017R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\n\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b*\u0010\u0017\u00a8\u0006."}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;", "a", "Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;", "d", "()Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;)V", "lastStep", "", "b", "J", "e", "()J", "setPortalCreateTime", "(J)V", "portalCreateTime", "c", "f", DomainData.DOMAIN_NAME, "reqCostTime", "g", "o", "rspCostTime", h.F, "p", "webCreateCostTime", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "webLoadCostTime", "k", "adShowCostTime", "j", "adCloseCostTime", "l", "adShownTime", "<init>", "(Lcom/tencent/sqshow/zootopia/operation/facead/report/ZootopiaFaceAdReport$STEP;JJJJJJJJ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.operation.facead.report.ZootopiaFaceAdReport$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class StepRecord {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private STEP lastStep;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private long portalCreateTime;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private long reqCostTime;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private long rspCostTime;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private long webCreateCostTime;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        private long webLoadCostTime;

        /* renamed from: g, reason: from kotlin metadata and from toString */
        private long adShowCostTime;

        /* renamed from: h, reason: from toString */
        private long adCloseCostTime;

        /* renamed from: i, reason: from kotlin metadata and from toString */
        private long adShownTime;

        public StepRecord(STEP lastStep, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28) {
            Intrinsics.checkNotNullParameter(lastStep, "lastStep");
            this.lastStep = lastStep;
            this.portalCreateTime = j3;
            this.reqCostTime = j16;
            this.rspCostTime = j17;
            this.webCreateCostTime = j18;
            this.webLoadCostTime = j19;
            this.adShowCostTime = j26;
            this.adCloseCostTime = j27;
            this.adShownTime = j28;
        }

        /* renamed from: a, reason: from getter */
        public final long getAdCloseCostTime() {
            return this.adCloseCostTime;
        }

        /* renamed from: b, reason: from getter */
        public final long getAdShowCostTime() {
            return this.adShowCostTime;
        }

        /* renamed from: c, reason: from getter */
        public final long getAdShownTime() {
            return this.adShownTime;
        }

        /* renamed from: d, reason: from getter */
        public final STEP getLastStep() {
            return this.lastStep;
        }

        /* renamed from: e, reason: from getter */
        public final long getPortalCreateTime() {
            return this.portalCreateTime;
        }

        /* renamed from: f, reason: from getter */
        public final long getReqCostTime() {
            return this.reqCostTime;
        }

        /* renamed from: g, reason: from getter */
        public final long getRspCostTime() {
            return this.rspCostTime;
        }

        /* renamed from: h, reason: from getter */
        public final long getWebCreateCostTime() {
            return this.webCreateCostTime;
        }

        public int hashCode() {
            return (((((((((((((((this.lastStep.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.portalCreateTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.reqCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.rspCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.webCreateCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.webLoadCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.adShowCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.adCloseCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.adShownTime);
        }

        /* renamed from: i, reason: from getter */
        public final long getWebLoadCostTime() {
            return this.webLoadCostTime;
        }

        public final void j(long j3) {
            this.adCloseCostTime = j3;
        }

        public final void k(long j3) {
            this.adShowCostTime = j3;
        }

        public final void l(long j3) {
            this.adShownTime = j3;
        }

        public final void m(STEP step) {
            Intrinsics.checkNotNullParameter(step, "<set-?>");
            this.lastStep = step;
        }

        public final void n(long j3) {
            this.reqCostTime = j3;
        }

        public final void o(long j3) {
            this.rspCostTime = j3;
        }

        public final void p(long j3) {
            this.webCreateCostTime = j3;
        }

        public final void q(long j3) {
            this.webLoadCostTime = j3;
        }

        public String toString() {
            return "StepRecord(lastStep=" + this.lastStep + ", portalCreateTime=" + this.portalCreateTime + ", reqCostTime=" + this.reqCostTime + ", rspCostTime=" + this.rspCostTime + ", webCreateCostTime=" + this.webCreateCostTime + ", webLoadCostTime=" + this.webLoadCostTime + ", adShowCostTime=" + this.adShowCostTime + ", adCloseCostTime=" + this.adCloseCostTime + ", adShownTime=" + this.adShownTime + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepRecord)) {
                return false;
            }
            StepRecord stepRecord = (StepRecord) other;
            return this.lastStep == stepRecord.lastStep && this.portalCreateTime == stepRecord.portalCreateTime && this.reqCostTime == stepRecord.reqCostTime && this.rspCostTime == stepRecord.rspCostTime && this.webCreateCostTime == stepRecord.webCreateCostTime && this.webLoadCostTime == stepRecord.webLoadCostTime && this.adShowCostTime == stepRecord.adShowCostTime && this.adCloseCostTime == stepRecord.adCloseCostTime && this.adShownTime == stepRecord.adShownTime;
        }

        public /* synthetic */ StepRecord(STEP step, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(step, j3, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? 0L : j17, (i3 & 16) != 0 ? 0L : j18, (i3 & 32) != 0 ? 0L : j19, (i3 & 64) != 0 ? 0L : j26, (i3 & 128) != 0 ? 0L : j27, (i3 & 256) != 0 ? 0L : j28);
        }
    }

    public final void c(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i3));
            if (record == null || record.getLastStep() != STEP.ON_PORTAL_CREATE) {
                return;
            }
            record.m(STEP.ON_AD_REQ);
            record.n(System.currentTimeMillis() - record.getPortalCreateTime());
            ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
            Intrinsics.checkNotNullExpressionValue(record, "record");
            HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
            c.c(c.f416532a, "e_zplan_facead_req", a16, false, 4, null);
            QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdRequest enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void d(Bundle bundle, boolean needShow) {
        String str;
        if (bundle != null) {
            int i3 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i3));
            if (record == null || record.getLastStep() != STEP.ON_AD_REQ) {
                return;
            }
            record.m(STEP.ON_AD_RSP);
            record.o((System.currentTimeMillis() - record.getPortalCreateTime()) - record.getReqCostTime());
            ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
            Intrinsics.checkNotNullExpressionValue(record, "record");
            HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
            a16.put("k_facead_total_cost_time", String.valueOf(System.currentTimeMillis() - record.getPortalCreateTime()));
            if (needShow) {
                str = "1";
            } else {
                str = "0";
            }
            a16.put("k_need_show", str);
            c.c(c.f416532a, "e_zplan_facead_rsp", a16, false, 4, null);
            QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdResponse enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void g(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i3));
            if (record == null || record.getLastStep() != STEP.ON_AD_RSP) {
                return;
            }
            record.m(STEP.ON_AD_WEB_CREATE);
            record.p(((System.currentTimeMillis() - record.getPortalCreateTime()) - record.getRspCostTime()) - record.getReqCostTime());
            ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
            Intrinsics.checkNotNullExpressionValue(record, "record");
            HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
            a16.put("k_facead_total_cost_time", String.valueOf(System.currentTimeMillis() - record.getPortalCreateTime()));
            c.c(c.f416532a, "e_zplan_facead_create", a16, false, 4, null);
            QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdWebCreate enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void h(Bundle bundle, int i3, int i16) {
        if (bundle != null) {
            int i17 = bundle.getInt("report_num", -1);
            StepRecord record = recordCache.get(Integer.valueOf(i17));
            if (record != null) {
                if (record.getLastStep() == STEP.ON_AD_WEB_CREATE || record.getLastStep() == STEP.ON_AD_SHOW) {
                    record.q((((System.currentTimeMillis() - record.getPortalCreateTime()) - record.getRspCostTime()) - record.getReqCostTime()) - record.getWebCreateCostTime());
                    ZootopiaFaceAdReport zootopiaFaceAdReport = f372190a;
                    Intrinsics.checkNotNullExpressionValue(record, "record");
                    HashMap<String, String> a16 = zootopiaFaceAdReport.a(record);
                    a16.put("k_load_result_code", String.valueOf(i3));
                    a16.put("k_load_ssl_err_code", String.valueOf(i16));
                    a16.put("k_facead_total_cost_time", String.valueOf(System.currentTimeMillis() - record.getPortalCreateTime()));
                    c.c(c.f416532a, "e_zplan_facead_load_result", a16, false, 4, null);
                    QLog.d("ZootopiaFaceAdReport", 4, "onFaceAdWebLoadResult enterNum=" + i17 + " params=" + a16);
                }
            }
        }
    }

    public final void i(Bundle bundle) {
        int andIncrement = faceAdReportNum.getAndIncrement();
        recordCache.put(Integer.valueOf(andIncrement), new StepRecord(STEP.ON_PORTAL_CREATE, System.currentTimeMillis(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 508, null));
        if (bundle != null) {
            bundle.putInt("report_num", andIncrement);
        }
        QLog.d("ZootopiaFaceAdReport", 4, "onPortalCreate enterNum=" + andIncrement);
    }

    public final void j(Bundle bundle) {
        int i3 = bundle != null ? bundle.getInt("report_num", -1) : -1;
        if (recordCache.get(Integer.valueOf(i3)) != null) {
            QLog.i("ZootopiaFaceAdReport", 1, "onPortalDestroy clearCache - " + i3);
            recordCache.remove(Integer.valueOf(i3));
        }
    }

    public static /* synthetic */ void f(ZootopiaFaceAdReport zootopiaFaceAdReport, Bundle bundle, int i3, int i16, String str, boolean z16, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z16 = false;
        }
        zootopiaFaceAdReport.e(bundle, i3, i16, str, z16);
    }
}
