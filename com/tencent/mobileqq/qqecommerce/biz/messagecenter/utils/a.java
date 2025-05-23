package com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/utils/a;", "T", "Lkotlin/Lazy;", "", "a", "", "isInitialized", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "initializer", "", "e", "scope", "f", "Ljava/lang/Object;", "cached", h.F, "scoped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checking", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a<T> implements Lazy<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<T> initializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Object> scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile T cached;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile Object scoped;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean checking;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> initializer, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this.scope = function0;
        this.scoped = function0 != null ? function0.invoke() : null;
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
