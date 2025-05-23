package com.tencent.mobileqq.startup.task.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/m;", "Lcom/tencent/qqnt/startup/parse/c;", "", "readConfigFile", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m implements com.tencent.qqnt.startup.parse.c {
    static IPatchRedirector $redirector_;

    public m() {
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
        ColdStartupStage coldStartupStage = ColdStartupStage.ApplicationAttach;
        ColdStartupTask coldStartupTask = ColdStartupTask.AttachStageCommonTask;
        ColdStartupTask coldStartupTask2 = ColdStartupTask.QLogInitTask;
        ColdStartupTask coldStartupTask3 = ColdStartupTask.MMKVInitTask;
        ColdStartupTask coldStartupTask4 = ColdStartupTask.ArtTiHookTask;
        ColdStartupTask coldStartupTask5 = ColdStartupTask.SpInitTask;
        ColdStartupStage coldStartupStage2 = ColdStartupStage.ApplicationCreate;
        ColdStartupTask coldStartupTask6 = ColdStartupTask.ApplicationCreateCommonTask;
        ColdStartupTask coldStartupTask7 = ColdStartupTask.CentaurInitTask;
        ColdStartupTask coldStartupTask8 = ColdStartupTask.LoadDexTask;
        ColdStartupTask coldStartupTask9 = ColdStartupTask.QRouteInitTask;
        ColdStartupTask coldStartupTask10 = ColdStartupTask.QIPCInitTask;
        ColdStartupTask coldStartupTask11 = ColdStartupTask.KernelInitTask;
        ColdStartupTask coldStartupTask12 = ColdStartupTask.WxMiniInitTask;
        ColdStartupTask coldStartupTask13 = ColdStartupTask.EarlySdkInitTask;
        ColdStartupTask coldStartupTask14 = ColdStartupTask.MonitorInitTask;
        ColdStartupTask coldStartupTask15 = ColdStartupTask.ManagerThreadTask;
        ColdStartupTask coldStartupTask16 = ColdStartupTask.RdmInitTask;
        ColdStartupTask coldStartupTask17 = ColdStartupTask.BrowserGlobalSettingTask;
        ColdStartupTask coldStartupTask18 = ColdStartupTask.SkinInitTask;
        ColdStartupTask coldStartupTask19 = ColdStartupTask.BeaconSDKInitTask;
        ColdStartupTask coldStartupTask20 = ColdStartupTask.DtSdkInitTask;
        trimIndent = StringsKt__IndentKt.trimIndent("\n        \n        >> " + coldStartupStage + "\n            " + coldStartupTask + "\n            " + coldStartupTask2 + "-->" + coldStartupTask3 + "\n            " + coldStartupTask4 + "\n            " + coldStartupTask3 + "-->" + coldStartupTask5 + "\n        <<\n        >> " + coldStartupStage2 + "\n            " + coldStartupTask6 + "-->" + coldStartupTask7 + "-->" + coldStartupTask8 + "\n            " + coldStartupTask6 + "-->" + coldStartupTask9 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask8 + "\n            " + coldStartupTask10 + "\n            " + coldStartupTask11 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask12 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask13 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask14 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask15 + " \n            " + coldStartupTask8 + "-->" + coldStartupTask16 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask17 + "\n            " + coldStartupTask8 + "-->" + coldStartupTask18 + "  \n            " + coldStartupTask8 + "-->" + coldStartupTask19 + "-->" + coldStartupTask20 + "\n            " + coldStartupTask9 + "-->" + ColdStartupTask.CodeCheckTask + "\n            " + coldStartupTask9 + "-->" + coldStartupTask20 + "-->" + ColdStartupTask.LoadAllDtSampleConfigTask + "\n            " + coldStartupTask8 + "-->" + ColdStartupTask.MMKVMonitorTask + "\n        <<       \n    ");
        return trimIndent;
    }
}
