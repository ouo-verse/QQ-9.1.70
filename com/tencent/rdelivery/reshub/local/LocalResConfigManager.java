package com.tencent.rdelivery.reshub.local;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.core.j;
import com.tencent.rdelivery.reshub.util.PendingDeleteManager;
import com.tencent.rdelivery.reshub.util.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010C\u001a\u00020?\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J+\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\u0002\b\u0010H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ(\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0#0\"2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eJ\u0016\u0010%\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002J\u0016\u0010,\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010-\u001a\u00020\u0007R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00105\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0017\u0010C\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b-\u0010@\u001a\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "", "", "configStoreSuffix", "l", "", "clearLockRes", "", "r", "", "Ljz3/e;", "map", "w", "saveConfig", "Lkotlin/Function1;", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigMap;", "Lkotlin/ExtensionFunctionType;", "operate", "u", "o", HippyTKDListViewAdapter.X, "Lkotlin/Function0;", "syncDo", "e", "resId", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "p", "version", "", "Lkotlin/Pair;", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/rdelivery/reshub/api/g;", "res", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "B", h.F, "i", "g", "a", "Ljava/lang/String;", "resHubKey", "b", "saveSpKey", "c", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigMap;", "resMap", "d", "lockVerResMap", "Lcom/tencent/rdelivery/reshub/local/TaskResConfigManager;", "Lcom/tencent/rdelivery/reshub/local/TaskResConfigManager;", "taskResManager", "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", "f", "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", QQPermissionConstants.Permission.STORAGE_GROUP, "Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/core/a;", "k", "()Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LocalResConfigManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String resHubKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String saveSpKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LocalResConfigMap resMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LocalResConfigMap lockVerResMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TaskResConfigManager taskResManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConfigStorage storage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.rdelivery.reshub.core.a appInfo;

    public LocalResConfigManager(@NotNull com.tencent.rdelivery.reshub.core.a appInfo) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        this.appInfo = appInfo;
        String str = m.f(appInfo) + "suffix=" + l(appInfo.getConfigStoreSuffix());
        this.resHubKey = str;
        String str2 = "config_save_prefix" + str;
        this.saveSpKey = str2;
        this.resMap = new LocalResConfigMap("Latest");
        this.lockVerResMap = new LocalResConfigMap("LockVersion");
        this.taskResManager = new TaskResConfigManager(str);
        this.storage = new ConfigStorage(str2, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$storage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalResConfigMap localResConfigMap;
                LocalResConfigMap localResConfigMap2;
                LocalResConfigMap localResConfigMap3;
                LocalResConfigManager.this.r(false);
                localResConfigMap = LocalResConfigManager.this.lockVerResMap;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, jz3.e> entry : localResConfigMap.entrySet()) {
                    String key = entry.getKey();
                    localResConfigMap3 = LocalResConfigManager.this.resMap;
                    if (!localResConfigMap3.containsKey((Object) key)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    localResConfigMap2 = LocalResConfigManager.this.lockVerResMap;
                    localResConfigMap2.remove(entry2.getKey());
                }
            }
        });
        s(this, false, 1, null);
    }

    private final void e(Function0<Unit> syncDo) {
        this.storage.h(syncDo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void f(LocalResConfigManager localResConfigManager, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$checkDataSync$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        localResConfigManager.e(function0);
    }

    private final String l(String configStoreSuffix) {
        String str;
        j jVar = j.L;
        if (jVar.S()) {
            str = jVar.w().getConfigStoreSuffix();
        } else {
            str = "store";
        }
        if (configStoreSuffix == null) {
            return str;
        }
        return configStoreSuffix;
    }

    private final synchronized Map<String, jz3.e> o() {
        return this.resMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(boolean clearLockRes) {
        boolean z16;
        Map<String, jz3.e> e16;
        String e17 = this.storage.e();
        if (e17.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (e16 = nz3.b.e(e17)) != null) {
            w(e16, clearLockRes);
        }
    }

    static /* synthetic */ void s(LocalResConfigManager localResConfigManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        localResConfigManager.r(z16);
    }

    private final synchronized boolean u(boolean saveConfig, Function1<? super LocalResConfigMap, Boolean> operate) {
        boolean z16;
        boolean booleanValue = operate.invoke(this.resMap).booleanValue();
        boolean booleanValue2 = operate.invoke(this.lockVerResMap).booleanValue();
        if (!booleanValue && !booleanValue2) {
            z16 = false;
            if (saveConfig && z16) {
                x();
            }
        }
        z16 = true;
        if (saveConfig) {
            x();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean v(LocalResConfigManager localResConfigManager, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return localResConfigManager.u(z16, function1);
    }

    private final synchronized void w(Map<String, ? extends jz3.e> map, boolean clearLockRes) {
        this.resMap.clear();
        this.resMap.putAll(map);
        if (clearLockRes) {
            this.lockVerResMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.storage.g(nz3.b.f(o()));
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.d("LocalResConfigManager", "Save Config Failed", m479exceptionOrNullimpl);
        }
    }

    public final synchronized void A(long taskId, @NotNull jz3.e resConfig) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        this.taskResManager.u(taskId, resConfig);
    }

    public final synchronized void B(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        jz3.e eVar = (jz3.e) this.lockVerResMap.remove((Object) resId);
        if (eVar != null) {
            jz3.d.e("LocalResConfigManager", "Unlock Res(" + resId + ") Version: " + eVar.f411261b);
        }
    }

    public final synchronized void g() {
        e(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$deleteAllRes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalResConfigMap localResConfigMap;
                LocalResConfigMap localResConfigMap2;
                localResConfigMap = LocalResConfigManager.this.resMap;
                localResConfigMap.delAllRes();
                localResConfigMap2 = LocalResConfigManager.this.lockVerResMap;
                localResConfigMap2.delAllRes();
                LocalResConfigManager.this.x();
            }
        });
        this.taskResManager.h();
        jz3.d.e("LocalResConfigManager", "Delete All Local/Locked/Task Res.");
    }

    public final synchronized void h(@NotNull final String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        e(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$deleteRes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalResConfigManager.v(LocalResConfigManager.this, false, new Function1<LocalResConfigMap, Boolean>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$deleteRes$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(LocalResConfigMap localResConfigMap) {
                        return Boolean.valueOf(invoke2(localResConfigMap));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(@NotNull LocalResConfigMap receiver) {
                        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                        return receiver.delRes(resId);
                    }
                }, 1, null);
            }
        });
        TaskResConfigManager.j(this.taskResManager, resId, false, 2, null);
    }

    public final synchronized void i(@NotNull String resId, long taskId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.taskResManager.l(resId, taskId);
    }

    @NotNull
    public final synchronized List<Pair<Long, jz3.e>> j(@NotNull String resId, long version) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        return this.taskResManager.m(resId, version);
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final com.tencent.rdelivery.reshub.core.a getAppInfo() {
        return this.appInfo;
    }

    @Nullable
    public final synchronized jz3.e m(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        f(this, null, 1, null);
        return (jz3.e) this.resMap.get((Object) resId);
    }

    @Nullable
    public final synchronized jz3.e n(@NotNull String resId) {
        jz3.e eVar;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        f(this, null, 1, null);
        if (this.lockVerResMap.containsKey((Object) resId)) {
            eVar = (jz3.e) this.lockVerResMap.get((Object) resId);
        } else {
            eVar = (jz3.e) this.resMap.get((Object) resId);
        }
        return eVar;
    }

    @Nullable
    public final synchronized jz3.e p(@NotNull String resId, long taskId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        return this.taskResManager.n(resId, taskId);
    }

    public final synchronized boolean q(@NotNull g res) {
        Intrinsics.checkParameterIsNotNull(res, "res");
        return this.taskResManager.p(res);
    }

    public final synchronized void t(@NotNull String resId) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        jz3.e n3 = n(resId);
        if (n3 != null) {
            if (this.lockVerResMap.get((Object) resId) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.lockVerResMap.put(resId, n3);
            if (!z16) {
                jz3.d.e("LocalResConfigManager", "Lock Res(" + resId + ") Version: " + n3.f411261b);
            }
        }
    }

    public final synchronized void y(@NotNull final String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        jz3.d.e("LocalResConfigManager", "tryDeleteResConfig,resId = " + resId + '.');
        e(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$tryDeleteResConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalResConfigMap localResConfigMap;
                LocalResConfigMap localResConfigMap2;
                LocalResConfigMap localResConfigMap3;
                localResConfigMap = LocalResConfigManager.this.resMap;
                jz3.e eVar = (jz3.e) localResConfigMap.get((Object) resId);
                if (eVar == null || !LocalResConfigManager.this.q(eVar)) {
                    localResConfigMap2 = LocalResConfigManager.this.resMap;
                    jz3.e eVar2 = (jz3.e) localResConfigMap2.remove((Object) resId);
                    localResConfigMap3 = LocalResConfigManager.this.lockVerResMap;
                    localResConfigMap3.remove((Object) resId);
                    jz3.d.e("LocalResConfigManager", "tryDeleteResConfig, config: " + eVar2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("tryDeleteResConfig, Res: ");
                    sb5.append(resId);
                    sb5.append(" Version: ");
                    sb5.append(eVar != null ? Long.valueOf(eVar.f411261b) : null);
                    sb5.append(" addToPendingDelete.");
                    jz3.d.e("LocalResConfigManager", sb5.toString());
                    PendingDeleteManager.f364584c.e(eVar);
                    LocalResConfigManager.this.x();
                    return;
                }
                jz3.d.e("LocalResConfigManager", "tryDeleteResConfig, Res: " + resId + " Version: " + eVar.f411261b + " in Specific Task, Ignore Delete.");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final synchronized jz3.e z(@NotNull final jz3.e resConfig) {
        final Ref.ObjectRef objectRef;
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        objectRef = new Ref.ObjectRef();
        objectRef.element = resConfig;
        e(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.LocalResConfigManager$tryUpdateResConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [T, jz3.e, com.tencent.rdelivery.reshub.api.g] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LocalResConfigMap localResConfigMap;
                LocalResConfigMap localResConfigMap2;
                String resId = resConfig.f411260a;
                localResConfigMap = LocalResConfigManager.this.resMap;
                ?? r16 = (jz3.e) localResConfigMap.get((Object) resId);
                int i3 = a.f364537a[new b("Latest").a(resConfig, r16, LocalResConfigManager.this.getAppInfo()).ordinal()];
                if (i3 == 1) {
                    localResConfigMap2 = LocalResConfigManager.this.resMap;
                    Intrinsics.checkExpressionValueIsNotNull(resId, "resId");
                    localResConfigMap2.put(resId, resConfig);
                    if (r16 != 0 && LocalResConfigManager.this.q(r16)) {
                        jz3.d.e("LocalResConfigManager", "Old Res: " + resId + " Version: " + r16.f411261b + " in Specific Task, Ignore Delete.");
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Old Res: ");
                        sb5.append(resId);
                        sb5.append(" Version: ");
                        sb5.append(r16 != 0 ? Long.valueOf(r16.f411261b) : null);
                        sb5.append(" addToPendingDelete.");
                        jz3.d.e("LocalResConfigManager", sb5.toString());
                        PendingDeleteManager.f364584c.e(r16);
                    }
                    LocalResConfigManager.this.x();
                    if (resConfig.f411284y == 1) {
                        LocalResConfigManager.this.B(resId);
                        return;
                    }
                    return;
                }
                if (i3 == 2) {
                    LocalResConfigManager.this.x();
                    if (resConfig.f411284y == 1) {
                        LocalResConfigManager localResConfigManager = LocalResConfigManager.this;
                        Intrinsics.checkExpressionValueIsNotNull(resId, "resId");
                        localResConfigManager.B(resId);
                    }
                    if (r16 != 0) {
                        objectRef.element = r16;
                        return;
                    }
                    return;
                }
                if (i3 == 3) {
                    if (r16 != 0) {
                        objectRef.element = r16;
                    }
                } else {
                    if (i3 != 4) {
                        return;
                    }
                    jz3.d.e("LocalResConfigManager", "Fail to Update Task ResConfig: " + resId + '.');
                    if (r16 != 0) {
                        objectRef.element = r16;
                    }
                }
            }
        });
        return (jz3.e) objectRef.element;
    }
}
