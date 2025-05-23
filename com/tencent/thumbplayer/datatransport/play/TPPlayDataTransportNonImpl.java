package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.datatransport.helper.TPDataTransportMediaAssetDecoratorNonProxy;
import com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPPlayDataTransportNonImpl implements ITPPlayDataTransport {
    private final TPContext mTPContext;
    private final AtomicInteger mTaskId = new AtomicInteger();

    public TPPlayDataTransportNonImpl(TPContext tPContext) {
        this.mTPContext = tPContext;
        TPLogUtil.i(getTag(), "create play data transport non impl");
    }

    private String getTag() {
        return this.mTPContext.getLogTag() + "_" + ITPPlayDataTransport.TAG + "_non_impl";
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public long getAvailablePositionMs() {
        return 0L;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public float getDownloadPercentage() {
        return 0.0f;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError() {
        return null;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public boolean isUseDataTransportForCurrentPlayTask() {
        return false;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset start(@NonNull ITPMediaAsset iTPMediaAsset) {
        ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecoratorNonProxy.decorateMediaAsset(iTPMediaAsset);
        if (decorateMediaAsset == null) {
            return null;
        }
        TPLogUtil.i(getTag(), "start play data transport : " + decorateMediaAsset);
        return decorateMediaAsset;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startAudioTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecoratorNonProxy.decorateMediaAsset(iTPMediaAsset);
        if (decorateMediaAsset == null) {
            return null;
        }
        TPLogUtil.i(getTag(), "start audio track data transport : " + decorateMediaAsset);
        return decorateMediaAsset;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    @Nullable
    public ITPMediaAsset startRemuxing(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPMediaAsset iTPMediaAsset2) {
        return null;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startSubtitleTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecoratorNonProxy.decorateMediaAsset(iTPMediaAsset);
        if (decorateMediaAsset == null) {
            return null;
        }
        TPLogUtil.i(getTag(), "start subtitle track data transport : " + decorateMediaAsset);
        return decorateMediaAsset;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPPlayDataTransport.SwitchTaskInfo switchDataSource(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) {
        ITPMediaAsset decorateMediaAsset = TPDataTransportMediaAssetDecoratorNonProxy.decorateMediaAsset(iTPMediaAsset);
        if (decorateMediaAsset == null) {
            return null;
        }
        if (i3 == 4) {
            i3 = 2;
        }
        TPLogUtil.i(getTag(), "start switch data transport : " + decorateMediaAsset);
        return new ITPPlayDataTransport.SwitchTaskInfo(this.mTaskId.incrementAndGet(), decorateMediaAsset, true, i3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError(String str) {
        return null;
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingEnd() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingStart() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeek() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeekComplete() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void pause() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void release() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void reset() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void resume() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void stop() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    public void stopRemuxing() {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onPlayerStateChanged(int i3) {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSwitchDataSourceComplete(int i3) {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlayDataTransportListener(ITPPlayDataTransportListener iTPPlayDataTransportListener) {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlaySpeedRatio(float f16) {
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void updateDataSource(@NonNull ITPMediaAsset iTPMediaAsset) {
    }
}
