package com.tencent.ecommerce.base.cache.service;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/cache/service/a;", "T", "Lkotlin/Lazy;", "", "isInitialized", "", "d", "Ljava/lang/Long;", "oldAccount", "", "e", "Ljava/lang/Object;", "_value", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getInitializer", "()Lkotlin/jvm/functions/Function0;", "initializer", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
final class a<T> implements Lazy<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Long oldAccount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Object _value = e.f100644a;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function0<T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> function0) {
        this.initializer = function0;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t16;
        synchronized (this) {
            long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            Long l3 = this.oldAccount;
            if (l3 != null && currentAccount == l3.longValue() && (!Intrinsics.areEqual(this._value, e.f100644a))) {
                t16 = (T) this._value;
                this.oldAccount = Long.valueOf(currentAccount);
            }
            this._value = this.initializer.invoke();
            if (cg0.a.c()) {
                cg0.a.b("ECMemoryCache", "AccountScopeImpl initial, _value=" + this._value);
            }
            t16 = (T) this._value;
            this.oldAccount = Long.valueOf(currentAccount);
        }
        return t16;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.oldAccount != null && (Intrinsics.areEqual(this._value, e.f100644a) ^ true);
    }
}
