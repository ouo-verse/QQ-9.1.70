package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.CapabilityInjector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.Switch;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\n\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u001a\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u001a\"\u0010\u0010\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f\u001a\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0002H\u0007\u00a8\u0006\u0017"}, d2 = {"Landroid/content/Context;", "context", "", "tokenResId", "d", "Landroid/content/res/ColorStateList;", "e", "drawableResId", "colorResId", "Landroid/graphics/drawable/Drawable;", "f", "color", "", com.tencent.luggage.wxa.c8.c.f123400v, "a", "b", "c", "", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "colorId", "i", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSQUIUtilsKt {
    public static final int a(int i3, float f16) {
        return Color.argb((int) (f16 * 255), Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    public static final int b(int i3, float f16) {
        return Color.argb((int) (f16 * Color.alpha(i3)), Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    public static final int c(@Nullable Context context, @ColorRes int i3, float f16) {
        return b(d(context, i3), f16);
    }

    public static final int d(@Nullable Context context, @ColorRes int i3) {
        return ie0.a.f().g(context, i3, 1000);
    }

    @NotNull
    public static final ColorStateList e(@Nullable Context context, @ColorRes int i3) {
        ColorStateList h16 = ie0.a.f().h(context, i3, 1000);
        Intrinsics.checkNotNullExpressionValue(h16, "getInstances()\n         \u2026, QUITokenConstants.SKIN)");
        return h16;
    }

    @NotNull
    public static final Drawable f(@Nullable Context context, @DrawableRes int i3, @ColorRes int i16) {
        Drawable o16 = ie0.a.f().o(context, i3, i16, 1000);
        Intrinsics.checkNotNullExpressionValue(o16, "getInstances().getQuiTok\u2026, QUITokenConstants.SKIN)");
        return o16;
    }

    public static final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CapabilityInjector capabilityInjector = CapabilityInjector.f316927a;
        capabilityInjector.h(new Function1<Context, QUIButton>() { // from class: com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt$quiInject$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final QUIButton invoke(@NotNull Context context2) {
                Intrinsics.checkNotNullParameter(context2, "context");
                QUIButton qUIButton = new QUIButton(context2);
                qUIButton.setType(1);
                qUIButton.setSizeType(2);
                return qUIButton;
            }
        });
        capabilityInjector.i(new Function1<Context, Switch>() { // from class: com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt$quiInject$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Switch invoke(@NotNull Context context2) {
                Intrinsics.checkNotNullParameter(context2, "context");
                return new Switch(context2);
            }
        });
        capabilityInjector.l(new Function2<ImageView, String, Unit>() { // from class: com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt$quiInject$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String s16) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(s16, "s");
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(s16));
            }
        });
        capabilityInjector.k(new Function2<ImageView, String, Unit>() { // from class: com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt$quiInject$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String s16) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(s16, "s");
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(s16));
            }
        });
    }

    @JvmOverloads
    public static final void h(@Nullable Activity activity) {
        j(activity, 0, 2, null);
    }

    @JvmOverloads
    public static final void i(@Nullable Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        RFWThemeUtil.setStatusBarColor(activity, d(activity, i3));
    }

    public static /* synthetic */ void j(Activity activity, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = R.color.qui_common_bg_bottom_standard;
        }
        i(activity, i3);
    }
}
