package kotlinx.coroutines.flow;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001H\n"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes28.dex */
final class FlowKt__ZipKt$combine$6$1 extends Lambda implements Function0<Object[]> {
    final /* synthetic */ Flow<Object>[] $flowArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(Flow<Object>[] flowArr) {
        super(0);
        this.$flowArray = flowArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Object[] invoke() {
        int length = this.$flowArray.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[length];
    }
}
