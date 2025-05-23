package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/d;", "Lvg/a;", "", "J", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mDynamicBg", "G", "Ljava/lang/String;", "mDynamicBgUrl", "H", "mOldTraceId", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mDynamicBg;

    /* renamed from: G, reason: from kotlin metadata */
    private String mDynamicBgUrl = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String mOldTraceId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/d$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            QLog.e("QZoneAdFeedDynamicBackgroundPresenter", 2, "[initDynamicBg] drawable load failed, url:" + d.this.mDynamicBgUrl);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            QLog.e("QZoneAdFeedDynamicBackgroundPresenter", 2, "[initDynamicBg] drawable load success ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    private final void J() {
        ImageView imageView = this.mDynamicBg;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        String str = this.mDynamicBgUrl;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadListener(new b());
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QZoneAdFeedDynamicBackgroundPresenter", str, apngOptions);
        ImageView imageView2 = this.mDynamicBg;
        if (imageView2 != null) {
            imageView2.setImageDrawable(apngURLDrawable);
        }
        ImageView imageView3 = this.mDynamicBg;
        if (imageView3 != null) {
            imageView3.setClickable(true);
        }
        ImageView imageView4 = this.mDynamicBg;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.K(d.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this$0.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this$0.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, view, mFeedData, FeedElement.GDT_DYNAMIC_BG, 10063, this$0.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && !TextUtils.isEmpty(QZoneAdFeedDataExtKt.getDynamicBgUrl(businessFeedData))) {
            if (QZoneAdFeedUtils.f55717a.W(this.C)) {
                ImageView imageView = this.mDynamicBg;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                QLog.e("QZoneAdFeedDynamicBackgroundPresenter", 1, "[onBindData] theme or qzoneBackground, need hide dynamic backgound");
                return;
            }
            if (!TextUtils.isEmpty(this.mOldTraceId) && Intrinsics.areEqual(this.mOldTraceId, QZoneAdFeedDataExtKt.getTraceId(this.f441565h))) {
                ImageView imageView2 = this.mDynamicBg;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                QLog.e("QZoneAdFeedDynamicBackgroundPresenter", 1, "[onBindData] ad is same");
                return;
            }
            this.mOldTraceId = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
            this.mDynamicBgUrl = QZoneAdFeedDataExtKt.getDynamicBgUrl(this.f441565h);
            J();
            return;
        }
        ImageView imageView3 = this.mDynamicBg;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        QLog.e("QZoneAdFeedDynamicBackgroundPresenter", 1, "[onBindData] error, feeddata is null or dynamicBgUrl is empty");
    }

    @Override // vg.a
    protected void C(View containerView) {
        View view = this.f441562d;
        if (view == null) {
            return;
        }
        this.mDynamicBg = view != null ? (ImageView) view.findViewById(R.id.f162845my1) : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedDynamicBackgroundPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmt;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
