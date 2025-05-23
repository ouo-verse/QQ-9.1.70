package com.tencent.richmediabrowser.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.richmediabrowser.listener.IBrowserItemScrollListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "BrowserScrollListener";
    private IBrowserItemScrollListener mItemScrollListener;
    private MainBrowserPresenter mMainBrowserPresenter;
    public int mScreenWidthPx;
    private int mTotalDistance;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "newState = " + i3);
        if (i3 == 0 || i3 == 1) {
            this.mTotalDistance = 0;
            this.mScreenWidthPx = ScreenUtils.getScreenWidth(recyclerView.getContext());
        }
        if (i3 == 0 && this.mMainBrowserPresenter != null && recyclerView.getChildCount() > 0) {
            try {
                int currentPosition = this.mMainBrowserPresenter.getCurrentPosition();
                int viewAdapterPosition = ((RecyclerView.LayoutParams) recyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
                int lastVisibleItemPosition = this.mMainBrowserPresenter.getLastVisibleItemPosition();
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "currentPosition = " + currentPosition + " viewPosition = " + viewAdapterPosition + " lastVisibleItemPosition = " + lastVisibleItemPosition);
                if (currentPosition != viewAdapterPosition && currentPosition != lastVisibleItemPosition) {
                    BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "onItemSelect position = " + viewAdapterPosition);
                    this.mMainBrowserPresenter.resetItemView(currentPosition);
                    this.mMainBrowserPresenter.onItemSelect(viewAdapterPosition);
                }
            } catch (Exception e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "onScrollStateChanged exception = " + e16.getMessage());
            }
        }
        IBrowserItemScrollListener iBrowserItemScrollListener = this.mItemScrollListener;
        if (iBrowserItemScrollListener != null) {
            if (i3 == 1) {
                iBrowserItemScrollListener.onScrollStart();
            } else if (i3 == 0) {
                iBrowserItemScrollListener.onScrollEnd();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        super.onScrolled(recyclerView, i3, i16);
        int i17 = this.mTotalDistance + i3;
        this.mTotalDistance = i17;
        if (this.mItemScrollListener != null && Math.abs(i17) > this.mScreenWidthPx / 2) {
            this.mItemScrollListener.onScrollHalfScreenWidth();
        }
    }

    public void setBrowserItemScrollListener(IBrowserItemScrollListener iBrowserItemScrollListener) {
        this.mItemScrollListener = iBrowserItemScrollListener;
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mMainBrowserPresenter = mainBrowserPresenter;
    }
}
