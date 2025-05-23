package com.tencent.mobileqq.opr.utils;

import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.util.ShiplySoDownloader;
import com.tencent.qne.util.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qne/util/d;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.mobileqq.opr.utils.SoLoader$load$2", f = "SoLoader.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"fetchSoStart"}, s = {"J$0"})
/* loaded from: classes16.dex */
public final class SoLoader$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    static IPatchRedirector $redirector_;
    long J$0;
    int label;
    final /* synthetic */ SoLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoLoader$load$2(SoLoader soLoader, Continuation<? super SoLoader$load$2> continuation) {
        super(2, continuation);
        this.this$0 = soLoader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) soLoader, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SoLoader$load$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean f16;
        com.tencent.qne.delegate.d dVar;
        String str;
        long j3;
        String str2;
        boolean g16;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    j3 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                f16 = this.this$0.f();
                if (f16) {
                    return new d(true, 0L, false, 0L, 14, null);
                }
                long currentTimeMillis = System.currentTimeMillis();
                dVar = this.this$0.shiply;
                Long boxLong = Boxing.boxLong(2263366L);
                str = this.this$0.unzipPath;
                ShiplySoDownloader shiplySoDownloader = new ShiplySoDownloader(dVar, "opr-arm64-v8a.so", boxLong, str);
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = ShiplySoDownloader.d(shiplySoDownloader, false, this, 1, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis;
            }
            com.tencent.qne.util.c cVar = (com.tencent.qne.util.c) obj;
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            if (!cVar.b()) {
                OprLogger.e("[opr]SoLoader", Intrinsics.stringPlus("fetchAndLoadSo fail, result:", cVar));
                str3 = this.this$0.unzipPath;
                com.tencent.qne.util.a.a(str3);
                return new d(false, currentTimeMillis2, cVar.a(), 0L, 8, null);
            }
            SoLoader soLoader = this.this$0;
            long currentTimeMillis3 = System.currentTimeMillis();
            str2 = soLoader.unzipPath;
            g16 = soLoader.g(str2);
            return new d(g16, currentTimeMillis2, cVar.a(), System.currentTimeMillis() - currentTimeMillis3);
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super d> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SoLoader$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
