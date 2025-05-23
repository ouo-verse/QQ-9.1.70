package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rR,\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bc;", "", "Landroid/content/Context;", "context", "", "id", "Landroid/graphics/drawable/Drawable;", "b", "", "tokenName", "resourceId", "c", "d", "(I)Ljava/lang/Integer;", "", "Lkotlin/Pair;", "Ljava/util/Map;", "bgTokenMap", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bc {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bc f235460a = new bc();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Pair<String, Integer>> bgTokenMap;

    static {
        Map<Integer, Pair<String, Integer>> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Integer.valueOf(R.drawable.qui_common_bg_bottom_standard_bg), new Pair("bg_bottom_standard", Integer.valueOf(R.color.qui_common_bg_bottom_standard))));
        bgTokenMap = mapOf;
    }

    bc() {
    }

    @JvmStatic
    @Nullable
    public static final Drawable b(@NotNull Context context, @DrawableRes int id5) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getDrawable(id5);
        if (drawable == null) {
            Logger.a d16 = Logger.f235387a.d();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get background null: ");
            Pair pair = (Pair) bgTokenMap.get(Integer.valueOf(id5));
            if (pair != null) {
                str = (String) pair.getFirst();
            } else {
                str = null;
            }
            sb5.append(str);
            d16.w("GuildTokenBackgroundUtil", 1, sb5.toString());
            Pair<String, Integer> pair2 = bgTokenMap.get(Integer.valueOf(id5));
            if (pair2 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("token_name", pair2.getFirst()));
                ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#token_bg_error", mapOf);
                return new ColorDrawable(f235460a.c(pair2.getFirst(), pair2.getSecond().intValue()));
            }
            return drawable;
        }
        return drawable;
    }

    private final int c(String tokenName, int resourceId) {
        try {
            return Color.parseColor(QUIUtil.getCurrentTokenMap().get(tokenName));
        } catch (Throwable unused) {
            Logger.f235387a.d().w("GuildTokenBackgroundUtil", 1, "get color failed: " + tokenName);
            return MobileQQ.sMobileQQ.getResources().getColor(resourceId);
        }
    }

    @Nullable
    public final Integer d(@DrawableRes int id5) {
        Pair<String, Integer> pair = bgTokenMap.get(Integer.valueOf(id5));
        if (pair != null) {
            return Integer.valueOf(f235460a.c(pair.getFirst(), pair.getSecond().intValue()));
        }
        return null;
    }
}
