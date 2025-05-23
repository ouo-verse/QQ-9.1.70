package com.qzone.reborn.feedx.presenter;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ap;", "Lvg/a;", "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", HippyTKDListViewAdapter.X, "", ReportConstant.COSTREPORT_PREFIX, "", "k", "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", "getMMemorySealView", "()Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", "setMMemorySealView", "(Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;)V", "mMemorySealView", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ap extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneFeedMemorySealView mMemorySealView;

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QZoneFeedMemorySealView qZoneFeedMemorySealView = this.mMemorySealView;
        if (qZoneFeedMemorySealView != null) {
            qZoneFeedMemorySealView.c(feedData);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mMemorySealView = (QZoneFeedMemorySealView) containerView.findViewById(R.id.n0u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedMemorySealPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnr;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
