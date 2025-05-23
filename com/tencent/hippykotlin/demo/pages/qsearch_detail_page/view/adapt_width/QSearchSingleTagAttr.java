package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.base.k;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleTagAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchSingleTagAttr.class, NodeProps.MAX_WIDTH, "getMaxWidth()F", 0)};
    public SearchNetLabel label;
    public final ReadWriteProperty maxWidth$delegate = c.a(Float.valueOf(0.0f));

    public final SearchNetLabel getLabel() {
        SearchNetLabel searchNetLabel = this.label;
        if (searchNetLabel != null) {
            return searchNetLabel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("label");
        return null;
    }

    public final float getMaxWidth() {
        return ((Number) this.maxWidth$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }
}
