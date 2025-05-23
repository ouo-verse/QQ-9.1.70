package com.tencent.mobileqq.search.searchdetail.content.template.ai;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/o;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f284142a = new o();

    o() {
    }

    public final float a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceType a16 = PadUtil.a(context);
        if (a16 == DeviceType.FOLD || a16 == DeviceType.TABLET || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106162", false)) {
            return 1.0f;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        float f16 = displayMetrics.density;
        float f17 = i3 / f16;
        QLog.d("UiAdaptUtils", 1, "getScreenWidthDp: width=" + i3 + ", density=" + f16 + ", ScreenWidthDp=" + f17);
        float f18 = f17 / ((float) QidPagView.DESIGN_PAG_WIDTH);
        double d16 = (double) f18;
        if (d16 < 0.64d || d16 > 1.28d) {
            return 1.0f;
        }
        return f18;
    }
}
