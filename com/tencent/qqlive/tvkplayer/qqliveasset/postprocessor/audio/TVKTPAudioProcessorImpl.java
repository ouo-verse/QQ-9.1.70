package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKAudioEffectInfo;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioPostProcessorListener;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKAudioEffectUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKTPAudioProcessorImpl implements ITVKTPAudioProcessorInternal {
    private static String TAG = "TVKTPAudioProcessor";

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    private ITVKAudioFx mCurrentAudioFx;
    private boolean mIsConnect = false;
    List<TVKVodVideoInfo.TVKAudioEffectModel> mLocalAudioEffectModels = new ArrayList();

    public TVKTPAudioProcessorImpl(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        initLocalEffectModels();
    }

    private void applyAudioEffectDescription(ITVKAudioFx iTVKAudioFx) {
        String audioFilterParams = getAudioFilterParams(iTVKAudioFx);
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildString(TPOptionalID.OPTIONAL_ID_GLOBAL_STRING_FFMPEG_AUDIO_FILTER_DESCRIPTION, audioFilterParams));
        TVKLogUtil.i(TAG, "applyAudioEffectDescription effect:" + iTVKAudioFx + " params:" + audioFilterParams);
    }

    private List<TVKAudioEffectInfo> generateAudioEffectInfoList() {
        ArrayList arrayList = new ArrayList();
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo instanceof TVKVodVideoInfo) {
            generateAudioEffectInfoFromModelList(((TVKVodVideoInfo) netVideoInfo).getAudioEffectList(), arrayList);
        }
        generateAudioEffectInfoFromModelList(this.mLocalAudioEffectModels, arrayList);
        return arrayList;
    }

    private String getAudioFilterParams(ITVKAudioFx iTVKAudioFx) {
        if (iTVKAudioFx == null) {
            return "";
        }
        for (TVKVodVideoInfo.TVKAudioEffectModel tVKAudioEffectModel : this.mLocalAudioEffectModels) {
            if (tVKAudioEffectModel.getEffectName().equals(TVKAudioEffectUtils.convertToAudioEffectNameByObject(iTVKAudioFx))) {
                return tVKAudioEffectModel.getEffectFilterParam();
            }
        }
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo instanceof TVKVodVideoInfo) {
            for (TVKVodVideoInfo.TVKAudioEffectModel tVKAudioEffectModel2 : ((TVKVodVideoInfo) netVideoInfo).getAudioEffectList()) {
                if (tVKAudioEffectModel2.getEffectName().equals(TVKAudioEffectUtils.convertToAudioEffectNameByObject(iTVKAudioFx))) {
                    return tVKAudioEffectModel2.getEffectFilterParam();
                }
            }
        }
        return "";
    }

    private void initLocalEffectModels() {
        TVKVodVideoInfo.TVKAudioEffectModel tVKAudioEffectModel = new TVKVodVideoInfo.TVKAudioEffectModel();
        tVKAudioEffectModel.setEffectName(TVKVodVideoInfo.TVKAudioEffectModel.AUDIO_EFFECT_NAME_SURROUND);
        tVKAudioEffectModel.setEffectFilterParam("zhencai");
        tVKAudioEffectModel.setEffectShowName("\u81fb\u5f69\u73af\u7ed5");
        tVKAudioEffectModel.setVipLimit(0);
        this.mLocalAudioEffectModels.add(tVKAudioEffectModel);
    }

    private boolean isAudioEffectSupported(@NonNull ITVKAudioFx iTVKAudioFx) {
        Iterator<TVKVodVideoInfo.TVKAudioEffectModel> it = this.mLocalAudioEffectModels.iterator();
        while (it.hasNext()) {
            if (it.next().getEffectName().equals(TVKAudioEffectUtils.convertToAudioEffectNameByObject(iTVKAudioFx))) {
                return true;
            }
        }
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo instanceof TVKVodVideoInfo) {
            Iterator<TVKVodVideoInfo.TVKAudioEffectModel> it5 = ((TVKVodVideoInfo) netVideoInfo).getAudioEffectList().iterator();
            while (it5.hasNext()) {
                if (it5.next().getEffectName().equals(TVKAudioEffectUtils.convertToAudioEffectNameByObject(iTVKAudioFx))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void notifyAudioPostProcessInfoEvent(ITVKAudioFx iTVKAudioFx) {
        TVKEventParams.AudioEffectInfoParam audioEffectInfoParam = new TVKEventParams.AudioEffectInfoParam();
        ArrayList arrayList = new ArrayList();
        audioEffectInfoParam.audioEffectTypes = arrayList;
        arrayList.add(TVKAudioEffectUtils.convertToAudioEffectTypeByObject(iTVKAudioFx));
        try {
            this.mAssetPlayerContext.getEventSender().sendEvent(TVKEventId.PLAYER_STATE_AUDIO_EFFECT_TYPE_INFO, 0, 0, "", audioEffectInfoParam);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "sendEvent audioEffectTypeInfo, exception=" + e16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public boolean addEffect(ITVKAudioFx iTVKAudioFx) {
        if (iTVKAudioFx == null) {
            TVKLogUtil.w(TAG, "addEffect has failed! effect is null");
            return false;
        }
        ITVKAudioFx iTVKAudioFx2 = this.mCurrentAudioFx;
        if (iTVKAudioFx2 == iTVKAudioFx) {
            TVKLogUtil.w(TAG, "effect has added!");
            return true;
        }
        if (iTVKAudioFx2 != null && iTVKAudioFx2 != iTVKAudioFx) {
            TVKLogUtil.w(TAG, "addEffect has failed! firstly remove current running effect:" + this.mCurrentAudioFx.audioFxDescription());
            return false;
        }
        if (!isAudioEffectSupported(iTVKAudioFx)) {
            TVKLogUtil.w(TAG, "addEffect has failed! the effect is not support");
            return false;
        }
        TVKLogUtil.i(TAG, "addEffect, effect=" + iTVKAudioFx);
        this.mCurrentAudioFx = iTVKAudioFx;
        if (this.mIsConnect) {
            applyAudioEffectDescription(iTVKAudioFx);
            notifyAudioPostProcessInfoEvent(this.mCurrentAudioFx);
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch
    public void connect() {
        this.mIsConnect = true;
        ITVKAudioFx iTVKAudioFx = this.mCurrentAudioFx;
        if (iTVKAudioFx != null) {
            applyAudioEffectDescription(iTVKAudioFx);
            notifyAudioPostProcessInfoEvent(this.mCurrentAudioFx);
        }
        TVKLogUtil.i(TAG, "connect, effect:" + this.mCurrentAudioFx);
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public ITVKAudioFx currentEffect() {
        return this.mCurrentAudioFx;
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch
    public void destroy() {
        reset();
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch
    public void disconnect() {
        if (!this.mIsConnect) {
            return;
        }
        this.mIsConnect = false;
        applyAudioEffectDescription(null);
        notifyAudioPostProcessInfoEvent(null);
        TVKLogUtil.i(TAG, "disconnct");
    }

    void generateAudioEffectInfoFromModelList(@NonNull List<TVKVodVideoInfo.TVKAudioEffectModel> list, @NonNull List<TVKAudioEffectInfo> list2) {
        TVKAudioEffectType convertToAudioEffectTypeByObject;
        ITVKAudioFx iTVKAudioFx = this.mCurrentAudioFx;
        if (iTVKAudioFx == null) {
            convertToAudioEffectTypeByObject = TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE;
        } else {
            convertToAudioEffectTypeByObject = TVKAudioEffectUtils.convertToAudioEffectTypeByObject(iTVKAudioFx);
        }
        for (TVKVodVideoInfo.TVKAudioEffectModel tVKAudioEffectModel : list) {
            TVKAudioEffectType convertToAudioEffectTypeByName = TVKAudioEffectUtils.convertToAudioEffectTypeByName(tVKAudioEffectModel.getEffectName());
            if (convertToAudioEffectTypeByName == TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_NONE) {
                TVKLogUtil.w(TAG, "the effect type is not support, ignore it, effect name:" + tVKAudioEffectModel.getEffectName());
            } else if (TextUtils.isEmpty(tVKAudioEffectModel.getEffectFilterParam())) {
                TVKLogUtil.w(TAG, "the effect filterparam is empty, ignore it, effect name:" + tVKAudioEffectModel.getEffectName());
            } else {
                TVKAudioEffectInfo tVKAudioEffectInfo = new TVKAudioEffectInfo();
                tVKAudioEffectInfo.setEffectType(convertToAudioEffectTypeByName);
                tVKAudioEffectInfo.setEffectName(tVKAudioEffectModel.getEffectName());
                tVKAudioEffectInfo.setEffectShowName(tVKAudioEffectModel.getEffectShowName());
                tVKAudioEffectInfo.setVipLimit(tVKAudioEffectModel.getVipLimit());
                if (convertToAudioEffectTypeByName == convertToAudioEffectTypeByObject && this.mIsConnect) {
                    tVKAudioEffectInfo.setSelected(true);
                }
                list2.add(tVKAudioEffectInfo);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public TVKAudioEffectInfo[] getSupportedAudioEffectInfo() {
        if (this.mAssetPlayerContext.getPlayer().getPlayerCoreType() != 2) {
            return new TVKAudioEffectInfo[0];
        }
        return (TVKAudioEffectInfo[]) generateAudioEffectInfoList().toArray(new TVKAudioEffectInfo[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public boolean hasAudioEffect() {
        if (this.mCurrentAudioFx != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    @TVKThreadAnnotations.ThreadSwitch
    public void removeAllEffects() {
        if (this.mIsConnect) {
            applyAudioEffectDescription(null);
            notifyAudioPostProcessInfoEvent(null);
        }
        this.mCurrentAudioFx = null;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    @TVKThreadAnnotations.ThreadSwitch
    public void removeEffect(ITVKAudioFx iTVKAudioFx) {
        if (this.mCurrentAudioFx != iTVKAudioFx) {
            TVKLogUtil.w(TAG, "effect wasn't loaded in processor, can not be removed");
            return;
        }
        TVKLogUtil.i(TAG, "removeEffect, effect=" + iTVKAudioFx);
        if (this.mIsConnect) {
            applyAudioEffectDescription(null);
            notifyAudioPostProcessInfoEvent(null);
        }
        this.mCurrentAudioFx = null;
    }

    @Override // com.tencent.qqlive.tvkplayer.postprocess.api.ITVKTPAudioProcessorInternal
    @TVKThreadAnnotations.ThreadSwitch
    public void reset() {
        disconnect();
        this.mCurrentAudioFx = null;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
    public void setListener(ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener) {
    }
}
