package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AdTimeCounter;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u000b2\u00020\u0001:\u0001rB\u0007\u00a2\u0006\u0004\bp\u0010qJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u001a\u0010#\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020+H\u0014J\b\u0010-\u001a\u00020\u000fH\u0014J\b\u0010.\u001a\u00020\u0004H\u0014J\u0012\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u00103\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101H\u0014J\u0012\u00104\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020\u0002H\u0016J\b\u00107\u001a\u00020\u0002H\u0016J\b\u00108\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u00020\u0002H\u0016R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010FR\u0016\u0010H\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010FR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010 R\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010RR\u0016\u0010T\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010FR\u0016\u0010U\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010FR\u0016\u0010V\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010FR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R\u0018\u0010X\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010<R\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010`R\u0016\u0010c\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010eR\u0016\u0010g\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0018\u0010h\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010<R\u0018\u0010i\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010]R\u0018\u0010j\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010`R\u0018\u0010k\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010`R\u0016\u0010l\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010bR\u0018\u0010m\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010eR\u0016\u0010o\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010 \u00a8\u0006s"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/h;", "Lvg/a;", "", "V", "", "U", "T", "L", "g0", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "gestureInfo", "i0", "e0", "j0", "k0", "", "currentTimeMs", "O", "Lcf/b;", "event", "P", "currentTimeS", "M", "f0", "Landroid/view/View;", "view", "clickPos", "J", "Y", BdhLogUtil.LogTag.Tag_Req, "X", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", ExifInterface.LATITUDE_SOUTH, "isVisible", "W", "N", "a0", "c0", "b0", "sec", "", "d0", "", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "mGestureLayout", "Lcom/tencent/gdtad/aditem/GdtAd;", "G", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "", "H", "Ljava/util/List;", "mGestureInfoList", "I", "mStageNum", "mGestureCurrentState", "K", "mIsShowGesture", "mNeedTimeCounter", "Lcom/tencent/mobileqq/util/AdTimeCounter;", "Lcom/tencent/mobileqq/util/AdTimeCounter;", "mAdTimeCounter", "Lcom/tencent/mobileqq/util/d;", "Lcom/tencent/mobileqq/util/d;", "mAdTimeCounterCallback", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "mCurrentStageGestureInfo", "mCurrentTimeS", "mCurrentStage", "mVideoCurrentDurationS", "mHasCheckedResumePlay", "mBottomGestureContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mBottomGestureContent", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mBottomGestureIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mBottomGestureText", "Ljava/lang/String;", "mBottomGestureIconUrl", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "mBottomGestureIconDrawable", "mBottomGestureApngCanPlay", "mMiddleGestureContainer", "mMiddleGestureIcon", "mMiddleGestureTextFirstLine", "mMiddleGestureTextSecondLine", "mMiddleGestureIconUrl", "mMiddleGestureIconDrawable", "h0", "mMiddleGestureApngCanPlay", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout mGestureLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: H, reason: from kotlin metadata */
    private List<QZoneAdFeedData.GestureStageInfo> mGestureInfoList;

    /* renamed from: I, reason: from kotlin metadata */
    private int mStageNum;

    /* renamed from: J, reason: from kotlin metadata */
    private int mGestureCurrentState;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsShowGesture;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mNeedTimeCounter;

    /* renamed from: M, reason: from kotlin metadata */
    private AdTimeCounter mAdTimeCounter;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.util.d mAdTimeCounterCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private QZoneAdFeedData.GestureStageInfo mCurrentStageGestureInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private volatile int mCurrentTimeS;

    /* renamed from: R, reason: from kotlin metadata */
    private volatile int mCurrentStage;

    /* renamed from: S, reason: from kotlin metadata */
    private volatile int mVideoCurrentDurationS;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mHasCheckedResumePlay;

    /* renamed from: U, reason: from kotlin metadata */
    private FrameLayout mBottomGestureContainer;

    /* renamed from: V, reason: from kotlin metadata */
    private LinearLayout mBottomGestureContent;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView mBottomGestureIcon;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView mBottomGestureText;

    /* renamed from: Z, reason: from kotlin metadata */
    private APNGDrawable mBottomGestureIconDrawable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mBottomGestureApngCanPlay;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mMiddleGestureContainer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ImageView mMiddleGestureIcon;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView mMiddleGestureTextFirstLine;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private TextView mMiddleGestureTextSecondLine;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private APNGDrawable mMiddleGestureIconDrawable;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean mMiddleGestureApngCanPlay;

    /* renamed from: Y, reason: from kotlin metadata */
    private String mBottomGestureIconUrl = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String mMiddleGestureIconUrl = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(h this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this$0.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this$0.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, view, mFeedData, FeedElement.GDT_GESTURE_STAGE_VIEW, i3, this$0.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L() {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        FrameLayout.LayoutParams layoutParams3;
        FrameLayout.LayoutParams layoutParams4;
        if (U()) {
            FrameLayout frameLayout = this.mGestureLayout;
            if (frameLayout != null && (layoutParams4 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams()) != null) {
                layoutParams4.width = N();
                layoutParams4.bottomMargin = QZoneAdFeedUtils.f55717a.D(this.f441565h, this.mAd);
                frameLayout.setLayoutParams(layoutParams4);
            }
            LinearLayout linearLayout = this.mBottomGestureContent;
            if (linearLayout == null || (layoutParams3 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams()) == null) {
                return;
            }
            layoutParams3.bottomMargin = ar.d(26.0f);
            linearLayout.setLayoutParams(layoutParams3);
            return;
        }
        FrameLayout frameLayout2 = this.mGestureLayout;
        if (frameLayout2 != null && (layoutParams2 = (FrameLayout.LayoutParams) frameLayout2.getLayoutParams()) != null) {
            layoutParams2.width = -1;
            layoutParams2.bottomMargin = 0;
            frameLayout2.setLayoutParams(layoutParams2);
        }
        LinearLayout linearLayout2 = this.mBottomGestureContent;
        if (linearLayout2 == null || (layoutParams = (FrameLayout.LayoutParams) linearLayout2.getLayoutParams()) == null) {
            return;
        }
        layoutParams.bottomMargin = ar.d(6.0f);
        linearLayout2.setLayoutParams(layoutParams);
    }

    private final void M(int currentTimeS) {
        if (this.mHasCheckedResumePlay) {
            return;
        }
        this.mHasCheckedResumePlay = true;
        List<QZoneAdFeedData.GestureStageInfo> list = this.mGestureInfoList;
        if ((list == null || list.isEmpty()) || currentTimeS == 0) {
            return;
        }
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "checkResumePlayGestureAnim:", Integer.valueOf(currentTimeS));
        List<QZoneAdFeedData.GestureStageInfo> list2 = this.mGestureInfoList;
        if (list2 != null) {
            int i3 = 0;
            for (QZoneAdFeedData.GestureStageInfo gestureStageInfo : list2) {
                int i16 = i3 + 1;
                if (currentTimeS <= gestureStageInfo.getEndTimeS() && gestureStageInfo.getBeginTimeS() <= currentTimeS) {
                    this.mCurrentStage = i3;
                    List<QZoneAdFeedData.GestureStageInfo> list3 = this.mGestureInfoList;
                    if (list3 != null) {
                        QZoneAdFeedData.GestureStageInfo gestureStageInfo2 = list3 != null ? list3.get(this.mCurrentStage) : null;
                        this.mCurrentStageGestureInfo = gestureStageInfo2;
                        if (gestureStageInfo2 != null) {
                            i0(gestureStageInfo2);
                        }
                    }
                    Y();
                    return;
                }
                i3 = i16;
            }
        }
    }

    private final int N() {
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
        return layoutParams.width + (ar.d(13.0f) * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int currentTimeMs) {
        if (this.mCurrentStageGestureInfo == null) {
            return;
        }
        this.mCurrentTimeS = currentTimeMs / 1000;
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "handleTimeCounterStage currentTimeS:", Integer.valueOf(this.mCurrentTimeS));
        QZoneAdFeedData.GestureStageInfo gestureStageInfo = this.mCurrentStageGestureInfo;
        if (gestureStageInfo != null) {
            if (gestureStageInfo.getBeginTimeS() == this.mCurrentTimeS) {
                Y();
            }
            if (gestureStageInfo.getEndTimeS() == this.mCurrentTimeS) {
                R();
            }
        }
    }

    private final void P(cf.b event) {
        int r16 = QZoneAdFeedUtils.f55717a.r(event.f30766b, "event_key_qzone_ad_feed_video_current_duration");
        if (this.mIsShowGesture) {
            this.mVideoCurrentDurationS = r16 / 1000;
            QZoneAdFeedData.GestureStageInfo gestureStageInfo = this.mCurrentStageGestureInfo;
            if (gestureStageInfo != null) {
                if (gestureStageInfo.getBeginTimeS() == this.mVideoCurrentDurationS) {
                    Y();
                }
                if (gestureStageInfo.getEndTimeS() == this.mVideoCurrentDurationS) {
                    R();
                }
            }
            M(this.mVideoCurrentDurationS);
        }
    }

    private final void Q() {
        if (this.mGestureCurrentState == 2) {
            return;
        }
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "hideBottomGestureView");
        W(this.mBottomGestureContainer, false);
        this.mBottomGestureApngCanPlay = false;
        APNGDrawable aPNGDrawable = this.mBottomGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        this.mGestureCurrentState = 2;
    }

    private final void R() {
        QZoneAdFeedData.GestureStageInfo gestureStageInfo = this.mCurrentStageGestureInfo;
        if (gestureStageInfo != null) {
            if (gestureStageInfo.getStageType() == 1) {
                Q();
            } else if (gestureStageInfo.getStageType() == 2) {
                S();
            }
            if (this.mCurrentStage < this.mStageNum - 1) {
                this.mCurrentStage++;
                List<QZoneAdFeedData.GestureStageInfo> list = this.mGestureInfoList;
                QZoneAdFeedData.GestureStageInfo gestureStageInfo2 = list != null ? list.get(this.mCurrentStage) : null;
                this.mCurrentStageGestureInfo = gestureStageInfo2;
                if (gestureStageInfo2 != null) {
                    i0(gestureStageInfo2);
                    if (this.mCurrentTimeS == 0 || gestureStageInfo2.getBeginTimeS() != this.mCurrentTimeS) {
                        return;
                    }
                    Y();
                    QLog.d("QZoneAdFeedGestureStagePresenter", 1, "hideGestureView and show next stage");
                }
            }
        }
    }

    private final void S() {
        if (this.mGestureCurrentState == 4) {
            return;
        }
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "hideMiddleGestureView");
        W(this.mMiddleGestureContainer, false);
        this.mMiddleGestureApngCanPlay = false;
        APNGDrawable aPNGDrawable = this.mMiddleGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        this.mGestureCurrentState = 4;
    }

    private final boolean T() {
        BusinessFeedData businessFeedData = this.f441565h;
        return QZoneAdFeedUtils.f55717a.P((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
    }

    private final boolean U() {
        BusinessFeedData businessFeedData = this.f441565h;
        return QZoneAdFeedUtils.f55717a.R((businessFeedData == null || !businessFeedData.isGDTAdvFeed()) ? Integer.MIN_VALUE : QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h));
    }

    private final void V() {
        boolean z16 = true;
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "resetCurrentGestureInfo");
        QZoneAdFeedData.GestureStageInfo gestureStageInfo = this.mCurrentStageGestureInfo;
        if (gestureStageInfo != null) {
            if (gestureStageInfo.getStageType() == 1) {
                Q();
            } else if (gestureStageInfo.getStageType() == 2) {
                S();
            }
        }
        List<QZoneAdFeedData.GestureStageInfo> list = this.mGestureInfoList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mCurrentTimeS = 0;
        this.mCurrentStage = 0;
        this.mHasCheckedResumePlay = false;
        this.mGestureCurrentState = 0;
        List<QZoneAdFeedData.GestureStageInfo> list2 = this.mGestureInfoList;
        if (list2 != null) {
            QZoneAdFeedData.GestureStageInfo gestureStageInfo2 = list2 != null ? list2.get(this.mCurrentStage) : null;
            this.mCurrentStageGestureInfo = gestureStageInfo2;
            if (gestureStageInfo2 != null) {
                i0(gestureStageInfo2);
            }
        }
    }

    private final void X() {
        if (this.mGestureCurrentState == 1) {
            return;
        }
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "showBottomGestureView");
        W(this.mBottomGestureContainer, true);
        this.mBottomGestureApngCanPlay = true;
        APNGDrawable aPNGDrawable = this.mBottomGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.start();
        }
        this.mGestureCurrentState = 1;
    }

    private final void Y() {
        QZoneAdFeedData.GestureStageInfo gestureStageInfo = this.mCurrentStageGestureInfo;
        if (gestureStageInfo != null) {
            int stageType = gestureStageInfo.getStageType();
            if (stageType == 1) {
                X();
            } else {
                if (stageType != 2) {
                    return;
                }
                Z();
            }
        }
    }

    private final void Z() {
        if (this.mGestureCurrentState == 3) {
            return;
        }
        QLog.d("QZoneAdFeedGestureStagePresenter", 1, "showMiddleGestureView");
        W(this.mMiddleGestureContainer, true);
        this.mMiddleGestureApngCanPlay = true;
        APNGDrawable aPNGDrawable = this.mMiddleGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.start();
        }
        this.mGestureCurrentState = 3;
    }

    private final void a0() {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2;
        if (this.mBottomGestureApngCanPlay && (aPNGDrawable2 = this.mBottomGestureIconDrawable) != null) {
            aPNGDrawable2.start();
        }
        if (this.mMiddleGestureApngCanPlay && (aPNGDrawable = this.mMiddleGestureIconDrawable) != null) {
            aPNGDrawable.start();
        }
        b0();
    }

    private final void b0() {
        if (this.mNeedTimeCounter) {
            QLog.d("QZoneAdFeedGestureStagePresenter", 1, "startTimeCounter currentTimeS:", Integer.valueOf(this.mCurrentTimeS));
            if (this.mCurrentTimeS == 0) {
                AdTimeCounter adTimeCounter = this.mAdTimeCounter;
                if (adTimeCounter != null) {
                    adTimeCounter.g();
                    return;
                }
                return;
            }
            AdTimeCounter adTimeCounter2 = this.mAdTimeCounter;
            if (adTimeCounter2 != null) {
                adTimeCounter2.h(d0(this.mCurrentTimeS));
            }
        }
    }

    private final void c0() {
        APNGDrawable aPNGDrawable = this.mBottomGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        APNGDrawable aPNGDrawable2 = this.mMiddleGestureIconDrawable;
        if (aPNGDrawable2 != null) {
            aPNGDrawable2.stop();
        }
        AdTimeCounter adTimeCounter = this.mAdTimeCounter;
        if (adTimeCounter != null) {
            adTimeCounter.i();
        }
    }

    private final long d0(int sec) {
        return sec * 1000;
    }

    private final void e0() {
        if (TextUtils.isEmpty(this.mBottomGestureIconUrl)) {
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        APNGDrawable aPNGDrawable = this.mBottomGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        this.mBottomGestureIconDrawable = null;
        APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("QZoneAdFeedGestureStagePresenter", this.mBottomGestureIconUrl, apngOptions);
        this.mBottomGestureIconDrawable = apngDrawable;
        ImageView imageView = this.mBottomGestureIcon;
        if (imageView != null) {
            imageView.setImageDrawable(apngDrawable);
        }
    }

    private final void f0() {
        J(this.mBottomGestureIcon, 10064);
        J(this.mBottomGestureText, 10064);
        J(this.mMiddleGestureIcon, 10065);
        J(this.mMiddleGestureTextFirstLine, 10065);
        J(this.mMiddleGestureTextSecondLine, 10065);
    }

    private final void g0() {
        ih.i iVar = ih.i.f407634a;
        BusinessFeedData mFeedData = this.f441565h;
        Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
        List<QZoneAdFeedData.GestureStageInfo> c16 = iVar.c(mFeedData);
        this.mGestureInfoList = c16;
        if (c16 != null) {
            int size = c16.size();
            this.mStageNum = size;
            QLog.d("QZoneAdFeedGestureStagePresenter", 1, "updateGestureInfo mStageNum:", Integer.valueOf(size));
            if (this.mStageNum == 0) {
                return;
            }
            this.mIsShowGesture = true;
            List<QZoneAdFeedData.GestureStageInfo> list = this.mGestureInfoList;
            QZoneAdFeedData.GestureStageInfo gestureStageInfo = list != null ? list.get(this.mCurrentStage) : null;
            this.mCurrentStageGestureInfo = gestureStageInfo;
            if (gestureStageInfo != null) {
                i0(gestureStageInfo);
            }
        }
    }

    private final void i0(QZoneAdFeedData.GestureStageInfo gestureInfo) {
        if (gestureInfo.getStageType() == 1) {
            this.mBottomGestureIconUrl = gestureInfo.getIconUrl();
            TextView textView = this.mBottomGestureText;
            if (textView != null) {
                textView.setText(gestureInfo.getTipFirstLine());
            }
            e0();
            return;
        }
        if (gestureInfo.getStageType() == 2) {
            this.mMiddleGestureIconUrl = gestureInfo.getIconUrl();
            TextView textView2 = this.mMiddleGestureTextFirstLine;
            if (textView2 != null) {
                textView2.setText(gestureInfo.getTipFirstLine());
            }
            TextView textView3 = this.mMiddleGestureTextSecondLine;
            if (textView3 != null) {
                textView3.setText(gestureInfo.getTipSecondLine());
            }
            j0();
        }
    }

    private final void j0() {
        if (TextUtils.isEmpty(this.mMiddleGestureIconUrl)) {
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        APNGDrawable aPNGDrawable = this.mMiddleGestureIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        this.mMiddleGestureIconDrawable = null;
        APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("QZoneAdFeedGestureStagePresenter", this.mMiddleGestureIconUrl, apngOptions);
        this.mMiddleGestureIconDrawable = apngDrawable;
        ImageView imageView = this.mMiddleGestureIcon;
        if (imageView != null) {
            imageView.setImageDrawable(apngDrawable);
        }
    }

    private final void k0() {
        Object last;
        int beginTimeS;
        if (!this.mIsShowGesture || this.mCurrentStageGestureInfo == null) {
            return;
        }
        this.mAdTimeCounterCallback = new b();
        List<QZoneAdFeedData.GestureStageInfo> list = this.mGestureInfoList;
        if (list != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            QZoneAdFeedData.GestureStageInfo gestureStageInfo = (QZoneAdFeedData.GestureStageInfo) last;
            if (gestureStageInfo != null) {
                if (gestureStageInfo.getEndTimeS() < 50) {
                    beginTimeS = gestureStageInfo.getEndTimeS();
                } else {
                    beginTimeS = gestureStageInfo.getBeginTimeS();
                }
                this.mAdTimeCounter = new AdTimeCounter(d0(beginTimeS), new WeakReference(this.mAdTimeCounterCallback), 0L, 4, null);
                this.mNeedTimeCounter = true;
            }
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Object obj;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && this.f441562d != null) {
            String aid = QZoneAdFeedDataExtKt.getAid(businessFeedData);
            String traceId = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
            GdtAd gdtAd = this.mAd;
            String str = null;
            if (gdtAd != null) {
                obj = gdtAd != null ? Long.valueOf(gdtAd.getAId()) : null;
            } else {
                obj = "-2147483648";
            }
            GdtAd gdtAd2 = this.mAd;
            if (gdtAd2 == null) {
                str = "";
            } else if (gdtAd2 != null) {
                str = gdtAd2.getTraceId();
            }
            QLog.i("QZoneAdFeedGestureStagePresenter", 2, "[onBindData]  aid:" + aid + " traceId:" + traceId + " oldAid:" + obj + " oldTraceId:" + str);
            if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
                QLog.e("QZoneAdFeedGestureStagePresenter", 2, "[onBindData] ignore, is the same ad");
                return;
            }
            this.mAd = GdtFeedUtilForQZone.E(this.f441565h);
            L();
            V();
            g0();
            f0();
            if (T()) {
                k0();
                return;
            }
            return;
        }
        QLog.e("QZoneAdFeedGestureStagePresenter", 1, "[onBindData] error, containerView is null");
    }

    @Override // vg.a
    public void B() {
        if (this.mIsShowGesture) {
            c0();
        }
    }

    @Override // vg.a, vg.c
    public void c() {
        if (this.mIsShowGesture) {
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedGestureStagePresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        c0();
        this.mBottomGestureIconDrawable = null;
        this.mMiddleGestureIconDrawable = null;
        this.mAdTimeCounterCallback = null;
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        if (this.mIsShowGesture) {
            c0();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmx;
    }

    @Override // vg.a
    public void t(cf.b event) {
        super.t(event);
        if (event == null) {
            return;
        }
        if (QZoneAdFeedUtils.f55717a.I(event.f30766b, "event_key_qzone_ad_feed_video_current_duration")) {
            P(event);
        }
        if (event.f30765a == 1008) {
            V();
        }
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        if (this.mIsShowGesture) {
            a0();
        }
    }

    private final void J(View view, final int clickPos) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.K(h.this, clickPos, view2);
                }
            });
        }
    }

    private final void W(View view, boolean isVisible) {
        if (view == null) {
            return;
        }
        if (T()) {
            view.setVisibility(isVisible ? 0 : 8);
        } else if (isVisible) {
            ih.i.e(ih.i.f407634a, view, 0L, 2, null);
        } else {
            ih.i.h(ih.i.f407634a, view, 0L, 2, null);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        if (containerView == null) {
            QLog.e("QZoneAdFeedGestureStagePresenter", 1, "[onInitView] error, containerView is null");
            return;
        }
        this.f441562d = containerView;
        this.mGestureLayout = (FrameLayout) containerView.findViewById(R.id.mml);
        this.mBottomGestureContainer = (FrameLayout) this.f441562d.findViewById(R.id.mmg);
        this.mBottomGestureContent = (LinearLayout) this.f441562d.findViewById(R.id.mmh);
        this.mBottomGestureIcon = (ImageView) this.f441562d.findViewById(R.id.mmi);
        this.mBottomGestureText = (TextView) this.f441562d.findViewById(R.id.mmk);
        this.mMiddleGestureContainer = (FrameLayout) this.f441562d.findViewById(R.id.mmm);
        this.mMiddleGestureIcon = (ImageView) this.f441562d.findViewById(R.id.mmn);
        this.mMiddleGestureTextFirstLine = (TextView) this.f441562d.findViewById(R.id.mmp);
        this.mMiddleGestureTextSecondLine = (TextView) this.f441562d.findViewById(R.id.mmq);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/h$b", "Lcom/tencent/mobileqq/util/d;", "", "currentTimeMs", "", "a", "leftTimeMs", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements com.tencent.mobileqq.util.d {
        b() {
        }

        @Override // com.tencent.mobileqq.util.d
        public void a(long currentTimeMs) {
            h.this.O((int) currentTimeMs);
        }

        @Override // com.tencent.mobileqq.util.d
        public void b(long leftTimeMs) {
        }
    }
}
