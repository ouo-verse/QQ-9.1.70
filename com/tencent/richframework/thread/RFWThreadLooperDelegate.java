package com.tencent.richframework.thread;

import android.os.Looper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/richframework/thread/RFWThreadLooperDelegate;", "", "getErrorLooper", "Landroid/os/Looper;", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface RFWThreadLooperDelegate {
    @NotNull
    Looper getErrorLooper();
}
