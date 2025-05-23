package com.tencent.gdtad.api.halfscreen;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.downloader.AdDownloadUrlManager;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ams.fusion.widget.downloadcard.DownloadHandler;
import com.tencent.ams.fusion.widget.downloadcard.DownloadInfo;
import com.tencent.ams.fusion.widget.downloadcard.DownloadStatus;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gathererga.core.UserInfoProvider;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.downloader.p;
import com.tencent.gdtad.downloader.x;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import xm0.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtHalfScreenDownloadHandler implements DownloadHandler {

    /* renamed from: a, reason: collision with root package name */
    private final DownloadInfo f108540a;

    /* renamed from: b, reason: collision with root package name */
    private volatile DownloadHandler.DownloadStatusChangeListener f108541b;

    /* renamed from: c, reason: collision with root package name */
    private final e f108542c;

    /* renamed from: d, reason: collision with root package name */
    private final b.a f108543d = new d(new WeakReference(this));

    /* renamed from: e, reason: collision with root package name */
    private volatile String f108544e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements c {
        a() {
        }

        @Override // com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler.c
        public void updateDownloadStatus(int i3, int i16) {
            GdtHalfScreenDownloadHandler.this.q(i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadHandler.DownloadStatusGetter f108551a;

        b(DownloadHandler.DownloadStatusGetter downloadStatusGetter) {
            this.f108551a = downloadStatusGetter;
        }

        @Override // com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler.c
        public void updateDownloadStatus(int i3, int i16) {
            DownloadStatus downloadStatus = new DownloadStatus(GdtHalfScreenDownloadHandler.k(i3));
            downloadStatus.setProgress(i16);
            this.f108551a.onGetStatus(downloadStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
        void updateDownloadStatus(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GdtHalfScreenDownloadHandler> f108553a;

        d(WeakReference<GdtHalfScreenDownloadHandler> weakReference) {
            this.f108553a = weakReference;
        }

        @Override // xm0.b.a
        public void onEvent(@Nullable String str, @Nullable String str2) {
            GdtHalfScreenDownloadHandler gdtHalfScreenDownloadHandler;
            if (!xm0.a.f448135a.d().equals(str)) {
                return;
            }
            WeakReference<GdtHalfScreenDownloadHandler> weakReference = this.f108553a;
            if (weakReference != null) {
                gdtHalfScreenDownloadHandler = weakReference.get();
            } else {
                gdtHalfScreenDownloadHandler = null;
            }
            if (TextUtils.isEmpty(str2)) {
                GdtLog.e("GdtHalfScreenDownloadHandler", "[onEvent] data is empty");
                return;
            }
            if (gdtHalfScreenDownloadHandler != null && gdtHalfScreenDownloadHandler.f108542c != null && gdtHalfScreenDownloadHandler.f108542c.f108565b != null) {
                JSONObject newJSONObject = AdJSONUtil.newJSONObject(str2);
                if (!TextUtils.equals(AdJSONUtil.optString(newJSONObject, "packagename", ""), gdtHalfScreenDownloadHandler.f108542c.f108565b.getAppPackageName())) {
                    GdtLog.i("GdtHalfScreenDownloadHandler", "[onEvent] not match current packageName");
                    return;
                }
                int optInt = AdJSONUtil.optInt(newJSONObject, "state", Integer.MIN_VALUE);
                int optInt2 = AdJSONUtil.optInt(newJSONObject, WadlResult.WEB_KEY_PROGRESS, Integer.MIN_VALUE);
                if (optInt == 1) {
                    GdtLog.i("GdtHalfScreenDownloadHandler", "[onEvent] no need to update");
                    return;
                } else {
                    if (optInt != Integer.MIN_VALUE && optInt2 != Integer.MIN_VALUE) {
                        gdtHalfScreenDownloadHandler.q(optInt, optInt2);
                        return;
                    }
                    return;
                }
            }
            GdtLog.e("GdtHalfScreenDownloadHandler", "[onEvent] params error");
        }
    }

    public GdtHalfScreenDownloadHandler(e eVar, DownloadInfo downloadInfo) {
        this.f108542c = eVar;
        this.f108540a = downloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject i(DownloadInfo downloadInfo, String str, int i3) {
        GdtAd gdtAd;
        if (downloadInfo == null) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[buildJsonFromDownloadInfo] downloadInfo is null");
            return null;
        }
        e eVar = this.f108542c;
        if (eVar != null) {
            gdtAd = eVar.f108565b;
        } else {
            gdtAd = null;
        }
        if (gdtAd == null) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[buildJsonFromDownloadInfo] mGdtAd is null");
            return null;
        }
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject, "appId", gdtAd.getAppId());
        AdJSONUtil.put(newJSONObject, "posId", gdtAd.getPosId());
        AdJSONUtil.put(newJSONObject, "adId", Long.valueOf(gdtAd.getAId()));
        AdJSONUtil.put(newJSONObject, "traceId", gdtAd.getTraceId());
        AdJSONUtil.put(newJSONObject, "isAutoInstall", 1);
        AdJSONUtil.put(newJSONObject, "packageName", gdtAd.getAppPackageName());
        AdJSONUtil.put(newJSONObject, VirtualAppProxy.KEY_DOWNLOAD_SCENE, 5);
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341500i, gdtAd.getVia());
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341501j, str);
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.F, gdtAd.getAppIconUrl());
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341502k, Integer.valueOf(i3));
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.I, Long.valueOf(gdtAd.getAppChannelPackageSize()));
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341503l, gdtAd.getAppName());
        AdJSONUtil.put(newJSONObject, "VersionCode", gdtAd.getAppChannelVersionName());
        AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341516y, Boolean.TRUE);
        GdtLog.i("GdtHalfScreenDownloadHandler", "[buildJsonFromDownloadInfo] downloadJson" + newJSONObject);
        return newJSONObject;
    }

    private static int j(int i3) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[convertNetWorkType]" + i3);
        if (i3 != 1) {
            int i16 = 2;
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 3) {
                i16 = 4;
                if (i3 == 4) {
                    return 3;
                }
                if (i3 != 7) {
                    GdtLog.e("GdtHalfScreenDownloadHandler", "[convertNetWorkType] unknown code:" + i3);
                    return 0;
                }
            }
            return i16;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i3) {
        int i16 = 1;
        if (i3 == 1) {
            return 0;
        }
        if (i3 != 2) {
            i16 = 3;
            if (i3 == 3) {
                return 2;
            }
            if (i3 != 4) {
                i16 = 5;
                if (i3 != 5) {
                    if (i3 == 10) {
                        return 0;
                    }
                    if (i3 != 30) {
                        GdtLog.e("GdtHalfScreenDownloadHandler", "[convertStatusCode] unknown code:" + i3);
                        return Integer.MIN_VALUE;
                    }
                    return 7;
                }
            }
        }
        return i16;
    }

    private boolean l(final DownloadInfo downloadInfo, final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String n3 = GdtHalfScreenDownloadHandler.this.n();
                    if (TextUtils.isEmpty(n3)) {
                        GdtLog.e("GdtHalfScreenDownloadHandler", "[doDownloadAction] downloadUrl is null");
                        GdtHalfScreenDownloadHandler.this.q(30, 0);
                        return;
                    }
                    String valueOf = String.valueOf(GdtHalfScreenDownloadHandler.this.i(downloadInfo, n3, i3));
                    if (TextUtils.isEmpty(valueOf)) {
                        GdtLog.e("GdtHalfScreenDownloadHandler", "[doDownloadAction] downloadString is empty");
                        GdtHalfScreenDownloadHandler.this.q(30, 0);
                    } else {
                        xm0.b.f448145d.b(valueOf, xm0.a.f448135a.c(), null);
                    }
                } catch (Throwable th5) {
                    GdtLog.e("GdtHalfScreenDownloadHandler", "[doDownloadAction]", th5);
                }
            }
        }, 4);
        return true;
    }

    private void m(final c cVar) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler.3
            @Override // java.lang.Runnable
            public void run() {
                if (GdtHalfScreenDownloadHandler.this.f108542c != null && GdtHalfScreenDownloadHandler.this.f108542c.a() && cVar != null) {
                    if (!AdAppUtil.isInstalled(BaseApplication.getContext(), GdtHalfScreenDownloadHandler.this.f108542c.f108565b.getAppPackageName())) {
                        String n3 = GdtHalfScreenDownloadHandler.this.n();
                        if (TextUtils.isEmpty(n3)) {
                            GdtLog.e("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] downloadUrl is null");
                            cVar.updateDownloadStatus(1, 0);
                            return;
                        }
                        GdtLog.i("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] updateStatusFromDB:" + n3);
                        GdtHalfScreenDownloadHandler.this.r(n3, cVar);
                        return;
                    }
                    GdtLog.i("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] is installed");
                    cVar.updateDownloadStatus(5, 100);
                    return;
                }
                GdtLog.e("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] error params");
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        GdtAd gdtAd;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[getDownloadUrlOnNetworkThread] can't get download url in main thread");
            return null;
        }
        if (!TextUtils.isEmpty(this.f108544e)) {
            GdtLog.i("GdtHalfScreenDownloadHandler", "[getDownloadUrlOnNetworkThread] use cached url");
            return this.f108544e;
        }
        e eVar = this.f108542c;
        if (eVar != null) {
            gdtAd = eVar.f108565b;
        } else {
            gdtAd = null;
        }
        if (gdtAd == null) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[getDownloadUrlOnNetworkThread] mGdtAd is null");
            return null;
        }
        String appDownloadUrlApi = gdtAd.getAppDownloadUrlApi();
        if (TextUtils.isEmpty(appDownloadUrlApi)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[getDownloadUrlOnNetworkThread] downloadApi is Empty");
            return null;
        }
        GdtLog.i("GdtHalfScreenDownloadHandler", "[getDownloadUrlOnNetworkThread]");
        this.f108544e = AdDownloadUrlManager.getInstance().queryOnNetworkThread(gdtAd.getTraceId(), appDownloadUrlApi);
        return this.f108544e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(c cVar, String str) {
        JSONArray newJSONArray = AdJSONArrayUtil.newJSONArray(str);
        if (AdJSONArrayUtil.isEmpty(newJSONArray)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] array is null");
            cVar.updateDownloadStatus(1, 0);
            return;
        }
        JSONObject optJSONObject = AdJSONArrayUtil.optJSONObject(newJSONArray, 0);
        if (AdJSONUtil.isObjectNull(optJSONObject)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[updateDownloadStatus] info is null");
            cVar.updateDownloadStatus(1, 0);
        } else {
            cVar.updateDownloadStatus(AdJSONUtil.optInt(optJSONObject, "state", 1), AdJSONUtil.optInt(optJSONObject, WadlResult.WEB_KEY_PROGRESS, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, int i16) {
        final DownloadHandler.DownloadStatusChangeListener downloadStatusChangeListener = this.f108541b;
        if (downloadStatusChangeListener == null) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[updateStatus] listener is empty");
            return;
        }
        GdtLog.i("GdtHalfScreenDownloadHandler", "[updateStatus] callBack qqDownloaderStatus is" + i3 + ", progress:" + i16);
        final DownloadStatus downloadStatus = new DownloadStatus(k(i3));
        downloadStatus.setProgress((float) i16);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.halfscreen.GdtHalfScreenDownloadHandler.1
            @Override // java.lang.Runnable
            public void run() {
                downloadStatusChangeListener.onStatusChange(GdtHalfScreenDownloadHandler.this.f108540a, downloadStatus);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, final c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, "url", str);
            JSONArray newJSONArray = AdJSONArrayUtil.newJSONArray();
            AdJSONArrayUtil.put(newJSONArray, newJSONObject);
            p.f109191a.j(newJSONArray, new x() { // from class: com.tencent.gdtad.api.halfscreen.d
                @Override // com.tencent.gdtad.downloader.x
                public final void a(String str2) {
                    GdtHalfScreenDownloadHandler.o(GdtHalfScreenDownloadHandler.c.this, str2);
                }
            });
            return;
        }
        GdtLog.i("GdtHalfScreenDownloadHandler", "[getStatusFromDB] params error");
    }

    private boolean s(DownloadInfo downloadInfo) {
        boolean z16;
        DownloadInfo downloadInfo2 = this.f108540a;
        if (downloadInfo2 != null && downloadInfo != null) {
            return downloadInfo2.equals(downloadInfo);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[verifyDownloadInfo] downloadInfo is empty:");
        if (downloadInfo == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GdtLog.e("GdtHalfScreenDownloadHandler", sb5.toString());
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean deleteDownload(DownloadInfo downloadInfo) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[deleteDownload]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[deleteDownload] verify false");
            return false;
        }
        return l(downloadInfo, 10);
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public void displayImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[displayImage] URL is empty");
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public void getDownloadStatus(DownloadInfo downloadInfo, DownloadHandler.DownloadStatusGetter downloadStatusGetter) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[getDownloadStatus]" + downloadInfo);
        if (s(downloadInfo) && downloadStatusGetter != null) {
            m(new b(downloadStatusGetter));
        } else {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[getDownloadStatus] verify false");
        }
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public int getNetWorkType() {
        com.tencent.gdtad.config.data.c cVar;
        com.tencent.gathererga.core.f networkType;
        GdtLog.i("GdtHalfScreenDownloadHandler", "[getNetWorkType]");
        try {
            cVar = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForDeviceInfo();
        } catch (Throwable th5) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[getNetWorkType]", th5);
            cVar = null;
        }
        GdtDeviceInfoHelper.updateSettings(cVar);
        UserInfoProvider userInfoProvider = (UserInfoProvider) com.tencent.gathererga.core.b.f(UserInfoProvider.class);
        if (userInfoProvider == null || (networkType = userInfoProvider.getNetworkType(com.tencent.gathererga.core.internal.provider.b.f().j().h(true).g(false).f())) == null || !(networkType.b() instanceof Integer)) {
            return 0;
        }
        return j(((Integer) networkType.b()).intValue());
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean installApp(DownloadInfo downloadInfo) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[installApp]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[installApp] verify false");
            return false;
        }
        if (!l(downloadInfo, 5)) {
            return false;
        }
        q(4, 100);
        return true;
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean openApp(DownloadInfo downloadInfo) {
        Boolean bool;
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[openApp] verify false");
            return false;
        }
        e eVar = this.f108542c;
        if (eVar != null && eVar.a()) {
            GdtLog.i("GdtHalfScreenDownloadHandler", "[openApp]" + downloadInfo);
            AdAppDeeplinkLauncher.Params params = new AdAppDeeplinkLauncher.Params();
            e eVar2 = this.f108542c;
            params.deeplink = eVar2.f108565b.getAppDeeplink(eVar2.f108566c);
            params.addflags = 268435456;
            e eVar3 = this.f108542c;
            params.extrasForIntent = eVar3.f108564a;
            Activity activity = eVar3.f108567d.get();
            AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch(activity, params);
            if (launch != null && launch.isSuccess()) {
                GdtLog.i("GdtHalfScreenDownloadHandler", "[openApp] deeplink success");
                return true;
            }
            AdError launch2 = AdAppUtil.launch(activity, this.f108542c.f108565b.getAppPackageName(), this.f108542c.f108564a);
            if (launch2 != null) {
                bool = Boolean.valueOf(launch2.isSuccess());
            } else {
                bool = null;
            }
            return bool.booleanValue();
        }
        GdtLog.e("GdtHalfScreenDownloadHandler", "[openApp] params error");
        return false;
    }

    public void p() {
        m(new a());
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean pauseDownload(DownloadInfo downloadInfo) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[pauseDownload]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[pauseDownload] verify false");
            return false;
        }
        return l(downloadInfo, 3);
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public void registerDownloadStatusChangeListener(DownloadInfo downloadInfo, DownloadHandler.DownloadStatusChangeListener downloadStatusChangeListener) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[registerDownloadStatusChangeListener]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[installApp] verify false");
            return;
        }
        this.f108541b = downloadStatusChangeListener;
        xm0.b.f448145d.d(new WeakReference<>(this.f108543d));
        p();
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean resumeDownload(DownloadInfo downloadInfo) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[resumeDownload]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[resumeDownload] verify false");
            return false;
        }
        return l(downloadInfo, 2);
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean showCustomDialog(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public boolean startDownload(DownloadInfo downloadInfo) {
        GdtLog.i("GdtHalfScreenDownloadHandler", "[startDownload]" + downloadInfo);
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[startDownload] verify false");
            return false;
        }
        return l(downloadInfo, 2);
    }

    @Override // com.tencent.ams.fusion.widget.downloadcard.DownloadHandler
    public void unregisterDownloadStatusChangeListener(DownloadInfo downloadInfo) {
        if (!s(downloadInfo)) {
            GdtLog.e("GdtHalfScreenDownloadHandler", "[installApp] verify false");
            return;
        }
        this.f108541b = null;
        GdtLog.i("GdtHalfScreenDownloadHandler", "[unregisterDownloadStatusChangeListener]" + downloadInfo);
        xm0.b.f448145d.e(new WeakReference<>(this.f108543d));
    }
}
