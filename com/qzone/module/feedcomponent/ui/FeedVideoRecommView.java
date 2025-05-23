package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.common.CenterViewPager;
import com.qzone.module.feedcomponent.ui.common.PagerAdapter;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.qqlive.module.videoreport.BuildConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedVideoRecommView {
    static final String TAG = "FeedVideoRecommView";
    public static final int TYPE_VIDEO_VIEW_HORIZONTAL = 0;
    public static final int TYPE_VIDEO_VIEW_NOT_SUPPORT = 10;
    public static final int TYPE_VIDEO_VIEW_SQUARE = 2;
    public static final int TYPE_VIDEO_VIEW_VERTICAL = 1;
    boolean hasAttached;
    ImageView imageView;
    ImageView[] imageViews;
    Context mContext;
    FeedAutoVideo mFeedAutoVideo;
    int mGridWidth;
    int mHeight;
    ViewGroup mIndicator;
    int mPages;
    ArrayList<com.qzone.proxy.feedcomponent.model.h> mRecommVideoInfos;
    RelativeLayout mRecommView;
    ViewGroup mReplay;
    TextView mReplayText;
    int mTitleLeft;
    int mTitleTop;
    int mVideoViewType;
    ViewPagerMatchParent mViewPager;
    TextView mViewPagerTitle;
    int mWidth;
    ArrayList<View> pageViews;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class RecommPageAdapter extends PagerAdapter {
        RecommPageAdapter() {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getCount() {
            return FeedVideoRecommView.this.pageViews.size();
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            viewGroup.addView(FeedVideoRecommView.this.pageViews.get(i3));
            return FeedVideoRecommView.this.pageViews.get(i3);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class RecommonChangeListener implements CenterViewPager.OnPageChangeListener {
        View view;

        public RecommonChangeListener(View view) {
            this.view = view;
        }

        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            int i16 = 0;
            while (true) {
                ImageView[] imageViewArr = FeedVideoRecommView.this.imageViews;
                if (i16 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i3].setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(756));
                if (i3 != i16) {
                    FeedVideoRecommView.this.imageViews[i16].setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(757));
                }
                i16++;
            }
            com.qzone.adapter.feedcomponent.i.H().Z1("1", Integer.toString(i3));
            com.qzone.adapter.feedcomponent.i.H().Z1("3", Integer.toString(i3));
            ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList = new ArrayList<>();
            for (int numPerPages = FeedVideoRecommView.this.getNumPerPages() * i3; numPerPages < FeedVideoRecommView.this.getNumPerPages() * (i3 + 1); numPerPages++) {
                arrayList.add(FeedVideoRecommView.this.mRecommVideoInfos.get(numPerPages));
            }
            FeedVideoRecommView feedVideoRecommView = FeedVideoRecommView.this;
            feedVideoRecommView.mFeedAutoVideo.onReportExposed(feedVideoRecommView.mViewPager, arrayList);
            FeedVideoRecommView.this.mFeedAutoVideo.onShowPage(i3);
        }

        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    static int dpToPx(float f16) {
        return com.qzone.proxy.feedcomponent.util.g.a(f16);
    }

    public static int getSupportVideoNum(int i3, int i16) {
        return isSquare(i3, i16) ? 12 : 6;
    }

    public boolean attach(Context context, FeedAutoVideo feedAutoVideo, int i3, int i16, ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
        this.mFeedAutoVideo = feedAutoVideo;
        this.mContext = context;
        this.mWidth = i3;
        this.mHeight = i16;
        preCaculateData(i3, i16);
        if (arrayList.size() < getNumPerPages()) {
            return false;
        }
        if (!this.hasAttached) {
            new FrameLayout.LayoutParams(-1, i16);
            try {
                this.mRecommView = (RelativeLayout) LayoutInflater.from(context).inflate(com.qzone.adapter.feedcomponent.j.j(1679), (ViewGroup) null);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            RelativeLayout relativeLayout = this.mRecommView;
            if (relativeLayout == null) {
                return false;
            }
            this.mFeedAutoVideo.addView(relativeLayout, -1, i16);
            this.hasAttached = true;
        }
        this.mViewPager = (ViewPagerMatchParent) this.mRecommView.findViewById(com.qzone.adapter.feedcomponent.j.O(BuildConfig.VERSION_CODE));
        this.mIndicator = (ViewGroup) this.mRecommView.findViewById(com.qzone.adapter.feedcomponent.j.O(2445));
        this.mViewPagerTitle = (TextView) this.mRecommView.findViewById(com.qzone.adapter.feedcomponent.j.O(2446));
        this.mReplay = (ViewGroup) this.mRecommView.findViewById(com.qzone.adapter.feedcomponent.j.O(2447));
        this.mReplayText = (TextView) this.mRecommView.findViewById(com.qzone.adapter.feedcomponent.j.O(2448));
        this.mReplay.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoRecommView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                FeedVideoRecommView.this.mFeedAutoVideo.onClickReplay(view);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return Recalculate(i3, i16, arrayList);
    }

    protected int getNumColums() {
        return 1 == this.mVideoViewType ? 1 : 2;
    }

    protected int getNumPerPages() {
        return 2 == this.mVideoViewType ? 4 : 2;
    }

    protected boolean isLastView(int i3, int i16) {
        return i3 == this.mPages - 1 && i16 == getNumPerPages() - 1;
    }

    public final void measure(int i3, int i16) {
        RelativeLayout relativeLayout = this.mRecommView;
        if (relativeLayout != null) {
            relativeLayout.measure(i3, i16);
        }
    }

    public void onRecycled() {
        FeedAutoVideo feedAutoVideo;
        RelativeLayout relativeLayout = this.mRecommView;
        if (relativeLayout == null || (feedAutoVideo = this.mFeedAutoVideo) == null) {
            return;
        }
        feedAutoVideo.removeView(relativeLayout);
        this.hasAttached = false;
    }

    public void preCaculateData(int i3, int i16) {
        if (isSquare(i3, i16)) {
            this.mVideoViewType = 2;
        } else if (!isSupportWidthHeight(i3, i16)) {
            this.mVideoViewType = 10;
            return;
        } else if (i3 > i16) {
            this.mVideoViewType = 0;
        } else {
            this.mVideoViewType = 1;
        }
        if (1 == this.mVideoViewType) {
            this.mGridWidth = dpToPx(161.0f);
        } else {
            this.mGridWidth = dpToPx(301.0f);
        }
        this.mTitleLeft = (i3 - this.mGridWidth) / 2;
        int i17 = this.mVideoViewType;
        if (1 == i17) {
            this.mTitleTop = (((i16 - (dpToPx(117.0f) * 2)) / 2) - dpToPx(14.0f)) - dpToPx(13.0f);
        } else if (i17 == 0) {
            this.mTitleTop = (((i16 - dpToPx(101.0f)) / 2) - dpToPx(14.0f)) - dpToPx(13.0f);
        } else {
            this.mTitleTop = (((i16 - (dpToPx(107.0f) * 2)) / 2) - dpToPx(14.0f)) - dpToPx(13.0f);
        }
    }

    public void setCurrentItem(int i3) {
        this.mViewPager.setCurrentItem(i3, false);
    }

    public void setVisibility(int i3) {
        RelativeLayout relativeLayout = this.mRecommView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class GridViewAdapter extends BaseAdapter {
        int pageIndex;

        public GridViewAdapter(int i3) {
            this.pageIndex = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FeedVideoRecommView.this.getNumPerPages();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(final int i3, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            if (view == null) {
                FeedVideoRecommView feedVideoRecommView = FeedVideoRecommView.this;
                if (1 == feedVideoRecommView.mVideoViewType) {
                    linearLayout = (LinearLayout) LayoutInflater.from(feedVideoRecommView.mContext).inflate(com.qzone.adapter.feedcomponent.j.j(1681), (ViewGroup) null);
                } else {
                    linearLayout = (LinearLayout) LayoutInflater.from(feedVideoRecommView.mContext).inflate(com.qzone.adapter.feedcomponent.j.j(1680), (ViewGroup) null);
                }
            } else {
                linearLayout = (LinearLayout) view;
            }
            AsyncImageView asyncImageView = (AsyncImageView) linearLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2450));
            TextView textView = (TextView) linearLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2451));
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2452));
            textView.setGravity(3);
            FeedVideoRecommView feedVideoRecommView2 = FeedVideoRecommView.this;
            com.qzone.proxy.feedcomponent.model.h hVar = feedVideoRecommView2.mRecommVideoInfos.get((this.pageIndex * feedVideoRecommView2.getNumPerPages()) + i3);
            asyncImageView.setAsyncImage(hVar.f50317a);
            asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setText(hVar.f50318b);
            if (FeedVideoRecommView.this.isLastView(this.pageIndex, i3)) {
                linearLayout2.setVisibility(0);
                textView.setText(" ");
            } else {
                linearLayout2.setVisibility(8);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedVideoRecommView.GridViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    GridViewAdapter gridViewAdapter = GridViewAdapter.this;
                    if (FeedVideoRecommView.this.isLastView(gridViewAdapter.pageIndex, i3)) {
                        FeedVideoRecommView.this.mFeedAutoVideo.onClickMoreVideo(view2);
                    } else {
                        GridViewAdapter gridViewAdapter2 = GridViewAdapter.this;
                        FeedVideoRecommView feedVideoRecommView3 = FeedVideoRecommView.this;
                        feedVideoRecommView3.mFeedAutoVideo.onClickVideo(view2, feedVideoRecommView3.mRecommVideoInfos.get((gridViewAdapter2.pageIndex * feedVideoRecommView3.getNumPerPages()) + i3));
                        com.qzone.adapter.feedcomponent.i.H().Z1("2", Integer.toString(GridViewAdapter.this.pageIndex));
                    }
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return linearLayout;
        }
    }

    public static boolean isSquare(int i3, int i16) {
        return Math.abs(i3 - i16) < dpToPx(35.0f);
    }

    protected int getHorizontalSpace() {
        if (1 == this.mVideoViewType) {
            return 0;
        }
        return dpToPx(15.0f);
    }

    boolean Recalculate(int i3, int i16, ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
        if (10 == this.mVideoViewType) {
            return false;
        }
        int size = arrayList.size() / getNumPerPages();
        this.mPages = size;
        if (size == 0) {
            return false;
        }
        if (size > 3) {
            this.mPages = 3;
        }
        this.mRecommVideoInfos = arrayList;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRecommView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.mRecommView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mViewPager.getLayoutParams();
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        this.mViewPager.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mIndicator.getLayoutParams();
        layoutParams3.width = i3;
        this.mIndicator.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mReplay.getLayoutParams();
        layoutParams4.width = i3;
        this.mReplay.setLayoutParams(layoutParams4);
        return initViewPager(i3, i16);
    }

    protected boolean initViewPager(int i3, int i16) {
        if (10 == this.mVideoViewType) {
            return false;
        }
        this.pageViews = new ArrayList<>();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mTitleLeft, this.mTitleTop, 0, 0);
        this.mViewPagerTitle.setLayoutParams(layoutParams);
        int i17 = this.mPages;
        for (int i18 = 0; i18 < i17; i18++) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.mGridWidth, -2);
            layoutParams2.gravity = 17;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            GridView gridView = new GridView(this.mContext);
            gridView.setNumColumns(getNumColums());
            gridView.setHorizontalSpacing(getHorizontalSpace());
            gridView.setSelector(17170445);
            gridView.setGravity(17);
            gridView.setAdapter((ListAdapter) new GridViewAdapter(i18));
            gridView.setPadding(0, 0, 0, 0);
            linearLayout.addView(gridView, layoutParams2);
            this.pageViews.add(linearLayout);
        }
        this.imageViews = new ImageView[this.pageViews.size()];
        this.mIndicator.removeAllViews();
        for (int i19 = 0; i19 < this.pageViews.size(); i19++) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(15, 0, 0, 0);
            ImageView imageView = new ImageView(this.mContext);
            this.imageView = imageView;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
            ImageView[] imageViewArr = this.imageViews;
            ImageView imageView2 = this.imageView;
            imageViewArr[i19] = imageView2;
            if (i19 == 0) {
                imageView2.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(756));
            } else {
                imageView2.setBackgroundResource(com.qzone.adapter.feedcomponent.j.h(757));
            }
            this.mIndicator.addView(this.imageViews[i19], layoutParams3);
        }
        this.mViewPager.setAdapter(new RecommPageAdapter());
        ViewPagerMatchParent viewPagerMatchParent = this.mViewPager;
        viewPagerMatchParent.setOnPageChangeListener(new RecommonChangeListener(viewPagerMatchParent));
        this.mViewPager.getPaddingTop();
        this.mViewPager.getPaddingBottom();
        com.qzone.adapter.feedcomponent.i.H().Z1("1", "0");
        ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList = new ArrayList<>();
        for (int i26 = 0; i26 < getNumPerPages(); i26++) {
            arrayList.add(this.mRecommVideoInfos.get(i26));
        }
        this.mFeedAutoVideo.onReportExposed(this.mViewPager, arrayList);
        return true;
    }

    public static boolean isSupportWidthHeight(int i3, int i16) {
        return ((float) i3) <= ((float) ((i16 + 2) * 16)) / 9.0f && i3 >= FeedGlobalEnv.g().getScreenWidth() - AreaConst.dp40;
    }
}
