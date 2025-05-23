package com.tencent.ecommerce.biz.detail.viewmodel.shop.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012<\u0010\u0010\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bj\u0002`\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016RJ\u0010\u0010\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bj\u0002`\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownStatus;", "status", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownCallback;", "a", "Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductCountdownReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Function2<Context, ECShopProductCountdownStatus, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public ECShopProductCountdownReceiver(Function2<? super Context, ? super ECShopProductCountdownStatus, Unit> function2) {
        this.callback = function2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("startCount", false)) : null;
        Boolean valueOf2 = intent != null ? Boolean.valueOf(intent.getBooleanExtra("endCount", false)) : null;
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(valueOf, bool)) {
            this.callback.invoke(context, ECShopProductCountdownStatus.START);
        } else if (Intrinsics.areEqual(valueOf2, bool)) {
            this.callback.invoke(context, ECShopProductCountdownStatus.END);
        }
    }
}
