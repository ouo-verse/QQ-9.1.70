package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.detail.AbsDetailWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailEnterHostSpaceWidgetView extends AbsDetailWidgetView {
    public FeedDetailEnterHostSpaceWidgetView(Context context) {
        super(context);
        initUI(context);
    }

    void initUI(Context context) {
        this.mWidgetType = 0;
        LayoutInflater.from(context).inflate(j.j(1674), this);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.detail.FeedDetailEnterHostSpaceWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (((AbsDetailWidgetView) FeedDetailEnterHostSpaceWidgetView.this).mWidgetData instanceof User) {
                    User user = (User) ((AbsDetailWidgetView) FeedDetailEnterHostSpaceWidgetView.this).mWidgetData;
                    if (((AbsDetailWidgetView) FeedDetailEnterHostSpaceWidgetView.this).onFeedElementClickListener != null) {
                        ((AbsDetailWidgetView) FeedDetailEnterHostSpaceWidgetView.this).onFeedElementClickListener.onClick(view, FeedElement.DETAIL_WIDGET_ENTER_HOST_SPACE_CLICK, 0, user);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    public FeedDetailEnterHostSpaceWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public FeedDetailEnterHostSpaceWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initUI(context);
    }
}
