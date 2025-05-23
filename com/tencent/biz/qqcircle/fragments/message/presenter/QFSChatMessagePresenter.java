package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostChatHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSChatMessagePresenter extends a implements View.OnClickListener {
    private static final String TAG = "QFSChatMessagePresenter";
    private Size mDefAvatarSize;
    private QCircleAvatarView mIvAvatarView;
    private SingleLineTextView mTvDesc;
    private TextView mTvNick;
    private DragTextView mTvRedPointNum;
    private TextView mTvSendTime;

    public QFSChatMessagePresenter(int i3) {
        super(i3);
    }

    private void jumpPrivateChat(String str, String str2, String str3) {
        if (this.mContext != null && !TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            if (QCirclePluginUtil.isFriend(str2)) {
                bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_FRIEND());
            } else {
                bundle.putBoolean(HostChatUtils.QCIRCLE_CHAT_HIDE_MENU_KEY(), true);
                bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), QCircleHostConstants.AppConstants.Value.UIN_TYPE_TEMP_CIRCLE());
            }
            bundle.putInt(QCircleHostConstants._ChatActivityConstants.KEY_AIO_MSG_SOURCE(), QCircleHostConstants._ChatActivityConstants.TYPE_DETAIL_MSG_REMIND());
            bundle.putBoolean(HostChatUtils.getQCircleFromPersonalPageKey(), false);
            String buddyName = HostDataTransUtils.getBuddyName(str2, true);
            String str4 = "";
            if (buddyName.equals(str2)) {
                if (str2.equals(str3)) {
                    buddyName = "";
                } else {
                    buddyName = str3;
                }
            }
            String UIN_NAME = QCircleHostConstants.AppConstants.Key.UIN_NAME();
            if (buddyName != null) {
                str4 = buddyName;
            }
            bundle.putString(UIN_NAME, str4);
            QCircleHostChatHelper.jumpPrivateChat(this.mContext, str3, str, str2, bundle, false);
        }
    }

    private void reportDT(QFSMessageItemInfo qFSMessageItemInfo) {
        VideoReport.setElementId(this.mContainer, QCircleDaTongConstant.ElementId.EM_XSJ_PRIVATE_MSG_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 1);
        QCircleRecentDataInterface recentData = qFSMessageItemInfo.getRecentData();
        if (recentData != null) {
            buildElementParams.put("xsj_target_qq", recentData.getRecentUserUin());
            buildElementParams.put("xsj_reddot_number", Integer.valueOf(recentData.getUnreadNum()));
            if (recentData.getUnreadNum() > 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, 1);
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, 0);
            }
        }
        VideoReport.setElementParams(this.mContainer, buildElementParams);
        VideoReport.setElementId(this.mIvAvatarView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        VideoReport.setElementId(this.mTvNick, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
        VideoReport.setElementId(this.mTvDesc, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_CONTEXT);
        Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams2.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_IF_QUOTE_CONTEXT, 0);
        VideoReport.setElementParams(this.mTvDesc, buildElementParams2);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        String str;
        QCircleRecentDataInterface recentData = qFSMessageItemInfo.getRecentData();
        if (recentData == null) {
            return;
        }
        QLog.d(TAG, 1, "[bindCustomData] " + recentData.getDataString());
        this.mTvNick.setText(recentData.getTitleName());
        this.mTvSendTime.setText(recentData.getShowTime());
        this.mIvAvatarView.setAvatarByUin(recentData.getRecentUserUin(), this.mDefAvatarSize);
        if (recentData.getMsgExtraInfo() != null) {
            str = recentData.getMsgExtraInfo().toString();
        } else {
            str = "";
        }
        this.mTvDesc.setExtendText(str, 1);
        this.mTvDesc.setText(recentData.getLastMsg(this.mContext));
        if (recentData.getUnreadNum() > 0) {
            this.mTvRedPointNum.setVisibility(0);
            this.mTvRedPointNum.setText(HostChatUtils.getMaxUnReadCountText(recentData.getUnreadNum()));
        } else {
            this.mTvRedPointNum.setVisibility(8);
        }
        this.mTvRedPointNum.setTag(Integer.valueOf(i3));
        reportDT(qFSMessageItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        this.mIvAvatarView.setOnClickListener(this);
        this.mContainer.setOnClickListener(this);
        this.mIvAvatarView.setOnLongClickListener(this.mOnItemLongClickListener);
        this.mContainer.setOnLongClickListener(this.mOnItemLongClickListener);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        this.mIvAvatarView = (QCircleAvatarView) view.findViewById(R.id.f165909du3);
        this.mTvRedPointNum = (DragTextView) view.findViewById(R.id.f110576iw);
        this.mTvNick = (TextView) view.findViewById(R.id.mdg);
        this.mTvSendTime = (TextView) view.findViewById(R.id.kbp);
        SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.f167043k74);
        this.mTvDesc = singleLineTextView;
        singleLineTextView.setTextColor(QFSQUIUtilsKt.d(context, R.color.qui_common_text_secondary));
        this.mDefAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159391d02);
        setTouchLister(this.mIvAvatarView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QCircleRecentDataInterface recentData;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick(TAG) && (recentData = this.mItemInfo.getRecentData()) != null) {
            String recentUserUin = recentData.getRecentUserUin();
            if (!TextUtils.isEmpty(recentUserUin)) {
                jumpPrivateChat(recentData.getRecentUserUid(), recentUserUin, recentData.getTitleName());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
