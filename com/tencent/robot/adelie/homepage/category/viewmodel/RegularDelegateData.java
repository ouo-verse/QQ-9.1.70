package com.tencent.robot.adelie.homepage.category.viewmodel;

import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/f;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "data", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tabName", "tabId", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RegularDelegateData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotCoreInfo data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegularDelegateData(@NotNull RobotCoreInfo data, @NotNull String tabName, @NotNull String tabId) {
        super(RecommendCardType.REGULAR);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        this.data = data;
        this.tabName = tabName;
        this.tabId = tabId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RobotCoreInfo getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTabId() {
        return this.tabId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegularDelegateData)) {
            return false;
        }
        RegularDelegateData regularDelegateData = (RegularDelegateData) other;
        if (Intrinsics.areEqual(this.data, regularDelegateData.data) && Intrinsics.areEqual(this.tabName, regularDelegateData.tabName) && Intrinsics.areEqual(this.tabId, regularDelegateData.tabId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + this.tabName.hashCode()) * 31) + this.tabId.hashCode();
    }

    @NotNull
    public String toString() {
        return "RegularDelegateData(data=" + this.data + ", tabName=" + this.tabName + ", tabId=" + this.tabId + ")";
    }
}
