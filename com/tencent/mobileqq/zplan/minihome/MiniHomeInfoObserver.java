package com.tencent.mobileqq.zplan.minihome;

import com.google.gson.Gson;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MiniHomeInfoObserver;", "Lcom/tencent/mobileqq/zplan/utils/c;", "Lcom/tencent/mobileqq/zplan/minihome/ah;", "", "uin", "Lq55/d;", "minihomeInfoRsp", "", "k", "updatedInfo", "i", "j", "e", "f", "g", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "updatedRoomDesc", "l", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Lazy;", tl.h.F, "()Ljava/util/concurrent/ConcurrentHashMap;", "cacheMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeInfoObserver extends com.tencent.mobileqq.zplan.utils.c<MiniHomeInfoData> {

    /* renamed from: c, reason: collision with root package name */
    public static final MiniHomeInfoObserver f334284c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy cacheMap;

    static {
        Lazy lazy;
        MiniHomeInfoObserver miniHomeInfoObserver = new MiniHomeInfoObserver();
        f334284c = miniHomeInfoObserver;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, q55.d>>() { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver$cacheMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, q55.d> invoke() {
                return new ConcurrentHashMap<>(30);
            }
        });
        cacheMap = lazy;
        String e16 = bb.f335811a.e();
        if (e16 != null) {
            miniHomeInfoObserver.f(e16);
        }
    }

    MiniHomeInfoObserver() {
    }

    private final ConcurrentHashMap<String, q55.d> h() {
        return (ConcurrentHashMap) cacheMap.getValue();
    }

    private final void i(String uin, q55.d updatedInfo) {
        QLog.i("MiniHomeDecorateObserver", 1, "saveToCache, uin: " + uin + ", updatedInfo: " + updatedInfo);
        h().put(uin, updatedInfo);
    }

    private final void j(String uin, q55.d updatedInfo) {
        if (Intrinsics.areEqual(bb.f335811a.e(), uin)) {
            QLog.i("MiniHomeDecorateObserver", 1, "saveToMMKV, uin: " + uin + ", updatedInfo: " + updatedInfo);
            try {
                String str = "mini_home_info_key_" + uin + "_" + AppSetting.f99551k;
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove(str);
                IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
                String json = new Gson().toJson(updatedInfo);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(updatedInfo)");
                iZPlanMMKVApi.setString(str, json);
            } catch (Throwable th5) {
                QLog.e("MiniHomeDecorateObserver", 1, "save minihomeInfoRsp to MMKV failed.", th5);
            }
        }
    }

    public final void d(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("MiniHomeDecorateObserver", 1, "clearCacheAndMMKV, uin: " + uin);
        h().remove(uin);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("mini_home_info_key_" + uin + "_" + AppSetting.f99551k, "");
        a(new MiniHomeInfoData(uin, null));
    }

    public final q55.d e(String uin) {
        MiniHomeInfo a16;
        ao roomDesc;
        Intrinsics.checkNotNullParameter(uin, "uin");
        q55.d dVar = h().get(uin);
        QLog.i("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromCache, uin: " + uin + ", " + ((dVar == null || (a16 = ai.a(dVar)) == null || (roomDesc = a16.getRoomDesc()) == null) ? null : roomDesc.getHash()));
        return dVar;
    }

    public final q55.d f(String uin) {
        q55.d dVar;
        MiniHomeInfo a16;
        ao roomDesc;
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromMMKV, uin: " + uin);
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("mini_home_info_key_" + uin + "_" + AppSetting.f99551k, "");
        String str = null;
        if (string.length() == 0) {
            QLog.i("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromMMKV empty.");
            return null;
        }
        try {
            dVar = (q55.d) new Gson().fromJson(string, q55.d.class);
        } catch (Throwable th5) {
            QLog.e("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromMMKV failed.", th5);
            dVar = null;
        }
        if (dVar != null && (a16 = ai.a(dVar)) != null && (roomDesc = a16.getRoomDesc()) != null) {
            str = roomDesc.getHash();
        }
        QLog.i("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromMMKV, uin: " + uin + ", " + str);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(String str, Continuation<? super q55.d> continuation) {
        MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1 miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1;
        Object coroutine_suspended;
        int i3;
        MiniHomeInfoObserver miniHomeInfoObserver;
        q55.d dVar;
        if (continuation instanceof MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1) {
            miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1 = (MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1) continuation;
            int i16 = miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("MiniHomeDecorateObserver", 1, "fetchMiniHomeInfoFromNet, uin: " + str);
                    if (str == null) {
                        return null;
                    }
                    miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.L$0 = this;
                    miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.L$1 = str;
                    miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.label = 1;
                    obj = MiniHomeNetworkKt.e(str, miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    miniHomeInfoObserver = this;
                } else if (i3 == 1) {
                    str = (String) miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.L$1;
                    miniHomeInfoObserver = (MiniHomeInfoObserver) miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dVar = (q55.d) obj;
                if (dVar != null) {
                    miniHomeInfoObserver.k(str.toString(), dVar);
                }
                return dVar;
            }
        }
        miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1 = new MiniHomeInfoObserver$fetchMiniHomeInfoFromNet$1(this, continuation);
        Object obj2 = miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeInfoObserver$fetchMiniHomeInfoFromNet$1.label;
        if (i3 != 0) {
        }
        dVar = (q55.d) obj2;
        if (dVar != null) {
        }
        return dVar;
    }

    private final void k(String uin, q55.d minihomeInfoRsp) {
        MiniHomeInfo a16;
        ao roomDesc;
        if (!(uin == null || uin.length() == 0) && !Intrinsics.areEqual(uin, "0") && minihomeInfoRsp != null) {
            QLog.i("MiniHomeDecorateObserver", 1, "updateMiniHomeInfo, uin: " + uin + ", getMinihomeInfoRsp: " + minihomeInfoRsp);
            q55.d dVar = h().get(uin);
            String hash = (dVar == null || (a16 = ai.a(dVar)) == null || (roomDesc = a16.getRoomDesc()) == null) ? null : roomDesc.getHash();
            i(uin, minihomeInfoRsp);
            j(uin, minihomeInfoRsp);
            MiniHomeInfo a17 = ai.a(minihomeInfoRsp);
            if (Intrinsics.areEqual(hash, a17.getRoomDesc().getHash())) {
                return;
            }
            a(new MiniHomeInfoData(uin, a17));
            return;
        }
        QLog.e("MiniHomeDecorateObserver", 1, "updateMiniHomeInfoFromNet failed, uin: " + uin + ", minihomeInfoRsp: " + minihomeInfoRsp);
    }

    public final void l(String uin, ao updatedRoomDesc) {
        if (!(uin == null || uin.length() == 0) && updatedRoomDesc != null) {
            QLog.i("MiniHomeDecorateObserver", 1, "updateTemporaryRoomDesc, uin: " + uin + ", updatedRoomDesc: " + updatedRoomDesc);
            q55.d dVar = new q55.d();
            dVar.f428437a = true;
            r55.a aVar = new r55.a();
            byte[] bytes = updatedRoomDesc.getRoomDescJson().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            aVar.f430776d = bytes;
            aVar.f430773a = updatedRoomDesc.getHash();
            dVar.f428438b = aVar;
            dVar.f428439c = true;
            i(uin, dVar);
            a(new MiniHomeInfoData(uin, ai.a(dVar)));
            return;
        }
        QLog.e("MiniHomeDecorateObserver", 1, "updateTemporaryRoomDesc failed, uin: " + uin + ", updatedRoom: " + updatedRoomDesc);
    }
}
