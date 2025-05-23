package com.tencent.qqnt.startup.task;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b(\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/startup/task/NtTask;", "Lcom/tencent/qqnt/startup/task/c;", "", "childSizeRunOnMain$nt_startup_kit_release", "()I", "childSizeRunOnMain", "", "onTaskStart", "onTaskFinish", "onWait", "onNotify", "", "toString", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dependencies", "Ljava/util/ArrayList;", "getDependencies", "()Ljava/util/ArrayList;", "setDependencies", "(Ljava/util/ArrayList;)V", "", "childNodes", "Ljava/util/List;", "getChildNodes$nt_startup_kit_release", "()Ljava/util/List;", "setChildNodes$nt_startup_kit_release", "(Ljava/util/List;)V", "Ljava/util/concurrent/CountDownLatch;", "mWaitCountDown$delegate", "Lkotlin/Lazy;", "getMWaitCountDown", "()Ljava/util/concurrent/CountDownLatch;", "mWaitCountDown", "<init>", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class NtTask implements c {
    static IPatchRedirector $redirector_;

    @Nullable
    private List<? extends NtTask> childNodes;

    @NotNull
    private ArrayList<String> dependencies;

    /* renamed from: mWaitCountDown$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWaitCountDown;

    @NotNull
    private String taskId;

    public NtTask() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this);
    }

    private final CountDownLatch getMWaitCountDown() {
        return (CountDownLatch) this.mWaitCountDown.getValue();
    }

    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return c.a.a(this);
    }

    public final int childSizeRunOnMain$nt_startup_kit_release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        List<? extends NtTask> list = this.childNodes;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((NtTask) obj).runOnMainThread()) {
                    arrayList.add(obj);
                }
            }
            return arrayList.size();
        }
        return 0;
    }

    @Nullable
    public final List<NtTask> getChildNodes$nt_startup_kit_release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.childNodes;
    }

    @NotNull
    public final ArrayList<String> getDependencies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dependencies;
    }

    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return c.a.b(this);
    }

    @NotNull
    public final String getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.taskId;
    }

    public void onNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            getMWaitCountDown().countDown();
        }
    }

    public void onTaskFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void onTaskStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void onWait() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            getMWaitCountDown().await();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public boolean runOnMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return c.a.c(this);
    }

    public final void setChildNodes$nt_startup_kit_release(@Nullable List<? extends NtTask> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            this.childNodes = list;
        }
    }

    public final void setDependencies(@NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.dependencies = arrayList;
        }
    }

    public final void setTaskId(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.taskId = str;
        }
    }

    @NotNull
    public String toString() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        String str = this.taskId;
        int size = this.dependencies.size();
        List<? extends NtTask> list = this.childNodes;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        return "taskName: " + str + ", dependencies: " + size + ", childNodes: " + num + ", priority:" + getPriority() + ", runOnMainThread: " + runOnMainThread() + ", blockUntilFinish: " + blockUntilFinish();
    }

    public NtTask(@NotNull String taskId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) taskId);
            return;
        }
        this.taskId = taskId;
        this.dependencies = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CountDownLatch>() { // from class: com.tencent.qqnt.startup.task.NtTask$mWaitCountDown$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtTask.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CountDownLatch invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new CountDownLatch(NtTask.this.getDependencies().size()) : (CountDownLatch) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mWaitCountDown = lazy;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        this.taskId = name;
    }

    public /* synthetic */ NtTask(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
