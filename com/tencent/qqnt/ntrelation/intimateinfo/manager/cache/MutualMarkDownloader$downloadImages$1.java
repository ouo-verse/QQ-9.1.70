package com.tencent.qqnt.ntrelation.intimateinfo.manager.cache;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDownloader$downloadImages$1", f = "MutualMarkDownloader.kt", i = {0, 0, 1}, l = {131, 133, 139}, m = "invokeSuspend", n = {ForwardMiniChooseFriendOption.RESULT_LIST, "completion", ForwardMiniChooseFriendOption.RESULT_LIST}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes22.dex */
final class MutualMarkDownloader$downloadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<ArrayList<Drawable>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<NTMutualMarkEntity> $mutualMarkInfos;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDownloader$downloadImages$1$1", f = "MutualMarkDownloader.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDownloader$downloadImages$1$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CompletableDeferred<Unit> $completion;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CompletableDeferred<Unit> completableDeferred, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$completion = completableDeferred;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) completableDeferred, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$completion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred<Unit> completableDeferred = this.$completion;
                    this.label = 1;
                    if (completableDeferred.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDownloader$downloadImages$1$2", f = "MutualMarkDownloader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDownloader$downloadImages$1$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Function1<ArrayList<Drawable>, Unit> $callback;
        final /* synthetic */ List<Drawable> $results;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super ArrayList<Drawable>, Unit> function1, List<Drawable> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$results = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, function1, list, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.$callback, this.$results, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$callback.invoke(new ArrayList<>(this.$results));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutualMarkDownloader$downloadImages$1(ArrayList<NTMutualMarkEntity> arrayList, Context context, Function1<? super ArrayList<Drawable>, Unit> function1, Continuation<? super MutualMarkDownloader$downloadImages$1> continuation) {
        super(2, continuation);
        this.$mutualMarkInfos = arrayList;
        this.$context = context;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, context, function1, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        MutualMarkDownloader$downloadImages$1 mutualMarkDownloader$downloadImages$1 = new MutualMarkDownloader$downloadImages$1(this.$mutualMarkInfos, this.$context, this.$callback, continuation);
        mutualMarkDownloader$downloadImages$1.L$0 = obj;
        return mutualMarkDownloader$downloadImages$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x011b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        List list;
        CompletableDeferred completableDeferred;
        Deferred async$default;
        MainCoroutineDispatcher main;
        AnonymousClass2 anonymousClass2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    QLog.i(MutualMarkDownloader.f360096a.d(), 1, "after channel close");
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(this.$callback, list, null);
                    this.L$0 = null;
                    this.label = 3;
                    if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                completableDeferred = (CompletableDeferred) this.L$1;
                List list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list = list2;
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                int size = this.$mutualMarkInfos.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i16 = 0; i16 < size; i16++) {
                    arrayList.add(null);
                }
                AtomicInteger atomicInteger = new AtomicInteger(this.$mutualMarkInfos.size());
                CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                ArrayList<NTMutualMarkEntity> arrayList2 = this.$mutualMarkInfos;
                Context context = this.$context;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                int i17 = 0;
                for (Object obj2 : arrayList2) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    ArrayList arrayList4 = arrayList3;
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MutualMarkDownloader$downloadImages$1$deferreds$1$1((NTMutualMarkEntity) obj2, arrayList, i17, context, atomicInteger, CompletableDeferred$default, null), 3, null);
                    arrayList4.add(async$default);
                    arrayList = arrayList;
                    arrayList3 = arrayList4;
                    i17 = i18;
                    context = context;
                }
                list = arrayList;
                this.L$0 = list;
                this.L$1 = CompletableDeferred$default;
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                completableDeferred = CompletableDeferred$default;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completableDeferred, null);
            this.L$0 = list;
            this.L$1 = null;
            this.label = 2;
            if (TimeoutKt.withTimeoutOrNull(500L, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            QLog.i(MutualMarkDownloader.f360096a.d(), 1, "after channel close");
            main = Dispatchers.getMain();
            anonymousClass2 = new AnonymousClass2(this.$callback, list, null);
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MutualMarkDownloader$downloadImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
