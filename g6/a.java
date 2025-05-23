package g6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.reporter.GdtCarouselCardReporterForQzone;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.views.AdUISettings;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: g6.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static /* synthetic */ class C10356a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f401407a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            f401407a = iArr;
            try {
                iArr[FeedElement.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f401407a[FeedElement.NOTHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f401407a[FeedElement.SUMMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f401407a[FeedElement.RECOMMAD_ACTION_STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f401407a[FeedElement.ACTION_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f401407a[FeedElement.FEEDBACK_LEFT_TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f401407a[FeedElement.HOT_STAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f401407a[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f401407a[FeedElement.RECOMM_ACTION_LEFT_TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f401407a[FeedElement.AUTO_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f401407a[FeedElement.GDT_DANMAKU_AD_COMPONENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f401407a[FeedElement.DROPDOWN_BUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f401407a[FeedElement.DETAIL_BOTTOM_AD_FEED_BACK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f401407a[FeedElement.GESTURE_AD_VIEW.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f401407a[FeedElement.DETAIL_BOTTOM_AD_EXPOSURE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f401407a[FeedElement.GDT_CAROUSEL_CARD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f401407a[FeedElement.GDT_ACTION_SHAKE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f401407a[FeedElement.GDT_MDPA_AD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f401408a;

        /* renamed from: b, reason: collision with root package name */
        public BusinessFeedData f401409b;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<AdFeedbackDialogFragment.Listener> f401413f;

        /* renamed from: g, reason: collision with root package name */
        public WeakReference<View> f401414g;

        /* renamed from: i, reason: collision with root package name */
        public String f401416i;

        /* renamed from: c, reason: collision with root package name */
        public int f401410c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f401411d = Integer.MIN_VALUE;

        /* renamed from: e, reason: collision with root package name */
        public FeedElement f401412e = FeedElement.OTHER;

        /* renamed from: h, reason: collision with root package name */
        public long f401415h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        public boolean a() {
            BusinessFeedData businessFeedData = this.f401409b;
            return (businessFeedData == null || !businessFeedData.isGDTAdvFeed() || this.f401408a == null) ? false : true;
        }
    }

    public static void g(b bVar) {
        GdtLog.i("GdtClickHandlerForQzone", "[handle] ---------click start---------");
        if (bVar != null && bVar.a()) {
            GdtHandler.Params e16 = e(bVar);
            if (e16 == null) {
                GdtLog.e("GdtClickHandlerForQzone", "[handle] gdtParams is null");
                return;
            }
            int i3 = e16.componentID;
            GdtLog.i("GdtClickHandlerForQzone", "[handle] click-areaId: " + i3);
            GdtLog.i("GdtClickHandlerForQzone", "[handle] sceneId = " + bVar.f401410c);
            int i16 = bVar.f401410c;
            if (i16 == 0) {
                i(bVar, e16, i3);
            } else if (i16 == 2) {
                h(bVar, e16, i3);
            } else if (i16 != 8) {
                AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handle::unknown scene", "");
                GdtLog.i("GdtClickHandlerForQzone", "[handle] cannot recognize this scene" + bVar.f401410c);
            } else {
                j(bVar, e16, i3);
            }
            GdtLog.i("GdtClickHandlerForQzone", "[handle] ---------click end---------");
            return;
        }
        GdtLog.e("GdtClickHandlerForQzone", "[handle] error : param is null or it is not an ad");
    }

    private static void i(b bVar, GdtHandler.Params params, int i3) {
        if (bVar != null && bVar.a()) {
            WeakReference<View> weakReference = bVar.f401414g;
            BaseVideo n3 = GdtFeedUtilForQZone.n(weakReference != null ? weakReference.get() : null);
            if (l(n3, i3) && !QZoneAdFeedDataExtKt.isGdt185AdVideo(bVar.f401409b)) {
                m(n3);
                return;
            }
            params.startActivityRequestCode = MaskAdConstants.MASK_AD_ACTIVITY_RESULT_CODE;
            GdtLog.i("GdtClickHandlerForQzone", "[handleClickForFeedScene] can handle" + i3);
            boolean z16 = false;
            if (i3 != Integer.MIN_VALUE) {
                if (i3 != 5) {
                    if (i3 != 2001) {
                        if (bVar.f401409b.isVideo()) {
                            c(bVar, params);
                        }
                        if (GdtAdFeedUtil.isCarouselCard(bVar.f401409b)) {
                            a(bVar, params);
                        }
                        if (QZoneAdFeedDataExtKt.isMDPAFeedData(bVar.f401409b)) {
                            b(bVar, params);
                        }
                        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                    } else {
                        k(bVar, params);
                    }
                } else if (!GdtAdFeedUtil.isPanoramaAd(bVar.f401409b)) {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                }
                z16 = true;
            } else {
                AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForFeedScene::ERROR", "");
            }
            if (z16) {
                vo.b.m(true, bVar.f401409b);
                return;
            }
            return;
        }
        GdtLog.i("GdtClickHandlerForQzone", "[handleClickForFeedScene] params is not valid");
    }

    private static void k(b bVar, GdtHandler.Params params) {
        if (bVar != null && bVar.a() && params != null) {
            GdtLog.i("GdtClickHandlerForQzone", "[handleCloseArea] handle feedback button");
            AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
            adFeedbackParams.activity = bVar.f401408a;
            adFeedbackParams.listener = bVar.f401413f;
            adFeedbackParams.f61346ad = params.f108486ad;
            adFeedbackParams.styleId = 0;
            adFeedbackParams.isDarkMode = AdUISettings.getInstance().isNightMode();
            adFeedbackParams.shouldShowCancelButton = false;
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                return;
            } catch (Throwable th5) {
                QLog.e("GdtClickHandlerForQzone", 1, "[handleCloseArea]", th5);
                return;
            }
        }
        GdtLog.i("GdtClickHandlerForQzone", "[handleCloseArea] params or gdtParams are null");
    }

    private static void m(BaseVideo baseVideo) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(baseVideo);
        BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(linkedList);
    }

    private static void a(b bVar, GdtHandler.Params params) {
        if (bVar != null && bVar.a() && params != null) {
            QZoneAdFeedData adData = bVar.f401409b.getAdData();
            int i3 = params.componentID;
            if (i3 == 2 || i3 == 3 || i3 == 4) {
                GdtCarouselCardReporterForQzone.reportForActionType(bVar.f401409b, adData.getCarouselCardFirstVisibleItemPosition(), "2");
            } else if (i3 == 64) {
                GdtCarouselCardReporterForQzone.reportForActionType(bVar.f401409b, adData.getCarouselCardClickedOrManuallyScrolledItemPosition(), "2");
                params.indexOfCarouselAd = adData.getCarouselCardClickedOrManuallyScrolledItemPosition();
            }
            params.videoCeilingSupportedIfNotInstalled = true;
            params.directPlay = QZoneAdFeedDataExtKt.isAdLandingPageVideoNeedAutoPlay(bVar.f401409b);
            return;
        }
        GdtLog.i("GdtClickHandlerForQzone", "[adjustParamsForCarouselCard] params or gdtParams are null");
    }

    private static void b(b bVar, GdtHandler.Params params) {
        if (bVar != null && bVar.a() && params != null) {
            if (params.componentID == 10028) {
                params.indexOfMDPA = bVar.f401409b.getAdData().getMDPAClickItemPosition();
                return;
            }
            return;
        }
        GdtLog.i("GdtClickHandlerForQzone", "[adjustParamsForMDPAAd] params or gdtParams are null");
    }

    private static void c(b bVar, GdtHandler.Params params) {
        if (bVar != null && bVar.a() && params != null) {
            params.videoCeilingSupportedIfNotInstalled = true;
            params.directPlay = QZoneAdFeedDataExtKt.isAdLandingPageVideoNeedAutoPlay(bVar.f401409b);
        } else {
            GdtLog.i("GdtClickHandlerForQzone", "[adjustParamsForVideoAd] params or gdtParams are null");
        }
    }

    public static boolean d(b bVar) {
        if (bVar != null) {
            bVar.f401408a = new WeakReference<>(Foreground.getTopActivity());
        }
        GdtHandler.Params e16 = e(bVar);
        if (e16 == null) {
            GdtLog.e("GdtClickHandlerForQzone", "[canLaunchApp] gdtParams is null");
            return false;
        }
        return GdtHandler.canLaunchApp(e16);
    }

    private static GdtHandler.Params e(b bVar) {
        if (bVar == null || !bVar.a()) {
            return null;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        int i3 = bVar.f401411d;
        if (i3 == Integer.MIN_VALUE) {
            i3 = f(bVar.f401412e);
        }
        params.activity = bVar.f401408a;
        params.f108486ad = new GdtAd(GdtFeedUtilForQZone.f(bVar.f401409b));
        params.sceneID = bVar.f401410c;
        params.componentID = i3;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        params.antiSpamParams = bVar.f401416i;
        params.videoStartPositionMillis = bVar.f401415h;
        return params;
    }

    private static int f(FeedElement feedElement) {
        if (feedElement == null) {
            GdtLog.i("GdtClickHandlerForQzone", "[getMappedAreaId] element is null");
            return Integer.MIN_VALUE;
        }
        GdtLog.i("GdtClickHandlerForQzone", "[getMappedAreaId] original click-element: " + feedElement);
        switch (C10356a.f401407a[feedElement.ordinal()]) {
            case 1:
                return 5;
            case 2:
                return 1000;
            case 3:
                return 4;
            case 4:
                return 20;
            case 5:
                return 8;
            case 6:
                return 3;
            case 7:
                return 2;
            case 8:
                return 31;
            case 9:
                return 7;
            case 10:
                return 6;
            case 11:
                return 53;
            case 12:
            case 13:
                return 2001;
            case 14:
                return 35;
            case 15:
                return 2002;
            case 16:
                return 64;
            case 17:
                return 80;
            case 18:
                return 10028;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private static void h(b bVar, GdtHandler.Params params, int i3) {
        if (bVar == null || !bVar.a()) {
            GdtLog.i("GdtClickHandlerForQzone", "[handleClickForDetailScene] params is not valid");
            return;
        }
        if (i3 == Integer.MIN_VALUE) {
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForDetailScene::ERROR", "");
            return;
        }
        if (i3 != 31) {
            if (i3 == 2001 || i3 == 2002 || bVar.f401412e == null) {
                return;
            }
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForDetailScene::" + bVar.f401412e, "");
            return;
        }
        vo.b.m(true, bVar.f401409b);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
    }

    private static void j(b bVar, GdtHandler.Params params, int i3) {
        if (bVar == null || !bVar.a()) {
            GdtLog.i("GdtClickHandlerForQzone", "[handleClickForVerticalVideoScene] params is not valid");
            return;
        }
        if (i3 == Integer.MIN_VALUE) {
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForVerticalVideoScene::ERROR", "");
        } else if (i3 != 2001) {
            vo.b.m(true, bVar.f401409b);
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } else {
            k(bVar, params);
        }
    }

    private static boolean l(BaseVideo baseVideo, int i3) {
        if (baseVideo == null || baseVideo.getState() == 3) {
            return false;
        }
        if (i3 == 6) {
            return true;
        }
        if (i3 == 64 && (baseVideo instanceof FeedAutoVideo)) {
            return ((FeedAutoVideo) baseVideo).isValidVideo();
        }
        return false;
    }
}
