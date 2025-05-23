package com.tencent.mobileqq.startup.update;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/update/UpdateTask;", "", "(Ljava/lang/String;I)V", "UpdateFreesiaTask", "UpdateSharppSoTask", "UpdateArkSoTask", "UpdateBubbleZipTask", "UpdatePatchConfigTask", "UpdatePluginVersionTask", "UpdateSecureFileTask", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class UpdateTask {
    private static final /* synthetic */ UpdateTask[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final UpdateTask UpdateArkSoTask;
    public static final UpdateTask UpdateBubbleZipTask;
    public static final UpdateTask UpdateFreesiaTask;
    public static final UpdateTask UpdatePatchConfigTask;
    public static final UpdateTask UpdatePluginVersionTask;
    public static final UpdateTask UpdateSecureFileTask;
    public static final UpdateTask UpdateSharppSoTask;

    private static final /* synthetic */ UpdateTask[] $values() {
        return new UpdateTask[]{UpdateFreesiaTask, UpdateSharppSoTask, UpdateArkSoTask, UpdateBubbleZipTask, UpdatePatchConfigTask, UpdatePluginVersionTask, UpdateSecureFileTask};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        UpdateFreesiaTask = new UpdateTask("UpdateFreesiaTask", 0);
        UpdateSharppSoTask = new UpdateTask("UpdateSharppSoTask", 1);
        UpdateArkSoTask = new UpdateTask("UpdateArkSoTask", 2);
        UpdateBubbleZipTask = new UpdateTask("UpdateBubbleZipTask", 3);
        UpdatePatchConfigTask = new UpdateTask("UpdatePatchConfigTask", 4);
        UpdatePluginVersionTask = new UpdateTask("UpdatePluginVersionTask", 5);
        UpdateSecureFileTask = new UpdateTask("UpdateSecureFileTask", 6);
        $VALUES = $values();
    }

    UpdateTask(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static UpdateTask valueOf(String str) {
        return (UpdateTask) Enum.valueOf(UpdateTask.class, str);
    }

    public static UpdateTask[] values() {
        return (UpdateTask[]) $VALUES.clone();
    }
}
