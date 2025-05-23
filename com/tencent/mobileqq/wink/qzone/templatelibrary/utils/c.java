package com.tencent.mobileqq.wink.qzone.templatelibrary.utils;

import android.content.Context;
import android.os.Build;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0017\u0010\u0017\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dR\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/c;", "", "Landroid/content/Context;", "context", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", h.F, "g", "d", "c", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "f", "itemCount", "k", "j", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "e", "usageCnt", "i", "(Ljava/lang/Integer;)Ljava/lang/String;", "mateCategory", "a", DomainData.DOMAIN_NAME, "pageState", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoryData", "", "o", "b", "Z", "()Z", "IS_ENABLE_BLUR", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f326233a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean IS_ENABLE_BLUR;

    static {
        c cVar = new c();
        f326233a = cVar;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        IS_ENABLE_BLUR = cVar.l(context);
    }

    c() {
    }

    private final boolean l(Context context) {
        if (!m() && com.tencent.qui.quiblurview.c.f363628c.b(context)) {
            return true;
        }
        return false;
    }

    private final boolean m() {
        Regex regex = new Regex("mt[0-9]*");
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        return regex.matches(HARDWARE);
    }

    public static /* synthetic */ void p(c cVar, String str, WinkQZoneTemplateLibViewModel.CategoriesData categoriesData, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            categoriesData = null;
        }
        cVar.o(str, categoriesData);
    }

    @NotNull
    public final MetaCategory a(@Nullable MetaCategory mateCategory) {
        boolean z16;
        if (mateCategory == null) {
            return new MetaCategory();
        }
        ArrayList<MetaMaterial> arrayList = mateCategory.materials;
        Intrinsics.checkNotNullExpressionValue(arrayList, "mateCategory.materials");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            MetaMaterial it = (MetaMaterial) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            boolean z17 = false;
            if (com.tencent.mobileqq.wink.editor.c.T(it) != MaterialType.H5 && com.tencent.mobileqq.wink.editor.c.T(it) != MaterialType.CAMERA) {
                if (com.tencent.mobileqq.wink.editor.c.m0(it).length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                arrayList2.add(obj);
            }
        }
        return new MetaCategory(mateCategory.f30532id, mateCategory.name, mateCategory.thumbUrl, mateCategory.subCategories, new ArrayList(arrayList2), mateCategory.dynamicFields);
    }

    public final boolean b() {
        return IS_ENABLE_BLUR;
    }

    public final int c() {
        return (int) (d() * 1.5f);
    }

    public final int d() {
        float screenWidth = ImmersiveUtils.getScreenWidth() * 0.448f;
        if (n()) {
            screenWidth /= 2.0f;
        }
        return (int) screenWidth;
    }

    @NotNull
    public final String e(@Nullable MetaMaterial material) {
        if (material == null) {
            w53.b.c("WinkQZoneTemplateLibUtils", "getMaterialUsageText material is null");
            return "";
        }
        return i(Integer.valueOf(material.usageCnt));
    }

    @NotNull
    public final List<MetaCategory> f() {
        if (r93.h.f430993a.g()) {
            List<MetaCategory> x16 = WinkEditorResourceManager.a1().x1();
            Intrinsics.checkNotNullExpressionValue(x16, "{\n            WinkEditor\u2026LibraryCategory\n        }");
            return x16;
        }
        List<MetaCategory> N1 = WinkEditorResourceManager.a1().N1();
        Intrinsics.checkNotNullExpressionValue(N1, "{\n            WinkEditor\u2026LibraryCategory\n        }");
        return N1;
    }

    public final int g() {
        return (int) (h() * 1.77f);
    }

    public final int h() {
        float screenWidth = ImmersiveUtils.getScreenWidth() * 0.29333332f;
        if (n()) {
            screenWidth /= 2.0f;
        }
        return (int) screenWidth;
    }

    @NotNull
    public final String i(@Nullable Integer usageCnt) {
        int i3;
        if (usageCnt != null && usageCnt.intValue() != 0) {
            i3 = usageCnt.intValue();
        } else {
            i3 = 10000;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%.1f\u4e07\u4eba\u4f7f\u7528", Arrays.copyOf(new Object[]{Float.valueOf(i3 / 10000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public final int j() {
        return (int) (ImmersiveUtils.getScreenWidth() * 0.017333332f);
    }

    public final int k(int itemCount) {
        return (int) ((((308.0f - ((itemCount * 2) * 6.5f)) / itemCount) / 375.0f) * ImmersiveUtils.getScreenWidth());
    }

    public final boolean n() {
        DeviceType a16 = PadUtil.a(BaseApplication.context);
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int screenHeight = ImmersiveUtils.getScreenHeight();
        if (a16 != DeviceType.TABLET && (a16 != DeviceType.FOLD || !TransitionHelper.isFolderScreenOpenMode(screenWidth, screenHeight))) {
            return false;
        }
        return true;
    }

    public final void o(@NotNull String pageState, @Nullable WinkQZoneTemplateLibViewModel.CategoriesData categoryData) {
        int i3;
        Map mutableMapOf;
        MetaCategory templateCategory;
        ArrayList<MetaCategory> arrayList;
        int i16;
        ArrayList<MetaMaterial> arrayList2;
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        if (categoryData != null && (templateCategory = categoryData.getTemplateCategory()) != null && (arrayList = templateCategory.subCategories) != null) {
            Iterator<T> it = arrayList.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                i17 += ((MetaCategory) it.next()).materials.size();
            }
            MetaCategory picGenPicCategory = categoryData.getPicGenPicCategory();
            if (picGenPicCategory != null && (arrayList2 = picGenPicCategory.materials) != null) {
                i16 = arrayList2.size();
            } else {
                i16 = 0;
            }
            i3 = i17 + i16;
        } else {
            i3 = 0;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("page_state", pageState), TuplesKt.to("template_count", String.valueOf(i3)));
        e.o(e.f326265a, WinkDengtaReportConstant.Action.WINK_QZONE_TEMPLATE_LIB_STATE, mutableMapOf, false, 4, null);
    }
}
