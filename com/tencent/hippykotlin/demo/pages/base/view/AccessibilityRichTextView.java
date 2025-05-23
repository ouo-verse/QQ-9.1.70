package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.g;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.ae;
import com.tencent.kuikly.core.views.cf;

/* compiled from: P */
/* loaded from: classes31.dex */
public class AccessibilityRichTextView extends RichTextView {
    @Override // com.tencent.kuikly.core.views.RichTextView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AccessibilityRichTextEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.RichTextView, com.tencent.kuikly.core.layout.f
    public final void measure(FlexNode flexNode, float f16, float f17, g gVar) {
        A viewAttr = getViewAttr();
        AccessibilityRichTextAttr accessibilityRichTextAttr = viewAttr instanceof AccessibilityRichTextAttr ? (AccessibilityRichTextAttr) viewAttr : null;
        if (accessibilityRichTextAttr != null && !accessibilityRichTextAttr.hasCustomAccessibilitySet) {
            String str = "";
            for (ae aeVar : accessibilityRichTextAttr.getSpans()) {
                if (aeVar instanceof cf) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str);
                    m3.append(((cf) aeVar).getText());
                    str = m3.toString();
                }
            }
            accessibilityRichTextAttr.internalAccessibilitySet = true;
            accessibilityRichTextAttr.accessibility(str);
            accessibilityRichTextAttr.internalAccessibilitySet = false;
        }
        super.measure(flexNode, f16, f17, gVar);
    }

    @Override // com.tencent.kuikly.core.views.RichTextView, com.tencent.kuikly.core.base.AbstractBaseView
    public RichTextAttr createAttr() {
        return new AccessibilityRichTextAttr();
    }

    @Override // com.tencent.kuikly.core.views.RichTextView, com.tencent.kuikly.core.base.AbstractBaseView
    public final RichTextEvent createEvent() {
        return new AccessibilityRichTextEvent();
    }
}
