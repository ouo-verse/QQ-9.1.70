package mqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import mqq.inject.MqqInjectorManager;
import mqq.util.MqqConfigUtil;
import mqq.util.RuntimeServiceHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0006\u0010\u0018\u001a\u00020\u0006J5\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001d2\u0006\u0010\u001e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\b\u00a8\u0006#"}, d2 = {"Lmqq/app/AppRuntimeServiceHelper;", "", "()V", "dependTaskFinishCnt", "Ljava/util/concurrent/atomic/AtomicInteger;", "isRuntimeServiceCleared", "", "isRuntimeServiceCleared$mqq_kit_release", "()Z", "setRuntimeServiceCleared$mqq_kit_release", "(Z)V", "runtimeServices", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lmqq/app/api/IRuntimeService;", "serviceLocks", "useStringKey", "getUseStringKey", "useStringKey$delegate", "Lkotlin/Lazy;", "clearRuntimeServiceDelay", "", "ensureLock", "apiClazz", "fixRuntimeServiceInstance", "getInstance", "T", "ar", "Lmqq/app/AppRuntime;", "Ljava/lang/Class;", "implName", "(Lmqq/app/AppRuntime;Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;", "onRelease", "releaseImportRuntimeService", "Companion", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class AppRuntimeServiceHelper {
    private static final int IMPORT_RUNTIME_DEPEND_CNT = 2;
    private static final int RUNTIME_SERVICE_CAPACITY = 1024;

    @NotNull
    private static final String TAG = "AppRuntimeServiceHelper";
    private volatile boolean isRuntimeServiceCleared;

    /* renamed from: useStringKey$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy useStringKey;

    @NotNull
    private final AtomicInteger dependTaskFinishCnt = new AtomicInteger(0);

    @NotNull
    private final ConcurrentHashMap<String, IRuntimeService> runtimeServices = new ConcurrentHashMap<>(1024);

    @NotNull
    private final ConcurrentHashMap<String, Object> serviceLocks = new ConcurrentHashMap<>();

    public AppRuntimeServiceHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: mqq.app.AppRuntimeServiceHelper$useStringKey$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean z16;
                try {
                    z16 = MqqConfigUtil.INSTANCE.getConfigFile("runtime_use_string_key").exists();
                } catch (Exception e16) {
                    QLog.e("AppRuntimeServiceHelper", 1, e16, new Object[0]);
                    z16 = false;
                }
                QLog.d("AppRuntimeServiceHelper", 1, "useStringKey result: " + z16);
                return Boolean.valueOf(z16);
            }
        });
        this.useStringKey = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearRuntimeServiceDelay$lambda$3(AppRuntimeServiceHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isRuntimeServiceCleared = true;
        ArrayList<String> arrayList = new ArrayList();
        for (String apiClass : this$0.runtimeServices.keySet()) {
            if (RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList(apiClass)) {
                Intrinsics.checkNotNullExpressionValue(apiClass, "apiClass");
                arrayList.add(apiClass);
            }
        }
        for (String str : arrayList) {
            this$0.ensureLock(str);
            this$0.runtimeServices.remove(str);
        }
        QLog.i(TAG, 1, "release|remove runtime service, size: " + arrayList.size());
    }

    private final void ensureLock(String apiClazz) {
        if (this.serviceLocks.get(apiClazz) == null) {
            synchronized (this.serviceLocks) {
                if (this.serviceLocks.get(apiClazz) == null) {
                    this.serviceLocks.put(apiClazz, new Object());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final boolean getUseStringKey() {
        return ((Boolean) this.useStringKey.getValue()).booleanValue();
    }

    public final void clearRuntimeServiceDelay() {
        if (!getUseStringKey()) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: mqq.app.b
            @Override // java.lang.Runnable
            public final void run() {
                AppRuntimeServiceHelper.clearRuntimeServiceDelay$lambda$3(AppRuntimeServiceHelper.this);
            }
        }, 16, null, true, 5000L);
    }

    public final boolean fixRuntimeServiceInstance() {
        return getUseStringKey();
    }

    @Nullable
    public final <T extends IRuntimeService> T getInstance(@NotNull AppRuntime ar3, @NotNull Class<T> apiClazz, @NotNull String implName) {
        Intrinsics.checkNotNullParameter(ar3, "ar");
        Intrinsics.checkNotNullParameter(apiClazz, "apiClazz");
        Intrinsics.checkNotNullParameter(implName, "implName");
        T t16 = null;
        if (!getUseStringKey()) {
            return null;
        }
        if (this.isRuntimeServiceCleared && RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList((Class<?>) apiClazz)) {
            String name = apiClazz.getName();
            Intrinsics.checkNotNullExpressionValue(name, "apiClazz.name");
            ensureLock(name);
            Object obj = this.serviceLocks.get(apiClazz.getName());
            Intrinsics.checkNotNull(obj);
            synchronized (obj) {
                IRuntimeService iRuntimeService = this.runtimeServices.get(apiClazz.getName());
                if (iRuntimeService instanceof IRuntimeService) {
                    t16 = (T) iRuntimeService;
                }
                if (t16 != null && RuntimeServiceHelper.isRuntimeServiceProxy(t16)) {
                    return t16;
                }
                T t17 = (T) RuntimeServiceHelper.createRuntimeServiceProxy(apiClazz);
                QLog.d(TAG, 1, "replace " + apiClazz.getName() + " to Proxy Object: " + t17.getClass() + ", tmp:" + t17);
                ConcurrentHashMap<String, IRuntimeService> concurrentHashMap = this.runtimeServices;
                String name2 = apiClazz.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "apiClazz.name");
                concurrentHashMap.put(name2, t17);
                return t17;
            }
        }
        boolean isDebugVersion = MqqInjectorManager.instance().isDebugVersion();
        ar3.runtimeServiceCheck(apiClazz, isDebugVersion, true);
        T t18 = (T) this.runtimeServices.get(apiClazz.getName());
        if (t18 == null) {
            if (this.isRuntimeServiceCleared && RuntimeServiceHelper.hitRuntimeServiceSetNullWhiteList((Class<?>) apiClazz)) {
                QLog.d(TAG, 1, "getRuntimeService when runtimeService is clear: " + apiClazz.getName() + ", apiClazz:" + apiClazz + ", runtime:" + ar3);
                return (T) ar3.getRuntimeService(apiClazz, implName);
            }
            String account = ar3.getAccount();
            if (TextUtils.isEmpty(account) && ar3.checkNeedAccount(apiClazz)) {
                String str = apiClazz.getName() + " need uin " + account + " or should add @Service{needUin=false}";
                QLog.e(TAG, 1, str);
                throw new IllegalStateException(str);
            }
            String name3 = apiClazz.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "apiClazz.name");
            ensureLock(name3);
            Object obj2 = this.serviceLocks.get(apiClazz.getName());
            Intrinsics.checkNotNull(obj2);
            synchronized (obj2) {
                T t19 = (T) this.runtimeServices.get(apiClazz.getName());
                if (t19 != null) {
                    return t19;
                }
                Class<?> cls = Class.forName(implName);
                ar3.cycleCheckBegin(implName, isDebugVersion);
                IRuntimeService iRuntimeService2 = (IRuntimeService) cls.newInstance();
                if (iRuntimeService2 != null) {
                    QLog.d(TAG, 1, "RuntimeService instance onCreate, " + implName + ", " + iRuntimeService2.hashCode());
                    iRuntimeService2.onCreate(ar3);
                    AbstractMap abstractMap = this.runtimeServices;
                    String name4 = apiClazz.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "apiClazz.name");
                    abstractMap.put(name4, iRuntimeService2);
                    t19 = (T) iRuntimeService2;
                }
                ar3.cycleCheckEnd(implName, isDebugVersion);
                Unit unit = Unit.INSTANCE;
                return t19;
            }
        }
        return t18;
    }

    /* renamed from: isRuntimeServiceCleared$mqq_kit_release, reason: from getter */
    public final boolean getIsRuntimeServiceCleared() {
        return this.isRuntimeServiceCleared;
    }

    public final void onRelease() {
        if (!getUseStringKey()) {
            return;
        }
        for (Map.Entry<String, IRuntimeService> entry : this.runtimeServices.entrySet()) {
            if (!RuntimeServiceHelper.isImportantRuntimeService(entry.getKey())) {
                entry.getValue().onDestroy();
            }
        }
        QLog.i(TAG, 1, "release|all runtime service destroy");
    }

    public final void releaseImportRuntimeService() {
        if (getUseStringKey() && 2 == this.dependTaskFinishCnt.addAndGet(1)) {
            QLog.i(TAG, 1, "release important runtime service");
            for (Map.Entry<String, IRuntimeService> entry : this.runtimeServices.entrySet()) {
                if (RuntimeServiceHelper.isImportantRuntimeService(entry.getKey())) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "release| destroy important runtime service: " + entry.getKey());
                    }
                    entry.getValue().onDestroy();
                }
            }
        }
    }

    public final void setRuntimeServiceCleared$mqq_kit_release(boolean z16) {
        this.isRuntimeServiceCleared = z16;
    }
}
