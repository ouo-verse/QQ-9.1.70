package com.tencent.qqlive.tvkplayer.videotrack;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVideoTrackHelper {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class LogHelper {
        LogHelper() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printApiCallAddTrack(String str, String str2, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
            TVKLogUtil.i(str, "api : add track -> " + str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printApiCallDeselectTrack(String str, TVKTrackInfo tVKTrackInfo) {
            TVKLogUtil.i(str, "api : de select track -> " + tVKTrackInfo.getTrackName());
        }

        static void printApiCallRemoveTrack(String str, TVKTrackInfo tVKTrackInfo) {
            TVKLogUtil.i(str, "api : remove track -> " + tVKTrackInfo.getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printApiCallSelectTrack(String str, TVKTrackInfo tVKTrackInfo) {
            TVKLogUtil.i(str, "api : select track -> " + tVKTrackInfo.getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackNetVideoInfo(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player net video info -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackBufferEnd(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player buffering end -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackBufferStart(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player buffering start -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackComplete(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player complete -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackError(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player error -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackPrepared(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player prepared -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printCallbackTrackSeekComplete(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "track callback : on track player seek complete  -> " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printOpenTimeMatchedTrack(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "normal track time to open - > " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void printStartTimeMatchedTrack(String str, ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKLogUtil.i(str, "preload enable track time to start - > " + iTVKVideoTrackPlayer.getVideoTrackInfo().getTrackName());
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class Utils {
        Utils() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean contains(@NonNull TVKVideoTrackInfo tVKVideoTrackInfo, ArrayMap<String, ITVKVideoTrackPlayer> arrayMap) {
            return arrayMap.get(tVKVideoTrackInfo.getTrackName()) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean inTimeInterval(@NonNull TVKVideoTrackInfo tVKVideoTrackInfo, long j3) {
            long insertTimeMs = tVKVideoTrackInfo.getInsertTimeMs();
            long playDurationMs = tVKVideoTrackInfo.getPlayDurationMs();
            if (playDurationMs > 0) {
                if (insertTimeMs <= j3 && insertTimeMs + playDurationMs > j3) {
                    return true;
                }
                return false;
            }
            if (insertTimeMs <= j3) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isTrackActive(int i3) {
            if (i3 != 3 && i3 != 4 && i3 != 5 && i3 != 6) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean contains(@NonNull String str, ArrayMap<String, ITVKVideoTrackPlayer> arrayMap) {
            return arrayMap.get(str) != null;
        }
    }
}
