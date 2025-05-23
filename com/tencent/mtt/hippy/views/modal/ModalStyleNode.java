package com.tencent.mtt.hippy.views.modal;

import android.graphics.Point;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.smtt.flexbox.FlexNode;

/* compiled from: P */
/* loaded from: classes20.dex */
class ModalStyleNode extends StyleNode {
    @Override // com.tencent.mtt.hippy.dom.node.b, com.tencent.smtt.flexbox.FlexNode
    public void addChildAt(FlexNode flexNode, int i3) {
        super.addChildAt(flexNode, i3);
        Point modalHostSize = ModalHostHelper.getModalHostSize(ContextHolder.getAppContext());
        flexNode.setStyleWidth(modalHostSize.x);
        flexNode.setStyleHeight(modalHostSize.y);
    }
}
