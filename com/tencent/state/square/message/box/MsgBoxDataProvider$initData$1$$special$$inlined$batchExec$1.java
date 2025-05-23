package com.tencent.state.square.message.box;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V", "com/tencent/state/utils/CallbackHelper$batchExec$1$1", "com/tencent/state/square/message/box/MsgBoxDataProvider$initData$1$batchExec$$inlined$forEachIndexed$lambda$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1 extends Lambda implements Function1<List<? extends SquareBaseMessageRecord>, Unit> {
    final /* synthetic */ Ref.IntRef $finishedCount$inlined;
    final /* synthetic */ boolean $ignoreTemp$inlined;
    final /* synthetic */ int $index;
    final /* synthetic */ ArrayList $result$inlined;
    final /* synthetic */ Object[] $ret$inlined;
    final /* synthetic */ List $tasks$inlined;
    final /* synthetic */ MsgBoxDataProvider$initData$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1(int i3, Object[] objArr, Ref.IntRef intRef, List list, MsgBoxDataProvider$initData$1 msgBoxDataProvider$initData$1, ArrayList arrayList, boolean z16) {
        super(1);
        this.$index = i3;
        this.$ret$inlined = objArr;
        this.$finishedCount$inlined = intRef;
        this.$tasks$inlined = list;
        this.this$0 = msgBoxDataProvider$initData$1;
        this.$result$inlined = arrayList;
        this.$ignoreTemp$inlined = z16;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SquareBaseMessageRecord> list) {
        m253invoke(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m253invoke(List<? extends SquareBaseMessageRecord> list) {
        List list2;
        List filterNotNull;
        SquareMessageRecord squareMessageRecord;
        SquareMessageRecord squareMessageRecord2;
        MsgBoxContext msgBoxContext;
        boolean inFriendList;
        synchronized (this.$ret$inlined) {
            SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: task[" + this.$index + "] finished");
            this.$ret$inlined[this.$index] = list;
            Ref.IntRef intRef = this.$finishedCount$inlined;
            int i3 = intRef.element + 1;
            intRef.element = i3;
            if (i3 >= this.$tasks$inlined.size()) {
                SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: finished");
                list2 = ArraysKt___ArraysKt.toList(this.$ret$inlined);
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list2);
                List list3 = (List) filterNotNull.get(0);
                List list4 = (List) filterNotNull.get(1);
                this.$result$inlined.addAll(list3);
                this.$result$inlined.addAll(list4);
                if (!this.$ignoreTemp$inlined) {
                    Iterable iterable = (Iterable) filterNotNull.get(2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : iterable) {
                        inFriendList = this.this$0.this$0.inFriendList(list3, ((SquareBaseMessageRecord) obj).getUin());
                        if (!inFriendList) {
                            arrayList.add(obj);
                        }
                    }
                    this.$result$inlined.addAll(arrayList);
                }
                SquareBaseKt.getSquareLog().i("SquareMsgBoxDataProvider", "initData, " + this.$result$inlined.size() + ", ignoreTemp:" + this.$ignoreTemp$inlined);
                ArrayList arrayList2 = this.$result$inlined;
                if (arrayList2.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new Comparator<T>() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1$lambda$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SquareBaseMessageRecord) t17).getLastTimeStamp()), Long.valueOf(((SquareBaseMessageRecord) t16).getLastTimeStamp()));
                            return compareValues;
                        }
                    });
                }
                ArrayList arrayList3 = this.$result$inlined;
                squareMessageRecord = MsgBoxDataProvider.HEAD_ITEM;
                arrayList3.add(0, squareMessageRecord);
                ArrayList arrayList4 = this.$result$inlined;
                squareMessageRecord2 = MsgBoxDataProvider.TAIL_ITEM;
                arrayList4.add(squareMessageRecord2);
                msgBoxContext = this.this$0.this$0.msgBoxContext;
                msgBoxContext.runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1$lambda$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1 msgBoxDataProvider$initData$1$$special$$inlined$batchExec$1 = MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1.this;
                        msgBoxDataProvider$initData$1$$special$$inlined$batchExec$1.this$0.$callback.invoke(msgBoxDataProvider$initData$1$$special$$inlined$batchExec$1.$result$inlined);
                    }
                });
                this.this$0.$callback.invoke(this.$result$inlined);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
