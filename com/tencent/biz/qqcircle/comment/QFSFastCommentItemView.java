package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.events.QFSAddFakeCommentOrReplyEvent;
import com.tencent.biz.qqcircle.events.QFSFakeCommentSendEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFastCommentItemView extends QFSCommentBaseItemView {
    private FeedCloudMeta$StFeed G;
    private View H;
    private TextView I;
    private TextView J;
    private String K;

    public QFSFastCommentItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void A0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.K = str;
        this.H.setVisibility(0);
        String string = getContext().getString(R.string.f19012419, str);
        int indexOf = string.indexOf(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_secondary)), 0, indexOf, 34);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_primary)), indexOf, str.length() + indexOf, 34);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(R.color.qui_button_text_secondary)), indexOf + str.length(), string.length(), 34);
        this.I.setText(spannableStringBuilder);
    }

    private void initView() {
        this.H = findViewById(R.id.f372316p);
        this.I = (TextView) findViewById(R.id.f372216o);
        TextView textView = (TextView) findViewById(R.id.f3735171);
        this.J = textView;
        textView.setOnClickListener(this);
        y0();
    }

    private void y0() {
        com.tencent.biz.qqcircle.immersive.utils.w.a(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_QUICK_SEND_BUTTON);
    }

    private void z0() {
        if (TextUtils.isEmpty(this.K)) {
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.l(QCircleToast.f91645e, getContext().getString(R.string.f181603e8), 0, true, false);
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment.f398447id.set(QFSCommentHelper.H());
        feedCloudMeta$StComment.content.set(this.K);
        feedCloudMeta$StComment.createTime.set((int) (System.currentTimeMillis() / 1000));
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (QCircleHostGlobalInfo.getStUserInfo() != null) {
            m3.iconDecorate.set(QCircleHostGlobalInfo.getStUserInfo().iconDecorate.get());
        }
        feedCloudMeta$StComment.postUser.set(m3);
        SimpleEventBus.getInstance().dispatchEvent(new QFSAddFakeCommentOrReplyEvent(this.G.f398449id.get(), feedCloudMeta$StComment));
        h.G().o(getContext().hashCode(), this.G, feedCloudMeta$StComment, false, false, QCirclePluginUtil.getQCircleInitBean(getContext()));
        SimpleEventBus.getInstance().dispatchEvent(new QFSFakeCommentSendEvent(this.G, feedCloudMeta$StComment));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168666ga1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSFastCommentItemView";
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        super.bindData(qFSCommentItemInfo, i3);
        QLog.d("QFSFastCommentItemView", 1, "mFeed= " + this.G + "objData = " + qFSCommentItemInfo);
        if (this.G != null && qFSCommentItemInfo != null) {
            A0(qFSCommentItemInfo.getFastCommentText());
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (view.getId() == R.id.f3735171) {
            z0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.G = feedCloudMeta$StFeed;
    }
}
