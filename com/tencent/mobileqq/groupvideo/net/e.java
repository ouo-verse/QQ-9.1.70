package com.tencent.mobileqq.groupvideo.net;

import android.text.TextUtils;
import com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoPSKeyListener;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/net/e;", "", "", "c", "g", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoPSKeyListener;", "listener", "f", h.F, "e", "", "d", "b", "Z", "isInit", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenList", "", "J", "lastPskeyChangeTs", "com/tencent/mobileqq/groupvideo/net/e$a", "Lcom/tencent/mobileqq/groupvideo/net/e$a;", "psKeyChangeListener", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f213814a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<IGroupVideoPSKeyListener> listenList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastPskeyChangeTs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a psKeyChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/groupvideo/net/e$a", "Lsd2/b;", "", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements sd2.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // sd2.b
        public void a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - e.lastPskeyChangeTs > 600000) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("GroupVideoPSKeyHandler", 1, "invoke onPskeyChanged shouldRefresh: " + z16);
            if (z16) {
                e.lastPskeyChangeTs = currentTimeMillis;
                e.f213814a.e();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f213814a = new e();
        listenList = new CopyOnWriteArrayList<>();
        psKeyChangeListener = new a();
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (isInit) {
            return;
        }
        isInit = true;
        String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
        QLog.i("GroupVideoPSKeyHandler", 1, "#init " + currentProcessName);
        if (TextUtils.equals(currentProcessName, "com.tencent.mobileqq")) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026onstant.ALL\n            )");
            ((IPskeyManager) runtimeService).registerPskeyListener(psKeyChangeListener);
            QLog.i("GroupVideoPSKeyHandler", 1, "#init:  registerPskeyListener");
        }
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return listenList.isEmpty();
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<IGroupVideoPSKeyListener> it = listenList.iterator();
        while (it.hasNext()) {
            it.next().onPSKeyChanged(new ArrayList());
        }
    }

    public final void f(@NotNull IGroupVideoPSKeyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<IGroupVideoPSKeyListener> copyOnWriteArrayList = listenList;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!isInit) {
            return;
        }
        isInit = false;
        String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
        QLog.i("GroupVideoPSKeyHandler", 1, "#unInit " + currentProcessName);
        if (TextUtils.equals(currentProcessName, "com.tencent.mobileqq")) {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026onstant.ALL\n            )");
            ((IPskeyManager) runtimeService).unregisterPskeyListener(psKeyChangeListener);
            QLog.i("GroupVideoPSKeyHandler", 1, "#unInit:  unregisterPskeyListener");
        }
    }

    public final void h(@NotNull IGroupVideoPSKeyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<IGroupVideoPSKeyListener> copyOnWriteArrayList = listenList;
        if (copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.remove(listener);
        }
    }
}
