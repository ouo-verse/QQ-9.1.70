package com.tencent.mtt.supportui.views.recyclerview;

import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class RecyclerAdapter extends RecyclerViewBase.Adapter<RecyclerView.ViewHolderWrapper> implements View.OnClickListener {
    static final String TAG = "RecyclerAdapter";
    public View mDefaultLoadingView;
    public RecyclerView mParentRecyclerView;
    protected RecyclerViewItemListener mRecyclerViewItemListener;
    DataHolder mRoot;
    List<Integer> mSuspentedPos;
    public int mLoadingStatus = 0;
    ArrayList<DataHolder> mDataList = new ArrayList<>();
    protected int mContentHeight = -1;
    SparseIntArray mOffsetMap = null;
    public ArrayList<Integer> mItemWidthList = null;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class DataHolder {
        public int mItemViewType = 0;
        public int mItemHeight = RecyclerViewItem.ITEM_VIEW_DEFAULT_HEIGHT;
        public Object mData = null;
        public int mItemViewStyle = 0;
        public int mTopMargin = 0;
        public int mBottomMargin = 0;
        public int mLeftMargin = 0;
        public int mRightMargin = 0;
        public boolean mHasDivider = true;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface RecyclerViewItemListener {
        void onCheckedChanged(View view, int i3, boolean z16);

        void onItemClick(View view, int i3, ContentHolder contentHolder);

        void onItemClickInEditMode(View view, int i3, ContentHolder contentHolder);

        boolean onItemLongClick(View view, int i3);
    }

    public RecyclerAdapter(RecyclerView recyclerView) {
        this.mParentRecyclerView = recyclerView;
    }

    public final void addData(DataHolder dataHolder) {
        if (dataHolder != null) {
            this.mDataList.add(dataHolder);
            this.mContentHeight = -1;
        }
    }

    public void addSuspentedPos(int i3) {
        if (!this.mParentRecyclerView.hasSuspentedItem()) {
            return;
        }
        if (this.mSuspentedPos == null) {
            this.mSuspentedPos = new ArrayList();
        }
        if (!this.mSuspentedPos.contains(Integer.valueOf(i3))) {
            this.mSuspentedPos.add(Integer.valueOf(i3));
        }
    }

    public final void appendData(ArrayList<DataHolder> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mDataList.addAll(arrayList);
            this.mContentHeight = -1;
        }
    }

    int binarySearch(SparseIntArray sparseIntArray, int i3) {
        if (sparseIntArray != null && sparseIntArray.size() != 0) {
            int keyAt = sparseIntArray.keyAt(0);
            int keyAt2 = sparseIntArray.keyAt(sparseIntArray.size() - 1);
            while (keyAt <= keyAt2) {
                int i16 = ((keyAt2 - keyAt) >> 1) + keyAt;
                int itemRangeCompare = itemRangeCompare(i16, sparseIntArray.valueAt(i16), i3);
                if (itemRangeCompare == 0) {
                    return i16;
                }
                if (itemRangeCompare > 0) {
                    keyAt2 = i16 - 1;
                } else {
                    keyAt = i16 + 1;
                }
            }
        }
        return -1;
    }

    void calculateOffsetMapIfNeed() {
        if (this.mOffsetMap == null) {
            this.mOffsetMap = new SparseIntArray();
        }
        if (this.mDataChanged) {
            this.mOffsetMap.clear();
            getItemCount();
            int headerViewCount = getHeaderViewCount();
            int i3 = 0;
            for (int i16 = 1; i16 <= headerViewCount; i16++) {
                i3 += getHeaderViewHeight(i16);
            }
            this.mParentRecyclerView.mLayout.calculateOffsetMap(this.mOffsetMap, i3);
            this.mDataChanged = false;
        }
    }

    public void clearData() {
        this.mDataList.clear();
        this.mContentHeight = -1;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void dataChanged() {
        super.dataChanged();
    }

    public void deSelecteItem(int i3) {
        View findViewByPosition = this.mParentRecyclerView.findViewByPosition(i3);
        if (findViewByPosition != null) {
            findViewByPosition.setSelected(false);
        }
    }

    public void deleteItem(int i3) {
        onItemDeleted(i3);
        if (this.mParentRecyclerView != null && doDeleteItem()) {
            RecyclerView recyclerView = this.mParentRecyclerView;
            recyclerView.postAdapterUpdate(recyclerView.obtainUpdateOp(1, i3, 1));
        }
    }

    void fillSuspentedPos() {
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            if (isSuspentedItem(i3)) {
                addSuspentedPos(i3);
            }
        }
        Collections.sort(this.mSuspentedPos);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int findNextSuspentedPos(int i3) {
        int i16;
        List<Integer> list = this.mSuspentedPos;
        if (list != null && !list.isEmpty()) {
            int findPrevSuspentedPos = findPrevSuspentedPos(i3);
            int indexOf = this.mSuspentedPos.indexOf(Integer.valueOf(findPrevSuspentedPos));
            if (findPrevSuspentedPos != -1 && (i16 = indexOf + 1) < this.mSuspentedPos.size()) {
                return this.mSuspentedPos.get(i16).intValue();
            }
        }
        return -1;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int findPrevSuspentedPos(int i3) {
        Integer num;
        initSuspentedPosIfNeed();
        List<Integer> list = this.mSuspentedPos;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.mSuspentedPos.size();
        int i16 = 0;
        while (true) {
            if (i16 < size) {
                int intValue = this.mSuspentedPos.get(i16).intValue();
                if (this.mSuspentedPos.get(i16).intValue() >= i3) {
                    if (intValue == i3) {
                        return intValue;
                    }
                    if (i16 == 0) {
                        return -1;
                    }
                    num = this.mSuspentedPos.get(i16 - 1);
                } else {
                    i16++;
                }
            } else {
                num = this.mSuspentedPos.get(size - 1);
                break;
            }
        }
        return num.intValue();
    }

    public void forceUpdateOffsetMap() {
        this.mDataChanged = true;
        calculateOffsetMapIfNeed();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int[] getBeginPositionWithOffset(int i3) {
        boolean z16;
        int[] iArr = new int[2];
        int itemCount = getItemCount() + getFooterViewCount();
        int headerViewCount = getHeaderViewCount();
        int cachedTotalHeight = this.mParentRecyclerView.getCachedTotalHeight();
        int i16 = 0;
        for (int i17 = 1; i17 <= headerViewCount; i17++) {
            i16 += getHeaderViewHeight(i17);
        }
        if (i3 >= cachedTotalHeight) {
            iArr[0] = itemCount;
            iArr[1] = (cachedTotalHeight - getItemHeight(itemCount)) - i3;
        } else if (i3 < 0) {
            iArr[0] = -headerViewCount;
            iArr[1] = (-i16) - i3;
        } else if (i3 < i16) {
            int i18 = -headerViewCount;
            int i19 = 0;
            while (true) {
                if (i18 >= 0) {
                    break;
                }
                int i26 = -i18;
                i19 += getHeaderViewHeight(i26);
                if (i19 > i3) {
                    iArr[0] = i18;
                    iArr[1] = (i19 - getHeaderViewHeight(i26)) - i3;
                    break;
                }
                i18++;
            }
        } else {
            calculateOffsetMapIfNeed();
            int size = this.mOffsetMap.size() - 1;
            int itemRange = this.mOffsetMap.get(size) + getItemRange(size);
            if (i3 > itemRange) {
                int footerViewCount = getFooterViewCount();
                if (footerViewCount > 0) {
                    int i27 = 1;
                    while (true) {
                        if (i27 <= footerViewCount) {
                            itemRange += getFooterViewHeight(i27);
                            if (itemRange > i3) {
                                iArr[0] = size + i27;
                                iArr[1] = (itemRange - getFooterViewHeight(i27)) - i3;
                                z16 = true;
                                break;
                            }
                            i27++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        iArr[0] = size + i27;
                        iArr[1] = (itemRange - getFooterViewHeight(i27)) - i3;
                    }
                }
                return iArr;
            }
            int binarySearch = binarySearch(this.mOffsetMap, i3);
            if (i3 == 0) {
                binarySearch = 0;
            }
            if (binarySearch != -1) {
                int i28 = this.mOffsetMap.get(binarySearch);
                int i29 = this.mParentRecyclerView.mLayoutType;
                if (i29 != 2) {
                    if (i29 == 1) {
                        iArr[0] = binarySearch;
                    } else if (i29 == 3) {
                        iArr[0] = binarySearch;
                    }
                    iArr[1] = i28 - i3;
                }
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (this.mOffsetMap.get(binarySearch) == i28);
                iArr[0] = binarySearch + 1;
                iArr[1] = i28 - i3;
            }
        }
        return iArr;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCardItemViewType(int i3) {
        try {
            if (this.mDataList.size() > i3 && i3 >= 0) {
                return this.mDataList.get(i3).mItemViewStyle;
            }
            return super.getCardItemViewType(i3);
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getCustomFooterView(int i3) {
        return null;
    }

    public int getCustomFooterViewCount() {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomFooterViewHeight() {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomFooterViewWidth() {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomHeaderViewHeight() {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getCustomHeaderViewWidth() {
        return 0;
    }

    public final DataHolder getDataHolder(int i3) {
        try {
            if (this.mDataList.size() > i3 && i3 >= 0) {
                return this.mDataList.get(i3);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<DataHolder> getDataHolderList() {
        return new ArrayList<>(this.mDataList);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public View getFooterView(int i3) {
        if (this.mLoadingStatus != 0) {
            if (i3 == getFooterViewCount()) {
                if (this.mDefaultLoadingView == null) {
                    RecyclerView recyclerView = this.mParentRecyclerView;
                    this.mDefaultLoadingView = recyclerView.createFooterView(recyclerView.getContext());
                }
                View view = this.mDefaultLoadingView;
                if (view != null) {
                    view.setOnClickListener(this);
                }
                KeyEvent.Callback callback = this.mDefaultLoadingView;
                if (callback != null && (callback instanceof IRecyclerViewFooter)) {
                    ((IRecyclerViewFooter) callback).setLoadingStatus(this.mLoadingStatus);
                }
                return this.mDefaultLoadingView;
            }
            return getCustomFooterView(i3);
        }
        return getCustomFooterView(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getFooterViewCount() {
        if (this.mLoadingStatus != 0) {
            return getCustomFooterViewCount() + 1;
        }
        return getCustomFooterViewCount();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getFooterViewHeight(int i3) {
        if (this.mLoadingStatus != 0) {
            if (i3 == getFooterViewCount()) {
                return getDefaultFooterHeight();
            }
            return getCustomFooterViewHeight(i3);
        }
        return getCustomFooterViewHeight(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public boolean getFooterViewInBottomMode() {
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public View getHeaderView(int i3) {
        return null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getHeaderViewCount() {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getHeaderViewHeight(int i3) {
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getHeightBefore(int i3) {
        int i16 = -getHeaderViewCount();
        if (i3 >= i16) {
            if (i3 >= 0) {
                calculateOffsetMapIfNeed();
                return this.mOffsetMap.get(i3);
            }
            int i17 = 0;
            while (i16 < i3) {
                i17 += getHeaderViewHeight(-i16);
                i16++;
            }
            return i17;
        }
        throw new IllegalStateException("pos less than header count,should not happened");
    }

    public RecyclerViewItemListener getItemClickListener() {
        return this.mRecyclerViewItemListener;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemHeight(int i3) {
        try {
            if (this.mDataList.size() > i3 && i3 >= 0) {
                return this.mDataList.get(i3).mItemHeight;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemMaigin(int i3, int i16) {
        int i17;
        if (i16 >= this.mDataList.size() || i16 < 0) {
            return 0;
        }
        try {
            DataHolder dataHolder = this.mDataList.get(i16);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return 0;
                        }
                        i17 = dataHolder.mBottomMargin;
                    } else {
                        i17 = dataHolder.mRightMargin;
                    }
                } else {
                    i17 = dataHolder.mTopMargin;
                }
            } else {
                i17 = dataHolder.mLeftMargin;
            }
            return i17;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getItemOffset(int i3) {
        SparseIntArray sparseIntArray = this.mOffsetMap;
        if (sparseIntArray != null) {
            return sparseIntArray.get(i3);
        }
        return -1;
    }

    protected int getItemRange(int i3) {
        return getItemHeight(i3) + getItemMaigin(1, i3) + getItemMaigin(3, i3) + 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getItemViewType(int i3) {
        try {
            if (this.mDataList.size() > i3 && i3 >= 0) {
                return this.mDataList.get(i3).mItemViewType;
            }
            return super.getItemViewType(i3);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getItemWidth(int i3) {
        ArrayList<Integer> arrayList;
        try {
            if (isAutoCalculateItemHeight() && (arrayList = this.mItemWidthList) != null && arrayList.size() > i3 && i3 >= 0) {
                return this.mItemWidthList.get(i3).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getListTotalHeight() {
        return super.getListTotalHeight() + this.mParentRecyclerView.getPaddingTop() + this.mParentRecyclerView.getPaddingBottom();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public int getTotalHeight() {
        if (isAutoCalculateItemHeight()) {
            this.mContentHeight = -1;
        }
        if (this.mContentHeight == -1) {
            int itemCount = getItemCount();
            this.mContentHeight = 0;
            if (this.mParentRecyclerView.mLayoutType == 1) {
                for (int i3 = 0; i3 < itemCount; i3++) {
                    int itemHeight = this.mContentHeight + getItemHeight(i3);
                    this.mContentHeight = itemHeight;
                    int itemMaigin = itemHeight + getItemMaigin(1, i3);
                    this.mContentHeight = itemMaigin;
                    this.mContentHeight = itemMaigin + getItemMaigin(3, i3);
                }
            }
        }
        return this.mContentHeight;
    }

    protected RecyclerViewItem getViewItem(RecyclerViewBase recyclerViewBase) {
        return this.mParentRecyclerView.createViewItem();
    }

    protected RecyclerViewItem getViewItemWithPos(RecyclerViewBase recyclerViewBase, int i3) {
        return getViewItem(recyclerViewBase);
    }

    public final boolean hasData() {
        return !this.mDataList.isEmpty();
    }

    public int indexOf(DataHolder dataHolder) {
        return this.mDataList.indexOf(dataHolder);
    }

    void initSuspentedPosIfNeed() {
        if (this.mSuspentedPos == null) {
            this.mSuspentedPos = new ArrayList();
            fillSuspentedPos();
        }
        if (this.mSuspentionDataChanged) {
            this.mSuspentedPos.clear();
            fillSuspentedPos();
            this.mSuspentionDataChanged = false;
        }
    }

    public final void insertData(DataHolder dataHolder, int i3) {
        if (i3 < 0 || dataHolder == null || this.mDataList.size() < i3) {
            return;
        }
        this.mDataList.add(i3, dataHolder);
        this.mContentHeight = -1;
    }

    public boolean isAutoCalculateItemHeight() {
        return false;
    }

    int itemRangeCompare(int i3, int i16, int i17) {
        int itemRange = getItemRange(i3);
        if (i16 > i17) {
            return 1;
        }
        if (i16 + itemRange < i17) {
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyDataSetChanged() {
        this.mContentHeight = -1;
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemChanged(int i3) {
        this.mContentHeight = -1;
        super.notifyItemChanged(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemInserted(int i3) {
        this.mContentHeight = -1;
        super.notifyItemInserted(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemRangeChanged(int i3, int i16) {
        this.mContentHeight = -1;
        super.notifyItemRangeChanged(i3, i16);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemRangeInserted(int i3, int i16) {
        this.mContentHeight = -1;
        super.notifyItemRangeInserted(i3, i16);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemRangeRemoved(int i3, int i16) {
        this.mContentHeight = -1;
        super.notifyItemRangeRemoved(i3, i16);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemRemoved(int i3) {
        this.mContentHeight = -1;
        super.notifyItemRemoved(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyItemsRemoved(ArrayList<Integer> arrayList) {
        this.mContentHeight = -1;
        super.notifyItemsRemoved(arrayList);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyLastFooterAppeared() {
        super.notifyLastFooterAppeared();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public boolean notifyOrderChanged(int i3, int i16) {
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolderWrapper viewHolderWrapper, int i3, int i16, int i17) {
        View view;
        if (viewHolderWrapper == null || (view = viewHolderWrapper.itemView) == null || viewHolderWrapper.mContentHolder == null) {
            return;
        }
        view.setPressed(false);
        viewHolderWrapper.itemView.setSelected(false);
        onBindContentView(viewHolderWrapper.mContentHolder, i3, i16);
        positionContentView(viewHolderWrapper.mContentHolder, i3, i16, false);
        onBindCustomerView(viewHolderWrapper, i3, i16);
        RecyclerView recyclerView = this.mParentRecyclerView;
        RecyclerViewBase.LayoutParams onCreateItemLayoutParams = recyclerView.mLayoutType == 3 ? recyclerView.mLayout.onCreateItemLayoutParams(viewHolderWrapper, i3, i16, i17) : recyclerView.mLayout.canScrollHorizontally() ? new RecyclerViewBase.LayoutParams(getItemWidth(i3), -1) : new RecyclerViewBase.LayoutParams(-1, getItemHeight(i3));
        onCreateItemLayoutParams.mViewHolder = viewHolderWrapper;
        ((ViewGroup.MarginLayoutParams) onCreateItemLayoutParams).topMargin = getItemMaigin(1, i3);
        ((ViewGroup.MarginLayoutParams) onCreateItemLayoutParams).bottomMargin = getItemMaigin(3, i3);
        ((ViewGroup.MarginLayoutParams) onCreateItemLayoutParams).leftMargin = getItemMaigin(0, i3);
        ((ViewGroup.MarginLayoutParams) onCreateItemLayoutParams).rightMargin = getItemMaigin(2, i3);
        viewHolderWrapper.itemView.setLayoutParams(onCreateItemLayoutParams);
        View view2 = viewHolderWrapper.itemView;
        ((RecyclerViewItem) view2).mHolder = viewHolderWrapper;
        ContentHolder contentHolder = viewHolderWrapper.mContentHolder;
        viewHolderWrapper.mForceBind = contentHolder.mForceBind;
        view2.setFocusable(contentHolder.mFocusable);
        viewHolderWrapper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                RecyclerViewItemListener recyclerViewItemListener;
                EventCollector.getInstance().onViewClickedBefore(view3);
                if ((view3 instanceof RecyclerViewItem) && (recyclerViewItemListener = RecyclerAdapter.this.mRecyclerViewItemListener) != null) {
                    RecyclerView.ViewHolderWrapper viewHolderWrapper2 = viewHolderWrapper;
                    recyclerViewItemListener.onItemClick(viewHolderWrapper2.itemView, viewHolderWrapper2.mPosition, viewHolderWrapper2.mContentHolder);
                }
                EventCollector.getInstance().onViewClicked(view3);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = this.mLoadingStatus;
        if (i3 != 4 && i3 != 9 && i3 != 10) {
            if (i3 == 6) {
                onClickBackward();
            }
        } else {
            onClickRetry();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void onClickBackward() {
        RecyclerView recyclerView = this.mParentRecyclerView;
        recyclerView.smoothScrollBy(0, -recyclerView.mOffsetY);
    }

    public ContentHolder onCreateContentView(ViewGroup viewGroup, int i3) {
        return null;
    }

    public ContentHolder onCreateContentViewWithPos(ViewGroup viewGroup, int i3, int i16) {
        return null;
    }

    public View onCreateCustomerView(ViewGroup viewGroup, int i3) {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerView.ViewHolderWrapper onCreateSuspendViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerView.ViewHolderWrapper onCreateViewHolder(RecyclerViewBase recyclerViewBase, int i3) {
        RecyclerViewItem viewItem = getViewItem(recyclerViewBase);
        ContentHolder onCreateContentView = onCreateContentView(viewItem, i3);
        if (onCreateContentView == null) {
            return null;
        }
        if (viewItem != null) {
            viewItem.addContentView(onCreateContentView.mContentView, false);
            viewItem.setPadding(onCreateContentView.mItemPaddingLeft, 0, onCreateContentView.mItemPaddingRight, 0);
        }
        RecyclerView.ViewHolderWrapper viewHolderWrapper = new RecyclerView.ViewHolderWrapper(viewItem, recyclerViewBase);
        viewHolderWrapper.setContentHolder(onCreateContentView);
        onCreateContentView.mParentViewHolder = viewHolderWrapper;
        return viewHolderWrapper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public RecyclerView.ViewHolderWrapper onCreateViewHolderWithPos(RecyclerViewBase recyclerViewBase, int i3, int i16) {
        RecyclerViewItem viewItemWithPos = getViewItemWithPos(recyclerViewBase, i3);
        ContentHolder onCreateContentViewWithPos = onCreateContentViewWithPos(viewItemWithPos, i3, i16);
        if (onCreateContentViewWithPos == null) {
            return null;
        }
        if (viewItemWithPos != null) {
            viewItemWithPos.addContentView(onCreateContentViewWithPos.mContentView, false);
            viewItemWithPos.setPadding(onCreateContentViewWithPos.mItemPaddingLeft, 0, onCreateContentViewWithPos.mItemPaddingRight, 0);
        }
        RecyclerView.ViewHolderWrapper viewHolderWrapper = new RecyclerView.ViewHolderWrapper(viewItemWithPos, recyclerViewBase);
        viewHolderWrapper.setContentHolder(onCreateContentViewWithPos);
        return viewHolderWrapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onViewAbandon(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onViewAttached() {
        super.onViewAttached();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onViewDetached() {
        super.onViewDetached();
    }

    public void onViewRecycled(ContentHolder contentHolder, int i3) {
    }

    public void positionContentView(ContentHolder contentHolder, int i3, int i16, boolean z16) {
        View view;
        if (i16 != 2 && i16 != 3 && i16 == 1 && contentHolder != null && (view = contentHolder.mContentView) != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.gravity = 5;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    public void removeData(int i3, int i16) {
        int i17 = i3 + i16;
        if (this.mDataList.size() >= i17 && i3 >= 0 && i16 > 0) {
            this.mDataList.subList(i3, i17).clear();
            this.mContentHeight = -1;
        }
    }

    public void removeDatas(int i3) {
        ArrayList arrayList = new ArrayList();
        Iterator<DataHolder> it = this.mDataList.iterator();
        while (it.hasNext()) {
            DataHolder next = it.next();
            if (next.mItemViewType == i3) {
                arrayList.add(next);
            }
        }
        this.mDataList.removeAll(arrayList);
        this.mContentHeight = -1;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void reset() {
        this.mContentHeight = -1;
        dataChanged();
    }

    public void setItemClickListener(RecyclerViewItemListener recyclerViewItemListener) {
        this.mRecyclerViewItemListener = recyclerViewItemListener;
    }

    public void setItemOffset(int i3, int i16) {
        SparseIntArray sparseIntArray = this.mOffsetMap;
        if (sparseIntArray != null) {
            sparseIntArray.put(i3, i16);
        }
    }

    public void setLoadingStatus(int i3) {
        setLoadingStatus(i3, -1);
    }

    public void setParentRecyclerView(RecyclerView recyclerView) {
        this.mParentRecyclerView = recyclerView;
    }

    public int getCustomFooterViewHeight(int i3) {
        return 0;
    }

    public final void insertData(ArrayList<DataHolder> arrayList, int i3, int i16) {
        if (i3 < 0 || i16 <= 0 || arrayList == null || arrayList.isEmpty() || this.mDataList.size() < i3) {
            return;
        }
        ArrayList<DataHolder> arrayList2 = this.mDataList;
        ArrayList<DataHolder> arrayList3 = new ArrayList<>();
        this.mDataList = arrayList3;
        arrayList3.addAll(arrayList2.subList(0, i3));
        this.mDataList.addAll(arrayList);
        this.mDataList.addAll(arrayList2.subList(i3, arrayList2.size()));
        this.mContentHeight = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void onViewRecycled(RecyclerView.ViewHolderWrapper viewHolderWrapper) {
        onViewRecycled(viewHolderWrapper.mContentHolder, viewHolderWrapper.mPosition);
    }

    public void setLoadingStatus(int i3, int i16) {
        this.mLoadingStatus = i3;
        KeyEvent.Callback callback = this.mDefaultLoadingView;
        if (callback == null || !(callback instanceof IRecyclerViewFooter)) {
            return;
        }
        ((IRecyclerViewFooter) callback).setLoadingStatus(i3);
    }

    protected void onClickRetry() {
    }

    public void onEnterModeStart(int i3) {
    }

    public void onBindContentView(ContentHolder contentHolder, int i3, int i16) {
    }

    public void onBindCustomerView(RecyclerView.ViewHolderWrapper viewHolderWrapper, int i3, int i16) {
    }

    protected void onShowContextMenu(float f16, float f17, int i3) {
    }
}
