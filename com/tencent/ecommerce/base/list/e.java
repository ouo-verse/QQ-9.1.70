package com.tencent.ecommerce.base.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/list/e;", "BEAN", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/ecommerce/base/list/e$b;", "Lcom/tencent/ecommerce/base/list/e$a;", "Lcom/tencent/ecommerce/base/list/e$c;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class e<BEAN> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/list/e$a;", "BEAN", "Lcom/tencent/ecommerce/base/list/e;", "a", "Ljava/lang/Object;", "bean", "<init>", "(Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a<BEAN> extends e<BEAN> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final BEAN bean;

        public a(BEAN bean) {
            super(null);
            this.bean = bean;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/list/e$b;", "BEAN", "Lcom/tencent/ecommerce/base/list/e;", "Lkotlin/Function1;", "", "a", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "predicate", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b<BEAN> extends e<BEAN> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function1<BEAN, Boolean> predicate;

        public final Function1<BEAN, Boolean> a() {
            return this.predicate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super BEAN, Boolean> function1) {
            super(null);
            this.predicate = function1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/base/list/e$c;", "BEAN", "Lcom/tencent/ecommerce/base/list/e;", "a", "Ljava/lang/Object;", "bean", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "predicate", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c<BEAN> extends e<BEAN> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final BEAN bean;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Function1<BEAN, Boolean> predicate;

        public final Function1<BEAN, Boolean> a() {
            return this.predicate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(BEAN bean, Function1<? super BEAN, Boolean> function1) {
            super(null);
            this.bean = bean;
            this.predicate = function1;
        }
    }

    e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
