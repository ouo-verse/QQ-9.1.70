package com.tencent.gdtad.api;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.log.GdtLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class GdtAd implements Serializable, IGdtAd {
    private static final int STATUS_LOADED_ERROR = 3;
    private static final int STATUS_LOADED_SUCCESS = 2;
    private static final int STATUS_LOADING = 1;
    private static final int STATUS_UNKNOWN = 0;
    private static final String TAG = "GdtAd";
    private static int loadCountDuringOneMinite = 0;
    private static long loadingTimeMillis = -2147483648L;
    private GdtAdLoader loader;
    private WeakReference<GdtAdListener> weakListener;
    private int status = 0;
    private long loadedTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    @NonNull
    private GdtAdLoader.Listener loadListener = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtAdLoader.Listener {
        a() {
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@Nullable GdtAdLoader gdtAdLoader) {
            int i3;
            int i16;
            if (gdtAdLoader == GdtAd.this.loader && GdtAd.this.isValid() && GdtAd.this.getParams().requestParams != null) {
                int i17 = Integer.MIN_VALUE;
                com.tencent.gdtad.aditem.GdtAd gdtAd = null;
                if (gdtAdLoader == null || gdtAdLoader.getSession() == null) {
                    i3 = Integer.MIN_VALUE;
                    i16 = Integer.MIN_VALUE;
                } else {
                    int i18 = gdtAdLoader.getSession().ssoResponseCode;
                    if (gdtAdLoader.getSession().response == null) {
                        i3 = Integer.MIN_VALUE;
                        i16 = Integer.MIN_VALUE;
                    } else {
                        i16 = gdtAdLoader.getSession().response.ret.get();
                        if (i16 == 0 && gdtAdLoader.getSession().response.pos_ads_info.size() > 0 && (i17 = gdtAdLoader.getSession().response.pos_ads_info.get(0).ret.get()) == 0 && gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.size() > 0) {
                            gdtAd = new com.tencent.gdtad.aditem.GdtAd(gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.get(0));
                        }
                        i3 = i17;
                    }
                    i17 = i18;
                }
                int errorCode = GdtAd.this.getErrorCode(gdtAd, i17, i16, i3);
                GdtAdError gdtAdError = new GdtAdError(errorCode);
                GdtLog.i(GdtAd.TAG, "[onResponse] " + gdtAdError.getErrorMessage());
                if (errorCode == 0) {
                    GdtAd.this.status = 2;
                    GdtAd.this.getParams().clickParams.f108486ad = gdtAd;
                    GdtAd.this.loadedTimeMillis = SystemClock.elapsedRealtime();
                    GdtAd.this.notifyLoaded();
                    return;
                }
                GdtAd.this.status = 3;
                GdtAd.this.notifyFailedToLoad(gdtAdError);
                return;
            }
            GdtLog.e(GdtAd.TAG, "[onResponse] error");
            GdtAd.this.status = 3;
            GdtAd.this.notifyFailedToLoad(new GdtAdError(1));
        }
    }

    public GdtAd(@Nullable GdtAdParams gdtAdParams) {
        if (gdtAdParams == null) {
            GdtLog.e(TAG, "constructor");
            return;
        }
        GdtAdLoader.Session session = new GdtAdLoader.Session();
        session.request = gdtAdParams.requestParams;
        this.loader = new GdtAdLoader(session, new WeakReference(this.loadListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailedToLoad(final GdtAdError gdtAdError) {
        final WeakReference weakReference = new WeakReference(this);
        new Handler().post(new Runnable() { // from class: com.tencent.gdtad.api.GdtAd.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAdListener gdtAdListener;
                GdtAd gdtAd = (GdtAd) weakReference.get();
                if (gdtAd != null) {
                    if (gdtAd.weakListener != null) {
                        gdtAdListener = (GdtAdListener) gdtAd.weakListener.get();
                    } else {
                        gdtAdListener = null;
                    }
                    if (gdtAdListener != null) {
                        GdtLog.i(GdtAd.TAG, "notifyFailedToLoad");
                        gdtAdListener.onAdFailedToLoad(gdtAd, gdtAdError);
                    }
                }
                GdtLog.e(GdtAd.TAG, "notifyFailedToLoad error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLoaded() {
        final WeakReference weakReference = new WeakReference(this);
        new Handler().post(new Runnable() { // from class: com.tencent.gdtad.api.GdtAd.2
            @Override // java.lang.Runnable
            public void run() {
                GdtAdListener gdtAdListener;
                GdtAd gdtAd = (GdtAd) weakReference.get();
                if (gdtAd != null) {
                    if (gdtAd.weakListener != null) {
                        gdtAdListener = (GdtAdListener) gdtAd.weakListener.get();
                    } else {
                        gdtAdListener = null;
                    }
                    if (gdtAdListener != null) {
                        GdtLog.i(GdtAd.TAG, "notifyLoaded");
                        gdtAdListener.onAdLoaded(gdtAd);
                        return;
                    }
                }
                GdtLog.e(GdtAd.TAG, "notifyLoaded error");
            }
        });
    }

    @Nullable
    public com.tencent.gdtad.aditem.GdtAd getAd() {
        if (isLoaded()) {
            return getParams().clickParams.f108486ad;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getErrorCode(@Nullable com.tencent.gdtad.aditem.GdtAd gdtAd, int i3, int i16, int i17) {
        if (i3 == Integer.MIN_VALUE) {
            return 3;
        }
        if (i3 != 0) {
            return 6;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                return 6;
            }
            return 4;
        }
        if (i17 != 0) {
            if (i17 != 102006) {
                return 6;
            }
            return 5;
        }
        if (gdtAd == null || !gdtAd.isValid()) {
            return 1;
        }
        return 0;
    }

    public GdtAdLoader getGdtAdLoader() {
        return this.loader;
    }

    protected abstract GdtAdParams getParams();

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        if (getParams() != null && getParams().clickParams != null && getParams().clickParams.f108486ad != null && getParams().clickParams.f108486ad.isValid()) {
            this.status = 2;
            this.loadedTimeMillis = System.currentTimeMillis();
        }
    }

    public boolean isInvalidated() {
        if (isLoaded() && SystemClock.elapsedRealtime() - this.loadedTimeMillis > 86400000) {
            return true;
        }
        return false;
    }

    public boolean isLoaded() {
        if (isValid() && this.status == 2 && getParams().clickParams.f108486ad != null && getParams().clickParams.f108486ad.isValid() && this.loadedTimeMillis != Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValid() {
        if (getParams() != null && getParams().isValid()) {
            return true;
        }
        return false;
    }

    public boolean load(@Nullable Context context) {
        int i3;
        if (context != null && isValid() && getParams().requestParams != null && ((i3 = this.status) == 0 || i3 == 3)) {
            if (loadingTimeMillis != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && SystemClock.elapsedRealtime() - loadingTimeMillis <= 60000) {
                if (loadCountDuringOneMinite >= 30) {
                    this.status = 3;
                    notifyFailedToLoad(new GdtAdError(2));
                }
            } else {
                loadCountDuringOneMinite = 0;
                loadingTimeMillis = SystemClock.elapsedRealtime();
            }
            this.status = 1;
            loadCountDuringOneMinite++;
            this.loader.load(new WeakReference<>(context));
            return true;
        }
        GdtLog.e(TAG, String.format("load error, status:%d", Integer.valueOf(this.status)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyClicked() {
        final WeakReference weakReference = new WeakReference(this);
        new Handler().post(new Runnable() { // from class: com.tencent.gdtad.api.GdtAd.4
            @Override // java.lang.Runnable
            public void run() {
                GdtAdListener gdtAdListener;
                GdtAd gdtAd = (GdtAd) weakReference.get();
                if (gdtAd != null) {
                    if (gdtAd.weakListener != null) {
                        gdtAdListener = (GdtAdListener) gdtAd.weakListener.get();
                    } else {
                        gdtAdListener = null;
                    }
                    if (gdtAdListener != null) {
                        GdtLog.i(GdtAd.TAG, "notifyClicked");
                        gdtAdListener.onAdClicked(gdtAd);
                    }
                }
                GdtLog.e(GdtAd.TAG, "notifyClicked error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyClosed() {
        final WeakReference weakReference = new WeakReference(this);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.GdtAd.5
            @Override // java.lang.Runnable
            public void run() {
                GdtAdListener gdtAdListener;
                GdtAd gdtAd = (GdtAd) weakReference.get();
                if (gdtAd != null) {
                    if (gdtAd.weakListener != null) {
                        gdtAdListener = (GdtAdListener) gdtAd.weakListener.get();
                    } else {
                        gdtAdListener = null;
                    }
                    if (gdtAdListener != null) {
                        GdtLog.i(GdtAd.TAG, "notifyClosed");
                        gdtAdListener.onAdClosed(gdtAd);
                    }
                }
                GdtLog.e(GdtAd.TAG, "notifyClosed error");
            }
        }, 0);
    }

    protected void notifyImpression() {
        final WeakReference weakReference = new WeakReference(this);
        new Handler().post(new Runnable() { // from class: com.tencent.gdtad.api.GdtAd.3
            @Override // java.lang.Runnable
            public void run() {
                GdtAdListener gdtAdListener;
                GdtAd gdtAd = (GdtAd) weakReference.get();
                if (gdtAd != null) {
                    if (gdtAd.weakListener != null) {
                        gdtAdListener = (GdtAdListener) gdtAd.weakListener.get();
                    } else {
                        gdtAdListener = null;
                    }
                    if (gdtAdListener != null) {
                        GdtLog.i(GdtAd.TAG, "notifyImpression");
                        gdtAdListener.onAdImpression(gdtAd);
                    }
                }
                GdtLog.e(GdtAd.TAG, "notifyImpression error");
            }
        });
    }

    @Override // com.tencent.gdtad.api.IGdtAd
    public void setListener(WeakReference<GdtAdListener> weakReference) {
        this.weakListener = weakReference;
    }
}
