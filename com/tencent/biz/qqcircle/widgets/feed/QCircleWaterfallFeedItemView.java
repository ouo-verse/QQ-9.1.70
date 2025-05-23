package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StLikeBusiData;
import qqcircle.QQCircleFeedBase$StPolyLike;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;
import ua0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleWaterfallFeedItemView extends QCircleBaseWidgetView implements View.OnClickListener, SimpleEventReceiver {
    private static final int FIRST_LINE_TOP_MARGIN = cx.a(9.0f);
    private static final String TAG = "QCircleWaterfallFeedItemView";
    private ImageView mCover;
    private FeedCloudMeta$StFeed mFeed;
    private FrameLayout mFlRecomLayout;
    private LinearLayout mItemLayout;
    private QCircleAvatarView mIvAvatar;
    private ImageView mIvPicIcon;
    private ImageView mIvRecomIcon;
    private LinearLayout mLlFuelLayout;
    private LinearLayout mLlPublishTimeContainer;
    private LinearLayout mLlRecomLayout;
    private int mPosition;
    private LinearLayout mRlUserLayout;
    private RoundCorneredRelativeLayout mRoundItem;
    private TextView mTvFuelNum;
    private TextView mTvNearbyText;
    private TextView mTvPublishTime;
    private TextView mTvRecomText;
    private QCircleAsyncTextView mTvTitle;
    private TextView mTvUser;
    private Size mUserAvatarSize;

    public QCircleWaterfallFeedItemView(Context context) {
        this(context, 0);
    }

    private void adjustFirstLineTopMargin() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mItemLayout.getLayoutParams();
        int i3 = this.mPosition;
        if (i3 != 0 && i3 != 1) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, FIRST_LINE_TOP_MARGIN, 0, 0);
        }
        this.mItemLayout.setLayoutParams(layoutParams);
    }

    private Map<String, Object> getDaTongReportParamMap() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(c.e(this.mFeed));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.mPosition + 1));
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.mPosition));
        if (!this.mFeed.reportInfoForClient.has()) {
            return buildElementParams;
        }
        try {
            QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.mFeed.reportInfoForClient.get().toByteArray());
            if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.w(TAG, 1, "QCircleWaterfallFeedItemView, transferInfo error");
        }
        return buildElementParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initOtherUIByViewType() {
        if (this.mFeed != null && (getData() instanceof b)) {
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) ((b) getData()).b("DITTO_FEED_BUSI_REQ_DATA");
            FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(this.mFeed.f398449id.get());
            if (f16 != null && qQCircleFeedBase$StFeedBusiReqData != null) {
                qQCircleFeedBase$StFeedBusiReqData.pushList.set(f16);
                this.mFeed.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
            }
            if (getViewType() == 0) {
                updateFuelLayoutData();
                return;
            }
            if (1 == getViewType()) {
                this.mLlFuelLayout.setVisibility(8);
                initPoiUI();
                adjustFirstLineTopMargin();
            } else if (2 == getViewType()) {
                updateFuelLayoutData();
                updateRecomUIData();
                adjustFirstLineTopMargin();
            }
        }
    }

    private void initPoiUI() {
        int i3 = 8;
        if (this.mFeed.poiInfo.has()) {
            String str = this.mFeed.poiInfo.get().distanceText.get();
            boolean z16 = !TextUtils.isEmpty(str);
            if (z16) {
                this.mTvNearbyText.setText(str);
            }
            LinearLayout linearLayout = this.mLlRecomLayout;
            if (z16) {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
            return;
        }
        this.mLlRecomLayout.setVisibility(8);
    }

    private void reportClickFeedInfo(String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QCircleLpReportDc05501.DataBuilder index = c.a(feedCloudMeta$StFeed).setToUin(this.mFeed.poster.f398463id.get()).setActionType(97).setSubActionType(2).setIndex(this.mPosition);
        if (str == null) {
            str = "";
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(index.setExt6(str).setPageId(getPageId())));
    }

    private void setUserAvatar(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QCircleAvatarView qCircleAvatarView = this.mIvAvatar;
        if (qCircleAvatarView == null) {
            QLog.d(TAG, 1, "[setUserAvatar] avatar should not be null.");
        } else {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.mUserAvatarSize);
        }
    }

    private void updateFeed(int i3, int i16, QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLike = feedCloudMeta$StFeed.likeInfo) != null) {
            feedCloudMeta$StLike.count.set(i16);
            new QQCircleFeedBase$StLikeBusiData();
            try {
                QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
                qQCircleFeedBase$StLikeBusiData.mergeFrom(this.mFeed.likeInfo.busiData.get().toByteArray());
                if (i3 == 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : qQCircleFeedBase$StLikeBusiData.likeIDs.get()) {
                        if (TextUtils.equals(str, "206008") || TextUtils.equals(str, "205993")) {
                            arrayList.add(str);
                        }
                    }
                    qQCircleFeedBase$StLikeBusiData.likeIDs.set(arrayList);
                } else {
                    if (qQCircleFeedBase$StLikeBusiData.likeIDs.get().contains(qQCircleFeedBase$StPolyLike.polyLikeID.get())) {
                        return;
                    }
                    qQCircleFeedBase$StLikeBusiData.curPolyLikeInfo.set(qQCircleFeedBase$StPolyLike);
                    qQCircleFeedBase$StLikeBusiData.likeIDs.add(qQCircleFeedBase$StPolyLike.polyLikeID.get());
                }
                this.mFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StLikeBusiData.toByteArray()));
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void updateFeedCover() {
        String str;
        if (this.mFeed == null) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected));
        obtain.mFailedDrawable = getResources().getDrawable(R.drawable.ojc);
        Pair<Integer, Integer> measureCoverWidthAndHeight = measureCoverWidthAndHeight(this.mFeed);
        if (((Integer) measureCoverWidthAndHeight.first).intValue() != 0 && ((Integer) measureCoverWidthAndHeight.second).intValue() != 0) {
            ViewGroup.LayoutParams layoutParams = this.mCover.getLayoutParams();
            layoutParams.width = ((Integer) measureCoverWidthAndHeight.first).intValue();
            layoutParams.height = ((Integer) measureCoverWidthAndHeight.second).intValue();
            this.mCover.requestLayout();
            obtain.mRequestWidth = ((Integer) measureCoverWidthAndHeight.first).intValue();
            obtain.mRequestHeight = ((Integer) measureCoverWidthAndHeight.second).intValue();
            QLog.i(TAG, 1, "mCover  measureCoverWidthAndHeight  params.width : " + measureCoverWidthAndHeight.first + " , params.height : " + measureCoverWidthAndHeight.second + " , requestResult.width:" + measureCoverWidthAndHeight.first + " , requestResult.height:" + measureCoverWidthAndHeight.second);
        } else if (this.mCover.getLayoutParams() != null) {
            obtain.mRequestWidth = this.mCover.getLayoutParams().width;
            obtain.mRequestHeight = this.mCover.getLayoutParams().height;
            QLog.i(TAG, 1, "mCover width : " + this.mCover.getLayoutParams().width + " , height : " + this.mCover.getLayoutParams().height);
        }
        if (this.mCover.getTag(R.id.f113916rx) instanceof String) {
            str = (String) this.mCover.getTag(R.id.f113916rx);
        } else {
            str = "";
        }
        this.mCover.setTag(R.id.f113916rx, this.mFeed.cover.picUrl.get());
        if (!str.equals(this.mFeed.cover.picUrl.get())) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.mFeed.cover.picUrl.get()).setTargetView(this.mCover).setFromPreLoad(false).setPredecode(true).setRequestWidth(obtain.mRequestWidth).setRequestHeight(obtain.mRequestHeight).setLoadingDrawable(obtain.mLoadingDrawable).setFailDrawable(obtain.mFailedDrawable));
        }
    }

    private void updateFuelLayoutData() {
        int i3 = 8;
        this.mFlRecomLayout.setVisibility(8);
        this.mLlRecomLayout.setVisibility(8);
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(this.mFeed.busiData.get().toByteArray());
            if (qQCircleFeedBase$StFeedBusiReqData.pushList.has()) {
                long j3 = qQCircleFeedBase$StFeedBusiReqData.pushList.totalClickCount.get();
                this.mTvFuelNum.setText(r.f(j3));
                LinearLayout linearLayout = this.mLlFuelLayout;
                if (j3 > 0) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void updateRecomUIData() {
        String str;
        this.mFlRecomLayout.setVisibility(8);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.recomInfo.has() && !TextUtils.isEmpty(this.mFeed.recomInfo.recomReason.get()) && !TextUtils.isEmpty(this.mFeed.recomInfo.iconUrl.get())) {
            this.mTvRecomText.setText(this.mFeed.recomInfo.recomReason.get());
            if (this.mIvRecomIcon.getTag(R.id.y7u) instanceof String) {
                str = (String) this.mIvRecomIcon.getTag(R.id.y7u);
            } else {
                str = "";
            }
            this.mIvRecomIcon.setTag(R.id.y7u, this.mFeed.recomInfo.iconUrl.get());
            if (!str.equals(this.mFeed.recomInfo.iconUrl.get())) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.mFeed.recomInfo.iconUrl.get()).setTargetView(this.mIvRecomIcon).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.mIvRecomIcon.getLayoutParams().width).setRequestHeight(this.mIvRecomIcon.getLayoutParams().height), new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView.3
                    @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                    public void onStateChange(LoadState loadState, Option option) {
                        super.onStateChange(loadState, option);
                        QLog.d(QCircleWaterfallFeedItemView.TAG, 1, option.getUrl() + "\n, state callback:" + loadState);
                    }
                });
            }
            this.mFlRecomLayout.setVisibility(0);
        }
    }

    private void waterfallItemDtReport() {
        LinearLayout linearLayout = this.mItemLayout;
        if (linearLayout != null && this.mFeed != null) {
            VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_FEED);
            VideoReport.setElementReuseIdentifier(this.mItemLayout, "em_xsj_feed_" + this.mFeed.hashCode());
            VideoReport.setElementParams(this.mItemLayout, getDaTongReportParamMap());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        if (!(obj instanceof b)) {
            return;
        }
        this.mPosition = i3;
        FeedCloudMeta$StFeed g16 = ((b) obj).g();
        this.mFeed = g16;
        if (g16.type.get() == 3) {
            this.mIvPicIcon.setVisibility(8);
        } else if (this.mFeed.type.get() == 2) {
            this.mIvPicIcon.setVisibility(0);
        }
        updateFeedCover();
        updatePublishTime();
        setUserAvatar(this.mFeed.poster);
        if (!TextUtils.isEmpty(this.mFeed.content.get())) {
            this.mTvTitle.setNeedSpecialAreaBold(false);
            this.mTvTitle.setSpecialClickAreaColor(R.color.qvideo_skin_color_text_primary);
            this.mTvTitle.setNeedSpecialHashTagAreaBackground(false);
            this.mTvTitle.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView.1
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
                public void onClick(String str) {
                    if (QCircleWaterfallFeedItemView.this.mItemLayout != null) {
                        QCircleWaterfallFeedItemView.this.mItemLayout.callOnClick();
                    }
                }
            });
            this.mTvTitle.setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView.2
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
                public void onClick(String str) {
                    if (QCircleWaterfallFeedItemView.this.mItemLayout != null) {
                        QCircleWaterfallFeedItemView.this.mItemLayout.callOnClick();
                    }
                }
            });
            this.mTvTitle.setText(this.mFeed.content.get());
            this.mTvTitle.setVisibility(0);
        } else {
            this.mTvTitle.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRlUserLayout.getLayoutParams();
            layoutParams.topMargin = ImmersiveUtils.dpToPx(10.0f);
            this.mRlUserLayout.setLayoutParams(layoutParams);
        }
        this.mTvUser.setText(this.mFeed.poster.nick.get());
        initOtherUIByViewType();
        waterfallItemDtReport();
    }

    public QCircleLayerBean getDetailInitBean() {
        int hashCode;
        if (this.mFeed != null && this.mCover != null) {
            QCircleExtraTypeInfo qCircleExtraTypeInfo = getQCircleExtraTypeInfo();
            if (qCircleExtraTypeInfo == null) {
                return new QCircleLayerBean();
            }
            QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setExtraTypeInfo(qCircleExtraTypeInfo);
            qCircleLayerBean.setFeed(this.mFeed);
            if (this.mFeed.poiInfo.has() && qCircleExtraTypeInfo.pageType == 12) {
                qCircleLayerBean.setPoiInfo(this.mFeed.poiInfo.get());
            }
            qCircleLayerBean.setDataPosInList(getDataPosInList());
            qCircleLayerBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(qCircleExtraTypeInfo.pageType);
            qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
            qCircleLayerBean.setTransInitBean(qCircleInitBean);
            qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
            qCircleLayerBean.setGlobalViewModelKey(qCircleExtraTypeInfo.mGlobalViewModelKey);
            if (getQCircleBaseFragment() == null) {
                hashCode = 0;
            } else {
                hashCode = getQCircleBaseFragment().hashCode();
            }
            qCircleLayerBean.setPageCode(hashCode);
            int[] iArr = new int[2];
            this.mCover.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i3 = iArr[0];
            qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.mCover.getWidth() + i3, iArr[1] + this.mCover.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.mFeed.cover.picUrl.get()));
            if (this.mCover != null) {
                qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.mCover.getDrawable());
            }
            return qCircleLayerBean;
        }
        return new QCircleLayerBean();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePolyPraiseUpdateEvent.class);
        arrayList.add(QCirclePushUpdateEvent.class);
        return arrayList;
    }

    public FeedCloudMeta$StFeed getFeedData() {
        return this.mFeed;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g6e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    public int getPosition() {
        return this.mPosition;
    }

    protected void initView() {
        this.mItemLayout = (LinearLayout) findViewById(R.id.yot);
        this.mRoundItem = (RoundCorneredRelativeLayout) findViewById(R.id.ifh);
        this.mCover = (ImageView) findViewById(R.id.f113916rx);
        this.mIvPicIcon = (ImageView) findViewById(R.id.y6u);
        this.mTvTitle = (QCircleAsyncTextView) findViewById(R.id.kbs);
        this.mIvAvatar = (QCircleAvatarView) findViewById(R.id.f85674pl);
        this.mTvUser = (TextView) findViewById(R.id.f112276nh);
        this.mLlFuelLayout = (LinearLayout) findViewById(R.id.yo9);
        this.mTvFuelNum = (TextView) findViewById(R.id.f108126c_);
        this.mFlRecomLayout = (FrameLayout) findViewById(R.id.v8j);
        this.mLlRecomLayout = (LinearLayout) findViewById(R.id.yph);
        this.mTvRecomText = (TextView) findViewById(R.id.f110536is);
        this.mTvNearbyText = (TextView) findViewById(R.id.f109496fz);
        this.mIvRecomIcon = (ImageView) findViewById(R.id.y7u);
        this.mRlUserLayout = (LinearLayout) findViewById(R.id.yre);
        this.mLlPublishTimeContainer = (LinearLayout) findViewById(R.id.f29220l2);
        this.mTvPublishTime = (TextView) findViewById(R.id.k_f);
        this.mItemLayout.setOnClickListener(this);
        this.mTvTitle.setOnClickListener(this);
        float a16 = cx.a(8.0f);
        this.mRoundItem.setRadius(a16, a16, a16, a16);
        this.mUserAvatarSize = n.a(getContext(), R.dimen.d4w);
    }

    public Pair<Integer, Integer> measureCoverWidthAndHeight(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return new Pair<>(0, 0);
        }
        int screenWidth = (ImmersiveUtils.getScreenWidth() / 2) - cx.a(4.0f);
        float f16 = 1.3333334f;
        if (feedCloudMeta$StFeed.type.get() == 3) {
            if (this.mFeed.video.width.get() >= this.mFeed.video.height.get()) {
                f16 = 0.75f;
            }
            return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf((int) (screenWidth * f16)));
        }
        if (this.mFeed.type.get() == 2) {
            float f17 = feedCloudMeta$StFeed.cover.height.get() / feedCloudMeta$StFeed.cover.width.get();
            if (f17 <= 1.3333334f) {
                f16 = f17;
            }
            return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf((int) (screenWidth * f16)));
        }
        return new Pair<>(0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        QLog.d(TAG, 4, "registerReceiver");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if ((id5 == R.id.yot || id5 == R.id.kbs) && this.mFeed != null && this.mCover != null) {
            com.tencent.biz.qqcircle.launcher.c.u(this.mCover.getContext(), getDetailInitBean());
            reportClickFeedInfo("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QLog.d(TAG, 4, "unRegisterReceiver");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && (simpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)) {
            QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qCirclePolyPraiseUpdateEvent.mTargetFeedId)) {
                updateFeed(qCirclePolyPraiseUpdateEvent.mPraisedStatus, qCirclePolyPraiseUpdateEvent.mPraisedNum, qCirclePolyPraiseUpdateEvent.mNewStPolyLike);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCirclePushUpdateEvent) {
            updatePushListChange((QCirclePushUpdateEvent) simpleBaseEvent);
        }
    }

    public void updatePublishTime() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e(TAG, 1, "[updatePublishTime] mFeed == null");
            return;
        }
        String str = feedCloudMeta$StFeed.publishTimeDesc.get();
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "[updatePublishTime] mFeed.publishTimeDesc text is empty");
            this.mLlPublishTimeContainer.setVisibility(8);
        } else {
            this.mLlPublishTimeContainer.setVisibility(0);
            this.mTvPublishTime.setText(str);
        }
    }

    public void updatePushListChange(QCirclePushUpdateEvent qCirclePushUpdateEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && qCirclePushUpdateEvent != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qCirclePushUpdateEvent.mTargetFeedId)) {
            QLog.d(TAG, 1, "updatePushUserList feedId" + qCirclePushUpdateEvent.mTargetFeedId + " allPushTimes:" + qCirclePushUpdateEvent.mAllPushTimes);
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(this.mFeed.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "[updatePushListChange] error: ", e16);
            }
            QCirclePushInfoManager.e().p(this.mFeed.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
            this.mFeed.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
            if (1 != getViewType()) {
                updateFuelLayoutData();
            }
        }
    }

    public QCircleWaterfallFeedItemView(@NonNull Context context, Integer num) {
        super(context, num.intValue());
        initView();
    }
}
