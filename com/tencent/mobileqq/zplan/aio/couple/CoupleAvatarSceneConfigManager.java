package com.tencent.mobileqq.zplan.aio.couple;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ku4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0007R \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSceneConfigManager;", "", "", "entryType", "", "idList", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/aio/couple/h;", "listenerRef", "", "e", "", SquareJSConst.Params.PARAMS_UIN_LIST, "g", WadlProxyConsts.SCENE_ID, "Lku4/n;", "d", "", "friendUin", "c", "(Ljava/lang/String;)Ljava/lang/Integer;", "bothSceneId", "i", "Lle3/b;", "resourceConfig", "j", "listener", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "sceneConfigMap", "", "bothSceneMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CoupleAvatarSceneConfigManager {

    /* renamed from: a, reason: collision with root package name */
    public static final CoupleAvatarSceneConfigManager f330980a = new CoupleAvatarSceneConfigManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, n> sceneConfigMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Long, Integer> bothSceneMap = new ConcurrentHashMap<>();

    CoupleAvatarSceneConfigManager() {
    }

    public final Integer c(String friendUin) {
        long j3;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        try {
            j3 = Long.parseLong(friendUin);
        } catch (Throwable unused) {
            j3 = -1;
        }
        if (j3 == -1) {
            return null;
        }
        return bothSceneMap.get(Long.valueOf(j3));
    }

    public final n d(int sceneId) {
        return sceneConfigMap.get(Integer.valueOf(sceneId));
    }

    public final void e(int entryType, int[] idList, WeakReference<h> listenerRef) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        if (idList.length == 0) {
            QLog.i("CoupleAvatarSceneConfigManager", 1, "requestBatchSceneConfig empty idList");
            return;
        }
        String arrays = Arrays.toString(idList);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.i("CoupleAvatarSceneConfigManager", 1, "requestBatchSceneConfig idList:" + arrays);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "CoupleAvatarSceneConfigManager_requestBatchSceneConfig", null, null, null, new CoupleAvatarSceneConfigManager$requestBatchSceneConfig$1(entryType, idList, listenerRef, null), 14, null);
        }
    }

    public final void g(long[] uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (uinList.length == 0) {
            QLog.i("CoupleAvatarSceneConfigManager", 1, "requestBothSceneInfosByUinList empty uinList");
            return;
        }
        String arrays = Arrays.toString(uinList);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.i("CoupleAvatarSceneConfigManager", 1, "requestBothSceneInfosByUinList uinList:" + arrays);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "CoupleAvatarSceneConfigManager_requestBothSceneInfosByUinList", null, null, null, new CoupleAvatarSceneConfigManager$requestBothSceneInfosByUinList$1(uinList, null), 14, null);
        }
    }

    public final void h(int sceneId, h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (d(sceneId) != null) {
            listener.a(true);
        } else {
            e(0, new int[]{sceneId}, new WeakReference<>(listener));
        }
    }

    public final void i(String friendUin, int bothSceneId) {
        long j3;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        try {
            j3 = Long.parseLong(friendUin);
        } catch (Throwable unused) {
            j3 = -1;
        }
        if (j3 == -1) {
            return;
        }
        bothSceneMap.put(Long.valueOf(j3), Integer.valueOf(bothSceneId));
    }

    public final void j(le3.b resourceConfig) {
        Intrinsics.checkNotNullParameter(resourceConfig, "resourceConfig");
        n nVar = new n();
        nVar.f413120a = resourceConfig.getId();
        nVar.f413121b = resourceConfig.getName();
        nVar.f413122c = resourceConfig.c();
        nVar.f413123d = resourceConfig.d();
        nVar.f413124e = resourceConfig.h();
        nVar.f413125f = resourceConfig.k();
        nVar.f413126g = resourceConfig.getActionType();
        nVar.f413127h = resourceConfig.b();
        nVar.f413128i = resourceConfig.i();
        nVar.f413129j = resourceConfig.f();
        nVar.f413130k = resourceConfig.g();
        nVar.f413131l = resourceConfig.j();
        sceneConfigMap.put(Integer.valueOf(resourceConfig.getId()), nVar);
        QLog.i("CoupleAvatarSceneConfigManager", 1, "updateSceneConfigById fill in id:" + resourceConfig.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(CoupleAvatarSceneConfigManager coupleAvatarSceneConfigManager, int i3, int[] iArr, WeakReference weakReference, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            weakReference = null;
        }
        coupleAvatarSceneConfigManager.e(i3, iArr, weakReference);
    }
}
