package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.mini.api.MiniConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogReporter;", "", "reportTag", "", "(Ljava/lang/String;)V", "getReportTag", "()Ljava/lang/String;", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasLogReporter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String reportTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\b\u0010\u0019\u001a\u00020\u0004H\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogReporter$Companion;", "", "()V", "getAppIcon", "Lcom/tencent/mobileqq/vas/VasLogReportProxy;", "getAvatarPendant", "getBirthGift", "getBubble", "getChatBackground", "getChatBackgroundJsb", "getDownload", "getDynamicDrawable", "getFont", "getLoveChat", "getNotificationSound", "getProfileCard", "getQzoneCover", "getQzoneFeedsCard", "getQzoneVip", "getSuperTheme", "getTheme", "getTroopKeyWord", "getVasGift", "getVasUpdateKeyWord", "getVipColorName", "getVipData", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getAppIcon() {
            return new VasLogReportProxy(MiniConst.WxMiniAppInfoConst.EXTRA_ICON);
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getAvatarPendant() {
            return new VasLogReportProxy("avatar_pendant");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getBirthGift() {
            return new VasLogReportProxy("birth_gift");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getBubble() {
            return new VasLogReportProxy("bubble");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getChatBackground() {
            return new VasLogReportProxy("chat_background");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getChatBackgroundJsb() {
            return new VasLogReportProxy("chat_background");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getDownload() {
            return new VasLogReportProxy("download");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getDynamicDrawable() {
            return new VasLogReportProxy("dynamic_drawable");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getFont() {
            return new VasLogReportProxy("font");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getLoveChat() {
            return new VasLogReportProxy("love_chat");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getNotificationSound() {
            return new VasLogReportProxy("vas_notification_sound");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getProfileCard() {
            return new VasLogReportProxy("profile_card");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getQzoneCover() {
            return new VasLogReportProxy("qzone_exception");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getQzoneFeedsCard() {
            return new VasLogReportProxy("qzone_feeds_card");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getQzoneVip() {
            return new VasLogReportProxy("qzone_vip");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getSuperTheme() {
            return new VasLogReportProxy("vas_super_theme");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getTheme() {
            return new VasLogReportProxy("vas_theme_switch");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getTroopKeyWord() {
            return new VasLogReportProxy("troop_key_work");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVasGift() {
            return new VasLogReportProxy("gift_panel");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVasUpdateKeyWord() {
            return new VasLogReportProxy("vas_update_manager");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipColorName() {
            return new VasLogReportProxy("color_name");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipData() {
            return new VasLogReportProxy("vip_data");
        }

        Companion() {
        }
    }

    VasLogReporter(String str) {
        this.reportTag = str;
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getAppIcon() {
        return INSTANCE.getAppIcon();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getAvatarPendant() {
        return INSTANCE.getAvatarPendant();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getBirthGift() {
        return INSTANCE.getBirthGift();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getBubble() {
        return INSTANCE.getBubble();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getChatBackground() {
        return INSTANCE.getChatBackground();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getChatBackgroundJsb() {
        return INSTANCE.getChatBackgroundJsb();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getDownload() {
        return INSTANCE.getDownload();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getDynamicDrawable() {
        return INSTANCE.getDynamicDrawable();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getFont() {
        return INSTANCE.getFont();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getLoveChat() {
        return INSTANCE.getLoveChat();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getNotificationSound() {
        return INSTANCE.getNotificationSound();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getProfileCard() {
        return INSTANCE.getProfileCard();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getQzoneCover() {
        return INSTANCE.getQzoneCover();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getQzoneFeedsCard() {
        return INSTANCE.getQzoneFeedsCard();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getQzoneVip() {
        return INSTANCE.getQzoneVip();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getSuperTheme() {
        return INSTANCE.getSuperTheme();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getTheme() {
        return INSTANCE.getTheme();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getTroopKeyWord() {
        return INSTANCE.getTroopKeyWord();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVasGift() {
        return INSTANCE.getVasGift();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVasUpdateKeyWord() {
        return INSTANCE.getVasUpdateKeyWord();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipColorName() {
        return INSTANCE.getVipColorName();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipData() {
        return INSTANCE.getVipData();
    }

    @NotNull
    public final String getReportTag() {
        return this.reportTag;
    }
}
