package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.g;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AccessibilityTextView extends TextView {
    @Override // com.tencent.kuikly.core.views.TextView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AccessibilityTextEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.TextView, com.tencent.kuikly.core.layout.f
    public final void measure(FlexNode flexNode, float f16, float f17, g gVar) {
        A viewAttr = getViewAttr();
        AccessibilityTextAttr accessibilityTextAttr = viewAttr instanceof AccessibilityTextAttr ? (AccessibilityTextAttr) viewAttr : null;
        if (accessibilityTextAttr != null && !accessibilityTextAttr.hasCustomAccessibilitySet) {
            accessibilityTextAttr.internalAccessibilitySet = true;
            accessibilityTextAttr.accessibility(accessibilityTextAttr.internalText);
            accessibilityTextAttr.internalAccessibilitySet = false;
        }
        super.measure(flexNode, f16, f17, gVar);
    }

    @Override // com.tencent.kuikly.core.views.TextView, com.tencent.kuikly.core.base.AbstractBaseView
    public ce createAttr() {
        return new AccessibilityTextAttr();
    }

    @Override // com.tencent.kuikly.core.views.TextView, com.tencent.kuikly.core.base.AbstractBaseView
    public final TextEvent createEvent() {
        return new AccessibilityTextEvent();
    }
}
