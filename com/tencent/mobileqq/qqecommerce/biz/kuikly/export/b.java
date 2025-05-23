package com.tencent.mobileqq.qqecommerce.biz.kuikly.export;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/b;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/a;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "weakRef", "module", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/a;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<a> weakRef;

    public b(a module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.weakRef = new WeakReference<>(module);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        if (intent == null || (aVar = this.weakRef.get()) == null) {
            return;
        }
        aVar.p(intent);
    }
}
