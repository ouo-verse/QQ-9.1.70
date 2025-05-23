package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.util.ad.QZoneAdStyleManager;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/q;", "Lvg/a;", "", "L", "", "K", "Landroid/view/View$OnClickListener;", "I", "", "k", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/gdtad/aditem/GdtAd;", UserInfo.SEX_FEMALE, "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "G", "Landroid/view/View;", "mAppTips", "H", "mIndustrialTips", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "mAppIcon", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mAppText", "mIndustrialIcon", "mIndustrialText", "Landroid/view/ViewStub;", "M", "Landroid/view/ViewStub;", "mAppTipsViewStub", "N", "Z", "mIsAppTipsInflate", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: G, reason: from kotlin metadata */
    private View mAppTips;

    /* renamed from: H, reason: from kotlin metadata */
    private View mIndustrialTips;

    /* renamed from: I, reason: from kotlin metadata */
    private URLImageView mAppIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mAppText;

    /* renamed from: K, reason: from kotlin metadata */
    private URLImageView mIndustrialIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mIndustrialText;

    /* renamed from: M, reason: from kotlin metadata */
    private ViewStub mAppTipsViewStub;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsAppTipsInflate;

    private final View.OnClickListener I() {
        GdtAd gdtAd = this.mAd;
        final long aId = gdtAd != null ? gdtAd.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        return new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.J(aId, this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(long j3, q this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedElement feedElement = FeedElement.GDT_FLOAT_TIPS_OPEN_APP;
        QLog.i("QZoneAdFeedTipsPresenter", 1, "[onClick] aid:" + j3 + " element:" + feedElement + " areaId:55");
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        Activity mActivity = this$0.C;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        BusinessFeedData mFeedData = this$0.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        qZoneAdFeedUtils.H(mActivity, v3, mFeedData, feedElement, 55, this$0.f441567m, null);
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final int K() {
        return ResourcesCompat.getColor(this.f441562d.getResources(), R.color.qui_common_text_secondary, null);
    }

    private final void L() {
        if (this.mIsAppTipsInflate) {
            return;
        }
        View view = this.f441562d;
        ViewStub viewStub = view != null ? (ViewStub) view.findViewById(R.id.nmw) : null;
        this.mAppTipsViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        View view2 = this.f441562d;
        this.mAppTips = view2 != null ? view2.findViewById(R.id.mme) : null;
        View view3 = this.f441562d;
        this.mIndustrialTips = view3 != null ? view3.findViewById(R.id.mmf) : null;
        View view4 = this.mAppTips;
        this.mAppIcon = view4 != null ? (URLImageView) view4.findViewById(R.id.f162787mn0) : null;
        View view5 = this.mAppTips;
        this.mAppText = view5 != null ? (TextView) view5.findViewById(R.id.f162788mn1) : null;
        View view6 = this.mIndustrialTips;
        this.mIndustrialIcon = view6 != null ? (URLImageView) view6.findViewById(R.id.f162787mn0) : null;
        View view7 = this.mIndustrialTips;
        this.mIndustrialText = view7 != null ? (TextView) view7.findViewById(R.id.f162788mn1) : null;
        View view8 = this.mIndustrialTips;
        if (view8 != null) {
            view8.setOnClickListener(null);
        }
        View view9 = this.f441562d;
        if (view9 != null) {
            view9.setVisibility(8);
        }
        this.mIsAppTipsInflate = true;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        if (!QZoneAdStyleManager.f55731a.a(2L, feedData)) {
            QLog.d("QZoneAdFeedTipsPresenter", 2, "[onBindData] don't show default button");
            this.f441562d.setVisibility(8);
            return;
        }
        this.mAd = GdtFeedUtilForQZone.E(this.f441565h);
        GdtAdFeedUtil.AdFloatTipsInfo[] adFloatTipsContainer = GdtAdFeedUtil.getAdFloatTipsContainer(this.f441565h);
        if (adFloatTipsContainer != null) {
            if (!(adFloatTipsContainer.length == 0)) {
                L();
                for (GdtAdFeedUtil.AdFloatTipsInfo adFloatTipsInfo : adFloatTipsContainer) {
                    if (adFloatTipsInfo != null) {
                        URLDrawable drawable = URLDrawable.getDrawable(adFloatTipsInfo.iconUrl, URLDrawable.URLDrawableOptions.obtain());
                        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(info.iconUrl\u2026DrawableOptions.obtain())");
                        String str = adFloatTipsInfo.text;
                        Intrinsics.checkNotNullExpressionValue(str, "info.text");
                        int i3 = adFloatTipsInfo.type;
                        if (i3 == 1) {
                            URLImageView uRLImageView = this.mAppIcon;
                            if (uRLImageView != null) {
                                uRLImageView.setImageDrawable(drawable);
                            }
                            TextView textView = this.mAppText;
                            if (textView != null) {
                                textView.setText(str);
                            }
                        } else if (i3 == 2) {
                            URLImageView uRLImageView2 = this.mIndustrialIcon;
                            if (uRLImageView2 != null) {
                                uRLImageView2.setImageDrawable(drawable);
                            }
                            TextView textView2 = this.mIndustrialText;
                            if (textView2 != null) {
                                textView2.setText(str);
                            }
                        }
                    }
                }
                View view = this.mAppTips;
                if (view != null) {
                    view.setOnClickListener(I());
                }
                this.f441562d.setPadding(cx.a(13.0f), 0, cx.a(13.0f), cx.a(14.0f));
                URLImageView uRLImageView3 = this.mAppIcon;
                if (uRLImageView3 != null) {
                    uRLImageView3.setColorFilter(K());
                }
                URLImageView uRLImageView4 = this.mIndustrialIcon;
                if (uRLImageView4 != null) {
                    uRLImageView4.setColorFilter(K());
                }
                View view2 = this.f441562d;
                if (view2 == null) {
                    return;
                }
                view2.setVisibility(0);
                return;
            }
        }
        View view3 = this.f441562d;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedTipsPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmv;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
