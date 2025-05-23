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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$handleSlashStateSuccess$1", f = "DefaultSlashDialogManager.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class DefaultSlashDialogManager$handleSlashStateSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ Object $tempSearchResult;
    int label;
    final /* synthetic */ DefaultSlashDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$handleSlashStateSuccess$1$1", f = "DefaultSlashDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.slash.manager.DefaultSlashDialogManager$handleSlashStateSuccess$1$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.tencent.robot.slash.businessapi.a $convertResult;
        int label;
        final /* synthetic */ DefaultSlashDialogManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.tencent.robot.slash.businessapi.a aVar, DefaultSlashDialogManager defaultSlashDialogManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$convertResult = aVar;
            this.this$0 = defaultSlashDialogManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$convertResult, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.robot.slash.businessapi.a aVar = this.$convertResult;
                if (aVar != null && !aVar.b().isEmpty()) {
                    this.this$0.O(this.$convertResult);
                } else {
                    d.a.a(this.this$0, false, 1, null);
                }
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
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSlashDialogManager$handleSlashStateSuccess$1(DefaultSlashDialogManager defaultSlashDialogManager, Object obj, String str, Continuation<? super DefaultSlashDialogManager$handleSlashStateSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultSlashDialogManager;
        this.$tempSearchResult = obj;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultSlashDialogManager$handleSlashStateSuccess$1(this.this$0, this.$tempSearchResult, this.$keyword, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.robot.slash.businessapi.a t16;
        Integer num;
        Integer num2;
        List<b.UIModelData> a16;
        List<b74.a> b16;
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
            t16 = this.this$0.t(this.$tempSearchResult, this.$keyword);
            String str = this.$keyword;
            if (t16 != null && (b16 = t16.b()) != null) {
                num = Boxing.boxInt(b16.size());
            } else {
                num = null;
            }
            if (t16 != null && (a16 = t16.a()) != null) {
                num2 = Boxing.boxInt(a16.size());
            } else {
                num2 = null;
            }
            QLog.i("SlashDialogManager", 1, "handleSlashStateSuccess keyword = " + str + " itemList size = " + num + "  avatarItemList size = " + num2);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(t16, this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultSlashDialogManager$handleSlashStateSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
