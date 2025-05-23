package com.qzone.module.feedcomponent.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.ui.detail.AbsDetailWidgetView;
import com.qzone.proxy.feedcomponent.util.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailBlankAreaWidgetView extends AbsDetailWidgetView {
    private View childView;
    private boolean mNeedBackground;

    public FeedDetailBlankAreaWidgetView(Context context) {
        super(context);
        this.mNeedBackground = true;
        this.childView = null;
    }

    public void initUI(Context context) {
        if (this.mWidgetData instanceof Integer) {
            this.mWidgetType = 1;
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, g.a(((Integer) this.mWidgetData).intValue())));
            view.setBackgroundColor(j.m());
            addView(view);
            this.childView = view;
        }
    }

    public void setNeedBackground(boolean z16) {
        View view = this.childView;
        if (view == null || view.getParent() == null) {
            return;
        }
        if (!z16) {
            this.childView.setBackground(null);
        } else {
            this.childView.setBackgroundColor(j.m());
        }
    }

    public FeedDetailBlankAreaWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNeedBackground = true;
        this.childView = null;
    }

    public FeedDetailBlankAreaWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mNeedBackground = true;
        this.childView = null;
    }
}
