package com.tencent.mobileqq.guild.aisearch.models;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.SearchResponse;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/e;", "prevState", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "event", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "resp", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {
    @NotNull
    public static final ChatAnswerData a(@NotNull ChatAnswerData prevState, @NotNull q event, @NotNull SearchResponse resp) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(prevState, "prevState");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(resp, "resp");
        boolean z17 = event instanceof q.ReceiveContent;
        if (z17) {
            z16 = true;
        } else {
            z16 = event instanceof q.ReceiveReasonContent;
        }
        if (z16) {
            if (z17) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            return ChatAnswerData.c(prevState, i16, resp.getContent(), resp.getReasonContent(), 0L, 0L, SystemClock.uptimeMillis(), 24, null);
        }
        if (event instanceof q.Failed) {
            String reason = ((q.Failed) event).getReason();
            if (Intrinsics.areEqual(reason, "sensitive")) {
                i3 = 7;
            } else if (Intrinsics.areEqual(reason, "timeout")) {
                i3 = 8;
            } else {
                i3 = 6;
            }
            return ChatAnswerData.c(prevState, i3, null, null, 0L, 0L, 0L, 62, null);
        }
        if (event instanceof q.e) {
            return ChatAnswerData.c(prevState, 2, null, null, SystemClock.uptimeMillis(), 0L, 0L, 54, null);
        }
        if (event instanceof q.a) {
            return ChatAnswerData.c(prevState, 5, null, null, 0L, 0L, 0L, 62, null);
        }
        if (event instanceof q.c) {
            return ChatAnswerData.c(prevState, 3, null, null, 0L, SystemClock.uptimeMillis(), 0L, 46, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
