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
public final class GoodsCenterTodayTurnover implements ISSOModel {
    public final Icon detailButton;
    public final ArrayList<GoodsCenterStringKV> turnoverInfos;

    public GoodsCenterTodayTurnover() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<GoodsCenterStringKV> arrayList = this.turnoverInfos;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((GoodsCenterStringKV) it.next()).encode());
            }
        }
        eVar.v("turnover_infos", bVar);
        Icon icon = this.detailButton;
        if (icon != null) {
            eVar.v("detail_button", icon.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        ArrayList<GoodsCenterStringKV> arrayList = this.turnoverInfos;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Icon icon = this.detailButton;
        return hashCode + (icon != null ? icon.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterTodayTurnover(turnoverInfos=");
        m3.append(this.turnoverInfos);
        m3.append(", detailButton=");
        m3.append(this.detailButton);
        m3.append(')');
        return m3.toString();
    }

    public GoodsCenterTodayTurnover(ArrayList<GoodsCenterStringKV> arrayList, Icon icon) {
        this.turnoverInfos = arrayList;
        this.detailButton = icon;
    }

    public /* synthetic */ GoodsCenterTodayTurnover(ArrayList arrayList, Icon icon, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterTodayTurnover)) {
            return false;
        }
        GoodsCenterTodayTurnover goodsCenterTodayTurnover = (GoodsCenterTodayTurnover) obj;
        return Intrinsics.areEqual(this.turnoverInfos, goodsCenterTodayTurnover.turnoverInfos) && Intrinsics.areEqual(this.detailButton, goodsCenterTodayTurnover.detailButton);
    }
}
