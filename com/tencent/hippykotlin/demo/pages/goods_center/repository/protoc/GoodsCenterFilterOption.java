package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterFilterOption implements ISSOModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterFilterOption.class, "isSelected", "isSelected()Z", 0)};
    public static final Companion Companion = new Companion();

    /* renamed from: default, reason: not valid java name */
    public final boolean f32default;

    /* renamed from: id, reason: collision with root package name */
    public final int f114198id;
    public final ReadWriteProperty isSelected$delegate;
    public final boolean mutex;
    public final String name;
    public final String shortName;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final GoodsCenterFilterOption decode(e eVar) {
            int k3 = eVar.k("id", 0);
            String q16 = eVar.q("name", "");
            String q17 = eVar.q("short_name", "");
            boolean g16 = eVar.g("mutex", false);
            boolean g17 = eVar.g("default", false);
            GoodsCenterFilterOption goodsCenterFilterOption = new GoodsCenterFilterOption(k3, q16, q17, g16, g17);
            goodsCenterFilterOption.setSelected(g17);
            return goodsCenterFilterOption;
        }
    }

    public GoodsCenterFilterOption() {
        this(0, null, null, false, false, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("id", this.f114198id);
        eVar.v("name", this.name);
        eVar.v("short_name", this.shortName);
        eVar.w("mutex", this.mutex);
        eVar.w("default", this.f32default);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.shortName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.f114198id * 31, 31), 31);
        boolean z16 = this.mutex;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        boolean z17 = this.f32default;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterFilterOption(id=");
        m3.append(this.f114198id);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", shortName=");
        m3.append(this.shortName);
        m3.append(", mutex=");
        m3.append(this.mutex);
        m3.append(", default=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.f32default, ')');
    }

    public GoodsCenterFilterOption(int i3, String str, String str2, boolean z16, boolean z17) {
        this.f114198id = i3;
        this.name = str;
        this.shortName = str2;
        this.mutex = z16;
        this.f32default = z17;
        this.isSelected$delegate = c.a(Boolean.FALSE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterFilterOption)) {
            return false;
        }
        GoodsCenterFilterOption goodsCenterFilterOption = (GoodsCenterFilterOption) obj;
        return this.f114198id == goodsCenterFilterOption.f114198id && Intrinsics.areEqual(this.name, goodsCenterFilterOption.name) && Intrinsics.areEqual(this.shortName, goodsCenterFilterOption.shortName) && this.mutex == goodsCenterFilterOption.mutex && this.f32default == goodsCenterFilterOption.f32default;
    }

    public /* synthetic */ GoodsCenterFilterOption(int i3, String str, String str2, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", false, false);
    }
}
