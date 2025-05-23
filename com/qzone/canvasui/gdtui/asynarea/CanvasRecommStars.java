package com.qzone.canvasui.gdtui.asynarea;

import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.gdtui.shell.GdtLayoutAttrDefine;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.module.feedcomponent.util.GdtCanvasUiUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommStars extends RelativeAreaLayout implements IGdtAsynArea {
    private static final int DEFAULT_MAX_STAR_NUM = 5;
    private static final int DEFAULT_VIEW_MARGIN_IN_DP = 4;
    private static final int DEFAULT_VIEW_SIZE_IN_DP = 15;
    private BusinessFeedData businessFeedData;
    private CanvasAsynAreaCore canvasAsynAreaCore;
    private int maxStarNum;
    private ArrayList<AsyncCanvasImageArea> subViews;
    private int viewMarginInDp;
    private int viewSizeInDp;

    public CanvasRecommStars(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.subViews = new ArrayList<>();
        initCore();
        setCustomAttr(layoutAttrSet);
        setVisibility(8);
    }

    private void initCore() {
        this.canvasAsynAreaCore = new CanvasAsynAreaCore() { // from class: com.qzone.canvasui.gdtui.asynarea.CanvasRecommStars.1
            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected boolean needUpdate() {
                return (CanvasRecommStars.this.businessFeedData == null || CanvasRecommStars.this.businessFeedData.getRecommAction() == null || CanvasRecommStars.this.businessFeedData.getRecommAction().rankMax <= 0) ? false : true;
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onReset() {
                CanvasRecommStars.this.setVisibility(8);
                CanvasRecommStars.this.businessFeedData = null;
                Iterator it = CanvasRecommStars.this.subViews.iterator();
                while (it.hasNext()) {
                    ((AsyncCanvasImageArea) it.next()).setVisibility(8);
                }
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onSetFeedData(BusinessFeedData businessFeedData) {
                CanvasRecommStars.this.businessFeedData = businessFeedData;
                CanvasRecommStars.this.setVisibility(8);
                if (CanvasRecommStars.this.subViews != null) {
                    Iterator it = CanvasRecommStars.this.subViews.iterator();
                    while (it.hasNext()) {
                        ((AsyncCanvasImageArea) it.next()).setVisibility(8);
                    }
                }
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            public void onUpdate() {
                CanvasRecommStars.this.setVisibility(0);
                int min = Math.min(CanvasRecommStars.this.businessFeedData.getRecommAction().rankMax, CanvasRecommStars.this.maxStarNum);
                int i3 = CanvasRecommStars.this.businessFeedData.getRecommAction().rankCurrentWithHalfStar;
                for (int i16 = 0; i16 < min; i16++) {
                    int i17 = i3 / 2;
                    if (i16 < i17) {
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setVisibility(0);
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setImageResource(j.h(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER));
                    } else if (i3 % 2 != 0 && i16 == i17) {
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setVisibility(0);
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setImageResource(j.h(574));
                    } else {
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setVisibility(0);
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setImageResource(j.h(575));
                    }
                    if (i.H().p1()) {
                        ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i16)).setAlpha(Float.parseFloat("200"));
                    }
                }
            }

            @Override // com.qzone.canvasui.gdtui.asynarea.CanvasAsynAreaCore
            protected void onInit() {
                for (int i3 = 0; i3 < CanvasRecommStars.this.maxStarNum; i3++) {
                    ArrayList arrayList = CanvasRecommStars.this.subViews;
                    CanvasRecommStars canvasRecommStars = CanvasRecommStars.this;
                    arrayList.add(i3, new AsyncCanvasImageArea(canvasRecommStars.mHost, GdtCanvasUiUtil.getHorizontalMarginAttr(canvasRecommStars.viewSizeInDp, CanvasRecommStars.this.viewMarginInDp, i3)));
                    CanvasRecommStars canvasRecommStars2 = CanvasRecommStars.this;
                    canvasRecommStars2.addChild((DittoArea) canvasRecommStars2.subViews.get(i3));
                    ((AsyncCanvasImageArea) CanvasRecommStars.this.subViews.get(i3)).setVisibility(8);
                }
            }
        };
    }

    private void setCustomAttr(LayoutAttrSet layoutAttrSet) {
        try {
            this.maxStarNum = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.MAX_SUB_VIEW_NUM_KEY, "5")).intValue();
            this.viewSizeInDp = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.SUB_VIEW_SIZE_KEY, "15")).intValue();
            this.viewMarginInDp = Integer.valueOf((String) layoutAttrSet.getAttrWithDefault(GdtLayoutAttrDefine.SUB_VIEW_MARGIN_KEY, "4")).intValue();
        } catch (Exception unused) {
        }
    }

    @Override // com.qzone.canvasui.gdtui.asynarea.IGdtAsynArea
    public CanvasAsynAreaCore getCore() {
        return this.canvasAsynAreaCore;
    }
}
