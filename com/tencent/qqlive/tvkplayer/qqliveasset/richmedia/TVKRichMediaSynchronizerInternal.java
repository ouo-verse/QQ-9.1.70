package com.tencent.qqlive.tvkplayer.qqliveasset.richmedia;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.TVKRichMediaSynchronizerInternal;
import com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.richmedia.api.TVKRichMediaFactory;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaSynchronizerInternal implements ITVKRichMediaSynchronizerInternal {
    private static final String MODULE_NAME = "RichMediaSynchronizer";

    @Nullable
    private ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mAssetPlayerListener;

    @NonNull
    private final Handler mCallbackThreadHandler;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKPlayerInputParam mPlayerInputParam;

    @NonNull
    private final TVKPlayerRuntimeParam mPlayerRuntimeParam;
    private ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener mSynchronizerListener;

    @NonNull
    private final ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener mOnPreparedListener = new TVKPrivateRichMediaListener();

    @NonNull
    private volatile ITVKPrivateRichMediaSynchronizer mPrivateRichMediaSynchronizer = createAndInitPrivateRichMediaSynchronizer();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class TVKPrivateRichMediaListener implements ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener {
        TVKPrivateRichMediaListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyPrepared() {
            ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener = TVKRichMediaSynchronizerInternal.this.mAssetPlayerListener;
            if (iTVKQQLiveAssetPlayerListener != null) {
                iTVKQQLiveAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 0L, 0L, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyPreparedFailed() {
            ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener = TVKRichMediaSynchronizerInternal.this.mAssetPlayerListener;
            if (iTVKQQLiveAssetPlayerListener != null) {
                iTVKQQLiveAssetPlayerListener.onInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED, 0L, 0L, null);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener
        public void onRichMediaPrepareFailed() {
            TVKRichMediaSynchronizerInternal.this.mLogger.info("onInfo: PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED", new Object[0]);
            TVKRichMediaSynchronizerInternal.this.mCallbackThreadHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.d
                @Override // java.lang.Runnable
                public final void run() {
                    TVKRichMediaSynchronizerInternal.TVKPrivateRichMediaListener.this.notifyPreparedFailed();
                }
            });
        }

        @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener
        public void onRichMediaPrepared() {
            TVKRichMediaSynchronizerInternal.this.mLogger.info("onInfo: PLAYER_INFO_ON_RICH_MEDIA_PREPARED", new Object[0]);
            TVKRichMediaSynchronizerInternal.this.mCallbackThreadHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.c
                @Override // java.lang.Runnable
                public final void run() {
                    TVKRichMediaSynchronizerInternal.TVKPrivateRichMediaListener.this.notifyPrepared();
                }
            });
        }
    }

    public TVKRichMediaSynchronizerInternal(@NonNull TVKContext tVKContext, @NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mPlayerInputParam = tVKPlayerInputParam;
        this.mPlayerRuntimeParam = tVKPlayerRuntimeParam;
        this.mCallbackThreadHandler = new Handler(tVKPlayerInputParam.getWorkThreadLooper());
    }

    private ITVKPrivateRichMediaSynchronizer createAndInitPrivateRichMediaSynchronizer() {
        ITVKPrivateRichMediaSynchronizer createRichMediaImpl = TVKRichMediaFactory.createRichMediaImpl();
        createRichMediaImpl.setOnRichMediaPreparedListener(this.mOnPreparedListener);
        createRichMediaImpl.setListener(this.mSynchronizerListener);
        return createRichMediaImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetAndRelease, reason: merged with bridge method [inline-methods] */
    public void lambda$reset$0(@NonNull ITVKPrivateRichMediaSynchronizer iTVKPrivateRichMediaSynchronizer) {
        try {
            try {
                iTVKPrivateRichMediaSynchronizer.reset();
            } catch (IllegalStateException e16) {
                this.mLogger.printException(e16);
            }
        } finally {
            iTVKPrivateRichMediaSynchronizer.release();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public boolean activateRichMedia(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (this.mPlayerInputParam.getPlayerVideoInfo() == null) {
            this.mLogger.info("playerVideoInfo is null, no need setup rich media", new Object[0]);
            return false;
        }
        if (this.mPlayerRuntimeParam.getTVKAsset() == null) {
            this.mLogger.info("asset is null, no need setup rich media", new Object[0]);
            return false;
        }
        if (tVKNetVideoInfo.getTVKRichMediaInfo() != null && !TextUtils.isEmpty(tVKNetVideoInfo.getTVKRichMediaInfo().getRichMediaUrl())) {
            try {
                this.mPrivateRichMediaSynchronizer.setRichMediaFuncListUrl(tVKNetVideoInfo.getTVKRichMediaInfo().getRichMediaUrl());
                this.mPrivateRichMediaSynchronizer.prepareAsync();
                return true;
            } catch (IllegalArgumentException | IllegalStateException e16) {
                this.mLogger.printException(e16);
                return false;
            }
        }
        this.mLogger.info("no rich media url, return", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public void connectToPlayer(@NonNull ITVKTPPlayer iTVKTPPlayer) {
        iTVKTPPlayer.setRichMediaSynchronizer(this.mPrivateRichMediaSynchronizer.getITPRichMediaSynchronizer());
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void deselectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        if (tVKRichMediaFeature != null) {
            if (!tVKRichMediaFeature.isInternal()) {
                this.mPrivateRichMediaSynchronizer.deselectAsync(tVKRichMediaFeature);
                return;
            }
            throw new IllegalArgumentException("feature is internal");
        }
        throw new IllegalArgumentException("feature can not be null");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public List<TVKRichMediaFeature> getFeatureList() {
        return this.mPrivateRichMediaSynchronizer.getFeatureList();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public boolean isPrepared() {
        return this.mPrivateRichMediaSynchronizer.isHasRichMediaPrepared();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public void release() {
        ExecutorService obtainNormalPriorityExecutor = TVKThreadPool.getInstance().obtainNormalPriorityExecutor();
        final ITVKPrivateRichMediaSynchronizer iTVKPrivateRichMediaSynchronizer = this.mPrivateRichMediaSynchronizer;
        Objects.requireNonNull(iTVKPrivateRichMediaSynchronizer);
        obtainNormalPriorityExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.a
            @Override // java.lang.Runnable
            public final void run() {
                ITVKPrivateRichMediaSynchronizer.this.release();
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public void reset() {
        final ITVKPrivateRichMediaSynchronizer iTVKPrivateRichMediaSynchronizer = this.mPrivateRichMediaSynchronizer;
        this.mPrivateRichMediaSynchronizer = createAndInitPrivateRichMediaSynchronizer();
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKRichMediaSynchronizerInternal.this.lambda$reset$0(iTVKPrivateRichMediaSynchronizer);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void selectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        if (tVKRichMediaFeature != null) {
            if (!tVKRichMediaFeature.isInternal()) {
                this.mPrivateRichMediaSynchronizer.selectAsync(tVKRichMediaFeature);
                return;
            }
            throw new IllegalArgumentException("feature is internal");
        }
        throw new IllegalArgumentException("feature can not be null");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void setListener(ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener) {
        this.mSynchronizerListener = iTVKRichMediaSynchronizerListener;
        this.mPrivateRichMediaSynchronizer.setListener(iTVKRichMediaSynchronizerListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.richmedia.ITVKRichMediaSynchronizerInternal
    public void setQQLiveAssetPlayerListener(@Nullable ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener iTVKQQLiveAssetPlayerListener) {
        this.mAssetPlayerListener = iTVKQQLiveAssetPlayerListener;
    }
}
