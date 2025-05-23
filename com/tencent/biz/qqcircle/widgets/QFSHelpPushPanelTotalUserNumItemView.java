package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QFSHelpPushPanelItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes5.dex */
public class QFSHelpPushPanelTotalUserNumItemView extends QCircleBaseWidgetView<QFSHelpPushPanelItemInfo> {

    /* renamed from: d, reason: collision with root package name */
    private TextView f93265d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f93266e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93267f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93268h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93269i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StUser f93270m;

    public QFSHelpPushPanelTotalUserNumItemView(@NonNull Context context) {
        super(context);
        l0(this);
    }

    private void l0(View view) {
        this.f93265d = (TextView) view.findViewById(R.id.f108656dp);
        this.f93266e = (LinearLayout) view.findViewById(R.id.uuw);
        this.f93267f = (ImageView) view.findViewById(R.id.f43691n6);
        this.f93268h = (TextView) view.findViewById(R.id.f43681n5);
        this.f93269i = (TextView) view.findViewById(R.id.f43671n4);
    }

    private void m0() {
        if (this.f93268h != null && this.f93269i != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.f93270m;
            if (feedCloudMeta$StUser != null && TextUtils.equals(feedCloudMeta$StUser.f398463id.get(), QCirclePluginGlobalInfo.l())) {
                this.f93268h.setText("\u8fd8\u6ca1\u6709\u4eba\u4e3a\u4f60\u52a9\u529b");
                this.f93269i.setText("\u5feb\u53bb\u9080\u8bf7\u597d\u53cb\u63a8\u706b\u7bad\u5427");
                return;
            } else {
                this.f93268h.setText("\u8fd8\u6ca1\u6709\u4eba\u4e3a\u4ed6\u52a9\u529b");
                this.f93269i.setText("\u5feb\u53bb\u5e2e\u4ed6\u63a8\u706b\u7bad\u5427");
                return;
            }
        }
        QLog.e("QFSHelpPushPanelTotalUserNumItemView", 1, "[updateEmptyHint] mEmptyHintTop should not be null");
    }

    private void n0(int i3) {
        LinearLayout linearLayout = this.f93266e;
        if (linearLayout != null && this.f93267f != null) {
            if (i3 == 0) {
                linearLayout.setVisibility(0);
                com.tencent.biz.qqcircle.utils.j.a(this.f93267f, QCircleSkinHelper.getInstance().getUrl("qvideo_skin_emptystate_img_nocontent"), 176.0f, 132.0f);
                m0();
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        QLog.e("QFSHelpPushPanelTotalUserNumItemView", 1, "[updateEmptyView] mLlEmptyView should not be null");
    }

    private void o0(int i3) {
        String valueOf = String.valueOf(i3);
        this.f93265d.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1909743j).replace("%d", valueOf));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gd9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSHelpPushPanelTotalUserNumItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSHelpPushPanelItemInfo qFSHelpPushPanelItemInfo, int i3) {
        if (qFSHelpPushPanelItemInfo == null) {
            QLog.e("QFSHelpPushPanelTotalUserNumItemView", 1, "[bindData] helpPushPanelItemInfo is null");
            return;
        }
        int totalHelpUserNum = qFSHelpPushPanelItemInfo.getTotalHelpUserNum();
        o0(totalHelpUserNum);
        n0(totalHelpUserNum);
    }

    public void setShareUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93270m = feedCloudMeta$StUser;
    }
}
