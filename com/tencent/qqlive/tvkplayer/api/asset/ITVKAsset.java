package com.tencent.qqlive.tvkplayer.api.asset;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKAsset extends Serializable {
    public static final int ASSET_TYPE_AFD_FILE = 8;
    public static final int ASSET_TYPE_LIVE_PID = 256;
    public static final int ASSET_TYPE_LIVE_SID = 512;
    public static final int ASSET_TYPE_OFFLINE_VOD_VID = 262144;
    public static final int ASSET_TYPE_ONLINE_SIMULATED_LIVE = 1048576;
    public static final int ASSET_TYPE_ONLINE_VOD_QUICK_PLAY = 524288;
    public static final int ASSET_TYPE_ONLINE_VOD_VID = 131072;
    public static final int ASSET_TYPE_ONLINE_VOD_XML = 65536;
    public static final int ASSET_TYPE_PFD_FILE = 4;
    public static final int ASSET_TYPE_URL = 2;
    public static final int LIVE_ASSET_MASK_BIT = 65280;
    public static final int NOT_QQLIVE_ASSET_MASK_BIT = 255;
    public static final int VOD_ASSET_MASK_BIT = 16711680;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AssetType {
    }

    int getAssetType();

    boolean isAssetValid();
}
