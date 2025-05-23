package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.util.ar;
import cooperation.qzone.util.QZLog;

/* loaded from: classes37.dex */
public class QZoneHomePageListView extends QZonePullToRefreshListView {
    private boolean U;

    /* loaded from: classes37.dex */
    public interface a {
    }

    public QZoneHomePageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView
    public int getSpringbackOffset() {
        if (this.U) {
            int scrollY = getScrollY();
            if (this.mOverscrollHeaderViewContainer != null && scrollY < 0) {
                int b16 = com.qzone.homepage.diy.util.a.b() * (-1);
                if (scrollY <= b16) {
                    this.mOverscrollHeadState = 0;
                    int k3 = (((ar.k() + scrollY) - com.qzone.homepage.diy.util.a.f47548a) * (-1)) + scrollY;
                    QZLog.i("QZoneHomePageListView", 4, " getSpringbackOffset resultY = " + k3 + " scrollY = " + scrollY);
                    return k3;
                }
                QZLog.i("QZoneHomePageListView", 4, " getSpringbackOffset scrollY = " + scrollY + " scrollShowHeight = " + b16);
            }
        }
        return super.getSpringbackOffset();
    }

    public void setIsDIYPage(boolean z16) {
        this.U = z16;
    }

    public void setScrollBackListener(a aVar) {
    }
}
