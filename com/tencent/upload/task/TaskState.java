package com.tencent.upload.task;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmdownloader.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class TaskState {
    private static final /* synthetic */ TaskState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TaskState CANCEL;
    public static final TaskState CONNECTING;
    public static final TaskState FAILED;
    public static final TaskState PAUSE;
    public static final TaskState SENDING;
    public static final TaskState SUCCEED;
    public static final TaskState TIMEOUT;
    public static final TaskState WAITING;
    private int code;
    private String desc;
    private int outState;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        TaskState taskState = new TaskState("WAITING", 0, 0, "\u7b49\u5f85\u4e2d", 0);
        WAITING = taskState;
        TaskState taskState2 = new TaskState(a.CONNTECTSTATE_CONNECTING, 1, 1, "\u8fde\u63a5\u4e2d", 4);
        CONNECTING = taskState2;
        TaskState taskState3 = new TaskState("SENDING", 2, 2, "\u53d1\u9001\u4e2d", 1);
        SENDING = taskState3;
        TaskState taskState4 = new TaskState(Tracker.PAUSE, 3, 3, "\u6682\u505c", 2);
        PAUSE = taskState4;
        TaskState taskState5 = new TaskState("CANCEL", 4, 4, "\u53d6\u6d88", 5);
        CANCEL = taskState5;
        TaskState taskState6 = new TaskState("FAILED", 5, 5, "\u5931\u8d25", -1000);
        FAILED = taskState6;
        TaskState taskState7 = new TaskState("SUCCEED", 6, 6, "\u6210\u529f", 3);
        SUCCEED = taskState7;
        TaskState taskState8 = new TaskState("TIMEOUT", 7, 7, "\u8d85\u65f6", -1000);
        TIMEOUT = taskState8;
        $VALUES = new TaskState[]{taskState, taskState2, taskState3, taskState4, taskState5, taskState6, taskState7, taskState8};
    }

    TaskState(String str, int i3, int i16, String str2, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17));
            return;
        }
        this.code = i16;
        this.desc = str2;
        this.outState = i17;
    }

    public static TaskState getStateFromCode(int i3) {
        for (TaskState taskState : values()) {
            if (taskState.code == i3) {
                return taskState;
            }
        }
        return WAITING;
    }

    public static TaskState valueOf(String str) {
        return (TaskState) Enum.valueOf(TaskState.class, str);
    }

    public static TaskState[] values() {
        return (TaskState[]) $VALUES.clone();
    }

    public int getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.code;
    }

    public String getDesc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.desc;
    }

    public int getOutState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.outState;
    }

    @Override // java.lang.Enum
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "[" + this.code + "," + this.desc + "]";
    }
}
