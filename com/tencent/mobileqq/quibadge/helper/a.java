package com.tencent.mobileqq.quibadge.helper;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import androidx.core.graphics.ColorUtils;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\u0013\u001a\u00020\tH\u0007J\b\u0010\u0014\u001a\u00020\tH\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\b\u0010\u0016\u001a\u00020\tH\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J(\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/quibadge/helper/a;", "", "Landroid/graphics/Typeface;", "o", "", "fname", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "", "resId", "f", h.F, "a", "j", "viewType", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "i", "b", "e", "d", "g", "", "l", "k", "oriText", "maxEnglishLength", "maxNoEnglishLength", "", "isAddEllipsis", "p", "Landroid/graphics/Typeface;", "sTypeface", "<init>", "()V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile Typeface sTypeface;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f276986b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276986b = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f276986b.f(context, R.color.qui_common_fill_standard_secondary);
    }

    @JvmStatic
    public static final int b() {
        return e.a(14);
    }

    @JvmStatic
    public static final int c(@NotNull Context context, int viewType) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (viewType != 1 && viewType != 3 && viewType != 5) {
            if (viewType != 6) {
                if (viewType != 8) {
                    if (viewType != 9) {
                        return j(context);
                    }
                    return a(context);
                }
            } else {
                return -1;
            }
        }
        return h(context);
    }

    @JvmStatic
    public static final int d() {
        return e.c(4.0f);
    }

    @JvmStatic
    public static final int e() {
        return e.a(10);
    }

    private final int f(Context context, int resId) {
        return context.getResources().getColor(resId, null);
    }

    @JvmStatic
    public static final int g() {
        return e.c(2.0f);
    }

    @JvmStatic
    public static final int h(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (je0.a.a(context)) {
            str = "#A7A7B2";
        } else {
            str = "#C0C0CC";
        }
        return Color.parseColor(str);
    }

    @JvmStatic
    public static final int i() {
        return e.a(12);
    }

    @JvmStatic
    public static final int j(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f276986b.f(context, R.color.qui_common_feedback_error);
    }

    @JvmStatic
    public static final int k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f276986b.f(context, R.color.qui_common_text_secondary);
    }

    @JvmStatic
    public static final float l() {
        return 14.0f;
    }

    @JvmStatic
    public static final int m(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int f16 = f276986b.f(context, R.color.qui_common_text_allwhite_primary);
        if (je0.a.a(context)) {
            return ColorUtils.setAlphaComponent(f16, (int) 229.5f);
        }
        return f16;
    }

    @JvmStatic
    public static final int n(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int f16 = f276986b.f(context, R.color.qui_common_text_nav_secondary);
        if (je0.a.a(context)) {
            return ColorUtils.setAlphaComponent(f16, (int) 229.5f);
        }
        return f16;
    }

    @JvmStatic
    @Nullable
    public static final Typeface o() {
        Typeface typeface = sTypeface;
        if (typeface == null) {
            typeface = f276986b.q(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            sTypeface = typeface;
        }
        return typeface;
    }

    @JvmStatic
    @NotNull
    public static final String p(@NotNull String oriText, int maxEnglishLength, int maxNoEnglishLength, boolean isAddEllipsis) {
        Intrinsics.checkNotNullParameter(oriText, "oriText");
        char[] charArray = oriText.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        int i3 = 0;
        for (char c16 : charArray) {
            boolean z16 = true;
            i3++;
            if (('A' > c16 || 'Z' < c16) && ('a' > c16 || 'z' < c16)) {
                z16 = false;
            }
            if (!z16) {
                maxEnglishLength = maxNoEnglishLength;
            }
            if (i3 >= maxEnglishLength) {
                break;
            }
        }
        if (oriText.length() > maxEnglishLength) {
            String substring = oriText.substring(0, maxEnglishLength);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            if (isAddEllipsis) {
                return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return substring;
        }
        return oriText;
    }

    private final Typeface q(String fname) {
        try {
            return Typeface.create(fname, 0);
        } catch (RuntimeException e16) {
            d.l("QUIBadgeHelper", d.f438811e, "[tryCreateTypeface] e=", e16);
            return null;
        }
    }
}
