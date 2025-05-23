package com.tencent.mobileqq.tvideo.recorder;

import android.text.TextUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import fy2.TVideoPlayRecordItem;
import fy2.b;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/recorder/TVideoPlayRecorder;", "", "", "e", "b", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "vid", "c", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStart", "Ljava/lang/String;", "launchId", "Lcom/tencent/superplayer/api/ISuperPlayer;", "", "f", "Ljava/lang/Boolean;", "isNewVideo", "Ljava/util/Timer;", "g", "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "Ljava/util/TimerTask;", h.F, "Ljava/util/TimerTask;", "timerTask", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoPlayRecorder {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile String launchId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile ISuperPlayer player;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Timer timer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TimerTask timerTask;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TVideoPlayRecorder f304757a = new TVideoPlayRecorder();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasStart = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile String vid = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Boolean isNewVideo = Boolean.FALSE;

    TVideoPlayRecorder() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        synchronized (this) {
            if (player != null) {
                ISuperPlayer iSuperPlayer = player;
                Intrinsics.checkNotNull(iSuperPlayer);
                if (iSuperPlayer.isPlaying()) {
                    if (Intrinsics.areEqual(isNewVideo, Boolean.TRUE)) {
                        QLog.i("TVideoPlayRecorder", 1, "isNewVideo");
                        String str = launchId;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("launchId");
                            str = null;
                        }
                        b.f400938a.g(new TVideoPlayRecordItem(str, vid, System.currentTimeMillis(), 0, 8, null));
                        isNewVideo = Boolean.FALSE;
                    } else {
                        b.f400938a.e(1);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    private final void e() {
        QLog.i("TVideoPlayRecorder", 1, "stopTimer");
        Timer timer2 = timer;
        if (timer2 != null) {
            Intrinsics.checkNotNull(timer2);
            timer2.cancel();
            Timer timer3 = timer;
            Intrinsics.checkNotNull(timer3);
            timer3.purge();
            timer = null;
        }
        TimerTask timerTask2 = timerTask;
        if (timerTask2 != null) {
            Intrinsics.checkNotNull(timerTask2);
            timerTask2.cancel();
            timerTask = null;
        }
    }

    public final void c(@NotNull ISuperPlayer player2, @NotNull String vid2) {
        Intrinsics.checkNotNullParameter(player2, "player");
        Intrinsics.checkNotNullParameter(vid2, "vid");
        QLog.i("TVideoPlayRecorder", 1, "startRecord");
        synchronized (this) {
            player = player2;
            if (!TextUtils.equals(vid, vid2)) {
                isNewVideo = Boolean.TRUE;
                vid = vid2;
            } else {
                isNewVideo = Boolean.FALSE;
            }
            if (hasStart.compareAndSet(false, true)) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                launchId = uuid;
                if (timer != null) {
                    f304757a.e();
                }
                timer = new BaseTimer();
                timerTask = new TimerTask() { // from class: com.tencent.mobileqq.tvideo.recorder.TVideoPlayRecorder$startRecord$1$1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        TVideoPlayRecorder.f304757a.b();
                    }
                };
                Timer timer2 = timer;
                Intrinsics.checkNotNull(timer2);
                timer2.scheduleAtFixedRate(timerTask, 1000L, 1000L);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d() {
        QLog.i("TVideoPlayRecorder", 1, "stopRecord");
        synchronized (this) {
            f304757a.e();
            hasStart.set(false);
            player = null;
            vid = "";
            b.f400938a.f();
            Unit unit = Unit.INSTANCE;
        }
    }
}
