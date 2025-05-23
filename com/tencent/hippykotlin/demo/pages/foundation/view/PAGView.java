package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class PAGView extends DeclarativeBaseView<PAGAttr, PAGEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new PAGAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new PAGEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        ((PAGAttr) getAttr()).didInit = true;
        Function0<Unit> function0 = ((PAGAttr) getAttr()).attrDidInitBlock;
        if (function0 != null) {
            function0.invoke();
        }
        ((PAGAttr) getAttr()).attrDidInitBlock = null;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "HRPAGView";
    }
}
