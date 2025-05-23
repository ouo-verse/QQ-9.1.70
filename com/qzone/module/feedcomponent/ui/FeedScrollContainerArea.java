package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.module.feedcomponent.actionreport.UserActionReportHelper;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLogoView;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;
import com.qzone.module.feedcomponent.ui.common.PagerAdapter;
import com.qzone.module.feedcomponent.ui.common.WrapContentViewPager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedScrollContainerArea extends BaseFeedView implements FeedChildView {
    static float PAGE_WIDTH = AreaConst.REC_WIDTH_WEIGHT;
    public static FeedViewSection.SectionController ScrollContainerController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedScrollContainerArea.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData == null || businessFeedData.containerSubType != 1 || businessFeedData.getRecBusinessFeedDatas() == null || businessFeedData.getRecBusinessFeedDatas().size() <= 0;
        }
    };
    final int CONTENT_CARD_STYLE;
    final int CONTENT_ORIGIN_STYLE;
    int alpha;
    int contentType;
    FeedContainerPreScroll feedContainerPreScroll;
    FeedContainerViewPager mAdapter;
    Context mContext;
    int mCurrPageIndex;
    int mDownX;
    int mDownY;
    BusinessFeedData mFeedData;
    ArrayList<BusinessFeedData> mFeedDatas;
    int mFeedPos;
    WrapContentViewPager mViewPager;
    boolean scrollDirectionDetermined;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FeedContainerViewPager extends PagerAdapter {
        protected final List<BusinessFeedData> feedDataList = new ArrayList();
        protected ArrayList<FrameLayout> listViews;
        protected int mFeedPos;
        protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;

        public FeedContainerViewPager() {
            resetViewLists();
        }

        private void resetViewLists() {
            this.listViews = new ArrayList<>();
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                this.listViews.add(null);
            }
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            View view = (View) obj;
            if (view != null && (view instanceof FeedView)) {
                ViewLoader.getInstance().recycleFeedViewInAdvContainer((FeedView) view);
            }
            if (view != null && (view instanceof QzoneCanvasAreaView)) {
                ((QzoneCanvasAreaView) view).onRecycled();
            }
            viewGroup.removeView(view);
            if (i3 < this.listViews.size()) {
                this.listViews.set(i3, null);
            }
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getCount() {
            List<BusinessFeedData> list = this.feedDataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public int getFeedPos() {
            return this.mFeedPos;
        }

        public BusinessFeedData getItem(int i3) {
            List<BusinessFeedData> list = this.feedDataList;
            if (list != null && list.size() >= i3 + 1) {
                return this.feedDataList.get(i3);
            }
            return null;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getItemPosition(Object obj) {
            return this.listViews.contains(obj) ? -1 : -2;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public float getPageWidth(int i3) {
            BusinessFeedData item = getItem(i3);
            if (item != null && item.isSquareCardStyle()) {
                FeedScrollContainerArea.PAGE_WIDTH = 0.661f;
            } else {
                FeedScrollContainerArea.PAGE_WIDTH = AreaConst.REC_WIDTH_WEIGHT;
            }
            if (FeedScrollContainerArea.this.contentType == 3001 && i3 != 0 && i3 != this.feedDataList.size() - 1) {
                return FeedScrollContainerArea.PAGE_WIDTH - AreaConst.REC_GAP_WIDTH_WEIGHT;
            }
            return FeedScrollContainerArea.PAGE_WIDTH;
        }

        public View getSubView(int i3) {
            ArrayList<FrameLayout> arrayList = this.listViews;
            if (arrayList == null || i3 >= arrayList.size() || i3 < 0 || this.listViews.get(i3) == null) {
                return null;
            }
            return this.listViews.get(i3).getChildAt(0);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            if (this.listViews.get(i3) == null) {
                View obtainViewInPositionFromCache = obtainViewInPositionFromCache(i3);
                FrameLayout frameLayout = new FrameLayout(FeedScrollContainerArea.this.mContext);
                frameLayout.addView(obtainViewInPositionFromCache);
                viewGroup.addView(frameLayout);
                this.listViews.set(i3, frameLayout);
                setSingleFeedViewData(i3);
                FeedScrollContainerArea.this.resetView(obtainViewInPositionFromCache);
            }
            return this.listViews.get(i3);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        View obtainViewInPositionFromCache(int i3) {
            BusinessFeedData item = getItem(i3);
            int i16 = AreaConst.dp10;
            int i17 = AreaConst.dp5;
            if (FeedScrollContainerArea.this.contentType == 3001) {
                i16 = AreaConst.cardContainerWingPad;
                i17 = AreaConst.cardContainerGap;
            }
            int i18 = i17;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (i3 == 0) {
                layoutParams.setMargins(i16, 0, i17, 0);
            } else if (i3 == this.feedDataList.size() - 1) {
                layoutParams.setMargins(i17, 0, i16, 0);
            } else {
                layoutParams.setMargins(i18, 0, i18, 0);
            }
            if (item != null && item.isAttach()) {
                CanvasLogoView canvasLogoView = new CanvasLogoView(FeedScrollContainerArea.this.mContext, null);
                canvasLogoView.setLayoutParams(layoutParams);
                return canvasLogoView;
            }
            FeedView obtainFeedViewInAdvContainer = ViewLoader.getInstance().obtainFeedViewInAdvContainer(FeedScrollContainerArea.this.mContext, false);
            obtainFeedViewInAdvContainer.setLayoutParams(layoutParams);
            obtainFeedViewInAdvContainer.mFeedData = null;
            obtainFeedViewInAdvContainer.mIndex = i3;
            obtainFeedViewInAdvContainer.setFeedPosition(this.mFeedPos);
            obtainFeedViewInAdvContainer.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
            obtainFeedViewInAdvContainer.setAlpha(FeedScrollContainerArea.this.alpha);
            return obtainFeedViewInAdvContainer;
        }

        public void resetViewDisplay() {
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                FeedScrollContainerArea.this.resetView(getSubView(i3));
            }
        }

        void setContentType() {
            List<BusinessFeedData> list = this.feedDataList;
            if (list == null || list.size() <= 0 || this.feedDataList.get(0) == null) {
                return;
            }
            if (this.feedDataList.get(0).isSubOfSingleAdvContainerNewStyle()) {
                FeedScrollContainerArea.this.contentType = 3001;
            } else {
                FeedScrollContainerArea.this.contentType = 3002;
            }
        }

        public void setData(List<BusinessFeedData> list) {
            setData(list, null);
        }

        void setSingleFeedViewData(int i3) {
            List<BusinessFeedData> list = this.feedDataList;
            if (list == null || list.size() == 0 || i3 < 0 || i3 >= this.feedDataList.size()) {
                return;
            }
            BusinessFeedData businessFeedData = this.feedDataList.get(i3);
            if (businessFeedData != null && !businessFeedData.hasCalculate) {
                com.qzone.adapter.feedcomponent.d.w(businessFeedData);
            }
            View subView = getSubView(i3);
            if (subView instanceof AbsFeedView) {
                AbsFeedView absFeedView = (AbsFeedView) subView;
                if (absFeedView == null) {
                    return;
                }
                absFeedView.mFeedData = businessFeedData;
                com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
                FeedGlobalEnv.g();
                uiInterface.setFeedViewData(FeedGlobalEnv.getContext(), absFeedView, businessFeedData, false);
                ((FeedView) absFeedView).mIndex = i3;
                absFeedView.setFeedPosition(this.mFeedPos);
                absFeedView.setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(i3));
                absFeedView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
                return;
            }
            if (businessFeedData != null && businessFeedData.isAttach() && (subView instanceof CanvasLogoView)) {
                CanvasLogoView canvasLogoView = (CanvasLogoView) subView;
                canvasLogoView.setFeedData(businessFeedData);
                canvasLogoView.setFeedPosition(this.mFeedPos, i3);
                canvasLogoView.setOnFeedElementClickListener(this.mOnFeedElementClickListener);
            }
        }

        public void setData(List<BusinessFeedData> list, com.qzone.proxy.feedcomponent.ui.g gVar) {
            this.mOnFeedElementClickListener = gVar;
            this.feedDataList.clear();
            if (list != null) {
                this.feedDataList.addAll(list);
            }
            FeedScrollContainerArea.this.mViewPager.setCenterModeChildren(true, true);
            setContentType();
            resetViewLists();
            notifyDataSetChanged();
        }
    }

    public FeedScrollContainerArea(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CONTENT_CARD_STYLE = 3001;
        this.CONTENT_ORIGIN_STYLE = 3002;
        this.contentType = 3002;
        this.mDownX = 0;
        this.mDownY = 0;
        this.scrollDirectionDetermined = false;
        initUI(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r2 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.scrollDirectionDetermined) {
                        int abs = Math.abs(x16 - this.mDownX);
                        int abs2 = Math.abs(y16 - this.mDownY);
                        if (Math.max(abs, abs2) > AreaConst.SCROLL_DIRECTION_THRESHHOLD) {
                            this.scrollDirectionDetermined = true;
                        }
                        if (abs < abs2) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
            this.scrollDirectionDetermined = false;
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        } else {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mDownX = x16;
            this.mDownY = y16;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public int getFeedPosition() {
        return this.mFeedPos;
    }

    void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1652), this);
        this.mViewPager = (WrapContentViewPager) findViewById(com.qzone.adapter.feedcomponent.j.O(2304));
        this.mAdapter = new FeedContainerViewPager();
        this.mViewPager.setDefaultHeight((int) (AreaConst.feedWidth_Rec / 1.78f));
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.autoScrollMode(true);
        this.mViewPager.setCurrentItemInCenter(0);
        this.mViewPager.setOnPageChangeListener(new CenterViewPager.OnPageChangeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedScrollContainerArea.2
            public int currPageSelected;
            public int pad;

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                com.qzone.proxy.feedcomponent.ui.g gVar;
                FeedScrollContainerArea.this.resetView(FeedScrollContainerArea.this.mAdapter.getSubView(i3));
                FeedScrollContainerArea feedScrollContainerArea = FeedScrollContainerArea.this;
                if (feedScrollContainerArea.mCurrPageIndex != i3 && (gVar = feedScrollContainerArea.onFeedElementClickListener) != null) {
                    gVar.onClick(feedScrollContainerArea.mAdapter.getSubView(i3), FeedElement.ADV_CONTAINER, FeedScrollContainerArea.this.mFeedPos, null);
                }
                FeedScrollContainerArea feedScrollContainerArea2 = FeedScrollContainerArea.this;
                feedScrollContainerArea2.mCurrPageIndex = i3;
                BusinessFeedData businessFeedData = feedScrollContainerArea2.mFeedData;
                if (businessFeedData != null) {
                    businessFeedData.currShowIndex = i3;
                }
                UserActionReportHelper.feedAdvContainerPageSelected(i3, feedScrollContainerArea2.mAdapter.getCount(), FeedScrollContainerArea.this.mAdapter);
                FeedScrollContainerArea feedScrollContainerArea3 = FeedScrollContainerArea.this;
                feedScrollContainerArea3.feedContainerPreScroll.feedScrolledByUser(feedScrollContainerArea3.mFeedData);
            }

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f16, int i16) {
            }
        });
        this.feedContainerPreScroll = new FeedContainerPreScroll();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected boolean isEmptyData() {
        return this.mFeedDatas == null;
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        FeedContainerViewPager feedContainerViewPager = this.mAdapter;
        if (feedContainerViewPager != null) {
            feedContainerViewPager.setData(new ArrayList(), null);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void preScrollContent(ListAdapter listAdapter) {
        BusinessFeedData item = this.mAdapter.getItem(0);
        int i3 = (AreaConst.cardContainerWidth * 1) / 5;
        if (item != null && item.isSquareCardStyle()) {
            i3 = (AreaConst.SQUARE_CARD_CONTAINER_WIDTH_IN_PX * 1) / 5;
        }
        this.feedContainerPreScroll.preScrollContent(this.mFeedData, this.mViewPager, i3, listAdapter, this.mFeedPos);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
        WrapContentViewPager wrapContentViewPager = this.mViewPager;
        if (wrapContentViewPager != null && wrapContentViewPager.getBackground() != null) {
            this.mViewPager.getBackground().setAlpha(i3);
        }
        this.alpha = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        setScrollContent(businessFeedData, businessFeedData.getRecBusinessFeedDatas());
        update();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.mAdapter.mFeedPos = i3;
        this.mFeedPos = i3;
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(this.mFeedPos));
    }

    public void setScrollContent(BusinessFeedData businessFeedData, ArrayList<BusinessFeedData> arrayList) {
        this.mFeedData = businessFeedData;
        this.mCurrPageIndex = businessFeedData.currShowIndex;
        this.mFeedDatas = arrayList;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mViewPager.getLayoutParams();
        if (businessFeedData.isSingleAdvContainerNewStyle()) {
            layoutParams.setMargins(0, AreaConst.dp5, 0, 0);
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
        }
        this.mViewPager.setLayoutParams(layoutParams);
        int i3 = (int) (AreaConst.feedWidth_Rec / 1.78f);
        if (arrayList != null && arrayList.get(0) != null && arrayList.get(0).isSquareCardStyle()) {
            i3 = AreaConst.SQUARE_CARD_CONTAINER_WIDTH_IN_PX;
            if (arrayList.get(0).isGDTAdvFeed()) {
                this.mViewPager.autoScrollMode(false);
            }
        }
        if (businessFeedData.isCardStyleButtonButtom()) {
            i3 += AreaConst.dp53;
        }
        this.mViewPager.setDefaultHeight(i3);
        this.mAdapter.setData(this.mFeedDatas, this.onFeedElementClickListener);
        this.mViewPager.setCurrentItemInternal(this.mCurrPageIndex, false, true);
        this.mAdapter.resetViewDisplay();
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    public void reset() {
        this.mFeedDatas = null;
        WrapContentViewPager wrapContentViewPager = this.mViewPager;
        if (wrapContentViewPager != null) {
            wrapContentViewPager.autoScrollMode(true);
        }
    }

    void resetView(View view) {
        BusinessFeedData businessFeedData;
        if (view == null || (businessFeedData = this.mFeedData) == null || !businessFeedData.isSingleAdvContainerNewStyle()) {
            return;
        }
        int i3 = AreaConst.CONTAINER_LINE_WIDTH;
        view.setPadding(i3, i3 - 1, i3, i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.BaseFeedView
    protected void onUpdate() {
    }
}
