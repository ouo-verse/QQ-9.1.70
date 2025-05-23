package ou3;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lou3/a;", "", "", "frameTimeNanos", "", "firstFrame", "", "e", "", "c", "a", "d", "b", "J", "lastFrameUpdateTime", "startFrameTime", "", "[J", "lastThreeFrameTimeRecords", "I", "totalFrameCount", "jankCount", "f", "bigJankCount", "g", "totalJankNanoTime", "<init>", "()V", h.F, "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastFrameUpdateTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long startFrameTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long[] lastThreeFrameTimeRecords = new long[3];

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int totalFrameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int jankCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int bigJankCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long totalJankNanoTime;

    /* renamed from: a, reason: from getter */
    public final int getBigJankCount() {
        return this.bigJankCount;
    }

    public final long b() {
        return TimeUnit.NANOSECONDS.toMillis(this.lastFrameUpdateTime - this.startFrameTime);
    }

    /* renamed from: c, reason: from getter */
    public final int getJankCount() {
        return this.jankCount;
    }

    public final long d() {
        return TimeUnit.NANOSECONDS.toSeconds(this.totalJankNanoTime);
    }

    public final void e(long frameTimeNanos, boolean firstFrame) {
        long j3 = 0;
        if (firstFrame) {
            this.lastThreeFrameTimeRecords = new long[3];
            this.totalFrameCount = 0;
            this.startFrameTime = frameTimeNanos;
            this.jankCount = 0;
            this.bigJankCount = 0;
            this.totalJankNanoTime = 0L;
        } else {
            long j16 = frameTimeNanos - this.lastFrameUpdateTime;
            if (this.totalFrameCount >= 3 && j16 > 83333332) {
                for (int i3 = 0; i3 < 3; i3++) {
                    j3 += this.lastThreeFrameTimeRecords[i3];
                }
                if (j16 > (j3 / 3) * 2) {
                    this.jankCount++;
                    if (j16 > 124999998) {
                        this.bigJankCount++;
                    }
                    this.totalJankNanoTime += j16;
                    QMLog.d("JankStatics", "jankCount=" + this.jankCount + ", bigJankCount=" + this.bigJankCount + ", time=" + TimeUnit.NANOSECONDS.toSeconds(frameTimeNanos - this.startFrameTime) + ", totalJankSecond=" + d());
                }
            }
            int i16 = this.totalFrameCount;
            this.lastThreeFrameTimeRecords[i16 % 3] = j16;
            this.totalFrameCount = i16 + 1;
        }
        this.lastFrameUpdateTime = frameTimeNanos;
    }
}
