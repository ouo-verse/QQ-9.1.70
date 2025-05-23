package com.tencent.mobileqq.startup.update;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/startup/update/c;", "Lcom/tencent/qqnt/startup/parse/c;", "", "readConfigFile", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c implements com.tencent.qqnt.startup.parse.c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.parse.c
    @NotNull
    public String readConfigFile() {
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        trimIndent = StringsKt__IndentKt.trimIndent("\n        \n        >> updateStage\n            " + UpdateTask.UpdateFreesiaTask + "\n            " + UpdateTask.UpdatePluginVersionTask + "\n            " + UpdateTask.UpdateSharppSoTask + "\n            " + UpdateTask.UpdateArkSoTask + "\n            " + UpdateTask.UpdateBubbleZipTask + "\n            " + UpdateTask.UpdatePatchConfigTask + "\n            " + UpdateTask.UpdateSecureFileTask + "\n        <<    \n        \n    ");
        return trimIndent;
    }
}
