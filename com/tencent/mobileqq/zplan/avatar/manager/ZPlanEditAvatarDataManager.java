package com.tencent.mobileqq.zplan.avatar.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import nu4.g;
import tl.h;
import ze3.ZPlanEditAvatarConfigInfo;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/manager/ZPlanEditAvatarDataManager;", "", "", "uin", "", "gender", "Lze3/b;", "e", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "rawConfigInfo", "Lcom/tencent/mobileqq/zplan/avatar/manager/b;", "i", "Lcom/tencent/mobileqq/zplan/avatar/manager/a;", "callback", "", "f", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarDataManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEditAvatarDataManager f331961a = new ZPlanEditAvatarDataManager();

    ZPlanEditAvatarDataManager() {
    }

    private final ZPlanEditAvatarConfigInfo h(long uin, int gender) {
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_edit_avatar_config_" + uin + "_" + gender, "");
        if (string.length() == 0) {
            return null;
        }
        ZPlanEditAvatarConfigInfo a16 = ZPlanEditAvatarConfigInfo.INSTANCE.a(string);
        if (a16 == null) {
            QLog.e("ZPlanEditAvatarDataManager", 1, "getEditAvatarConfigFromMMKV, localConfig null.");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_edit_avatar_config_" + uin + "_" + gender, "");
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ZPlanEditAvatarAllConfigInfo i(ZPlanEditAvatarConfigInfo rawConfigInfo) {
        boolean z16;
        List filterNotNull;
        Object[] sortedArrayWith;
        List list;
        boolean z17;
        List filterNotNull2;
        Object[] sortedArrayWith2;
        List list2;
        g[] headConfigs = rawConfigInfo.getHeadConfigs();
        if (headConfigs != null) {
            if (!(headConfigs.length == 0)) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                Comparator comparator = new Comparator() { // from class: com.tencent.mobileqq.zplan.avatar.manager.c
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int j3;
                        j3 = ZPlanEditAvatarDataManager.j((g) obj, (g) obj2);
                        return j3;
                    }
                };
                filterNotNull = ArraysKt___ArraysKt.filterNotNull(headConfigs);
                Object[] array = filterNotNull.toArray(new g[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                sortedArrayWith = ArraysKt___ArraysKt.sortedArrayWith(array, comparator);
                list = ArraysKt___ArraysKt.toList(sortedArrayWith);
                if (list == null) {
                    return null;
                }
                QLog.i("ZPlanEditAvatarDataManager", 1, "handleConfigInfo, sortedHeadConfigs size: " + list.size());
                nu4.a[] backgroundConfigs = rawConfigInfo.getBackgroundConfigs();
                if (backgroundConfigs != null) {
                    if (!(backgroundConfigs.length == 0)) {
                        z17 = false;
                        if (!z17) {
                            return null;
                        }
                        Comparator comparator2 = new Comparator() { // from class: com.tencent.mobileqq.zplan.avatar.manager.d
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                int k3;
                                k3 = ZPlanEditAvatarDataManager.k((nu4.a) obj, (nu4.a) obj2);
                                return k3;
                            }
                        };
                        filterNotNull2 = ArraysKt___ArraysKt.filterNotNull(backgroundConfigs);
                        Object[] array2 = filterNotNull2.toArray(new nu4.a[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        sortedArrayWith2 = ArraysKt___ArraysKt.sortedArrayWith(array2, comparator2);
                        list2 = ArraysKt___ArraysKt.toList(sortedArrayWith2);
                        if (list2 == null) {
                            return null;
                        }
                        QLog.i("ZPlanEditAvatarDataManager", 1, "handleConfigInfo, sortedBackgroundConfigs size: " + list2.size());
                        return new ZPlanEditAvatarAllConfigInfo(list, list2, rawConfigInfo.getGlobalConfig());
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(g gVar, g gVar2) {
        return Intrinsics.compare(gVar.sortWeight, gVar2.sortWeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(nu4.a aVar, nu4.a aVar2) {
        return Intrinsics.compare(aVar.sortWeight, aVar2.sortWeight);
    }

    public final void f(long uin, int gender, a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEditAvatarDataManager$getAvatarInfo$1(uin, gender, callback, null), 3, null);
    }

    public final void g(long uin, int gender, a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanEditAvatarConfigInfo h16 = h(uin, gender);
        if (h16 == null) {
            f(uin, gender, callback);
            return;
        }
        ZPlanEditAvatarAllConfigInfo i3 = i(h16);
        if (i3 != null) {
            callback.a(true, i3);
        } else {
            callback.a(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(long j3, int i3, Continuation<? super ZPlanEditAvatarConfigInfo> continuation) {
        ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1 zPlanEditAvatarDataManager$fetchEditAvatarConfig$1;
        Object coroutine_suspended;
        int i16;
        long j16;
        int i17;
        ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo;
        String signature;
        boolean booleanValue;
        try {
            if (continuation instanceof ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1) {
                zPlanEditAvatarDataManager$fetchEditAvatarConfig$1 = (ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1) continuation;
                int i18 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$1.label;
                if ((i18 & Integer.MIN_VALUE) != 0) {
                    zPlanEditAvatarDataManager$fetchEditAvatarConfig$1.label = i18 - Integer.MIN_VALUE;
                    ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1 zPlanEditAvatarDataManager$fetchEditAvatarConfig$12 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$1;
                    Object obj = zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj);
                        ZPlanEditAvatarConfigInfo h16 = h(j3, i3);
                        QLog.i("ZPlanEditAvatarDataManager", 1, "localAvatarConfigInfo: " + h16);
                        String str = (h16 == null || (signature = h16.getSignature()) == null) ? "" : signature;
                        String subVersion = AppSetting.getSubVersion();
                        QLog.i("ZPlanEditAvatarDataManager", 1, "tryRequest with localSignature: " + str);
                        lf3.a aVar = lf3.a.f414450a;
                        zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.L$0 = h16;
                        j16 = j3;
                        zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.J$0 = j16;
                        zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.I$0 = i3;
                        zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.label = 1;
                        Object a16 = aVar.a(str, j3, i3, subVersion, zPlanEditAvatarDataManager$fetchEditAvatarConfig$12);
                        if (a16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i17 = i3;
                        zPlanEditAvatarConfigInfo = h16;
                        obj = a16;
                    } else if (i16 == 1) {
                        i17 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.I$0;
                        long j17 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.J$0;
                        zPlanEditAvatarConfigInfo = (ZPlanEditAvatarConfigInfo) zPlanEditAvatarDataManager$fetchEditAvatarConfig$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        j16 = j17;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Pair pair = (Pair) obj;
                    booleanValue = ((Boolean) pair.component1()).booleanValue();
                    ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo2 = (ZPlanEditAvatarConfigInfo) pair.component2();
                    QLog.i("ZPlanEditAvatarDataManager", 1, "request done, needUpdate: " + booleanValue);
                    if (booleanValue) {
                        QLog.i("ZPlanEditAvatarDataManager", 1, "fetchEditAvatarConfig\uff0c hit cache!");
                        return zPlanEditAvatarConfigInfo;
                    }
                    if (zPlanEditAvatarConfigInfo2 == null) {
                        QLog.e("ZPlanEditAvatarDataManager", 1, "needUpdate, but avatarConfigInfo from pb invalid.");
                        return null;
                    }
                    QLog.i("ZPlanEditAvatarDataManager", 1, "updatedAvatarConfigInfo: " + zPlanEditAvatarConfigInfo2);
                    String b16 = ZPlanEditAvatarConfigInfo.INSTANCE.b(zPlanEditAvatarConfigInfo2);
                    ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_edit_avatar_config_" + j16 + "_" + i17, b16 != null ? b16 : "");
                    return zPlanEditAvatarConfigInfo2;
                }
            }
            if (i16 != 0) {
            }
            Pair pair2 = (Pair) obj;
            booleanValue = ((Boolean) pair2.component1()).booleanValue();
            ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo22 = (ZPlanEditAvatarConfigInfo) pair2.component2();
            QLog.i("ZPlanEditAvatarDataManager", 1, "request done, needUpdate: " + booleanValue);
            if (booleanValue) {
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanEditAvatarDataManager", 1, "requestEditAvatarConfig failed.", th5);
            return null;
        }
        zPlanEditAvatarDataManager$fetchEditAvatarConfig$1 = new ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1(this, continuation);
        ZPlanEditAvatarDataManager$fetchEditAvatarConfig$1 zPlanEditAvatarDataManager$fetchEditAvatarConfig$122 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$1;
        Object obj2 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = zPlanEditAvatarDataManager$fetchEditAvatarConfig$122.label;
    }
}
