package com.tencent.rmonitor.looper.provider;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rmonitor/looper/provider/c;", "", "Ljava/lang/Thread;", MosaicConstants$JsProperty.PROP_THREAD, "Lcom/tencent/rmonitor/looper/provider/b;", "lagParam", "Lc14/a;", "callback", "", "a", "", "stop", "", "startTime", "c", "endTime", "duration", "b", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface c {
    boolean a(@NotNull Thread thread, @NotNull b lagParam, @NotNull c14.a callback);

    void b(long endTime, long duration);

    void c(long startTime);

    void stop();
}
