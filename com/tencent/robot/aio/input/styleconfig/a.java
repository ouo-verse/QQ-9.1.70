package com.tencent.robot.aio.input.styleconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/aio/input/styleconfig/a;", "", "other", "", "equals", "", "toString", "e", "d", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "a", "Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "()Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;", "inputStyleType", "", "", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "shortcutIdList", "plusPanelAppIdList", "Z", "f", "()Z", "isSupportSlashPanel", "<init>", "(Lcom/tencent/robot/aio/input/styleconfig/InputStyleType;Ljava/util/List;Ljava/util/List;Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InputStyleType inputStyleType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> shortcutIdList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> plusPanelAppIdList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSupportSlashPanel;

    public a() {
        this(null, null, null, false, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final InputStyleType getInputStyleType() {
        return this.inputStyleType;
    }

    @NotNull
    public final List<Integer> b() {
        return this.plusPanelAppIdList;
    }

    @NotNull
    public final List<Integer> c() {
        return this.shortcutIdList;
    }

    public final boolean d() {
        if (!this.shortcutIdList.contains(1005) && !this.plusPanelAppIdList.contains(Integer.valueOf(com.tencent.qqnt.pluspanel.utils.a.INSTANCE.G()))) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        if (!this.shortcutIdList.contains(1003) && !this.plusPanelAppIdList.contains(Integer.valueOf(com.tencent.qqnt.pluspanel.utils.a.INSTANCE.z()))) {
            return false;
        }
        return true;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.inputStyleType == aVar.inputStyleType && Intrinsics.areEqual(this.shortcutIdList, aVar.shortcutIdList) && Intrinsics.areEqual(this.plusPanelAppIdList, aVar.plusPanelAppIdList) && this.isSupportSlashPanel == aVar.isSupportSlashPanel) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSupportSlashPanel() {
        return this.isSupportSlashPanel;
    }

    @NotNull
    public String toString() {
        String str = " inputStyleType = " + this.inputStyleType + " shortcutIdList = " + this.shortcutIdList + " plusPanelAppIdList = " + this.plusPanelAppIdList + " isSupportSlashPanel = " + this.isSupportSlashPanel;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        \u2026)\n            .toString()");
        return str;
    }

    public a(@NotNull InputStyleType inputStyleType, @NotNull List<Integer> shortcutIdList, @NotNull List<Integer> plusPanelAppIdList, boolean z16) {
        Intrinsics.checkNotNullParameter(inputStyleType, "inputStyleType");
        Intrinsics.checkNotNullParameter(shortcutIdList, "shortcutIdList");
        Intrinsics.checkNotNullParameter(plusPanelAppIdList, "plusPanelAppIdList");
        this.inputStyleType = inputStyleType;
        this.shortcutIdList = shortcutIdList;
        this.plusPanelAppIdList = plusPanelAppIdList;
        this.isSupportSlashPanel = z16;
    }

    public /* synthetic */ a(InputStyleType inputStyleType, List list, List list2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? InputStyleType.STYLE_DEFAULT : inputStyleType, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 8) != 0 ? false : z16);
    }
}
