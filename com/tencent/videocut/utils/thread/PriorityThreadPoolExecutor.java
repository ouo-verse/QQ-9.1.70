package com.tencent.videocut.utils.thread;

import android.annotation.TargetApi;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\t\u0013B#\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "Ljava/lang/Runnable;", "command", "", "execute", "Lcom/tencent/videocut/utils/thread/b;", "priority", "a", "", "poolSize", "", "keepAliveTime", "Ljava/util/concurrent/TimeUnit;", "unit", "<init>", "(IJLjava/util/concurrent/TimeUnit;)V", "e", "PriorityRunnable", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class PriorityThreadPoolExecutor extends BaseThreadPoolExecutor implements ExecutorService {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u00022\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0003:\u0001\u001dB\u0019\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0015\u0010\n\u001a\u00020\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0096\u0002R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor$PriorityRunnable;", "T", "Ljava/lang/Runnable;", "", "another", "", "d", "", TencentLocation.RUN_MODE, "other", "c", "I", "mPriority", "", "e", "Z", "mFifo", "", "f", "J", "mSeqNum", h.F, "Ljava/lang/Runnable;", "mRunnable", "Lcom/tencent/videocut/utils/thread/b;", "p", "<init>", "(Ljava/lang/Runnable;Lcom/tencent/videocut/utils/thread/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class PriorityRunnable<T> implements Runnable, Comparable<PriorityRunnable<?>> {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        private static final AtomicLong f384272i;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mPriority;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean mFifo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long mSeqNum;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final Runnable mRunnable;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor$PriorityRunnable$a;", "", "Ljava/util/concurrent/atomic/AtomicLong;", "SEQ", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.videocut.utils.thread.PriorityThreadPoolExecutor$PriorityRunnable$a, reason: from kotlin metadata */
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11038);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
                f384272i = new AtomicLong(0L);
            }
        }

        public PriorityRunnable(@NotNull Runnable mRunnable, @NotNull b p16) {
            Intrinsics.checkNotNullParameter(mRunnable, "mRunnable");
            Intrinsics.checkNotNullParameter(p16, "p");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mRunnable, (Object) p16);
                return;
            }
            this.mRunnable = mRunnable;
            this.mPriority = p16.b();
            this.mFifo = p16.a();
            this.mSeqNum = f384272i.getAndIncrement();
        }

        private final int d(PriorityRunnable<?> another) {
            int i3;
            long j3 = this.mSeqNum;
            long j16 = another.mSeqNum;
            if (j3 < j16) {
                i3 = -1;
            } else if (j3 > j16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!this.mFifo) {
                return -i3;
            }
            return i3;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull PriorityRunnable<?> other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) other)).intValue();
            }
            Intrinsics.checkNotNullParameter(other, "other");
            int i3 = this.mPriority;
            int i16 = other.mPriority;
            if (i3 > i16) {
                return -1;
            }
            if (i3 < i16) {
                return 1;
            }
            return d(other);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mRunnable.run();
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/videocut/utils/thread/PriorityThreadPoolExecutor$a;", "", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.videocut.utils.thread.PriorityThreadPoolExecutor$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @TargetApi(9)
    public PriorityThreadPoolExecutor(int i3, long j3, @Nullable TimeUnit timeUnit) {
        super(i3, i3, j3, timeUnit, new PriorityBlockingQueue());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Long.valueOf(j3), timeUnit);
        } else if (j3 > 0) {
            allowCoreThreadTimeOut(true);
        }
    }

    public void a(@Nullable Runnable command, @Nullable b priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) command, (Object) priority);
            return;
        }
        command.getClass();
        if (priority == null) {
            priority = b.f384282d;
        }
        super.execute(new PriorityRunnable(command, priority));
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) command);
        } else {
            Intrinsics.checkNotNullParameter(command, "command");
            a(command, null);
        }
    }
}
