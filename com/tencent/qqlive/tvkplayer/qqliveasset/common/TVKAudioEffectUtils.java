package com.tencent.qqlive.tvkplayer.qqliveasset.common;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKClearVoiceFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKLiveConcertFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKPanoSurroundFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKSurroundFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioEffectUtils {
    private static Map<String, TVKAudioEffectType> sAudioFxNameTypeMap;

    static {
        HashMap hashMap = new HashMap();
        sAudioFxNameTypeMap = hashMap;
        hashMap.put(TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_PANO_SURROUND, TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_PANO_SURROUND);
        sAudioFxNameTypeMap.put(TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_CLEAR_VOICE, TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_CLEAR_VOICE);
        sAudioFxNameTypeMap.put(TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_LIVE_CONCERT, TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_LIVE_CONCERT);
        sAudioFxNameTypeMap.put(TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_SURROUND, TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_SURROUND);
    }

    public static String convertToAudioEffectNameByObject(ITVKAudioFx iTVKAudioFx) {
        if (iTVKAudioFx instanceof ITVKPanoSurroundFx) {
            return TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_PANO_SURROUND;
        }
        if (iTVKAudioFx instanceof ITVKClearVoiceFx) {
            return TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_CLEAR_VOICE;
        }
        if (iTVKAudioFx instanceof ITVKLiveConcertFx) {
            return TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_LIVE_CONCERT;
        }
        if (iTVKAudioFx instanceof ITVKSurroundFx) {
            return TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_SURROUND;
        }
        return "";
    }

    public static TVKAudioEffectType convertToAudioEffectTypeByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE;
        }
        if (sAudioFxNameTypeMap.containsKey(str)) {
            return sAudioFxNameTypeMap.get(str);
        }
        return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE;
    }

    public static TVKAudioEffectType convertToAudioEffectTypeByObject(ITVKAudioFx iTVKAudioFx) {
        if (iTVKAudioFx == null) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE;
        }
        if (iTVKAudioFx instanceof ITVKPanoSurroundFx) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_PANO_SURROUND;
        }
        if (iTVKAudioFx instanceof ITVKClearVoiceFx) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_CLEAR_VOICE;
        }
        if (iTVKAudioFx instanceof ITVKLiveConcertFx) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_LIVE_CONCERT;
        }
        if (iTVKAudioFx instanceof ITVKSurroundFx) {
            return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_SURROUND;
        }
        return TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE;
    }
}
