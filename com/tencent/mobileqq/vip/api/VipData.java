package com.tencent.mobileqq.vip.api;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.DiyVipIconDownloadBusiness;
import com.tencent.pb.vipdata.userdata$NumberItem;
import com.tencent.pb.vipdata.userdata$UserData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b?\b\u0087\b\u0018\u0000 X2\u00020\u0001:\u0002YZB\u00cb\u0001\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u000b\u0012\b\b\u0002\u0010*\u001a\u00020\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\b\b\u0002\u00100\u001a\u00020\u000b\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\u001c\u0012\b\b\u0002\u00102\u001a\u00020\u000b\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0010\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u00a2\u0006\u0004\bV\u0010WJ\t\u0010\u0003\u001a\u00020\u0002H\u00c2\u0003J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\t\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u00c6\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\u0002H\u00c6\u0003J\t\u0010!\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0002H\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0002H\u00c6\u0003J\u00d4\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u00142\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\u001c2\b\b\u0002\u00102\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u00102\b\b\u0002\u00105\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b8\u00109J\t\u0010:\u001a\u00020\u0004H\u00d6\u0001J\t\u0010;\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010=\u001a\u00020\u00022\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010>\u001a\u0004\b%\u0010?R\u0017\u0010&\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b'\u0010>\u001a\u0004\b'\u0010?R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010>R\u0017\u0010)\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010*\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010+\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b+\u0010C\u001a\u0004\bI\u0010ER\u0017\u0010,\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b,\u0010C\u001a\u0004\bJ\u0010ER\u0017\u0010-\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b-\u0010C\u001a\u0004\bK\u0010ER\u0017\u0010.\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b.\u0010C\u001a\u0004\bL\u0010ER\u0017\u0010/\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b/\u0010C\u001a\u0004\bM\u0010ER\u0017\u00100\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b0\u0010C\u001a\u0004\bN\u0010ER\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b1\u0010O\u001a\u0004\bP\u0010\u001eR\u0017\u00102\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b2\u0010C\u001a\u0004\bQ\u0010ER\u0017\u00103\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b3\u0010>\u001a\u0004\bR\u0010?R\u0017\u00104\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b4\u0010@\u001a\u0004\bS\u0010BR\u0017\u00105\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b5\u0010>\u001a\u0004\b5\u0010?R\u0017\u00106\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b6\u0010C\u001a\u0004\bT\u0010ER\u0017\u00107\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b7\u0010>\u001a\u0004\bU\u0010?\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/vip/api/VipData;", "", "", "component4", "", "toJson", "isLetterSwitchAvailable", "curFaceId", "isMoonAvatar", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo$APPID;", "appId", "", "itemId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "getVipNumberInfo", "component1", "", "component2", "component3", "component5", "", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "", "component13", "()[Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "component14", "component15", "component16", "component17", "component18", "component19", "isSplendid", "nvalue", "isSplendidCard", "nameplateLetterOpen", "nameplateItemId", "nameplateLetters", "nameplateFgId", "appIconId", "avatarType", "faceItemId", "loveChatItemId", "colorName", "vipNumberInfos", "pendantItemId", "pendantIsVip", "kingVipType", "isWzryVip", "specialAvatarId", "useDefaultNickColor", "copy", "(ZJZZI[IIIIIII[Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;IZJZIZ)Lcom/tencent/mobileqq/vip/api/VipData;", "toString", "hashCode", "other", "equals", "Z", "()Z", "J", "getNvalue", "()J", "I", "getNameplateItemId", "()I", "[I", "getNameplateLetters", "()[I", "getNameplateFgId", "getAppIconId", "getAvatarType", "getFaceItemId", "getLoveChatItemId", "getColorName", "[Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "getVipNumberInfos", "getPendantItemId", "getPendantIsVip", "getKingVipType", "getSpecialAvatarId", "getUseDefaultNickColor", "<init>", "(ZJZZI[IIIIIII[Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;IZJZIZ)V", "Companion", "a", "VipNumberInfo", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class VipData {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String VERSION;

    @NotNull
    private static final Gson gson;
    private final int appIconId;
    private final int avatarType;
    private final int colorName;
    private final int faceItemId;
    private final boolean isSplendid;
    private final boolean isSplendidCard;
    private final boolean isWzryVip;
    private final long kingVipType;
    private final int loveChatItemId;
    private final int nameplateFgId;
    private final int nameplateItemId;
    private final boolean nameplateLetterOpen;

    @NotNull
    private final int[] nameplateLetters;
    private final long nvalue;
    private final boolean pendantIsVip;
    private final int pendantItemId;
    private final int specialAvatarId;
    private final boolean useDefaultNickColor;

    @NotNull
    private final VipNumberInfo[] vipNumberInfos;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "", "()V", "appId", "", "getAppId", "()I", "setAppId", "(I)V", "isLongNumber", "", "()Z", "setLongNumber", "(Z)V", "itemId", "getItemId", "setItemId", "numberIdx", "getNumberIdx", "setNumberIdx", "numberItemId", "getNumberItemId", "setNumberItemId", "APPID", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class VipNumberInfo {
        static IPatchRedirector $redirector_;
        private int appId;
        private boolean isLongNumber;
        private int itemId;
        private int numberIdx;
        private int numberItemId;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo$APPID;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "Theme", "ProfileCard", AegisLogger.PENDANT, "Avatar", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes20.dex */
        public static final class APPID {
            private static final /* synthetic */ APPID[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final APPID Avatar;
            public static final APPID Pendant;
            public static final APPID ProfileCard;
            public static final APPID Theme;
            private final int id;

            private static final /* synthetic */ APPID[] $values() {
                return new APPID[]{Theme, ProfileCard, Pendant, Avatar};
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39988);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 3)) {
                    redirector.redirect((short) 3);
                    return;
                }
                Theme = new APPID("Theme", 0, 3);
                ProfileCard = new APPID("ProfileCard", 1, 15);
                Pendant = new APPID(AegisLogger.PENDANT, 2, 4);
                Avatar = new APPID("Avatar", 3, 23);
                $VALUES = $values();
            }

            APPID(String str, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    this.id = i16;
                }
            }

            public static APPID valueOf(String str) {
                return (APPID) Enum.valueOf(APPID.class, str);
            }

            public static APPID[] values() {
                return (APPID[]) $VALUES.clone();
            }

            public final int getId() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.id;
            }
        }

        public VipNumberInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int getAppId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.appId;
        }

        public final int getItemId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.itemId;
        }

        public final int getNumberIdx() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.numberIdx;
        }

        public final int getNumberItemId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.numberItemId;
        }

        public final boolean isLongNumber() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.isLongNumber;
        }

        public final void setAppId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.appId = i3;
            }
        }

        public final void setItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.itemId = i3;
            }
        }

        public final void setLongNumber(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.isLongNumber = z16;
            }
        }

        public final void setNumberIdx(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.numberIdx = i3;
            }
        }

        public final void setNumberItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.numberItemId = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005*\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vip/api/VipData$a;", "", "Lcom/tencent/pb/vipdata/userdata$UserData;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "Lkotlin/collections/ArrayList;", "b", "data", "Lcom/tencent/mobileqq/vip/api/VipData;", "a", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.VipData$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        private final ArrayList<VipNumberInfo> b(userdata$UserData userdata_userdata) {
            boolean z16;
            ArrayList<VipNumberInfo> arrayList = new ArrayList<>();
            List<userdata$NumberItem> list = userdata_userdata.number_items.get();
            Intrinsics.checkNotNullExpressionValue(list, "number_items.get()");
            for (userdata$NumberItem userdata_numberitem : list) {
                VipNumberInfo vipNumberInfo = new VipNumberInfo();
                vipNumberInfo.setAppId(userdata_numberitem.item.appid.get());
                vipNumberInfo.setItemId(userdata_numberitem.item.itemid.get());
                vipNumberInfo.setNumberItemId(userdata_numberitem.number_itemid.get());
                vipNumberInfo.setLongNumber(false);
                vipNumberInfo.setNumberIdx(userdata_numberitem.number_idx.get());
                arrayList.add(vipNumberInfo);
            }
            List<userdata$NumberItem> list2 = userdata_userdata.number_items_long.get();
            Intrinsics.checkNotNullExpressionValue(list2, "number_items_long.get()");
            for (userdata$NumberItem userdata_numberitem2 : list2) {
                VipNumberInfo vipNumberInfo2 = new VipNumberInfo();
                vipNumberInfo2.setAppId(userdata_numberitem2.item.appid.get());
                vipNumberInfo2.setItemId(userdata_numberitem2.item.itemid.get());
                vipNumberInfo2.setNumberItemId(userdata_numberitem2.number_itemid.get());
                vipNumberInfo2.setLongNumber(true);
                vipNumberInfo2.setNumberIdx(userdata_numberitem2.number_idx.get());
                Iterator<VipNumberInfo> it = arrayList.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        VipNumberInfo next = it.next();
                        if (next.getAppId() == vipNumberInfo2.getAppId() && next.getItemId() == vipNumberInfo2.getItemId()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 != -1) {
                    arrayList.set(i3, vipNumberInfo2);
                } else {
                    arrayList.add(vipNumberInfo2);
                }
            }
            return arrayList;
        }

        @NotNull
        public final VipData a(@NotNull userdata$UserData data) {
            boolean z16;
            int[] intArray;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (VipData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
            }
            Intrinsics.checkNotNullParameter(data, "data");
            ArrayList<VipNumberInfo> b16 = VipData.INSTANCE.b(data);
            long j3 = data.vip_bitflag.get();
            boolean z18 = data.splendid.isSplendidface.get();
            long j16 = data.splendid.nvalue.get();
            boolean z19 = data.splendid.isSplendidsummarycard.get();
            if (data.nameplate.type.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = data.nameplate.itemid.get();
            List<Integer> list = data.nameplate.content.get();
            Intrinsics.checkNotNullExpressionValue(list, "nameplate.content.get()");
            intArray = CollectionsKt___CollectionsKt.toIntArray(list);
            int i16 = data.nameplate.fgid.get();
            int i17 = data.app_icon.icon_id.get();
            int i18 = data.splendid.avatar_type.get();
            int i19 = data.splendid.face_itemid.get();
            Object[] array = b16.toArray(new VipNumberInfo[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            VipNumberInfo[] vipNumberInfoArr = (VipNumberInfo[]) array;
            int i26 = data.love_chat_frame_info.itemid.get();
            boolean z26 = data.addon.islogo.get();
            int i27 = data.addon.itemid.get();
            int i28 = data.colour_nick.itemid.get();
            boolean z27 = data.colour_nick.is_close.get();
            long j17 = data.vip_bitflag.get();
            int i29 = data.face_maskid.get();
            if ((j3 & 1) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            return new VipData(z18, j16, z19, z16, i3, intArray, i16, i17, i18, i19, i26, i28, vipNumberInfoArr, i27, z26, j17, z17, i29, z27);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
            return;
        }
        INSTANCE = new Companion(null);
        String md5 = MD5.toMD5(new VipData(false, 0L, false, false, 0, null, 0, 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524287, null).toString());
        Intrinsics.checkNotNull(md5);
        VERSION = md5;
        gson = new Gson();
    }

    public VipData() {
        this(false, 0L, false, false, 0, null, 0, 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524287, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            return;
        }
        iPatchRedirector.redirect((short) 47, (Object) this);
    }

    /* renamed from: component4, reason: from getter */
    private final boolean getNameplateLetterOpen() {
        return this.nameplateLetterOpen;
    }

    public final boolean component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.isSplendid;
    }

    public final int component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.faceItemId;
    }

    public final int component11() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.loveChatItemId;
    }

    public final int component12() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.colorName;
    }

    @NotNull
    public final VipNumberInfo[] component13() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (VipNumberInfo[]) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.vipNumberInfos;
    }

    public final int component14() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.pendantItemId;
    }

    public final boolean component15() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return this.pendantIsVip;
    }

    public final long component16() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        return this.kingVipType;
    }

    public final boolean component17() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.isWzryVip;
    }

    public final int component18() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.specialAvatarId;
    }

    public final boolean component19() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.useDefaultNickColor;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return this.nvalue;
    }

    public final boolean component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.isSplendidCard;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.nameplateItemId;
    }

    @NotNull
    public final int[] component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (int[]) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.nameplateLetters;
    }

    public final int component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.nameplateFgId;
    }

    public final int component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.appIconId;
    }

    public final int component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.avatarType;
    }

    @NotNull
    public final VipData copy(boolean isSplendid, long nvalue, boolean isSplendidCard, boolean nameplateLetterOpen, int nameplateItemId, @NotNull int[] nameplateLetters, int nameplateFgId, int appIconId, int avatarType, int faceItemId, int loveChatItemId, int colorName, @NotNull VipNumberInfo[] vipNumberInfos, int pendantItemId, boolean pendantIsVip, long kingVipType, boolean isWzryVip, int specialAvatarId, boolean useDefaultNickColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (VipData) iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(isSplendid), Long.valueOf(nvalue), Boolean.valueOf(isSplendidCard), Boolean.valueOf(nameplateLetterOpen), Integer.valueOf(nameplateItemId), nameplateLetters, Integer.valueOf(nameplateFgId), Integer.valueOf(appIconId), Integer.valueOf(avatarType), Integer.valueOf(faceItemId), Integer.valueOf(loveChatItemId), Integer.valueOf(colorName), vipNumberInfos, Integer.valueOf(pendantItemId), Boolean.valueOf(pendantIsVip), Long.valueOf(kingVipType), Boolean.valueOf(isWzryVip), Integer.valueOf(specialAvatarId), Boolean.valueOf(useDefaultNickColor));
        }
        Intrinsics.checkNotNullParameter(nameplateLetters, "nameplateLetters");
        Intrinsics.checkNotNullParameter(vipNumberInfos, "vipNumberInfos");
        return new VipData(isSplendid, nvalue, isSplendidCard, nameplateLetterOpen, nameplateItemId, nameplateLetters, nameplateFgId, appIconId, avatarType, faceItemId, loveChatItemId, colorName, vipNumberInfos, pendantItemId, pendantIsVip, kingVipType, isWzryVip, specialAvatarId, useDefaultNickColor);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipData)) {
            return false;
        }
        VipData vipData = (VipData) other;
        if (this.isSplendid == vipData.isSplendid && this.nvalue == vipData.nvalue && this.isSplendidCard == vipData.isSplendidCard && this.nameplateLetterOpen == vipData.nameplateLetterOpen && this.nameplateItemId == vipData.nameplateItemId && Intrinsics.areEqual(this.nameplateLetters, vipData.nameplateLetters) && this.nameplateFgId == vipData.nameplateFgId && this.appIconId == vipData.appIconId && this.avatarType == vipData.avatarType && this.faceItemId == vipData.faceItemId && this.loveChatItemId == vipData.loveChatItemId && this.colorName == vipData.colorName && Intrinsics.areEqual(this.vipNumberInfos, vipData.vipNumberInfos) && this.pendantItemId == vipData.pendantItemId && this.pendantIsVip == vipData.pendantIsVip && this.kingVipType == vipData.kingVipType && this.isWzryVip == vipData.isWzryVip && this.specialAvatarId == vipData.specialAvatarId && this.useDefaultNickColor == vipData.useDefaultNickColor) {
            return true;
        }
        return false;
    }

    public final int getAppIconId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.appIconId;
    }

    public final int getAvatarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.avatarType;
    }

    public final int getColorName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.colorName;
    }

    public final int getFaceItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.faceItemId;
    }

    public final long getKingVipType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.kingVipType;
    }

    public final int getLoveChatItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.loveChatItemId;
    }

    public final int getNameplateFgId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.nameplateFgId;
    }

    public final int getNameplateItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.nameplateItemId;
    }

    @NotNull
    public final int[] getNameplateLetters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.nameplateLetters;
    }

    public final long getNvalue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.nvalue;
    }

    public final boolean getPendantIsVip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.pendantIsVip;
    }

    public final int getPendantItemId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.pendantItemId;
    }

    public final int getSpecialAvatarId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.specialAvatarId;
    }

    public final boolean getUseDefaultNickColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.useDefaultNickColor;
    }

    @Nullable
    public final VipNumberInfo getVipNumberInfo(@NotNull VipNumberInfo.APPID appId, int itemId) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (VipNumberInfo) iPatchRedirector.redirect((short) 24, (Object) this, (Object) appId, itemId);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        int id5 = appId.getId();
        for (VipNumberInfo vipNumberInfo : this.vipNumberInfos) {
            if (vipNumberInfo.getAppId() == id5 && vipNumberInfo.getItemId() == itemId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return vipNumberInfo;
            }
        }
        return null;
    }

    @NotNull
    public final VipNumberInfo[] getVipNumberInfos() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (VipNumberInfo[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.vipNumberInfos;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        boolean z16 = this.isSplendid;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.nvalue)) * 31;
        ?? r26 = this.isSplendidCard;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        ?? r27 = this.nameplateLetterOpen;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int hashCode = (((((((((((((((((((((i17 + i18) * 31) + this.nameplateItemId) * 31) + Arrays.hashCode(this.nameplateLetters)) * 31) + this.nameplateFgId) * 31) + this.appIconId) * 31) + this.avatarType) * 31) + this.faceItemId) * 31) + this.loveChatItemId) * 31) + this.colorName) * 31) + Arrays.hashCode(this.vipNumberInfos)) * 31) + this.pendantItemId) * 31;
        ?? r28 = this.pendantIsVip;
        int i19 = r28;
        if (r28 != 0) {
            i19 = 1;
        }
        int a17 = (((hashCode + i19) * 31) + androidx.fragment.app.a.a(this.kingVipType)) * 31;
        ?? r29 = this.isWzryVip;
        int i26 = r29;
        if (r29 != 0) {
            i26 = 1;
        }
        int i27 = (((a17 + i26) * 31) + this.specialAvatarId) * 31;
        boolean z17 = this.useDefaultNickColor;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i27 + i3;
    }

    public final boolean isLetterSwitchAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (BaseApplication.context != null && this.nameplateLetterOpen) {
            DiyVipIconDownloadBusiness diyVipIconDownloadBusiness = (DiyVipIconDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(DiyVipIconDownloadBusiness.class);
            boolean isFileExists = diyVipIconDownloadBusiness.isFileExists(this.nameplateItemId);
            if (!isFileExists) {
                diyVipIconDownloadBusiness.startDownload(this.nameplateItemId);
            }
            return isFileExists;
        }
        return false;
    }

    public final boolean isMoonAvatar(@Nullable String curFaceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) curFaceId)).booleanValue();
        }
        if (curFaceId == null || !Intrinsics.areEqual(curFaceId, String.valueOf(this.faceItemId)) || !VasNtToggle.INSTANCE.getVAS_SPLENDID_AVATAR_CONFIG().isEnable(false) || this.isSplendid || this.avatarType != 1) {
            return false;
        }
        return true;
    }

    public final boolean isSplendid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isSplendid;
    }

    public final boolean isSplendidCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSplendidCard;
    }

    public final boolean isWzryVip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isWzryVip;
    }

    @NotNull
    public final String toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        String json = gson.toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return "VipData(isSplendid=" + this.isSplendid + ", nvalue=" + this.nvalue + ", isSplendidCard=" + this.isSplendidCard + ", nameplateLetterOpen=" + this.nameplateLetterOpen + ", nameplateItemId=" + this.nameplateItemId + ", nameplateLetters=" + Arrays.toString(this.nameplateLetters) + ", nameplateFgId=" + this.nameplateFgId + ", appIconId=" + this.appIconId + ", avatarType=" + this.avatarType + ", faceItemId=" + this.faceItemId + ", loveChatItemId=" + this.loveChatItemId + ", colorName=" + this.colorName + ", vipNumberInfos=" + Arrays.toString(this.vipNumberInfos) + ", pendantItemId=" + this.pendantItemId + ", pendantIsVip=" + this.pendantIsVip + ", kingVipType=" + this.kingVipType + ", isWzryVip=" + this.isWzryVip + ", specialAvatarId=" + this.specialAvatarId + ", useDefaultNickColor=" + this.useDefaultNickColor + ")";
    }

    public VipData(boolean z16, long j3, boolean z17, boolean z18, int i3, @NotNull int[] nameplateLetters, int i16, int i17, int i18, int i19, int i26, int i27, @NotNull VipNumberInfo[] vipNumberInfos, int i28, boolean z19, long j16, boolean z26, int i29, boolean z27) {
        Intrinsics.checkNotNullParameter(nameplateLetters, "nameplateLetters");
        Intrinsics.checkNotNullParameter(vipNumberInfos, "vipNumberInfos");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), nameplateLetters, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), vipNumberInfos, Integer.valueOf(i28), Boolean.valueOf(z19), Long.valueOf(j16), Boolean.valueOf(z26), Integer.valueOf(i29), Boolean.valueOf(z27));
            return;
        }
        this.isSplendid = z16;
        this.nvalue = j3;
        this.isSplendidCard = z17;
        this.nameplateLetterOpen = z18;
        this.nameplateItemId = i3;
        this.nameplateLetters = nameplateLetters;
        this.nameplateFgId = i16;
        this.appIconId = i17;
        this.avatarType = i18;
        this.faceItemId = i19;
        this.loveChatItemId = i26;
        this.colorName = i27;
        this.vipNumberInfos = vipNumberInfos;
        this.pendantItemId = i28;
        this.pendantIsVip = z19;
        this.kingVipType = j16;
        this.isWzryVip = z26;
        this.specialAvatarId = i29;
        this.useDefaultNickColor = z27;
    }

    public /* synthetic */ VipData(boolean z16, long j3, boolean z17, boolean z18, int i3, int[] iArr, int i16, int i17, int i18, int i19, int i26, int i27, VipNumberInfo[] vipNumberInfoArr, int i28, boolean z19, long j16, boolean z26, int i29, boolean z27, int i36, DefaultConstructorMarker defaultConstructorMarker) {
        this((i36 & 1) != 0 ? false : z16, (i36 & 2) != 0 ? 0L : j3, (i36 & 4) != 0 ? false : z17, (i36 & 8) != 0 ? false : z18, (i36 & 16) != 0 ? 0 : i3, (i36 & 32) != 0 ? new int[]{0} : iArr, (i36 & 64) != 0 ? 0 : i16, (i36 & 128) != 0 ? 0 : i17, (i36 & 256) != 0 ? 0 : i18, (i36 & 512) != 0 ? 0 : i19, (i36 & 1024) != 0 ? 0 : i26, (i36 & 2048) != 0 ? 0 : i27, (i36 & 4096) != 0 ? new VipNumberInfo[0] : vipNumberInfoArr, (i36 & 8192) != 0 ? 0 : i28, (i36 & 16384) != 0 ? false : z19, (32768 & i36) != 0 ? 0L : j16, (65536 & i36) != 0 ? false : z26, (131072 & i36) != 0 ? 0 : i29, (262144 & i36) != 0 ? false : z27);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), iArr, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), vipNumberInfoArr, Integer.valueOf(i28), Boolean.valueOf(z19), Long.valueOf(j16), Boolean.valueOf(z26), Integer.valueOf(i29), Boolean.valueOf(z27), Integer.valueOf(i36), defaultConstructorMarker);
    }
}
