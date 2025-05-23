package com.tencent.mobileqq.profilecard.report;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.NTTraceManager;
import com.tencent.qqnt.trace.l;
import com.tencent.qqnt.trace.m;
import com.tencent.qqnt.trace.n;
import com.tencent.qqnt.trace.o;
import com.tencent.qqnt.trace.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfileTraceManager;", "", "", "key", "value", "", "doReportInner", "Lkotlin/Function1;", "", "cb", "canReportKey", "doReport", "tag", "Ljava/lang/String;", "KEY_REPORT_TIME_PREFIX", "", "reportMinInterval", "I", "reportMinIntervalNonPublic", "hasInitSample", "Z", "isSampled", "Ljava/util/HashSet;", "Lcom/tencent/qqnt/trace/q;", "Lkotlin/collections/HashSet;", "allReport", "Ljava/util/HashSet;", "<init>", "()V", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ProfileTraceManager {
    public static final ProfileTraceManager INSTANCE = new ProfileTraceManager();
    private static final String KEY_REPORT_TIME_PREFIX = "KEY_PROFILE_REPORT_TIME_";
    private static final HashSet<q> allReport;
    private static volatile boolean hasInitSample = false;
    private static boolean isSampled = false;
    private static final int reportMinInterval = 14400000;
    private static final int reportMinIntervalNonPublic = 300000;
    private static final String tag = "ProfileTraceManager";

    static {
        HashSet<q> hashSet = new HashSet<>();
        allReport = hashSet;
        hashSet.add(new o());
        hashSet.add(new m());
        hashSet.add(new n());
        hashSet.add(new l());
    }

    ProfileTraceManager() {
    }

    private final void canReportKey(final String key, final Function1<? super Boolean, Unit> cb5) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.report.a
            @Override // java.lang.Runnable
            public final void run() {
                ProfileTraceManager.canReportKey$lambda$1(key, cb5);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void canReportKey$lambda$1(String key, Function1 cb5) {
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong(KEY_REPORT_TIME_PREFIX + key, -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong > 0) {
            if (!(currentTimeMillis - decodeLong > ((long) 14400000))) {
                cb5.invoke(Boolean.FALSE);
                return;
            }
        }
        from.encodeLong(KEY_REPORT_TIME_PREFIX + key, currentTimeMillis);
        cb5.invoke(Boolean.TRUE);
    }

    private final void doReportInner(final String key, final String value) {
        Object obj;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final long longAccountUin = peekAppRuntime.getLongAccountUin();
        if (longAccountUin <= 0) {
            return;
        }
        Iterator<T> it = allReport.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((q) obj).isTargetType()) {
                    break;
                }
            }
        }
        final q qVar = (q) obj;
        if (qVar == null) {
            return;
        }
        if (!hasInitSample) {
            isSampled = ((long) (NTTraceManager.f362318a.f() % qVar.a())) == longAccountUin % ((long) qVar.a());
            hasInitSample = true;
        }
        if (!isSampled) {
            QLog.w(tag, 1, "isNotSampled,key=" + key);
            return;
        }
        canReportKey(key, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.profilecard.report.ProfileTraceManager$doReportInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    QLog.w("ProfileTraceManager", 1, "can't Report,time limit,key=" + key);
                    return;
                }
                QLog.w("ProfileTraceManager", 1, "doReport,key=" + key + ",value=" + value);
                HashMap hashMap = new HashMap();
                String str = key;
                String str2 = value;
                q qVar2 = qVar;
                hashMap.put(str, str2);
                hashMap.put("source", "PROFILE_PAGE");
                hashMap.put("app_type", String.valueOf(qVar2.getBuildType().getValue()));
                QQBeaconReport.reportWithAppKey("0AND05CMPBA8DUEM", String.valueOf(longAccountUin), "qq_part_performance_report", hashMap);
            }
        });
    }

    public final void doReport(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            doReportInner(key, value);
        } catch (Exception e16) {
            QLog.e(tag, 1, e16.getMessage());
        }
    }
}
