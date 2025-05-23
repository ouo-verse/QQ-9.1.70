package of2;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.qqnt.kernel.nativeinterface.Picture;
import com.tencent.qqnt.kernel.nativeinterface.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/Picture;", "", "", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/Picture;)[Ljava/lang/Object;", "b", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/Picture;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bq {
    public static final Object[] a(Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.add("id");
        String id5 = picture.f359200id;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        arrayList.add(id5);
        arrayList.add(CoverDBCacheData.URLS);
        arrayList.add(Integer.valueOf(picture.urls.size()));
        ArrayList<URL> urls = picture.urls;
        Intrinsics.checkNotNullExpressionValue(urls, "urls");
        for (URL elem : urls) {
            Intrinsics.checkNotNullExpressionValue(elem, "elem");
            Object[] a16 = bx.a(elem);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add("localCachePath");
        String localCachePath = picture.localCachePath;
        Intrinsics.checkNotNullExpressionValue(localCachePath, "localCachePath");
        arrayList.add(localCachePath);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    public static final Picture b(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Picture picture = new Picture();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "id")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                picture.f359200id = (String) next2;
            } else if (Intrinsics.areEqual(next, CoverDBCacheData.URLS)) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) next3).intValue();
                ArrayList<URL> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < intValue; i3++) {
                    Object next4 = it.next();
                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next4).intValue();
                    Object[] objArr2 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr2[i16] = it.next();
                    }
                    arrayList.add(bx.b(objArr2));
                }
                picture.urls = arrayList;
            } else if (Intrinsics.areEqual(next, "localCachePath")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                picture.localCachePath = (String) next5;
            }
        }
        return picture;
    }
}
