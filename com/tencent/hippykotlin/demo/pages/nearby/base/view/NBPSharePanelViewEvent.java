package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPSharePanelViewEvent extends l {
    public Function0<Unit> onCloseClickHandler;
    public Function1<? super ShareItemData, Unit> onItemClickHandler;
}
