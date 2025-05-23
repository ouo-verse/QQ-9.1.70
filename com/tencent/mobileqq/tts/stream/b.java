package com.tencent.mobileqq.tts.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0007R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/tts/stream/b;", "", "", "e", "Ljava/io/InputStream;", "stream", "isLast", "", "c", "d", "b", "", "f", "a", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/util/concurrent/LinkedBlockingQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Z", "endOfStream", AudioContext.State.CLOSED, "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "enqueueCount", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedBlockingQueue<InputStream> queue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean endOfStream;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean closed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger enqueueCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/tts/stream/b$a;", "", "", "CAPACITY", "I", "", "TAG", "Ljava/lang/String;", "", "TIMEOUT", "J", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tts.stream.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.queue = new LinkedBlockingQueue<>(5);
            this.enqueueCount = new AtomicInteger(0);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.closed = true;
        while (!this.queue.isEmpty()) {
            InputStream poll = this.queue.poll();
            if (poll != null) {
                poll.close();
            }
        }
    }

    @Nullable
    public final InputStream b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InputStream) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.closed) {
            if (QLog.isDevelopLevel()) {
                QLog.d("InputStreamQueue", 4, "[dequeue] queue is closed");
            }
            return null;
        }
        if (!this.queue.isEmpty()) {
            return this.queue.take();
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (this.queue.isEmpty() && !this.closed && !this.endOfStream) {
            InputStream poll = this.queue.poll(100L, TimeUnit.MILLISECONDS);
            if (poll != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("InputStreamQueue", 4, "[dequeue] success, stream=" + poll + " time=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                return poll;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("InputStreamQueue", 4, "[dequeue] end, closed=" + this.closed + ", endOfStream=" + this.endOfStream);
        }
        return null;
    }

    public final void c(@NotNull InputStream stream, boolean isLast) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, stream, Boolean.valueOf(isLast));
            return;
        }
        Intrinsics.checkNotNullParameter(stream, "stream");
        if (this.endOfStream) {
            QLog.w("InputStreamQueue", 1, "[enqueue] stream is end, stream=" + stream + " isLast=" + isLast);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.closed) {
            if (this.queue.offer(stream, 100L, TimeUnit.MILLISECONDS)) {
                this.endOfStream = isLast;
                int incrementAndGet = this.enqueueCount.incrementAndGet();
                if (QLog.isDevelopLevel()) {
                    QLog.d("InputStreamQueue", 4, "[enqueue] success, queueSize=" + f() + " total=" + incrementAndGet + " isLast=" + isLast + " time=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputStreamQueue", 2, "[enqueue] queue is closed, stream=" + stream + " isLast=" + isLast);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.endOfStream = true;
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.closed;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.queue.size();
    }
}
