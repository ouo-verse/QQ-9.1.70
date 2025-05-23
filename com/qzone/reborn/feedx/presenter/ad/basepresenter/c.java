package com.qzone.reborn.feedx.presenter.ad.basepresenter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\tH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010!\u001a\u00060\u001aR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "J", "K", "L", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getMAdPicView", "()Landroid/widget/ImageView;", "setMAdPicView", "(Landroid/widget/ImageView;)V", "mAdPicView", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c$a;", "G", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c$a;", "H", "()Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c$a;", "setMAdFeedPicData", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c$a;)V", "mAdFeedPicData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class c extends vg.a implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mAdPicView;

    /* renamed from: G, reason: from kotlin metadata */
    private a mAdFeedPicData = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c$a;", "", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "a", "Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "()Lcom/qzone/proxy/feedcomponent/model/PictureUrl;", "b", "(Lcom/qzone/proxy/feedcomponent/model/PictureUrl;)V", "pictureUrl", "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private PictureUrl pictureUrl = new PictureUrl();

        public a() {
        }

        /* renamed from: a, reason: from getter */
        public final PictureUrl getPictureUrl() {
            return this.pictureUrl;
        }

        public final void b(PictureUrl pictureUrl) {
            Intrinsics.checkNotNullParameter(pictureUrl, "<set-?>");
            this.pictureUrl = pictureUrl;
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        ImageView imageView = this.mAdPicView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (!I()) {
            QLog.e(getTAG(), 1, "[onBindData] error, pictureinfo is null");
        } else {
            K();
            L();
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        View view = this.f441562d;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.mvo) : null;
        this.mAdPicView = imageView;
        GdtUIUtils.setViewRadius(imageView, 2.0f);
    }

    /* renamed from: H, reason: from getter */
    public final a getMAdFeedPicData() {
        return this.mAdFeedPicData;
    }

    public abstract boolean I();

    public abstract boolean J();

    public abstract void K();

    public void L() {
        int D = J() ? QZoneAdFeedUtils.f55717a.D(this.f441565h, null) : 0;
        View view = this.f441562d;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.f441562d.getPaddingTop(), this.f441562d.getPaddingRight(), D);
        }
        PictureUrl pictureUrl = this.mAdFeedPicData.getPictureUrl();
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.Q(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h))) {
            Activity activity = this.C;
            ImageView imageView = this.mAdPicView;
            qZoneAdFeedUtils.d(activity, imageView != null ? imageView.getLayoutParams() : null);
            ImageView imageView2 = this.mAdPicView;
            if (imageView2 != null) {
                imageView2.setPadding(imageView2.getPaddingLeft(), imageView2.getPaddingTop(), imageView2.getPaddingRight(), ViewUtils.dpToPx(12.0f));
            }
        } else {
            Activity activity2 = this.C;
            BusinessFeedData businessFeedData = this.f441565h;
            ImageView imageView3 = this.mAdPicView;
            com.qzone.reborn.feedx.widget.picmixvideo.b.a(activity2, businessFeedData, imageView3 != null ? imageView3.getLayoutParams() : null, pictureUrl, pl.a.f426446a.l(this.C));
        }
        String str = pictureUrl.url;
        if (str == null) {
            str = "";
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAdPicView).setNeedShowLoadingDrawable(true).setNeedShowFailedDrawable(true).setUrl(str));
        ImageView imageView4 = this.mAdPicView;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.mAdPicView;
        if (imageView5 != null) {
            imageView5.setOnClickListener(this);
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.f162976nn1;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
