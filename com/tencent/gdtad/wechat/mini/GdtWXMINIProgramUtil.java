package com.tencent.gdtad.wechat.mini;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import bn0.b;
import bn0.c;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ad.tangram.util.AdWXMINIProgramClickHandler;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.wechat.mini.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public final class GdtWXMINIProgramUtil {
    public static boolean b(WeakReference<Activity> weakReference, Bundle bundle, String str) {
        Activity activity;
        int i3;
        int i16;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i17;
        c cVar;
        b bVar;
        c cVar2;
        c cVar3;
        String str12 = null;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramUtil", 1, "[handleOpenUrl]", th5);
        }
        a.C1173a b16 = a.b(str);
        if (b16 != null) {
            i3 = b16.f109798b;
        } else {
            i3 = 1;
        }
        if (b16 != null) {
            i16 = b16.f109799c;
        } else {
            i16 = Integer.MIN_VALUE;
        }
        if (b16 != null && (cVar3 = b16.f109797a) != null) {
            str2 = cVar3.f28680a;
        } else {
            str2 = null;
        }
        if (b16 != null && (cVar2 = b16.f109797a) != null) {
            str3 = cVar2.f28681b;
        } else {
            str3 = null;
        }
        if (b16 != null && (cVar = b16.f109797a) != null && (bVar = cVar.f28682c) != null) {
            str12 = bVar.sdkVersion;
        }
        if (b16 != null && (b16.b() || b16.c())) {
            QLog.i("GdtWXMINIProgramUtil", 1, "[handleOpenUrl] parse success, activity:" + activity + " scheme:" + str2 + " authority:" + str3 + " url:" + str);
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(600000L).setTagSet(AdMetricTag.JS_BUNDLE_VERSION, str12).setTagSet(AdMetricTag.URI_SCHEME, str2).setTagSet(AdMetricTag.URI_AUTHORITY, str3));
            str4 = str;
            str5 = " url:";
            str8 = " authority:";
            str9 = AdMetricTag.ERROR_CODE;
            str6 = "GdtWXMINIProgramUtil";
            str7 = "scheme:";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleOpenUrl] error, parse failed, activity:");
            sb5.append(activity);
            sb5.append(" parseErrorCode:");
            sb5.append(i3);
            sb5.append("parseDetailErrorCode:");
            sb5.append(i16);
            sb5.append("scheme:");
            sb5.append(str2);
            sb5.append(" authority:");
            sb5.append(str3);
            sb5.append(" url:");
            str4 = str;
            sb5.append(str4);
            str5 = " url:";
            str6 = "GdtWXMINIProgramUtil";
            str7 = "scheme:";
            QLog.e(str6, 1, sb5.toString());
            str8 = " authority:";
            IAdMetric tagSet = AdMetricService.getInstance().build(AdMetricID.WXMINIProgram.PrivateOpenUrl.PARSE_FAILED).setTagSet(AdMetricTag.JS_BUNDLE_VERSION, str12).setTagSet(AdMetricTag.URI_SCHEME, str2).setTagSet(AdMetricTag.URI_AUTHORITY, str3);
            String valueOf = String.valueOf(i3);
            str9 = AdMetricTag.ERROR_CODE;
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), tagSet.setTagSet(str9, valueOf).setTagSet(AdMetricTag.WXMINIProgram.ERROR_CODE_PRIVATE_OPEN_URL_PARSE, String.valueOf(i16)));
        }
        if (b16 != null && b16.b()) {
            c cVar4 = b16.f109797a;
            str10 = AdMetricTag.JS_BUNDLE_VERSION;
            str11 = str5;
            i17 = c(weakReference, bundle, cVar4);
        } else {
            str10 = AdMetricTag.JS_BUNDLE_VERSION;
            str11 = str5;
            if (b16 != null && b16.c()) {
                i17 = d(weakReference, bundle, b16.f109797a);
            } else {
                i17 = Integer.MIN_VALUE;
            }
        }
        if (i17 == 0) {
            QLog.i(str6, 1, "[handleOpenUrl] handle success, activity:" + activity + " scheme:" + str2 + str8 + str3 + str11 + str4);
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(AdMetricID.WXMINIProgram.PrivateOpenUrl.HANDLE_SUCCESS).setTagSet(str10, str12).setTagSet(AdMetricTag.URI_SCHEME, str2).setTagSet(AdMetricTag.URI_AUTHORITY, str3));
        } else {
            String str13 = str8;
            if (i17 != Integer.MIN_VALUE) {
                QLog.e(str6, 1, "[handlePrivateOpenUrl] error, handle failed, activity:" + activity + " handleErrorCode:" + i17 + str7 + str2 + str13 + str3 + str11 + str4);
                AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(AdMetricID.WXMINIProgram.PrivateOpenUrl.HANDLE_FAILED).setTagSet(str10, str12).setTagSet(AdMetricTag.URI_SCHEME, str2).setTagSet(AdMetricTag.URI_AUTHORITY, str3).setTagSet(str9, String.valueOf(i17)));
            }
        }
        AdMetricService.getInstance().flush(new WeakReference<>(BaseApplication.getContext()));
        if (b16 != null && b16.a()) {
            return true;
        }
        return false;
    }

    private static int c(WeakReference<Activity> weakReference, Bundle bundle, c cVar) {
        Activity activity;
        long j3;
        b.a aVar;
        if (cVar != null && cVar.b()) {
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            bn0.a aVar2 = new bn0.a(cVar.f28684e);
            QLog.i("GdtWXMINIProgramUtil", 1, "[handleOpenUrlForClick] activity:" + activity + " posId:" + aVar2.getPosId() + " aid:" + aVar2.getAId() + " traceId:" + aVar2.getTraceId());
            AdWXMINIProgramClickHandler.Params params = new AdWXMINIProgramClickHandler.Params();
            params.activity = weakReference;
            params.reportForClick = false;
            b bVar = cVar.f28682c;
            if (bVar != null && (aVar = bVar.clickInfo) != null) {
                j3 = aVar.clickTimeMillis;
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            params.clickStartTimeMillis = j3;
            params.f61334ad = aVar2;
            params.extrasForIntent = new Bundle();
            if (bundle != null && !bundle.isEmpty()) {
                params.extrasForIntent.putAll(bundle);
            }
            params.extrasForIntent.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            params.browserForcePortrait = true;
            AdWXMINIProgramClickHandler.Result handle = AdWXMINIProgramClickHandler.handle(params);
            if (handle == null) {
                return 1;
            }
            return handle.getErrorCode();
        }
        QLog.i("GdtWXMINIProgramUtil", 1, "[handleOpenUrlForClick] error, not valid");
        return 1;
    }

    private static int d(WeakReference<Activity> weakReference, Bundle bundle, c cVar) {
        Activity activity;
        if (cVar != null && cVar.c()) {
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            bn0.a aVar = new bn0.a(cVar.f28684e);
            String str = cVar.f28683d.url;
            QLog.i("GdtWXMINIProgramUtil", 1, "[handleOpenUrlForWebPage] activity:" + activity + " posId:" + aVar.getPosId() + " aid:" + aVar.getAId() + " traceId:" + aVar.getTraceId() + " url:" + str);
            Bundle bundle2 = new Bundle();
            if (bundle != null && !bundle.isEmpty()) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            AdBrowser.Params params = new AdBrowser.Params();
            params.activity = weakReference;
            params.url = str;
            params.extrasForIntent = bundle2;
            AdError showWithoutAd = AdBrowser.getInstance().showWithoutAd(params);
            if (showWithoutAd == null) {
                return 1;
            }
            return showWithoutAd.getErrorCode();
        }
        QLog.i("GdtWXMINIProgramUtil", 1, "[handleOpenUrlForWebPage] error, not valid");
        return 1;
    }

    public static void e(final WeakReference<Context> weakReference) {
        QLog.i("GdtWXMINIProgramUtil", 1, "[updateTuringAIDTicketAsync]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.wechat.mini.GdtWXMINIProgramUtil.1
            @Override // java.lang.Runnable
            public void run() {
                GdtWXMINIProgramUtil.f(weakReference);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(WeakReference<Context> weakReference) {
        Context context;
        Context context2;
        int i3;
        int i16;
        IAdMetric enabled;
        String str = null;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QLog.e("GdtWXMINIProgramUtil", 1, "[updateTuringAIDTicketNotOnMainThread] error, should not on main thread");
            return;
        }
        try {
            com.tencent.mobileqq.turingfd.c.a().e();
        } catch (Throwable th5) {
            QLog.e("GdtWXMINIProgramUtil", 1, "[updateTuringAIDTicketNotOnMainThread]", th5);
        }
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(context2, new InitGdtContextParams());
        } catch (Throwable th6) {
            QLog.e("GdtWXMINIProgramUtil", 1, "[updateTuringAIDTicketNotOnMainThread]", th6);
        }
        AdTAID.Entity entity = AdTAID.getInstance().getEntity(context);
        if (entity != null) {
            str = entity.aidTicket;
        }
        if (entity != null) {
            i3 = entity.errorCodeForAidTicket;
        } else {
            i3 = 1;
        }
        if (entity != null) {
            i16 = entity.originErrorCode;
        } else {
            i16 = Integer.MIN_VALUE;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateTuringAIDTicketNotOnMainThread] aidTicket:");
        sb5.append(!TextUtils.isEmpty(str));
        sb5.append(" errorCode:");
        sb5.append(i3);
        sb5.append(" originErrorCode:");
        sb5.append(i16);
        QLog.i("GdtWXMINIProgramUtil", 1, sb5.toString());
        if (!TextUtils.isEmpty(str)) {
            try {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).updateTuringAIDTicket(str);
                i3 = 0;
            } catch (Throwable th7) {
                QLog.e("GdtWXMINIProgramUtil", 1, "[updateTuringAIDTicketNotOnMainThread]", th7);
                i3 = 15;
            }
        }
        if (i3 == 0) {
            enabled = AdMetricService.getInstance().build(AdMetricID.WXMINIProgram.Device.UPDATE_AID_TICKET_SUCCESS).setEnabled(wm0.b.m().u());
        } else {
            enabled = AdMetricService.getInstance().build(AdMetricID.WXMINIProgram.Device.UPDATE_AID_TICKET_FAILED).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)).setTagSet(AdMetricTag.Turing.ERROR_CODE, String.valueOf(i16)).setEnabled(wm0.b.m().u());
        }
        AdMetricService.getInstance().handle(new WeakReference<>(context2), enabled);
    }
}
