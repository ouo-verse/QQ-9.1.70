package com.tencent.mobileqq.wink.editor.templatecoll;

import android.graphics.Matrix;
import android.graphics.RectF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.crop.model.SerializableCropInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.templatecoll.ah;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00016B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\rR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011RL\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019RL\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R(\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010*\u001a\u0004\u0018\u00010%2\b\u0010\u0015\u001a\u0004\u0018\u00010%8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u00100\u001a\u0004\u0018\u00010+2\b\u0010\u0015\u001a\u0004\u0018\u00010+8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/TemplateCollClippingUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "Lcom/tencent/mobileqq/wink/editor/templatecoll/ah$b;", "cropInfo", "Lcom/tencent/mobileqq/wink/editor/crop/model/SerializableCropInfo;", "translateCropInfo", "serializableCropInfo", "translateSerializableCropInfo", "", "updateInner", "", "resourceID", "storeCropInfo", "", "getCropInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "cropInfoByResourceID", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "Lkotlin/collections/ArrayList;", "value", "getHolderInfo", "()Ljava/util/ArrayList;", "setHolderInfo", "(Ljava/util/ArrayList;)V", "holderInfo", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getOriginMediaInfo", "setOriginMediaInfo", "originMediaInfo", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getTemplateLibraryMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setTemplateLibraryMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "templateLibraryMaterial", "Lcom/tencent/mobileqq/wink/picker/TabType;", "getPickerTabType", "()Lcom/tencent/mobileqq/wink/picker/TabType;", "setPickerTabType", "(Lcom/tencent/mobileqq/wink/picker/TabType;)V", "pickerTabType", "", "getNeedFaceDetect", "()Ljava/lang/Boolean;", "setNeedFaceDetect", "(Ljava/lang/Boolean;)V", "needFaceDetect", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClippingMenuPart;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClippingMenuPart;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TemplateCollClippingUIData extends WinkEditUIData {
    private static final long serialVersionUID = -7127894083628899268L;

    @Nullable
    private ConcurrentHashMap<String, SerializableCropInfo> cropInfoByResourceID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateCollClippingUIData(@NotNull WinkEditorTemplateCollClippingMenuPart part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    private final SerializableCropInfo translateCropInfo(ah.CropInfo cropInfo) {
        float[] fArr = new float[9];
        cropInfo.getCropViewMatrix().getValues(fArr);
        float f16 = cropInfo.getCropViewCropRect().left;
        return new SerializableCropInfo(fArr, null, 0.0f, cropInfo.getCropViewCropRect().top, cropInfo.getCropViewCropRect().bottom, cropInfo.getCropViewCropRect().right, f16, false, false, 390, null);
    }

    private final ah.CropInfo translateSerializableCropInfo(SerializableCropInfo serializableCropInfo) {
        Matrix matrix = new Matrix();
        matrix.setValues(serializableCropInfo.getMatrixValues());
        return new ah.CropInfo(matrix, new RectF(serializableCropInfo.getCropRectLeft(), serializableCropInfo.getCropRectTop(), serializableCropInfo.getCropRectRight(), serializableCropInfo.getCropRectBottom()), null, 4, null);
    }

    @NotNull
    public final Map<String, ah.CropInfo> getCropInfoMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConcurrentHashMap<String, SerializableCropInfo> concurrentHashMap = this.cropInfoByResourceID;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, SerializableCropInfo> entry : concurrentHashMap.entrySet()) {
                linkedHashMap.put(entry.getKey(), translateSerializableCropInfo(entry.getValue()));
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final ArrayList<TemplateLibraryHolderInfo> getHolderInfo() {
        Serializable serializable = getSerializable("template_holder_slot", null);
        if (!(serializable instanceof ArrayList)) {
            return null;
        }
        return (ArrayList) serializable;
    }

    @Nullable
    public final Boolean getNeedFaceDetect() {
        Serializable serializable = getSerializable(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, null);
        if (!(serializable instanceof Boolean)) {
            return null;
        }
        return (Boolean) serializable;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> getOriginMediaInfo() {
        Serializable serializable = getSerializable(QQWinkConstants.INPUT_MEDIA_ORIGINAL, null);
        if (!(serializable instanceof ArrayList)) {
            return null;
        }
        return (ArrayList) serializable;
    }

    @Nullable
    public final TabType getPickerTabType() {
        Serializable serializable = getSerializable(QQWinkConstants.MEDIA_PICKER_TAB_TYPE, null);
        if (!(serializable instanceof TabType)) {
            return null;
        }
        return (TabType) serializable;
    }

    @Nullable
    public final MetaMaterial getTemplateLibraryMaterial() {
        Serializable serializable = getSerializable(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, null);
        if (!(serializable instanceof MetaMaterial)) {
            return null;
        }
        return (MetaMaterial) serializable;
    }

    public final void setHolderInfo(@Nullable ArrayList<TemplateLibraryHolderInfo> arrayList) {
        putSerializable("template_holder_slot", arrayList);
    }

    public final void setNeedFaceDetect(@Nullable Boolean bool) {
        putSerializable(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, bool);
    }

    public final void setOriginMediaInfo(@Nullable ArrayList<LocalMediaInfo> arrayList) {
        putSerializable(QQWinkConstants.INPUT_MEDIA_ORIGINAL, arrayList);
    }

    public final void setPickerTabType(@Nullable TabType tabType) {
        putSerializable(QQWinkConstants.MEDIA_PICKER_TAB_TYPE, tabType);
    }

    public final void setTemplateLibraryMaterial(@Nullable MetaMaterial metaMaterial) {
        putSerializable(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, metaMaterial);
    }

    public final void storeCropInfo(@NotNull String resourceID, @NotNull ah.CropInfo cropInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(resourceID, "resourceID");
        Intrinsics.checkNotNullParameter(cropInfo, "cropInfo");
        if (resourceID.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (this.cropInfoByResourceID == null) {
            this.cropInfoByResourceID = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, SerializableCropInfo> concurrentHashMap = this.cropInfoByResourceID;
        Intrinsics.checkNotNull(concurrentHashMap);
        concurrentHashMap.put(resourceID, translateCropInfo(cropInfo));
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
