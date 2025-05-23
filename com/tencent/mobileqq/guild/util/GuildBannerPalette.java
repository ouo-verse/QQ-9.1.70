package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xy2.d;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J5\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\u0007J\f\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildBannerPalette;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "color", "", "block", "g", "Lxy2/d;", "f", "c", "Lxy2/d$d;", "swatch", "", "d", tl.h.F, "b", "I", "DEFAULT_LIGHT_BACKGROUND", "DEFAULT_DARK_BACKGROUND", "Lxy2/d$c;", "Lxy2/d$c;", CustomAnimation.KeyPath.COLOR_FILTER, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBannerPalette {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildBannerPalette f235327a = new GuildBannerPalette();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int DEFAULT_LIGHT_BACKGROUND = Color.parseColor("#FFF0F3F7");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int DEFAULT_DARK_BACKGROUND = Color.parseColor("#FF2C2E30");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final d.c colorFilter = new d.c() { // from class: com.tencent.mobileqq.guild.util.j
        @Override // xy2.d.c
        public final boolean a(int i3, float[] fArr) {
            boolean b16;
            b16 = GuildBannerPalette.b(i3, fArr);
            return b16;
        }
    };

    GuildBannerPalette() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(int i3, float[] hsl) {
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        float f16 = hsl[1];
        float f17 = hsl[2];
        double d16 = f16;
        if (0.5d < d16 && f16 <= 1.0f && 0.02d < f17 && f17 < 1.0f) {
            return true;
        }
        if (0.0f <= f16 && d16 <= 0.5d && 0.03d < f17 && f17 < 1.0f) {
            return true;
        }
        return false;
    }

    private final int c() {
        if (GuildThemeManager.f235286a.b()) {
            return DEFAULT_DARK_BACKGROUND;
        }
        return DEFAULT_LIGHT_BACKGROUND;
    }

    private final boolean d(d.C11578d swatch) {
        return colorFilter.a(swatch.e(), swatch.c());
    }

    @JvmStatic
    public static final int e(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            Logger.f235387a.d().w("GuildBannerPalette", 1, "bitmap == null, \u53d6\u9ed8\u8ba4\u8272");
            return f235327a.c();
        }
        GuildBannerPalette guildBannerPalette = f235327a;
        xy2.d b16 = xy2.d.b(guildBannerPalette.h(bitmap)).a().b();
        Intrinsics.checkNotNullExpressionValue(b16, "from(processHardwareConf\u2026clearFilters().generate()");
        return guildBannerPalette.f(b16);
    }

    private final int f(xy2.d dVar) {
        d.C11578d[] c11578dArr = {dVar.q(), dVar.n(), dVar.l(), dVar.k(), dVar.h(), dVar.g()};
        d.C11578d c11578d = null;
        for (int i3 = 0; i3 < 6; i3++) {
            d.C11578d c11578d2 = c11578dArr[i3];
            if (c11578d2 != null && d(c11578d2) && (c11578d == null || c11578d2.d() > c11578d.d())) {
                c11578d = c11578d2;
            }
        }
        if (c11578d != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildBannerPalette", 2, "obtainColor: " + Integer.valueOf(c11578d.e()));
            }
            return c11578d.e();
        }
        for (int i16 = 0; i16 < 6; i16++) {
            d.C11578d c11578d3 = c11578dArr[i16];
            if (c11578d == null || (c11578d3 != null && c11578d3.d() > c11578d.d())) {
                c11578d = c11578d3;
            }
        }
        if (c11578d != null) {
            float f16 = c11578d.c()[2];
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildBannerPalette", 2, "obtainColor: \u6839\u636e\u5360\u6bd4\u6700\u5927\u7684\u989c\u8272\u53d6\u8272\uff0c\u989c\u8272L: " + f16 + ", \u989c\u8272rgb: " + c11578d.e());
            }
            double d16 = f16;
            if (d16 < 0.2d) {
                return DEFAULT_DARK_BACKGROUND;
            }
            if (d16 > 0.95d) {
                return DEFAULT_LIGHT_BACKGROUND;
            }
        }
        Logger.f235387a.d().w("GuildBannerPalette", 1, "obtainColor, getDefaultColor");
        return c();
    }

    @JvmStatic
    public static final void g(@Nullable Bitmap bitmap, @NotNull Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (bitmap == null) {
            Logger.f235387a.d().w("GuildBannerPalette", 1, "bitmap == null, \u53d6\u9ed8\u8ba4\u8272");
            block.invoke(Integer.valueOf(f235327a.c()));
        } else {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            Intrinsics.checkNotNull(f16);
            CorountineFunKt.e(f16, "GuildBannerPalette obtainColorAsync", null, null, null, new GuildBannerPalette$obtainColorAsync$2(bitmap, block, null), 14, null);
        }
    }

    @NotNull
    public final Bitmap h(@NotNull Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap.Config config2;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config3 = bitmap.getConfig();
            config = Bitmap.Config.HARDWARE;
            if (config3 == config) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildBannerPalette", 1, "bitmap.config == HARDWARE, copy it first!");
                }
                config2 = Bitmap.Config.RGBA_F16;
                Bitmap copy = bitmap.copy(config2, true);
                Intrinsics.checkNotNullExpressionValue(copy, "{\n            Logger.inn\u2026RGBA_F16, true)\n        }");
                return copy;
            }
            return bitmap;
        }
        return bitmap;
    }
}
