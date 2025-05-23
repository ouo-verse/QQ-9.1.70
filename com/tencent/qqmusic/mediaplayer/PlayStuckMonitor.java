package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J&\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005J \u0010\u001a\u001a\u00020\u00062\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J,\u0010\u001c\u001a\u00020\u00062$\u0010\u001b\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\bR\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R,\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmusic/mediaplayer/PlayStuckMonitor;", "", "()V", "mAudioTrackFlushCallback", "Lkotlin/Function2;", "", "", "mCallback", "Lkotlin/Function4;", "", "", "mEnable", "mHandler", "Landroid/os/Handler;", "mHandlerForFlush", "mHandlerThread", "Landroid/os/HandlerThread;", "init", "onAudioTrackFlush", "writeCount", "bufferSize", "onPlayStuck", "decodeTime", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "continuous", "underrunCount", "setAudioTrackFlushListener", "callback", "setOnPlayStuckListener", "player_qqmusic_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class PlayStuckMonitor {
    public static final PlayStuckMonitor INSTANCE = new PlayStuckMonitor();
    private static Function2<? super Integer, ? super Integer, Unit> mAudioTrackFlushCallback;
    private static Function4<? super Long, ? super Long, ? super Boolean, ? super Integer, Unit> mCallback;
    private static boolean mEnable;
    private static Handler mHandler;
    private static Handler mHandlerForFlush;
    private static HandlerThread mHandlerThread;

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AudioTrackFlushMonitor");
        baseHandlerThread.start();
        mHandlerForFlush = new Handler(baseHandlerThread.getLooper());
    }

    PlayStuckMonitor() {
    }

    public static final /* synthetic */ Function4 access$getMCallback$p(PlayStuckMonitor playStuckMonitor) {
        Function4<? super Long, ? super Long, ? super Boolean, ? super Integer, Unit> function4 = mCallback;
        if (function4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        }
        return function4;
    }

    public final void init() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PlayStuckMonitor");
        mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        HandlerThread handlerThread = mHandlerThread;
        if (handlerThread == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerThread");
        }
        mHandler = new Handler(handlerThread.getLooper());
    }

    public final void onAudioTrackFlush(final int writeCount, final int bufferSize) {
        Handler handler;
        final Function2<? super Integer, ? super Integer, Unit> function2 = mAudioTrackFlushCallback;
        if (function2 != null && (handler = mHandlerForFlush) != null) {
            handler.post(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.PlayStuckMonitor$onAudioTrackFlush$$inlined$apply$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function2.this.invoke(Integer.valueOf(writeCount), Integer.valueOf(bufferSize));
                }
            });
        }
    }

    public final void onPlayStuck(final long decodeTime, final long playTime, final boolean continuous, final int underrunCount) {
        if (mEnable) {
            Handler handler = mHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            }
            handler.post(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.PlayStuckMonitor$onPlayStuck$1
                @Override // java.lang.Runnable
                public final void run() {
                    PlayStuckMonitor.access$getMCallback$p(PlayStuckMonitor.INSTANCE).invoke(Long.valueOf(decodeTime), Long.valueOf(playTime), Boolean.valueOf(continuous), Integer.valueOf(underrunCount));
                }
            });
        }
    }

    public final void setAudioTrackFlushListener(@NotNull Function2<? super Integer, ? super Integer, Unit> callback) {
        mAudioTrackFlushCallback = callback;
    }

    public final void setOnPlayStuckListener(@NotNull Function4<? super Long, ? super Long, ? super Boolean, ? super Integer, Unit> callback) {
        mCallback = callback;
        mEnable = true;
    }
}
