package com.tencent.ecommerce.biz.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.WindowManager;
import com.tencent.ads.data.AdParam;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/util/ECDeviceUtils;", "", "Landroid/content/Context;", "context", "Landroid/util/Size;", "c", "", "pxValue", "i", "dpValue", "b", "", tl.h.F, "g", "a", "Lkotlin/Lazy;", "e", "()Landroid/util/Size;", AdParam.SCREENSIZE, "", "I", "f", "()I", "screenWidth", "d", "screenHeight", "Ljava/text/DecimalFormat;", "Ljava/text/DecimalFormat;", "decimalFormat", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDeviceUtils {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy screenSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int screenWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int screenHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static DecimalFormat decimalFormat;

    /* renamed from: e, reason: collision with root package name */
    public static final ECDeviceUtils f104857e;

    static {
        ECDeviceUtils eCDeviceUtils = new ECDeviceUtils();
        f104857e = eCDeviceUtils;
        screenSize = LazyKt.lazy(new Function0<Size>() { // from class: com.tencent.ecommerce.biz.util.ECDeviceUtils$screenSize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size c16;
                c16 = ECDeviceUtils.f104857e.c(wg0.a.a());
                return c16;
            }
        });
        screenWidth = eCDeviceUtils.e().getWidth();
        screenHeight = eCDeviceUtils.e().getHeight();
    }

    ECDeviceUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size c(Context context) {
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final float b(float dpValue) {
        float f16;
        try {
            f16 = com.tencent.ecommerce.base.device.a.f100685b.e().density;
        } catch (Exception e16) {
            cg0.a.a("ECDeviceUtils", "dp2px", "Exception e:" + e16.getMessage());
            f16 = 2.0f;
        }
        float f17 = f16 != 0.0f ? f16 : 2.0f;
        try {
            if (decimalFormat == null) {
                decimalFormat = new DecimalFormat("0.00");
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                DecimalFormat decimalFormat2 = decimalFormat;
                Intrinsics.checkNotNull(decimalFormat2);
                decimalFormat2.setDecimalFormatSymbols(decimalFormatSymbols);
            }
            DecimalFormat decimalFormat3 = decimalFormat;
            Intrinsics.checkNotNull(decimalFormat3);
            return Float.valueOf(decimalFormat3.format(f17 * dpValue)).floatValue();
        } catch (Exception e17) {
            cg0.a.a("ECDeviceUtils", "dp2px", "[px2dip]: " + e17.getMessage());
            return dpValue;
        }
    }

    public final int d() {
        return screenHeight;
    }

    public final Size e() {
        return (Size) screenSize.getValue();
    }

    public final int f() {
        return screenWidth;
    }

    public final boolean g(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public final boolean h() {
        String model = DeviceInfoMonitor.getModel();
        if (model != null) {
            String lowerCase = model.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null)) {
                String str = Build.MANUFACTURER;
                if (str != null) {
                    String lowerCase2 = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null)) {
                        return false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final float i(float pxValue) {
        float f16;
        try {
            f16 = com.tencent.ecommerce.base.device.a.f100685b.e().density;
        } catch (Exception e16) {
            cg0.a.a("ECDeviceUtils", "px2dip", "Exception e:" + e16.getMessage());
            f16 = 2.0f;
        }
        float f17 = f16 != 0.0f ? f16 : 2.0f;
        try {
            if (decimalFormat == null) {
                decimalFormat = new DecimalFormat("0.00");
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                DecimalFormat decimalFormat2 = decimalFormat;
                Intrinsics.checkNotNull(decimalFormat2);
                decimalFormat2.setDecimalFormatSymbols(decimalFormatSymbols);
            }
            DecimalFormat decimalFormat3 = decimalFormat;
            Intrinsics.checkNotNull(decimalFormat3);
            return Float.valueOf(decimalFormat3.format(pxValue / f17)).floatValue();
        } catch (Exception e17) {
            cg0.a.a("ECDeviceUtils", "px2dip", "[px2dip]: " + e17.getMessage());
            return pxValue;
        }
    }
}
