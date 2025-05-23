package com.tencent.robot.adelie.homepage.category.viewmodel;

import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\nB9\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0011\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;", "a", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;", "c", "()Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;", "type", "", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "b", "Ljava/util/List;", "()Ljava/util/List;", "data", "Z", "e", "()Z", "isFirstSection", "d", "isEnd", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "guideInfo", "<init>", "(Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;Ljava/util/List;ZZLcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;)V", "f", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RecommondPageData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PageDataType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<a> data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFirstSection;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final RobotGuideInfo guideInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/e$a;", "", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/e;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.e$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommondPageData a() {
            return new RecommondPageData(PageDataType.LOADING, new ArrayList(), true, true, null, 16, null);
        }

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecommondPageData(@NotNull PageDataType type, @NotNull List<? extends a> data, boolean z16, boolean z17, @Nullable RobotGuideInfo robotGuideInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        this.type = type;
        this.data = data;
        this.isFirstSection = z16;
        this.isEnd = z17;
        this.guideInfo = robotGuideInfo;
    }

    @NotNull
    public final List<a> a() {
        return this.data;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final RobotGuideInfo getGuideInfo() {
        return this.guideInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final PageDataType getType() {
        return this.type;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFirstSection() {
        return this.isFirstSection;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommondPageData)) {
            return false;
        }
        RecommondPageData recommondPageData = (RecommondPageData) other;
        if (this.type == recommondPageData.type && Intrinsics.areEqual(this.data, recommondPageData.data) && this.isFirstSection == recommondPageData.isFirstSection && this.isEnd == recommondPageData.isEnd && Intrinsics.areEqual(this.guideInfo, recommondPageData.guideInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.type.hashCode() * 31) + this.data.hashCode()) * 31;
        boolean z16 = this.isFirstSection;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isEnd;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        RobotGuideInfo robotGuideInfo = this.guideInfo;
        if (robotGuideInfo == null) {
            hashCode = 0;
        } else {
            hashCode = robotGuideInfo.hashCode();
        }
        return i18 + hashCode;
    }

    @NotNull
    public String toString() {
        return "RecommondPageData(type=" + this.type + ", data=" + this.data + ", isFirstSection=" + this.isFirstSection + ", isEnd=" + this.isEnd + ", guideInfo=" + this.guideInfo + ")";
    }

    public /* synthetic */ RecommondPageData(PageDataType pageDataType, List list, boolean z16, boolean z17, RobotGuideInfo robotGuideInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageDataType, list, z16, z17, (i3 & 16) != 0 ? null : robotGuideInfo);
    }
}
