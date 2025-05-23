package com.tencent.mobileqq.vas.api.impl;

import com.tencent.state.square.IZPlanRecorder;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.UserIdentifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.api.impl.VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1", f = "VasSquareApiImpl.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Resource $resource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1(Resource resource, Continuation<? super VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1> continuation) {
        super(1, continuation);
        this.$resource = resource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1(this.$resource, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        r15 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.state.square.record.UserIdentifier(java.lang.String.valueOf(r1.longValue()), null, 2, null));
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
            Long toUin = this.$resource.getFilament().getToUin();
            IZPlanRecorder recorder = Square.INSTANCE.getConfig().getRecorder();
            Resource resource = this.$resource;
            UserIdentifier userIdentifier = new UserIdentifier(currentAccountUin, null, 2, null);
            if (toUin == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            RecordIdentifier recordIdentifier = new RecordIdentifier(userIdentifier, emptyList, 0, RecordType.FILAMENT_SQUARE, true, 4, null);
            this.label = 1;
            if (recorder.recordAvatarActions(resource, recordIdentifier, true, true, (Continuation<? super Boolean>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
