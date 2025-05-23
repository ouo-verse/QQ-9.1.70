package com.tencent.bugly.common.looper;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/bugly/common/looper/ILooperDispatchListener;", "", h.f248218g, "", "onDispatchEnd", "", "msg", "", "endTime", "", "duration", "onDispatchStart", "startTime", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface ILooperDispatchListener {
    boolean isOpen();

    void onDispatchEnd(@NotNull String msg2, long endTime, long duration);

    void onDispatchStart(@NotNull String msg2, long startTime);
}
