package com.tencent.mtt.hippy.uimanager;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.PixelUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.uimanager.d$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337680a;

        static {
            int[] iArr = new int[a.values().length];
            f337680a = iArr;
            try {
                iArr[a.DRAWABLE_TYPE_RIPPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum a {
        DRAWABLE_TYPE_RIPPLE
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @NonNull
    @RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Drawable a(@Nullable HippyMap hippyMap) {
        int i3;
        ColorDrawable colorDrawable;
        int i16 = -16776961;
        if (hippyMap != null) {
            if (hippyMap.containsKey("color") && !hippyMap.isNull("color")) {
                i16 = hippyMap.getInt("color");
            }
            i3 = hippyMap.containsKey("rippleRadius") ? (int) (PixelUtil.dp2px(hippyMap.getDouble("rippleRadius")) + 0.5d) : 0;
            if (!hippyMap.containsKey("borderless") || hippyMap.isNull("borderless") || !hippyMap.getBoolean("borderless")) {
                colorDrawable = new ColorDrawable(-1);
                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{i16}), null, colorDrawable);
                if (i3 > 0) {
                    rippleDrawable.setRadius(i3);
                }
                return rippleDrawable;
            }
        } else {
            i3 = 0;
        }
        colorDrawable = null;
        RippleDrawable rippleDrawable2 = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{i16}), null, colorDrawable);
        if (i3 > 0) {
        }
        return rippleDrawable2;
    }

    @Nullable
    public static Drawable a(a aVar, @Nullable HippyMap hippyMap) {
        if (AnonymousClass1.f337680a[aVar.ordinal()] != 1) {
            return null;
        }
        return a(hippyMap);
    }
}
