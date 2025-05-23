package com.tencent.biz.richframework.layoutinflater.redirect;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.tencent.biz.richframework.util.RFWDeviceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/redirect/RecyclerViewRedirectHandler;", "Lcom/tencent/biz/richframework/layoutinflater/redirect/ICreateViewRedirectHandler;", "()V", "isTargetBrand", "", "needCreateViewInMain", "name", "", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RecyclerViewRedirectHandler implements ICreateViewRedirectHandler {
    private final boolean isTargetBrand() {
        int i3;
        RFWDeviceUtil rFWDeviceUtil = RFWDeviceUtil.INSTANCE;
        if (rFWDeviceUtil.isHonor() && (i3 = Build.VERSION.SDK_INT) >= 31 && i3 <= 33) {
            return true;
        }
        if (rFWDeviceUtil.isXiaoMi() && Build.VERSION.SDK_INT == 33) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.layoutinflater.redirect.ICreateViewRedirectHandler
    public boolean needCreateViewInMain(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attr) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, "RecyclerView", false, 2, null);
        if ((!endsWith$default && !Intrinsics.areEqual(name, "androidx.viewpager2.widget.ViewPager2")) || !isTargetBrand()) {
            return false;
        }
        return true;
    }
}
