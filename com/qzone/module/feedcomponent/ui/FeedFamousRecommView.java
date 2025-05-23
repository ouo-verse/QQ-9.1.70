package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.math.BigDecimal;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedFamousRecommView extends BaseFeedView implements FeedChildView {
    public static FeedViewSection.SectionController FamousRecommController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedFamousRecommView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getRecommAction() == null;
        }
    };
    BusinessFeedData feedData;
    VisitAndPraiseAvatarsView followAvatarView;
    TextView followBtn;
    View.OnClickListener mListener;
    CellRecommAction recommAction;

    public FeedFamousRecommView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedFamousRecommView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedFamousRecommView.this.onFeedElementClickListener != null && view.getId() == com.qzone.adapter.feedcomponent.j.O(2388)) {
                    FeedFamousRecommView feedFamousRecommView = FeedFamousRecommView.this;
                    BusinessFeedData businessFeedData = feedFamousRecommView.feedData;
                    boolean z16 = !businessFeedData.isFamousRecommFollowed;
                    businessFeedData.isFamousRecommFollowed = z16;
                    TextView textView = feedFamousRecommView.followBtn;
                    if (z16) {
                        str = "\u5df2\u5173\u6ce8";
                    } else {
                        str = "\u5173\u6ce8";
                    }
                    textView.setText(str);
                    FeedFamousRecommView feedFamousRecommView2 = FeedFamousRecommView.this;
                    com.qzone.proxy.feedcomponent.ui.g gVar = feedFamousRecommView2.onFeedElementClickListener;
                    FeedElement feedElement = FeedElement.FOLLOW_FAMOUS;
                    int i3 = feedFamousRecommView2.feedPosition;
                    gVar.onClick(view, feedElement, i3, new com.qzone.proxy.feedcomponent.model.f(i3, 0, false));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        initView(context);
    }

    void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1650), this);
        this.followAvatarView = (VisitAndPraiseAvatarsView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2387));
        this.followBtn = (TextView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2388));
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public boolean isEmptyData() {
        return this.recommAction == null;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = this.followAvatarView;
        if (visitAndPraiseAvatarsView != null) {
            visitAndPraiseAvatarsView.onRecycled();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        String str;
        if (this.recommAction == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        String format = String.format("%s\u4eba\u5df2\u5173\u6ce8", getStarNumDisplayText(this.recommAction.allcount));
        ArrayList<User> arrayList = this.recommAction.userList;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(4);
        int size = this.recommAction.userList.size();
        for (int i3 = 0; i3 < 4 && i3 < size; i3++) {
            arrayList2.add(new CellLikeInfo.LikeMan(this.recommAction.userList.get(i3), 0, null));
        }
        this.followAvatarView.setPraiseData(arrayList2, arrayList2.size(), false, format, com.qzone.adapter.feedcomponent.j.o(), 13);
        TextView textView = this.followBtn;
        if (this.feedData.isFamousRecommFollowed) {
            str = "\u5df2\u5173\u6ce8";
        } else {
            str = "\u5173\u6ce8";
        }
        textView.setText(str);
        this.followAvatarView.setOnFeedElementClickListener(this.onFeedElementClickListener);
        this.followBtn.setOnClickListener(this.mListener);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.feedData = businessFeedData;
        if (businessFeedData != null) {
            this.recommAction = businessFeedData.getRecommAction();
        } else {
            this.recommAction = null;
        }
        update();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.recommAction = null;
        VisitAndPraiseAvatarsView visitAndPraiseAvatarsView = this.followAvatarView;
        if (visitAndPraiseAvatarsView != null) {
            visitAndPraiseAvatarsView.reset();
        }
    }

    String getStarNumDisplayText(long j3) {
        if (j3 > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            try {
                return new BigDecimal(j3).movePointLeft(8).setScale(2, 4) + "\u4ebf";
            } catch (Exception unused) {
                return String.valueOf(j3);
            }
        }
        if (j3 > 10000000) {
            return String.format("%d\u5343\u4e07", Long.valueOf(j3 / 10000000));
        }
        if (j3 > 1000000) {
            return String.format("%d\u767e\u4e07", Long.valueOf(j3 / 1000000));
        }
        if (j3 > JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return String.format("%d\u5341\u4e07", Long.valueOf(j3 / JsonGrayBusiId.UI_RESERVE_100000_110000));
        }
        if (j3 > 10000) {
            return String.format("%d\u4e07", Long.valueOf(j3 / 10000));
        }
        return String.valueOf(j3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
