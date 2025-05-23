package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 X2\u00020\u0001:\u0002XYB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u0002012\u0006\u00102\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u000bJ\u0012\u00107\u001a\u0004\u0018\u00010\u00192\u0006\u00102\u001a\u00020\u001fH\u0002J\u000e\u00108\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001fJ\u000e\u00109\u001a\u00020:2\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010;\u001a\u00020:2\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010<\u001a\u00020:2\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010=\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010>\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020@2\u0006\u00102\u001a\u00020\u001fJ\u0006\u0010A\u001a\u000201J\u0006\u0010B\u001a\u000201J\b\u0010C\u001a\u000201H\u0002J\u000e\u0010D\u001a\u0002012\u0006\u00102\u001a\u00020\u001fJ\u0006\u0010E\u001a\u000201J\u0006\u0010F\u001a\u000201J\u000e\u0010F\u001a\u0002012\u0006\u00102\u001a\u00020\u001fJ\u000e\u0010G\u001a\u0002012\u0006\u00102\u001a\u00020\u001fJ\b\u0010H\u001a\u000201H\u0002J\u0006\u0010I\u001a\u000201J\u0016\u0010J\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020@J\u0016\u0010L\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u000bJ\u0016\u0010N\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000bJ\u0018\u0010P\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001f2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0016\u0010S\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020@J\u0016\u0010U\u001a\u0002012\u0006\u00102\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020@J\u000e\u0010W\u001a\u0002012\u0006\u00102\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00190!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u00060$R\u00020\u00000!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", "", "context", "Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "isMute", "", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;Lcom/tencent/mobileqq/triton/utils/Downloader;Lcom/tencent/mobileqq/triton/utils/LogDelegate;Z)V", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "forceMuteReceiver", "Landroid/content/BroadcastReceiver;", "isForceMute", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getLogger", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mIdleQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioPlayer;", "mIsDestoryed", "mIsMute", "mIsPause", "mLock", "mMaxVolume", "", "mPlayerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "mSavedVolume", "mStateChangeHandlerMap", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler;", "sw", "musicSwitch", "getMusicSwitch", "()Z", "setMusicSwitch", "(Z)V", "totalErrorCount", "getTotalErrorCount", "()I", "setTotalErrorCount", "(I)V", "createAudioContext", "", WebAudioPlugin.AUDIO_ID, "listener", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "destroyAudioContext", "execAudioFocus", "findAudioPlayer", "getAutoplay", "getBuffered", "", "getCurPosition", "getDuration", "getLoop", "getPaused", "getStartTime", "", "handleFocusGain", "handleFocusLoss", "muteAll", InnerAudioPlugin.API_ON_AUDIO_TIME_UPDATE_REGISTER, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "pauseMusic", "playMusic", "restoreVolume", "resumeMusic", "seekTo", c.G, "setAutoplay", "autoplay", "setLoop", "loop", "setMusicPath", "musicPath", "", "setStartTime", "startTime", "setVolume", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "stopMusic", "Companion", "InnerAudioStateChangeHandler", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class AudioPlayerManager {
    private static final String ACTION_USER_MUTE = "action.qq.miniapp.audio.mute";
    private static final String KEY_USER_MUTE = "isMute";
    public static final int MAX_TOTAL_ERROR_COUNT = 10;

    @NotNull
    public static final String TAG = "[audio] AudioPlayerManager";
    private final Context context;

    @NotNull
    private final GameDataFileSystem dataFileSystem;

    @NotNull
    private final Downloader downloader;
    private final BroadcastReceiver forceMuteReceiver;
    private final AtomicBoolean isForceMute;
    private final boolean isMute;

    @Nullable
    private final LogDelegate logger;
    private final ConcurrentLinkedQueue<IAudioPlayer> mIdleQueue;
    private boolean mIsDestoryed;
    private volatile boolean mIsMute;
    private final AtomicBoolean mIsPause;
    private final Object mLock;
    private volatile int mMaxVolume;
    private final ConcurrentHashMap<Integer, IAudioPlayer> mPlayerMap;
    private volatile int mSavedVolume;
    private final ConcurrentHashMap<Integer, InnerAudioStateChangeHandler> mStateChangeHandlerMap;
    private volatile int totalErrorCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\tJ\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\tH\u0002J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010%\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "manager", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", WebAudioPlugin.AUDIO_ID, "", "callback", "(Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;ILcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;)V", "callPlay", "", "localPath", "", "managerReference", "Ljava/lang/ref/WeakReference;", "maxRetryCount", "rawPath", "retryCount", "src", "downloadAndPlayAudio", "", "hasCallPlay", "isFileExists", "path", "onCanPlay", "onEnded", "onError", "errCode", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "onSeeked", "onSeeking", DKHippyEvent.EVENT_STOP, "onTimeUpdate", "onWaiting", "prepareAndPlayLocalAudio", "needPlay", "setCallPlay", "setPath", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public final class InnerAudioStateChangeHandler implements IAudioStateChangeListener {
        private int audioId;
        private volatile boolean callPlay;
        private final IAudioStateChangeListener callback;
        private volatile String localPath;
        private WeakReference<AudioPlayerManager> managerReference;
        private final int maxRetryCount;
        private volatile String rawPath;
        private volatile int retryCount;
        private String src;
        final /* synthetic */ AudioPlayerManager this$0;

        public InnerAudioStateChangeHandler(@NotNull AudioPlayerManager audioPlayerManager, AudioPlayerManager manager, @Nullable int i3, IAudioStateChangeListener iAudioStateChangeListener) {
            Intrinsics.checkParameterIsNotNull(manager, "manager");
            this.this$0 = audioPlayerManager;
            this.audioId = i3;
            this.callback = iAudioStateChangeListener;
            this.maxRetryCount = 1;
            this.managerReference = new WeakReference<>(manager);
            this.retryCount = 0;
        }

        private final void downloadAndPlayAudio() {
            String str = this.rawPath;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TemporaryFile newTempFile$default = GameDataFileSystem.DefaultImpls.newTempFile$default(this.this$0.getDataFileSystem(), str, null, 2, null);
            Downloader downloader = this.this$0.getDownloader();
            if (str == null) {
                Intrinsics.throwNpe();
            }
            downloader.download(str, newTempFile$default.getFile(), new AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1(this, newTempFile$default, str));
            LogDelegate logger = this.this$0.getLogger();
            if (logger != null) {
                LogDelegate.DefaultImpls.printLog$default(logger, LogDelegate.Level.INFO, AudioPlayerManager.TAG, "downloadAndPlayAudio rawPath:" + str, null, 8, null);
            }
        }

        private final boolean isFileExists(String path) {
            if (!TextUtils.isEmpty(path) && new File(path).exists()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void prepareAndPlayLocalAudio(boolean needPlay) {
            AudioPlayerManager audioPlayerManager;
            if (this.localPath != null) {
                GameDataFileSystem dataFileSystem = this.this$0.getDataFileSystem();
                String str = this.localPath;
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                if (dataFileSystem.getFile(str).exists()) {
                    WeakReference<AudioPlayerManager> weakReference = this.managerReference;
                    if (weakReference != null) {
                        audioPlayerManager = weakReference.get();
                    } else {
                        audioPlayerManager = null;
                    }
                    LogDelegate logger = this.this$0.getLogger();
                    if (logger != null) {
                        LogDelegate.DefaultImpls.printLog$default(logger, LogDelegate.Level.INFO, AudioPlayerManager.TAG, "audioId:" + this.audioId + ", playLocalAudio localPath:" + this.localPath, null, 8, null);
                    }
                    if (audioPlayerManager != null) {
                        audioPlayerManager.setMusicPath(this.audioId, this.localPath);
                    }
                    if (needPlay && audioPlayerManager != null) {
                        audioPlayerManager.playMusic(this.audioId);
                        return;
                    }
                    return;
                }
            }
            LogDelegate logger2 = this.this$0.getLogger();
            if (logger2 != null) {
                LogDelegate.DefaultImpls.printLog$default(logger2, LogDelegate.Level.ERROR, AudioPlayerManager.TAG, "playLocalAudio localPath:" + this.localPath + " not exists", null, 8, null);
            }
        }

        /* renamed from: hasCallPlay, reason: from getter */
        public final boolean getCallPlay() {
            return this.callPlay;
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onCanPlay() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onCanPlay();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onEnded() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onEnded();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onError(int errCode) {
            AudioPlayerManager audioPlayerManager;
            int i3;
            WeakReference<AudioPlayerManager> weakReference = this.managerReference;
            if (weakReference != null) {
                audioPlayerManager = weakReference.get();
            } else {
                audioPlayerManager = null;
            }
            if (audioPlayerManager != null) {
                i3 = audioPlayerManager.getTotalErrorCount();
            } else {
                i3 = 10;
            }
            if (URLUtil.isNetworkUrl(this.rawPath) && this.retryCount < this.maxRetryCount && i3 < 10) {
                LogDelegate logger = this.this$0.getLogger();
                if (logger != null) {
                    LogDelegate.DefaultImpls.printLog$default(logger, LogDelegate.Level.DEBUG, AudioPlayerManager.TAG, "network error, errCode=" + errCode, null, 8, null);
                }
                this.retryCount++;
                if (audioPlayerManager != null) {
                    audioPlayerManager.setTotalErrorCount(audioPlayerManager.getTotalErrorCount() + 1);
                }
                if (isFileExists(this.localPath)) {
                    prepareAndPlayLocalAudio(getCallPlay());
                    return;
                } else {
                    downloadAndPlayAudio();
                    return;
                }
            }
            LogDelegate logger2 = this.this$0.getLogger();
            if (logger2 != null) {
                LogDelegate.DefaultImpls.printLog$default(logger2, LogDelegate.Level.ERROR, AudioPlayerManager.TAG, toString() + " onError retryCount:" + this.retryCount + ", audioId:" + this.audioId + " totalErrorCount:" + i3, null, 8, null);
            }
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onError(errCode);
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onPause() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onPause();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onPlay() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onPlay();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onSeeked() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onSeeked();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onSeeking() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onSeeking();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onStop() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onStop();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onTimeUpdate() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onTimeUpdate();
            }
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onWaiting() {
            IAudioStateChangeListener iAudioStateChangeListener = this.callback;
            if (iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onWaiting();
            }
        }

        public final void setCallPlay(boolean callPlay) {
            this.callPlay = callPlay;
        }

        public final void setPath(@Nullable String src, @Nullable String path) {
            this.src = src;
            this.rawPath = path;
        }
    }

    public AudioPlayerManager(@NotNull Context context, @NotNull GameDataFileSystem dataFileSystem, @NotNull Downloader downloader, @Nullable LogDelegate logDelegate, boolean z16) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dataFileSystem, "dataFileSystem");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        this.context = context;
        this.dataFileSystem = dataFileSystem;
        this.downloader = downloader;
        this.logger = logDelegate;
        this.isMute = z16;
        this.mLock = new Object();
        this.mIsPause = new AtomicBoolean(false);
        this.mPlayerMap = new ConcurrentHashMap<>();
        this.mStateChangeHandlerMap = new ConcurrentHashMap<>();
        this.mIdleQueue = new ConcurrentLinkedQueue<>();
        this.mSavedVolume = 1;
        this.mMaxVolume = 1;
        AtomicBoolean atomicBoolean = new AtomicBoolean(z16);
        this.isForceMute = atomicBoolean;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager$forceMuteReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context2, @NotNull Intent intent) {
                AtomicBoolean atomicBoolean2;
                AtomicBoolean atomicBoolean3;
                boolean z17;
                Intrinsics.checkParameterIsNotNull(context2, "context");
                Intrinsics.checkParameterIsNotNull(intent, "intent");
                atomicBoolean2 = AudioPlayerManager.this.isForceMute;
                boolean booleanExtra = intent.getBooleanExtra("isMute", atomicBoolean2.get());
                atomicBoolean3 = AudioPlayerManager.this.isForceMute;
                atomicBoolean3.set(booleanExtra);
                if (booleanExtra) {
                    AudioPlayerManager.this.muteAll();
                    return;
                }
                z17 = AudioPlayerManager.this.mIsMute;
                if (!z17) {
                    AudioPlayerManager.this.restoreVolume();
                }
            }
        };
        this.forceMuteReceiver = broadcastReceiver;
        if (context instanceof Activity) {
            atomicBoolean.set(((Activity) context).getIntent().getBooleanExtra("isMute", false));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.qq.miniapp.audio.mute");
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private final IAudioPlayer findAudioPlayer(int audioId) {
        return this.mPlayerMap.get(Integer.valueOf(audioId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void muteAll() {
        try {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "muteAll", null, 8, null);
            }
            for (IAudioPlayer player : this.mPlayerMap.values()) {
                Intrinsics.checkExpressionValueIsNotNull(player, "player");
                player.setVolume(0.0f);
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate2 = this.logger;
            if (logDelegate2 != null) {
                logDelegate2.printLog(LogDelegate.Level.ERROR, TAG, "catching exception :muteAll error:", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreVolume() {
        if (!this.mIsMute && !this.isForceMute.get()) {
            try {
                float f16 = 1.0f;
                if (this.mMaxVolume > 0) {
                    f16 = (this.mSavedVolume * 1.0f) / this.mMaxVolume;
                }
                LogDelegate logDelegate = this.logger;
                if (logDelegate != null) {
                    LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "restoreVolume volume=" + f16, null, 8, null);
                }
                for (IAudioPlayer player : this.mPlayerMap.values()) {
                    try {
                        Intrinsics.checkExpressionValueIsNotNull(player, "player");
                        player.setVolume(f16);
                    } catch (Throwable th5) {
                        LogDelegate logDelegate2 = this.logger;
                        if (logDelegate2 != null) {
                            logDelegate2.printLog(LogDelegate.Level.ERROR, TAG, "mute error:", th5);
                        }
                    }
                }
            } catch (Throwable th6) {
                LogDelegate logDelegate3 = this.logger;
                if (logDelegate3 != null) {
                    logDelegate3.printLog(LogDelegate.Level.ERROR, TAG, "catching exception :pauseMusic error:", th6);
                }
            }
        }
    }

    public final void createAudioContext(int audioId, @NotNull IAudioStateChangeListener listener) {
        float f16;
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        IAudioPlayer poll = this.mIdleQueue.poll();
        InnerAudioStateChangeHandler innerAudioStateChangeHandler = new InnerAudioStateChangeHandler(this, this, audioId, listener);
        this.mStateChangeHandlerMap.put(Integer.valueOf(audioId), innerAudioStateChangeHandler);
        if (!this.mIsMute && !this.isForceMute.get()) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        if (poll == null) {
            InnerAudioPlayer innerAudioPlayer = new InnerAudioPlayer(this.logger, TritonAudioThreadPool.getInnerAudioThreadPool(), f16);
            innerAudioPlayer.setAudioId(audioId);
            innerAudioPlayer.setStateChangeListener(innerAudioStateChangeHandler);
            this.mPlayerMap.put(Integer.valueOf(audioId), innerAudioPlayer);
            return;
        }
        poll.release();
        poll.setVolume(f16);
        poll.setAudioId(audioId);
        poll.setStateChangeListener(innerAudioStateChangeHandler);
        this.mPlayerMap.put(Integer.valueOf(audioId), poll);
    }

    public final void destroyAudioContext(int audioId) {
        IAudioPlayer remove = this.mPlayerMap.remove(Integer.valueOf(audioId));
        if (remove != null) {
            remove.release();
            this.mIdleQueue.add(remove);
        }
    }

    public final boolean execAudioFocus() {
        if (!this.mIsMute) {
            return false;
        }
        this.mIsMute = false;
        restoreVolume();
        return true;
    }

    public final boolean getAutoplay(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            return findAudioPlayer.getMAutoPlay();
        }
        return false;
    }

    public final double getBuffered(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            return findAudioPlayer.getMBufferedTime();
        }
        return 0.0d;
    }

    public final double getCurPosition(int audioId) {
        if (findAudioPlayer(audioId) != null) {
            return r3.getCurrentPosition();
        }
        return 0.0d;
    }

    @NotNull
    public final GameDataFileSystem getDataFileSystem() {
        return this.dataFileSystem;
    }

    @NotNull
    public final Downloader getDownloader() {
        return this.downloader;
    }

    public final double getDuration(int audioId) {
        if (findAudioPlayer(audioId) != null) {
            return r3.getDuration();
        }
        return 0.0d;
    }

    @Nullable
    public final LogDelegate getLogger() {
        return this.logger;
    }

    public final boolean getLoop(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            return findAudioPlayer.getMLoop();
        }
        return false;
    }

    public final boolean getMusicSwitch() {
        return false;
    }

    public final boolean getPaused(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null && findAudioPlayer.getMPaused()) {
            return true;
        }
        return false;
    }

    public final float getStartTime(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            return findAudioPlayer.getStartTime();
        }
        return 0.0f;
    }

    public final int getTotalErrorCount() {
        return this.totalErrorCount;
    }

    public final void handleFocusGain() {
        if (this.mIsMute) {
            restoreVolume();
            this.mIsMute = false;
        }
    }

    public final void handleFocusLoss() {
        Object systemService = this.context.getSystemService("audio");
        if (systemService != null) {
            AudioManager audioManager = (AudioManager) systemService;
            this.mSavedVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
            this.mMaxVolume = audioManager.getStreamMaxVolume(3);
            this.mIsMute = true;
            muteAll();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
    }

    public final void onAudioTimeUpdateRegister(int audioId) {
        IAudioPlayer iAudioPlayer = this.mPlayerMap.get(Integer.valueOf(audioId));
        if (iAudioPlayer != null) {
            iAudioPlayer.onAudioTimeUpdateRegister();
        }
    }

    public final void onDestroy() {
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "[onDestroy] all size=" + this.mPlayerMap.size(), null, 8, null);
        }
        if (!this.mIsPause.get()) {
            this.mIsPause.set(false);
        }
        synchronized (this.mLock) {
            this.mIsDestoryed = true;
            Iterator<IAudioPlayer> it = this.mPlayerMap.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mPlayerMap.clear();
            this.mIdleQueue.clear();
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.context.unregisterReceiver(this.forceMuteReceiver);
        } catch (Throwable th5) {
            LogDelegate logDelegate2 = this.logger;
            if (logDelegate2 != null) {
                logDelegate2.printLog(LogDelegate.Level.WARN, TAG, "unregister force mute receiver throw t:", th5);
            }
        }
    }

    public final void pauseMusic(int audioId) {
        try {
            IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
            if (findAudioPlayer != null) {
                findAudioPlayer.setNeedResume(false);
                findAudioPlayer.pause();
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "pauseMusic fail!", th5);
            }
        }
    }

    public final void playMusic(int audioId) {
        InnerAudioStateChangeHandler innerAudioStateChangeHandler = this.mStateChangeHandlerMap.get(Integer.valueOf(audioId));
        if (innerAudioStateChangeHandler != null) {
            innerAudioStateChangeHandler.setCallPlay(true);
        }
        IAudioPlayer iAudioPlayer = this.mPlayerMap.get(Integer.valueOf(audioId));
        if (iAudioPlayer != null) {
            iAudioPlayer.play();
        }
    }

    public final void resumeMusic() {
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "resumeMusic all", null, 8, null);
        }
        this.mIsPause.set(false);
        for (IAudioPlayer player : this.mPlayerMap.values()) {
            try {
                Intrinsics.checkExpressionValueIsNotNull(player, "player");
                if (player.getMNeedToResume()) {
                    player.resume();
                }
            } catch (Throwable th5) {
                LogDelegate logDelegate2 = this.logger;
                if (logDelegate2 != null) {
                    logDelegate2.printLog(LogDelegate.Level.ERROR, TAG, "resumeMusic error:", th5);
                }
            }
        }
        this.totalErrorCount = 0;
    }

    public final void seekTo(int audioId, float pos) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            findAudioPlayer.seekTo(pos);
        }
    }

    public final void setAutoplay(int audioId, boolean autoplay) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            findAudioPlayer.setAutoPlay(autoplay);
        }
    }

    public final void setLoop(int audioId, boolean loop) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            findAudioPlayer.setLoop(loop);
        }
    }

    public final int setMusicPath(int audioId, @Nullable String musicPath) {
        String str;
        String str2;
        try {
            if (URLUtil.isNetworkUrl(musicPath)) {
                str = musicPath;
            } else {
                str = null;
                if (!TextUtils.isEmpty(musicPath)) {
                    GameDataFileSystem gameDataFileSystem = this.dataFileSystem;
                    if (musicPath == null) {
                        Intrinsics.throwNpe();
                    }
                    str2 = gameDataFileSystem.getFile(musicPath).getAbsolutePath();
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str2);
                    if (file.exists()) {
                        str = file.getPath();
                    }
                }
            }
            InnerAudioStateChangeHandler innerAudioStateChangeHandler = this.mStateChangeHandlerMap.get(Integer.valueOf(audioId));
            if (innerAudioStateChangeHandler != null) {
                innerAudioStateChangeHandler.setPath(musicPath, str);
            }
            IAudioPlayer iAudioPlayer = this.mPlayerMap.get(Integer.valueOf(audioId));
            if (iAudioPlayer != null) {
                iAudioPlayer.setAudioPath(str);
                return 0;
            }
            return 0;
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "setMusicPath " + musicPath + " error ", th5);
                return -1;
            }
            return -1;
        }
    }

    public final void setStartTime(int audioId, float startTime) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            findAudioPlayer.setStartTime(startTime);
        }
    }

    public final void setTotalErrorCount(int i3) {
        this.totalErrorCount = i3;
    }

    public final void setVolume(int audioId, float volume) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            if (this.mIsMute || this.isForceMute.get()) {
                volume = 0.0f;
            }
            findAudioPlayer.setVolume(volume);
        }
    }

    public final void stopMusic(int audioId) {
        IAudioPlayer findAudioPlayer = findAudioPlayer(audioId);
        if (findAudioPlayer != null) {
            findAudioPlayer.stop();
        }
    }

    public final void pauseMusic() {
        try {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "pauseMusic all", null, 8, null);
            }
            this.mIsPause.set(true);
            for (IAudioPlayer player : this.mPlayerMap.values()) {
                try {
                    Intrinsics.checkExpressionValueIsNotNull(player, "player");
                    if (player.isPlaying()) {
                        player.setNeedResume(true);
                    }
                    player.pause();
                } catch (Throwable th5) {
                    LogDelegate logDelegate2 = this.logger;
                    if (logDelegate2 != null) {
                        logDelegate2.printLog(LogDelegate.Level.ERROR, TAG, "pause error:", th5);
                    }
                }
            }
        } catch (Throwable th6) {
            LogDelegate logDelegate3 = this.logger;
            if (logDelegate3 != null) {
                logDelegate3.printLog(LogDelegate.Level.ERROR, TAG, "catching exception :pauseMusic error:", th6);
            }
        }
    }

    public final void setMusicSwitch(boolean z16) {
    }
}
