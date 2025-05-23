package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSuggestMoreViewB extends LinearLayout implements View.OnClickListener, FeedChildView {
    public static FeedViewSection.SectionController SuggestMoreController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedSuggestMoreViewB.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.getCellViewMore() == null || !(((businessFeedData.getUser().isCanShowFamousIcon() && businessFeedData.feedType == 4097) || businessFeedData.isAdFeeds()) && businessFeedData.isAdFeeds());
        }
    };
    static String TAG = "FeedSuggestMoreViewB";
    BusinessFeedData data;
    int feedPosition;
    com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    TextView textView;

    public FeedSuggestMoreViewB(Context context) {
        super(context);
        initUI(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.onFeedElementClickListener.onClick(this, FeedElement.FEED_SUGGEST_MORE, this.feedPosition, this.data);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        super.onMeasure(i3, i16);
        setMeasuredDimension(size, AreaConst.dp24);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.data = businessFeedData;
        setVisibility(0);
        this.textView.setText(businessFeedData.getCellViewMore().guide_content);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    void initUI(Context context) {
        setOrientation(0);
        setGravity(17);
        setOnClickListener(this);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(-9408400);
        this.textView.setTextSize(14.0f);
        this.textView.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = AreaConst.f48747dp2;
        addView(this.textView, layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(com.qzone.adapter.feedcomponent.j.h(754));
        int i3 = AreaConst.dp12;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.bottomMargin = AreaConst.f48746dp1;
        layoutParams2.leftMargin = AreaConst.dp5;
        addView(imageView, layoutParams2);
    }

    public FeedSuggestMoreViewB(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public void reset() {
        setVisibility(8);
    }

    public FeedSuggestMoreViewB(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initUI(context);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onRecycled() {
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
