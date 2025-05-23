package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.qzone.module.feedcomponent.actionreport.UserActionReportHelper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GalleryEx extends HorizontalScrollView {
    Adapter mAdapter;
    LinearLayout mContainer;
    AdapterDataSetObserver mDataSetObserver;
    int mItemCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class AdapterDataSetObserver extends DataSetObserver {
        AdapterDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            GalleryEx galleryEx = GalleryEx.this;
            galleryEx.mItemCount = galleryEx.getAdapter().getCount();
            GalleryEx.this.mContainer.removeAllViewsInLayout();
            int i3 = 0;
            while (true) {
                GalleryEx galleryEx2 = GalleryEx.this;
                if (i3 < galleryEx2.mItemCount) {
                    GalleryEx.this.mContainer.addView(galleryEx2.mAdapter.getView(i3, null, galleryEx2));
                    i3++;
                } else {
                    galleryEx2.requestLayout();
                    return;
                }
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            GalleryEx galleryEx = GalleryEx.this;
            galleryEx.mItemCount = 0;
            galleryEx.mContainer.removeAllViewsInLayout();
            GalleryEx.this.requestLayout();
        }
    }

    public GalleryEx(Context context) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContainer = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mContainer.setOrientation(0);
        addView(this.mContainer);
        setHorizontalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public View getSubView(int i3) {
        return this.mContainer.getChildAt(i3);
    }

    public int getSubViewCounts() {
        return this.mContainer.getChildCount();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        super.onOverScrolled(i3, i16, z16, z17);
        Adapter adapter = this.mAdapter;
        if (adapter == null || !(adapter instanceof FeedContainerAdapter)) {
            return;
        }
        UserActionReportHelper.feedContainerOverScroll(i3, i16, z16, z17, this.mItemCount, adapter);
        double d16 = i3;
        int i17 = AreaConst.SCREEN_WIDTH;
        if (d16 > i17 * 1.35d) {
            com.qzone.adapter.feedcomponent.i.H().T1(2, ((FeedContainerAdapter) this.mAdapter).getItem(2));
        } else if (d16 > i17 * 0.5d) {
            com.qzone.adapter.feedcomponent.i.H().T1(1, ((FeedContainerAdapter) this.mAdapter).getItem(1));
        } else {
            com.qzone.adapter.feedcomponent.i.H().T1(0, ((FeedContainerAdapter) this.mAdapter).getItem(0));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        UserActionReportHelper.containerOnTouchEvent(motionEvent, this.mAdapter);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(Adapter adapter) {
        AdapterDataSetObserver adapterDataSetObserver;
        this.mAdapter = adapter;
        if (adapter != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            adapter.unregisterDataSetObserver(adapterDataSetObserver);
        }
        this.mContainer.removeAllViewsInLayout();
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            this.mItemCount = adapter2.getCount();
            AdapterDataSetObserver adapterDataSetObserver2 = new AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver2;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver2);
            return;
        }
        this.mItemCount = 0;
    }

    public void resetView() {
        this.mItemCount = 0;
        this.mContainer.removeAllViewsInLayout();
        scrollTo(0, 0);
    }
}
