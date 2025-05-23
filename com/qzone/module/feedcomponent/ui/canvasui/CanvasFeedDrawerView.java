package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedDrawerView extends QzoneCanvasAreaView {

    @DittoField
    DittoArea feed_drawer_content;

    @DittoField
    DittoArea feed_drawer_root;
    private BusinessFeedData mFeedData;

    public CanvasFeedDrawerView(Context context) {
        this(context, null);
    }

    private void init() {
        setContentAreaForJsonFile("qzone_canvas_ui_feed_drawer.json");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"feed_drawer_root", "feed_drawer_content"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        g gVar = this.onFeedElementClickListener;
        if (gVar != null && dittoArea == this.feed_drawer_content) {
            gVar.onClick(this, FeedElement.FEED_DRAWER, this.feedPosition, null);
            i.H().f(84, 26, 2);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        super.reset();
        this.mFeedData = null;
    }

    public CanvasFeedDrawerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void onUpdate() {
        setVisibility(0);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        this.mFeedData = businessFeedData;
    }
}
