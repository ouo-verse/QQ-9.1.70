package com.tencent.rmonitor.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/rmonitor/common/util/a;", "", "c", "a", "b", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static b f365521a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static String f365522b = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/rmonitor/common/util/a$a;", "", "Landroid/content/Context;", "ctx", "", "c", "context", "a", "", "b", "PSS_INFO_VALIDATE_IN_MILLIS", "J", "TAG", "Ljava/lang/String;", "appName", "Lcom/tencent/rmonitor/common/util/a$b;", "pssInfo", "Lcom/tencent/rmonitor/common/util/a$b;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.common.util.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final String a(@Nullable Context context) {
            if (!TextUtils.isEmpty(a.f365522b)) {
                return a.f365522b;
            }
            CharSequence charSequence = null;
            if (context != null) {
                try {
                    charSequence = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
                } catch (Throwable th5) {
                    Logger.f365497g.c("RMonitor_common_AppInfo", th5);
                }
            }
            if (charSequence == null) {
                charSequence = "";
            }
            a.f365522b = String.valueOf(charSequence);
            Logger.f365497g.d("RMonitor_common_AppInfo", "getAppName, name: " + a.f365522b);
            return a.f365522b;
        }

        @JvmStatic
        public final long b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - a.f365521a.getTimeStamp() < 10000) {
                    return a.f365521a.getPssSize() * 1024;
                }
                a.f365521a.d(currentTimeMillis);
                a.f365521a.c(SystemMethodProxy.getPss());
                return a.f365521a.getPssSize() * 1024;
            } catch (Exception e16) {
                Logger.f365497g.c("RMonitor_common_AppInfo", e16);
                return 0L;
            }
        }

        @JvmStatic
        @NotNull
        public final String c(@Nullable Context ctx) {
            return ProcessUtil.INSTANCE.getCurrentProcessName(ctx);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rmonitor/common/util/a$b;", "", "", "a", "J", "()J", "c", "(J)V", "pssSize", "b", "d", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long pssSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long timeStamp;

        /* renamed from: a, reason: from getter */
        public final long getPssSize() {
            return this.pssSize;
        }

        /* renamed from: b, reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public final void c(long j3) {
            this.pssSize = j3;
        }

        public final void d(long j3) {
            this.timeStamp = j3;
        }
    }

    @JvmStatic
    public static final long d() {
        return INSTANCE.b();
    }

    @JvmStatic
    @NotNull
    public static final String e(@Nullable Context context) {
        return INSTANCE.c(context);
    }
}
