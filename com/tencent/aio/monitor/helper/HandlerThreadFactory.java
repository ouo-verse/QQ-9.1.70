package com.tencent.aio.monitor.helper;

import android.os.Handler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\tB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/monitor/helper/HandlerThreadFactory;", "", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "()Landroid/os/Handler;", "mSamplerHandler", "<init>", "()V", "MonitorThread", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class HandlerThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler mSamplerHandler;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final HandlerThreadFactory f69415b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$MonitorThread;", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "", "name", "<init>", "(Ljava/lang/String;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class MonitorThread extends BaseHandlerThread {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler mHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MonitorThread(@NotNull String name) {
            super("Monitor-" + name);
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
            } else {
                start();
                this.mHandler = new Handler(getLooper());
            }
        }

        @NotNull
        public final Handler getMHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (Handler) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.mHandler;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$a;", "", "Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$MonitorThread;", "a", "Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$MonitorThread;", "()Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$MonitorThread;", "setMSamplerThread", "(Lcom/tencent/aio/monitor/helper/HandlerThreadFactory$MonitorThread;)V", "mSamplerThread", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static MonitorThread mSamplerThread;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final a f69418b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45432);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f69418b = new a();
                mSamplerThread = new MonitorThread("Sampler");
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @NotNull
        public final MonitorThread a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (MonitorThread) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return mSamplerThread;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f69415b = new HandlerThreadFactory();
            mSamplerHandler = a.f69418b.a().getMHandler();
        }
    }

    HandlerThreadFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @NotNull
    public final Handler a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Handler) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return mSamplerHandler;
    }
}
