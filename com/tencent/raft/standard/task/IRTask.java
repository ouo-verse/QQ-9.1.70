package com.tencent.raft.standard.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRTask {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class Priority {
        private static final /* synthetic */ Priority[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Priority MAX_PRIORITY;
        public static final Priority MIN_PRIORITY;
        public static final Priority NORMAL_PRIORITY;
        private int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9612);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Priority priority = new Priority("MIN_PRIORITY", 0, 0);
            MIN_PRIORITY = priority;
            Priority priority2 = new Priority("NORMAL_PRIORITY", 1, 5);
            NORMAL_PRIORITY = priority2;
            Priority priority3 = new Priority("MAX_PRIORITY", 2, 10);
            MAX_PRIORITY = priority3;
            $VALUES = new Priority[]{priority, priority2, priority3};
        }

        Priority(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static Priority valueOf(String str) {
            return (Priority) Enum.valueOf(Priority.class, str);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }

        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class Task implements Runnable {
        static IPatchRedirector $redirector_;
        private final String name;
        private final Priority priority;

        public Task(@NotNull String str, Priority priority) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) priority);
            } else {
                this.name = str;
                this.priority = priority;
            }
        }

        @NotNull
        public final String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.name;
        }

        public final Priority getPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Priority) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.priority;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class TaskType {
        private static final /* synthetic */ TaskType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TaskType IO_TASK;
        public static final TaskType NETWORK_TASK;
        public static final TaskType SIMPLE_TASK;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9643);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TaskType taskType = new TaskType("SIMPLE_TASK", 0);
            SIMPLE_TASK = taskType;
            TaskType taskType2 = new TaskType("NETWORK_TASK", 1);
            NETWORK_TASK = taskType2;
            TaskType taskType3 = new TaskType("IO_TASK", 2);
            IO_TASK = taskType3;
            $VALUES = new TaskType[]{taskType, taskType2, taskType3};
        }

        TaskType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TaskType valueOf(String str) {
            return (TaskType) Enum.valueOf(TaskType.class, str);
        }

        public static TaskType[] values() {
            return (TaskType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class WeakReferenceTask<T> extends Task {
        static IPatchRedirector $redirector_;
        private WeakReference<T> weakRef;

        public WeakReferenceTask(T t16, @NotNull String str, Priority priority) {
            super(str, priority);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, t16, str, priority);
            } else if (t16 != null) {
                this.weakRef = new WeakReference<>(t16);
            }
        }

        @Nullable
        public final T getRef() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (T) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            WeakReference<T> weakReference = this.weakRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
    }

    void startTask(@NotNull TaskType taskType, @NotNull Task task);
}
