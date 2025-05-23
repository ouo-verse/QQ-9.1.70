package com.tencent.richframework.tracer;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/richframework/tracer/RFWTracer;", "", "()V", "mStreamMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/richframework/tracer/RFWTraceStream;", "addStream", "", "stream", "findStream", "streamName", "Companion", "trace_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class RFWTracer {
    private ConcurrentHashMap<String, RFWTraceStream> mStreamMap = new ConcurrentHashMap<>();

    public final void addStream(@NotNull RFWTraceStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.mStreamMap.put(stream.getStreamName(), stream);
    }

    @NotNull
    public final RFWTraceStream findStream(@NotNull String streamName) {
        Intrinsics.checkNotNullParameter(streamName, "streamName");
        RFWTraceStream rFWTraceStream = this.mStreamMap.get(streamName);
        if (rFWTraceStream == null) {
            RFWLog.fatal("RFWTracer", RFWLog.USR, new RuntimeException("have no stream in name: " + streamName));
            return new EmptyTraceStream(streamName);
        }
        return rFWTraceStream;
    }
}
