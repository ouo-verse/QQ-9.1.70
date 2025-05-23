package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.qzone.common.event.ui.widget.ExtendAdapterView;
import com.qzone.common.event.ui.widget.ExtendGallery;
import com.qzone.commoncode.module.videorecommend.model.VideoRecommendInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommVideoView extends LinearLayout implements com.qzone.proxy.feedcomponent.widget.g, FeedChildView {
    private static final String TAG = "FeedRecommVideoView";
    private RecommVideoAdapter mAdapter;
    private Context mContext;
    private HashSet<Integer> mExposureReportedSet;
    private ExtendGallery mGallery;
    private com.qzone.proxy.feedcomponent.ui.g mOnFeedElementClickListener;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class ViewHolder {
        View mContainer;
        View mContentItem;
        AsyncImageView mCoverImg;
        View mGetMoreItem;
        TextView mPlayCounts;
        CellTextView mTitle;

        ViewHolder() {
        }
    }

    public FeedRecommVideoView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), false);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            com.qzone.adapter.feedcomponent.i.H().u2(getContext(), true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ExtendGallery getGallery() {
        return this.mGallery;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ExtendGallery extendGallery = (ExtendGallery) findViewById(com.qzone.adapter.feedcomponent.j.O(2716));
        this.mGallery = extendGallery;
        extendGallery.setGalleryMode(2);
        this.mGallery.setOverScrollRatio(0.0f);
        this.mGallery.setUnselectedAlpha(1.0f);
        this.mGallery.setSpacing(ViewUtils.dpToPx(6.0f));
        RecommVideoAdapter recommVideoAdapter = new RecommVideoAdapter();
        this.mAdapter = recommVideoAdapter;
        this.mGallery.setAdapter((SpinnerAdapter) recommVideoAdapter);
        this.mGallery.setOnItemClickListener(new ExtendAdapterView.c() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommVideoView.1
            @Override // com.qzone.common.event.ui.widget.ExtendAdapterView.c
            public void onItemClick(ExtendAdapterView<?> extendAdapterView, View view, int i3, long j3) {
                if (FeedRecommVideoView.this.mOnFeedElementClickListener != null) {
                    FeedRecommVideoView.this.mOnFeedElementClickListener.onClick(view, FeedElement.FEEDVIDEO_PLAY_RECOMMEND, i3, FeedRecommVideoView.this.mAdapter.getItem(i3));
                }
                com.qzone.proxy.feedcomponent.b.e(FeedRecommVideoView.TAG, "reportClick position:" + i3);
                if (i3 == FeedRecommVideoView.this.mAdapter.getCount() - 1) {
                    com.qzone.adapter.feedcomponent.i.H().Y1(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, "5", "2", true);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().Y1(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, "4", "2", true);
                }
            }
        });
    }

    public void setData(ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
        this.mAdapter.setData(arrayList);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mOnFeedElementClickListener = gVar;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class RecommVideoAdapter extends BaseAdapter {
        ArrayList<com.qzone.proxy.feedcomponent.model.h> datas = new ArrayList<>();

        RecommVideoAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList = this.datas;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 < this.datas.size()) {
                return this.datas.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View view2;
            VideoInfo videoInfo;
            if (view == null) {
                view2 = LayoutInflater.from(FeedRecommVideoView.this.mContext).inflate(com.qzone.adapter.feedcomponent.j.j(FSUploadConst.ERR_GENERATE_VIDEO_COVER_FAIL), (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.mContainer = view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2712));
                viewHolder.mCoverImg = (AsyncImageView) view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2713));
                viewHolder.mTitle = (CellTextView) view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2714));
                viewHolder.mPlayCounts = (TextView) view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2715));
                viewHolder.mContentItem = view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2717));
                viewHolder.mGetMoreItem = view2.findViewById(com.qzone.adapter.feedcomponent.j.O(2718));
                viewHolder.mCoverImg.setAsyncImageProcessor(new ImageProcessor() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommVideoView.RecommVideoAdapter.2
                    @Override // com.tencent.component.media.image.ImageProcessor
                    public int getType() {
                        return hashCode();
                    }

                    @Override // com.tencent.component.media.image.ImageProcessor
                    public Drawable process(Drawable drawable) {
                        return new RoundCornerProcessor(new float[]{ViewUtils.dpToPx(3.0f), ViewUtils.dpToPx(3.0f), ViewUtils.dpToPx(3.0f), ViewUtils.dpToPx(3.0f), 0.0f, 0.0f, 0.0f, 0.0f}).process(new NormalFeedImageProcessor(ViewUtils.dpToPx(140.0f), ViewUtils.dpToPx(78.0f)).process(drawable));
                    }
                });
                view2.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            }
            viewHolder.mTitle.setClickable(false);
            viewHolder.mTitle.setLongclickable(false);
            viewHolder.mContentItem.setVisibility(0);
            viewHolder.mGetMoreItem.setVisibility(8);
            if (i3 == 0) {
                viewHolder.mContainer.setPadding(ViewUtils.dpToPx(7.0f), 0, 0, 0);
            } else if (i3 == getCount() - 1) {
                viewHolder.mContainer.setPadding(0, 0, ViewUtils.dpToPx(7.0f), 0);
                viewHolder.mContentItem.setVisibility(8);
                viewHolder.mGetMoreItem.setVisibility(0);
            } else {
                viewHolder.mContainer.setPadding(0, 0, 0, 0);
            }
            com.qzone.proxy.feedcomponent.model.h hVar = (com.qzone.proxy.feedcomponent.model.h) getItem(i3);
            if (hVar != null) {
                viewHolder.mCoverImg.setAsyncImage(hVar.f50317a);
                viewHolder.mTitle.setRichText(hVar.f50318b);
                VideoRecommendInfo videoRecommendInfo = hVar.f50319c;
                if (videoRecommendInfo != null && (videoInfo = videoRecommendInfo.mCellVideoInfo) != null) {
                    viewHolder.mPlayCounts.setText(getPlayCountText(videoInfo.videoplaycnt));
                }
                com.qzone.proxy.feedcomponent.b.e(FeedRecommVideoView.TAG, "video info--cover:" + hVar.f50317a + ",desc:" + hVar.f50318b);
            }
            if (!FeedRecommVideoView.this.mExposureReportedSet.contains(Integer.valueOf(i3))) {
                FeedRecommVideoView.this.mExposureReportedSet.add(Integer.valueOf(i3));
                if (i3 == 0) {
                    com.qzone.proxy.feedcomponent.b.e(FeedRecommVideoView.TAG, "reportExposure position:" + i3);
                    com.qzone.adapter.feedcomponent.i.H().Y1(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, "4", "1", true);
                } else if (i3 == FeedRecommVideoView.this.mAdapter.getCount() - 1) {
                    com.qzone.proxy.feedcomponent.b.e(FeedRecommVideoView.TAG, "reportExposure position:" + i3);
                    com.qzone.adapter.feedcomponent.i.H().Y1(IGuildUniteGrayTipUtilApi.GUILD_CANCEL_TOP_MESSAGE, "5", "1", true);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }

        public void setData(ArrayList<com.qzone.proxy.feedcomponent.model.h> arrayList) {
            if (arrayList != null) {
                this.datas.clear();
                this.datas.addAll(arrayList);
            }
            FeedRecommVideoView.this.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommVideoView.RecommVideoAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    RecommVideoAdapter.this.notifyDataSetChanged();
                }
            });
        }

        private String getPlayCountText(int i3) {
            if (i3 > 10000) {
                return String.format("%.1f\u4e07\u6b21", Float.valueOf(i3 / 10000.0f));
            }
            return String.format("%d\u6b21", Integer.valueOf(i3));
        }
    }

    public FeedRecommVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mExposureReportedSet = new HashSet<>();
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
    }
}
