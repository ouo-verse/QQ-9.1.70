package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager;

import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/h;", "", "Landroid/os/HandlerThread;", "b", "Landroid/os/HandlerThread;", "c", "()Landroid/os/HandlerThread;", "fileThread", "fileReadThread", "d", "a", "decoderThread", "e", "loaderThread", "f", "workThread", "g", "timeLineThread", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f99037a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread fileThread;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread fileReadThread;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread decoderThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread loaderThread;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread workThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HandlerThread timeLineThread;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f99037a = new h();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("dynamic_file");
        fileThread = baseHandlerThread;
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("dynamic_read_file");
        fileReadThread = baseHandlerThread2;
        BaseHandlerThread baseHandlerThread3 = new BaseHandlerThread("dynamic_decoder");
        decoderThread = baseHandlerThread3;
        BaseHandlerThread baseHandlerThread4 = new BaseHandlerThread("dynamic_down_load");
        loaderThread = baseHandlerThread4;
        BaseHandlerThread baseHandlerThread5 = new BaseHandlerThread("dynamic_work");
        workThread = baseHandlerThread5;
        BaseHandlerThread baseHandlerThread6 = new BaseHandlerThread("dynamic_time_line");
        timeLineThread = baseHandlerThread6;
        baseHandlerThread.start();
        baseHandlerThread2.start();
        baseHandlerThread3.start();
        baseHandlerThread4.start();
        baseHandlerThread5.start();
        baseHandlerThread6.start();
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final HandlerThread a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return decoderThread;
    }

    @NotNull
    public final HandlerThread b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return fileReadThread;
    }

    @NotNull
    public final HandlerThread c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return fileThread;
    }

    @NotNull
    public final HandlerThread d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return loaderThread;
    }

    @NotNull
    public final HandlerThread e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return timeLineThread;
    }

    @NotNull
    public final HandlerThread f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HandlerThread) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return workThread;
    }
}
