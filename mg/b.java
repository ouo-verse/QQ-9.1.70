package mg;

import android.app.Activity;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.presenter.ad.appinfo.TextViewWithDivider;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \t2\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010=\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010H\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010@\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR$\u0010K\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010@\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR$\u0010N\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010@\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR$\u0010Q\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010@\u001a\u0004\bO\u0010B\"\u0004\bP\u0010DR$\u0010T\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010@\u001a\u0004\bR\u0010B\"\u0004\bS\u0010DR$\u0010W\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010@\u001a\u0004\bU\u0010B\"\u0004\bV\u0010DR$\u0010Z\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010@\u001a\u0004\bX\u0010B\"\u0004\bY\u0010DR$\u0010a\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`\u00a8\u0006e"}, d2 = {"Lmg/b;", "Lvg/a;", "", ExifInterface.LATITUDE_SOUTH, "Y", "X", "W", "V", "", "U", "Z", "T", "Landroid/view/View$OnClickListener;", "J", "", BdhLogUtil.LogTag.Tag_Req, "isNeedShowICP", "L", "M", "", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/ViewStub;", UserInfo.SEX_FEMALE, "Landroid/view/ViewStub;", "getMAppInfoViewStub", "()Landroid/view/ViewStub;", "setMAppInfoViewStub", "(Landroid/view/ViewStub;)V", "mAppInfoViewStub", "G", "getMIsAppInfoInflate", "()Z", "setMIsAppInfoInflate", "(Z)V", "mIsAppInfoInflate", "Landroid/widget/RelativeLayout;", "H", "Landroid/widget/RelativeLayout;", "N", "()Landroid/widget/RelativeLayout;", "setMAppInfoLayout", "(Landroid/widget/RelativeLayout;)V", "mAppInfoLayout", "Landroid/widget/LinearLayout;", "I", "Landroid/widget/LinearLayout;", "getMFirLineLayout", "()Landroid/widget/LinearLayout;", "setMFirLineLayout", "(Landroid/widget/LinearLayout;)V", "mFirLineLayout", "getMSecLineLayout", "setMSecLineLayout", "mSecLineLayout", "Lcom/qzone/reborn/feedx/presenter/ad/appinfo/TextViewWithDivider;", "K", "Lcom/qzone/reborn/feedx/presenter/ad/appinfo/TextViewWithDivider;", "getMAppName", "()Lcom/qzone/reborn/feedx/presenter/ad/appinfo/TextViewWithDivider;", "setMAppName", "(Lcom/qzone/reborn/feedx/presenter/ad/appinfo/TextViewWithDivider;)V", "mAppName", "getMAuthorName", "setMAuthorName", "mAuthorName", "O", "setMICPNumber1", "mICPNumber1", "P", "setMICPNumber2", "mICPNumber2", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "setMVersionName", "mVersionName", "getMPremissionName", "setMPremissionName", "mPremissionName", "getMPrivacy", "setMPrivacy", "mPrivacy", "getMDescription", "setMDescription", "mDescription", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "getMAd", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setMAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "mAd", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private ViewStub mAppInfoViewStub;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsAppInfoInflate;

    /* renamed from: H, reason: from kotlin metadata */
    private RelativeLayout mAppInfoLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout mFirLineLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout mSecLineLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private TextViewWithDivider mAppName;

    /* renamed from: L, reason: from kotlin metadata */
    private TextViewWithDivider mAuthorName;

    /* renamed from: M, reason: from kotlin metadata */
    private TextViewWithDivider mICPNumber1;

    /* renamed from: N, reason: from kotlin metadata */
    private TextViewWithDivider mICPNumber2;

    /* renamed from: P, reason: from kotlin metadata */
    private TextViewWithDivider mVersionName;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextViewWithDivider mPremissionName;

    /* renamed from: R, reason: from kotlin metadata */
    private TextViewWithDivider mPrivacy;

    /* renamed from: S, reason: from kotlin metadata */
    private TextViewWithDivider mDescription;

    /* renamed from: T, reason: from kotlin metadata */
    private GdtAd mAd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"mg/b$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mg.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC10781b implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC10781b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            RelativeLayout mAppInfoLayout = b.this.getMAppInfoLayout();
            if (mAppInfoLayout != null && (viewTreeObserver = mAppInfoLayout.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            b bVar = b.this;
            RelativeLayout mAppInfoLayout2 = bVar.getMAppInfoLayout();
            bVar.D(new df.a(mAppInfoLayout2 != null ? mAppInfoLayout2.getMeasuredHeight() : 0));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"mg/b$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f416718e;

        c(String str) {
            this.f416718e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int coerceAtMost;
            ViewTreeObserver viewTreeObserver;
            TextViewWithDivider mICPNumber1 = b.this.getMICPNumber1();
            if (mICPNumber1 != null && (viewTreeObserver = mICPNumber1.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            TextViewWithDivider mICPNumber12 = b.this.getMICPNumber1();
            Paint b16 = mICPNumber12 != null ? mICPNumber12.b() : null;
            float measureText = b16 != null ? b16.measureText(this.f416718e) : 0.0f;
            TextViewWithDivider mICPNumber13 = b.this.getMICPNumber1();
            int c16 = mICPNumber13 != null ? mICPNumber13.c() : 0;
            if ((this.f416718e.length() > 0) && c16 != 0) {
                if (!(measureText == 0.0f)) {
                    float f16 = c16;
                    if (measureText > f16) {
                        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.f416718e.length() - 1, (int) ((f16 / measureText) * this.f416718e.length()));
                        CharSequence subSequence = this.f416718e.subSequence(0, coerceAtMost);
                        String str = this.f416718e;
                        CharSequence subSequence2 = str.subSequence(coerceAtMost, str.length());
                        TextViewWithDivider mICPNumber14 = b.this.getMICPNumber1();
                        if (mICPNumber14 != null) {
                            mICPNumber14.setText(subSequence);
                        }
                        TextViewWithDivider mICPNumber2 = b.this.getMICPNumber2();
                        if (mICPNumber2 != null) {
                            mICPNumber2.setText(subSequence2);
                        }
                        TextViewWithDivider mICPNumber22 = b.this.getMICPNumber2();
                        if (mICPNumber22 != null) {
                            mICPNumber22.setDivider(false);
                        }
                        TextViewWithDivider mICPNumber15 = b.this.getMICPNumber1();
                        if (mICPNumber15 != null) {
                            mICPNumber15.setVisibility(0);
                        }
                        TextViewWithDivider mICPNumber23 = b.this.getMICPNumber2();
                        if (mICPNumber23 != null) {
                            mICPNumber23.setVisibility(0);
                        }
                        TextViewWithDivider mVersionName = b.this.getMVersionName();
                        if (mVersionName != null) {
                            mVersionName.setDivider(true);
                            return;
                        }
                        return;
                    }
                }
            }
            TextViewWithDivider mICPNumber16 = b.this.getMICPNumber1();
            if (mICPNumber16 != null) {
                mICPNumber16.setText(this.f416718e);
            }
            TextViewWithDivider mICPNumber17 = b.this.getMICPNumber1();
            if (mICPNumber17 != null) {
                mICPNumber17.setVisibility(0);
            }
            TextViewWithDivider mICPNumber24 = b.this.getMICPNumber2();
            if (mICPNumber24 != null) {
                mICPNumber24.setVisibility(8);
            }
            TextViewWithDivider mVersionName2 = b.this.getMVersionName();
            if (mVersionName2 != null) {
                mVersionName2.setDivider(false);
            }
        }
    }

    private final View.OnClickListener J() {
        return new View.OnClickListener() { // from class: mg.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.K(b.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(b this$0, View it) {
        String appChannelFeatureListUrl;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (it.getId()) {
            case R.id.mxt /* 1745224854 */:
                QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                GdtAd gdtAd = this$0.mAd;
                appChannelFeatureListUrl = gdtAd != null ? gdtAd.getAppChannelFeatureListUrl() : null;
                Activity mActivity = this$0.C;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                qZoneAdFeedUtils.b0(appChannelFeatureListUrl, mActivity);
                break;
            case R.id.mxu /* 1745224855 */:
            default:
                QZoneAdFeedUtils qZoneAdFeedUtils2 = QZoneAdFeedUtils.f55717a;
                Activity mActivity2 = this$0.C;
                Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                BusinessFeedData mFeedData = this$0.f441565h;
                Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                qZoneAdFeedUtils2.H(mActivity2, it, mFeedData, FeedElement.RECOMM_ACTION_LEFT_TEXT, 10069, this$0.f441567m, null);
                break;
            case R.id.mxv /* 1745224856 */:
                QZoneAdFeedUtils qZoneAdFeedUtils3 = QZoneAdFeedUtils.f55717a;
                GdtAd gdtAd2 = this$0.mAd;
                appChannelFeatureListUrl = gdtAd2 != null ? gdtAd2.getAppChannelPermissionUrl() : null;
                Activity mActivity3 = this$0.C;
                Intrinsics.checkNotNullExpressionValue(mActivity3, "mActivity");
                qZoneAdFeedUtils3.b0(appChannelFeatureListUrl, mActivity3);
                break;
            case R.id.mxw /* 1745224857 */:
                QZoneAdFeedUtils qZoneAdFeedUtils4 = QZoneAdFeedUtils.f55717a;
                GdtAd gdtAd3 = this$0.mAd;
                appChannelFeatureListUrl = gdtAd3 != null ? gdtAd3.getAppChannelPrivacyUrl() : null;
                Activity mActivity4 = this$0.C;
                Intrinsics.checkNotNullExpressionValue(mActivity4, "mActivity");
                qZoneAdFeedUtils4.b0(appChannelFeatureListUrl, mActivity4);
                break;
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final int L(boolean isNeedShowICP) {
        if (QZoneAdFeedUtils.f55717a.R(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h))) {
            return isNeedShowICP ? 6 : 12;
        }
        return 20;
    }

    private final int M(boolean isNeedShowICP) {
        if (QZoneAdFeedUtils.f55717a.R(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h))) {
            return isNeedShowICP ? 8 : 12;
        }
        return 20;
    }

    private final int R() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int gdtInnerAdShowType = QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h);
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        if (qZoneAdFeedUtils.T(gdtInnerAdShowType)) {
            com.qzone.reborn.feedx.widget.picmixvideo.b.b(i(), layoutParams, this.f441565h.getVideoInfo());
        } else if (qZoneAdFeedUtils.P(gdtInnerAdShowType)) {
            Activity activity = this.C;
            BusinessFeedData businessFeedData = this.f441565h;
            com.qzone.reborn.feedx.widget.picmixvideo.b.a(activity, businessFeedData, layoutParams, businessFeedData != null ? QZoneAdFeedDataExtKt.getAdPicture(businessFeedData) : null, pl.a.f426446a.l(this.C));
        }
        return layoutParams.width;
    }

    private final void S() {
        if (this.mIsAppInfoInflate) {
            return;
        }
        this.mIsAppInfoInflate = true;
        View view = this.f441562d;
        ViewStub viewStub = view != null ? (ViewStub) view.findViewById(R.id.nmh) : null;
        this.mAppInfoViewStub = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        View view2 = this.f441562d;
        this.mAppInfoLayout = view2 != null ? (RelativeLayout) view2.findViewById(R.id.mxu) : null;
        View view3 = this.f441562d;
        this.mFirLineLayout = view3 != null ? (LinearLayout) view3.findViewById(R.id.mxp) : null;
        View view4 = this.f441562d;
        this.mSecLineLayout = view4 != null ? (LinearLayout) view4.findViewById(R.id.mxq) : null;
        View view5 = this.f441562d;
        this.mAppName = view5 != null ? (TextViewWithDivider) view5.findViewById(R.id.mxr) : null;
        View view6 = this.f441562d;
        this.mAuthorName = view6 != null ? (TextViewWithDivider) view6.findViewById(R.id.mxs) : null;
        View view7 = this.f441562d;
        this.mICPNumber1 = view7 != null ? (TextViewWithDivider) view7.findViewById(R.id.mxx) : null;
        View view8 = this.f441562d;
        this.mICPNumber2 = view8 != null ? (TextViewWithDivider) view8.findViewById(R.id.mxy) : null;
        View view9 = this.f441562d;
        this.mVersionName = view9 != null ? (TextViewWithDivider) view9.findViewById(R.id.mxz) : null;
        View view10 = this.f441562d;
        this.mPremissionName = view10 != null ? (TextViewWithDivider) view10.findViewById(R.id.mxv) : null;
        View view11 = this.f441562d;
        this.mPrivacy = view11 != null ? (TextViewWithDivider) view11.findViewById(R.id.mxw) : null;
        View view12 = this.f441562d;
        this.mDescription = view12 != null ? (TextViewWithDivider) view12.findViewById(R.id.mxt) : null;
    }

    private final void V() {
        LinearLayout linearLayout = this.mFirLineLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) (linearLayout != null ? linearLayout.getLayoutParams() : null);
        if (layoutParams != null) {
            layoutParams.removeRule(14);
        }
        LinearLayout linearLayout2 = this.mFirLineLayout;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout3 = this.mSecLineLayout;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (linearLayout3 != null ? linearLayout3.getLayoutParams() : null);
        if (layoutParams2 != null) {
            layoutParams2.removeRule(3);
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(1, R.id.mxp);
        }
        if (layoutParams2 != null) {
            layoutParams2.removeRule(14);
        }
        LinearLayout linearLayout4 = this.mSecLineLayout;
        if (linearLayout4 != null) {
            linearLayout4.setLayoutParams(layoutParams2);
        }
        TextViewWithDivider textViewWithDivider = this.mVersionName;
        if (textViewWithDivider != null) {
            textViewWithDivider.setDivider(true);
        }
    }

    private final void W() {
        LinearLayout linearLayout = this.mFirLineLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) (linearLayout != null ? linearLayout.getLayoutParams() : null);
        if (layoutParams != null) {
            layoutParams.addRule(14, -1);
        }
        LinearLayout linearLayout2 = this.mFirLineLayout;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout3 = this.mSecLineLayout;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) (linearLayout3 != null ? linearLayout3.getLayoutParams() : null);
        if (layoutParams2 != null) {
            layoutParams2.removeRule(1);
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(3, R.id.mxp);
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(14, -1);
        }
        LinearLayout linearLayout4 = this.mSecLineLayout;
        if (linearLayout4 != null) {
            linearLayout4.setLayoutParams(layoutParams2);
        }
        TextViewWithDivider textViewWithDivider = this.mVersionName;
        if (textViewWithDivider != null) {
            TextViewWithDivider textViewWithDivider2 = this.mICPNumber2;
            textViewWithDivider.setDivider(textViewWithDivider2 != null && textViewWithDivider2.getVisibility() == 0);
        }
    }

    private final void X() {
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        boolean R = qZoneAdFeedUtils.R(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
        RelativeLayout relativeLayout = this.mAppInfoLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) (relativeLayout != null ? relativeLayout.getLayoutParams() : null);
        if (layoutParams != null) {
            layoutParams.bottomMargin = R ? qZoneAdFeedUtils.D(this.f441565h, this.mAd) : 0;
        }
    }

    private final void Y() {
        ViewTreeObserver viewTreeObserver;
        S();
        GdtAd gdtAd = this.mAd;
        String appChannelICPNumber = gdtAd != null ? gdtAd.getAppChannelICPNumber() : null;
        if (appChannelICPNumber == null) {
            appChannelICPNumber = "";
        }
        TextViewWithDivider textViewWithDivider = this.mICPNumber1;
        if (textViewWithDivider != null) {
            textViewWithDivider.setText(appChannelICPNumber);
        }
        boolean z16 = !TextUtils.isEmpty(appChannelICPNumber);
        if (!z16) {
            TextViewWithDivider textViewWithDivider2 = this.mICPNumber1;
            if (textViewWithDivider2 != null) {
                textViewWithDivider2.setVisibility(8);
            }
            TextViewWithDivider textViewWithDivider3 = this.mICPNumber2;
            if (textViewWithDivider3 != null) {
                textViewWithDivider3.setVisibility(8);
            }
        } else {
            TextViewWithDivider textViewWithDivider4 = this.mICPNumber1;
            if (textViewWithDivider4 != null) {
                textViewWithDivider4.setVisibility(0);
            }
        }
        TextViewWithDivider textViewWithDivider5 = this.mAuthorName;
        if (textViewWithDivider5 != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            GdtAd gdtAd2 = this.mAd;
            textViewWithDivider5.setText(qZoneAdFeedUtils.C(gdtAd2 != null ? gdtAd2.getAppChannelAuthorName() : null, M(z16)));
        }
        TextViewWithDivider textViewWithDivider6 = this.mAppName;
        if (textViewWithDivider6 != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils2 = QZoneAdFeedUtils.f55717a;
            GdtAd gdtAd3 = this.mAd;
            textViewWithDivider6.setText(qZoneAdFeedUtils2.C(gdtAd3 != null ? gdtAd3.getAppChannelAppName() : null, L(z16)));
        }
        TextViewWithDivider textViewWithDivider7 = this.mAppName;
        if (textViewWithDivider7 != null) {
            textViewWithDivider7.setDivider(false);
        }
        TextViewWithDivider textViewWithDivider8 = this.mVersionName;
        if (textViewWithDivider8 != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils3 = QZoneAdFeedUtils.f55717a;
            GdtAd gdtAd4 = this.mAd;
            textViewWithDivider8.setText(qZoneAdFeedUtils3.C(gdtAd4 != null ? gdtAd4.getAppChannelVersionName() : null, 10));
        }
        TextViewWithDivider textViewWithDivider9 = this.mVersionName;
        if (textViewWithDivider9 != null) {
            textViewWithDivider9.setDivider(true);
        }
        TextViewWithDivider textViewWithDivider10 = this.mPremissionName;
        if (textViewWithDivider10 != null) {
            textViewWithDivider10.setText("\u5e94\u7528\u6743\u9650");
        }
        TextViewWithDivider textViewWithDivider11 = this.mPremissionName;
        if (textViewWithDivider11 != null) {
            textViewWithDivider11.setTextUnderline();
        }
        TextViewWithDivider textViewWithDivider12 = this.mPrivacy;
        if (textViewWithDivider12 != null) {
            textViewWithDivider12.setText("\u9690\u79c1\u653f\u7b56");
        }
        TextViewWithDivider textViewWithDivider13 = this.mPrivacy;
        if (textViewWithDivider13 != null) {
            textViewWithDivider13.setTextUnderline();
        }
        TextViewWithDivider textViewWithDivider14 = this.mDescription;
        if (textViewWithDivider14 != null) {
            textViewWithDivider14.setText("\u529f\u80fd\u4ecb\u7ecd");
        }
        TextViewWithDivider textViewWithDivider15 = this.mDescription;
        if (textViewWithDivider15 != null) {
            textViewWithDivider15.setTextUnderline();
        }
        RelativeLayout relativeLayout = this.mAppInfoLayout;
        ViewGroup.LayoutParams layoutParams = relativeLayout != null ? relativeLayout.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = R();
        }
        if (U()) {
            if (z16) {
                Z();
            }
            W();
        } else {
            V();
        }
        RelativeLayout relativeLayout2 = this.mAppInfoLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        RelativeLayout relativeLayout3 = this.mAppInfoLayout;
        if (relativeLayout3 != null) {
            relativeLayout3.requestLayout();
        }
        RelativeLayout relativeLayout4 = this.mAppInfoLayout;
        if (relativeLayout4 != null && (viewTreeObserver = relativeLayout4.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10781b());
        }
        RelativeLayout relativeLayout5 = this.mAppInfoLayout;
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(0);
        }
        RelativeLayout relativeLayout6 = this.mAppInfoLayout;
        if (relativeLayout6 != null) {
            relativeLayout6.requestLayout();
        }
        TextViewWithDivider textViewWithDivider16 = this.mPremissionName;
        if (textViewWithDivider16 != null) {
            textViewWithDivider16.setOnClickListener(J());
        }
        TextViewWithDivider textViewWithDivider17 = this.mPrivacy;
        if (textViewWithDivider17 != null) {
            textViewWithDivider17.setOnClickListener(J());
        }
        TextViewWithDivider textViewWithDivider18 = this.mDescription;
        if (textViewWithDivider18 != null) {
            textViewWithDivider18.setOnClickListener(J());
        }
        RelativeLayout relativeLayout7 = this.mAppInfoLayout;
        if (relativeLayout7 != null) {
            relativeLayout7.setOnClickListener(J());
        }
        X();
    }

    private final void Z() {
        ViewTreeObserver viewTreeObserver;
        GdtAd gdtAd = this.mAd;
        String appChannelICPNumber = gdtAd != null ? gdtAd.getAppChannelICPNumber() : null;
        if (appChannelICPNumber == null) {
            appChannelICPNumber = "";
        }
        if (QZoneAdFeedUtils.f55717a.R(QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h))) {
            TextViewWithDivider textViewWithDivider = this.mICPNumber1;
            if (textViewWithDivider != null && (viewTreeObserver = textViewWithDivider.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new c(appChannelICPNumber));
            }
            TextViewWithDivider textViewWithDivider2 = this.mICPNumber1;
            if (textViewWithDivider2 != null) {
                textViewWithDivider2.setText(appChannelICPNumber);
                return;
            }
            return;
        }
        if (T()) {
            TextViewWithDivider textViewWithDivider3 = this.mICPNumber1;
            if (textViewWithDivider3 != null) {
                textViewWithDivider3.setVisibility(8);
            }
            TextViewWithDivider textViewWithDivider4 = this.mICPNumber2;
            if (textViewWithDivider4 != null) {
                textViewWithDivider4.setVisibility(0);
            }
            TextViewWithDivider textViewWithDivider5 = this.mICPNumber2;
            if (textViewWithDivider5 != null) {
                textViewWithDivider5.setDivider(false);
            }
            TextViewWithDivider textViewWithDivider6 = this.mICPNumber2;
            if (textViewWithDivider6 != null) {
                textViewWithDivider6.setText(appChannelICPNumber);
                return;
            }
            return;
        }
        TextViewWithDivider textViewWithDivider7 = this.mICPNumber1;
        if (textViewWithDivider7 != null) {
            textViewWithDivider7.setVisibility(0);
        }
        TextViewWithDivider textViewWithDivider8 = this.mICPNumber2;
        if (textViewWithDivider8 != null) {
            textViewWithDivider8.setVisibility(8);
        }
        TextViewWithDivider textViewWithDivider9 = this.mICPNumber1;
        if (textViewWithDivider9 != null) {
            textViewWithDivider9.setText(appChannelICPNumber);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        String str;
        if (this.f441565h == null) {
            return;
        }
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null || (str = gdtAd.getTraceId()) == null) {
            str = "";
        }
        BusinessFeedData businessFeedData = this.f441565h;
        if (TextUtils.equals(str, businessFeedData != null ? QZoneAdFeedDataExtKt.getTraceId(businessFeedData) : null)) {
            return;
        }
        GdtAd E = GdtFeedUtilForQZone.E(this.f441565h);
        View view = this.f441562d;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!QZoneAdFeedUtils.f55717a.l(this.f441565h)) {
            QLog.d("QZoneAdFeedAppInfoPresenter", 2, "[onBindData] can not showOuterLayerDownloadView");
            return;
        }
        View view2 = this.f441562d;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.mAd = E;
        Y();
    }

    /* renamed from: N, reason: from getter */
    public final RelativeLayout getMAppInfoLayout() {
        return this.mAppInfoLayout;
    }

    /* renamed from: O, reason: from getter */
    public final TextViewWithDivider getMICPNumber1() {
        return this.mICPNumber1;
    }

    /* renamed from: P, reason: from getter */
    public final TextViewWithDivider getMICPNumber2() {
        return this.mICPNumber2;
    }

    /* renamed from: Q, reason: from getter */
    public final TextViewWithDivider getMVersionName() {
        return this.mVersionName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedAppInfoPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmg;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private final boolean T() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        TextViewWithDivider textViewWithDivider = this.mAppName;
        if (textViewWithDivider != null) {
            textViewWithDivider.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        TextViewWithDivider textViewWithDivider2 = this.mAuthorName;
        if (textViewWithDivider2 != null) {
            textViewWithDivider2.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        TextViewWithDivider textViewWithDivider3 = this.mICPNumber1;
        if (textViewWithDivider3 != null) {
            textViewWithDivider3.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        TextViewWithDivider textViewWithDivider4 = this.mAppName;
        int measuredWidth = textViewWithDivider4 != null ? textViewWithDivider4.getMeasuredWidth() : 0;
        TextViewWithDivider textViewWithDivider5 = this.mAuthorName;
        int measuredWidth2 = textViewWithDivider5 != null ? textViewWithDivider5.getMeasuredWidth() : 0;
        TextViewWithDivider textViewWithDivider6 = this.mICPNumber1;
        int measuredWidth3 = textViewWithDivider6 != null ? textViewWithDivider6.getMeasuredWidth() : 0;
        RelativeLayout relativeLayout = this.mAppInfoLayout;
        int paddingLeft = relativeLayout != null ? relativeLayout.getPaddingLeft() : 0;
        RelativeLayout relativeLayout2 = this.mAppInfoLayout;
        return ((measuredWidth + measuredWidth2) + measuredWidth3) + (paddingLeft + (relativeLayout2 != null ? relativeLayout2.getPaddingRight() : 0)) > R();
    }

    private final boolean U() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        LinearLayout linearLayout = this.mFirLineLayout;
        if (linearLayout != null) {
            linearLayout.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        LinearLayout linearLayout2 = this.mSecLineLayout;
        if (linearLayout2 != null) {
            linearLayout2.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        LinearLayout linearLayout3 = this.mFirLineLayout;
        int measuredWidth = linearLayout3 != null ? linearLayout3.getMeasuredWidth() : 0;
        LinearLayout linearLayout4 = this.mSecLineLayout;
        int measuredWidth2 = linearLayout4 != null ? linearLayout4.getMeasuredWidth() : 0;
        RelativeLayout relativeLayout = this.mAppInfoLayout;
        int paddingLeft = relativeLayout != null ? relativeLayout.getPaddingLeft() : 0;
        RelativeLayout relativeLayout2 = this.mAppInfoLayout;
        return (measuredWidth + measuredWidth2) + (paddingLeft + (relativeLayout2 != null ? relativeLayout2.getPaddingRight() : 0)) > R();
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}
