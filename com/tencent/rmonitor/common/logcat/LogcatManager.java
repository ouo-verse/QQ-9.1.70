package com.tencent.rmonitor.common.logcat;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rmonitor/common/logcat/LogcatManager;", "", "c", "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LogcatManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f365486a;

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f365487b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rmonitor/common/logcat/LogcatManager$a;", "", "", "type", "Lcom/tencent/rmonitor/common/logcat/a;", "c", "Lcom/tencent/rmonitor/common/logcat/b;", "javaLog$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/rmonitor/common/logcat/b;", "javaLog", "Lcom/tencent/rmonitor/common/logcat/c;", "nativeLog$delegate", "b", "()Lcom/tencent/rmonitor/common/logcat/c;", "nativeLog", "JAVA", "I", "NATIVE", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.common.logcat.LogcatManager$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty[] f365489a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "javaLog", "getJavaLog()Lcom/tencent/rmonitor/common/logcat/LogcatFromJava;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "nativeLog", "getNativeLog()Lcom/tencent/rmonitor/common/logcat/LogcatFromNative;"))};

        Companion() {
        }

        private final b a() {
            Lazy lazy = LogcatManager.f365486a;
            KProperty kProperty = f365489a[0];
            return (b) lazy.getValue();
        }

        private final c b() {
            Lazy lazy = LogcatManager.f365487b;
            KProperty kProperty = f365489a[1];
            return (c) lazy.getValue();
        }

        @JvmStatic
        @Nullable
        public final a c(int type) {
            if (type != 1) {
                if (type != 2) {
                    return a();
                }
                return b();
            }
            return a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.rmonitor.common.logcat.LogcatManager$Companion$javaLog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b();
            }
        });
        f365486a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.rmonitor.common.logcat.LogcatManager$Companion$nativeLog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return new c();
            }
        });
        f365487b = lazy2;
    }

    @JvmStatic
    @Nullable
    public static final a c(int i3) {
        return INSTANCE.c(i3);
    }
}
