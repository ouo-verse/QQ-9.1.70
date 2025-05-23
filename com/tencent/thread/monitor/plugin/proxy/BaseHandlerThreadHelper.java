package com.tencent.thread.monitor.plugin.proxy;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper;", "", "()V", "Companion", "IBaseHandlerThreadListener", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class BaseHandlerThreadHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    @Nullable
    private static IBaseHandlerThreadListener listener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$Companion;", "", "()V", "listener", "Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$IBaseHandlerThreadListener;", "getListener$annotations", "getListener", "()Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$IBaseHandlerThreadListener;", "setListener", "(Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$IBaseHandlerThreadListener;)V", "callBeforeHandlerThreadStart", "", MosaicConstants$JsProperty.PROP_THREAD, "Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThread;", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @JvmStatic
        public final void callBeforeHandlerThreadStart(@NotNull BaseHandlerThread thread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) thread);
                return;
            }
            Intrinsics.checkNotNullParameter(thread, "thread");
            IBaseHandlerThreadListener listener = getListener();
            if (listener != null) {
                listener.beforeHandlerThreadStart(thread.getId());
            }
        }

        @Nullable
        public final IBaseHandlerThreadListener getListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return BaseHandlerThreadHelper.listener;
            }
            return (IBaseHandlerThreadListener) iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public final void setListener(@Nullable IBaseHandlerThreadListener iBaseHandlerThreadListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                BaseHandlerThreadHelper.listener = iBaseHandlerThreadListener;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iBaseHandlerThreadListener);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public static /* synthetic */ void getListener$annotations() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThreadHelper$IBaseHandlerThreadListener;", "", "beforeHandlerThreadStart", "", "tid", "", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface IBaseHandlerThreadListener {
        void beforeHandlerThreadStart(long tid);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8637);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseHandlerThreadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void callBeforeHandlerThreadStart(@NotNull BaseHandlerThread baseHandlerThread) {
        INSTANCE.callBeforeHandlerThreadStart(baseHandlerThread);
    }

    @Nullable
    public static final IBaseHandlerThreadListener getListener() {
        return listener;
    }

    public static final void setListener(@Nullable IBaseHandlerThreadListener iBaseHandlerThreadListener) {
        listener = iBaseHandlerThreadListener;
    }
}
