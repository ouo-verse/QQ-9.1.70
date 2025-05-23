package lf3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.zplan.servlet.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import nu4.d;
import nu4.e;
import nu4.f;
import nu4.g;
import ze3.ZPlanEditAvatarConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJA\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Llf3/a;", "", "", "lastMd5", "", "uin", "", "gender", "version", "Lkotlin/Pair;", "", "Lze3/b;", "a", "(Ljava/lang/String;JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414450a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"lf3/a$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lf3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10721a implements b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Boolean, ZPlanEditAvatarConfigInfo>> f414451d;

        /* JADX WARN: Multi-variable type inference failed */
        C10721a(Continuation<? super Pair<Boolean, ZPlanEditAvatarConfigInfo>> continuation) {
            this.f414451d = continuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            e eVar;
            QLog.w("ZPlanEditAvatarRequest", 1, "requestEditAvatarConfig onUpdate, type " + type + ", success: " + isSuccess);
            if (!isSuccess) {
                Continuation<Pair<Boolean, ZPlanEditAvatarConfigInfo>> continuation = this.f414451d;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestEditAvatarConfig failed."))));
                return;
            }
            ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo = null;
            try {
                eVar = e.c(data instanceof byte[] ? (byte[]) data : null);
            } catch (Exception e16) {
                QLog.e("ZPlanEditAvatarRequest", 1, "requestEditAvatarConfig failed.", e16);
                eVar = null;
            }
            if (eVar == null) {
                Continuation<Pair<Boolean, ZPlanEditAvatarConfigInfo>> continuation2 = this.f414451d;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("requestEditAvatarConfig failed, rsp null."))));
                return;
            }
            boolean z16 = eVar.f421355a;
            if (z16) {
                String str = eVar.f421356b;
                Intrinsics.checkNotNullExpressionValue(str, "rsp.md5");
                g[] gVarArr = eVar.f421357c;
                Intrinsics.checkNotNullExpressionValue(gVarArr, "rsp.headConfigs");
                nu4.a[] aVarArr = eVar.f421358d;
                Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.backgroundConfigs");
                f fVar = eVar.f421359e;
                Intrinsics.checkNotNullExpressionValue(fVar, "rsp.globalConfig");
                zPlanEditAvatarConfigInfo = new ZPlanEditAvatarConfigInfo(str, gVarArr, aVarArr, fVar);
            }
            QLog.i("ZPlanEditAvatarRequest", 1, "requestEditAvatarConfig succeed, config: " + zPlanEditAvatarConfigInfo + ".");
            Continuation<Pair<Boolean, ZPlanEditAvatarConfigInfo>> continuation3 = this.f414451d;
            Result.Companion companion3 = Result.INSTANCE;
            continuation3.resumeWith(Result.m476constructorimpl(new Pair(Boolean.valueOf(z16), zPlanEditAvatarConfigInfo)));
        }
    }

    a() {
    }

    public final Object a(String str, long j3, int i3, String str2, Continuation<? super Pair<Boolean, ZPlanEditAvatarConfigInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        C10721a c10721a = new C10721a(safeContinuation);
        d dVar = new d();
        dVar.f421351a = str;
        dVar.f421352b = j3;
        dVar.f421353c = i3;
        dVar.f421354d = str2;
        byte[] byteArray = MessageNano.toByteArray(dVar);
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("trpc.zplan.avatar_head_info.Config.SsoGetConfig", byteArray, c10721a);
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
