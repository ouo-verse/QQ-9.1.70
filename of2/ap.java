package of2;

import com.tencent.qqnt.kernel.nativeinterface.CompressedFileFolderReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSceneType;
import com.tencent.qqnt.kernel.nativeinterface.GetCompressedFileFolderReq;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCompressedFileFolderReq;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/GetCompressedFileFolderReq;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ap {
    public static final GetCompressedFileFolderReq a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        GetCompressedFileFolderReq getCompressedFileFolderReq = new GetCompressedFileFolderReq();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "seq")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                getCompressedFileFolderReq.seq = ((Integer) next2).intValue();
            } else if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                getCompressedFileFolderReq.fileSetId = (String) next3;
            } else if (Intrinsics.areEqual(next, "cliFileId")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                getCompressedFileFolderReq.cliFileId = (String) next4;
            } else if (Intrinsics.areEqual(next, "srvFileId")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                getCompressedFileFolderReq.srvFileId = (String) next5;
            } else if (Intrinsics.areEqual(next, "reqInfos")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next6).intValue();
                ArrayList<CompressedFileFolderReqInfo> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next7).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    arrayList.add(k.a(objArr2));
                }
                getCompressedFileFolderReq.reqInfos = arrayList;
            } else if (Intrinsics.areEqual(next, "sceneType")) {
                FlashTransferSceneType[] values = FlashTransferSceneType.values();
                Object next8 = it.next();
                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                getCompressedFileFolderReq.sceneType = values[((Integer) next8).intValue()];
            } else if (Intrinsics.areEqual(next, "isUseCache")) {
                Object next9 = it.next();
                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                getCompressedFileFolderReq.isUseCache = ((Integer) next9).intValue() == 1;
            }
        }
        return getCompressedFileFolderReq;
    }
}
