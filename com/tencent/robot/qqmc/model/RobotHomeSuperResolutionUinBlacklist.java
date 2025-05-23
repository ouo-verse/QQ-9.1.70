package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/qqmc/model/RobotHomeSuperResolutionUinBlacklist;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "uinBlacklist", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class RobotHomeSuperResolutionUinBlacklist {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<RobotHomeSuperResolutionUinBlacklist> f368212b;

    @SerializedName("uinBlacklist")
    @NotNull
    private final List<String> uinBlacklist;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/qqmc/model/RobotHomeSuperResolutionUinBlacklist$a;", "", "", "", "b", "Lcom/tencent/robot/qqmc/model/RobotHomeSuperResolutionUinBlacklist;", "config$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/robot/qqmc/model/RobotHomeSuperResolutionUinBlacklist;", DownloadInfo.spKey_Config, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.qqmc.model.RobotHomeSuperResolutionUinBlacklist$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final RobotHomeSuperResolutionUinBlacklist a() {
            return (RobotHomeSuperResolutionUinBlacklist) RobotHomeSuperResolutionUinBlacklist.f368212b.getValue();
        }

        public final boolean b(@Nullable String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            return a().b().contains(str);
        }

        Companion() {
        }
    }

    static {
        Lazy<RobotHomeSuperResolutionUinBlacklist> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotHomeSuperResolutionUinBlacklist>() { // from class: com.tencent.robot.qqmc.model.RobotHomeSuperResolutionUinBlacklist$Companion$config$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotHomeSuperResolutionUinBlacklist invoke() {
                return RobotQQMC.INSTANCE.getHomePageSuperResolutionUinBlacklist();
            }
        });
        f368212b = lazy;
    }

    public RobotHomeSuperResolutionUinBlacklist() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<String> b() {
        return this.uinBlacklist;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RobotHomeSuperResolutionUinBlacklist) && Intrinsics.areEqual(this.uinBlacklist, ((RobotHomeSuperResolutionUinBlacklist) other).uinBlacklist)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.uinBlacklist.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotHomeSuperResolutionUinBlacklist(uinBlacklist=" + this.uinBlacklist + ")";
    }

    public RobotHomeSuperResolutionUinBlacklist(@NotNull List<String> uinBlacklist) {
        Intrinsics.checkNotNullParameter(uinBlacklist, "uinBlacklist");
        this.uinBlacklist = uinBlacklist;
    }

    public /* synthetic */ RobotHomeSuperResolutionUinBlacklist(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
