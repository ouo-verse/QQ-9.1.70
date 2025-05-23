package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieBottomBubbleTipViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipViewAttr.class, "bubbleMaxWidth", "getBubbleMaxWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipViewAttr.class, "anchorX", "getAnchorX()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipViewAttr.class, "anchorY", "getAnchorY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipViewAttr.class, "bubbleTipMsg", "getBubbleTipMsg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipViewAttr.class, "enableClickOutSideDissmis", "getEnableClickOutSideDissmis()Z", 0)};
    public final ReadWriteProperty anchorX$delegate;
    public final ReadWriteProperty anchorY$delegate;
    public final ReadWriteProperty bubbleMaxWidth$delegate;
    public final ReadWriteProperty bubbleTipMsg$delegate;
    public int direction;
    public final ReadWriteProperty enableClickOutSideDissmis$delegate;

    public AdelieBottomBubbleTipViewAttr() {
        Float valueOf = Float.valueOf(0.0f);
        this.bubbleMaxWidth$delegate = c.a(valueOf);
        this.anchorX$delegate = c.a(valueOf);
        this.anchorY$delegate = c.a(valueOf);
        this.bubbleTipMsg$delegate = c.a("");
        this.enableClickOutSideDissmis$delegate = c.a(Boolean.TRUE);
        this.direction = 2;
    }

    public final float getAnchorX() {
        return ((Number) this.anchorX$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }
}
