package com.tencent.sqshow.zootopia.nativeui.view;

import com.tencent.sqshow.zootopia.nativeui.data.title.AvatarPanelTitleData;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.aq;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "toString", "index", "Ljava/lang/String;", "getIndex", "()Ljava/lang/String;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/AvatarPanelTitleData;", "titleData", "Ljava/util/List;", "getTitleData", "()Ljava/util/List;", "Luv4/aq;", "categoryGroup", "Luv4/aq;", "getCategoryGroup", "()Luv4/aq;", "", "defaultResId", "I", "getDefaultResId", "()I", "", "fakeData", "Z", "getFakeData", "()Z", "defaultName", "getDefaultName", "<init>", "(Ljava/lang/String;Ljava/util/List;Luv4/aq;IZLjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPanelViewData extends BaseZPlanTabTitleData<String> {
    private final aq categoryGroup;
    private final String defaultName;
    private final int defaultResId;
    private final boolean fakeData;
    private final String index;
    private final List<AvatarPanelTitleData> titleData;

    public AvatarPanelViewData() {
        this(null, null, null, 0, false, null, 63, null);
    }

    public final aq getCategoryGroup() {
        return this.categoryGroup;
    }

    public final String getDefaultName() {
        return this.defaultName;
    }

    public final int getDefaultResId() {
        return this.defaultResId;
    }

    public final boolean getFakeData() {
        return this.fakeData;
    }

    public final String getIndex() {
        return this.index;
    }

    public final List<AvatarPanelTitleData> getTitleData() {
        return this.titleData;
    }

    public String toString() {
        return "AvatarPanelViewData index:" + this.index;
    }

    public /* synthetic */ AvatarPanelViewData(String str, List list, aq aqVar, int i3, boolean z16, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? new aq() : aqVar, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelViewData(String index, List<AvatarPanelTitleData> titleData, aq categoryGroup, int i3, boolean z16, String defaultName) {
        super(index, "");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        Intrinsics.checkNotNullParameter(categoryGroup, "categoryGroup");
        Intrinsics.checkNotNullParameter(defaultName, "defaultName");
        this.index = index;
        this.titleData = titleData;
        this.categoryGroup = categoryGroup;
        this.defaultResId = i3;
        this.fakeData = z16;
        this.defaultName = defaultName;
    }
}
