package com.tencent.mobileqq.aio.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/event/NTPanelEntrance;", "", HippyControllerProps.STRING, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "TROOP_PLUS_PANEL", "TROOP_PROFILE_CARD", "TROOP_GIFT_ITEM", "TROOP_GIFT_ITEM_BACK", "TROOP_GIFT_EASTER_EGG", "TROOP_BIRTH_BANNER", "TROOP_BIRTH_PICK_MEMBER", "TROOP_BIRTH_ITEM", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class NTPanelEntrance {
    private static final /* synthetic */ NTPanelEntrance[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NTPanelEntrance TROOP_BIRTH_BANNER;
    public static final NTPanelEntrance TROOP_BIRTH_ITEM;
    public static final NTPanelEntrance TROOP_BIRTH_PICK_MEMBER;
    public static final NTPanelEntrance TROOP_GIFT_EASTER_EGG;
    public static final NTPanelEntrance TROOP_GIFT_ITEM;
    public static final NTPanelEntrance TROOP_GIFT_ITEM_BACK;
    public static final NTPanelEntrance TROOP_PLUS_PANEL;
    public static final NTPanelEntrance TROOP_PROFILE_CARD;

    @NotNull
    private final String string;

    private static final /* synthetic */ NTPanelEntrance[] $values() {
        return new NTPanelEntrance[]{TROOP_PLUS_PANEL, TROOP_PROFILE_CARD, TROOP_GIFT_ITEM, TROOP_GIFT_ITEM_BACK, TROOP_GIFT_EASTER_EGG, TROOP_BIRTH_BANNER, TROOP_BIRTH_PICK_MEMBER, TROOP_BIRTH_ITEM};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        TROOP_PLUS_PANEL = new NTPanelEntrance("TROOP_PLUS_PANEL", 0, VipFunCallConstants.KEY_GROUP);
        TROOP_PROFILE_CARD = new NTPanelEntrance("TROOP_PROFILE_CARD", 1, "qunziliaoka");
        TROOP_GIFT_ITEM = new NTPanelEntrance("TROOP_GIFT_ITEM", 2, "ark");
        TROOP_GIFT_ITEM_BACK = new NTPanelEntrance("TROOP_GIFT_ITEM_BACK", 3, "ark");
        TROOP_GIFT_EASTER_EGG = new NTPanelEntrance("TROOP_GIFT_EASTER_EGG", 4, "caidan");
        TROOP_BIRTH_BANNER = new NTPanelEntrance("TROOP_BIRTH_BANNER", 5, "troopBirth");
        TROOP_BIRTH_PICK_MEMBER = new NTPanelEntrance("TROOP_BIRTH_PICK_MEMBER", 6, "troopBirth");
        TROOP_BIRTH_ITEM = new NTPanelEntrance("TROOP_BIRTH_ITEM", 7, "troopBirth");
        $VALUES = $values();
    }

    NTPanelEntrance(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.string = str2;
        }
    }

    public static NTPanelEntrance valueOf(String str) {
        return (NTPanelEntrance) Enum.valueOf(NTPanelEntrance.class, str);
    }

    public static NTPanelEntrance[] values() {
        return (NTPanelEntrance[]) $VALUES.clone();
    }

    @NotNull
    public final String getString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.string;
    }
}
