package com.tencent.thumbplayer.datatransport.play;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportTaskMgr;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport;

/* loaded from: classes26.dex */
public class TPPlayDataTransport implements ITPPlayDataTransport {
    private final TPContext mContext;
    private ITPPlayDataTransport mDataTransport;
    private ITPPlayDataTransportListener mPlayDataTransportListener;

    public TPPlayDataTransport(@NonNull TPContext tPContext) {
        this.mContext = tPContext;
        createDataTransport(true);
    }

    private void createDataTransport(boolean z16) {
        if (z16) {
            createPlayDataTransportImplIfNeed();
        } else {
            createPlayDataTransportNonImplIfNeed();
        }
    }

    private void createPlayDataTransportImplIfNeed() {
        ITPDataTransportTaskMgr taskMgr = TPDataTransportMgr.getTaskMgr();
        if (taskMgr == null) {
            TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "create data transport impl, but task mgr is null");
            createPlayDataTransportNonImplIfNeed();
            return;
        }
        ITPPlayDataTransport iTPPlayDataTransport = this.mDataTransport;
        if (iTPPlayDataTransport instanceof TPPlayDataTransportImpl) {
            TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "reuse play data transport impl");
            return;
        }
        if (iTPPlayDataTransport != null) {
            TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "release play data transport");
            this.mDataTransport.reset();
            this.mDataTransport.release();
        }
        TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "create & use play data transport impl");
        TPPlayDataTransportImpl tPPlayDataTransportImpl = new TPPlayDataTransportImpl(this.mContext, taskMgr);
        this.mDataTransport = tPPlayDataTransportImpl;
        tPPlayDataTransportImpl.setPlayDataTransportListener(this.mPlayDataTransportListener);
    }

    private void createPlayDataTransportNonImplIfNeed() {
        ITPPlayDataTransport iTPPlayDataTransport = this.mDataTransport;
        if (iTPPlayDataTransport instanceof TPPlayDataTransportNonImpl) {
            TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "reuse play data transport non_impl");
            return;
        }
        if (iTPPlayDataTransport != null) {
            TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "release play data transport");
            this.mDataTransport.release();
        }
        TPLogUtil.i(this.mContext.getLogTag() + "_" + ITPPlayDataTransport.TAG, "create & use play data transport non_impl");
        TPPlayDataTransportNonImpl tPPlayDataTransportNonImpl = new TPPlayDataTransportNonImpl(this.mContext);
        this.mDataTransport = tPPlayDataTransportNonImpl;
        tPPlayDataTransportNonImpl.setPlayDataTransportListener(this.mPlayDataTransportListener);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        if (TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_DOWNLOAD_PROXY.equals(tPOptionalParam.getKey())) {
            createDataTransport(((Boolean) tPOptionalParam.getValue()).booleanValue());
        } else {
            this.mDataTransport.addOptionalParam(tPOptionalParam);
        }
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public long getAvailablePositionMs() {
        return this.mDataTransport.getAvailablePositionMs();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public float getDownloadPercentage() {
        return this.mDataTransport.getDownloadPercentage();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError() {
        return this.mDataTransport.getError();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public boolean isUseDataTransportForCurrentPlayTask() {
        return this.mDataTransport.isUseDataTransportForCurrentPlayTask();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingEnd() {
        this.mDataTransport.onBufferingEnd();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onBufferingStart() {
        this.mDataTransport.onBufferingStart();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onPlayerStateChanged(int i3) {
        this.mDataTransport.onPlayerStateChanged(i3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeek() {
        this.mDataTransport.onSeek();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSeekComplete() {
        this.mDataTransport.onSeekComplete();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void onSwitchDataSourceComplete(int i3) {
        this.mDataTransport.onSwitchDataSourceComplete(i3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void pause() {
        this.mDataTransport.pause();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void release() {
        this.mDataTransport.release();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void reset() {
        this.mDataTransport.reset();
        createDataTransport(true);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void resume() {
        this.mDataTransport.resume();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlayDataTransportListener(ITPPlayDataTransportListener iTPPlayDataTransportListener) {
        this.mPlayDataTransportListener = iTPPlayDataTransportListener;
        this.mDataTransport.setPlayDataTransportListener(iTPPlayDataTransportListener);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void setPlaySpeedRatio(float f16) {
        this.mDataTransport.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset start(@NonNull ITPMediaAsset iTPMediaAsset) {
        return this.mDataTransport.start(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startAudioTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        return this.mDataTransport.startAudioTrack(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    @Nullable
    public ITPMediaAsset startRemuxing(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPMediaAsset iTPMediaAsset2) {
        return this.mDataTransport.startRemuxing(iTPMediaAsset, iTPMediaAsset2);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPMediaAsset startSubtitleTrack(@NonNull ITPMediaAsset iTPMediaAsset) {
        return this.mDataTransport.startSubtitleTrack(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void stop() {
        this.mDataTransport.stop();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer
    public void stopRemuxing() {
        this.mDataTransport.stopRemuxing();
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public ITPPlayDataTransport.SwitchTaskInfo switchDataSource(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) {
        return this.mDataTransport.switchDataSource(iTPMediaAsset, i3, j3);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    public void updateDataSource(@NonNull ITPMediaAsset iTPMediaAsset) {
        this.mDataTransport.updateDataSource(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.datatransport.play.ITPPlayDataTransport
    @Nullable
    public TPError getError(String str) {
        return this.mDataTransport.getError(str);
    }
}
