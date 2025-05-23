package com.tencent.qne.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.util.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.qne.model.Backend$prepareDependency$2", f = "Backend.kt", i = {0}, l = {32}, m = "invokeSuspend", n = {"timeStart"}, s = {"J$0"})
/* loaded from: classes22.dex */
public final class Backend$prepareDependency$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.qne.delegate.d $shiply;
    final /* synthetic */ String $unzipPath;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Backend this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Backend$prepareDependency$2(Backend backend, String str, com.tencent.qne.delegate.d dVar, Continuation<? super Backend$prepareDependency$2> continuation) {
        super(2, continuation);
        this.this$0 = backend;
        this.$unzipPath = str;
        this.$shiply = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, backend, str, dVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        Backend$prepareDependency$2 backend$prepareDependency$2 = new Backend$prepareDependency$2(this.this$0, this.$unzipPath, this.$shiply, continuation);
        backend$prepareDependency$2.L$0 = obj;
        return backend$prepareDependency$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        long j3;
        Deferred async$default;
        boolean z16;
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                long currentTimeMillis = System.currentTimeMillis();
                List<DependencyLibrary> c16 = this.this$0.c();
                com.tencent.qne.delegate.d dVar = this.$shiply;
                String str = this.$unzipPath;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = c16.iterator();
                while (it.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new Backend$prepareDependency$2$jobs$1$1((DependencyLibrary) it.next(), dVar, str, null), 3, null);
                    arrayList.add(async$default);
                }
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis;
            }
            List list = (List) obj;
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    if (!((com.tencent.qne.util.c) it5.next()).b()) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            Logger.i("[qne]Backend", "fetch " + this.this$0.b() + " dependency:" + this.this$0.c() + ", cost:" + currentTimeMillis2);
            if (z16) {
                Logger.e("[qne]Backend", Intrinsics.stringPlus("fetch so fail, results:", list));
                com.tencent.qne.util.a.a(this.$unzipPath);
                return Boxing.boxBoolean(false);
            }
            return Boxing.boxBoolean(true);
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((Backend$prepareDependency$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
