package of2;

import com.tencent.qqnt.kernel.nativeinterface.DownloadOptionParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadOptionParams;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/DownloadOptionParams;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q {
    public static final DownloadOptionParams a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        DownloadOptionParams downloadOptionParams = new DownloadOptionParams();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "isIncludeCompressInnerFiles")) {
                Object next2 = it.next();
                if ((next2 instanceof byte[]) && ((byte[]) next2).length == 0) {
                    downloadOptionParams.isIncludeCompressInnerFiles = null;
                } else {
                    Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                    downloadOptionParams.isIncludeCompressInnerFiles = Boolean.valueOf(((Integer) next2).intValue() == 1);
                }
            } else if (Intrinsics.areEqual(next, "compressFolderOptionParamsFolderId")) {
                Object next3 = it.next();
                if ((next3 instanceof byte[]) && ((byte[]) next3).length == 0) {
                    downloadOptionParams.compressFolderOptionParamsFolderId = null;
                } else {
                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                    downloadOptionParams.compressFolderOptionParamsFolderId = (String) next3;
                }
            }
        }
        return downloadOptionParams;
    }
}
