package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedBottomGuideView extends FeedViewSection implements View.OnClickListener {
    protected static FeedViewSection.SectionController BottomGuideController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedBottomGuideView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return true;
        }
    };
    private VisitAndPraiseAvatarsView avatarsView;
    private View container;
    private final int mAvatarMaxCount;
    private TextView title;

    public FeedBottomGuideView(Context context, FeedView feedView) {
        super(context, feedView);
        init();
        this.mAvatarMaxCount = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "secondary_feed_bottom_guide_avatar_max_count", 3);
    }

    private List<CellLikeInfo.LikeMan> convertUserList() {
        CellFollowGuide cellFollowGuide;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null || cellFollowGuide.followed_list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mFeedData.cellFollowGuide.followed_list.size(); i3++) {
            CellLikeInfo.LikeMan likeMan = new CellLikeInfo.LikeMan();
            likeMan.user = this.mFeedData.cellFollowGuide.followed_list.get(i3);
            arrayList.add(likeMan);
        }
        return arrayList;
    }

    void init() {
        setSectionController(BottomGuideController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.container == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_bottom_guide"), (ViewGroup) null);
            this.container = inflate;
            this.avatarsView = (VisitAndPraiseAvatarsView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2869));
            this.title = (TextView) this.container.findViewById(com.qzone.adapter.feedcomponent.j.O(2870));
            this.container.setOnClickListener(this);
        }
        return updateUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null && view == (view2 = this.container)) {
            gVar.onClick(view2, FeedElement.FEED_BOTTOM_GUIDE, getFeedPosition(), null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        View view = this.container;
        if (view == null || view.getBackground() == null) {
            return;
        }
        this.container.getBackground().setAlpha(i3);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = this.avatarsView;
        if (visitAndPraiseAvatarsView != null) {
            visitAndPraiseAvatarsView.setFeedPosition(i3, 0);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
    }

    protected View updateUI() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.cellFollowGuide != null) {
            this.container.setVisibility(0);
            this.title.setText(this.mFeedData.cellFollowGuide.summary);
            List<CellLikeInfo.LikeMan> convertUserList = convertUserList();
            if (convertUserList != null && convertUserList.size() > 0) {
                this.avatarsView.setVisibility(0);
                this.avatarsView.setAvatarSize(AreaManager.dp22);
                int size = convertUserList.size();
                int i3 = this.mAvatarMaxCount;
                if (size > i3) {
                    this.avatarsView.setPraiseData(convertUserList.subList(0, i3), (int) this.mFeedData.cellFollowGuide.count, false, null, -1, -1);
                } else {
                    this.avatarsView.setPraiseData(convertUserList, (int) this.mFeedData.cellFollowGuide.count, false, null, -1, -1);
                }
                this.avatarsView.setAvatarPressEnable(false);
                this.avatarsView.requestLayout();
            } else {
                this.avatarsView.setVisibility(8);
            }
            return this.container;
        }
        View view = this.container;
        if (view == null) {
            return null;
        }
        view.setVisibility(8);
        return null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mFeedData = null;
        setOnFeedElementClickListener(null);
        View view = this.container;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.mFeedData = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
    }
}
