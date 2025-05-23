package com.tencent.qmethod.monitor.base.util;

import android.content.Context;
import android.os.Process;
import android.util.SparseArray;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/AppInfo;", "", "d", "a", "b", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class AppInfo {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f343509c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static b f343507a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<String> f343508b = new SparseArray<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007R\u001b\u0010\f\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/AppInfo$a;", "", "Landroid/content/Context;", "a", "ctx", "", "c", "", "pid$delegate", "Lkotlin/Lazy;", "b", "()I", "pid", "", "PSS_INFO_VALIDATE_IN_MILLIS", "J", "TAG", "Ljava/lang/String;", "Landroid/util/SparseArray;", "processMap", "Landroid/util/SparseArray;", "Lcom/tencent/qmethod/monitor/base/util/AppInfo$b;", "pssInfo", "Lcom/tencent/qmethod/monitor/base/util/AppInfo$b;", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.base.util.AppInfo$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final Context a() {
            return com.tencent.qmethod.monitor.a.f343451h.g().getContext();
        }

        public final int b() {
            return ((Number) AppInfo.f343509c.getValue()).intValue();
        }

        @JvmStatic
        @NotNull
        public final String c(@Nullable Context ctx) {
            String str = (String) AppInfo.f343508b.get(b());
            if (str != null) {
                return str;
            }
            String d16 = com.tencent.qmethod.pandoraex.core.collector.utils.a.d(ctx);
            if (d16 != null) {
                AppInfo.f343508b.put(AppInfo.INSTANCE.b(), d16);
                return d16;
            }
            return "";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/AppInfo$b;", "", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b {
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qmethod.monitor.base.util.AppInfo$Companion$pid$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return Process.myPid();
            }
        });
        f343509c = lazy;
    }
}
