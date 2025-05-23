package com.tencent.ecommerce.base.ktx;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/b;", "T", "Lkotlin/Lazy;", "", "a", "", "isInitialized", "d", "Ljava/lang/Object;", "cached", "", "e", "scoped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checking", "Lkotlin/Function0;", tl.h.F, "Lkotlin/jvm/functions/Function0;", "initializer", "i", "scope", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b<T> implements Lazy<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile T cached;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile Object scoped;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean checking;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function0<T> initializer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Function0<Object> scope;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function0<? extends T> function0, Function0<? extends Object> function02) {
        this.initializer = function0;
        this.scope = function02;
        this.scoped = function02 != null ? function02.invoke() : null;
        this.checking = new AtomicBoolean(false);
    }

    private final void a() {
        if (this.checking.compareAndSet(false, true)) {
            Object obj = this.scoped;
            Function0<Object> function0 = this.scope;
            Object invoke = function0 != null ? function0.invoke() : null;
            boolean areEqual = Intrinsics.areEqual(obj, invoke);
            this.scoped = invoke;
            if (!areEqual) {
                this.cached = null;
            }
            this.checking.set(false);
            return;
        }
        this.cached = null;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        a();
        T t16 = this.cached;
        if (t16 != null) {
            return t16;
        }
        T invoke = this.initializer.invoke();
        this.cached = invoke;
        return invoke;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.cached != null;
    }
}
