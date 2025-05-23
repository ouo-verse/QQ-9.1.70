package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.HippyRecyclerExtension;
import androidx.recyclerview.widget.HippyRecyclerPool;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderHost;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRecyclerViewWrapper<HRCV extends HippyRecyclerView> extends FrameLayout implements HippyViewBase, IHeaderHost {
    protected final HippyEngineContext hpContext;
    private NativeGestureDispatcher nativeGestureDispatcher;
    protected HRCV recyclerView;

    public HippyRecyclerViewWrapper(@NonNull Context context, HRCV hrcv) {
        super(context);
        this.recyclerView = hrcv;
        addView(hrcv, new FrameLayout.LayoutParams(-1, -1));
        HippyEngineContext engineContext = ((HippyInstanceContext) context).getEngineContext();
        this.hpContext = engineContext;
        HippyRecyclerExtension hippyRecyclerExtension = new HippyRecyclerExtension(hrcv, engineContext, hrcv.getNodePositionHelper());
        hrcv.setViewCacheExtension(hippyRecyclerExtension);
        hrcv.setHeaderHost(this);
        HippyRecyclerPool hippyRecyclerPool = new HippyRecyclerPool(engineContext, this, hippyRecyclerExtension, hrcv.getNodePositionHelper());
        hippyRecyclerPool.setViewAboundListener(hrcv);
        hrcv.setRecycledViewPool(hippyRecyclerPool);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderHost
    public void addOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderHost
    public void attachHeader(View view, FrameLayout.LayoutParams layoutParams) {
        addView(view, layoutParams);
        layout(getLeft(), getTop(), getRight(), getBottom());
        getViewTreeObserver().dispatchOnGlobalLayout();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.recyclerView.computeVerticalScrollOffset();
    }

    public View getChildAtWithCaches(int i3) {
        return this.recyclerView.getChildAtWithCaches(i3);
    }

    public int getChildCountWithCaches() {
        return this.recyclerView.getChildCountWithCaches();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.nativeGestureDispatcher;
    }

    public HRCV getRecyclerView() {
        return this.recyclerView;
    }

    public RecyclerViewEventHelper getRecyclerViewEventHelper() {
        return this.recyclerView.getRecyclerViewEventHelper();
    }

    public void onBatchComplete() {
        this.recyclerView.onBatchComplete();
    }

    public void onBatchStart() {
        this.recyclerView.onBatchStart();
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderHost
    @RequiresApi(api = 16)
    public void removeOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void scrollToContentOffset(double d16, double d17, boolean z16, int i3) {
        this.recyclerView.scrollToContentOffset(d16, d17, z16, i3);
    }

    public void scrollToIndex(int i3, int i16, boolean z16, int i17) {
        this.recyclerView.scrollToIndex(i3, i16, z16, i17);
    }

    public void scrollToTop() {
        this.recyclerView.scrollToTop();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.nativeGestureDispatcher = nativeGestureDispatcher;
    }

    public void setListData() {
        this.recyclerView.setListData();
    }

    public void setRowShouldSticky(boolean z16) {
        this.recyclerView.setRowShouldSticky(z16);
    }

    public void setScrollEnable(boolean z16) {
        this.recyclerView.setScrollEnable(z16);
    }
}
