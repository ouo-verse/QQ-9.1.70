package com.tencent.ecommerce.base.ui.api;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/ui/api/IECToast;", "", "makeText", "context", "Landroid/content/Context;", "msg", "", "icon", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "duration", "", "show", "", "showQToast", "mode", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECToast {
    @NotNull
    IECToast makeText(@NotNull Context context, @NotNull CharSequence msg2, @NotNull ECToastIcon icon, int duration);

    void show();

    void showQToast(@NotNull Context context, @NotNull CharSequence msg2, int mode);
}
