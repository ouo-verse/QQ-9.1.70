package com.tencent.thread.monitor.plugin.manager;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0001J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/FutureTaskParser;", "", "()V", "INNER_CALLABLE_NAME", "", "QUEUE_FUTURE_NAME", "SCHEDULE_FUTURE_NAME", "TAG", "callableField", "Ljava/lang/reflect/Field;", "queueingFutureTaskField", "runnableAdapterTaskField", "getOriginal", "runnable", "Ljava/lang/Runnable;", "getOriginalFromInvokeWrapper", "getOriginalFromScheduleWrapper", "getOriginalFromSubmitWrapper", "initField", "targetClass", "Ljava/lang/Class;", "fieldName", PushClientConstants.TAG_CLASS_NAME, "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class FutureTaskParser {
    static IPatchRedirector $redirector_ = null;
    private static final String INNER_CALLABLE_NAME = "java.util.concurrent.Executors$RunnableAdapter";
    public static final FutureTaskParser INSTANCE;
    private static final String QUEUE_FUTURE_NAME = "java.util.concurrent.ExecutorCompletionService$QueueingFuture";
    private static final String SCHEDULE_FUTURE_NAME = "java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask";
    private static final String TAG = "ThreadProxy_plugin";
    private static Field callableField;
    private static Field queueingFutureTaskField;
    private static Field runnableAdapterTaskField;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8127);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        FutureTaskParser futureTaskParser = new FutureTaskParser();
        INSTANCE = futureTaskParser;
        callableField = futureTaskParser.initField(FutureTask.class, "callable");
        runnableAdapterTaskField = futureTaskParser.initField(INNER_CALLABLE_NAME, "task");
        queueingFutureTaskField = futureTaskParser.initField(QUEUE_FUTURE_NAME, "task");
    }

    FutureTaskParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    private final Object getOriginalFromInvokeWrapper(Object runnable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (Intrinsics.areEqual(runnable.getClass().getName(), QUEUE_FUTURE_NAME)) {
                if (queueingFutureTaskField == null) {
                    queueingFutureTaskField = initField(QUEUE_FUTURE_NAME, "task");
                }
                Field field = queueingFutureTaskField;
                if (field == null) {
                    return null;
                }
                return field.get(runnable);
            }
            return runnable;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                return null;
            }
            return m476constructorimpl;
        }
    }

    private final Object getOriginalFromScheduleWrapper(Object runnable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (Intrinsics.areEqual(runnable.getClass().getName(), SCHEDULE_FUTURE_NAME)) {
                return getOriginalFromSubmitWrapper(runnable);
            }
            return runnable;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                return null;
            }
            return m476constructorimpl;
        }
    }

    private final Field initField(Class<?> targetClass, String fieldName) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = targetClass.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            m476constructorimpl = Result.m476constructorimpl(declaredField);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (Field) m476constructorimpl;
    }

    @Nullable
    public final Object getOriginal(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!(runnable instanceof FutureTask)) {
                ProxyController proxyController = ProxyController.INSTANCE;
                if (proxyController.getDebugMode()) {
                    proxyController.getLogger().d("ThreadProxy_plugin", "getOriginal, is runnable, " + runnable);
                }
                return runnable;
            }
            ProxyController proxyController2 = ProxyController.INSTANCE;
            if (proxyController2.getDebugMode()) {
                proxyController2.getLogger().d("ThreadProxy_plugin", "getOriginal, origin: " + runnable);
            }
            Object originalFromScheduleWrapper = getOriginalFromScheduleWrapper(runnable);
            if (originalFromScheduleWrapper != null) {
                Object originalFromInvokeWrapper = getOriginalFromInvokeWrapper(originalFromScheduleWrapper);
                if (originalFromInvokeWrapper != null) {
                    Object originalFromSubmitWrapper = getOriginalFromSubmitWrapper(originalFromInvokeWrapper);
                    if (originalFromSubmitWrapper != null) {
                        return originalFromSubmitWrapper;
                    }
                    if (proxyController2.getDebugMode()) {
                        proxyController2.getLogger().d("ThreadProxy_plugin", "getOriginal, fromSubmitWrapper fail");
                    }
                    return null;
                }
                if (proxyController2.getDebugMode()) {
                    proxyController2.getLogger().d("ThreadProxy_plugin", "getOriginal, fromInvokeWrapper fail");
                }
                return null;
            }
            if (proxyController2.getDebugMode()) {
                proxyController2.getLogger().d("ThreadProxy_plugin", "getOriginal, fromScheduleWrapper fail");
            }
            return null;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                return null;
            }
            return m476constructorimpl;
        }
    }

    @Nullable
    public final Object getOriginalFromSubmitWrapper(@NotNull Object runnable) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!(runnable instanceof FutureTask)) {
                return runnable;
            }
            Field field = callableField;
            if (field != null) {
                obj = field.get(runnable);
            } else {
                obj = null;
            }
            Callable callable = (Callable) obj;
            if (callable == null) {
                return null;
            }
            if (Intrinsics.areEqual(callable.getClass().getName(), INNER_CALLABLE_NAME)) {
                Field field2 = runnableAdapterTaskField;
                if (field2 == null) {
                    return null;
                }
                return field2.get(callable);
            }
            return callable;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                return null;
            }
            return m476constructorimpl;
        }
    }

    private final Field initField(String className, String fieldName) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = Class.forName(className).getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            m476constructorimpl = Result.m476constructorimpl(declaredField);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (Field) m476constructorimpl;
    }
}
