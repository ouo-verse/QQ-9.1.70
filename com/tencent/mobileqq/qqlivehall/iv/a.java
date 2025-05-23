package com.tencent.mobileqq.qqlivehall.iv;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/a;", "Lcom/tencent/mobileqq/qqlivehall/iv/common/b;", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "<init>", "(Landroid/content/res/Resources;)V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends com.tencent.mobileqq.qqlivehall.iv.common.b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Resources resources) {
        super(resources);
        Intrinsics.checkNotNullParameter(resources, "resources");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources);
        }
    }

    @Override // android.content.res.Resources
    @NotNull
    public DisplayMetrics getDisplayMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DisplayMetrics) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        DisplayMetrics customMetrics = FontSettingManager.customMetrics;
        Intrinsics.checkNotNullExpressionValue(customMetrics, "customMetrics");
        return customMetrics;
    }
}
