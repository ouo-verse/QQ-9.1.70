package com.tencent.thread.monitor.plugin.proxy;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import java.lang.reflect.Field;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseTimer;", "Ljava/util/Timer;", "()V", "isDaemon", "", "(Z)V", "name", "", "(Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "timerThreadId", "", "cancel", "", "init", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class BaseTimer extends Timer {
    static IPatchRedirector $redirector_;
    private long timerThreadId;

    public BaseTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.timerThreadId = -1L;
            init();
        }
    }

    private final void init() {
        if (!ProxyController.INSTANCE.getEnabled()) {
            return;
        }
        boolean z16 = false;
        for (Class<?> cls = getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field field = cls.getDeclaredField(MosaicConstants$JsProperty.PROP_THREAD);
                Intrinsics.checkNotNullExpressionValue(field, "field");
                field.setAccessible(true);
                Object obj = field.get(this);
                if ((obj instanceof Thread) && ((Thread) obj).isAlive()) {
                    try {
                        long id5 = ((Thread) obj).getId();
                        this.timerThreadId = id5;
                        ProxyManager.getOrPutThreadInfo(id5).update((Thread) obj);
                    } catch (Exception unused) {
                    }
                    z16 = true;
                }
            } catch (Exception unused2) {
            }
        }
        if (!z16) {
            ProxyController.INSTANCE.getLogger().e(ProxyManager.TAG, "proxy timer fail, " + getClass().getName());
        }
    }

    @Override // java.util.Timer
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (this.timerThreadId != -1 && ProxyController.INSTANCE.getEnabled()) {
            ProxyManager.removeThreadInfo(this.timerThreadId);
        }
        super.cancel();
    }

    public BaseTimer(boolean z16) {
        super(z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.timerThreadId = -1L;
            init();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTimer(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) name);
        } else {
            this.timerThreadId = -1L;
            init();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTimer(@NotNull String name, boolean z16) {
        super(name, z16);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, name, Boolean.valueOf(z16));
        } else {
            this.timerThreadId = -1L;
            init();
        }
    }
}
