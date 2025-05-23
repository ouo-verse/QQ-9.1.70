package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSelectionCenter implements ISSOModel {
    public final ArrayList<Icon> buttons;

    public GoodsCenterSelectionCenter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<Icon> arrayList = this.buttons;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((Icon) it.next()).encode());
            }
        }
        eVar.v("buttons", bVar);
        return eVar;
    }

    public final int hashCode() {
        ArrayList<Icon> arrayList = this.buttons;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterSelectionCenter(buttons=");
        m3.append(this.buttons);
        m3.append(')');
        return m3.toString();
    }

    public GoodsCenterSelectionCenter(ArrayList<Icon> arrayList) {
        this.buttons = arrayList;
    }

    public /* synthetic */ GoodsCenterSelectionCenter(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GoodsCenterSelectionCenter) && Intrinsics.areEqual(this.buttons, ((GoodsCenterSelectionCenter) obj).buttons);
    }
}
