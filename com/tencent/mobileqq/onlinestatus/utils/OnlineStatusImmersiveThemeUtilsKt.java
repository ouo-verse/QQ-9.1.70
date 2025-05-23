package com.tencent.mobileqq.onlinestatus.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xy2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\u001a\u0017\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000e\"'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Landroid/graphics/drawable/Drawable;", "drawable", "", NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "b", "(Landroid/graphics/drawable/Drawable;III)Ljava/lang/Integer;", "", "key", "color", "", "d", "a", "(Ljava/lang/String;)Ljava/lang/Integer;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Lazy;", "c", "()Ljava/util/concurrent/ConcurrentHashMap;", "sThemeColorCache", "qqonlinestatus-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusImmersiveThemeUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f256313a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, Integer>>() { // from class: com.tencent.mobileqq.onlinestatus.utils.OnlineStatusImmersiveThemeUtilsKt$sThemeColorCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<String, Integer> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        f256313a = lazy;
    }

    @Nullable
    public static final Integer a(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return c().get(key);
    }

    @WorkerThread
    @Nullable
    public static final Integer b(@NotNull Drawable drawable, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap drawabletoBitmapV2 = BaseImageUtil.drawabletoBitmapV2(drawable, i3, i16);
        if (drawabletoBitmapV2 == null) {
            return null;
        }
        xy2.d b16 = xy2.d.b(drawabletoBitmapV2).b();
        Intrinsics.checkNotNullExpressionValue(b16, "from(bitmap).generate()");
        d.C11578d o16 = b16.o(xy2.f.f449112g);
        if (o16 == null) {
            o16 = b16.o(xy2.f.f449114i);
        }
        if (o16 == null) {
            o16 = b16.o(xy2.f.f449115j);
        }
        if (o16 != null) {
            i17 = o16.e();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("calculate color cost ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        sb5.append("ms color: ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(i17)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb5.append(format);
        QLog.d("OnlineStatusImmersiveThemeUtils", 1, sb5.toString());
        drawabletoBitmapV2.recycle();
        return Integer.valueOf(i17);
    }

    private static final ConcurrentHashMap<String, Integer> c() {
        return (ConcurrentHashMap) f256313a.getValue();
    }

    public static final void d(@NotNull String key, int i3) {
        Intrinsics.checkNotNullParameter(key, "key");
        c().put(key, Integer.valueOf(i3));
    }
}
