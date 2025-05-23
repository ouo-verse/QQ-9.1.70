package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    private List<ShapeModifierContent> shapeModifiers;
    private final Path tempPath;
    private final ShapeData tempShapeData;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.tempShapeData = new ShapeData();
        this.tempPath = new Path();
    }

    public void setShapeModifiers(@Nullable List<ShapeModifierContent> list) {
        this.shapeModifiers = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public Path getValue(Keyframe<ShapeData> keyframe, float f16) {
        this.tempShapeData.interpolateBetween(keyframe.startValue, keyframe.endValue, f16);
        ShapeData shapeData = this.tempShapeData;
        List<ShapeModifierContent> list = this.shapeModifiers;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                shapeData = this.shapeModifiers.get(size).modifyShape(shapeData);
            }
        }
        MiscUtils.getPathFromData(shapeData, this.tempPath);
        return this.tempPath;
    }
}
