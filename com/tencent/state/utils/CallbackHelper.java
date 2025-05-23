package com.tencent.state.utils;

import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.state.square.SquareBaseKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u000128\u0010\u0006\u001a4\u00120\u0012.\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u0002H\u0005`\t\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u0002H\u0005`\n0\u00072\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u00040\bH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/utils/CallbackHelper;", "", "()V", "batchExec", "", "T", Constants.Raft.TASKS, "", "Lkotlin/Function1;", "Lcom/tencent/state/utils/CallbackFun;", "Lcom/tencent/state/utils/TaskFun;", "onFinish", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CallbackHelper {
    public static final CallbackHelper INSTANCE = new CallbackHelper();

    CallbackHelper() {
    }

    public final /* synthetic */ <T> void batchExec(final List<? extends Function1<? super Function1<? super T, Unit>, Unit>> tasks, final Function1<? super List<? extends T>, Unit> onFinish) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: tasks.size=" + tasks.size());
        int size = tasks.size();
        Intrinsics.reifiedOperationMarker(0, "T?");
        final Object[] objArr = new Object[size];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        final int i3 = 0;
        for (T t16 : tasks) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((Function1) t16).invoke(new Function1<T, Unit>() { // from class: com.tencent.state.utils.CallbackHelper$batchExec$$inlined$forEachIndexed$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2((CallbackHelper$batchExec$$inlined$forEachIndexed$lambda$1<T>) obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(T t17) {
                    List list;
                    List filterNotNull;
                    synchronized (objArr) {
                        SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: task[" + i3 + "] finished");
                        objArr[i3] = t17;
                        Ref.IntRef intRef2 = intRef;
                        int i17 = intRef2.element + 1;
                        intRef2.element = i17;
                        if (i17 >= tasks.size()) {
                            SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: finished");
                            Function1 function1 = onFinish;
                            list = ArraysKt___ArraysKt.toList(objArr);
                            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
                            function1.invoke(filterNotNull);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
            i3 = i16;
        }
    }
}
