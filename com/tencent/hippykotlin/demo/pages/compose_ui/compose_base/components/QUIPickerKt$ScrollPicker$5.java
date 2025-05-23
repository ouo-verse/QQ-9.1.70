package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.MutableState;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.foundation.lazy.d;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$5", f = "QUIPicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QUIPickerKt$ScrollPicker$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $initialItem;
    public final /* synthetic */ MutableState<Boolean> $isInitialized;
    public final /* synthetic */ List<String> $itemList;
    public final /* synthetic */ ScrollPickerState $scrollPickerState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIPickerKt$ScrollPicker$5(ScrollPickerState scrollPickerState, int i3, MutableState<Boolean> mutableState, List<String> list, Continuation<? super QUIPickerKt$ScrollPicker$5> continuation) {
        super(2, continuation);
        this.$scrollPickerState = scrollPickerState;
        this.$initialItem = i3;
        this.$isInitialized = mutableState;
        this.$itemList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QUIPickerKt$ScrollPicker$5(this.$scrollPickerState, this.$initialItem, this.$isInitialized, this.$itemList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QUIPickerKt$ScrollPicker$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (this.$scrollPickerState.state.q(this.$initialItem) != null && !this.$isInitialized.getValue().booleanValue()) {
            final ScrollPickerState scrollPickerState = this.$scrollPickerState;
            final int i3 = this.$initialItem;
            TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$5.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    d.x(ScrollPickerState.this.state, i3, 0.0f, false, null, 14, null);
                    return Unit.INSTANCE;
                }
            });
            this.$scrollPickerState.centerValue = this.$itemList.get(this.$initialItem);
            this.$scrollPickerState.centerItemIndex = this.$initialItem;
            this.$isInitialized.setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
