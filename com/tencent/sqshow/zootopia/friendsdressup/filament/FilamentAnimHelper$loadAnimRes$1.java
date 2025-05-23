package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadAnimRes$1", f = "FriendsDressUpAnimHelper.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FilamentAnimHelper$loadAnimRes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bodyMontagePath;
    final /* synthetic */ String $headMontagePath;
    final /* synthetic */ String $uin;
    final /* synthetic */ FilamentViewerV2 $viewer;
    int label;
    final /* synthetic */ FilamentAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadAnimRes$1$1", f = "FriendsDressUpAnimHelper.kt", i = {0, 1, 1, 2, 2}, l = {153, 158, 160}, m = "invokeSuspend", n = {"errorMsg", "errorMsg", "initAnimAction", "errorMsg", "initAnimAction"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadAnimRes$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bodyMontagePath;
        final /* synthetic */ String $headMontagePath;
        final /* synthetic */ String $uin;
        final /* synthetic */ FilamentViewerV2 $viewer;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ FilamentAnimHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FilamentAnimHelper filamentAnimHelper, FilamentViewerV2 filamentViewerV2, String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = filamentAnimHelper;
            this.$viewer = filamentViewerV2;
            this.$headMontagePath = str;
            this.$bodyMontagePath = str2;
            this.$uin = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$viewer, this.$headMontagePath, this.$bodyMontagePath, this.$uin, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00d6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef objectRef;
            Deferred async$default;
            Object await;
            final ZPlanAction zPlanAction;
            AtomicBoolean atomicBoolean;
            AtomicBoolean atomicBoolean2;
            com.tencent.filament.zplan.animation.b bVar;
            Object y16;
            ZPlanAction zPlanAction2;
            com.tencent.filament.zplan.animation.b bVar2;
            Object x16;
            i iVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "loadAnimRes start");
                objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimHelper$loadAnimRes$1$1$initAnimActionJob$1(this.this$0, this.$headMontagePath, this.$bodyMontagePath, objectRef, null), 3, null);
                this.L$0 = objectRef;
                this.label = 1;
                await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2 && i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    zPlanAction2 = (ZPlanAction) this.L$1;
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    zPlanAction = zPlanAction2;
                    final Ref.ObjectRef objectRef2 = objectRef;
                    iVar = this.this$0.taskExecutor;
                    if (iVar != null) {
                        final FilamentAnimHelper filamentAnimHelper = this.this$0;
                        final String str = this.$uin;
                        final FilamentViewerV2 filamentViewerV2 = this.$viewer;
                        iVar.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper.loadAnimRes.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ConcurrentHashMap concurrentHashMap;
                                com.tencent.filament.zplan.animation.b D;
                                if (ZPlanAction.this == null) {
                                    filamentAnimHelper.z(objectRef2.element);
                                } else {
                                    concurrentHashMap = filamentAnimHelper.uinAnimMap;
                                    String str2 = str;
                                    D = filamentAnimHelper.D(filamentViewerV2, new ZPlanAction[]{ZPlanAction.this});
                                    concurrentHashMap.put(str2, D);
                                }
                                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "loadAnimRes end");
                                filamentAnimHelper.q(str);
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                await = obj;
            }
            ZPlanAction zPlanAction3 = (ZPlanAction) await;
            if (zPlanAction3 == null) {
                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "download fail, load default anim");
                atomicBoolean = this.this$0.isFemale;
                if (atomicBoolean.get()) {
                    bVar2 = this.this$0.femaleInitAnim;
                    if (bVar2 == null) {
                        FilamentAnimHelper filamentAnimHelper2 = this.this$0;
                        FilamentViewerV2 filamentViewerV22 = this.$viewer;
                        this.L$0 = objectRef;
                        this.L$1 = zPlanAction3;
                        this.label = 2;
                        x16 = filamentAnimHelper2.x(filamentViewerV22, this);
                        if (x16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanAction2 = zPlanAction3;
                        zPlanAction = zPlanAction2;
                        final Ref.ObjectRef<String> objectRef22 = objectRef;
                        iVar = this.this$0.taskExecutor;
                        if (iVar != null) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                atomicBoolean2 = this.this$0.isFemale;
                if (!atomicBoolean2.get()) {
                    bVar = this.this$0.maleInitAnim;
                    if (bVar == null) {
                        FilamentAnimHelper filamentAnimHelper3 = this.this$0;
                        FilamentViewerV2 filamentViewerV23 = this.$viewer;
                        this.L$0 = objectRef;
                        this.L$1 = zPlanAction3;
                        this.label = 3;
                        y16 = filamentAnimHelper3.y(filamentViewerV23, this);
                        if (y16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanAction2 = zPlanAction3;
                        zPlanAction = zPlanAction2;
                        final Ref.ObjectRef<String> objectRef222 = objectRef;
                        iVar = this.this$0.taskExecutor;
                        if (iVar != null) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            }
            zPlanAction = zPlanAction3;
            final Ref.ObjectRef<String> objectRef2222 = objectRef;
            iVar = this.this$0.taskExecutor;
            if (iVar != null) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimHelper$loadAnimRes$1(FilamentAnimHelper filamentAnimHelper, String str, FilamentViewerV2 filamentViewerV2, String str2, String str3, Continuation<? super FilamentAnimHelper$loadAnimRes$1> continuation) {
        super(2, continuation);
        this.this$0 = filamentAnimHelper;
        this.$uin = str;
        this.$viewer = filamentViewerV2;
        this.$headMontagePath = str2;
        this.$bodyMontagePath = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilamentAnimHelper$loadAnimRes$1(this.this$0, this.$uin, this.$viewer, this.$headMontagePath, this.$bodyMontagePath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            concurrentHashMap = this.this$0.uinAnimMap;
            if (((com.tencent.filament.zplan.animation.b) concurrentHashMap.get(this.$uin)) != null) {
                this.this$0.q(this.$uin);
                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAnimHelper_", "use cached anim res!");
                return Unit.INSTANCE;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$viewer, this.$headMontagePath, this.$bodyMontagePath, this.$uin, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentAnimHelper$loadAnimRes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
