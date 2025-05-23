package com.tencent.biz.qqcircle.share;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSFriendDialogInitBean;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.bean.QFSShareSelectMemberInitBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.ImageShareInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import uq3.o;
import uq3.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private HostForwardUtils f92366u;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Consumer<String> {
        a() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) {
            f.this.T(str);
        }
    }

    public f(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void M(Intent intent, String str) {
        if (this.f92366u == null) {
            this.f92366u = new HostForwardUtils();
        }
        if (t() == null) {
            QLog.d("QFSSharePart", 1, "[createHostForwardApi] share info should not be null.");
            return;
        }
        QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo d16 = ua0.d.d(t());
        if (d16 != null) {
            d16.mDtCustomPgId = QCircleDaTongConstant.PageId.PG_SENDVIEW_POP;
            QCircleShareInfo t16 = t();
            if (t16 != null) {
                d16.isMutualShare = t16.isEnableShareToMutual;
            }
        }
        this.f92366u.registerForwardResultReceiver(intent, QFSShareResultKt.f(m(), n(), d16));
        this.f92366u.addForwardType(intent, str);
    }

    private void N() {
        if (!(f() instanceof FragmentActivity)) {
            return;
        }
        FragmentTransaction beginTransaction = ((FragmentActivity) f()).getSupportFragmentManager().beginTransaction();
        Fragment qFSHalfScreenQQShareDialogFragment = new QFSHalfScreenQQShareDialogFragment();
        Bundle bundle = new Bundle();
        QFSFriendDialogInitBean qFSFriendDialogInitBean = new QFSFriendDialogInitBean();
        qFSFriendDialogInitBean.setShareInfo(t());
        bundle.putSerializable("key_bundle_common_init_bean", qFSFriendDialogInitBean);
        qFSHalfScreenQQShareDialogFragment.setArguments(bundle);
        beginTransaction.add(qFSHalfScreenQQShareDialogFragment, "QFSHalfScreenQQShareDialogFragment");
        beginTransaction.commitAllowingStateLoss();
    }

    private void O() {
        H(25, 2, t().extraTypeInfo, "");
    }

    private void P() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(25).setSubActionType(2);
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        if (t().extraTypeInfo != null) {
            i3 = t().extraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(m())));
    }

    private void Q() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(9).setThrActionType(1).setExt9(o()).setFeedReportInfo(p()).setPageId(m()));
    }

    private void R() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(F()).setSubActionType(3).setThrActionType(1).setExt6(String.valueOf(t().polymerizationName)).setPageId(m()));
    }

    private void S() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(6).setSubActionType(4).setThrActionType(1).setPageId(m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IShareActionHelper) QRoute.api(IShareActionHelper.class)).doShareImageToQQBySelect("QFSSharePart", f(), new ImageShareInfo(str, ""));
    }

    private void U() {
        if (!C(57) && !uq3.c.g6()) {
            if (C(32)) {
                Q();
                return;
            }
            if (C(31)) {
                S();
                return;
            } else if (A()) {
                R();
                return;
            } else {
                P();
                return;
            }
        }
        O();
    }

    private void V(Intent intent) {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.isEnableShareToMutual) {
            QFSShareSelectMemberInitBean qFSShareSelectMemberInitBean = new QFSShareSelectMemberInitBean();
            qFSShareSelectMemberInitBean.setFeedId(t().feed.f398449id.get());
            qFSShareSelectMemberInitBean.setSelectType("select_type_friends");
            if (!t16.mMultiShareUsers.isEmpty()) {
                intent.putExtra("param_selected_item_list_from_panel", t16.mMultiShareUsers);
            }
            M(intent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
            com.tencent.biz.qqcircle.launcher.c.D0(f(), intent, qFSShareSelectMemberInitBean);
            return;
        }
        I(true);
        intent.putExtra(QCircleHostConstants._ForwardRecentActivity.KEY_SELECTION_MODE(), QCircleHostConstants._ForwardRecentActivity.SELECTION_MODE_MULTI());
        if (!TextUtils.isEmpty(t().mDirectShowMsg)) {
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_ADDTIONAL_MESSAGE, t().mDirectShowMsg);
        }
        if (!TextUtils.isEmpty(t().customShareSuccessToast)) {
            intent.putExtra("is_need_show_toast", false);
            intent.putExtra("qqcircle_custom_share_success_toast", t().customShareSuccessToast);
        }
        if (!t().isNeedShowShareSuccessToast) {
            intent.putExtra("is_need_show_toast", false);
        }
        if (!t().mMultiShareUsers.isEmpty()) {
            intent.putExtra("key_forward_finish_when_multi_select", true);
            intent.putExtra("selected_target_list", t().mMultiShareUsers);
            intent.putExtra(HostForwardUtils.getNeedShowGuildEntranceKey(), false);
        }
        if (o.Y1("qqcircle_enable_multi_share_report_loop", true)) {
            intent.putExtra("key_is_need_return_selected_list", true);
        }
        M(intent, HostForwardUtils.HOST_FORWARD_RECENTLY_CHAT_FLAG());
        f().startActivityForResult(intent, QCircleHostConstants._ChatActivityConstants.FORWARD_REQUEST());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (yb0.c.d(t())) {
            yb0.c.i(f());
            return;
        }
        if (t() != null && t().feed != null && t().feed.share != null && f() != null) {
            if (t().isShowPersonalQrcodeDown && h() != null) {
                h().g(new a());
            } else if (com.tencent.biz.qqcircle.immersive.utils.a.d() && !TransitionHelper.isFolderScreenOpenMode(f()) && PadUtil.a(f()) != DeviceType.TABLET) {
                N();
            } else {
                Intent s16 = QCircleBaseShareOperation.s(f(), t().feed);
                if (s16 == null) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.tx7), 0);
                    return;
                }
                V(s16);
            }
            QLog.d("QFSSharePart", 1, "shareToQQ  success");
            U();
            d("share", QCircleDaTongConstant.ElementParamValue.QQ_SELECT);
            ua0.d.a(m(), n()).q(t().extraTypeInfo);
            q.c(f(), "share_lately_type_key", "share_type_qq");
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
