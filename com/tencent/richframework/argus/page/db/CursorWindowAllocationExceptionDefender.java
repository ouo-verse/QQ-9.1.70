package com.tencent.richframework.argus.page.db;

import android.os.Build;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.thread.defend.IExceptionDefender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/argus/page/db/CursorWindowAllocationExceptionDefender;", "Lcom/tencent/richframework/thread/defend/IExceptionDefender;", "()V", "canDefendException", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "throwable", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class CursorWindowAllocationExceptionDefender implements IExceptionDefender {
    @Override // com.tencent.richframework.thread.defend.IExceptionDefender
    public boolean canDefendException(@NotNull Thread thread, @NotNull Throwable throwable) {
        int i3;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (throwable.getClass().getName().equals("android.database.CursorWindowAllocationException") && (i3 = Build.VERSION.SDK_INT) >= 26 && i3 <= 27) {
            return true;
        }
        return false;
    }
}
