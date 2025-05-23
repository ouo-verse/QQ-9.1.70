package com.tencent.mobileqq.perf.memory.gc;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.perf.memory.gc.a;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/gc/c;", "", "", "e", "", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "d", "c", "Lcom/tencent/mobileqq/perf/memory/gc/c$a;", "b", "Lcom/tencent/mobileqq/perf/memory/gc/c$a;", "preRecordItem", "Z", "isTestStart", "Landroid/os/Handler;", "Landroid/os/Handler;", "loopHandler", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f257747a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile a preRecordItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isTestStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler loopHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/gc/c$a;", "", "", "toString", "Lcom/tencent/mobileqq/perf/memory/gc/a$a;", "a", "Lcom/tencent/mobileqq/perf/memory/gc/a$a;", "()Lcom/tencent/mobileqq/perf/memory/gc/a$a;", "info", "", "b", "J", "()J", "time", "", "c", "Z", "isBackground", "()Z", "<init>", "(Lcom/tencent/mobileqq/perf/memory/gc/a$a;JZ)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a.C8202a info;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long time;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isBackground;

        public a(@NotNull a.C8202a info, long j3, boolean z16) {
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, info, Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            this.info = info;
            this.time = j3;
            this.isBackground = z16;
        }

        @NotNull
        public final a.C8202a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a.C8202a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.time;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(super.toString());
            sb5.append(" info=" + this.info);
            sb5.append(" time=" + this.time);
            sb5.append(" isBackground=" + this.isBackground);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f257747a = new c();
            loopHandler = new Handler(QQPerfHandlerThreadManager.INSTANCE.d().getLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.perf.memory.gc.b
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean b16;
                    b16 = c.b(message);
                    return b16;
                }
            });
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 112345) {
            f257747a.e();
            return true;
        }
        return false;
    }

    private final void d(boolean isTest) {
        if (isTestStart && !isTest) {
            QLog.w("GcMonitor", 1, "recordGcInfoInner jump for test");
            return;
        }
        a aVar = preRecordItem;
        if (aVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long b16 = currentTimeMillis - aVar.b();
            if (!isTest && b16 < MiniBoxNoticeInfo.MIN_5) {
                return;
            }
            com.tencent.mobileqq.perf.memory.gc.a aVar2 = com.tencent.mobileqq.perf.memory.gc.a.f257735a;
            a.C8202a c16 = aVar2.c();
            boolean z16 = !SceneTracker.j();
            a.C8202a e16 = aVar2.e(aVar.a(), c16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" info=" + e16);
            sb5.append(" timeDis=" + b16);
            sb5.append(" currentIsBackground=" + z16);
            if (isTest) {
                QLog.i("GcMonitor_Test", 1, sb5.toString());
            } else {
                QLog.i("GcMonitor", 1, sb5.toString());
            }
            preRecordItem = new a(c16, currentTimeMillis, z16);
            return;
        }
        preRecordItem = new a(com.tencent.mobileqq.perf.memory.gc.a.f257735a.c(), System.currentTimeMillis(), true ^ SceneTracker.j());
    }

    private final void e() {
        d(true);
        MemoryUtil.b();
        if (isTestStart) {
            loopHandler.sendEmptyMessageDelayed(112345, 10000L);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            d(false);
        }
    }
}
