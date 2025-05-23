package com.tencent.mobileqq.multishare.util;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001d\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/multishare/util/c;", "", "Landroid/content/Context;", "context", "", "f", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/app/Dialog;", "dialog", "Landroid/view/View$OnClickListener;", "dismissListener", "", h.F, "g", "d", MiniChatConstants.MINI_APP_LANDSCAPE, "", "verticalHeight", "j", "c", "view", "i", "viewId", "o", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f251800a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f251800a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean f(Context context) {
        Resources resources;
        Configuration configuration;
        String configuration2;
        boolean contains$default;
        List split$default;
        String str;
        String str2;
        List split$default2;
        boolean contains$default2;
        boolean z16;
        boolean contains$default3;
        boolean contains$default4;
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && (configuration2 = configuration.toString()) != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) configuration2, (CharSequence) "mWindowingMode=", false, 2, (Object) null);
            if (contains$default) {
                try {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) configuration2, new String[]{" "}, false, 0, 6, (Object) null);
                    Object[] array = split$default.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        str = "";
                        if (i3 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = strArr[i3];
                        contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "mWindowingMode=", false, 2, (Object) null);
                        if (contains$default4) {
                            break;
                        }
                        i3++;
                    }
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                    Object[] array2 = split$default2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length >= 2) {
                        str = strArr2[1];
                    }
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "freeform", false, 2, (Object) null);
                    if (!contains$default2) {
                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "100", false, 2, (Object) null);
                        if (!contains$default3) {
                            z16 = false;
                            QLog.d("DialogFragmentConfigUtil", 1, "[isFreeWindow] windowModeStr: " + str2 + " | windowModeName: " + str + " | isActivityInFreeFormMode: " + z16);
                            return z16;
                        }
                    }
                    z16 = true;
                    QLog.d("DialogFragmentConfigUtil", 1, "[isFreeWindow] windowModeStr: " + str2 + " | windowModeName: " + str + " | isActivityInFreeFormMode: " + z16);
                    return z16;
                } catch (Throwable th5) {
                    QLog.e("DialogFragmentConfigUtil", 1, "[isFreeWindow] error: ", th5);
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void c(@NotNull Dialog dialog, boolean isLandscape) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, dialog, Boolean.valueOf(isLandscape));
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (Intrinsics.areEqual(Build.MANUFACTURER, "HUAWEI") && isLandscape && (window = dialog.getWindow()) != null) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(5894);
        }
    }

    public final boolean d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (DisplayUtil.getInstantScreenHeight(context) >= DisplayUtil.dip2px(context, 696.0f)) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_full_screen_share", true);
    }

    public final boolean g(@NotNull Context context) {
        Resources resources;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!e() || TransitionHelper.isFolderScreenOpenMode(context) || PadUtil.a(context) == DeviceType.TABLET || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    public final void h(@Nullable View rootView, @Nullable Dialog dialog, @NotNull View.OnClickListener dismissListener) {
        int i3;
        FrameLayout.LayoutParams layoutParams;
        View decorView;
        ViewGroup.LayoutParams layoutParams2;
        Resources resources;
        DisplayMetrics displayMetrics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rootView, dialog, dismissListener);
            return;
        }
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_share_panel_pad_and_fold_compat", true) || rootView == null || dialog == null) {
            return;
        }
        Context context = rootView.getContext();
        if (AppSetting.o(context) || PadUtil.a(context) == DeviceType.FOLD) {
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                i3 = displayMetrics.widthPixels;
            } else {
                i3 = 0;
            }
            if (i3 <= DisplayUtil.dip2px(context, 600.0f)) {
                if (f(context) && (layoutParams2 = rootView.getLayoutParams()) != null) {
                    layoutParams2.width = i3;
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = DisplayUtil.dip2px(context, 360.0f);
            }
            ViewGroup.LayoutParams layoutParams4 = rootView.getLayoutParams();
            View view = null;
            if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams4;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.gravity = 17;
            }
            Window window = dialog.getWindow();
            if (window != null && (decorView = window.getDecorView()) != null) {
                view = decorView.findViewById(R.id.content);
            }
            if (view != null) {
                view.setOnClickListener(dismissListener);
            }
        }
    }

    public final void i(@NotNull Context context, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(context, view);
        }
    }

    public final void j(@NotNull Dialog dialog, boolean isLandscape, int verticalHeight) {
        WindowManager.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, dialog, Boolean.valueOf(isLandscape), Integer.valueOf(verticalHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Window window = dialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (isLandscape) {
            if (layoutParams != null) {
                layoutParams.gravity = 8388613;
            }
            if (layoutParams != null) {
                layoutParams.width = cx.a(400.0f);
            }
            int instantScreenHeight = DisplayUtil.getInstantScreenHeight(dialog.getContext());
            int e16 = cx.e(dialog.getContext());
            if (layoutParams != null) {
                layoutParams.height = e16;
            }
            QLog.d("DialogFragmentConfigUtil", 1, "[setParams] instantScreenHeight: " + instantScreenHeight + ", screenHeight: " + e16);
        } else {
            if (layoutParams != null) {
                layoutParams.gravity = 80;
            }
            int instantScreenWidth = DisplayUtil.getInstantScreenWidth(dialog.getContext());
            int g16 = cx.g();
            if (layoutParams != null) {
                layoutParams.width = instantScreenWidth;
            }
            if (layoutParams != null) {
                layoutParams.height = verticalHeight;
            }
            QLog.d("DialogFragmentConfigUtil", 1, "[setParams] instantScreenWidth: " + instantScreenWidth + ", screenWidth: " + g16);
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        dialog.setCanceledOnTouchOutside(true);
    }

    public final void k(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f169472if), (String) null, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f169462ie), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.multishare.util.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.l(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026dialog.dismiss() }, null)");
        createCustomDialog.show();
    }

    public final void m(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f169432ib), (String) null, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f169462ie), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.multishare.util.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.n(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026dialog.dismiss() }, null)");
        createCustomDialog.show();
    }

    public final void o(@NotNull View rootView, int viewId, boolean isLandscape) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, rootView, Integer.valueOf(viewId), Boolean.valueOf(isLandscape));
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(viewId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(viewId)");
        Context context = findViewById.getContext();
        if (isLandscape) {
            i3 = com.tencent.mobileqq.R.drawable.qui_common_bg_middle_light_bg;
        } else {
            i3 = com.tencent.mobileqq.R.drawable.k1l;
        }
        findViewById.setBackground(ContextCompat.getDrawable(context, i3));
    }
}
