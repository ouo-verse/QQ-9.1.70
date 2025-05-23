package kotlinx.atomicfu;

import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\n\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u000e"}, d2 = {"traceFormatDefault", "Lkotlinx/atomicfu/TraceFormat;", "getTraceFormatDefault", "()Lkotlinx/atomicfu/TraceFormat;", AutoStartMonitor.AutoStartBean.KEY_TRACE, "Lkotlinx/atomicfu/TraceBase;", "size", "", "format", "getSystemProperty", "", "key", "named", "name", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class TraceKt {

    @NotNull
    private static final TraceFormat traceFormatDefault;

    static {
        TraceFormat traceFormat;
        if (getSystemProperty("kotlinx.atomicfu.trace.thread") != null) {
            traceFormat = new TraceFormatThread();
        } else {
            traceFormat = new TraceFormat();
        }
        traceFormatDefault = traceFormat;
    }

    @InlineOnly
    @NotNull
    public static final TraceBase Trace(int i3, @NotNull TraceFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new TraceImpl(i3, format);
    }

    public static /* synthetic */ TraceBase Trace$default(int i3, TraceFormat traceFormat, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 32;
        }
        if ((i16 & 2) != 0) {
            traceFormat = traceFormatDefault;
        }
        return Trace(i3, traceFormat);
    }

    private static final String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    @NotNull
    public static final TraceFormat getTraceFormatDefault() {
        return traceFormatDefault;
    }

    @NotNull
    public static final TraceBase named(@NotNull TraceBase named, @NotNull String name) {
        Intrinsics.checkNotNullParameter(named, "$this$named");
        Intrinsics.checkNotNullParameter(name, "name");
        if (named != TraceBase.None.INSTANCE) {
            return new NamedTrace(named, name);
        }
        return named;
    }
}
