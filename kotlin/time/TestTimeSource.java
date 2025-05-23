package kotlin.time;

import com.tencent.mobileqq.msf.core.auth.k;
import kotlin.Metadata;
import kotlin.SinceKotlin;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", k.f247491e, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
/* loaded from: classes28.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1959overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + ((Object) Duration.m1875toStringimpl(duration)) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1960plusAssignLRDsOJo(long duration) {
        long j3;
        long m1872toLongimpl = Duration.m1872toLongimpl(duration, getUnit());
        if (m1872toLongimpl != Long.MIN_VALUE && m1872toLongimpl != Long.MAX_VALUE) {
            long j16 = this.reading;
            j3 = j16 + m1872toLongimpl;
            if ((m1872toLongimpl ^ j16) >= 0 && (j16 ^ j3) < 0) {
                m1959overflowLRDsOJo(duration);
            }
        } else {
            double m1869toDoubleimpl = this.reading + Duration.m1869toDoubleimpl(duration, getUnit());
            if (m1869toDoubleimpl > 9.223372036854776E18d || m1869toDoubleimpl < -9.223372036854776E18d) {
                m1959overflowLRDsOJo(duration);
            }
            j3 = (long) m1869toDoubleimpl;
        }
        this.reading = j3;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }
}
