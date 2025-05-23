package com.tencent.tav.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public class PlayerThreadAudio implements Handler.Callback {
    private static final String TAG = "PlayerThreadAudio";
    private IDecoderTrack audioDecoderTrack;
    private AudioTrackWrapper mAudioTrack;
    private boolean mLooper;
    private Handler mPlayHandler;
    private HandlerThread mThread;
    private Handler mVideoHandler;
    public volatile CMSampleState currentPlayingState = new CMSampleState();
    public volatile long lastSyncMessgeId = -1;
    private int mStatus = 1;
    private float rate = 1.0f;
    private float volume = 1.0f;

    public PlayerThreadAudio(IDecoderTrack iDecoderTrack, Handler handler) {
        this.audioDecoderTrack = iDecoderTrack;
        this.mVideoHandler = handler;
        initThread();
    }

    private void actionPrepare() {
        if (this.audioDecoderTrack != null) {
            updateStatus(2);
            releaseAudioTrack();
        }
    }

    private String catLog(int i3) {
        return PlayerThread.catLog(i3);
    }

    private void initThread() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PlayerAudioThread");
        this.mThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
    }

    private void pause() {
        if (this.mStatus == 2) {
            this.mLooper = false;
            this.currentPlayingState = new CMSampleState();
            removePendingMessage(12);
        }
    }

    private void play(Object obj) {
        if (this.mStatus == 1) {
            return;
        }
        this.mLooper = true;
        if ((obj instanceof CMTime) && Math.abs(((CMTime) obj).getTimeUs() - this.currentPlayingState.getTime().getTimeUs()) > JsonGrayBusiId.UI_RESERVE_100000_110000) {
            seekTo(obj);
        }
        if (this.mStatus == 3) {
            updateStatus(2);
        }
        sendMessage(12, "play", System.currentTimeMillis());
    }

    private void playerFinish() {
        this.currentPlayingState = new CMSampleState();
        this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
        this.mLooper = false;
        updateStatus(3);
        removePendingMessage(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readSample() {
        CMSampleBuffer cMSampleBuffer;
        IDecoderTrack iDecoderTrack = this.audioDecoderTrack;
        if (iDecoderTrack != null && this.mLooper) {
            if (iDecoderTrack instanceof AudioCompositionDecoderTrack) {
                ((AudioCompositionDecoderTrack) iDecoderTrack).setRate(this.rate);
            } else if (iDecoderTrack instanceof ReverseAudioDecoderTrack) {
                ((ReverseAudioDecoderTrack) iDecoderTrack).setRate(this.rate);
            }
            CMSampleState fromError = CMSampleState.fromError(-2L);
            v(TAG, "readSample start");
            byte[] bArr = null;
            try {
                cMSampleBuffer = this.audioDecoderTrack.readSample();
                try {
                    fromError = cMSampleBuffer.getState();
                    v(TAG, "readSample finish " + fromError);
                } catch (Exception e16) {
                    e = e16;
                    Logger.e(TAG, "java.lang.IllegalStateException: buffer was freed", e);
                    this.currentPlayingState = fromError;
                    v(TAG, "processFrame() called sampleState--> " + fromError);
                    if (this.mAudioTrack == null) {
                    }
                    if (fromError.stateMatchingTo(-1, -3, -100)) {
                    }
                    v(TAG, "processFrame() called end of stream");
                    playerFinish();
                }
            } catch (Exception e17) {
                e = e17;
                cMSampleBuffer = null;
            }
            this.currentPlayingState = fromError;
            v(TAG, "processFrame() called sampleState--> " + fromError);
            if (this.mAudioTrack == null) {
                v(TAG, "processFrame() called new mediaFormat");
                AudioTrackWrapper audioTrackWrapper = new AudioTrackWrapper(44100, 1);
                this.mAudioTrack = audioTrackWrapper;
                audioTrackWrapper.setVolume(this.volume);
            }
            if (fromError.stateMatchingTo(-1, -3, -100) && !fromError.getTime().bigThan(this.audioDecoderTrack.getDuration())) {
                if (fromError.getStateCode() >= 0 && cMSampleBuffer != null) {
                    try {
                        ByteBuffer sampleByteBuffer = cMSampleBuffer.getSampleByteBuffer();
                        if (sampleByteBuffer != null) {
                            sampleByteBuffer.position(0);
                            bArr = new byte[sampleByteBuffer.limit()];
                            Logger.v(TAG, "read sample thread: " + Thread.currentThread().getId() + " " + cMSampleBuffer.getTime());
                            sampleByteBuffer.get(bArr);
                        }
                    } catch (Exception e18) {
                        Logger.e(TAG, "readSample: ", e18);
                    }
                    if (bArr != null) {
                        v(TAG, "processFrame() called run audioData length audioData--" + bArr.length);
                        this.audioDecoderTrack.asyncReadNextSample(CMTime.CMTimeInvalid);
                        this.mAudioTrack.writeData(bArr, 0, bArr.length);
                    } else {
                        v(TAG, "processFrame() called run audioData length exception");
                    }
                }
                if (this.mLooper && this.rate != 0.0f) {
                    v(TAG, "processFrame() called run looper " + this.currentPlayingState);
                    scheduleNextWork();
                    return;
                }
                v(TAG, "processFrame() not run looper");
                return;
            }
            v(TAG, "processFrame() called end of stream");
            playerFinish();
        }
    }

    private void release() {
        releaseAudioTrack();
        removePendingMessage(new int[0]);
        updateStatus(1);
        try {
            try {
                Log.e(TAG, "quit: PlayerThreadAudio " + this);
                this.mThread.quit();
                this.mThread = null;
                synchronized (this.mVideoHandler) {
                    this.mVideoHandler.sendEmptyMessage(850);
                }
            } catch (Exception e16) {
                Logger.e(TAG, "release error-->", e16);
                synchronized (this.mVideoHandler) {
                    this.mVideoHandler.sendEmptyMessage(850);
                }
            }
            this.mPlayHandler = null;
            this.mVideoHandler = null;
        } catch (Throwable th5) {
            synchronized (this.mVideoHandler) {
                this.mVideoHandler.sendEmptyMessage(850);
                this.mPlayHandler = null;
                this.mVideoHandler = null;
                throw th5;
            }
        }
    }

    private void releaseAudioTrack() {
        AudioTrackWrapper audioTrackWrapper = this.mAudioTrack;
        if (audioTrackWrapper != null) {
            audioTrackWrapper.stop();
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    private void removePendingMessage(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                this.mPlayHandler.removeMessages(i3);
            }
            return;
        }
        this.mPlayHandler.removeCallbacksAndMessages(null);
    }

    private void scheduleNextWork() {
        sendMessage(12, "schedule next", System.currentTimeMillis());
    }

    private void seekTo(Object obj) {
        if (obj instanceof PlayerMessage) {
            obj = ((PlayerMessage) obj).bizMsg1;
        }
        if (obj instanceof CMTime) {
            CMTime cMTime = (CMTime) obj;
            this.currentPlayingState = new CMSampleState(cMTime);
            this.audioDecoderTrack.seekTo(cMTime, false, true);
        }
        AudioTrackWrapper audioTrackWrapper = this.mAudioTrack;
        if (audioTrackWrapper != null) {
            audioTrackWrapper.flush();
        }
    }

    private void setVolume(Object obj) {
        float f16;
        if (obj instanceof PlayerMessage) {
            f16 = ((Float) ((PlayerMessage) obj).bizMsg1).floatValue();
        } else if (obj instanceof Float) {
            f16 = ((Float) obj).floatValue();
        } else {
            f16 = 1.0f;
        }
        if (f16 >= 0.0f && f16 <= 1.0f) {
            setVolumeToAudioTrack(f16);
        }
    }

    private void setVolumeToAudioTrack(float f16) {
        this.volume = f16;
        AudioTrackWrapper audioTrackWrapper = this.mAudioTrack;
        if (audioTrackWrapper != null) {
            audioTrackWrapper.setVolume(f16);
        }
    }

    private void stop(boolean z16) {
        if (z16) {
            removePendingMessage(12);
            this.mLooper = false;
            this.currentPlayingState = new CMSampleState();
        }
        updateStatus(1);
        releaseAudioTrack();
    }

    private void updateStatus(int i3) {
        this.mStatus = i3;
    }

    private void v(String str, String str2) {
        Logger.v(str, str2);
    }

    public CMTime getCurrentPlayingState() {
        return this.currentPlayingState.getTime();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PlayerMessage playerMessage;
        Object obj;
        Object obj2 = message.obj;
        PlayerMessage playerMessage2 = null;
        if (obj2 == null) {
            playerMessage = null;
        } else {
            playerMessage = (PlayerMessage) obj2;
        }
        if (playerMessage != null) {
            obj = playerMessage.bizMsg1;
        } else {
            obj = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleMessage() called with: msg = [");
        sb5.append(catLog(message.what));
        sb5.append(message.what);
        sb5.append("]--status-->");
        sb5.append(this.mStatus);
        sb5.append("--from-->");
        if (playerMessage != null) {
            playerMessage2 = playerMessage;
        }
        sb5.append(playerMessage2);
        sb5.append(" targetObj = ");
        sb5.append(obj);
        v(TAG, sb5.toString());
        try {
            try {
                int i3 = message.what;
                if (i3 != -1) {
                    if (i3 != 12) {
                        switch (i3) {
                            case 1:
                                actionPrepare();
                                break;
                            case 2:
                                play(obj);
                                break;
                            case 3:
                                pause();
                                break;
                            case 4:
                                stop(false);
                                break;
                            case 5:
                                seekTo(obj);
                                break;
                            case 6:
                                release();
                                break;
                            case 7:
                                setVolume(obj);
                                break;
                        }
                    } else {
                        readSample();
                    }
                } else {
                    playerFinish();
                }
                if (playerMessage != null && !TextUtils.isEmpty(playerMessage.form) && playerMessage.form.startsWith("syncAudioStatus")) {
                    Log.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage.msgId + ", what = " + message.what);
                    this.lastSyncMessgeId = playerMessage.msgId;
                    return true;
                }
                return true;
            } catch (Exception e16) {
                Logger.e(TAG, "handleMessage: error", e16);
                if (playerMessage != null && !TextUtils.isEmpty(playerMessage.form) && playerMessage.form.startsWith("syncAudioStatus")) {
                    Log.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage.msgId + ", what = " + message.what);
                    this.lastSyncMessgeId = playerMessage.msgId;
                }
                return false;
            }
        } catch (Throwable th5) {
            if (playerMessage != null && !TextUtils.isEmpty(playerMessage.form) && playerMessage.form.startsWith("syncAudioStatus")) {
                Log.d(TAG, "handleMessage:  SyncMessageId = " + playerMessage.msgId + ", what = " + message.what);
                this.lastSyncMessgeId = playerMessage.msgId;
            }
            throw th5;
        }
    }

    public boolean isFinished() {
        if (3 == this.mStatus && this.currentPlayingState.isInvalid()) {
            return true;
        }
        return false;
    }

    public void sendMessage(int i3, Object obj, String str, long j3) {
        v(TAG, "sendMessage() called with: what = [" + catLog(i3) + "], obj = [" + obj + "], from = [" + str + "]");
        Handler handler = this.mPlayHandler;
        if (handler == null || this.mThread == null) {
            return;
        }
        if ((i3 == 3 || i3 == -1 || i3 == 5 || i3 == 6) && handler.hasMessages(12)) {
            this.mPlayHandler.removeMessages(12);
            sendMessage(12, "schedule next", System.currentTimeMillis());
        }
        this.mPlayHandler.obtainMessage(i3, new PlayerMessage(obj, str, j3)).sendToTarget();
    }

    public void sendMessageDelay(int i3, long j3, String str, long j16) {
        v(TAG, "sendMessageDelay() called with: what = [" + catLog(i3) + "], delay = [" + j3 + "], from = [" + str + "]");
        if (this.mPlayHandler != null) {
            Message message = new Message();
            message.what = i3;
            message.obj = new PlayerMessage(null, str, j16);
            this.mPlayHandler.sendMessageDelayed(message, j3);
        }
    }

    public void setRate(float f16) {
        this.rate = Math.abs(f16);
    }

    public void update(IDecoderTrack iDecoderTrack) {
        this.audioDecoderTrack = iDecoderTrack;
    }

    @Deprecated
    public void updateComposition(AudioCompositionDecoderTrack audioCompositionDecoderTrack) {
        sendMessage(4, "updateComposition", System.currentTimeMillis());
        sendMessage(1, audioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
    }

    public void sendMessage(int i3, String str, long j3) {
        v(TAG, "sendMessage() called with: what = [" + catLog(i3) + "], from = [" + str + "]");
        Handler handler = this.mPlayHandler;
        if (handler == null || this.mThread == null) {
            return;
        }
        handler.obtainMessage(i3, new PlayerMessage(null, str, j3)).sendToTarget();
    }
}
