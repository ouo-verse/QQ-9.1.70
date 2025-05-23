package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushMoreWidget;
import com.tencent.biz.qqcircle.widgets.QCircleSimpleTextView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.qqcircle.widgets.QFSLightInteractUrgeReminderWidget;
import com.tencent.biz.qqcircle.widgets.textview.QCircleTopHintTextView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataCallBack;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudRead$StGetLightInteractListRsp;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLikeListBlock extends QCircleBaseListBlock<FeedCloudMeta$StLightInteractInfo, FeedCloudRead$StGetLightInteractListRsp> {
    private static final String COMMENT_LIKE = "\u8d5e\u8fc7\u8bc4\u8bba\u7684\u4eba";
    private static final String EARLIER = "\u66f4\u65e9";
    private static final String EMPTY_HINT = "\u6682\u65e0\u6388\u6743\u5c55\u793a\u7684\u7528\u6237";
    private static final String JOINED_FRIENDS_PAGE = "\u5df2\u52a0\u5165\u5c0f\u4e16\u754c\u7684\u597d\u53cb";
    private static final String LONG_BEFORE = "\u8f83\u65e9\u6d88\u606f";
    private static final String NEW_MESSAGE = "\u6761\u65b0\u6d88\u606f";
    private static final String TAG = "QCircleLikeListBlock";
    public static final int TYPE_CONTENT1 = 3;
    public static final int TYPE_CONTENT2 = 4;
    public static final int TYPE_CONTENT3 = 5;
    public static final int TYPE_HINT = 0;
    public static final int TYPE_TITLE1 = 1;
    public static final int TYPE_TITLE2 = 2;
    private static final String URGE_UPDATE_REMINDER = "\u50ac\u4ed6\u4eec\u66f4\u65b0";
    private static final String VISIT_FEED_PAGE = "\u770b\u5b8c\u672c\u6761\u4f5c\u54c1\u7684\u4eba";
    private static final String VISIT_PERSON = "\u6700\u8fd1\u8bbf\u5ba2";
    private static final String YESTERDAY = "\u6700\u8fd11\u5929";
    private View mBottomLine;
    private List<FeedCloudCommon$BytesEntry> mBusiTranparent;
    private String mCommentId;
    private int mCount;
    private FeedCloudMeta$StFeed mCurrentFeed;
    private String mId;
    private FeedCloudMeta$StLightInteractInfo mInteractInfo;
    private int mLightInteractType;
    private int mNoticeType;
    private String mReplyId;
    private long mTime;
    private TextView mTvTitle;
    private TextView mTvUnReadNum;

    public QCircleLikeListBlock(Bundle bundle) {
        super(bundle);
        this.mCurrentFeed = new FeedCloudMeta$StFeed();
        this.mInteractInfo = new FeedCloudMeta$StLightInteractInfo();
    }

    private Object getTitle1() {
        if (this.mLightInteractType == 23) {
            return YESTERDAY;
        }
        return this.mCount + NEW_MESSAGE;
    }

    private Object getTitle2() {
        if (this.mLightInteractType == 23) {
            return EARLIER;
        }
        return LONG_BEFORE;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        int i3 = this.mLightInteractType;
        if (i3 != 0) {
            if (i3 != 17) {
                if (i3 != 23) {
                    if (i3 != 31) {
                        if (i3 != 6 && i3 != 7) {
                            if (i3 != 19) {
                                if (i3 == 20) {
                                    hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 4);
                                }
                            } else {
                                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 3);
                            }
                        } else {
                            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 2);
                        }
                    } else {
                        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 7);
                    }
                } else {
                    hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 6);
                }
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 5);
            }
        } else {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SKIP_PG_TYPE, 1);
        }
        return hashMap;
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
        return QCircleHostDropFrameMonitorHelper._Constants.QCIRLE_LIKE_LIST_PAGE();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f183913kg);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.mDataList.size();
        int i3 = this.mLightInteractType;
        if (i3 == 19 || i3 == 20 || i3 == 22) {
            size++;
        }
        if (this.mCount == 0) {
            return size;
        }
        if (this.mDataList.size() > this.mCount) {
            return size + 2;
        }
        return size + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int i16 = this.mLightInteractType;
        if (i16 != 19 && i16 != 20 && i16 != 22) {
            int i17 = this.mCount;
            if (i17 == 0) {
                return 3;
            }
            if (i3 == 0) {
                return 1;
            }
            if (i3 < i17 + 1) {
                return 4;
            }
            if (i3 == i17 + 1) {
                return 2;
            }
            return 5;
        }
        if (i3 != 0) {
            return 3;
        }
        return 0;
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
        int i3 = this.mLightInteractType;
        if (i3 == 19) {
            return VISIT_FEED_PAGE;
        }
        if (i3 == 20) {
            return VISIT_PERSON;
        }
        if (i3 == 17) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f184633me);
        }
        if (i3 == 23) {
            return com.dataline.util.j.d(JOINED_FRIENDS_PAGE);
        }
        if (i3 == 31) {
            return URGE_UPDATE_REMINDER;
        }
        if (i3 != 6 && i3 != 7) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f183693jv);
        }
        return COMMENT_LIKE;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g4i, viewGroup, false);
        this.mTvTitle = (TextView) inflate.findViewById(R.id.f111766m4);
        this.mBottomLine = inflate.findViewById(R.id.f116256y9);
        this.mTvUnReadNum = (TextView) inflate.findViewById(R.id.f110576iw);
        this.mTvTitle.setText(getTitle());
        this.mBottomLine.setVisibility(8);
        this.mTvUnReadNum.setVisibility(8);
        return inflate;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 5;
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

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean isEnableRefresh() {
        if (this.mLightInteractType == 31) {
            return false;
        }
        return super.isEnableRefresh();
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIBackgroundDrawable() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean isNeedQUIColor() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        super.loadData(loadInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        try {
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            if (itemViewType != 4) {
                                if (itemViewType == 5) {
                                    ((QCircleBaseLightInteractWidget) viewHolder.itemView).k0(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
                                    List<E> list = this.mDataList;
                                    if (list != 0) {
                                        ((BaseListBlock.BaseListVH) viewHolder).setData(list.get(i3 - 2), i3, this.mExtraTypeInfo);
                                    }
                                }
                            } else {
                                ((QCircleBaseLightInteractWidget) viewHolder.itemView).k0(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
                                List<E> list2 = this.mDataList;
                                if (list2 != 0) {
                                    ((BaseListBlock.BaseListVH) viewHolder).setData(list2.get(i3 - 1), i3, this.mExtraTypeInfo);
                                }
                            }
                        } else {
                            ((QCircleBaseLightInteractWidget) viewHolder.itemView).k0(this.mCurrentFeed, new QCircleExtraTypeInfo(), 0);
                            List<E> list3 = this.mDataList;
                            if (list3 != 0) {
                                int size = list3.size();
                                int i16 = this.mLightInteractType;
                                if (i16 != 19 && i16 != 20 && i16 != 22) {
                                    if (i3 >= 0 && i3 < size) {
                                        ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
                                    }
                                }
                                int i17 = i3 - 1;
                                if (i17 >= 0 && i17 < size) {
                                    ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i17), i3, this.mExtraTypeInfo);
                                }
                            }
                        }
                    } else {
                        ((BaseListBlock.BaseListVH) viewHolder).setData(getTitle2(), i3, this.mExtraTypeInfo);
                    }
                } else {
                    ((BaseListBlock.BaseListVH) viewHolder).setData(getTitle1(), i3, this.mExtraTypeInfo);
                }
            } else {
                String str = EMPTY_HINT;
                if (this.mDataList.size() != 0) {
                    QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData = new QQCircleFeedBase$LightInteractionBusiData();
                    try {
                        qQCircleFeedBase$LightInteractionBusiData.mergeFrom(this.mInteractInfo.busiData.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                    str = qQCircleFeedBase$LightInteractionBusiData.splitItemText.get();
                }
                ((BaseListBlock.BaseListVH) viewHolder).setData(str, i3, this.mExtraTypeInfo);
            }
            QLog.d(TAG, 4, "onBindViewHolder:" + i3 + "  " + viewHolder + "  " + this);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "onBindViewHolder error", e17);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 1 && i3 != 2) {
            if (i3 == 0) {
                return new BaseListBlock.BaseListVH(new QCircleTopHintTextView(getContext()));
            }
            int i16 = this.mLightInteractType;
            if (i16 == 17) {
                QCircleLightInteractPushMoreWidget qCircleLightInteractPushMoreWidget = new QCircleLightInteractPushMoreWidget(getContext(), i3);
                qCircleLightInteractPushMoreWidget.setReportBeanAgent(this);
                return new BaseListBlock.BaseListVH(qCircleLightInteractPushMoreWidget);
            }
            if (i16 == 31) {
                QFSLightInteractUrgeReminderWidget qFSLightInteractUrgeReminderWidget = new QFSLightInteractUrgeReminderWidget(getContext(), i3);
                qFSLightInteractUrgeReminderWidget.setReportBeanAgent(this);
                return new BaseListBlock.BaseListVH(qFSLightInteractUrgeReminderWidget);
            }
            QCircleLightInteractPolyLikeWidget qCircleLightInteractPolyLikeWidget = new QCircleLightInteractPolyLikeWidget(getContext(), i3, this.mLightInteractType);
            qCircleLightInteractPolyLikeWidget.setReportBeanAgent(this);
            qCircleLightInteractPolyLikeWidget.setOtherParams(this.mId, this.mNoticeType, this.mCommentId, this.mReplyId);
            return new BaseListBlock.BaseListVH(qCircleLightInteractPolyLikeWidget);
        }
        return new BaseListBlock.BaseListVH(new QCircleSimpleTextView(getContext()));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        QLog.d(TAG, 1, "onPrepareParams");
        super.onInitBlock(bundle);
        getBlockMerger().setNoMoreHint("");
        ((QCircleStatusView) getHostFragment().sh().getStatusInterface()).setBackgroundColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_light));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onPartCreate(Activity activity, Bundle bundle) {
        if (QCircleReportHelper.getInstance().isPageStackEmpty()) {
            QCircleInitBean qCircleInitBean = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
            QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(qCircleInitBean.getLaunchFrom(), qCircleInitBean.getLaunchId(), qCircleInitBean.getUin(), getPageId(), qCircleInitBean.getSchemeAttrs()));
        }
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(13).setThrActionType(1));
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        boolean z16;
        super.onPartPause(activity);
        QCircleReportHelper qCircleReportHelper = QCircleReportHelper.getInstance();
        int pageId = getPageId();
        if (getHostFragment() != null && getHostFragment().isHaveInteractive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        qCircleReportHelper.recordPageEndShow(pageId, z16);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QCircleReportHelper.getInstance().recordPageStartShow(59);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStart(Activity activity) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(1));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
        int i3;
        Typeface typeface;
        int i16;
        if (view != null) {
            View view2 = this.mBottomLine;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
            TextView textView = this.mTvTitle;
            if (z16) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textView.setTypeface(typeface);
            TextView textView2 = this.mTvTitle;
            Application application = RFWApplication.getApplication();
            if (z16) {
                i16 = R.color.qui_common_brand_standard;
            } else {
                i16 = R.color.qui_common_text_primary;
            }
            textView2.setTextColor(QFSQUIUtilsKt.d(application, i16));
        }
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
                this.mCount = qCircleLikeBean.getCount();
                this.mTime = qCircleLikeBean.getTime();
                this.mBusiTranparent = qCircleLikeBean.getBusiTranparent();
                this.mNoticeType = qCircleLikeBean.getNoticeType();
                this.mCommentId = qCircleLikeBean.getCommentId();
                this.mReplyId = qCircleLikeBean.getReplyId();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
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

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<FeedCloudMeta$StLightInteractInfo> getListDataFromRsp(FeedCloudRead$StGetLightInteractListRsp feedCloudRead$StGetLightInteractListRsp, boolean z16) {
        if (feedCloudRead$StGetLightInteractListRsp.listInfo.size() >= 1) {
            this.mInteractInfo = feedCloudRead$StGetLightInteractListRsp.listInfo.get(0);
        }
        return feedCloudRead$StGetLightInteractListRsp.listInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QCircleGetLightInteractRequest(this.mCurrentFeed, str, this.mLightInteractType, this.mId, this.mTime, 2, this.mBusiTranparent);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack<FeedCloudMeta$StLightInteractInfo> iDataCallBack, String str) {
    }
}
