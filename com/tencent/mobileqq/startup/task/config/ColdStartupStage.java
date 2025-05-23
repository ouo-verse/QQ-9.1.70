package com.tencent.mobileqq.startup.task.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/startup/task/config/ColdStartupStage;", "", "(Ljava/lang/String;I)V", "ApplicationAttach", "ApplicationCreate", "BackgroundCreate", "ActivityAfterBgCreate", "ActivityFirstCreate", "SplashShow", "SplashShowBgCreate", "ActivityRealCreate", "MainPageShow", "RegProxyEnd", "PreloadUiStage", "startup_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ColdStartupStage {
    private static final /* synthetic */ ColdStartupStage[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ColdStartupStage ActivityAfterBgCreate;
    public static final ColdStartupStage ActivityFirstCreate;
    public static final ColdStartupStage ActivityRealCreate;
    public static final ColdStartupStage ApplicationAttach;
    public static final ColdStartupStage ApplicationCreate;
    public static final ColdStartupStage BackgroundCreate;
    public static final ColdStartupStage MainPageShow;
    public static final ColdStartupStage PreloadUiStage;
    public static final ColdStartupStage RegProxyEnd;
    public static final ColdStartupStage SplashShow;
    public static final ColdStartupStage SplashShowBgCreate;

    private static final /* synthetic */ ColdStartupStage[] $values() {
        return new ColdStartupStage[]{ApplicationAttach, ApplicationCreate, BackgroundCreate, ActivityAfterBgCreate, ActivityFirstCreate, SplashShow, SplashShowBgCreate, ActivityRealCreate, MainPageShow, RegProxyEnd, PreloadUiStage};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46365);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ApplicationAttach = new ColdStartupStage("ApplicationAttach", 0);
        ApplicationCreate = new ColdStartupStage("ApplicationCreate", 1);
        BackgroundCreate = new ColdStartupStage("BackgroundCreate", 2);
        ActivityAfterBgCreate = new ColdStartupStage("ActivityAfterBgCreate", 3);
        ActivityFirstCreate = new ColdStartupStage("ActivityFirstCreate", 4);
        SplashShow = new ColdStartupStage("SplashShow", 5);
        SplashShowBgCreate = new ColdStartupStage("SplashShowBgCreate", 6);
        ActivityRealCreate = new ColdStartupStage("ActivityRealCreate", 7);
        MainPageShow = new ColdStartupStage("MainPageShow", 8);
        RegProxyEnd = new ColdStartupStage("RegProxyEnd", 9);
        PreloadUiStage = new ColdStartupStage("PreloadUiStage", 10);
        $VALUES = $values();
    }

    ColdStartupStage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ColdStartupStage valueOf(String str) {
        return (ColdStartupStage) Enum.valueOf(ColdStartupStage.class, str);
    }

    public static ColdStartupStage[] values() {
        return (ColdStartupStage[]) $VALUES.clone();
    }
}
