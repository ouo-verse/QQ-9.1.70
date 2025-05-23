package com.tencent.mobileqq.vas.theme.api;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J$\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/QUITintHelper;", "", "()V", "TAG", "", "tintDrawableMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "needTint", "", WadlProxyConsts.PARAM_FILENAME, "themeId", "tint", "paint", "Landroid/graphics/Paint;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QUITintHelper {

    @NotNull
    public static final QUITintHelper INSTANCE = new QUITintHelper();

    @NotNull
    public static final String TAG = "QUITintHelper";

    @NotNull
    private static final HashMap<String, String> tintDrawableMap;

    static {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("qui_bg_nav_primary.9.png", "bg_nav_primary"), TuplesKt.to("qui_bg_nav_secondary.9.png", "bg_nav_secondary"), TuplesKt.to("qui_common_bg_nav_aio_bg.9.png", "bg_nav_aio"), TuplesKt.to("skin_header_tab_left_normal.9.png", "text_nav_secondary"), TuplesKt.to("skin_header_tab_left_select.9.png", "text_nav_secondary"), TuplesKt.to("skin_header_tab_middle_normal.9.png", "text_nav_secondary"), TuplesKt.to("skin_header_tab_middle_select.9.png", "text_nav_secondary"), TuplesKt.to("skin_header_tab_right_normal.9.png", "text_nav_secondary"), TuplesKt.to("skin_header_tab_right_select.9.png", "text_nav_secondary"));
        tintDrawableMap = hashMapOf;
    }

    QUITintHelper() {
    }

    public final boolean needTint(@Nullable String fileName, @Nullable String themeId) {
        if ((QUITokenResUtil.isNowQUIDebugTheme() || (!Intrinsics.areEqual("1000", themeId) && !QQTheme.isVasTheme(themeId))) && fileName != null) {
            return tintDrawableMap.containsKey(fileName);
        }
        return false;
    }

    public final boolean tint(@Nullable Paint paint, @Nullable String fileName, @Nullable String themeId) {
        boolean z16;
        if (paint != null) {
            if (fileName != null && fileName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && needTint(fileName, themeId)) {
                Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
                String str = tintDrawableMap.get(fileName);
                String str2 = currentTokenMap.get(str);
                try {
                    int parseColor = Color.parseColor(str2);
                    QLog.i(TAG, 1, "tint drawable, fileName:" + fileName + " tintToken:" + str + " tintColor:" + str2);
                    if (Color.alpha(parseColor) == 255) {
                        paint.setColorFilter(new LightingColorFilter(0, parseColor));
                    } else {
                        paint.setColorFilter(new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_IN));
                    }
                    return true;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "tint error, ", e16);
                }
            }
        }
        return false;
    }
}
