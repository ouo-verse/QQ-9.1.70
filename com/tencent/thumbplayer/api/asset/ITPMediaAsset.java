package com.tencent.thumbplayer.api.asset;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.resourceloader.ITPResourceLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPMediaAsset {
    public static final int ASSET_TYPE_AFD = 1;
    public static final int ASSET_TYPE_DRM = 5;
    public static final int ASSET_TYPE_MULTI_ASSET = 6;
    public static final int ASSET_TYPE_PFD = 2;
    public static final int ASSET_TYPE_RTC = 4;
    public static final int ASSET_TYPE_SIMULATED_LIVE = 8;
    public static final int ASSET_TYPE_UNKNOWN = 0;
    public static final int ASSET_TYPE_URL = 3;
    public static final String TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_AUDIO = "tp_asset_param_key_object_preferred_audio";
    public static final String TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_SUBTITLE = "tp_asset_param_key_object_preferred_subtitle";
    public static final String TP_ASSET_PARAM_KEY_OBJECT_PREFERRED_VIDEO = "tp_asset_param_key_object_preferred_video";
    public static final String TP_ASSET_PARAM_KEY_STRING_OPAQUE = "tp_asset_param_key_string_opaque";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface AssetType {
    }

    int getAssetType();

    boolean isValid();

    void setObjectParam(String str, ITPMediaAssetObjectParam iTPMediaAssetObjectParam);

    void setParam(String str, String str2);

    void setResourceLoader(@NonNull ITPResourceLoader iTPResourceLoader);
}
