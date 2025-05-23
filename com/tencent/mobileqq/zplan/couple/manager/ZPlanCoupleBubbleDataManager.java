package com.tencent.mobileqq.zplan.couple.manager;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.couple.config.BubbleType;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import com.tencent.mobileqq.zplan.servlet.ZPlanCoupleAvatarRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineScope;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0013\u0010\u000e\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/manager/ZPlanCoupleBubbleDataManager;", "", "", "Lcom/tencent/mobileqq/zplan/couple/config/a;", h.F, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", "d", "updatedBubbleConfigs", "j", "k", "l", "i", "e", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "guideBubbles", "Ljava/util/concurrent/ConcurrentHashMap;", "", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "msgBubbles", "settingBubbles", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAvatarBubbleRequesting", "isSettingBubbleRequesting", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCoupleBubbleDataManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanCoupleBubbleDataManager f332649a = new ZPlanCoupleBubbleDataManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<ZPlanCoupleBubbleConfig> guideBubbles = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, ZPlanCoupleBubbleConfig> msgBubbles = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<ZPlanCoupleBubbleConfig> settingBubbles = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isAvatarBubbleRequesting = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isSettingBubbleRequesting = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((ZPlanCoupleBubbleConfig) t16).getOrder()), Integer.valueOf(((ZPlanCoupleBubbleConfig) t17).getOrder()));
            return compareValues;
        }
    }

    ZPlanCoupleBubbleDataManager() {
    }

    private final void d() {
        guideBubbles.clear();
        msgBubbles.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(1:10)(2:20|21))(3:22|(2:24|(1:26))|27)|11|12|(2:15|13)|16|17))|30|6|7|(0)(0)|11|12|(1:13)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002a, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ZPlanCoupleBubbleDataManager", 1, "request bubbleList from remote failed.", r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[LOOP:0: B:13:0x005f->B:15:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Continuation<? super List<ZPlanCoupleBubbleConfig>> continuation) {
        ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1 zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        if (continuation instanceof ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1) {
            zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1 = (ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1) continuation;
            int i16 = zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isAvatarBubbleRequesting.compareAndSet(false, true)) {
                        ZPlanCoupleAvatarRequest zPlanCoupleAvatarRequest = ZPlanCoupleAvatarRequest.f335363a;
                        zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.label = 1;
                        obj = zPlanCoupleAvatarRequest.c(zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return null;
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<i55.a> list = (List) obj;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (i55.a aVar : list) {
                    arrayList.add(new ZPlanCoupleBubbleConfig(aVar.f407256a, aVar.f407257b, aVar.f407261f, aVar.f407262g, aVar.f407258c, aVar.f407259d, Boxing.boxLong(aVar.f407260e)));
                }
                return arrayList;
            }
        }
        zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1 = new ZPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1(this, continuation);
        Object obj2 = zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleBubbleDataManager$getRemoteAvatarBubbles$1.label;
        if (i3 != 0) {
        }
        List<i55.a> list2 = (List) obj2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        while (r12.hasNext()) {
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(1:10)(2:20|21))(3:22|(2:24|(1:26))|27)|11|12|(2:15|13)|16|17))|30|6|7|(0)(0)|11|12|(1:13)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002a, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ZPlanCoupleBubbleDataManager", 1, "request setting bubbleList from remote failed.", r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[LOOP:0: B:13:0x005f->B:15:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Continuation<? super List<ZPlanCoupleBubbleConfig>> continuation) {
        ZPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1 zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        if (continuation instanceof ZPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1) {
            zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1 = (ZPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1) continuation;
            int i16 = zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (isSettingBubbleRequesting.compareAndSet(false, true)) {
                        ZPlanCoupleAvatarRequest zPlanCoupleAvatarRequest = ZPlanCoupleAvatarRequest.f335363a;
                        zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.label = 1;
                        obj = zPlanCoupleAvatarRequest.d(zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return null;
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<i55.a> list = (List) obj;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (i55.a aVar : list) {
                    arrayList.add(new ZPlanCoupleBubbleConfig(aVar.f407256a, aVar.f407257b, aVar.f407261f, aVar.f407262g, aVar.f407258c, aVar.f407259d, Boxing.boxLong(aVar.f407260e)));
                }
                return arrayList;
            }
        }
        zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1 = new ZPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1(this, continuation);
        Object obj2 = zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleBubbleDataManager$getRemoteSettingBubbles$1.label;
        if (i3 != 0) {
        }
        List<i55.a> list2 = (List) obj2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        while (r12.hasNext()) {
        }
        return arrayList2;
    }

    private final void j(List<ZPlanCoupleBubbleConfig> updatedBubbleConfigs) {
        List sortedWith;
        List<ZPlanCoupleBubbleConfig> list = updatedBubbleConfigs;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ZPlanCoupleBubbleConfig) next).getType() == BubbleType.AVATAR_GUIDE_BUBBLE_TYPE.getValue()) {
                arrayList.add(next);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        guideBubbles.addAll(sortedWith);
        ArrayList<ZPlanCoupleBubbleConfig> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((ZPlanCoupleBubbleConfig) obj).getType() == BubbleType.AVATAR_MESSAGE_BUBBLE_TYPE.getValue()) {
                arrayList2.add(obj);
            }
        }
        for (ZPlanCoupleBubbleConfig zPlanCoupleBubbleConfig : arrayList2) {
            msgBubbles.put(Integer.valueOf(zPlanCoupleBubbleConfig.getId()), zPlanCoupleBubbleConfig);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(Continuation<? super Unit> continuation) {
        ZPlanCoupleBubbleDataManager$getAvatarBubbles$1 zPlanCoupleBubbleDataManager$getAvatarBubbles$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        ZPlanCoupleBubbleDataManager zPlanCoupleBubbleDataManager;
        List<ZPlanCoupleBubbleConfig> list;
        if (continuation instanceof ZPlanCoupleBubbleDataManager$getAvatarBubbles$1) {
            zPlanCoupleBubbleDataManager$getAvatarBubbles$1 = (ZPlanCoupleBubbleDataManager$getAvatarBubbles$1) continuation;
            int i16 = zPlanCoupleBubbleDataManager$getAvatarBubbles$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleBubbleDataManager$getAvatarBubbles$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanCoupleBubbleDataManager$getAvatarBubbles$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleBubbleDataManager$getAvatarBubbles$1.label;
                z16 = true;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    zPlanCoupleBubbleDataManager$getAvatarBubbles$1.L$0 = this;
                    zPlanCoupleBubbleDataManager$getAvatarBubbles$1.label = 1;
                    obj = g(zPlanCoupleBubbleDataManager$getAvatarBubbles$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanCoupleBubbleDataManager = this;
                } else if (i3 == 1) {
                    zPlanCoupleBubbleDataManager = (ZPlanCoupleBubbleDataManager) zPlanCoupleBubbleDataManager$getAvatarBubbles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<ZPlanCoupleBubbleConfig> list2 = (List) obj;
                list = list2;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                }
                if (!z16) {
                    return Unit.INSTANCE;
                }
                zPlanCoupleBubbleDataManager.d();
                zPlanCoupleBubbleDataManager.j(list2);
                return Unit.INSTANCE;
            }
        }
        zPlanCoupleBubbleDataManager$getAvatarBubbles$1 = new ZPlanCoupleBubbleDataManager$getAvatarBubbles$1(this, continuation);
        Object obj2 = zPlanCoupleBubbleDataManager$getAvatarBubbles$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleBubbleDataManager$getAvatarBubbles$1.label;
        z16 = true;
        if (i3 != 0) {
        }
        List<ZPlanCoupleBubbleConfig> list22 = (List) obj2;
        list = list22;
        if (list != null) {
            z16 = false;
        }
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(Continuation<? super List<ZPlanCoupleBubbleConfig>> continuation) {
        ZPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1 zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ZPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1) {
            zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1 = (ZPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1) continuation;
            int i16 = zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CopyOnWriteArrayList<ZPlanCoupleBubbleConfig> copyOnWriteArrayList = guideBubbles;
                    if (!copyOnWriteArrayList.isEmpty()) {
                        return copyOnWriteArrayList;
                    }
                    zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.label = 1;
                    if (e(zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return guideBubbles;
            }
        }
        zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1 = new ZPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1(this, continuation);
        Object obj2 = zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanCoupleBubbleDataManager$getAvatarGuideBubbles$1.label;
        if (i3 != 0) {
        }
        return guideBubbles;
    }

    public final List<ZPlanCoupleBubbleConfig> i() {
        return settingBubbles;
    }

    public final void k() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleBubbleDataManager_requestAvatarBubbles", null, null, null, new ZPlanCoupleBubbleDataManager$requestAvatarBubbles$1(null), 14, null);
        }
    }

    public final void l() {
        if (!settingBubbles.isEmpty()) {
            QLog.i("ZPlanCoupleBubbleDataManager", 1, "requestSettingPageBubbles, setting bubble info already exists.");
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleBubbleDataManager_requestSettingPageBubbles", null, null, null, new ZPlanCoupleBubbleDataManager$requestSettingPageBubbles$1(null), 14, null);
        }
    }
}
