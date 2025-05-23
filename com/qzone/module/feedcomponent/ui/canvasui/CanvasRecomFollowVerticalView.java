package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.CellViewMore;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoBridgeArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecomFollowVerticalView extends QzoneCanvasAreaView implements DittoArea.ClickListener, DittoArea.LongClickListener {
    private DittoArea clickedArea;

    @DittoField
    LinearAreaLayout feed_recommend_follow_layout;
    private DittoListArea.ListAreaAdapter mAdapter;
    private ArrayList<BusinessFeedData> mRecBusinessFeedDatas;
    protected CellViewMore mViewMore;

    @DittoField
    DittoImageArea qzone_feed_recomm_follow_dropdown_btn;

    @DittoField
    DittoImageArea qzone_feed_recomm_follow_more_icon;

    @DittoField
    RichCanvasTextArea qzone_feed_recomm_follow_more_text;

    @DittoField
    LinearAreaLayout qzone_feed_recomm_follow_morecontainer;

    @DittoField
    RelativeAreaLayout qzone_feed_recomm_follow_moreview;

    @DittoField
    RichCanvasTextArea qzone_feed_recomm_follow_title;

    @DittoField
    RelativeAreaLayout qzone_feed_recomm_follow_titlebar;

    @DittoField
    DittoListArea recomlist;

    public CanvasRecomFollowVerticalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapter = new DittoListArea.ListAreaAdapterWithSection() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalView.1
            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public DittoArea getArea(DittoListArea dittoListArea, int i3, int i16) {
                return CanvasRecomFollowVerticalView.this.getRecommendCardArea((CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas == null || CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.size() <= i16) ? null : (BusinessFeedData) CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.get(i16), i16);
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
            public int numberOfRows(DittoListArea dittoListArea, int i3) {
                if (CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas == null) {
                    return 0;
                }
                if (CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.size() > 3) {
                    return 3;
                }
                return CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.size();
            }

            @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapterWithSection
            public int numberOfSections(DittoListArea dittoListArea) {
                return 1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"qzone_feed_recomm_follow_dropdown_btn", "qzone_feed_recomm_follow_moreview"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (this.qzone_feed_recomm_follow_dropdown_btn == dittoArea) {
            int[] locationToViewHost = DittoAreaView.getLocationToViewHost(dittoArea);
            this.onFeedElementClickListener.onClick(this, FeedElement.DROPDOWN_BUTTON, this.feedPosition, new ClickedPoint(locationToViewHost[0], locationToViewHost[1], 0, 0, dittoArea.getWidth(), dittoArea.getHeight()));
        } else if (this.qzone_feed_recomm_follow_moreview == dittoArea) {
            gVar.onClick(this, FeedElement.FEED_RECOMM_BOTTOM_CLICK, this.feedPosition, this.mViewMore);
        }
    }

    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        DittoBridgeArea dittoBridgeArea;
        ArrayList<BusinessFeedData> arrayList = this.mRecBusinessFeedDatas;
        if (arrayList != null) {
            Iterator<BusinessFeedData> it = arrayList.iterator();
            final BusinessFeedData businessFeedData2 = null;
            while (it.hasNext()) {
                BusinessFeedData next = it.next();
                if (next.getRecommItem() != null && next.getRecommItem().userInfo != null && next.getRecommItem().userInfo.uin == j3) {
                    next.getRecommItem().isFollowed = z16;
                    businessFeedData2 = next;
                }
            }
            int indexOf = this.mRecBusinessFeedDatas.indexOf(businessFeedData2);
            if (indexOf >= 0 && this.recomlist.getChildCount() > indexOf && (dittoBridgeArea = (DittoBridgeArea) this.recomlist.getChildAt(indexOf)) != null && (dittoBridgeArea.getContainedView() instanceof CanvasRecomFollowListItemView)) {
                ((CanvasRecomFollowListItemView) dittoBridgeArea.getContainedView()).setFeedData(businessFeedData2, indexOf);
                invalidate();
            }
            ((QzoneCanvasAreaView) this).mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowVerticalView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (businessFeedData2 == null || CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas == null) {
                        return;
                    }
                    CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.remove(businessFeedData2);
                    if (CanvasRecomFollowVerticalView.this.mRecBusinessFeedDatas.size() > 0) {
                        CanvasRecomFollowVerticalView.this.recomlist.reloadRows();
                    } else {
                        CanvasRecomFollowVerticalView canvasRecomFollowVerticalView = CanvasRecomFollowVerticalView.this;
                        canvasRecomFollowVerticalView.onFeedElementClickListener.onClick(canvasRecomFollowVerticalView, FeedElement.FEEDBACK, ((QzoneCanvasAreaView) canvasRecomFollowVerticalView).feedPosition, Integer.valueOf(((QzoneCanvasAreaView) CanvasRecomFollowVerticalView.this).feedPosition));
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DittoArea getRecommendCardArea(BusinessFeedData businessFeedData, int i3) {
        CellRecommItem cellRecommItem;
        if (businessFeedData == null || (cellRecommItem = businessFeedData.cellRecommItem) == null || cellRecommItem.userInfo == null) {
            return null;
        }
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.width = -1;
        layoutAttrSet.height = -2;
        layoutAttrSet.addLayoutAttr("view", "com.qzone.module.feedcomponent.ui.canvasui.CanvasRecomFollowListItemView");
        DittoBridgeArea dittoBridgeArea = new DittoBridgeArea(this, layoutAttrSet);
        if (dittoBridgeArea.getContainedView() instanceof CanvasRecomFollowListItemView) {
            ((CanvasRecomFollowListItemView) dittoBridgeArea.getContainedView()).setFeedData(businessFeedData, i3);
            ((CanvasRecomFollowListItemView) dittoBridgeArea.getContainedView()).setFeedPosition(this.feedPosition);
            ((CanvasRecomFollowListItemView) dittoBridgeArea.getContainedView()).setOnFeedElementClickListener(this.onFeedElementClickListener);
        }
        return dittoBridgeArea;
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getRecBusinessFeedDatas() == null || businessFeedData.getRecommHeader() == null) {
            return;
        }
        setContentAreaForJsonFile("qzone_canvas_ui_recom_followlist.json");
        this.mRecBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        if (businessFeedData.getRecommItem() != null && !TextUtils.isEmpty(businessFeedData.getRecommHeader().leftTitle)) {
            this.qzone_feed_recomm_follow_title.setText(businessFeedData.getRecommHeader().leftTitle);
            this.qzone_feed_recomm_follow_dropdown_btn.setImageDrawable(AreaManager.DROPDOWN_DRAWABLE);
        }
        CellViewMore cellViewMore = businessFeedData.getCellViewMore();
        this.mViewMore = cellViewMore;
        if (cellViewMore != null) {
            String str = cellViewMore.guide_content;
            if (!TextUtils.isEmpty(str)) {
                this.qzone_feed_recomm_follow_morecontainer.setVisibility(0);
                this.qzone_feed_recomm_follow_more_text.setText(str);
            } else {
                this.qzone_feed_recomm_follow_moreview.setVisibility(8);
            }
        } else {
            this.qzone_feed_recomm_follow_moreview.setVisibility(8);
        }
        this.qzone_feed_recomm_follow_more_icon.setImageDrawable(AreaManager.FEED_ARROW_RIGHT_ICON);
        this.recomlist.setAdapter(this.mAdapter);
    }

    @Override // com.tencent.ditto.area.DittoArea.ClickListener
    public void onClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
    }

    @Override // com.tencent.ditto.area.DittoArea.LongClickListener
    public void onLongClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
    }
}
