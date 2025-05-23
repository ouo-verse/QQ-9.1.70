package com.tencent.sqshow.zootopia.report;

import android.os.Bundle;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mb4.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R2\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport;", "", "Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$a;", "stepRecord", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "bundle", "", "b", "c", "d", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "callNum", "", "Z", "isColdBoot", "isEngineExist", "", "Ljava/util/HashMap;", "stepRecordCache", "<init>", "()V", "STEP", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaStartUpReport {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isColdBoot;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isEngineExist;

    /* renamed from: a, reason: collision with root package name */
    public static final ZootopiaStartUpReport f372678a = new ZootopiaStartUpReport();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicInteger callNum = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, StepRecord> stepRecordCache = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;", "", "(Ljava/lang/String;I)V", "NONE", "ON_ENTER", "ON_CALL", "ON_CREATE", "ON_RESUME", "ON_SHOW", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum STEP {
        NONE,
        ON_ENTER,
        ON_CALL,
        ON_CREATE,
        ON_RESUME,
        ON_SHOW
    }

    ZootopiaStartUpReport() {
    }

    private final HashMap<String, String> a(StepRecord stepRecord) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("k_source", stepRecord.getSource().name());
        hashMap.put("k_oncall_cost_time", String.valueOf(stepRecord.getCallCostTime()));
        hashMap.put("k_oncreate_cost_time", String.valueOf(stepRecord.getCreateCostTime()));
        hashMap.put("k_onresume_cost_time", String.valueOf(stepRecord.getResumeCostTime()));
        hashMap.put("k_onshow_cost_time", String.valueOf(stepRecord.getShowCostTime()));
        String str2 = "1";
        if (isColdBoot) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("k_is_cold_boot", str);
        if (!isEngineExist) {
            str2 = "0";
        }
        hashMap.put("k_is_zplan_exist", str2);
        return hashMap;
    }

    public final void c(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt(ISchemeApi.KEY_STARTUP_ENTER_NUM);
            StepRecord stepRecord = stepRecordCache.get(Integer.valueOf(i3));
            if (stepRecord == null || stepRecord.getLastStep() != STEP.ON_ENTER) {
                return;
            }
            stepRecord.j(STEP.ON_CALL);
            stepRecord.h(System.currentTimeMillis() - stepRecord.getEnterTime());
            ZootopiaStartUpReport zootopiaStartUpReport = f372678a;
            Intrinsics.checkNotNullExpressionValue(stepRecord, "stepRecord");
            HashMap<String, String> a16 = zootopiaStartUpReport.a(stepRecord);
            a16.put("k_startup_total_cost_time", String.valueOf(stepRecord.getCallCostTime()));
            c.c(c.f416532a, "e_zplan_main_page_oncall", a16, false, 4, null);
            QLog.d("ZootopiaStartUpReport", 4, "onZootopiaMainPageCall enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void d(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt(ISchemeApi.KEY_STARTUP_ENTER_NUM);
            StepRecord stepRecord = stepRecordCache.get(Integer.valueOf(i3));
            if (stepRecord == null || stepRecord.getLastStep() != STEP.ON_CALL) {
                return;
            }
            stepRecord.j(STEP.ON_CREATE);
            stepRecord.i((System.currentTimeMillis() - stepRecord.getEnterTime()) - stepRecord.getCallCostTime());
            ZootopiaStartUpReport zootopiaStartUpReport = f372678a;
            Intrinsics.checkNotNullExpressionValue(stepRecord, "stepRecord");
            HashMap<String, String> a16 = zootopiaStartUpReport.a(stepRecord);
            a16.put("k_startup_total_cost_time", String.valueOf(System.currentTimeMillis() - stepRecord.getEnterTime()));
            c.c(c.f416532a, "e_zplan_main_page_oncreate", a16, false, 4, null);
            QLog.d("ZootopiaStartUpReport", 4, "onZootopiaMainPageCreate enterNum=" + i3 + " params=" + a16);
        }
    }

    public final void e(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt(ISchemeApi.KEY_STARTUP_ENTER_NUM);
            StepRecord stepRecord = stepRecordCache.get(Integer.valueOf(i3));
            if (stepRecord == null || stepRecord.getLastStep() != STEP.ON_CREATE) {
                return;
            }
            stepRecord.j(STEP.ON_RESUME);
            stepRecord.k(((System.currentTimeMillis() - stepRecord.getEnterTime()) - stepRecord.getCreateCostTime()) - stepRecord.getCallCostTime());
            ZootopiaStartUpReport zootopiaStartUpReport = f372678a;
            Intrinsics.checkNotNullExpressionValue(stepRecord, "stepRecord");
            HashMap<String, String> a16 = zootopiaStartUpReport.a(stepRecord);
            a16.put("k_startup_total_cost_time", String.valueOf(System.currentTimeMillis() - stepRecord.getEnterTime()));
            c.c(c.f416532a, "e_zplan_main_page_onresume", a16, false, 4, null);
            QLog.d("ZootopiaStartUpReport", 4, "onZootopiaMainPageResume enterNum=" + i3 + " params=" + a16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010'\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b&\u0010\u0017R\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b%\u0010\u0015\"\u0004\b(\u0010\u0017\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;", "a", "Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;", "d", "()Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;", "j", "(Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;)V", "lastStep", "", "b", "J", "c", "()J", "setEnterTime", "(J)V", "enterTime", "Lcom/tencent/mobileqq/zootopia/Source;", "Lcom/tencent/mobileqq/zootopia/Source;", "g", "()Lcom/tencent/mobileqq/zootopia/Source;", "setSource", "(Lcom/tencent/mobileqq/zootopia/Source;)V", "source", h.F, "callCostTime", "e", "i", "createCostTime", "f", "k", "resumeCostTime", "setShowCostTime", "showCostTime", "<init>", "(Lcom/tencent/sqshow/zootopia/report/ZootopiaStartUpReport$STEP;JLcom/tencent/mobileqq/zootopia/Source;JJJJ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.report.ZootopiaStartUpReport$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class StepRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private STEP lastStep;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long enterTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private Source source;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long callCostTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private long createCostTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long resumeCostTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private long showCostTime;

        public StepRecord(STEP lastStep, long j3, Source source, long j16, long j17, long j18, long j19) {
            Intrinsics.checkNotNullParameter(lastStep, "lastStep");
            Intrinsics.checkNotNullParameter(source, "source");
            this.lastStep = lastStep;
            this.enterTime = j3;
            this.source = source;
            this.callCostTime = j16;
            this.createCostTime = j17;
            this.resumeCostTime = j18;
            this.showCostTime = j19;
        }

        /* renamed from: a, reason: from getter */
        public final long getCallCostTime() {
            return this.callCostTime;
        }

        /* renamed from: b, reason: from getter */
        public final long getCreateCostTime() {
            return this.createCostTime;
        }

        /* renamed from: c, reason: from getter */
        public final long getEnterTime() {
            return this.enterTime;
        }

        /* renamed from: d, reason: from getter */
        public final STEP getLastStep() {
            return this.lastStep;
        }

        /* renamed from: e, reason: from getter */
        public final long getResumeCostTime() {
            return this.resumeCostTime;
        }

        /* renamed from: f, reason: from getter */
        public final long getShowCostTime() {
            return this.showCostTime;
        }

        /* renamed from: g, reason: from getter */
        public final Source getSource() {
            return this.source;
        }

        public final void h(long j3) {
            this.callCostTime = j3;
        }

        public int hashCode() {
            return (((((((((((this.lastStep.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.enterTime)) * 31) + this.source.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.callCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.createCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.resumeCostTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.showCostTime);
        }

        public final void i(long j3) {
            this.createCostTime = j3;
        }

        public final void j(STEP step) {
            Intrinsics.checkNotNullParameter(step, "<set-?>");
            this.lastStep = step;
        }

        public final void k(long j3) {
            this.resumeCostTime = j3;
        }

        public String toString() {
            return "StepRecord(lastStep=" + this.lastStep + ", enterTime=" + this.enterTime + ", source=" + this.source + ", callCostTime=" + this.callCostTime + ", createCostTime=" + this.createCostTime + ", resumeCostTime=" + this.resumeCostTime + ", showCostTime=" + this.showCostTime + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepRecord)) {
                return false;
            }
            StepRecord stepRecord = (StepRecord) other;
            return this.lastStep == stepRecord.lastStep && this.enterTime == stepRecord.enterTime && this.source == stepRecord.source && this.callCostTime == stepRecord.callCostTime && this.createCostTime == stepRecord.createCostTime && this.resumeCostTime == stepRecord.resumeCostTime && this.showCostTime == stepRecord.showCostTime;
        }

        public /* synthetic */ StepRecord(STEP step, long j3, Source source, long j16, long j17, long j18, long j19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(step, j3, source, (i3 & 8) != 0 ? 0L : j16, (i3 & 16) != 0 ? 0L : j17, (i3 & 32) != 0 ? 0L : j18, (i3 & 64) != 0 ? 0L : j19);
        }
    }

    public final void b(ZootopiaSource source, Bundle bundle) {
        Source mainSource;
        Intrinsics.checkNotNullParameter(source, "source");
        int andIncrement = callNum.getAndIncrement();
        isColdBoot = andIncrement == 0;
        isEngineExist = ZPlanServiceHelper.I.l0();
        ZootopiaSource c16 = ag.f373258a.c(source);
        if (c16 == null || (mainSource = c16.getMainSource()) == null) {
            mainSource = source.getMainSource();
        }
        StepRecord stepRecord = new StepRecord(STEP.ON_ENTER, System.currentTimeMillis(), mainSource, 0L, 0L, 0L, 0L, 120, null);
        stepRecordCache.put(Integer.valueOf(andIncrement), stepRecord);
        HashMap<String, String> a16 = a(stepRecord);
        c.c(c.f416532a, "e_zplan_main_page_onenter", a16, false, 4, null);
        QLog.d("ZootopiaStartUpReport", 4, "onZootopiaEntranceCall enterNum=" + andIncrement + " params=" + a16);
        if (bundle != null) {
            bundle.putInt(ISchemeApi.KEY_STARTUP_ENTER_NUM, andIncrement);
        }
    }
}
