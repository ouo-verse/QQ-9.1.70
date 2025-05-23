package com.tencent.rdelivery.util;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.qmethod.monitor.PMBridage;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.RDeliveryData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\fJ0\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002R\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/rdelivery/util/RightlyHelper;", "", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "data", "", "elapsedRealtime", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "e", "", "b", "d", h.F, "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "f", "rightlyFullReport", "g", "hitSubTaskTags", "hitSubTaskID", "c", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "rightlyReportClsObj", "Lcom/tencent/raft/standard/storage/IRStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", "commonStorage", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RightlyHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Class<?> rightlyReportClsObj;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static IRStorage commonStorage;

    /* renamed from: c, reason: collision with root package name */
    public static final RightlyHelper f364646c = new RightlyHelper();

    RightlyHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b(RDeliverySetting setting) {
        boolean z16;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        c logger;
        IRStorage iRStorage;
        long j3;
        String rdInstanceIdentifier = setting.getRdInstanceIdentifier();
        IRStorage iRStorage2 = commonStorage;
        if (iRStorage2 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                String string = iRStorage2.getString("key_rightly_full_report_" + rdInstanceIdentifier, String.valueOf(false));
                Intrinsics.checkExpressionValueIsNotNull(string, "it.getString(\n          \u2026tring()\n                )");
                z16 = Boolean.parseBoolean(string);
            } catch (Throwable th5) {
                th = th5;
                z16 = false;
            }
            try {
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th6) {
                th = th6;
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    logger.d(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "getAdjustedRightlyFullReportValue err", m479exceptionOrNullimpl);
                }
                Result.m475boximpl(m476constructorimpl);
                String str = "key_rightly_full_report_turn_on_time_" + rdInstanceIdentifier;
                iRStorage = commonStorage;
                if (iRStorage == null) {
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!z16) {
                }
                return z16;
            }
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null && (logger = setting.getLogger()) != null) {
                logger.d(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "getAdjustedRightlyFullReportValue err", m479exceptionOrNullimpl);
            }
            Result.m475boximpl(m476constructorimpl);
        } else {
            z16 = false;
        }
        String str2 = "key_rightly_full_report_turn_on_time_" + rdInstanceIdentifier;
        iRStorage = commonStorage;
        if (iRStorage == null) {
            j3 = iRStorage.getLong(str2, 0L);
        } else {
            j3 = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!z16 && j3 > 0 && currentTimeMillis2 - j3 > 86400000) {
            c logger2 = setting.getLogger();
            if (logger2 == null) {
                return false;
            }
            logger2.a(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "getAdjustedRightlyFullReportValue adjust to false", setting.getEnableDetailLog());
            return false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String key, RDeliveryData data, long elapsedRealtime, RDeliverySetting setting) {
        Class<?> cls;
        a aVar = a.f364654d;
        String c16 = c(aVar.d(setting), data.getHitSubTaskID());
        boolean b16 = b(setting);
        if (c16 != null && (cls = rightlyReportClsObj) != null) {
            aVar.j(cls, "appendTag", new Class[]{String.class, Boolean.TYPE, Long.TYPE}, new Object[]{c16, Boolean.valueOf(b16), Long.valueOf(elapsedRealtime)}, setting.getLogger());
        }
    }

    @Nullable
    public final String c(@NotNull String hitSubTaskTags, @NotNull String hitSubTaskID) {
        List<String> split$default;
        boolean startsWith$default;
        Intrinsics.checkParameterIsNotNull(hitSubTaskTags, "hitSubTaskTags");
        Intrinsics.checkParameterIsNotNull(hitSubTaskID, "hitSubTaskID");
        split$default = StringsKt__StringsKt.split$default((CharSequence) hitSubTaskTags, new String[]{"|"}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, hitSubTaskID + util.base64_pad_url, false, 2, null);
            if (startsWith$default) {
                return str;
            }
        }
        return null;
    }

    public final synchronized void d(@NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        if (commonStorage != null) {
            c logger = setting.getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "init return for already initialed", setting.getEnableDetailLog());
            }
            return;
        }
        c logger2 = setting.getLogger();
        if (logger2 != null) {
            c.b(logger2, d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "init", false, 4, null);
        }
        try {
            PMBridage pMBridage = PMBridage.INSTANCE;
            rightlyReportClsObj = PMBridage.class;
        } catch (ClassNotFoundException unused) {
            c logger3 = setting.getLogger();
            if (logger3 != null) {
                c.b(logger3, d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "init error", false, 4, null);
            }
        }
        commonStorage = setting.getCommonStorage();
    }

    public final void f(@NotNull final String key, @Nullable final RDeliveryData data, final long elapsedRealtime, @NotNull final RDeliverySetting setting, @NotNull IRTask taskInterface) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        if (rightlyReportClsObj != null && data != null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.rdelivery.util.RightlyHelper$onQueryLocalData$runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        RightlyHelper.f364646c.e(key, data, elapsedRealtime, setting);
                        Result.m476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                }
            };
            Class<?> cls = rightlyReportClsObj;
            if (cls != null) {
                a.f364654d.j(cls, Method.POST, new Class[]{Runnable.class}, new Object[]{runnable}, setting.getLogger());
            }
        }
    }

    public final void g(@NotNull RDeliverySetting setting, boolean rightlyFullReport) {
        Object m476constructorimpl;
        c logger;
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        if (rightlyReportClsObj != null) {
            c logger2 = setting.getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "setIsRightlyFullReport rightlyFullReport = " + rightlyFullReport, setting.getEnableDetailLog());
            }
            String rdInstanceIdentifier = setting.getRdInstanceIdentifier();
            IRStorage iRStorage = commonStorage;
            boolean z16 = false;
            if (iRStorage != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String string = iRStorage.getString("key_rightly_full_report_" + rdInstanceIdentifier, String.valueOf(false));
                    Intrinsics.checkExpressionValueIsNotNull(string, "it.getString(\n          \u2026tring()\n                )");
                    z16 = Boolean.parseBoolean(string);
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null && (logger = setting.getLogger()) != null) {
                    logger.d(d.a("RDelivery_RightlyHelper", setting.getRdInstanceIdentifier()), "setIsRightlyFullReport err", m479exceptionOrNullimpl);
                }
                Result.m475boximpl(m476constructorimpl);
            }
            if (rightlyFullReport != z16) {
                if (rightlyFullReport) {
                    IRStorage iRStorage2 = commonStorage;
                    if (iRStorage2 != null) {
                        iRStorage2.putLong("key_rightly_full_report_turn_on_time_" + rdInstanceIdentifier, System.currentTimeMillis());
                    }
                } else {
                    IRStorage iRStorage3 = commonStorage;
                    if (iRStorage3 != null) {
                        iRStorage3.remove("key_rightly_full_report_turn_on_time_" + rdInstanceIdentifier);
                    }
                }
                IRStorage iRStorage4 = commonStorage;
                if (iRStorage4 != null) {
                    iRStorage4.putString("key_rightly_full_report_" + rdInstanceIdentifier, String.valueOf(rightlyFullReport));
                }
            }
        }
    }

    public final boolean h() {
        if (rightlyReportClsObj != null) {
            return true;
        }
        return false;
    }
}
