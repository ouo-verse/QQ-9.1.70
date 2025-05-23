package jz1;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestionItem;", "", c.G, "", "answer", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    public static final void a(@NotNull GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem, int i3, @NotNull String answer) {
        Intrinsics.checkNotNullParameter(gWGProJoinGuildChoiceQuestionItem, "<this>");
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (gWGProJoinGuildChoiceQuestionItem.getAnswers().size() > i3) {
            gWGProJoinGuildChoiceQuestionItem.getAnswers().set(i3, answer);
            return;
        }
        int size = i3 - gWGProJoinGuildChoiceQuestionItem.getAnswers().size();
        for (int i16 = 0; i16 < size; i16++) {
            gWGProJoinGuildChoiceQuestionItem.getAnswers().add("");
        }
        gWGProJoinGuildChoiceQuestionItem.getAnswers().add(answer);
    }
}
