package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPAvatarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPAvatarAttr.class, NodeProps.BORDER_WIDTH, "getBorderWidth()F", 0)};
    public String url = "";
    public String dressBorderUrl = "";
    public float size = 28.0f;
    public final ReadWriteProperty borderWidth$delegate = c.a(Float.valueOf(0.0f));
    public float imageRenderScale = 1.0f;

    public final float getBorderWidth() {
        return ((Number) this.borderWidth$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }
}
