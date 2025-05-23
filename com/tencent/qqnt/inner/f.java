package com.tencent.qqnt.inner;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010!\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0006j\u0002`\u001f0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/inner/f;", "", "", "d", "", "g", "Lkotlin/Function0;", "task", tl.h.F, "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "b", "configID", "", "c", "J", "delayTime", "Ljava/lang/Boolean;", "enable", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "f", "Z", "waiting", "", "Lcom/tencent/qqnt/inner/TroopGatherTask;", "Ljava/util/List;", "waitingTask", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "delayTask", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String configID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long delayTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean enable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean waiting;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Function0<Unit>> waitingTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable delayTask;

    public f(@NotNull String tag, @NotNull String configID, long j3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(configID, "configID");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tag, configID, Long.valueOf(j3));
            return;
        }
        this.tag = tag;
        this.configID = configID;
        this.delayTime = j3;
        this.handler = new Handler(ThreadManagerV2.getSubThreadLooper());
        this.waitingTask = new ArrayList();
        this.delayTask = new Runnable() { // from class: com.tencent.qqnt.inner.d
            @Override // java.lang.Runnable
            public final void run() {
                f.e(f.this);
            }
        };
    }

    private final void d() {
        synchronized (this) {
            if (!this.waiting) {
                this.waiting = true;
                this.handler.postDelayed(this.delayTask, this.delayTime);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0) {
            final List<Function0<Unit>> list = this$0.waitingTask;
            this$0.waitingTask = new ArrayList();
            this$0.waiting = false;
            bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.f(list);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List needExecuteTask) {
        Intrinsics.checkNotNullParameter(needExecuteTask, "$needExecuteTask");
        Iterator it = needExecuteTask.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.enable == null) {
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            this.enable = Boolean.valueOf(((IUnitedConfigManager) api).isSwitchOn(this.configID, true));
        }
        Boolean bool = this.enable;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final void h(@NotNull final Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        if (g()) {
            synchronized (this) {
                this.waitingTask.add(task);
                d();
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.c
            @Override // java.lang.Runnable
            public final void run() {
                f.i(Function0.this);
            }
        });
    }
}
