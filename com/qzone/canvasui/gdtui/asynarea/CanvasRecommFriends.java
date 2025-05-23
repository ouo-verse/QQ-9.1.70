package com.qzone.canvasui.gdtui.asynarea;

import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.gdtui.shell.GdtLayoutAttrDefine;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.module.feedcomponent.util.GdtCanvasUiUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommFriends extends RelativeAreaLayout implements IGdtAsynArea {
    private static final int DEFAULT_MAX_SUB_VIEW_NUM = 3;
    private static final int DEFAULT_VIEW_MARGIN_IN_DP = 3;
    private static final int DEFAULT_VIEW_SIZE_IN_DP = 27;
    private BusinessFeedData businessFeedData;
    public CanvasAsynAreaCore canvasAsynAreaCore;
    private boolean inited;
    private int subViewMarginInDp;
    private int subViewSizeInDp;
    private ArrayList<AsyncCanvasImageArea> subViews;
    private int totalSubviewNum;

    public CanvasRecommFriends(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.inited = false;
        this.subViews = new ArrayList<>();
        initCore();
        setCustomAttr(layoutAttrSet);
        setVisibility(8);
    }

    private void initCore() {
        this.canvasAsynAreaCore = new CanvasAsynAreaCore() { // from class: com.qzone.canvasui.gdtui.asynarea.CanvasRecommFriends.1
            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected boolean needUpdate() {
                return (CanvasRecommFriends.this.businessFeedData == null || CanvasRecommFriends.this.businessFeedData.getRecommAction() == null || CanvasRecommFriends.this.businessFeedData.getRecommAction().relation_total_number == 0) ? false : true;
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onReset() {
                CanvasRecommFriends.this.setVisibility(8);
                for (int i3 = 0; i3 < CanvasRecommFriends.this.totalSubviewNum; i3++) {
                    ((AsyncCanvasImageArea) CanvasRecommFriends.this.subViews.get(i3)).setVisibility(8);
                }
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onSetFeedData(BusinessFeedData businessFeedData) {
                CanvasRecommFriends.this.businessFeedData = businessFeedData;
                CanvasRecommFriends.this.setVisibility(8);
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            public void onUpdate() {
                CanvasRecommFriends.this.setVisibility(0);
                int min = (CanvasRecommFriends.this.businessFeedData == null || CanvasRecommFriends.this.businessFeedData.getRecommAction() == null || CanvasRecommFriends.this.businessFeedData.getRecommAction().relation_chain == null) ? 0 : Math.min(CanvasRecommFriends.this.businessFeedData.getRecommAction().relation_chain.size(), CanvasRecommFriends.this.totalSubviewNum);
                for (int i3 = 0; i3 < min; i3++) {
                    ((AsyncCanvasImageArea) CanvasRecommFriends.this.subViews.get(i3)).setVisibility(0);
                    ((AsyncCanvasImageArea) CanvasRecommFriends.this.subViews.get(i3)).setAvatar(CanvasRecommFriends.this.businessFeedData.getRecommAction().relation_chain.get(i3).uin, Math.round(DittoUIEngine.g().getDensity() * 27.0f), j.g(PlayerResources.ViewId.CURRUNT_TIME));
                }
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onInit() {
                for (int i3 = 0; i3 < CanvasRecommFriends.this.totalSubviewNum; i3++) {
                    ArrayList arrayList = CanvasRecommFriends.this.subViews;
                    CanvasRecommFriends canvasRecommFriends = CanvasRecommFriends.this;
                    arrayList.add(i3, new AsyncCanvasImageArea(canvasRecommFriends.mHost, GdtCanvasUiUtil.getHorizontalMarginAttr(canvasRecommFriends.subViewSizeInDp, CanvasRecommFriends.this.subViewMarginInDp, i3)));
                    CanvasRecommFriends canvasRecommFriends2 = CanvasRecommFriends.this;
                    canvasRecommFriends2.addChild((DittoArea) canvasRecommFriends2.subViews.get(i3));
                    ((AsyncCanvasImageArea) CanvasRecommFriends.this.subViews.get(i3)).setVisibility(8);
                }
            }
        };
    }

    private void setCustomAttr(LayoutAttrSet layoutAttrSet) {
        try {
            this.totalSubviewNum = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.MAX_SUB_VIEW_NUM_KEY, "3")).intValue();
            this.subViewSizeInDp = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.SUB_VIEW_SIZE_KEY, "27")).intValue();
            this.subViewMarginInDp = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.SUB_VIEW_MARGIN_KEY, "3")).intValue();
        } catch (Exception unused) {
        }
    }

    @Override // com.qzone.canvasui.gdtui.asynarea.IGdtAsynArea
    public CanvasAsynAreaCore getCore() {
        return this.canvasAsynAreaCore;
    }
}
