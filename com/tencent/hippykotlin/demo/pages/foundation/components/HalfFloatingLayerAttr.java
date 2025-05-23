package com.tencent.hippykotlin.demo.pages.foundation.components;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.aq;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HalfFloatingLayerAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HalfFloatingLayerAttr.class, "floatingLayerHeight", "getFloatingLayerHeight$qecommerce_biz_release()F", 0)};
    public Function1<? super aq<?, ?>, Unit> boardBuilder;
    public Function1<? super ViewContainer<?, ?>, Unit> boardIndicatorBarBuilder;
    public final ReadWriteProperty floatingLayerHeight$delegate = c.a(Float.valueOf(600.0f));
    public float bgMaskColorAlpha = 0.3f;
    public h boardBgColor = h.INSTANCE.m();
    public float boardBorderRadius = 8.0f;
}
