package iq;

import android.os.SystemClock;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Liq/f;", "", "", "a", "J", "b", "()J", "c", "(J)V", "prevOutputPTSUs", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile long prevOutputPTSUs;

    public final long a() {
        return SystemClock.elapsedRealtimeNanos() / 1000;
    }

    /* renamed from: b, reason: from getter */
    public final long getPrevOutputPTSUs() {
        return this.prevOutputPTSUs;
    }

    public final void c(long j3) {
        this.prevOutputPTSUs = j3;
    }
}
