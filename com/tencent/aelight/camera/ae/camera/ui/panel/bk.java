package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"", "", "a", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bq;", "c", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/br;", "b", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bk {
    public static final boolean a(Object obj) {
        if (obj instanceof DYAELocalMaterialItem) {
            if (((DYAELocalMaterialItem) obj).getPath().length() != 0) {
                return false;
            }
        } else {
            if (obj instanceof br) {
                return Intrinsics.areEqual(((br) obj).getId(), "0");
            }
            if (obj instanceof bp) {
                return ((bp) obj).getFilterItem().k();
            }
            if (obj instanceof ar) {
                if (((ar) obj).getBeautyConfig().getType() != BeautyItem.NONE.getType()) {
                    return false;
                }
            } else if (obj instanceof bu) {
                if (((bu) obj).getBeautyConfig().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String() != BeautyItem.NONE) {
                    return false;
                }
            } else {
                if (obj instanceof QIMFilterCategoryItem) {
                    return ((QIMFilterCategoryItem) obj).k();
                }
                if (obj instanceof b) {
                    if (((b) obj).getType() != BeautyItem.NONE.getType()) {
                        return false;
                    }
                } else if ((obj instanceof f) && ((f) obj).getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String() != BeautyItem.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final br b() {
        AEMaterialMetaData material = AEMaterialMetaData.MATERIAL_NONE;
        material.name = "\u65e0";
        material.cosmeticName = "\u65e0";
        material.usable = true;
        Intrinsics.checkNotNullExpressionValue(material, "material");
        return new br(material);
    }

    public static final DYAELocalMaterialItem c() {
        return new DYAELocalMaterialItem("cosmetic_none", "\u65e0", "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png", "");
    }
}
