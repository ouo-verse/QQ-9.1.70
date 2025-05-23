package com.tencent.gdtad.aditem;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.basics.sso.callback.SsoAdCallback;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtAdLoader {
    private static final String TAG = "GdtAdLoader";
    private WeakReference<Listener> loaderListener;
    private Session session;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Listener {
        void onResponse(GdtAdLoader gdtAdLoader);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Session {

        @Nullable
        public qq_ad_get.QQAdGet request;

        @Nullable
        public qq_ad_get.QQAdGetRsp response;
        public int ssoResponseCode = Integer.MIN_VALUE;
        public long timeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        public boolean supportOpenMotiveAd = false;

        boolean canSend() {
            if (this.request != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements SsoAdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f108483a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f108484b;

        a(long j3, HashMap hashMap) {
            this.f108483a = j3;
            this.f108484b = hashMap;
        }

        @Override // com.tencent.gdtad.basics.sso.callback.SsoAdCallback
        public void onRsp(int i3, @Nullable access.AdGetRsp adGetRsp, @Nullable String str) {
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            String str2;
            GdtAdLoader.this.session.ssoResponseCode = i3;
            GdtAdLoader.this.session.timeMillis = System.currentTimeMillis() - this.f108483a;
            Session session = GdtAdLoader.this.session;
            if (adGetRsp != null) {
                qQAdGetRsp = adGetRsp.qq_ad_get_rsp.get();
            } else {
                qQAdGetRsp = null;
            }
            session.response = qQAdGetRsp;
            this.f108484b.put("retCode", String.valueOf(i3));
            this.f108484b.put("cost_time", String.valueOf(GdtAdLoader.this.session.timeMillis));
            SsoReporter ssoReporter = SsoReporter.INSTANCE;
            if (i3 == 0) {
                str2 = SsoReporter.AD_REQUEST_RETURN_SUCCESS;
            } else {
                str2 = SsoReporter.AD_REQUEST_RETURN_FAILED;
            }
            ssoReporter.reportAdRequestEvent(str2, this.f108484b);
            GdtAdLoader.this.notifyListener();
        }
    }

    public GdtAdLoader(Session session, WeakReference<Listener> weakReference) {
        this.session = session;
        this.loaderListener = weakReference;
    }

    private HashMap<String, String> getReportMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        qq_ad_get.QQAdGet qQAdGet = this.session.request;
        String str = "";
        if (qQAdGet != null && qQAdGet.position_info.size() > 0) {
            str = this.session.request.position_info.get(0).pos_id.get();
        }
        hashMap.put(SsoReporter.POS_ID_KEY, str);
        hashMap.put("cost_time", String.valueOf(0));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListener() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                Listener listener;
                if (GdtAdLoader.this.loaderListener != null) {
                    listener = (Listener) GdtAdLoader.this.loaderListener.get();
                } else {
                    listener = null;
                }
                if (listener != null) {
                    listener.onResponse(GdtAdLoader.this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportForAnalysis(@Nullable WeakReference<Context> weakReference) {
        Context context;
        Session session = this.session;
        if (session != null && session.request != null) {
            for (int i3 = 0; i3 < this.session.request.position_info.size(); i3++) {
                if (weakReference != null) {
                    context = weakReference.get();
                } else {
                    context = null;
                }
                AdAnalysisHelperForUtil.reportForLoadAd(context, this.session.request.position_info.get(i3).pos_id.get());
            }
            return;
        }
        GdtLog.e(TAG, "reportForAnalysis error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAdBySso(@Nullable WeakReference<Context> weakReference) {
        Context context;
        GdtLog.i(TAG, "sso request start");
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = null;
        if (weakReference != null) {
            try {
                context = weakReference.get();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "sso request failed, error is " + th5);
                return;
            }
        } else {
            context = null;
        }
        if (context == null) {
            GdtLog.e(TAG, "context is null, cancel request");
            notifyListener();
            return;
        }
        IGdtAPI iGdtAPI = (IGdtAPI) QRoute.api(IGdtAPI.class);
        Session session = this.session;
        if (session != null && session.canSend()) {
            long currentTimeMillis = System.currentTimeMillis();
            GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
            params.supportOpenMotiveAd = this.session.supportOpenMotiveAd;
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(context, params);
            if (create != null) {
                deviceInfo = create.deviceInfo;
            }
            if (deviceInfo != null) {
                this.session.request.device_info.set(deviceInfo);
            }
            HashMap<String, String> reportMap = getReportMap();
            SsoReporter.INSTANCE.reportAdRequestEvent(SsoReporter.AD_REQUEST_START, reportMap);
            iGdtAPI.requestAdBySso(iGdtAPI.createRequestAdReq(this.session.request), new a(currentTimeMillis, reportMap));
            return;
        }
        GdtLog.e(TAG, "session is null, cancel request");
        notifyListener();
    }

    public Session getSession() {
        return this.session;
    }

    @Deprecated
    public void load(@Nullable final WeakReference<Context> weakReference) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtAdLoader.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAdLoader.this.requestAdBySso(weakReference);
                GdtAdLoader.this.reportForAnalysis(weakReference);
            }
        }, 128, null, false);
    }
}
