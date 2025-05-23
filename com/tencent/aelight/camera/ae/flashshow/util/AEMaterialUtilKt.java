package com.tencent.aelight.camera.ae.flashshow.util;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007\u001a\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007\u001a \u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0010"}, d2 = {"", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialCategory;", "categories", "", "takeSameMaterialId", "filterName", "f", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", QQCustomArkDialogUtil.META_DATA, "", "d", "id", "b", "category", "c", "a", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEMaterialUtilKt {
    public static final AEMaterialCategory a(String id5, List<? extends AEMaterialCategory> categories) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(categories, "categories");
        for (AEMaterialCategory aEMaterialCategory : categories) {
            if (Intrinsics.areEqual(id5, String.valueOf(aEMaterialCategory.f69045e))) {
                return aEMaterialCategory;
            }
        }
        return null;
    }

    public static final AEMaterialMetaData b(String str, List<? extends AEMaterialCategory> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<? extends AEMaterialCategory> it = categories.iterator();
        while (it.hasNext()) {
            AEMaterialMetaData c16 = c(str, it.next());
            if (c16 != null) {
                return c16;
            }
        }
        return null;
    }

    public static final AEMaterialMetaData c(String str, AEMaterialCategory category) {
        List<AEMaterialMetaData> list;
        Intrinsics.checkNotNullParameter(category, "category");
        if (!TextUtils.isEmpty(str) && (list = category.f69044d) != null) {
            for (AEMaterialMetaData aEMaterialMetaData : list) {
                if (TextUtils.equals(str, aEMaterialMetaData.f69050id)) {
                    return aEMaterialMetaData;
                }
            }
        }
        return null;
    }

    public static final int d(AEMaterialMetaData metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        return AECameraPrefsUtil.f().d().getInt("makeup_strength_prefix_" + metaData.f69050id, 100);
    }

    public static final List<AEMaterialCategory> f(List<? extends AEMaterialCategory> list, final String str, String filterName) {
        List<AEMaterialCategory> emptyList;
        Intrinsics.checkNotNullParameter(filterName, "filterName");
        List<? extends AEMaterialCategory> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (AEMaterialCategory aEMaterialCategory : list) {
            if (!(filterName.length() > 0) || Intrinsics.areEqual(filterName, aEMaterialCategory.f69047h)) {
                AEMaterialCategory clone = aEMaterialCategory.clone();
                Intrinsics.checkNotNullExpressionValue(clone, "it.clone()");
                List<AEMaterialMetaData> list3 = clone.f69044d;
                Intrinsics.checkNotNullExpressionValue(list3, "clone.materialList");
                CollectionsKt__MutableCollectionsKt.removeAll((List) list3, (Function1) new Function1<AEMaterialMetaData, Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.util.AEMaterialUtilKt$removeHiddenButTakeSameMaterials$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AEMaterialMetaData aEMaterialMetaData) {
                        return Boolean.valueOf(aEMaterialMetaData == null || (Intrinsics.areEqual(aEMaterialMetaData.activityHidden, "1") && !Intrinsics.areEqual(aEMaterialMetaData.f69050id, str)));
                    }
                });
                arrayList.add(clone);
            }
        }
        return arrayList;
    }

    public static final List<AEMaterialCategory> e(List<? extends AEMaterialCategory> list, String str) {
        return g(list, str, null, 4, null);
    }

    public static /* synthetic */ List g(List list, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return f(list, str, str2);
    }
}
