package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b*\u00020\u0000H\u0000\u001a(\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\" \u0010\u0016\u001a\n \t*\u0004\u0018\u00010\u00130\u0013*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "", "id", "", "f", "b", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "e", "type", "yOffset", "", "g", "Landroidx/lifecycle/LifecycleCoroutineScope;", "d", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "Lcom/tencent/mobileqq/app/QQAppInterface;", "a", "(Lcom/tencent/biz/richframework/part/Part;)Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "base_proj_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bc {
    public static final QQAppInterface a(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return TroopUtils.f();
    }

    public static final int b(Part part, int i3) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return part.getPartHost().getHostActivity().getColor(i3);
    }

    public static final Drawable c(Part part, int i3) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return part.getPartHost().getHostActivity().getDrawable(i3);
    }

    public static final LifecycleCoroutineScope d(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        LifecycleOwner lifecycleOwner = part.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        return LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
    }

    public static final Resources e(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        return part.getPartHost().getHostActivity().getResources();
    }

    public static final String f(Part part, int i3) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        String string = part.getPartHost().getHostActivity().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "partHost.hostActivity.getString(id)");
        return string;
    }

    public static final void g(Part part, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        QQToast.makeText(a(part).getApp(), i16, HardCodeUtil.qqStr(i3), 0).show(i17);
    }

    public static /* synthetic */ void h(Part part, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 2) != 0) {
            i16 = 1;
        }
        if ((i18 & 4) != 0) {
            i17 = e(part).getDimensionPixelSize(R.dimen.title_bar_height);
        }
        g(part, i3, i16, i17);
    }
}
