package com.tencent.qqlive.tvkplayer.richmedia.async;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.api.richmedia.TVKRichMediaFeature;
import com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester;
import com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequesterListener;
import com.tencent.qqlive.tvkplayer.api.richmedia.async.TVKRichMediaTimeRange;
import com.tencent.qqlive.tvkplayer.richmedia.utils.TVKRichMediaDataConverter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPTimeRange;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaAsyncRequesterImpl implements ITVKRichMediaAsyncRequester {
    private static final int INVALID_REQUEST_ID = -1;
    private static final String TAG = "TVKRichMediaAsyncRequester";
    private final List<TVKRichMediaFeature> mFeatureList = new ArrayList();
    private final ITPRichMediaAsyncRequester mITPRichMediaAsyncRequester;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class TVKRichMediaAsyncListenerAdapter implements ITPRichMediaAsyncRequesterListener {
        private final ITVKRichMediaAsyncRequesterListener mITVKListener;

        public TVKRichMediaAsyncListenerAdapter(@NonNull ITVKRichMediaAsyncRequesterListener iTVKRichMediaAsyncRequesterListener) {
            this.mITVKListener = iTVKRichMediaAsyncRequesterListener;
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener
        public void onRequestDataError(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, int i3, int i16, TPError tPError) {
            if (i16 >= TVKRichMediaAsyncRequesterImpl.this.mFeatureList.size()) {
                TVKLogUtil.e(TVKRichMediaAsyncRequesterImpl.TAG, "onFeatureDataRequestFailure, featureIndex=" + i16 + " great than mFeatureList.size() = " + TVKRichMediaAsyncRequesterImpl.this.mFeatureList.size());
                return;
            }
            this.mITVKListener.onFeatureDataRequestFailure(TVKRichMediaAsyncRequesterImpl.this, i3, (TVKRichMediaFeature) TVKRichMediaAsyncRequesterImpl.this.mFeatureList.get(i16), tPError.getErrorCode());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener
        public void onRequestDataSuccess(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, int i3, int i16, TPRichMediaData tPRichMediaData) {
            if (i16 >= TVKRichMediaAsyncRequesterImpl.this.mFeatureList.size()) {
                TVKLogUtil.e(TVKRichMediaAsyncRequesterImpl.TAG, "onFeatureDataRequestSuccess, featureIndex=" + i16 + " great than mFeatureList.size() = " + TVKRichMediaAsyncRequesterImpl.this.mFeatureList.size());
                return;
            }
            this.mITVKListener.onFeatureDataRequestSuccess(TVKRichMediaAsyncRequesterImpl.this, i3, (TVKRichMediaFeature) TVKRichMediaAsyncRequesterImpl.this.mFeatureList.get(i16), TVKRichMediaDataConverter.convertToTVKRichMediaFeatureData(tPRichMediaData));
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener
        public void onRequesterError(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, TPError tPError) {
            this.mITVKListener.onRequesterError(TVKRichMediaAsyncRequesterImpl.this, tPError.getErrorCode());
        }

        @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener
        public void onRequesterPrepared(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester) {
            this.mITVKListener.onRequesterPrepared(TVKRichMediaAsyncRequesterImpl.this);
        }
    }

    public TVKRichMediaAsyncRequesterImpl(@NonNull ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester) {
        this.mITPRichMediaAsyncRequester = iTPRichMediaAsyncRequester;
    }

    private List<TVKRichMediaFeature> convertToAsyncFeatureList(TPRichMediaFeature[] tPRichMediaFeatureArr) {
        ArrayList arrayList = new ArrayList();
        if (tPRichMediaFeatureArr == null) {
            return arrayList;
        }
        for (TPRichMediaFeature tPRichMediaFeature : tPRichMediaFeatureArr) {
            TVKRichMediaPrivateAsyncFeature tVKRichMediaPrivateAsyncFeature = new TVKRichMediaPrivateAsyncFeature(tPRichMediaFeature.getFeatureType());
            tVKRichMediaPrivateAsyncFeature.setActivated(tPRichMediaFeature.isSelected());
            arrayList.add(tVKRichMediaPrivateAsyncFeature);
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public void cancelRequest(int i3) {
        this.mITPRichMediaAsyncRequester.cancelRequest(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public List<TVKRichMediaFeature> getFeatureList() {
        List<TVKRichMediaFeature> convertToAsyncFeatureList = convertToAsyncFeatureList(this.mITPRichMediaAsyncRequester.getFeatures());
        this.mFeatureList.clear();
        this.mFeatureList.addAll(convertToAsyncFeatureList);
        return convertToAsyncFeatureList;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public void prepareAsync() throws IllegalStateException {
        this.mITPRichMediaAsyncRequester.prepareAsync();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public void release() {
        this.mITPRichMediaAsyncRequester.release();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMs(TVKRichMediaFeature tVKRichMediaFeature, long j3) {
        if (tVKRichMediaFeature == null) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeMs, feature == null");
            return -1;
        }
        int indexOf = this.mFeatureList.indexOf(tVKRichMediaFeature);
        if (indexOf < 0) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeMs, index feature:" + tVKRichMediaFeature.getFeatureType() + ContainerUtils.KEY_VALUE_DELIMITER + indexOf);
            return -1;
        }
        return this.mITPRichMediaAsyncRequester.requestDataAsyncAtPositionMs(indexOf, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeMsArray(TVKRichMediaFeature tVKRichMediaFeature, long[] jArr) {
        if (tVKRichMediaFeature == null) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeMsArray, feature == null");
            return -1;
        }
        int indexOf = this.mFeatureList.indexOf(tVKRichMediaFeature);
        if (indexOf < 0) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeMsArray, index feature:" + tVKRichMediaFeature.getFeatureType() + ContainerUtils.KEY_VALUE_DELIMITER + indexOf);
            return -1;
        }
        return this.mITPRichMediaAsyncRequester.requestDataAsyncAtPositionMsArray(indexOf, jArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRange(TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaTimeRange tVKRichMediaTimeRange) {
        if (tVKRichMediaFeature == null) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRange, feature == null");
            return -1;
        }
        int indexOf = this.mFeatureList.indexOf(tVKRichMediaFeature);
        if (indexOf < 0) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRange, index feature:" + tVKRichMediaFeature.getFeatureType() + ContainerUtils.KEY_VALUE_DELIMITER + indexOf);
            return -1;
        }
        if (tVKRichMediaTimeRange == null) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRange, index feature:" + tVKRichMediaFeature.getFeatureType() + " timeRange == null");
            return -1;
        }
        return this.mITPRichMediaAsyncRequester.requestDataAsyncAtTimeRange(indexOf, new TPTimeRange(tVKRichMediaTimeRange.getStartTimeMs(), tVKRichMediaTimeRange.getEndTimeMs()));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public int requestFeatureDataAsyncAtTimeRanges(TVKRichMediaFeature tVKRichMediaFeature, TVKRichMediaTimeRange[] tVKRichMediaTimeRangeArr) {
        if (tVKRichMediaFeature == null) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRanges, feature == null");
            return -1;
        }
        int indexOf = this.mFeatureList.indexOf(tVKRichMediaFeature);
        if (indexOf < 0) {
            TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRanges, index feature:" + tVKRichMediaFeature.getFeatureType() + ContainerUtils.KEY_VALUE_DELIMITER + indexOf);
            return -1;
        }
        TPTimeRange[] tPTimeRangeArr = new TPTimeRange[tVKRichMediaTimeRangeArr.length];
        for (int i3 = 0; i3 < tVKRichMediaTimeRangeArr.length; i3++) {
            TVKRichMediaTimeRange tVKRichMediaTimeRange = tVKRichMediaTimeRangeArr[i3];
            if (tVKRichMediaTimeRange == null) {
                TVKLogUtil.e(TAG, "requestFeatureDataAsyncAtTimeRanges, timeRange[" + indexOf + "], == null");
                return -1;
            }
            tPTimeRangeArr[i3] = new TPTimeRange(tVKRichMediaTimeRange.getStartTimeMs(), tVKRichMediaTimeRange.getEndTimeMs());
        }
        return this.mITPRichMediaAsyncRequester.requestDataAsyncAtTimeRangeArray(indexOf, tPTimeRangeArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public void setRequesterListener(ITVKRichMediaAsyncRequesterListener iTVKRichMediaAsyncRequesterListener) {
        if (iTVKRichMediaAsyncRequesterListener == null) {
            this.mITPRichMediaAsyncRequester.setListener(null);
        } else {
            this.mITPRichMediaAsyncRequester.setListener(new TVKRichMediaAsyncListenerAdapter(iTVKRichMediaAsyncRequesterListener));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.richmedia.async.ITVKRichMediaAsyncRequester
    public void setRichMediaSource(String str) throws IllegalStateException, IllegalArgumentException {
        this.mITPRichMediaAsyncRequester.setRichMediaSource(TPMediaAssetFactory.createUrlMediaAsset(str));
    }
}
