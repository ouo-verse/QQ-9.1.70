package com.tencent.tav.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.RCHandlerThread;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.SeekTimeStore;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class PlayerThread {
    static final int ACTION_FINISH = -1;
    static final int ACTION_GET_TAV_EXTRA_INFO = 25;
    static final int ACTION_PAUSE = 3;
    static final int ACTION_PLAY = 2;
    static final int ACTION_PLAY_NOT_SYNC = 26;
    static final int ACTION_POST = 101;
    static final int ACTION_PREPARE = 1;
    static final int ACTION_QUIT = 850;
    static final int ACTION_READ_CURRENT_SAMPLE = 231;
    static final int ACTION_READ_SAMPLE = 12;
    static final int ACTION_READ_SNAP_SHOOT_BITMAP = 24;
    static final int ACTION_RELEASE = 6;
    static final int ACTION_SEEK = 5;
    static final int ACTION_SEEK_PRE_SAMPLE = 9;
    static final int ACTION_SET_VOLUME = 7;
    static final int ACTION_STOP = 4;
    static final int ACTION_UPDATE_ALLPROPERTIES = 20;
    static final int ACTION_UPDATE_AUDIOCLIP_PROPERTIES = 22;
    static final int ACTION_UPDATE_AUDIOVOLUME_PROPERTIES = 23;
    static final int ACTION_UPDATE_COMPOSITION = 11;
    static final int ACTION_UPDATE_PROPERTIES = 10;
    static final int ACTION_UPDATE_SIZE = 21;
    static final int STATUS_FINISH = 3;
    static final int STATUS_INIT_CODEC = 2;
    static final int STATUS_NONE = 1;
    private static final String TAG = "PlayerThreadMain";
    static HashMap<Integer, String> msgMap;
    final Handler mPlayHandler;

    @Nullable
    HandlerThread mThread;
    private final PlayerMessageHandler messageHandler;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>(20);
        msgMap = hashMap;
        hashMap.put(-1, "ACTION_FINISH");
        msgMap.put(1, "\u521d\u59cb\u5316");
        msgMap.put(2, "\u64ad\u653e");
        msgMap.put(3, "\u6682\u505c");
        msgMap.put(4, "\u505c\u6b62");
        msgMap.put(5, "\u62d6\u52a8");
        msgMap.put(6, "\u7ed3\u675f\u7ebf\u7a0b");
        msgMap.put(7, "ACTION_SET_VOLUME");
        msgMap.put(9, "ACTION_SEEK_PRE_SAMPLE");
        msgMap.put(10, "ACTION_UPDATE_PROPERTIES");
        msgMap.put(11, "ACTION_UPDATE_COMPOSITION");
        msgMap.put(20, "ACTION_UPDATE_ALLPROPERTIES");
        msgMap.put(21, "ACTION_UPDATE_SIZE");
        msgMap.put(22, "ACTION_UPDATE_AUDIOCLIP_PROPERTIES");
        msgMap.put(23, "ACTION_UPDATE_AUDIOVOLUME_PROPERTIES");
        msgMap.put(24, "ACTION_READ_SNAP_SHOOT_BITMAP");
        msgMap.put(25, "ACTION_GET_TAV_EXTRA_INFO");
        msgMap.put(26, "reaACTION_PLAY_NOT_SYNC");
        msgMap.put(Integer.valueOf(ACTION_QUIT), "ACTION_QUIT");
        msgMap.put(101, "ACTION_POST");
        msgMap.put(12, "\u8bfb\u53d6\u4e0b\u4e00\u5e27");
        msgMap.put(231, "read\u5f53\u524d\u5e27");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerThread(@Nullable IDecoderTrack iDecoderTrack, @Nullable IDecoderTrack iDecoderTrack2, @NonNull Player player) {
        HandlerThread videoThread = player.getVideoThread();
        this.mThread = videoThread;
        if (videoThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PlayerVideoThread");
            this.mThread = baseHandlerThread;
            baseHandlerThread.start();
        } else if ((videoThread instanceof RCHandlerThread) && videoThread.isAlive()) {
            ((RCHandlerThread) this.mThread).reference();
        }
        PlayerMessageHandler playerMessageHandler = new PlayerMessageHandler(this, iDecoderTrack, iDecoderTrack2, player);
        this.messageHandler = playerMessageHandler;
        Handler handler = new Handler(this.mThread.getLooper(), playerMessageHandler);
        this.mPlayHandler = handler;
        playerMessageHandler.setAudioThread(new PlayerThreadAudio(iDecoderTrack2, handler));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String catLog(int i3) {
        String str = msgMap.get(Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            Logger.e("PlayerThreadMain", "catLog: \u672a\u52a0\u5165\u96c6\u5408\u7684\u6d88\u606f\u5b9a\u4e49\uff01\uff01\uff01");
            return String.valueOf(i3);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindSurface(IDecoderTrack iDecoderTrack, PlayerLayer playerLayer) {
        this.messageHandler.bindSurface(iDecoderTrack, playerLayer);
        sendMessage(1, "bind surface");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CGRect getGlViewportRect() {
        return this.messageHandler.getGlViewportRect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CMTime getPosition() {
        return this.messageHandler.mPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderContextParams getRenderContextParams() {
        return this.messageHandler.getRenderContextParams();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMessage(int i3) {
        Handler handler = this.mPlayHandler;
        if (handler != null && this.mThread != null) {
            return handler.hasMessages(i3);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean post(Runnable runnable) {
        if (this.mPlayHandler == null) {
            return false;
        }
        sendMessage(101, runnable, "main");
        return true;
    }

    public void quitThread() {
        HandlerThread handlerThread = this.mThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean refresh() {
        if (this.mPlayHandler == null) {
            return false;
        }
        removeMessages(231);
        sendMessage(231, "main");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMessages(int i3) {
        Logger.v("PlayerThreadMain", "removeMessages() called with: what = [" + catLog(i3) + "]");
        Handler handler = this.mPlayHandler;
        if (handler != null && this.mThread != null) {
            handler.removeMessages(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i3, Object obj, Object obj2, String str) {
        if (i3 == 5) {
            SeekTimeStore.updateSeekTime(((CMTime) obj).getTimeUs());
        }
        Handler handler = this.mPlayHandler;
        if (handler == null || this.mThread == null) {
            return;
        }
        handler.removeMessages(i3);
        this.mPlayHandler.obtainMessage(i3, new PlayerMessage(obj, obj2, str, System.currentTimeMillis())).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessageDelay(int i3, long j3, String str) {
        Logger.v("PlayerThreadMain", "sendMessageDelay() called with: what = [" + catLog(i3) + "], delay = [" + j3 + "], from = [" + str + "]");
        if (this.mPlayHandler != null) {
            Message message = new Message();
            message.what = i3;
            message.obj = new PlayerMessage(null, str, System.currentTimeMillis());
            this.mPlayHandler.sendMessageDelayed(message, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFrameDuration(CMTime cMTime) {
        this.messageHandler.frameDuration = cMTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRate(float f16) {
        this.messageHandler.setRate(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.messageHandler.setRenderContextParams(renderContextParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePositionRightAway(CMTime cMTime) {
        this.messageHandler.mPosition = cMTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i3, Object obj, String str) {
        Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(i3) + "], obj = [" + obj + "], from = [" + str + "]");
        Handler handler = this.mPlayHandler;
        if (handler == null || this.mThread == null) {
            return;
        }
        handler.obtainMessage(i3, new PlayerMessage(obj, str, System.currentTimeMillis())).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMessage(int i3, String str) {
        Logger.v("PlayerThreadMain", "sendMessage() called with: what = [" + catLog(i3) + "], from = [" + str + "]");
        Handler handler = this.mPlayHandler;
        if (handler == null || this.mThread == null) {
            return;
        }
        handler.obtainMessage(i3, new PlayerMessage(null, str, System.currentTimeMillis())).sendToTarget();
    }
}
