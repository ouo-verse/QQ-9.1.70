package com.tencent.mobileqq.zplan.avatar.encoder;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/encoder/b;", "Lcom/tencent/mobileqq/zplan/avatar/encoder/ApolloVideoEncoder;", "", "frameIndex", "e", "", "", "src", "outputPath", "", "width", "height", "<init>", "(Ljava/util/List;Ljava/lang/String;II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends ApolloVideoEncoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<String> src, String outputPath, int i3, int i16) {
        super(src, outputPath, i3, i16);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
    }

    @Override // com.tencent.mobileqq.zplan.avatar.encoder.ApolloVideoEncoder
    protected long e(long frameIndex) {
        return 100 + ((frameIndex * 1000000) / this.f331671a);
    }
}
