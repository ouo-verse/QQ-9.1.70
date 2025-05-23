package com.facebook.yoga;

/* loaded from: classes2.dex */
public interface YogaProps {
    YogaAlign getAlignContent();

    YogaAlign getAlignItems();

    YogaAlign getAlignSelf();

    float getAspectRatio();

    float getBorder(YogaEdge yogaEdge);

    YogaValue getFlexBasis();

    YogaFlexDirection getFlexDirection();

    float getFlexGrow();

    float getFlexShrink();

    YogaValue getHeight();

    YogaJustify getJustifyContent();

    YogaValue getMargin(YogaEdge yogaEdge);

    YogaValue getMaxHeight();

    YogaValue getMaxWidth();

    YogaValue getMinHeight();

    YogaValue getMinWidth();

    YogaValue getPadding(YogaEdge yogaEdge);

    YogaValue getPosition(YogaEdge yogaEdge);

    YogaPositionType getPositionType();

    YogaDirection getStyleDirection();

    YogaValue getWidth();

    void setAlignContent(YogaAlign yogaAlign);

    void setAlignItems(YogaAlign yogaAlign);

    void setAlignSelf(YogaAlign yogaAlign);

    void setAspectRatio(float f16);

    void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    void setBorder(YogaEdge yogaEdge, float f16);

    void setDirection(YogaDirection yogaDirection);

    void setFlex(float f16);

    void setFlexBasis(float f16);

    void setFlexBasisAuto();

    void setFlexBasisPercent(float f16);

    void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    void setFlexGrow(float f16);

    void setFlexShrink(float f16);

    void setHeight(float f16);

    void setHeightAuto();

    void setHeightPercent(float f16);

    void setIsReferenceBaseline(boolean z16);

    void setJustifyContent(YogaJustify yogaJustify);

    void setMargin(YogaEdge yogaEdge, float f16);

    void setMarginAuto(YogaEdge yogaEdge);

    void setMarginPercent(YogaEdge yogaEdge, float f16);

    void setMaxHeight(float f16);

    void setMaxHeightPercent(float f16);

    void setMaxWidth(float f16);

    void setMaxWidthPercent(float f16);

    void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction);

    void setMinHeight(float f16);

    void setMinHeightPercent(float f16);

    void setMinWidth(float f16);

    void setMinWidthPercent(float f16);

    void setPadding(YogaEdge yogaEdge, float f16);

    void setPaddingPercent(YogaEdge yogaEdge, float f16);

    void setPosition(YogaEdge yogaEdge, float f16);

    void setPositionPercent(YogaEdge yogaEdge, float f16);

    void setPositionType(YogaPositionType yogaPositionType);

    void setWidth(float f16);

    void setWidthAuto();

    void setWidthPercent(float f16);

    void setWrap(YogaWrap yogaWrap);
}
