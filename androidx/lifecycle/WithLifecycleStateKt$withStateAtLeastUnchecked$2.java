package androidx.lifecycle;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", BdhLogUtil.LogTag.Tag_Req, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2<R> extends Lambda implements Function0<R> {
    final /* synthetic */ Function0 $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(Function0 function0) {
        super(0);
        this.$block = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final R invoke() {
        return (R) this.$block.invoke();
    }
}
