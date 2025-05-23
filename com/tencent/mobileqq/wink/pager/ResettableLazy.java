package com.tencent.mobileqq.wink.pager;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/pager/ResettableLazy;", "T", "", "Lkotlin/Lazy;", "d", "", "c", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "initializer", "b", "Lkotlin/Lazy;", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "lazyHolder", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class ResettableLazy<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<T> initializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Lazy<? extends T> lazyHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public ResettableLazy(@NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this.lazyHolder = d();
    }

    private final Lazy<T> d() {
        Lazy<T> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<T>(this) { // from class: com.tencent.mobileqq.wink.pager.ResettableLazy$makeInitBlock$1
            final /* synthetic */ ResettableLazy<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return this.this$0.a().invoke();
            }
        });
        return lazy;
    }

    @NotNull
    public final Function0<T> a() {
        return this.initializer;
    }

    @NotNull
    public final Lazy<T> b() {
        return this.lazyHolder;
    }

    public final boolean c() {
        return this.lazyHolder.isInitialized();
    }
}
