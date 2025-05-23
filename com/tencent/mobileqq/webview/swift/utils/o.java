package com.tencent.mobileqq.webview.swift.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/utils/o;", "", "Landroid/view/View;", "view", "", "resScene", "drawableResId", "", "useDefault", "", "d", AdMetricTag.FALLBACK, "b", "tintColor", "f", "Landroid/graphics/drawable/Drawable;", "a", "", "text", "c", "e", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f314785a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314785a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final Drawable a(@Nullable View view, int resScene) {
        TextView textView;
        if (resScene >= 2 && resScene <= 5) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = null;
            }
            if (textView != null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
                return compoundDrawables[resScene - 2];
            }
        }
        return null;
    }

    private final int b(View view, int fallback) {
        Integer num;
        Object tag = view.getTag(R.id.f9219578);
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return fallback;
    }

    @JvmStatic
    public static final int c(@Nullable String text, int fallback) {
        boolean z16;
        boolean startsWith$default;
        String str;
        if (text != null) {
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(text, "#", false, 2, null);
                if (!startsWith$default) {
                    str = "#" + text;
                } else {
                    str = text;
                }
                try {
                    return Color.parseColor(str);
                } catch (Exception e16) {
                    QLog.w("TokenUtil", 1, "parseColorText exception: " + text, e16);
                    return fallback;
                }
            }
            return fallback;
        }
        return fallback;
    }

    @JvmStatic
    public static final void d(@Nullable View view, int resScene, int drawableResId, boolean useDefault) {
        TextView textView;
        char c16;
        if (view == null) {
            QLog.w("TokenUtil", 1, "setIconMayUseDefault[" + drawableResId + "] useDefault:" + useDefault + " resScene:" + resScene + " view == null return");
            return;
        }
        ImageView imageView = null;
        TextView textView2 = null;
        ImageView imageView2 = null;
        Drawable drawable = null;
        if (useDefault) {
            Drawable o16 = ie0.a.f().o(BaseApplication.getContext(), drawableResId, n.token_color_navIcon, 1001);
            if (o16 == null) {
                QLog.w("TokenUtil", 1, "setIconMayUseDefault[" + drawableResId + "] useDefault:" + useDefault + " resScene:" + resScene + " view:" + view + " drawable == null return");
            }
            if (resScene != 0) {
                if (resScene != 1) {
                    if (resScene != 2 && resScene != 3 && resScene != 4 && resScene != 5) {
                        QLog.w("TokenUtil", 1, "setIconMayUseDefault[useDefault] [" + drawableResId + "] resScene:" + resScene + " view:" + view + " error");
                        return;
                    }
                    if (view instanceof TextView) {
                        textView2 = (TextView) view;
                    }
                    TextView textView3 = textView2;
                    if (textView3 != null) {
                        Drawable[] compoundDrawables = textView3.getCompoundDrawables();
                        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
                        compoundDrawables[resScene - 2] = o16;
                        int i3 = n.token_icon_size;
                        o16.setBounds(0, 0, i3, i3);
                        textView3.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
                    }
                } else {
                    if (view instanceof ImageView) {
                        imageView2 = (ImageView) view;
                    }
                    ImageView imageView3 = imageView2;
                    if (imageView3 != null) {
                        imageView3.setImageDrawable(o16);
                    }
                }
            } else {
                view.setBackgroundDrawable(o16);
            }
            view.setTag(R.id.f9219578, Integer.valueOf(drawableResId));
            return;
        }
        if (resScene != 0) {
            if (resScene != 1) {
                if (resScene != 2 && resScene != 3 && resScene != 4 && resScene != 5) {
                    QLog.w("TokenUtil", 1, "setIconMayUseDefault[notDefault] [" + drawableResId + "] resScene:" + resScene + " view:" + view + " error");
                    return;
                }
                if (view instanceof TextView) {
                    textView = (TextView) view;
                } else {
                    textView = null;
                }
                if (textView != null) {
                    Drawable[] compoundDrawables2 = textView.getCompoundDrawables();
                    int i16 = resScene - 2;
                    Drawable c17 = com.tencent.mobileqq.webview.view.b.c(drawableResId);
                    if (c17 != null) {
                        int i17 = n.token_icon_size;
                        c16 = 0;
                        c17.setBounds(0, 0, i17, i17);
                        Unit unit = Unit.INSTANCE;
                        drawable = c17;
                    } else {
                        c16 = 0;
                    }
                    compoundDrawables2[i16] = drawable;
                    textView.setCompoundDrawables(textView.getCompoundDrawables()[c16], textView.getCompoundDrawables()[1], textView.getCompoundDrawables()[2], textView.getCompoundDrawables()[3]);
                }
            } else {
                if (view instanceof ImageView) {
                    imageView = (ImageView) view;
                }
                ImageView imageView4 = imageView;
                if (imageView4 != null) {
                    imageView4.setImageResource(drawableResId);
                }
            }
        } else {
            view.setBackgroundResource(drawableResId);
        }
        view.setTag(R.id.f9219578, Integer.valueOf(drawableResId));
    }

    @JvmStatic
    public static final void e(@NotNull View view, int drawableResId) {
        Intrinsics.checkNotNullParameter(view, "view");
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        view.setBackgroundResource(drawableResId);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @JvmStatic
    public static final void f(@Nullable View view, int resScene, int tintColor) {
        if (view == null) {
            QLog.w("TokenUtil", 1, "tintViewDrawable resScene:" + resScene + " tintColor:#" + Util.toHexString(tintColor) + " view == null return");
            return;
        }
        if (resScene != 0) {
            ImageView imageView = null;
            TextView textView = null;
            if (resScene != 1) {
                if (resScene != 2 && resScene != 3 && resScene != 4 && resScene != 5) {
                    QLog.w("TokenUtil", 1, "tintViewDrawable resScene:" + resScene + " tintColor:#" + Util.toHexString(tintColor) + " view:" + view + " error");
                    return;
                }
                if (view instanceof TextView) {
                    textView = (TextView) view;
                }
                if (textView != null) {
                    Drawable[] compoundDrawables = textView.getCompoundDrawables();
                    Intrinsics.checkNotNullExpressionValue(compoundDrawables, "compoundDrawables");
                    int i3 = resScene - 2;
                    Drawable d16 = compoundDrawables[i3];
                    if (QLog.isColorLevel()) {
                        QLog.d("TokenUtil", 2, "tintViewDrawable[COMPOUND] tintColor:" + tintColor + " drawable:" + d16);
                    }
                    if (d16 != null) {
                        Intrinsics.checkNotNullExpressionValue(d16, "d");
                        if (tintColor == 0) {
                            compoundDrawables[i3] = com.tencent.mobileqq.webview.view.b.c(f314785a.b(view, 0));
                            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
                            return;
                        } else {
                            compoundDrawables[i3] = BaseImageUtil.maskDrawableByColor(d16, tintColor);
                            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (view instanceof ImageView) {
                imageView = (ImageView) view;
            }
            if (imageView != null) {
                Drawable d17 = imageView.getDrawable();
                if (QLog.isColorLevel()) {
                    QLog.d("TokenUtil", 2, "tintViewDrawable[RES_SRC] tintColor:" + tintColor + " drawable:" + d17);
                }
                if (d17 != null) {
                    Intrinsics.checkNotNullExpressionValue(d17, "d");
                    if (tintColor == 0) {
                        ((ImageView) view).setImageResource(f314785a.b(view, 0));
                        return;
                    } else {
                        ((ImageView) view).setImageDrawable(BaseImageUtil.maskDrawableByColor(d17, tintColor));
                        return;
                    }
                }
                return;
            }
            return;
        }
        Drawable background = view.getBackground();
        if (QLog.isColorLevel()) {
            QLog.d("TokenUtil", 2, "tintViewDrawable[RES_BG] tintColor:" + tintColor + " drawable:" + background);
        }
        if (background != null) {
            if (tintColor == 0) {
                view.setBackgroundResource(f314785a.b(view, 0));
            } else {
                view.setBackgroundDrawable(BaseImageUtil.maskDrawableByColor(background, tintColor));
            }
        }
    }
}
