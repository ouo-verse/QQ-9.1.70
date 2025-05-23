package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/VasQzoneYellowThread;", "", "()V", "execJob", "", "job", "Ljava/lang/Runnable;", "execJobDelay", "delay", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasQzoneYellowThread {

    @NotNull
    public static final VasQzoneYellowThread INSTANCE = new VasQzoneYellowThread();

    VasQzoneYellowThread() {
    }

    public final void execJob(@NotNull Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.excute(job, 16, null, true);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.YellowVipThread).post(job);
        }
    }

    public final void execJobDelay(@Nullable Runnable job, long delay) {
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.executeDelay(job, 16, null, true, delay);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.YellowVipThread).postDelayed(job, delay);
        }
    }
}
