package com.tencent.mobileqq.troop.troopnotification.recommend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotifyWithRecommendPlaceHolder;", "", "(Ljava/lang/String;I)V", "SHOW_EMPTY_NOTIFICATION", "SHOW_MORE", "SHOW_MORE_TROOP", "SHOW_LOADING_TROOP", "SHOW_EMPTY_TROOP", "SHOW_ALL_EMPTY", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopNotifyWithRecommendPlaceHolder {
    private static final /* synthetic */ TroopNotifyWithRecommendPlaceHolder[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_ALL_EMPTY;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_EMPTY_NOTIFICATION;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_EMPTY_TROOP;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_LOADING_TROOP;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_MORE;
    public static final TroopNotifyWithRecommendPlaceHolder SHOW_MORE_TROOP;

    private static final /* synthetic */ TroopNotifyWithRecommendPlaceHolder[] $values() {
        return new TroopNotifyWithRecommendPlaceHolder[]{SHOW_EMPTY_NOTIFICATION, SHOW_MORE, SHOW_MORE_TROOP, SHOW_LOADING_TROOP, SHOW_EMPTY_TROOP, SHOW_ALL_EMPTY};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59142);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SHOW_EMPTY_NOTIFICATION = new TroopNotifyWithRecommendPlaceHolder("SHOW_EMPTY_NOTIFICATION", 0);
        SHOW_MORE = new TroopNotifyWithRecommendPlaceHolder("SHOW_MORE", 1);
        SHOW_MORE_TROOP = new TroopNotifyWithRecommendPlaceHolder("SHOW_MORE_TROOP", 2);
        SHOW_LOADING_TROOP = new TroopNotifyWithRecommendPlaceHolder("SHOW_LOADING_TROOP", 3);
        SHOW_EMPTY_TROOP = new TroopNotifyWithRecommendPlaceHolder("SHOW_EMPTY_TROOP", 4);
        SHOW_ALL_EMPTY = new TroopNotifyWithRecommendPlaceHolder("SHOW_ALL_EMPTY", 5);
        $VALUES = $values();
    }

    TroopNotifyWithRecommendPlaceHolder(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static TroopNotifyWithRecommendPlaceHolder valueOf(String str) {
        return (TroopNotifyWithRecommendPlaceHolder) Enum.valueOf(TroopNotifyWithRecommendPlaceHolder.class, str);
    }

    public static TroopNotifyWithRecommendPlaceHolder[] values() {
        return (TroopNotifyWithRecommendPlaceHolder[]) $VALUES.clone();
    }
}
