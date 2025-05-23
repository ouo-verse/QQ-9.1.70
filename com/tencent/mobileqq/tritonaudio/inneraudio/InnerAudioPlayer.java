package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaTimestamp;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b0*\u00010\u0018\u0000 a2\u00020\u0001:\u0002abB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u00020\u0010H\u0016J\n\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\u0017H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\fH\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016J\u0012\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020\fH\u0016J\b\u0010D\u001a\u00020\fH\u0016J\b\u0010E\u001a\u000203H\u0016J\b\u0010F\u001a\u000203H\u0016J\b\u0010G\u001a\u000203H\u0016J\n\u0010H\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010I\u001a\u000203H\u0016J\u0012\u0010J\u001a\u0002032\b\b\u0002\u0010K\u001a\u00020\fH\u0002J\b\u0010L\u001a\u000203H\u0016J\u0010\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020\u0007H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020\u0010H\u0016J\u0012\u0010Q\u001a\u0002032\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\fH\u0016J\u0010\u0010T\u001a\u0002032\u0006\u0010U\u001a\u00020\fH\u0016J\u0010\u0010V\u001a\u0002032\u0006\u0010W\u001a\u00020\fH\u0016J\u0010\u0010X\u001a\u0002032\u0006\u0010Y\u001a\u00020\u0007H\u0016J\u0012\u0010Z\u001a\u0002032\b\u0010[\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\\\u001a\u0002032\u0006\u0010]\u001a\u00020\u0007H\u0016J\b\u0010^\u001a\u000203H\u0002J\b\u0010_\u001a\u000203H\u0016J\b\u0010`\u001a\u000203H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010%\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010'0' (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010'0'\u0018\u00010)0&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u00101R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioPlayer;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", SemanticAttributes.FaasTriggerValues.TIMER, "Ljava/util/concurrent/ScheduledExecutorService;", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "(Lcom/tencent/mobileqq/triton/utils/LogDelegate;Ljava/util/concurrent/ScheduledExecutorService;F)V", "hadRegisterTimeUpdate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPrepared", "", "()Z", "isScheduleTimeUpdate", "mAudioId", "", "mAudioPath", "", "mAudioStateChangeListener", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "mAutoPlay", "mBufferedTime", "", "mCacheDuration", "mIsPrepared", "mLoop", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mNeedToResume", "mOnCompletionListener", "Landroid/media/MediaPlayer$OnCompletionListener;", "mOnPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "mOnSeekCompleteListener", "Landroid/media/MediaPlayer$OnSeekCompleteListener;", "mPaused", "mPendingOperateTasks", "", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "", "mStartTime", "onBufferingUpdateListener", "Landroid/media/MediaPlayer$OnBufferingUpdateListener;", "onErrorListener", "Landroid/media/MediaPlayer$OnErrorListener;", "scheduleTask", "com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer$scheduleTask$1", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer$scheduleTask$1;", "addOperateTask", "", "runnable", "execOperateTasks", "getAudioId", "getAudioPath", "getAutoPlay", "getBufferedTime", "getCurrentPosition", "getDuration", "getLoop", "getStartTime", "getStateChangeListener", "getVolume", "isAudioFileValid", "path", "isNeedResume", "isPaused", "isPlaying", InnerAudioPlugin.API_ON_AUDIO_TIME_UPDATE_REGISTER, "pause", "play", "preparePlayer", "release", "reset", "isServerDie", "resume", "seekTo", c.G, "setAudioId", WebAudioPlugin.AUDIO_ID, "setAudioPath", "setAutoPlay", "autoplay", "setLoop", "loop", "setNeedResume", "needResume", "setStartTime", "startTime", "setStateChangeListener", "listener", "setVolume", "vol", "startTimeUpdateCallback", "stop", "stopTimeUpdateCallback", "Companion", "ResetTask", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class InnerAudioPlayer implements IAudioPlayer {
    private static final int AUDIO_DURATION_THREADHOLD = 500;
    private static final int TIME_UPDATE_FIXED_PERIOD = 250;
    private final AtomicBoolean hadRegisterTimeUpdate;
    private AtomicBoolean isScheduleTimeUpdate;
    private final LogDelegate logger;
    private int mAudioId;
    private String mAudioPath;
    private IAudioStateChangeListener mAudioStateChangeListener;
    private boolean mAutoPlay;
    private double mBufferedTime;
    private volatile int mCacheDuration;
    private volatile boolean mIsPrepared;
    private boolean mLoop;
    private MediaPlayer mMediaPlayer;
    private boolean mNeedToResume;
    private final MediaPlayer.OnCompletionListener mOnCompletionListener;
    private final MediaPlayer.OnPreparedListener mOnPreparedListener;
    private final MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private volatile boolean mPaused;
    private final List<Runnable> mPendingOperateTasks;
    private int mStartTime;
    private final MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    private final MediaPlayer.OnErrorListener onErrorListener;
    private final InnerAudioPlayer$scheduleTask$1 scheduleTask;
    private final ScheduledExecutorService timer;
    private float volume;
    private static final String TAG = TAG;
    private static final String TAG = TAG;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer$ResetTask;", "Ljava/lang/Runnable;", "targetId", "", "targetPath", "", "(Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer;ILjava/lang/String;)V", TencentLocation.RUN_MODE, "", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public final class ResetTask implements Runnable {
        private final int targetId;
        private final String targetPath;

        public ResetTask(int i3, @Nullable String str) {
            this.targetId = i3;
            this.targetPath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InnerAudioPlayer.this.getMAudioId() == this.targetId && InnerAudioPlayer.this.getMAudioPath() != null && Intrinsics.areEqual(InnerAudioPlayer.this.getMAudioPath(), this.targetPath)) {
                InnerAudioPlayer.reset$default(InnerAudioPlayer.this, false, 1, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$scheduleTask$1] */
    public InnerAudioPlayer(@Nullable LogDelegate logDelegate, @NotNull ScheduledExecutorService timer, float f16) {
        Intrinsics.checkParameterIsNotNull(timer, "timer");
        this.logger = logDelegate;
        this.timer = timer;
        this.volume = f16;
        this.mPaused = true;
        this.isScheduleTimeUpdate = new AtomicBoolean(true);
        this.hadRegisterTimeUpdate = new AtomicBoolean(false);
        this.onBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$onBufferingUpdateListener$1
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i3) {
                InnerAudioPlayer.this.mBufferedTime = InnerAudioPlayer.this.getDuration() * i3;
            }
        };
        this.mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$mOnCompletionListener$1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                InnerAudioPlayer innerAudioPlayer = InnerAudioPlayer.this;
                InnerAudioPlayer.ResetTask resetTask = new InnerAudioPlayer.ResetTask(innerAudioPlayer.getMAudioId(), InnerAudioPlayer.this.getMAudioPath());
                if (InnerAudioPlayer.this.getDuration() < 500) {
                    TritonAudioThreadPool.getAudioThreadPool().schedule(resetTask, InnerAudioPlayer.this.getDuration() * 2, TimeUnit.MILLISECONDS);
                } else {
                    TritonAudioThreadPool.getAudioThreadPool().execute(resetTask);
                }
                IAudioStateChangeListener mAudioStateChangeListener = InnerAudioPlayer.this.getMAudioStateChangeListener();
                if (mAudioStateChangeListener != null) {
                    mAudioStateChangeListener.onEnded();
                }
            }
        };
        this.mOnSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$mOnSeekCompleteListener$1
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                IAudioStateChangeListener mAudioStateChangeListener = InnerAudioPlayer.this.getMAudioStateChangeListener();
                if (mAudioStateChangeListener != null) {
                    mAudioStateChangeListener.onSeeked();
                }
            }
        };
        this.onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$onErrorListener$1
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, final int i3, int i16) {
                LogDelegate logDelegate2;
                String str;
                logDelegate2 = InnerAudioPlayer.this.logger;
                if (logDelegate2 != null) {
                    LogDelegate.Level level = LogDelegate.Level.ERROR;
                    str = InnerAudioPlayer.TAG;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("onError audioId=%d path=%s errCode=%d extra=%d", Arrays.copyOf(new Object[]{Integer.valueOf(InnerAudioPlayer.this.getMAudioId()), InnerAudioPlayer.this.getMAudioPath(), Integer.valueOf(i3), Integer.valueOf(i16)}, 4));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    LogDelegate.DefaultImpls.printLog$default(logDelegate2, level, str, format, null, 8, null);
                }
                IAudioStateChangeListener mAudioStateChangeListener = InnerAudioPlayer.this.getMAudioStateChangeListener();
                if (mAudioStateChangeListener != null) {
                    mAudioStateChangeListener.onError(i3);
                }
                TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$onErrorListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z16;
                        InnerAudioPlayer innerAudioPlayer = InnerAudioPlayer.this;
                        if (i3 == 100) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        innerAudioPlayer.reset(z16);
                    }
                });
                if (i3 == 100) {
                    MediaPlayerManager.getInstance().releaseAll();
                }
                return true;
            }
        };
        this.mOnPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$mOnPreparedListener$1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                LogDelegate logDelegate2;
                String str;
                try {
                    InnerAudioPlayer.this.mIsPrepared = true;
                    if (!URLUtil.isNetworkUrl(InnerAudioPlayer.this.getMAudioPath())) {
                        InnerAudioPlayer.this.mBufferedTime = r6.getDuration();
                    }
                    InnerAudioPlayer.this.execOperateTasks();
                    if (InnerAudioPlayer.this.getMAutoPlay()) {
                        InnerAudioPlayer.this.play();
                    }
                } catch (Throwable th5) {
                    logDelegate2 = InnerAudioPlayer.this.logger;
                    if (logDelegate2 != null) {
                        LogDelegate.Level level = LogDelegate.Level.ERROR;
                        str = InnerAudioPlayer.TAG;
                        logDelegate2.printLog(level, str, "onPrepared error. audioId=" + InnerAudioPlayer.this.getMAudioId() + " path=" + InnerAudioPlayer.this.getMAudioPath(), th5);
                    }
                }
            }
        };
        this.mPendingOperateTasks = Collections.synchronizedList(new ArrayList());
        this.scheduleTask = new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$scheduleTask$1
            @Override // java.lang.Runnable
            public void run() {
                AtomicBoolean atomicBoolean;
                ScheduledExecutorService scheduledExecutorService;
                if (InnerAudioPlayer.this.getMAudioStateChangeListener() != null && !InnerAudioPlayer.this.getMPaused()) {
                    IAudioStateChangeListener mAudioStateChangeListener = InnerAudioPlayer.this.getMAudioStateChangeListener();
                    if (mAudioStateChangeListener == null) {
                        Intrinsics.throwNpe();
                    }
                    mAudioStateChangeListener.onTimeUpdate();
                }
                atomicBoolean = InnerAudioPlayer.this.isScheduleTimeUpdate;
                if (atomicBoolean.get()) {
                    scheduledExecutorService = InnerAudioPlayer.this.timer;
                    scheduledExecutorService.schedule(this, 250, TimeUnit.MILLISECONDS);
                }
            }
        };
    }

    private final void addOperateTask(Runnable runnable) {
        this.mPendingOperateTasks.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execOperateTasks() {
        if (this.mPendingOperateTasks.size() > 0) {
            for (Runnable runnable : this.mPendingOperateTasks) {
                if (runnable != null) {
                    runnable.run();
                }
            }
            this.mPendingOperateTasks.clear();
        }
    }

    private final boolean isAudioFileValid(String path) {
        boolean z16;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    private final boolean isPrepared() {
        if (this.mMediaPlayer != null && this.mIsPrepared) {
            return true;
        }
        return false;
    }

    private final MediaPlayer preparePlayer() {
        MediaPlayer dequeuePlayer = MediaPlayerManager.getInstance().dequeuePlayer(this.logger);
        if (dequeuePlayer != null) {
            dequeuePlayer.setOnErrorListener(this.onErrorListener);
            dequeuePlayer.setOnCompletionListener(this.mOnCompletionListener);
            dequeuePlayer.setOnPreparedListener(this.mOnPreparedListener);
            dequeuePlayer.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
            dequeuePlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            if (Build.VERSION.SDK_INT >= 28) {
                dequeuePlayer.setOnMediaTimeDiscontinuityListener(new MediaPlayer.OnMediaTimeDiscontinuityListener() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$preparePlayer$1
                    @Override // android.media.MediaPlayer.OnMediaTimeDiscontinuityListener
                    public final void onMediaTimeDiscontinuity(@NotNull MediaPlayer mediaPlayer, @NotNull MediaTimestamp mediaTimestamp) {
                        IAudioStateChangeListener mAudioStateChangeListener;
                        Intrinsics.checkParameterIsNotNull(mediaPlayer, "<anonymous parameter 0>");
                        Intrinsics.checkParameterIsNotNull(mediaTimestamp, "<anonymous parameter 1>");
                        if (!InnerAudioPlayer.this.getMPaused() && (mAudioStateChangeListener = InnerAudioPlayer.this.getMAudioStateChangeListener()) != null) {
                            mAudioStateChangeListener.onWaiting();
                        }
                    }
                });
            }
        }
        return dequeuePlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void reset(boolean isServerDie) {
        stopTimeUpdateCallback();
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (isServerDie) {
                    mediaPlayer.release();
                } else {
                    mediaPlayer.setOnErrorListener(null);
                    mediaPlayer.setOnCompletionListener(null);
                    mediaPlayer.setOnPreparedListener(null);
                    mediaPlayer.setOnBufferingUpdateListener(null);
                    mediaPlayer.setOnSeekCompleteListener(null);
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaPlayer.clearOnMediaTimeDiscontinuityListener();
                    }
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.reset();
                    MediaPlayerManager.getInstance().enqueuePlayer(mediaPlayer);
                }
            }
            this.mMediaPlayer = null;
            this.mIsPrepared = false;
            this.mPaused = true;
        } catch (Throwable th5) {
            try {
                LogDelegate logDelegate = this.logger;
                if (logDelegate != null) {
                    logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "reset error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
                }
                this.mMediaPlayer = null;
                this.mIsPrepared = false;
                this.mPaused = true;
            } catch (Throwable th6) {
                this.mMediaPlayer = null;
                this.mIsPrepared = false;
                this.mPaused = true;
                this.mCacheDuration = 0;
                throw th6;
            }
        }
        this.mCacheDuration = 0;
    }

    static /* synthetic */ void reset$default(InnerAudioPlayer innerAudioPlayer, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        innerAudioPlayer.reset(z16);
    }

    private final void startTimeUpdateCallback() {
        this.isScheduleTimeUpdate.set(true);
        this.timer.schedule(this.scheduleTask, 250, TimeUnit.MILLISECONDS);
    }

    private final void stopTimeUpdateCallback() {
        this.isScheduleTimeUpdate.set(false);
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: getAudioId, reason: from getter */
    public int getMAudioId() {
        return this.mAudioId;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    @Nullable
    /* renamed from: getAudioPath, reason: from getter */
    public String getMAudioPath() {
        return this.mAudioPath;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: getAutoPlay, reason: from getter */
    public boolean getMAutoPlay() {
        return this.mAutoPlay;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: getBufferedTime, reason: from getter */
    public double getMBufferedTime() {
        return this.mBufferedTime;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public int getCurrentPosition() {
        if (isPrepared()) {
            try {
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                if (mediaPlayer == null) {
                    return 0;
                }
                return mediaPlayer.getCurrentPosition();
            } catch (Throwable th5) {
                LogDelegate logDelegate = this.logger;
                if (logDelegate != null) {
                    logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "getCurrentPosition error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public int getDuration() {
        if (this.mCacheDuration > 0) {
            return this.mCacheDuration;
        }
        if (isPrepared()) {
            try {
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                if (mediaPlayer != null) {
                    if (mediaPlayer == null) {
                        Intrinsics.throwNpe();
                    }
                    this.mCacheDuration = mediaPlayer.getDuration();
                }
            } catch (Throwable th5) {
                LogDelegate logDelegate = this.logger;
                if (logDelegate != null) {
                    logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "getDuration error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
                }
            }
        }
        if (this.mCacheDuration < 0) {
            this.mCacheDuration = 0;
        }
        return this.mCacheDuration;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: getLoop, reason: from getter */
    public boolean getMLoop() {
        return this.mLoop;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public float getStartTime() {
        return this.mStartTime;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    @Nullable
    /* renamed from: getStateChangeListener, reason: from getter */
    public IAudioStateChangeListener getMAudioStateChangeListener() {
        return this.mAudioStateChangeListener;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public float getVolume() {
        return this.volume;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: isNeedResume, reason: from getter */
    public boolean getMNeedToResume() {
        return this.mNeedToResume;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /* renamed from: isPaused, reason: from getter */
    public boolean getMPaused() {
        return this.mPaused;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public boolean isPlaying() {
        boolean z16;
        if (!isPrepared()) {
            return false;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            z16 = mediaPlayer.isPlaying();
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void onAudioTimeUpdateRegister() {
        this.hadRegisterTimeUpdate.set(true);
        if (isPlaying()) {
            startTimeUpdateCallback();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void pause() {
        if (this.mMediaPlayer == null) {
            return;
        }
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$pause$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.pause();
                }
            });
            return;
        }
        try {
            this.mPaused = true;
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer.pause();
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "pause error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
            }
        }
        stopTimeUpdateCallback();
        IAudioStateChangeListener mAudioStateChangeListener = getMAudioStateChangeListener();
        if (mAudioStateChangeListener != null) {
            mAudioStateChangeListener.onPause();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void play() {
        String str = this.mAudioPath;
        if (!isAudioFileValid(str)) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.ERROR, TAG, "play: audio file not valid, path=" + str, null, 8, null);
            }
            IAudioStateChangeListener mAudioStateChangeListener = getMAudioStateChangeListener();
            if (mAudioStateChangeListener != null) {
                mAudioStateChangeListener.onError(10003);
                return;
            }
            return;
        }
        if (this.mMediaPlayer == null) {
            MediaPlayer preparePlayer = preparePlayer();
            this.mMediaPlayer = preparePlayer;
            if (preparePlayer != null) {
                if (preparePlayer == null) {
                    try {
                        Intrinsics.throwNpe();
                    } catch (Throwable th5) {
                        LogDelegate logDelegate2 = this.logger;
                        if (logDelegate2 != null) {
                            logDelegate2.printLog(LogDelegate.Level.ERROR, TAG, "play error on setDataSource and prepareAsync. audioId=" + getMAudioId() + " path=" + str, th5);
                        }
                        IAudioStateChangeListener mAudioStateChangeListener2 = getMAudioStateChangeListener();
                        if (mAudioStateChangeListener2 != null) {
                            mAudioStateChangeListener2.onError(10003);
                        }
                    }
                }
                preparePlayer.setDataSource(str);
                MediaPlayer mediaPlayer = this.mMediaPlayer;
                if (mediaPlayer == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer.prepareAsync();
                if (getMAutoPlay()) {
                    return;
                }
            }
        }
        if (this.mMediaPlayer == null) {
            IAudioStateChangeListener mAudioStateChangeListener3 = getMAudioStateChangeListener();
            if (mAudioStateChangeListener3 != null) {
                mAudioStateChangeListener3.onError(10001);
            }
            LogDelegate logDelegate3 = this.logger;
            if (logDelegate3 != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate3, LogDelegate.Level.WARN, TAG, "play error on null mMediaPlayer, audioId=" + getMAudioId() + " path=" + str, null, 8, null);
                return;
            }
            return;
        }
        if (isPlaying()) {
            return;
        }
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$play$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.play();
                }
            });
            return;
        }
        try {
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 != null) {
                if (mediaPlayer2 == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer2.setLooping(getMLoop());
                float f16 = 0;
                if (this.volume >= f16) {
                    MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                    if (mediaPlayer3 == null) {
                        Intrinsics.throwNpe();
                    }
                    float f17 = this.volume;
                    mediaPlayer3.setVolume(f17, f17);
                }
                if (!getMPaused() && getStartTime() > f16) {
                    MediaPlayer mediaPlayer4 = this.mMediaPlayer;
                    if (mediaPlayer4 == null) {
                        Intrinsics.throwNpe();
                    }
                    mediaPlayer4.seekTo(this.mStartTime);
                }
                MediaPlayer mediaPlayer5 = this.mMediaPlayer;
                if (mediaPlayer5 == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer5.start();
                if (this.hadRegisterTimeUpdate.get()) {
                    startTimeUpdateCallback();
                }
            }
            this.mPaused = false;
        } catch (Throwable th6) {
            LogDelegate logDelegate4 = this.logger;
            if (logDelegate4 != null) {
                logDelegate4.printLog(LogDelegate.Level.ERROR, TAG, "play error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th6);
            }
        }
        IAudioStateChangeListener mAudioStateChangeListener4 = getMAudioStateChangeListener();
        if (mAudioStateChangeListener4 != null) {
            mAudioStateChangeListener4.onPlay();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public synchronized void release() {
        AtomicBoolean atomicBoolean;
        try {
            if (this.mMediaPlayer != null) {
                if (isPlaying()) {
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer == null) {
                        Intrinsics.throwNpe();
                    }
                    mediaPlayer.stop();
                }
                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                if (mediaPlayer2 == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer2.reset();
                MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                if (mediaPlayer3 == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer3.release();
            }
            this.mAudioId = 0;
            this.mAudioPath = null;
            this.mNeedToResume = false;
            this.mBufferedTime = 0.0d;
            this.mStartTime = 0;
            this.volume = -1.0f;
            this.mLoop = false;
            this.mAutoPlay = false;
            this.mPaused = true;
            this.mMediaPlayer = null;
            this.mPendingOperateTasks.clear();
            atomicBoolean = this.hadRegisterTimeUpdate;
        } catch (Throwable th5) {
            try {
                LogDelegate logDelegate = this.logger;
                if (logDelegate != null) {
                    logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "destroy error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
                }
                this.mAudioId = 0;
                this.mAudioPath = null;
                this.mNeedToResume = false;
                this.mBufferedTime = 0.0d;
                this.mStartTime = 0;
                this.volume = -1.0f;
                this.mLoop = false;
                this.mAutoPlay = false;
                this.mPaused = true;
                this.mMediaPlayer = null;
                this.mPendingOperateTasks.clear();
                atomicBoolean = this.hadRegisterTimeUpdate;
            } catch (Throwable th6) {
                this.mAudioId = 0;
                this.mAudioPath = null;
                this.mNeedToResume = false;
                this.mBufferedTime = 0.0d;
                this.mStartTime = 0;
                this.volume = -1.0f;
                this.mLoop = false;
                this.mAutoPlay = false;
                this.mPaused = true;
                this.mMediaPlayer = null;
                this.mPendingOperateTasks.clear();
                this.hadRegisterTimeUpdate.set(false);
                throw th6;
            }
        }
        atomicBoolean.set(false);
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void resume() {
        if (this.mMediaPlayer == null) {
            return;
        }
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$resume$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.resume();
                }
            });
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer.start();
                if (this.hadRegisterTimeUpdate.get()) {
                    startTimeUpdateCallback();
                }
            }
            this.mPaused = false;
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "resume error. audioId=" + getMAudioId() + " path=audioPath", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void seekTo(final float pos) {
        if (Float.isNaN(pos)) {
            return;
        }
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$seekTo$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.seekTo(pos);
                }
            });
            return;
        }
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo((int) pos);
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "seekTo error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
            }
        }
        IAudioStateChangeListener mAudioStateChangeListener = getMAudioStateChangeListener();
        if (mAudioStateChangeListener != null) {
            mAudioStateChangeListener.onSeeking();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setAudioId(int audioId) {
        this.mAudioId = audioId;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setAudioPath(@Nullable String path) {
        boolean z16;
        boolean z17;
        if (path != null && path.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str = this.mAudioPath;
            if (str != null) {
                if (str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    LogDelegate logDelegate = this.logger;
                    if (logDelegate != null) {
                        LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.WARN, TAG, "setAudioPath, path reset to null", null, 8, null);
                    }
                    reset$default(this, false, 1, null);
                }
            }
            this.mAudioPath = null;
            return;
        }
        if (!Intrinsics.areEqual(path, getMAudioPath())) {
            this.mAudioPath = path;
            reset$default(this, false, 1, null);
        }
        IAudioStateChangeListener mAudioStateChangeListener = getMAudioStateChangeListener();
        if (mAudioStateChangeListener != null) {
            mAudioStateChangeListener.onCanPlay();
        }
        if (getMAutoPlay()) {
            play();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setAutoPlay(boolean autoplay) {
        this.mAutoPlay = autoplay;
        if (autoplay && !TextUtils.isEmpty(getMAudioPath())) {
            play();
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setLoop(final boolean loop) {
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$setLoop$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.setLoop(loop);
                }
            });
            return;
        }
        this.mLoop = loop;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(loop);
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "setLoop error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setNeedResume(boolean needResume) {
        this.mNeedToResume = needResume;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setStartTime(float startTime) {
        this.mStartTime = (int) startTime;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setStateChangeListener(@Nullable IAudioStateChangeListener listener) {
        this.mAudioStateChangeListener = listener;
    }

    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    public void setVolume(final float vol) {
        if (vol < 0) {
            vol = 0.0f;
        } else if (vol > 1) {
            vol = 1.0f;
        }
        if (!isPrepared()) {
            addOperateTask(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer$setVolume$1
                @Override // java.lang.Runnable
                public final void run() {
                    InnerAudioPlayer.this.setVolume(vol);
                }
            });
            return;
        }
        this.volume = vol;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(vol, vol);
            }
        } catch (Throwable th5) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.ERROR, TAG, "setVolume error. audioId=" + getMAudioId() + " path=" + getMAudioPath(), th5);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void stop() {
        IAudioStateChangeListener mAudioStateChangeListener;
        if (this.mMediaPlayer == null) {
            return;
        }
        try {
            if (isPrepared()) {
                if (isPlaying()) {
                    MediaPlayer mediaPlayer = this.mMediaPlayer;
                    if (mediaPlayer == null) {
                        Intrinsics.throwNpe();
                    }
                    mediaPlayer.pause();
                }
                if (getStartTime() > 0) {
                    setStartTime(0.0f);
                }
                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                if (mediaPlayer2 == null) {
                    Intrinsics.throwNpe();
                }
                mediaPlayer2.seekTo(this.mStartTime);
            }
        } finally {
            try {
                mAudioStateChangeListener = getMAudioStateChangeListener();
                if (mAudioStateChangeListener == null) {
                }
            } finally {
            }
        }
        mAudioStateChangeListener = getMAudioStateChangeListener();
        if (mAudioStateChangeListener == null) {
            mAudioStateChangeListener.onStop();
        }
    }

    public /* synthetic */ InnerAudioPlayer(LogDelegate logDelegate, ScheduledExecutorService scheduledExecutorService, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(logDelegate, scheduledExecutorService, (i3 & 4) != 0 ? 1.0f : f16);
    }
}
