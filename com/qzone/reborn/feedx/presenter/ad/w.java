package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/w;", "Lvg/a;", "Lgf/r;", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZonePicMixVideoView;", "G", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZonePicMixVideoView;", "mPicMixVideoView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w extends vg.a implements gf.r {

    /* renamed from: F, reason: from kotlin metadata */
    private final String TAG = "QZoneAdGdtFeedMultiPicPresenter";

    /* renamed from: G, reason: from kotlin metadata */
    private QZonePicMixVideoView mPicMixVideoView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(w this$0, PictureItem pictureItem, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        Activity mActivity = this$0.C;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        BusinessFeedData mFeedData = this$0.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        qZoneAdFeedUtils.H(mActivity, view, mFeedData, FeedElement.NOTHING, 1000, this$0.f441567m, null);
        QLog.i(this$0.TAG, 1, "index is " + i3);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QZonePicMixVideoView qZonePicMixVideoView = this.mPicMixVideoView;
        if (qZonePicMixVideoView != null) {
            qZonePicMixVideoView.setData(feedData, this.f441567m);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        QZonePicMixVideoView qZonePicMixVideoView = (QZonePicMixVideoView) containerView.findViewById(R.id.n9_);
        this.mPicMixVideoView = qZonePicMixVideoView;
        if (qZonePicMixVideoView != null) {
            qZonePicMixVideoView.setEnableOverLimit(o() != 10);
        }
        QZonePicMixVideoView qZonePicMixVideoView2 = this.mPicMixVideoView;
        if (qZonePicMixVideoView2 != null) {
            qZonePicMixVideoView2.setOnItemClickListener(new QZonePicMixVideoView.c() { // from class: com.qzone.reborn.feedx.presenter.ad.v
                @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView.c
                public final void a(PictureItem pictureItem, int i3, View view) {
                    w.I(w.this, pictureItem, i3, view);
                }
            });
        }
    }

    @Override // gf.r
    public void a() {
        QZonePicMixVideoView qZonePicMixVideoView = this.mPicMixVideoView;
        if (qZonePicMixVideoView == null || qZonePicMixVideoView == null) {
            return;
        }
        qZonePicMixVideoView.a();
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        QZonePicMixVideoView qZonePicMixVideoView = this.mPicMixVideoView;
        if (qZonePicMixVideoView == null || qZonePicMixVideoView == null) {
            return null;
        }
        return qZonePicMixVideoView.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // gf.r
    public void pause() {
        QZonePicMixVideoView qZonePicMixVideoView = this.mPicMixVideoView;
        if (qZonePicMixVideoView == null || qZonePicMixVideoView == null) {
            return;
        }
        qZonePicMixVideoView.pause();
    }

    @Override // gf.r
    public void play() {
        QZonePicMixVideoView qZonePicMixVideoView = this.mPicMixVideoView;
        if (qZonePicMixVideoView == null || qZonePicMixVideoView == null) {
            return;
        }
        qZonePicMixVideoView.play();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnv;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
