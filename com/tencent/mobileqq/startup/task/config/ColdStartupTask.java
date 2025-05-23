package com.tencent.mobileqq.startup.task.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\bM\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bM\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/ColdStartupTask;", "", "(Ljava/lang/String;I)V", "AttachStageCommonTask", "QLogInitTask", "QRouteInitTask", "MMKVInitTask", "CrashDefenderTask", "CrashDefenderEndTask", "ArtTiHookTask", "SpInitTask", "LoadDexTask", "LoadModuleTask", "EarlySdkInitTask", "CentaurInitTask", "MonitorInitTask", "QIPCInitTask", "ManagerThreadTask", "DtSdkInitTask", "TabSdkInitTask", "TuxSdkInitTask", "MatrixBatteryInitTask", "NoLoginTabInitTask", "MemoryCacheInitTask", "BrowserPreloadTask", "BrowserGlobalSettingTask", "ApplicationCreateCommonTask", "ApplicationCreateEndTask", "NewRuntimeTask", "GuardInitTask", "BeaconSDKInitTask", "CrashInitTask", "RFWInitTask", "QFSInitTask", "NativeMonitorTask", "AlbumInitTask", "LaunchAutomatorTask", "VersionUpdateTask", "SplashSetupTask", "SplashShowTask", "KernelInitTask", "SubKernelInitTask", "MsgObserverTask", "PreLoadUiTask", "QShadowInitTask", "UrlDrawableInitTask", "SkinInitTask", "ArgusPreloadTask", "ThemeInitTask", "RdmInitTask", "RaftKitInitTask", "StartServiceTask", "BusinessPreloadTask", "PreloadConversationTask", "PreloadAfterRuntimeTask", "WxMiniInitTask", "WxMiniMainInitTask", "CodeCheckTask", "RUDataPreloadTask", "GuardRegisterTask", "GroupVideoInitTask", "SafeModeTask", "SafeO3InitTask", "MSFAccountChangeRegisterTask", "UpdateFriendLocalInitTask", "LoadAllDtSampleConfigTask", "MiniBoxInitTask", "LoadFeKitSoTask", "MainPageShowEndTask", "RegProxyEndTask", "MMKVMonitorTask", "QimeiInitTask", "FreesiaBgFetchTask", "AIOCorePreLoadTask", "GuidLoadTask", "WTSigCheckTask", "WTUpgradeTask", "WTRefreshNTSignTask", "startup_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ColdStartupTask {
    private static final /* synthetic */ ColdStartupTask[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ColdStartupTask AIOCorePreLoadTask;
    public static final ColdStartupTask AlbumInitTask;
    public static final ColdStartupTask ApplicationCreateCommonTask;
    public static final ColdStartupTask ApplicationCreateEndTask;
    public static final ColdStartupTask ArgusPreloadTask;
    public static final ColdStartupTask ArtTiHookTask;
    public static final ColdStartupTask AttachStageCommonTask;
    public static final ColdStartupTask BeaconSDKInitTask;
    public static final ColdStartupTask BrowserGlobalSettingTask;
    public static final ColdStartupTask BrowserPreloadTask;
    public static final ColdStartupTask BusinessPreloadTask;
    public static final ColdStartupTask CentaurInitTask;
    public static final ColdStartupTask CodeCheckTask;
    public static final ColdStartupTask CrashDefenderEndTask;
    public static final ColdStartupTask CrashDefenderTask;
    public static final ColdStartupTask CrashInitTask;
    public static final ColdStartupTask DtSdkInitTask;
    public static final ColdStartupTask EarlySdkInitTask;
    public static final ColdStartupTask FreesiaBgFetchTask;
    public static final ColdStartupTask GroupVideoInitTask;
    public static final ColdStartupTask GuardInitTask;
    public static final ColdStartupTask GuardRegisterTask;
    public static final ColdStartupTask GuidLoadTask;
    public static final ColdStartupTask KernelInitTask;
    public static final ColdStartupTask LaunchAutomatorTask;
    public static final ColdStartupTask LoadAllDtSampleConfigTask;
    public static final ColdStartupTask LoadDexTask;
    public static final ColdStartupTask LoadFeKitSoTask;
    public static final ColdStartupTask LoadModuleTask;
    public static final ColdStartupTask MMKVInitTask;
    public static final ColdStartupTask MMKVMonitorTask;
    public static final ColdStartupTask MSFAccountChangeRegisterTask;
    public static final ColdStartupTask MainPageShowEndTask;
    public static final ColdStartupTask ManagerThreadTask;
    public static final ColdStartupTask MatrixBatteryInitTask;
    public static final ColdStartupTask MemoryCacheInitTask;
    public static final ColdStartupTask MiniBoxInitTask;
    public static final ColdStartupTask MonitorInitTask;
    public static final ColdStartupTask MsgObserverTask;
    public static final ColdStartupTask NativeMonitorTask;
    public static final ColdStartupTask NewRuntimeTask;
    public static final ColdStartupTask NoLoginTabInitTask;
    public static final ColdStartupTask PreLoadUiTask;
    public static final ColdStartupTask PreloadAfterRuntimeTask;
    public static final ColdStartupTask PreloadConversationTask;
    public static final ColdStartupTask QFSInitTask;
    public static final ColdStartupTask QIPCInitTask;
    public static final ColdStartupTask QLogInitTask;
    public static final ColdStartupTask QRouteInitTask;
    public static final ColdStartupTask QShadowInitTask;
    public static final ColdStartupTask QimeiInitTask;
    public static final ColdStartupTask RFWInitTask;
    public static final ColdStartupTask RUDataPreloadTask;
    public static final ColdStartupTask RaftKitInitTask;
    public static final ColdStartupTask RdmInitTask;
    public static final ColdStartupTask RegProxyEndTask;
    public static final ColdStartupTask SafeModeTask;
    public static final ColdStartupTask SafeO3InitTask;
    public static final ColdStartupTask SkinInitTask;
    public static final ColdStartupTask SpInitTask;
    public static final ColdStartupTask SplashSetupTask;
    public static final ColdStartupTask SplashShowTask;
    public static final ColdStartupTask StartServiceTask;
    public static final ColdStartupTask SubKernelInitTask;
    public static final ColdStartupTask TabSdkInitTask;
    public static final ColdStartupTask ThemeInitTask;
    public static final ColdStartupTask TuxSdkInitTask;
    public static final ColdStartupTask UpdateFriendLocalInitTask;
    public static final ColdStartupTask UrlDrawableInitTask;
    public static final ColdStartupTask VersionUpdateTask;
    public static final ColdStartupTask WTRefreshNTSignTask;
    public static final ColdStartupTask WTSigCheckTask;
    public static final ColdStartupTask WTUpgradeTask;
    public static final ColdStartupTask WxMiniInitTask;
    public static final ColdStartupTask WxMiniMainInitTask;

    private static final /* synthetic */ ColdStartupTask[] $values() {
        return new ColdStartupTask[]{AttachStageCommonTask, QLogInitTask, QRouteInitTask, MMKVInitTask, CrashDefenderTask, CrashDefenderEndTask, ArtTiHookTask, SpInitTask, LoadDexTask, LoadModuleTask, EarlySdkInitTask, CentaurInitTask, MonitorInitTask, QIPCInitTask, ManagerThreadTask, DtSdkInitTask, TabSdkInitTask, TuxSdkInitTask, MatrixBatteryInitTask, NoLoginTabInitTask, MemoryCacheInitTask, BrowserPreloadTask, BrowserGlobalSettingTask, ApplicationCreateCommonTask, ApplicationCreateEndTask, NewRuntimeTask, GuardInitTask, BeaconSDKInitTask, CrashInitTask, RFWInitTask, QFSInitTask, NativeMonitorTask, AlbumInitTask, LaunchAutomatorTask, VersionUpdateTask, SplashSetupTask, SplashShowTask, KernelInitTask, SubKernelInitTask, MsgObserverTask, PreLoadUiTask, QShadowInitTask, UrlDrawableInitTask, SkinInitTask, ArgusPreloadTask, ThemeInitTask, RdmInitTask, RaftKitInitTask, StartServiceTask, BusinessPreloadTask, PreloadConversationTask, PreloadAfterRuntimeTask, WxMiniInitTask, WxMiniMainInitTask, CodeCheckTask, RUDataPreloadTask, GuardRegisterTask, GroupVideoInitTask, SafeModeTask, SafeO3InitTask, MSFAccountChangeRegisterTask, UpdateFriendLocalInitTask, LoadAllDtSampleConfigTask, MiniBoxInitTask, LoadFeKitSoTask, MainPageShowEndTask, RegProxyEndTask, MMKVMonitorTask, QimeiInitTask, FreesiaBgFetchTask, AIOCorePreLoadTask, GuidLoadTask, WTSigCheckTask, WTUpgradeTask, WTRefreshNTSignTask};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        AttachStageCommonTask = new ColdStartupTask("AttachStageCommonTask", 0);
        QLogInitTask = new ColdStartupTask("QLogInitTask", 1);
        QRouteInitTask = new ColdStartupTask("QRouteInitTask", 2);
        MMKVInitTask = new ColdStartupTask("MMKVInitTask", 3);
        CrashDefenderTask = new ColdStartupTask("CrashDefenderTask", 4);
        CrashDefenderEndTask = new ColdStartupTask("CrashDefenderEndTask", 5);
        ArtTiHookTask = new ColdStartupTask("ArtTiHookTask", 6);
        SpInitTask = new ColdStartupTask("SpInitTask", 7);
        LoadDexTask = new ColdStartupTask("LoadDexTask", 8);
        LoadModuleTask = new ColdStartupTask("LoadModuleTask", 9);
        EarlySdkInitTask = new ColdStartupTask("EarlySdkInitTask", 10);
        CentaurInitTask = new ColdStartupTask("CentaurInitTask", 11);
        MonitorInitTask = new ColdStartupTask("MonitorInitTask", 12);
        QIPCInitTask = new ColdStartupTask("QIPCInitTask", 13);
        ManagerThreadTask = new ColdStartupTask("ManagerThreadTask", 14);
        DtSdkInitTask = new ColdStartupTask("DtSdkInitTask", 15);
        TabSdkInitTask = new ColdStartupTask("TabSdkInitTask", 16);
        TuxSdkInitTask = new ColdStartupTask("TuxSdkInitTask", 17);
        MatrixBatteryInitTask = new ColdStartupTask("MatrixBatteryInitTask", 18);
        NoLoginTabInitTask = new ColdStartupTask("NoLoginTabInitTask", 19);
        MemoryCacheInitTask = new ColdStartupTask("MemoryCacheInitTask", 20);
        BrowserPreloadTask = new ColdStartupTask("BrowserPreloadTask", 21);
        BrowserGlobalSettingTask = new ColdStartupTask("BrowserGlobalSettingTask", 22);
        ApplicationCreateCommonTask = new ColdStartupTask("ApplicationCreateCommonTask", 23);
        ApplicationCreateEndTask = new ColdStartupTask("ApplicationCreateEndTask", 24);
        NewRuntimeTask = new ColdStartupTask("NewRuntimeTask", 25);
        GuardInitTask = new ColdStartupTask("GuardInitTask", 26);
        BeaconSDKInitTask = new ColdStartupTask("BeaconSDKInitTask", 27);
        CrashInitTask = new ColdStartupTask("CrashInitTask", 28);
        RFWInitTask = new ColdStartupTask("RFWInitTask", 29);
        QFSInitTask = new ColdStartupTask("QFSInitTask", 30);
        NativeMonitorTask = new ColdStartupTask("NativeMonitorTask", 31);
        AlbumInitTask = new ColdStartupTask("AlbumInitTask", 32);
        LaunchAutomatorTask = new ColdStartupTask("LaunchAutomatorTask", 33);
        VersionUpdateTask = new ColdStartupTask("VersionUpdateTask", 34);
        SplashSetupTask = new ColdStartupTask("SplashSetupTask", 35);
        SplashShowTask = new ColdStartupTask("SplashShowTask", 36);
        KernelInitTask = new ColdStartupTask("KernelInitTask", 37);
        SubKernelInitTask = new ColdStartupTask("SubKernelInitTask", 38);
        MsgObserverTask = new ColdStartupTask("MsgObserverTask", 39);
        PreLoadUiTask = new ColdStartupTask("PreLoadUiTask", 40);
        QShadowInitTask = new ColdStartupTask("QShadowInitTask", 41);
        UrlDrawableInitTask = new ColdStartupTask("UrlDrawableInitTask", 42);
        SkinInitTask = new ColdStartupTask("SkinInitTask", 43);
        ArgusPreloadTask = new ColdStartupTask("ArgusPreloadTask", 44);
        ThemeInitTask = new ColdStartupTask("ThemeInitTask", 45);
        RdmInitTask = new ColdStartupTask("RdmInitTask", 46);
        RaftKitInitTask = new ColdStartupTask("RaftKitInitTask", 47);
        StartServiceTask = new ColdStartupTask("StartServiceTask", 48);
        BusinessPreloadTask = new ColdStartupTask("BusinessPreloadTask", 49);
        PreloadConversationTask = new ColdStartupTask("PreloadConversationTask", 50);
        PreloadAfterRuntimeTask = new ColdStartupTask("PreloadAfterRuntimeTask", 51);
        WxMiniInitTask = new ColdStartupTask("WxMiniInitTask", 52);
        WxMiniMainInitTask = new ColdStartupTask("WxMiniMainInitTask", 53);
        CodeCheckTask = new ColdStartupTask("CodeCheckTask", 54);
        RUDataPreloadTask = new ColdStartupTask("RUDataPreloadTask", 55);
        GuardRegisterTask = new ColdStartupTask("GuardRegisterTask", 56);
        GroupVideoInitTask = new ColdStartupTask("GroupVideoInitTask", 57);
        SafeModeTask = new ColdStartupTask("SafeModeTask", 58);
        SafeO3InitTask = new ColdStartupTask("SafeO3InitTask", 59);
        MSFAccountChangeRegisterTask = new ColdStartupTask("MSFAccountChangeRegisterTask", 60);
        UpdateFriendLocalInitTask = new ColdStartupTask("UpdateFriendLocalInitTask", 61);
        LoadAllDtSampleConfigTask = new ColdStartupTask("LoadAllDtSampleConfigTask", 62);
        MiniBoxInitTask = new ColdStartupTask("MiniBoxInitTask", 63);
        LoadFeKitSoTask = new ColdStartupTask("LoadFeKitSoTask", 64);
        MainPageShowEndTask = new ColdStartupTask("MainPageShowEndTask", 65);
        RegProxyEndTask = new ColdStartupTask("RegProxyEndTask", 66);
        MMKVMonitorTask = new ColdStartupTask("MMKVMonitorTask", 67);
        QimeiInitTask = new ColdStartupTask("QimeiInitTask", 68);
        FreesiaBgFetchTask = new ColdStartupTask("FreesiaBgFetchTask", 69);
        AIOCorePreLoadTask = new ColdStartupTask("AIOCorePreLoadTask", 70);
        GuidLoadTask = new ColdStartupTask("GuidLoadTask", 71);
        WTSigCheckTask = new ColdStartupTask("WTSigCheckTask", 72);
        WTUpgradeTask = new ColdStartupTask("WTUpgradeTask", 73);
        WTRefreshNTSignTask = new ColdStartupTask("WTRefreshNTSignTask", 74);
        $VALUES = $values();
    }

    ColdStartupTask(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ColdStartupTask valueOf(String str) {
        return (ColdStartupTask) Enum.valueOf(ColdStartupTask.class, str);
    }

    public static ColdStartupTask[] values() {
        return (ColdStartupTask[]) $VALUES.clone();
    }
}
