package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NearbyProMapViewKt {
    public static final void NearbyProMap(ViewContainer<?, ?> viewContainer, Function1<? super NearbyProMapView, Unit> function1) {
        viewContainer.addChild(new NearbyProMapView(), function1);
    }
}
