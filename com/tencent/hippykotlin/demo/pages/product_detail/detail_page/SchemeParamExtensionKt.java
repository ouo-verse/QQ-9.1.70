package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.base.UtilsKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class SchemeParamExtensionKt {
    public static final String blindBoxID(e eVar) {
        return eVar.q("mystery_box_id", "");
    }

    public static final int blindBoxType(e eVar) {
        int k3 = eVar.k("blind_box_product_detail_bottom_bar_type", 1);
        int[] values = BoxType$EnumUnboxingSharedUtility.values(2);
        int length = values.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            int i17 = values[i16];
            if (BoxType$EnumUnboxingLocalUtility.getId(i17) == k3) {
                i3 = i17;
                break;
            }
            i16++;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public static final String schemeActiveId(e eVar) {
        return eVar.q("active_id", "");
    }

    public static final String schemeAmsClickID(e eVar) {
        return eVar.q("qz_gdt", "");
    }

    public static final int schemeBizType(e eVar) {
        int j3 = eVar.j("biz_type");
        int[] values = BoxType$EnumUnboxingSharedUtility.values(4);
        int length = values.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            int i17 = values[i16];
            if (BoxType$EnumUnboxingSharedUtility.ordinal(i17) == j3) {
                i3 = i17;
                break;
            }
            i16++;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public static final boolean schemeBuyNow(e eVar) {
        return eVar.k("buy_now", 0) == 1;
    }

    public static final boolean schemeHideIcon(e eVar) {
        return eVar.k("hide_icon", 0) == 1;
    }

    public static final boolean schemeIsDistributor(e eVar) {
        return eVar.k("is_distributor", 0) == 1;
    }

    public static final boolean schemeIsHalf(e eVar) {
        return Intrinsics.areEqual(UtilsKt.getValueFromParams(eVar, "half"), "1") || eVar.k(KuiklyLaunchParams.PARAM_MODAL_MODE, 0) != 0;
    }

    public static final float schemeMarginTop(e eVar) {
        String valueFromParams = UtilsKt.getValueFromParams(eVar, LayoutAttrDefine.MARGIN_TOP);
        if (Intrinsics.areEqual(valueFromParams, "")) {
            return 0.0f;
        }
        return Float.parseFloat(valueFromParams);
    }

    public static final String schemePlanId(e eVar) {
        return eVar.p("plan_id");
    }

    public static final long schemeRoomId(e eVar) {
        return eVar.n("live_room_id");
    }

    public static final boolean schemeShowBottom(e eVar) {
        return !Intrinsics.areEqual(UtilsKt.getValueFromParams(eVar, "show_bottom"), "0");
    }

    public static final String schemeSpuId(e eVar) {
        return eVar.p("spu_id");
    }
}
