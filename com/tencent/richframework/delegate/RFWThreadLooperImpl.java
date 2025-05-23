package com.tencent.richframework.delegate;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.richframework.thread.RFWThreadLooperDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/delegate/RFWThreadLooperImpl;", "Lcom/tencent/richframework/thread/RFWThreadLooperDelegate;", "()V", "getErrorLooper", "Landroid/os/Looper;", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RFWThreadLooperImpl implements RFWThreadLooperDelegate {
    @Override // com.tencent.richframework.thread.RFWThreadLooperDelegate
    @NotNull
    public Looper getErrorLooper() {
        Looper qQCommonThreadLooper = ThreadManagerV2.getQQCommonThreadLooper();
        Intrinsics.checkNotNullExpressionValue(qQCommonThreadLooper, "getQQCommonThreadLooper()");
        return qQCommonThreadLooper;
    }
}
