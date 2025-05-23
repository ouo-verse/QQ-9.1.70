package com.tencent.rdelivery.net;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001%\u0018\u0000 02\u00020\u0001:\u0002\u00161B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0017\u0010+\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b\u001b\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/rdelivery/net/ReqFreqLimiter;", "", "Landroid/content/Context;", "context", "", "g", "l", "k", "", "c", "b", "e", "d", "Lcom/tencent/rdelivery/net/BaseProto$PullType;", "pullType", "i", "", "j", "", "softInterval", "hardInterval", tl.h.F, "a", "J", "softIntervalFromServer", "hardIntervalFromServer", "softIntervalSetByHost", "f", "lastReqTSForFull", "lastReqTSForAny", "Lcom/tencent/raft/standard/storage/IRStorage;", "Lcom/tencent/raft/standard/storage/IRStorage;", "commonStorage", "Ljava/lang/String;", "rdInstanceIdentifier", "Z", "enableDetailLog", "com/tencent/rdelivery/net/ReqFreqLimiter$b", "Lcom/tencent/rdelivery/net/ReqFreqLimiter$b;", "listener", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/raft/standard/task/IRTask;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "InitCachedIntervalTask", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ReqFreqLimiter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long softInterval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long hardInterval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long softIntervalFromServer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long hardIntervalFromServer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long softIntervalSetByHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastReqTSForFull;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastReqTSForAny;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IRStorage commonStorage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String rdInstanceIdentifier;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean enableDetailLog;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final b listener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rdelivery/net/ReqFreqLimiter$InitCachedIntervalTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/net/ReqFreqLimiter;", "", TencentLocation.RUN_MODE, "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "reqFreqLimiter", "<init>", "(Lcom/tencent/rdelivery/net/ReqFreqLimiter;Landroid/content/Context;)V", "e", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class InitCachedIntervalTask extends IRTask.WeakReferenceTask<ReqFreqLimiter> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitCachedIntervalTask(@NotNull ReqFreqLimiter reqFreqLimiter, @NotNull Context context) {
            super(reqFreqLimiter, "RDelivery_InitIntervalTask", IRTask.Priority.NORMAL_PRIORITY);
            Intrinsics.checkParameterIsNotNull(reqFreqLimiter, "reqFreqLimiter");
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReqFreqLimiter ref = getRef();
            if (ref != null) {
                com.tencent.rdelivery.util.c logger = ref.getSetting().getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, "RDelivery_InitIntervalTask", "InitCachedIntervalTask in sub thread", false, 4, null);
                }
                ref.g(this.context);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/rdelivery/net/ReqFreqLimiter$b", "Lcom/tencent/rdelivery/RDeliverySetting$c;", "", "softInterval", "hardInterval", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements RDeliverySetting.c {
        b() {
        }

        @Override // com.tencent.rdelivery.RDeliverySetting.c
        public void a(long softInterval, long hardInterval) {
            ReqFreqLimiter.this.h(softInterval, hardInterval);
        }
    }

    public ReqFreqLimiter(@NotNull Context context, @NotNull RDeliverySetting setting, @NotNull IRTask taskInterface) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        this.setting = setting;
        this.enableDetailLog = setting.getEnableDetailLog();
        b bVar = new b();
        this.listener = bVar;
        this.rdInstanceIdentifier = setting.c();
        this.softIntervalSetByHost = setting.getNextFullReqIntervalLimit();
        setting.a(bVar);
        taskInterface.startTask(IRTask.TaskType.SIMPLE_TASK, new InitCachedIntervalTask(this, context));
    }

    private final String b() {
        return "LastReqTSForAny_" + this.rdInstanceIdentifier;
    }

    private final String c() {
        return "LastReqTSForFull_" + this.rdInstanceIdentifier;
    }

    private final String d() {
        return "HardIntervalFromServer_" + this.rdInstanceIdentifier;
    }

    private final String e() {
        return "SoftIntervalFromServer_" + this.rdInstanceIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Context context) {
        long j3;
        long j16;
        long j17;
        IRStorage commonStorage = this.setting.getCommonStorage();
        this.commonStorage = commonStorage;
        long j18 = 0;
        if (commonStorage != null) {
            j3 = commonStorage.getLong(c(), 0L);
        } else {
            j3 = 0;
        }
        this.lastReqTSForFull = j3;
        IRStorage iRStorage = this.commonStorage;
        if (iRStorage != null) {
            j16 = iRStorage.getLong(b(), 0L);
        } else {
            j16 = 0;
        }
        this.lastReqTSForAny = j16;
        IRStorage iRStorage2 = this.commonStorage;
        if (iRStorage2 != null) {
            j17 = iRStorage2.getLong(e(), 0L);
        } else {
            j17 = 0;
        }
        this.softIntervalFromServer = j17;
        IRStorage iRStorage3 = this.commonStorage;
        if (iRStorage3 != null) {
            j18 = iRStorage3.getLong(d(), 0L);
        }
        this.hardIntervalFromServer = j18;
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_ReqFreqLimiter", this.rdInstanceIdentifier), "initCachedInterval lastReqTSForFull = " + this.lastReqTSForFull + ", lastReqTSForAny = " + this.lastReqTSForAny + ", ,softIntervalFromServer = " + this.softIntervalFromServer + ", hardIntervalFromServer = " + this.hardIntervalFromServer, this.enableDetailLog);
        }
        l();
        k();
    }

    private final void k() {
        this.hardInterval = this.hardIntervalFromServer;
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_ReqFreqLimiter", this.rdInstanceIdentifier), "updateHardInterval hardInterval = " + this.hardInterval, this.enableDetailLog);
        }
    }

    private final void l() {
        long j3 = this.softIntervalFromServer;
        if (j3 <= 0) {
            j3 = this.softIntervalSetByHost;
        }
        this.softInterval = j3;
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_ReqFreqLimiter", this.rdInstanceIdentifier), "updateSoftInterval softInterval = " + this.softInterval + ",softIntervalSetByHost = " + this.softIntervalSetByHost + ", softIntervalFromServer = " + this.softIntervalFromServer, this.enableDetailLog);
        }
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }

    public final void h(long softInterval, long hardInterval) {
        if (softInterval != this.softIntervalFromServer) {
            this.softIntervalFromServer = softInterval;
            l();
            IRStorage iRStorage = this.commonStorage;
            if (iRStorage != null) {
                iRStorage.putLong(e(), this.softIntervalFromServer);
            }
        }
        if (hardInterval != this.hardIntervalFromServer) {
            this.hardIntervalFromServer = hardInterval;
            k();
            IRStorage iRStorage2 = this.commonStorage;
            if (iRStorage2 != null) {
                iRStorage2.putLong(d(), this.hardIntervalFromServer);
            }
        }
    }

    public final void i(@NotNull BaseProto$PullType pullType) {
        Intrinsics.checkParameterIsNotNull(pullType, "pullType");
        this.lastReqTSForAny = SystemClock.elapsedRealtime();
        IRStorage iRStorage = this.commonStorage;
        if (iRStorage != null) {
            iRStorage.putLong(b(), this.lastReqTSForAny);
        }
        if (pullType == BaseProto$PullType.ALL) {
            this.lastReqTSForFull = this.lastReqTSForAny;
            IRStorage iRStorage2 = this.commonStorage;
            if (iRStorage2 != null) {
                iRStorage2.putLong(c(), this.lastReqTSForFull);
            }
        }
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_ReqFreqLimiter", this.rdInstanceIdentifier), "recordReqTimeStamp " + pullType + ", lastReqTSForAny = " + this.lastReqTSForAny + ", lastReqTSForFull = " + this.lastReqTSForFull, this.enableDetailLog);
        }
    }

    public final boolean j(@NotNull BaseProto$PullType pullType) {
        Intrinsics.checkParameterIsNotNull(pullType, "pullType");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDelivery_ReqFreqLimiter", this.rdInstanceIdentifier), "shouldLimitReq " + pullType + ", curTS = " + elapsedRealtime + ", lastReqTSForFull = " + this.lastReqTSForFull + ", lastReqTSForAny = " + this.lastReqTSForAny + ", hardInterval = " + this.hardInterval + ", softInterval = " + this.softInterval, this.enableDetailLog);
        }
        long j3 = this.lastReqTSForFull;
        if (elapsedRealtime < j3) {
            return false;
        }
        long j16 = this.lastReqTSForAny;
        if (elapsedRealtime < j16) {
            return false;
        }
        long j17 = this.hardInterval;
        if (j17 > 0) {
            if (elapsedRealtime - j16 >= j17 * 1000) {
                return false;
            }
            return true;
        }
        long j18 = this.softInterval;
        if (j18 <= 0 || pullType != BaseProto$PullType.ALL || elapsedRealtime - j3 >= j18 * 1000) {
            return false;
        }
        return true;
    }
}
