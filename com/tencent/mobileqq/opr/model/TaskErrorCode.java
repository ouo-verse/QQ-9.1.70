package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "", "(Ljava/lang/String;I)V", "Success", "InputInvalid", "PreDetectFail", "QueueDiscard", "ExecuteError", "CheckSafetyFail", "UnsupportImage", "UploadResultFail", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TaskErrorCode {
    private static final /* synthetic */ TaskErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TaskErrorCode CheckSafetyFail;
    public static final TaskErrorCode ExecuteError;
    public static final TaskErrorCode InputInvalid;
    public static final TaskErrorCode PreDetectFail;
    public static final TaskErrorCode QueueDiscard;
    public static final TaskErrorCode Success;
    public static final TaskErrorCode UnsupportImage;
    public static final TaskErrorCode UploadResultFail;

    private static final /* synthetic */ TaskErrorCode[] $values() {
        return new TaskErrorCode[]{Success, InputInvalid, PreDetectFail, QueueDiscard, ExecuteError, CheckSafetyFail, UnsupportImage, UploadResultFail};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Success = new TaskErrorCode("Success", 0);
        InputInvalid = new TaskErrorCode("InputInvalid", 1);
        PreDetectFail = new TaskErrorCode("PreDetectFail", 2);
        QueueDiscard = new TaskErrorCode("QueueDiscard", 3);
        ExecuteError = new TaskErrorCode("ExecuteError", 4);
        CheckSafetyFail = new TaskErrorCode("CheckSafetyFail", 5);
        UnsupportImage = new TaskErrorCode("UnsupportImage", 6);
        UploadResultFail = new TaskErrorCode("UploadResultFail", 7);
        $VALUES = $values();
    }

    TaskErrorCode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TaskErrorCode valueOf(String str) {
        return (TaskErrorCode) Enum.valueOf(TaskErrorCode.class, str);
    }

    public static TaskErrorCode[] values() {
        return (TaskErrorCode[]) $VALUES.clone();
    }
}
