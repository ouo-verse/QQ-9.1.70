package fs;

import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class o<IN, OUT> extends JobSegment<IN, OUT> {

    /* renamed from: d, reason: collision with root package name */
    protected long f400460d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f400461e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f400462f = "Q.qqstory.publish.edit." + getClass().getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment, com.tribe.async.reactive.StreamFunction
    public void call(IN in5) {
        this.f400460d = SystemClock.uptimeMillis();
        super.call(in5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void notifyError(Error error) {
        this.f400461e = SystemClock.uptimeMillis();
        super.notifyError(error);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.reactive.StreamFunction
    public void notifyResult(OUT out) {
        this.f400461e = SystemClock.uptimeMillis();
        super.notifyResult(out);
    }
}
