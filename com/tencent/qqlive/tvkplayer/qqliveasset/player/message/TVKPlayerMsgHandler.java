package com.tencent.qqlive.tvkplayer.qqliveasset.player.message;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKSeiInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKAssetPlayerMsgMap;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerMsgValueConverter;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerMsgValueMap;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKSeiInfoParser;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPVideoSeiInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes23.dex */
public class TVKPlayerMsgHandler {
    private static final String[] HLS_TAG_PREFIX_ARRAY = TVKUtils.splitStringToArray(TVKMediaPlayerConfig.PlayerConfig.live_hls_tag_array_list, ",");
    private static final String MODULE_NAME = "TVKQQLiveAssetPlayer";

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final Set<Integer> mNotifiedOneTimeMsgs = new HashSet();

    @NonNull
    private final TVKPlayerRuntimeParam mRuntimeParam;

    public TVKPlayerMsgHandler(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mRuntimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
    }

    private TVKSeiInfo createTVKSeiInfo(TPVideoSeiInfo tPVideoSeiInfo) {
        TVKSeiInfo tVKSeiInfo = new TVKSeiInfo();
        tVKSeiInfo.codecType = tPVideoSeiInfo.getCodecType();
        tVKSeiInfo.seiType = tPVideoSeiInfo.getSeiType();
        if (tPVideoSeiInfo.getSeiData() != null) {
            tVKSeiInfo.seiData = new byte[tPVideoSeiInfo.getSeiData().length];
            System.arraycopy(tPVideoSeiInfo.getSeiData(), 0, tVKSeiInfo.seiData, 0, tPVideoSeiInfo.getSeiData().length);
        }
        return tVKSeiInfo;
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {114})
    private void handleAudioDecoderType(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (!(tVKAssetPlayerMsgParams.extra instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleAudioDecoderType, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, TVKPlayerMsgValueConverter.toTVKIntValue(TVKPlayerMsgValueMap.MapAudioDecoderType.class, (int) ((TPOnInfoParam) r0).getLongParam1()), 0L, null);
    }

    private void handleDataTransportAbTestInfo(String str, String str2) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(str, Integer.valueOf(Integer.parseInt(str2)));
            notifyPlayerInfo(212, 0L, 0L, hashMap);
        } catch (NumberFormatException unused) {
            this.mLogger.error("illegal AB test info: key=" + str + ", ID=" + str2, new Object[0]);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {215})
    private void handleDataTransportInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleDataTransportInfo, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        TPOnInfoParam tPOnInfoParam = (TPOnInfoParam) obj;
        if (!(tPOnInfoParam.getObjParam() instanceof TPDataTransportMessageInfo)) {
            this.mLogger.warn("handleDataTransportInfo, onInfoParam objParam not TPDataTransportMessageInfo, return", new Object[0]);
            return;
        }
        TPDataTransportMessageInfo tPDataTransportMessageInfo = (TPDataTransportMessageInfo) tPOnInfoParam.getObjParam();
        int i3 = tPDataTransportMessageInfo.messageType;
        if (i3 != 8) {
            if (i3 != 20) {
                if (i3 != 10) {
                    if (i3 != 11) {
                        switch (i3) {
                            case 14:
                                notifyPlayerInfo(204, 0L, 0L, tPDataTransportMessageInfo);
                                return;
                            case 15:
                                notifyPlayerInfo(206, 0L, 0L, tPDataTransportMessageInfo);
                                return;
                            case 16:
                                notifyPlayerInfo(205, 0L, 0L, tPDataTransportMessageInfo);
                                return;
                            default:
                                return;
                        }
                    }
                    notifyPlayerInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE, 0L, 0L, tPDataTransportMessageInfo);
                    return;
                }
                notifyPlayerInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED, 0L, 0L, tPDataTransportMessageInfo);
                return;
            }
            notifyPlayerInfo(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED, 0L, 0L, tPDataTransportMessageInfo);
            return;
        }
        handleDataTransportAbTestInfo((String) tPDataTransportMessageInfo.obj1, (String) tPDataTransportMessageInfo.obj2);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {207})
    private void handleDownloadProgress(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleDownloadProgress, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        TPOnInfoParam tPOnInfoParam = (TPOnInfoParam) obj;
        if (!(tPOnInfoParam.getObjParam() instanceof TPDownloadProgressInfo)) {
            this.mLogger.warn("handleDownloadProgress, onInfoParam objParam not TPDownLoadProgressInfo, return", new Object[0]);
            return;
        }
        this.mRuntimeParam.setDownloadSpeedKBps((((TPDownloadProgressInfo) tPOnInfoParam.getObjParam()).getDownloadSpeedbps() / 1024) / 8);
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, tVKAssetPlayerMsgParams.arg1, tVKAssetPlayerMsgParams.arg2, tPOnInfoParam.getObjParam());
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {217})
    private void handleHdrInfoChanged(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (!(tVKAssetPlayerMsgParams.extra instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleHdrInfoChanged, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, (int) ((TPOnInfoParam) r0).getLongParam1(), (int) ((TPOnInfoParam) tVKAssetPlayerMsgParams.extra).getLongParam2(), null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {213})
    private void handleHighDropRateInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleHighDropRateInfo, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, 0L, 0L, Float.valueOf(((TPOnInfoParam) obj).getFloatParam1()));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {214})
    private void handleLowFrameRateInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleLowFrameRateInfo, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, 0L, 0L, Float.valueOf(((TPOnInfoParam) obj).getFloatParam1()));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg
    private void handlePlayerCommonMsg(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        int i3 = tVKAssetPlayerMsgParams.what;
        if (i3 != 0) {
            notifyPlayerInfo(i3, tVKAssetPlayerMsgParams.arg1, tVKAssetPlayerMsgParams.arg2, tVKAssetPlayerMsgParams.extra);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {123})
    private void handlePlayerHlsTag(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handlePlayerHlsTag, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, 0L, 0L, ((TPOnInfoParam) obj).getStrParam1());
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {100, 102, 103, 104, 105, 106})
    private void handlePlayerOneTimeMsg(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (this.mNotifiedOneTimeMsgs.contains(Integer.valueOf(tVKAssetPlayerMsgParams.what))) {
            this.mLogger.info("player info, what : " + TVKQQLiveAssetPlayerMsg.stringDefine(tVKAssetPlayerMsgParams.what) + " has notified, return", new Object[0]);
            return;
        }
        this.mNotifiedOneTimeMsgs.add(Integer.valueOf(tVKAssetPlayerMsgParams.what));
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, tVKAssetPlayerMsgParams.arg1, tVKAssetPlayerMsgParams.arg2, tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {124})
    private void handlePlayerType(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handlePlayerType, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        int longParam1 = (int) ((TPOnInfoParam) obj).getLongParam1();
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, TVKPlayerMsgValueConverter.toTVKIntValue(TVKPlayerMsgValueMap.MapPlayerType.class, longParam1), 0L, null);
        notifyAudioPostProcessorPlayerTypeChange(longParam1);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {135})
    private void handleRenderTimeout(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (!(tVKAssetPlayerMsgParams.extra instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleRenderTimeout, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, (int) ((TPOnInfoParam) r0).getLongParam1(), (int) ((TPOnInfoParam) tVKAssetPlayerMsgParams.extra).getLongParam2(), null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {210})
    private void handleUseDownloadProxyChange(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (!(tVKAssetPlayerMsgParams.extra instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleUseDownloadProxyChange, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, (int) ((TPOnInfoParam) r0).getLongParam1(), 0L, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {115})
    private void handleVideoDecoderType(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        if (!(tVKAssetPlayerMsgParams.extra instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleVideoDecoderType, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        notifyPlayerInfo(tVKAssetPlayerMsgParams.what, TVKPlayerMsgValueConverter.toTVKIntValue(TVKPlayerMsgValueMap.MapVideoDecoderType.class, (int) ((TPOnInfoParam) r0).getLongParam1()), 0L, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {136})
    private void handleVideoMetadataChanged(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleMetadataChanged, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        if (((TPOnInfoParam) obj).getObjParam() instanceof Map) {
            notifyPlayerInfo(tVKAssetPlayerMsgParams.what, 0L, 0L, TVKVideoMetadataInfoUtils.buildVideoMetadataMap((Map) ((TPOnInfoParam) tVKAssetPlayerMsgParams.extra).getObjParam(), this.mRuntimeParam.getNetVideoInfo()));
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {132})
    private void handleVideoSeiInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        int i3 = 0;
        if (!(obj instanceof TPOnInfoParam)) {
            this.mLogger.warn("handleVideoSeiInfo, extra is :" + tVKAssetPlayerMsgParams.extra + ", not TPOnInfoParam", new Object[0]);
            return;
        }
        TPOnInfoParam tPOnInfoParam = (TPOnInfoParam) obj;
        if (!(tPOnInfoParam.getObjParam() instanceof TPVideoSeiInfo)) {
            this.mLogger.warn("handleVideoSeiInfo, onInfoParam objParam not TPVideoSeiInfo, return", new Object[0]);
            return;
        }
        TPVideoSeiInfo tPVideoSeiInfo = (TPVideoSeiInfo) tPOnInfoParam.getObjParam();
        if (tPVideoSeiInfo.getSeiData() == null) {
            this.mLogger.warn("handleVideoSeiInfo, seiInfo.seiData == null, return", new Object[0]);
            return;
        }
        TVKSeiInfo createTVKSeiInfo = createTVKSeiInfo(tPVideoSeiInfo);
        String userDataUnregisteredPayloadContent = TVKSeiInfoParser.getUserDataUnregisteredPayloadContent(createTVKSeiInfo);
        if (!TextUtils.isEmpty(userDataUnregisteredPayloadContent)) {
            String[] strArr = HLS_TAG_PREFIX_ARRAY;
            int length = strArr.length;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (userDataUnregisteredPayloadContent.startsWith(strArr[i3])) {
                    notifyPlayerInfo(123, 0L, 0L, userDataUnregisteredPayloadContent);
                    break;
                }
                i3++;
            }
        }
        notifyPlayerInfo(132, 0L, 0L, createTVKSeiInfo);
    }

    private static boolean isAllowPrintLog(int i3) {
        if (i3 != 132 && i3 != 215 && i3 != 206 && i3 != 207) {
            return true;
        }
        return false;
    }

    private void notifyAudioPostProcessorPlayerTypeChange(int i3) {
        this.mAssetPlayerContext.getAudioPostProcessor().onPlayerTypeChange(i3);
    }

    private void notifyPlayerInfo(int i3, long j3, long j16, Object obj) {
        if (this.mAssetPlayerContext.getAssetPlayerListener() != null) {
            this.mAssetPlayerContext.getAssetPlayerListener().onInfo(i3, j3, j16, obj);
        }
    }

    public boolean handleMsg(int i3, TPOnInfoParam tPOnInfoParam) {
        int convertToAssetPlayerMsg = TVKAssetPlayerMsgMap.convertToAssetPlayerMsg(i3);
        if (isAllowPrintLog(convertToAssetPlayerMsg)) {
            this.mLogger.info("player info, what : " + TVKQQLiveAssetPlayerMsg.stringDefine(convertToAssetPlayerMsg) + ", onInfoParam:" + tPOnInfoParam, new Object[0]);
        }
        boolean methodAndInvoke = TVKAssetPlayerMsgMap.getMethodAndInvoke(TVKPlayerMsgHandler.class, convertToAssetPlayerMsg, this, new TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams(convertToAssetPlayerMsg, 0L, 0L, tPOnInfoParam));
        if (!methodAndInvoke) {
            this.mLogger.error("onInfo: " + TVKQQLiveAssetPlayerMsg.stringDefine(convertToAssetPlayerMsg) + " not match deal method.", new Object[0]);
        }
        return methodAndInvoke;
    }

    public void reset() {
        this.mNotifiedOneTimeMsgs.clear();
    }
}
