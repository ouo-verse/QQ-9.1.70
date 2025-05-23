package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public class Layer {

    @Nullable
    private final BlurEffect blurEffect;
    private final LottieComposition composition;

    @Nullable
    private final DropShadowEffect dropShadowEffect;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;

    @Nullable
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;

    @Nullable
    private final AnimatableTextFrame text;

    @Nullable
    private final AnimatableTextProperties textProperties;

    @Nullable
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j3, LayerType layerType, long j16, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i3, int i16, int i17, float f16, float f17, int i18, int i19, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, @Nullable AnimatableFloatValue animatableFloatValue, boolean z16, @Nullable BlurEffect blurEffect, @Nullable DropShadowEffect dropShadowEffect) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j3;
        this.layerType = layerType;
        this.parentId = j16;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i3;
        this.solidHeight = i16;
        this.solidColor = i17;
        this.timeStretch = f16;
        this.startFrame = f17;
        this.preCompWidth = i18;
        this.preCompHeight = i19;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z16;
        this.blurEffect = blurEffect;
        this.dropShadowEffect = dropShadowEffect;
    }

    @Nullable
    public BlurEffect getBlurEffect() {
        return this.blurEffect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieComposition getComposition() {
        return this.composition;
    }

    @Nullable
    public DropShadowEffect getDropShadowEffect() {
        return this.dropShadowEffect;
    }

    public long getId() {
        return this.layerId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> getMasks() {
        return this.masks;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType getMatteType() {
        return this.matteType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.layerName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getParentId() {
        return this.parentId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreCompHeight() {
        return this.preCompHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreCompWidth() {
        return this.preCompWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.refId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ContentModel> getShapes() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.solidColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidHeight() {
        return this.solidHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidWidth() {
        return this.solidWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextFrame getText() {
        return this.text;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getTimeStretch() {
        return this.timeStretch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(getName());
        sb5.append("\n");
        Layer layerModelForId = this.composition.layerModelForId(getParentId());
        if (layerModelForId != null) {
            sb5.append("\t\tParents: ");
            sb5.append(layerModelForId.getName());
            Layer layerModelForId2 = this.composition.layerModelForId(layerModelForId.getParentId());
            while (layerModelForId2 != null) {
                sb5.append("->");
                sb5.append(layerModelForId2.getName());
                layerModelForId2 = this.composition.layerModelForId(layerModelForId2.getParentId());
            }
            sb5.append(str);
            sb5.append("\n");
        }
        if (!getMasks().isEmpty()) {
            sb5.append(str);
            sb5.append("\tMasks: ");
            sb5.append(getMasks().size());
            sb5.append("\n");
        }
        if (getSolidWidth() != 0 && getSolidHeight() != 0) {
            sb5.append(str);
            sb5.append("\tBackground: ");
            sb5.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sb5.append(str);
            sb5.append("\tShapes:\n");
            for (ContentModel contentModel : this.shapes) {
                sb5.append(str);
                sb5.append("\t\t");
                sb5.append(contentModel);
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }
}
