package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import g25.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Category {
    public final List<h> data;
    public final int type;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/List<Lg25/h;>;)V */
    public Category(int i3, List list) {
        this.type = i3;
        this.data = list;
    }

    public final int hashCode() {
        return this.data.hashCode() + (BoxType$EnumUnboxingSharedUtility.ordinal(this.type) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Category(type=");
        m3.append(CategoryType$EnumUnboxingLocalUtility.stringValueOf(this.type));
        m3.append(", data=");
        m3.append(this.data);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return this.type == category.type && Intrinsics.areEqual(this.data, category.data);
    }
}
