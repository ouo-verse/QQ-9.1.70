package com.tencent.state.square.media.extractor;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.SquarePlayerReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/extractor/MediaCoverReportListener;", "Lcom/tencent/state/square/media/extractor/MediaCoverListener;", "()V", "reporter", "Lcom/tencent/state/square/media/extractor/MediaCoverReportListener$Reporter;", "time", "", "getTime", "()J", "setTime", "(J)V", "onComposeDone", "", "onComposeStart", "onError", "code", "", "msg", "", "onExtractDone", "onGetFrameDone", "onGetFrameStart", "onInitDone", "onStart", "Reporter", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class MediaCoverReportListener implements MediaCoverListener {
    private final Reporter reporter = new Reporter();
    private long time;

    public final long getTime() {
        return this.time;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onComposeDone() {
        this.reporter.recordComposeCostTime(System.nanoTime() - this.time);
        this.time = 0L;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onComposeStart() {
        this.time = System.nanoTime();
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onError(int code, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.reporter.onError(code, msg2);
        this.time = 0L;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onExtractDone() {
        this.reporter.doReport();
        this.time = 0L;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onGetFrameDone() {
        this.reporter.recordGetFrameCostTime(System.nanoTime() - this.time);
        this.time = 0L;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onGetFrameStart() {
        this.time = System.nanoTime();
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onInitDone() {
        this.reporter.recordInitExtractorCostTime(System.nanoTime() - this.time);
        this.time = 0L;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void onStart() {
        long nanoTime = System.nanoTime();
        this.time = nanoTime;
        this.reporter.recordStartTime(nanoTime);
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/media/extractor/MediaCoverReportListener$Reporter;", "", "()V", "composeCostTime", "", "Ljava/lang/Long;", "errorCode", "", "getFrameCostTime", "initExtractorCostTime", "startTime", "doReport", "", "onError", "message", "", "recordComposeCostTime", "time", "recordGetFrameCostTime", "recordInitExtractorCostTime", "recordStartTime", "reset", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Reporter {
        private static final String TAG = "MediaCoverExtractor-Reporter";
        private static final int TIME = 1000000;
        private Long composeCostTime;
        private int errorCode;
        private Long getFrameCostTime;
        private Long initExtractorCostTime;
        private long startTime;

        public final void doReport() {
            Map<String, Object> mutableMapOf;
            if (this.startTime == 0) {
                return;
            }
            long nanoTime = (System.nanoTime() - this.startTime) / 1000000;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("error_code", String.valueOf(this.errorCode)), TuplesKt.to(SquarePlayerReportConst.PARAM_EXTRACT_COST_TIME, String.valueOf(nanoTime)));
            Long l3 = this.getFrameCostTime;
            if (l3 != null) {
                mutableMapOf.put(SquarePlayerReportConst.PARAM_GET_COVER_FRAME_COST_TIME, String.valueOf(l3.longValue()));
            }
            Long l16 = this.composeCostTime;
            if (l16 != null) {
                mutableMapOf.put(SquarePlayerReportConst.PARAM_COMPOST_COVER_COST_TIME, String.valueOf(l16.longValue()));
            }
            Long l17 = this.initExtractorCostTime;
            if (l17 != null) {
                mutableMapOf.put(SquarePlayerReportConst.PARAM_INIT_EXTRACT_COST_TIME, String.valueOf(l17.longValue()));
            }
            SquareBase.INSTANCE.getConfig().getReporter().reportEvent(SquarePlayerReportConst.EVENT_SQUARE_COVER_EXTRACT, mutableMapOf);
            reset();
            SquareBaseKt.getSquareLog().i(TAG, "doReport cost " + nanoTime);
        }

        public final void onError(int errorCode, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.errorCode = errorCode;
        }

        public final void recordInitExtractorCostTime(long time) {
            this.initExtractorCostTime = Long.valueOf(time);
        }

        public final void recordStartTime(long time) {
            this.startTime = time;
        }

        private final void reset() {
            this.startTime = 0L;
            this.getFrameCostTime = null;
            this.composeCostTime = null;
            this.errorCode = 0;
        }

        public static /* synthetic */ void onError$default(Reporter reporter, int i3, String str, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                str = "";
            }
            reporter.onError(i3, str);
        }

        public final void recordComposeCostTime(long time) {
            this.composeCostTime = Long.valueOf(time / 1000000);
        }

        public final void recordGetFrameCostTime(long time) {
            this.getFrameCostTime = Long.valueOf(time / 1000000);
        }
    }
}
