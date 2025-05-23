package com.tencent.robot.profile.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.PanelItem;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotPanelInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0002()B=\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0012\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/profile/data/k;", "Lcom/tencent/robot/profile/data/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "title", "", "Lcom/tencent/robot/profile/data/k$b;", "j", "Ljava/util/List;", "()Ljava/util/List;", "serviceList", "Lcom/tencent/robot/profile/data/d;", "k", "Lcom/tencent/robot/profile/data/d;", "getRelationShip", "()Lcom/tencent/robot/profile/data/d;", "relationShip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Ljava/util/List;Lcom/tencent/robot/profile/data/d;)V", "l", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.k, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileMyServiceData extends g {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileColor color;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<RobotService> serviceList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d relationShip;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/data/k$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/h;", "color", "Lcom/tencent/robot/profile/data/d;", "relationShip", "Lcom/tencent/robot/profile/data/k;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.k$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotProfileMyServiceData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull GroupRobotProfile robotProfile, @NotNull RobotProfileColor color, @NotNull d relationShip) {
            boolean z16;
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(relationShip, "relationShip");
            RobotPanelInfo robotPanelInfo = robotProfile.panels.get(0);
            ArrayList arrayList = new ArrayList();
            ArrayList<PanelItem> arrayList2 = robotPanelInfo.items;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "panelInfo.items");
            for (PanelItem it : arrayList2) {
                RobotService.Companion companion = RobotService.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean z17 = true;
                if (troopUin.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 || Intrinsics.areEqual(troopUin, "0")) {
                    z17 = false;
                }
                RobotBaseInfo robotBaseInfo = robotProfile.robotData;
                Intrinsics.checkNotNullExpressionValue(robotBaseInfo, "robotProfile.robotData");
                arrayList.add(companion.a(it, z17, relationShip, robotBaseInfo));
            }
            String str = robotProfile.panelTitle;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.panelTitle");
            return new RobotProfileMyServiceData(robotUin, troopUin, color, str, arrayList, relationShip);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001\u0003Bg\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0017\u0010&\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b!\u0010$\u001a\u0004\b\u001f\u0010%R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u000e\u0010\u0019R\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b\u0011\u0010\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/profile/data/k$b;", "", "", "a", "", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "b", "f", "name", "c", "e", "desc", "d", tl.h.F, "settingUrl", "Z", "j", "()Z", "isSet", "I", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "status", "g", "availableRangeDesc", "i", "isFromTroop", "Lcom/tencent/robot/profile/data/d;", "Lcom/tencent/robot/profile/data/d;", "()Lcom/tencent/robot/profile/data/d;", "relationShip", "allowAddC2C", "k", "allowAddGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;ZLcom/tencent/robot/profile/data/d;ZZ)V", "l", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.k$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotService {

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String desc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String settingUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSet;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int status;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String availableRangeDesc;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFromTroop;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final d relationShip;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean allowAddC2C;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean allowAddGroup;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/profile/data/k$b$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PanelItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "isFromTroop", "Lcom/tencent/robot/profile/data/d;", "relationShip", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBaseInfo;", "robotBaseInfo", "Lcom/tencent/robot/profile/data/k$b;", "a", "", "STATUS_CAN_USE", "I", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.profile.data.k$b$a, reason: from kotlin metadata */
        /* loaded from: classes25.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final RobotService a(@NotNull PanelItem item, boolean isFromTroop, @NotNull d relationShip, @NotNull RobotBaseInfo robotBaseInfo) {
                boolean z16;
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(relationShip, "relationShip");
                Intrinsics.checkNotNullParameter(robotBaseInfo, "robotBaseInfo");
                String valueOf = String.valueOf(item.pId);
                String str = item.offInfo.name;
                Intrinsics.checkNotNullExpressionValue(str, "item.offInfo.name");
                String str2 = item.desc;
                Intrinsics.checkNotNullExpressionValue(str2, "item.desc");
                String str3 = item.settingUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "item.settingUrl");
                if (item.isSet != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int i3 = item.status;
                String str4 = item.availableRangeDesc;
                Intrinsics.checkNotNullExpressionValue(str4, "item.availableRangeDesc");
                return new RobotService(valueOf, str, str2, str3, z16, i3, str4, isFromTroop, relationShip, robotBaseInfo.allowedAddC2C, robotBaseInfo.allowedAddGroup);
            }

            Companion() {
            }
        }

        public RobotService(@NotNull String id5, @NotNull String name, @NotNull String desc, @NotNull String settingUrl, boolean z16, int i3, @NotNull String availableRangeDesc, boolean z17, @NotNull d relationShip, boolean z18, boolean z19) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(settingUrl, "settingUrl");
            Intrinsics.checkNotNullParameter(availableRangeDesc, "availableRangeDesc");
            Intrinsics.checkNotNullParameter(relationShip, "relationShip");
            this.id = id5;
            this.name = name;
            this.desc = desc;
            this.settingUrl = settingUrl;
            this.isSet = z16;
            this.status = i3;
            this.availableRangeDesc = availableRangeDesc;
            this.isFromTroop = z17;
            this.relationShip = relationShip;
            this.allowAddC2C = z18;
            this.allowAddGroup = z19;
        }

        public final boolean a() {
            if (this.status == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getAllowAddC2C() {
            return this.allowAddC2C;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getAllowAddGroup() {
            return this.allowAddGroup;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getAvailableRangeDesc() {
            return this.availableRangeDesc;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RobotService)) {
                return false;
            }
            RobotService robotService = (RobotService) other;
            if (Intrinsics.areEqual(this.id, robotService.id) && Intrinsics.areEqual(this.name, robotService.name) && Intrinsics.areEqual(this.desc, robotService.desc) && Intrinsics.areEqual(this.settingUrl, robotService.settingUrl) && this.isSet == robotService.isSet && this.status == robotService.status && Intrinsics.areEqual(this.availableRangeDesc, robotService.availableRangeDesc) && this.isFromTroop == robotService.isFromTroop && Intrinsics.areEqual(this.relationShip, robotService.relationShip) && this.allowAddC2C == robotService.allowAddC2C && this.allowAddGroup == robotService.allowAddGroup) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final d getRelationShip() {
            return this.relationShip;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getSettingUrl() {
            return this.settingUrl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.settingUrl.hashCode()) * 31;
            boolean z16 = this.isSet;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int hashCode2 = (((((hashCode + i16) * 31) + this.status) * 31) + this.availableRangeDesc.hashCode()) * 31;
            boolean z17 = this.isFromTroop;
            int i17 = z17;
            if (z17 != 0) {
                i17 = 1;
            }
            int hashCode3 = (((hashCode2 + i17) * 31) + this.relationShip.hashCode()) * 31;
            boolean z18 = this.allowAddC2C;
            int i18 = z18;
            if (z18 != 0) {
                i18 = 1;
            }
            int i19 = (hashCode3 + i18) * 31;
            boolean z19 = this.allowAddGroup;
            if (!z19) {
                i3 = z19 ? 1 : 0;
            }
            return i19 + i3;
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsFromTroop() {
            return this.isFromTroop;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsSet() {
            return this.isSet;
        }

        @NotNull
        public String toString() {
            return "RobotService(id=" + this.id + ", name=" + this.name + ", desc=" + this.desc + ", settingUrl=" + this.settingUrl + ", isSet=" + this.isSet + ", status=" + this.status + ", availableRangeDesc=" + this.availableRangeDesc + ", isFromTroop=" + this.isFromTroop + ", relationShip=" + this.relationShip + ", allowAddC2C=" + this.allowAddC2C + ", allowAddGroup=" + this.allowAddGroup + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileMyServiceData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String title, @NotNull List<RobotService> serviceList, @NotNull d relationShip) {
        super("MyService", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(serviceList, "serviceList");
        Intrinsics.checkNotNullParameter(relationShip, "relationShip");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.title = title;
        this.serviceList = serviceList;
        this.relationShip = relationShip;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: c, reason: from getter */
    public RobotProfileColor getColor() {
        return this.color;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    @Override // com.tencent.robot.profile.data.g
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileMyServiceData)) {
            return false;
        }
        RobotProfileMyServiceData robotProfileMyServiceData = (RobotProfileMyServiceData) other;
        if (Intrinsics.areEqual(getRobotUin(), robotProfileMyServiceData.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), robotProfileMyServiceData.getTroopUin()) && Intrinsics.areEqual(getColor(), robotProfileMyServiceData.getColor()) && Intrinsics.areEqual(this.title, robotProfileMyServiceData.title) && Intrinsics.areEqual(this.serviceList, robotProfileMyServiceData.serviceList) && Intrinsics.areEqual(this.relationShip, robotProfileMyServiceData.relationShip)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    public final List<RobotService> h() {
        return this.serviceList;
    }

    public int hashCode() {
        return (((((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.title.hashCode()) * 31) + this.serviceList.hashCode()) * 31) + this.relationShip.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public String toString() {
        return "RobotProfileMyServiceData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", title=" + this.title + ", serviceList=" + this.serviceList + ", relationShip=" + this.relationShip + ")";
    }
}
