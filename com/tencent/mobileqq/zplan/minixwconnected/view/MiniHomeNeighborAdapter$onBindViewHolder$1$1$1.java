package com.tencent.mobileqq.zplan.minixwconnected.view;

import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import fi3.bm;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeNeighborAdapter$onBindViewHolder$1$1$1", f = "MiniHomeNeighborAdapter.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeNeighborAdapter$onBindViewHolder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x45.g $item;
    final /* synthetic */ bm $this_apply;
    int label;
    final /* synthetic */ MiniHomeNeighborAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeNeighborAdapter$onBindViewHolder$1$1$1(x45.g gVar, MiniHomeNeighborAdapter miniHomeNeighborAdapter, bm bmVar, Continuation<? super MiniHomeNeighborAdapter$onBindViewHolder$1$1$1> continuation) {
        super(2, continuation);
        this.$item = gVar;
        this.this$0 = miniHomeNeighborAdapter;
        this.$this_apply = bmVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeNeighborAdapter$onBindViewHolder$1$1$1(this.$item, this.this$0, this.$this_apply, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            long j3 = this.$item.f447206a;
            this.label = 1;
            obj = MiniHomeNetworkKt.i(j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final x45.f fVar = (x45.f) obj;
        final MiniHomeNeighborAdapter miniHomeNeighborAdapter = this.this$0;
        final x45.g gVar = this.$item;
        final bm bmVar = this.$this_apply;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeNeighborAdapter$onBindViewHolder$1$1$1.1
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
                CopyOnWriteArrayList copyOnWriteArrayList;
                x45.f fVar2 = x45.f.this;
                if (fVar2.f447203a == 0) {
                    copyOnWriteArrayList = miniHomeNeighborAdapter.inviteList;
                    copyOnWriteArrayList.add(Long.valueOf(gVar.f447206a));
                    bmVar.f399122c.setText("\u5df2\u53d1\u9001");
                    bmVar.f399122c.setClickable(false);
                    bmVar.f399122c.setPadding(0, 0, 0, 0);
                    bmVar.f399122c.setBackgroundDisabled();
                    QQToastUtil.showQQToast(2, "\u53d1\u9001\u6210\u529f");
                    return;
                }
                QQToastUtil.showQQToast(0, fVar2.f447204b);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeNeighborAdapter$onBindViewHolder$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
