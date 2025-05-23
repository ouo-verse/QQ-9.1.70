package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDateHeader extends BaseFeedView implements FeedChildView {
    public static FeedViewSection.SectionController DateHeaderController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedDateHeader.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData != null && businessFeedData.showDateHeader && !businessFeedData.isBlankSearchNoResultTip) {
                CellFollowGuide cellFollowGuide = businessFeedData.cellFollowGuide;
                if (cellFollowGuide == null) {
                    return false;
                }
                int i3 = cellFollowGuide.feed_type;
                if (i3 != 1 && i3 != 4) {
                    return false;
                }
            }
            return true;
        }
    };
    ImageView mButton;
    TextView mDate;
    long time;

    public FeedDateHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    void initUI(Context context) {
        View inflate = LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1693), this);
        this.mDate = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2575));
        ImageView imageView = (ImageView) findViewById(com.qzone.adapter.feedcomponent.j.O(2576));
        this.mButton = imageView;
        imageView.setContentDescription("\u65e5\u671f\u9009\u62e9");
        this.mButton.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedDateHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedDateHeader feedDateHeader = FeedDateHeader.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedDateHeader.onFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(view, FeedElement.FEED_DATE_HEADER_ICON_CLICK, feedDateHeader.feedPosition, Long.valueOf(feedDateHeader.time));
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedDateHeader.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return false;
    }

    public void setData(long j3) {
        this.time = j3;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        this.mDate.setText(calendar.get(1) + "\u5e74" + (calendar.get(2) + 1) + "\u6708");
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            if (getParent() != null && (getParent() instanceof FeedView)) {
                ((FeedView) getParent()).setShowDateHeader(true);
            }
            setData(businessFeedData.getFeedCommInfo().getTime());
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
