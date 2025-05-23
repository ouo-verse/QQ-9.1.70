package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderBy implements ISSOModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterOrderBy.class, "sortable", "getSortable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterOrderBy.class, "curOrderByType", "getCurOrderByType()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterOrderBy.class, "curIsSelected", "getCurIsSelected()Z", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty curIsSelected$delegate;
    public final ReadWriteProperty curOrderByType$delegate;
    public final int defaultOrderByType;
    public final boolean disabled;

    /* renamed from: id, reason: collision with root package name */
    public final String f114199id;
    public final String name;
    public final ReadWriteProperty sortable$delegate;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final GoodsCenterOrderBy decode(e eVar) {
            String q16 = eVar.q("id", "");
            String q17 = eVar.q("name", "");
            boolean g16 = eVar.g("sortable", false);
            GoodsCenterOrderBy goodsCenterOrderBy = new GoodsCenterOrderBy(q16, q17, eVar.g("disabled", false), eVar.k("default_order_by_type", 0));
            goodsCenterOrderBy.sortable$delegate.setValue(goodsCenterOrderBy, GoodsCenterOrderBy.$$delegatedProperties[0], Boolean.valueOf(g16));
            goodsCenterOrderBy.setCurOrderByType(0);
            return goodsCenterOrderBy;
        }
    }

    public GoodsCenterOrderBy() {
        this(null, null, false, 0, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114199id);
        eVar.v("name", this.name);
        eVar.w("sortable", getSortable());
        eVar.w("disabled", this.disabled);
        eVar.t("default_order_by_type", this.defaultOrderByType);
        return eVar;
    }

    public final boolean getCurIsSelected() {
        return ((Boolean) this.curIsSelected$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final int getCurOrderByType() {
        return ((Number) this.curOrderByType$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final boolean getSortable() {
        return ((Boolean) this.sortable$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114199id.hashCode() * 31, 31);
        boolean z16 = this.disabled;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return this.defaultOrderByType + ((m3 + i3) * 31);
    }

    public final void setCurIsSelected(boolean z16) {
        this.curIsSelected$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final void setCurOrderByType(int i3) {
        this.curOrderByType$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterOrderBy(id=");
        m3.append(this.f114199id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", disabled=");
        m3.append(this.disabled);
        m3.append(", defaultOrderByType=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.defaultOrderByType, ')');
    }

    public GoodsCenterOrderBy(String str, String str2, boolean z16, int i3) {
        this.f114199id = str;
        this.name = str2;
        this.disabled = z16;
        this.defaultOrderByType = i3;
        Boolean bool = Boolean.FALSE;
        this.sortable$delegate = c.a(bool);
        this.curOrderByType$delegate = c.a(0);
        this.curIsSelected$delegate = c.a(bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterOrderBy)) {
            return false;
        }
        GoodsCenterOrderBy goodsCenterOrderBy = (GoodsCenterOrderBy) obj;
        return Intrinsics.areEqual(this.f114199id, goodsCenterOrderBy.f114199id) && Intrinsics.areEqual(this.name, goodsCenterOrderBy.name) && this.disabled == goodsCenterOrderBy.disabled && this.defaultOrderByType == goodsCenterOrderBy.defaultOrderByType;
    }

    public /* synthetic */ GoodsCenterOrderBy(String str, String str2, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", false, 0);
    }
}
