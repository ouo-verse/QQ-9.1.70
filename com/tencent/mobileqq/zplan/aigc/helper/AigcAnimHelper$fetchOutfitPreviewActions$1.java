package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$fetchOutfitPreviewActions$1", f = "AigcAnimHelper.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class AigcAnimHelper$fetchOutfitPreviewActions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ List<SuitAnimationItem> $suitActions;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AigcAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$fetchOutfitPreviewActions$1$1", f = "AigcAnimHelper.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$fetchOutfitPreviewActions$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ EnumUserGender $gender;
        final /* synthetic */ List<SuitAnimationItem> $suitActions;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AigcAnimHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<SuitAnimationItem> list, AigcAnimHelper aigcAnimHelper, Function1<? super Boolean, Unit> function1, EnumUserGender enumUserGender, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$suitActions = list;
            this.this$0 = aigcAnimHelper;
            this.$callback = function1;
            this.$gender = enumUserGender;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$suitActions, this.this$0, this.$callback, this.$gender, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            AigcAnimHelper aigcAnimHelper;
            Deferred async$default;
            List mutableList;
            List list;
            int i3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ArrayList arrayList = new ArrayList();
                List<SuitAnimationItem> list2 = this.$suitActions;
                AigcAnimHelper aigcAnimHelper2 = this.this$0;
                EnumUserGender enumUserGender = this.$gender;
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1((SuitAnimationItem) it.next(), aigcAnimHelper2, enumUserGender, null), 3, null);
                    arrayList.add(async$default);
                }
                AigcAnimHelper aigcAnimHelper3 = this.this$0;
                this.L$0 = aigcAnimHelper3;
                this.label = 1;
                Object awaitAll = AwaitKt.awaitAll(arrayList, this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aigcAnimHelper = aigcAnimHelper3;
                obj = awaitAll;
            } else if (i16 == 1) {
                aigcAnimHelper = (AigcAnimHelper) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) obj);
            aigcAnimHelper.mSuitOutfitActionList = mutableList;
            AigcAnimHelper aigcAnimHelper4 = this.this$0;
            Random.Companion companion = Random.INSTANCE;
            list = aigcAnimHelper4.mSuitOutfitActionList;
            aigcAnimHelper4.currentAnimIndex = companion.nextInt(0, list.size());
            this.$callback.invoke(Boxing.boxBoolean(true));
            i3 = this.this$0.currentAnimIndex;
            QLog.i("AigcAnimHelper_", 1, "fetchOutfitPreviewActions success, currentAnimIndex: " + i3);
            return "done";
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AigcAnimHelper$fetchOutfitPreviewActions$1(Function1<? super Boolean, Unit> function1, List<SuitAnimationItem> list, AigcAnimHelper aigcAnimHelper, EnumUserGender enumUserGender, Continuation<? super AigcAnimHelper$fetchOutfitPreviewActions$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$suitActions = list;
        this.this$0 = aigcAnimHelper;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcAnimHelper$fetchOutfitPreviewActions$1 aigcAnimHelper$fetchOutfitPreviewActions$1 = new AigcAnimHelper$fetchOutfitPreviewActions$1(this.$callback, this.$suitActions, this.this$0, this.$gender, continuation);
        aigcAnimHelper$fetchOutfitPreviewActions$1.L$0 = obj;
        return aigcAnimHelper$fetchOutfitPreviewActions$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$suitActions, this.this$0, this.$callback, this.$gender, null);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(10000L, anonymousClass1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((String) obj) == null) {
                Function1<Boolean, Unit> function1 = this.$callback;
                QLog.e("AigcAnimHelper_", 1, "fetchActions timeout");
                function1.invoke(Boxing.boxBoolean(false));
                Unit unit = Unit.INSTANCE;
            }
        } catch (FetchFileException e16) {
            QLog.e("AigcAnimHelper_", 1, "fetchActions throw exception. errorCode:" + e16.getErrorCode() + ", msg:" + e16.getErrorMessage() + ", url: " + e16.getUrl());
            this.$callback.invoke(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AigcAnimHelper$fetchOutfitPreviewActions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
