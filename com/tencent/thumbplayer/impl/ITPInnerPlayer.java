package com.tencent.thumbplayer.impl;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.common.TPTimeoutException;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;

/* loaded from: classes26.dex */
public interface ITPInnerPlayer extends ITPPlayer {
    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    int getCurrentState() throws TPTimeoutException;

    long getDemuxerCurrentOriginalPtsUs();

    long getDemuxerOffsetInFileByte();

    @Nullable
    TPDynamicStatisticParams getDynamicStatisticParams(boolean z16);

    @Nullable
    TPGeneralPlayFlowParams getGeneralPlayFlowParams();

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    ITPReportExtendedController getReportExtendedController();

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    ITPBusinessReportManager getReportManager();

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setLogTagPrefix(String str);

    void setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener);

    void setPlayRemuxer(ITPPlayRemuxer iTPPlayRemuxer);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void setRichMediaSynchronizer(@Nullable ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    void stopAsync() throws IllegalStateException;
}
