package com.tencent.qqlive.tvkplayer.logo.api;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.TVKDarkLogoPlugin;
import com.tencent.qqlive.tvkplayer.logo.TVKLogoPlugin;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKLogoPluginFactory {
    private static final String TAG = "TVKPlayer[TVKLogoPluginFactory]";

    public static ITVKPlugin createLogoPlugin(@NonNull TVKContext tVKContext, ViewGroup viewGroup) {
        if (!TVKMediaPlayerConfig.PlayerConfig.is_use_logo) {
            TVKLogUtil.w(TAG, "playerconfig disable logo, return null");
            return null;
        }
        return new TVKLogoPlugin(tVKContext, viewGroup);
    }

    public static ITVKPlugin createOverlayLogoPlugin(@NonNull TVKContext tVKContext, ViewGroup viewGroup) {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_dark_logo) {
            TVKLogUtil.w(TAG, "playerconfig disable dark logo, return null");
            return null;
        }
        return new TVKDarkLogoPlugin(tVKContext, viewGroup);
    }
}
