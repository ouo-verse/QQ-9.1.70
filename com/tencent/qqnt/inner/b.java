package com.tencent.qqnt.inner;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R*\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/inner/b;", "", "", "c", "", "troopUin", "Lkotlin/Function0;", "", "callback", "b", "d", "e", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "configID", "", "I", "maxRequestSize", "", "J", "requestDelayTime", "", "Ljava/util/List;", "waitingTaskGroupCode", "", "Lcom/tencent/qqnt/inner/TroopFrequencyTask;", "f", "Ljava/util/Map;", "waitingTask", "g", "requestingTaskGroupCode", tl.h.F, "lastRequestingTaskTime", "i", "Ljava/lang/Boolean;", "enable", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int maxRequestSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long requestDelayTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> waitingTaskGroupCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Function0<Unit>> waitingTask;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> requestingTaskGroupCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Long> lastRequestingTaskTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean enable;

    public b(@NotNull String tag, @NotNull String configID, int i3, long j3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(configID, "configID");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tag, configID, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.tag = tag;
        this.configID = configID;
        this.maxRequestSize = i3;
        this.requestDelayTime = j3;
        this.waitingTaskGroupCode = new ArrayList();
        this.waitingTask = new LinkedHashMap();
        this.requestingTaskGroupCode = new ArrayList();
        this.lastRequestingTaskTime = new LinkedHashMap();
    }

    private final boolean b(String troopUin, Function0<Unit> callback) {
        if (!c()) {
            return true;
        }
        synchronized (this.requestingTaskGroupCode) {
            if (this.requestingTaskGroupCode.contains(troopUin)) {
                return false;
            }
            if (this.waitingTaskGroupCode.contains(troopUin)) {
                return false;
            }
            if (this.requestingTaskGroupCode.size() >= this.maxRequestSize) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.tag, 2, "checkCanExecuteTask: add waiting queue troopUin:" + troopUin);
                }
                this.waitingTask.put(troopUin, callback);
                this.waitingTaskGroupCode.add(troopUin);
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.tag, 2, "checkCanExecuteTask: add running queue troopUin:" + troopUin + " queueSize=" + this.requestingTaskGroupCode.size());
            }
            this.requestingTaskGroupCode.add(troopUin);
            return true;
        }
    }

    private final boolean c() {
        if (this.enable == null) {
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            this.enable = Boolean.valueOf(((IUnitedConfigManager) api).isSwitchOn(this.configID, true));
        }
        Boolean bool = this.enable;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, String troopUin) {
        Object removeFirst;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.tag, 2, "finishTask: troopUin=" + troopUin);
        }
        synchronized (this$0.requestingTaskGroupCode) {
            this$0.requestingTaskGroupCode.remove(troopUin);
            this$0.waitingTaskGroupCode.remove(troopUin);
            if (!this$0.waitingTaskGroupCode.isEmpty()) {
                removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(this$0.waitingTaskGroupCode);
                String str = (String) removeFirst;
                Function0<Unit> function0 = this$0.waitingTask.get(str);
                this$0.waitingTask.remove(str);
                if (function0 != null) {
                    this$0.d(str, function0);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d(@NotNull String troopUin, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (c()) {
            if (b(troopUin, callback)) {
                synchronized (this.lastRequestingTaskTime) {
                    this.lastRequestingTaskTime.put(troopUin, Long.valueOf(System.currentTimeMillis()));
                    Unit unit = Unit.INSTANCE;
                }
                callback.invoke();
                return;
            }
            return;
        }
        callback.invoke();
    }

    public final void e(@NotNull final String troopUin) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (!c()) {
            return;
        }
        synchronized (this.lastRequestingTaskTime) {
            Long l3 = this.lastRequestingTaskTime.get(troopUin);
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            this.lastRequestingTaskTime.remove(troopUin);
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqnt.inner.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.f(b.this, troopUin);
                }
            }, 16, null, false, Math.max(0L, this.requestDelayTime - (System.currentTimeMillis() - j3)));
        }
    }
}
