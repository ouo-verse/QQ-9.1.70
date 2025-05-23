package com.tencent.mobileqq.qwallet.pet;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$checkAllTaskFinish$2", f = "QWalletPetStartup.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class QWalletPetStartup$checkAllTaskFinish$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QWalletPetStartup this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$checkAllTaskFinish$2$1", f = "QWalletPetStartup.kt", i = {}, l = {117, 119}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.QWalletPetStartup$checkAllTaskFinish$2$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QWalletPetStartup this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QWalletPetStartup qWalletPetStartup, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qWalletPetStartup;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Map map;
            Object firstOrNull;
            QWalletPetStartup.d dVar;
            QWalletPetStartup.d dVar2;
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
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            map = this.this$0.finishTask;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(linkedHashMap.entrySet());
            Map.Entry entry2 = (Map.Entry) firstOrNull;
            if (entry2 == null) {
                dVar2 = this.this$0.callback;
                if (dVar2 == null) {
                    return null;
                }
                this.label = 1;
                if (dVar2.b(true, null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            dVar = this.this$0.callback;
            if (dVar == null) {
                return null;
            }
            QWalletPetStartup.FailResultData a16 = QWalletPetStartup.FailResultData.INSTANCE.a((QWalletPetStartup.EnumTask) entry2.getKey());
            this.label = 2;
            if (dVar.b(false, a16, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletPetStartup$checkAllTaskFinish$2(QWalletPetStartup qWalletPetStartup, Continuation<? super QWalletPetStartup$checkAllTaskFinish$2> continuation) {
        super(2, continuation);
        this.this$0 = qWalletPetStartup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletPetStartup$checkAllTaskFinish$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map map;
        Set set;
        Map map2;
        Map map3;
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
            map = this.this$0.finishTask;
            Set keySet = map.keySet();
            set = ArraysKt___ArraysKt.toSet(QWalletPetStartup.EnumTask.values());
            if (!keySet.containsAll(set)) {
                map3 = this.this$0.finishTask;
                QLog.i("QWallet.Pet.Startup", 1, "has finish: " + map3.keySet());
                return Unit.INSTANCE;
            }
            map2 = this.this$0.finishTask;
            QLog.i("QWallet.Pet.Startup", 1, "all finish: " + map2);
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (CorountineFunKt.i(eVar, "QWallet.Pet.Startup", null, anonymousClass1, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletPetStartup$checkAllTaskFinish$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
