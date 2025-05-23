package com.qzone.reborn.feedx.presenter.friendplaying;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.compat.CustomHorizontallyScrollRecyclerViewX;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends vg.a {
    private CustomHorizontallyScrollRecyclerViewX F;
    private b G;
    private BusinessFeedData H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (c.this.G != null && c.this.G.getItemCount() > 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.left = ImmersiveUtils.dpToPx(13.0f);
                    rect.right = 0;
                    return;
                } else if (recyclerView.getChildAdapterPosition(view) < c.this.G.getItemCount() - 1) {
                    rect.left = ImmersiveUtils.dpToPx(10.0f);
                    rect.right = 0;
                    return;
                } else {
                    rect.left = ImmersiveUtils.dpToPx(10.0f);
                    rect.right = ImmersiveUtils.dpToPx(13.0f);
                    return;
                }
            }
            super.getItemOffsets(rect, view, recyclerView, state);
        }
    }

    private void I() {
        this.F.addItemDecoration(new a());
    }

    private void J() {
        if (this.G == null) {
            this.G = new b();
        }
        if (this.H.cellGameRecommend == null) {
            return;
        }
        this.F.setAdapter(this.G);
        this.G.i0(this.H);
        this.G.setDatas(this.H.cellGameRecommend.f50339e);
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = this.F;
        if (customHorizontallyScrollRecyclerViewX != null && (customHorizontallyScrollRecyclerViewX.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.F.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition instanceof QZoneFriendPlayingFeedContentItemView) {
                    ((QZoneFriendPlayingFeedContentItemView) findViewByPosition).onResume();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendPlayingFeedContentPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = this.F;
        if (customHorizontallyScrollRecyclerViewX == null || this.G == null || !(customHorizontallyScrollRecyclerViewX.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        int childCount = ((LinearLayoutManager) this.F.getLayoutManager()).getChildCount();
        for (int i3 = 0; i3 <= childCount; i3++) {
            View childAt = this.F.getChildAt(i3);
            if (childAt instanceof QZoneFriendPlayingFeedContentItemView) {
                ((QZoneFriendPlayingFeedContentItemView) childAt).onDestroy();
            }
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nle;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || this.H == businessFeedData) {
            return;
        }
        this.H = businessFeedData;
        J();
    }

    @Override // vg.a
    protected void C(View view) {
        CustomHorizontallyScrollRecyclerViewX customHorizontallyScrollRecyclerViewX = (CustomHorizontallyScrollRecyclerViewX) view.findViewById(R.id.n08);
        this.F = customHorizontallyScrollRecyclerViewX;
        customHorizontallyScrollRecyclerViewX.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        I();
    }
}
