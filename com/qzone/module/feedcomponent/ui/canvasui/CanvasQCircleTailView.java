package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.module.feedcomponent.ui.FeedChildView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.mobileqq.reminder.util.QQConstants;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasQCircleTailView extends QzoneCanvasAreaView implements FeedChildView {
    public static FeedViewSection.SectionController QCircleTailController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQCircleTailView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return true;
        }
    };

    @DittoField
    RelativeAreaLayout layout_qcircle_tail;

    @DittoField
    DittoImageArea qcircle_tail_arrow;

    @DittoField
    DittoImageArea qcircle_tail_icon;

    @DittoField
    DittoTextArea qcircle_tail_summary;

    public CanvasQCircleTailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setContentAreaForJsonFile("qzone_canvas_ui_qcircle_tail_view.json");
        this.layout_qcircle_tail.setBackgroundDrawable(j.g(975));
        this.qcircle_tail_icon.setImageDrawable(j.g(QQConstants.REMINDER_POS_ID));
        this.qcircle_tail_arrow.setImageDrawable(j.g(976));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"layout_qcircle_tail"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (dittoArea == this.layout_qcircle_tail) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_QCIRCLE_TAIL_VIEW_CLICK_EVENT_TAG, this.feedPosition, Boolean.FALSE);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        if (cellBottomRecomm == null || TextUtils.isEmpty(cellBottomRecomm.title)) {
            return;
        }
        this.qcircle_tail_summary.setText(cellBottomRecomm.title);
    }
}
