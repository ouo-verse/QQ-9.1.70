package com.tencent.mobileqq.guild.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001aB\t\b\u0002\u00a2\u0006\u0004\b_\u0010`J/\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0007J&\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0007J)\u0010\u0010\u001a\u00020\u000f*\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0014\u001a\u00020\u000f*\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0012\u0010\u001f\u001a\u00020\u001e2\b\b\u0001\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0007J\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004J \u0010,\u001a\u00020\u00042\b\b\u0001\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020#J\u0016\u0010-\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0004J&\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010.\u001a\u00020\u0004H\u0007J\u0018\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\b\b\u0001\u0010\u0006\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\u00042\u0006\u0010)\u001a\u000203J\u0014\u00107\u001a\u00020\u000f*\u0002052\b\b\u0001\u00106\u001a\u00020\u0004J0\u0010<\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012J8\u0010>\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012J \u0010?\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0012J\u0018\u0010A\u001a\u00020\u001b2\b\b\u0001\u0010@\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0012J\"\u0010C\u001a\u00020\u001b2\b\b\u0001\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004J\"\u0010D\u001a\u00020\u001b2\b\b\u0001\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004J\"\u0010G\u001a\u00020F2\b\b\u0001\u0010\u001d\u001a\u00020\u00042\b\b\u0001\u0010E\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0012J\u0016\u0010H\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\u0012H\u0007J\u000e\u0010K\u001a\u00020I2\u0006\u0010J\u001a\u00020IJ:\u0010O\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020\u00122\b\b\u0002\u0010N\u001a\u00020\u0012J\u0018\u0010R\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020PH\u0007J\u001e\u0010S\u001a\u00020I2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010J\u001a\u00020P2\u0006\u0010Q\u001a\u00020PR\u0016\u0010U\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010TR\u001b\u0010Z\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010W\u001a\u0004\bX\u0010YR0\u0010^\u001a\u001e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00040[j\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u0004`\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildUIUtils;", "", "Landroid/content/Context;", "context", "", "drawableRes", "filterColor", "Landroid/graphics/drawable/Drawable;", "w", "(Landroid/content/Context;ILjava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "y", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/widget/ImageView;", "", "d", "(Landroid/widget/ImageView;ILjava/lang/Integer;)V", "", "strokeWidth", "c", "(Landroid/widget/ImageView;IFLjava/lang/Integer;)V", "startColor", "endColor", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "orientation", "shape", "Landroid/graphics/drawable/GradientDrawable;", "j", "normalColor", "Landroid/content/res/ColorStateList;", "r", "Landroid/view/Window;", "window", "H", "", BdhLogUtil.LogTag.Tag_Conn, "drawable", "D", "imageView", "G", "color", com.tencent.luggage.wxa.c8.c.f123400v, "override", "v", UserInfo.SEX_FEMALE, "tintColorRes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "t", "", "g", "Landroid/widget/TextView;", "textColor", "b", "tokenColor", "solidAlpha", "cornerRadiusDp", "strokeWithDp", "p", "strockAlpha", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "solidColor", tl.h.F, "alphaInt", "i", "k", "pressedColor", "Landroid/graphics/drawable/StateListDrawable;", "l", "E", "", "text", ReportConstant.COSTREPORT_PREFIX, "strokeColor", "dashGap", "dashWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "colorToken", "u", "f", "J", "mLastClickTime", "Lkotlin/text/Regex;", "Lkotlin/Lazy;", "B", "()Lkotlin/text/Regex;", "NUM_REGEX", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "colorTokenMap", "<init>", "()V", "FilterLottieAnimationHelper", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildUIUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildUIUtils f235378a = new GuildUIUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mLastClickTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy NUM_REGEX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> colorTokenMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildUIUtils$FilterLottieAnimationHelper;", "Lcom/airbnb/lottie/LottieOnCompositionLoadedListener;", "", "color", "", "d", "Lcom/airbnb/lottie/LottieComposition;", "p0", "onCompositionLoaded", "Lcom/airbnb/lottie/LottieAnimationView;", "a", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "Landroid/graphics/ColorFilter;", "b", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/LightingColorFilter;", "c", "Lkotlin/Lazy;", "()Landroid/graphics/LightingColorFilter;", "defaultColorFilter", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class FilterLottieAnimationHelper implements LottieOnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LottieAnimationView lottieAnimationView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ColorFilter colorFilter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy defaultColorFilter;

        public FilterLottieAnimationHelper(@NotNull LottieAnimationView lottieAnimationView) {
            Lazy lazy;
            Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
            this.lottieAnimationView = lottieAnimationView;
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LightingColorFilter>() { // from class: com.tencent.mobileqq.guild.util.GuildUIUtils$FilterLottieAnimationHelper$defaultColorFilter$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LightingColorFilter invoke() {
                    return new LightingColorFilter(1, 0);
                }
            });
            this.defaultColorFilter = lazy;
        }

        private final LightingColorFilter b() {
            return (LightingColorFilter) this.defaultColorFilter.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ColorFilter c(FilterLottieAnimationHelper this$0, LottieFrameInfo lottieFrameInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ColorFilter colorFilter = this$0.colorFilter;
            if (colorFilter == null) {
                return this$0.b();
            }
            return colorFilter;
        }

        public final void d(int color) {
            this.colorFilter = new LightingColorFilter(0, color);
        }

        @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
        @SuppressLint({"RestrictedApi"})
        public void onCompositionLoaded(@NotNull LottieComposition p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            if (this.colorFilter == null) {
                return;
            }
            this.lottieAnimationView.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.util.be
                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                    ColorFilter c16;
                    c16 = GuildUIUtils.FilterLottieAnimationHelper.c(GuildUIUtils.FilterLottieAnimationHelper.this, lottieFrameInfo);
                    return c16;
                }
            });
        }
    }

    static {
        Lazy lazy;
        HashMap<String, Integer> hashMapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Regex>() { // from class: com.tencent.mobileqq.guild.util.GuildUIUtils$NUM_REGEX$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Regex invoke() {
                return new Regex("\\d+(\\.\\d+)?");
            }
        });
        NUM_REGEX = lazy;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("brand_standard", Integer.valueOf(R.color.qui_common_brand_standard)));
        colorTokenMap = hashMapOf;
    }

    GuildUIUtils() {
    }

    private final Regex B() {
        return (Regex) NUM_REGEX.getValue();
    }

    @JvmStatic
    public static final void H(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.setDimAmount(0.0f);
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    @JvmStatic
    public static final void c(@NotNull ImageView imageView, @DrawableRes int i3, float f16, @ColorRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(imageView.getResources(), i3, null);
        if (create == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "applyGuildVectorIcon: drawableRes " + com.tencent.mobileqq.guild.base.extension.t.e(imageView, i3) + " is null";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.UIUtils", 1, (String) it.next(), null);
            }
            d(imageView, i3, num);
            return;
        }
        create.setOverrideStrokeWidth(f16);
        imageView.setImageDrawable(create);
        if (num != null) {
            imageView.setImageTintList(imageView.getResources().getColorStateList(num.intValue()));
        }
    }

    @JvmStatic
    public static final void d(@NotNull ImageView imageView, @DrawableRes int i3, @ColorRes @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(w(context, i3, num));
    }

    public static /* synthetic */ void e(ImageView imageView, int i3, Integer num, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            num = null;
        }
        d(imageView, i3, num);
    }

    @JvmStatic
    @NotNull
    public static final GradientDrawable j(@ColorInt int startColor, @ColorInt int endColor, @NotNull GradientDrawable.Orientation orientation, int shape) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{startColor, endColor});
        gradientDrawable.setShape(shape);
        return gradientDrawable;
    }

    public static /* synthetic */ GradientDrawable n(GuildUIUtils guildUIUtils, Context context, int i3, float f16, float f17, float f18, float f19, int i16, Object obj) {
        float f26;
        float f27;
        if ((i16 & 16) != 0) {
            f26 = 0.0f;
        } else {
            f26 = f18;
        }
        if ((i16 & 32) != 0) {
            f27 = 0.0f;
        } else {
            f27 = f19;
        }
        return guildUIUtils.m(context, i3, f16, f17, f26, f27);
    }

    @JvmStatic
    @NotNull
    public static final ColorStateList r(@ColorInt int normalColor) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{kotlin.g.a(normalColor, 30), kotlin.g.a(normalColor, 50), normalColor});
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final Drawable w(@NotNull Context context, @DrawableRes int drawableRes, @ColorRes @Nullable Integer filterColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), drawableRes, null);
        if (drawable == null) {
            return null;
        }
        Drawable D = f235378a.D(drawable);
        if (filterColor != null) {
            D.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(filterColor.intValue()), PorterDuff.Mode.SRC_IN));
        }
        return D;
    }

    public static /* synthetic */ Drawable x(Context context, int i3, Integer num, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            num = null;
        }
        return w(context, i3, num);
    }

    @JvmStatic
    @Nullable
    public static final Drawable y(@NotNull Context context, @DrawableRes int drawableRes, @ColorInt int filterColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return z(resources, drawableRes, filterColor);
    }

    @JvmStatic
    @Nullable
    public static final Drawable z(@NotNull Resources resources, @DrawableRes int drawableRes, @ColorInt int filterColor) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Drawable drawable = ResourcesCompat.getDrawable(resources, drawableRes, null);
        if (drawable == null) {
            return null;
        }
        return f235378a.F(drawable, filterColor);
    }

    @Deprecated(message = "\u8fd9\u4e2a\u65b9\u6cd5\u5bf9SkinnableBitmapDrawable\u4e0d\u7ba1\u7528")
    @Nullable
    public final Drawable A(@NotNull Context context, @DrawableRes int drawableRes, @ColorRes int tintColorRes) {
        Intrinsics.checkNotNullParameter(context, "context");
        return w(context, drawableRes, Integer.valueOf(tintColorRes));
    }

    public final boolean C() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - mLastClickTime;
        if (1 <= j3 && j3 < 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (!QLog.isColorLevel()) {
                return true;
            }
            logger.d().d("Guild.UIUtils", 2, "time:" + currentTimeMillis + ", mLastClickTIme:" + mLastClickTime + ", timeDiff:" + j3);
            return true;
        }
        mLastClickTime = currentTimeMillis;
        return false;
    }

    @NotNull
    public final Drawable D(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof SkinnableBitmapDrawable) {
            Drawable mutate2 = ((SkinnableBitmapDrawable) drawable).mutate2();
            Intrinsics.checkNotNullExpressionValue(mutate2, "{\n        drawable.mutate2()\n    }");
            return mutate2;
        }
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "{\n        drawable.mutate()\n    }");
        return mutate;
    }

    @ColorInt
    public final int E(int i3, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return ColorUtils.setAlphaComponent(i3, (int) (Color.alpha(i3) * f16));
    }

    @NotNull
    public final Drawable F(@NotNull Drawable drawable, int color) {
        Drawable mutate;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.mutate();
        }
        mutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        Intrinsics.checkNotNullExpressionValue(mutate, "if (drawable is Skinnabl\u2026ff.Mode.SRC_IN)\n        }");
        return mutate;
    }

    public final void G(@NotNull ImageView imageView, int filterColor) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "imageView.drawable");
        imageView.setImageDrawable(D(drawable));
        imageView.setColorFilter(filterColor);
    }

    public final void b(@NotNull TextView textView, @ColorRes int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), i3));
    }

    @NotNull
    public final CharSequence f(@NotNull Context context, @NotNull String text, @NotNull String colorToken) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(colorToken, "colorToken");
        boolean z17 = true;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (colorToken.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                int u16 = u(context, colorToken);
                if (u16 == 0) {
                    return text;
                }
                SpannableString spannableString = new SpannableString(text);
                spannableString.setSpan(new ForegroundColorSpan(context.getColor(u16)), 0, text.length(), 33);
                return spannableString;
            }
        }
        return text;
    }

    public final int g(long color) {
        return ((int) color) | (-16777216);
    }

    @NotNull
    public final GradientDrawable h(@ColorInt int solidColor, float cornerRadiusDp) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.a(cornerRadiusDp));
        gradientDrawable.setColor(solidColor);
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable i(@ColorInt int startColor, @ColorInt int endColor, int alphaInt) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{startColor, endColor});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setAlpha(alphaInt);
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable k(@ColorInt int startColor, @ColorInt int endColor, int alphaInt) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{startColor, endColor});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setAlpha(alphaInt);
        return gradientDrawable;
    }

    @NotNull
    public final StateListDrawable l(@ColorInt int normalColor, @ColorInt int pressedColor, float cornerRadiusDp) {
        GradientDrawable h16 = h(normalColor, cornerRadiusDp);
        GradientDrawable h17 = h(pressedColor, cornerRadiusDp);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, h17);
        stateListDrawable.addState(new int[0], h16);
        return stateListDrawable;
    }

    @NotNull
    public final GradientDrawable m(@NotNull Context context, int strokeColor, float strokeWidth, float cornerRadiusDp, float dashGap, float dashWidth) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.a(cornerRadiusDp));
        gradientDrawable.setStroke(bi.a(strokeWidth), context.getColor(strokeColor), bi.a(dashGap), bi.a(dashWidth));
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable o(@NotNull Context context, @ColorRes int tokenColor, float cornerRadiusDp) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.a(cornerRadiusDp));
        gradientDrawable.setColor(context.getColorStateList(tokenColor));
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable p(@NotNull Context context, @ColorRes int tokenColor, int solidAlpha, float cornerRadiusDp, float strokeWithDp) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.a(cornerRadiusDp));
        gradientDrawable.setStroke(bi.a(strokeWithDp), context.getColor(tokenColor));
        gradientDrawable.setColor(kotlin.g.a(context.getColor(tokenColor), solidAlpha));
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable q(@NotNull Context context, @ColorRes int tokenColor, int solidAlpha, int strockAlpha, float cornerRadiusDp, float strokeWithDp) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.a(cornerRadiusDp));
        gradientDrawable.setStroke(bi.a(strokeWithDp), kotlin.g.a(context.getColor(tokenColor), strockAlpha));
        gradientDrawable.setColor(kotlin.g.a(context.getColor(tokenColor), solidAlpha));
        return gradientDrawable;
    }

    @NotNull
    public final CharSequence s(@NotNull CharSequence text) {
        Spannable spannableString;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text instanceof Spannable) {
            spannableString = (Spannable) text;
        } else {
            spannableString = new SpannableString(text);
        }
        for (MatchResult matchResult : Regex.findAll$default(B(), text, 0, 2, null)) {
            spannableString.setSpan(new StyleSpan(1), matchResult.getRange().getFirst(), matchResult.getRange().getLast() + 1, 33);
        }
        return spannableString;
    }

    public final void t(@NotNull LottieAnimationView lottieAnimationView, @ColorInt int filterColor) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Object tag = lottieAnimationView.getTag(R.id.wp7);
        if (tag instanceof FilterLottieAnimationHelper) {
            ((FilterLottieAnimationHelper) tag).d(filterColor);
            return;
        }
        FilterLottieAnimationHelper filterLottieAnimationHelper = new FilterLottieAnimationHelper(lottieAnimationView);
        filterLottieAnimationHelper.d(filterColor);
        lottieAnimationView.setTag(R.id.wp7, filterLottieAnimationHelper);
        lottieAnimationView.addLottieOnCompositionLoadedListener(filterLottieAnimationHelper);
    }

    @ColorRes
    public final int u(@NotNull Context context, @NotNull String colorToken) {
        boolean z16;
        boolean startsWith$default;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorToken, "colorToken");
        if (colorToken.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        HashMap<String, Integer> hashMap = colorTokenMap;
        Integer num = hashMap.get(colorToken);
        if (num == null) {
            try {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorToken, "button_", false, 2, null);
                if (startsWith$default) {
                    sb5 = new StringBuilder();
                    sb5.append("qui_");
                    sb5.append(colorToken);
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("qui_common_");
                    sb5.append(colorToken);
                }
                String sb6 = sb5.toString();
                int identifier = context.getResources().getIdentifier(sb6, "color", context.getPackageName());
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.UIUtils", 1, "findColorResByToken token: " + colorToken + ", name: " + sb6 + ", colorRes: " + identifier);
                }
                if (identifier > 0) {
                    hashMap.put(colorToken, Integer.valueOf(identifier));
                    return identifier;
                }
            } catch (Exception e16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("findColorResByToken error");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.UIUtils", 1, (String) it.next(), e16);
                }
            }
            return 0;
        }
        return num.intValue();
    }

    public final int v(@ColorInt int color, float alpha, boolean override) {
        int i3 = 255;
        if (!override) {
            i3 = 255 & (color >> 24);
        }
        return (color & 16777215) | (((int) (alpha * i3)) << 24);
    }
}
