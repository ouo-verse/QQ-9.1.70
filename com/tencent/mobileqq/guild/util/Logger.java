package com.tencent.mobileqq.guild.util;

import android.os.SystemClock;
import android.util.Log;
import androidx.collection.LruCache;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J)\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\u0002\b\rH\u0002J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086\b\u00f8\u0001\u0000J,\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086\b\u00f8\u0001\u0000J$\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086\b\u00f8\u0001\u0000J$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086\b\u00f8\u0001\u0000J0\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\u0002\b\r2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\u0002\b\rJ&\u0010\u0019\u001a\u00020\t*\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\u0002\b\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\u0004R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\"\u0010#\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/util/Logger;", "", "", "level", "", "tag", "message", "", "throwable", "", tl.h.F, "messageKey", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "k", "Lkotlin/Function0;", "e", "", "fail", "f", "a", "b", "action", "j", "l", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "messageWithTimestamp", "c", "Z", "()Z", "setDebugSwitch", "(Z)V", "debugSwitch", "Lcom/tencent/mobileqq/guild/util/Logger$a;", "d", "Lcom/tencent/mobileqq/guild/util/Logger$a;", "()Lcom/tencent/mobileqq/guild/util/Logger$a;", "setLogger", "(Lcom/tencent/mobileqq/guild/util/Logger$a;)V", "logger", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class Logger {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean debugSwitch;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Logger f235387a = new Logger();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Long> messageWithTimestamp = new LruCache<>(16);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static a logger = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J \u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J*\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/util/Logger$a;", "", "", "tag", "", "level", "msg", "", "i", "a", "d", "c", "w", "e", "", ReportConstant.COSTREPORT_TRANS, "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        void a(@NotNull String tag, int level, @NotNull String msg2);

        void b(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5);

        void c(@NotNull String tag, int level, @NotNull String msg2);

        void d(@NotNull String tag, int level, @NotNull String msg2);

        void e(@NotNull String tag, int level, @NotNull String msg2);

        void e(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5);

        void i(@NotNull String tag, int level, @NotNull String msg2);

        void w(@NotNull String tag, int level, @NotNull String msg2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0086\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/Logger$b;", "", "", "", "b", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "logs", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> logs = new ArrayList();

        @NotNull
        public final List<String> a() {
            return this.logs;
        }

        public final void b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            this.logs.add(str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J*\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/util/Logger$c", "Lcom/tencent/mobileqq/guild/util/Logger$a;", "", "tag", "", "level", "msg", "", "i", "a", "d", "c", "w", "e", "", ReportConstant.COSTREPORT_TRANS, "b", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void a(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.iAsync(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void b(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.eAsync(tag, level, msg2, tr5);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void c(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.dAsync(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void d(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void e(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.wAsync(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void i(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void w(@NotNull String tag, int level, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.w(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.guild.util.Logger.a
        public void e(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, level, msg2, tr5);
        }
    }

    Logger() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(int i3, @NotNull String tag, @NotNull String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        i(i3, tag, message, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(int level, @NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = tag + ':' + message;
        LruCache<String, Long> lruCache = messageWithTimestamp;
        Long l3 = lruCache.get(str);
        if (l3 == null || l3.longValue() + 1000 < SystemClock.uptimeMillis()) {
            lruCache.put(str, Long.valueOf(SystemClock.uptimeMillis()));
            if (level != 4) {
                if (level != 5) {
                    if (level != 6) {
                        logger.d(tag, 1, message);
                        return;
                    } else {
                        logger.e(tag, 1, message, throwable);
                        return;
                    }
                }
                logger.w(tag, 1, message);
                return;
            }
            logger.i(tag, 1, message);
        }
    }

    public static /* synthetic */ void i(int i3, String str, String str2, Throwable th5, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            th5 = null;
        }
        h(i3, str, str2, th5);
    }

    private final void k(String messageKey, Function1<? super Logger, Unit> block) {
        LruCache<String, Long> lruCache = messageWithTimestamp;
        Long l3 = lruCache.get(messageKey);
        if (l3 == null || l3.longValue() + 1000 < SystemClock.uptimeMillis()) {
            lruCache.put(messageKey, Long.valueOf(SystemClock.uptimeMillis()));
            block.invoke(f235387a);
        }
    }

    public final void a(@NotNull String tag, @NotNull Function0<String> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (QLog.isColorLevel()) {
            d().d(tag, 2, block.invoke());
        }
    }

    public final void b(@NotNull String tag, @NotNull Function0<String> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (QLog.isDevelopLevel()) {
            Log.d(tag, block.invoke());
        }
    }

    public final boolean c() {
        return debugSwitch;
    }

    @NotNull
    public final a d() {
        return logger;
    }

    public final void e(@NotNull String tag, @NotNull Function0<String> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        d().i(tag, 1, block.invoke());
    }

    public final void f(boolean fail, @NotNull String tag, @NotNull Function0<String> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        if (fail) {
            d().e(tag, 1, block.invoke(), null);
        } else {
            d().i(tag, 1, block.invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Function1<Logger, Unit> j(@NotNull Function1<? super Logger, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action;
    }

    public final void l(@NotNull final Function1<? super Logger, Unit> function1, @NotNull String messageKey) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(messageKey, "messageKey");
        k(messageKey, new Function1<Logger, Unit>() { // from class: com.tencent.mobileqq.guild.util.Logger$withRateLimit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Logger logger2) {
                invoke2(logger2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Logger rateLimitInvoke) {
                Intrinsics.checkNotNullParameter(rateLimitInvoke, "$this$rateLimitInvoke");
                function1.invoke(Logger.f235387a);
            }
        });
    }
}
