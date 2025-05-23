package com.tencent.mobileqq.gamecenter.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001\u001a(\u0010\u000b\u001a\u0004\u0018\u00010\n*\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t\u00a8\u0006\f"}, d2 = {"", "", "screenWidth", "b", "screenHeight", "a", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "Lcom/tencent/mobileqq/gamecenter/ui/aa;", "c", "qq-gamecenter-msg-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ab {
    public static final int a(float f16, int i3) {
        return (int) (((i3 * f16) * 1.0f) / 100);
    }

    public static final int b(float f16, int i3) {
        return (int) (((i3 * f16) * 1.0f) / 100);
    }

    @Nullable
    public static final aa c(@NotNull LinkedHashMap<String, Object> linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        try {
            aa aaVar = new aa();
            aaVar.r(linkedHashMap);
            Object obj = linkedHashMap.get("gc_percent_width");
            Object obj2 = "0";
            if (obj == null) {
                obj = "0";
            }
            aaVar.q(Float.parseFloat(obj.toString()));
            Object obj3 = linkedHashMap.get("gc_percent_height");
            if (obj3 == null) {
                obj3 = "0";
            }
            aaVar.p(Float.parseFloat(obj3.toString()));
            Object obj4 = linkedHashMap.get("gc_min_width");
            if (obj4 == null) {
                obj4 = "0";
            }
            aaVar.n(Integer.parseInt(obj4.toString()));
            Object obj5 = linkedHashMap.get("gc_min_height");
            if (obj5 == null) {
                obj5 = "0";
            }
            aaVar.m(Integer.parseInt(obj5.toString()));
            Object obj6 = linkedHashMap.get("gc_left");
            Object obj7 = "-1";
            if (obj6 == null) {
                obj6 = "-1";
            }
            aaVar.l(Float.parseFloat(obj6.toString()));
            Object obj8 = linkedHashMap.get("gc_right");
            if (obj8 == null) {
                obj8 = "-1";
            }
            aaVar.t(Float.parseFloat(obj8.toString()));
            Object obj9 = linkedHashMap.get("gc_top");
            if (obj9 == null) {
                obj9 = "-1";
            }
            aaVar.v(Float.parseFloat(obj9.toString()));
            Object obj10 = linkedHashMap.get("gc_bottom");
            if (obj10 != null) {
                obj7 = obj10;
            }
            aaVar.i(Float.parseFloat(obj7.toString()));
            Object obj11 = linkedHashMap.get("gc_dragable");
            if (obj11 == null) {
                obj11 = "0";
            }
            aaVar.j(Integer.parseInt(obj11.toString()));
            Object obj12 = linkedHashMap.get("gc_singleton");
            if (obj12 == null) {
                obj12 = "0";
            }
            aaVar.u(Integer.parseInt(obj12.toString()));
            Object obj13 = linkedHashMap.get("gc_keep_on_aio_destroy");
            if (obj13 != null) {
                obj2 = obj13;
            }
            aaVar.k(Integer.parseInt(obj2.toString()));
            Object obj14 = linkedHashMap.get("page_name");
            if (obj14 == null) {
                obj14 = "";
            }
            aaVar.o(obj14.toString());
            if (!aaVar.a()) {
                return null;
            }
            return aaVar;
        } catch (Exception e16) {
            QLog.e("OpenKuiklyFloatDialogInfo", 1, "[toOpenInfo] error:", e16);
            return null;
        }
    }
}
