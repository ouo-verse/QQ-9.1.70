package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedFollowGuideView extends FeedViewSection implements View.OnClickListener {
    protected static FeedViewSection.SectionController FollowGuideController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedFollowGuideView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.cellFollowGuide == null;
        }
    };
    private ImageView arrow;
    private VisitAndPraiseAvatarsView avatarsView;
    private View container;
    private TextView mGuestMemSummary;
    private View mGuestMemoryBar;
    private View mMemCloseButton;
    private AsyncImageView mMemIcon;
    private TextView mMemSetting;
    private TextView mMemSummary;
    private View mMemoryBar;
    private TextView summary;
    private TextView title;

    public FeedFollowGuideView(Context context, FeedView feedView) {
        super(context, feedView);
        init();
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
        setSectionController(FollowGuideController);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        if (this.mGuestMemoryBar == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_memory_store_guest"), (ViewGroup) null);
            this.mGuestMemoryBar = inflate;
            this.mGuestMemSummary = (TextView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2720));
            AsyncImageView asyncImageView = (AsyncImageView) this.mGuestMemoryBar.findViewById(com.qzone.adapter.feedcomponent.j.O(2843));
            String c16 = com.qzone.adapter.feedcomponent.h.c(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_DIVIMAGE_URL, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DIVIMAGE_URL);
            if (!TextUtils.isEmpty(c16) && asyncImageView != null) {
                asyncImageView.setAsyncImage(c16);
            }
        }
        if (this.mMemoryBar == null) {
            View inflate2 = LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_memory_store"), (ViewGroup) null);
            this.mMemoryBar = inflate2;
            this.mMemSetting = (TextView) inflate2.findViewById(com.qzone.adapter.feedcomponent.j.O(2632));
            this.mMemSummary = (TextView) this.mMemoryBar.findViewById(com.qzone.adapter.feedcomponent.j.O(2631));
            this.mMemIcon = (AsyncImageView) this.mMemoryBar.findViewById(com.qzone.adapter.feedcomponent.j.O(2630));
            this.mMemCloseButton = this.mMemoryBar.findViewById(com.qzone.adapter.feedcomponent.j.O(2840));
            this.mMemSetting.setOnClickListener(this);
            this.mMemCloseButton.setOnClickListener(this);
        }
        if (this.container == null) {
            View inflate3 = LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_widget_feed_follow_guide"), (ViewGroup) null);
            this.container = inflate3;
            this.arrow = (ImageView) inflate3.findViewById(com.qzone.adapter.feedcomponent.j.O(2635));
            this.title = (TextView) this.container.findViewById(com.qzone.adapter.feedcomponent.j.O(2636));
            this.summary = (TextView) this.container.findViewById(com.qzone.adapter.feedcomponent.j.O(2637));
            this.avatarsView = (VisitAndPraiseAvatarsView) this.container.findViewById(com.qzone.adapter.feedcomponent.j.O(2638));
            this.container.setOnClickListener(this);
        }
        return updateUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            View view2 = this.container;
            if (view == view2) {
                gVar.onClick(view2, FeedElement.FEED_FOLLOW_GUIDE, getFeedPosition(), null);
            } else if (view == this.mMemSetting) {
                gVar.onClick(view2, FeedElement.FEED_MEMORY_SETTING, getFeedPosition(), null);
            } else if (view == this.mMemCloseButton) {
                gVar.onClick(this.mMemoryBar, FeedElement.FEED_MEMORY_CLOSE, getFeedPosition(), null);
            }
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
        CellFollowGuide cellFollowGuide;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && (cellFollowGuide = businessFeedData.cellFollowGuide) != null) {
            int i3 = cellFollowGuide.feed_type;
            if (i3 != 1 && i3 != 4) {
                this.mMemoryBar.setVisibility(8);
                this.mGuestMemoryBar.setVisibility(8);
                this.mMemSetting.setVisibility(8);
                this.container.setVisibility(0);
                this.title.setText(this.mFeedData.cellFollowGuide.title);
                this.summary.setTextSize((TextUtils.isEmpty(this.mFeedData.cellFollowGuide.displaySummary) || !this.mFeedData.cellFollowGuide.displaySummary.contains("{type:")) ? 14.0f : 12.0f);
                this.summary.setText(this.mFeedData.cellFollowGuide.displaySummary);
                com.qzone.proxy.feedcomponent.b.e("Feed", "FollowGuide content:" + this.mFeedData.cellFollowGuide.displaySummary + " Ellipsize:" + this.mFeedData.cellFollowGuide.displaySummaryEllipsizeStart + " " + this.mFeedData.cellFollowGuide.displaySummaryEllipsizeEnd);
                if (this.mFeedData.cellFollowGuide.getStatus() == 0) {
                    this.arrow.setImageResource(com.qzone.adapter.feedcomponent.j.h(876));
                } else if (this.mFeedData.cellFollowGuide.getStatus() == 2) {
                    this.arrow.setImageResource(com.qzone.adapter.feedcomponent.j.h(877));
                } else if (this.mFeedData.cellFollowGuide.getStatus() == 1) {
                    this.arrow.setImageResource(com.qzone.adapter.feedcomponent.j.h(878));
                } else {
                    this.arrow.setImageResource(com.qzone.adapter.feedcomponent.j.h(876));
                }
                List<CellLikeInfo.LikeMan> convertUserList = convertUserList();
                if (convertUserList != null && convertUserList.size() > 0) {
                    this.avatarsView.setVisibility(0);
                    this.avatarsView.setAvatarSize(AreaManager.dp24);
                    this.avatarsView.setPraiseData(convertUserList, (int) this.mFeedData.cellFollowGuide.count, false, null, -1, -1);
                    this.avatarsView.setAvatarPressEnable(false);
                    this.avatarsView.requestLayout();
                } else {
                    this.avatarsView.setVisibility(8);
                }
                return this.container;
            }
            this.container.setVisibility(8);
            if (TextUtils.isEmpty(this.mFeedData.cellFollowGuide.button_text)) {
                this.mMemoryBar.setVisibility(8);
                this.mGuestMemoryBar.setVisibility(0);
                this.mGuestMemSummary.setText(this.mFeedData.cellFollowGuide.summary);
                return this.mGuestMemoryBar;
            }
            boolean z16 = this.mFeedData.cellFollowGuide.feed_type == 1 && !com.qzone.adapter.feedcomponent.i.H().i1();
            boolean z17 = this.mFeedData.cellFollowGuide.feed_type == 4 && !com.qzone.adapter.feedcomponent.i.H().j1();
            if (!z16 && !z17) {
                return null;
            }
            this.mGuestMemoryBar.setVisibility(8);
            if (this.mMemoryBar.getVisibility() != 0) {
                this.mMemoryBar.setVisibility(0);
                com.qzone.adapter.feedcomponent.i.H().f(z16 ? 114 : 113, 1, this.mFeedData.feedType == 3 ? 1 : 2);
            }
            this.mMemSetting.setVisibility(0);
            this.mMemSetting.setText(this.mFeedData.cellFollowGuide.button_text);
            this.mMemSummary.setText(this.mFeedData.cellFollowGuide.summary);
            this.mMemIcon.setAsyncImage(this.mFeedData.cellFollowGuide.icon_url);
            return this.mMemoryBar;
        }
        View view = this.container;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mMemoryBar;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mGuestMemoryBar;
        if (view3 != null) {
            view3.setVisibility(8);
        }
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
        View view2 = this.mMemoryBar;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mGuestMemoryBar;
        if (view3 != null) {
            view3.setVisibility(8);
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
