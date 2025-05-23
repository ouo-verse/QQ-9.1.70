package com.tencent.gdtad.kuikly.dex;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f109277c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f109278a = false;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f109279b = new CopyOnWriteArraySet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.kuikly.dex.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1162a implements Function1<ResError, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f109280d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f109281e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f109282f;

        C1162a(long j3, String str, String str2) {
            this.f109280d = j3;
            this.f109281e = str;
            this.f109282f = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(ResError resError) {
            int i3;
            String str;
            if (resError != null) {
                i3 = resError.getCode();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (resError != null) {
                str = resError.getMessage();
            } else {
                str = null;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f109280d;
            if (i3 == 0) {
                com.tencent.gdtad.kuikly.a.j("GdtKuiklyDexPreDownloader", "[createCallback][invoke] success, message:" + str + " durationMillis:" + currentTimeMillis, AdMetricID.Kuikly.PreDownload.PRE_DOWNLOAD_SUCCESS, AdMetricID.Kuikly.PreDownload.PRE_DOWNLOAD_SUCCESS_TIME_MILLIS, this.f109281e, this.f109282f, currentTimeMillis);
            } else {
                com.tencent.gdtad.kuikly.a.e("GdtKuiklyDexPreDownloader", "[createCallback][invoke] error, errorCode:" + i3 + " message:" + str + " durationMillis:" + currentTimeMillis, null, AdMetricID.Kuikly.PreDownload.PRE_DOWNLOAD_FAILED, AdMetricID.Kuikly.PreDownload.PRE_DOWNLOAD_FAILED_TIME_MILLIS, this.f109281e, this.f109282f, currentTimeMillis, 1, AdMetricTag.Kuikly.UPDATE_ERROR_CODE, Integer.valueOf(i3));
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class b implements AdIPCManager.Handler {
        b() {
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            if (params == null) {
                QLog.e("GdtKuiklyIPCHandlerForPreDownload", 1, "[handle] error, params is null");
                return new AdIPCManager.Result();
            }
            if (!params.isValid()) {
                QLog.e("GdtKuiklyIPCHandlerForPreDownload", 1, "[handle] error, params is not valid");
                return new AdIPCManager.Result();
            }
            Bundle bundle = params.bundle;
            if (bundle == null) {
                QLog.e("GdtKuiklyIPCHandlerForPreDownload", 1, "[handle] error, params.bundle is null");
                return new AdIPCManager.Result();
            }
            String string = bundle.getString("IPC_PARAM_KUIKLY_POS_ID");
            if (!params.bundle.containsKey("IPC_PARAM_KUIKLY_BUNDLE_NAME")) {
                QLog.e("GdtKuiklyIPCHandlerForPreDownload", 1, "[handle] error, params.bundle do not contains IPC_PARAM_KUIKLY_BUNDLE_NAME");
                return new AdIPCManager.Result();
            }
            String string2 = params.bundle.getString("IPC_PARAM_KUIKLY_BUNDLE_NAME");
            QLog.i("GdtKuiklyIPCHandlerForPreDownload", 1, "[handle] posId:" + string + " bundleName:" + string2);
            AdIPCManager.Result result = new AdIPCManager.Result();
            result.success = a.c().f(string, string2);
            return result;
        }
    }

    private static Function1<ResError, Unit> b(String str, String str2, long j3) {
        return new C1162a(j3, str, str2);
    }

    public static a c() {
        if (f109277c == null) {
            synchronized (a.class) {
                if (f109277c == null) {
                    f109277c = new a();
                }
            }
        }
        return f109277c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            QLog.e("GdtKuiklyDexPreDownloader", 1, "[preDownloadImpl] error, bundleName is empty");
            return false;
        }
        if (this.f109279b.contains(str2)) {
            QLog.i("GdtKuiklyDexPreDownloader", 1, "[preDownloadImpl] do nothing, too frequently, bundleName:" + str2);
            return false;
        }
        com.tencent.gdtad.kuikly.a.m("GdtKuiklyDexPreDownloader", "[preDownloadImpl]", AdMetricID.Kuikly.PreDownload.PRE_DOWNLOAD_START, str, str2);
        this.f109279b.add(str2);
        try {
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(str2, b(str, str2, System.currentTimeMillis()));
            return true;
        } catch (Throwable th5) {
            QLog.e("GdtKuiklyDexPreDownloader", 1, "[preDownloadImpl]", th5);
            return false;
        }
    }

    public void d() {
        if (this.f109278a) {
            return;
        }
        synchronized (this) {
            if (this.f109278a) {
                return;
            }
            this.f109278a = true;
            QLog.i("GdtKuiklyDexPreDownloader", 1, "[init]");
            AdIPCManager.getInstance().register("IPC_ACTION_KUIKLY_PRE_DOWNLOAD", new b());
        }
    }

    public void e(Context context, String str, String str2) {
        if (context == null) {
            QLog.e("GdtKuiklyDexPreDownloader", 1, "[preDownload] error, context is null, bundleName:" + str2);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("GdtKuiklyDexPreDownloader", 1, "[preDownload] error, bundleName is empty, bundleName:" + str2);
            return;
        }
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(context, new InitGdtContextParams());
            QLog.i("GdtKuiklyDexPreDownloader", 1, "[preDownload] bundleName:" + str2);
            Bundle bundle = new Bundle();
            bundle.putString(AdIPCManager.Params.KEY_ACTION, "IPC_ACTION_KUIKLY_PRE_DOWNLOAD");
            bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
            bundle.putString("IPC_PARAM_KUIKLY_POS_ID", str);
            bundle.putString("IPC_PARAM_KUIKLY_BUNDLE_NAME", str2);
            AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle), null);
        } catch (Throwable th5) {
            QLog.e("GdtKuiklyDexPreDownloader", 1, "[preDownload] error, bundleName:" + str2, th5);
        }
    }
}
