package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
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
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadFemaleInitAnim$2", f = "FriendsDressUpAnimHelper.kt", i = {0}, l = {229}, m = "invokeSuspend", n = {"errorMsg"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class FilamentAnimHelper$loadFemaleInitAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilamentViewerV2 $viewer;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FilamentAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimHelper$loadFemaleInitAnim$2(FilamentAnimHelper filamentAnimHelper, FilamentViewerV2 filamentViewerV2, Continuation<? super FilamentAnimHelper$loadFemaleInitAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = filamentAnimHelper;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FilamentAnimHelper$loadFemaleInitAnim$2 filamentAnimHelper$loadFemaleInitAnim$2 = new FilamentAnimHelper$loadFemaleInitAnim$2(this.this$0, this.$viewer, continuation);
        filamentAnimHelper$loadFemaleInitAnim$2.L$0 = obj;
        return filamentAnimHelper$loadFemaleInitAnim$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        final Ref.ObjectRef objectRef;
        i iVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimHelper$loadFemaleInitAnim$2$initAnimFemaleActionJob$1(this.this$0, objectRef2, null), 3, null);
            this.L$0 = objectRef2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            obj = await;
        } else if (i3 == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ZPlanAction zPlanAction = (ZPlanAction) obj;
        iVar = this.this$0.taskExecutor;
        if (iVar == null) {
            return null;
        }
        final FilamentAnimHelper filamentAnimHelper = this.this$0;
        final FilamentViewerV2 filamentViewerV2 = this.$viewer;
        iVar.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentAnimHelper$loadFemaleInitAnim$2.1
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
                com.tencent.filament.zplan.animation.b D;
                ZPlanAction zPlanAction2 = ZPlanAction.this;
                if (zPlanAction2 == null) {
                    QLog.e("FilamentAnimHelper_", 1, "loadFemaleInitAnim fail, ", objectRef.element);
                    return;
                }
                FilamentAnimHelper filamentAnimHelper2 = filamentAnimHelper;
                D = filamentAnimHelper2.D(filamentViewerV2, new ZPlanAction[]{zPlanAction2});
                filamentAnimHelper2.femaleInitAnim = D;
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentAnimHelper$loadFemaleInitAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
