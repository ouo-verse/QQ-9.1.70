package com.tencent.mobileqq.qqfeatureswitch.impl;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IShiply;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.rdelivery.net.BaseProto$DataRefreshMode;
import com.tencent.rdelivery.util.RDeliveryConstant$DataLoadMode;
import com.tencent.rfix.lib.RFix;
import com.tencent.upgrade.core.j;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import iz3.e;
import iz3.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 92\u00020\u0001:\u0002:;B\u0007\u00a2\u0006\u0004\b7\u00108J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001dH\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)\u0018\u00010(J\u001a\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010)J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010,J\u0006\u0010.\u001a\u00020\u0011R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R$\u0010\u0005\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl;", "Lcom/tencent/mobileqq/qqfeatureswitch/IShiply;", "Lcom/tencent/rdelivery/RDelivery;", "initRDelivery", "", "userId", "Lcom/tencent/rdelivery/RDeliverySetting;", "getRDeliverySetting", "Lcom/tencent/rdelivery/a;", "getDependencyInjector", "", "shouldReport", "Liz3/e;", "listener", "frequencyControl", "Lcom/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl$FetchFrom;", "fetchFrom", "", "fetchAll", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "isSwitchOn", "", "getInt", "getBool", "", "getLong", "", "getDouble", "", "getFloat", "getString", "", "getBytes", "Lorg/json/JSONObject;", "getJSONObject", "Lorg/json/JSONArray;", "getJSONArray", "clearData", "clearAll", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "getAllRDeliveryData", "getRDeliveryData", "Liz3/h;", "switchUserId", "reLogin", "rDelivery", "Lcom/tencent/rdelivery/RDelivery;", "inited", "Z", "<set-?>", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "<init>", "()V", "Companion", "a", "FetchFrom", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ShiplyImpl implements IShiply {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String APP_ID = "4cd6974be1";

    @NotNull
    public static final String APP_KEY = "0ccc46ca-154c-4c6b-8b0b-4d8537ffcbcc";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String EVENT_COLD_START = "shiply_cold_start";

    @NotNull
    public static final String EVENT_FETCH = "shiply_fetch";
    private static final long FETCH_INTERVAL = 21600000;

    @NotNull
    public static final String PKG_NAME = "com.tencent.mobileqq";

    @NotNull
    private static final String TAG = "RDeliveryServiceImpl";

    @NotNull
    private static final ConcurrentHashMap<String, Long> UIN_TO_FETCH_TIME;
    private volatile boolean inited;

    @Nullable
    private RDelivery rDelivery;

    @NotNull
    private String userId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl$FetchFrom;", "", "(Ljava/lang/String;I)V", "Foreground", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "UserIdChanged", "NetChanged", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class FetchFrom {
        private static final /* synthetic */ FetchFrom[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FetchFrom Foreground;
        public static final FetchFrom Init;
        public static final FetchFrom NetChanged;
        public static final FetchFrom UserIdChanged;

        private static final /* synthetic */ FetchFrom[] $values() {
            return new FetchFrom[]{Foreground, Init, UserIdChanged, NetChanged};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32804);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Foreground = new FetchFrom("Foreground", 0);
            Init = new FetchFrom(QZoneCoverStoreJsPlugin.INIT_PLUGIN, 1);
            UserIdChanged = new FetchFrom("UserIdChanged", 2);
            NetChanged = new FetchFrom("NetChanged", 3);
            $VALUES = $values();
        }

        FetchFrom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FetchFrom valueOf(String str) {
            return (FetchFrom) Enum.valueOf(FetchFrom.class, str);
        }

        public static FetchFrom[] values() {
            return (FetchFrom[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl$a;", "", "", "APP_ID", "Ljava/lang/String;", "APP_KEY", "EVENT_COLD_START", "EVENT_FETCH", "", "FETCH_INTERVAL", "J", "PKG_NAME", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "UIN_TO_FETCH_TIME", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl$b", "Liz3/e;", "", "onSuccess", "", "reason", "onFail", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // iz3.e, iz3.m
        public /* synthetic */ void a(List list, List list2, List list3) {
            iz3.d.a(this, list, list2, list3);
        }

        @Override // iz3.m
        public void onFail(@NonNull @NotNull String reason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) reason);
                return;
            }
            Intrinsics.checkNotNullParameter(reason, "reason");
            QLog.w(ShiplyImpl.TAG, 1, "upgrade mergeRequestFullRemoteData onFail, reason = " + reason);
        }

        @Override // iz3.e
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d(ShiplyImpl.TAG, 1, "upgrade mergeRequestFullRemoteData onSuccess ");
                com.tencent.mobileqq.upgrade.e.e().a(false, false, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqfeatureswitch/impl/ShiplyImpl$c", "Liz3/h;", "", "onInitFinish", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShiplyImpl.this);
            }
        }

        @Override // iz3.h
        public void onInitFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i(ShiplyImpl.TAG, 1, "---RDelivery.create onInitFinish---");
                ShiplyImpl.this.inited = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
            UIN_TO_FETCH_TIME = new ConcurrentHashMap<>();
        }
    }

    public ShiplyImpl() {
        Object m476constructorimpl;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.userId = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(initRDelivery());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            obj = null;
        } else {
            obj = m476constructorimpl;
        }
        this.rDelivery = (RDelivery) obj;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(TAG, 1, m479exceptionOrNullimpl.getMessage());
        }
        if (shouldReport()) {
            QQBeaconReport.report(this.userId, EVENT_COLD_START);
        }
    }

    private final boolean frequencyControl(e listener) {
        ConcurrentHashMap<String, Long> concurrentHashMap = UIN_TO_FETCH_TIME;
        Long l3 = concurrentHashMap.get(this.userId);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 21600000) {
            if (listener != null) {
                listener.onFail("req_freq_limit");
                return true;
            }
            return true;
        }
        concurrentHashMap.put(this.userId, Long.valueOf(elapsedRealtime));
        return false;
    }

    private final com.tencent.rdelivery.a getDependencyInjector() {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new com.tencent.rdelivery.a(new com.tencent.rdelivery.dependencyimpl.c(context, 0, 0, 6, null), new MmkvStorage.b(null, 1, null), new IRTask() { // from class: com.tencent.mobileqq.qqfeatureswitch.impl.d
            @Override // com.tencent.raft.standard.task.IRTask
            public final void startTask(IRTask.TaskType taskType, IRTask.Task task) {
                ShiplyImpl.getDependencyInjector$lambda$4(taskType, task);
            }
        }, new com.tencent.mobileqq.qqfeatureswitch.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDependencyInjector$lambda$4(IRTask.TaskType taskType, IRTask.Task task) {
        Intrinsics.checkNotNullParameter(taskType, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(task, 192, null, true);
    }

    private final RDeliverySetting getRDeliverySetting(String userId) {
        RDeliverySetting.a P = new RDeliverySetting.a().N(APP_ID).O(APP_KEY).n0(userId).f0(Boolean.FALSE).m0(Integer.valueOf(RDeliverySetting.UpdateStrategy.PERIODIC.getValue())).P("com.tencent.mobileqq");
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        RDeliverySetting.a l06 = P.X(MODEL).i0(o.c()).l0(21600);
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        RDeliverySetting.a U = l06.W(MANUFACTURER).M(String.valueOf(Build.VERSION.SDK_INT)).d0(AppSetting.f99551k + '.' + AppSetting.f99542b).a0(true).Y(false).U(RDeliveryConstant$DataLoadMode.LAZY_LOAD);
        if (1 != MobileQQ.sProcessId) {
            U.V(BaseProto$DataRefreshMode.FROM_LOCAL_STORAGE);
        } else {
            U.m0(0);
        }
        return U.a();
    }

    private final RDelivery initRDelivery() {
        String currentUin;
        if (this.rDelivery != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Rdelivery has inited\uff01\uff01\uff01");
            }
            return this.rDelivery;
        }
        QMMKV.from(MobileQQ.sMobileQQ.getApplicationContext(), "common_mmkv_configurations");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        if (peekAppRuntime != null && (currentUin = peekAppRuntime.getCurrentUin()) != null) {
            str = currentUin;
        }
        this.userId = str;
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "init shiply with empty uin");
        }
        RDeliverySetting rDeliverySetting = getRDeliverySetting(this.userId);
        com.tencent.rdelivery.a dependencyInjector = getDependencyInjector();
        RDelivery.Companion companion = RDelivery.INSTANCE;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return companion.a(applicationContext, rDeliverySetting, dependencyInjector, new c());
    }

    private final boolean shouldReport() {
        StringsKt__StringNumberConversionsKt.toLongOrNull(this.userId);
        return false;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public void clearAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.h();
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public void clearData(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.E(key);
        }
    }

    public final void fetchAll(@Nullable e listener, @NotNull FetchFrom fetchFrom) {
        Object m476constructorimpl;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener, (Object) fetchFrom);
            return;
        }
        Intrinsics.checkNotNullParameter(fetchFrom, "fetchFrom");
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(initRDelivery());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            obj = null;
        } else {
            obj = m476constructorimpl;
        }
        this.rDelivery = (RDelivery) obj;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(TAG, 1, m479exceptionOrNullimpl.getMessage());
        }
        if (1 != MobileQQ.sProcessId) {
            QLog.w(TAG, 1, "sub process jump request");
            return;
        }
        com.tencent.mobileqq.upgrade.e.e().h();
        com.tencent.mobileqq.upgrade.e.e().j();
        ArrayList arrayList = new ArrayList();
        QLog.w(TAG, 1, "fetchAll, from:" + fetchFrom);
        if (frequencyControl(listener)) {
            QLog.w(TAG, 1, "this uin has fetched before");
            if (fetchFrom != FetchFrom.Foreground && UpgradeConfigTypeParser.f()) {
                com.tencent.mobileqq.upgrade.e.e().a(false, false, null);
                QLog.d(TAG, 1, "upgrade get catch data on frequencyControl!");
                return;
            }
            return;
        }
        if (this.rDelivery != null) {
            RDelivery rDelivery = this.rDelivery;
            Intrinsics.checkNotNull(rDelivery, "null cannot be cast to non-null type com.tencent.rdelivery.RDelivery");
            arrayList.add(new Pair(rDelivery, listener));
        }
        RDelivery m3 = j.l().m();
        if (m3 != null) {
            arrayList.add(new Pair(m3, new b()));
        }
        com.tencent.mobileqq.rfix.a.f281292a.g(true);
        try {
            arrayList.add(RFix.getInstance().getRDeliveryPair());
        } catch (Throwable th6) {
            QLog.e(TAG, 1, th6, new Object[0]);
        }
        if (arrayList.size() == 0) {
            QLog.w(TAG, 1, "instancePairList is empty, jump mergeRequestFullRemoteData");
            return;
        }
        QLog.d(TAG, 1, "fetch all");
        com.tencent.rdelivery.net.h.f364359c.e(arrayList);
        if (shouldReport()) {
            QQBeaconReport.report(this.userId, EVENT_FETCH);
        }
    }

    @Nullable
    public final Map<String, RDeliveryData> getAllRDeliveryData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Map) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.l(true);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public boolean getBool(@NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.m(key, defaultValue, true);
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    @Nullable
    public byte[] getBytes(@NotNull String key, @Nullable byte[] defaultValue) {
        byte[] n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null && (n3 = rDelivery.n(key, defaultValue, true)) != null) {
            return n3;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public double getDouble(@NotNull String key, double defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Double) iPatchRedirector.redirect((short) 8, this, key, Double.valueOf(defaultValue))).doubleValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.p(key, defaultValue, true);
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public float getFloat(@NotNull String key, float defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, this, key, Float.valueOf(defaultValue))).floatValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.q(key, defaultValue, true);
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public int getInt(@NotNull String key, int defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, defaultValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.r(key, defaultValue, true);
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    @Nullable
    public JSONArray getJSONArray(@NotNull String key, @Nullable JSONArray defaultValue) {
        JSONArray s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (JSONArray) iPatchRedirector.redirect((short) 13, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null && (s16 = rDelivery.s(key, defaultValue, true)) != null) {
            return s16;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    @Nullable
    public JSONObject getJSONObject(@NotNull String key, @Nullable JSONObject defaultValue) {
        JSONObject t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (JSONObject) iPatchRedirector.redirect((short) 12, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null && (t16 = rDelivery.t(key, defaultValue, true)) != null) {
            return t16;
        }
        return defaultValue;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public long getLong(@NotNull String key, long defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, key, Long.valueOf(defaultValue))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.w(key, defaultValue, true);
        }
        return defaultValue;
    }

    @Nullable
    public final RDeliveryData getRDeliveryData(@NotNull String key, @Nullable RDeliveryData defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (RDeliveryData) iPatchRedirector.redirect((short) 17, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.y(key, defaultValue, true);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    @Nullable
    public String getString(@NotNull String key, @Nullable String defaultValue) {
        String A;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, (Object) defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null && (A = rDelivery.A(key, defaultValue, true)) != null) {
            return A;
        }
        return defaultValue;
    }

    @NotNull
    public final String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.userId;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IShiply
    public boolean isSwitchOn(@NotNull String key, boolean defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, key, Boolean.valueOf(defaultValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.C(key, defaultValue, true);
        }
        return defaultValue;
    }

    public final void reLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (1 != MobileQQ.sProcessId) {
            QLog.w(TAG, 1, "sub process jump request");
        } else if (UpgradeConfigTypeParser.f()) {
            com.tencent.mobileqq.upgrade.e.e().a(false, false, null);
            QLog.d(TAG, 1, "reLogin upgrade get catch data on frequencyControl!");
        }
    }

    public final void switchUserId(@NotNull String userId, @Nullable h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) userId, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (this.rDelivery != null) {
            if (TextUtils.isEmpty(this.userId)) {
                QLog.w(TAG, 1, "switch shiply from empty uin");
            }
            this.userId = userId;
            if (TextUtils.isEmpty(userId)) {
                QLog.w(TAG, 1, "switch shiply with empty uin");
            }
            RDelivery rDelivery = this.rDelivery;
            Intrinsics.checkNotNull(rDelivery);
            rDelivery.M(userId, listener);
        }
        com.tencent.mobileqq.upgrade.e.e().q(userId);
    }
}
