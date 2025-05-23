package com.tencent.mobileqq.zplan.aigc.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ModelExtraInfo;", "", "previewTemplate", "", "hidePrimitives", "", "", "modelStyles", "Lcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;", "materials", "Lcom/tencent/mobileqq/zplan/aigc/render/Material;", "exportTemplate", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getExportTemplate", "()Ljava/lang/String;", "getHidePrimitives", "()Ljava/util/List;", "getMaterials", "getModelStyles", "getPreviewTemplate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ModelExtraInfo {
    private final String exportTemplate;
    private final List<Integer> hidePrimitives;
    private final List<Material> materials;
    private final List<ModelStyle> modelStyles;
    private final String previewTemplate;

    public ModelExtraInfo(String previewTemplate, List<Integer> hidePrimitives, List<ModelStyle> modelStyles, List<Material> materials, String exportTemplate) {
        Intrinsics.checkNotNullParameter(previewTemplate, "previewTemplate");
        Intrinsics.checkNotNullParameter(hidePrimitives, "hidePrimitives");
        Intrinsics.checkNotNullParameter(modelStyles, "modelStyles");
        Intrinsics.checkNotNullParameter(materials, "materials");
        Intrinsics.checkNotNullParameter(exportTemplate, "exportTemplate");
        this.previewTemplate = previewTemplate;
        this.hidePrimitives = hidePrimitives;
        this.modelStyles = modelStyles;
        this.materials = materials;
        this.exportTemplate = exportTemplate;
    }

    /* renamed from: component1, reason: from getter */
    public final String getPreviewTemplate() {
        return this.previewTemplate;
    }

    public final List<Integer> component2() {
        return this.hidePrimitives;
    }

    public final List<ModelStyle> component3() {
        return this.modelStyles;
    }

    public final List<Material> component4() {
        return this.materials;
    }

    /* renamed from: component5, reason: from getter */
    public final String getExportTemplate() {
        return this.exportTemplate;
    }

    public final ModelExtraInfo copy(String previewTemplate, List<Integer> hidePrimitives, List<ModelStyle> modelStyles, List<Material> materials, String exportTemplate) {
        Intrinsics.checkNotNullParameter(previewTemplate, "previewTemplate");
        Intrinsics.checkNotNullParameter(hidePrimitives, "hidePrimitives");
        Intrinsics.checkNotNullParameter(modelStyles, "modelStyles");
        Intrinsics.checkNotNullParameter(materials, "materials");
        Intrinsics.checkNotNullParameter(exportTemplate, "exportTemplate");
        return new ModelExtraInfo(previewTemplate, hidePrimitives, modelStyles, materials, exportTemplate);
    }

    public final String getExportTemplate() {
        return this.exportTemplate;
    }

    public final List<Integer> getHidePrimitives() {
        return this.hidePrimitives;
    }

    public final List<Material> getMaterials() {
        return this.materials;
    }

    public final List<ModelStyle> getModelStyles() {
        return this.modelStyles;
    }

    public final String getPreviewTemplate() {
        return this.previewTemplate;
    }

    public int hashCode() {
        return (((((((this.previewTemplate.hashCode() * 31) + this.hidePrimitives.hashCode()) * 31) + this.modelStyles.hashCode()) * 31) + this.materials.hashCode()) * 31) + this.exportTemplate.hashCode();
    }

    public String toString() {
        return "ModelExtraInfo(previewTemplate=" + this.previewTemplate + ", hidePrimitives=" + this.hidePrimitives + ", modelStyles=" + this.modelStyles + ", materials=" + this.materials + ", exportTemplate=" + this.exportTemplate + ")";
    }

    public static /* synthetic */ ModelExtraInfo copy$default(ModelExtraInfo modelExtraInfo, String str, List list, List list2, List list3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = modelExtraInfo.previewTemplate;
        }
        if ((i3 & 2) != 0) {
            list = modelExtraInfo.hidePrimitives;
        }
        List list4 = list;
        if ((i3 & 4) != 0) {
            list2 = modelExtraInfo.modelStyles;
        }
        List list5 = list2;
        if ((i3 & 8) != 0) {
            list3 = modelExtraInfo.materials;
        }
        List list6 = list3;
        if ((i3 & 16) != 0) {
            str2 = modelExtraInfo.exportTemplate;
        }
        return modelExtraInfo.copy(str, list4, list5, list6, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelExtraInfo)) {
            return false;
        }
        ModelExtraInfo modelExtraInfo = (ModelExtraInfo) other;
        return Intrinsics.areEqual(this.previewTemplate, modelExtraInfo.previewTemplate) && Intrinsics.areEqual(this.hidePrimitives, modelExtraInfo.hidePrimitives) && Intrinsics.areEqual(this.modelStyles, modelExtraInfo.modelStyles) && Intrinsics.areEqual(this.materials, modelExtraInfo.materials) && Intrinsics.areEqual(this.exportTemplate, modelExtraInfo.exportTemplate);
    }
}
