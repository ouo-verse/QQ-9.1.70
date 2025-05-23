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
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.webview.GDTADWebviewDelegate;
import com.qq.e.comm.plugin.webview.IWebView;
import com.qq.e.comm.plugin.webview.bridge.GDTJSEvent;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DefaultApiImpl implements PublicApi.CanvasApi, PublicApi.DeviceInfoApi, PublicApi.DownloadManagerApi, PublicApi.RewardVideoApi, PublicApi.SplashApi, PublicApi.VelenApi, PublicApi.VideoCacheApi, PublicApi.WebViewApi {
    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void addStatusListener(a aVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public IInnerWebView buildInnerWebView(Context context, JSONObject jSONObject) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public IWebView buildWebView(Context context, GDTADWebviewDelegate gDTADWebviewDelegate) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public int canvasPageNodeHandle(Object obj) {
        return 2;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
    public boolean checkPreloadSplashMaterial(Object obj) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public boolean dealCanvasAd(Context context, JSONObject jSONObject, boolean z16) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public JSONObject get(int i3, c cVar) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public long getAPKTotalSize(String str) {
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getAndroidId() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getBuildModel() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public FrameLayout getCanvasView(Activity activity, JSONObject jSONObject, boolean z16, boolean z17) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public int getCarrier() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getDeviceId() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public List<JSONObject> getDownloadedPackage() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public List<d> getDownloadedTasks() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public List<d> getDownloadingOrPausedTasks() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getHashDeviceId() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public Pair<Integer, Integer> getHeightAndWidth() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getImei() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public int getNetWorkType() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public JSONObject getOnlyCache(int i3, c cVar) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getOsVersion() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public int getPageViewScrollY(View view) {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public int getProgress(Context context, String str) {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public String getQImei36() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VideoCacheApi
    public com.qq.e.comm.plugin.m.c getServer(Context context, File file, boolean z16) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public int getStatus(String str) {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.RewardVideoApi
    public String getTGRewardVideoHandlerServiceName() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public Pair<String, String> getTaidAndOaidTicket() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public Object getTangramDownloaderConfigure() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.RewardVideoApi
    public Object getTangramRewardVideoHandler() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public d getTask(String str) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public d getTaskById(int i3) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public String getVelenPreloadPageUrl(JSONObject jSONObject) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public List<String> getVelenPreloadUrl(JSONObject jSONObject) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public WebResourceResponse getWebResResponseOffline(String str) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public String handleJs(View view, JSONObject jSONObject, String str, JsCallback jsCallback) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void installApp(Context context, int i3) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public boolean isCanvas(JSONObject jSONObject) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean isSetMediaCustomDownloader() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public boolean isX5Loaded() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean pauseTask(int i3, m mVar) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void removeStatusListener(a aVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean resumeTask(int i3, m mVar) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public int rmTask(d dVar) {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean startInstallApk(Context context, File file) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public com.tencent.smtt.export.external.interfaces.WebResourceResponse translateResponseFromWebkitToX5(WebResourceResponse webResourceResponse) {
        return null;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean updateProgress(int i3, int i16, long j3) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void addStatusListener(String str, a aVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public int getProgress(String str) {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void installApp(Context context, File file, d dVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean pauseTask(String str, m mVar) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void removeStatusListener(String str, a aVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean resumeTask(String str, m mVar) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public boolean rmTask(int i3, String str, int i16) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public void cancelPendingTask() {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public void reset() {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void deleteApk(int i3) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi, com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public void init(Context context) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public void initDefaultHandlers(IWebView iWebView) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void initForGdtManager(Context context) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void onActivityDestroy(View view) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void onActivityPause(View view) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void onActivityResume(View view) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void onBackPressed(View view) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public void preloadAdFileSource(JSONObject jSONObject) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.VelenApi
    public void preloadResourcesToRam(List<String> list) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void start(d dVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void startInstallChecker(d dVar) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DeviceInfoApi
    public void updateAppStatus(String str) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public void fireJSEvent(IInnerWebView iInnerWebView, GDTJSEvent gDTJSEvent) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void preload(JSONArray jSONArray, String str) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
    public void startInterPage(Object obj, int i3) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.SplashApi
    public void reportOutSplashEvent(int i3, String str, String str2) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.DownloadManagerApi
    public void traceCheckingPhaseStatus(d dVar, int i3, String str) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.WebViewApi
    public void addHandler(String str, IInnerWebView iInnerWebView, String str2, Object... objArr) {
    }

    @Override // com.qq.e.comm.plugin.router.PublicApi.CanvasApi
    public void initForCanvas(Context context, JSONObject jSONObject, String str, boolean z16) {
    }
}
