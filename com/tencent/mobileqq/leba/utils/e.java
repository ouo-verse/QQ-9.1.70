package com.tencent.mobileqq.leba.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.view.LebaDrawablePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ThemeImageView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int f240768a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f240769b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240768a = R.drawable.ew8;
            f240769b = R.drawable.neu;
        }
    }

    private static Drawable a(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (!(drawable instanceof URLDrawable)) {
            return null;
        }
        URLDrawable uRLDrawable = (URLDrawable) drawable;
        if (uRLDrawable.getStatus() != 1) {
            return null;
        }
        return uRLDrawable.getCurrDrawable();
    }

    public static void b(ImageView imageView, TextView textView, View view, n nVar, boolean z16) {
        boolean z17;
        int i3;
        String str;
        int i16;
        Context context = imageView.getContext();
        boolean z18 = false;
        if (!QQTheme.isNowSimpleUI() && !((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isShowQZoneFrameForTeenage()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (nVar.f240507d == 2) {
            textView.setText(R.string.f162031zb);
            if (z17) {
                i16 = R.drawable.krk;
            } else {
                i16 = R.drawable.krh;
            }
            if (((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).isPluginInfoPatchEnable()) {
                i16 = R.drawable.kri;
            }
            imageView.setImageDrawable(LebaDrawablePreloadHelper.d(i16));
        } else {
            if (z17) {
                i3 = f240769b;
            } else {
                i3 = f240768a;
            }
            Drawable d16 = LebaDrawablePreloadHelper.d(i3);
            textView.setText(nVar.f240505b.getPluginName(!z16));
            if (z17) {
                str = nVar.b();
            } else {
                str = nVar.f240505b.strResURL;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LebaPluginViewUtil", 4, "setIconAndText: " + nVar.f240505b.getPluginName(z17) + ", " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                Drawable a16 = a(imageView);
                if (a16 == null) {
                    a16 = d16;
                }
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    int dip2px = ViewUtils.dip2px(26.0f);
                    obtain.mRequestWidth = dip2px;
                    obtain.mRequestHeight = dip2px;
                    obtain.mLoadingDrawable = a16;
                    obtain.mFailedDrawable = a16;
                    URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                    drawable.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi);
                    if (drawable.getStatus() == 2) {
                        drawable.restartDownload();
                    }
                    imageView.setImageDrawable(drawable);
                } catch (Exception e16) {
                    QLog.e("LebaPluginViewUtil", 1, "setIconAndText", e16);
                }
            } else {
                int i17 = nVar.f240505b.cIconResId;
                if (i17 != 0) {
                    try {
                        Drawable d17 = LebaDrawablePreloadHelper.d(i17);
                        if (d17 != null) {
                            imageView.setImageDrawable(d17);
                        }
                    } catch (Exception e17) {
                        QLog.e("LebaPluginViewUtil", 1, "setIconAndText", e17);
                    }
                }
                z18 = true;
            }
            if (z18) {
                QLog.i("LebaPluginViewUtil", 1, "setIconAndText load defaultDrawable");
                imageView.setImageDrawable(d16);
            }
        }
        d(imageView, textView, z16);
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(view, textView.getText(), Button.class.getName());
        }
    }

    public static void c(ImageView imageView) {
        boolean z16;
        boolean isPluginInfoPatchEnable = ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, "")).isPluginInfoPatchEnable();
        boolean z17 = true;
        if (!QQTheme.isNowSimpleUI() && !((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).isShowQZoneFrameForTeenage()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (isPluginInfoPatchEnable) {
                z17 = QQTheme.isVasTheme();
            } else {
                z17 = false;
            }
        }
        if (imageView instanceof ThemeImageView) {
            ((ThemeImageView) imageView).setSupportMaskView(false);
        }
        if (isPluginInfoPatchEnable && ThemeUtil.isDefaultNightTheme()) {
            QLog.d("LebaPluginViewUtil", 4, "updateIconStyle ");
            imageView.setAlpha(0.8f);
        } else {
            imageView.setAlpha(1.0f);
        }
        if (z17) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) {
                return;
            }
            int g16 = ie0.a.f().g(imageView.getContext(), R.color.qui_common_icon_primary, 1000);
            Drawable mutate = drawable.mutate();
            if (mutate instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) mutate).mutate2();
            }
            mutate.setColorFilter(new LightingColorFilter(0, g16));
            imageView.setImageDrawable(mutate);
            return;
        }
        imageView.setColorFilter(0);
    }

    public static void d(ImageView imageView, TextView textView, boolean z16) {
        Resources resources = imageView.getContext().getResources();
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        c(imageView);
        if (isNowSimpleUI) {
            textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        } else {
            textView.setTextColor(resources.getColor(R.color.qui_common_text_primary));
        }
    }
}
