package h00;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lh00/g;", "Lh00/a;", "Lh00/c;", "jumpFactor", "", "b", "<init>", "(Lh00/c;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c jumpFactor) {
        super(jumpFactor);
        Intrinsics.checkNotNullParameter(jumpFactor, "jumpFactor");
    }

    @Override // h00.a
    public boolean b(c jumpFactor) {
        Context context = jumpFactor != null ? jumpFactor.getContext() : null;
        if (context == null || !com.tencent.biz.pubaccount.weishi.util.a.c(context)) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.util.a.b(context);
        if (jumpFactor.d() != null) {
            jumpFactor.d().b();
        }
        i00.a.f406985a.a(jumpFactor.g().schema);
        return true;
    }
}
