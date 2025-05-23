package com.tencent.state.square.holder;

import android.view.View;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareAvatarItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/state/square/holder/AvatarViewHolder$onZoomOverOut$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.holder.AvatarViewHolder$onZoomOverOut$1$1", f = "AvatarViewHolder.kt", i = {}, l = {gdt_analysis_event.EVENT_GET_VERSION_CODENAME}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SquareAvatarItem $it;
    int label;
    final /* synthetic */ AvatarViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/state/square/holder/AvatarViewHolder$onZoomOverOut$1$1$1"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.state.square.holder.AvatarViewHolder$onZoomOverOut$1$1$1", f = "AvatarViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.state.square.holder.AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map $reportParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Map map, Continuation continuation) {
            super(2, continuation);
            this.$reportParams = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(this.$reportParams, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IReporter iReporter;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                iReporter = AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1.this.this$0.reporter;
                Map<String, Object> map = this.$reportParams;
                View itemView = AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1.this.this$0.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                map.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(itemView.getContext()));
                Unit unit = Unit.INSTANCE;
                iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DOUBLE_FINGER, map);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1(SquareAvatarItem squareAvatarItem, Continuation continuation, AvatarViewHolder avatarViewHolder) {
        super(2, continuation);
        this.$it = squareAvatarItem;
        this.this$0 = avatarViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1(this.$it, completion, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AvatarViewHolder$onZoomOverOut$$inlined$let$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AvatarViewHolder avatarViewHolder = this.this$0;
            SquareAvatarItem squareAvatarItem = this.$it;
            this.label = 1;
            obj = avatarViewHolder.getAvatarIconReportParams(squareAvatarItem, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1((Map) obj, null), 3, null);
        return Unit.INSTANCE;
    }
}
