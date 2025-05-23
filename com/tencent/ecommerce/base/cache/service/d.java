package com.tencent.ecommerce.base.cache.service;

import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/cache/service/d;", "T", "Lkotlin/Lazy;", "", "isInitialized", "", "d", "Ljava/lang/Object;", "_value", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getInitializer", "()Lkotlin/jvm/functions/Function0;", "initializer", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class d<T> implements Lazy<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Object _value = e.f100644a;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<T> initializer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/base/cache/service/EcommerceBizScopeImpl$value$1$1", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/base/fragment/e;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a implements EventObserver<com.tencent.ecommerce.base.fragment.e> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(com.tencent.ecommerce.base.fragment.e event) {
            synchronized (d.this) {
                if (cg0.a.c()) {
                    cg0.a.b("ECMemoryCache", "EcommerceBizScopeImpl release, _value=" + d.this._value);
                }
                d.this._value = e.f100644a;
                LifecycleEventBus.f100688b.e(this);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<? extends T> function0) {
        this.initializer = function0;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t16;
        synchronized (this) {
            if (Intrinsics.areEqual(this._value, e.f100644a)) {
                this._value = this.initializer.invoke();
                if (cg0.a.c()) {
                    cg0.a.b("ECMemoryCache", "EcommerceBizScopeImpl initial, _value=" + this._value);
                }
                LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, com.tencent.ecommerce.base.fragment.e.class, new a());
            }
            t16 = (T) this._value;
        }
        return t16;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return !Intrinsics.areEqual(this._value, e.f100644a);
    }
}
