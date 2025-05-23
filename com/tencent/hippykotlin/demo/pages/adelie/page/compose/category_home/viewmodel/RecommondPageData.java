package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class RecommondPageData {
    public final List<AbsDelegateData> data;
    public final PageDataType type;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommondPageData(PageDataType pageDataType, List<? extends AbsDelegateData> list) {
        this.type = pageDataType;
        this.data = list;
    }

    public final int hashCode() {
        return this.data.hashCode() + (this.type.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RecommondPageData(type=");
        m3.append(this.type);
        m3.append(", data=");
        m3.append(this.data);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommondPageData)) {
            return false;
        }
        RecommondPageData recommondPageData = (RecommondPageData) obj;
        return this.type == recommondPageData.type && Intrinsics.areEqual(this.data, recommondPageData.data);
    }
}
