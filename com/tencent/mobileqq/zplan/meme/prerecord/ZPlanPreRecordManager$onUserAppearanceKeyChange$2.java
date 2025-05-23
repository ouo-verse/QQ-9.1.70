package com.tencent.mobileqq.zplan.meme.prerecord;

import com.tencent.mobileqq.zootopia.Source;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager$onUserAppearanceKeyChange$2", f = "ZPlanPreRecordManager.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanPreRecordManager$onUserAppearanceKeyChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Source $portalSource;
    final /* synthetic */ List<String> $uinList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPreRecordManager$onUserAppearanceKeyChange$2(Source source, List<String> list, Continuation<? super ZPlanPreRecordManager$onUserAppearanceKeyChange$2> continuation) {
        super(2, continuation);
        this.$portalSource = source;
        this.$uinList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanPreRecordManager$onUserAppearanceKeyChange$2(this.$portalSource, this.$uinList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object e16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanPreRecordManager zPlanPreRecordManager = ZPlanPreRecordManager.f334206e;
            Source source = this.$portalSource;
            List<String> list = this.$uinList;
            this.label = 1;
            e16 = zPlanPreRecordManager.e(source, list, this);
            if (e16 == coroutine_suspended) {
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
        return ((ZPlanPreRecordManager$onUserAppearanceKeyChange$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
