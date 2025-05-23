package com.tencent.mobileqq.zootopia;

import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Profile' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b5\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zootopia/Source;", "", "value", "", "isRootEntry", "", "(Ljava/lang/String;IIZ)V", "()Z", HippyTextInputController.COMMAND_getValue, "()I", "UnSet", "None", "Demo", "Conversation", "Emoticon", "DynamicEntry", "ProfileEntry", "Notification", "Ark", "H5", QzoneConfig.SECONDARY_AVATAR_SETTING, "RedPacket", "RedPacketEx", "AIOEntry", IAnimationFactory.AnimationType.f70702GROUP, "Beancurd", "LebaEntry", "SetCover", "StatusSquare", "AvatarEdit", "QzoneFeedTail", "DRAWER", "MiniHome", "UserCenter", "FetchSilver", "BuyButton", "AvatarRoleRight", "AvatarRoleFirstDialog", "AvatarParadiseBanner", "AvatarParadisePicCard", "AvatarParadiseVideoCard", "AvatarParadiseDownloadManager", "AvatarSuperQQShow", "AvatarCoupleAvatar", "Dynamic", "PortalActivity", "Profile", "ZootopiaActivity", "ZootopiaUEActivity", "TemplateEntrance", "TemplatePreview", "ZPlantChangeRoleEntrance", "SmallPanel", "QavEntrance", "StorageScan", "AIGCPreview", "XiaoWoDress", "DRAWER_PORTAL", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class Source {
    public static final Source AIGCPreview;
    public static final Source DRAWER_PORTAL;
    public static final Source Profile;
    public static final Source QavEntrance;
    public static final Source SmallPanel;
    public static final Source StorageScan;
    public static final Source TemplateEntrance;
    public static final Source TemplatePreview;
    public static final Source XiaoWoDress;
    public static final Source ZPlantChangeRoleEntrance;
    public static final Source ZootopiaActivity;
    public static final Source ZootopiaUEActivity;
    private final boolean isRootEntry;
    private final int value;
    public static final Source UnSet = new Source("UnSet", 0, -1, true);
    public static final Source None = new Source("None", 1, 0, true);
    public static final Source Demo = new Source("Demo", 2, 1000, true);
    public static final Source Conversation = new Source("Conversation", 3, 1001, true);
    public static final Source Emoticon = new Source("Emoticon", 4, 1002, true);
    public static final Source DynamicEntry = new Source("DynamicEntry", 5, 1003, true);
    public static final Source ProfileEntry = new Source("ProfileEntry", 6, 1004, true);
    public static final Source Notification = new Source("Notification", 7, 1005, true);
    public static final Source Ark = new Source("Ark", 8, 1006, true);
    public static final Source H5 = new Source("H5", 9, 1007, true);
    public static final Source AvatarSetting = new Source(QzoneConfig.SECONDARY_AVATAR_SETTING, 10, 1008, true);
    public static final Source RedPacket = new Source("RedPacket", 11, 1009, true);
    public static final Source RedPacketEx = new Source("RedPacketEx", 12, 1010, true);
    public static final Source AIOEntry = new Source("AIOEntry", 13, 1011, true);
    public static final Source Group = new Source(IAnimationFactory.AnimationType.f70702GROUP, 14, 1012, true);
    public static final Source Beancurd = new Source("Beancurd", 15, 1013, true);
    public static final Source LebaEntry = new Source("LebaEntry", 16, 1014, true);
    public static final Source SetCover = new Source("SetCover", 17, 1015, true);
    public static final Source StatusSquare = new Source("StatusSquare", 18, 1016, true);
    public static final Source AvatarEdit = new Source("AvatarEdit", 19, 1017, true);
    public static final Source QzoneFeedTail = new Source("QzoneFeedTail", 20, 1018, true);
    public static final Source DRAWER = new Source("DRAWER", 21, 1019, true);
    public static final Source MiniHome = new Source("MiniHome", 22, 1020, true);
    public static final Source UserCenter = new Source("UserCenter", 23, 2000, true);
    public static final Source FetchSilver = new Source("FetchSilver", 24, 2001, true);
    public static final Source BuyButton = new Source("BuyButton", 25, 2002, true);
    public static final Source AvatarRoleRight = new Source("AvatarRoleRight", 26, 3001, true);
    public static final Source AvatarRoleFirstDialog = new Source("AvatarRoleFirstDialog", 27, 3002, true);
    public static final Source AvatarParadiseBanner = new Source("AvatarParadiseBanner", 28, 3003, true);
    public static final Source AvatarParadisePicCard = new Source("AvatarParadisePicCard", 29, 3004, true);
    public static final Source AvatarParadiseVideoCard = new Source("AvatarParadiseVideoCard", 30, 3005, true);
    public static final Source AvatarParadiseDownloadManager = new Source("AvatarParadiseDownloadManager", 31, 3009, true);
    public static final Source AvatarSuperQQShow = new Source("AvatarSuperQQShow", 32, 3010, true);
    public static final Source AvatarCoupleAvatar = new Source("AvatarCoupleAvatar", 33, 3011, true);
    public static final Source Dynamic = new Source("Dynamic", 34, 1, false, 2, null);
    public static final Source PortalActivity = new Source("PortalActivity", 35, 2, false, 2, null);
    private static final /* synthetic */ Source[] $VALUES = $values();

    private static final /* synthetic */ Source[] $values() {
        return new Source[]{UnSet, None, Demo, Conversation, Emoticon, DynamicEntry, ProfileEntry, Notification, Ark, H5, AvatarSetting, RedPacket, RedPacketEx, AIOEntry, Group, Beancurd, LebaEntry, SetCover, StatusSquare, AvatarEdit, QzoneFeedTail, DRAWER, MiniHome, UserCenter, FetchSilver, BuyButton, AvatarRoleRight, AvatarRoleFirstDialog, AvatarParadiseBanner, AvatarParadisePicCard, AvatarParadiseVideoCard, AvatarParadiseDownloadManager, AvatarSuperQQShow, AvatarCoupleAvatar, Dynamic, PortalActivity, Profile, ZootopiaActivity, ZootopiaUEActivity, TemplateEntrance, TemplatePreview, ZPlantChangeRoleEntrance, SmallPanel, QavEntrance, StorageScan, AIGCPreview, XiaoWoDress, DRAWER_PORTAL};
    }

    static {
        boolean z16 = false;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Profile = new Source("Profile", 36, 3, z16, i3, defaultConstructorMarker);
        boolean z17 = false;
        int i16 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        ZootopiaActivity = new Source("ZootopiaActivity", 37, 4, z17, i16, defaultConstructorMarker2);
        ZootopiaUEActivity = new Source("ZootopiaUEActivity", 38, 5, z16, i3, defaultConstructorMarker);
        TemplateEntrance = new Source("TemplateEntrance", 39, 6, z17, i16, defaultConstructorMarker2);
        TemplatePreview = new Source("TemplatePreview", 40, 7, z16, i3, defaultConstructorMarker);
        ZPlantChangeRoleEntrance = new Source("ZPlantChangeRoleEntrance", 41, 8, z17, i16, defaultConstructorMarker2);
        SmallPanel = new Source("SmallPanel", 42, 9, z16, i3, defaultConstructorMarker);
        QavEntrance = new Source("QavEntrance", 43, 10, z17, i16, defaultConstructorMarker2);
        StorageScan = new Source("StorageScan", 44, 11, z16, i3, defaultConstructorMarker);
        AIGCPreview = new Source("AIGCPreview", 45, 12, z17, i16, defaultConstructorMarker2);
        XiaoWoDress = new Source("XiaoWoDress", 46, 13, z16, i3, defaultConstructorMarker);
        DRAWER_PORTAL = new Source("DRAWER_PORTAL", 47, 14, z17, i16, defaultConstructorMarker2);
    }

    Source(String str, int i3, int i16, boolean z16) {
        this.value = i16;
        this.isRootEntry = z16;
    }

    public static Source valueOf(String str) {
        return (Source) Enum.valueOf(Source.class, str);
    }

    public static Source[] values() {
        return (Source[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: isRootEntry, reason: from getter */
    public final boolean getIsRootEntry() {
        return this.isRootEntry;
    }

    /* synthetic */ Source(String str, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, (i17 & 2) != 0 ? false : z16);
    }
}
