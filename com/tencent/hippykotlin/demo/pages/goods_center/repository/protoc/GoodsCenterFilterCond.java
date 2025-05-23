package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterFilterCond implements ISSOModel {
    public final boolean multi;
    public final String name;
    public final List<GoodsCenterFilterOption> options;
    public final int type;

    public GoodsCenterFilterCond() {
        this(0, null, null, false, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        b a16 = o.a(eVar, "name", this.name);
        Iterator<T> it = this.options.iterator();
        while (it.hasNext()) {
            a16.t(((GoodsCenterFilterOption) it.next()).encode());
        }
        eVar.v("options", a16);
        eVar.w(ProcessConstant.MULTI, this.multi);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.options.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.type * 31, 31)) * 31;
        boolean z16 = this.multi;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterFilterCond(type=");
        m3.append(this.type);
        m3.append(", name=");
        m3.append(this.name);
        m3.append(", options=");
        m3.append(this.options);
        m3.append(", multi=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.multi, ')');
    }

    public GoodsCenterFilterCond(int i3, String str, List<GoodsCenterFilterOption> list, boolean z16) {
        this.type = i3;
        this.name = str;
        this.options = list;
        this.multi = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterFilterCond)) {
            return false;
        }
        GoodsCenterFilterCond goodsCenterFilterCond = (GoodsCenterFilterCond) obj;
        return this.type == goodsCenterFilterCond.type && Intrinsics.areEqual(this.name, goodsCenterFilterCond.name) && Intrinsics.areEqual(this.options, goodsCenterFilterCond.options) && this.multi == goodsCenterFilterCond.multi;
    }

    public static GoodsCenterFilterCond copy$default(GoodsCenterFilterCond goodsCenterFilterCond, List list, int i3) {
        int i16 = (i3 & 1) != 0 ? goodsCenterFilterCond.type : 0;
        String str = (i3 & 2) != 0 ? goodsCenterFilterCond.name : null;
        if ((i3 & 4) != 0) {
            list = goodsCenterFilterCond.options;
        }
        boolean z16 = (i3 & 8) != 0 ? goodsCenterFilterCond.multi : false;
        goodsCenterFilterCond.getClass();
        return new GoodsCenterFilterCond(i16, str, list, z16);
    }

    public /* synthetic */ GoodsCenterFilterCond(int i3, String str, List list, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", new ArrayList(), false);
    }
}
