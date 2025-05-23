package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.viewmodels.e;
import com.tencent.biz.qqcircle.widgets.pymk.QFSPYMKRecommendListView;

/* loaded from: classes5.dex */
public class QFSPersonalListPymkContainerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private QFSPYMKRecommendListView f93707d;

    public QFSPersonalListPymkContainerView(Context context) {
        this(context, null);
    }

    private void a() {
        setOrientation(1);
        QFSPYMKRecommendListView qFSPYMKRecommendListView = new QFSPYMKRecommendListView(getContext(), 1001);
        this.f93707d = qFSPYMKRecommendListView;
        qFSPYMKRecommendListView.setParentView(this);
        addView(this.f93707d);
    }

    public void setPYMKGuestViewModel(e eVar) {
        this.f93707d.setPYMKGuestViewModel(eVar);
    }

    public QFSPersonalListPymkContainerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPersonalListPymkContainerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93707d = null;
        a();
    }
}
