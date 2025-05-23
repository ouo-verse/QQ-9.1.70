package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.RegionDrawableData;
import com.tencent.mobileqq.R;
import com.tencent.richmediabrowser.listener.IBrowserItemScrollListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener;
import com.tencent.richmediabrowser.view.recyclerview.DragView;
import f04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MainBrowserScene extends BrowserBaseScene implements DragView.OnGestureChangeListener, IBrowserItemScrollListener {
    private static final String TAG = "MainBrowserScene";
    private boolean isNeedFullScreen;
    private volatile boolean isRemoveFullScreen;
    public Context mContext;
    public DragView mDragView;
    public Intent mIntent;

    public MainBrowserScene(Context context, MainBrowserPresenter mainBrowserPresenter) {
        super(context);
        this.isRemoveFullScreen = false;
        this.isNeedFullScreen = true;
        this.mContext = context;
        this.mainBrowserPresenter = mainBrowserPresenter;
    }

    private void setFullScreen(boolean z16) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (z16) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean back() {
        if (this.mContext != null) {
            BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "MainBrowserScene.back[" + this.mContext.hashCode() + "]");
        }
        if (this.isNeedFullScreen && !this.isRemoveFullScreen) {
            this.isRemoveFullScreen = true;
            setFullScreen(false);
        }
        return super.back();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void buildComplete() {
        super.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void buildParams(Intent intent) {
        this.mIntent = intent;
        super.buildParams(intent);
        BrowserScrollListener browserScrollListener = this.scrollListener;
        if (browserScrollListener != null) {
            browserScrollListener.setBrowserItemScrollListener(this);
        }
        if (intent != null) {
            this.isNeedFullScreen = intent.getBooleanExtra("isNeedFullScreen", true);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void buildView() {
        super.buildView();
        initView();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    protected BrowserAdapter createGalleryAdapter(Context context) {
        BrowserAdapter browserAdapter = new BrowserAdapter(context);
        this.mAdapter = browserAdapter;
        browserAdapter.setPresenter(this.mainBrowserPresenter);
        return this.mAdapter;
    }

    public Rect getAnimationEndDstRect() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            return ((BrowserBaseView) currentView).getAnimationEndDstRect();
        }
        return null;
    }

    public BrowserAdapter.BrowserViewHolder getBrowserViewHolder(int i3) {
        BrowserRecyclerView browserRecyclerView;
        if (this.mainBrowserPresenter != null && (browserRecyclerView = this.recyclerView) != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = browserRecyclerView.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof BrowserAdapter.BrowserViewHolder) {
                return (BrowserAdapter.BrowserViewHolder) findViewHolderForAdapterPosition;
            }
            return null;
        }
        return null;
    }

    public c getCurrentView() {
        return getView(this.mainBrowserPresenter.getCurrentPosition());
    }

    public RichMediaBrowserInfo getItem(int i3) {
        return this.mAdapter.getItem(i3);
    }

    public int getLastVisibleItemPosition() {
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager.findLastVisibleItemPosition();
        }
        return -1;
    }

    public c getView(int i3) {
        BrowserRecyclerView browserRecyclerView;
        if (this.mainBrowserPresenter != null && (browserRecyclerView = this.recyclerView) != null) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = browserRecyclerView.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof BrowserAdapter.BrowserViewHolder) {
                return ((BrowserAdapter.BrowserViewHolder) findViewHolderForAdapterPosition).itemView;
            }
            return null;
        }
        return null;
    }

    public void initView() {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            this.recyclerView.scrollToPosition(mainBrowserModel.getSelectedIndex());
        }
        this.recyclerView.setVisibility(0);
        DragView dragView = (DragView) this.mRoot.findViewById(R.id.bq8);
        this.mDragView = dragView;
        dragView.setGestureChangeListener(this);
        this.mDragView.setRatioModify(true);
        this.mDragView.init();
        MainBrowserPresenter mainBrowserPresenter2 = this.mainBrowserPresenter;
        if (mainBrowserPresenter2 != null) {
            this.mDragView.setEnableDrag(mainBrowserPresenter2.getParamsBuilder().f27658h);
        }
    }

    public boolean isNeedDisallowInterceptEvent(MotionEvent motionEvent) {
        c currentView = getCurrentView();
        if ((currentView instanceof BrowserBaseView) && ((BrowserBaseView) currentView).isNeedDisallowInterceptEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean needEnterRectAnimation() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            return ((BrowserBaseView) currentView).needEnterRectAnimation();
        }
        return false;
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public boolean needExitRectAnimation() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            return ((BrowserBaseView) currentView).needExitRectAnimation();
        }
        return false;
    }

    public void notifyDataSetChanged() {
        BrowserAdapter browserAdapter = this.mAdapter;
        if (browserAdapter != null) {
            browserAdapter.notifyDataSetChanged();
        }
    }

    public void notifyImageModelDataChanged() {
        BrowserAdapter browserAdapter = this.mAdapter;
        if (browserAdapter != null && this.mainBrowserPresenter != null) {
            browserAdapter.reset();
            notifyDataSetChanged();
            scrollToCurrentPosition();
            BrowserLogHelper.getInstance().getGalleryLog().e(TAG, 2, "notifyImageModelDataChanged");
        }
    }

    public void notifyItemChanged(int i3) {
        this.mAdapter.notifyItemChanged(i3);
    }

    public void onConfigurationChanged(Configuration configuration) {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onConfigurationChanged(configuration);
        }
    }

    public void onContentMove(float f16) {
        if (this.isNeedFullScreen && !this.isRemoveFullScreen) {
            this.isRemoveFullScreen = true;
            setFullScreen(false);
        }
        this.bgView.setAlpha(f16);
        if (f16 < 0.8f) {
            c currentView = getCurrentView();
            if (currentView instanceof BrowserBaseView) {
                ((BrowserBaseView) currentView).updateUI();
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void onDestroy() {
        if (this.mContext != null) {
            BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "MainBrowserScene.onDestroy[" + this.mContext.hashCode() + "]");
        }
        super.onDestroy();
        DragView dragView = this.mDragView;
        if (dragView != null) {
            dragView.setGestureChangeListener(null);
            this.mDragView.onDestroy();
            this.mDragView = null;
        }
        BrowserScrollListener browserScrollListener = this.scrollListener;
        if (browserScrollListener != null) {
            browserScrollListener.setBrowserItemScrollListener(null);
            this.scrollListener = null;
        }
    }

    public void onDoubleTap() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onDoubleTap(this.mainBrowserPresenter.getCurrentPosition());
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene, com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationEnd() {
        super.onEnterAnimationEnd();
        showContentView(true);
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            BrowserBaseView browserBaseView = (BrowserBaseView) currentView;
            browserBaseView.isInEnterAnim = false;
            browserBaseView.onEnterAnimationEnd();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene, com.tencent.richmediabrowser.animation.AnimationLister
    public void onEnterAnimationStart() {
        super.onEnterAnimationStart();
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            BrowserBaseView browserBaseView = (BrowserBaseView) currentView;
            browserBaseView.isInEnterAnim = true;
            browserBaseView.onEnterAnimationStart();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene, com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationEnd() {
        super.onExitAnimationEnd();
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            BrowserBaseView browserBaseView = (BrowserBaseView) currentView;
            browserBaseView.isInExitAnim = false;
            browserBaseView.onExitAnimationEnd();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene, com.tencent.richmediabrowser.animation.AnimationLister
    public void onExitAnimationStart() {
        super.onExitAnimationStart();
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            BrowserBaseView browserBaseView = (BrowserBaseView) currentView;
            browserBaseView.isInExitAnim = true;
            browserBaseView.onExitAnimationStart();
        }
        showContentView(false);
    }

    public void onGestureFinish() {
        if (this.mContext != null) {
            BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "onGestureFinish[" + this.mContext.hashCode() + "]");
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void onItemSelected(int i3) {
        super.onItemSelected(i3);
        c view = getView(i3);
        if (view instanceof BrowserBaseView) {
            ((BrowserBaseView) view).onItemSelected(i3);
        }
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return false;
        }
        return back();
    }

    public void onResetPosition() {
        if (this.mContext != null) {
            BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "onResetPosition[" + this.mContext.hashCode() + "]");
        }
        if (this.isNeedFullScreen && this.isRemoveFullScreen) {
            this.isRemoveFullScreen = false;
            setFullScreen(true);
        }
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).updateUI();
        }
    }

    public void onScale() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScale(this.mainBrowserPresenter.getCurrentPosition());
        }
    }

    public void onScaleBegin() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScaleBegin(this.mainBrowserPresenter.getCurrentPosition());
        }
    }

    public void onScaleEnd() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScaleEnd(this.mainBrowserPresenter.getCurrentPosition());
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserItemScrollListener
    public void onScrollEnd() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScrollEnd();
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserItemScrollListener
    public void onScrollHalfScreenWidth() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScrollHalfScreenWidth();
        }
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserItemScrollListener
    public void onScrollStart() {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onScrollStart();
        }
    }

    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        c currentView = getCurrentView();
        if (currentView instanceof BrowserBaseView) {
            ((BrowserBaseView) currentView).onShowAreaChanged(i3, view, regionDrawableData);
        }
    }

    public void requestDisallowInterceptDragEvent(boolean z16) {
        DragView dragView = this.mDragView;
        if (dragView != null) {
            dragView.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z16) {
        BrowserRecyclerView browserRecyclerView = this.recyclerView;
        if (browserRecyclerView != null) {
            browserRecyclerView.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public void scrollToCurrentPosition() {
        MainBrowserPresenter mainBrowserPresenter;
        BrowserRecyclerView browserRecyclerView = this.recyclerView;
        if (browserRecyclerView != null && (mainBrowserPresenter = this.mainBrowserPresenter) != null) {
            browserRecyclerView.scrollToPosition(mainBrowserPresenter.getCurrentPosition());
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseScene
    public void updateSystemUIVisablity() {
        if (this.isNeedFullScreen) {
            this.isRemoveFullScreen = false;
            setFullScreen(true);
        }
    }

    public void onClickDragView() {
    }
}
