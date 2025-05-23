package of2;

import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.Permission;
import com.tencent.qqnt.kernel.nativeinterface.Picture;
import com.tencent.qqnt.kernel.nativeinterface.Uploader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileSetSimpleInfo;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileSetSimpleInfo;)[Ljava/lang/Object;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class x {
    public static final Object[] a(FileSetSimpleInfo fileSetSimpleInfo) {
        Intrinsics.checkNotNullParameter(fileSetSimpleInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        String fileSetId = fileSetSimpleInfo.fileSetId;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        arrayList.add(fileSetId);
        arrayList.add("name");
        String name = fileSetSimpleInfo.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        arrayList.add(name);
        arrayList.add("totalFileCount");
        arrayList.add(String.valueOf(fileSetSimpleInfo.totalFileCount));
        arrayList.add("totalFileSize");
        arrayList.add(String.valueOf(fileSetSimpleInfo.totalFileSize));
        arrayList.add(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        Permission permission = fileSetSimpleInfo.permission;
        Intrinsics.checkNotNullExpressionValue(permission, "permission");
        Object[] a16 = bo.a(permission);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add("cover");
        Picture cover = fileSetSimpleInfo.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        Object[] a17 = bq.a(cover);
        arrayList.add(Integer.valueOf(a17.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a17);
        arrayList.add("uploaders");
        arrayList.add(Integer.valueOf(fileSetSimpleInfo.uploaders.size()));
        ArrayList<Uploader> uploaders = fileSetSimpleInfo.uploaders;
        Intrinsics.checkNotNullExpressionValue(uploaders, "uploaders");
        for (Uploader elem : uploaders) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a18 = cb.a(elem);
            arrayList.add(Integer.valueOf(a18.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a18);
        }
        arrayList.add("expireLeftTime");
        arrayList.add(String.valueOf(fileSetSimpleInfo.expireLeftTime));
        arrayList.add("transferType");
        arrayList.add(Integer.valueOf(fileSetSimpleInfo.transferType.ordinal()));
        arrayList.add("isLocalCreate");
        arrayList.add(Integer.valueOf(fileSetSimpleInfo.isLocalCreate ? 1 : 0));
        arrayList.add("localCoverPath");
        String localCoverPath = fileSetSimpleInfo.localCoverPath;
        Intrinsics.checkNotNullExpressionValue(localCoverPath, "localCoverPath");
        arrayList.add(localCoverPath);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
