package com.tencent.mobileqq.guild.aisearch.models.operators;

import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a&\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a&\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "Lkotlinx/coroutines/flow/Flow;", "c", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/c;", "emitStatus", "prevData", "data", "", "b", "", "result", "", "d", "e", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class InterpolateEmitKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ChatAnswerData> b(EmitStatus emitStatus, ChatAnswerData chatAnswerData, ChatAnswerData chatAnswerData2) {
        List<ChatAnswerData> emptyList;
        if (chatAnswerData == null || (emitStatus.getHasEmitFirstReason() && emitStatus.getHasEmitFirstContent())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int state = chatAnswerData2.getState();
        boolean z16 = false;
        if (state != 2) {
            if (state != 4) {
                if (state == 5) {
                    e(emitStatus, arrayList, chatAnswerData2);
                    d(emitStatus, arrayList, chatAnswerData2);
                }
            } else {
                if (chatAnswerData2.getContent().length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    emitStatus.c(true);
                }
                e(emitStatus, arrayList, chatAnswerData2);
                d(emitStatus, arrayList, chatAnswerData2);
            }
        } else {
            if (chatAnswerData2.getReasonContent().length() == 0) {
                z16 = true;
            }
            if (z16) {
                emitStatus.d(true);
            }
            e(emitStatus, arrayList, chatAnswerData2);
        }
        return arrayList;
    }

    @NotNull
    public static final Flow<ChatAnswerData> c(@NotNull StateFlow<ChatAnswerData> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        return FlowKt.flow(new InterpolateEmitKt$interpolateEmit$$inlined$transform$1(stateFlow, null, new EmitStatus(false, false, 3, null), new Ref.ObjectRef()));
    }

    private static final void d(EmitStatus emitStatus, List<ChatAnswerData> list, ChatAnswerData chatAnswerData) {
        if (!emitStatus.getHasEmitFirstContent()) {
            list.add(ChatAnswerData.c(chatAnswerData, 4, "", null, 0L, 0L, 0L, 60, null));
            emitStatus.c(true);
        }
    }

    private static final void e(EmitStatus emitStatus, List<ChatAnswerData> list, ChatAnswerData chatAnswerData) {
        if (!emitStatus.getHasEmitFirstReason()) {
            list.add(ChatAnswerData.c(chatAnswerData, 2, "", "", 0L, 0L, 0L, 56, null));
            emitStatus.d(true);
        }
    }
}
