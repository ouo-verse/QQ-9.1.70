package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKTrackUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKOnFunctionCompleteListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKBaseUniversalAccompanyFunction extends TVKBaseAccompanyFunction {
    protected static final long SWITCH_DATA_SOURCE_WITH_EXTERNAL_TRACK = -1000;
    protected TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    private final ITVKOnFunctionCompleteListener mEmptyOnFunctionCompleteListener;
    protected final ITVKLogger mLogger;
    protected final ITVKMediaSourceListener mMediaSourceListener = new MediaSourceListener();
    protected ITVKOnFunctionCompleteListener mOnFunctionCompleteListener;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class MediaSourceListener implements ITVKMediaSourceListener {
        MediaSourceListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onFailure(int i3, ITVKAsset iTVKAsset, @NonNull TVKError tVKError) {
            TVKBaseUniversalAccompanyFunction.this.processOnNetVideoInfoFailure(i3, tVKError);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onSuccess(int i3, ITVKAsset iTVKAsset, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
            if (TVKBaseUniversalAccompanyFunction.this.processOnNetVideoInfoSuccess(i3, iTPMediaAsset, tVKNetVideoInfo)) {
                TVKBaseUniversalAccompanyFunction.this.mAssetPlayerContext.getPlayerSharedOperator().processCGIRequestSuccess(tVKNetVideoInfo);
            }
        }
    }

    public TVKBaseUniversalAccompanyFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull String str) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, str);
        ITVKOnFunctionCompleteListener iTVKOnFunctionCompleteListener = new ITVKOnFunctionCompleteListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.a
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKOnFunctionCompleteListener
            public final void onComplete(ITVKFunction iTVKFunction) {
                TVKBaseUniversalAccompanyFunction.this.lambda$new$0(iTVKFunction);
            }
        };
        this.mEmptyOnFunctionCompleteListener = iTVKOnFunctionCompleteListener;
        this.mOnFunctionCompleteListener = iTVKOnFunctionCompleteListener;
    }

    private void deselectOldSubtitleTrack() {
        int trackIdByName;
        TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
        if (trackInfo == null) {
            return;
        }
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getToBeRemovedVinfoTrackForTPPlayerList()) {
            if (tVKTrackInfo.isSelected() && tVKTrackInfo.getTrackType() == 3 && (trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, trackInfo)) != -1) {
                this.mAssetPlayerContext.getPlayer().deselectTrackAsync(trackIdByName, trackIdByName);
            }
        }
    }

    private List<Integer> getToBeSelectedAudioTrackIndexes() {
        int trackIdByName;
        TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
        ArrayList arrayList = new ArrayList();
        Iterator<TVKTrackInfo> it = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TVKTrackInfo next = it.next();
            if (next.isSelected() && next.getTrackType() == 2 && (next instanceof TVKAudioTrackVinfo)) {
                TVKAudioTrackVinfo tVKAudioTrackVinfo = (TVKAudioTrackVinfo) next;
                if (!tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate() && tVKAudioTrackVinfo.getAudioTrackInfo().getTrackType() != 1 && !TextUtils.isEmpty(tVKAudioTrackVinfo.getAudioTrackInfo().getAudioPlayUrl()) && (trackIdByName = TVKTrackUtils.getTrackIdByName(next, trackInfo)) != -1) {
                    arrayList.add(Integer.valueOf(trackIdByName));
                    break;
                }
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Integer> getToBeSelectedSubtitleTrackIndexes() {
        TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
        ArrayList arrayList = new ArrayList();
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo.isSelected() && tVKTrackInfo.getTrackType() == 3 && (!(tVKTrackInfo instanceof TVKSubtitleTrackVinfo) || !((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle().isAvsSeparate())) {
                int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, trackInfo);
                if (trackIdByName != -1) {
                    arrayList.add(Integer.valueOf(trackIdByName));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ITVKFunction iTVKFunction) {
        this.mLogger.error("OnFunctionCompleteListener unset! FIX ME!", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public int[] addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes() {
        this.mAssetPlayerContext.getMediaTrackSelector().addMediaTrackFromVinfo();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getToBeSelectedSubtitleTrackIndexes());
        arrayList.addAll(getToBeSelectedAudioTrackIndexes());
        if (arrayList.isEmpty()) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    protected abstract void processOnNetVideoInfoFailure(int i3, @NonNull TVKError tVKError);

    protected abstract boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public void processPlayerErrorAndFinishFunction(TVKError tVKError) {
        this.mAssetPlayerContext.getPlayerSharedOperator().processError(tVKError);
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeAndDeselectPreviousAddToCoreTrackFromVinfo() {
        int trackIdByName;
        List<TVKTrackInfo> toBeRemovedVinfoTrackForTPPlayerList = this.mAssetPlayerContext.getRuntimeParam().getToBeRemovedVinfoTrackForTPPlayerList();
        if (toBeRemovedVinfoTrackForTPPlayerList.isEmpty()) {
            return;
        }
        deselectOldSubtitleTrack();
        ArrayList arrayList = new ArrayList();
        for (TVKTrackInfo tVKTrackInfo : toBeRemovedVinfoTrackForTPPlayerList) {
            TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
            if (trackInfo == null) {
                return;
            }
            if (!TVKTrackUtils.isInternalAudioTrack(tVKTrackInfo) && (trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, trackInfo)) != -1 && !trackInfo[trackIdByName].isSelected()) {
                this.mLogger.info("removePreviousAddToCoresTrackFromVinfo track=" + tVKTrackInfo.getTrackUniqueId(), new Object[0]);
                try {
                    this.mAssetPlayerContext.getPlayer().removeTrack(trackIdByName);
                    arrayList.add(tVKTrackInfo);
                } catch (IllegalArgumentException e16) {
                    this.mLogger.error("removePreviousAddToCoresTrackFromVinfo has exception: " + e16, new Object[0]);
                }
            }
        }
        toBeRemovedVinfoTrackForTPPlayerList.removeAll(arrayList);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void setOnCompleteListener(ITVKOnFunctionCompleteListener iTVKOnFunctionCompleteListener) {
        if (iTVKOnFunctionCompleteListener == null) {
            iTVKOnFunctionCompleteListener = this.mEmptyOnFunctionCompleteListener;
        }
        this.mOnFunctionCompleteListener = iTVKOnFunctionCompleteListener;
    }
}
