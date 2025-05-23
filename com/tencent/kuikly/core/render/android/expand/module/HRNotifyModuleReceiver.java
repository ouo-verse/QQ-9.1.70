package com.tencent.kuikly.core.render.android.expand.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/HRNotifyModuleReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/kuikly/core/render/android/expand/module/k;", "a", "Ljava/lang/ref/WeakReference;", "weakRef", "notifyModule", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/module/k;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class HRNotifyModuleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<k> weakRef;

    public HRNotifyModuleReceiver(@NotNull k notifyModule) {
        Intrinsics.checkNotNullParameter(notifyModule, "notifyModule");
        this.weakRef = new WeakReference<>(notifyModule);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable final Intent intent) {
        final k kVar;
        if (intent != null && (kVar = this.weakRef.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(kVar, "weakRef.get() ?: return");
            if (com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
                kVar.d(intent);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.module.HRNotifyModuleReceiver$onReceive$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.this.d(intent);
                    }
                });
            }
        }
    }
}
