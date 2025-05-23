package com.tencent.localedit.fakenative.packages;

import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x11.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.localedit.fakenative.packages.ResourcePackage$updateResource$1", f = "ResourcePackage.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class ResourcePackage$updateResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Boolean $checkInnerZip;
    final /* synthetic */ String $docsType;
    int label;
    final /* synthetic */ ResourcePackage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.tencent.localedit.fakenative.packages.ResourcePackage$updateResource$1$1", f = "ResourcePackage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.localedit.fakenative.packages.ResourcePackage$updateResource$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Boolean $checkInnerZip;
        final /* synthetic */ String $docsType;
        int label;
        final /* synthetic */ ResourcePackage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ResourcePackage resourcePackage, String str, Function1<? super Boolean, Unit> function1, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = resourcePackage;
            this.$docsType = str;
            this.$callback = function1;
            this.$checkInnerZip = bool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$docsType, this.$callback, this.$checkInnerZip, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z16;
            Set set;
            boolean contains;
            Set set2;
            String l3;
            String h16;
            Set set3;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String j3 = this.this$0.j(this.$docsType);
                b bVar = b.f446855a;
                bVar.a("ResourcePackage", Intrinsics.stringPlus("updateResource url = ", j3));
                boolean z17 = false;
                if (j3 != null && j3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    bVar.b("ResourcePackage", "url is empty");
                    Function1<Boolean, Unit> function1 = this.$callback;
                    if (function1 != null) {
                        function1.invoke(Boxing.boxBoolean(false));
                    }
                    return Unit.INSTANCE;
                }
                ResourcePackage resourcePackage = this.this$0;
                String str = this.$docsType;
                Function1<Boolean, Unit> function12 = this.$callback;
                synchronized (resourcePackage) {
                    set = resourcePackage.currentUpdatingList;
                    contains = CollectionsKt___CollectionsKt.contains(set, str);
                    if (!contains) {
                        set2 = resourcePackage.currentUpdatingList;
                        Intrinsics.checkNotNull(str);
                        set2.add(str);
                        StringBuilder sb5 = new StringBuilder();
                        l3 = this.this$0.l();
                        sb5.append(l3);
                        sb5.append('/');
                        sb5.append((Object) this.$docsType);
                        sb5.append(".zip");
                        String sb6 = sb5.toString();
                        File file = new File(sb6);
                        if (!w11.b.f444160a.a(j3, file)) {
                            bVar.b("ResourcePackage", Intrinsics.stringPlus("download resource failed for ", this.$docsType));
                            Function1<Boolean, Unit> function13 = this.$callback;
                            if (function13 != null) {
                                function13.invoke(Boxing.boxBoolean(false));
                            }
                            return Unit.INSTANCE;
                        }
                        w11.a aVar = w11.a.f444159a;
                        h16 = this.this$0.h(this.$docsType);
                        boolean t16 = aVar.t(sb6, h16);
                        bVar.d("ResourcePackage", "unzipFile package for " + ((Object) this.$docsType) + " is " + t16);
                        if (t16) {
                            FilesKt__UtilsKt.deleteRecursively(file);
                            if (Intrinsics.areEqual(this.$checkInnerZip, Boxing.boxBoolean(true))) {
                                this.this$0.e(this.$docsType);
                            }
                            z17 = this.this$0.m(this.$docsType);
                        }
                        ResourcePackage resourcePackage2 = this.this$0;
                        String str2 = this.$docsType;
                        synchronized (resourcePackage2) {
                            set3 = resourcePackage2.currentUpdatingList;
                            if (set3 != null) {
                                TypeIntrinsics.asMutableCollection(set3).remove(str2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                            }
                        }
                        Function1<Boolean, Unit> function14 = this.$callback;
                        if (function14 != null) {
                            function14.invoke(Boxing.boxBoolean(z17));
                        }
                        return Unit.INSTANCE;
                    }
                    bVar.d("ResourcePackage", "offline package for " + ((Object) str) + " is already downloading");
                    if (function12 != null) {
                        function12.invoke(Boxing.boxBoolean(false));
                    }
                    return Unit.INSTANCE;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResourcePackage$updateResource$1(ResourcePackage resourcePackage, String str, Function1<? super Boolean, Unit> function1, Boolean bool, Continuation<? super ResourcePackage$updateResource$1> continuation) {
        super(2, continuation);
        this.this$0 = resourcePackage;
        this.$docsType = str;
        this.$callback = function1;
        this.$checkInnerZip = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ResourcePackage$updateResource$1(this.this$0, this.$docsType, this.$callback, this.$checkInnerZip, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$docsType, this.$callback, this.$checkInnerZip, null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ResourcePackage$updateResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
