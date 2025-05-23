package com.tencent.ecommerce.base.ui;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ktx.CacheDelegateKt;
import com.tencent.ecommerce.base.ui.api.IECSkinApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001b\u0010\u0005\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\b\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u001b\u0010\u000b\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "a", "Lkotlin/Lazy;", "g", "()Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "enabledManager", "b", "e", "disabledManager", "c", tl.h.F, "innerSkinManager", "", "f", "()Z", "enableSkin", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECSkinKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f101118a;

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f101119b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f101120c;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECEnableSkinManager>() { // from class: com.tencent.ecommerce.base.ui.ECSkinKt$enabledManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECEnableSkinManager invoke() {
                return new ECEnableSkinManager();
            }
        });
        f101118a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ECDisableSkinManager>() { // from class: com.tencent.ecommerce.base.ui.ECSkinKt$disabledManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDisableSkinManager invoke() {
                return new ECDisableSkinManager();
            }
        });
        f101119b = lazy2;
        f101120c = new com.tencent.ecommerce.base.ktx.b(new Function0<IECSkinApi>() { // from class: com.tencent.ecommerce.base.ui.ECSkinKt$innerSkinManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IECSkinApi invoke() {
                boolean f16;
                IECSkinApi g16;
                IECSkinApi e16;
                f16 = ECSkinKt.f();
                if (!f16) {
                    cg0.a.b("ECSkin", "skin disabled");
                    e16 = ECSkinKt.e();
                    return e16;
                }
                QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
                if (Intrinsics.areEqual(qQEcommerceSdk.getGlobalInternalSdk().getSkinApi(), com.tencent.ecommerce.base.ui.api.b.f101143b)) {
                    cg0.a.b("ECSkin", "skin enabled, use preset api");
                    g16 = ECSkinKt.g();
                    return g16;
                }
                cg0.a.b("ECSkin", "skin enabled, use custom api");
                return qQEcommerceSdk.getGlobalInternalSdk().getSkinApi();
            }
        }, CacheDelegateKt.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IECSkinApi e() {
        return (IECSkinApi) f101119b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f() {
        return ((Number) com.tencent.ecommerce.base.config.service.b.f100655b.a(657, "ecommerce_enable_skin_int", 1)).intValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IECSkinApi g() {
        return (IECSkinApi) f101118a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IECSkinApi h() {
        return (IECSkinApi) f101120c.getValue();
    }
}
