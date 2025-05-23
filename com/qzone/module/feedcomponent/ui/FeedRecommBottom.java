package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellViewMore;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommBottom extends BaseFeedView {
    private CellViewMore cellViewMore;
    private BusinessFeedData mFeedData;
    private TextView mViewMoreText;

    public FeedRecommBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    void initUI(Context context) {
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1699), this);
        this.mViewMoreText = (TextView) findViewById(com.qzone.adapter.feedcomponent.j.O(2607));
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommBottom.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedRecommBottom feedRecommBottom = FeedRecommBottom.this;
                com.qzone.proxy.feedcomponent.ui.g gVar = feedRecommBottom.onFeedElementClickListener;
                if (gVar != null) {
                    gVar.onClick(feedRecommBottom, FeedElement.FEED_RECOMM_BOTTOM_CLICK, feedRecommBottom.feedPosition, feedRecommBottom.cellViewMore);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
        CellViewMore cellViewMore;
        TextView textView = this.mViewMoreText;
        if (textView == null || (cellViewMore = this.cellViewMore) == null) {
            return;
        }
        textView.setText(cellViewMore.guide_content);
        this.mViewMoreText.setVisibility(0);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        if (businessFeedData == null || businessFeedData.getCellViewMore() == null) {
            return;
        }
        this.cellViewMore = businessFeedData.getCellViewMore();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
    }
}
