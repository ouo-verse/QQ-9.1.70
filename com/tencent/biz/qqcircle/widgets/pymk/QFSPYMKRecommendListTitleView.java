package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.mobileqq.R;

/* loaded from: classes5.dex */
public class QFSPYMKRecommendListTitleView extends LinearLayout implements IRefreshViewProvider {

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f93825d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93826e;

    public QFSPYMKRecommendListTitleView(Context context) {
        this(context, null);
    }

    private void a() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.f168749gq4, (ViewGroup) null);
        this.f93825d = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        this.f93826e = (TextView) this.f93825d.findViewById(R.id.f32920v2);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh */
    public boolean getIsManualRefreshing() {
        return false;
    }

    public void setTitle(String str) {
        this.f93826e.setText(str);
    }

    public QFSPYMKRecommendListTitleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPYMKRecommendListTitleView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(RecyclerView recyclerView) {
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(MotionEvent motionEvent) {
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener onRefreshListener) {
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean z16) {
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int i3) {
    }
}
