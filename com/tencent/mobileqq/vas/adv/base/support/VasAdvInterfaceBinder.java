package com.tencent.mobileqq.vas.adv.base.support;

import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppImpl;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl;
import dz2.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvInterfaceBinder;", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvInterfaceBinder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<VasAdvAppImpl> f307995b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<VasAdvGdtImpl> f307996c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/VasAdvInterfaceBinder$a;", "", "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "b", "Ldz2/b;", "c", "app$delegate", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "app", "gdt$delegate", "e", "()Ldz2/b;", "gdt", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c d() {
            return (c) VasAdvInterfaceBinder.f307995b.getValue();
        }

        private final b e() {
            return (b) VasAdvInterfaceBinder.f307996c.getValue();
        }

        @JvmStatic
        @NotNull
        public final c b() {
            return d();
        }

        @JvmStatic
        @NotNull
        public final b c() {
            return e();
        }

        Companion() {
        }
    }

    static {
        Lazy<VasAdvAppImpl> lazy;
        Lazy<VasAdvGdtImpl> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VasAdvAppImpl>() { // from class: com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder$Companion$app$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VasAdvAppImpl invoke() {
                return new VasAdvAppImpl();
            }
        });
        f307995b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<VasAdvGdtImpl>() { // from class: com.tencent.mobileqq.vas.adv.base.support.VasAdvInterfaceBinder$Companion$gdt$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VasAdvGdtImpl invoke() {
                c d16;
                d16 = VasAdvInterfaceBinder.INSTANCE.d();
                return new VasAdvGdtImpl(d16);
            }
        });
        f307996c = lazy2;
    }
}
