package com.tencent.qqlive.tvkplayer.qqliveasset.context;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKMediaTrackSelector;
import com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio.TVKAudioPostProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.TVKVideoPostProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.TVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerAndDecoderChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerRetryStrategy;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerRetryStrategy;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAudioTrackSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKDefinitionSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer;
import com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.TVKSubtitleRendererControllerFactory;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKQQLiveAssetPlayerContext extends TVKContext {

    @Nullable
    private ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mAssetPlayerListener;

    @NonNull
    private final TVKAudioPostProcessor mAudioPostProcessor;

    @NonNull
    private final ITVKSwitchDispatcher mAudioTrackSwitchDispatcher;

    @NonNull
    private final ITVKSwitchDispatcher mDefinitionSwitchDispatcher;

    @NonNull
    private final TVKPlayerInputParam mInputParam;

    @NonNull
    private final TVKMediaTrackSelector mMediaTrackSelector;

    @NonNull
    private ITVKTPPlayer mPlayer;

    @NonNull
    private final ITVKPlayerAndDecoderChooser mPlayerAndDecoderChooser;

    @NonNull
    private ITVKQQLiveAssetPlayerSharedOperator mPlayerSharedOperator;

    @NonNull
    private final ITVKPlayerRetryStrategy mRetryStrategy;

    @NonNull
    private final TVKPlayerRuntimeParam mRuntimeParam;

    @NonNull
    private final TVKPlayerState mState;

    @NonNull
    private final ITVKSubtitleRenderer mSubtitleRenderer;

    @NonNull
    private final TVKVideoPostProcessor mVideoPostProcessor;

    @NonNull
    private final ITVKPlayerFeatureGroup sFeatureGroup;

    public TVKQQLiveAssetPlayerContext(@NonNull TVKContext tVKContext, @NonNull ITVKTPPlayer iTVKTPPlayer, @NonNull ITVKQQLiveAssetPlayerSharedOperator iTVKQQLiveAssetPlayerSharedOperator, @NonNull Looper looper, @Nullable Looper looper2) {
        super(tVKContext);
        TVKPlayerFeatureGroup tVKPlayerFeatureGroup = new TVKPlayerFeatureGroup(initFeatureList(tVKContext));
        this.sFeatureGroup = tVKPlayerFeatureGroup;
        this.mPlayer = iTVKTPPlayer;
        this.mPlayerSharedOperator = iTVKQQLiveAssetPlayerSharedOperator;
        TVKPlayerInputParam tVKPlayerInputParam = new TVKPlayerInputParam();
        this.mInputParam = tVKPlayerInputParam;
        TVKPlayerRuntimeParam tVKPlayerRuntimeParam = new TVKPlayerRuntimeParam();
        this.mRuntimeParam = tVKPlayerRuntimeParam;
        this.mDefinitionSwitchDispatcher = new TVKDefinitionSwitchDispatcher(this);
        this.mAudioTrackSwitchDispatcher = new TVKAudioTrackSwitchDispatcher(this);
        this.mMediaTrackSelector = new TVKMediaTrackSelector(this);
        this.mRetryStrategy = new TVKAphonePlayerRetryStrategy(tVKPlayerInputParam, tVKPlayerRuntimeParam, tVKPlayerFeatureGroup);
        this.mPlayerAndDecoderChooser = new TVKAphonePlayerAndDecoderChooser(tVKPlayerInputParam, tVKPlayerRuntimeParam, tVKPlayerFeatureGroup);
        this.mVideoPostProcessor = new TVKVideoPostProcessor(this, looper);
        this.mAudioPostProcessor = new TVKAudioPostProcessor(this, looper, looper2);
        this.mSubtitleRenderer = TVKSubtitleRendererControllerFactory.createSubtitleRendererController(this, looper);
        this.mState = new TVKPlayerState(new TVKPlayerState.OnStateChangeListener() { // from class: au3.a
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.state.TVKPlayerState.OnStateChangeListener
            public final void onStateChange(ITVKPlayerState iTVKPlayerState) {
                TVKQQLiveAssetPlayerContext.this.lambda$new$0(iTVKPlayerState);
            }
        });
    }

    private ArrayList<ITVKFeatureBase> initFeatureList(TVKContext tVKContext) {
        ArrayList<ITVKFeatureBase> arrayList = new ArrayList<>();
        arrayList.addAll(TVKFeatureFactory.createVodFeatureList(tVKContext));
        arrayList.addAll(TVKFeatureFactory.createLiveFeatureList(tVKContext));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ITVKPlayerState iTVKPlayerState) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener = this.mAssetPlayerListener;
        if (iTVKQQLiveAssetPlayerListener != null) {
            iTVKQQLiveAssetPlayerListener.onStateChange(iTVKPlayerState);
        }
    }

    @Nullable
    public ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener getAssetPlayerListener() {
        return this.mAssetPlayerListener;
    }

    @NonNull
    public TVKAudioPostProcessor getAudioPostProcessor() {
        return this.mAudioPostProcessor;
    }

    @NonNull
    public ITVKSwitchDispatcher getAudioTrackSwitchDispatcher() {
        return this.mAudioTrackSwitchDispatcher;
    }

    @NonNull
    public List<ITVKPlayerFeature> getCurrentPlayerFeatureList() {
        List<ITVKPlayerFeature> emptyList = Collections.emptyList();
        if (TVKAssetUtils.isVodAsset(this.mRuntimeParam.getTVKAsset())) {
            return this.sFeatureGroup.getVodPlayerFeatureList();
        }
        if (TVKAssetUtils.isLiveAsset(this.mRuntimeParam.getTVKAsset())) {
            return this.sFeatureGroup.getLivePlayerFeatureList();
        }
        return emptyList;
    }

    @NonNull
    public ITVKSwitchDispatcher getDefinitionSwitchDispatcher() {
        return this.mDefinitionSwitchDispatcher;
    }

    @NonNull
    public ITVKPlayerFeatureGroup getFeatureGroup() {
        return this.sFeatureGroup;
    }

    @NonNull
    public TVKPlayerInputParam getInputParam() {
        return this.mInputParam;
    }

    @NonNull
    public TVKMediaTrackSelector getMediaTrackSelector() {
        return this.mMediaTrackSelector;
    }

    @NonNull
    public ITVKTPPlayer getPlayer() {
        return this.mPlayer;
    }

    @NonNull
    public ITVKPlayerAndDecoderChooser getPlayerAndDecoderChooser() {
        return this.mPlayerAndDecoderChooser;
    }

    @NonNull
    public ITVKQQLiveAssetPlayerSharedOperator getPlayerSharedOperator() {
        return this.mPlayerSharedOperator;
    }

    @NonNull
    public ITVKPlayerRetryStrategy getRetryStrategy() {
        return this.mRetryStrategy;
    }

    @NonNull
    public TVKPlayerRuntimeParam getRuntimeParam() {
        return this.mRuntimeParam;
    }

    @NonNull
    public TVKPlayerState getState() {
        return this.mState;
    }

    @NonNull
    public ITVKSubtitleRenderer getSubtitleRenderer() {
        return this.mSubtitleRenderer;
    }

    @NonNull
    public TVKVideoPostProcessor getVideoPostProcessor() {
        return this.mVideoPostProcessor;
    }

    public void setAssetPlayerListener(@Nullable ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener) {
        this.mAssetPlayerListener = iTVKQQLiveAssetPlayerListener;
    }

    public void setPlayer(@NonNull ITVKTPPlayer iTVKTPPlayer) {
        this.mPlayer = iTVKTPPlayer;
    }

    public void setPlayerSharedOperator(@NonNull ITVKQQLiveAssetPlayerSharedOperator iTVKQQLiveAssetPlayerSharedOperator) {
        this.mPlayerSharedOperator = iTVKQQLiveAssetPlayerSharedOperator;
    }
}
