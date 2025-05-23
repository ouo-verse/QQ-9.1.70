package com.tencent.tav.player;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.Utils;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.SeekTimeStore;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer;
import com.tencent.tav.report.CodecPerfReportSession;
import com.tencent.tav.report.PreviewReportSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class PlayerMessageHandler implements Handler.Callback {
    private static final String TAG = "PlayerMessageHandler";
    private IDecoderTrack aDecoderTrack;
    CMTime frameDuration;
    private boolean loop;
    private PlayerThreadAudio mAudioThread;

    @NonNull
    private final Handler mMainHandler;
    private boolean mPause;
    private PlayerItem mPlayerItem;
    private long mStartTime;

    @NonNull
    private final WeakReference<Player> mWeakPlayer;
    private OnGetTavExtraListener onGetTavExtraListener;
    private final PlayerThread playerThread;
    private IDecoderTrack vDecoderTrack;
    private final PlayerRenderer playerRenderer = new PlayerRenderer();
    private float rate = 1.0f;
    private final PreviewReportSession reportSession = new PreviewReportSession();
    private final CodecPerfReportSession codecPerfReportSession = new CodecPerfReportSession();
    private long decoderConsumerTimeUs = 0;
    private long startTimeUsMark = Utils.getCurrentUsTime();
    private volatile long lastSyncMessageId = 0;
    CMTime mPosition = CMTime.CMTimeZero;
    private int mStatus = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerMessageHandler(PlayerThread playerThread, IDecoderTrack iDecoderTrack, IDecoderTrack iDecoderTrack2, Player player) {
        this.frameDuration = new CMTime(1L, 30);
        this.playerThread = playerThread;
        this.vDecoderTrack = iDecoderTrack;
        this.aDecoderTrack = iDecoderTrack2;
        this.mWeakPlayer = new WeakReference<>(player);
        this.mPlayerItem = player.getCurrentItem();
        this.mMainHandler = player.mMainHandler;
        if (iDecoderTrack != null) {
            this.frameDuration = iDecoderTrack.getFrameDuration();
        }
    }

    private void checkNotifyProgressChange(boolean z16, boolean z17) {
        if (!z16 && !this.playerThread.mPlayHandler.hasMessages(5)) {
            if (this.mWeakPlayer.get() != null && this.mWeakPlayer.get().isIgnorePreparePosition() && z17) {
                return;
            }
            notifyProgressChange();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean dispatchMessage(Message message, Object obj, Object obj2) {
        int i3 = message.what;
        if (i3 != 9) {
            if (i3 != 101) {
                if (i3 != 231) {
                    if (i3 != 850) {
                        if (i3 != 11) {
                            int i16 = 0;
                            boolean z16 = false;
                            if (i3 != 12) {
                                if (i3 != 21) {
                                    if (i3 != 22) {
                                        switch (i3) {
                                            case 1:
                                                prepare(obj);
                                                break;
                                            case 2:
                                                play(2);
                                                break;
                                            case 3:
                                                pause();
                                                break;
                                            case 4:
                                                if (obj != null) {
                                                    z16 = ((Boolean) obj).booleanValue();
                                                }
                                                stop(z16);
                                                break;
                                            case 5:
                                                if (obj2 instanceof Callback) {
                                                    seek((CMTime) obj, (Callback) obj2);
                                                    break;
                                                } else {
                                                    seek((CMTime) obj);
                                                    break;
                                                }
                                            case 6:
                                                release(message);
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 24:
                                                        if (obj instanceof OnReadSnapShootListener) {
                                                            this.playerRenderer.setOnReadSnapShootListener((OnReadSnapShootListener) obj);
                                                            break;
                                                        }
                                                        break;
                                                    case 25:
                                                        if (obj instanceof OnGetTavExtraListener) {
                                                            this.onGetTavExtraListener = (OnGetTavExtraListener) obj;
                                                            break;
                                                        }
                                                        break;
                                                    case 26:
                                                        play(26);
                                                        break;
                                                }
                                        }
                                    } else {
                                        updateAudioClipsProperties();
                                    }
                                } else if (obj instanceof CGSize) {
                                    this.playerRenderer.setSurfaceSize((CGSize) obj);
                                    this.playerRenderer.initViewport(this.mMainHandler, true);
                                }
                            } else {
                                if (obj != null) {
                                    i16 = ((Integer) obj).intValue();
                                }
                                readSample(i16);
                            }
                        } else {
                            UpdateCompositionMessage updateCompositionMessage = (UpdateCompositionMessage) obj;
                            stop(true, true);
                            if (updateCompositionMessage != null) {
                                this.mPosition = updateCompositionMessage.position;
                                updateComposition(updateCompositionMessage.playerItem);
                                prepare(updateCompositionMessage.updateListener);
                            }
                        }
                    } else {
                        quit();
                    }
                } else {
                    readCurrentSample();
                }
            } else if (obj instanceof Runnable) {
                ((Runnable) obj).run();
            }
        } else {
            seekPreSample();
        }
        return true;
    }

    @NonNull
    private CMSampleState doReadSample(int i3, CMTime cMTime, CMTime cMTime2) {
        this.playerRenderer.makeCurrent();
        CMSampleBuffer readSampleBuffer = readSampleBuffer(i3, cMTime, cMTime2);
        CMSampleState state = readSampleBuffer.getState();
        if (this.mWeakPlayer.get() != null) {
            this.playerRenderer.renderSampleBuffer(readSampleBuffer, this.mWeakPlayer.get().getBgColor(), this.onGetTavExtraListener);
        }
        CMTime add = state.getTime().add(new CMTime(1L, state.getTime().timeScale));
        if (i3 != 5) {
            this.vDecoderTrack.asyncReadNextSample(add);
        }
        this.decoderConsumerTimeUs = Utils.getCurrentUsTime() - this.startTimeUsMark;
        return state;
    }

    private void fixFrameDuration() {
        try {
            long timeUs = this.frameDuration.divide(this.rate).getTimeUs() - (Utils.getCurrentUsTime() - this.startTimeUsMark);
            if (timeUs > 0) {
                LockMethodProxy.sleep(timeUs / 1000);
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "readSample: ", th5);
        }
    }

    @NonNull
    private CMSampleState fixSampleState(CMTime cMTime, CMSampleState cMSampleState, boolean z16, boolean z17) {
        if (cMSampleState.getStateCode() >= 0) {
            this.mPosition = cMSampleState.getTime();
            checkNotifyProgressChange(z16, z17);
            return cMSampleState;
        }
        if (cMSampleState.stateMatchingTo(-100)) {
            this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        }
        return new CMSampleState(cMTime);
    }

    private CMTime getLastSeekPosAndRemoveOther() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Message> continuesMessage = Utils.getContinuesMessage(5, PlayerMessage.class, this.playerThread.mPlayHandler);
        CMTime cMTime = CMTime.CMTimeInvalid;
        if (continuesMessage.isEmpty()) {
            return cMTime;
        }
        Object obj = continuesMessage.get(continuesMessage.size() - 1).obj;
        if (!(obj instanceof PlayerMessage)) {
            return cMTime;
        }
        CMTime cMTime2 = (CMTime) ((PlayerMessage) obj).bizMsg1;
        if (cMTime2 == cMTime) {
            return cMTime2;
        }
        Iterator<Message> it = continuesMessage.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            this.playerThread.mPlayHandler.removeMessages(next.what, next.obj);
        }
        return cMTime2;
    }

    private long getWaitTime(CMTime cMTime, boolean z16, boolean z17) {
        long timeUs = this.frameDuration.getTimeUs();
        cMTime.getTimeUs();
        if (!z16 && !z17) {
            return (((float) timeUs) / Math.abs(this.rate)) - this.decoderConsumerTimeUs;
        }
        return 0L;
    }

    private void initDecoderTrack(Object obj) {
        this.playerRenderer.initRenderContext();
        this.playerRenderer.initRenderSize(this.mPlayerItem.getVideoComposition());
        this.playerRenderer.initViewport(this.mMainHandler, false);
        updateProgressPreNextAction(this.mPosition);
        IDecoderTrack iDecoderTrack = this.aDecoderTrack;
        if (iDecoderTrack != null) {
            iDecoderTrack.start();
            this.mAudioThread.update(this.aDecoderTrack);
            this.aDecoderTrack.seekTo(this.mPosition, false, false);
        }
        if (this.vDecoderTrack != null) {
            tryInitVideoDecoder(obj);
        } else {
            onCompositionUpdate(obj, false);
        }
        updateStatus(2);
        synAudioComposition();
    }

    private void initVideoDecoder(Object obj) {
        this.vDecoderTrack.setFrameRate((int) (r1.timeScale / this.frameDuration.getValue()));
        this.vDecoderTrack.start(this.playerRenderer.getRenderContext());
        if (!this.loop) {
            if (this.mPosition == CMTime.CMTimeInvalid) {
                this.mPosition = this.vDecoderTrack.getDuration();
            }
            this.vDecoderTrack.seekTo(this.mPosition, false, true);
            readSample(1);
        }
        onCompositionUpdate(obj, true);
        Logger.v(TAG, "prepare: init codec-->" + Thread.currentThread().getName() + "--vDecoderTrack-->" + this.vDecoderTrack);
    }

    private void notifyProgressChange() {
        if (!this.playerThread.mPlayHandler.hasMessages(5)) {
            this.mMainHandler.obtainMessage(2, this.mPosition).sendToTarget();
        }
    }

    private void notifyStatus(IPlayer.PlayerStatus playerStatus, String str) {
        this.mMainHandler.obtainMessage(1, new PlayerStatusMsg(playerStatus, str)).sendToTarget();
    }

    private void onCompositionUpdate(Object obj, boolean z16) {
        if ((obj instanceof OnCompositionUpdateListener) && this.mWeakPlayer.get() != null) {
            ((OnCompositionUpdateListener) obj).onUpdated(this.mWeakPlayer.get(), z16);
        }
    }

    private void onPlayFinish() {
        IDecoderTrack iDecoderTrack = this.vDecoderTrack;
        if (iDecoderTrack != null) {
            if (this.mPosition.smallThan(iDecoderTrack.getDuration())) {
                this.vDecoderTrack.seekTo(this.mPosition, false, true);
            } else {
                this.vDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
            }
        }
        updateStatus(2);
        SeekTimeStore.clean();
    }

    private void pause() {
        this.loop = false;
        Logger.v(TAG, "pause: mLooper set to false");
        this.mPause = true;
        removePendingMessage(12);
        notifyStatus(IPlayer.PlayerStatus.PAUSED, "");
        SeekTimeStore.clean();
    }

    private void play(int i3) {
        int i16 = this.mStatus;
        if (i16 == 1) {
            if (this.vDecoderTrack != null || this.aDecoderTrack != null) {
                this.playerThread.sendMessage(1, "not can play");
                this.playerThread.sendMessage(2, "not can play");
                return;
            }
            return;
        }
        if (i16 == 3) {
            onPlayFinish();
        }
        removePendingMessage(12);
        this.loop = true;
        Logger.v(TAG, "play: mLooper set to true");
        this.playerThread.sendMessage(12, Integer.valueOf(i3), "play");
        notifyStatus(IPlayer.PlayerStatus.PLAYING, "");
        Logger.v(TAG, "playm() called start play-->" + this.mStatus);
        SeekTimeStore.clean();
    }

    private void playerFinish() {
        CMTime duration;
        Logger.d(TAG, "playFinish");
        if (this.mWeakPlayer.get() == null) {
            duration = new CMTime();
        } else {
            duration = this.mWeakPlayer.get().duration();
        }
        IDecoderTrack iDecoderTrack = this.vDecoderTrack;
        if (iDecoderTrack != null) {
            duration = iDecoderTrack.getDuration();
        }
        updateProgressPreNextAction(duration);
        notifyProgressChange();
        updateStatus(3);
        syncAudioOtherMsg(-1, null);
        IDecoderTrack iDecoderTrack2 = this.vDecoderTrack;
        if (iDecoderTrack2 != null) {
            iDecoderTrack2.seekTo(CMTime.CMTimeZero, false, true);
        }
        this.mStartTime = 0L;
        this.loop = false;
        notifyStatus(IPlayer.PlayerStatus.FINISHED, "");
    }

    private void prepare(Object obj) {
        if (this.mStatus == 1) {
            initDecoderTrack(obj);
        } else {
            this.playerThread.sendMessage(4, Boolean.FALSE, "prepare");
            this.playerThread.sendMessage(1, obj, "prepare");
        }
    }

    private void quit() {
        Logger.i(TAG, "quit: PlayerThreadMain " + this);
        removePendingMessage(new int[0]);
        this.playerThread.quitThread();
        this.vDecoderTrack.release();
        this.aDecoderTrack.release();
        this.playerRenderer.releaseRenderContext();
        this.vDecoderTrack = null;
        this.aDecoderTrack = null;
        this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
    }

    private void readCurrentSample() {
        CMSampleBuffer readCurrentSample = this.vDecoderTrack.readCurrentSample();
        if (readCurrentSample != null && this.mWeakPlayer.get() != null) {
            this.playerRenderer.renderSampleBuffer(readCurrentSample, this.mWeakPlayer.get().getBgColor(), this.onGetTavExtraListener);
        }
    }

    private void readSample(int i3) {
        readSample(i3, (this.mAudioThread.lastSyncMessgeId > this.lastSyncMessageId ? 1 : (this.mAudioThread.lastSyncMessgeId == this.lastSyncMessageId ? 0 : -1)) == 0 ? this.mAudioThread.getCurrentPlayingState() : CMTime.CMTimeInvalid);
    }

    @NonNull
    private CMSampleBuffer readSampleBuffer(int i3, CMTime cMTime, CMTime cMTime2) {
        boolean z16 = true;
        if (i3 == 5) {
            return this.vDecoderTrack.seekTo(cMTime, true, true);
        }
        CMTime multi = this.frameDuration.multi(this.rate);
        if (this.mWeakPlayer.get() == null || !this.mWeakPlayer.get().getEnableSync()) {
            z16 = false;
        }
        if (!z16) {
            return this.vDecoderTrack.readSample(cMTime2.add(multi));
        }
        if (cMTime2.smallThan(cMTime.sub(multi.multi(3.0f)))) {
            return this.vDecoderTrack.readSample(cMTime.divide(multi).multi(multi));
        }
        if (PlayerDefaultConfigs.enableVideoSyncOpt && cMTime2.bigThan(cMTime.add(multi)) && cMTime.bigThan(CMTime.CMTimeZero) && !this.mAudioThread.isFinished()) {
            Logger.v(TAG, "readSampleBuffer: sampleTime = /// " + cMTime2.add(multi));
            return this.vDecoderTrack.readSample(cMTime2);
        }
        Logger.v(TAG, "readSampleBuffer: sampleTime = " + cMTime2.add(multi));
        return this.vDecoderTrack.readSample(cMTime2.add(multi));
    }

    private void release(Message message) {
        Logger.d(TAG, "release player - " + this);
        this.playerRenderer.makeCurrent();
        Object obj = message.obj;
        if (obj instanceof PlayerMessage) {
            Object obj2 = ((PlayerMessage) obj).bizMsg1;
            if (obj2 instanceof Runnable) {
                ((Runnable) obj2).run();
            }
        }
        removePendingMessage(new int[0]);
        releaseAudioThread(message.what, message.obj);
        updateStatus(1);
        this.reportSession.flush();
        this.codecPerfReportSession.flush();
    }

    private void releaseAudioThread(int i3, Object obj) {
        if (i3 == 6) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d(TAG, "releaseAudioThread SyncMessageId = " + this.lastSyncMessageId + "  action = " + i3 + "  obj =  " + obj);
            this.mAudioThread.sendMessage(i3, obj, "syncAudioStatus", this.lastSyncMessageId);
        }
    }

    private void releaseComposition() {
        if (this.vDecoderTrack == null) {
            return;
        }
        if (this.mPlayerItem.getCustomVideoCompositor() != null) {
            this.mPlayerItem.getCustomVideoCompositor().release();
        }
        this.vDecoderTrack.release();
        this.aDecoderTrack.release();
    }

    private void removePendingMessage(int... iArr) {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleMessage() called with: removeInt = [");
        if (iArr.length == 0) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(iArr[0]);
        }
        sb5.append(valueOf);
        sb5.append("]");
        Logger.v(TAG, sb5.toString());
        if (iArr.length != 0) {
            for (int i3 : iArr) {
                this.playerThread.mPlayHandler.removeMessages(i3);
            }
            return;
        }
        synchronized (this.playerThread.mPlayHandler) {
            if (!this.playerThread.mPlayHandler.hasMessages(850)) {
                this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
            } else {
                this.playerThread.mPlayHandler.removeCallbacksAndMessages(null);
                this.playerThread.mPlayHandler.sendEmptyMessage(850);
            }
        }
    }

    private void removePendingMessageUnless(int... iArr) {
        try {
            for (Integer num : PlayerThread.msgMap.keySet()) {
                if (Arrays.binarySearch(iArr, num.intValue()) < 0) {
                    this.playerThread.mPlayHandler.removeMessages(num.intValue());
                }
            }
        } catch (Exception e16) {
            Logger.e(TAG, "removePendingMessageUnless: ", e16);
        }
    }

    private void scheduleNextWork(CMSampleState cMSampleState, boolean z16) {
        if (this.loop) {
            boolean z17 = this.mPause;
            this.decoderConsumerTimeUs = (Utils.getCurrentUsTime() - this.startTimeUsMark) + 5000;
            scheduleNextWork(getWaitTime(cMSampleState.getTime(), z16, z17));
            this.mPause = false;
        }
    }

    private void seek(CMTime cMTime) {
        seek(cMTime, null);
    }

    private void seekPreSample() {
        CMTime currentSampleTime = this.vDecoderTrack.getCurrentSampleTime();
        if (currentSampleTime != CMTime.CMTimeInvalid) {
            seek(currentSampleTime);
        }
    }

    private void stop(boolean z16) {
        stop(z16, false);
    }

    private void synAudioComposition() {
        if (this.aDecoderTrack != null) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d(TAG, "synAudioComposition SyncMessageId = " + this.lastSyncMessageId);
            this.mAudioThread.sendMessage(1, null, "syncAudioStatus composition", this.lastSyncMessageId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncAudioOtherMsg(int i3, Object obj) {
        if (i3 == 3 || i3 == 2 || i3 == 4 || i3 == 6 || i3 == 7 || i3 == -1 || i3 == 5) {
            this.lastSyncMessageId = System.currentTimeMillis();
            Logger.d(TAG, "syncAudioOtherMsg SyncMessageId = " + this.lastSyncMessageId + "  action = " + i3 + "  obj = " + obj);
            this.mAudioThread.sendMessage(i3, obj, "syncAudioStatus", this.lastSyncMessageId);
        }
    }

    private void syncAudioPosition(int i3, CMTime cMTime, CMTime cMTime2) {
        if (i3 == 2 || (i3 == 26 && this.mAudioThread.currentPlayingState.isInvalid())) {
            syncAudioOtherMsg(2, cMTime2);
        }
    }

    private void syncAudioProgress() {
        IDecoderTrack iDecoderTrack = this.aDecoderTrack;
        if (iDecoderTrack == null) {
            return;
        }
        if (!this.mPosition.equalsTo(iDecoderTrack.getCurrentSampleTime())) {
            this.mPosition = this.aDecoderTrack.getCurrentSampleTime();
            notifyProgressChange();
        }
        if (this.mAudioThread.isFinished()) {
            Logger.v(TAG, "processFrame() called with: finish");
            playerFinish();
        } else if (this.loop) {
            scheduleNextWork(30L);
            this.mPause = false;
        }
    }

    private void tryInitVideoDecoder(Object obj) {
        try {
            initVideoDecoder(obj);
        } catch (Exception e16) {
            Logger.e(TAG, "init composition cause exception: ", e16);
            this.vDecoderTrack.release();
            this.vDecoderTrack = null;
            onCompositionUpdate(obj, false);
        }
    }

    private void updateAudioClipsProperties() {
        IDecoderTrack iDecoderTrack = this.aDecoderTrack;
        if (iDecoderTrack != null) {
            iDecoderTrack.release();
        }
        AudioCompositionDecoderTrack initAudioCompositionDecoderTrack = this.mPlayerItem.initAudioCompositionDecoderTrack();
        this.aDecoderTrack = initAudioCompositionDecoderTrack;
        initAudioCompositionDecoderTrack.start();
        this.mAudioThread.update(this.aDecoderTrack);
        if (this.loop) {
            syncAudioOtherMsg(2, this.mPosition);
        }
    }

    private void updateComposition(Object obj) {
        Logger.i(TAG, "updateComposition() called with: obj = [" + obj + "]");
        if (obj instanceof PlayerItem) {
            PlayerItem playerItem = (PlayerItem) obj;
            this.vDecoderTrack = playerItem.getRealDecoderTrack();
            this.aDecoderTrack = playerItem.getAudioCompositionDecoderTrack();
            this.mPlayerItem = playerItem;
        }
        IDecoderTrack iDecoderTrack = this.vDecoderTrack;
        if (iDecoderTrack != null) {
            this.frameDuration = iDecoderTrack.getFrameDuration();
        }
    }

    private void updateProgressPreNextAction(CMTime cMTime) {
        this.mPosition = cMTime;
    }

    private void updateStatus(int i3) {
        this.mStatus = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindSurface(IDecoderTrack iDecoderTrack, PlayerLayer playerLayer) {
        this.playerRenderer.bindSurface(playerLayer);
        this.vDecoderTrack = iDecoderTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CGRect getGlViewportRect() {
        return this.playerRenderer.getGlViewportRect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContextParams getRenderContextParams() {
        return this.playerRenderer.getRenderContextParams();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PlayerMessage playerMessage;
        Object obj;
        Object obj2 = message.obj;
        Object obj3 = null;
        if (obj2 == null) {
            playerMessage = null;
        } else {
            playerMessage = (PlayerMessage) obj2;
        }
        if (playerMessage != null) {
            obj3 = playerMessage.bizMsg1;
            obj = playerMessage.bizMsg2;
        } else {
            obj = null;
        }
        int i3 = message.what;
        if (i3 != 2 && i3 != 26) {
            syncAudioOtherMsg(i3, obj2);
        }
        if (this.playerThread.mThread == null) {
            return false;
        }
        try {
            return dispatchMessage(message, obj3, obj);
        } catch (Exception e16) {
            Logger.e(TAG, "player error:", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAudioThread(PlayerThreadAudio playerThreadAudio) {
        this.mAudioThread = playerThreadAudio;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRate(float f16) {
        this.rate = f16;
        this.mAudioThread.setRate(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.playerRenderer.setRenderContextParams(renderContextParams);
        this.codecPerfReportSession.setRenderContextParams(renderContextParams);
    }

    private void seek(CMTime cMTime, @Nullable Callback callback) {
        if (this.mStatus == 1) {
            return;
        }
        CMTime cMTime2 = CMTime.CMTimeInvalid;
        try {
            cMTime2 = getLastSeekPosAndRemoveOther();
        } catch (Exception e16) {
            Logger.e(TAG, "seek: ", e16);
        }
        if (cMTime2.getValue() > -1) {
            cMTime = cMTime2;
        }
        if (this.vDecoderTrack != null) {
            removePendingMessage(12);
            this.mPosition = cMTime;
            notifyProgressChange();
            syncAudioOtherMsg(3, cMTime);
            syncAudioOtherMsg(5, cMTime);
            if (cMTime.getTimeUs() == SeekTimeStore.getLastSeekTime()) {
                SeekTimeStore.clean();
            }
            readSample(5, cMTime);
            this.playerThread.mPlayHandler.postDelayed(new Runnable() { // from class: com.tencent.tav.player.PlayerMessageHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayerMessageHandler.this.loop) {
                        PlayerMessageHandler.this.syncAudioOtherMsg(2, null);
                    }
                }
            }, 10L);
        } else {
            syncAudioOtherMsg(5, cMTime);
        }
        if (callback != null) {
            callback.call();
        }
    }

    private void stop(boolean z16, boolean z17) {
        releaseComposition();
        this.playerRenderer.releaseFilter();
        this.mStartTime = 0L;
        updateStatus(1);
        if (z16) {
            notifyStatus(IPlayer.PlayerStatus.STOPPED, "");
            if (z17) {
                removePendingMessageUnless(101, 850);
            } else {
                removePendingMessage(new int[0]);
            }
            this.loop = false;
            Logger.v(TAG, "stop: mLooper set to false");
        }
    }

    private void readSample(int i3, CMTime cMTime) {
        if (this.vDecoderTrack == null) {
            syncAudioProgress();
            return;
        }
        if (i3 == 2 || i3 == 26) {
            this.loop = true;
        }
        fixFrameDuration();
        CMTime currentSampleTime = this.vDecoderTrack.getCurrentSampleTime();
        syncAudioPosition(i3, cMTime, currentSampleTime);
        this.startTimeUsMark = Utils.getCurrentUsTime();
        CMSampleState cMSampleState = new CMSampleState();
        try {
            cMSampleState = doReadSample(i3, cMTime, currentSampleTime);
        } catch (Exception e16) {
            Logger.e(TAG, "readSample: ", e16);
            if (e16 instanceof IllegalStateException) {
                notifyStatus(IPlayer.PlayerStatus.ERROR, ImageTaskConst.ErrorDesciption.IMAGE_TASK_DECODE_EXCEPTION_DESC);
                return;
            }
        }
        if (cMSampleState.stateMatchingTo(-1, -3)) {
            Logger.v(TAG, "readSample() called with: finish");
            if (cMSampleState.stateMatchingTo(-3)) {
                this.reportSession.onReadSampleError();
            }
            playerFinish();
            return;
        }
        boolean z16 = 5 == i3;
        scheduleNextWork(fixSampleState(currentSampleTime, cMSampleState, z16, 1 == i3), z16);
        this.codecPerfReportSession.tickFrameTimeConsume((Utils.getCurrentUsTime() - this.startTimeUsMark) / 1000);
    }

    private void scheduleNextWork(long j3) {
        long j16 = j3 / 1000;
        if (j16 > 0) {
            Logger.v("scheduleNextWork", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME + j16);
            this.playerThread.sendMessageDelay(12, j16, "schedule next");
            return;
        }
        this.playerThread.sendMessage(12, "schedule next");
    }
}
