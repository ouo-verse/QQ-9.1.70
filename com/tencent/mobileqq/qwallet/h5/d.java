package com.tencent.mobileqq.qwallet.h5;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.h5.QWalletH5Step;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010#\u001a\u00020\u0013\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/d;", "", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "step", "", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "", "hasLoginCookies", "d", "k", "l", "i", "f", h.F, "", "title", "j", "g", "hasInvalidCookie", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "stepMap", "J", "enterTime", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5TechReportHandler;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5TechReportHandler;", "h5ReportHandler", "hostUrl", "<init>", "(Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<QWalletH5Step.StepEnum, QWalletH5Step> stepMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long enterTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletH5TechReportHandler h5ReportHandler;

    public d(@NotNull String hostUrl) {
        Intrinsics.checkNotNullParameter(hostUrl, "hostUrl");
        this.stepMap = new ConcurrentHashMap<>();
        this.h5ReportHandler = new QWalletH5TechReportHandler(hostUrl);
    }

    private final void b(QWalletH5Step step) {
        QLog.i("QWalletH5TechReporter", 1, "addStep: " + step + "}");
        if (step == null) {
            return;
        }
        this.stepMap.put(step.getStepEnum(), step);
    }

    private final long c() {
        return System.currentTimeMillis() - this.enterTime;
    }

    private final void m() {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.h5ReportHandler.c());
        Iterator<Map.Entry<QWalletH5Step.StepEnum, QWalletH5Step>> it = this.stepMap.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.putAll(ml2.d.f416922a.a(it.next().getValue()));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.h5.c
            @Override // java.lang.Runnable
            public final void run() {
                d.n(linkedHashMap);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Map retMap) {
        Intrinsics.checkNotNullParameter(retMap, "$retMap");
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_qwallet_h5", (Map<String, String>) retMap);
    }

    public final void d(@NotNull QBaseFragment fragment, boolean hasLoginCookies) {
        QWalletH5Step.ClickAction clickAction;
        long currentTimeMillis;
        long coerceAtMost;
        Intent intent;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            clickAction = (QWalletH5Step.ClickAction) intent.getParcelableExtra("KEY_CLICK_ENTRY_BEAN");
        } else {
            clickAction = null;
        }
        b(clickAction);
        if (clickAction != null) {
            currentTimeMillis = clickAction.getTimestamp();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(System.currentTimeMillis() - currentTimeMillis, 20000L);
        b(new QWalletH5Step.PageCreated(coerceAtMost, m.e(), hasLoginCookies));
        long currentTimeMillis2 = System.currentTimeMillis();
        this.enterTime = currentTimeMillis2;
        QWalletH5TechReportHandler qWalletH5TechReportHandler = this.h5ReportHandler;
        qWalletH5TechReportHandler.f(currentTimeMillis2);
        qWalletH5TechReportHandler.e(fragment);
    }

    public final void e(@NotNull QBaseFragment fragment, boolean hasInvalidCookie) {
        Object next;
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Collection<QWalletH5Step> values = this.stepMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "stepMap.values");
        Iterator<T> it = values.iterator();
        QWalletH5Step.StepEnum stepEnum = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                int ordinal = ((QWalletH5Step) next).getStepEnum().ordinal();
                do {
                    Object next2 = it.next();
                    int ordinal2 = ((QWalletH5Step) next2).getStepEnum().ordinal();
                    if (ordinal < ordinal2) {
                        next = next2;
                        ordinal = ordinal2;
                    }
                } while (it.hasNext());
            }
        }
        QWalletH5Step qWalletH5Step = (QWalletH5Step) next;
        if (qWalletH5Step == null) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - qWalletH5Step.getStepTime();
        }
        long j3 = currentTimeMillis;
        long c16 = c();
        if (qWalletH5Step != null) {
            stepEnum = qWalletH5Step.getStepEnum();
        }
        b(new QWalletH5Step.PageQuit(hasInvalidCookie, c16, stepEnum, j3));
        m();
        this.h5ReportHandler.h(fragment);
    }

    public final void f() {
        if (!this.stepMap.containsKey(QWalletH5Step.StepEnum.FirstProgress)) {
            b(new QWalletH5Step.FirstProgress(c()));
        }
    }

    public final void g() {
        b(new QWalletH5Step.H5LoadFinished(c()));
    }

    public final void h() {
        b(new QWalletH5Step.H5PageStarted(c()));
    }

    public final void i() {
        b(new QWalletH5Step.onLoadUrl(c()));
    }

    public final void j(@Nullable String title) {
        boolean z16;
        boolean z17 = false;
        if (title != null) {
            if (title.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17 && !this.stepMap.containsKey(QWalletH5Step.StepEnum.ReceiveTitle)) {
            b(new QWalletH5Step.ReceiveTitle(c()));
        }
    }

    public final void k() {
        b(new QWalletH5Step.PageViewCreated(c()));
    }

    public final void l() {
        b(new QWalletH5Step.X5Init(c()));
    }
}
