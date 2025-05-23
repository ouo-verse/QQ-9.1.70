package com.tencent.qqlive.tvkplayer.vinfo.xml;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKGetVinfoData;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoCache;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoParser;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoPlayUrlBuilder;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public class TVKVodXmlParseGetter implements ITVKDataParseGetter {
    private static final String MODULE_NAME = "TVKVodXmlParseGetter";
    private static final AtomicInteger REQUEST_ID_BASE = new AtomicInteger(QzoneConfig.DefaultValue.DEFAULT_WEISHI_VIDEO_MAX_BITRATE);
    private Handler mCallbackHandler;
    private ITVKDataParseGetter.ITVKVodDataParseGetterListener mListener;
    private final ITVKLogger mLogger;
    private final ConcurrentHashMap<Integer, String> mRequestMap = new ConcurrentHashMap<>();

    public TVKVodXmlParseGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        if (looper != null) {
            this.mCallbackHandler = new Handler(looper);
        }
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
    }

    private void addRequest(int i3, String str) {
        this.mRequestMap.put(Integer.valueOf(i3), str);
    }

    private void dealOnParseFailure(final int i3, TVKGetVinfoData tVKGetVinfoData, String str) {
        int errCode;
        int i16;
        final ITVKDataParseGetter.ITVKVodDataParseGetterListener iTVKVodDataParseGetterListener = this.mListener;
        if (getAndRemoveRequest(i3) != null && iTVKVodDataParseGetterListener != null) {
            if (tVKGetVinfoData.getParseResult() != 0) {
                errCode = tVKGetVinfoData.getParseResult();
                i16 = TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR;
            } else {
                errCode = tVKGetVinfoData.getErrorInfo().getErrCode();
                i16 = 1300000;
            }
            final TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, errCode + i16, tVKGetVinfoData.getErrorInfo().getErrDetailCode());
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.DETAIL_INFO, str);
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.ERROR_INSTRUCTION, tVKGetVinfoData.getErrorInfo().getMessage());
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.IP_LIMITATION_INFO, tVKGetVinfoData.getErrorInfo().getIpInfo());
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.xml.TVKVodXmlParseGetter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        iTVKVodDataParseGetterListener.onFailure(i3, tVKError);
                    }
                });
                return;
            } else {
                iTVKVodDataParseGetterListener.onFailure(i3, tVKError);
                return;
            }
        }
        this.mLogger.warn("VOD CGI: canceled or listener is null, return, requestId=" + i3 + ", listener=" + iTVKVodDataParseGetterListener, new Object[0]);
    }

    private void dealOnParseSuccess(final int i3, final TVKVodVideoInfo tVKVodVideoInfo) {
        final ITVKDataParseGetter.ITVKVodDataParseGetterListener iTVKVodDataParseGetterListener = this.mListener;
        if (getAndRemoveRequest(i3) != null && iTVKVodDataParseGetterListener != null) {
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.xml.TVKVodXmlParseGetter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        iTVKVodDataParseGetterListener.onSuccess(i3, tVKVodVideoInfo);
                    }
                });
                return;
            } else {
                iTVKVodDataParseGetterListener.onSuccess(i3, tVKVodVideoInfo);
                return;
            }
        }
        this.mLogger.warn("VOD CGI: canceled or listener is null, return, requestId=" + i3 + ", listener=" + iTVKVodDataParseGetterListener, new Object[0]);
    }

    private String getAndRemoveRequest(int i3) {
        if (this.mRequestMap.containsKey(Integer.valueOf(i3))) {
            return this.mRequestMap.remove(Integer.valueOf(i3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleParse(int i3, String str, ITVKFeatureGroup iTVKFeatureGroup) {
        String str2;
        List<ITVKVodFeature> vodFeatureList;
        if (TVKMediaPlayerConfig.PlayerConfig.enable_xml_vod_cache) {
            str2 = TVKUtils.getMd5(str);
        } else {
            str2 = "";
        }
        this.mLogger.info("VOD CGI: cache key generated: " + str2, new Object[0]);
        TVKVodVideoInfo tVKVodVideoInfo = TVKVodInfoCache.getInstance().get(str2);
        if (tVKVodVideoInfo != null) {
            this.mLogger.info("VOD CGI: dealCacheVideoInfoRequest for xml, has cached record , use cached data. vid:" + tVKVodVideoInfo.getVid(), new Object[0]);
            dealOnParseSuccess(i3, tVKVodVideoInfo);
            return;
        }
        this.mLogger.info("VOD CGI: dealCacheVideoInfoRequest for xml, has no cache", new Object[0]);
        if (iTVKFeatureGroup == null) {
            vodFeatureList = null;
        } else {
            vodFeatureList = iTVKFeatureGroup.getVodFeatureList();
        }
        TVKGetVinfoData parseVinfo = new TVKVodInfoParser(vodFeatureList, this.mLogger).parseVinfo(str);
        if (parseVinfo.getParseResult() == 0 && parseVinfo.getErrorInfo().getErrCode() == 0) {
            TVKVodVideoInfo vodInfo = parseVinfo.getVodInfo();
            vodInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_XML);
            TVKVodInfoPlayUrlBuilder.buildCdnUrl(vodInfo, TVKVersion.getSdtfrom());
            boolean put = TVKVodInfoCache.getInstance().put(str2, vodInfo);
            this.mLogger.info("VOD CGI: successfully cache CGI content with key " + str2 + "? " + put, new Object[0]);
            dealOnParseSuccess(i3, parseVinfo.getVodInfo());
            return;
        }
        dealOnParseFailure(i3, parseVinfo, str);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter
    public void cancelRequest(int i3) {
        this.mLogger.info("cancelRequest, requestId=" + i3, new Object[0]);
        this.mRequestMap.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter
    public int parse(@NonNull final String str, final ITVKFeatureGroup iTVKFeatureGroup) {
        final int incrementAndGet = REQUEST_ID_BASE.incrementAndGet();
        addRequest(incrementAndGet, str);
        TVKThreadPool.getInstance().obtainHighPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.xml.TVKVodXmlParseGetter.1
            @Override // java.lang.Runnable
            public void run() {
                TVKVodXmlParseGetter.this.handleParse(incrementAndGet, str, iTVKFeatureGroup);
            }
        });
        return incrementAndGet;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter
    public void setListener(ITVKDataParseGetter.ITVKVodDataParseGetterListener iTVKVodDataParseGetterListener) {
        this.mListener = iTVKVodDataParseGetterListener;
    }
}
