package com.tencent.thumbplayer.api.asset;

import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPMediaAssetParamMap extends ITPMediaAssetObjectParam {
    public static final String TP_ASSET_PARAM_KEY_FLOAT_DASH_TRACK_FRAMERATE = "dash_track_framerate";
    public static final String TP_ASSET_PARAM_KEY_FLOAT_HLS_TRACK_FRAMERATE = "hls_track_framerate";
    public static final String TP_ASSET_PARAM_KEY_INT_DASH_TRACK_BANDWIDTH = "dash_track_bandwidth";
    public static final String TP_ASSET_PARAM_KEY_INT_DASH_TRACK_LUMA_SAMPLES = "dash_track_luma_samples";
    public static final String TP_ASSET_PARAM_KEY_INT_HLS_TRACK_BANDWIDTH = "hls_track_bandwidth";
    public static final String TP_ASSET_PARAM_KEY_STRING_DASH_TRACK_LABEL = "dash_track_label";
    public static final String TP_ASSET_PARAM_KEY_STRING_DASH_TRACK_LANGUAGE = "dash_track_language";
    public static final String TP_ASSET_PARAM_KEY_STRING_DASH_TRACK_RESOLUTION = "dash_track_resolution";
    public static final String TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_CODECS = "hls_track_codecs";
    public static final String TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_GROUPID = "hls_track_groupid";
    public static final String TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_LANGUAGE = "hls_track_language";
    public static final String TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_NAME = "hls_track_name";
    public static final String TP_ASSET_PARAM_KEY_STRING_HLS_TRACK_RESOLUTION = "hls_track_resolution";

    void add(@NonNull String str, @NonNull String str2);

    Map<String, String> getParamMap();
}
