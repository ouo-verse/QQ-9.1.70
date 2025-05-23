package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$loadUgcThumbnailAnimation$1", f = "AigcAnimHelper.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class AigcAnimHelper$loadUgcThumbnailAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ FetchActionData $fetchActionData;
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ FilamentViewerV2 $viewer;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AigcAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$loadUgcThumbnailAnimation$1$1", f = "AigcAnimHelper.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$loadUgcThumbnailAnimation$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ FetchActionData $fetchActionData;
        final /* synthetic */ EnumUserGender $gender;
        final /* synthetic */ FilamentViewerV2 $viewer;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AigcAnimHelper this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$loadUgcThumbnailAnimation$1$1$1", f = "AigcAnimHelper.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$loadUgcThumbnailAnimation$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C91311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
            final /* synthetic */ FetchActionData $fetchActionData;
            final /* synthetic */ EnumUserGender $gender;
            int label;
            final /* synthetic */ AigcAnimHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C91311(AigcAnimHelper aigcAnimHelper, EnumUserGender enumUserGender, FetchActionData fetchActionData, Continuation<? super C91311> continuation) {
                super(2, continuation);
                this.this$0 = aigcAnimHelper;
                this.$gender = enumUserGender;
                this.$fetchActionData = fetchActionData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C91311(this.this$0, this.$gender, this.$fetchActionData, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AigcAnimHelper aigcAnimHelper = this.this$0;
                    EnumUserGender enumUserGender = this.$gender;
                    String actionFacePath = this.$fetchActionData.getActionFacePath();
                    Intrinsics.checkNotNull(actionFacePath);
                    String actionBodyPath = this.$fetchActionData.getActionBodyPath();
                    Intrinsics.checkNotNull(actionBodyPath);
                    FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
                    this.label = 1;
                    obj = aigcAnimHelper.d0(null, enumUserGender, actionFacePath, actionBodyPath, urlTemplate, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
                return ((C91311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(AigcAnimHelper aigcAnimHelper, EnumUserGender enumUserGender, FetchActionData fetchActionData, FilamentViewerV2 filamentViewerV2, Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aigcAnimHelper;
            this.$gender = enumUserGender;
            this.$fetchActionData = fetchActionData;
            this.$viewer = filamentViewerV2;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$gender, this.$fetchActionData, this.$viewer, this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Deferred async$default;
            com.tencent.sqshow.zootopia.avatar.filament.i mTaskExecutor;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ArrayList arrayList = new ArrayList();
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C91311(this.this$0, this.$gender, this.$fetchActionData, null), 3, null);
                arrayList.add(async$default);
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object[] array = ((Collection) obj).toArray(new ZPlanAction[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            final ZPlanAction[] zPlanActionArr = (ZPlanAction[]) array;
            mTaskExecutor = super/*com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper*/.getMTaskExecutor();
            if (mTaskExecutor != null) {
                final AigcAnimHelper aigcAnimHelper = this.this$0;
                final FilamentViewerV2 filamentViewerV2 = this.$viewer;
                final Function1<Boolean, Unit> function1 = this.$callback;
                mTaskExecutor.runOnViewerThread("loadUgcThumbnailAnimation", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper.loadUgcThumbnailAnimation.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AigcAnimHelper aigcAnimHelper2 = AigcAnimHelper.this;
                        aigcAnimHelper2.mUgcThumbnailAnim = PortalAnimHelper.r1(aigcAnimHelper2, filamentViewerV2, zPlanActionArr, null, 4, null);
                        function1.invoke(Boolean.TRUE);
                    }
                });
                return "done";
            }
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
    public AigcAnimHelper$loadUgcThumbnailAnimation$1(Function1<? super Boolean, Unit> function1, AigcAnimHelper aigcAnimHelper, EnumUserGender enumUserGender, FetchActionData fetchActionData, FilamentViewerV2 filamentViewerV2, Continuation<? super AigcAnimHelper$loadUgcThumbnailAnimation$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.this$0 = aigcAnimHelper;
        this.$gender = enumUserGender;
        this.$fetchActionData = fetchActionData;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcAnimHelper$loadUgcThumbnailAnimation$1 aigcAnimHelper$loadUgcThumbnailAnimation$1 = new AigcAnimHelper$loadUgcThumbnailAnimation$1(this.$callback, this.this$0, this.$gender, this.$fetchActionData, this.$viewer, continuation);
        aigcAnimHelper$loadUgcThumbnailAnimation$1.L$0 = obj;
        return aigcAnimHelper$loadUgcThumbnailAnimation$1;
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$gender, this.$fetchActionData, this.$viewer, this.$callback, null);
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
                QLog.e("AigcAnimHelper_", 1, "loadUgcThumbnailAnimation timeout");
                function1.invoke(Boxing.boxBoolean(false));
                Unit unit = Unit.INSTANCE;
            }
        } catch (FetchFileException e16) {
            QLog.e("AigcAnimHelper_", 1, "loadUgcThumbnailAnimation throw exception. errorCode:" + e16.getErrorCode() + ", msg:" + e16.getErrorMessage() + ", url: " + e16.getUrl());
            this.$callback.invoke(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AigcAnimHelper$loadUgcThumbnailAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
