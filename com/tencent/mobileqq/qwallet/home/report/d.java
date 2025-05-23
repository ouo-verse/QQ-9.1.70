package com.tencent.mobileqq.qwallet.home.report;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.h5.QWalletH5TechReportHandler;
import com.tencent.mobileqq.qwallet.home.QWalletHomePreviewController;
import com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bJ\u0018\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020$R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/d;", "", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "step", "", "b", ReportConstant.COSTREPORT_PREFIX, "", "c", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "", "isAdNative", "useQWalletAdExposureChecker", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", h.F, "r", "isSucceed", DomainData.DOMAIN_NAME, "", "advId", "g", "p", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "e", "", "screenHeight", "advHeight", "advTop", "i", "f", "d", "Lcom/tencent/mobileqq/app/QBaseFragment;", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "stepMap", "J", "enterTime", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5TechReportHandler;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5TechReportHandler;", "h5ReportHandler", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long enterTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<QWalletHomeStep.StepEnum, QWalletHomeStep> stepMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletH5TechReportHandler h5ReportHandler = new QWalletH5TechReportHandler(null);

    private final void b(QWalletHomeStep step) {
        QLog.d("QWalletHomeReporter", 2, "addStep: " + step + "}");
        if (step == null) {
            return;
        }
        this.stepMap.put(step.getStepEnum(), step);
    }

    private final long c() {
        return System.currentTimeMillis() - this.enterTime;
    }

    private final void s() {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.h5ReportHandler.c());
        Iterator<Map.Entry<QWalletHomeStep.StepEnum, QWalletHomeStep>> it = this.stepMap.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.putAll(ml2.d.f416922a.a(it.next().getValue()));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.report.c
            @Override // java.lang.Runnable
            public final void run() {
                d.t(linkedHashMap);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Map retMap) {
        Intrinsics.checkNotNullParameter(retMap, "$retMap");
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_qwallet_home", (Map<String, String>) retMap);
    }

    public final void d() {
        b(new QWalletHomeStep.AdvClickAction(c()));
    }

    public final void e() {
        b(new QWalletHomeStep.AdvExposure(c()));
    }

    public final void f() {
        QWalletHomeStep.AdvExposure advExposure;
        long currentTimeMillis;
        QWalletHomeStep qWalletHomeStep = this.stepMap.get(QWalletHomeStep.StepEnum.AdvExposure);
        if (qWalletHomeStep instanceof QWalletHomeStep.AdvExposure) {
            advExposure = (QWalletHomeStep.AdvExposure) qWalletHomeStep;
        } else {
            advExposure = null;
        }
        if (advExposure == null) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - advExposure.getStepTime();
        }
        b(new QWalletHomeStep.AdvExposureValid(c(), currentTimeMillis));
    }

    public final void g(@Nullable String advId, boolean isSucceed) {
        QWalletHomeStep.AdvReqStart advReqStart;
        long currentTimeMillis;
        QWalletHomeStep qWalletHomeStep = this.stepMap.get(QWalletHomeStep.StepEnum.AdvReqStart);
        if (qWalletHomeStep instanceof QWalletHomeStep.AdvReqStart) {
            advReqStart = (QWalletHomeStep.AdvReqStart) qWalletHomeStep;
        } else {
            advReqStart = null;
        }
        if (advReqStart == null) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - advReqStart.getStepTime();
        }
        long j3 = currentTimeMillis;
        long c16 = c();
        if (advId == null) {
            advId = "";
        }
        b(new QWalletHomeStep.AdvReqFinish(c16, j3, advId, isSucceed));
    }

    public final void h() {
        b(new QWalletHomeStep.AdvReqStart(c()));
    }

    public final void i(int screenHeight, int advHeight, int advTop) {
        boolean z16;
        if ((advHeight / 2) + advTop < screenHeight) {
            z16 = true;
        } else {
            z16 = false;
        }
        b(new QWalletHomeStep.AdvLayout(screenHeight, advHeight, advTop, z16));
    }

    public final void j(@NotNull QWalletBaseFragment fragment, boolean isAdNative, boolean useQWalletAdExposureChecker) {
        QWalletHomeStep.ClickAction clickAction;
        long currentTimeMillis;
        long coerceAtMost;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = fragment.getIntent();
        if (intent != null) {
            clickAction = (QWalletHomeStep.ClickAction) intent.getParcelableExtra("KEY_CLICK_ENTRY_BEAN");
        } else {
            clickAction = null;
        }
        b(clickAction);
        if (clickAction != null) {
            currentTimeMillis = clickAction.getTimestamp();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(System.currentTimeMillis() - currentTimeMillis, 10000L);
        b(new QWalletHomeStep.PageCreated(coerceAtMost, m.e(), isAdNative, useQWalletAdExposureChecker, QWalletHomePreviewController.f277969a.h(fragment).ordinal()));
        long currentTimeMillis2 = System.currentTimeMillis();
        this.enterTime = currentTimeMillis2;
        QWalletH5TechReportHandler qWalletH5TechReportHandler = this.h5ReportHandler;
        qWalletH5TechReportHandler.f(currentTimeMillis2);
        qWalletH5TechReportHandler.e(fragment);
    }

    public final void k(@NotNull QBaseFragment fragment) {
        Object next;
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Collection<QWalletHomeStep> values = this.stepMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "stepMap.values");
        Iterator<T> it = values.iterator();
        QWalletHomeStep.StepEnum stepEnum = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                int ordinal = ((QWalletHomeStep) next).getStepEnum().ordinal();
                do {
                    Object next2 = it.next();
                    int ordinal2 = ((QWalletHomeStep) next2).getStepEnum().ordinal();
                    if (ordinal < ordinal2) {
                        next = next2;
                        ordinal = ordinal2;
                    }
                } while (it.hasNext());
            }
        }
        QWalletHomeStep qWalletHomeStep = (QWalletHomeStep) next;
        if (qWalletHomeStep == null) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - qWalletHomeStep.getStepTime();
        }
        long j3 = currentTimeMillis;
        long c16 = c();
        if (qWalletHomeStep != null) {
            stepEnum = qWalletHomeStep.getStepEnum();
        }
        b(new QWalletHomeStep.PageQuit(c16, stepEnum, j3));
        s();
        this.h5ReportHandler.h(fragment);
    }

    public final void l() {
        b(new QWalletHomeStep.H5LoadFinish(c()));
    }

    public final void m(@Nullable String url) {
        this.h5ReportHandler.g(url);
    }

    public final void n(boolean isSucceed) {
        QWalletHomeStep.HomeReqStart homeReqStart;
        long currentTimeMillis;
        QWalletHomeStep qWalletHomeStep = this.stepMap.get(QWalletHomeStep.StepEnum.HomeReqStart);
        if (qWalletHomeStep instanceof QWalletHomeStep.HomeReqStart) {
            homeReqStart = (QWalletHomeStep.HomeReqStart) qWalletHomeStep;
        } else {
            homeReqStart = null;
        }
        if (homeReqStart == null) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - homeReqStart.getStepTime();
        }
        b(new QWalletHomeStep.HomeReqFinish(c(), currentTimeMillis, isSucceed));
    }

    public final void o() {
        b(new QWalletHomeStep.HomeReqStart(c()));
    }

    public final void p() {
        b(new QWalletHomeStep.RenderView(c()));
    }

    public final void q() {
        QWalletHomeStep.PageResume pageResume;
        QWalletHomeStep qWalletHomeStep = this.stepMap.get(QWalletHomeStep.StepEnum.PageResume);
        if (qWalletHomeStep instanceof QWalletHomeStep.PageResume) {
            pageResume = (QWalletHomeStep.PageResume) qWalletHomeStep;
        } else {
            pageResume = null;
        }
        if (pageResume == null) {
            b(new QWalletHomeStep.PageResume(0, 1, null));
        } else {
            pageResume.e(pageResume.getPageVisibleCount() + 1);
        }
    }

    public final void r() {
        b(new QWalletHomeStep.PageViewCreated(c()));
    }
}
