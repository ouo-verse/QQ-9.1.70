package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ShapeLayer extends BaseLayer {
    private final CompositionLayer compositionLayer;
    private final ContentGroup contentGroup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer) {
        super(lottieDrawable, layer);
        this.compositionLayer = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes(), false));
        this.contentGroup = contentGroup;
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(@NonNull Canvas canvas, Matrix matrix, int i3) {
        this.contentGroup.draw(canvas, matrix, i3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public BlurEffect getBlurEffect() {
        BlurEffect blurEffect = super.getBlurEffect();
        if (blurEffect != null) {
            return blurEffect;
        }
        return this.compositionLayer.getBlurEffect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z16) {
        super.getBounds(rectF, matrix, z16);
        this.contentGroup.getBounds(rectF, this.boundsMatrix, z16);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    @Nullable
    public DropShadowEffect getDropShadowEffect() {
        DropShadowEffect dropShadowEffect = super.getDropShadowEffect();
        if (dropShadowEffect != null) {
            return dropShadowEffect;
        }
        return this.compositionLayer.getDropShadowEffect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void resolveChildKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i3, list, keyPath2);
    }
}
