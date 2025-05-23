package com.tencent.mobileqq.cardcontainer.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "", "", "value", "Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "Unknown", "DemoCardType", "GroupMsgReminder", "SelfGroupMsgReminder", "AvatarPlusOneBtn", "IconPlusOneBtn", "ImageNoButton", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardType {
    private static final /* synthetic */ CardType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final CardType AvatarPlusOneBtn;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final CardType DemoCardType;
    public static final CardType GroupMsgReminder;
    public static final CardType IconPlusOneBtn;
    public static final CardType ImageNoButton;
    public static final CardType SelfGroupMsgReminder;
    public static final CardType Unknown;

    @NotNull
    private final String value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/CardType$a;", "", "", "value", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "a", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.data.CardType$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final CardType a(@NotNull String value) {
            CardType cardType;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CardType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value);
            }
            Intrinsics.checkNotNullParameter(value, "value");
            CardType[] values = CardType.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    cardType = values[i3];
                    if (Intrinsics.areEqual(cardType.getValue(), value)) {
                        break;
                    }
                    i3++;
                } else {
                    cardType = null;
                    break;
                }
            }
            if (cardType == null) {
                return CardType.Unknown;
            }
            return cardType;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ CardType[] $values() {
        return new CardType[]{Unknown, DemoCardType, GroupMsgReminder, SelfGroupMsgReminder, AvatarPlusOneBtn, IconPlusOneBtn, ImageNoButton};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Unknown = new CardType("Unknown", 0, "Unknown");
        DemoCardType = new CardType("DemoCardType", 1, "DemoCardType");
        GroupMsgReminder = new CardType("GroupMsgReminder", 2, "GroupMsgReminder");
        SelfGroupMsgReminder = new CardType("SelfGroupMsgReminder", 3, "SelfGroupMsgReminder");
        AvatarPlusOneBtn = new CardType("AvatarPlusOneBtn", 4, "AvatarPlusOneBtn");
        IconPlusOneBtn = new CardType("IconPlusOneBtn", 5, "IconPlusOneBtn");
        ImageNoButton = new CardType("ImageNoButton", 6, "ImageNoButton");
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    CardType(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.value = str2;
        }
    }

    public static CardType valueOf(String str) {
        return (CardType) Enum.valueOf(CardType.class, str);
    }

    public static CardType[] values() {
        return (CardType[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }
}
