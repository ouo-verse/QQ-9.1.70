package com.tencent.mobileqq.wink.magicstudio;

import android.widget.TextView;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$initObserver$2", f = "MultiSelectFragment.kt", i = {}, l = {869}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MultiSelectFragment$initObserver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiSelectFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Pair<? extends Integer, ? extends MagicStudioButtonInfo>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MultiSelectFragment f323699d;

        public a(MultiSelectFragment multiSelectFragment) {
            this.f323699d = multiSelectFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends Integer, ? extends MagicStudioButtonInfo> pair, @NotNull Continuation<? super Unit> continuation) {
            boolean z16;
            String pageId;
            Integer num;
            WinkQZoneMagicStudioViewModel ai5;
            TextView Uh;
            Pair<? extends Integer, ? extends MagicStudioButtonInfo> pair2 = pair;
            int intValue = pair2.getFirst().intValue();
            MagicStudioButtonInfo second = pair2.getSecond();
            if (intValue != 3) {
                if (second != null) {
                    second.f(true);
                }
                this.f323699d.currentButtonInfo = second;
                if (second != null) {
                    Uh = this.f323699d.Uh();
                    Uh.setText(second.getSubtitleString());
                }
                this.f323699d.xi();
                if (intValue == 1) {
                    ai5 = this.f323699d.ai();
                    ai5.N1().postValue(second);
                }
                z16 = this.f323699d.needReportButtonExpose;
                if (z16) {
                    this.f323699d.needReportButtonExpose = false;
                    m83.b bVar = m83.b.f416442a;
                    pageId = this.f323699d.getPageId();
                    if (second != null) {
                        num = Boxing.boxInt(second.getActionType());
                    } else {
                        num = null;
                    }
                    bVar.g(pageId, num);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectFragment$initObserver$2(MultiSelectFragment multiSelectFragment, Continuation<? super MultiSelectFragment$initObserver$2> continuation) {
        super(2, continuation);
        this.this$0 = multiSelectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MultiSelectFragment$initObserver$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicStudioMultiViewModel gi5;
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
            gi5 = this.this$0.gi();
            SharedFlow<Pair<Integer, MagicStudioButtonInfo>> U1 = gi5.U1();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (U1.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MultiSelectFragment$initObserver$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
