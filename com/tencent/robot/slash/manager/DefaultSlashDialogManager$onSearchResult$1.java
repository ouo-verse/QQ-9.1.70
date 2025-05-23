package com.tencent.robot.slash.manager;

import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import com.tencent.robot.slash.manager.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchResult$1", f = "DefaultSlashDialogManager.kt", i = {0, 0}, l = {414, 422}, m = "invokeSuspend", n = {"keyword", "convertResult"}, s = {"L$0", "L$1"})
/* loaded from: classes25.dex */
final class DefaultSlashDialogManager$onSearchResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $searchResult;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultSlashDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchResult$1$1", f = "DefaultSlashDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchResult$1$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<com.tencent.robot.slash.businessapi.a> $convertResult;
        final /* synthetic */ String $keyword;
        final /* synthetic */ Object $searchResult;
        int label;
        final /* synthetic */ DefaultSlashDialogManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<com.tencent.robot.slash.businessapi.a> objectRef, DefaultSlashDialogManager defaultSlashDialogManager, Object obj, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$convertResult = objectRef;
            this.this$0 = defaultSlashDialogManager;
            this.$searchResult = obj;
            this.$keyword = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$convertResult, this.this$0, this.$searchResult, this.$keyword, continuation);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.robot.slash.businessapi.a] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            ?? t16;
            Integer num;
            List<b.UIModelData> a16;
            List<b74.a> b16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<com.tencent.robot.slash.businessapi.a> objectRef = this.$convertResult;
                t16 = this.this$0.t(this.$searchResult, this.$keyword);
                objectRef.element = t16;
                String str = this.$keyword;
                com.tencent.robot.slash.businessapi.a aVar = this.$convertResult.element;
                Integer num2 = null;
                if (aVar != null && (b16 = aVar.b()) != null) {
                    num = Boxing.boxInt(b16.size());
                } else {
                    num = null;
                }
                com.tencent.robot.slash.businessapi.a aVar2 = this.$convertResult.element;
                if (aVar2 != null && (a16 = aVar2.a()) != null) {
                    num2 = Boxing.boxInt(a16.size());
                }
                QLog.i("SlashDialogManager", 1, "onSearchResult keyword = " + str + " itemDataList size = " + num + " avatarItemList size = " + num2);
                return Unit.INSTANCE;
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
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchResult$1$2", f = "DefaultSlashDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchResult$1$2, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<com.tencent.robot.slash.businessapi.a> $convertResult;
        final /* synthetic */ String $keyword;
        final /* synthetic */ Object $searchResult;
        int label;
        final /* synthetic */ DefaultSlashDialogManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DefaultSlashDialogManager defaultSlashDialogManager, Object obj, String str, Ref.ObjectRef<com.tencent.robot.slash.businessapi.a> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = defaultSlashDialogManager;
            this.$searchResult = obj;
            this.$keyword = str;
            this.$convertResult = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$searchResult, this.$keyword, this.$convertResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.mCacheSearchResult = this.$searchResult;
                if (((List) this.$searchResult).isEmpty()) {
                    this.this$0.mSlashState = 3;
                    if (this.$keyword.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.this$0.J();
                    } else {
                        d.a.a(this.this$0, false, 1, null);
                    }
                    return Unit.INSTANCE;
                }
                this.this$0.mSlashState = 4;
                com.tencent.robot.slash.businessapi.a aVar = this.$convertResult.element;
                if (aVar != null && !aVar.b().isEmpty()) {
                    this.this$0.O(this.$convertResult.element);
                    return Unit.INSTANCE;
                }
                d.a.a(this.this$0, false, 1, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSlashDialogManager$onSearchResult$1(DefaultSlashDialogManager defaultSlashDialogManager, Object obj, Continuation<? super DefaultSlashDialogManager$onSearchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultSlashDialogManager;
        this.$searchResult = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultSlashDialogManager$onSearchResult$1(this.this$0, this.$searchResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String str;
        String str2;
        Ref.ObjectRef objectRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
            String str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef = objectRef2;
            str2 = str3;
        } else {
            ResultKt.throwOnFailure(obj);
            z16 = this.this$0.mProcessEndFlag;
            if (z16) {
                QLog.i("SlashDialogManager", 1, "onSearchResult mProcessEndFlag == true return");
                return Unit.INSTANCE;
            }
            if (!(this.$searchResult instanceof List)) {
                this.this$0.mSlashState = 2;
                return Unit.INSTANCE;
            }
            str = this.this$0.mKeyword;
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef3, this.this$0, this.$searchResult, str, null);
            this.L$0 = str;
            this.L$1 = objectRef3;
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            objectRef = objectRef3;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$searchResult, str2, objectRef, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultSlashDialogManager$onSearchResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
