package co1;

import com.tencent.richframework.data.idata.IDataDisplaySurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "", "a", "(Lcom/tencent/richframework/data/idata/IDataDisplaySurface;)Ljava/lang/String;", "surfaceKey", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {
    @Nullable
    public static final String a(@NotNull IDataDisplaySurface<?> iDataDisplaySurface) {
        h hVar;
        Intrinsics.checkNotNullParameter(iDataDisplaySurface, "<this>");
        if (iDataDisplaySurface instanceof h) {
            hVar = (h) iDataDisplaySurface;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            return null;
        }
        return hVar.getIdentifier();
    }
}
