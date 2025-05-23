package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StNoticeCategory;
import java.util.Map;
import qqcircle.QQCircleCounterMsg$MergePsvRedPoint;

/* loaded from: classes4.dex */
public class QFSCategoryMessagePresenter extends a implements View.OnClickListener {
    private static final int DELAY_DISMISS_RED_POINT = 200;
    private static final int MESSAGE_TEXT_SIZE = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.c6v);
    private static final int SECOND_MESSAGE_TEXT_SIZE = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.c6u);
    private static final String TAG = "QFSCategoryMessagePresenter";
    protected Size mDefAvatarSize;
    private ImageView mIvIcon;
    private View mLlRightNext;
    private View mLlRightRedDot;
    private View mLlRightRedPoint;
    private View mRightAreaView;
    private QCircleAsyncTextView mTvMessage;
    private TextView mTvNick;
    private DragTextView mTvRedPointNum;
    private TextView mTvTime;
    private TextView mUserTypeLabel;

    public QFSCategoryMessagePresenter(int i3) {
        super(i3);
    }

    private void adjustIconSize() {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView = this.mIvIcon;
        if (imageView != null) {
            layoutParams = imageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            QLog.e(getLogTag(), 1, "[adjustIconSize] layout params is null");
            return;
        }
        Size size = this.mDefAvatarSize;
        if (size == null) {
            QLog.e(getLogTag(), 1, "[adjustIconSize] mDefAvatarSize is null");
            return;
        }
        layoutParams.width = size.getWidth();
        layoutParams.height = this.mDefAvatarSize.getHeight();
        this.mIvIcon.setLayoutParams(layoutParams);
    }

    private void clearClientTrans(@NonNull View view, @NonNull QCircleInitBean qCircleInitBean) {
        Intent intent;
        Context context = view.getContext();
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return;
        }
        qCircleInitBean.setCommonExtInfo(new FeedCloudCommon$StCommonExt());
        intent.putExtra("key_bundle_common_init_bean", qCircleInitBean);
    }

    private Map<String, Object> getItemReportParams(@NonNull FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_msg_entrance_name_new", feedCloudMeta$StNoticeCategory.report_info.entrance_name.get());
        buildElementParams.put("xsj_operation_activity_id", feedCloudMeta$StNoticeCategory.report_info.psv_task_id.get());
        q.r().m(feedCloudMeta$StNoticeCategory.report_info.busiReport.get().toByteArray(), buildElementParams);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 0);
        QQCircleCounterMsg$MergePsvRedPoint y16 = q.r().y(feedCloudMeta$StNoticeCategory.f398455id.get());
        if (y16 == null) {
            y16 = new QQCircleCounterMsg$MergePsvRedPoint();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(y16.type.get()));
        buildElementParams.put("xsj_reddot_number", Integer.valueOf(y16.num.get()));
        return buildElementParams;
    }

    private void handleJumpPage(@NonNull View view, @NonNull FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        if (QCirclePluginUtil.getUrlType(feedCloudMeta$StNoticeCategory.jump_url.get()) == 1) {
            QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(view.getContext());
            if (qCircleInitBean == null) {
                return;
            }
            String str = new String(Base64.encode(qCircleInitBean.getCommonExtInfo().toByteArray(), 0));
            QCircleHostLauncher.doJumpAction(view.getContext(), feedCloudMeta$StNoticeCategory.jump_url.get() + ContainerUtils.FIELD_DELIMITER + "client_trans" + ContainerUtils.KEY_VALUE_DELIMITER + str);
            clearClientTrans(view, qCircleInitBean);
            return;
        }
        QCircleSchemeLauncher.f(view.getContext(), feedCloudMeta$StNoticeCategory.jump_url.get());
    }

    private void inflateRightView() {
        boolean z16;
        int i3;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.isRightAreaVerticalCenter()) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view = this.mContainer;
        if (z16) {
            i3 = R.id.f46851vp;
        } else {
            i3 = R.id.f46841vo;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(i3);
        if (viewStub == null) {
            return;
        }
        View view2 = this.mRightAreaView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View inflate = viewStub.inflate();
        this.mRightAreaView = inflate;
        this.mLlRightNext = inflate.findViewById(R.id.yqe);
        this.mLlRightRedDot = this.mRightAreaView.findViewById(R.id.yqf);
        this.mLlRightRedPoint = this.mRightAreaView.findViewById(R.id.yqg);
        this.mTvRedPointNum = (DragTextView) this.mRightAreaView.findViewById(R.id.f110576iw);
        if (z16) {
            int a16 = cx.a(4.0f);
            View view3 = this.mLlRightNext;
            view3.setPadding(a16, view3.getPaddingTop(), this.mLlRightNext.getPaddingRight(), this.mLlRightNext.getPaddingBottom());
            View view4 = this.mLlRightRedDot;
            view4.setPadding(a16, view4.getPaddingTop(), this.mLlRightRedDot.getPaddingRight(), this.mLlRightRedDot.getPaddingBottom());
            View view5 = this.mLlRightRedPoint;
            view5.setPadding(a16, view5.getPaddingTop(), this.mLlRightRedPoint.getPaddingRight(), this.mLlRightRedPoint.getPaddingBottom());
        }
    }

    private void reportDT(QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNoticeCategory() != null) {
            VideoReport.setElementId(this.mContainer, QCircleDaTongConstant.ElementId.EM_XSJ_PASSIVE_MSG_ENTRANCE);
            VideoReport.setElementParams(this.mContainer, getItemReportParams(qFSMessageItemInfo.getStNoticeCategory()));
            VideoReport.setElementReuseIdentifier(this.mContainer, qFSMessageItemInfo.getStNoticeCategory().report_info.entrance_name.get());
            VideoReport.setElementId(this.mTvMessage, QCircleDaTongConstant.ElementId.EM_XSJ_PASSIVE_MSG_ENTRANCE);
            VideoReport.setElementParams(this.mTvMessage, getItemReportParams(qFSMessageItemInfo.getStNoticeCategory()));
            VideoReport.setElementReuseIdentifier(this.mTvMessage, qFSMessageItemInfo.getStNoticeCategory().report_info.entrance_name.get());
            VideoReport.setElementExposePolicy(this.mTvMessage, ExposurePolicy.REPORT_NONE);
        }
    }

    private void resetRightView() {
        this.mLlRightNext.setVisibility(8);
        this.mLlRightRedDot.setVisibility(8);
        this.mLlRightRedPoint.setVisibility(8);
    }

    private void setIcon(FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        adjustIconSize();
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl(feedCloudMeta$StNoticeCategory.icon.picUrl.get())).setTargetView(this.mIvIcon).setRequestWidth(this.mDefAvatarSize.getWidth()).setRequestHeight(this.mDefAvatarSize.getHeight()).setEnableAutoDeleteLocalCache(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRightView(FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        boolean z16;
        QFSMessageItemInfo qFSMessageItemInfo;
        boolean z17;
        inflateRightView();
        resetRightView();
        QQCircleCounterMsg$MergePsvRedPoint y16 = q.r().y(feedCloudMeta$StNoticeCategory.f398455id.get());
        if (y16 != null) {
            int i3 = y16.num.get();
            int i16 = y16.type.get();
            if (i16 != 1) {
                if (i16 == 2 && i3 > 0) {
                    this.mLlRightRedDot.setVisibility(0);
                    z16 = true;
                }
            } else if (i3 > 0) {
                this.mLlRightRedPoint.setVisibility(0);
                this.mTvRedPointNum.setText(HostChatUtils.getMaxUnReadCountText(i3));
                z16 = true;
            }
            qFSMessageItemInfo = this.mItemInfo;
            if (qFSMessageItemInfo == null && qFSMessageItemInfo.isForceRightArrow()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if ((z16 && feedCloudMeta$StNoticeCategory.right_icon.get() == 1) || z17) {
                this.mLlRightNext.setVisibility(0);
                return;
            }
        }
        z16 = false;
        qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo == null) {
        }
        z17 = false;
        if (z16) {
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        int i16;
        int i17;
        FeedCloudMeta$StNoticeCategory stNoticeCategory = qFSMessageItemInfo.getStNoticeCategory();
        if (stNoticeCategory == null) {
            QLog.e(getLogTag(), 1, "bindCustomData category is null");
            return;
        }
        Context context = this.mContext;
        if (qFSMessageItemInfo.useSmallAvatar()) {
            i16 = R.dimen.f159391d02;
        } else {
            i16 = R.dimen.d3c;
        }
        this.mDefAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, i16);
        setIcon(stNoticeCategory);
        TextView textView = this.mTvNick;
        if (qFSMessageItemInfo.useSmallAvatar()) {
            i17 = SECOND_MESSAGE_TEXT_SIZE;
        } else {
            i17 = MESSAGE_TEXT_SIZE;
        }
        textView.setTextSize(0, i17);
        this.mTvNick.setText(stNoticeCategory.title.get());
        setUserTypeLabel(this.mUserTypeLabel, stNoticeCategory.label_text.get());
        setTime(qFSMessageItemInfo);
        setMessage(stNoticeCategory);
        setRightView(stNoticeCategory);
        reportDT(qFSMessageItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        this.mContainer.setOnClickListener(this);
        this.mTvMessage.setOnClickListener(this);
        this.mTvMessage.setOnLongClickListener(this.mOnItemLongClickListener);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        this.mIvIcon = (ImageView) view.findViewById(R.id.dvu);
        this.mTvNick = (TextView) view.findViewById(R.id.mdg);
        this.mUserTypeLabel = (TextView) view.findViewById(R.id.f112326nm);
        this.mTvTime = (TextView) view.findViewById(R.id.f109336fj);
        this.mTvMessage = (QCircleAsyncTextView) view.findViewById(R.id.f109306fg);
        this.mDefAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3c);
        setTouchLister(this.mTvMessage);
        setLabelBackground(this.mUserTypeLabel, 2.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final FeedCloudMeta$StNoticeCategory stNoticeCategory;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick(TAG) && (stNoticeCategory = this.mItemInfo.getStNoticeCategory()) != null) {
            handleJumpPage(view, stNoticeCategory);
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSCategoryMessagePresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    q.r().O(stNoticeCategory.f398455id.get());
                    QFSCategoryMessagePresenter.this.setRightView(stNoticeCategory);
                }
            }, 200L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void setMessage(@NonNull FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        String str = feedCloudMeta$StNoticeCategory.summary.get();
        if (TextUtils.isEmpty(str) && feedCloudMeta$StNoticeCategory.f398455id.get() == 4) {
            this.mTvMessage.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918445w));
        } else {
            this.mTvMessage.setText(str);
            this.mTvMessage.setTextColor(RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_text_secondary));
        }
    }

    protected void setTime(@NonNull QFSMessageItemInfo qFSMessageItemInfo) {
        long j3;
        if (this.mTvTime == null) {
            QLog.e(getLogTag(), 1, "setTime view is null");
            return;
        }
        if (qFSMessageItemInfo.getStNoticeCategory() != null) {
            j3 = qFSMessageItemInfo.getStNoticeCategory().newest_notice_timestamp.get() * 1000;
        } else {
            j3 = 0;
        }
        if (!qFSMessageItemInfo.isHideTime() && j3 > 0) {
            this.mTvTime.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(j3));
        } else {
            this.mTvTime.setText("");
        }
    }
}
