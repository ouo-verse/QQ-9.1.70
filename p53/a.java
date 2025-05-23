package p53;

import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lp53/a;", "Lcom/tencent/biz/richframework/part/BlockPart;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "x9", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a extends BlockPart {
    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: x9, reason: merged with bridge method [inline-methods] */
    public BasePartFragment getHostFragment() {
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.part.BasePartFragment");
        return (BasePartFragment) partHost;
    }
}
