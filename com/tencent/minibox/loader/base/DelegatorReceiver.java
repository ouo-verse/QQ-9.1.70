package com.tencent.minibox.loader.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.dynamic.api.IReceiverDelegate;
import com.tencent.minibox.loader.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/minibox/loader/base/DelegatorReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/tencent/minibox/dynamic/api/IReceiverDelegate;", "a", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "b", "Lcom/tencent/minibox/dynamic/api/IReceiverDelegate;", "mReceiverImpl", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public abstract class DelegatorReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private IReceiverDelegate mReceiverImpl;

    private final IReceiverDelegate a() {
        IReceiverDelegate iReceiverDelegate = this.mReceiverImpl;
        if (iReceiverDelegate != null) {
            return iReceiverDelegate;
        }
        a aVar = a.f151655b;
        if (!aVar.b()) {
            return null;
        }
        IReceiverDelegate receiverImpl = aVar.a().getReceiverImpl(this);
        this.mReceiverImpl = receiverImpl;
        return receiverImpl;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        String TAG = this.TAG;
        Intrinsics.checkExpressionValueIsNotNull(TAG, "TAG");
        LogUtils.i(TAG, "onReceive");
        IReceiverDelegate a16 = a();
        if (a16 != null) {
            a16.onReceive(context, intent);
        }
    }
}
