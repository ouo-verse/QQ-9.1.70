package com.tencent.mobileqq.zplan.minixwconnected;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.ZPlanRequestReq;
import com.tencent.mobileqq.zplan.utils.at;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/MiniHomeConnectedEntrance;", "", "", "friendUin", "Lv45/b;", "b", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "callback", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedEntrance {

    /* renamed from: a, reason: collision with root package name */
    public static final MiniHomeConnectedEntrance f334439a = new MiniHomeConnectedEntrance();

    MiniHomeConnectedEntrance() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(long j3, Continuation<? super v45.b> continuation) {
        MiniHomeConnectedEntrance$queryEntranceStatus$1 miniHomeConnectedEntrance$queryEntranceStatus$1;
        Object coroutine_suspended;
        int i3;
        byte[] bArr;
        if (continuation instanceof MiniHomeConnectedEntrance$queryEntranceStatus$1) {
            miniHomeConnectedEntrance$queryEntranceStatus$1 = (MiniHomeConnectedEntrance$queryEntranceStatus$1) continuation;
            int i16 = miniHomeConnectedEntrance$queryEntranceStatus$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeConnectedEntrance$queryEntranceStatus$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeConnectedEntrance$queryEntranceStatus$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeConnectedEntrance$queryEntranceStatus$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.n nVar = new com.tencent.mobileqq.zplan.utils.n("FriendsDressUpFragmentDebug_" + bb.f335811a.e());
                    com.tencent.mobileqq.zplan.utils.o<ZPlanRequestReq, av> j16 = SknNetworkUtilKt.j(SknNetworkUtilKt.e(at.f335791a, nVar, new Function2<av.a, Long, Boolean>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance$queryEntranceStatus$rsp$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Boolean invoke(av.a aVar, Long l3) {
                            return invoke(aVar, l3.longValue());
                        }

                        public final Boolean invoke(av.a cachedRsp, long j17) {
                            v45.b bVar;
                            Intrinsics.checkNotNullParameter(cachedRsp, "cachedRsp");
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            Object data = cachedRsp.getData();
                            byte[] bArr2 = data instanceof byte[] ? (byte[]) data : null;
                            return Boolean.valueOf(currentTimeMillis > ((bArr2 == null || (bVar = (v45.b) SknNetworkUtilKt.c(bArr2, new v45.b())) == null) ? 0L : bVar.f440974d));
                        }
                    }), nVar);
                    v45.a aVar = new v45.a();
                    aVar.f440970a = j3;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_aio_entrance.Manager.SsoQueryEntranceStatus", SknNetworkUtilKt.i(aVar));
                    miniHomeConnectedEntrance$queryEntranceStatus$1.label = 1;
                    obj = j16.a(zPlanRequestReq, miniHomeConnectedEntrance$queryEntranceStatus$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                av avVar = (av) obj;
                QLog.i("FriendsDressUpFragmentDebug", 1, "queryEntranceStatus " + avVar);
                Object data = avVar.getData();
                bArr = !(data instanceof byte[]) ? (byte[]) data : null;
                if (bArr == null) {
                    return (v45.b) SknNetworkUtilKt.c(bArr, new v45.b());
                }
                return null;
            }
        }
        miniHomeConnectedEntrance$queryEntranceStatus$1 = new MiniHomeConnectedEntrance$queryEntranceStatus$1(this, continuation);
        Object obj2 = miniHomeConnectedEntrance$queryEntranceStatus$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeConnectedEntrance$queryEntranceStatus$1.label;
        if (i3 != 0) {
        }
        av avVar2 = (av) obj2;
        QLog.i("FriendsDressUpFragmentDebug", 1, "queryEntranceStatus " + avVar2);
        Object data2 = avVar2.getData();
        if (!(data2 instanceof byte[])) {
        }
        if (bArr == null) {
        }
    }

    public final void c(long friendUin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "MiniHomeConnectedEntrance", null, null, null, new MiniHomeConnectedEntrance$showEntrance$1(friendUin, callback, null), 14, null);
        }
    }
}
