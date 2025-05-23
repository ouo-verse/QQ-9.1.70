package com.tencent.qqnt.aio.helper;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/helper/fn;", "", "", "troopUin", "memberUin", "", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class fn {

    /* renamed from: a, reason: collision with root package name */
    public static final fn f350874a = new fn();

    fn() {
    }

    public final Object a(String str, String str2, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        ITroopHonorService iTroopHonorService;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
        if (baseQQAppInterface != null && (iTroopHonorService = (ITroopHonorService) baseQQAppInterface.getRuntimeService(ITroopHonorService.class, "")) != null) {
            iTroopHonorService.asyncGetTroopHonorListByDirect(str, str2, new a(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/troop/honor/config/a;", "kotlin.jvm.PlatformType", "", "result", "", "onResult", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    static final class a implements ITroopHonorService.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f350875a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation) {
            this.f350875a = continuation;
        }

        @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService.c
        public final void onResult(List<com.tencent.mobileqq.troop.honor.config.a> list) {
            Object obj;
            boolean z16 = false;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((com.tencent.mobileqq.troop.honor.config.a) obj).f297511d == 1) {
                            break;
                        }
                    }
                }
                if (((com.tencent.mobileqq.troop.honor.config.a) obj) != null) {
                    z16 = true;
                }
            }
            QLog.i("UserInteractiveLevelQueryApi", 1, "bIsDragonKing=" + z16);
            Continuation<Boolean> continuation = this.f350875a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }
}
