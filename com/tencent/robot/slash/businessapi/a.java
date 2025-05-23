package com.tencent.robot.slash.businessapi;

import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.robot.slash.dialog.content.avatarbar.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/slash/businessapi/a;", "", "", "Lb74/a;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "functionItemDataList", "Lcom/tencent/robot/slash/dialog/content/avatarbar/b$c;", "avatarItemDataList", "", "c", "I", "()I", QQBrowserActivityConstants.KEY_TITLE_STYLE, "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b74.a> functionItemDataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<b.UIModelData> avatarItemDataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int titleStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends b74.a> functionItemDataList, @Nullable List<b.UIModelData> list, int i3) {
        Intrinsics.checkNotNullParameter(functionItemDataList, "functionItemDataList");
        this.functionItemDataList = functionItemDataList;
        this.avatarItemDataList = list;
        this.titleStyle = i3;
    }

    @Nullable
    public final List<b.UIModelData> a() {
        return this.avatarItemDataList;
    }

    @NotNull
    public final List<b74.a> b() {
        return this.functionItemDataList;
    }

    /* renamed from: c, reason: from getter */
    public final int getTitleStyle() {
        return this.titleStyle;
    }

    public /* synthetic */ a(List list, List list2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i16 & 4) != 0 ? 0 : i3);
    }
}
