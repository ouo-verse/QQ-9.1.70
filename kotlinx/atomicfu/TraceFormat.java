package kotlinx.atomicfu;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0017\u00a8\u0006\b"}, d2 = {"Lkotlinx/atomicfu/TraceFormat;", "", "()V", "format", "", "index", "", "event", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public class TraceFormat {
    @NotNull
    public String format(int index, @NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return index + MsgSummary.STR_COLON + event;
    }
}
