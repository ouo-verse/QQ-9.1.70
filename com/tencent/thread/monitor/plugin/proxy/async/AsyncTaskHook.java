package com.tencent.thread.monitor.plugin.proxy.async;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/async/AsyncTaskHook;", "", "()V", "init", "", "proxyS", "Ljava/util/concurrent/Executor;", ReportConstant.COSTREPORT_PREFIX, "proxyT", "t", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class AsyncTaskHook {
    static IPatchRedirector $redirector_;
    public static final AsyncTaskHook INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9455);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new AsyncTaskHook();
        }
    }

    AsyncTaskHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private final Executor proxyS(Executor s16) {
        Object newProxyInstance = Proxy.newProxyInstance(s16.getClass().getClassLoader(), ExecutorService.class.getInterfaces(), new ProxyAsyncTaskExecutor(s16, 1));
        if (newProxyInstance != null) {
            return (Executor) newProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.Executor");
    }

    private final Executor proxyT(Executor t16) {
        if (t16 instanceof ThreadPoolExecutor) {
            return new ProxyThreadPoolExecutor((ThreadPoolExecutor) t16);
        }
        Object newProxyInstance = Proxy.newProxyInstance(t16.getClass().getClassLoader(), ExecutorService.class.getInterfaces(), new ProxyAsyncTaskExecutor(t16, 0));
        if (newProxyInstance != null) {
            return (Executor) newProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.Executor");
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (!ProxyController.INSTANCE.getEnabled()) {
            return;
        }
        try {
            Executor t16 = AsyncTask.THREAD_POOL_EXECUTOR;
            Executor s16 = AsyncTask.SERIAL_EXECUTOR;
            Field fieldT = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
            Field fieldS = AsyncTask.class.getField("SERIAL_EXECUTOR");
            Field fieldsDE = AsyncTask.class.getDeclaredField("sDefaultExecutor");
            Intrinsics.checkNotNullExpressionValue(fieldsDE, "fieldsDE");
            fieldsDE.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("accessFlags");
            Intrinsics.checkNotNullExpressionValue(modifiersField, "modifiersField");
            modifiersField.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(fieldT, "fieldT");
            modifiersField.setInt(fieldT, fieldT.getModifiers() & (-17));
            Intrinsics.checkNotNullExpressionValue(fieldS, "fieldS");
            modifiersField.setInt(fieldS, fieldS.getModifiers() & (-17));
            Intrinsics.checkNotNullExpressionValue(t16, "t");
            fieldT.set(null, proxyT(t16));
            Intrinsics.checkNotNullExpressionValue(s16, "s");
            Executor proxyS = proxyS(s16);
            fieldS.set(null, proxyS);
            fieldsDE.set(null, proxyS);
        } catch (Exception e16) {
            ProxyController.INSTANCE.getLogger().e(ProxyManager.TAG, "AsyncTaskHook fail", e16);
        }
    }
}
