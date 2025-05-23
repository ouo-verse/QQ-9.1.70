package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.ui.detail.AbsDetailWidgetView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailCommentTipsWidgetView extends AbsDetailWidgetView {
    public FeedDetailCommentTipsWidgetView(Context context) {
        super(context);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.detail.AbsDetailWidgetView
    public void setWidgetData(Object obj) {
        super.setWidgetData(obj);
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
    }

    public FeedDetailCommentTipsWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initUI(Context context) {
        this.mWidgetType = 2;
        setBackgroundColor(0);
        LayoutInflater.from(context).inflate(j.j(1676), this);
    }

    public FeedDetailCommentTipsWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
