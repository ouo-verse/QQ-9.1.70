package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.RelativeAreaLayout;

/* loaded from: classes39.dex */
public class CanvasPresentInfoView extends QzoneCanvasAreaView {
    private static final String TAG = "CanvasPresentInfoView";
    DittoListArea.ListAreaAdapter adapter;

    @DittoField
    DittoImageArea arrowIndicator;
    BusinessFeedData mFeedData;

    @DittoField
    DittoListArea presentAvatarList;

    @DittoField
    DittoButtonArea presentCount;

    @DittoField
    RelativeAreaLayout presentRoot;

    public CanvasPresentInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adapter = new DittoListArea.ListAreaAdapter() { // from class: com.qzone.module.feedcomponent.ui.CanvasPresentInfoView.1
            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public DittoArea getArea(DittoListArea dittoListArea, int i3, int i16) {
                LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
                int i17 = AreaManager.dp22;
                layoutAttrSet.height = i17;
                layoutAttrSet.width = i17;
                CanvasAvatarArea canvasAvatarArea = new CanvasAvatarArea(CanvasPresentInfoView.this, layoutAttrSet);
                canvasAvatarArea.setBorderRadius(AreaManager.dp11);
                canvasAvatarArea.setUser(CanvasPresentInfoView.this.mFeedData.getCellPresentInfo().presentmans.get(i16).user);
                return canvasAvatarArea;
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public int numberOfRows(DittoListArea dittoListArea, int i3) {
                BusinessFeedData businessFeedData = CanvasPresentInfoView.this.mFeedData;
                if (businessFeedData == null || businessFeedData.getCellPresentInfo() == null || CanvasPresentInfoView.this.mFeedData.getCellPresentInfo().presentmans == null) {
                    return 0;
                }
                return Math.min(CanvasPresentInfoView.this.mFeedData.getCellPresentInfo().presentmans.size(), 5);
            }
        };
        setContentAreaForJsonFile("qzone_canvas_ui_presentinfo.json");
        this.presentAvatarList.setItemInterval(AreaManager.dp5);
        this.presentAvatarList.setAdapter(this.adapter);
        this.arrowIndicator.setImageResource(com.qzone.adapter.feedcomponent.j.h(832));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick("presentRoot")
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        BusinessFeedData businessFeedData;
        com.qzone.proxy.feedcomponent.b.c(TAG, "clicked");
        if (this.onFeedElementClickListener == null || (businessFeedData = this.mFeedData) == null || businessFeedData.getUser() == null || this.mFeedData.getFeedCommInfoV2() == null) {
            return;
        }
        this.onFeedElementClickListener.onClick(this, FeedElement.PRESENT_BOARD, this.feedPosition, null);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        this.presentAvatarList.reloadRows();
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.getCellPresentInfo() != null) {
            this.presentCount.setText(String.format("%d\u4eba \u9001\u793c", Long.valueOf(this.mFeedData.getCellPresentInfo().num)));
            this.presentRoot.setVisibility(0);
        } else {
            this.presentRoot.setVisibility(8);
        }
    }
}
