package com.tencent.mobileqq.startup.task.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/e;", "Lcom/tencent/qqnt/startup/parse/c;", "", "readConfigFile", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e implements com.tencent.qqnt.startup.parse.c {
    static IPatchRedirector $redirector_;

    public e() {
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
        ColdStartupTask coldStartupTask = ColdStartupTask.CrashDefenderTask;
        ColdStartupTask coldStartupTask2 = ColdStartupTask.AttachStageCommonTask;
        ColdStartupTask coldStartupTask3 = ColdStartupTask.QLogInitTask;
        ColdStartupTask coldStartupTask4 = ColdStartupTask.MMKVInitTask;
        ColdStartupTask coldStartupTask5 = ColdStartupTask.ArtTiHookTask;
        ColdStartupTask coldStartupTask6 = ColdStartupTask.SpInitTask;
        ColdStartupStage coldStartupStage2 = ColdStartupStage.ApplicationCreate;
        ColdStartupTask coldStartupTask7 = ColdStartupTask.ApplicationCreateCommonTask;
        ColdStartupTask coldStartupTask8 = ColdStartupTask.CentaurInitTask;
        ColdStartupTask coldStartupTask9 = ColdStartupTask.LoadDexTask;
        ColdStartupTask coldStartupTask10 = ColdStartupTask.QRouteInitTask;
        ColdStartupTask coldStartupTask11 = ColdStartupTask.QShadowInitTask;
        ColdStartupTask coldStartupTask12 = ColdStartupTask.QIPCInitTask;
        ColdStartupTask coldStartupTask13 = ColdStartupTask.EarlySdkInitTask;
        ColdStartupTask coldStartupTask14 = ColdStartupTask.MonitorInitTask;
        ColdStartupTask coldStartupTask15 = ColdStartupTask.UrlDrawableInitTask;
        ColdStartupTask coldStartupTask16 = ColdStartupTask.LoadModuleTask;
        ColdStartupTask coldStartupTask17 = ColdStartupTask.ManagerThreadTask;
        ColdStartupTask coldStartupTask18 = ColdStartupTask.SkinInitTask;
        ColdStartupTask coldStartupTask19 = ColdStartupTask.ArgusPreloadTask;
        ColdStartupTask coldStartupTask20 = ColdStartupTask.RFWInitTask;
        ColdStartupTask coldStartupTask21 = ColdStartupTask.QFSInitTask;
        ColdStartupTask coldStartupTask22 = ColdStartupTask.MemoryCacheInitTask;
        ColdStartupTask coldStartupTask23 = ColdStartupTask.AlbumInitTask;
        ColdStartupTask coldStartupTask24 = ColdStartupTask.SafeModeTask;
        ColdStartupTask coldStartupTask25 = ColdStartupTask.BeaconSDKInitTask;
        ColdStartupTask coldStartupTask26 = ColdStartupTask.DtSdkInitTask;
        ColdStartupTask coldStartupTask27 = ColdStartupTask.ApplicationCreateEndTask;
        ColdStartupTask coldStartupTask28 = ColdStartupTask.MMKVMonitorTask;
        ColdStartupStage coldStartupStage3 = ColdStartupStage.BackgroundCreate;
        ColdStartupTask coldStartupTask29 = ColdStartupTask.VersionUpdateTask;
        ColdStartupTask coldStartupTask30 = ColdStartupTask.NewRuntimeTask;
        ColdStartupTask coldStartupTask31 = ColdStartupTask.GuardInitTask;
        ColdStartupTask coldStartupTask32 = ColdStartupTask.GuardRegisterTask;
        ColdStartupTask coldStartupTask33 = ColdStartupTask.StartServiceTask;
        ColdStartupTask coldStartupTask34 = ColdStartupTask.NoLoginTabInitTask;
        ColdStartupTask coldStartupTask35 = ColdStartupTask.ThemeInitTask;
        ColdStartupTask coldStartupTask36 = ColdStartupTask.KernelInitTask;
        ColdStartupTask coldStartupTask37 = ColdStartupTask.RUDataPreloadTask;
        ColdStartupTask coldStartupTask38 = ColdStartupTask.WxMiniMainInitTask;
        ColdStartupTask coldStartupTask39 = ColdStartupTask.MsgObserverTask;
        ColdStartupTask coldStartupTask40 = ColdStartupTask.RdmInitTask;
        ColdStartupTask coldStartupTask41 = ColdStartupTask.RaftKitInitTask;
        ColdStartupStage coldStartupStage4 = ColdStartupStage.ActivityFirstCreate;
        ColdStartupTask coldStartupTask42 = ColdStartupTask.SplashSetupTask;
        ColdStartupTask coldStartupTask43 = ColdStartupTask.WTUpgradeTask;
        ColdStartupTask coldStartupTask44 = ColdStartupTask.WTRefreshNTSignTask;
        ColdStartupStage coldStartupStage5 = ColdStartupStage.SplashShow;
        ColdStartupTask coldStartupTask45 = ColdStartupTask.SplashShowTask;
        ColdStartupStage coldStartupStage6 = ColdStartupStage.ActivityAfterBgCreate;
        ColdStartupStage coldStartupStage7 = ColdStartupStage.SplashShowBgCreate;
        ColdStartupStage coldStartupStage8 = ColdStartupStage.PreloadUiStage;
        ColdStartupTask coldStartupTask46 = ColdStartupTask.PreloadAfterRuntimeTask;
        ColdStartupTask coldStartupTask47 = ColdStartupTask.PreLoadUiTask;
        ColdStartupTask coldStartupTask48 = ColdStartupTask.PreloadConversationTask;
        ColdStartupStage coldStartupStage9 = ColdStartupStage.MainPageShow;
        ColdStartupTask coldStartupTask49 = ColdStartupTask.SafeO3InitTask;
        ColdStartupTask coldStartupTask50 = ColdStartupTask.UpdateFriendLocalInitTask;
        ColdStartupTask coldStartupTask51 = ColdStartupTask.AIOCorePreLoadTask;
        ColdStartupTask coldStartupTask52 = ColdStartupTask.TabSdkInitTask;
        ColdStartupTask coldStartupTask53 = ColdStartupTask.GuidLoadTask;
        ColdStartupTask coldStartupTask54 = ColdStartupTask.WTSigCheckTask;
        ColdStartupTask coldStartupTask55 = ColdStartupTask.MatrixBatteryInitTask;
        ColdStartupTask coldStartupTask56 = ColdStartupTask.MainPageShowEndTask;
        ColdStartupStage coldStartupStage10 = ColdStartupStage.RegProxyEnd;
        ColdStartupTask coldStartupTask57 = ColdStartupTask.RegProxyEndTask;
        ColdStartupTask coldStartupTask58 = ColdStartupTask.CrashDefenderEndTask;
        trimIndent = StringsKt__IndentKt.trimIndent("\n        \n        >> " + coldStartupStage + "\n            " + coldStartupTask + "-->" + coldStartupTask2 + "\n            " + coldStartupTask + "-->" + coldStartupTask3 + "-->" + coldStartupTask4 + "\n            " + coldStartupTask + "-->" + coldStartupTask5 + "\n            " + coldStartupTask + "-->" + coldStartupTask6 + "\n        <<\n        >> " + coldStartupStage2 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask8 + "-->" + coldStartupTask9 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask10 + "\n            " + coldStartupTask7 + "-->" + coldStartupTask11 + "\n            " + coldStartupTask10 + "-->" + coldStartupTask9 + "\n            " + coldStartupTask12 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask13 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask14 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask15 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask16 + "  \n            " + coldStartupTask9 + "-->" + coldStartupTask17 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask18 + "-->" + coldStartupTask19 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask20 + " \n            " + coldStartupTask9 + "-->" + coldStartupTask21 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask22 + "    \n            " + coldStartupTask9 + "-->" + coldStartupTask23 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask24 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask25 + "-->" + coldStartupTask26 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask27 + "\n            " + coldStartupTask9 + "-->" + coldStartupTask28 + "\n        <<    \n        >> " + coldStartupStage3 + "\n            " + coldStartupTask29 + "-->" + coldStartupTask30 + "-->" + coldStartupTask31 + "\n            " + coldStartupTask31 + "-->" + coldStartupTask32 + "\n            " + coldStartupTask31 + "-->" + coldStartupTask33 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask34 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask35 + "\n            " + coldStartupTask36 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask37 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask38 + "\n            " + coldStartupTask36 + "-->" + coldStartupTask37 + "\n            " + coldStartupTask36 + "-->" + coldStartupTask39 + "\n            " + coldStartupTask40 + "\n            " + coldStartupTask41 + "\n        <<          \n        >> " + coldStartupStage4 + "\n            " + coldStartupTask42 + "\n            " + coldStartupTask36 + "-->" + coldStartupTask43 + "-->" + coldStartupTask30 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask34 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask37 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask38 + "\n            " + coldStartupTask36 + "-->" + coldStartupTask37 + "\n            " + coldStartupTask36 + "-->" + coldStartupTask39 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask35 + "\n            " + coldStartupTask30 + "-->" + coldStartupTask44 + "\n            " + coldStartupTask40 + "\n            " + coldStartupTask41 + "  \n        <<      \n        >> " + coldStartupStage5 + "\n            " + coldStartupTask45 + "\n            " + coldStartupTask31 + "-->" + coldStartupTask29 + "\n        <<   \n        >> " + coldStartupStage6 + "\n            " + coldStartupTask42 + "\n        <<\n        >> " + coldStartupStage7 + "\n            " + coldStartupTask45 + "\n        <<\n        >> " + coldStartupStage8 + "\n            " + coldStartupTask46 + "\n            " + coldStartupTask47 + "\n            " + coldStartupTask48 + "\n        <<   \n        >> " + coldStartupStage9 + "\n            " + coldStartupTask33 + "-->" + coldStartupTask49 + "-->" + coldStartupTask50 + "-->" + coldStartupTask51 + "      \n            " + coldStartupTask52 + "\n            " + coldStartupTask53 + "\n            " + coldStartupTask54 + "\n            " + coldStartupTask55 + "\n            " + coldStartupTask33 + "-->" + coldStartupTask56 + "\n        <<                     \n        >> " + coldStartupStage10 + "\n            " + coldStartupTask57 + "-->" + coldStartupTask58 + "\n            " + ColdStartupTask.BusinessPreloadTask + "-->" + coldStartupTask58 + "\n            " + ColdStartupTask.CodeCheckTask + "-->" + coldStartupTask58 + "\n            " + ColdStartupTask.LoadAllDtSampleConfigTask + "-->" + coldStartupTask58 + "\n            " + ColdStartupTask.TuxSdkInitTask + "\n        <<\n                 \n    ");
        return trimIndent;
    }
}
