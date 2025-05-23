package com.tencent.thumbplayer.tpplayer;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPHashMapBuilder;
import com.tencent.thumbplayer.common.TPUrlAnalyzer;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginManager;
import java.util.List;

/* loaded from: classes26.dex */
public class TPPlayerEventForwarder {
    public final ITPPluginManager mPluginManager;
    public final TPContext mTPContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TPPlayerEventForwarder(TPContext tPContext, ITPPluginManager iTPPluginManager) {
        this.mTPContext = tPContext;
        this.mPluginManager = iTPPluginManager;
    }

    private int getAssetUrlProtocolType(ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset == null) {
            return -1;
        }
        if ((iTPMediaAsset instanceof TPMediaAsset) && ((TPMediaAsset) iTPMediaAsset).getResourceLoader() != null) {
            return 8;
        }
        if (iTPMediaAsset.getAssetType() != 1 && iTPMediaAsset.getAssetType() != 2) {
            return TPUrlAnalyzer.getUrlProtocolType(getUrlFromMediaAsset(iTPMediaAsset));
        }
        return 4;
    }

    private String getUrlFromMediaAsset(ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset == null) {
            return "";
        }
        if (iTPMediaAsset.getAssetType() == 6) {
            List<Pair<ITPMediaAsset, Long>> assetAndClipDurationMsPairList = ((TPMultiMediaAsset) iTPMediaAsset).getAssetAndClipDurationMsPairList();
            if (assetAndClipDurationMsPairList != null && !assetAndClipDurationMsPairList.isEmpty()) {
                iTPMediaAsset = assetAndClipDurationMsPairList.get(0).first;
            } else {
                iTPMediaAsset = null;
            }
        }
        if (iTPMediaAsset == null || !(iTPMediaAsset instanceof ITPUrlMediaAsset)) {
            return "";
        }
        return ((TPUrlMediaAsset) iTPMediaAsset).getUrl();
    }

    public void forwardAddSubtitleEvent(String str, @NonNull ITPMediaAsset iTPMediaAsset, long j3, long j16) {
        this.mPluginManager.onEvent(118, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(j3)).put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(j16)).put("url", getUrlFromMediaAsset(iTPMediaAsset)).put("name", str).build());
    }

    public void forwardBufferingEndEvent() {
        this.mPluginManager.onEvent(115, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardBufferingStartEvent(long j3, ITPMediaAsset iTPMediaAsset) {
        this.mPluginManager.onEvent(114, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).put("format", 0).put("ptime", Long.valueOf(j3)).put("url", getUrlFromMediaAsset(iTPMediaAsset)).build());
    }

    public void forwardCdnUrlUpdateEvent(String str, String str2, String str3) {
        this.mPluginManager.onEvent(201, 0, 0, null, new TPHashMapBuilder().put("url", str).put(TPReportKeys.Common.COMMON_CDN_IP, str2).put(TPReportKeys.Common.COMMON_CDN_UIP, str3).build());
    }

    public void forwardCompletionEvent() {
        this.mPluginManager.onEvent(111, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put("reason", 0).build());
    }

    public void forwardCreateEndEvent() {
        this.mPluginManager.onEvent(101, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardCreateStartEvent() {
        this.mPluginManager.onEvent(100, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardDownloadProgressEvent(long j3, String str) {
        this.mPluginManager.onEvent(200, 0, 0, null, new TPHashMapBuilder().put("speed", Integer.valueOf((int) (j3 / 8000))).put(TPReportKeys.LiveExKeys.LIVE_FX_SPANID, str).build());
    }

    public void forwardErrorEvent(@NonNull TPError tPError) {
        this.mPluginManager.onEvent(108, 0, 0, "", new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put("reason", 3).put("code", tPError.getErrorType() + "." + tPError.getErrorCode()).build());
    }

    public void forwardFirstClipOpenedEvent() {
        this.mPluginManager.onEvent(124, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardFirstPacketReadEvent() {
        this.mPluginManager.onEvent(119, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardFirstVideoFrameRenderedEvent() {
        this.mPluginManager.onEvent(105, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardHlsPrivateTagEvent(String str) {
        this.mPluginManager.onEvent(117, 0, 0, null, str);
    }

    public void forwardPauseEvent() {
        this.mPluginManager.onEvent(106, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardPrepareCompleteEvent(int i3, String str, long j3, long j16, String str2, boolean z16) {
        this.mPluginManager.onEvent(103, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.Common.COMMON_PLAYER_TYPE, Integer.valueOf(i3)).put("definition", str).put("rate", Long.valueOf(j3 / 8000)).put("duration", Long.valueOf(j16)).put(TPReportKeys.Common.COMMON_MEDIA_FORMAT, str2).put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put(TPReportKeys.VodExKeys.VOD_EX_MULTI_TRACK, Boolean.valueOf(z16)).build());
    }

    public void forwardPrepareEvent(ITPMediaAsset iTPMediaAsset, boolean z16, String str) {
        this.mPluginManager.onEvent(102, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).put("url", getUrlFromMediaAsset(iTPMediaAsset)).put(TPReportKeys.Common.COMMON_P2P, Boolean.valueOf(z16)).put("flowid", str).build());
        TPPlayerEventInfo.PrepareStartEventInfo prepareStartEventInfo = new TPPlayerEventInfo.PrepareStartEventInfo();
        prepareStartEventInfo.setFlowId(str);
        this.mTPContext.getPlayerEventPublisher().publishEvent(prepareStartEventInfo);
    }

    public void forwardProtocolUpdateEvent(String str, String str2) {
        this.mPluginManager.onEvent(202, 0, 0, null, new TPHashMapBuilder().put("proto", str).put(TPReportKeys.Common.COMMON_PROTOVER, str2).build());
    }

    public void forwardReleaseEvent() {
        this.mPluginManager.onEvent(112, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put("reason", 1).build());
    }

    public void forwardResetEvent() {
        this.mPluginManager.onEvent(113, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put("reason", 1).build());
    }

    public void forwardSeekCompleteEvent(long j3) {
        this.mPluginManager.onEvent(110, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_END_TIME, Long.valueOf(j3)).build());
    }

    public void forwardSeekEvent(long j3) {
        this.mPluginManager.onEvent(109, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).put("format", 0).put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_START_TIME, Long.valueOf(j3)).build());
    }

    public void forwardSelectTrackCompleteEvent(TPError tPError, long j3) {
        int i3;
        ITPPluginManager iTPPluginManager = this.mPluginManager;
        TPHashMapBuilder put = new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, Long.valueOf(j3)).put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis()));
        if (tPError != null) {
            i3 = tPError.getErrorCode();
        } else {
            i3 = 0;
        }
        iTPPluginManager.onEvent(123, 0, 0, null, put.put("code", String.valueOf(i3)).build());
    }

    public void forwardSelectTrackEvent(String str, int i3, long j3) {
        this.mPluginManager.onEvent(122, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, Long.valueOf(j3)).put(TPReportKeys.PlayerStep.PLAYER_SELECT_TRACK_TYPE, Integer.valueOf(i3)).put("name", str).put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardSetDataSourceEvent(ITPMediaAsset iTPMediaAsset, boolean z16) {
        TPPlayerEventInfo.SetDataSourceEventInfo setDataSourceEventInfo = new TPPlayerEventInfo.SetDataSourceEventInfo();
        setDataSourceEventInfo.setUrl(getUrlFromMediaAsset(iTPMediaAsset));
        setDataSourceEventInfo.setUrlProtocol(getAssetUrlProtocolType(iTPMediaAsset));
        setDataSourceEventInfo.setIsUseProxy(z16);
        this.mTPContext.getPlayerEventPublisher().publishEvent(setDataSourceEventInfo);
    }

    public void forwardSetPlaySpeedEvent(float f16) {
        this.mPluginManager.onEvent(116, 0, 0, null, new TPHashMapBuilder().put("scene", Float.valueOf(f16)).build());
    }

    public void forwardStartEvent() {
        this.mPluginManager.onEvent(104, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_START_TIME, Long.valueOf(System.currentTimeMillis())).build());
    }

    public void forwardStopEvent() {
        this.mPluginManager.onEvent(107, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put("reason", 1).build());
    }

    public void forwardSwitchDataSourceCompleteEvent() {
        this.mPluginManager.onEvent(121, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "").build());
    }

    public void forwardSwitchDataSourceEvent() {
        this.mPluginManager.onEvent(120, 0, 0, null, new TPHashMapBuilder().put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "").build());
    }
}
