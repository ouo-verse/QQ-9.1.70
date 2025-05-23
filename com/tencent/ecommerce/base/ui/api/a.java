package com.tencent.ecommerce.base.ui.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/a;", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "Landroid/content/Context;", "context", "", "msg", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "icon", "", "duration", "makeText", "", "show", "mode", "showQToast", "Landroid/widget/Toast;", "a", "Landroid/widget/Toast;", "toast", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECToast {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Toast toast;

    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    @SuppressLint({"ShowToast"})
    @NotNull
    public IECToast makeText(@NotNull Context context, @NotNull CharSequence msg2, @NotNull ECToastIcon icon, int duration) {
        this.toast = Toast.makeText(context, msg2, duration);
        return this;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    public void show() {
        Toast toast = this.toast;
        if (toast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toast");
        }
        toast.show();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECToast
    public void showQToast(@NotNull Context context, @NotNull CharSequence msg2, int mode) {
    }
}
