package com.tencent.state.square.message.box;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.utils.CallbackHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxDataProvider$initData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ MsgBoxDataProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxDataProvider$initData$1(MsgBoxDataProvider msgBoxDataProvider, Function1 function1) {
        super(0);
        this.this$0 = msgBoxDataProvider;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function1 recentRecordsTask;
        Function1 recentRecordsTask2;
        List mutableListOf;
        Function1 recentRecordsTask3;
        ArrayList arrayList = new ArrayList();
        recentRecordsTask = this.this$0.getRecentRecordsTask(MessageRecordType.RECORD_TYPE_FRIEND);
        recentRecordsTask2 = this.this$0.getRecentRecordsTask(MessageRecordType.RECORD_TYPE_TROOP);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(recentRecordsTask, recentRecordsTask2);
        boolean z16 = SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode();
        if (!z16) {
            recentRecordsTask3 = this.this$0.getRecentRecordsTask(MessageRecordType.RECORD_TYPE_SQUARE_TEMP);
            mutableListOf.add(recentRecordsTask3);
        }
        CallbackHelper callbackHelper = CallbackHelper.INSTANCE;
        SquareBaseKt.getSquareLog().d("CallbackHelper", "batchExec: tasks.size=" + mutableListOf.size());
        List[] listArr = new List[mutableListOf.size()];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        int i3 = 0;
        for (Object obj : mutableListOf) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((Function1) obj).invoke(new MsgBoxDataProvider$initData$1$$special$$inlined$batchExec$1(i3, listArr, intRef, mutableListOf, this, arrayList, z16));
            i3 = i16;
            arrayList = arrayList;
        }
    }
}
