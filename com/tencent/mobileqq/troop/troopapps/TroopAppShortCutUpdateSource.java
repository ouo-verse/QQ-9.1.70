package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/TroopAppShortCutUpdateSource;", "", "(Ljava/lang/String;I)V", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "TroopAppPageRequest", "TroopAppManagerRefresh", "AddTroopRecommendApp", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopAppShortCutUpdateSource {
    private static final /* synthetic */ TroopAppShortCutUpdateSource[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopAppShortCutUpdateSource AddTroopRecommendApp;
    public static final TroopAppShortCutUpdateSource Init;
    public static final TroopAppShortCutUpdateSource TroopAppManagerRefresh;
    public static final TroopAppShortCutUpdateSource TroopAppPageRequest;

    private static final /* synthetic */ TroopAppShortCutUpdateSource[] $values() {
        return new TroopAppShortCutUpdateSource[]{Init, TroopAppPageRequest, TroopAppManagerRefresh, AddTroopRecommendApp};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62461);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Init = new TroopAppShortCutUpdateSource(QZoneCoverStoreJsPlugin.INIT_PLUGIN, 0);
        TroopAppPageRequest = new TroopAppShortCutUpdateSource("TroopAppPageRequest", 1);
        TroopAppManagerRefresh = new TroopAppShortCutUpdateSource("TroopAppManagerRefresh", 2);
        AddTroopRecommendApp = new TroopAppShortCutUpdateSource("AddTroopRecommendApp", 3);
        $VALUES = $values();
    }

    TroopAppShortCutUpdateSource(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TroopAppShortCutUpdateSource valueOf(String str) {
        return (TroopAppShortCutUpdateSource) Enum.valueOf(TroopAppShortCutUpdateSource.class, str);
    }

    public static TroopAppShortCutUpdateSource[] values() {
        return (TroopAppShortCutUpdateSource[]) $VALUES.clone();
    }
}
