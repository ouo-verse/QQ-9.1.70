package com.tencent.sqshow.zootopia.samestyle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/JumpToLittleWorldBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Landroid/content/IntentFilter;", "a", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getCancelCallback", "()Lkotlin/jvm/functions/Function0;", "cancelCallback", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class JumpToLittleWorldBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> cancelCallback;

    public JumpToLittleWorldBroadcastReceiver(Function0<Unit> cancelCallback) {
        Intrinsics.checkNotNullParameter(cancelCallback, "cancelCallback");
        this.cancelCallback = cancelCallback;
    }

    public final IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("CANCEL_JUMPER_TO_QQ_CIRCLE_PUBLISH");
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "CANCEL_JUMPER_TO_QQ_CIRCLE_PUBLISH")) {
            this.cancelCallback.invoke();
        }
    }
}
