package com.tencent.qqlive.tvkplayer.security.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;

/* loaded from: classes23.dex */
public class TVKSecurityPluginFactory {
    @Nullable
    public static ITVKPlugin createSecurityPlugin(@NonNull TVKContext tVKContext) {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_polling_report) {
            return new TVKPlaybackAliveKeeper(tVKContext);
        }
        return null;
    }
}
