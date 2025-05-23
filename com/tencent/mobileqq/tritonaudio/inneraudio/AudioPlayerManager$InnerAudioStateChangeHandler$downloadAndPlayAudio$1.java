package com.tencent.mobileqq.tritonaudio.inneraudio;

import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "onFail", "", "errorMsg", "", "onProgress", "total", "", "current", "onSuccess", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1 implements Downloader.Listener {
    final /* synthetic */ String $rawPathTemp;
    final /* synthetic */ TemporaryFile $temp;
    final /* synthetic */ AudioPlayerManager.InnerAudioStateChangeHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1(AudioPlayerManager.InnerAudioStateChangeHandler innerAudioStateChangeHandler, TemporaryFile temporaryFile, String str) {
        this.this$0 = innerAudioStateChangeHandler;
        this.$temp = temporaryFile;
        this.$rawPathTemp = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        r0 = r2.this$0.callback;
     */
    @Override // com.tencent.mobileqq.triton.utils.Downloader.Listener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFail(@NotNull String errorMsg) {
        Object obj;
        boolean z16;
        IAudioStateChangeListener iAudioStateChangeListener;
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        obj = this.this$0.this$0.mLock;
        synchronized (obj) {
            z16 = this.this$0.this$0.mIsDestoryed;
            if (!z16 && iAudioStateChangeListener != null) {
                iAudioStateChangeListener.onError(10002);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.triton.utils.Downloader.Listener
    public void onSuccess() {
        Object obj;
        boolean z16;
        String str;
        obj = this.this$0.this$0.mLock;
        synchronized (obj) {
            z16 = this.this$0.this$0.mIsDestoryed;
            if (!z16) {
                this.this$0.localPath = this.$temp.getPathInGame();
                LogDelegate logger = this.this$0.this$0.getLogger();
                if (logger != null) {
                    LogDelegate.Level level = LogDelegate.Level.INFO;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("download rawPath:");
                    sb5.append(this.$rawPathTemp);
                    sb5.append(" success, localPath:");
                    str = this.this$0.localPath;
                    sb5.append(str);
                    LogDelegate.DefaultImpls.printLog$default(logger, level, AudioPlayerManager.TAG, sb5.toString(), null, 8, null);
                }
                TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1$onSuccess$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioPlayerManager.InnerAudioStateChangeHandler innerAudioStateChangeHandler = AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1.this.this$0;
                        innerAudioStateChangeHandler.prepareAndPlayLocalAudio(innerAudioStateChangeHandler.getCallPlay());
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.triton.utils.Downloader.Listener
    public void onProgress(long total, long current) {
    }
}
