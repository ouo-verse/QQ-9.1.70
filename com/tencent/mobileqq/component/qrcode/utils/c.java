package com.tencent.mobileqq.component.qrcode.utils;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildColorQRCodeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/utils/c;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "mainColor", "", "block", "f", "color", "", "c", "e", "d", "<init>", "()V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f201870a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f201870a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Bitmap bitmap, final Function1 block) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(block, "$block");
        final int obtainColor = ((IGuildColorQRCodeApi) QRoute.api(IGuildColorQRCodeApi.class)).obtainColor(bitmap);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.component.qrcode.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(Function1.this, obtainColor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 block, int i3) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke(Integer.valueOf(i3));
    }

    public final boolean c(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, color)).booleanValue();
        }
        return ((IGuildColorQRCodeApi) QRoute.api(IGuildColorQRCodeApi.class)).isLightColor(color);
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((IGuildColorQRCodeApi) QRoute.api(IGuildColorQRCodeApi.class)).isNightTheme();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IGuildColorQRCodeApi) QRoute.api(IGuildColorQRCodeApi.class)).isVasTheme();
    }

    public final void f(@NotNull final Bitmap bitmap, @NotNull final Function1<? super Integer, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.component.qrcode.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                c.g(bitmap, block);
            }
        }, 64, null, true);
    }
}
