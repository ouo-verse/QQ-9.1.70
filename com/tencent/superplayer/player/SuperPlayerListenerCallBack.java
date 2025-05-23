package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.player.ListenerCombine;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class SuperPlayerListenerCallBack implements ListenerCombine.ISuperPlayerCombine {
    private static final int ON_CAPTURE_IMAGE_FAILED = 7;
    private static final int ON_CAPTURE_IMAGE_SUCCEED = 6;
    private static final int ON_COMPLETION = 4;
    private static final int ON_DEFINITION_INFO_UPDATE = 9;
    private static final int ON_ERROR = 2;
    private static final int ON_INFO = 3;
    private static final int ON_SEEK_COMPLETE = 5;
    private static final int ON_TVIDEO_NETINFO_UPDATE = 10;
    private static final int ON_VIDEO_PREPARED = 1;
    private static final int ON_VIDEO_SIZE_CHANGED = 8;
    private CallBackEventHandler mCallBackEventHandler;
    private WeakReference<SuperPlayerListenerMgr> mListenerMgrWeakReference;
    private WeakReference<ISuperPlayer> mPlayerWeakReference;
    private Queue<Message> mMessageQueue = new LinkedList();
    private AtomicBoolean mIsBlockCallback = new AtomicBoolean(false);
    private boolean notifyPreparedPlayMsgAhead = false;
    private boolean mHasNotifyCacheFinish = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class CallBackEventHandler extends Handler {
        public CallBackEventHandler(Looper looper) {
            super(looper);
        }

        private boolean interceptorProgress(Object obj) {
            if ((obj instanceof TPDownloadProgressInfo) && (SuperPlayerListenerCallBack.this.getPlayer() instanceof SuperPlayerMgr)) {
                try {
                    JSONObject jSONObject = new JSONObject(((TPDownloadProgressInfo) obj).getExtraInfo());
                    int optInt = jSONObject.optInt("localCacheSize");
                    if (optInt == jSONObject.optInt("actualFileSize") && optInt > 0 && !SuperPlayerListenerCallBack.this.mHasNotifyCacheFinish) {
                        SuperPlayerListenerCallBack.this.mHasNotifyCacheFinish = true;
                        SuperPlayerListenerCallBack.this.handleOnInfo(266, 0L, 0L, obj);
                        ISuperPlayer player = SuperPlayerListenerCallBack.this.getPlayer();
                        if (player != null) {
                            LogUtil.i(player.getToken(), "notify all cache size finish:" + obj);
                        }
                        return true;
                    }
                    return false;
                } catch (Exception e16) {
                    ISuperPlayer player2 = SuperPlayerListenerCallBack.this.getPlayer();
                    if (player2 != null) {
                        LogUtil.e(player2.getToken(), e16);
                        return false;
                    }
                    return false;
                }
            }
            return false;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SuperPlayerListenerCallBack.this.handleOnVideoPrepared();
                    return;
                case 2:
                    OnErrorParams onErrorParams = (OnErrorParams) message.obj;
                    SuperPlayerListenerCallBack.this.handleOnError(onErrorParams.module, onErrorParams.errorType, onErrorParams.errorCode, onErrorParams.extraInfo);
                    return;
                case 3:
                    OnInfoParams onInfoParams = (OnInfoParams) message.obj;
                    int i3 = onInfoParams.what;
                    if (i3 != 207) {
                        SuperPlayerListenerCallBack.this.handleOnInfo(i3, onInfoParams.arg1, onInfoParams.arg2, onInfoParams.extra);
                        return;
                    } else {
                        if (!interceptorProgress(onInfoParams.extra)) {
                            SuperPlayerListenerCallBack.this.handleOnInfo(onInfoParams.what, onInfoParams.arg1, onInfoParams.arg2, onInfoParams.extra);
                            return;
                        }
                        return;
                    }
                case 4:
                    SuperPlayerListenerCallBack.this.handleOnCompletion();
                    return;
                case 5:
                    SuperPlayerListenerCallBack.this.handleOnSeekComplete();
                    return;
                case 6:
                    OnCaptureImageSucceeParams onCaptureImageSucceeParams = (OnCaptureImageSucceeParams) message.obj;
                    SuperPlayerListenerCallBack.this.handleOnCaptureImageSucceed(onCaptureImageSucceeParams.f373918id, onCaptureImageSucceeParams.width, onCaptureImageSucceeParams.height, onCaptureImageSucceeParams.bitmap);
                    return;
                case 7:
                    OnCaptureImageFailedParams onCaptureImageFailedParams = (OnCaptureImageFailedParams) message.obj;
                    SuperPlayerListenerCallBack.this.handleOnCaptureImageFailed(onCaptureImageFailedParams.f373917id, onCaptureImageFailedParams.errCode);
                    return;
                case 8:
                    OnVideoSizeParams onVideoSizeParams = (OnVideoSizeParams) message.obj;
                    SuperPlayerListenerCallBack.this.handleOnVideoSizeChanged(onVideoSizeParams.width, onVideoSizeParams.height);
                    return;
                case 9:
                    OnDefinitionInfoParams onDefinitionInfoParams = (OnDefinitionInfoParams) message.obj;
                    SuperPlayerListenerCallBack.this.handleOnDefinitionUpdate(onDefinitionInfoParams.currentDefinition, onDefinitionInfoParams.definitionList);
                    return;
                case 10:
                    SuperPlayerListenerCallBack.this.handleOnTVideoNetInfoUpdate((TVideoNetInfo) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnCaptureImageFailedParams {
        int errCode;

        /* renamed from: id, reason: collision with root package name */
        int f373917id;

        OnCaptureImageFailedParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnCaptureImageSucceeParams {
        Bitmap bitmap;
        int height;

        /* renamed from: id, reason: collision with root package name */
        int f373918id;
        int width;

        OnCaptureImageSucceeParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnDefinitionInfoParams {
        String currentDefinition;
        ArrayList<String> definitionList;

        OnDefinitionInfoParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnErrorParams {
        int errorCode;
        int errorType;
        String extraInfo;
        int module;

        OnErrorParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnInfoParams {
        long arg1;
        long arg2;
        Object extra;
        int what;

        OnInfoParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class OnVideoSizeParams {
        int height;
        int width;

        OnVideoSizeParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuperPlayerListenerCallBack(ISuperPlayer iSuperPlayer, SuperPlayerListenerMgr superPlayerListenerMgr, Looper looper) {
        this.mPlayerWeakReference = new WeakReference<>(iSuperPlayer);
        this.mListenerMgrWeakReference = new WeakReference<>(superPlayerListenerMgr);
        this.mCallBackEventHandler = new CallBackEventHandler(looper);
    }

    private void handleOnAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onAudioFrameOutput(tPAudioFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCaptureImageFailed(int i3, int i16) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onCaptureImageFailed(iSuperPlayer, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onCaptureImageSucceed(iSuperPlayer, i3, i16, i17, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCompletion() {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onCompletion(iSuperPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDefinitionUpdate(String str, ArrayList<String> arrayList) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (arrayList != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onDefinitionInfoUpdate(iSuperPlayer, str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleOnError(int i3, int i16, int i17, String str) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            return superPlayerListenerMgr.onError(iSuperPlayer, i3, i16, i17, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleOnInfo(int i3, long j3, long j16, Object obj) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            return superPlayerListenerMgr.onInfo(iSuperPlayer, i3, j3, j16, obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSeekComplete() {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onSeekComplete(iSuperPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnTVideoNetInfoUpdate(TVideoNetInfo tVideoNetInfo) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (tVideoNetInfo != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onTVideoNetInfoUpdate(iSuperPlayer, tVideoNetInfo);
        }
    }

    private void handleOnVideoFrameOutput(TPVideoFrameBuffer tPVideoFrameBuffer) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onVideoFrameOutput(tPVideoFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoPrepared() {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onVideoPrepared(iSuperPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoSizeChanged(int i3, int i16) {
        ISuperPlayer iSuperPlayer = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (iSuperPlayer != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onVideoSizeChanged(iSuperPlayer, i3, i16);
        }
    }

    private synchronized void internalMessage(int i3, Object obj) {
        Message obtain = Message.obtain(this.mCallBackEventHandler, i3, obj);
        if (this.mIsBlockCallback.get()) {
            this.mMessageQueue.offer(obtain);
            return;
        }
        if (this.notifyPreparedPlayMsgAhead) {
            if (i3 == 1) {
                this.mCallBackEventHandler.sendMessageAtFrontOfQueue(obtain);
            } else if (i3 == 3) {
                int i16 = ((OnInfoParams) obj).what;
                if (i16 != 105 && i16 != 104) {
                    obtain.sendToTarget();
                }
                this.mCallBackEventHandler.sendMessageAtFrontOfQueue(obtain);
            } else {
                obtain.sendToTarget();
            }
        } else {
            obtain.sendToTarget();
        }
    }

    public ISuperPlayer getPlayer() {
        WeakReference<ISuperPlayer> weakReference = this.mPlayerWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            return this.mPlayerWeakReference.get();
        }
        return null;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener
    public void onAudioFrameOutput(TPAudioFrameBuffer tPAudioFrameBuffer) {
        handleOnAudioFrameOutput(tPAudioFrameBuffer);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
        OnCaptureImageFailedParams onCaptureImageFailedParams = new OnCaptureImageFailedParams();
        onCaptureImageFailedParams.f373917id = i3;
        onCaptureImageFailedParams.errCode = i16;
        internalMessage(7, onCaptureImageFailedParams);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        OnCaptureImageSucceeParams onCaptureImageSucceeParams = new OnCaptureImageSucceeParams();
        onCaptureImageSucceeParams.f373918id = i3;
        onCaptureImageSucceeParams.width = i16;
        onCaptureImageSucceeParams.height = i17;
        onCaptureImageSucceeParams.bitmap = bitmap;
        internalMessage(6, onCaptureImageSucceeParams);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        internalMessage(4, null);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
        OnDefinitionInfoParams onDefinitionInfoParams = new OnDefinitionInfoParams();
        onDefinitionInfoParams.currentDefinition = str;
        onDefinitionInfoParams.definitionList = arrayList;
        internalMessage(9, onDefinitionInfoParams);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        OnErrorParams onErrorParams = new OnErrorParams();
        onErrorParams.module = i3;
        onErrorParams.errorType = i16;
        onErrorParams.errorCode = i17;
        onErrorParams.extraInfo = str;
        internalMessage(2, onErrorParams);
        return true;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        OnInfoParams onInfoParams = new OnInfoParams();
        onInfoParams.what = i3;
        onInfoParams.arg1 = j3;
        onInfoParams.arg2 = j16;
        onInfoParams.extra = obj;
        internalMessage(3, onInfoParams);
        return true;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        internalMessage(5, null);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener
    public void onSubtitleData(ISuperPlayer iSuperPlayer, TPSubtitleData tPSubtitleData) {
        ISuperPlayer iSuperPlayer2 = this.mPlayerWeakReference.get();
        SuperPlayerListenerMgr superPlayerListenerMgr = this.mListenerMgrWeakReference.get();
        if (tPSubtitleData != null && superPlayerListenerMgr != null) {
            superPlayerListenerMgr.onSubtitleData(iSuperPlayer2, tPSubtitleData);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
        internalMessage(10, tVideoNetInfo);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener
    public void onVideoFrameOutput(TPVideoFrameBuffer tPVideoFrameBuffer) {
        handleOnVideoFrameOutput(tPVideoFrameBuffer);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        internalMessage(1, null);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
        OnVideoSizeParams onVideoSizeParams = new OnVideoSizeParams();
        onVideoSizeParams.width = i3;
        onVideoSizeParams.height = i16;
        internalMessage(8, onVideoSizeParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setIsBlockCallback(boolean z16) {
        this.mIsBlockCallback.set(z16);
        if (!z16 && !this.mMessageQueue.isEmpty()) {
            while (!this.mMessageQueue.isEmpty()) {
                Message poll = this.mMessageQueue.poll();
                if (poll != null) {
                    this.mCallBackEventHandler.sendMessage(poll);
                }
            }
        }
    }

    public void setNotifyPreparedPlayMsgAhead(boolean z16) {
        this.notifyPreparedPlayMsgAhead = z16;
    }
}
