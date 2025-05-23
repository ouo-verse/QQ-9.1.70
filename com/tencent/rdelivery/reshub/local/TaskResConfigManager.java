package com.tencent.rdelivery.reshub.local;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.reshub.api.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020\u0004\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\rH\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J(\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001c0\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0018J\u0016\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0002R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$Rh\u0010*\u001aV\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0&j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`'0&j*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0&j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`'`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/TaskResConfigManager;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "resId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Ljz3/e;", "resConfig", "t", "k", ReportConstant.COSTREPORT_PREFIX, "", "o", "map", "r", "Lkotlin/Function0;", "syncDo", "f", DomainData.DOMAIN_NAME, "u", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "", "p", "version", "", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "saveConfig", "i", "targetTaskId", "l", h.F, "a", "Ljava/lang/String;", "saveSpKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "resMap", "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", "c", "Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", QQPermissionConstants.Permission.STORAGE_GROUP, "resHubKey", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class TaskResConfigManager {

    /* renamed from: a, reason: from kotlin metadata */
    private final String saveSpKey;

    /* renamed from: b, reason: from kotlin metadata */
    private final HashMap<String, HashMap<Long, jz3.e>> resMap;

    /* renamed from: c, reason: from kotlin metadata */
    private final ConfigStorage com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String;

    public TaskResConfigManager(@NotNull String resHubKey) {
        Intrinsics.checkParameterIsNotNull(resHubKey, "resHubKey");
        String str = "task_config_save_prefix" + resHubKey;
        this.saveSpKey = str;
        this.resMap = new HashMap<>();
        this.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String = new ConfigStorage(str, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$storage$1
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
                TaskResConfigManager.this.q();
            }
        });
        q();
    }

    private final void f(Function0<Unit> syncDo) {
        this.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String.h(syncDo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void g(TaskResConfigManager taskResConfigManager, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$checkDataSync$1
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
        taskResConfigManager.f(function0);
    }

    public static /* synthetic */ void j(TaskResConfigManager taskResConfigManager, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        taskResConfigManager.i(str, z16);
    }

    public final void k(long r36, jz3.e resConfig) {
        String str = resConfig.H;
        Intrinsics.checkExpressionValueIsNotNull(str, "resConfig.originLocal");
        jz3.b.f(str);
        String str2 = resConfig.G;
        Intrinsics.checkExpressionValueIsNotNull(str2, "resConfig.local");
        jz3.b.f(str2);
        jz3.d.e("TaskResConfigManager", "Delete Local(Task) Res: " + resConfig.f411260a + " TaskId: " + r36 + " Version: " + resConfig.f411261b);
    }

    private final synchronized Map<String, jz3.e> o() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (Map.Entry<String, HashMap<Long, jz3.e>> entry : this.resMap.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<Long, jz3.e> entry2 : entry.getValue().entrySet()) {
                long longValue = entry2.getKey().longValue();
                hashMap.put(key + '-' + longValue, entry2.getValue());
            }
        }
        return hashMap;
    }

    public final void q() {
        boolean z16;
        Map<String, jz3.e> e16;
        String e17 = this.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String.e();
        if (e17.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (e16 = nz3.b.e(e17)) != null) {
            r(e16);
        }
    }

    private final synchronized void r(Map<String, ? extends jz3.e> map) {
        Object m476constructorimpl;
        int lastIndexOf$default;
        this.resMap.clear();
        try {
            Result.Companion companion = Result.INSTANCE;
            for (Map.Entry<String, ? extends jz3.e> entry : map.entrySet()) {
                String key = entry.getKey();
                jz3.e value = entry.getValue();
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) key, "-", 0, false, 6, (Object) null);
                if (key != null) {
                    String substring = key.substring(0, lastIndexOf$default);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    String substring2 = key.substring(lastIndexOf$default + 1);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    t(substring, Long.parseLong(substring2), value);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.d("TaskResConfigManager", "Reset Parse Config Failed", m479exceptionOrNullimpl);
        }
    }

    public final void s() {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String.g(nz3.b.f(o()));
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.d("TaskResConfigManager", "Save Config Failed", m479exceptionOrNullimpl);
        }
    }

    public final synchronized void t(String resId, long r46, jz3.e resConfig) {
        HashMap<String, HashMap<Long, jz3.e>> hashMap = this.resMap;
        HashMap<Long, jz3.e> hashMap2 = hashMap.get(resId);
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
            hashMap.put(resId, hashMap2);
        }
        hashMap2.put(Long.valueOf(r46), resConfig);
    }

    public final synchronized void h() {
        f(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$delAllRes$1
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
                HashMap hashMap;
                List<String> list;
                hashMap = TaskResConfigManager.this.resMap;
                Set keySet = hashMap.keySet();
                Intrinsics.checkExpressionValueIsNotNull(keySet, "resMap.keys");
                list = CollectionsKt___CollectionsKt.toList(keySet);
                for (String it : list) {
                    TaskResConfigManager taskResConfigManager = TaskResConfigManager.this;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    taskResConfigManager.i(it, false);
                }
                TaskResConfigManager.this.s();
            }
        });
    }

    public final synchronized void i(@NotNull final String resId, final boolean saveConfig) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        f(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$delRes$1
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
                HashMap hashMap;
                HashMap hashMap2;
                hashMap = TaskResConfigManager.this.resMap;
                HashMap hashMap3 = (HashMap) hashMap.get(resId);
                if (hashMap3 == null) {
                    hashMap3 = new HashMap();
                }
                Intrinsics.checkExpressionValueIsNotNull(hashMap3, "resMap[resId] ?: hashMapOf()");
                for (Map.Entry entry : hashMap3.entrySet()) {
                    TaskResConfigManager.this.k(((Number) entry.getKey()).longValue(), (jz3.e) entry.getValue());
                }
                hashMap2 = TaskResConfigManager.this.resMap;
                hashMap2.remove(resId);
                if (saveConfig) {
                    TaskResConfigManager.this.s();
                }
            }
        });
    }

    public final synchronized void l(@NotNull final String resId, final long targetTaskId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        f(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$deleteSpecificTaskRes$1
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
                HashMap hashMap;
                hashMap = TaskResConfigManager.this.resMap;
                HashMap hashMap2 = (HashMap) hashMap.get(resId);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                }
                Intrinsics.checkExpressionValueIsNotNull(hashMap2, "resMap[resId] ?: hashMapOf()");
                for (Map.Entry entry : hashMap2.entrySet()) {
                    long longValue = ((Number) entry.getKey()).longValue();
                    jz3.e eVar = (jz3.e) entry.getValue();
                    if (longValue == targetTaskId) {
                        TaskResConfigManager.this.k(longValue, eVar);
                    }
                }
                hashMap2.remove(Long.valueOf(targetTaskId));
                TaskResConfigManager.this.s();
            }
        });
    }

    @NotNull
    public final synchronized List<Pair<Long, jz3.e>> m(@NotNull String resId, long j3) {
        List<Pair<Long, jz3.e>> emptyList;
        List<Pair<Long, jz3.e>> list;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        g(this, null, 1, null);
        HashMap<Long, jz3.e> hashMap = this.resMap.get(resId);
        if (hashMap == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Intrinsics.checkExpressionValueIsNotNull(hashMap, "resMap[resId] ?: return emptyList()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, jz3.e> entry : hashMap.entrySet()) {
            if (entry.getValue().f411261b == j3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        list = MapsKt___MapsKt.toList(linkedHashMap);
        return list;
    }

    @Nullable
    public final synchronized jz3.e n(@NotNull String resId, long j3) {
        jz3.e eVar;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        eVar = null;
        g(this, null, 1, null);
        HashMap<Long, jz3.e> hashMap = this.resMap.get(resId);
        if (hashMap != null) {
            eVar = hashMap.get(Long.valueOf(j3));
        }
        return eVar;
    }

    public final synchronized boolean p(@NotNull g res) {
        Intrinsics.checkParameterIsNotNull(res, "res");
        g(this, null, 1, null);
        return !m(res.getResId(), res.getVersion()).isEmpty();
    }

    public final synchronized void u(final long r26, @NotNull final jz3.e resConfig) {
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        f(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.TaskResConfigManager$tryUpdateResConfig$1
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
                String resId = resConfig.f411260a;
                TaskResConfigManager taskResConfigManager = TaskResConfigManager.this;
                Intrinsics.checkExpressionValueIsNotNull(resId, "resId");
                int i3 = e.f364545a[b.b(new b("Task"), resConfig, taskResConfigManager.n(resId, r26), null, 4, null).ordinal()];
                if (i3 == 1) {
                    TaskResConfigManager.this.t(resId, r26, resConfig);
                    TaskResConfigManager.this.s();
                } else {
                    if (i3 == 2) {
                        TaskResConfigManager.this.s();
                        return;
                    }
                    if (i3 != 4) {
                        return;
                    }
                    jz3.d.i("TaskResConfigManager", "Fail to Update Task ResConfig: " + resId + '.');
                }
            }
        });
    }
}
