package com.qq.e.comm.plugin.router;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import com.qq.e.comm.pi.JsCallback;
import com.qq.e.comm.plugin.b.a;
import com.qq.e.comm.plugin.base.ad.model.d;
import com.qq.e.comm.plugin.base.ad.model.m;
import com.qq.e.comm.plugin.e.c;
import com.qq.e.comm.plugin.webview.GDTADWebviewDelegate;
import com.qq.e.comm.plugin.webview.IWebView;
import com.qq.e.comm.plugin.webview.bridge.GDTJSEvent;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PublicApi {

    /* loaded from: classes3.dex */
    public interface CanvasApi extends ModuleApi {
        int canvasPageNodeHandle(Object obj);

        boolean dealCanvasAd(Context context, JSONObject jSONObject, boolean z16);

        FrameLayout getCanvasView(Activity activity, JSONObject jSONObject, boolean z16, boolean z17);

        int getPageViewScrollY(View view);

        void initForCanvas(Context context, JSONObject jSONObject, String str, boolean z16);

        void initForGdtManager(Context context);

        boolean isCanvas(JSONObject jSONObject);

        void onActivityDestroy(View view);

        void onActivityPause(View view);

        void onActivityResume(View view);

        void onBackPressed(View view);

        void preload(JSONArray jSONArray, String str);
    }

    /* loaded from: classes3.dex */
    public interface DeviceInfoApi extends ModuleApi {
        JSONObject get(int i3, c cVar) throws JSONException;

        String getAndroidId();

        String getBuildModel();

        int getCarrier();

        String getDeviceId();

        String getHashDeviceId();

        Pair<Integer, Integer> getHeightAndWidth();

        String getImei();

        int getNetWorkType();

        JSONObject getOnlyCache(int i3, c cVar) throws JSONException;

        String getOsVersion();

        String getQImei36();

        Pair<String, String> getTaidAndOaidTicket();

        void init(Context context);

        void reset();

        void updateAppStatus(String str);
    }

    /* loaded from: classes3.dex */
    public interface DownloadManagerApi extends ModuleApi {
        void addStatusListener(a aVar);

        void addStatusListener(String str, a aVar);

        void deleteApk(int i3);

        long getAPKTotalSize(String str);

        List<JSONObject> getDownloadedPackage();

        List<d> getDownloadedTasks();

        List<d> getDownloadingOrPausedTasks();

        int getProgress(Context context, String str);

        int getProgress(String str);

        int getStatus(String str);

        Object getTangramDownloaderConfigure();

        d getTask(String str);

        d getTaskById(int i3);

        void installApp(Context context, int i3);

        void installApp(Context context, File file, d dVar);

        boolean isSetMediaCustomDownloader();

        boolean pauseTask(int i3, m mVar);

        boolean pauseTask(String str, m mVar);

        void removeStatusListener(a aVar);

        void removeStatusListener(String str, a aVar);

        boolean resumeTask(int i3, m mVar);

        boolean resumeTask(String str, m mVar);

        int rmTask(d dVar);

        boolean rmTask(int i3, String str, int i16);

        void start(d dVar);

        boolean startInstallApk(Context context, File file);

        void startInstallChecker(d dVar);

        void traceCheckingPhaseStatus(d dVar, int i3, String str);

        boolean updateProgress(int i3, int i16, long j3);
    }

    /* loaded from: classes3.dex */
    public interface RewardVideoApi extends ModuleApi {
        String getTGRewardVideoHandlerServiceName();

        Object getTangramRewardVideoHandler();
    }

    /* loaded from: classes3.dex */
    public interface SplashApi extends ModuleApi {
        boolean checkPreloadSplashMaterial(Object obj);

        void reportOutSplashEvent(int i3, String str, String str2);

        void startInterPage(Object obj, int i3);
    }

    /* loaded from: classes3.dex */
    public interface VelenApi extends ModuleApi {
        void cancelPendingTask();

        String getVelenPreloadPageUrl(JSONObject jSONObject);

        List<String> getVelenPreloadUrl(JSONObject jSONObject);

        WebResourceResponse getWebResResponseOffline(String str);

        void init(Context context);

        void preloadAdFileSource(JSONObject jSONObject);

        void preloadResourcesToRam(List<String> list);

        com.tencent.smtt.export.external.interfaces.WebResourceResponse translateResponseFromWebkitToX5(WebResourceResponse webResourceResponse);
    }

    /* loaded from: classes3.dex */
    public interface VideoCacheApi extends ModuleApi {
        com.qq.e.comm.plugin.m.c getServer(Context context, File file, boolean z16);
    }

    /* loaded from: classes3.dex */
    public interface WebViewApi extends ModuleApi {
        void addHandler(String str, IInnerWebView iInnerWebView, String str2, Object... objArr);

        IInnerWebView buildInnerWebView(Context context, JSONObject jSONObject);

        IWebView buildWebView(Context context, GDTADWebviewDelegate gDTADWebviewDelegate);

        void fireJSEvent(IInnerWebView iInnerWebView, GDTJSEvent gDTJSEvent);

        String handleJs(View view, JSONObject jSONObject, String str, JsCallback jsCallback);

        void initDefaultHandlers(IWebView iWebView);

        boolean isX5Loaded();
    }
}
