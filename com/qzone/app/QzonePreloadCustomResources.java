package com.qzone.app;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import com.tencent.raft.measure.utils.MeasureConst;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QzonePreloadCustomResources {

    /* renamed from: a, reason: collision with root package name */
    private static IQZoneServiceListener f44452a;

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(boolean z16, String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, str);
            String str3 = MeasureConst.SLI_TYPE_SUCCESS;
            if (z16) {
                str2 = MeasureConst.SLI_TYPE_SUCCESS;
            } else {
                str2 = "fail";
            }
            hashMap.put("result", str2);
            if (!z16) {
                str3 = LoginData.getInstance().getUinString();
            }
            hashMap.put("fail_uin", str3);
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_preload_custom_res", z16, 0L, 0L, hashMap, null);
        } catch (Exception e16) {
            QZLog.e("QzonePreloadCustomResources", "downloadSuccReportMta error", e16);
        }
    }

    private static int h() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QBOSS_APPID_CUSTOM_RESOURCES_INFO, QzoneConfig.DefaultValue.QBOSS_APPID_CUSTOM_RESOURCES_INFO_DEFAULT);
    }

    public static void i(final Context context) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.app.QzonePreloadCustomResources.1
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                QzonePreloadCustomResources.j(context);
                QZLog.d("QzonePreloadCustomResources", 4, "preloadCustomResource \u7b49\u5f85\u961f\u5217\u65f6\u95f4\uff1a" + uptimeMillis2 + "ms,\u603b\u5904\u7406\u8017\u65f6\uff1a" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context) {
        long parseLong;
        if (context == null) {
            QZLog.e("QzonePreloadCustomResources", "preloadCustomResource context is null");
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin < 10000) {
            QZLog.e("QzonePreloadCustomResources", "preloadCustomResource uin is invalid:" + uin);
            return;
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        if (systemNetwork != 1 && systemNetwork != 4) {
            QZLog.d("QzonePreloadCustomResources", 4, "preloadCustomResource is not wifi and 4G,return");
            return;
        }
        long config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS, QzoneConfig.DefaultValue.PRELOAD_CUSTOM_RESOURCES_INTERVAL_SECONDS_DEFAULT);
        SharedPreferences sharedPreferences = context.getSharedPreferences("preload_custom_resource", 4);
        String string = sharedPreferences.getString("key_qzone_preload_custom_resources_timestamp_" + uin, "");
        if (TextUtils.isEmpty(string)) {
            parseLong = 0;
        } else {
            try {
                parseLong = Long.parseLong(string);
            } catch (NumberFormatException unused) {
                QZLog.e("QzonePreloadCustomResources", "preloadCustomResource \u683c\u5f0f\u5316\u65f6\u95f4\u6233\u5f02\u5e38 time:" + string);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - parseLong <= config * 1000) {
            return;
        }
        if (f44452a == null) {
            f44452a = new c();
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(uin, h(), 10, true), null, f44452a, 1));
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("key_qzone_preload_custom_resources_timestamp_" + uin, String.valueOf(currentTimeMillis));
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(final QZoneTask qZoneTask) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.app.QzonePreloadCustomResources.2
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                QzonePreloadCustomResources.l(qZoneTask);
                QZLog.i("QzonePreloadCustomResources", 1, "processResultCustomResourceInfo \u7b49\u5f85\u961f\u5217\u65f6\u95f4\uff1a" + uptimeMillis2 + "ms,\u603b\u5904\u7406\u8017\u65f6\uff1a" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
            }
        });
    }

    /* loaded from: classes39.dex */
    public static class c implements IQZoneServiceListener {
        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask != null && qZoneTask.mType == 1) {
                QzonePreloadCustomResources.k(qZoneTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(int[] iArr, String str) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= iArr.length) {
                z16 = true;
                break;
            } else if (iArr[i3] != 1) {
                break;
            } else {
                i3++;
            }
        }
        if (!z16 || TextUtils.isEmpty(str)) {
            return;
        }
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str, null);
        QZLog.i("QzonePreloadCustomResources", "checkIfAllDownloadSuccAndReportToQboss \u5168\u90e8\u4e0b\u8f7d\u6210\u529f,url\u6570\u91cf\u662f\uff1a" + iArr.length + ",traceinfo=" + str);
        g(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c8, code lost:
    
        if ("static_cover".equals(r6) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ce, code lost:
    
        if ("image".equals(r7) == false) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        String str;
        boolean z16;
        if (qZoneTask == null) {
            return;
        }
        if (!qZoneTask.succeeded()) {
            QZLog.d("QzonePreloadCustomResources", 4, "processResultCustomResourceInfoImpl succeeded=false");
            return;
        }
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (qZoneRequest != null && (jceStruct = qZoneRequest.rsp) != null) {
            if (jceStruct instanceof MobileQbossAdvRsp) {
                MobileQbossAdvRsp mobileQbossAdvRsp = (MobileQbossAdvRsp) jceStruct;
                if (mobileQbossAdvRsp.iRet != 0) {
                    QZLog.e("QzonePreloadCustomResources", "processResultCustomResourceInfo qboss\u8fd4\u56de\u6570\u636e\u5931\u8d25\uff0ciRet=" + mobileQbossAdvRsp.iRet + ",msg=" + mobileQbossAdvRsp.sMsg);
                    return;
                }
                Map<Integer, ArrayList<tAdvDesc>> map = mobileQbossAdvRsp.mapAdv;
                if (map == null) {
                    QZLog.e("QzonePreloadCustomResources", "processResultCustomResourceInfo rsp mapAdv is null");
                    return;
                }
                int h16 = h();
                if (!map.containsKey(Integer.valueOf(h16))) {
                    QZLog.i("QzonePreloadCustomResources", 1, "processResultCustomResourceInfoImpl \u6ca1\u6709\u8fd4\u56de\u5e7f\u544a\u4f4d\u6570\u636e qboss appid=" + h16);
                    return;
                }
                ArrayList<tAdvDesc> arrayList = map.get(Integer.valueOf(h16));
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                Iterator<tAdvDesc> it = arrayList.iterator();
                while (it.hasNext()) {
                    tAdvDesc next = it.next();
                    if (next != null) {
                        QZLog.i("QzonePreloadCustomResources", 2, "processResultCustomResourceInfo res data=" + next.res_data + ",traceinfo=" + next.res_traceinfo);
                        if (!TextUtils.isEmpty(next.res_data)) {
                            try {
                                JSONArray jSONArray = new JSONArray(next.res_data);
                                int[] iArr = new int[jSONArray.length()];
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    iArr[i3] = -1;
                                }
                                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                                    if (optJSONObject != null) {
                                        String optString = optJSONObject.optString("busi");
                                        String optString2 = optJSONObject.optString("file_type");
                                        String optString3 = optJSONObject.optString("url");
                                        String trim = optString3 != null ? optString3.trim() : null;
                                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(trim)) {
                                            if ("custom_praise".equals(optString)) {
                                                if ("zip".equals(optString2)) {
                                                    String m3 = QzoneZipAnimateUtil.m(trim);
                                                    String str2 = "zip_drawable_" + m3;
                                                    str = trim;
                                                    if (((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded(null, str, ZipDrawableLoader.DEFAULT_BUSINESS, m3, -1, new a(iArr, i16, next, trim, str2))) {
                                                        QZLog.i("QzonePreloadCustomResources", 2, "zip is exist,url=" + str + ",local zip path=" + str2);
                                                        iArr[i16] = 1;
                                                        f(iArr, next.res_traceinfo);
                                                    }
                                                } else {
                                                    str = trim;
                                                    z16 = "image".equals(optString2);
                                                }
                                            } else {
                                                str = trim;
                                                if (!"float".equals(optString)) {
                                                }
                                            }
                                            if (z16) {
                                                ImageLoader.getInstance().loadImageAsync(str, new b(iArr, i16, next, str));
                                            }
                                        }
                                    }
                                }
                            } catch (JSONException e16) {
                                QZLog.e("QzonePreloadCustomResources", "qboss res_data is invalid.", e16);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        QZLog.d("QzonePreloadCustomResources", 4, "processResultCustomResourceInfoImpl rsp is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements QzoneZipCacheHelperCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f44457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f44458b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ tAdvDesc f44459c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f44460d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f44461e;

        a(int[] iArr, int i3, tAdvDesc tadvdesc, String str, String str2) {
            this.f44457a = iArr;
            this.f44458b = i3;
            this.f44459c = tadvdesc;
            this.f44460d = str;
            this.f44461e = str2;
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            int[] iArr = this.f44457a;
            int i3 = this.f44458b;
            if (-1 == iArr[i3]) {
                iArr[i3] = z16 ? 1 : 0;
                QzonePreloadCustomResources.f(iArr, this.f44459c.res_traceinfo);
                if (z16) {
                    QZLog.i("QzonePreloadCustomResources", 2, "download zip succ,url=" + this.f44460d + ",local zip path=" + this.f44461e);
                    return;
                }
                QZLog.e("QzonePreloadCustomResources", 1, "download zip fail,url=" + this.f44460d);
                QzonePreloadCustomResources.g(false, this.f44459c.res_traceinfo);
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f44462d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f44463e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ tAdvDesc f44464f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f44465h;

        b(int[] iArr, int i3, tAdvDesc tadvdesc, String str) {
            this.f44462d = iArr;
            this.f44463e = i3;
            this.f44464f = tadvdesc;
            this.f44465h = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            int[] iArr = this.f44462d;
            iArr[this.f44463e] = 0;
            QzonePreloadCustomResources.f(iArr, this.f44464f.res_traceinfo);
            QZLog.e("QzonePreloadCustomResources", 1, "download image cancel,url=" + this.f44465h);
            QzonePreloadCustomResources.g(false, this.f44464f.res_traceinfo);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            int[] iArr = this.f44462d;
            iArr[this.f44463e] = 0;
            QzonePreloadCustomResources.f(iArr, this.f44464f.res_traceinfo);
            QZLog.e("QzonePreloadCustomResources", 1, "download image fail,url=" + this.f44465h);
            QzonePreloadCustomResources.g(false, this.f44464f.res_traceinfo);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            int[] iArr = this.f44462d;
            iArr[this.f44463e] = 1;
            QzonePreloadCustomResources.f(iArr, this.f44464f.res_traceinfo);
            QZLog.i("QzonePreloadCustomResources", 1, "download image succ,url=" + this.f44465h);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
