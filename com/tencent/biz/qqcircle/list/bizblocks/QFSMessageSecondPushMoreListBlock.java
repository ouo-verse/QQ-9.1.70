package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QFSMessageLightInteractInfo;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageTopFansReminderNumItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSSplitLineItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSUrgeCardItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushMoreWidget;
import com.tencent.biz.qqcircle.widgets.QFSDefaultItemView;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudRead$StGetLightInteractListRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StUnifiedTagPageData;

/* loaded from: classes4.dex */
public class QFSMessageSecondPushMoreListBlock extends QCircleBaseListBlock<QFSMessageLightInteractInfo, FeedCloudRead$StGetLightInteractListRsp> {
    private static final String TAG = "QFSMessageSecondPushMoreListBlock";
    private View.OnClickListener mBottomBarClickListener;
    private ViewGroup mBottomBarContainer;
    private String mBottomBarJumpUrl;
    private List<FeedCloudCommon$BytesEntry> mBusiTranparent;
    private FeedCloudMeta$StFeed mCurrentFeed;
    private String mId;
    private int mLightInteractType;
    private boolean mNeedAddSpilt;
    private boolean mNeedShowBottomBar;
    private long mSplitTime;
    private long mTime;
    private final List<FeedCloudCommon$Entry> mTransMapInfo;
    private TextView mTvBottomBtn;
    private TextView mTvTitle;
    private String mUrgeNumFromInitBean;
    private String mUrgeNumFromRsp;

    public QFSMessageSecondPushMoreListBlock(Bundle bundle) {
        super(bundle);
        this.mNeedShowBottomBar = true;
        this.mNeedAddSpilt = true;
        this.mTransMapInfo = new ArrayList();
        this.mCurrentFeed = new FeedCloudMeta$StFeed();
    }

