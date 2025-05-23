package com.tencent.mobileqq.log;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u0010\bB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/log/a;", "", "", "tag", "message", "", "throwable", "", "b", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "messageWithTimestamp", "Lcom/tencent/mobileqq/log/a$a;", "c", "Lcom/tencent/mobileqq/log/a$a;", "a", "()Lcom/tencent/mobileqq/log/a$a;", "setLogger", "(Lcom/tencent/mobileqq/log/a$a;)V", "logger", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f241755a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Long> messageWithTimestamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static InterfaceC7984a logger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/log/a$a;", "", "", "tag", "", "level", "msg", "", "d", "", ReportConstant.COSTREPORT_TRANS, "e", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.log.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7984a {
        void d(@NotNull String tag, int level, @NotNull String msg2);

        void e(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/log/a$b;", "", "", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "logs", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> logs;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.logs = new ArrayList();
            }
        }

        @NotNull
        public final List<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.logs;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/log/a$c", "Lcom/tencent/mobileqq/log/a$a;", "", "tag", "", "level", "msg", "", "d", "", ReportConstant.COSTREPORT_TRANS, "e", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements InterfaceC7984a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.log.a.InterfaceC7984a
        public void d(@NotNull String tag, int level, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, tag, Integer.valueOf(level), msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, level, msg2);
        }

        @Override // com.tencent.mobileqq.log.a.InterfaceC7984a
        public void e(@NotNull String tag, int level, @NotNull String msg2, @Nullable Throwable tr5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, tag, Integer.valueOf(level), msg2, tr5);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, level, msg2, tr5);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39349);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        f241755a = new a();
        messageWithTimestamp = new LruCache<>(16);
        logger = new c();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        aVar.b(str, str2, th5);
    }

    @NotNull
    public final InterfaceC7984a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (InterfaceC7984a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return logger;
    }

    public final void b(@NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, tag, message, throwable);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        String str = tag + ":" + message;
        LruCache<String, Long> lruCache = messageWithTimestamp;
        Long l3 = lruCache.get(str);
        if (l3 == null || l3.longValue() + 1000 < SystemClock.uptimeMillis()) {
            lruCache.put(str, Long.valueOf(SystemClock.uptimeMillis()));
            b bVar = new b();
            bVar.a().add(message);
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                f241755a.a().e(tag, 1, (String) it.next(), throwable);
            }
        }
    }
}
