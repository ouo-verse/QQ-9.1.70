package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import n25.a;

/* loaded from: classes31.dex */
public final class NBPCityWalkMapViewEvent extends l {
    public Function1<? super a, Unit> onMapClickHandler;
    public Function2<? super ClickParams, ? super NBPCityWalkMapView, Unit> onMapDoubleClick;
    public Function0<Unit> onMapLongPress;
}