    private void initBottomBar() {
        View view;
        if (getHostFragment() == null) {
            view = null;
        } else {
            view = getHostFragment().getView();
        }
        if (view == null) {
            return;
        }
        this.mBottomBarContainer = (ViewGroup) view.findViewById(R.id.yp_);
        TextView textView = (TextView) view.findViewById(R.id.f109316fh);
        this.mTvBottomBtn = textView;
        textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f193844aa));
        this.mTvBottomBtn.setOnClickListener(getBottomBarListener());
        reportDT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBottomBarListener$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(this.mBottomBarJumpUrl)) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), cy.c(cy.a(this.mBottomBarJumpUrl, QCirclePublishQualityReporter.getTraceId()), 3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleResponse$1(FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
        if (feedCloudRead$StGetLightInteractListRsp != null && feedCloudRead$StGetLightInteractListRsp.extInfo.has()) {
            try {
                this.mSplitTime = Long.parseLong(bh.d(feedCloudRead$StGetLightInteractListRsp.extInfo.mapInfo.get(), "split_time"));
            } catch (Exception e16) {
                QLog.e(getLogTag(), 1, "[parseExtInfo] split time error:" + e16.toString());
            }
            this.mUrgeNumFromRsp = bh.d(feedCloudRead$StGetLightInteractListRsp.extInfo.mapInfo.get(), "urge_count");
            QLog.d(getLogTag(), 1, "[parseExtInfo] mSplitTime:" + this.mSplitTime + " | mUrgeNumFromRsp:" + this.mUrgeNumFromRsp);
            return;
        }
        QLog.e(getLogTag(), 1, "[parseExtInfo] not has extInfo");
    }

    private void reportDT() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondPushMoreListBlock.2
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.setElementId(QFSMessageSecondPushMoreListBlock.this.mTvBottomBtn, QCircleDaTongConstant.ElementId.EM_XSJ_PUBLISH_BY_REQUEST);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_WAITING_FOR_UPDATE_FANS_NUM, QFSMessageSecondPushMoreListBlock.this.mUrgeNumFromInitBean);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, "bottom");
                VideoReport.setElementParams(QFSMessageSecondPushMoreListBlock.this.mTvBottomBtn, buildElementParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottomBarVisible(int i3) {
        ViewGroup viewGroup = this.mBottomBarContainer;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(i3);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(QFSMessageLightInteractInfo qFSMessageLightInteractInfo) {
        return null;
    }

    protected View.OnClickListener getBottomBarListener() {
        if (this.mBottomBarClickListener == null) {
            this.mBottomBarClickListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.list.bizblocks.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageSecondPushMoreListBlock.this.lambda$getBottomBarListener$0(view);
                }
            };
        }
        return this.mBottomBarClickListener;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 5);
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getContentLayoutId() {
        return R.layout.f168712gj2;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_MORE_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_MESSAGE_NOTICE();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        QFSMessageLightInteractInfo qFSMessageLightInteractInfo;
        List<E> list = this.mDataList;
        if (list == 0 || list.size() <= i3 || (qFSMessageLightInteractInfo = (QFSMessageLightInteractInfo) this.mDataList.get(i3)) == null) {
            return -1;
        }
        return qFSMessageLightInteractInfo.getType();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f184633me);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    protected String getTopFansNumTxt() {
        int i3;
        try {
            i3 = Integer.parseInt(this.mUrgeNumFromRsp);
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "[getTopFansNumTxt] error:" + e16.toString());
            i3 = 0;
        }
        if (i3 > 0) {
            return HostChatUtils.getMaxUnReadCountText(i3);
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.kbs);
            this.mTvTitle = textView;
            if (textView != null) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        View view = viewHolder.itemView;
        if (!(view instanceof QCircleBaseLightInteractWidget)) {
            return;
        }
        ((QCircleBaseLightInteractWidget) view).k0(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
        if (ab0.a.a(i3, this.mDataList)) {
            return;
        }
        ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == -1) {
            return new BaseListBlock.BaseListVH(new QFSDefaultItemView(viewGroup.getContext(), i3));
        }
        if (i3 == -1000) {
            return new BaseListBlock.BaseListVH(new QFSSplitLineItemView(viewGroup.getContext(), i3));
        }
        if (i3 == -200) {
            return new BaseListBlock.BaseListVH(new QFSMessageTopFansReminderNumItemView(viewGroup.getContext(), i3));
        }
        if (i3 == -300) {
            return new BaseListBlock.BaseListVH(new QFSUrgeCardItemView(viewGroup.getContext(), i3));
        }
        QCircleLightInteractPushMoreWidget qCircleLightInteractPushMoreWidget = new QCircleLightInteractPushMoreWidget(getContext(), i3);
        qCircleLightInteractPushMoreWidget.setReportBeanAgent(this);
        return new BaseListBlock.BaseListVH(qCircleLightInteractPushMoreWidget);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        initBottomBar();
        BlockContainer blockContainer = getBlockContainer();
        if (blockContainer == null) {
            return;
        }
        if (blockContainer.getBlockMerger() != null && getContext() != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_tertiary));
            blockContainer.getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        if (blockContainer.getRecyclerView() != null) {
            blockContainer.getRecyclerView().setClipChildren(false);
            blockContainer.getRecyclerView().setClipToPadding(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void preHandleListData(List<QFSMessageLightInteractInfo> list, boolean z16, boolean z17, boolean z18) {
        int i3;
        if (list != null && list.size() > 0) {
            if (!z17) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.QFSMessageSecondPushMoreListBlock.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16;
                        QFSMessageSecondPushMoreListBlock qFSMessageSecondPushMoreListBlock = QFSMessageSecondPushMoreListBlock.this;
                        if (qFSMessageSecondPushMoreListBlock.mNeedShowBottomBar) {
                            i16 = 0;
                        } else {
                            i16 = 8;
                        }
                        qFSMessageSecondPushMoreListBlock.setBottomBarVisible(i16);
                        QFSMessageSecondPushMoreListBlock.this.mNeedShowBottomBar = true;
                    }
                });
            }
            String topFansNumTxt = getTopFansNumTxt();
            QLog.d(getLogTag(), 1, "[preHandleListData] mUrgeNumFromRsp:" + this.mUrgeNumFromRsp + " | fansNum:" + topFansNumTxt);
            if (!z17 && !TextUtils.isEmpty(topFansNumTxt)) {
                list.add(0, QFSMessageLightInteractInfo.obtainFansReminder(topFansNumTxt));
            }
            if (!z17) {
                this.mNeedAddSpilt = true;
            }
            if (!this.mNeedAddSpilt) {
                return;
            }
            ListIterator<QFSMessageLightInteractInfo> listIterator = list.listIterator();
            while (true) {
                if (!listIterator.hasNext()) {
                    break;
                }
                if (listIterator.next().getStLightInteractInfo() != null && this.mNeedAddSpilt && this.mSplitTime > r1.opTime.get()) {
                    this.mNeedAddSpilt = false;
                    if (z17 || listIterator.nextIndex() != 1) {
                        i3 = listIterator.nextIndex() - 1;
                    }
                }
            }
            i3 = -1;
            if (i3 != -1) {
                list.add(i3, QFSMessageLightInteractInfo.obtainDivider());
                return;
            }
            return;
        }
        QLog.e(getLogTag(), 1, "[preHandleListData] listData == null or empty");
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void setInitBean(Serializable serializable) {
        super.setInitBean(serializable);
        try {
            Serializable serializable2 = this.mInitBean;
            if (serializable2 instanceof QCircleLikeBean) {
                QCircleLikeBean qCircleLikeBean = (QCircleLikeBean) serializable2;
                this.mCurrentFeed = qCircleLikeBean.getFeed();
                this.mId = qCircleLikeBean.getLikeId();
                this.mLightInteractType = qCircleLikeBean.getRequestType();
                this.mTime = qCircleLikeBean.getTime();
                this.mBusiTranparent = qCircleLikeBean.getBusiTranparent();
                if (qCircleLikeBean.getSchemeAttrs() != null && qCircleLikeBean.getSchemeAttrs().containsKey("jump_url")) {
                    this.mBottomBarJumpUrl = qCircleLikeBean.getSchemeAttrs().get("jump_url");
                }
                if (qCircleLikeBean.getSchemeAttrs() != null && qCircleLikeBean.getSchemeAttrs().containsKey(QCircleSchemeAttr.MessageList.COUNT)) {
                    this.mUrgeNumFromInitBean = qCircleLikeBean.getSchemeAttrs().get(QCircleSchemeAttr.MessageList.COUNT);
                }
                if (!TextUtils.isEmpty(this.mUrgeNumFromInitBean)) {
                    FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                    feedCloudCommon$Entry.key.set("req_urge_count");
                    feedCloudCommon$Entry.value.set(this.mUrgeNumFromInitBean);
                    this.mTransMapInfo.add(feedCloudCommon$Entry);
                }
                QLog.d(getLogTag(), 1, "[setInitBean] mUrgeNumFromInitBean:" + this.mUrgeNumFromInitBean + " | mBottomBarJumpUrl:" + this.mBottomBarJumpUrl);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[setInitBean] error:" + e16.toString());
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
        return feedCloudRead$StGetLightInteractListRsp.attachInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
        return feedCloudRead$StGetLightInteractListRsp.isFinish.get() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0017 A[SYNTHETIC] */
    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<QFSMessageLightInteractInfo> getListDataFromRsp(FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp, boolean z16) {
        QQCircleFeedBase$StUnifiedTagPageData qQCircleFeedBase$StUnifiedTagPageData;
        if (feedCloudRead$StGetLightInteractListRsp == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = feedCloudRead$StGetLightInteractListRsp.extInfo;
        if (feedCloudCommon$StCommonExt != null) {
            for (FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry : feedCloudCommon$StCommonExt.mapBytesInfo.get()) {
                if (feedCloudCommon$BytesEntry != null && "publish_guide".equals(feedCloudCommon$BytesEntry.key.get())) {
                    try {
                        qQCircleFeedBase$StUnifiedTagPageData = new QQCircleFeedBase$StUnifiedTagPageData();
                        try {
                            qQCircleFeedBase$StUnifiedTagPageData.mergeFrom(feedCloudCommon$BytesEntry.value.get().toByteArray());
                        } catch (Exception e16) {
                            e = e16;
                            QLog.d(TAG, 1, "StUnifiedTagPageData mergeFrom fail", e);
                            if (qQCircleFeedBase$StUnifiedTagPageData == null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        qQCircleFeedBase$StUnifiedTagPageData = null;
                    }
                    if (qQCircleFeedBase$StUnifiedTagPageData == null) {
                        QFSMessageLightInteractInfo qFSMessageLightInteractInfo = new QFSMessageLightInteractInfo(-300);
                        qFSMessageLightInteractInfo.setStUnifiedTagPageData(qQCircleFeedBase$StUnifiedTagPageData);
                        qFSMessageLightInteractInfo.setFansReminderNum(this.mUrgeNumFromRsp);
                        arrayList.add(qFSMessageLightInteractInfo);
                        this.mNeedShowBottomBar = false;
                    }
                }
            }
        }
        PBRepeatMessageField<FeedCloudMeta$StLightInteractInfo> pBRepeatMessageField = feedCloudRead$StGetLightInteractListRsp.listInfo;
        if (pBRepeatMessageField == null) {
            return arrayList;
        }
        for (FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo : pBRepeatMessageField.get()) {
            QFSMessageLightInteractInfo qFSMessageLightInteractInfo2 = new QFSMessageLightInteractInfo(-100);
            qFSMessageLightInteractInfo2.setStLightInteractInfo(feedCloudMeta$StLightInteractInfo);
            arrayList.add(qFSMessageLightInteractInfo2);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QCircleGetLightInteractRequest(this.mCurrentFeed, str, this.mLightInteractType, this.mId, this.mTime, 2, this.mBusiTranparent, this.mTransMapInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, boolean z17, long j3, @Nullable BaseRequest baseRequest, String str, final FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.list.bizblocks.e
            @Override // java.lang.Runnable
            public final void run() {
                QFSMessageSecondPushMoreListBlock.this.lambda$handleResponse$1(feedCloudRead$StGetLightInteractListRsp);
            }
        });
        super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetLightInteractListRsp);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<QFSMessageLightInteractInfo> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
