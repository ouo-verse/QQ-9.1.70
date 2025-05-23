package com.tencent.ad.tangram.wechat;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdWXCanvas {
    private static final String TAG = "AdWXCanvas";
    private static volatile AdWXCanvas sInstance;
    private WeakReference<AdWXCanvasAdapter> adapter;

    AdWXCanvas() {
    }

    @Nullable
    private AdWXCanvasAdapter getAdapter() {
        WeakReference<AdWXCanvasAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdWXCanvas getInstance() {
        if (sInstance == null) {
            synchronized (AdWXCanvas.class) {
                if (sInstance == null) {
                    sInstance = new AdWXCanvas();
                }
            }
        }
        return sInstance;
    }

    public void setAdapter(WeakReference<AdWXCanvasAdapter> weakReference) {
        this.adapter = weakReference;
    }

    @Nullable
    public AdError show(Params params) {
        AdWXCanvasAdapter adapter = getAdapter();
        if (adapter == null) {
            AdLog.e(TAG, "show error, adapter is null");
            return new AdError(307);
        }
        return adapter.show(params);
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: ad, reason: collision with root package name */
        public Ad f61349ad;
        public String channelAppID;
        public WeakReference<Context> context;
        public String extInfo;
        public long videoStartPositionMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        public boolean reportForLinkEvent = false;

        private static long getOutPlaybackTimeMillis(long j3, long j16) {
            if (j3 < 0 || j16 == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            return j3 + j16;
        }

        public String getExtInfo() {
            long j3 = AdConfigManager.getInstance().isWXCanvasVideoOffsetEnabled() ? -2000L : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long outPlaybackTimeMillis = getOutPlaybackTimeMillis(this.videoStartPositionMillis, j3);
            AdLog.i(AdWXCanvas.TAG, "[getExtInfo] videoStartPositionMillis:" + this.videoStartPositionMillis + " videoOffsetTimeMillis:" + j3 + " outPlaybackTimeMillis:" + outPlaybackTimeMillis);
            return getExtInfo(this.extInfo, outPlaybackTimeMillis);
        }

        public boolean isValid() {
            WeakReference<Context> weakReference = this.context;
            if (weakReference != null && weakReference.get() != null && !TextUtils.isEmpty(this.channelAppID) && !TextUtils.isEmpty(this.extInfo)) {
                return true;
            }
            return false;
        }

        private static String getExtInfo(String str, long j3) {
            if (j3 == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("outPlaybackTimeMs", j3);
                return jSONObject.toString();
            } catch (Throwable th5) {
                AdLog.e(AdWXCanvas.TAG, "[getExtInfo] outPlaybackTimeMs:" + j3, th5);
                return str;
            }
        }
    }
}
