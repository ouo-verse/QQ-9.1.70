package com.tencent.state.square.interaction.record;

import android.content.Context;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.interaction.InteractionRecordInfo;
import com.tencent.state.square.interaction.InteractionRecordList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "result", "Lcom/tencent/state/square/interaction/InteractionRecordList;", "code", "", "msg", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionRecordDialog$loadMore$1 extends Lambda implements Function3<InteractionRecordList, Integer, String, Unit> {
    final /* synthetic */ InteractionRecordDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionRecordDialog$loadMore$1(InteractionRecordDialog interactionRecordDialog) {
        super(3);
        this.this$0 = interactionRecordDialog;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(InteractionRecordList interactionRecordList, Integer num, String str) {
        invoke(interactionRecordList, num.intValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(final InteractionRecordList interactionRecordList, int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.this$0.isLoading = false;
        if (interactionRecordList != null && i3 == 0) {
            this.this$0.currentCursor = interactionRecordList.getCursorId();
            final ArrayList arrayList = new ArrayList();
            for (Object obj : interactionRecordList.getRecords()) {
                int i16 = r1 + 1;
                if (r1 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                this.this$0.transformData((InteractionRecordInfo) obj, new Function1<InteractionRecordData, Unit>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordDialog$loadMore$1$$special$$inlined$forEachIndexed$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(InteractionRecordData interactionRecordData) {
                        invoke2(interactionRecordData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(InteractionRecordData data) {
                        InteractionRecordAdapter interactionRecordAdapter;
                        List<? extends Object> transformList;
                        Intrinsics.checkNotNullParameter(data, "data");
                        arrayList.add(data);
                        if (interactionRecordList.getRecords().size() <= arrayList.size()) {
                            interactionRecordAdapter = InteractionRecordDialog$loadMore$1.this.this$0.adapter;
                            transformList = InteractionRecordDialog$loadMore$1.this.this$0.transformList(arrayList, Intrinsics.areEqual(interactionRecordList.getCursorId(), "0"));
                            interactionRecordAdapter.appendList(transformList);
                        }
                    }
                });
                r1 = i16;
            }
            return;
        }
        if ((msg2.length() > 0 ? 1 : 0) != 0) {
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            squareCommon.showToast(context, msg2, 1);
        }
        this.this$0.dismiss();
    }
}
