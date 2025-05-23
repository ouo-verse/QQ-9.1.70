package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.qzone.common.event.ui.widget.ExtendAdapterView;
import com.qzone.common.event.ui.widget.ExtendGallery;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.EventTag;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.SystemEmoCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedGalleryContainer extends AbsFeedView {
    private static final String EVENT_TAG_DEFAULT_IMAGE = "https://qzonestyle.gtimg.cn/aoi/sola/20170426162816_gHcnt0YZTd.png";
    private static final String EVENT_TAG_IMAGE_MASK = "https://qzonestyle.gtimg.cn/aoi/sola/20170427215930_kuif5jAtUc.png";
    final String TAG;
    boolean hasRecyled;
    boolean hasReportInitialCard;
    private boolean isFriendLikeContainer;
    FeedContainerGalleryViewPager mAdapter;
    public Drawable mBackgroundDrawable;
    Context mContext;
    int mCurrPageIndex;
    boolean mDataFilled;
    BusinessFeedData mFeedData;
    int mFeedPos;
    ExtendGallery mGallery;
    private View mHorizontalView;
    com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
    AsyncImageView mSingleImage;
    AsyncImageView mSingleImageMask;
    TextView mSingleJoinList;
    RelativeLayout mSingleLayout;
    ImageView mSingleRedDot;
    CellTextView mSingleTagTitle;
    private int mTitleCurrentWidth;
    public Drawable mTopBackGroundDrawable;
    int mTrans;
    boolean needFillBlackArea;
    FeedRecommHeader recommHeaderView;
    int showingCardQuantity;
    private static final int TITLE_SEPERATE_LINE_WIDTH_LIMIT = com.qzone.proxy.feedcomponent.util.g.a(135.0f);
    private static final int DESC_SEPERATE_LINE_WIDTH_LIMIT = com.qzone.proxy.feedcomponent.util.g.a(134.0f);
    private static final int SINGLE_TITLE_SEPERATE_LINE_WIDTH_LIMIT = com.qzone.proxy.feedcomponent.util.g.a(330.0f);
    private static final int SINGLE_DESC_SEPERATE_LINE_WIDTH_LIMIT = com.qzone.proxy.feedcomponent.util.g.a(330.0f);

    public FeedGalleryContainer(Context context, BusinessFeedData businessFeedData) {
        super(context);
        this.TAG = "FeedGalleryContainer";
        this.mFeedPos = -1;
        this.mTrans = 255;
        this.isFriendLikeContainer = false;
        this.mContext = context;
        this.type = 7;
        setOrientation(1);
        setContentType(businessFeedData);
        initUI();
    }

    private String getTitleStringWidthAvailableWidth(CellTextView cellTextView, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 > length) {
                break;
            }
            String substring = str.substring(0, i16);
            int measureStringWidth = measureStringWidth(cellTextView, substring) + this.mTitleCurrentWidth;
            if (measureStringWidth >= i3) {
                str = substring;
                i17 = measureStringWidth;
                break;
            }
            i16++;
            i17 = measureStringWidth;
        }
        if (i17 != 0) {
            this.mTitleCurrentWidth = i17;
        }
        return str;
    }

    private static int measureStringWidth(Paint paint, String str) {
        if (paint == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        rect.height();
        return rect.width();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "dispatchTouchEvent");
        if (motionEvent.getAction() == 0) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public FeedView getCurrentFeedView() {
        View subView;
        FeedContainerGalleryViewPager feedContainerGalleryViewPager = this.mAdapter;
        if (feedContainerGalleryViewPager == null || (subView = feedContainerGalleryViewPager.getSubView(this.mCurrPageIndex)) == null || !(subView instanceof FeedView)) {
            return null;
        }
        resetView(subView);
        return (FeedView) subView;
    }

    public BusinessFeedData getFeedData() {
        return this.mFeedData;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    /* renamed from: getFeedPosition */
    public int getMFeedPosition() {
        return this.mFeedPos;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public View getFollowButtonPos(Rect rect) {
        FeedView currentFeedView = getCurrentFeedView();
        if (currentFeedView != null) {
            return currentFeedView.getFollowButtonPos(rect);
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "hasVideoPlayed");
        return false;
    }

    void initUI() {
        removeAllViews();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FeedRecommHeader feedRecommHeader = new FeedRecommHeader(this.mContext, null);
        this.recommHeaderView = feedRecommHeader;
        feedRecommHeader.setBoarderLineVisibility(4);
        addView(this.recommHeaderView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, com.qzone.proxy.feedcomponent.util.g.a(2.0f));
        View inflate = LayoutInflater.from(this.mContext).inflate(com.qzone.adapter.feedcomponent.j.j(UfsGROUPMASK.GROUP_MASK_MINI_APP), (ViewGroup) null);
        this.mHorizontalView = inflate;
        this.mGallery = (ExtendGallery) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2639));
        FeedContainerGalleryViewPager feedContainerGalleryViewPager = new FeedContainerGalleryViewPager();
        this.mAdapter = feedContainerGalleryViewPager;
        this.mGallery.setAdapter((SpinnerAdapter) feedContainerGalleryViewPager);
        this.mGallery.setGalleryMode(2);
        this.mGallery.setOverScrollRatio(0.0f);
        this.mGallery.setUnselectedAlpha(1.0f);
        addView(this.mHorizontalView, layoutParams2);
        this.mGallery.setOnItemClickListener(new ExtendAdapterView.c() { // from class: com.qzone.module.feedcomponent.ui.FeedGalleryContainer.1
            @Override // com.qzone.common.event.ui.widget.ExtendAdapterView.c
            public void onItemClick(ExtendAdapterView<?> extendAdapterView, View view, int i3, long j3) {
                String actionUrl = FeedGalleryContainer.this.mAdapter.getActionUrl(i3);
                BusinessFeedData businessFeedData = (BusinessFeedData) FeedGalleryContainer.this.mAdapter.getItem(i3);
                if (TextUtils.isEmpty(actionUrl)) {
                    return;
                }
                FeedGalleryContainer feedGalleryContainer = FeedGalleryContainer.this;
                feedGalleryContainer.mOnFeedElementClickListener.onClick(feedGalleryContainer, FeedElement.FEED_GALLERY_EVENT_TAG_CLICKED, feedGalleryContainer.mFeedPos, actionUrl);
                if (businessFeedData == null || !businessFeedData.isRecomMyEventTagContainerFeed()) {
                    return;
                }
                businessFeedData.hasClickedMyEventTag = true;
            }
        });
        this.mSingleLayout = (RelativeLayout) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2643));
        this.mSingleImage = (AsyncImageView) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2640));
        this.mSingleImageMask = (AsyncImageView) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2644));
        this.mSingleJoinList = (TextView) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2641));
        this.mSingleTagTitle = (CellTextView) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2642));
        this.mSingleRedDot = (ImageView) this.mHorizontalView.findViewById(com.qzone.adapter.feedcomponent.j.O(2710));
        this.mTopBackGroundDrawable = AreaManager.MESSAGE_LIST_BACKGROUND;
        setWillNotDraw(false);
        setupShowingCardQuantity();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "isAlwaysAutoPlayFeed");
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "isAutoVideoFeed");
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        this.mBackgroundDrawable = colorDrawable;
        colorDrawable.setAlpha(this.mTrans);
        this.mBackgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.mBackgroundDrawable.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onPause() {
        int count = this.mAdapter.getCount();
        FeedView feedView = null;
        for (int i3 = 0; i3 < count; i3++) {
            View subView = this.mAdapter.getSubView(i3);
            if (subView != null && (subView instanceof FeedView)) {
                feedView = (FeedView) this.mAdapter.getSubView(i3);
            }
            if (feedView != null) {
                feedView.onPause();
            }
        }
        super.onPause();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "onRecycled");
        super.onRecycled();
        int count = this.mAdapter.getCount();
        for (int i3 = 0; i3 < count; i3++) {
            View subView = this.mAdapter.getSubView(i3);
            if (subView != null && (subView instanceof FeedView)) {
                FeedView feedView = (FeedView) subView;
                if (feedView.getParent() != null) {
                    ((ViewGroup) feedView.getParent()).removeView(feedView);
                }
                feedView.onRecycled();
                ViewLoader.getInstance().recycleFeedViewInAdvContainer(feedView);
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
        FeedView currentFeedView = getCurrentFeedView();
        if (currentFeedView != null) {
            currentFeedView.onStateIdle();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "onStateIdleOnDetail");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "onTouchEvent");
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "reportFeed");
    }

    void resetView(View view) {
        BusinessFeedData businessFeedData;
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "resetView");
        if (view == null || (businessFeedData = this.mFeedData) == null) {
            return;
        }
        if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds()) {
            view.setPadding(0, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, AreaConst.dp10_5);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
        this.mTrans = i3;
    }

    void setContentType(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setContentType");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.mFeedPos = i3;
        this.mAdapter.mFeedPos = i3;
        this.recommHeaderView.setFeedPosition(i3);
        setTag(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.AIO_ZPLAN_SCENE_LINKAGE), Integer.valueOf(this.mFeedPos));
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setHasRecommHeader");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setHasSearchSeparator");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
        this.needFillBlackArea = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
        this.mAdapter.mOnFeedElementClickListener = gVar;
        this.recommHeaderView.setOnFeedElementClickListener(gVar);
    }

    void setupShowingCardQuantity() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setupShowingCardQuantity");
        this.showingCardQuantity = FeedGlobalEnv.g().getScreenWidth() / com.qzone.adapter.feedcomponent.j.f(FilterEnum.MIC_PTU_TRANS_XINXIAN);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "showSearchSeparator");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "startFlashNickName");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "updateFollowInfo");
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || businessFeedData2.getRecBusinessFeedDatas() == null || this.mFeedData.getRecBusinessFeedDatas().size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.mFeedData.getRecBusinessFeedDatas().size(); i3++) {
            BusinessFeedData businessFeedData3 = this.mFeedData.getRecBusinessFeedDatas().get(i3);
            if (j3 == businessFeedData3.getUser().uin) {
                businessFeedData3.getFeedCommInfo().isFollowed = z16;
                if (businessFeedData3.getRecommAction() != null) {
                    businessFeedData3.getRecommAction().hasFollowed = z16 ? 1 : 0;
                }
                View subView = this.mAdapter.getSubView(i3);
                if (subView != null && (subView instanceof AbsFeedView)) {
                    FeedViewBuilder.updateFollowInfo(this.mContext, (AbsFeedView) subView, businessFeedData3);
                }
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "updateLikeInfo");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "updateRecommAction");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "updateTitle");
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "updateTransparentBackground");
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FeedContainerGalleryViewPager extends BaseAdapter {
        protected final List<BusinessFeedData> feedDataList = new ArrayList();
        protected ArrayList<LinearLayout> listViews;
        protected int mContentType;
        protected int mFeedPos;
        protected com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;
        protected List<BusinessFeedData> realFeedDataList;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        private class Holder {
            public TextView mJoinList;
            public AsyncImageView mPic;
            public ImageView mRedDot;
            public CellTextView mTitle;

            Holder() {
            }
        }

        public FeedContainerGalleryViewPager() {
        }

        public String getActionUrl(int i3) {
            com.qzone.proxy.feedcomponent.model.b bVar;
            List<BusinessFeedData> list = this.feedDataList;
            if (list == null || list.size() <= i3 || (bVar = this.feedDataList.get(i3).cellRecomTag) == null) {
                return null;
            }
            return bVar.f50296c;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "FeedContainerGalleryViewPager   getCount");
            return this.feedDataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "FeedContainerGalleryViewPager   getItem");
            return this.feedDataList.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "FeedContainerGalleryViewPager   getItemId");
            return i3;
        }

        public View getSubView(int i3) {
            ArrayList<LinearLayout> arrayList = this.listViews;
            if (arrayList == null || i3 >= arrayList.size() || i3 < 0 || this.listViews.get(i3) == null) {
                return null;
            }
            return this.listViews.get(i3).getChildAt(0);
        }

        void resetViewLists() {
            this.listViews = new ArrayList<>();
            int count = getCount();
            for (int i3 = 0; i3 < count; i3++) {
                this.listViews.add(null);
            }
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            Holder holder;
            View view2;
            String truncatedStringWithMaxWidth;
            com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "FeedContainerGalleryViewPager   getView");
            if (view == null) {
                View inflate = LayoutInflater.from(FeedGalleryContainer.this.mContext).inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_LOGIN_STATUS_EMPTY), (ViewGroup) null);
                holder = new Holder();
                holder.mPic = (AsyncImageView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2640));
                holder.mJoinList = (TextView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2641));
                holder.mTitle = (CellTextView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2642));
                holder.mRedDot = (ImageView) inflate.findViewById(com.qzone.adapter.feedcomponent.j.O(2709));
                inflate.setTag(holder);
                view2 = inflate;
            } else {
                holder = (Holder) view.getTag();
                view2 = view;
            }
            BusinessFeedData businessFeedData = this.feedDataList.get(i3);
            com.qzone.proxy.feedcomponent.model.b bVar = businessFeedData != null ? businessFeedData.cellRecomTag : null;
            if (bVar != null && bVar.f50294a != null) {
                int a16 = com.qzone.proxy.feedcomponent.util.g.a(160.0f);
                int a17 = com.qzone.proxy.feedcomponent.util.g.a(64.0f);
                if (this.feedDataList.size() == 2) {
                    a16 = com.qzone.proxy.feedcomponent.util.g.a(171.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.mPic.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(a16, a17);
                    } else {
                        layoutParams.width = a16;
                        layoutParams.height = a17;
                    }
                    holder.mPic.setLayoutParams(layoutParams);
                }
                if (businessFeedData != null && businessFeedData.isRecomMyEventTagContainerFeed()) {
                    view2.setPadding(view2.getPaddingLeft(), view2.getTop(), view2.getRight(), com.qzone.proxy.feedcomponent.util.g.a(6.0f));
                    if (bVar.f50294a.updateFlag && !businessFeedData.hasClickedMyEventTag) {
                        holder.mRedDot.setVisibility(0);
                        holder.mJoinList.setPadding(com.qzone.proxy.feedcomponent.util.g.a(8.0f), 0, 0, holder.mJoinList.getPaddingBottom());
                    }
                }
                holder.mPic.setScaleType(ImageView.ScaleType.FIT_XY);
                if (businessFeedData != null && !businessFeedData.isRecomMyEventTagContainerFeed() && !businessFeedData.isRecomEventTagFeed()) {
                    NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(a16, a17, 0.5f, 0.5f);
                    RoundCornerProcessor roundCornerProcessor = new RoundCornerProcessor(0.0f);
                    roundCornerProcessor.setPreProcessor(normalFeedImageProcessor);
                    holder.mPic.setAsyncImageProcessor(roundCornerProcessor);
                }
                holder.mPic.setAsyncImage(bVar.f50294a.backgd_picurl);
                Object[] joinListString = EventTag.getJoinListString(bVar.f50294a.joinList);
                if (businessFeedData != null && bVar.f50294a.updateFlag && businessFeedData.hasClickedMyEventTag) {
                    truncatedStringWithMaxWidth = FeedGalleryContainer.getTruncatedStringWithMaxWidth(holder.mJoinList.getPaint(), bVar.f50294a.count_desc, ((Integer) joinListString[1]).intValue(), FeedGalleryContainer.DESC_SEPERATE_LINE_WIDTH_LIMIT);
                } else {
                    truncatedStringWithMaxWidth = FeedGalleryContainer.getTruncatedStringWithMaxWidth(holder.mJoinList.getPaint(), (String) joinListString[0], ((Integer) joinListString[1]).intValue(), FeedGalleryContainer.DESC_SEPERATE_LINE_WIDTH_LIMIT);
                }
                holder.mJoinList.setMaxWidth(FeedGalleryContainer.DESC_SEPERATE_LINE_WIDTH_LIMIT + 1);
                holder.mJoinList.setText(truncatedStringWithMaxWidth);
                holder.mTitle.setClickable(false);
                holder.mTitle.setLongclickable(false);
                holder.mTitle.setCellClickable(false);
                CellTextView cellTextView = holder.mTitle;
                cellTextView.setRichText(FeedGalleryContainer.this.getTitleStringWithMaxWidth(cellTextView, bVar.f50294a.title, FeedGalleryContainer.TITLE_SEPERATE_LINE_WIDTH_LIMIT), false);
                com.qzone.adapter.feedcomponent.i.H().z(12, 26, 19, System.currentTimeMillis(), this.feedDataList.get(i3), this.mFeedPos, i3);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        public void setData(List<BusinessFeedData> list, int i3, boolean z16, com.qzone.proxy.feedcomponent.ui.g gVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setData size:" + list.size());
            if (gVar == null) {
                this.mOnFeedElementClickListener = gVar;
            }
            int count = getCount();
            this.feedDataList.clear();
            this.feedDataList.addAll(list);
            this.realFeedDataList = list;
            if (z16 || count != getCount() || this.mContentType != i3) {
                resetViewLists();
                notifyDataSetChanged();
            }
            this.mContentType = i3;
        }
    }

    public static String getTruncatedStringWithMaxWidth(Paint paint, String str, int i3, int i16) {
        if (paint != null && !TextUtils.isEmpty(str) && measureStringWidth(paint, str) > i16 && str.length() > i3 + 1) {
            String str2 = MiniBoxNoticeInfo.APPNAME_SUFFIX + str.substring(str.length() - i3, str.length());
            String substring = str.substring(0, str.length() - i3);
            for (int i17 = 1; i17 < substring.length(); i17++) {
                String str3 = str.substring(0, substring.length() - i17) + str2;
                if (measureStringWidth(paint, str3) <= i16) {
                    return str3;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTitleStringWithMaxWidth(CellTextView cellTextView, String str, int i3) {
        String str2 = null;
        if (cellTextView == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<TextCell> parseContent = cellTextView.parseContent(str, false);
        this.mTitleCurrentWidth = 0;
        StringBuilder sb5 = new StringBuilder();
        Iterator<TextCell> it = parseContent.iterator();
        while (it.hasNext()) {
            TextCell next = it.next();
            if (next != null) {
                if (!next.isEmo() && !(next instanceof SystemEmoCell)) {
                    String titleStringWidthAvailableWidth = getTitleStringWidthAvailableWidth(cellTextView, next.getText(), i3);
                    if (!TextUtils.isEmpty(titleStringWidthAvailableWidth)) {
                        sb5.append(titleStringWidthAvailableWidth);
                    }
                } else {
                    String text = next.getText();
                    int width = (int) (this.mTitleCurrentWidth + next.getWidth(cellTextView.getPaint()));
                    this.mTitleCurrentWidth = width;
                    if (width < i3) {
                        sb5.append(text);
                        str2 = text;
                    } else {
                        String sb6 = sb5.toString();
                        if (str2 != null && sb6.endsWith(str2)) {
                            return sb6.substring(0, sb6.lastIndexOf(str2)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                        }
                    }
                }
            }
        }
        return sb5.toString();
    }

    public void setFeedData(final BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("FeedGalleryContainer", "setFeedData");
        this.mTrans = com.qzone.adapter.feedcomponent.i.H().E0();
        this.mDataFilled = true;
        this.mFeedData = businessFeedData;
        this.hasReportInitialCard = false;
        setContentType(businessFeedData);
        this.mCurrPageIndex = this.mFeedData.currShowIndex;
        this.hasRecyled = false;
        if (businessFeedData.getRecommHeader() != null) {
            if (businessFeedData.isRecomMyEventTagContainerFeed()) {
                this.recommHeaderView.setHeaderData(businessFeedData.getRecommHeader(), false);
                this.recommHeaderView.setMyEventTagInContainer(true);
                this.recommHeaderView.setTransparent(this.mTrans);
            } else {
                this.recommHeaderView.setHeaderData(businessFeedData.getRecommHeader(), true);
                this.recommHeaderView.setEventTagGalleryInContainer(true);
            }
            this.recommHeaderView.setFeedAttr(businessFeedData.getFeedCommInfo().feedsAttr, businessFeedData.isSubFeed);
            this.recommHeaderView.setIsHotRecommFeed(businessFeedData.getFeedCommInfo().isHotRecommFeed() || businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds());
            this.recommHeaderView.setStyle(businessFeedData.getSinglePicAdvStyle());
            if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds()) {
                this.recommHeaderView.setBizRecomContainer(true);
            } else {
                this.recommHeaderView.setBizRecomContainer(false);
            }
            this.recommHeaderView.setVisibility(0);
            this.recommHeaderView.update();
        } else {
            this.recommHeaderView.setVisibility(8);
        }
        if (businessFeedData.getRecBusinessFeedDatas() != null && businessFeedData.getRecBusinessFeedDatas().size() == 1) {
            this.mGallery.setVisibility(4);
            this.mSingleLayout.setVisibility(0);
            final com.qzone.proxy.feedcomponent.model.b bVar = businessFeedData.getRecBusinessFeedDatas().get(0).cellRecomTag;
            if (bVar == null || bVar.f50294a == null) {
                return;
            }
            int a16 = com.qzone.proxy.feedcomponent.util.g.a(214.0f);
            int a17 = com.qzone.proxy.feedcomponent.util.g.a(95.0f);
            if (bVar.f50294a.isDefault) {
                a17 = com.qzone.proxy.feedcomponent.util.g.a(95.0f);
            }
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(a16, a17, 0.5f, 0.5f);
            RoundCornerProcessor roundCornerProcessor = new RoundCornerProcessor(com.qzone.proxy.feedcomponent.util.g.a(3.0f));
            roundCornerProcessor.setPreProcessor(normalFeedImageProcessor);
            this.mSingleImage.setAsyncImageProcessor(roundCornerProcessor);
            if (bVar.f50294a.isDefault) {
                this.mSingleLayout.setBackground(AreaManager.FEED_GALLERY_EVENT_TAG);
                this.mSingleImage.setAsyncImage(EVENT_TAG_DEFAULT_IMAGE);
                this.mSingleJoinList.setTextColor(-1);
                this.mSingleTagTitle.setTextColor(-1);
                this.mSingleImageMask.setVisibility(8);
            } else {
                this.mSingleLayout.setBackground(AreaManager.BORDER_CONTAINER_ADV);
                this.mSingleImage.setAsyncImage(bVar.f50294a.picUrl);
                this.mSingleJoinList.setTextColor(-16777216);
                this.mSingleTagTitle.setTextColor(-16777216);
                this.mSingleImageMask.setVisibility(0);
            }
            this.mSingleJoinList.setAlpha(0.5f);
            this.mSingleImageMask.setAsyncImageProcessor(roundCornerProcessor);
            this.mSingleImageMask.setAsyncImage(EVENT_TAG_IMAGE_MASK);
            if (businessFeedData.isRecomMyEventTagContainerFeed()) {
                View view = this.mHorizontalView;
                view.setPadding(view.getPaddingLeft(), this.mHorizontalView.getPaddingTop(), this.mHorizontalView.getPaddingRight(), com.qzone.proxy.feedcomponent.util.g.a(8.0f));
                if (bVar.f50294a.updateFlag && !businessFeedData.hasClickedMyEventTag) {
                    ImageView imageView = this.mSingleRedDot;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.mSingleJoinList.setPadding(com.qzone.proxy.feedcomponent.util.g.a(8.0f), 0, 0, this.mSingleJoinList.getPaddingBottom());
                } else {
                    ImageView imageView2 = this.mSingleRedDot;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                    TextView textView = this.mSingleJoinList;
                    textView.setPadding(0, 0, 0, textView.getPaddingBottom());
                }
            }
            Object[] joinListString = EventTag.getJoinListString(bVar.f50294a.joinList);
            if (joinListString == null) {
                str = null;
            } else if (bVar.f50294a.updateFlag && businessFeedData.hasClickedMyEventTag) {
                str = getTruncatedStringWithMaxWidth(this.mSingleJoinList.getPaint(), bVar.f50294a.count_desc, ((Integer) joinListString[1]).intValue(), DESC_SEPERATE_LINE_WIDTH_LIMIT);
            } else {
                str = getTruncatedStringWithMaxWidth(this.mSingleJoinList.getPaint(), (String) joinListString[0], ((Integer) joinListString[1]).intValue(), DESC_SEPERATE_LINE_WIDTH_LIMIT);
            }
            this.mSingleJoinList.setMaxWidth(SINGLE_DESC_SEPERATE_LINE_WIDTH_LIMIT + 1);
            this.mSingleJoinList.setText(str);
            this.mSingleTagTitle.setClickable(false);
            this.mSingleTagTitle.setLongclickable(false);
            this.mSingleTagTitle.setCellClickable(false);
            CellTextView cellTextView = this.mSingleTagTitle;
            cellTextView.setRichText(getTitleStringWithMaxWidth(cellTextView, bVar.f50294a.title, SINGLE_TITLE_SEPERATE_LINE_WIDTH_LIMIT), false);
            this.mSingleLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedGalleryContainer.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    String str2 = bVar.f50296c;
                    if (!TextUtils.isEmpty(str2)) {
                        FeedGalleryContainer feedGalleryContainer = FeedGalleryContainer.this;
                        feedGalleryContainer.mOnFeedElementClickListener.onClick(feedGalleryContainer, FeedElement.FEED_GALLERY_EVENT_TAG_CLICKED, feedGalleryContainer.mFeedPos, str2);
                        BusinessFeedData businessFeedData2 = businessFeedData;
                        if (businessFeedData2 != null && businessFeedData2.isRecomMyEventTagContainerFeed()) {
                            businessFeedData.hasClickedMyEventTag = true;
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            return;
        }
        this.mGallery.setVisibility(0);
        this.mSingleLayout.setVisibility(4);
        this.mAdapter.setData(businessFeedData.getRecBusinessFeedDatas(), 0, true, this.mOnFeedElementClickListener);
    }

    private static int measureStringWidth(CellTextView cellTextView, String str) {
        Rect rect = new Rect();
        cellTextView.getPaint().getTextBounds(str, 0, str.length(), rect);
        rect.height();
        return rect.width();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(com.qzone.proxy.feedcomponent.ui.h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
