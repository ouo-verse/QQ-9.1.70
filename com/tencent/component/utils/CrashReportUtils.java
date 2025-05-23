package com.tencent.component.utils;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/component/utils/CrashReportUtils;", "", "()V", "Companion", "qq-live-od-adapter-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class CrashReportUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/component/utils/CrashReportUtils$Companion;", "", "()V", "postCatchedException", "", "exception", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "qq-live-od-adapter-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void postCatchedException$default(Companion companion, Throwable th5, Thread thread, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                thread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(thread, "currentThread()");
            }
            companion.postCatchedException(th5, thread);
        }

        @JvmStatic
        @JvmOverloads
        public final void postCatchedException(@NotNull Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            postCatchedException$default(this, exception, null, 2, null);
        }

        Companion() {
        }

        @JvmStatic
        @JvmOverloads
        public final void postCatchedException(@NotNull Throwable exception, @NotNull Thread thread) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(thread, "thread");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void postCatchedException(@NotNull Throwable th5) {
        INSTANCE.postCatchedException(th5);
    }

    @JvmStatic
    @JvmOverloads
    public static final void postCatchedException(@NotNull Throwable th5, @NotNull Thread thread) {
        INSTANCE.postCatchedException(th5, thread);
    }
}
