package com.tencent.ams.mosaic.jsengine.animation.layer;

import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface Layer extends Component {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface MaskType {
        public static final int IN = 1;
        public static final int OUT = 2;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @JSMethod
    void addAnimation(Animation animation);

    @JSMethod
    float getAnchorPointX();

    @JSMethod
    float getAnchorPointY();

    Animation getAnimation();

    AnimatorLayer getAnimatorLayer();

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @JSMethod
    void removeAnimation();

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @JSMethod
    void setAnchorPoint(float f16, float f17);

    @JSMethod
    void setMaskLayer(ShapeLayer shapeLayer, @MaskType int i3);
}
