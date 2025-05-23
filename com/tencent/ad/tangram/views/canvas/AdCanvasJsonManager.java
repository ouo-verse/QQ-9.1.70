package com.tencent.ad.tangram.views.canvas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.protocol.landing_page_collect_data;
import com.tencent.ad.tangram.statistics.AdReportForAction;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasJsonManager {
    private static final int FAIL = 1;
    private static final int SUCC = 0;
    private static final String TAG = "AdCanvasJsonManager";
    private static volatile AdCanvasJsonManager sInstance;
    private WeakReference<Context> mContext;

    @Nullable
    private volatile LruCache<String, String> mDataList;
    private volatile boolean initialized = false;

    @NonNull
    private Set<String> preloadingUrlList = new HashSet();

    /* compiled from: P */
    /* renamed from: com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Ad val$ad;
        final /* synthetic */ String val$canvasJsonKey;
        final /* synthetic */ String val$canvasJsonUrl;

        AnonymousClass1(String str, Ad ad5, String str2) {
            this.val$canvasJsonUrl = str;
            this.val$ad = ad5;
            this.val$canvasJsonKey = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdCanvasJsonManager.this.preloadingUrlList.contains(this.val$canvasJsonUrl)) {
                return;
            }
            AdCanvasJsonManager.this.preloadingUrlList.add(this.val$canvasJsonUrl);
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    AdCanvasJsonManager.this.preloadCanvasJsonOnNetworkThread(anonymousClass1.val$ad, anonymousClass1.val$canvasJsonKey, anonymousClass1.val$canvasJsonUrl);
                    AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdCanvasJsonManager.this.preloadingUrlList.remove(AnonymousClass1.this.val$canvasJsonUrl);
                        }
                    }, 0);
                }
            }, 4);
        }
    }

    AdCanvasJsonManager() {
    }

    private boolean cache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mDataList != null) {
            this.mDataList.put(str, str2);
            return true;
        }
        return false;
    }

    public static AdCanvasJsonManager getInstance() {
        if (sInstance == null) {
            synchronized (AdCanvasJsonManager.class) {
                if (sInstance == null) {
                    sInstance = new AdCanvasJsonManager();
                }
            }
        }
        return sInstance;
    }

    private void initDataList(int i3) {
        if (i3 > 0) {
            if (this.mDataList == null) {
                this.mDataList = new LruCache<>(i3);
            } else if (this.mDataList.size() != i3) {
                this.mDataList.resize(i3);
            }
            AdLog.i(TAG, "canvas_json cache list size :" + this.mDataList.maxSize());
            return;
        }
        this.mDataList = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadCanvasJsonOnNetworkThread(Ad ad5, String str, String str2) {
        String str3;
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        report(ad5, 74, 0, 0L);
        AdHttp.Params params = new AdHttp.Params();
        params.method = "GET";
        params.setUrl(str2);
        AdHttp.send(params);
        if (params.responseCode == 200 && params.responseData != null) {
            try {
                jSONObject = new JSONObject(new String(params.responseData));
            } catch (Throwable th5) {
                AdLog.e(TAG, "invalid canvasJson :" + th5);
                str3 = null;
            }
            if (jSONObject.getInt("code") != 0) {
                return;
            }
            str3 = jSONObject.optString("data");
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            report(ad5, 75, 0, System.currentTimeMillis() - currentTimeMillis);
            cache(str, str3);
            return;
        }
        AdLog.i(TAG, "preloadCanvasJson failed :" + params.responseCode);
    }

    private void report(Ad ad5, int i3, int i16, long j3) {
        try {
            AdReportForAction.Params params = new AdReportForAction.Params();
            params.context = this.mContext;
            params.f61333ad = ad5;
            landing_page_collect_data.LandingPageCollectData landingPageCollectData = params.data;
            landingPageCollectData.landing_page_action_type = i3;
            landingPageCollectData.landing_error_code = i16;
            landingPageCollectData.latency_ms = j3;
            AdReportForAction.report(params);
        } catch (Throwable th5) {
            AdLog.e(TAG, "rtp report error", th5);
        }
    }

    @Nullable
    public String getCachedCanvasJson(Ad ad5, String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null && this.mDataList.size() != 0) {
            String str2 = this.mDataList.get(str);
            if (z16) {
                report(ad5, 76, TextUtils.isEmpty(str2) ? 1 : 0, 0L);
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        AdLog.i(TAG, "getCachedCanvasJson failed :" + str);
        return null;
    }

    public void init(Context context) {
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            this.mContext = new WeakReference<>(context);
            initDataList(20);
        }
    }

    public void preloadCanvasJson(Ad ad5, String str, String str2) {
        AdThreadManager.getInstance().post(new AnonymousClass1(str2, ad5, str), 0);
    }
}
