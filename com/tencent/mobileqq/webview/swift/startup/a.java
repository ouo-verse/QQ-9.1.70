package com.tencent.mobileqq.webview.swift.startup;

import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/a;", "Lcom/tencent/mobileqq/app/automator/b$a;", "Ljava/util/concurrent/AbstractExecutorService;", "a", "", "I", "maxRunning", "", "b", "Ljava/lang/String;", "tag", "<init>", "(ILjava/lang/String;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements b.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int maxRunning;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/a$a;", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "", "d", "Ljava/lang/String;", "tag", "Ljava/util/concurrent/atomic/AtomicInteger;", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadNumber", "<init>", "(Ljava/lang/String;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.swift.startup.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static final class ThreadFactoryC8978a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String tag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicInteger threadNumber;

        public ThreadFactoryC8978a(@NotNull String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag);
            } else {
                this.tag = tag;
                this.threadNumber = new AtomicInteger(1);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable r16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r16);
            }
            Intrinsics.checkNotNullParameter(r16, "r");
            BaseThread baseThread = new BaseThread(r16, this.tag + "_" + this.threadNumber.getAndIncrement());
            if (baseThread.getPriority() != 10) {
                baseThread.setPriority(10);
            }
            return baseThread;
        }
    }

    public a(int i3, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) tag);
        } else {
            this.maxRunning = i3;
            this.tag = tag;
        }
    }

    @Override // com.tencent.mobileqq.app.automator.b.a
    @NotNull
    public AbstractExecutorService a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbstractExecutorService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int i3 = this.maxRunning;
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(i3, i3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new ThreadFactoryC8978a(this.tag));
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }
}
