package com.tencent.mobileqq.troop.flame.surprise;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurprisePag;", "", "", "pagUrl", "Ljava/lang/String;", "getPagUrl", "()Ljava/lang/String;", "lottieUrl", "getLottieUrl", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "DEFAULT", "FIRST", "SECOND", "THIRD", "FIRST2SECOND", "FIRST2THIRD", "SECOND2THIRD", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameSurprisePag {
    private static final /* synthetic */ TroopFlameSurprisePag[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final TroopFlameSurprisePag DEFAULT;
    public static final TroopFlameSurprisePag FIRST;
    public static final TroopFlameSurprisePag FIRST2SECOND;
    public static final TroopFlameSurprisePag FIRST2THIRD;
    public static final TroopFlameSurprisePag SECOND;
    public static final TroopFlameSurprisePag SECOND2THIRD;
    public static final TroopFlameSurprisePag THIRD;

    @NotNull
    private final String lottieUrl;

    @NotNull
    private final String pagUrl;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurprisePag$a;", "", "", "isUseLottie", "", "levelHasShow", "curLevel", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.surprise.TroopFlameSurprisePag$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        public final String a(boolean isUseLottie, int levelHasShow, int curLevel) {
            TroopFlameSurprisePag troopFlameSurprisePag;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isUseLottie), Integer.valueOf(levelHasShow), Integer.valueOf(curLevel));
            }
            if (levelHasShow == 0 && curLevel == 1) {
                troopFlameSurprisePag = TroopFlameSurprisePag.FIRST;
            } else if (levelHasShow == 0 && curLevel == 2) {
                troopFlameSurprisePag = TroopFlameSurprisePag.SECOND;
            } else if (levelHasShow == 0 && curLevel == 3) {
                troopFlameSurprisePag = TroopFlameSurprisePag.THIRD;
            } else if (levelHasShow == 1 && curLevel == 2) {
                troopFlameSurprisePag = TroopFlameSurprisePag.FIRST2SECOND;
            } else if (levelHasShow == 1 && curLevel == 3) {
                troopFlameSurprisePag = TroopFlameSurprisePag.FIRST2THIRD;
            } else if (levelHasShow == 2 && curLevel == 3) {
                troopFlameSurprisePag = TroopFlameSurprisePag.SECOND2THIRD;
            } else {
                troopFlameSurprisePag = TroopFlameSurprisePag.DEFAULT;
            }
            if (isUseLottie) {
                return troopFlameSurprisePag.getLottieUrl();
            }
            return troopFlameSurprisePag.getPagUrl();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ TroopFlameSurprisePag[] $values() {
        return new TroopFlameSurprisePag[]{DEFAULT, FIRST, SECOND, THIRD, FIRST2SECOND, FIRST2THIRD, SECOND2THIRD};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        DEFAULT = new TroopFlameSurprisePag("DEFAULT", 0, "", "");
        FIRST = new TroopFlameSurprisePag("FIRST", 1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_first_v1.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_first_v1.json");
        SECOND = new TroopFlameSurprisePag("SECOND", 2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_first_v2.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_first_v2.json");
        THIRD = new TroopFlameSurprisePag("THIRD", 3, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_first_v3.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_first_v3.json");
        FIRST2SECOND = new TroopFlameSurprisePag("FIRST2SECOND", 4, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_upgrade_1to2.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_upgrade_1to2.json");
        FIRST2THIRD = new TroopFlameSurprisePag("FIRST2THIRD", 5, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_upgrade_1to3.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_upgrade_1to3.json");
        SECOND2THIRD = new TroopFlameSurprisePag("SECOND2THIRD", 6, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_caidan_upgrade_2to3.pag", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9060/group_flame/image/qecommerce_group_flame_caidan_upgrade_2to3.json");
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    TroopFlameSurprisePag(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            this.pagUrl = str2;
            this.lottieUrl = str3;
        }
    }

    public static TroopFlameSurprisePag valueOf(String str) {
        return (TroopFlameSurprisePag) Enum.valueOf(TroopFlameSurprisePag.class, str);
    }

    public static TroopFlameSurprisePag[] values() {
        return (TroopFlameSurprisePag[]) $VALUES.clone();
    }

    @NotNull
    public final String getLottieUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.lottieUrl;
    }

    @NotNull
    public final String getPagUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pagUrl;
    }
}
