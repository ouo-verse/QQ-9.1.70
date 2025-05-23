package com.tencent.qqlive.tvkplayer.qqliveasset.feature.live;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKLivePlayerFeature;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.Map;

/* loaded from: classes23.dex */
public abstract class TVKLivePlayerFeatureBase implements ITVKLivePlayerFeature {
    private static final String MODULE_NAME = "TVKLivePlayerFeatureBase";
    protected boolean mEnable = true;
    protected final ITVKLogger mLogger;

    public TVKLivePlayerFeatureBase(@NonNull TVKContext tVKContext) {
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
    }

    private void addCapabilities(@NonNull Map<String, String> map, String str, int... iArr) {
        int optInt = TVKUtils.optInt(map.get(str), 0);
        for (int i3 : iArr) {
            optInt |= i3;
        }
        map.put(str, String.valueOf(optInt));
    }

    public static boolean isSelfPlayerAvailableForLive() {
        if (!TVKPlayerMsg.PLAYER_CHOICE_SYSTEM.equalsIgnoreCase(TVKMediaPlayerConfig.PlayerConfig.live_player) && TVKPlayerStrategy.isSelfPlayerAvailable(TVKCommParams.getApplicationContext())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addDrmCapabilities(@NonNull Map<String, String> map, int... iArr) {
        addCapabilities(map, "livedrm", iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFormatCapabilities(@NonNull Map<String, String> map, int... iArr) {
        addCapabilities(map, TVKLiveRequestBuilder.RequestParamKey.FORMAT_SUPPORT, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSpaudioCapabilities(@NonNull Map<String, String> map, int... iArr) {
        addCapabilities(map, "spaudio", iArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public void reset() {
        setEnable(true);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public void setEnable(boolean z16) {
        this.mEnable = z16;
    }
}
