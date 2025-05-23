package g6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.event.ad.QZoneAdClickEvent;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.AdUISettings;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002JF\u0010\u001b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019JH\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010$\u001a\u00020 8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lg6/c;", "", "Lg6/c$a;", "params", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "c", "gdtParams", "", "areaId", "", "i", "k", "j", "Lcom/qzone/proxy/feedcomponent/ui/FeedElement;", DTConstants.TAG.ELEMENT, "d", "b", "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "view", "Lyd/a;", "data", "position", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "listener", "g", WadlProxyConsts.SCENE_ID, "adFeedData", "e", h.F, "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f401419a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZoneAdProClickHandler";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001a\u0010\u001f\"\u0004\b \u0010!R*\u0010'\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR*\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010-\u001a\u0004\b$\u0010.\"\u0004\b/\u00100R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\f\u00105\"\u0004\b6\u00107R\u0011\u0010;\u001a\u0002098F\u00a2\u0006\u0006\u001a\u0004\b3\u0010:\u00a8\u0006>"}, d2 = {"Lg6/c$a;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "a", "Ljava/lang/ref/WeakReference;", "g", "()Ljava/lang/ref/WeakReference;", "o", "(Ljava/lang/ref/WeakReference;)V", "weakActivity", "Lyd/a;", "b", "Lyd/a;", "()Lyd/a;", "j", "(Lyd/a;)V", "adFeedData", "", "c", "I", "e", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", WadlProxyConsts.SCENE_ID, "d", "k", "areaId", "Lcom/qzone/proxy/feedcomponent/ui/FeedElement;", "Lcom/qzone/proxy/feedcomponent/ui/FeedElement;", "()Lcom/qzone/proxy/feedcomponent/ui/FeedElement;", "l", "(Lcom/qzone/proxy/feedcomponent/ui/FeedElement;)V", DTConstants.TAG.ELEMENT, "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "f", h.F, "p", "weakFeedbackListener", "Landroid/view/View;", "getWeakView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "weakView", "", "J", "()J", DomainData.DOMAIN_NAME, "(J)V", "videoStartPositionMillis", "", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "setAntiSpamParams", "(Ljava/lang/String;)V", "antiSpamParams", "", "()Z", AppConstants.Key.COLUMN_IS_VALID, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private WeakReference<Activity> weakActivity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private yd.a adFeedData;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private WeakReference<AdFeedbackDialogFragment.Listener> weakFeedbackListener;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private WeakReference<View> weakView;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private String antiSpamParams;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int sceneId = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int areaId = Integer.MIN_VALUE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private FeedElement element = FeedElement.OTHER;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long videoStartPositionMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        /* renamed from: a, reason: from getter */
        public final yd.a getAdFeedData() {
            return this.adFeedData;
        }

        /* renamed from: b, reason: from getter */
        public final String getAntiSpamParams() {
            return this.antiSpamParams;
        }

        /* renamed from: c, reason: from getter */
        public final int getAreaId() {
            return this.areaId;
        }

        /* renamed from: d, reason: from getter */
        public final FeedElement getElement() {
            return this.element;
        }

        /* renamed from: e, reason: from getter */
        public final int getSceneId() {
            return this.sceneId;
        }

        /* renamed from: f, reason: from getter */
        public final long getVideoStartPositionMillis() {
            return this.videoStartPositionMillis;
        }

        public final WeakReference<Activity> g() {
            return this.weakActivity;
        }

        public final WeakReference<AdFeedbackDialogFragment.Listener> h() {
            return this.weakFeedbackListener;
        }

        public final boolean i() {
            GdtAd gdtAd;
            yd.a aVar = this.adFeedData;
            return (aVar == null || (gdtAd = aVar.getGdtAd()) == null || !gdtAd.isValid()) ? false : true;
        }

        public final void j(yd.a aVar) {
            this.adFeedData = aVar;
        }

        public final void k(int i3) {
            this.areaId = i3;
        }

        public final void l(FeedElement feedElement) {
            this.element = feedElement;
        }

        public final void m(int i3) {
            this.sceneId = i3;
        }

        public final void n(long j3) {
            this.videoStartPositionMillis = j3;
        }

        public final void o(WeakReference<Activity> weakReference) {
            this.weakActivity = weakReference;
        }

        public final void p(WeakReference<AdFeedbackDialogFragment.Listener> weakReference) {
            this.weakFeedbackListener = weakReference;
        }

        public final void q(WeakReference<View> weakReference) {
            this.weakView = weakReference;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401430a;

        static {
            int[] iArr = new int[FeedElement.values().length];
            try {
                iArr[FeedElement.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedElement.NOTHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeedElement.SUMMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeedElement.RECOMMAD_ACTION_STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FeedElement.ACTION_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FeedElement.FEEDBACK_LEFT_TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FeedElement.HOT_STAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FeedElement.RECOMM_ACTION_LEFT_TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FeedElement.AUTO_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FeedElement.GDT_DANMAKU_AD_COMPONENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FeedElement.DROPDOWN_BUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FeedElement.DETAIL_BOTTOM_AD_FEED_BACK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FeedElement.GESTURE_AD_VIEW.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FeedElement.DETAIL_BOTTOM_AD_EXPOSURE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[FeedElement.GDT_CAROUSEL_CARD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[FeedElement.GDT_ACTION_SHAKE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[FeedElement.GDT_MDPA_AD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            f401430a = iArr;
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(yd.a adFeedData, int i3, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(adFeedData, "$adFeedData");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "onExposure");
        }
        qe.a.f428878a.a(adFeedData, i3);
    }

    public final void e(int sceneId, Activity activity, View view, final yd.a adFeedData, FeedElement element, int areaId, final int position, AdFeedbackDialogFragment.Listener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adFeedData, "adFeedData");
        Intrinsics.checkNotNullParameter(element, "element");
        a aVar = new a();
        aVar.k(areaId);
        aVar.m(sceneId);
        aVar.o(new WeakReference<>(activity));
        aVar.p(new WeakReference<>(listener));
        aVar.l(element);
        aVar.q(new WeakReference<>(view));
        aVar.j(adFeedData);
        Long l3 = qe.b.f428879a.a().get(yd.b.l(adFeedData));
        if (l3 != null) {
            aVar.n(l3.longValue());
        }
        h(aVar);
        qe.a.f428878a.f(adFeedData, "", position);
        GdtAd gdtAd = adFeedData.getGdtAd();
        AdExposureChecker.onClick(view.getContext(), gdtAd, new WeakReference(new AdExposureChecker.ExposureCallback() { // from class: g6.b
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                c.f(yd.a.this, position, weakReference);
            }
        }));
        SimpleEventBus.getInstance().dispatchEvent(new QZoneAdClickEvent(gdtAd, areaId));
    }

    public final void g(Activity activity, View view, yd.a data, FeedElement element, int areaId, int position, AdFeedbackDialogFragment.Listener listener) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (activity == null || view == null || data == null) {
            return;
        }
        e(0, activity, view, data, element, areaId, position, listener);
    }

    public final void h(a params) {
        String str = TAG;
        GdtLog.i(str, "[handle] ---------click start---------");
        if (params != null && params.i()) {
            GdtHandler.Params c16 = c(params);
            if (c16 == null) {
                GdtLog.e(str, "[handle] gdtParams is null");
                return;
            }
            int i3 = c16.componentID;
            GdtLog.i(str, "[handle] click-areaId: " + i3);
            GdtLog.i(str, "[handle] sceneId = " + params.getSceneId());
            int sceneId = params.getSceneId();
            if (sceneId == 0) {
                j(params, c16, i3);
            } else if (sceneId == 2) {
                i(params, c16, i3);
            } else if (sceneId != 8) {
                AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handle::unknown scene", "");
                GdtLog.i(str, "[handle] cannot recognize this scene" + params.getSceneId());
            } else {
                k(params, c16, i3);
            }
            GdtLog.i(str, "[handle] ---------click end---------");
            return;
        }
        GdtLog.e(str, "[handle] error : param is null or it is not an ad");
    }

    private final void b(a params, GdtHandler.Params gdtParams) {
        if (params != null && params.i() && gdtParams != null) {
            gdtParams.videoCeilingSupportedIfNotInstalled = true;
            gdtParams.directPlay = false;
        } else {
            GdtLog.i(TAG, "[adjustParamsForVideoAd] params or gdtParams are null");
        }
    }

    private final void i(a params, GdtHandler.Params gdtParams, int areaId) {
        if (params == null || !params.i()) {
            GdtLog.i(TAG, "[handleClickForDetailScene] params is not valid");
            return;
        }
        if (areaId == Integer.MIN_VALUE) {
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForDetailScene::ERROR", "");
            return;
        }
        if (areaId != 31) {
            if (areaId == 2001 || areaId == 2002 || params.getElement() == null) {
                return;
            }
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForDetailScene::" + params.getElement(), "");
            return;
        }
        qe.a aVar = qe.a.f428878a;
        yd.a adFeedData = params.getAdFeedData();
        aVar.e(true, adFeedData != null ? adFeedData.getGdtAd() : null);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(gdtParams);
    }

    private final void j(a params, GdtHandler.Params gdtParams, int areaId) {
        if (params != null && params.i()) {
            gdtParams.startActivityRequestCode = MaskAdConstants.MASK_AD_ACTIVITY_RESULT_CODE;
            GdtLog.i(TAG, "[handleClickForFeedScene] can handle" + areaId);
            boolean z16 = false;
            if (areaId != Integer.MIN_VALUE) {
                if (areaId == 5) {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(gdtParams);
                } else if (areaId != 2001) {
                    if (qe.b.f428879a.g(yd.b.h(params.getAdFeedData()))) {
                        b(params, gdtParams);
                    }
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(gdtParams);
                } else {
                    l(params, gdtParams);
                }
                z16 = true;
            } else {
                AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForFeedScene::ERROR", "");
            }
            if (z16) {
                qe.a aVar = qe.a.f428878a;
                yd.a adFeedData = params.getAdFeedData();
                aVar.e(true, adFeedData != null ? adFeedData.getGdtAd() : null);
                return;
            }
            return;
        }
        GdtLog.i(TAG, "[handleClickForFeedScene] params is not valid");
    }

    private final void k(a params, GdtHandler.Params gdtParams, int areaId) {
        if (params == null || !params.i()) {
            GdtLog.i(TAG, "[handleClickForVerticalVideoScene] params is not valid");
            return;
        }
        if (areaId == Integer.MIN_VALUE) {
            AdAnalysisHelperForUtil.reportForAPIInvoked((Context) null, false, "GdtClickHandlerForQzone::handleClickForVerticalVideoScene::ERROR", "");
            return;
        }
        if (areaId != 2001) {
            qe.a aVar = qe.a.f428878a;
            yd.a adFeedData = params.getAdFeedData();
            aVar.e(true, adFeedData != null ? adFeedData.getGdtAd() : null);
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(gdtParams);
            return;
        }
        l(params, gdtParams);
    }

    private final void l(a params, GdtHandler.Params gdtParams) {
        if (params != null && params.i() && gdtParams != null) {
            GdtLog.i(TAG, "[handleCloseArea] handle feedback button");
            AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
            adFeedbackParams.activity = params.g();
            adFeedbackParams.listener = params.h();
            adFeedbackParams.f61346ad = gdtParams.f108486ad;
            adFeedbackParams.styleId = 0;
            adFeedbackParams.isDarkMode = AdUISettings.getInstance().isNightMode();
            adFeedbackParams.shouldShowCancelButton = false;
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[handleCloseArea]", th5);
                return;
            }
        }
        GdtLog.i(TAG, "[handleCloseArea] params or gdtParams are null");
    }

    private final GdtHandler.Params c(a params) {
        if (params == null || !params.i()) {
            return null;
        }
        GdtHandler.Params params2 = new GdtHandler.Params();
        int areaId = params.getAreaId();
        if (areaId == Integer.MIN_VALUE) {
            areaId = d(params.getElement());
        }
        params2.activity = params.g();
        yd.a adFeedData = params.getAdFeedData();
        params2.f108486ad = adFeedData != null ? adFeedData.getGdtAd() : null;
        params2.sceneID = params.getSceneId();
        params2.componentID = areaId;
        Bundle bundle = new Bundle();
        params2.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        params2.antiSpamParams = params.getAntiSpamParams();
        params2.videoStartPositionMillis = params.getVideoStartPositionMillis();
        return params2;
    }

    private final int d(FeedElement element) {
        if (element == null) {
            GdtLog.i(TAG, "[getMappedAreaId] element is null");
            return Integer.MIN_VALUE;
        }
        GdtLog.i(TAG, "[getMappedAreaId] original click-element: " + element);
        switch (b.f401430a[element.ordinal()]) {
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
}
