package com.tencent.mobileqq.qqexpand.flutter.router;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\tR2\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/router/RouterManager;", "", "Lcom/tencent/mobileqq/qqexpand/flutter/router/a;", "router", "", "c", "b", "", "f", "", "e", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "mNativeRouters", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsInitial", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RouterManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<RouterManager> f263578d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, a> mNativeRouters = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean mIsInitial = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/flutter/router/RouterManager$a;", "", "Lcom/tencent/mobileqq/qqexpand/flutter/router/RouterManager;", "a", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/qqexpand/flutter/router/RouterManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.flutter.router.RouterManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final RouterManager b() {
            return (RouterManager) RouterManager.f263578d.getValue();
        }

        @JvmStatic
        public final RouterManager a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<RouterManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RouterManager>() { // from class: com.tencent.mobileqq.qqexpand.flutter.router.RouterManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RouterManager invoke() {
                return new RouterManager();
            }
        });
        f263578d = lazy;
    }

    private final void c(a router) {
        if (TextUtils.isEmpty(router.a())) {
            QLog.d("RouterManager", 1, "add router name is empty");
        } else {
            if (this.mNativeRouters.containsKey(router.a())) {
                return;
            }
            this.mNativeRouters.put(router.a(), router);
        }
    }

    @JvmStatic
    public static final RouterManager d() {
        return INSTANCE.a();
    }

    public final void b() {
        this.mIsInitial.set(true);
        c(new b());
    }

    public final boolean e() {
        return this.mIsInitial.get();
    }

    public final a f(String router) {
        if (TextUtils.isEmpty(router) || !this.mNativeRouters.containsKey(router)) {
            return null;
        }
        return this.mNativeRouters.get(router);
    }
}
