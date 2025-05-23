package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.upload.a;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.api.impl.DiyCardBgUtilsImpl$uploadBackgroundToUps$2", f = "DiyCardBgUtilsImpl.kt", i = {0, 1, 1}, l = {120, 123}, m = "invokeSuspend", n = {"app", "app", "bytesA2"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes35.dex */
final class DiyCardBgUtilsImpl$uploadBackgroundToUps$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $filePath;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/api/impl/DiyCardBgUtilsImpl$uploadBackgroundToUps$2$a", "Lcom/tencent/mobileqq/profile/upload/task/b;", "", "state", "", "", "args", "", "e", "(I[Ljava/lang/Object;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.profile.upload.task.b {
        final /* synthetic */ Continuation<String> J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, byte[] bArr, Continuation<? super String> continuation, long j3) {
            super(j3, str, bArr, "qqprofile");
            this.J = continuation;
        }

        @Override // com.tencent.mobileqq.profile.upload.task.a
        public void e(int state, Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            if (state == 1001) {
                Object d16 = d();
                UpsImageUploadResult upsImageUploadResult = d16 instanceof UpsImageUploadResult ? (UpsImageUploadResult) d16 : null;
                this.J.resumeWith(Result.m476constructorimpl(upsImageUploadResult != null ? upsImageUploadResult.url : null));
            } else {
                if (state != 1002) {
                    return;
                }
                Continuation<String> continuation = this.J;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(b() + " " + c()))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "([B)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<byte[]> f308468a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super byte[]> continuation) {
            this.f308468a = continuation;
        }

        @Override // com.tencent.mobileqq.profile.upload.a.b
        public final void a(byte[] bArr) {
            this.f308468a.resumeWith(Result.m476constructorimpl(bArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiyCardBgUtilsImpl$uploadBackgroundToUps$2(String str, Continuation<? super DiyCardBgUtilsImpl$uploadBackgroundToUps$2> continuation) {
        super(2, continuation);
        this.$filePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiyCardBgUtilsImpl$uploadBackgroundToUps$2(this.$filePath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQAppInterface qQAppInterface;
        Continuation intercepted;
        Object coroutine_suspended2;
        Continuation intercepted2;
        Object coroutine_suspended3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            qQAppInterface = (QQAppInterface) peekAppRuntime;
            this.L$0 = qQAppInterface;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            com.tencent.mobileqq.profile.upload.a.c(qQAppInterface, new b(safeContinuation));
            obj = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qQAppInterface = (QQAppInterface) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        byte[] bArr = (byte[]) obj;
        String str = this.$filePath;
        this.L$0 = qQAppInterface;
        this.L$1 = bArr;
        this.L$2 = str;
        this.label = 2;
        intercepted2 = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
        SafeContinuation safeContinuation2 = new SafeContinuation(intercepted2);
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        a aVar = new a(str, bArr, safeContinuation2, Long.parseLong(currentAccountUin));
        aVar.f260334n = bArr;
        aVar.f260346y = com.tencent.mobileqq.profile.upload.a.b(qQAppInterface, str);
        Manager manager = qQAppInterface.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.profile.upload.task.VipImageUploadManager");
        com.tencent.mobileqq.profile.upload.task.c cVar = (com.tencent.mobileqq.profile.upload.task.c) manager;
        cVar.b(qQAppInterface, null);
        aVar.j();
        cVar.c(qQAppInterface, aVar, null);
        obj = safeContinuation2.getOrThrow();
        coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended3) {
            DebugProbes.probeCoroutineSuspended(this);
        }
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((DiyCardBgUtilsImpl$uploadBackgroundToUps$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
