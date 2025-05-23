package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ITVKDataBinder {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Factory {
        private static final String TAG = "video.IVideoDataBinder.Factory";
        private static final Map<String, ITVKDataBinder> mBinders = new ConcurrentHashMap();

        public static void init(String str, IDTTVKDataProvider iDTTVKDataProvider) {
            Log.d(TAG, "[VideoPlayReport] init binder for " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            mBinders.put(str, new TVKDataBinder(str, iDTTVKDataProvider));
        }

        public static void release(String str) {
            Log.d(TAG, "[VideoPlayReport] release binder for " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            mBinders.remove(str);
        }

        public static ITVKDataBinder with(String str) {
            ITVKDataBinder iTVKDataBinder;
            if (!TextUtils.isEmpty(str)) {
                iTVKDataBinder = mBinders.get(str);
            } else {
                iTVKDataBinder = null;
            }
            if (iTVKDataBinder == null) {
                return new DefaultTVKDataBinder();
            }
            return iTVKDataBinder;
        }
    }

    void onAdPrepared(ITVKPlayerEventListener.AdType adType, long j3);

    void onAdStop();

    void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo);

    void onOpenMedia(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, String str);

    void onUpdateReportParam(@NonNull TVKProperties tVKProperties);

    void onVideoPlay(@Nullable View view);

    void onVideoPrepared(long j3);

    void onVideoStop();
}
