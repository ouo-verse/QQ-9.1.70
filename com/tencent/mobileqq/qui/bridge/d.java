package com.tencent.mobileqq.qui.bridge;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/d;", "Ltd0/d;", "", "type", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d implements td0.d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.d
    @NotNull
    public Drawable a(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, type);
        }
        if (type == 2) {
            Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(BaseApplication.getContext(), 2);
            Intrinsics.checkNotNullExpressionValue(loadingDrawable, "{\n            LoadingUti\u2026ING_TYPE_GRAY);\n        }");
            return loadingDrawable;
        }
        Drawable loadingDrawable2 = LoadingUtil.getLoadingDrawable(BaseApplication.getContext(), 1);
        Intrinsics.checkNotNullExpressionValue(loadingDrawable2, "{\n            LoadingUti\u2026NG_TYPE_WHITE);\n        }");
        return loadingDrawable2;
    }
}
