package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final Paint offScreenPaint;
    private final RectF offScreenRectF;
    private final Path path;

    @Nullable
    private List<PathContent> pathContents;
    private final RectF rect;

    @Nullable
    private TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), contentsFromModels(lottieDrawable, baseLayer, shapeGroup.getItems()), findTransform(shapeGroup.getItems()));
    }

    private static List<Content> contentsFromModels(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content content = list.get(i3).toContent(lottieDrawable, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    static AnimatableTransform findTransform(List<ContentModel> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            ContentModel contentModel = list.get(i3);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.contents.size(); i16++) {
            if ((this.contents.get(i16) instanceof DrawingContent) && (i3 = i3 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t16, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i3) {
        boolean z16;
        int intValue;
        if (this.hidden) {
            return;
        }
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
            if (this.transformAnimation.getOpacity() == null) {
                intValue = 100;
            } else {
                intValue = this.transformAnimation.getOpacity().getValue().intValue();
            }
            i3 = (int) ((((intValue / 100.0f) * i3) / 255.0f) * 255.0f);
        }
        if (this.lottieDrawable.isApplyingOpacityToLayersEnabled() && hasTwoOrMoreDrawableContent() && i3 != 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(this.offScreenRectF, this.matrix, true);
            this.offScreenPaint.setAlpha(i3);
            Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint);
        }
        if (z16) {
            i3 = 255;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).draw(canvas, this.matrix, i3);
            }
        }
        if (z16) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z16) {
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, z16);
                rectF.union(this.rect);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i3 = 0; i3 < this.contents.size(); i3++) {
                Content content = this.contents.get(i3);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2) {
        if (!keyPath.matches(getName(), i3) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            keyPath2 = keyPath2.addKey(getName());
            if (keyPath.fullyResolvesTo(getName(), i3)) {
                list.add(keyPath2.resolve(this));
            }
        }
        if (keyPath.propagateToChildren(getName(), i3)) {
            int incrementDepthBy = i3 + keyPath.incrementDepthBy(getName(), i3);
            for (int i16 = 0; i16 < this.contents.size(); i16++) {
                Content content = this.contents.get(i16);
                if (content instanceof KeyPathElement) {
                    ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            content.setContents(arrayList, this.contents.subList(0, size));
            arrayList.add(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z16, List<Content> list, @Nullable AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable;
        this.hidden = z16;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.transformAnimation = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
