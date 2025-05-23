package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.ImageInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0002\"#B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/data/o;", "Lcom/tencent/robot/profile/data/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "title", "", "Lcom/tencent/robot/profile/data/o$b;", "j", "Ljava/util/List;", "()Ljava/util/List;", "usageList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Ljava/util/List;)V", "k", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.o, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileUsagePreviewData extends g {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
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
    private final List<RobotUsage> usageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/profile/data/o$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/h;", "color", "Lcom/tencent/robot/profile/data/o;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.o$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotProfileUsagePreviewData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull GroupRobotProfile robotProfile, @NotNull RobotProfileColor color) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            Intrinsics.checkNotNullParameter(color, "color");
            ArrayList arrayList = new ArrayList();
            ArrayList<ImageInfo> arrayList2 = robotProfile.previewImages;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "robotProfile.previewImages");
            for (ImageInfo it : arrayList2) {
                RobotUsage.Companion companion = RobotUsage.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(companion.a(it));
            }
            String str = robotProfile.previewImagesTitle;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.previewImagesTitle");
            return new RobotProfileUsagePreviewData(robotUin, troopUin, color, str, arrayList);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/data/o$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "b", "url", "c", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.o$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RobotUsage {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/data/o$b$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ImageInfo;", "imageItem", "Lcom/tencent/robot/profile/data/o$b;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.profile.data.o$b$a, reason: from kotlin metadata */
        /* loaded from: classes25.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final RobotUsage a(@NotNull ImageInfo imageItem) {
                Intrinsics.checkNotNullParameter(imageItem, "imageItem");
                String str = imageItem.imageUrl;
                Intrinsics.checkNotNullExpressionValue(str, "imageItem.imageUrl");
                String str2 = imageItem.desc;
                Intrinsics.checkNotNullExpressionValue(str2, "imageItem.desc");
                return new RobotUsage("", str, str2);
            }

            Companion() {
            }
        }

        public RobotUsage(@NotNull String id5, @NotNull String url, @NotNull String name) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id5;
            this.url = url;
            this.name = name;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RobotUsage)) {
                return false;
            }
            RobotUsage robotUsage = (RobotUsage) other;
            if (Intrinsics.areEqual(this.id, robotUsage.id) && Intrinsics.areEqual(this.url, robotUsage.url) && Intrinsics.areEqual(this.name, robotUsage.name)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "RobotUsage(id=" + this.id + ", url=" + this.url + ", name=" + this.name + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileUsagePreviewData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String title, @NotNull List<RobotUsage> usageList) {
        super("UsagePreview", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(usageList, "usageList");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.title = title;
        this.usageList = usageList;
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
        if (!(other instanceof RobotProfileUsagePreviewData)) {
            return false;
        }
        RobotProfileUsagePreviewData robotProfileUsagePreviewData = (RobotProfileUsagePreviewData) other;
        if (Intrinsics.areEqual(getRobotUin(), robotProfileUsagePreviewData.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), robotProfileUsagePreviewData.getTroopUin()) && Intrinsics.areEqual(getColor(), robotProfileUsagePreviewData.getColor()) && Intrinsics.areEqual(this.title, robotProfileUsagePreviewData.title) && Intrinsics.areEqual(this.usageList, robotProfileUsagePreviewData.usageList)) {
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
    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.title.hashCode()) * 31) + this.usageList.hashCode();
    }

    @NotNull
    public final List<RobotUsage> i() {
        return this.usageList;
    }

    @NotNull
    public String toString() {
        return "RobotProfileUsagePreviewData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", title=" + this.title + ", usageList=" + this.usageList + ")";
    }
}
