package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.leba.feed.FeedPluginDataManager;
import com.tencent.mobileqq.leba.list.ListPluginDataManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/leba/core/b;", "", "", "style", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "b", "a", "from", "", "reason", "", "c", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "pluginDataManager", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f240364a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile BasePluginDataManager pluginDataManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantLock lock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f240364a = new b();
            lock = new ReentrantLock();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final BasePluginDataManager a() {
        return pluginDataManager;
    }

    @JvmStatic
    @NotNull
    public static final BasePluginDataManager b(int style) {
        BasePluginDataManager listPluginDataManager;
        if (style != 1 && style != 2) {
            QLog.e("LebaPluginDataManagerHolder", 1, "getOrCreatePluginDataManager illegal style: " + style);
        }
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            BasePluginDataManager basePluginDataManager = pluginDataManager;
            if (basePluginDataManager != null && basePluginDataManager.g() == style) {
                listPluginDataManager = basePluginDataManager;
            } else {
                if (style == 2) {
                    listPluginDataManager = new FeedPluginDataManager();
                } else {
                    listPluginDataManager = new ListPluginDataManager();
                }
                pluginDataManager = listPluginDataManager;
            }
            reentrantLock.unlock();
            if (!Intrinsics.areEqual(listPluginDataManager, basePluginDataManager) && basePluginDataManager != null) {
                basePluginDataManager.o();
            }
            return listPluginDataManager;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @JvmStatic
    public static final void c(int from, @Nullable String reason) {
        Unit unit;
        BasePluginDataManager a16 = a();
        if (a16 != null) {
            a16.j(from, reason);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("LebaPluginDataManagerHolder", 1, "notifyReloadPluginData BasePluginDataManager is null");
        }
    }
}
