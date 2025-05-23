package com.qzone.reborn.feedx.presenter.ad;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.event.ad.QZoneAdClickEvent;
import com.tencent.ad.tangram.views.AdUISettings;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView;
import com.tencent.mobileqq.vas.adv.recommendad.f;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneTopGestureLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!`\"H\u0016R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010G\u001a\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/QZoneAdRecommendAdPresenter;", "Lvg/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "Landroid/view/View;", "L", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "K", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "N", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "onPaused", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView;", "getMRecommendAdView", "()Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView;", "setMRecommendAdView", "(Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView;)V", "mRecommendAdView", "G", "Landroid/view/View;", "getMMediaView", "()Landroid/view/View;", "setMMediaView", "(Landroid/view/View;)V", "mMediaView", "Landroid/os/Handler;", "H", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "getMRequestRecommendAdRunnable", "()Ljava/lang/Runnable;", "mRequestRecommendAdRunnable", "", "J", "getMClickTime", "()J", "setMClickTime", "(J)V", "mClickTime", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "Lkotlin/Lazy;", "M", "()Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mFeedbackListener", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdRecommendAdPresenter extends vg.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: F, reason: from kotlin metadata */
    private RecommendAdView mRecommendAdView;

    /* renamed from: G, reason: from kotlin metadata */
    private View mMediaView;

    /* renamed from: H, reason: from kotlin metadata */
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: I, reason: from kotlin metadata */
    private final Runnable mRequestRecommendAdRunnable = new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.y
        @Override // java.lang.Runnable
        public final void run() {
            QZoneAdRecommendAdPresenter.O(QZoneAdRecommendAdPresenter.this);
        }
    };

    /* renamed from: J, reason: from kotlin metadata */
    private long mClickTime = Long.MAX_VALUE;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy mFeedbackListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/QZoneAdRecommendAdPresenter$b", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$a;", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements RecommendAdView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView.a
        public void a(GdtAd ad5) {
            Intrinsics.checkNotNullParameter(ad5, "ad");
            AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
            adFeedbackParams.activity = new WeakReference<>(((vg.a) QZoneAdRecommendAdPresenter.this).C);
            adFeedbackParams.listener = new WeakReference<>(QZoneAdRecommendAdPresenter.this.M());
            adFeedbackParams.f61346ad = ad5;
            adFeedbackParams.styleId = 0;
            adFeedbackParams.isDarkMode = AdUISettings.getInstance().isNightMode();
            adFeedbackParams.shouldShowCancelButton = false;
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
            } catch (Throwable th5) {
                QLog.e("QZoneAdRecommendAdPresenter", 1, "[handleFeebBack] error" + th5);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/QZoneAdRecommendAdPresenter$c", "Lcom/tencent/mobileqq/vas/adv/recommendad/RecommendAdView$b;", "", "backEnable", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements RecommendAdView.b {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.adv.recommendad.RecommendAdView.b
        public void a(boolean backEnable) {
            QZoneTopGestureLayout.setBackEnabled(backEnable);
            FrameHelperActivity.gj(backEnable, "QZoneAdRecommendAdPresenter");
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/QZoneAdRecommendAdPresenter$d", "Lcom/tencent/mobileqq/vas/adv/recommendad/f$a;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "adList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements f.a {
        d() {
        }

        @Override // com.tencent.mobileqq.vas.adv.recommendad.f.a
        public void a(List<? extends GdtAd> adList) {
            ArrayList arrayListOf;
            GdtImageData imageData;
            Intrinsics.checkNotNullParameter(adList, "adList");
            if (adList.isEmpty()) {
                return;
            }
            GdtAd ad5 = GdtFeedUtilForQZone.E(((vg.a) QZoneAdRecommendAdPresenter.this).f441565h);
            Intrinsics.checkNotNullExpressionValue(ad5, "ad");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ad5);
            arrayListOf.addAll(adList);
            BusinessFeedData businessFeedData = ((vg.a) QZoneAdRecommendAdPresenter.this).f441565h;
            String str = null;
            QZoneAdFeedData adData = businessFeedData != null ? businessFeedData.getAdData() : null;
            if (adData != null) {
                adData.setRecommendAdList(arrayListOf);
            }
            GdtAd E = GdtFeedUtilForQZone.E(((vg.a) QZoneAdRecommendAdPresenter.this).f441565h);
            if (E != null && (imageData = E.getImageData()) != null) {
                str = imageData.url;
            }
            if (str == null) {
                str = "";
            }
            URLDrawable uRLDrawable = (URLDrawable) GdtUIUtils.getUrlDrawable(str);
            if (uRLDrawable != null) {
                uRLDrawable.startDownload();
            }
        }
    }

    public QZoneAdRecommendAdPresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new QZoneAdRecommendAdPresenter$mFeedbackListener$2(this));
        this.mFeedbackListener = lazy;
    }

    private final RecommendAdView.a K() {
        return new b();
    }

    private final View L() {
        int gdtInnerAdShowType = QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h);
        if (gdtInnerAdShowType == 1) {
            return this.f441563e.findViewById(R.id.mvo);
        }
        if (gdtInnerAdShowType != 3) {
            return null;
        }
        return this.f441563e.findViewById(R.id.mvr);
    }

    private final RecommendAdView.b N() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QZoneAdRecommendAdPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P();
    }

    private final void P() {
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestRecommendAd(QZoneAdFeedDataExtKt.getAdSecondCategory(this.f441565h), new d());
    }

    private final void Q() {
        RecommendAdView recommendAdView = this.mRecommendAdView;
        if (recommendAdView != null) {
            recommendAdView.f(this.f441565h.getAdData().getRecommendAdList(), K(), com.qzone.adapter.feedcomponent.i.H().m(), N());
        }
        RecommendAdView recommendAdView2 = this.mRecommendAdView;
        if (recommendAdView2 != null) {
            recommendAdView2.setVisibility(4);
        }
        View L = L();
        this.mMediaView = L;
        if (L == null) {
            return;
        }
        int[] iArr = new int[2];
        if (L != null) {
            L.getLocationOnScreen(iArr);
        }
        View view = this.mMediaView;
        int width = view != null ? view.getWidth() : 0;
        View view2 = this.mMediaView;
        int height = view2 != null ? view2.getHeight() : 0;
        D(new df.b());
        RecommendAdView recommendAdView3 = this.mRecommendAdView;
        if (recommendAdView3 != null) {
            recommendAdView3.o(iArr, width, height, 340);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        QZoneAdFeedData adData;
        List<GdtAd> recommendAdList;
        RecommendAdView recommendAdView;
        if (QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h)) {
            BusinessFeedData businessFeedData = this.f441565h;
            if (businessFeedData != null && (adData = businessFeedData.getAdData()) != null && (recommendAdList = adData.getRecommendAdList()) != null && (recommendAdView = this.mRecommendAdView) != null) {
                recommendAdView.f(recommendAdList, K(), com.qzone.adapter.feedcomponent.i.H().m(), N());
            }
            RecommendAdView recommendAdView2 = this.mRecommendAdView;
            if (recommendAdView2 != null) {
                recommendAdView2.setVisibility(0);
            }
            RecommendAdView recommendAdView3 = this.mRecommendAdView;
            if (recommendAdView3 != null) {
                recommendAdView3.j();
                return;
            }
            return;
        }
        RecommendAdView recommendAdView4 = this.mRecommendAdView;
        if (recommendAdView4 == null) {
            return;
        }
        recommendAdView4.setVisibility(8);
    }

    @Override // vg.a
    public void B() {
        RecommendAdView recommendAdView;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (!QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h) || (recommendAdView = this.mRecommendAdView) == null) {
            return;
        }
        recommendAdView.i();
    }

    public final AdFeedbackDialogFragment.Listener M() {
        return (AdFeedbackDialogFragment.Listener) this.mFeedbackListener.getValue();
    }

    @Override // vg.a, vg.c
    public void c() {
        QZoneAdFeedData adData;
        QZoneAdFeedData adData2;
        if (QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h)) {
            RecommendAdView recommendAdView = this.mRecommendAdView;
            if (recommendAdView != null) {
                recommendAdView.setVisibility(0);
            }
            RecommendAdView recommendAdView2 = this.mRecommendAdView;
            if (recommendAdView2 != null) {
                recommendAdView2.j();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mClickTime;
        List<GdtAd> recommendAdList = this.f441565h.getAdData().getRecommendAdList();
        QLog.d("QZoneAdRecommendAdPresenter", 2, "[onResumed] landingpage stayDuration \uff1a " + currentTimeMillis + "recommendAd is NullOrEmpty:" + (recommendAdList == null || recommendAdList.isEmpty()));
        BusinessFeedData businessFeedData = this.f441565h;
        List<GdtAd> recommendAdList2 = (businessFeedData == null || (adData2 = businessFeedData.getAdData()) == null) ? null : adData2.getRecommendAdList();
        if (!(recommendAdList2 == null || recommendAdList2.isEmpty()) && currentTimeMillis >= QZoneAdFeedDataExtKt.recommendAdStayTime(this.f441565h)) {
            BusinessFeedData businessFeedData2 = this.f441565h;
            adData = businessFeedData2 != null ? businessFeedData2.getAdData() : null;
            if (adData != null) {
                adData.setNeedShowRecommendAd(true);
            }
            Q();
        } else {
            BusinessFeedData businessFeedData3 = this.f441565h;
            adData = businessFeedData3 != null ? businessFeedData3.getAdData() : null;
            if (adData != null) {
                adData.setRecommendAdList(new ArrayList());
            }
        }
        this.mHandler.removeCallbacks(this.mRequestRecommendAdRunnable);
        this.mClickTime = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdRecommendAdPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        RecommendAdView recommendAdView;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (!QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h) || (recommendAdView = this.mRecommendAdView) == null) {
            return;
        }
        recommendAdView.h();
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        RecommendAdView recommendAdView;
        if (!QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h) || (recommendAdView = this.mRecommendAdView) == null) {
            return;
        }
        recommendAdView.i();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof QZoneAdClickEvent) && ((QZoneAdClickEvent) event).getAreaId() != 2001 && QZoneAdFeedDataExtKt.isNeedRequestRecommendAd(this.f441565h)) {
            List<GdtAd> recommendAdList = this.f441565h.getAdData().getRecommendAdList();
            if (recommendAdList == null || recommendAdList.isEmpty()) {
                this.mHandler.removeCallbacks(this.mRequestRecommendAdRunnable);
                this.mHandler.postDelayed(this.mRequestRecommendAdRunnable, QZoneAdFeedDataExtKt.recommendAdRequestDelay(this.f441565h));
                this.mClickTime = System.currentTimeMillis();
            }
        }
    }

    @Override // vg.a, vg.c
    public void onStop() {
        RecommendAdView recommendAdView;
        if (!QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h) || (recommendAdView = this.mRecommendAdView) == null) {
            return;
        }
        recommendAdView.k();
    }

    @Override // vg.a
    protected int s() {
        return R.id.f162977nn2;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        RecommendAdView recommendAdView;
        SimpleEventBus.getInstance().registerReceiver(this);
        if (!QZoneAdFeedDataExtKt.isShowingRecommendAd(this.f441565h) || (recommendAdView = this.mRecommendAdView) == null) {
            return;
        }
        recommendAdView.j();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneAdClickEvent.class);
        return arrayListOf;
    }

    @Override // vg.a
    protected void C(View containerView) {
        this.mRecommendAdView = containerView != null ? (RecommendAdView) containerView.findViewById(R.id.ndh) : null;
    }
}
