package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.canvasui.gdtui.CanvasRecommActionButton;
import com.qzone.module.feedcomponent.ui.DetailBottomAdBaseSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommButtonView extends MarginCanvasAreaView implements DetailBottomAdBaseSection {
    CanvasRecommActionButton canvasRecommActionButton;

    public CanvasRecommButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.addLayoutAttr("text_color", "#FF2D8AE7");
        layoutAttrSet.addLayoutAttr("padding", "14dp,0dp,14dp,0dp");
        layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderWidth, "1dp");
        layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderRadius, "2dp");
        layoutAttrSet.addLayoutAttr(LayoutAttrDefine.BorderColor, "#FF2D8AE7");
        layoutAttrSet.addLayoutAttr("text_size", 14);
        CanvasRecommActionButton canvasRecommActionButton = new CanvasRecommActionButton(this, layoutAttrSet);
        this.canvasRecommActionButton = canvasRecommActionButton;
        canvasRecommActionButton.setLayoutAttr(layoutAttrSet);
        setCanvasArea(this.canvasRecommActionButton);
    }

    void setOnAreaClickListener(DittoArea.ClickListener clickListener) {
        this.canvasRecommActionButton.clickListener = clickListener;
    }

    public void setText(String str) {
        if (str == null || str.equals(this.canvasRecommActionButton.getText())) {
            return;
        }
        this.canvasRecommActionButton.setText(str);
    }

    @Override // com.qzone.module.feedcomponent.ui.DetailBottomAdBaseSection
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        LayoutAttrSet layoutAttr = this.canvasRecommActionButton.getLayoutAttr();
        layoutAttr.width = getLayoutParams().width;
        layoutAttr.height = getLayoutParams().height;
    }
}
