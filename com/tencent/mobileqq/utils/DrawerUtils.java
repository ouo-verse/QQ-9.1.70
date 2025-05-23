package com.tencent.mobileqq.utils;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.preload.DrawerPreLoadCache;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\fH\u0007J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J$\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0007J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u0018\u0010\u001a\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010!\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rJ\u001c\u0010%\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0$J\u0006\u0010'\u001a\u00020&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/utils/DrawerUtils;", "", "Landroid/graphics/drawable/LayerDrawable;", "bgDrawable", "", "i", "Landroid/graphics/drawable/StateListDrawable;", "j", "", "res", "Landroid/view/View;", "view", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "block", "f", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "bean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needMutate", "k", DomainData.DOMAIN_NAME, "showDefaultMenu", "o", "", "g", "e", "topHeight", "c", "d", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "Lkotlin/Function0;", "b", "", tl.h.F, "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class DrawerUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DrawerUtils f306948a = new DrawerUtils();

    DrawerUtils() {
    }

    @JvmStatic
    public static final void f(int res, @Nullable View view, @NotNull Function1<? super Drawable, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DrawerPreLoadCache.f259468a.k(res, view, block);
    }

    private final boolean i(LayerDrawable bgDrawable) {
        int numberOfLayers = bgDrawable.getNumberOfLayers();
        boolean z16 = true;
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            Drawable drawable = bgDrawable.getDrawable(i3);
            Intrinsics.checkNotNullExpressionValue(drawable, "bgDrawable.getDrawable(i)");
            if (!(drawable instanceof SkinnableBitmapDrawable)) {
                QLog.e("DrawerUtils", 1, "bg is not a SkinnableBitmapDrawable.");
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean j(StateListDrawable bgDrawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        boolean z16;
        ColorStateList color;
        boolean z17;
        Drawable.ConstantState constantState = bgDrawable.getConstantState();
        Drawable[] drawableArr = null;
        if (constantState instanceof DrawableContainer.DrawableContainerState) {
            drawableContainerState = (DrawableContainer.DrawableContainerState) constantState;
        } else {
            drawableContainerState = null;
        }
        if (drawableContainerState != null) {
            drawableArr = drawableContainerState.getChildren();
        }
        if (drawableArr != null) {
            if (drawableArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    QLog.i("DrawerUtils", 1, "checkItemBgDrawable drawableItems invalid.");
                    return false;
                }
                Iterator it = ArrayIteratorKt.iterator(drawableArr);
                boolean z18 = true;
                while (it.hasNext()) {
                    Drawable drawable = (Drawable) it.next();
                    if ((drawable instanceof GradientDrawable) && Build.VERSION.SDK_INT >= 24) {
                        color = ((GradientDrawable) drawable).getColor();
                        if (!(color instanceof SkinnableColorStateList)) {
                            QLog.e("DrawerUtils", 1, "item bg error! ");
                            z18 = false;
                        } else {
                            QLog.i("DrawerUtils", 1, "check item bg drawable, " + ((SkinnableColorStateList) color).skinData);
                        }
                    }
                }
                return z18;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @JvmStatic
    public static final void k(@Nullable final ImageView imageView, int res, final boolean needMutate) {
        f(res, imageView, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.utils.DrawerUtils$setDrawableForIv$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                if (needMutate) {
                    drawable = com.tencent.mobileqq.util.cn.f(drawable);
                }
                ImageView imageView2 = imageView;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(drawable);
                }
            }
        });
    }

    public static /* synthetic */ void l(ImageView imageView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        k(imageView, i3, z16);
    }

    @JvmStatic
    public static final void m(@NotNull ImageView imageView, @Nullable QQSettingMeBizBean bean) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (bean == null) {
            return;
        }
        k(imageView, bean.f184985f, true);
    }

    @JvmStatic
    public static final void n(@NotNull ImageView imageView, @Nullable QQSettingMeBizBean bean) {
        String str;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (bean == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight() && !TextUtils.isEmpty(bean.K)) {
            str = bean.K;
        } else {
            str = bean.J;
        }
        if (!TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(VasApngUtil.getApngURLDrawable(str, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null));
            return;
        }
        int i3 = bean.f184985f;
        if (i3 != 0) {
            k(imageView, i3, true);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final boolean a(@Nullable Drawable bgDrawable) {
        try {
            if (bgDrawable instanceof StateListDrawable) {
                return j((StateListDrawable) bgDrawable);
            }
            if (bgDrawable instanceof LayerDrawable) {
                return i((LayerDrawable) bgDrawable);
            }
            QLog.e("DrawerUtils", 1, "item bg is not a StateListDrawable.");
            return false;
        } catch (Throwable th5) {
            QLog.e("DrawerUtils", 1, "checkItemBgDrawable error ", th5);
            return false;
        }
    }

    public final void b(@NotNull AtomicBoolean isInit, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(isInit, "isInit");
        Intrinsics.checkNotNullParameter(block, "block");
        if (isInit.compareAndSet(false, true)) {
            block.invoke();
        }
    }

    @Nullable
    public final Drawable c(int topHeight) {
        try {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(Color.parseColor(QUIUtil.getCurrentTokenMap().get("bg_bottom_standard")))});
            layerDrawable.setLayerInset(0, 0, topHeight, 0, 0);
            return layerDrawable;
        } catch (Exception e16) {
            QLog.e("DrawerUtils", 1, "getDefaultFillLightSecondaryDrawable error:" + e16);
            return null;
        }
    }

    @Nullable
    public final Drawable d(int topHeight) {
        try {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(Color.parseColor(QUIUtil.getCurrentTokenMap().get("fill_light_primary")))});
            layerDrawable.setLayerInset(0, 0, topHeight, 0, 0);
            return layerDrawable;
        } catch (Exception e16) {
            QLog.e("DrawerUtils", 1, "getDefaultFillLightSecondaryDrawable error:" + e16);
            return null;
        }
    }

    @Nullable
    public final Drawable e() {
        try {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.parseColor(currentTokenMap.get("fill_light_secondary_pressed"))));
            stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(currentTokenMap.get("fill_light_secondary"))));
            return stateListDrawable;
        } catch (Exception e16) {
            QLog.e("DrawerUtils", 1, "getDefaultFillLightSecondaryDrawable error:" + e16);
            return null;
        }
    }

    @NotNull
    public final String g() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String uin = peekAppRuntime.getCurrentAccountUin();
        if (je0.a.a(peekAppRuntime.getApp())) {
            str = "_night";
        } else {
            str = "_day";
        }
        IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        return BaseApplication.getContext().getCacheDir().toString() + "/zplan/filament/drawer/frame/" + MD5Utils.toMD5(uin) + str + util.base64_pad_url + iZPlanDataHelper.getUserZPlanInfo(uin).appearanceKey + util.base64_pad_url + ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanGenderWithUin(uin) + "_1_qq_setting_me.png";
    }

    public final long h() {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("102182", new byte[0]), Charsets.UTF_8);
        long j3 = 5000;
        try {
            j3 = new JSONObject(str).optLong("delay_time", 5000L);
        } catch (JSONException unused) {
            QLog.e("DrawerUtils", 1, "getQQSettingMeInitDelayTime error: " + str);
        }
        QLog.i("DrawerUtils", 1, "getQQSettingMeInitDelayTime " + j3);
        return j3;
    }

    public final void o(@Nullable View view, boolean showDefaultMenu) {
        String qqStr;
        if (showDefaultMenu) {
            qqStr = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.zti);
        } else {
            qqStr = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.ztj);
        }
        if (view != null) {
            view.setContentDescription(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.zth) + qqStr);
        }
    }
}
