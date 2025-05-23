package com.tencent.gdtad.basics.motivevideo.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveHippyParams;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.hippy.i;
import com.tencent.gdtad.config.data.h;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtAnalysisHelperForMotiveAd {
    private static gdt_analysis_event b(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, long j3, boolean z16) {
        if (gdtMotiveVideoPageData == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[createEvent] null data");
            return null;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData));
        createEventForAd.duration = j3;
        createEventForAd.actionId = gdtMotiveVideoPageData.playType;
        createEventForAd.status1 = gdtMotiveVideoPageData.renderType;
        int i16 = 1;
        createEventForAd.status2 = !gdtMotiveVideoPageData.enableHippy ? 1 : 0;
        if (gdtMotiveVideoPageData.screenOrientation != 0) {
            i16 = 2;
        }
        createEventForAd.status3 = i16;
        createEventForAd.status4 = gdtMotiveVideoPageData.getType();
        createEventForAd.status5 = z16 ? 1 : 0;
        GdtMotiveHippyParams gdtMotiveHippyParams = gdtMotiveVideoPageData.hippyParams;
        if (gdtMotiveHippyParams != null) {
            createEventForAd.api = gdtMotiveHippyParams.getCurrentJsBundleVersion();
            createEventForAd.carrierCode = gdtMotiveVideoPageData.hippyParams.getTemplateId();
        }
        return createEventForAd;
    }

    public static void c(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, int i16, boolean z16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_CLOSE, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, z16);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForClose] error, event is null");
        } else {
            if (gdtMotiveVideoPageData == null) {
                GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForClose] null data");
                return;
            }
            b16.internalErrorCode = i3;
            b16.errorCode1 = i16;
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void d(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, boolean z16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, 1301, j3, z16);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForCreateViewSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    private static void e(Context context, GdtAd gdtAd) {
        int i3;
        int i16 = 103;
        if (gdtAd == null) {
            i3 = gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITHOUT_GDTAD;
        } else if (TextUtils.isEmpty(gdtAd.getExtJSON())) {
            i3 = gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITHOUT_EXT_JSON;
        } else {
            i3 = gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITH_EXT_JSON;
            i16 = 102;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(context, i3, gdtAd), i16));
    }

    public static void f(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, int i3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, 1306, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyCheckParamsFailed] error, event is null");
        } else {
            b16.internalErrorCode = i3;
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void g(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_CHECK_PARAMS_SUCCESS, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyCheckParamsSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void h(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, int i3, int i16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_CREATE_VIEW_FAILED, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyCreateViewFailed] error, event is null");
            return;
        }
        b16.internalErrorCode = i3;
        b16.errorCode1 = i16;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
    }

    public static void i(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, int i3, int i16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_INITIALIZE_ENGINE_FAILED, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyInitializeEngineFailed] error, event is null");
            return;
        }
        b16.internalErrorCode = i3;
        b16.errorCode1 = i16;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
    }

    public static void j(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, 1307, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyInitializeEngineSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void k(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, int i3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_LOAD_HIPPY_FAILED, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyLoadFailed] error, event is null");
        } else {
            b16.internalErrorCode = i3;
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void l(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, int i3, int i16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_LOAD_JS_BUNDLE_FAILED, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyLoadJSBundleFailed] error, event is null");
            return;
        }
        b16.internalErrorCode = i3;
        b16.errorCode1 = i16;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
    }

    public static void m(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_LOAD_JS_BUNDLE_SUCCESS, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyLoadJSBundleSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void n(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, 1313, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyLoadSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    public static void o(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_SHOW_VIEW_SUCCESS, j3, true);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyShowSuccess] error, event is null");
        } else {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
        }
    }

    private static void p(final Context context, final GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAnalysisHelperForMotiveAd.q(context, gdtMotiveVideoPageData);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        int i3;
        if (gdtMotiveVideoPageData == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForHippyTemplateOnNetworkThread] null data");
            return;
        }
        h i16 = wm0.b.m().i();
        if (i16 == null) {
            QLog.i("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread] do nothing, config is null");
            return;
        }
        String[] strArr = i16.templateIdList;
        if (strArr == null) {
            QLog.i("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread] do nothing, config.templateIdList is null");
            return;
        }
        if (strArr.length <= 0) {
            QLog.i("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread] do nothing, config.templateIdList is empty");
            return;
        }
        try {
            QLog.i("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread] config:" + i16);
        } catch (Throwable th5) {
            QLog.e("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread]", th5);
        }
        for (String str : i16.templateIdList) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("GdtAnalysisHelperForMotiveAd", 1, "[reportForHippyTemplateOnNetworkThread] error, templateId is empty");
            } else {
                gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
                AdAnalysisUtil.initEvent(BaseApplication.getContext(), 200010, gdt_analysis_eventVar);
                gdt_analysis_eventVar.carrierCode = str;
                gdt_analysis_eventVar.status2 = !gdtMotiveVideoPageData.enableHippy ? 1 : 0;
                if (gdtMotiveVideoPageData.screenOrientation == 0) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                gdt_analysis_eventVar.status3 = i3;
                boolean exists = TemplateManager.getInstance().getTemplateFileWithoutLastModifiedUpdated(str).exists();
                gdt_analysis_eventVar.status5 = exists ? 1 : 0;
                AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
                if (gdtMotiveVideoPageData.enableHippy) {
                    a.f("GdtAnalysisHelperForMotiveAd", "[reportForHippyTemplateOnNetworkThread] templateId:" + str + " exists:" + exists, null, exists, AdMetricID.Reward.TEMPLATE_ITEM_EXISTS, AdMetricID.Reward.TEMPLATE_ITEM_NOT_EXISTS, gdtMotiveVideoPageData, null);
                }
            }
        }
    }

    public static void r(Context context) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(BaseApplication.getContext(), gdt_analysis_event.EVENT_MOTIVE_HIPPY_WEB_VIEW_DISPLAYED, gdt_analysis_eventVar);
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
    }

    public static void s(Context context, int i3) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(BaseApplication.getContext(), gdt_analysis_event.EVENT_MOTIVE_HIPPY_WEB_VIEW_START_ACTIVITY, gdt_analysis_eventVar);
        gdt_analysis_eventVar.urlType = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
    }

    public static void t(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        GdtAd parseGdtAdFromString = GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData);
        v(context, gdtMotiveVideoPageData, parseGdtAdFromString);
        p(context, gdtMotiveVideoPageData);
        e(context, parseGdtAdFromString);
    }

    public static void u(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, long j3, boolean z16) {
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, 1317, j3, z16);
        gdt_analysis_event b17 = b(context, gdtMotiveVideoPageData, 1318, j3, z16);
        if (b16 != null && b17 != null) {
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
            if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b17, 103));
                return;
            }
            return;
        }
        GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForMotiveVideoFirstFrameRendered] error, event is null");
    }

    private static void v(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, GdtAd gdtAd) {
        int i3;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1055, gdtAd);
        if (gdtMotiveVideoPageData == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForShow] null data");
            return;
        }
        if (gdtMotiveVideoPageData.getType() == Integer.MIN_VALUE) {
            createEventForAd.internalErrorCode = 4;
            i3 = 101;
        } else {
            createEventForAd.internalErrorCode = 0;
            i3 = 103;
        }
        createEventForAd.api = i.L();
        createEventForAd.actionId = gdtMotiveVideoPageData.playType;
        createEventForAd.status1 = gdtMotiveVideoPageData.renderType;
        int i16 = 1;
        createEventForAd.status2 = !gdtMotiveVideoPageData.enableHippy ? 1 : 0;
        if (gdtMotiveVideoPageData.screenOrientation != 0) {
            i16 = 2;
        }
        createEventForAd.status3 = i16;
        createEventForAd.status4 = gdtMotiveVideoPageData.getType();
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void w(Context context, GdtMotiveVideoPageData gdtMotiveVideoPageData, boolean z16, boolean z17) {
        int i3;
        gdt_analysis_event b16 = b(context, gdtMotiveVideoPageData, gdt_analysis_event.EVENT_MOTIVE_HIPPY_USE_DIALOG, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, z16);
        if (b16 == null) {
            GdtLog.e("GdtAnalysisHelperForMotiveAd", "[reportForStartDialog] error, event is null");
            return;
        }
        if (z17) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        b16.errorCode1 = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(b16, 103));
    }
}
