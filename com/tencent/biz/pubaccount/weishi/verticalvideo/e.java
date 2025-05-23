package com.tencent.biz.pubaccount.weishi.verticalvideo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    private VideoFeedsRecyclerView f82034a;

    public e(Context context, VideoFeedsRecyclerView videoFeedsRecyclerView, int i3, boolean z16) {
        super(context, i3, z16);
        this.f82034a = videoFeedsRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutManager
    public int getExtraLayoutSpace(RecyclerView.State state) {
        return super.getExtraLayoutSpace(state) + 200;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void removeAndRecycleView(View view, RecyclerView.Recycler recycler) {
        if (a(view)) {
            return;
        }
        super.removeAndRecycleView(view, recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void removeAndRecycleViewAt(int i3, RecyclerView.Recycler recycler) {
        if (a(getChildAt(i3))) {
            return;
        }
        super.removeAndRecycleViewAt(i3, recycler);
    }

    private boolean a(View view) {
        if (view == null) {
            return false;
        }
        int layoutPosition = this.f82034a.getChildViewHolder(view).getLayoutPosition();
        int s16 = this.f82034a.s();
        return s16 >= 0 && (layoutPosition == s16 + 1 || layoutPosition == s16 - 1);
    }
}
