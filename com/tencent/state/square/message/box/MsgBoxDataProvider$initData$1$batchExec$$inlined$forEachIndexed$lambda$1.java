package com.tencent.state.square.message.box;

import com.tencent.state.square.SquareBaseKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V", "com/tencent/state/utils/CallbackHelper$batchExec$1$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxDataProvider$initData$1$batchExec$$inlined$forEachIndexed$lambda$1<T> extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ int $index;
    final /* synthetic */ Function1 $onFinish$inlined;
    final /* synthetic */ Object[] $ret$inlined;
    final /* synthetic */ List $tasks$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxDataProvider$initData$1$batchExec$$inlined$forEachIndexed$lambda$1(int i3, Object[] objArr, Ref.IntRef intRef, List list, Function1 function1) {
        super(1);
        this.$index = i3;
        this.$ret$inlined = objArr;
        this.$finishedCount$inlined = intRef;
        this.$tasks$inlined = list;
        this.$onFinish$inlined = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2((MsgBoxDataProvider$initData$1$batchExec$$inlined$forEachIndexed$lambda$1<T>) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t16) {
        List list;
        List filterNotNull;
        synchronized (this.$ret$inlined) {
            SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: task[" + this.$index + "] finished");
            this.$ret$inlined[this.$index] = t16;
            Ref.IntRef intRef = this.$finishedCount$inlined;
            int i3 = intRef.element + 1;
            intRef.element = i3;
            if (i3 >= this.$tasks$inlined.size()) {
                SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: finished");
                Function1 function1 = this.$onFinish$inlined;
                list = ArraysKt___ArraysKt.toList(this.$ret$inlined);
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
                function1.invoke(filterNotNull);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
