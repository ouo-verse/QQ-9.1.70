package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007RT\u0010\u0010\u001aB\u0012\u0004\u0012\u00020\u000b\u00128\u00126\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qwallet/pay/PayLogicFactory;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lcom/qwallet/pay/b;", "a", "", "b", "", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Ljava/util/Map;", "mInvokeIDToLogicMap", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class PayLogicFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PayLogicFactory f41626a = new PayLogicFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Function2<Context, Intent, b>> mInvokeIDToLogicMap;

    static {
        Map<Integer, Function2<Context, Intent, b>> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(22, PayLogicFactory$mInvokeIDToLogicMap$1.INSTANCE), TuplesKt.to(15, PayLogicFactory$mInvokeIDToLogicMap$2.INSTANCE), TuplesKt.to(21, PayLogicFactory$mInvokeIDToLogicMap$3.INSTANCE), TuplesKt.to(23, PayLogicFactory$mInvokeIDToLogicMap$4.INSTANCE), TuplesKt.to(16, PayLogicFactory$mInvokeIDToLogicMap$5.INSTANCE), TuplesKt.to(9, PayLogicFactory$mInvokeIDToLogicMap$6.INSTANCE), TuplesKt.to(24, PayLogicFactory$mInvokeIDToLogicMap$7.INSTANCE), TuplesKt.to(8, PayLogicFactory$mInvokeIDToLogicMap$8.INSTANCE), TuplesKt.to(7, PayLogicFactory$mInvokeIDToLogicMap$9.INSTANCE), TuplesKt.to(6, PayLogicFactory$mInvokeIDToLogicMap$10.INSTANCE), TuplesKt.to(4, PayLogicFactory$mInvokeIDToLogicMap$11.INSTANCE), TuplesKt.to(14, PayLogicFactory$mInvokeIDToLogicMap$12.INSTANCE), TuplesKt.to(17, PayLogicFactory$mInvokeIDToLogicMap$13.INSTANCE), TuplesKt.to(5, PayLogicFactory$mInvokeIDToLogicMap$14.INSTANCE), TuplesKt.to(1, PayLogicFactory$mInvokeIDToLogicMap$15.INSTANCE), TuplesKt.to(2, PayLogicFactory$mInvokeIDToLogicMap$16.INSTANCE), TuplesKt.to(3, PayLogicFactory$mInvokeIDToLogicMap$17.INSTANCE), TuplesKt.to(10, PayLogicFactory$mInvokeIDToLogicMap$18.INSTANCE), TuplesKt.to(11, PayLogicFactory$mInvokeIDToLogicMap$19.INSTANCE), TuplesKt.to(12, PayLogicFactory$mInvokeIDToLogicMap$20.INSTANCE), TuplesKt.to(13, PayLogicFactory$mInvokeIDToLogicMap$21.INSTANCE), TuplesKt.to(25, PayLogicFactory$mInvokeIDToLogicMap$22.INSTANCE));
        mInvokeIDToLogicMap = mutableMapOf;
    }

    PayLogicFactory() {
    }

    @JvmStatic
    @Nullable
    public static final b a(@Nullable Context context, @Nullable Intent intent) {
        int f16 = s.f(intent);
        Function2<Context, Intent, b> function2 = mInvokeIDToLogicMap.get(Integer.valueOf(f16));
        if (function2 != null) {
            return function2.invoke(context, intent);
        }
        QLog.i("PayLogicFactory", 2, "no match logic invokeId=" + f16);
        return null;
    }

    @JvmStatic
    public static final boolean b(@Nullable Intent intent) {
        return QWalletPayBridge.isMidasInvokerId(s.f(intent));
    }
}
