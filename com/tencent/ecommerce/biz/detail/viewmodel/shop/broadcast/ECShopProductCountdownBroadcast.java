package com.tencent.ecommerce.biz.detail.viewmodel.shop.broadcast;

import android.content.Context;
import android.content.IntentFilter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012<\u0010\u0016\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u000fj\u0002`\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\b\u0010\rRJ\u0010\u0016\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u000fj\u0002`\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownBroadcast;", "", "Landroid/content/Context;", "context", "b", "", "c", "", "a", "Z", "mReceiverTag", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownReceiver;", "Lkotlin/Lazy;", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownReceiver;", "countdownObserver", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownStatus;", "status", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownCallback;", "Lkotlin/jvm/functions/Function2;", "callback", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductCountdownBroadcast {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mReceiverTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy countdownObserver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Function2<Context, ECShopProductCountdownStatus, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public ECShopProductCountdownBroadcast(Function2<? super Context, ? super ECShopProductCountdownStatus, Unit> function2) {
        Lazy lazy;
        this.callback = function2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECShopProductCountdownReceiver>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.broadcast.ECShopProductCountdownBroadcast$countdownObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECShopProductCountdownReceiver invoke() {
                return new ECShopProductCountdownReceiver(ECShopProductCountdownBroadcast.this.callback);
            }
        });
        this.countdownObserver = lazy;
    }

    private final ECShopProductCountdownReceiver a() {
        return (ECShopProductCountdownReceiver) this.countdownObserver.getValue();
    }

    public final ECShopProductCountdownBroadcast b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.pts.broadcast.countdown.end");
        context.registerReceiver(a(), intentFilter);
        this.mReceiverTag = true;
        return this;
    }

    public final void c(Context context) {
        if (this.mReceiverTag) {
            this.mReceiverTag = false;
            context.unregisterReceiver(a());
        }
    }
}
