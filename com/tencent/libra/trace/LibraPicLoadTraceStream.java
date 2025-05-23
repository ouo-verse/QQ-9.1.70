package com.tencent.libra.trace;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.richframework.tracer.RFWTraceStream;
import com.tencent.richframework.tracer.RFWTraceStreamResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/libra/trace/LibraPicLoadTraceStream;", "Lcom/tencent/richframework/tracer/RFWTraceStream;", "Lcom/tencent/richframework/tracer/RFWTraceStream$IStreamResultHandler;", "seq", "", "(I)V", "generateSessionId", "", "getSessionLog", "onStreamFinish", "", "streamResult", "Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "recycle", "Companion", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraPicLoadTraceStream extends RFWTraceStream implements RFWTraceStream.IStreamResultHandler {
    private static final int MAX_POOL_SIZE = 20;
    private static LibraPicLoadTraceStream mNext;
    private static LibraPicLoadTraceStream sPool;
    private static int sPoolSize;
    private int seq;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Object sPoolSync = new Object();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/libra/trace/LibraPicLoadTraceStream$Companion;", "", "()V", "MAX_POOL_SIZE", "", "mNext", "Lcom/tencent/libra/trace/LibraPicLoadTraceStream;", "sPool", "sPoolSize", "sPoolSync", "obtain", "seq", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final LibraPicLoadTraceStream obtain(int seq) {
            synchronized (LibraPicLoadTraceStream.sPoolSync) {
                LibraPicLoadTraceStream libraPicLoadTraceStream = LibraPicLoadTraceStream.sPool;
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (libraPicLoadTraceStream != null) {
                    libraPicLoadTraceStream.seq = seq;
                    LibraPicLoadTraceStream.sPool = LibraPicLoadTraceStream.mNext;
                    LibraPicLoadTraceStream.mNext = null;
                    LibraPicLoadTraceStream.sPoolSize--;
                    return libraPicLoadTraceStream;
                }
                return new LibraPicLoadTraceStream(seq, defaultConstructorMarker);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    LibraPicLoadTraceStream(int i3) {
        super("LibraPicLoader");
        this.seq = i3;
        getConfig().enableLog(true);
        addNode(LibraTraceConst.Node.IMAGE_LOAD_START, "\u5f00\u59cb\u52a0\u8f7d");
        addNode(LibraTraceConst.Node.IMAGE_DOWNLOADING, "\u4e0b\u8f7d\u4e2d");
        addNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_URL_ILLEGAL, "\u4e0b\u8f7durl\u975e\u6cd5");
        addNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_FAILED, "\u4e0b\u8f7d\u5931\u8d25");
        addNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_SUCCESS, "\u4e0b\u8f7d\u6210\u529f");
        addNode("decoding", "\u89e3\u7801\u4e2d");
        addNode(LibraTraceConst.Node.IMAGE_DECODE_FAILED, ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_NEXT_TASK_DESC);
        addNode(LibraTraceConst.Node.IMAGE_LOAD_CANCEL, "\u53d6\u6d88\u52a0\u8f7d");
        addNode(LibraTraceConst.Node.IMAGE_LOAD_SUCCESS, "\u52a0\u8f7d\u6210\u529f");
        addNode(LibraTraceConst.Node.IMAGE_LOAD_END, "\u52a0\u8f7d\u7ed3\u675f");
        addStreamResultHandler(this);
    }

    @JvmStatic
    @NotNull
    public static final LibraPicLoadTraceStream obtain(int i3) {
        return INSTANCE.obtain(i3);
    }

    private final void recycle() {
        reset();
        synchronized (sPoolSync) {
            int i3 = sPoolSize;
            if (i3 < 20) {
                mNext = sPool;
                sPool = this;
                sPoolSize = i3 + 1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.richframework.tracer.RFWTraceStream
    @NotNull
    public String generateSessionId() {
        return String.valueOf(this.seq);
    }

    @Override // com.tencent.richframework.tracer.RFWTraceStream
    @NotNull
    public String getSessionLog() {
        return LibraLogUtil.INSTANCE.getSeqLog(this.seq);
    }

    @Override // com.tencent.richframework.tracer.RFWTraceStream.IStreamResultHandler
    public void onStreamFinish(@NotNull RFWTraceStreamResult streamResult) {
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        recycle();
    }

    public /* synthetic */ LibraPicLoadTraceStream(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }
}
