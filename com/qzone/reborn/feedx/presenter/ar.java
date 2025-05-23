package com.qzone.reborn.feedx.presenter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ar;", "Lvg/a;", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "viewModel", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "G", "Lcom/qzone/module/feedcomponent/ui/common/SuperLikeView;", "praiseView", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ar extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneFeedxMoodListViewModel viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private SuperLikeView praiseView;

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this.viewModel;
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel2 = null;
        if (qZoneFeedxMoodListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qZoneFeedxMoodListViewModel = null;
        }
        if (qZoneFeedxMoodListViewModel.F2()) {
            QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel3 = this.viewModel;
            if (qZoneFeedxMoodListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qZoneFeedxMoodListViewModel3 = null;
            }
            if (qZoneFeedxMoodListViewModel3.getHasShowPraiseBubble()) {
                return;
            }
            QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel4 = this.viewModel;
            if (qZoneFeedxMoodListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qZoneFeedxMoodListViewModel4 = null;
            }
            qZoneFeedxMoodListViewModel4.L2(true);
            com.tencent.mobileqq.widget.tip.a m06 = QUIDefaultBubbleTip.r(this.C).S(this.praiseView).m0(3);
            QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel5 = this.viewModel;
            if (qZoneFeedxMoodListViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                qZoneFeedxMoodListViewModel2 = qZoneFeedxMoodListViewModel5;
            }
            QZoneMoodListInitBean initBean = qZoneFeedxMoodListViewModel2.getInitBean();
            Intrinsics.checkNotNull(initBean);
            m06.o0(initBean.getPraiseBubbleText()).R(0).k0(0).f0(false).s0();
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        BaseViewModel r16 = r(QZoneFeedxMoodListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(r16, "getViewModel(QZoneFeedxM\u2026istViewModel::class.java)");
        this.viewModel = (QZoneFeedxMoodListViewModel) r16;
        this.praiseView = containerView != null ? (SuperLikeView) containerView.findViewById(R.id.n9l) : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedOperateGuideBubblePresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnt;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
