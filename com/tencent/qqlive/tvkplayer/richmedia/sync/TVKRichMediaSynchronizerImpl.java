package com.tencent.qqlive.tvkplayer.richmedia.sync;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.richmedia.utils.TVKRichMediaDataConverter;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFactory;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaOptParam;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaSynchronizerImpl implements ITVKPrivateRichMediaSynchronizer {
    private static final String TAG = "TVKRichMediaSynchronizerImpl";
    private volatile boolean mHasRichMediaPrepared;
    private ITPRichMediaSynchronizer mITPRichMediaSynchronizer;
    private ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener mITVKOnRichMediaPrepareListener;
    private final TVKRichMediaListenerAdapter mRichMediaListenerAdapter;

    public TVKRichMediaSynchronizerImpl() {
        TVKRichMediaListenerAdapter tVKRichMediaListenerAdapter = new TVKRichMediaListenerAdapter();
        this.mRichMediaListenerAdapter = tVKRichMediaListenerAdapter;
        this.mHasRichMediaPrepared = false;
        if (TVKMediaPlayerConfig.PlayerConfig.enable_create_rich_media) {
            this.mITPRichMediaSynchronizer = TPRichMediaFactory.createRichMediaSynchronizer();
        } else {
            TVKLogUtil.w(TAG, "do not create rich media by config");
        }
        if (this.mITPRichMediaSynchronizer == null) {
            TVKLogUtil.i(TAG, "mITPRichMediaSynchronizer==null, create a stub!");
            this.mITPRichMediaSynchronizer = new TVKTPRichMediaSynchronizerStub();
        }
        this.mITPRichMediaSynchronizer.setListener(tVKRichMediaListenerAdapter);
    }

    private List<TVKRichMediaFeature> convertToSyncFeatureList(TPRichMediaFeature[] tPRichMediaFeatureArr) {
        ArrayList arrayList = new ArrayList();
        if (tPRichMediaFeatureArr == null) {
            return arrayList;
        }
        for (TPRichMediaFeature tPRichMediaFeature : tPRichMediaFeatureArr) {
            TVKRichMediaPrivateSyncFeature tVKRichMediaPrivateSyncFeature = new TVKRichMediaPrivateSyncFeature(tPRichMediaFeature.getFeatureType());
            tVKRichMediaPrivateSyncFeature.setActivated(tPRichMediaFeature.isSelected());
            tVKRichMediaPrivateSyncFeature.setInternal(false);
            arrayList.add(tVKRichMediaPrivateSyncFeature);
        }
        return arrayList;
    }

    private int indexOfRichMedia(TVKRichMediaFeature tVKRichMediaFeature) {
        if (tVKRichMediaFeature == null) {
            TVKLogUtil.e(TAG, "richMediaFeature == null");
            return -1;
        }
        if (TextUtils.isEmpty(tVKRichMediaFeature.getFeatureType())) {
            TVKLogUtil.e(TAG, "richMediaFeature.getFeatureType() is empty");
            return -1;
        }
        List<TVKRichMediaFeature> featureList = getFeatureList();
        for (int i3 = 0; i3 < featureList.size(); i3++) {
            if (tVKRichMediaFeature.getFeatureType().equals(featureList.get(i3).getFeatureType())) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void deselectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        int indexOfRichMedia = indexOfRichMedia(tVKRichMediaFeature);
        if (indexOfRichMedia < 0) {
            TVKLogUtil.e(TAG, "deselectAsync, feature:" + tVKRichMediaFeature.getFeatureType() + " return invalid index:" + indexOfRichMedia);
            return;
        }
        this.mITPRichMediaSynchronizer.deselectFeatureAsync(indexOfRichMedia);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public List<TVKRichMediaFeature> getFeatureList() {
        return convertToSyncFeatureList(this.mITPRichMediaSynchronizer.getFeatures());
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public ITPRichMediaSynchronizer getITPRichMediaSynchronizer() {
        return this.mITPRichMediaSynchronizer;
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public boolean isHasRichMediaPrepared() {
        return this.mHasRichMediaPrepared;
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public void prepareAsync() throws IllegalStateException {
        TVKLogUtil.i(TAG, "api call: prepareAsync");
        this.mITPRichMediaSynchronizer.prepareAsync();
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public void release() {
        TVKLogUtil.i(TAG, "api call: release");
        this.mITPRichMediaSynchronizer.release();
        this.mRichMediaListenerAdapter.setSynchronizerListener(null);
        this.mITVKOnRichMediaPrepareListener = null;
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public void reset() throws IllegalStateException {
        TVKLogUtil.i(TAG, "api call: reset");
        this.mITPRichMediaSynchronizer.reset();
        this.mHasRichMediaPrepared = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void selectAsync(@NonNull TVKRichMediaFeature tVKRichMediaFeature) throws IllegalStateException, IllegalArgumentException {
        int indexOfRichMedia = indexOfRichMedia(tVKRichMediaFeature);
        if (indexOfRichMedia < 0) {
            TVKLogUtil.e(TAG, "selectAsync, feature:" + tVKRichMediaFeature.getFeatureType() + " return invalid index:" + indexOfRichMedia);
            return;
        }
        TPRichMediaOptParam tPRichMediaOptParam = new TPRichMediaOptParam();
        tPRichMediaOptParam.setDataCallbackType(0);
        this.mITPRichMediaSynchronizer.selectFeatureAsync(indexOfRichMedia, tPRichMediaOptParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer
    public void setListener(ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener) {
        this.mRichMediaListenerAdapter.setSynchronizerListener(iTVKRichMediaSynchronizerListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public void setOnRichMediaPreparedListener(ITVKPrivateRichMediaSynchronizer.ITVKOnRichMediaPrepareListener iTVKOnRichMediaPrepareListener) {
        this.mITVKOnRichMediaPrepareListener = iTVKOnRichMediaPrepareListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.richmedia.api.ITVKPrivateRichMediaSynchronizer
    public void setRichMediaFuncListUrl(@NonNull String str) throws IllegalStateException, IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.w(TAG, "api call: setRichMediaFuncListUrl, url is empty");
            return;
        }
        TVKLogUtil.i(TAG, "api call: setRichMediaFuncListUrl, url=" + str);
        this.mITPRichMediaSynchronizer.setRichMediaSource(TPMediaAssetFactory.createUrlMediaAsset(str));
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class TVKRichMediaListenerAdapter implements ITPRichMediaSynchronizerListener {
        private ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener mSynchronizerListener;

        TVKRichMediaListenerAdapter() {
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onDeselectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3) {
            if (this.mSynchronizerListener == null) {
                return;
            }
            List<TVKRichMediaFeature> featureList = TVKRichMediaSynchronizerImpl.this.getFeatureList();
            if (i3 >= 0 && i3 < featureList.size()) {
                this.mSynchronizerListener.onRichMediaDeselectSuccess(featureList.get(i3));
                return;
            }
            TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "onDeselectFeatureSuccess, richMediaIndex=" + i3 + "mFeatureList.size()=" + featureList.size());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onRichMediaError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, TPError tPError) {
            TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "onRichMediaError: " + tPError);
            if (!TVKRichMediaSynchronizerImpl.this.mHasRichMediaPrepared) {
                TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "tp rich media prepareAsync failed!");
                if (TVKRichMediaSynchronizerImpl.this.mITVKOnRichMediaPrepareListener != null) {
                    TVKRichMediaSynchronizerImpl.this.mITVKOnRichMediaPrepareListener.onRichMediaPrepareFailed();
                }
            }
            ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener = this.mSynchronizerListener;
            if (iTVKRichMediaSynchronizerListener == null) {
                return;
            }
            iTVKRichMediaSynchronizerListener.onRichMediaError(tPError.getErrorCode());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onRichMediaFeatureData(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, TPRichMediaData tPRichMediaData) {
            if (this.mSynchronizerListener == null) {
                return;
            }
            List<TVKRichMediaFeature> featureList = TVKRichMediaSynchronizerImpl.this.getFeatureList();
            if (i3 >= 0 && i3 < featureList.size()) {
                this.mSynchronizerListener.onRichMediaResponse(featureList.get(i3), TVKRichMediaDataConverter.convertToTVKRichMediaFeatureData(tPRichMediaData));
                return;
            }
            TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "onRichMediaData, richMediaIndex=" + i3 + "mFeatureList.size()=" + featureList.size());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onRichMediaFeatureError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, TPError tPError) {
            if (this.mSynchronizerListener == null) {
                return;
            }
            List<TVKRichMediaFeature> featureList = TVKRichMediaSynchronizerImpl.this.getFeatureList();
            if (i3 >= 0 && i3 < featureList.size()) {
                this.mSynchronizerListener.onRichMediaFeatureFailure(featureList.get(i3), tPError.getErrorCode());
                return;
            }
            TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "onRichMediaFeatureError, richMediaIndex=" + i3 + "mFeatureList.size()=" + featureList.size());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onRichMediaPrepared(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
            TVKRichMediaSynchronizerImpl.this.mHasRichMediaPrepared = true;
            TVKLogUtil.i(TVKRichMediaSynchronizerImpl.TAG, "onRichMediaPrepared");
            if (TVKRichMediaSynchronizerImpl.this.mITVKOnRichMediaPrepareListener != null) {
                TVKRichMediaSynchronizerImpl.this.mITVKOnRichMediaPrepareListener.onRichMediaPrepared();
            }
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onSelectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3) {
            if (this.mSynchronizerListener == null) {
                return;
            }
            List<TVKRichMediaFeature> featureList = TVKRichMediaSynchronizerImpl.this.getFeatureList();
            if (i3 >= 0 && i3 < featureList.size()) {
                this.mSynchronizerListener.onRichMediaSelectSuccess(featureList.get(i3));
                return;
            }
            TVKLogUtil.e(TVKRichMediaSynchronizerImpl.TAG, "onSelectFeatureSuccess, richMediaIndex=" + i3 + "mFeatureList.size()=" + featureList.size());
        }

        public void setSynchronizerListener(ITVKRichMediaSynchronizer.ITVKRichMediaSynchronizerListener iTVKRichMediaSynchronizerListener) {
            this.mSynchronizerListener = iTVKRichMediaSynchronizerListener;
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener
        public void onRichMediaInfo(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i3, TPOnInfoParam tPOnInfoParam) {
        }
    }
}
