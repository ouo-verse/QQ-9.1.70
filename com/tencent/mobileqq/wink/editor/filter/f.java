package com.tencent.mobileqq.wink.editor.filter;

import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010$\n\u0002\b\u0011\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"(\u0010\u000f\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"(\u0010\u0015\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\f\"(\u0010\u001d\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"(\u0010 \u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c\"(\u0010&\u001a\u00020!*\u00020\u00002\u0006\u0010\n\u001a\u00020!8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"(\u0010)\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c\"(\u0010,\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001c\"(\u0010/\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000e\"(\u00102\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000e\"(\u00106\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u00105\"(\u00109\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014\"(\u0010<\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u00105\"(\u0010?\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014\"D\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010@*\u00020\u00002\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010@8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\"(\u0010H\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014\"(\u0010K\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000e\"(\u0010N\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010\u001a\"\u0004\bM\u0010\u001c\"(\u0010O\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010\u001a\"\u0004\bP\u0010\u001c\u00a8\u0006Q"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "c", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "b", "", "j", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "intensity", "", "value", "i", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "intIntensity", "", "f", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "filterName", "g", "filterSlidingValue", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "y", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "isFilterReady", "p", "w", "isEffectExtendReady", "Lcom/tencent/mobileqq/wink/editor/filter/EffectType;", "e", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/filter/EffectType;", "setEffectType", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/filter/EffectType;)V", AIAbilityModel.AI_KEY, DomainData.DOMAIN_NAME, "v", "isDisableForImage", "o", "setDisableForVideo", "isDisableForVideo", tl.h.F, "setImageShowLevel", "imageShowLevel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setVideoShowLevel", "videoShowLevel", "getDefaultEffectAlpha", "u", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;F)V", "defaultEffectAlpha", "l", BdhLogUtil.LogTag.Tag_Conn, "lutID", "getGlowStrength", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "glowStrength", "getMotionID", "D", "motionID", "", "getAdjustParams", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/util/Map;", ReportConstant.COSTREPORT_PREFIX, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/Map;)V", "adjustParams", "k", "B", "localLutPath", "d", "t", "adjustValue", "r", "E", "isSmartFilter", "isSmartFilterInApply", UserInfo.SEX_FEMALE, "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {
    public static final void A(@NotNull MetaMaterial metaMaterial, int i3) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (r(metaMaterial)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(f(metaMaterial));
            if (!isBlank) {
                com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "intIntensity_" + f(metaMaterial), Integer.valueOf(i3));
                return;
            }
        }
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "intIntensity", Integer.valueOf(i3));
    }

    public static final void B(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "localLutPath", value);
    }

    public static final void C(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "lutID", value);
    }

    public static final void D(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "motionID", value);
    }

    public static final void E(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.g1(metaMaterial, "isSmartFilter", z16);
    }

    public static final void F(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.g1(metaMaterial, "isSmartFilterInApply", z16);
    }

    @NotNull
    public static final MetaMaterial a() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "emptyFilter";
        com.tencent.mobileqq.wink.editor.c.B1(metaMaterial, "\u65e0");
        com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "fake_empty_filter_id");
        com.tencent.mobileqq.wink.editor.c.p1(metaMaterial, "");
        return metaMaterial;
    }

    @NotNull
    public static final MetaCategory b() {
        ArrayList<MetaMaterial> arrayListOf;
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "fake_smart_filter_id";
        metaCategory.name = "\u667a\u80fd";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(c());
        metaCategory.materials = arrayListOf;
        return metaCategory;
    }

    @NotNull
    public static final MetaMaterial c() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "autofilter";
        E(metaMaterial, true);
        com.tencent.mobileqq.wink.editor.c.B1(metaMaterial, "\u667a\u80fd");
        com.tencent.mobileqq.wink.editor.c.y1(metaMaterial, 0);
        com.tencent.mobileqq.wink.editor.c.o1(metaMaterial, "fake_smart_filter_id");
        com.tencent.mobileqq.wink.editor.c.p1(metaMaterial, "\u667a\u80fd");
        v(metaMaterial, true);
        return metaMaterial;
    }

    public static final int d(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.M(metaMaterial, "adjustValue", -999);
    }

    @NotNull
    public static final EffectType e(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        try {
            String w06 = com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, AIAbilityModel.AI_KEY);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String upperCase = w06.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return EffectType.valueOf(upperCase);
        } catch (Exception unused) {
            return EffectType.CLIENT;
        }
    }

    @NotNull
    public static final String f(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "filterName");
    }

    public static final int g(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.M(metaMaterial, "filter_sliding_value", 80);
    }

    public static final int h(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "imageShowLevel");
    }

    public static final int i(@NotNull MetaMaterial metaMaterial) {
        int g16;
        boolean isBlank;
        int g17;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (r(metaMaterial)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(f(metaMaterial));
            if (!isBlank) {
                String str = "intIntensity_" + f(metaMaterial);
                if (j(metaMaterial) >= 0.0f) {
                    g17 = (int) (j(metaMaterial) * 100);
                } else {
                    g17 = g(metaMaterial);
                }
                return com.tencent.mobileqq.wink.editor.c.M(metaMaterial, str, g17);
            }
        }
        if (j(metaMaterial) >= 0.0f) {
            g16 = (int) (j(metaMaterial) * 100);
        } else {
            g16 = g(metaMaterial);
        }
        return com.tencent.mobileqq.wink.editor.c.M(metaMaterial, "intIntensity", g16);
    }

    private static final float j(MetaMaterial metaMaterial) {
        boolean isBlank;
        if (r(metaMaterial)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(f(metaMaterial));
            if (!isBlank) {
                return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "intensity_" + f(metaMaterial), -1.0f);
            }
        }
        return com.tencent.mobileqq.wink.editor.c.B(metaMaterial, "intensity", -1.0f);
    }

    @NotNull
    public static final String k(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "localLutPath");
    }

    @NotNull
    public static final String l(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.w0(metaMaterial, "lutID");
    }

    public static final int m(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "videoShowLevel");
    }

    public static final boolean n(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "disableForImage") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean o(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "disableForVideo") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean p(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isEffectExtendReady") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "exFilterReady") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean r(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "isSmartFilter") == 1) {
            return true;
        }
        return false;
    }

    public static final void s(@NotNull MetaMaterial metaMaterial, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.h1(metaMaterial, "adjustParams", map);
    }

    public static final void t(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "adjustValue", Integer.valueOf(i3));
    }

    public static final void u(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "defaultEffectAlpha", Float.valueOf(f16));
    }

    public static final void v(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
    }

    public static final void w(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "isEffectExtendReady", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void x(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        com.tencent.mobileqq.wink.editor.c.k1(metaMaterial, "filterName", value);
    }

    public static final void y(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "exFilterReady", Integer.valueOf(z16 ? 1 : 0));
    }

    public static final void z(@NotNull MetaMaterial metaMaterial, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        com.tencent.mobileqq.wink.editor.c.i1(metaMaterial, "glowStrength", Float.valueOf(f16));
    }
}
