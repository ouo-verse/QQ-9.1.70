package com.tencent.mobileqq.wink.editor.crop.model;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.wink.editor.crop.viewmodel.WinkEditorCropViewModel;
import com.tencent.mobileqq.wink.editor.d;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/model/WinkCropUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "isImage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/wink/editor/crop/model/SerializableCropInfo;", "getSerializableCropInfoMap", "Lcom/tencent/mobileqq/wink/editor/crop/viewmodel/WinkEditorCropViewModel$CropInfo;", "cropInfo", "translateCropInfo", "serializableCropInfo", "translateSerializableCropInfo", "", "updateInner", "id", "storeCropInfo", "", "getCropInfoMap", "cropImageInfoByID", "Ljava/util/concurrent/ConcurrentHashMap;", "cropVideoInfoByID", "Lcom/tencent/mobileqq/wink/editor/d;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/d;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCropUIData extends WinkEditUIData {
    private static final long serialVersionUID = -3070529545084719057L;

    @NotNull
    private final ConcurrentHashMap<String, SerializableCropInfo> cropImageInfoByID;

    @NotNull
    private final ConcurrentHashMap<String, SerializableCropInfo> cropVideoInfoByID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkCropUIData(@NotNull d part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
        this.cropImageInfoByID = new ConcurrentHashMap<>();
        this.cropVideoInfoByID = new ConcurrentHashMap<>();
    }

    private final ConcurrentHashMap<String, SerializableCropInfo> getSerializableCropInfoMap(boolean isImage) {
        if (isImage) {
            return this.cropImageInfoByID;
        }
        return this.cropVideoInfoByID;
    }

    private final SerializableCropInfo translateCropInfo(WinkEditorCropViewModel.CropInfo cropInfo) {
        float[] fArr = new float[9];
        cropInfo.getMatrix().getValues(fArr);
        return new SerializableCropInfo(fArr, cropInfo.getRatioType(), cropInfo.getRotateDegree(), cropInfo.getCropRect().top, cropInfo.getCropRect().bottom, cropInfo.getCropRect().right, cropInfo.getCropRect().left, cropInfo.isRotate90(), cropInfo.isEmpty());
    }

    private final WinkEditorCropViewModel.CropInfo translateSerializableCropInfo(SerializableCropInfo serializableCropInfo) {
        Matrix matrix = new Matrix();
        matrix.setValues(serializableCropInfo.getMatrixValues());
        return new WinkEditorCropViewModel.CropInfo(matrix, serializableCropInfo.getRatioType(), serializableCropInfo.getRotateDegree(), new RectF(serializableCropInfo.getCropRectLeft(), serializableCropInfo.getCropRectTop(), serializableCropInfo.getCropRectRight(), serializableCropInfo.getCropRectBottom()), serializableCropInfo.isRotate90(), serializableCropInfo.isEmpty());
    }

    @NotNull
    public final Map<String, WinkEditorCropViewModel.CropInfo> getCropInfoMap(boolean isImage) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isImage) {
            for (Map.Entry<String, SerializableCropInfo> entry : this.cropImageInfoByID.entrySet()) {
                linkedHashMap.put(entry.getKey(), translateSerializableCropInfo(entry.getValue()));
            }
        } else {
            for (Map.Entry<String, SerializableCropInfo> entry2 : this.cropVideoInfoByID.entrySet()) {
                linkedHashMap.put(entry2.getKey(), translateSerializableCropInfo(entry2.getValue()));
            }
        }
        return linkedHashMap;
    }

    public final void storeCropInfo(boolean isImage, @NotNull String id5, @NotNull WinkEditorCropViewModel.CropInfo cropInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(cropInfo, "cropInfo");
        if (id5.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        getSerializableCropInfoMap(isImage).put(id5, translateCropInfo(cropInfo));
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
