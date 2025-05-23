package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.model.DependencyLibrary;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qne/util/d;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.qne.util.SoLoader$load$2", f = "SoLoader.kt", i = {0}, l = {42}, m = "invokeSuspend", n = {"fetchSoStart"}, s = {"J$0"})
/* loaded from: classes22.dex */
public final class SoLoader$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    static IPatchRedirector $redirector_;
    long J$0;
    private /* synthetic */ Object L$0;
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
        SoLoader$load$2 soLoader$load$2 = new SoLoader$load$2(this.this$0, continuation);
        soLoader$load$2.L$0 = obj;
        return soLoader$load$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List list;
        List list2;
        long currentTimeMillis;
        List list3;
        int collectionSizeOrDefault;
        Object awaitAll;
        Deferred async$default;
        boolean z16;
        boolean z17;
        List list4;
        String str;
        boolean f16;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    long j3 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis = j3;
                    awaitAll = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                list = this.this$0.dependency;
                if (!list.isEmpty()) {
                    list2 = this.this$0.dependency;
                    Logger.i("[qne]SoLoader", Intrinsics.stringPlus("load so from dependency:", list2));
                    currentTimeMillis = System.currentTimeMillis();
                    list3 = this.this$0.dependency;
                    List list5 = list3;
                    SoLoader soLoader = this.this$0;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = list5.iterator();
                    while (it.hasNext()) {
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SoLoader$load$2$jobs$1$1((DependencyLibrary) it.next(), soLoader, null), 3, null);
                        arrayList.add(async$default);
                    }
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    awaitAll = AwaitKt.awaitAll(arrayList, this);
                    if (awaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Logger.e("[qne]SoLoader", "load so fail. dependency empty.");
                    return new d(false, 0L, false, 0L, 15, null);
                }
            }
            List list6 = (List) awaitAll;
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            List list7 = list6;
            boolean z18 = list7 instanceof Collection;
            boolean z19 = false;
            if (!z18 || !list7.isEmpty()) {
                Iterator it5 = list7.iterator();
                while (it5.hasNext()) {
                    if (!((c) it5.next()).b()) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z18 || !list7.isEmpty()) {
                Iterator it6 = list7.iterator();
                while (it6.hasNext()) {
                    if (((c) it6.next()).a()) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z16) {
                Logger.e("[qne]SoLoader", Intrinsics.stringPlus("fetch so fail, results:", list6));
                str3 = this.this$0.unzipPath;
                a.a(str3);
                return new d(false, currentTimeMillis2, z17, 0L, 8, null);
            }
            SoLoader soLoader2 = this.this$0;
            long currentTimeMillis3 = System.currentTimeMillis();
            list4 = soLoader2.dependency;
            List list8 = list4;
            if (!(list8 instanceof Collection) || !list8.isEmpty()) {
                Iterator it7 = list8.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    DependencyLibrary dependencyLibrary = (DependencyLibrary) it7.next();
                    str = soLoader2.unzipPath;
                    f16 = soLoader2.f(dependencyLibrary, str);
                    if (!f16) {
                        z19 = true;
                        break;
                    }
                }
            }
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            if (z19) {
                Logger.e("[qne]SoLoader", "load some so fail");
                str2 = this.this$0.unzipPath;
                a.a(str2);
            }
            return new d(!z19, currentTimeMillis2, z17, currentTimeMillis4);
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
