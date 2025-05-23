package com.tencent.ecommerce.base.ui;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.api.IECToast;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J$\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/ui/i;", "", "", "msg", "Lcom/tencent/ecommerce/base/ui/api/ECToastIcon;", "icon", "", "duration", "", "d", "stringRes", "c", "mode", "b", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "a", "Lcom/tencent/ecommerce/base/ui/api/IECToast;", "()Lcom/tencent/ecommerce/base/ui/api/IECToast;", "toast", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f101155b = new i();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECToast toast = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getToast();

    i() {
    }

    public final IECToast a() {
        return toast;
    }

    public final void b(CharSequence msg2, int mode) {
        toast.showQToast(wg0.a.a(), msg2, mode);
    }

    public final void c(int stringRes, ECToastIcon icon, int duration) {
        d(wg0.a.a().getString(stringRes), icon, duration);
    }

    public final void d(CharSequence msg2, ECToastIcon icon, int duration) {
        toast.makeText(wg0.a.a(), msg2, icon, duration).show();
    }

    public static /* synthetic */ void e(i iVar, int i3, ECToastIcon eCToastIcon, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            eCToastIcon = ECToastIcon.ICON_NONE;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        iVar.c(i3, eCToastIcon, i16);
    }

    public static /* synthetic */ void f(i iVar, CharSequence charSequence, ECToastIcon eCToastIcon, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            eCToastIcon = ECToastIcon.ICON_NONE;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        iVar.d(charSequence, eCToastIcon, i3);
    }
}
