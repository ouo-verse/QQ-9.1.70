package com.tencent.gdtad.kuikly.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.kuikly.fragment.a;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public abstract class GdtBaseKuiklyFragmentFallbackIPCHandler implements AdIPCManager.Handler {
    public GdtBaseKuiklyFragmentFallbackIPCHandler() {
        AdIPCManager.getInstance().register(b(), this);
    }

    public int a(Context context, int i3, int i16, String str) {
        if (context == null) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[fallbackByIPC] error, context is null, mAction:" + b() + " errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str);
            return 4;
        }
        if (i16 == Integer.MIN_VALUE) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[fallbackByIPC] error, hashCode is not valid, mAction:" + b() + " errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str);
            return 4;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[fallbackByIPC] error, toProcessName is empty, mAction:" + b() + " errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str);
            return 4;
        }
        if (TextUtils.isEmpty(b())) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[fallbackByIPC] error, mAction is empty, mAction:" + b() + " errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str);
            return 4;
        }
        QLog.i("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[fallbackByIPC] mAction:" + b() + " errorCode:" + i3 + " hashCode:" + i16 + " toProcessName:" + str);
        Bundle bundle = new Bundle();
        bundle.putString(AdIPCManager.Params.KEY_ACTION, b());
        bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, str);
        bundle.putInt("IPC_PARAM_WX_CUSTOMER_SERVICE_ERROR_CODE", i3);
        bundle.putInt("IPC_PARAM_WX_CUSTOMER_SERVICE_HASH_CODE", i16);
        AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle), null);
        return 0;
    }

    protected abstract String b();

    protected abstract a c();

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
    public AdIPCManager.Result handle(AdIPCManager.Params params) {
        final a.d dVar;
        if (params == null) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, params is null");
            return new AdIPCManager.Result();
        }
        if (!params.isValid()) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, params is not valid");
            return new AdIPCManager.Result();
        }
        Bundle bundle = params.bundle;
        if (bundle == null) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, params.bundle is null");
            return new AdIPCManager.Result();
        }
        if (!bundle.containsKey("IPC_PARAM_WX_CUSTOMER_SERVICE_ERROR_CODE")) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, params.bundle do not contains KEY_ERROR_CODE");
            return new AdIPCManager.Result();
        }
        final int i3 = params.bundle.getInt("IPC_PARAM_WX_CUSTOMER_SERVICE_ERROR_CODE");
        if (!params.bundle.containsKey("IPC_PARAM_WX_CUSTOMER_SERVICE_HASH_CODE")) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, params.bundle do not contains KEY_HASH_CODE");
            return new AdIPCManager.Result();
        }
        int i16 = params.bundle.getInt("IPC_PARAM_WX_CUSTOMER_SERVICE_HASH_CODE");
        a c16 = c();
        final a.c cVar = null;
        if (c16 != null) {
            dVar = c16.g(i16);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            cVar = dVar.a();
        }
        if (cVar == null) {
            QLog.e("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] error, processor is null");
            return new AdIPCManager.Result();
        }
        QLog.i("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] errorCode:" + i3 + " hashCode:" + i16);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragmentFallbackIPCHandler.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAd gdtAd;
                String str;
                GdtAd gdtAd2;
                String str2;
                QLog.i("GdtBaseKuiklyFragmentFallbackIPCHandler", 1, "[handle] fallback start, errorCode:" + i3);
                int a16 = cVar.a(dVar, i3);
                long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
                String str3 = null;
                if (a16 == 0) {
                    String str4 = "[handle] fallback success, errorCode:" + i3;
                    a.d dVar2 = dVar;
                    if (dVar2 != null) {
                        gdtAd2 = dVar2.b();
                    } else {
                        gdtAd2 = null;
                    }
                    a.d dVar3 = dVar;
                    if (dVar3 != null) {
                        str2 = dVar3.i();
                    } else {
                        str2 = null;
                    }
                    a.d dVar4 = dVar;
                    if (dVar4 != null) {
                        str3 = dVar4.getPageName();
                    }
                    String str5 = str3;
                    a.d dVar5 = dVar;
                    if (dVar5 != null) {
                        j3 = dVar5.h();
                    }
                    com.tencent.gdtad.kuikly.a.i("GdtBaseKuiklyFragmentFallbackIPCHandler", str4, AdMetricID.Kuikly.FragmentIPCHandler.FALLBACK_SUCCESS, AdMetricID.Kuikly.FragmentIPCHandler.FALLBACK_SUCCESS_TIME_MILLIS, gdtAd2, str2, str5, j3, i3);
                    return;
                }
                String str6 = "[handle] fallback failed, errorCode:" + i3 + " result:" + a16;
                a.d dVar6 = dVar;
                if (dVar6 != null) {
                    gdtAd = dVar6.b();
                } else {
                    gdtAd = null;
                }
                a.d dVar7 = dVar;
                if (dVar7 != null) {
                    str = dVar7.i();
                } else {
                    str = null;
                }
                a.d dVar8 = dVar;
                if (dVar8 != null) {
                    str3 = dVar8.getPageName();
                }
                String str7 = str3;
                a.d dVar9 = dVar;
                if (dVar9 != null) {
                    j3 = dVar9.h();
                }
                com.tencent.gdtad.kuikly.a.c("GdtBaseKuiklyFragmentFallbackIPCHandler", str6, null, AdMetricID.Kuikly.FragmentIPCHandler.FALLBACK_FAILED, AdMetricID.Kuikly.FragmentIPCHandler.FALLBACK_FAILED_TIME_MILLIS, gdtAd, str, str7, j3, a16);
            }
        });
        AdIPCManager.Result result = new AdIPCManager.Result();
        result.success = true;
        return result;
    }
}
