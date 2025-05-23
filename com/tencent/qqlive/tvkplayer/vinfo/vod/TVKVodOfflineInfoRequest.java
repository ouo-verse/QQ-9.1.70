package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVodInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIExecutor;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodOfflineInfoRequest implements ITVKCGIRequestBase {
    private static final String MODULE_NAME = "TVKVodOfflineInfoRequest";
    private final TVKCGIExecutor mCGIExecutor;

    @NonNull
    private final ITVKVodInfoListener mListener;
    private final ITVKLogger mLogger;

    @NonNull
    private TVKVodProxyCache mProxyCache;
    private final int mRequestId;
    private volatile ITVKCGIRequestBase.RequestState mRequestState = ITVKCGIRequestBase.RequestState.STATE_IDLE;

    @NonNull
    private final TVKVodInfoParser mVodInfoParser;

    public TVKVodOfflineInfoRequest(int i3, @NonNull TVKContext tVKContext, @NonNull TVKVodRequestBuilder tVKVodRequestBuilder, @NonNull TVKVodInfoParser tVKVodInfoParser, @NonNull TVKVodProxyCache tVKVodProxyCache, @NonNull ITVKVodInfoListener iTVKVodInfoListener) {
        this.mRequestId = i3;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mVodInfoParser = tVKVodInfoParser;
        this.mProxyCache = tVKVodProxyCache;
        this.mListener = iTVKVodInfoListener;
        this.mCGIExecutor = new TVKCGIExecutor(tVKVodRequestBuilder.getRequestSource());
    }

    private void dealOnFail(int i3) {
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][dealOnFail] canceled and return", new Object[0]);
            return;
        }
        this.mListener.onFailure(this.mRequestId, new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, i3 + TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest() {
        String offlineCache = this.mProxyCache.getOfflineCache();
        if (TextUtils.isEmpty(offlineCache)) {
            if (TVKNetworkUtils.getNetworkType() != 1) {
                this.mLogger.info("VOD CGI: video info process : offline video , use p2p method url is empty and not wifi. so 1401024 error, vid:" + this.mProxyCache.getVid(), new Object[0]);
                dealOnFail(24);
                return;
            }
            this.mLogger.info("VOD CGI: video info process : offline video , use p2p method url is empty but is wifi. so 1401025 error, change to online request, vid:" + this.mProxyCache.getVid(), new Object[0]);
            dealOnFail(25);
            return;
        }
        this.mLogger.info("VOD CGI: video info process : offline video , use p2p method. vid:" + this.mProxyCache.getVid() + ", offlineVinfo:" + offlineCache, new Object[0]);
        parseOfflineVinfo(offlineCache);
    }

    private void handleOnSuccess(TVKVodVideoInfo tVKVodVideoInfo) {
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][handleOnSuccess] canceled and return", new Object[0]);
        } else {
            TVKVodInfoPlayUrlBuilder.buildCdnUrl(tVKVodVideoInfo, TVKVersion.getSdtfrom());
            this.mListener.onSuccess(this.mRequestId, tVKVodVideoInfo);
        }
    }

    private boolean isCanceled() {
        if (this.mRequestState == ITVKCGIRequestBase.RequestState.STATE_CANCELED) {
            return true;
        }
        return false;
    }

    private void parseOfflineVinfo(String str) {
        TVKGetVinfoData parseVinfo = this.mVodInfoParser.parseVinfo(str);
        if (parseVinfo.getErrorInfo().getErrCode() != 0) {
            dealOnFail(parseVinfo.getErrorInfo(), str);
            return;
        }
        TVKVodVideoInfo vodInfo = parseVinfo.getVodInfo();
        vodInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_DL_PROXY);
        handleOnSuccess(vodInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void cancel() {
        this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_CANCELED;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void execute() {
        if (this.mRequestState != ITVKCGIRequestBase.RequestState.STATE_IDLE) {
            this.mLogger.error("VOD CGI: [vinfo] request state is not idle and return", new Object[0]);
        } else {
            this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_RUNNING;
            this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.c
                @Override // java.lang.Runnable
                public final void run() {
                    TVKVodOfflineInfoRequest.this.executeRequest();
                }
            });
        }
    }

    private void dealOnFail(TVKVodRetryAndErrorInfo tVKVodRetryAndErrorInfo, String str) {
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][dealOnFail] canceled and return", new Object[0]);
            return;
        }
        TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, tVKVodRetryAndErrorInfo.getErrCode() + 1300000, tVKVodRetryAndErrorInfo.getErrDetailCode());
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.DETAIL_INFO, str);
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.ERROR_INSTRUCTION, tVKVodRetryAndErrorInfo.getMessage());
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.IP_LIMITATION_INFO, tVKVodRetryAndErrorInfo.getIpInfo());
        this.mListener.onFailure(this.mRequestId, tVKError);
    }
}
