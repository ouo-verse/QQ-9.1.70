package com.tencent.mobileqq.utils;

import android.view.View;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Landroid/view/View;", "view", "", "b", "", "", "a", "(F)I", "dp", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class am {
    public static final int a(float f16) {
        return com.tencent.mobileqq.util.x.c(BaseApplication.context, f16);
    }

    public static final void b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (SimpleUIUtil.isNowElderMode() || FontSettingManager.getFontLevel() > 16.0f) {
            FontSettingManager.resetViewSize2Normal(view.getContext(), view);
        }
    }
}
