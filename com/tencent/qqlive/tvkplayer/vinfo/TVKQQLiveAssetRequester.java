package com.tencent.qqlive.tvkplayer.vinfo;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKQQLiveAssetRequester implements ITVKQQLiveAssetRequester {
    private static final String MODULE_NAME = "TVKQQLiveAssetRequester";
    private static final ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener STUB_LISTENER = new ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.TVKQQLiveAssetRequester.1
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener
        public void onFailure(int i3, TVKError tVKError) {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener
        public void onSuccess(int i3, String str, ITVKQQLiveAssetRequester.ExtraVideoInfo extraVideoInfo, TVKNetVideoInfo tVKNetVideoInfo) {
        }
    };
    private static volatile TVKPlayerFeatureGroup sFeatureGroup;
    private static volatile TVKPlayerFeatureGroup sFeatureGroupForDlna;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKContext mTVKContext;
    private ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener mListener = STUB_LISTENER;
    private final ITVKVodInfoGetter.ITVKVodInfoGetterListener mVodInfoListener = new ITVKVodInfoGetter.ITVKVodInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.TVKQQLiveAssetRequester.2
        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
        public void onFailure(int i3, @NonNull TVKError tVKError) {
            TVKQQLiveAssetRequester.this.mLogger.error("TVKVodInfoGetter OnFailure, requestId:" + i3 + ", error: " + tVKError, new Object[0]);
            TVKQQLiveAssetRequester.this.mListener.onFailure(i3, tVKError);
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
        public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
            TVKQQLiveAssetRequester.this.mLogger.info("TVKVodInfoGetter onSuccess, requestId:" + i3, new Object[0]);
            if (!TextUtils.isEmpty(tVKVodVideoInfo.getPlayUrl())) {
                TVKQQLiveAssetRequester.this.mLogger.info("TVKVodInfoGetter onSuccess, vid=" + tVKVodVideoInfo.getVid() + ", url=" + tVKVodVideoInfo.getPlayUrl(), new Object[0]);
                TVKQQLiveAssetRequester.this.mListener.onSuccess(i3, tVKVodVideoInfo.getPlayUrl(), TVKQQLiveAssetRequester.this.getExtraVideoInfo(tVKVodVideoInfo), tVKVodVideoInfo);
                return;
            }
            TVKQQLiveAssetRequester.this.mLogger.error("TVKVodInfoGetter onSuccess, playurl is null", new Object[0]);
            TVKQQLiveAssetRequester.this.mListener.onFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCommonErrorCodeUtil.CODE.VOD.VINFO_URL_EMPTY_ERR));
        }
    };
    private final ITVKLiveInfoGetter.ITVKLiveInfoGetterListener mLiveInfoListener = new ITVKLiveInfoGetter.ITVKLiveInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.TVKQQLiveAssetRequester.3
        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
        public void onFailure(int i3, @NonNull TVKError tVKError) {
            TVKQQLiveAssetRequester.this.mLogger.error("TVKLiveInfoGetter onFailure, requestId:" + i3 + ", error: " + tVKError, new Object[0]);
            TVKQQLiveAssetRequester.this.mListener.onFailure(i3, tVKError);
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
        public void onSuccess(int i3, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
            TVKQQLiveAssetRequester.this.mLogger.info("TVKLiveInfoGetter onSuccess, requestId:" + i3, new Object[0]);
            if (!TextUtils.isEmpty(tVKLiveVideoInfo.getOriginalPlayUrl())) {
                TVKQQLiveAssetRequester.this.mLogger.info("TVKLiveInfoGetter onSuccess, vid=" + tVKLiveVideoInfo.getVid() + ", url=" + tVKLiveVideoInfo.getOriginalPlayUrl(), new Object[0]);
                TVKQQLiveAssetRequester.this.mListener.onSuccess(i3, tVKLiveVideoInfo.getOriginalPlayUrl(), null, tVKLiveVideoInfo);
                return;
            }
            TVKQQLiveAssetRequester.this.mLogger.error("TVKLiveInfoGetter onSuccess, playurl is null ", new Object[0]);
            TVKQQLiveAssetRequester.this.mListener.onFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETPROGINFO_ERR, TVKCommonErrorCodeUtil.CODE.LIVE.LIVEINFO_URL_EMPTY_ERR));
        }
    };

    public TVKQQLiveAssetRequester(@NonNull TVKContext tVKContext) {
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        initFeatureGroup(tVKContext);
    }

    private ITVKLiveInfoGetter createLiveInfoGetter(Looper looper) {
        ITVKLiveInfoGetter createLiveInfoGetter = TVKCGIFactory.createLiveInfoGetter(this.mTVKContext, looper);
        createLiveInfoGetter.setLiveInfoListener(this.mLiveInfoListener);
        return createLiveInfoGetter;
    }

    private ITVKVodInfoGetter createVodInfoGetter(Looper looper) {
        ITVKVodInfoGetter createVodInfoGetter = TVKCGIFactory.createVodInfoGetter(this.mTVKContext, looper);
        createVodInfoGetter.setVodInfoListener(this.mVodInfoListener);
        return createVodInfoGetter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITVKQQLiveAssetRequester.ExtraVideoInfo getExtraVideoInfo(@NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        ArrayList<TVKVodVideoInfo.ReferUrl> urlList = tVKVodVideoInfo.getUrlList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<TVKVodVideoInfo.ReferUrl> it = urlList.iterator();
        while (it.hasNext()) {
            TVKVodVideoInfo.ReferUrl next = it.next();
            arrayList.add(Integer.valueOf(next.getVt()));
            arrayList2.add(next.getUrl());
        }
        ITVKQQLiveAssetRequester.ExtraVideoInfo extraVideoInfo = new ITVKQQLiveAssetRequester.ExtraVideoInfo();
        extraVideoInfo.mBackPlayUrlList = tVKVodVideoInfo.getBakPlayUrl();
        extraVideoInfo.mVtList = arrayList;
        extraVideoInfo.mReferUrlList = arrayList2;
        return extraVideoInfo;
    }

    private void initFeatureGroup(@NonNull TVKContext tVKContext) {
        if (sFeatureGroup == null) {
            synchronized (TVKQQLiveAssetRequester.class) {
                if (sFeatureGroup == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(TVKFeatureFactory.createVodFeatureList(tVKContext));
                    arrayList.addAll(TVKFeatureFactory.createLiveFeatureList(tVKContext));
                    sFeatureGroup = new TVKPlayerFeatureGroup(arrayList);
                }
            }
        }
        if (sFeatureGroupForDlna == null) {
            synchronized (TVKQQLiveAssetRequester.class) {
                if (sFeatureGroupForDlna == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(TVKFeatureFactory.createVodFeatureListForDlna(tVKContext));
                    arrayList2.addAll(TVKFeatureFactory.createLiveFeatureListForDlna(tVKContext));
                    sFeatureGroupForDlna = new TVKPlayerFeatureGroup(arrayList2);
                }
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester
    public int inquireLiveInfo(TVKUserInfo tVKUserInfo, String str, String str2, Map<String, String> map) throws IllegalArgumentException, IllegalAccessException {
        TVKPlayerVideoInfo tVKPlayerVideoInfo;
        this.mTVKContext.increaseSequence();
        this.mLogger.info("inquireLiveInfo, sid:" + str + ", definition:" + str2, new Object[0]);
        if (map != null && !map.isEmpty()) {
            tVKPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createLiveSidAsset(str, map.get("livepid")));
            tVKPlayerVideoInfo.getExtraRequestParamsMap().putAll(map);
            tVKPlayerVideoInfo.getExtraRequestParamsMap().remove("livepid");
        } else {
            tVKPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createLiveSidAsset(str, ""));
        }
        return createLiveInfoGetter(Looper.myLooper()).inquireLiveInfo(new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, tVKPlayerVideoInfo.getAsset(), tVKUserInfo).definition(str2).streamFormatId(2).flowId(TVKUtils.generateFlowId()).requestSource(3).build(), sFeatureGroup, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester
    public int request(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, int i3) throws IllegalArgumentException, IllegalAccessException {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.isAssetValid()) {
            this.mTVKContext.increaseSequence();
            this.mLogger.info("request, asset:" + tVKPlayerVideoInfo.getAsset() + ", definition:" + str, new Object[0]);
            TVKCGIRequestParam build = new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, tVKPlayerVideoInfo.getAsset(), tVKUserInfo).definition(str).streamFormatId(i3).flowId(TVKUtils.generateFlowId()).requestSource(3).build();
            if (tVKPlayerVideoInfo.isLivePlay()) {
                return createLiveInfoGetter(Looper.myLooper()).requestLivePlayInfo(build, sFeatureGroup, null);
            }
            if (tVKPlayerVideoInfo.getAsset().getAssetType() != 131072 && tVKPlayerVideoInfo.getAsset().getAssetType() != 524288 && tVKPlayerVideoInfo.getAsset().getAssetType() != 1048576) {
                throw new IllegalArgumentException("Unsupported asset");
            }
            return createVodInfoGetter(Looper.myLooper()).requestOnlinePlayInfo(build, sFeatureGroup, null);
        }
        throw new IllegalArgumentException("input param invalid");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester
    public int requestForDlna(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, int i3) throws IllegalArgumentException, IllegalAccessException {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.isAssetValid()) {
            this.mTVKContext.increaseSequence();
            this.mLogger.info("requestForDlna, asset: " + tVKPlayerVideoInfo.getAsset() + ", definition: " + str, new Object[0]);
            TVKCGIRequestParam build = new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, tVKPlayerVideoInfo.getAsset(), tVKUserInfo).definition(str).streamFormatId(i3).flowId(TVKUtils.generateFlowId()).requestSource(3).build();
            if (tVKPlayerVideoInfo.isLivePlay()) {
                return createLiveInfoGetter(Looper.myLooper()).requestDlnaPlayInfo(build, sFeatureGroupForDlna, TVKFeatureFactory.createFeatureParamGroupForDlna());
            }
            if (tVKPlayerVideoInfo.getAsset().getAssetType() != 131072 && tVKPlayerVideoInfo.getAsset().getAssetType() != 524288) {
                throw new IllegalArgumentException("Unsupported asset");
            }
            return createVodInfoGetter(Looper.myLooper()).requestDlnaPlayInfo(build, sFeatureGroupForDlna, TVKFeatureFactory.createFeatureParamGroupForDlna());
        }
        throw new IllegalArgumentException("input param invalid");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKQQLiveAssetRequester
    public void setQQLiveAssetListener(ITVKQQLiveAssetRequester.ITVKQQLiveAssetListener iTVKQQLiveAssetListener) {
        if (iTVKQQLiveAssetListener == null) {
            iTVKQQLiveAssetListener = STUB_LISTENER;
        }
        this.mListener = iTVKQQLiveAssetListener;
    }
}
