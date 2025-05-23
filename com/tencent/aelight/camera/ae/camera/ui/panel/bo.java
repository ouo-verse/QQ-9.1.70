package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002\u001aP\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0011\u001a\u00020\t*\u00020\u0010H\u0002\u001a\f\u0010\u0013\u001a\u00020\t*\u00020\u0012H\u0002\u00a8\u0006\u0014"}, d2 = {"Landroid/view/View;", "v", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "rightBeautyBtnMode", "", "e", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "map", "d", tl.h.F, "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "f", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondaryItem;", "g", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bo {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f63159a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f63160b;

        static {
            int[] iArr = new int[BeautyItem.values().length];
            try {
                iArr[BeautyItem.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BeautyItem.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BeautyItem.SKIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BeautyItem.BASICFACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BeautyItem.TOOTH_WHITEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BeautyItem.FACE_FEATURE_SOFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BeautyItem.FACE_FEATURE_REDCHEEK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BeautyItem.REMOVE_POUNCH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BeautyItem.REMOVE_WRINKLES2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BeautyItem.LUT_CLEAR_ALPHA.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BeautyItem.LUT_FOUNDATION_ALPHA.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BeautyItem.FOREHEAD.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BeautyItem.EYE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BeautyItem.MOUTH_SHAPE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BeautyItem.FACE_THIN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BeautyItem.FACE_SMALLER.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BeautyItem.NOSE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BeautyItem.CHEEKBONE_THIN.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BeautyItem.AUTOTHIN_BODY.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BeautyItem.SLIM_HEAD.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BeautyItem.SLIM_LEG.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BeautyItem.LONG_LEG.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BeautyItem.SLIM_WAIST.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BeautyItem.EYE_MAKEUP.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            f63159a = iArr;
            int[] iArr2 = new int[BeautySecondaryItem.values().length];
            try {
                iArr2[BeautySecondaryItem.SUB_THIN_FACE_NATURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_THIN_FACE_GIRL.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_THIN_FACE_BOY.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_MI_TAO.ordinal()] = 5;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_SHAN_HU.ordinal()] = 6;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_WEN_ROU.ordinal()] = 7;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_HUO_LI.ordinal()] = 8;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LIPSTICK_FU_GU.ordinal()] = 9;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_RED_CHEEK_NONE.ordinal()] = 10;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_RED_CHEEK_JIAN_YUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_RED_CHECK_CHENG_SHU.ordinal()] = 12;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_RED_CHECK_HAI_XIU.ordinal()] = 13;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_RED_CHECK_SHENG_XIA.ordinal()] = 14;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LI_TI_NONE.ordinal()] = 15;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LI_TI_GUANG_MANG.ordinal()] = 16;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LI_TI_ZI_RAN.ordinal()] = 17;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LI_TI_QING_XIN.ordinal()] = 18;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr2[BeautySecondaryItem.SUB_LI_TI_JUN_LANG.ordinal()] = 19;
            } catch (NoSuchFieldError unused44) {
            }
            f63160b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, bj bjVar, int i3) {
        if (bjVar instanceof ar) {
            ar arVar = (ar) bjVar;
            int i16 = a.f63159a[arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String().ordinal()];
            if (i16 == 1) {
                VideoReport.setElementId(view, "em_xsj_beauty_clear");
                HashMap<String, Object> e16 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
                Intrinsics.checkNotNullExpressionValue(e16, "g().generateElementParams()");
                VideoReport.setElementParams(view, d(e16, i3));
            } else if (i16 != 2) {
                VideoReport.setElementId(view, "em_xsj_beauty_item");
                HashMap<String, Object> e17 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
                e17.put("xsj_beauty_name", f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String()));
                e17.put("xsj_" + f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar)));
                Intrinsics.checkNotNullExpressionValue(e17, "this");
                d(e17, i3);
                VideoReport.setElementParams(view, e17);
            } else {
                VideoReport.setElementId(view, "em_xsj_beauty_reset");
                HashMap<String, Object> e18 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
                Intrinsics.checkNotNullExpressionValue(e18, "g().generateElementParams()");
                VideoReport.setElementParams(view, d(e18, i3));
            }
        }
        if (bjVar instanceof bu) {
            VideoReport.setElementId(view, "em_xsj_beauty_item");
            HashMap<String, Object> e19 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
            bu buVar = (bu) bjVar;
            e19.put("xsj_beauty_name", g(buVar.getBeautyConfig().getSubItem()));
            e19.put("xsj_" + g(buVar.getBeautyConfig().getSubItem()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar)));
            Intrinsics.checkNotNullExpressionValue(e19, "this");
            d(e19, i3);
            VideoReport.setElementParams(view, e19);
        }
        if (bjVar instanceof br) {
            VideoReport.setElementId(view, "em_xsj_makeup_item");
            HashMap<String, Object> e26 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
            br brVar = (br) bjVar;
            e26.put("xsj_makeup_name", brVar.getMaterial().name);
            e26.put("xsj_" + brVar.getMaterial().name + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar)));
            Intrinsics.checkNotNullExpressionValue(e26, "this");
            d(e26, i3);
            VideoReport.setElementParams(view, e26);
        }
    }

    private static final String f(BeautyItem beautyItem) {
        switch (a.f63159a[beautyItem.ordinal()]) {
            case 1:
            default:
                return "none";
            case 2:
                return "reset";
            case 3:
                return "mopi";
            case 4:
                return "shoulian";
            case 5:
                return "baiya";
            case 6:
                return "liti";
            case 7:
                return "saihong";
            case 8:
                return "kouhong";
            case 9:
                return "heiyanquan";
            case 10:
                return "falingwen";
            case 11:
                return "qingxi";
            case 12:
                return "meibai";
            case 13:
                return "etou";
            case 14:
                return "dayan";
            case 15:
                return "zuixing";
            case 16:
                return "zhailian";
            case 17:
                return "xiaolian";
            case 18:
                return "shoubi";
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return "shouquangu";
            case 25:
                return "yanzhuang";
        }
    }

    private static final String g(BeautySecondaryItem beautySecondaryItem) {
        switch (a.f63160b[beautySecondaryItem.ordinal()]) {
            case 1:
            case 17:
                return "ziran";
            case 2:
                return "qizhi";
            case 3:
                return "yingjun";
            case 4:
            case 10:
            case 15:
                return "none";
            case 5:
                return "mitao";
            case 6:
                return "shanhu";
            case 7:
                return "wenrou";
            case 8:
                return "huoli";
            case 9:
                return "fugu";
            case 11:
                return "jianyue";
            case 12:
                return "chengshu";
            case 13:
                return "haixiu";
            case 14:
                return "shengxia";
            case 16:
                return "guangmang";
            case 18:
                return "qingxin";
            case 19:
                return "junlang";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view, bj bjVar) {
        Map<String, ?> mapOf;
        Map mapOf2;
        Map<String, ?> mapOf3;
        Map mapOf4;
        Map<String, ?> mapOf5;
        Map<String, ?> mapOf6;
        Map<String, ?> mapOf7;
        Map mapOf8;
        Map<String, ?> mapOf9;
        if (bjVar instanceof ar) {
            ar arVar = (ar) bjVar;
            int i3 = a.f63159a[arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String().ordinal()];
            if (i3 == 1) {
                VideoReport.reportEvent("dt_clck", view, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
                vq.a aVar = vq.a.f443174a;
                aVar.c(view, "em_ae_beauty_item", bjVar.getId());
                mapOf6 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_beauty_name", "none"));
                aVar.a(view, mapOf6);
            } else if (i3 != 2) {
                mapOf8 = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_beauty_name", f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String())), TuplesKt.to("xsj_" + f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
                VideoReport.reportEvent("dt_clck", view, mapOf8);
                vq.a aVar2 = vq.a.f443174a;
                aVar2.c(view, "em_ae_beauty_item", bjVar.getId());
                mapOf9 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_beauty_name", f(((ar) bjVar).getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String())));
                aVar2.a(view, mapOf9);
            } else {
                VideoReport.reportEvent("dt_clck", view, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
                vq.a aVar3 = vq.a.f443174a;
                aVar3.c(view, "em_ae_beauty_item", bjVar.getId());
                mapOf7 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_beauty_name", "reset"));
                aVar3.a(view, mapOf7);
            }
        }
        if (bjVar instanceof bu) {
            bu buVar = (bu) bjVar;
            mapOf4 = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_beauty_name", g(buVar.getBeautyConfig().getSubItem())), TuplesKt.to("xsj_" + g(buVar.getBeautyConfig().getSubItem()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
            VideoReport.reportEvent("dt_clck", view, mapOf4);
            vq.a aVar4 = vq.a.f443174a;
            aVar4.c(view, "em_ae_beauty_item", bjVar.getId());
            mapOf5 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_beauty_name", g(((bu) bjVar).getBeautyConfig().getSubItem())));
            aVar4.a(view, mapOf5);
        }
        if (bjVar instanceof br) {
            br brVar = (br) bjVar;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_makeup_name", brVar.getMaterial().name), TuplesKt.to("xsj_" + brVar.getMaterial().name + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
            VideoReport.reportEvent("dt_clck", view, mapOf2);
            vq.a aVar5 = vq.a.f443174a;
            aVar5.c(view, "em_ae_cosmetic_item", bjVar.getId());
            mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_cosmetic_name", ((br) bjVar).getMaterial().name));
            aVar5.a(view, mapOf3);
        }
        if (bjVar instanceof bp) {
            vq.a aVar6 = vq.a.f443174a;
            aVar6.c(view, "em_ae_filter_item", bjVar.getId());
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ae_filter_name", ((bp) bjVar).getFilterItem().f66697d));
            aVar6.a(view, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View view, bj bjVar) {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        if (bjVar instanceof ar) {
            ar arVar = (ar) bjVar;
            mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_beauty_name", f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String())), TuplesKt.to("xsj_" + f(arVar.getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
            VideoReport.reportEvent("dt_imp", view, mapOf3);
        }
        if (bjVar instanceof bu) {
            bu buVar = (bu) bjVar;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_beauty_name", g(buVar.getBeautyConfig().getSubItem())), TuplesKt.to("xsj_" + g(buVar.getBeautyConfig().getSubItem()) + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
            VideoReport.reportEvent("dt_imp", view, mapOf2);
        }
        if (bjVar instanceof br) {
            br brVar = (br) bjVar;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_makeup_name", brVar.getMaterial().name), TuplesKt.to("xsj_" + brVar.getMaterial().name + "_value", Integer.valueOf(AEProviderViewModel.INSTANCE.b(bjVar))));
            VideoReport.reportEvent("dt_imp", view, mapOf);
        }
    }

    private static final HashMap<String, Object> d(HashMap<String, Object> hashMap, int i3) {
        String str;
        if (i3 <= 0) {
            return hashMap;
        }
        if (i3 == 1) {
            str = "upright";
        } else {
            str = "bottom";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BEAUTY_LOCATION, str);
        return hashMap;
    }
}
