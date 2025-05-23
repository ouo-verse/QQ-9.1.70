package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.pull2refresh.XRecyclerView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RefreshRecyclerView extends XRecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f115571d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f115572e;

    public RefreshRecyclerView(Context context) {
        super(context);
        this.f115571d = true;
        this.f115572e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.XRecyclerView, com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public boolean isScroll2Top() {
        if (!this.f115571d) {
            return false;
        }
        return super.isScroll2Top();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void rebound() {
        if (!this.f115572e) {
            super.rebound();
        }
    }

    public void setIsAutoScrolling(boolean z16) {
        this.f115572e = z16;
    }

    public void setRefreshEnable(boolean z16) {
        this.f115571d = z16;
    }

    public RefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f115571d = true;
        this.f115572e = false;
    }

    public RefreshRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f115571d = true;
        this.f115572e = false;
    }
}
