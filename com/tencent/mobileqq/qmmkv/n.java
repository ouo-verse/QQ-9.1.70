package com.tencent.mobileqq.qmmkv;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007H\u0016R\u00d9\u0001\u0010\u000f\u001a\u00c6\u0001\u0012\\\u0012Z\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007 \f*,\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007\u0018\u00010\u000b0\u000b \f*b\u0012\\\u0012Z\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007 \f*,\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007\u0018\u00010\u000b0\u000b\u0018\u00010\r0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR*\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/n;", "Lcom/tencent/mobileqq/qmmkv/e;", "", "b", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "param", "report", "", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "pendingItems", "", "value", "c", "Z", "getAfterLogin", "()Z", "d", "(Z)V", "afterLogin", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class n implements e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f262021a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<Pair<String, HashMap<String, String>>> pendingItems = Collections.synchronizedSet(new HashSet(100));

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean afterLogin;

    n() {
    }

    private final void b() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.m
            @Override // java.lang.Runnable
            public final void run() {
                n.c();
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        Set<Pair<String, HashMap<String, String>>> set = pendingItems;
        HashSet<Pair> hashSet = new HashSet(set.size());
        try {
            Result.Companion companion = Result.INSTANCE;
            hashSet.addAll(set);
            set.clear();
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVReport", 2, "postReportAfterLogin pendingItems: " + hashSet.size());
        }
        for (Pair pair : hashSet) {
            try {
                StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, (String) pair.getFirst(), true, 0L, 0L, (HashMap) pair.getSecond(), "");
            } catch (Throwable th6) {
                QLog.w("MMKVReport", 1, "postReportAfterLogin exception: " + th6.getMessage(), th6);
            }
        }
    }

    public final void d(boolean z16) {
        afterLogin = z16;
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MMKVReport", 2, "set afterLogin=true pendingItems: " + pendingItems.size());
            }
            if (pendingItems.size() > 0) {
                b();
            }
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.e
    public void report(@NotNull String eventName, @NotNull HashMap<String, String> param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(param, "param");
        if (afterLogin) {
            try {
                StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, eventName, true, 0L, 0L, param, "");
                return;
            } catch (Throwable th5) {
                QLog.w("MMKVReport", 1, "report exception: " + th5.getMessage(), th5);
                return;
            }
        }
        Set<Pair<String, HashMap<String, String>>> set = pendingItems;
        if (set.size() < 100) {
            set.add(TuplesKt.to(eventName, param));
        }
    }
}
