package com.tencent.mobileqq.startup.task.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/d;", "Lcom/tencent/qqnt/startup/parse/c;", "", "readConfigFile", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d implements com.tencent.qqnt.startup.parse.c {
    static IPatchRedirector $redirector_;

    public d() {
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
        ColdStartupTask coldStartupTask6 = ColdStartupTask.LoadFeKitSoTask;
        ColdStartupStage coldStartupStage2 = ColdStartupStage.ApplicationCreate;
        ColdStartupTask coldStartupTask7 = ColdStartupTask.ApplicationCreateCommonTask;
        ColdStartupTask coldStartupTask8 = ColdStartupTask.CentaurInitTask;
        ColdStartupTask coldStartupTask9 = ColdStartupTask.LoadDexTask;
        ColdStartupTask coldStartupTask10 = ColdStartupTask.QRouteInitTask;
        ColdStartupTask coldStartupTask11 = ColdStartupTask.QShadowInitTask;
        ColdStartupTask coldStartupTask12 = ColdStartupTask.EarlySdkInitTask;
        ColdStartupTask coldStartupTask13 = ColdStartupTask.MonitorInitTask;
        ColdStartupTask coldStartupTask14 = ColdStartupTask.GuardInitTask;
        ColdStartupTask coldStartupTask15 = ColdStartupTask.ManagerThreadTask;
        ColdStartupTask coldStartupTask16 = ColdStartupTask.RdmInitTask;
        ColdStartupTask coldStartupTask17 = ColdStartupTask.QimeiInitTask;
        ColdStartupTask coldStartupTask18 = ColdStartupTask.BeaconSDKInitTask;
        ColdStartupTask coldStartupTask19 = ColdStartupTask.DtSdkInitTask;
        ColdStartupTask coldStartupTask20 = ColdStartupTask.MSFAccountChangeRegisterTask;
        trimIndent = StringsKt__IndentKt.trimIndent("\n        \n        >> " + coldStartupStage + "\n            " + coldStartupTask + "\n            " + coldStartupTask2 + "-->" + coldStartupTask3 + "\n            " + coldStartupTask4 + "\n            " + coldStartupTask3 + "-->" + coldStartupTask5 + "\n            " + coldStartupTask3 + "-->" + coldStartupTask6 + "\n        <<\n        >> " + coldStartupStage2 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask8 + "-->" + coldStartupTask9 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask10 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask11 + "\n            " + coldStartupTask10 + "-->" + coldStartupTask9 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask12 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask13 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask14 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask15 + "           \n            " + coldStartupTask9 + "-->" + coldStartupTask16 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask17 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask18 + "-->" + coldStartupTask19 + "\n            " + coldStartupTask16 + "-->" + coldStartupTask20 + "\n            " + coldStartupTask18 + "-->" + coldStartupTask20 + "\n            " + coldStartupTask10 + "-->" + ColdStartupTask.CodeCheckTask + "\n            " + coldStartupTask10 + "-->" + coldStartupTask19 + "-->" + ColdStartupTask.LoadAllDtSampleConfigTask + "\n            " + coldStartupTask16 + "-->" + ColdStartupTask.MatrixBatteryInitTask + "\n            " + coldStartupTask9 + "-->" + ColdStartupTask.MMKVMonitorTask + "\n        <<        \n    ");
        return trimIndent;
    }
}
