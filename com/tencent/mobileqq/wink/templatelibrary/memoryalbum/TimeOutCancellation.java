package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/TimeOutCancellation;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class TimeOutCancellation extends CancellationException {

    @NotNull
    public static final TimeOutCancellation INSTANCE = new TimeOutCancellation();

    TimeOutCancellation() {
        super("cancelled by time out");
    }
}
