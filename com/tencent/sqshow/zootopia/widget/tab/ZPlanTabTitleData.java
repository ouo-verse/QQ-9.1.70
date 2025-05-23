package com.tencent.sqshow.zootopia.widget.tab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "id", "title", "", "mark", "(ILjava/lang/String;Ljava/lang/String;)V", "getMark", "()Ljava/lang/String;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public class ZPlanTabTitleData extends BaseZPlanTabTitleData<Integer> {
    private final String mark;

    public /* synthetic */ ZPlanTabTitleData(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? "" : str2);
    }

    public final String getMark() {
        return this.mark;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanTabTitleData(int i3, String title, String mark) {
        super(Integer.valueOf(i3), title);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.mark = mark;
    }
}
