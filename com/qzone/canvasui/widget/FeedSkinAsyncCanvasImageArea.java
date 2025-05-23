package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import com.qzone.adapter.feedcomponent.j;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSkinAsyncCanvasImageArea extends AsyncCanvasImageArea {
    public FeedSkinAsyncCanvasImageArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        j.U(getDrawable());
        super.onDraw(canvas);
    }
}
